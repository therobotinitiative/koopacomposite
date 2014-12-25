package com.orbital3dstudios.composite.koopa;

import java.util.Collection;

import com.orbital3dstudios.composite.koopa.component.CompositeComponent;

/**
 * Map based composition API for key-value based component composition. This
 * works like map and one key can have one value. The used key is a type bounded
 * by the value type.
 * 
 * @author Mikko Sirén
 * 
 * @param <V>
 *            Type of the value element
 */
public interface MapComponent<V extends CompositeComponent> extends KeyValueComponent<V>
{
	/**
	 * @param key
	 *            Key for the stored value
	 * @param value
	 *            The value to store under the key
	 */
	void put(Class<? extends V> key, V value);

	/**
	 * @param key
	 *            Key used to retrieve the associated value
	 * @return Stored value or null if not found
	 */
	V get(Class<? extends V> key);

	/**
	 * @return All the values in the composition as {@link Collection}
	 */
	Collection<V> values();
}
