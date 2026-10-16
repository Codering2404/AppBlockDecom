package com.google.android.gms.internal.consent_sdk;

import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzdn extends zzdc {
    final CharSequence zza;
    int zzb = 0;
    int zzc = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    zzdn(zzdo zzdoVar, CharSequence charSequence) {
        this.zza = charSequence;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdc
    protected final /* bridge */ /* synthetic */ Object zza() {
        int iZzc;
        int i3 = this.zzb;
        while (true) {
            int i4 = this.zzb;
            if (i4 == -1) {
                zzb();
                return null;
            }
            int iZzd = zzd(i4);
            if (iZzd == -1) {
                iZzd = this.zza.length();
                this.zzb = -1;
                iZzc = -1;
            } else {
                iZzc = zzc(iZzd);
                this.zzb = iZzc;
            }
            if (iZzc != i3) {
                if (i3 < iZzd) {
                    this.zza.charAt(i3);
                }
                if (i3 < iZzd) {
                    this.zza.charAt(iZzd - 1);
                }
                int i5 = this.zzc;
                if (i5 == 1) {
                    CharSequence charSequence = this.zza;
                    int length = charSequence.length();
                    this.zzb = -1;
                    if (length > i3) {
                        charSequence.charAt(length - 1);
                    }
                    iZzd = length;
                } else {
                    this.zzc = i5 - 1;
                }
                return this.zza.subSequence(i3, iZzd).toString();
            }
            int i6 = iZzc + 1;
            this.zzb = i6;
            if (i6 > this.zza.length()) {
                this.zzb = -1;
            }
        }
    }

    abstract int zzc(int i3);

    abstract int zzd(int i3);
}
