package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzdl extends zzdn {
    zzdl(zzdo zzdoVar, CharSequence charSequence, zzdh zzdhVar) {
        super(zzdoVar, charSequence);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdn
    final int zzc(int i3) {
        return i3 + 1;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdn
    final int zzd(int i3) {
        CharSequence charSequence = ((zzdn) this).zza;
        int length = charSequence.length();
        zzdj.zzb(i3, length, "index");
        while (i3 < length) {
            if (charSequence.charAt(i3) == ',') {
                return i3;
            }
            i3++;
        }
        return -1;
    }
}
