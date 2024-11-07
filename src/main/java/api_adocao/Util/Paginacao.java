package api_adocao.Util;

public abstract class Paginacao {
    public static int getTotalPages(int pageSize, int totalElements){
        if(pageSize >= totalElements){
            return 1;
        }
        if((totalElements / pageSize) % 2 == 0){
            return (totalElements / pageSize);
        }
        return (totalElements / pageSize) + 1;

    }
}
