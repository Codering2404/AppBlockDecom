package com.google.firebase.sessions;

import androidx.datastore.core.DataStore;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.settings.SessionsSettings;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class SharedSessionRepositoryImpl_Factory implements Factory<SharedSessionRepositoryImpl> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Provider f90109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Provider f90110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Provider f90111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Provider f90112d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Provider f90113e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Provider f90114f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Provider f90115g;

    public SharedSessionRepositoryImpl_Factory(Provider provider, Provider provider2, Provider provider3, Provider provider4, Provider provider5, Provider provider6, Provider provider7) {
        this.f90109a = provider;
        this.f90110b = provider2;
        this.f90111c = provider3;
        this.f90112d = provider4;
        this.f90113e = provider5;
        this.f90114f = provider6;
        this.f90115g = provider7;
    }

    public static SharedSessionRepositoryImpl_Factory a(Provider provider, Provider provider2, Provider provider3, Provider provider4, Provider provider5, Provider provider6, Provider provider7) {
        return new SharedSessionRepositoryImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static SharedSessionRepositoryImpl c(SessionsSettings sessionsSettings, SessionGenerator sessionGenerator, SessionFirelogPublisher sessionFirelogPublisher, TimeProvider timeProvider, DataStore dataStore, ProcessDataManager processDataManager, CoroutineContext coroutineContext) {
        return new SharedSessionRepositoryImpl(sessionsSettings, sessionGenerator, sessionFirelogPublisher, timeProvider, dataStore, processDataManager, coroutineContext);
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public SharedSessionRepositoryImpl get() {
        return c((SessionsSettings) this.f90109a.get(), (SessionGenerator) this.f90110b.get(), (SessionFirelogPublisher) this.f90111c.get(), (TimeProvider) this.f90112d.get(), (DataStore) this.f90113e.get(), (ProcessDataManager) this.f90114f.get(), (CoroutineContext) this.f90115g.get());
    }
}
