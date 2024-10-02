package api_adocao.Config.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResponseError {
        private int status;
        private String message;
        private String stackTrace;
}
