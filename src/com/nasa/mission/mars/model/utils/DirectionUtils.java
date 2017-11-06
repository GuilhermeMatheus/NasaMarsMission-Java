package com.nasa.mission.mars.model.utils;

import com.nasa.mission.mars.model.Direction;

/*
 * Não encontrei uma forma segura de implementar esta 
 * classe de forma semelhante a como fazemos em c#:
 * https://github.com/GuilhermeMatheus/NasaMarsMission-WebAPI/blob/master/src/Nasa.Mission.Mars.Entity/Utils/DirectionUtils.cs
 */
public class DirectionUtils
{
    public static Direction Right(Direction direction) {
    	switch(direction) {
		case East:
			return Direction.South;
		case North:
			return Direction.East;
		case South:
			return Direction.West;
		case West:
			return Direction.North;
    	}
    	throw new IllegalStateException();
    }

    public static Direction Left(Direction direction) {
    	switch(direction) {
		case East:
			return Direction.North;
		case North:
			return Direction.West;
		case South:
			return Direction.East;
		case West:
			return Direction.South;
    	}
    	throw new IllegalStateException();
    }
}
