package com.google.android.gms.internal.play_billing;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbf {
    private final String zza;
    private final zzbe zzb;
    private zzbe zzc;

    /* synthetic */ zzbf(String str, zzbg zzbgVar) {
        zzbe zzbeVar = new zzbe();
        this.zzb = zzbeVar;
        this.zzc = zzbeVar;
        str.getClass();
        this.zza = str;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append('{');
        zzbe zzbeVar = this.zzb.zzb;
        String str = "";
        while (zzbeVar != null) {
            Object obj = zzbeVar.zza;
            sb.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                sb.append((CharSequence) Arrays.deepToString(new Object[]{obj}), 1, r2.length() - 1);
            }
            zzbeVar = zzbeVar.zzb;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    public final zzbf zza(Object obj) {
        zzbe zzbeVar = new zzbe();
        this.zzc.zzb = zzbeVar;
        this.zzc = zzbeVar;
        zzbeVar.zza = obj;
        return this;
    }
}
