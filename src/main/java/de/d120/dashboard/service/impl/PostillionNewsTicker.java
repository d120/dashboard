package de.d120.dashboard.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonValue;

import de.d120.dashboard.service.NewsTickerService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Implementation of the {@link NewsTickerService} retrieving news of the
 * <a href="https://www.der-postillon.com">Postillon</a>.
 *
 * @author Fabian Damken
 */
@Service
public class PostillionNewsTicker implements NewsTickerService {
    /**
     * The URL of the REST endpoint of the postillion.
     *
     */
    private static final String URL_POSTILLION = "https://www.der-postillion.de/ticker/newsticker2.php";

    /**
     * The {@link RestTemplate}.
     *
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * {@inheritDoc}
     *
     * @see de.d120.dashboard.service.NewsTickerService#retrieveNews()
     */
    @Override
    public List<String> retrieveNews() {
        final PostillionTickerDTO result = this.restTemplate.getForObject(PostillionNewsTicker.URL_POSTILLION,
                PostillionTickerDTO.class);
        if (result == null || result.getEntries() == null) {
            return Collections.emptyList();
        }
        final List<String> resultList = new ArrayList<>();
        for (final PostillionTickerEntryDTO entry : result.getEntries()) {
            resultList.add(entry.getText());
        }
        return resultList;
    }

    @SuppressWarnings("javadoc")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonRootName("tickers")
    private static class PostillionTickerDTO {
        @Getter(onMethod = @__(@JsonValue))
        private List<PostillionTickerEntryDTO> entries;
    }

    @SuppressWarnings("javadoc")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class PostillionTickerEntryDTO {
        private String text;
    }
}
