package com.orbital3dstudios.composite.koopa.implementation;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.orbital3dstudios.composite.koopa.MultiMapComponent;
import com.orbital3dstudios.composite.koopa.component.CompositeComponent;

public abstract class AbstractMultiMapComposite<K extends Class<? extends CompositeComponent>, E extends CompositeComponent> implements MultiMapComponent<K, E>
{
	private final Map<K, Set<E>> mappi = createMultiMap();

	private Map<K, Set<E>> createMultiMap()
	{
		return new HashMap<K, Set<E>>();
	}

	protected Map<K, Set<E>> getMultiMap()
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

	public void put(K key, Set<E> values)
	{
		mappi.put(key, values);
	}

	public void put(K key, E value)
	{
		Set<E> valueSet = mappi.get(key);
		if (valueSet == null)
		{
			valueSet = new HashSet<E>();
			mappi.put(key, valueSet);
		}
		valueSet.add(value);
	}

	public Set<E> get(K key)
	{
		return mappi.get(key);
	}

	public E getFirstValue(K key)
	{
		if (mappi.containsKey(key))
		{
			if (!mappi.get(key).isEmpty())
			{
				return mappi.get(key).iterator().next();
			}
		}
		return null;
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

	public Collection<Set<E>> values()
	{
		return mappi.values();
	}

}
