package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgtf {
    private final String zza;
    private final zzgte zzb;
    private zzgte zzc;

    /* synthetic */ zzgtf(String str, byte[] bArr) {
        zzgte zzgteVar = new zzgte();
        this.zzb = zzgteVar;
        this.zzc = zzgteVar;
        str.getClass();
        this.zza = str;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append('{');
        zzgte zzgteVar = this.zzb.zzb;
        String str = "";
        while (zzgteVar != null) {
            Object obj = zzgteVar.zza;
            sb.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                sb.append((CharSequence) Arrays.deepToString(new Object[]{obj}), 1, r2.length() - 1);
            }
            zzgteVar = zzgteVar.zzb;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    public final zzgtf zza(Object obj) {
        zzgte zzgteVar = new zzgte();
        this.zzc.zzb = zzgteVar;
        this.zzc = zzgteVar;
        zzgteVar.zza = obj;
        return this;
    }
}
