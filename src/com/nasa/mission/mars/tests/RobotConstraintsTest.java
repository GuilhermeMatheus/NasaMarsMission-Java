package com.nasa.mission.mars.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.nasa.mission.mars.constraints.ConstraintException;
import com.nasa.mission.mars.model.*;

class RobotConstraintsTest {

	@Test
	void moveForward_BeforeRobotPutOnLand_ShouldThrowConstraintException() throws ConstraintException {
		assertThrows(
				ConstraintException.class,
				() -> {
					Robot robot = new Robot(1, "robot", "robot", new Position(5,5));
					robot.moveForward();
				}
			);
	}
	
	@Test 
	void turnLeft_BeforeRobotPutOnLand_ShouldThrowConstraintException() throws ConstraintException {
		assertThrows(
				ConstraintException.class,
				() -> {
					Robot robot = new Robot(1, "robot", "robot", new Position(5,5));
					robot.turnLeft();
				}
			);
	}
	
	@Test
	void turnRight_BeforeRobotPutOnLand_ShouldThrowConstraintException() throws ConstraintException {
		assertThrows(
				ConstraintException.class,
				() -> {
					Robot robot = new Robot(1, "robot", "robot", new Position(5,5));
					robot.turnRight();
				}
			);
	}
	
	@Test
	void putOnLand_BeforeRobotPutOnOrbit_ShouldThrowConstraintException() throws ConstraintException {
		assertThrows(
				ConstraintException.class,
				() -> {
					Robot robot = new Robot(1, "robot", "robot", new Position(5,5));
					robot.putOnLand(new Position(1, 1), Direction.North);
				}
			);
	}
	
	@Test
	void putOnLandTwice_ShouldThrowConstraintException() throws ConstraintException {
		assertThrows(
				ConstraintException.class,
				() -> {
					Robot robot = new Robot(1, "robot", "robot", new Position(5,5));
					robot.putOnOrbit();
					robot.putOnLand(new Position(1, 1), Direction.North);
					robot.putOnLand(new Position(1, 1), Direction.North);
				}
			);
	}
	
	@Test
	void moveForward_WhenOutOfUpperYBound_ShouldThrowConstraintException() throws ConstraintException {
		assertThrows(
				ConstraintException.class,
				() -> {
					Robot robot = new Robot(1, "robot", "robot", new Position(1,1));
					robot.putOnOrbit();
					robot.putOnLand(new Position(0, 0), Direction.North);
					
					robot.moveForward();
					robot.moveForward();
				}
			);
	}
	
	@Test
	void moveForward_WhenOutOfRightXBound_ShouldThrowConstraintException() throws ConstraintException {
		assertThrows(
				ConstraintException.class,
				() -> {
					Robot robot = new Robot(1, "robot", "robot", new Position(1,1));
					robot.putOnOrbit();
					robot.putOnLand(new Position(0, 0), Direction.East);
					
					robot.moveForward();
					robot.moveForward();
				}
			);
	}
	
	@Test
	void moveForward_WhenOutOfBottomYBound_ShouldThrowConstraintException() throws ConstraintException {
		assertThrows(
				ConstraintException.class,
				() -> {
					Robot robot = new Robot(1, "robot", "robot", new Position(1,1));
					robot.putOnOrbit();
					robot.putOnLand(new Position(0, 0), Direction.South);
					
					robot.moveForward();
				}
			);
	}
	
	@Test
	void moveForward_WhenOutOfLeftXBound_ShouldThrowConstraintException() throws ConstraintException {
		assertThrows(
				ConstraintException.class,
				() -> {
					Robot robot = new Robot(1, "robot", "robot", new Position(1,1));
					robot.putOnOrbit();
					robot.putOnLand(new Position(0, 0), Direction.West);
					
					robot.moveForward();
				}
			);
	}
}
