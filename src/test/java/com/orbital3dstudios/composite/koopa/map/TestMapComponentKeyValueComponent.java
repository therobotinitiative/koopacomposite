package com.orbital3dstudios.composite.koopa.map;

import com.orbital3dstudios.composite.koopa.AbstractTestKeyValueComponent;
import com.orbital3dstudios.composite.koopa.MapComponent;
import com.orbital3dstudios.composite.koopa.TypeOne;
import com.orbital3dstudios.composite.koopa.TypeOneCompositeComponent;
import com.orbital3dstudios.composite.koopa.implementation.AbstractMapComponent;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestMapComponentKeyValueComponent extends AbstractTestKeyValueComponent<MapComponent<TypeOne>, TypeOne>
{

	@Override
	protected MapComponent<TypeOne> createKeyValueComponent()
	{
		return new AbstractMapComponent<TypeOne>()
		{
			// anonymous inner class for testing
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
	protected Class<? extends TypeOne> putValueForKey(MapComponent<TypeOne> putInto)
	{
		Class<? extends TypeOne> key = createKey();
		putInto.put(key, createComponent());
		return key;
	}

}
