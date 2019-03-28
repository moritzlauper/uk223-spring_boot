package ch.noseryoung.uk223.data;

import java.util.List;

public interface DataGenerator<T> {
    DataHolder<T> generate();
}
