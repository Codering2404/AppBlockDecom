package com.google.firebase.sessions;

import com.google.firebase.sessions.dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class SessionsActivityLifecycleCallbacks_Factory implements Factory<SessionsActivityLifecycleCallbacks> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Provider f90067a;

    public SessionsActivityLifecycleCallbacks_Factory(Provider provider) {
        this.f90067a = provider;
    }

    public static SessionsActivityLifecycleCallbacks_Factory a(Provider provider) {
        return new SessionsActivityLifecycleCallbacks_Factory(provider);
    }

    public static SessionsActivityLifecycleCallbacks c(SharedSessionRepository sharedSessionRepository) {
        return new SessionsActivityLifecycleCallbacks(sharedSessionRepository);
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public SessionsActivityLifecycleCallbacks get() {
        return c((SharedSessionRepository) this.f90067a.get());
    }
}
