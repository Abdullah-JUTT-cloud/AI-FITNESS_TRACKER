package com.activityService.models;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum ActivityType {
    RUNNING,
    WALKING,
    CYCLING,
    STRETCHING,
    WEIGHT_EXERCISES,
    SWIMMING,
    CARDIO,
    OTHER;

    @JsonCreator
    public static ActivityType from(String value) {
        if (value == null) return null;
        try {
            return ActivityType.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            return OTHER;
        }
    }
}