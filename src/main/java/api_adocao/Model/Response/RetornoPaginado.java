package api_adocao.Model.Response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RetornoPaginado extends RetornoPadrao{
    private List<RetornoSolicitacao> content;
    private int pageNumber = 0;
    private int pageSize = 10;
    private int totalPages = 0;
    private int totalElements = 0;

    public RetornoPaginado(List<RetornoSolicitacao> content, int pageNumber, int pageSize, int totalPages, int totalElements) {
        this.content = content;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }

}
