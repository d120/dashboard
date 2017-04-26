package de.d120.dashboard.rest;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.d120.dashboard.dto.DeparturesDTO;
import de.schildbach.pte.NetworkProvider;
import de.schildbach.pte.dto.Departure;
import de.schildbach.pte.dto.QueryDeparturesResult;
import de.schildbach.pte.dto.QueryDeparturesResult.Status;

/**
 * The REST controller for <code>/api/departures</code>.
 *
 * @author Fabian Damken
 */
@RestController
@RequestMapping("/api/departures")
public class DeparturesRestController {
    /**
     * The logger.
     *
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DeparturesRestController.class);

    /**
     * The {@link NetworkProvider}.
     *
     */
    @Autowired
    private NetworkProvider networkProvider;

    /**
     * Retrieves the next departures for the station with the given ID.
     *
     * @param stationId
     *            The ID of the station to retrieve the departures of.
     * @param maxDepartures
     *            The maximum departures with different time to retrieve.
     * @return The retrieved departures.
     * @throws IOException
     *             If any I/O error occurs.
     */
    @GetMapping(path = "/{stationId}",
                params = "limit")
    public ResponseEntity<DeparturesDTO> retrieveDepartures(@PathVariable final String stationId,
            @RequestParam(name = "limit",
                          required = false,
                          defaultValue = "25") final int maxDepartures)
            throws IOException {
        final QueryDeparturesResult queryResult = this.networkProvider.queryDepartures(stationId, new Date(),
                maxDepartures, false);
        if (queryResult.status == Status.INVALID_STATION) {
            return ResponseEntity.notFound().build();
        }
        if (queryResult.status == Status.SERVICE_DOWN) {
            DeparturesRestController.LOGGER.error("Network provider is down!");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        final List<Departure> departures = queryResult.findStationDepartures(stationId).departures;
        return ResponseEntity.ok(new DeparturesDTO(departures));
    }
}
