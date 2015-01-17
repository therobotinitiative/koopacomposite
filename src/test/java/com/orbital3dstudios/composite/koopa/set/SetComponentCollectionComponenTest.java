package com.orbital3dstudios.composite.koopa.set;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.orbital3dstudios.composite.koopa.AbstractTestCollectionComponent;
import com.orbital3dstudios.composite.koopa.CollectionComponent;
import com.orbital3dstudios.composite.koopa.SetComponent;
import com.orbital3dstudios.composite.koopa.TypeOne;
import com.orbital3dstudios.composite.koopa.implementation.AbstractSetComponent;

/**
 * This class performs the {@link CollectionComponent} specific tests on
 * {@link AbstractSetComponent}. The tests are inherited and the testable
 * component is instantiated here. See {@link AbstractTestCollectionComponent}
 * for details on the tests.
 * 
 * @author Mikko Sirén
 * 
 */
@RunWith(JUnit4.class)
public class SetComponentCollectionComponenTest extends AbstractTestCollectionComponent<SetComponent<TypeOne>, TypeOne>
{

	@Override
	protected SetComponent<TypeOne> createCollectionComponentInstance()
	{
		return new AbstractSetComponent<TypeOne>()
		{
			// anonymous inner class for testing
		};
	}

}
