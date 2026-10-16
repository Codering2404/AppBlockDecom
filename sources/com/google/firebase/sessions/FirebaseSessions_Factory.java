package com.google.firebase.sessions;

import com.google.firebase.FirebaseApp;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.settings.SessionsSettings;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class FirebaseSessions_Factory implements Factory<FirebaseSessions> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Provider f89977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Provider f89978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Provider f89979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Provider f89980d;

    public FirebaseSessions_Factory(Provider provider, Provider provider2, Provider provider3, Provider provider4) {
        this.f89977a = provider;
        this.f89978b = provider2;
        this.f89979c = provider3;
        this.f89980d = provider4;
    }

    public static FirebaseSessions_Factory a(Provider provider, Provider provider2, Provider provider3, Provider provider4) {
        return new FirebaseSessions_Factory(provider, provider2, provider3, provider4);
    }

    public static FirebaseSessions c(FirebaseApp firebaseApp, SessionsSettings sessionsSettings, CoroutineContext coroutineContext, SessionsActivityLifecycleCallbacks sessionsActivityLifecycleCallbacks) {
        return new FirebaseSessions(firebaseApp, sessionsSettings, coroutineContext, sessionsActivityLifecycleCallbacks);
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FirebaseSessions get() {
        return c((FirebaseApp) this.f89977a.get(), (SessionsSettings) this.f89978b.get(), (CoroutineContext) this.f89979c.get(), (SessionsActivityLifecycleCallbacks) this.f89980d.get());
    }
}
