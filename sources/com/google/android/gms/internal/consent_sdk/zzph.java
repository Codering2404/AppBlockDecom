package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzph extends zzpk {
    zzph(byte[] bArr, int i3, int i4) {
        super(bArr);
        zzpm.zzi(0, 47, bArr.length);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpk, com.google.android.gms.internal.consent_sdk.zzpm
    public final byte zza(int i3) {
        if (((47 - (i3 + 1)) | i3) >= 0) {
            return ((zzpk) this).zza[i3];
        }
        if (i3 < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i3);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i3 + ", 47");
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpk, com.google.android.gms.internal.consent_sdk.zzpm
    final byte zzb(int i3) {
        return ((zzpk) this).zza[i3];
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpk
    protected final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpk, com.google.android.gms.internal.consent_sdk.zzpm
    public final int zzd() {
        return 47;
    }
}
