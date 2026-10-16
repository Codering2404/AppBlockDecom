package com.google.android.gms.internal.ads;

import android.view.View;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbdc extends zzbdf {
    private final View zzh;

    public zzbdc(zzbbs zzbbsVar, String str, String str2, zzaxm zzaxmVar, int i3, int i4, View view) {
        super(zzbbsVar, "K/Oo81d3D7QQWAvkxOkmH49qSlOsGQFHscMya6S21HBqr+GdnpBDhLtEJWB1CCZB", "Ge8je/arysmNa4UdtKuRe+4JSpIyhDOrTZ5OtsYb5ag=", zzaxmVar, i3, 57);
        this.zzh = view;
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        View view = this.zzh;
        if (view != null) {
            Boolean bool = (Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzen);
            Boolean bool2 = (Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzms);
            zzbbw zzbbwVar = new zzbbw((String) this.zze.invoke(null, view, this.zza.zzb().getResources().getDisplayMetrics(), bool, bool2));
            zzayk zzaykVarZza = zzayl.zza();
            zzaykVarZza.zzb(zzbbwVar.zza.longValue());
            zzaykVarZza.zzc(zzbbwVar.zzb.longValue());
            zzaykVarZza.zzd(zzbbwVar.zzc.longValue());
            if (bool2.booleanValue()) {
                zzaykVarZza.zza(zzbbwVar.zze.longValue());
            }
            if (bool.booleanValue()) {
                zzaykVarZza.zze(zzbbwVar.zzd.longValue());
            }
            this.zzd.zzM((zzayl) zzaykVarZza.zzbu());
        }
    }
}
