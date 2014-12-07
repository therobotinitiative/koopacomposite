package com.orbital3dstudios.composite.koopa.implementation;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.orbital3dstudios.composite.koopa.MultiMapComponent;
import com.orbital3dstudios.composite.koopa.component.CompositeComponent;

public class AbstractMultiMapComposite<V extends CompositeComponent> implements MultiMapComponent<V>
{
	private final Map<Class<? extends V>, Set<V>> backEndMap = new HashMap<Class<? extends V>, Set<V>>();

	protected Map<Class<? extends V>, Set<V>> getMap()
	{
		return backEndMap;
	}

	public void put(Class<? extends V> key, Set<V> values)
	{
		getMap().put(key, values);
	}

	public void put(Class<? extends V> key, V value)
	{
		Set<V> valueSet = getMap().get(key);
		if (valueSet == null)
		{
			valueSet = new HashSet<V>();
			getMap().put(key, valueSet);
		}
		valueSet.add(value);
	}

	public Set<V> get(Class<? extends V> key)
	{
		return getMap().get(key);
	}

	public V getFirstValue(Class<? extends V> key)
	{
		if (getMap().containsKey(key) && !getMap().get(key).isEmpty())
		{
			return getMap().get(key).iterator().next();
		}
		return null;
	}

	public Collection<Set<V>> values()
	{
		return getMap().values();
	}

	public boolean remove(Class<? extends V> key)
	{
		return getMap().remove(key) != null ? true : false;
	}

	public boolean hasKey(Class<? extends V> key)
	{
		return getMap().containsKey(key);
	}

	public Set<Class<? extends V>> keys()
	{
		return getMap().keySet();
	}

	public int size()
	{
		return getMap().size();
	}

	public boolean isEmpty()
	{
		return getMap().isEmpty();
	}

	public void removeAll()
	{
		getMap().clear();
	}

}
