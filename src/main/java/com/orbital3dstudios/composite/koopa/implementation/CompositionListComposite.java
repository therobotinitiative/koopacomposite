package com.orbital3dstudios.composite.koopa.implementation;

import com.orbital3dstudios.composite.koopa.ListComponent;
import com.orbital3dstudios.composite.koopa.component.CompositeComponent;

/**
 * Instantiable class for using the {@link ListComponent} as composite in case
 * the {@link AbstractListComposite} cannot be extended.
 * 
 * @author Mikko Sir�n
 * 
 * @param <E>
 *            Type of the component in the composition
 */
public final class CompositionListComposite<E extends CompositeComponent> extends AbstractListCompositeComponent<E>
{
	// Nothing
}
