package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfll {
    private final zzfkf zza;
    private final zzfki zzb;
    private final zzfsc zzc;
    private final zzfru zzd;
    private final zzfqg zze;
    private final zzctj zzf;

    public zzfll(zzfsc zzfscVar, zzfru zzfruVar, zzfkf zzfkfVar, zzfki zzfkiVar, zzctj zzctjVar, zzfqg zzfqgVar) {
        this.zza = zzfkfVar;
        this.zzb = zzfkiVar;
        this.zzc = zzfscVar;
        this.zzd = zzfruVar;
        this.zzf = zzctjVar;
        this.zze = zzfqgVar;
    }

    public final void zza(List list, zzdfg zzdfgVar) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzc((String) it.next(), 2, zzdfgVar);
        }
    }

    public final void zzb(List list, int i3) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            zzhbw.zzr((((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzlw)).booleanValue() && zzctj.zzc(str)) ? this.zzf.zzb(str, com.google.android.gms.ads.internal.client.zzay.h()) : zzhbw.zza(str), new zzflk(this, i3), zzcfr.zza);
        }
    }

    public final void zzc(String str, int i3, zzdfg zzdfgVar) {
        zzfkf zzfkfVar = this.zza;
        if (zzfkfVar.zzai) {
            this.zzd.zza(str, this.zzb.zzb, i3);
            return;
        }
        this.zzc.zzb(str, zzfkfVar.zzax, this.zze, zzdfgVar);
    }
}
