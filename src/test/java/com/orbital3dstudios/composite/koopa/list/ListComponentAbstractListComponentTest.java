package com.orbital3dstudios.composite.koopa.list;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.orbital3dstudios.composite.koopa.EqualsTestType;
import com.orbital3dstudios.composite.koopa.ListComponent;
import com.orbital3dstudios.composite.koopa.TypeOne;
import com.orbital3dstudios.composite.koopa.TypeOneCompositeComponent;
import com.orbital3dstudios.composite.koopa.implementation.AbstractListCompnent;

/**
 * These tests focuses on the contract presented by {@link ListComponent} by
 * instantiating {@link AbstractListCompnent} and testing that if follows the
 * contract.
 * 
 * We are not concerned about the actual implementation so we ignore it
 * completely. We are testing only the contract of the interface.
 * 
 * JUnit tests point is not to test the implementation in this case we know that
 * the abstract classes are backed by classes from the collections library
 * available in JDK. There is no point in testing that. And if the
 * implementation would change then that would mean rewriting the test to follow
 * the new implementation which makes no sense.
 * 
 * @author Mikko Sir�n
 * 
 */
@RunWith(JUnit4.class)
public class ListComponentAbstractListComponentTest
{
	private ListComponent<TypeOne> test;

	@Before
	public void setup()
	{
		test = new AbstractListCompnent<TypeOne>()
		{
			// anonymous inner class for testing
		};
	}

	@After
	public void tearDown()
	{
		test = null;
	}

	@Test
	public void testGetComponents()
	{
		Set<TypeOne> components = new HashSet<TypeOne>();
		components.add(new TypeOneCompositeComponent());
		components.add(new TypeOneCompositeComponent());
		components.add(new TypeOneCompositeComponent());
		components.add(new TypeOneCompositeComponent());
		components.add(new TypeOneCompositeComponent());
		for (TypeOne component : components)
		{
			test.add(component);
		}
		Assert.assertNotNull("get components", test.getComponents());
		Assert.assertEquals("size", components.size(), test.getComponents().size());
	}

	@Test
	public void testListBehaviourAddMany()
	{
		for (int i = 0; i < 10; i++)
		{
			test.add(new EqualsTestType(1));
		}
		Assert.assertNotNull("list get component", test.getComponents());
		Assert.assertEquals("list size get component", 10, test.getComponents().size());
	}
}
