package tech.hobbs.mallparkingmanagementsystem.utils.exceptions;

import java.util.Objects;
import java.util.function.Supplier;

public class ExceptionUtils {

    public static void requireNonNull(Object obj, Supplier<? extends RuntimeException> exceptionSupplier) {
        if (Objects.isNull(obj)) {
            throw exceptionSupplier.get();
        }
    }

}
