package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzblc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f76364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f76365b;

    private zzblc(String str, Object obj) {
        this.f76364a = str;
        this.f76365b = obj;
    }

    public static zzblc a(String str) {
        Preconditions.u("internal:health-check-consumer-listener", "debugString");
        return new zzblc("internal:health-check-consumer-listener", null);
    }

    public static zzblc b(String str, Object obj) {
        Preconditions.u("internal:disable-subchannel-reconnect", "debugString");
        return new zzblc("internal:disable-subchannel-reconnect", obj);
    }

    final /* synthetic */ Object c() {
        return this.f76365b;
    }

    public final String toString() {
        return this.f76364a;
    }
}
