package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.Module;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Module
public abstract class EventStoreModule {
    static String a() {
        return "com.google.android.datatransport.events";
    }

    static String b(Context context) {
        return context.getPackageName();
    }

    static int c() {
        return SchemaManager.f69571d;
    }

    static EventStoreConfig d() {
        return EventStoreConfig.f69552a;
    }
}
