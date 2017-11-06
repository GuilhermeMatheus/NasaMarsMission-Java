package com.nasa.mission.mars.model;

import com.nasa.mission.mars.constraints.ConstraintException;
import com.nasa.mission.mars.model.utils.DirectionUtils;

public class Robot {
	private int id;
	public int getId() {
		return id;
	}
	private void setId(int id) {
		this.id = id;
	}
	
	private String name;
	public String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}

	private String type;
	public String getType() {
		return type;
	}
	private void setType(String type) {
		this.type = type;
	}
	
	private JourneyStatus journeyStatus;
	public JourneyStatus getJourneyStatus() {
		return journeyStatus;
	}
	private void setJourneyStatus(JourneyStatus journeyStatus) {
		this.journeyStatus = journeyStatus;
	}
	
	private Position position;
	public Position getPosition() {
		return position;
	}
	private void setPosition(Position position) throws ConstraintException {
		validateFuturePosition(position);
		this.position = position;
	}

	private Direction direction;
	public Direction getDirection() {
		return direction;
	}
	private void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	private Position explorationBoundary;
	public Position getExplorationBoundary() {
		return explorationBoundary;
	}
	private void setExplorationBoundary(Position explorationBoundary) {
		this.explorationBoundary = explorationBoundary;
	}
	
	public Robot(int id, String name, String type, Position explorationBoundary) {
		setId(id);
		setName(name);
		setType(type);
		setExplorationBoundary(explorationBoundary);
		setJourneyStatus(JourneyStatus.OnTravel);
	}
		
	public void putOnOrbit() {
		setJourneyStatus(JourneyStatus.OnOrbit);
	}
	public void putOnLand(Position position, Direction direction) throws ConstraintException {
		if (getJourneyStatus() == JourneyStatus.OnTravel)
            throw new ConstraintException("Robot cannot land while traveling");

        if (getJourneyStatus() == JourneyStatus.OnLand)
            throw new ConstraintException("Robot is already on land");

        setPosition(position);
        setDirection(direction);
        setJourneyStatus(JourneyStatus.OnLand);
	}
	
	public void moveForward() throws ConstraintException {
		if(getJourneyStatus() != JourneyStatus.OnLand)
            throw new ConstraintException("Robot must be on land to move forward");

        switch (getDirection())
        {
            case North:
                setPosition(getPosition().shiftY(1));
                break;
            case East:
            	setPosition(getPosition().shiftX(1));
                break;
            case South:
            	setPosition(getPosition().shiftY(-1));
                break;
            case West:
            	setPosition(getPosition().shiftX(-1));
                break;
        }
	}
	public void turnLeft() throws ConstraintException {
		if (getJourneyStatus() != JourneyStatus.OnLand)
            throw new ConstraintException("Robot must be on land to turn right");

        setDirection(DirectionUtils.Left(getDirection()));
	}
	public void turnRight() throws ConstraintException {
		if (getJourneyStatus() != JourneyStatus.OnLand)
            throw new ConstraintException("Robot must be on land to turn left");

        setDirection(DirectionUtils.Right(getDirection()));
	}

	public String getDisplayPosition() {
		char directionChar = ' ';
		
		switch(getDirection()) {
		case East:
			directionChar = 'E';
			break;
		case North:
			directionChar = 'N';
			break;
		case South:
			directionChar = 'S';
			break;
		case West:
			directionChar = 'W';
			break;
		default:
			break;
		
		}
		
		return String.format("%s %s", getPosition(), directionChar);
	}
	
	private void validateFuturePosition(Position position) throws ConstraintException {
		Position boundary = getExplorationBoundary();
		
		if (position.getX() > boundary.getX() || position.getX() < 0)
            throw new ConstraintException("Position cannot exceed X-axis boundary.");

        if (position.getY() > boundary.getY() || position.getY() < 0)
            throw new ConstraintException("Position cannot exceed Y-axis boundary.");
	}
}
