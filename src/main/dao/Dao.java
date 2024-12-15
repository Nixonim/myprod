package dao;

import java.util.List;
import java.util.Optional;

public interface Dao<K, V> {

    public List<V> findAll();

    public Optional<V> findId(K id);

    public void updateId(K id);

    public void deleteId(K id);
}
