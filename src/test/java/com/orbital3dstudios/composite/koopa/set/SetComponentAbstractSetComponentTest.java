package com.orbital3dstudios.composite.koopa.set;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.orbital3dstudios.composite.koopa.EqualsTestType;
import com.orbital3dstudios.composite.koopa.SetComponent;
import com.orbital3dstudios.composite.koopa.TypeOne;
import com.orbital3dstudios.composite.koopa.TypeOneCompositeComponent;
import com.orbital3dstudios.composite.koopa.implementation.AbstractSetComponent;

/**
 * These tests focuses on the contract presented by {@link SetComponent} by
 * instantiating {@link AbstractSetComponent} and testing that if follows the
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
 * @author Mikko Sirén
 * 
 */
@RunWith(JUnit4.class)
public class SetComponentAbstractSetComponentTest
{
	private SetComponent<TypeOne> test;

	@Before
	public void setup()
	{
		test = new AbstractSetComponent<TypeOne>()
		{
			// Instantiate with anonymous inner-class for testing
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
	public void testSetBehaviour()
	{
		EqualsTestType t1_1 = new EqualsTestType(1);
		EqualsTestType t2_1 = new EqualsTestType(1);
		EqualsTestType t3_1 = new EqualsTestType(1);
		EqualsTestType t1_2 = new EqualsTestType(2);
		// Because the expected behaviour is set this would produce
		// only two different values in a set.
		test.add(t1_1);
		test.add(t2_1);
		test.add(t3_1);
		test.add(t1_2);
		Assert.assertEquals("Adding several equal", 2, test.size());
	}

	@Test
	public void testSetBehaviourByAddingSameInstanceManyTimes()
	{
		EqualsTestType t1 = new EqualsTestType(1);
		EqualsTestType t2 = new EqualsTestType(2);
		test.add(t1);
		test.add(t1);
		test.add(t1);
		test.add(t2);
		test.add(t2);
		test.add(t2);
		test.add(t1);
		test.add(t1);
		test.add(t2);
		test.add(t1);
		test.add(t2);
		Assert.assertEquals("Adding same instance", 2, test.size());
	}
}
