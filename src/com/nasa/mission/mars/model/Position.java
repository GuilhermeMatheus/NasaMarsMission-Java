package com.nasa.mission.mars.model;

public class Position {
	private int x;
	public int getX() {
		return x;
	}
	
	private int y;
	public int getY() {
		return y;
	}
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Position shiftX(int delta) {
		return new Position(x + delta, y);
	}
	
	public Position shiftY(int delta) {
		return new Position(x, y + delta);
	}
	
	public Position add(Position that){
		return new Position(x + that.x, y + that.y);
    }
	
	@Override
	public String toString() {
		return String.format("%d %d", getX(), getY());		
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (obj == null) {
	        return false;
	    }
	    if (!Position.class.isAssignableFrom(obj.getClass())) {
	        return false;
	    }
	    
	    final Position other = (Position)obj;
	    
	    if (getX() != other.getX()) {
	        return false;
	    }
	    
	    if (getY() != other.getY()) {
	        return false;
	    }
	    
	    return true;
	}

	@Override
	public int hashCode() {
	    int hash = 3;
	    hash = 53 * hash + getY();
	    hash = 53 * hash + getX();
	    return hash;
	}

}
