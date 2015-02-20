package com.orbital3dstudios.composite.koopa.list;

import com.orbital3dstudios.composite.koopa.AbstractTestCollectionComponent;
import com.orbital3dstudios.composite.koopa.CollectionComponent;
import com.orbital3dstudios.composite.koopa.ListComponent;
import com.orbital3dstudios.composite.koopa.TypeOne;
import com.orbital3dstudios.composite.koopa.implementation.AbstractListCompnent;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * This class performs the {@link CollectionComponent} specific tests on
 * {@link AbstractListComponent}. The tests are inherited and the testable
 * component is instantiated here. See {@link AbstractListCollectionComponent}
 * for details on the tests.
 * 
 * @author Mikko Sirën
 * 
 */
@RunWith(JUnit4.class)
public class ListComponentCollectionComponentTest extends AbstractTestCollectionComponent<ListComponent<TypeOne>, TypeOne>
{

	@Override
	protected ListComponent<TypeOne> createCollectionComponentInstance()
	{
		return new AbstractListCompnent<TypeOne>()
		{
			// Instantiate the abstract class which will be tested
		};
	}

}
