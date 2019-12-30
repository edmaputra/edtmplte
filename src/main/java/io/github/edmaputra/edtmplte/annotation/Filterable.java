package io.github.edmaputra.edtmplte.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Filterable {

    String fieldType() default "string";
}
