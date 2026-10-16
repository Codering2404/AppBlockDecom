package com.google.android.gms.internal.play_billing;

import com.google.android.gms.internal.ads.v;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class zzcp {
    public static /* synthetic */ boolean zza(Unsafe unsafe, Object obj, long j3, Object obj2, Object obj3) {
        while (!v.a(unsafe, obj, j3, obj2, obj3)) {
            if (unsafe.getObject(obj, j3) != obj2) {
                return false;
            }
        }
        return true;
    }
}
