package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhr extends zzhu {
    public zzhr(byte[] bArr, int i3) throws InvalidKeyException {
        super(bArr, i3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzhu
    public final int zza() {
        return 12;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzhu
    public final /* bridge */ /* synthetic */ void zza(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        super.zza(byteBuffer, bArr, bArr2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzhu
    public final /* bridge */ /* synthetic */ byte[] zza(byte[] bArr, ByteBuffer byteBuffer) throws GeneralSecurityException {
        return super.zza(bArr, byteBuffer);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzhu
    public final int[] zza(int[] iArr, int i3) {
        if (iArr.length == 3) {
            int[] iArr2 = new int[16];
            zzhp.zza(iArr2, this.zza);
            iArr2[12] = i3;
            System.arraycopy(iArr, 0, iArr2, 13, iArr.length);
            return iArr2;
        }
        throw new IllegalArgumentException(String.format("ChaCha20 uses 96-bit nonces, but got a %d-bit nonce", Integer.valueOf(iArr.length << 5)));
    }
}
