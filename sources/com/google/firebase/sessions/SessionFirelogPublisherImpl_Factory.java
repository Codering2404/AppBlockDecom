package com.google.firebase.sessions;

import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.settings.SessionsSettings;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class SessionFirelogPublisherImpl_Factory implements Factory<SessionFirelogPublisherImpl> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Provider f90049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Provider f90050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Provider f90051c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Provider f90052d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Provider f90053e;

    public SessionFirelogPublisherImpl_Factory(Provider provider, Provider provider2, Provider provider3, Provider provider4, Provider provider5) {
        this.f90049a = provider;
        this.f90050b = provider2;
        this.f90051c = provider3;
        this.f90052d = provider4;
        this.f90053e = provider5;
    }

    public static SessionFirelogPublisherImpl_Factory a(Provider provider, Provider provider2, Provider provider3, Provider provider4, Provider provider5) {
        return new SessionFirelogPublisherImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static SessionFirelogPublisherImpl c(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, SessionsSettings sessionsSettings, EventGDTLoggerInterface eventGDTLoggerInterface, CoroutineContext coroutineContext) {
        return new SessionFirelogPublisherImpl(firebaseApp, firebaseInstallationsApi, sessionsSettings, eventGDTLoggerInterface, coroutineContext);
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public SessionFirelogPublisherImpl get() {
        return c((FirebaseApp) this.f90049a.get(), (FirebaseInstallationsApi) this.f90050b.get(), (SessionsSettings) this.f90051c.get(), (EventGDTLoggerInterface) this.f90052d.get(), (CoroutineContext) this.f90053e.get());
    }
}
