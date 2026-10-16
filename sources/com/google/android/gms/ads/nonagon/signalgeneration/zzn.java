package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzn extends LinkedHashMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzq f70763a;

    zzn(zzq zzqVar) {
        Objects.requireNonNull(zzqVar);
        this.f70763a = zzqVar;
    }

    @Override // java.util.LinkedHashMap
    protected final boolean removeEldestEntry(Map.Entry entry) {
        zzq zzqVar = this.f70763a;
        synchronized (zzqVar) {
            try {
                if (size() <= zzqVar.g()) {
                    return false;
                }
                zzqVar.h().add(new Pair((String) entry.getKey(), ((zzo) entry.getValue()).f70765b));
                return size() > zzqVar.g();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
