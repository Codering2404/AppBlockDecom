package com.google.firebase.components;

import com.google.firebase.events.Publisher;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class RestrictedComponentContainer implements ComponentContainer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set f88144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set f88145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set f88146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set f88147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set f88148e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Set f88149f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ComponentContainer f88150g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class RestrictedPublisher implements Publisher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Set f88151a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Publisher f88152b;

        public RestrictedPublisher(Set set, Publisher publisher) {
            this.f88151a = set;
            this.f88152b = publisher;
        }
    }

    RestrictedComponentContainer(Component component, ComponentContainer componentContainer) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        for (Dependency dependency : component.g()) {
            if (dependency.e()) {
                if (dependency.g()) {
                    hashSet4.add(dependency.c());
                } else {
                    hashSet.add(dependency.c());
                }
            } else if (dependency.d()) {
                hashSet3.add(dependency.c());
            } else if (dependency.g()) {
                hashSet5.add(dependency.c());
            } else {
                hashSet2.add(dependency.c());
            }
        }
        if (!component.k().isEmpty()) {
            hashSet.add(Qualified.b(Publisher.class));
        }
        this.f88144a = Collections.unmodifiableSet(hashSet);
        this.f88145b = Collections.unmodifiableSet(hashSet2);
        this.f88146c = Collections.unmodifiableSet(hashSet3);
        this.f88147d = Collections.unmodifiableSet(hashSet4);
        this.f88148e = Collections.unmodifiableSet(hashSet5);
        this.f88149f = component.k();
        this.f88150g = componentContainer;
    }

    @Override // com.google.firebase.components.ComponentContainer
    public Object a(Class cls) {
        if (!this.f88144a.contains(Qualified.b(cls))) {
            throw new DependencyException(String.format("Attempting to request an undeclared dependency %s.", cls));
        }
        Object objA = this.f88150g.a(cls);
        return !cls.equals(Publisher.class) ? objA : new RestrictedPublisher(this.f88149f, (Publisher) objA);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public Provider b(Qualified qualified) {
        if (this.f88145b.contains(qualified)) {
            return this.f88150g.b(qualified);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Provider<%s>.", qualified));
    }

    @Override // com.google.firebase.components.ComponentContainer
    public Set c(Qualified qualified) {
        if (this.f88147d.contains(qualified)) {
            return this.f88150g.c(qualified);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Set<%s>.", qualified));
    }

    @Override // com.google.firebase.components.ComponentContainer
    public Provider d(Qualified qualified) {
        if (this.f88148e.contains(qualified)) {
            return this.f88150g.d(qualified);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", qualified));
    }

    @Override // com.google.firebase.components.ComponentContainer
    public Object e(Qualified qualified) {
        if (this.f88144a.contains(qualified)) {
            return this.f88150g.e(qualified);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency %s.", qualified));
    }

    @Override // com.google.firebase.components.ComponentContainer
    public Provider g(Class cls) {
        return b(Qualified.b(cls));
    }

    @Override // com.google.firebase.components.ComponentContainer
    public Deferred h(Qualified qualified) {
        if (this.f88146c.contains(qualified)) {
            return this.f88150g.h(qualified);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Deferred<%s>.", qualified));
    }

    @Override // com.google.firebase.components.ComponentContainer
    public Deferred i(Class cls) {
        return h(Qualified.b(cls));
    }
}
