package com.google.firebase.sessions.settings;

import androidx.datastore.core.DataStore;
import com.google.firebase.sessions.TimeProvider;
import com.google.firebase.sessions.dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class SettingsCacheImpl_Factory implements Factory<SettingsCacheImpl> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Provider f90229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Provider f90230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Provider f90231c;

    public SettingsCacheImpl_Factory(Provider provider, Provider provider2, Provider provider3) {
        this.f90229a = provider;
        this.f90230b = provider2;
        this.f90231c = provider3;
    }

    public static SettingsCacheImpl_Factory a(Provider provider, Provider provider2, Provider provider3) {
        return new SettingsCacheImpl_Factory(provider, provider2, provider3);
    }

    public static SettingsCacheImpl c(CoroutineContext coroutineContext, TimeProvider timeProvider, DataStore dataStore) {
        return new SettingsCacheImpl(coroutineContext, timeProvider, dataStore);
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public SettingsCacheImpl get() {
        return c((CoroutineContext) this.f90229a.get(), (TimeProvider) this.f90230b.get(), (DataStore) this.f90231c.get());
    }
}
