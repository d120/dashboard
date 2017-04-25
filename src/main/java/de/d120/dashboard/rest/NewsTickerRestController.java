package de.d120.dashboard.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.d120.dashboard.dto.NewsTickerDTO;
import de.d120.dashboard.service.NewsTickerService;

/**
 * The REST controller for <code>/api/news</code>.
 *
 * @author Fabian Damken
 */
@RestController
@RequestMapping("/api/news")
public class NewsTickerRestController {
    /**
     * The {@link NewsTickerService}.
     *
     */
    @Autowired
    private NewsTickerService newsTickerService;

    /**
     * Retrieves the latest news.
     *
     * @return The response entity.
     */
    @GetMapping
    public ResponseEntity<NewsTickerDTO> retrieveNews() {
        return ResponseEntity.ok(new NewsTickerDTO(this.newsTickerService.retrieveNews()));
    }
}
