package onmyownn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort;

@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class FilterAndPagingModel {
    private  Sort.Direction sortDirection = Sort.Direction.DESC;
    private String sortBy = "id";
}
