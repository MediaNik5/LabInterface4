package org.medianik.align;

import static org.medianik.feature.Feature.OFFSET;

public abstract class Row{
	private double yOffset;

	public void update(int number, int size){
		yOffset = -(size + size%2 - 1 - 2*number)*OFFSET
				- ((size-1)/2. - number)*getHeightOfRow();
		setYOffset(yOffset);
	}

	protected abstract void setYOffset(double yOffset);
	protected abstract double getHeightOfRow();

}
