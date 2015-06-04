package com.orbital3dstudios.composite.koopa.map;

import com.orbital3dstudios.composite.koopa.MultiMapComponent;
import com.orbital3dstudios.composite.koopa.TypeOne;
import com.orbital3dstudios.composite.koopa.TypeOneCompositeComponent;
import com.orbital3dstudios.composite.koopa.implementation.AbstractMultiMapComponent;

public class TestMultiMapComponentBaseComponent extends AbstractTestMapBaseCompositeComponent<MultiMapComponent<TypeOne>>
{

	@Override
	protected void addComponentsToComposition(MultiMapComponent<TypeOne> composition, int numToAdd)
	{
		for (int i = 0; i < numToAdd; i++)
		{
			composition.add(TypeOne.class, new TypeOneCompositeComponent());
		}
	}

	@Override
	protected MultiMapComponent<TypeOne> createTestedInstance()
	{
		return new AbstractMultiMapComponent<TypeOne>()
		{
			// Instantiate abstract class for testing
		};
	}
}
