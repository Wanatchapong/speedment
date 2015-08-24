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
package com.speedment.core.field.reference;

import com.speedment.core.config.model.Column;
import com.speedment.core.field.StandardBinaryOperator;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * This class represents a Comparable Reference Field. A Reference Field is
 * something that extends {@link Comparable}.
 *
 * @author pemi
 * @param <ENTITY> The entity type
 * @param <V> The value type
 */
public class ComparableReferenceField<ENTITY, V extends Comparable<? super V>> extends ReferenceField<ENTITY, V> {

    public ComparableReferenceField(Supplier<Column> columnSupplier, Function<ENTITY, V> getter, BiFunction<ENTITY, V, ENTITY> setter) {
        super(columnSupplier, getter, setter);
    }

    /**
     * Returns a {@link java.util.function.Predicate} that will evaluate to
     * {@code true}, if and only if this Field is <em>equal</em> to the given
     * value.
     *
     * @param value to compare
     * @return a Predicate that will evaluate to {@code true}, if and only if
     * this Field is <em>equal</em> to the given value
     */
    public ReferenceBinaryPredicateBuilder<ENTITY, V> equal(V value) {
        return newBinary(value, StandardBinaryOperator.EQUAL);
    }

    /**
     * Returns a {@link java.util.function.Predicate} that will evaluate to
     * {@code true}, if and only if this Field is <em>not equal</em> to the
     * given value.
     *
     * @param value to compare
     * @return a Predicate that will evaluate to {@code true}, if and only if
     * this Field is <em>not equal</em> to the given value
     */
    public ReferenceBinaryPredicateBuilder<ENTITY, V> notEqual(V value) {
        return newBinary(value, StandardBinaryOperator.NOT_EQUAL);
    }

    /**
     * Returns a {@link java.util.function.Predicate} that will evaluate to
     * {@code true}, if and only if this Field is <em>less than</em> the given
     * value.
     *
     * @param value to compare
     * @return a Predicate that will evaluate to {@code true}, if and only if
     * this Field is <em>less than</em> the given value
     */
    public ReferenceBinaryPredicateBuilder<ENTITY, V> lessThan(V value) {
        return newBinary(value, StandardBinaryOperator.LESS_THAN);
    }

    /**
     * Returns a {@link java.util.function.Predicate} that will evaluate to
     * {@code true}, if and only if this Field is <em>less than or equal</em>
     * to the given value.
     *
     * @param value to compare
     * @return a Predicate that will evaluate to {@code true}, if and only if
     * this Field is <em>less than or equal</em> to the given value
     */
    public ReferenceBinaryPredicateBuilder<ENTITY, V> lessOrEqual(V value) {
        return newBinary(value, StandardBinaryOperator.LESS_OR_EQUAL);
    }

    /**
     * Returns a {@link java.util.function.Predicate} that will evaluate to
     * {@code true}, if and only if this Field is <em>greater than</em>
     * the given value.
     *
     * @param value to compare
     * @return a Predicate that will evaluate to {@code true}, if and only if
     * this Field is <em>greater than</em> the given value
     */
    public ReferenceBinaryPredicateBuilder<ENTITY, V> greaterThan(V value) {
        return newBinary(value, StandardBinaryOperator.GREATER_THAN);
    }

    /**
     * Returns a {@link java.util.function.Predicate} that will evaluate to
     * {@code true}, if and only if this Field is <em>greater than or equal</em>
     * to the given value.
     *
     * @param value to compare
     * @return a Predicate that will evaluate to {@code true}, if and only if
     * this Field is <em>greater than or equal</em> to the given value
     */
    public ReferenceBinaryPredicateBuilder<ENTITY, V> greaterOrEqual(V value) {
        return newBinary(value, StandardBinaryOperator.GREATER_OR_EQUAL);
    }

    protected ReferenceBinaryPredicateBuilder<ENTITY, V> newBinary(V value, StandardBinaryOperator binaryOperator) {
        return new ReferenceBinaryPredicateBuilder<>(this, value, binaryOperator);
    }

}
