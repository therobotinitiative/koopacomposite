package com.orbital3dstudios.composite.koopa.map;

import com.orbital3dstudios.composite.koopa.AbstractTestMapBaseCompositeComponent;
import com.orbital3dstudios.composite.koopa.MapComponent;
import com.orbital3dstudios.composite.koopa.TypeOne;
import com.orbital3dstudios.composite.koopa.TypeOneCompositeComponent;
import com.orbital3dstudios.composite.koopa.implementation.AbstractMapComponent;

public class MapComponentBaseComponentTest extends AbstractTestMapBaseCompositeComponent<MapComponent<TypeOne>>
{

	@Override
	protected void addComponentsToComposition(MapComponent<TypeOne> composition, int numToAdd)
	{
		composition.put(TypeOne.class, new TypeOneCompositeComponent());
	}

	@Override
	protected MapComponent<TypeOne> createTestedInstance()
	{
		return new AbstractMapComponent<TypeOne>()
		{
			// Instantiate the abstract class for testing
		};
	}

}
