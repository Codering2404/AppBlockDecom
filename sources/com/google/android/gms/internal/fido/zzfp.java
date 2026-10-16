package com.google.android.gms.internal.fido;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzfp extends zzfr {
    private final ByteBuffer zza = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);

    zzfp() {
    }

    @Override // com.google.android.gms.internal.fido.zzfr, com.google.android.gms.internal.fido.zzfv
    public final zzfv zza(byte[] bArr) {
        bArr.getClass();
        zzb(bArr, 0, bArr.length);
        return this;
    }

    protected void zzb(byte[] bArr, int i3, int i4) {
        throw null;
    }
}
