package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Provider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class SQLiteEventStore_Factory implements Factory<SQLiteEventStore> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Provider f69565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Provider f69566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Provider f69567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Provider f69568d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Provider f69569e;

    public SQLiteEventStore_Factory(Provider provider, Provider provider2, Provider provider3, Provider provider4, Provider provider5) {
        this.f69565a = provider;
        this.f69566b = provider2;
        this.f69567c = provider3;
        this.f69568d = provider4;
        this.f69569e = provider5;
    }

    public static SQLiteEventStore_Factory a(Provider provider, Provider provider2, Provider provider3, Provider provider4, Provider provider5) {
        return new SQLiteEventStore_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static SQLiteEventStore c(Clock clock, Clock clock2, Object obj, Object obj2, Provider provider) {
        return new SQLiteEventStore(clock, clock2, (EventStoreConfig) obj, (SchemaManager) obj2, provider);
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public SQLiteEventStore get() {
        return c((Clock) this.f69565a.get(), (Clock) this.f69566b.get(), this.f69567c.get(), this.f69568d.get(), this.f69569e);
    }
}
