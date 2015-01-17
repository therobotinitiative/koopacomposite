package com.orbital3dstudios.composite.koopa.implementation;

import com.orbital3dstudios.composite.koopa.ListComponent;
import com.orbital3dstudios.composite.koopa.component.CompositeComponent;

/**
 * Instantiable class for using the {@link ListComponent} as composite in case
 * the {@link AbstractListCompnent} cannot be extended.
 * 
 * @author Mikko Sirén
 * 
 * @param <E>
 *            Type of the component in the composition
 */
public final class CompositionListComponent<E extends CompositeComponent> extends AbstractListCompnent<E>
{
	// Nothing
}
