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
package com.speedment.runtime.field.predicate.trait;

import com.speedment.runtime.annotation.Api;
import com.speedment.runtime.field.trait.FieldTrait;

/**
 * A trait for predicates the implement the {@link #getField()} method.
 * 
 * @param <ENTITY>  the entity type
 * 
 * @author  Per Minborg
 * @since   2.2.0
 */
@Api(version = "3.0")
public interface HasFieldTrait<ENTITY> {

    /**
     * Returns the {@link FieldTrait} that was used to generate this predicate.
     * 
     * @return  the field
     */
    FieldTrait<ENTITY> getField();
}