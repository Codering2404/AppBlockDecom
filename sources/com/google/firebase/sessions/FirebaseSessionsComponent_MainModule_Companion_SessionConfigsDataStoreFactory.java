package com.google.firebase.sessions;

import android.content.Context;
import androidx.datastore.core.DataStore;
import com.google.firebase.sessions.FirebaseSessionsComponent;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.Preconditions;
import com.google.firebase.sessions.settings.SessionConfigs;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class FirebaseSessionsComponent_MainModule_Companion_SessionConfigsDataStoreFactory implements Factory<DataStore<SessionConfigs>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Provider f89970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Provider f89971b;

    public FirebaseSessionsComponent_MainModule_Companion_SessionConfigsDataStoreFactory(Provider provider, Provider provider2) {
        this.f89970a = provider;
        this.f89971b = provider2;
    }

    public static FirebaseSessionsComponent_MainModule_Companion_SessionConfigsDataStoreFactory a(Provider provider, Provider provider2) {
        return new FirebaseSessionsComponent_MainModule_Companion_SessionConfigsDataStoreFactory(provider, provider2);
    }

    public static DataStore c(Context context, CoroutineContext coroutineContext) {
        return (DataStore) Preconditions.d(FirebaseSessionsComponent.MainModule.f89967a.i(context, coroutineContext));
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public DataStore get() {
        return c((Context) this.f89970a.get(), (CoroutineContext) this.f89971b.get());
    }
}
