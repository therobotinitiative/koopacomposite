package com.orbital3dstudios.composite.koopa.implementation;

import com.orbital3dstudios.composite.koopa.MultiMapComponent;
import com.orbital3dstudios.composite.koopa.component.CompositeComponent;

/**
 * Instantiable class for using the {@link MultiMapComponent} as composite in
 * case the {@link AbstractMultiMapComponent} cannot be extended.
 * 
 * @author Mikko Sirén
 * 
 * @param <E>
 *            Type of the component in the composition
 */
public final class CompositionMultiMapComponent<E extends CompositeComponent> extends AbstractMultiMapComponent<E>
{
	// Nothing
}
