package modulo20.dbmodel.exceptions;

public class DbExceptions extends RuntimeException {

    private final static long serialVersionUID = 1L;

    public DbExceptions(String msg) {
        super(msg);
    }

}
