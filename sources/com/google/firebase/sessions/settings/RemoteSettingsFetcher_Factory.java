package com.google.firebase.sessions.settings;

import com.google.firebase.sessions.ApplicationInfo;
import com.google.firebase.sessions.dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class RemoteSettingsFetcher_Factory implements Factory<RemoteSettingsFetcher> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Provider f90187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Provider f90188b;

    public RemoteSettingsFetcher_Factory(Provider provider, Provider provider2) {
        this.f90187a = provider;
        this.f90188b = provider2;
    }

    public static RemoteSettingsFetcher_Factory a(Provider provider, Provider provider2) {
        return new RemoteSettingsFetcher_Factory(provider, provider2);
    }

    public static RemoteSettingsFetcher c(ApplicationInfo applicationInfo, CoroutineContext coroutineContext) {
        return new RemoteSettingsFetcher(applicationInfo, coroutineContext);
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RemoteSettingsFetcher get() {
        return c((ApplicationInfo) this.f90187a.get(), (CoroutineContext) this.f90188b.get());
    }
}
