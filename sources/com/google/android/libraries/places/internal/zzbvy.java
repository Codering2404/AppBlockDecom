package com.google.android.libraries.places.internal;

import java.lang.ref.ReferenceQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbvy extends zzbso {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ReferenceQueue f77046c = new ReferenceQueue();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ConcurrentMap f77047d = new ConcurrentHashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Logger f77048e = Logger.getLogger(zzbvy.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbvx f77049b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbvy(zzblw zzblwVar) {
        super(zzblwVar);
        ReferenceQueue referenceQueue = f77046c;
        ConcurrentMap concurrentMap = f77047d;
        this.f77049b = new zzbvx(this, zzblwVar, referenceQueue, concurrentMap);
    }

    @Override // com.google.android.libraries.places.internal.zzbso, com.google.android.libraries.places.internal.zzblw
    public final zzblw g() {
        this.f77049b.b();
        return super.g();
    }
}
