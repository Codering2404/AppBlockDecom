package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbtb implements zzbkv {
    zzbtb() {
    }

    @Override // com.google.android.libraries.places.internal.zzbmf
    public final /* synthetic */ byte[] zza(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.places.internal.zzbmf
    public final /* bridge */ /* synthetic */ Object zzb(byte[] bArr) {
        if (bArr.length < 3) {
            throw new NumberFormatException("Malformed status code ".concat(new String(bArr, zzbkw.f76356a)));
        }
        return Integer.valueOf(((bArr[0] - 48) * 100) + ((bArr[1] - 48) * 10) + (bArr[2] - 48));
    }
}
