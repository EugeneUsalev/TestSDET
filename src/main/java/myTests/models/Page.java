package myTests.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "data"
})
@JsonIgnoreProperties({
        "page",
        "per_page",
        "total",
        "total_pages",
        "support"
})


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Page {

    @JsonProperty("data")
    private List<UserModel> data = null;
}
