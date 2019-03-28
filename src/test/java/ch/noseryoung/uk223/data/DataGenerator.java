package ch.noseryoung.uk223.data;

/**
 * @author Santiago Gabriel Vollmar
 */
public interface DataGenerator<T> {
    DataHolder<T> generate();
}
