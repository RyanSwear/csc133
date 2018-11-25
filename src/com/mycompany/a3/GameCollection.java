package com.mycompany.a3;

import java.util.Vector;

public class GameCollection implements ICollection{
	private Vector theCollection;
	public GameCollection()
	{
		theCollection = new Vector();
	}
	public void add(Object newObject)
	{
		theCollection.addElement(newObject);
	}
	public void remove(Object removeObj)
	{
		theCollection.remove(removeObj);
		
		
	}
	public IIterator getIterator()
	{
		return new SpaceVectorIterator();
	}
	
	private class SpaceVectorIterator implements IIterator
	{
		private int currentI;
		public SpaceVectorIterator()
		{
			currentI = -1;
		}
		public boolean hasNext()
		{
			if (theCollection.size() <= 0) return false;
			if (currentI == theCollection.size() - 1) return false;
			return true;
		}
		public Object getNext()
		{
			currentI ++;
			return (theCollection.elementAt(currentI));
		}
		public Object getObject()
		{
			return (theCollection.elementAt(currentI));
		}
		public int getIndex()
		{
			return currentI;
		}
		public void dec()
		{
			currentI--;
		}
	}
}
