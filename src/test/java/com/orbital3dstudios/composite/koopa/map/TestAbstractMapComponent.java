package com.orbital3dstudios.composite.koopa.map;

import java.util.Collection;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.orbital3dstudios.composite.koopa.MapComponent;
import com.orbital3dstudios.composite.koopa.TypeOne;
import com.orbital3dstudios.composite.koopa.TypeOneCompositeComponent;
import com.orbital3dstudios.composite.koopa.TypeTwoCompositeComponent;
import com.orbital3dstudios.composite.koopa.implementation.AbstractMapComponent;

@RunWith(JUnit4.class)
public class TestAbstractMapComponent
{
	private MapComponent<TypeOne> test;

	@Before
	public void setup()
	{
		test = new AbstractMapComponent<TypeOne>()
		{
			// For test purposes
		};
	}

	private final class TypeOneTest extends AbstractMapComponent<TypeOne> implements TypeOne
	{
		// Test component
	}

	@After
	public void tearDown()
	{
		test = null;
	}

	@Test
	public void testSizeZero()
	{
		Assert.assertEquals("Empty size", 0, test.size());
	}

	@Test
	public void testIsEmpty()
	{
		Assert.assertTrue("IsEmpty", test.isEmpty());
	}

	@Test
	public void testAddOne()
	{
		test.put(TypeOneCompositeComponent.class, new TypeOneCompositeComponent());
		Assert.assertEquals("after add", 1, test.size());
		Assert.assertFalse("not empty after add", test.isEmpty());
	}

	@Test
	public void testGetOne()
	{
		TypeOneCompositeComponent t1 = new TypeOneCompositeComponent();
		// Add it
		test.put(TypeOneCompositeComponent.class, t1);
		// Try to get it
		TypeOneCompositeComponent res = (TypeOneCompositeComponent) test.get(TypeOneCompositeComponent.class);
		Assert.assertNotNull("Got value", res);
		Assert.assertEquals("Same object", t1, res);
	}

	@Test
	public void testSizeAfterAdd()
	{
		test.put(TypeOneCompositeComponent.class, new TypeOneCompositeComponent());
		Assert.assertEquals("size after add", 1, test.size());
	}

	@Test
	public void testValueGetsReplaced()
	{
		TypeOneCompositeComponent t1 = new TypeOneCompositeComponent();
		TypeOneCompositeComponent t2 = new TypeOneCompositeComponent();
		test.put(TypeOneCompositeComponent.class, t1);
		test.put(TypeOneCompositeComponent.class, t2);
		Assert.assertEquals("double add size", 1, test.size());
		Assert.assertEquals("Has been replaced", t2, test.get(TypeOneCompositeComponent.class));
	}

	@Test
	public void testRemove()
	{
		TypeOneCompositeComponent t1 = new TypeOneCompositeComponent();
		test.put(TypeOneCompositeComponent.class, t1);
		Assert.assertTrue("remove", test.remove(TypeOneCompositeComponent.class));
		Assert.assertEquals("size after remove", 0, test.size());
		Assert.assertTrue("isEmpty after remove", test.isEmpty());
	}

	@Test
	public void testRemovePutTwo()
	{
		TypeOneCompositeComponent t1 = new TypeOneCompositeComponent();
		TypeOneCompositeComponent t2 = new TypeOneCompositeComponent();
		test.put(TypeOne.class, t1);
		test.put(TypeOneCompositeComponent.class, t2);
		Assert.assertTrue("Remove other", test.remove(TypeOne.class));
		Assert.assertEquals("Get other", t2, test.get(TypeOneCompositeComponent.class));
		Assert.assertEquals("size", 1, test.size());
	}

	@Test
	public void testGetKeys()
	{
		test.put(TypeOne.class, new TypeOneCompositeComponent());
		test.put(TypeOneCompositeComponent.class, new TypeOneCompositeComponent());
		Set<Class<? extends TypeOne>> keys = test.keys();
		Assert.assertNotNull("keys", keys);
		Assert.assertEquals("keys size", 2, keys.size());
		Assert.assertTrue("Contains", keys.contains(TypeOne.class));
		Assert.assertTrue("contains other", keys.contains(TypeOneCompositeComponent.class));
		Assert.assertFalse("does not contain type", keys.contains(TypeOneTest.class));
	}

	@Test
	public void testGetValues()
	{
		TypeOneCompositeComponent t1 = new TypeOneCompositeComponent();
		TypeOneCompositeComponent t2 = new TypeOneCompositeComponent();
		test.put(TypeOne.class, t1);
		test.put(TypeOneCompositeComponent.class, t2);
		Collection<TypeOne> values = test.values();
		Assert.assertNotNull("values not null", values);
		Assert.assertEquals("values size", 2, values.size());
		Assert.assertTrue("contains t1", values.contains(t1));
		Assert.assertTrue("contains t2", values.contains(t2));
		Assert.assertFalse("not contains random instance", values.contains(new TypeOneTest()));
	}

	@Test
	public void testPutTwoKeyFromTypeHierarchy()
	{
		test.put(TypeOne.class, new TypeOneCompositeComponent());
		test.put(TypeOneCompositeComponent.class, new TypeOneCompositeComponent());
		Assert.assertEquals("Size after put two", 2, test.size());
	}

	@Test(expected = ClassCastException.class)
	public void testPut551CastTrick()
	{
		test.put(TypeOne.class, (TypeOne) new TypeTwoCompositeComponent());
	}

}
