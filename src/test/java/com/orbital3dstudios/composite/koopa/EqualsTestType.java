package com.orbital3dstudios.composite.koopa;

/**
 * Test class in the {@link TypeOne} "family". The equality of the class can be
 * determined by the given number in construction phase. The purpose of this
 * test component is to able testing where only one instance of equal component
 * is stored.
 * 
 * @author Mikko Sirén
 * 
 */
public class EqualsTestType implements TypeOne
{
	private final int field;

	public EqualsTestType(int field)
	{
		this.field = field;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + field;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (!(obj instanceof EqualsTestType))
		{
			return false;
		}
		return true;
	}

}
