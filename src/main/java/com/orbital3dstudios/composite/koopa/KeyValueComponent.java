package com.orbital3dstudios.composite.koopa;

import java.util.Set;

import com.orbital3dstudios.composite.koopa.component.CompositeComponent;

/**
 * Key-value based composition API. The key used is a type so the value can be
 * stored against the type.
 * 
 * @author Mikko Sirén
 * 
 * @param <V>
 *            Type parameter for the value
 */
public interface KeyValueComponent<V extends CompositeComponent> extends BaseCompositeComponent
{
	/**
	 * @param key
	 *            The key which value is removed from the composition
	 * @return true if there was a value removed
	 */
	boolean remove(Class<? extends V> key);

	/**
	 * @param key
	 *            The key which existence is checked
	 * @return true if the composition has the key
	 */
	boolean hasKey(Class<? extends V> key);

	/**
	 * @return All the keys in the composition as {@link Set}
	 */
	Set<Class<? extends V>> keys();
}
