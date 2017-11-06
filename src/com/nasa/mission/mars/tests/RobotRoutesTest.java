package com.nasa.mission.mars.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.nasa.mission.mars.constraints.ConstraintException;
import com.nasa.mission.mars.model.*;

class RobotRoutesTest {

	@Test
	void robotNavigationCase1() throws ConstraintException {
		Robot robot = new Robot(1, "", "", new Position(5, 5));
		robot.putOnOrbit();
		robot.putOnLand(new Position(1, 2), Direction.North);
		
		executeCommands("LMLMLMLMM", robot);
		
		assertEquals(new Position(1, 3), robot.getPosition());
		assertEquals(Direction.North, robot.getDirection());
		assertEquals("1 3 N", robot.getDisplayPosition());
	}
	
	@Test
	void robotNavigationCase2() throws ConstraintException {
		Robot robot = new Robot(1, "", "", new Position(5, 5));
		robot.putOnOrbit();
		robot.putOnLand(new Position(3, 3), Direction.East);
		
		executeCommands("MMRMMRMRRM", robot);
		
		assertEquals(new Position(5, 1), robot.getPosition());
		assertEquals(Direction.East, robot.getDirection());
		assertEquals("5 1 E", robot.getDisplayPosition());
	}
	
	private static void executeCommands(String commands, Robot robot) throws ConstraintException {
		for(char s: commands.toUpperCase().toCharArray()) {
			switch(s) {
			case 'M':
				robot.moveForward();
				break;
			case 'R':
				robot.turnRight();
				break;
			case 'L':
				robot.turnLeft();
				break;
			}
		}
	}

}
