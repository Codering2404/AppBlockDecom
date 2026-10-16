package com.google.android.libraries.places.internal;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbfh {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final zzbfh f76143c = new zzbfh();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentMap f76145b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbfm f76144a = new zzbep();

    private zzbfh() {
    }

    static zzbfh a() {
        return f76143c;
    }

    final zzbfl b(Class cls) {
        byte[] bArr = zzbeb.f76092b;
        if (cls == null) {
            throw new NullPointerException("messageType");
        }
        ConcurrentMap concurrentMap = this.f76145b;
        zzbfl zzbflVarZza = (zzbfl) concurrentMap.get(cls);
        if (zzbflVarZza == null) {
            zzbflVarZza = this.f76144a.zza(cls);
            zzbfl zzbflVar = (zzbfl) concurrentMap.putIfAbsent(cls, zzbflVarZza);
            if (zzbflVar != null) {
                return zzbflVar;
            }
        }
        return zzbflVarZza;
    }
}
