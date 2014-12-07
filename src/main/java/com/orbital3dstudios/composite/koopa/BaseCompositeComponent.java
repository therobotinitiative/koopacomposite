package com.orbital3dstudios.composite.koopa;


/**
 * Base interface for component composition managing API.
 * 
 * @author Mikko Sirén
 * 
 */
public interface BaseCompositeComponent
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
