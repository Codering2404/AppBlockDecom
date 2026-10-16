package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zznf {
    private final zzne zza;

    private zznf(zzot zzotVar, Object obj, zzot zzotVar2, Object obj2) {
        this.zza = new zzne(zzotVar, "", zzotVar2, "");
    }

    public static zznf zza(zzot zzotVar, Object obj, zzot zzotVar2, Object obj2) {
        return new zznf(zzotVar, "", zzotVar2, "");
    }

    static void zzb(zzlm zzlmVar, zzne zzneVar, Object obj, Object obj2) throws IOException {
        zzlw.zzf(zzlmVar, zzneVar.zza, 1, obj);
        zzlw.zzf(zzlmVar, zzneVar.zzc, 2, obj2);
    }

    static int zzc(zzne zzneVar, Object obj, Object obj2) {
        return zzlw.zzh(zzneVar.zza, 1, obj) + zzlw.zzh(zzneVar.zzc, 2, obj2);
    }

    public final int zzd(int i3, Object obj, Object obj2) {
        zzne zzneVar = this.zza;
        int iZzz = zzlm.zzz(i3 << 3);
        int iZzc = zzc(zzneVar, obj, obj2);
        return iZzz + zzlm.zzz(iZzc) + iZzc;
    }

    final zzne zze() {
        return this.zza;
    }
}
