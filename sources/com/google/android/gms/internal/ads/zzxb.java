package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzxb {
    private static final AtomicLong zza = new AtomicLong();

    public zzxb(long j3, zzht zzhtVar, Uri uri, Map map, long j4, long j5, long j6) {
    }

    public static long zza() {
        return zza.getAndIncrement();
    }
}
