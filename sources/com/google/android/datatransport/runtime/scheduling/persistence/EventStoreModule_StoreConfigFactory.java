package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class EventStoreModule_StoreConfigFactory implements Factory<EventStoreConfig> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class InstanceHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final EventStoreModule_StoreConfigFactory f69556a = new EventStoreModule_StoreConfigFactory();
    }

    public static EventStoreModule_StoreConfigFactory a() {
        return InstanceHolder.f69556a;
    }

    public static EventStoreConfig c() {
        return (EventStoreConfig) Preconditions.d(EventStoreModule.d());
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public EventStoreConfig get() {
        return c();
    }
}
