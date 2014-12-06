package com.orbital3dstudios.composite.koopa.implementation;

import com.orbital3dstudios.composite.koopa.SetComponent;
import com.orbital3dstudios.composite.koopa.component.CompositeComponent;

/**
 * Instantiable class for using the {@link SetComponent} as composite in case
 * the {@link AbstractSetComposite} cannot be extended.
 * 
 * @author Mikko Sir�n
 * 
 * @param <E>
 *            Type of the component in the composition
 */
public final class CompositionSetComponent<E extends CompositeComponent> extends AbstractSetComposite<E>
{
	// Noyhing
}
