package com.orbital3dstudios.composite.koopa;

import com.orbital3dstudios.composite.koopa.component.CompositeComponent;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractTestKeyValueComponent<T extends KeyValueComponent<E>, E extends CompositeComponent>
{
	private T testKeyValue;

	/**
	 * @return Instance of {@link KeyValueComponent} that will be tested
	 */
	protected abstract T createKeyValueComponent();

	protected abstract E createComponent();

	protected abstract Class<? extends E> createKey();

	protected abstract Class<? extends E> putValueForKey(T putInto);

	@Before
	public void setup()
	{
		testKeyValue = createKeyValueComponent();
	}

	@After
	public void tearDown()
	{
		testKeyValue = null;
	}

	@Test
	public void testRemoveNull()
	{
		Assert.assertFalse("remove nnull", testKeyValue.remove(null));
	}

	@Test
	public void testRemoveNoKey()
	{
		Assert.assertFalse("remove no key", testKeyValue.remove(createKey()));
	}

	@Test
	public void testRemove()
	{
		Class<? extends E> key = putValueForKey(testKeyValue);
		Assert.assertTrue("remove key", testKeyValue.remove(key));
	}
}
