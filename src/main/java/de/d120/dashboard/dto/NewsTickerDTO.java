package de.d120.dashboard.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * DTO for a simple news ticker containing text only.
 *
 * @author Fabian Damken
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName("news")
public class NewsTickerDTO {
    /**
     * The entries of the news ticker.
     *
     */
    @Getter(onMethod = @__(@JsonValue))
    private List<String> entries;
}
