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
package com.speedment.runtime.internal.field.predicate.impl.longs;

import com.speedment.common.tuple.Tuple1;
import com.speedment.runtime.internal.field.predicate.AbstractFieldPredicate;

import java.util.Set;

import static com.speedment.runtime.field.predicate.PredicateType.IN;
import com.speedment.runtime.field.trait.LongFieldTrait;
import static java.util.Objects.requireNonNull;

/**
 *
 * @param <ENTITY>  the entity type
 * @param <D>       the database type
 * @param <V>       the value type
 * 
 * @author  Per Minborg
 * @since   2.2.0
 */
public final class LongInPredicate<ENTITY, D>
        extends AbstractFieldPredicate<ENTITY, LongFieldTrait<ENTITY, D>>
        implements Tuple1<Set<Long>> {

    private final Set<Long> set;

    public LongInPredicate(LongFieldTrait<ENTITY, D> field, Set<Long> values) {
        super(IN, field, entity -> values.contains(field.getAsLong(entity)));
        this.set = requireNonNull(values);
    }

    @Override
    public Set<Long> get0() {
        return set;
    }
}