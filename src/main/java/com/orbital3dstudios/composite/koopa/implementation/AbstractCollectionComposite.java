package com.orbital3dstudios.composite.koopa.implementation;

import java.util.Collection;

import com.orbital3dstudios.composite.koopa.CollectionComponent;
import com.orbital3dstudios.composite.koopa.component.CompositeComponent;

public abstract class AbstractCollectionComposite<E extends CompositeComponent> implements CollectionComponent<E>
{
	private final Collection<E> setti = createCollection();

	/**
	 * @return Instance of {@Collection} used by this
	 *         implementation
	 */
	protected abstract Collection<E> createCollection();

	protected Collection<E> getCollection()
	{
		return setti;
	}

	public int size()
	{
		return setti.size();
	}

	public boolean isEmpty()
	{
		return setti.isEmpty();
	}

	public void add(E component)
	{
		setti.add(component);
	}

	public boolean remove(E component)
	{
		return setti.remove(component);
	}

	public void remove(int index)
	{
		remove(get(index));
	}

	public E get(int index)
	{
		if (index < 0 || index >= setti.size())
		{
			throw new IndexOutOfBoundsException("Index " + index + " must be within range [0," + (setti.size() - 1) + "]");
		}
		// The Java collections library is type safe so the type safety is
		// already guaranteed at that level.
		@SuppressWarnings("unchecked")
		E returnValue = (E) setti.toArray()[index];
		return returnValue;
	}

	public boolean contains(E component)
	{
		return setti.contains(component);
	}

	public void removeAll()
	{
		setti.clear();
	}
}
