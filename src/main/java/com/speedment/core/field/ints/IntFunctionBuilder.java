/**
 *
 * Copyright (c) 2006-2015, Speedment, Inc. All Rights Reserved.
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
package com.speedment.core.field.ints;

import com.speedment.core.field.BaseFunction;
import com.speedment.core.field.FunctionBuilder;

import static java.util.Objects.requireNonNull;

/**
 *
 * @author pemi
 * @param <ENTITY> Entity type
 */
public class IntFunctionBuilder<ENTITY> extends BaseFunction<ENTITY> implements FunctionBuilder<ENTITY> {

    private final IntField<ENTITY> field;
    private final int newValue;

    public IntFunctionBuilder(
        final IntField<ENTITY> field,
        final int newValue
    ) {
        this.field    = requireNonNull(field);
        this.newValue = requireNonNull(newValue);
    }

    @Override
    public ENTITY apply(ENTITY entity) {
        return field.setIn(entity, newValue);
    }

    @Override
    public IntField<ENTITY> getField() {
        return field;
    }

    public int getValue() {
        return newValue;
    }
}