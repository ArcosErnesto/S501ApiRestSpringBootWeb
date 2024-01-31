package cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n01.model.exception;

public class BranchNotFoundException extends RuntimeException{
    public BranchNotFoundException(String msg){
        super(msg);
    }
}
