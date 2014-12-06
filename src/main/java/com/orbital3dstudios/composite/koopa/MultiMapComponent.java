package com.orbital3dstudios.composite.koopa;

import java.util.Collection;
import java.util.Set;

import com.orbital3dstudios.composite.koopa.component.CompositeComponent;

/**
 * Multi map based composition API for key-set based component composition. This
 * composition works as multi map and can have a set of values stored under one
 * key.
 * 
 * @author Mikko Sirén
 * 
 * @param <K>
 *            Type of the key
 * @param <E>
 *            Type of the value
 */
public interface MultiMapComponent<K extends Class<? extends CompositeComponent>, E extends CompositeComponent> extends BaseCompositeComponent<E>
{
	/**
	 * Store the set of values under the key.
	 * 
	 * @param key
	 *            Key under which the values are stored
	 * @param values
	 *            {@link Set} of values to store
	 */
	void put(K key, Set<E> values);

	/**
	 * Stores single value under the given key.
	 * 
	 * @param key
	 *            Key under which the value is stored
	 * @param value
	 *            The value to store
	 */
	void put(K key, E value);

	/**
	 * @param key
	 *            Key under which the stored data is retrieved from
	 * @return {@link Set} of components under the key
	 */
	Set<E> get(K key);

	/**
	 * Gets the first value from the set. The set is not guaranteed to be sorted
	 * so the result may vary. If storing of a single value is used for the key
	 * then that value is returned.
	 * 
	 * @param key
	 *            Key under which the stored data is retrieved from
	 * @return First value returned from a set, sorting of a set is not
	 *         guaranteed, or null if no value is stored
	 */
	E getFirstValue(K key);

	/**
	 * Removes the values stored under the given key.
	 * 
	 * @param key
	 *            Key under which the stored values are removed
	 * @return true if values were removed
	 */
	boolean remove(K key);

	/**
	 * Checks if the composition has the given key stored.
	 * 
	 * @param key
	 *            Key which existence is checked
	 * @return true if the key is in the composition
	 */
	boolean hasKey(K key);

	/**
	 * @return All keys in the composition
	 */
	Set<K> keys();

	/**
	 * @return All values in the composition
	 */
	Collection<Set<E>> values();

}
