package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzgtw extends zzgsr {
    final CharSequence zzb;
    int zzc = 0;
    int zzd = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    zzgtw(zzgty zzgtyVar, CharSequence charSequence) {
        this.zzb = charSequence;
    }

    @Override // com.google.android.gms.internal.ads.zzgsr
    protected final /* bridge */ /* synthetic */ Object zza() {
        int iZzd;
        int i3 = this.zzc;
        while (true) {
            int i4 = this.zzc;
            if (i4 == -1) {
                zzb();
                return null;
            }
            int iZzc = zzc(i4);
            if (iZzc == -1) {
                iZzc = this.zzb.length();
                this.zzc = -1;
                iZzd = -1;
            } else {
                iZzd = zzd(iZzc);
                this.zzc = iZzd;
            }
            if (iZzd != i3) {
                if (i3 < iZzc) {
                    this.zzb.charAt(i3);
                }
                if (i3 < iZzc) {
                    this.zzb.charAt(iZzc - 1);
                }
                int i5 = this.zzd;
                if (i5 == 1) {
                    CharSequence charSequence = this.zzb;
                    int length = charSequence.length();
                    this.zzc = -1;
                    if (length > i3) {
                        charSequence.charAt(length - 1);
                    }
                    iZzc = length;
                } else {
                    this.zzd = i5 - 1;
                }
                return this.zzb.subSequence(i3, iZzc).toString();
            }
            int i6 = iZzd + 1;
            this.zzc = i6;
            if (i6 > this.zzb.length()) {
                this.zzc = -1;
            }
        }
    }

    abstract int zzc(int i3);

    abstract int zzd(int i3);
}
