package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class EventStoreModule_PackageNameFactory implements Factory<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Provider f69554a;

    public EventStoreModule_PackageNameFactory(Provider provider) {
        this.f69554a = provider;
    }

    public static EventStoreModule_PackageNameFactory a(Provider provider) {
        return new EventStoreModule_PackageNameFactory(provider);
    }

    public static String c(Context context) {
        return (String) Preconditions.d(EventStoreModule.b(context));
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public String get() {
        return c((Context) this.f69554a.get());
    }
}
