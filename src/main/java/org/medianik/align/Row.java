package org.medianik.align;

import static org.medianik.feature.Feature.OFFSET;

public abstract class Row{
	private double yOffset;

	public void update(int index, int size){
		yOffset = -(size + size%2 - 1 - 2*index)*OFFSET
				- ((size-1)/2. - index)*getHeightOfRow();
		setYOffset(yOffset);
	}

	protected abstract void setYOffset(double yOffset);
	protected abstract double getHeightOfRow();

}
