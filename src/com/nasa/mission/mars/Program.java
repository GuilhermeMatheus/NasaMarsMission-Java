package com.nasa.mission.mars;

import java.io.IOException;
import java.util.Scanner;

import com.nasa.mission.mars.constraints.ConstraintException;
import com.nasa.mission.mars.model.Direction;
import com.nasa.mission.mars.model.Position;
import com.nasa.mission.mars.model.Robot;

public class Program {

	private static Scanner scanner;
	
	public static void main(String[] args) throws ConstraintException {
		scanner = new Scanner(System.in);
		Position robotBoundary = new Position(scanner.nextInt(), scanner.nextInt()); 
		
		while (scanner.hasNextInt()) {
			Robot robot = nextOnLandRobot(robotBoundary);
			String commands = scanner.next();
			executeCommands(commands, robot);
			
			System.out.println(robot.getDisplayPosition());
		}
	}
	
	private static Robot nextOnLandRobot(Position robotBoundary) throws ConstraintException {
		Robot robot;
		Position landingPosition = new Position(scanner.nextInt(), scanner.nextInt());
		Direction landingDirection = Direction.North;
		String landingDirectionChar = scanner.next();
		
		switch(landingDirectionChar.charAt(0)) {
		case 'N':
			landingDirection = Direction.North;
			break;
		case 'S':
			landingDirection = Direction.South;
			break;
		case 'W':
			landingDirection = Direction.West;
			break;
		case 'E':
			landingDirection = Direction.East;
			break;
		}
		
		robot = new Robot(1, "", "", robotBoundary);
		robot.putOnOrbit();
		robot.putOnLand(landingPosition, landingDirection);
		return robot;
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
