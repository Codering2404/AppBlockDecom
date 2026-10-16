package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzqu extends Exception {
    public final int zza;
    public final boolean zzb;

    public zzqu(int i3, boolean z2) {
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 26);
        sb.append("AudioOutput write failed: ");
        sb.append(i3);
        super(sb.toString());
        this.zzb = z2;
        this.zza = i3;
    }
}
