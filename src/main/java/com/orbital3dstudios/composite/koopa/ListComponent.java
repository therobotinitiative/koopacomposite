package com.orbital3dstudios.composite.koopa;

import java.util.List;

import com.orbital3dstudios.composite.koopa.component.CompositeComponent;
import com.orbital3dstudios.composite.koopa.component.LeafComponent;

/**
 * {@link List} based interface for the component composition API. This
 * interface extends the functionality of the {@link CollectionComponent} API.
 * This interface explicitly defines that the component composition is a list by
 * nature.
 * 
 * @see CompositeComponent
 * @see LeafComponent
 * @see List
 * 
 * @author Mikko Sirén
 * 
 * @param <T>
 *            Type of the composed components
 */
public interface ListComponent<E extends CompositeComponent> extends CollectionComponent<E>
{
	List<E> getComponents();
}