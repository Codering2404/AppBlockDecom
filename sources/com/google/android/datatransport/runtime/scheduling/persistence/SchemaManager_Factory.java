package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class SchemaManager_Factory implements Factory<SchemaManager> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Provider f69582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Provider f69583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Provider f69584c;

    public SchemaManager_Factory(Provider provider, Provider provider2, Provider provider3) {
        this.f69582a = provider;
        this.f69583b = provider2;
        this.f69584c = provider3;
    }

    public static SchemaManager_Factory a(Provider provider, Provider provider2, Provider provider3) {
        return new SchemaManager_Factory(provider, provider2, provider3);
    }

    public static SchemaManager c(Context context, String str, int i3) {
        return new SchemaManager(context, str, i3);
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public SchemaManager get() {
        return c((Context) this.f69582a.get(), (String) this.f69583b.get(), ((Integer) this.f69584c.get()).intValue());
    }
}
