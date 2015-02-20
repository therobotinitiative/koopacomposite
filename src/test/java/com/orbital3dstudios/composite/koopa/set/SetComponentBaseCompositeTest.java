package com.orbital3dstudios.composite.koopa.set;

import com.orbital3dstudios.composite.koopa.AbstractTestBaseCompositeComponent;
import com.orbital3dstudios.composite.koopa.SetComponent;
import com.orbital3dstudios.composite.koopa.TypeOne;
import com.orbital3dstudios.composite.koopa.TypeOneCompositeComponent;
import com.orbital3dstudios.composite.koopa.implementation.AbstractSetComponent;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * This class performs the {@link BaseComponent} specific tests on
 * {@link AbstractSetComponent}. The tests are inherited and the testable
 * component is instantiated here. See {@link AbstractTestBaseComponent} for
 * details on the tests.
 * 
 * @author Mikko Sir�n
 * 
 */
@RunWith(JUnit4.class)
public class SetComponentBaseCompositeTest extends AbstractTestBaseCompositeComponent<SetComponent<TypeOne>>
{

	@Override
	protected void addComponentsToComposition(SetComponent<TypeOne> composition, int numToAdd)
	{
		for (int i = 0; i < numToAdd; i++)
		{
			composition.add(new TypeOneCompositeComponent());
		}
	}

	@Override
	protected SetComponent<TypeOne> createTestedInstance()
	{
		return new AbstractSetComponent<TypeOne>()
		{
			// Anonymous inner class for testing
		};
	}

}
