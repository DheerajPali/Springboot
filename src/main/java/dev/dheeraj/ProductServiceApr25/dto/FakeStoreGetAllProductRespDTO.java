package dev.dheeraj.ProductServiceApr25.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FakeStoreGetAllProductRespDTO {
    private List<FakeStoreProductDTO> response;
}
