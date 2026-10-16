package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaqo extends zzafk {
    public zzaqo(zzfi zzfiVar, long j3, long j4) {
        super(new zzaff(), new zzaqn(zzfiVar, null), j3, 0L, j3 + 1, 0L, j4, 188L, 1000);
    }

    static /* synthetic */ int zzh(byte[] bArr, int i3) {
        return (bArr[i3 + 3] & 255) | ((bArr[i3] & 255) << 24) | ((bArr[i3 + 1] & 255) << 16) | ((bArr[i3 + 2] & 255) << 8);
    }
}
