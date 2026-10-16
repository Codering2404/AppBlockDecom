package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_PersistedEvent extends PersistedEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f69549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TransportContext f69550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EventInternal f69551c;

    AutoValue_PersistedEvent(long j3, TransportContext transportContext, EventInternal eventInternal) {
        this.f69549a = j3;
        if (transportContext == null) {
            throw new NullPointerException("Null transportContext");
        }
        this.f69550b = transportContext;
        if (eventInternal == null) {
            throw new NullPointerException("Null event");
        }
        this.f69551c = eventInternal;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent
    public EventInternal b() {
        return this.f69551c;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent
    public long c() {
        return this.f69549a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent
    public TransportContext d() {
        return this.f69550b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PersistedEvent) {
            PersistedEvent persistedEvent = (PersistedEvent) obj;
            if (this.f69549a == persistedEvent.c() && this.f69550b.equals(persistedEvent.d()) && this.f69551c.equals(persistedEvent.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j3 = this.f69549a;
        return ((((((int) (j3 ^ (j3 >>> 32))) ^ 1000003) * 1000003) ^ this.f69550b.hashCode()) * 1000003) ^ this.f69551c.hashCode();
    }

    public String toString() {
        return "PersistedEvent{id=" + this.f69549a + ", transportContext=" + this.f69550b + ", event=" + this.f69551c + "}";
    }
}
