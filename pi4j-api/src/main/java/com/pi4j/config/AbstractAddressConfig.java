package com.pi4j.config;

/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: LIBRARY  :: Java Library (API)
 * FILENAME      :  AbstractAddressConfig.java
 *
 * This file is part of the Pi4J project. More information about
 * this project can be found here:  https://pi4j.com/
 * **********************************************************************
 * %%
 * Copyright (C) 2012 - 2019 Pi4J
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

import com.pi4j.config.exception.ConfigMissingRequiredKeyException;

import java.util.Properties;

public abstract class AbstractAddressConfig<CONFIG_TYPE extends Config>
        extends AbstractNameConfig<CONFIG_TYPE>
        implements AddressConfig<CONFIG_TYPE> {

    private int address;

    public AbstractAddressConfig(){
        this.address(0);
    }
    public AbstractAddressConfig(int address){
        this.address = address;
    }

    public int address() { return this.address; };
    public CONFIG_TYPE address(int address) { this.address = address; return (CONFIG_TYPE)this; }

    @Override
    public CONFIG_TYPE load(Properties properties, String prefix){

        // ensure properties is not empty
        super.load(properties, prefix);

        // ensure required configuration properties are present
        if(!properties.containsKey(prefix + ".address"))
            throw new ConfigMissingRequiredKeyException(prefix + ".address");

        // set address property
        int address = Integer.parseInt(properties.get(prefix + ".address").toString());
        this.address(address);

        return (CONFIG_TYPE) this;
    }
}
