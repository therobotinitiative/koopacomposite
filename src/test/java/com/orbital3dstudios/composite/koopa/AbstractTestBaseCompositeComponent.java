package com.orbital3dstudios.composite.koopa;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractTestBaseCompositeComponent<T extends BaseCompositeComponent>
{
	private T testBaseComponent;

	protected abstract void addComponentsToComposition(T composition, int numToAdd);

	protected abstract T createTestedInstance();

	@Before
	public void setup()
	{
		testBaseComponent = createTestedInstance();
	}

	@After
	public void tearDown()
	{
		testBaseComponent = null;
	}

	@Test
	public void testIsEmpty()
	{
		Assert.assertTrue("Newly created is empty", testBaseComponent.isEmpty());
	}

	@Test
	public void testNotEmpty()
	{
		addComponentsToComposition(testBaseComponent, 5);
		Assert.assertFalse("Not empty after adding", testBaseComponent.isEmpty());
	}

	@Test
	public void testSizeZero()
	{
		Assert.assertEquals("Size 0", 0, testBaseComponent.size());
	}

	@Test
	public void testSizeExpected()
	{
		int numberOfComponents = 10;
		addComponentsToComposition(testBaseComponent, numberOfComponents);
		Assert.assertEquals("Size expected", numberOfComponents, testBaseComponent.size());
	}

	@Test
	public void testRemoveAll()
	{
		addComponentsToComposition(testBaseComponent, 10);
		testBaseComponent.removeAll();
		Assert.assertEquals("nothing after remove", 0, testBaseComponent.size());
		Assert.assertTrue("is empty after remove all", testBaseComponent.isEmpty());
	}

	@Test
	public void testRemoveAllEmpty()
	{
		testBaseComponent.removeAll();
	}
}
