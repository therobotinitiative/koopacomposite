package com.orbital3dstudios.composite.koopa;

import com.orbital3dstudios.composite.koopa.component.CompositeComponent;
import com.orbital3dstudios.composite.koopa.component.LeafComponent;

/**
 * Collection based API for component composition managing API. This API allows
 * basic managing of the composition that can have a collection of components,
 * usually a set or list.
 * 
 * It intended that objects that act as components on the composite pattern
 * implement this interface or any of the sub-interfaces. It is suggested that
 * sub-interface is use because they are more strict about the content.
 * 
 * If the object is a component in the pattern then it must implement this
 * interface or any of the sub-interfaces and also the
 * {@link CompositeComponent} or {@link LeafComponent}. This allows the object
 * to have the component management capabilities and also to be one of the
 * composed components.
 * 
 * Without type parameter this interface would be bound to
 * {@link CompositeComponent} type and would not be that type safe. In case
 * there are several type hierarchies that are not related then there would the
 * risk of having wrong type of component in the composition and casting would
 * cause {@link ClassCastException}.
 * 
 * The code below shows two type interfaces of domain objects that are not
 * related and create their own type hierarchy:
 * 
 * <code>
 * public interface DomainTypeOne extends CompositeComponent ...
 * public interface DomainTypeTwo extends CompositeComponent ...
 * </code>
 * 
 * From the code example above using the interface as the bound for the type
 * parameter would guarantee better type safety for both kind of domain objects.
 * The type parameter would bound the components to either of the domain object
 * types:
 * 
 * <code>
 * public class One implements CollectionComponent<DomainTypeOne> ...
 * public class Two implements CollectionComponent<DomainTypeTwo> ...
 * </code>
 * 
 * @author Mikko Sirén
 * 
 * @param <E>
 *            Type of the component, must be {@link CompositeComponent}
 */
public interface CollectionComponent<E extends CompositeComponent> extends BaseCompositeComponent
{
	/**
	 * Add component to the component composition.
	 * 
	 * @param component
	 *            {@link E} component to add
	 * @throws NullPointerException
	 *             If the added component is null
	 */
	void add(E component);

	/**
	 * Removes the given component from composition if it exists. The removed
	 * component is returned if it was in the composition, otherwise null is
	 * returned.
	 * 
	 * @param component
	 *            {@link E} component to remove
	 * @return true if the component was removed
	 */
	boolean remove(E component);

	/**
	 * Removes the component from the given position.
	 * 
	 * @param index
	 *            Index position from where the component is removed from
	 * @throws IndexOutOfBoundsException
	 *             If the given index is out of range [0, size of the
	 *             composition]
	 */
	void remove(int index);

	/**
	 * Gets the component from the composition in the given index position.
	 * 
	 * @param index
	 *            Index from where the component is retrieved from
	 * @return {@link E} component from the given position
	 * @throws IndexOutOfBoundsException
	 *             If the given index is not within range [0, size of
	 *             composition]
	 */
	E get(int index);

	/**
	 * @param component
	 *            {@link E} component to check if it is in the composition
	 * @return true if the component is in the composition, false otherwise
	 */
	boolean contains(E component);
}
