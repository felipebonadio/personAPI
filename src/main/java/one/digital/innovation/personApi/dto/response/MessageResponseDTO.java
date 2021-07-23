package one.digital.innovation.personApi.dto.response;

import lombok.Builder;
import lombok.Data;

@Data //geter, setter, equals e hashcode
@Builder
public class MessageResponseDTO {
    private String message;
}
