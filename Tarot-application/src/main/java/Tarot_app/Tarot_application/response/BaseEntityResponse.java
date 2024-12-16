package Tarot_app.Tarot_application.response;

import Tarot_app.Tarot_application.util.CommonUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseEntityResponse {
    private String id;
    private String name;
    private String code;
    private String email;
    private Long startDate;
    private Long endDate;

    public BaseEntityResponse(Long id, String name, String code, Instant startDate, Instant endDate) {
        this.id = String.valueOf(id);
        this.name = name;
        this.code = code;
        this.startDate = CommonUtil.isNotEmpty(startDate) ? startDate.toEpochMilli() : null;
        this.endDate = CommonUtil.isNotEmpty(endDate) ? endDate.toEpochMilli() : null;
    }
}
