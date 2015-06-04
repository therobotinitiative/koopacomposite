package com.orbital3dstudios.composite.koopa.map;

import com.orbital3dstudios.composite.koopa.AbstractTestKeyValueComponent;
import com.orbital3dstudios.composite.koopa.MultiMapComponent;
import com.orbital3dstudios.composite.koopa.TypeOne;
import com.orbital3dstudios.composite.koopa.TypeOneCompositeComponent;
import com.orbital3dstudios.composite.koopa.implementation.AbstractMultiMapComponent;

public class TestAbstractMultiMapComponentKeyValueComponent extends AbstractTestKeyValueComponent<MultiMapComponent<TypeOne>, TypeOne>
{

	@Override
	protected MultiMapComponent<TypeOne> createKeyValueComponent()
	{
		return new AbstractMultiMapComponent<TypeOne>()
		{
			// Instantiate abstract class for testing
		};
	}

	@Override
	protected TypeOne createComponent()
	{
		return new TypeOneCompositeComponent();
	}

	@Override
	protected Class<? extends TypeOne> createKey()
	{
		return TypeOneCompositeComponent.class;
	}

	@Override
	protected Class<? extends TypeOne> putValueForKey(MultiMapComponent<TypeOne> putInto)
	{
		Class<? extends TypeOne> key = createKey();
		putInto.add(key, createComponent());
		return key;
	}

}
