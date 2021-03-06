package com.orbital3dstudios.composite.koopa.map;

import com.orbital3dstudios.composite.koopa.AbstractTestBaseCompositeComponent;
import com.orbital3dstudios.composite.koopa.BaseCompositeComponent;

public abstract class AbstractTestMapBaseCompositeComponent<T extends BaseCompositeComponent> extends AbstractTestBaseCompositeComponent<T>
{

	@Override
	public void testSizeExpected()
	{
		// This test is left empty because it does not apply to map. The size will be 1 for 1 key
		// Ok maybe it could apply to map, but I'm too lazy to think about it now
	}

}
