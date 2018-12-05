package com.igor.khorev.qa.annotation;

import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by metttalist on 8/24/18.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Lazy
@Component
@Conditional(BeanDoesNotExistCondition.class)
public @interface TestComponent {
        String value() default "core";
}
