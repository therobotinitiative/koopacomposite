package com.orbital3dstudios.composite.koopa.map;

import com.orbital3dstudios.composite.koopa.MultiMapComponent;
import com.orbital3dstudios.composite.koopa.TypeOne;
import com.orbital3dstudios.composite.koopa.implementation.AbstractMultiMapComponent;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestAbstractMultiMapComponent
{
	private MultiMapComponent<TypeOne> test;

	@Before
	public void setup()
	{
		test = new AbstractMultiMapComponent<TypeOne>()
		{
			// Instantiate abstract class for testing
		};
	}

	@After
	public void tearDown()
	{
		test = null;
	}

	@Test
	public void thereAreNoTestsToRunYetIAmTooLazy()
	{

	}
}
