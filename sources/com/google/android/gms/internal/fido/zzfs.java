package com.google.android.gms.internal.fido;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfs extends zzft implements Serializable {
    final byte[] zza;

    zzfs(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.fido.zzft
    public final int zza() {
        byte[] bArr = this.zza;
        int length = bArr.length;
        if (length < 4) {
            throw new IllegalStateException(zzbo.zza("HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", Integer.valueOf(length)));
        }
        int i3 = bArr[0] & 255;
        int i4 = bArr[1] & 255;
        int i5 = bArr[2] & 255;
        return ((bArr[3] & 255) << 24) | i3 | (i4 << 8) | (i5 << 16);
    }

    @Override // com.google.android.gms.internal.fido.zzft
    public final int zzb() {
        return this.zza.length * 8;
    }

    @Override // com.google.android.gms.internal.fido.zzft
    final boolean zzc(zzft zzftVar) {
        if (this.zza.length != zzftVar.zze().length) {
            return false;
        }
        boolean z2 = true;
        int i3 = 0;
        while (true) {
            byte[] bArr = this.zza;
            if (i3 >= bArr.length) {
                return z2;
            }
            z2 &= bArr[i3] == zzftVar.zze()[i3];
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.fido.zzft
    public final byte[] zzd() {
        return (byte[]) this.zza.clone();
    }

    @Override // com.google.android.gms.internal.fido.zzft
    final byte[] zze() {
        return this.zza;
    }
}
