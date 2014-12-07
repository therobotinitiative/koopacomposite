package com.orbital3dstudios.composite.koopa.implementation;

import java.util.Map;
import java.util.Set;

import com.orbital3dstudios.composite.koopa.KeyValueComponent;
import com.orbital3dstudios.composite.koopa.component.CompositeComponent;

public abstract class AbstractKeyValueComponent<V extends CompositeComponent> implements KeyValueComponent<V>
{
	private final Map<Class<? extends V>, V> backEndMap = createMap();

	protected abstract Map<Class<? extends V>, V> createMap();

	protected Map<Class<? extends V>, V> getMap()
	{
		return backEndMap;
	}

	public int size()
	{
		return backEndMap.size();
	}

	public boolean isEmpty()
	{
		return backEndMap.isEmpty();
	}

	public void removeAll()
	{
		backEndMap.clear();
	}

	public boolean remove(Class<? extends V> key)
	{
		return backEndMap.remove(key) != null ? true : false;
	}

	public boolean hasKey(Class<? extends V> key)
	{
		return backEndMap.containsKey(key);
	}

	public Set<Class<? extends V>> keys()
	{
		return backEndMap.keySet();
	}

}
