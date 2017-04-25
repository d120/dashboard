package de.d120.dashboard.service;

import java.util.List;

/**
 * The news ticker service provides a simple text-only news ticker.
 *
 * @author Fabian Damken
 */
public interface NewsTickerService {
    /**
     * Retrieves a list of text-based oneline news.
     *
     * @return The retrieved list of news.
     */
    List<String> retrieveNews();
}
