package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzanz implements zzanl {
    private final zzet zza = new zzet();
    private final zzet zzb = new zzet();
    private final zzany zzc = new zzany();
    private Inflater zzd;

    @Override // com.google.android.gms.internal.ads.zzanl
    public final void zza(byte[] bArr, int i3, int i4, zzank zzankVar, zzdt zzdtVar) {
        zzet zzetVar = this.zza;
        zzetVar.zzb(bArr, i4 + i3);
        zzetVar.zzh(i3);
        if (this.zzd == null) {
            this.zzd = new Inflater();
        }
        zzet zzetVar2 = this.zzb;
        if (zzfl.zzO(zzetVar, zzetVar2, this.zzd)) {
            zzetVar.zzb(zzetVar2.zzi(), zzetVar2.zze());
        }
        zzany zzanyVar = this.zzc;
        zzanyVar.zzb();
        ArrayList arrayList = new ArrayList();
        while (zzetVar.zzd() >= 3) {
            int iZze = zzetVar.zze();
            int iZzs = zzetVar.zzs();
            int iZzt = zzetVar.zzt();
            int iZzg = zzetVar.zzg() + iZzt;
            zzcx zzcxVarZza = null;
            if (iZzg > iZze) {
                zzetVar.zzh(iZze);
            } else {
                if (iZzs != 128) {
                    switch (iZzs) {
                        case 20:
                            zzanyVar.zzc(zzetVar, iZzt);
                            break;
                        case 21:
                            zzanyVar.zzd(zzetVar, iZzt);
                            break;
                        case 22:
                            zzanyVar.zze(zzetVar, iZzt);
                            break;
                    }
                } else {
                    zzcxVarZza = zzanyVar.zza();
                    zzanyVar.zzb();
                }
                zzetVar.zzh(iZzg);
            }
            if (zzcxVarZza != null) {
                arrayList.add(zzcxVarZza);
            }
        }
        zzdtVar.zza(new zzand(arrayList, -9223372036854775807L, -9223372036854775807L));
    }
}
