package com.google.firebase.components;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class Dependency {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Qualified f88126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f88127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f88128c;

    private Dependency(Class cls, int i3, int i4) {
        this(Qualified.b(cls), i3, i4);
    }

    public static Dependency a(Class cls) {
        return new Dependency(cls, 0, 2);
    }

    private static String b(int i3) {
        if (i3 == 0) {
            return "direct";
        }
        if (i3 == 1) {
            return "provider";
        }
        if (i3 == 2) {
            return "deferred";
        }
        throw new AssertionError("Unsupported injection: " + i3);
    }

    public static Dependency h(Class cls) {
        return new Dependency(cls, 0, 0);
    }

    public static Dependency i(Qualified qualified) {
        return new Dependency(qualified, 0, 1);
    }

    public static Dependency j(Class cls) {
        return new Dependency(cls, 0, 1);
    }

    public static Dependency k(Qualified qualified) {
        return new Dependency(qualified, 1, 0);
    }

    public static Dependency l(Class cls) {
        return new Dependency(cls, 1, 0);
    }

    public static Dependency m(Qualified qualified) {
        return new Dependency(qualified, 1, 1);
    }

    public static Dependency n(Class cls) {
        return new Dependency(cls, 1, 1);
    }

    public static Dependency o(Class cls) {
        return new Dependency(cls, 2, 0);
    }

    public Qualified c() {
        return this.f88126a;
    }

    public boolean d() {
        return this.f88128c == 2;
    }

    public boolean e() {
        return this.f88128c == 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Dependency) {
            Dependency dependency = (Dependency) obj;
            if (this.f88126a.equals(dependency.f88126a) && this.f88127b == dependency.f88127b && this.f88128c == dependency.f88128c) {
                return true;
            }
        }
        return false;
    }

    public boolean f() {
        return this.f88127b == 1;
    }

    public boolean g() {
        return this.f88127b == 2;
    }

    public int hashCode() {
        return ((((this.f88126a.hashCode() ^ 1000003) * 1000003) ^ this.f88127b) * 1000003) ^ this.f88128c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.f88126a);
        sb.append(", type=");
        int i3 = this.f88127b;
        sb.append(i3 == 1 ? "required" : i3 == 0 ? "optional" : "set");
        sb.append(", injection=");
        sb.append(b(this.f88128c));
        sb.append("}");
        return sb.toString();
    }

    private Dependency(Qualified qualified, int i3, int i4) {
        this.f88126a = (Qualified) Preconditions.c(qualified, "Null dependency anInterface.");
        this.f88127b = i3;
        this.f88128c = i4;
    }
}
