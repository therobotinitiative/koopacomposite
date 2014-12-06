package com.orbital3dstudios.composite.koopa;

import java.util.Set;

import com.orbital3dstudios.composite.koopa.component.CompositeComponent;
import com.orbital3dstudios.composite.koopa.component.LeafComponent;

/**
 * {@link Set} based interface for the component composition API. This interface
 * extends the functionality of the {@link CollectionComponent} API. This
 * interface explicitly defines that the component composition is a set by
 * nature.
 * 
 * @see CompositeComponent
 * @see LeafComponent
 * @see Set
 * 
 * @author Mikko Sirén
 * 
 * @param <T>
 *            Type of the composed components
 */
public interface SetComponent<T extends CompositeComponent> extends CollectionComponent<T>
{
	/**
	 * @return {@link Set} of components in this composition
	 */
	Set<T> getComponents();
}
