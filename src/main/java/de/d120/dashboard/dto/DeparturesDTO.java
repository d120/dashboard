package de.d120.dashboard.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonValue;

import de.schildbach.pte.dto.Departure;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * DTO for multiple {@link Departure departures}.
 *
 * @author Fabian Damken
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName("departures")
public class DeparturesDTO {
    /**
     * The {@link Departure departures}.
     *
     */
    @Getter(onMethod = @__(@JsonValue))
    private List<Departure> departures;
}
