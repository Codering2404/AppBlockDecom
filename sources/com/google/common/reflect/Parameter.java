package com.google.common.reflect;

import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class Parameter implements AnnotatedElement {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Invokable f85546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f85547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TypeToken f85548c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ImmutableList f85549d;

    public boolean equals(Object obj) {
        if (obj instanceof Parameter) {
            Parameter parameter = (Parameter) obj;
            if (this.f85547b == parameter.f85547b && this.f85546a.equals(parameter.f85546a)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation getAnnotation(Class cls) {
        Preconditions.t(cls);
        UnmodifiableIterator it = this.f85549d.iterator();
        while (it.hasNext()) {
            Annotation annotation = (Annotation) it.next();
            if (cls.isInstance(annotation)) {
                return (Annotation) cls.cast(annotation);
            }
        }
        return null;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation[] getAnnotations() {
        return getDeclaredAnnotations();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation[] getAnnotationsByType(Class cls) {
        return getDeclaredAnnotationsByType(cls);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation getDeclaredAnnotation(Class cls) {
        Preconditions.t(cls);
        return (Annotation) FluentIterable.g(this.f85549d).e(cls).f().f();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation[] getDeclaredAnnotations() {
        return (Annotation[]) this.f85549d.toArray(new Annotation[0]);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation[] getDeclaredAnnotationsByType(Class cls) {
        return (Annotation[]) FluentIterable.g(this.f85549d).e(cls).l(cls);
    }

    public int hashCode() {
        return this.f85547b;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public boolean isAnnotationPresent(Class cls) {
        return getAnnotation(cls) != null;
    }

    public String toString() {
        return this.f85548c + " arg" + this.f85547b;
    }
}
