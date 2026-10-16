package com.google.common.reflect;

import java.lang.reflect.TypeVariable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class TypeParameter<T> extends TypeCapture<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final TypeVariable f85550a;

    public final boolean equals(Object obj) {
        if (obj instanceof TypeParameter) {
            return this.f85550a.equals(((TypeParameter) obj).f85550a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f85550a.hashCode();
    }

    public String toString() {
        return this.f85550a.toString();
    }
}
