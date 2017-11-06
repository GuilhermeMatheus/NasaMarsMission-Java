package com.nasa.mission.mars.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.nasa.mission.mars.constraints.ConstraintException;
import com.nasa.mission.mars.model.*;

class RobotTurnRightTest {

	@Test
	void turnRight_ShouldChangeDirectionToNorth_WhenDirectionIsWest() throws ConstraintException {
		Robot robot = getRobotLandedInDirection(Direction.West);
		
		robot.turnRight();
		
		assertEquals(
				Direction.North,
				robot.getDirection());
	}
	
	@Test
	void turnRight_ShouldChangeDirectionToEast_WhenDirectionIsNorth() throws ConstraintException {
		Robot robot = getRobotLandedInDirection(Direction.North);
		
		robot.turnRight();
		
		assertEquals(
				Direction.East,
				robot.getDirection());
	}

	@Test
	void turnRight_ShouldChangeDirectionToSouth_WhenDirectionIsEast() throws ConstraintException {
		Robot robot = getRobotLandedInDirection(Direction.East);
		
		robot.turnRight();
		
		assertEquals(
				Direction.South,
				robot.getDirection());
	}

	@Test
	void turnRight_ShouldChangeDirectionToWest_WhenDirectionIsSouth() throws ConstraintException {
		Robot robot = getRobotLandedInDirection(Direction.South);
		
		robot.turnRight();
		
		assertEquals(
				Direction.West,
				robot.getDirection());
	}
	
	@Test
	void turnLeft_ShouldChangeDirectionToSouth_WhenDirectionIsWest() throws ConstraintException {
		Robot robot = getRobotLandedInDirection(Direction.West);
		
		robot.turnLeft();
		
		assertEquals(
				Direction.South,
				robot.getDirection());
	}
	
	@Test
	void turnLeft_ShouldChangeDirectionToWest_WhenDirectionIsNorth() throws ConstraintException {
		Robot robot = getRobotLandedInDirection(Direction.North);
		
		robot.turnLeft();
		
		assertEquals(
				Direction.West,
				robot.getDirection());
	}

	@Test
	void turnLeft_ShouldChangeDirectionToNorth_WhenDirectionIsEast() throws ConstraintException {
		Robot robot = getRobotLandedInDirection(Direction.East);
		
		robot.turnLeft();
		
		assertEquals(
				Direction.North,
				robot.getDirection());
	}

	@Test
	void turnLeft_ShouldChangeDirectionToEast_WhenDirectionIsSouth() throws ConstraintException {
		Robot robot = getRobotLandedInDirection(Direction.South);
		
		robot.turnLeft();
		
		assertEquals(
				Direction.East,
				robot.getDirection());
	}
	
	
	static Robot getRobotLandedInDirection(Direction direction) throws ConstraintException {
		Robot result = new Robot(1, "robot", "robot", new Position(5,5));
		result.putOnOrbit();
		result.putOnLand(new Position(1, 1), direction);
		return result;
	}
}