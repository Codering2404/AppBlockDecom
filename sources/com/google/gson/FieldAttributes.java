package com.google.gson;

import java.lang.reflect.Field;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class FieldAttributes {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Field f90232a;

    public FieldAttributes(Field field) {
        Objects.requireNonNull(field);
        this.f90232a = field;
    }

    public String toString() {
        return this.f90232a.toString();
    }
}
