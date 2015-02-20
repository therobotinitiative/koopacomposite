package com.orbital3dstudios.composite.koopa.list;

import com.orbital3dstudios.composite.koopa.AbstractTestBaseCompositeComponent;
import com.orbital3dstudios.composite.koopa.ListComponent;
import com.orbital3dstudios.composite.koopa.TypeOne;
import com.orbital3dstudios.composite.koopa.TypeOneCompositeComponent;
import com.orbital3dstudios.composite.koopa.implementation.AbstractListCompnent;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * This class performs the {@link BaseComponent} specific tests on
 * {@link AbstractListComponent}. The tests are inherited and the testable
 * component is instantiated here. See {@link AbstractListBaseComponent} for
 * details on the tests.
 * 
 * @author Mikko Sirén
 * 
 */
@RunWith(JUnit4.class)
public class ListComponentBaseComponentTest extends AbstractTestBaseCompositeComponent<ListComponent<TypeOne>>
{

	@Override
	protected void addComponentsToComposition(ListComponent<TypeOne> composition, int numToAdd)
	{
		for (int i = 0; i < numToAdd; i++)
		{
			composition.add(new TypeOneCompositeComponent());
		}
	}

	@Override
	protected ListComponent<TypeOne> createTestedInstance()
	{
		return new AbstractListCompnent<TypeOne>()
		{
			// anonymous inner class for testing
		};
	}

}
