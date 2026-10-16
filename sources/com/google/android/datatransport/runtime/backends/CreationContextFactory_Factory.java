package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Provider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class CreationContextFactory_Factory implements Factory<CreationContextFactory> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Provider f69390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Provider f69391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Provider f69392c;

    public CreationContextFactory_Factory(Provider provider, Provider provider2, Provider provider3) {
        this.f69390a = provider;
        this.f69391b = provider2;
        this.f69392c = provider3;
    }

    public static CreationContextFactory_Factory a(Provider provider, Provider provider2, Provider provider3) {
        return new CreationContextFactory_Factory(provider, provider2, provider3);
    }

    public static CreationContextFactory c(Context context, Clock clock, Clock clock2) {
        return new CreationContextFactory(context, clock, clock2);
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public CreationContextFactory get() {
        return c((Context) this.f69390a.get(), (Clock) this.f69391b.get(), (Clock) this.f69392c.get());
    }
}
