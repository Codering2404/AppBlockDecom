package com.google.android.gms.internal.common;

import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzv extends zzk {
    final CharSequence zzb;
    final zzp zzc;
    final boolean zzd;
    int zze = 0;
    int zzf = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    zzv(zzw zzwVar, CharSequence charSequence) {
        this.zzc = zzwVar.zzf();
        this.zzd = zzwVar.zzg();
        this.zzb = charSequence;
    }

    @Override // com.google.android.gms.internal.common.zzk
    protected final /* bridge */ /* synthetic */ Object zza() {
        int iZzc;
        int iZzd;
        int i3 = this.zze;
        while (true) {
            int i4 = this.zze;
            if (i4 == -1) {
                zzb();
                return null;
            }
            iZzc = zzc(i4);
            if (iZzc == -1) {
                iZzc = this.zzb.length();
                this.zze = -1;
                iZzd = -1;
            } else {
                iZzd = zzd(iZzc);
                this.zze = iZzd;
            }
            if (iZzd == i3) {
                int i5 = iZzd + 1;
                this.zze = i5;
                if (i5 > this.zzb.length()) {
                    this.zze = -1;
                }
            } else {
                if (i3 < iZzc) {
                    this.zzb.charAt(i3);
                }
                if (i3 < iZzc) {
                    this.zzb.charAt(iZzc - 1);
                }
                if (!this.zzd || i3 != iZzc) {
                    break;
                }
                i3 = this.zze;
            }
        }
        int i6 = this.zzf;
        if (i6 == 1) {
            CharSequence charSequence = this.zzb;
            int length = charSequence.length();
            this.zze = -1;
            if (length > i3) {
                charSequence.charAt(length - 1);
            }
            iZzc = length;
        } else {
            this.zzf = i6 - 1;
        }
        return this.zzb.subSequence(i3, iZzc).toString();
    }

    abstract int zzc(int i3);

    abstract int zzd(int i3);
}
