package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzenm implements zzdno {
    private final Context zza;
    private final VersionInfoParcel zzb;
    private final ListenableFuture zzc;
    private final zzfkf zzd;
    private final zzcku zze;
    private final zzfky zzf;
    private final zzbpt zzg;
    private final boolean zzh;
    private final zzekr zzi;
    private final zzdzl zzj;

    zzenm(Context context, VersionInfoParcel versionInfoParcel, ListenableFuture listenableFuture, zzfkf zzfkfVar, zzcku zzckuVar, zzfky zzfkyVar, boolean z2, zzbpt zzbptVar, zzekr zzekrVar, zzdzl zzdzlVar) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = listenableFuture;
        this.zzd = zzfkfVar;
        this.zze = zzckuVar;
        this.zzf = zzfkyVar;
        this.zzg = zzbptVar;
        this.zzh = z2;
        this.zzi = zzekrVar;
        this.zzj = zzdzlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdno
    public final void zza(boolean z2, Context context, zzdde zzddeVar) {
        boolean z3;
        zzdma zzdmaVar = (zzdma) zzhbw.zzt(this.zzc);
        zzcku zzckuVar = this.zze;
        zzckuVar.zzag(true);
        boolean z4 = this.zzh;
        boolean z5 = false;
        boolean zZzc = z4 ? this.zzg.zzc(false) : false;
        com.google.android.gms.ads.internal.zzt.g();
        boolean zL = com.google.android.gms.ads.internal.util.zzs.l(this.zza);
        if (!z4) {
            z3 = z5;
        } else if (this.zzg.zzd()) {
            z5 = true;
            z3 = z5;
        } else {
            z3 = false;
            z5 = true;
        }
        float fZze = z5 ? this.zzg.zze() : 0.0f;
        zzfkf zzfkfVar = this.zzd;
        com.google.android.gms.ads.internal.zzl zzlVar = new com.google.android.gms.ads.internal.zzl(zZzc, zL, z3, fZze, -1, z2, zzfkfVar.zzO, false);
        if (zzddeVar != null) {
            zzddeVar.zzb();
        }
        com.google.android.gms.ads.internal.zzt.f();
        zzdnd zzdndVarZzj = zzdmaVar.zzj();
        int i3 = zzfkfVar.zzQ;
        VersionInfoParcel versionInfoParcel = this.zzb;
        String str = zzfkfVar.zzB;
        zzfkk zzfkkVar = zzfkfVar.zzs;
        com.google.android.gms.ads.internal.overlay.zzn.a(context, new AdOverlayInfoParcel(null, zzdndVarZzj, null, zzckuVar, i3, versionInfoParcel, str, zzlVar, zzfkkVar.zzb, zzfkkVar.zza, this.zzf.zzg, zzddeVar, zzfkfVar.zzb() ? this.zzi : null, zzckuVar.zzn()), true, this.zzj);
    }

    @Override // com.google.android.gms.internal.ads.zzdno
    public final zzfkf zzb() {
        return this.zzd;
    }
}
