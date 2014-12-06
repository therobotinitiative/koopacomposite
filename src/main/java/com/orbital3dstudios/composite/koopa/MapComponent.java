package com.orbital3dstudios.composite.koopa;

import java.util.Collection;
import java.util.Set;

import com.orbital3dstudios.composite.koopa.component.CompositeComponent;

/**
 * Map based composition API for key-value based component composition. This
 * works like map and one key can have one value. The used key is a type of
 * {@link CompositeComponent}.
 * 
 * @author Mikko Sirén
 * 
 * @param <K>
 *            Type of the key
 * @param <E>
 *            Type of the value element
 */
public interface MapComponent<K extends Class<? extends CompositeComponent>, E extends CompositeComponent> extends BaseCompositeComponent<E>
{
	/**
	 * @param key
	 *            Key for the stored value
	 * @param value
	 *            The value to store under the key
	 */
	void put(K key, E value);

	/**
	 * @param key
	 *            Key used to retrieve the associated value
	 * @return Stored value or null if not found
	 */
	E get(K key);

	/**
	 * @param key
	 *            The key which value is removed from the composition
	 * @return true if there was a value removed
	 */
	boolean remove(K key);

	/**
	 * @param key
	 *            The key which existence is checked
	 * @return true if the composition has the key
	 */
	boolean hasKey(K key);

	/**
	 * @return All the keys in the composition as {@link Set}
	 */
	Set<K> keys();

	/**
	 * @return All the values in the composition as {@link Collection}
	 */
	Collection<E> values();
}
