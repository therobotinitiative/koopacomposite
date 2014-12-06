package com.orbital3dstudios.composite.koopa.implementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.orbital3dstudios.composite.koopa.ListComponent;
import com.orbital3dstudios.composite.koopa.component.CompositeComponent;

public abstract class AbstractListCompositeComponent<E extends CompositeComponent> extends AbstractCollectionComposite<E> implements ListComponent<E>
{

	public List<E> getComponents()
	{
		// Casting is safe as long as createCollection returns instance of class
		// that
		// is in the return type class hierarchy.
		return (List<E>) getCollection();
	}

	@Override
	protected Collection<E> createCollection()
	{
		return new ArrayList<E>();
	}

}
