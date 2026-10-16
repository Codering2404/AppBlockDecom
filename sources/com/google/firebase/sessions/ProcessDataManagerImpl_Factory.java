package com.google.firebase.sessions;

import android.content.Context;
import com.google.firebase.sessions.dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class ProcessDataManagerImpl_Factory implements Factory<ProcessDataManagerImpl> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Provider f90004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Provider f90005b;

    public ProcessDataManagerImpl_Factory(Provider provider, Provider provider2) {
        this.f90004a = provider;
        this.f90005b = provider2;
    }

    public static ProcessDataManagerImpl_Factory a(Provider provider, Provider provider2) {
        return new ProcessDataManagerImpl_Factory(provider, provider2);
    }

    public static ProcessDataManagerImpl c(Context context, UuidGenerator uuidGenerator) {
        return new ProcessDataManagerImpl(context, uuidGenerator);
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ProcessDataManagerImpl get() {
        return c((Context) this.f90004a.get(), (UuidGenerator) this.f90005b.get());
    }
}
