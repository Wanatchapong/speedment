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

import com.speedment.core.config.model.Column;
import com.speedment.core.field.Field;
import com.speedment.core.field.StandardBinaryOperator;
import com.speedment.core.field.StandardUnaryOperator;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

import static java.util.Objects.requireNonNull;

/**
 * This class represents an {@code int} Field.
 *
 * @author pemi
 * @param <ENTITY> The entity field
 */
public class IntField<ENTITY> implements Field<ENTITY> {

    private final Supplier<Column> columnSupplier;
    private final ToIntFunction<ENTITY> getter;
    private final IntSetter<ENTITY> setter;

    public IntField(Supplier<Column> columnSupplier, ToIntFunction<ENTITY> getter, IntSetter<ENTITY> setter) {
        this.getter         = requireNonNull(getter);
        this.setter         = requireNonNull(setter);
        this.columnSupplier = requireNonNull(columnSupplier);
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
    public IntBinaryPredicateBuilder<ENTITY> equal(int value) {
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
    public IntBinaryPredicateBuilder<ENTITY> notEqual(int value) {
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
    public IntBinaryPredicateBuilder<ENTITY> lessThan(int value) {
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
    public IntBinaryPredicateBuilder<ENTITY> lessOrEqual(int value) {
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
    public IntBinaryPredicateBuilder<ENTITY> greaterThan(int value) {
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
    public IntBinaryPredicateBuilder<ENTITY> greaterOrEqual(int value) {
        return newBinary(value, StandardBinaryOperator.GREATER_OR_EQUAL);
    }

    public IntFunctionBuilder<ENTITY> set(int value) {
        return new IntFunctionBuilder<>(this, value);
    }

    @Override
    public boolean isNullIn(ENTITY entity) {
        return false;
    }

    public int getFrom(ENTITY entity) {
        return getter.applyAsInt(entity);
    }

    public ENTITY setIn(ENTITY entity, int value) {
        return setter.applyAsInt(entity, value);
    }

    @Override
    public Column getColumn() {
        return columnSupplier.get();
    }

    protected IntBinaryPredicateBuilder<ENTITY> newBinary(int value, StandardBinaryOperator binaryOperator) {
        return new IntBinaryPredicateBuilder<>(this, value, binaryOperator);
    }

    protected IntUnaryPredicateBuilder<ENTITY> newUnary(StandardUnaryOperator unaryOperator) {
        return new IntUnaryPredicateBuilder<>(this, unaryOperator);
    }

}
