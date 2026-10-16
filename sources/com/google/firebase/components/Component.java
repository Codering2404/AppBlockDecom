package com.google.firebase.components;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class Component<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f88090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set f88091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set f88092c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f88093d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f88094e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ComponentFactory f88095f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Set f88096g;

    public static Builder c(Qualified qualified) {
        return new Builder(qualified, new Qualified[0]);
    }

    public static Builder d(Qualified qualified, Qualified... qualifiedArr) {
        return new Builder(qualified, qualifiedArr);
    }

    public static Builder e(Class cls) {
        return new Builder(cls, new Class[0]);
    }

    public static Builder f(Class cls, Class... clsArr) {
        return new Builder(cls, clsArr);
    }

    public static Component l(final Object obj, Class cls) {
        return m(cls).f(new ComponentFactory() { // from class: com.google.firebase.components.a
            @Override // com.google.firebase.components.ComponentFactory
            public final Object a(ComponentContainer componentContainer) {
                return Component.b(obj, componentContainer);
            }
        }).d();
    }

    public static Builder m(Class cls) {
        return e(cls).g();
    }

    public static Component q(final Object obj, Class cls, Class... clsArr) {
        return f(cls, clsArr).f(new ComponentFactory() { // from class: com.google.firebase.components.b
            @Override // com.google.firebase.components.ComponentFactory
            public final Object a(ComponentContainer componentContainer) {
                return Component.a(obj, componentContainer);
            }
        }).d();
    }

    public Set g() {
        return this.f88092c;
    }

    public ComponentFactory h() {
        return this.f88095f;
    }

    public String i() {
        return this.f88090a;
    }

    public Set j() {
        return this.f88091b;
    }

    public Set k() {
        return this.f88096g;
    }

    public boolean n() {
        return this.f88093d == 1;
    }

    public boolean o() {
        return this.f88093d == 2;
    }

    public boolean p() {
        return this.f88094e == 0;
    }

    public Component r(ComponentFactory componentFactory) {
        return new Component(this.f88090a, this.f88091b, this.f88092c, this.f88093d, this.f88094e, componentFactory, this.f88096g);
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.f88091b.toArray()) + ">{" + this.f88093d + ", type=" + this.f88094e + ", deps=" + Arrays.toString(this.f88092c.toArray()) + "}";
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f88097a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Set f88098b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Set f88099c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f88100d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f88101e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private ComponentFactory f88102f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Set f88103g;

        /* JADX INFO: Access modifiers changed from: private */
        public Builder g() {
            this.f88101e = 1;
            return this;
        }

        private Builder i(int i3) {
            Preconditions.d(this.f88100d == 0, "Instantiation type has already been set.");
            this.f88100d = i3;
            return this;
        }

        private void j(Qualified qualified) {
            Preconditions.a(!this.f88098b.contains(qualified), "Components are not allowed to depend on interfaces they themselves provide.");
        }

        public Builder b(Dependency dependency) {
            Preconditions.c(dependency, "Null dependency");
            j(dependency.c());
            this.f88099c.add(dependency);
            return this;
        }

        public Builder c() {
            return i(1);
        }

        public Component d() {
            Preconditions.d(this.f88102f != null, "Missing required property: factory.");
            return new Component(this.f88097a, new HashSet(this.f88098b), new HashSet(this.f88099c), this.f88100d, this.f88101e, this.f88102f, this.f88103g);
        }

        public Builder e() {
            return i(2);
        }

        public Builder f(ComponentFactory componentFactory) {
            this.f88102f = (ComponentFactory) Preconditions.c(componentFactory, "Null factory");
            return this;
        }

        public Builder h(String str) {
            this.f88097a = str;
            return this;
        }

        private Builder(Class cls, Class... clsArr) {
            this.f88097a = null;
            HashSet hashSet = new HashSet();
            this.f88098b = hashSet;
            this.f88099c = new HashSet();
            this.f88100d = 0;
            this.f88101e = 0;
            this.f88103g = new HashSet();
            Preconditions.c(cls, "Null interface");
            hashSet.add(Qualified.b(cls));
            for (Class cls2 : clsArr) {
                Preconditions.c(cls2, "Null interface");
                this.f88098b.add(Qualified.b(cls2));
            }
        }

        private Builder(Qualified qualified, Qualified... qualifiedArr) {
            this.f88097a = null;
            HashSet hashSet = new HashSet();
            this.f88098b = hashSet;
            this.f88099c = new HashSet();
            this.f88100d = 0;
            this.f88101e = 0;
            this.f88103g = new HashSet();
            Preconditions.c(qualified, "Null interface");
            hashSet.add(qualified);
            for (Qualified qualified2 : qualifiedArr) {
                Preconditions.c(qualified2, "Null interface");
            }
            Collections.addAll(this.f88098b, qualifiedArr);
        }
    }

    private Component(String str, Set set, Set set2, int i3, int i4, ComponentFactory componentFactory, Set set3) {
        this.f88090a = str;
        this.f88091b = Collections.unmodifiableSet(set);
        this.f88092c = Collections.unmodifiableSet(set2);
        this.f88093d = i3;
        this.f88094e = i4;
        this.f88095f = componentFactory;
        this.f88096g = Collections.unmodifiableSet(set3);
    }

    public static /* synthetic */ Object a(Object obj, ComponentContainer componentContainer) {
        return obj;
    }

    public static /* synthetic */ Object b(Object obj, ComponentContainer componentContainer) {
        return obj;
    }
}
