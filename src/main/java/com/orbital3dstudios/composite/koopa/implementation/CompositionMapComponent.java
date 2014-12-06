package com.orbital3dstudios.composite.koopa.implementation;

import java.util.HashMap;
import java.util.Map;

import com.orbital3dstudios.composite.koopa.MapComponent;
import com.orbital3dstudios.composite.koopa.component.CompositeComponent;

/**
 * Instantiable class for using the {@link MapComponent} as composite in case
 * the {@link AbstractMapComposite} cannot be extended.
 * 
 * @author Mikko Sirén
 * 
 * @param <K>
 *            Type of the key
 * @param <E>
 *            Type of the component in the composition
 */
public final class CompositionMapComponent<K extends Class<? extends CompositeComponent>, E extends CompositeComponent> extends AbstractMapComposite<K, E>
{

	@Override
	protected Map<K, E> createMap()
	{
		return new HashMap<K, E>();
	}
}
