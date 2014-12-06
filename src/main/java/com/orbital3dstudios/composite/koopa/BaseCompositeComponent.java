package com.orbital3dstudios.composite.koopa;

import com.orbital3dstudios.composite.koopa.component.CompositeComponent;

/**
 * Base interface for component composition managing API.
 * 
 * @author Mikko Sirén
 * 
 * @param <E>
 *            Type of the element composed in this composition
 */
public interface BaseCompositeComponent<E extends CompositeComponent>
{
	/**
	 * @return The number of composite components in this composition
	 */
	int size();

	/**
	 * @return true if there is no composed components
	 */
	boolean isEmpty();

	/**
	 * Removes all composite components stored in this composition object.
	 */
	void removeAll();
}
