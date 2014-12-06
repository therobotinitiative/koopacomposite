package com.orbital3dstudios.composite.koopa.implementation;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import com.orbital3dstudios.composite.koopa.MapComponent;
import com.orbital3dstudios.composite.koopa.component.CompositeComponent;

public abstract class AbstractMapComposite<K extends Class<? extends CompositeComponent>, E extends CompositeComponent> implements MapComponent<K, E>
{
	private final Map<K, E> mappi = createMap();

	/**
	 * @return Instantiated class belonging to the [@link Map} hierarchy used as
	 *         the composition back end
	 */
	protected abstract Map<K, E> createMap();

	/**
	 * @return {@link Map} that is the composition back end
	 */
	protected Map<K, E> getMap()
	{
		return mappi;
	}

	public int size()
	{
		return mappi.size();
	}

	public boolean isEmpty()
	{
		return mappi.isEmpty();
	}

	public void removeAll()
	{
		mappi.clear();
	}

	public void put(K key, E value)
	{
		mappi.put(key, value);
	}

	public E get(K key)
	{
		return mappi.get(key);
	}

	public boolean remove(K key)
	{
		return mappi.remove(key) != null ? true : false;
	}

	public boolean hasKey(K key)
	{
		return mappi.containsKey(key);
	}

	public Set<K> keys()
	{
		return mappi.keySet();
	}

	public Collection<E> values()
	{
		return mappi.values();
	}

}
