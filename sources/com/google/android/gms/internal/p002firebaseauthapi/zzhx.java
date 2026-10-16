package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhx extends zzhw {
    public zzhx(byte[] bArr) throws GeneralSecurityException {
        super(bArr);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzhw
    final zzhu zza(byte[] bArr, int i3) throws InvalidKeyException {
        return new zzhy(bArr, i3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzhw
    public final /* bridge */ /* synthetic */ void zza(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        super.zza(byteBuffer, bArr, bArr2, bArr3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzhw
    public final /* bridge */ /* synthetic */ byte[] zza(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return super.zza(byteBuffer, bArr, bArr2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzhw
    public final /* bridge */ /* synthetic */ byte[] zza(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        return super.zza(bArr, bArr2, bArr3);
    }
}
