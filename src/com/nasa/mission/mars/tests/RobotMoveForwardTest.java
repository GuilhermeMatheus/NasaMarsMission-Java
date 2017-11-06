package com.nasa.mission.mars.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.nasa.mission.mars.constraints.ConstraintException;
import com.nasa.mission.mars.model.*;

class RobotMoveForwardTest {

	@Test
	void moveForward_ShouldShift1XPosition_WhenDirectionIsEast() throws ConstraintException {
		Robot robot = getRobotLandedInDirection(Direction.East);
		Position position = robot.getPosition();
		
		robot.moveForward();
		
		assertEquals(
				position.getX()+1,
				robot.getPosition().getX());
	}
	
	@Test
	void moveForward_ShouldShiftMinus1XPosition_WhenDirectionIsWest() throws ConstraintException {
		Robot robot = getRobotLandedInDirection(Direction.West);
		Position position = robot.getPosition();
		
		robot.moveForward();
		
		assertEquals(
				position.getX()-1,
				robot.getPosition().getX());
	}
	
	@Test
	void moveForward_ShouldShift1YPosition_WhenDirectionIsNorth() throws ConstraintException {
		Robot robot = getRobotLandedInDirection(Direction.North);
		Position position = robot.getPosition();
		
		robot.moveForward();
		
		assertEquals(
				position.getY()+1,
				robot.getPosition().getY());
	}
	
	@Test
	void moveForward_ShouldShiftMinus1YPosition_WhenDirectionIsSouth() throws ConstraintException {
		Robot robot = getRobotLandedInDirection(Direction.South);
		Position position = robot.getPosition();
		
		robot.moveForward();
		
		assertEquals(
				position.getY()-1,
				robot.getPosition().getY());
	}
	
	static Robot getRobotLandedInDirection(Direction direction) throws ConstraintException {
		Robot result = new Robot(1, "robot", "robot", new Position(5,5));
		result.putOnOrbit();
		result.putOnLand(new Position(1, 1), direction);
		return result;
	}
}
