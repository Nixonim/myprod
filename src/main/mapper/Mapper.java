package mapper;

public interface Mapper<F,T>{
    public T changeType(F from);
}
