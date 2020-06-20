package com.pi4j.io.gpio;

import java.util.EnumSet;

/*
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: Java Library (Core)
 * FILENAME      :  PinState.java
 *
 * This file is part of the Pi4J project. More information about
 * this project can be found here:  https://pi4j.com/
 * **********************************************************************
 * %%
 * Copyright (C) 2012 - 2020 Pi4J
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

/**
 * Pin edge definition.
 *
 * @author Robert Savage (<a
 *         href="http://www.savagehomeautomation.com">http://www.savagehomeautomation.com</a>)
 */
@SuppressWarnings("unused")
public enum PinState {

    LOW(0, "LOW"),
    HIGH(1, "HIGH");

    private final int value;
    private final String name;

    private PinState(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public boolean isHigh() {
        return (this == HIGH);
    }

    public boolean isLow() {
        return (this == LOW);
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static PinState getState(int state) {
        for (PinState item : PinState.values()) {
            if (item.getValue() == state) {
                return item;
            }
        }
        return null;
    }

    public static PinState getInverseState(PinState state) {
        return (state == HIGH ? LOW : HIGH);
    }

    public static PinState getState(boolean state) {
        return (state ? PinState.HIGH : PinState.LOW);
    }

    public static PinState[] allStates() {
        return PinState.values();
    }

    public static EnumSet<PinState> all() {
        return EnumSet.of(PinState.HIGH, PinState.LOW);
    }
}
