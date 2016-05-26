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
package com.speedment.common.codegen.model;

import com.speedment.common.codegen.internal.model.AnnotationImpl;
import com.speedment.common.codegen.model.modifier.AnnotationModifier;
import com.speedment.common.codegen.model.trait.HasAnnotationUsage;
import com.speedment.common.codegen.model.trait.HasCopy;
import com.speedment.common.codegen.model.trait.HasFields;
import com.speedment.common.codegen.model.trait.HasImports;
import com.speedment.common.codegen.model.trait.HasJavadoc;
import com.speedment.common.codegen.model.trait.HasName;

/**
 * A model that represents an annotation in code.
 *
 * @author Emil Forslund
 * @see AnnotationUsage
 * @since   2.0
 */
public interface Annotation extends HasCopy<Annotation>, HasName<Annotation>,
    HasJavadoc<Annotation>, HasFields<Annotation>, HasImports<Annotation>,
    AnnotationModifier<Annotation>, HasAnnotationUsage<Annotation> {

    /**
     * Creates a new instance implementing this interface using the default
     * implementation.
     *
     * @param name the name
     * @return the new instance
     */
    static Annotation of(String name) {
        return new AnnotationImpl(name);
    }
}
