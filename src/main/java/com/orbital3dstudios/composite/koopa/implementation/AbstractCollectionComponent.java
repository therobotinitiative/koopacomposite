package com.orbital3dstudios.composite.koopa.implementation;

import java.util.Collection;

import com.orbital3dstudios.composite.koopa.CollectionComponent;
import com.orbital3dstudios.composite.koopa.component.CompositeComponent;

public abstract class AbstractCollectionComponent<E extends CompositeComponent> implements CollectionComponent<E>
{
	private final Collection<E> backEndCollection = createCollection();

	/**
	 * @return Instance of {@Collection} used by this
	 *         implementation
	 */
	protected abstract Collection<E> createCollection();

	protected Collection<E> getCollection()
	{
		return backEndCollection;
	}

	public int size()
	{
		return backEndCollection.size();
	}

	public boolean isEmpty()
	{
		return backEndCollection.isEmpty();
	}

	public void add(E component)
	{
		if (component == null)
		{
			throw new NullPointerException("The component cannot be null");
		}
		backEndCollection.add(component);
	}

	public boolean remove(E component)
	{
		return backEndCollection.remove(component);
	}

	public void remove(int index)
	{
		remove(get(index));
	}

	public E get(int index)
	{
		if (index < 0 || index >= backEndCollection.size())
		{
			throw new IndexOutOfBoundsException("Index " + index + " must be within range [0," + (backEndCollection.size() - 1) + "]");
		}
		// The Java collections library is type safe so the type safety is
		// already guaranteed at that level.
		@SuppressWarnings("unchecked")
		E returnValue = (E) backEndCollection.toArray()[index];
		return returnValue;
	}

	public boolean contains(E component)
	{
		return backEndCollection.contains(component);
	}

	public void removeAll()
	{
		backEndCollection.clear();
	}
}
