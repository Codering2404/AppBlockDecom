package com.google.firebase.sessions;

import com.google.firebase.sessions.dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class SessionGenerator_Factory implements Factory<SessionGenerator> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Provider f90056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Provider f90057b;

    public SessionGenerator_Factory(Provider provider, Provider provider2) {
        this.f90056a = provider;
        this.f90057b = provider2;
    }

    public static SessionGenerator_Factory a(Provider provider, Provider provider2) {
        return new SessionGenerator_Factory(provider, provider2);
    }

    public static SessionGenerator c(TimeProvider timeProvider, UuidGenerator uuidGenerator) {
        return new SessionGenerator(timeProvider, uuidGenerator);
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public SessionGenerator get() {
        return c((TimeProvider) this.f90056a.get(), (UuidGenerator) this.f90057b.get());
    }
}
