package com.google.android.gms.internal.ads;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaqu implements zzari {
    private final zzaqt zza;
    private final zzet zzb = new zzet(32);
    private int zzc;
    private int zzd;
    private boolean zze;
    private boolean zzf;

    public zzaqu(zzaqt zzaqtVar) {
        this.zza = zzaqtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzari
    public final void zza(zzfi zzfiVar, zzagb zzagbVar, zzarh zzarhVar) {
        this.zza.zza(zzfiVar, zzagbVar, zzarhVar);
        this.zzf = true;
    }

    @Override // com.google.android.gms.internal.ads.zzari
    public final void zzb() {
        this.zzf = true;
    }

    @Override // com.google.android.gms.internal.ads.zzari
    public final void zzc(zzet zzetVar, int i3) {
        int i4 = i3 & 1;
        int iZzg = i4 != 0 ? zzetVar.zzg() + zzetVar.zzs() : -1;
        if (this.zzf) {
            if (i4 == 0) {
                return;
            }
            this.zzf = false;
            zzetVar.zzh(iZzg);
            this.zzd = 0;
        }
        while (zzetVar.zzd() > 0) {
            int i5 = this.zzd;
            if (i5 < 3) {
                if (i5 == 0) {
                    int iZzs = zzetVar.zzs();
                    zzetVar.zzh(zzetVar.zzg() - 1);
                    if (iZzs == 255) {
                        this.zzf = true;
                        return;
                    }
                }
                int iMin = Math.min(zzetVar.zzd(), 3 - this.zzd);
                zzet zzetVar2 = this.zzb;
                zzetVar.zzm(zzetVar2.zzi(), this.zzd, iMin);
                int i6 = this.zzd + iMin;
                this.zzd = i6;
                if (i6 == 3) {
                    zzetVar2.zzh(0);
                    zzetVar2.zzf(3);
                    zzetVar2.zzk(1);
                    int iZzs2 = zzetVar2.zzs();
                    boolean z2 = (iZzs2 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0;
                    int iZzs3 = zzetVar2.zzs();
                    this.zze = z2;
                    this.zzc = (((iZzs2 & 15) << 8) | iZzs3) + 3;
                    int iZzj = zzetVar2.zzj();
                    int i7 = this.zzc;
                    if (iZzj < i7) {
                        int iZzj2 = zzetVar2.zzj();
                        zzetVar2.zzc(Math.min(4098, Math.max(i7, iZzj2 + iZzj2)));
                    }
                }
            } else {
                int iMin2 = Math.min(zzetVar.zzd(), this.zzc - this.zzd);
                zzet zzetVar3 = this.zzb;
                zzetVar.zzm(zzetVar3.zzi(), this.zzd, iMin2);
                int i8 = this.zzd + iMin2;
                this.zzd = i8;
                int i9 = this.zzc;
                if (i8 != i9) {
                    continue;
                } else {
                    if (!this.zze) {
                        zzetVar3.zzf(i9);
                    } else {
                        if (zzfl.zzJ(zzetVar3.zzi(), 0, i9, -1) != 0) {
                            this.zzf = true;
                            return;
                        }
                        zzetVar3.zzf(this.zzc - 4);
                    }
                    zzetVar3.zzh(0);
                    this.zza.zzb(zzetVar3);
                    this.zzd = 0;
                }
            }
        }
    }
}
