package exercises.uebung3;

import java.util.List;

public class PersistenceStrategyMongoDB<E> implements PersistenceStrategy<E> {

    @Override
    public void save(List<E> member) {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public List<E> load() {
        throw new UnsupportedOperationException("Not implemented!");
    }
}