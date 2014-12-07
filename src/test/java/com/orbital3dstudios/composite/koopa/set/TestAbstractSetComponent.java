package com.orbital3dstudios.composite.koopa.set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.orbital3dstudios.composite.koopa.SetComponent;
import com.orbital3dstudios.composite.koopa.TestCompositeComponent;
import com.orbital3dstudios.composite.koopa.implementation.AbstractSetComposite;

/**
 * These tests focuses on the contract presented by {@link SetComponent} by
 * instantiating {@link AbstractSetComposite} and testing that if follows the
 * contract.
 * 
 * We are not concerned about the actual implementation so we ignore it
 * completely. We are testing only the contract.
 * 
 * @author Mikko Sirén
 * 
 */
@RunWith(JUnit4.class)
public class TestAbstractSetComponent
{
	private SetComponent<TestCompositeComponent> test;

	@Before
	public void setup()
	{
		test = new AbstractSetComposite<TestCompositeComponent>()
		{
			// Instantiate with anonymous inner-class for testing
		};
	}

	@After
	public void tearDown()
	{
		test = null;
	}

	@Test(expected = NullPointerException.class)
	public void testAddNull()
	{
		test.add(null);
	}

	@Test
	public void testAddComponent()
	{
		test.add(new TestCompositeComponent());
	}

	@Test
	public void testIsEmpty()
	{
		Assert.assertTrue("Newly created is empty", test.isEmpty());
	}

	@Test
	public void testNotEmpty()
	{
		for (int i = 0; i < 5; i++)
		{
			test.add(new TestCompositeComponent());
		}
		Assert.assertFalse("Not empty after adding", test.isEmpty());
	}

	@Test
	public void testSizeZero()
	{
		Assert.assertEquals("Size 0", 0, test.size());
	}

	@Test
	public void testSizeExpected()
	{
		int numberOfComponents = 10;
		for (int i = 0; i < numberOfComponents; i++)
		{
			test.add(new TestCompositeComponent());
		}
		Assert.assertEquals("Size expected", numberOfComponents, test.size());
	}

	@Test
	public void testRemoveNothingOnTheSet()
	{
		Assert.assertFalse("Remove from empty", test.remove(new TestCompositeComponent()));
	}

	@Test
	public void testRemoveJustAdded()
	{
		TestCompositeComponent comp = new TestCompositeComponent();
		test.add(comp);
		Assert.assertTrue("Remove just added", test.remove(comp));
	}

	@Test
	public void testRemoveNull()
	{
		Assert.assertFalse("Removing null", test.remove(null));
	}

	@Test
	public void testRemoveByIndex()
	{
		for (int i = 0; i < 10; i++)
		{
			test.add(new TestCompositeComponent());
		}
		test.remove(1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetOutOfRangeIndexEmpty()
	{
		test.get(10);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetOutOfRangeIndexWithTwoComponents()
	{
		test.add(new TestCompositeComponent());
		test.add(new TestCompositeComponent());
		test.get(10);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveOutOfRangeIndexEmpty()
	{
		test.remove(10);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveOutOfRangeIndexWithTwoElements()
	{
		test.add(new TestCompositeComponent());
		test.add(new TestCompositeComponent());
		test.remove(10);
	}
}
