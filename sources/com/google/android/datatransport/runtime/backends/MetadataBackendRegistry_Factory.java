package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class MetadataBackendRegistry_Factory implements Factory<MetadataBackendRegistry> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Provider f69398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Provider f69399b;

    public MetadataBackendRegistry_Factory(Provider provider, Provider provider2) {
        this.f69398a = provider;
        this.f69399b = provider2;
    }

    public static MetadataBackendRegistry_Factory a(Provider provider, Provider provider2) {
        return new MetadataBackendRegistry_Factory(provider, provider2);
    }

    public static MetadataBackendRegistry c(Context context, Object obj) {
        return new MetadataBackendRegistry(context, (CreationContextFactory) obj);
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public MetadataBackendRegistry get() {
        return c((Context) this.f69398a.get(), this.f69399b.get());
    }
}
