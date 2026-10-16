package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class PersistedEvent {
    public static PersistedEvent a(long j3, TransportContext transportContext, EventInternal eventInternal) {
        return new AutoValue_PersistedEvent(j3, transportContext, eventInternal);
    }

    public abstract EventInternal b();

    public abstract long c();

    public abstract TransportContext d();
}
