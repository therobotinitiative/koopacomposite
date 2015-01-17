package com.orbital3dstudios.composite.koopa;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.orbital3dstudios.composite.koopa.component.CompositeComponent;

public abstract class AbstractTestCollectionComponent<T extends CollectionComponent<E>, E extends CompositeComponent>
{
	private T test;

	protected abstract T createCollectionComponentInstance();

	private E createComponent()
	{
		// Type parameter E bound is CompositeComponent so we rely on the fact
		// that we know
		// that instantiated class is correct type. Also re-reading Effective
		// Javas chapter
		// on generics might help here.
		@SuppressWarnings("unchecked")
		E componentToAdd = (E) new TypeOneCompositeComponent();
		return componentToAdd;
	}

	@Before
	public void setup()
	{
		test = createCollectionComponentInstance();
	}

	@Test(expected = NullPointerException.class)
	public void testAddNull()
	{
		test.add(null);
	}

	@Test
	public void testAddComponent()
	{
		test.add(createComponent());
	}

	@Test
	public void testRemoveNothingOnTheSet()
	{
		Assert.assertFalse("Remove from empty", test.remove(createComponent()));
	}

	@Test
	public void testRemoveJustAdded()
	{
		E componentToAdd = createComponent();
		test.add(componentToAdd);
		Assert.assertTrue("Remove just added", test.remove(componentToAdd));
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
			test.add(createComponent());
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
		test.add(createComponent());
		test.add(createComponent());
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
		test.add(createComponent());
		test.add(createComponent());
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
		test.add((E) (TypeOne) new TypeTwoCompositeComponent());
	}

	@Test
	public void testContainsAddedComponent()
	{
		EqualsTestType t1 = new EqualsTestType(1);
		for (int i = 0; i < 5; i++)
		{
			test.add(createComponent());
		}
		test.add((E) t1);
		Assert.assertTrue("Contains", test.contains((E) t1));
	}

	@Test
	public void testDoesNotContainsAddedComponent()
	{
		EqualsTestType t1 = new EqualsTestType(1);
		for (int i = 0; i < 5; i++)
		{
			test.add(createComponent());
		}
		Assert.assertFalse("Contains", test.contains((E) t1));
	}

	@Test
	public void testContainsNull()
	{
		Assert.assertFalse("contains null", test.contains(null));
	}

}
