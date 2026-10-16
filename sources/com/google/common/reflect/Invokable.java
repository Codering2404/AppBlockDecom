package com.google.common.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class Invokable<T, R> implements AnnotatedElement, Member {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final boolean f85539c = b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AccessibleObject f85540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Member f85541b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ConstructorInvokable<T> extends Invokable<T, T> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Constructor f85542d;

        private boolean d() {
            Class<T> declaringClass = this.f85542d.getDeclaringClass();
            if (declaringClass.getEnclosingConstructor() != null) {
                return true;
            }
            return declaringClass.getEnclosingMethod() != null ? !Modifier.isStatic(r1.getModifiers()) : (declaringClass.getEnclosingClass() == null || Modifier.isStatic(declaringClass.getModifiers())) ? false : true;
        }

        Type[] c() {
            Type[] genericParameterTypes = this.f85542d.getGenericParameterTypes();
            if (genericParameterTypes.length <= 0 || !d()) {
                return genericParameterTypes;
            }
            Class<?>[] parameterTypes = this.f85542d.getParameterTypes();
            return (genericParameterTypes.length == parameterTypes.length && parameterTypes[0] == getDeclaringClass().getEnclosingClass()) ? (Type[]) Arrays.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length) : genericParameterTypes;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class MethodInvokable<T> extends Invokable<T, Object> {
    }

    private static boolean b() {
        try {
            Class.forName("java.lang.reflect.AnnotatedType");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public TypeToken a() {
        return TypeToken.n(getDeclaringClass());
    }

    public boolean equals(Object obj) {
        if (obj instanceof Invokable) {
            Invokable invokable = (Invokable) obj;
            if (a().equals(invokable.a()) && this.f85541b.equals(invokable.f85541b)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final Annotation getAnnotation(Class cls) {
        return this.f85540a.getAnnotation(cls);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final Annotation[] getAnnotations() {
        return this.f85540a.getAnnotations();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final Annotation[] getDeclaredAnnotations() {
        return this.f85540a.getDeclaredAnnotations();
    }

    @Override // java.lang.reflect.Member
    public final Class getDeclaringClass() {
        return this.f85541b.getDeclaringClass();
    }

    @Override // java.lang.reflect.Member
    public final int getModifiers() {
        return this.f85541b.getModifiers();
    }

    @Override // java.lang.reflect.Member
    public final String getName() {
        return this.f85541b.getName();
    }

    public int hashCode() {
        return this.f85541b.hashCode();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final boolean isAnnotationPresent(Class cls) {
        return this.f85540a.isAnnotationPresent(cls);
    }

    @Override // java.lang.reflect.Member
    public final boolean isSynthetic() {
        return this.f85541b.isSynthetic();
    }

    public String toString() {
        return this.f85541b.toString();
    }
}
