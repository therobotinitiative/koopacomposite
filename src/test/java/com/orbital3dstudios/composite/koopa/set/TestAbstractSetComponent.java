package com.orbital3dstudios.composite.koopa.set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.orbital3dstudios.composite.koopa.SetComponent;
import com.orbital3dstudios.composite.koopa.TypeOne;
import com.orbital3dstudios.composite.koopa.TypeOneCompositeComponent;
import com.orbital3dstudios.composite.koopa.TypeTwoCompositeComponent;
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
	private SetComponent<TypeOne> test;

	@Before
	public void setup()
	{
		test = new AbstractSetComposite<TypeOne>()
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
		test.add(new TypeOneCompositeComponent());
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
			test.add(new TypeOneCompositeComponent());
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
			test.add(new TypeOneCompositeComponent());
		}
		Assert.assertEquals("Size expected", numberOfComponents, test.size());
	}

	@Test
	public void testRemoveNothingOnTheSet()
	{
		Assert.assertFalse("Remove from empty", test.remove(new TypeOneCompositeComponent()));
	}

	@Test
	public void testRemoveJustAdded()
	{
		TypeOneCompositeComponent comp = new TypeOneCompositeComponent();
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
			test.add(new TypeOneCompositeComponent());
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
		test.add(new TypeOneCompositeComponent());
		test.add(new TypeOneCompositeComponent());
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
		test.add(new TypeOneCompositeComponent());
		test.add(new TypeOneCompositeComponent());
		test.remove(10);
	}

	@Test(expected = ClassCastException.class)
	public void testAddWrongTypeComponentByCasting()
	{
		// Apparently this is legal cast I think it's due to JLS 5.5.1 (Java
		// SE7), so we test that this does
		// cause ClassCastException during runtime. The library relies on the
		// fact that the user of the library
		// takes care about these kind of things. If the user needs to
		// extensively cast then something could
		// be wrong in the way the library is used.
		test.add((TypeOne) new TypeTwoCompositeComponent());
	}
}
