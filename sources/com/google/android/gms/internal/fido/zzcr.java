package com.google.android.gms.internal.fido;

import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcr {
    static Object zza(@CheckForNull Object obj, int i3) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("at index " + i3);
    }

    static Object[] zzb(Object[] objArr, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            zza(objArr[i4], i4);
        }
        return objArr;
    }
}
