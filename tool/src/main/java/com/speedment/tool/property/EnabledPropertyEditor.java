/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.speedment.tool.property;

import com.speedment.runtime.config.trait.HasEnabled;
import com.speedment.tool.config.trait.HasEnabledProperty;
import java.util.stream.Stream;
import org.controlsfx.control.PropertySheet;

/**
 *
 * @author Simon
 * @param <T>  the document type
 */
public class EnabledPropertyEditor<T extends HasEnabledProperty> implements PropertyEditor<T>{

    @Override
    public Stream<PropertyEditor.Item> fieldsFor(T document) {
        return Stream.of(
            new SimpleBooleanItem(
                "Enabled", 
                document.enabledProperty()
            )
        );
    }

    @Override
    public String getPropertyKey() {
        return HasEnabled.ENABLED;
    }
    
}
