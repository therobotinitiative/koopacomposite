package com.orbital3dstudios.composite.koopa.implementation;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.orbital3dstudios.composite.koopa.MapComponent;
import com.orbital3dstudios.composite.koopa.component.CompositeComponent;

public abstract class AbstractMapComposite<V extends CompositeComponent> extends AbstractKeyValueComponent<V> implements MapComponent<V>
{
	@Override
	protected Map<Class<? extends V>, V> createMap()
	{
		return new HashMap<Class<? extends V>, V>();
	}

	public void put(Class<? extends V> key, V value)
	{
		getMap().put(key, value);
	}

	public V get(Class<? extends V> key)
	{
		return getMap().get(key);
	}

	public Collection<V> values()
	{
		return getMap().values();
	}

}
