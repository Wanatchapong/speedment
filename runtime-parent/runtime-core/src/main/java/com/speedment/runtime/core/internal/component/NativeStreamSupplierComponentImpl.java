/**
 *
 * Copyright (c) 2006-2016, Speedment, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); You may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.speedment.runtime.core.internal.component;

import com.speedment.common.injector.annotation.Inject;
import com.speedment.runtime.core.component.ManagerComponent;
import com.speedment.runtime.core.component.StreamSupplierComponent;
import com.speedment.runtime.core.stream.StreamDecorator;

import java.util.stream.Stream;

/**
 *
 * @author Per Minborg
 */
public class NativeStreamSupplierComponentImpl implements StreamSupplierComponent {

    private @Inject ManagerComponent managerComponent;

    @Override
    public <ENTITY> Stream<ENTITY> stream(Class<ENTITY> entityClass, StreamDecorator decorator) {
        return managerComponent.managerOf(entityClass).stream(); // TODO use decorator
    }

    @Override
    public void start() {
        // Do nothing.
    }

    @Override
    public void stop() {
        // Do nothing.
    }
}