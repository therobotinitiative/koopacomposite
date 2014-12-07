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
 * @param <V>
 *            Type of the value
 */
public interface MultiMapComponent<V extends CompositeComponent> extends KeyValueComponent<V>
{
	/**
	 * Store the set of values under the key.
	 * 
	 * @param key
	 *            Key under which the values are stored
	 * @param values
	 *            {@link Set} of values to store
	 */
	void put(Class<? extends V> key, Set<V> values);

	/**
	 * @param key
	 *            Key under which the stored data is retrieved from
	 * @return {@link Set} of components under the key
	 */
	Set<V> get(Class<? extends V> key);

	/**
	 * @return All values in the composition
	 */
	Collection<Set<V>> values();

}
