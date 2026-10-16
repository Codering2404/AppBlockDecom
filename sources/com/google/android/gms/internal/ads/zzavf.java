package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzavf implements zzave {
    @Override // com.google.android.gms.internal.ads.zzave
    public final byte zza(zzavq zzavqVar, int i3) {
        return zzavqVar.zzb(i3);
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final zzavq zzb(zzavq zzavqVar, int i3, int i4) {
        byte[] bArr;
        int length;
        if (i3 < 0 || i3 > i4 || i4 > (length = (bArr = zzavqVar.zza).length) || i3 > i4 || i4 > length) {
            throw new IndexOutOfBoundsException();
        }
        return new zzavq(zzavq.zzh(bArr, i3, i4 - i3));
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final zzave zzc() {
        return new zzavf();
    }
}
