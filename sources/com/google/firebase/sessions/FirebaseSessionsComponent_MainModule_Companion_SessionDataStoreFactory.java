package com.google.firebase.sessions;

import android.content.Context;
import androidx.datastore.core.DataStore;
import com.google.firebase.sessions.FirebaseSessionsComponent;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class FirebaseSessionsComponent_MainModule_Companion_SessionDataStoreFactory implements Factory<DataStore<SessionData>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Provider f89972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Provider f89973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Provider f89974c;

    public FirebaseSessionsComponent_MainModule_Companion_SessionDataStoreFactory(Provider provider, Provider provider2, Provider provider3) {
        this.f89972a = provider;
        this.f89973b = provider2;
        this.f89974c = provider3;
    }

    public static FirebaseSessionsComponent_MainModule_Companion_SessionDataStoreFactory a(Provider provider, Provider provider2, Provider provider3) {
        return new FirebaseSessionsComponent_MainModule_Companion_SessionDataStoreFactory(provider, provider2, provider3);
    }

    public static DataStore c(Context context, CoroutineContext coroutineContext, SessionDataSerializer sessionDataSerializer) {
        return (DataStore) Preconditions.d(FirebaseSessionsComponent.MainModule.f89967a.l(context, coroutineContext, sessionDataSerializer));
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public DataStore get() {
        return c((Context) this.f89972a.get(), (CoroutineContext) this.f89973b.get(), (SessionDataSerializer) this.f89974c.get());
    }
}
