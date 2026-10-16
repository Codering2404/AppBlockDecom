package com.google.android.recaptcha.internal;

import com.facebook.stetho.websocket.CloseCodes;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbl {
    public static final zzbl zza = new zzbl(9999);
    public static final zzbl zzb = new zzbl(1004);
    public static final zzbl zzc = new zzbl(1005);
    public static final zzbl zzd = new zzbl(CloseCodes.CLOSED_ABNORMALLY);
    public static final zzbl zze = new zzbl(1007);
    public static final zzbl zzf = new zzbl(1008);
    public static final zzbl zzg = new zzbl(1009);
    public static final zzbl zzh = new zzbl(1010);
    private final int zzi;

    private zzbl(int i3) {
        this.zzi = i3;
    }

    public final int zza() {
        return this.zzi;
    }
}
