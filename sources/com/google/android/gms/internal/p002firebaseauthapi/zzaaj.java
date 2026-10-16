package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaaj {
    private final byte[] zza;

    private zzaaj(byte[] bArr, int i3, int i4) {
        byte[] bArr2 = new byte[i4];
        this.zza = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, i4);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzaaj) {
            return Arrays.equals(((zzaaj) obj).zza, this.zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final String toString() {
        return "Bytes(" + zzzx.zza(this.zza) + ")";
    }

    public final int zza() {
        return this.zza.length;
    }

    public final byte[] zzb() {
        byte[] bArr = this.zza;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static zzaaj zza(byte[] bArr) {
        if (bArr != null) {
            return zza(bArr, 0, bArr.length);
        }
        throw new NullPointerException("data must be non-null");
    }

    public static zzaaj zza(byte[] bArr, int i3, int i4) {
        if (bArr != null) {
            if (i4 > bArr.length) {
                i4 = bArr.length;
            }
            return new zzaaj(bArr, 0, i4);
        }
        throw new NullPointerException("data must be non-null");
    }
}
