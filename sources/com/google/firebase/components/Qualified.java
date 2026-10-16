package com.google.firebase.components;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class Qualified<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class f88142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class f88143b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private @interface Unqualified {
    }

    public Qualified(Class cls, Class cls2) {
        this.f88142a = cls;
        this.f88143b = cls2;
    }

    public static Qualified a(Class cls, Class cls2) {
        return new Qualified(cls, cls2);
    }

    public static Qualified b(Class cls) {
        return new Qualified(Unqualified.class, cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Qualified.class != obj.getClass()) {
            return false;
        }
        Qualified qualified = (Qualified) obj;
        if (this.f88143b.equals(qualified.f88143b)) {
            return this.f88142a.equals(qualified.f88142a);
        }
        return false;
    }

    public int hashCode() {
        return (this.f88143b.hashCode() * 31) + this.f88142a.hashCode();
    }

    public String toString() {
        if (this.f88142a == Unqualified.class) {
            return this.f88143b.getName();
        }
        return "@" + this.f88142a.getName() + " " + this.f88143b.getName();
    }
}
