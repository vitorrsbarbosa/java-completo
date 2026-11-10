package modulo20.dbmodel.exceptions;

public class DbException extends RuntimeException {

    private final static long serialVersionUID = 1L;

    public DbException(String msg) {
        super(msg);
    }

}
