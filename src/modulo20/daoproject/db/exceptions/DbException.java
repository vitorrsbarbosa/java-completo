package modulo20.daoproject.db.exceptions;

public class DbException extends RuntimeException {

    private final static long serialVersionUID = 1L;

    public DbException(String msg) {
        super(msg);
    }

}
