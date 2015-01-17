package com.orbital3dstudios.composite.koopa.implementation;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.orbital3dstudios.composite.koopa.SetComponent;
import com.orbital3dstudios.composite.koopa.component.CompositeComponent;

public abstract class AbstractSetComponent<E extends CompositeComponent> extends AbstractCollectionComponent<E> implements SetComponent<E>
{

	@Override
	protected Collection<E> createCollection()
	{
		return new HashSet<E>();
	}

	public Set<E> getComponents()
	{
		// Casting if safe as long as the collection created in the
		// createCollection method
		// instantiates a class that is in the return type class hierarchy
		return (Set<E>) getCollection();
	}
}
