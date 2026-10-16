package com.google.firebase.sessions;

import com.google.firebase.sessions.dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class SessionDataSerializer_Factory implements Factory<SessionDataSerializer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Provider f90017a;

    public SessionDataSerializer_Factory(Provider provider) {
        this.f90017a = provider;
    }

    public static SessionDataSerializer_Factory a(Provider provider) {
        return new SessionDataSerializer_Factory(provider);
    }

    public static SessionDataSerializer c(SessionGenerator sessionGenerator) {
        return new SessionDataSerializer(sessionGenerator);
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public SessionDataSerializer get() {
        return c((SessionGenerator) this.f90017a.get());
    }
}
