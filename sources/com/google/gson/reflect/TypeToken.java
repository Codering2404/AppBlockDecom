package com.google.gson.reflect;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class TypeToken<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class f90542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Type f90543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f90544c;

    protected TypeToken() {
        Type typeE = e();
        this.f90543b = typeE;
        this.f90542a = C$Gson$Types.k(typeE);
        this.f90544c = typeE.hashCode();
    }

    public static TypeToken a(Class cls) {
        return new TypeToken(cls);
    }

    public static TypeToken b(Type type) {
        return new TypeToken(type);
    }

    private Type e() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            if (parameterizedType.getRawType() == TypeToken.class) {
                return C$Gson$Types.b(parameterizedType.getActualTypeArguments()[0]);
            }
        } else if (genericSuperclass == TypeToken.class) {
            throw new IllegalStateException("TypeToken must be created with a type argument: new TypeToken<...>() {}; When using code shrinkers (ProGuard, R8, ...) make sure that generic signatures are preserved.");
        }
        throw new IllegalStateException("Must only create direct subclasses of TypeToken");
    }

    public final Class c() {
        return this.f90542a;
    }

    public final Type d() {
        return this.f90543b;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof TypeToken) && C$Gson$Types.f(this.f90543b, ((TypeToken) obj).f90543b);
    }

    public final int hashCode() {
        return this.f90544c;
    }

    public final String toString() {
        return C$Gson$Types.t(this.f90543b);
    }

    private TypeToken(Type type) {
        Objects.requireNonNull(type);
        Type typeB = C$Gson$Types.b(type);
        this.f90543b = typeB;
        this.f90542a = C$Gson$Types.k(typeB);
        this.f90544c = typeB.hashCode();
    }
}
