package modulo20.daoproject.db.exceptions;

public class DbIntegrityException extends RuntimeException {
    private final static long serialVersionUID = 1L;

    public DbIntegrityException(String msg) {
        super(msg);
    }
}
