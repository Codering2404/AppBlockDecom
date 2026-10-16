package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdg {
    @EnsuresNonNull
    @Deprecated
    @Pure
    public static String zza(String str) {
        zzgtj.zza(!TextUtils.isEmpty(str));
        return str;
    }
}
