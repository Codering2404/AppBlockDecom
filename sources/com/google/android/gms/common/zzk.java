package com.google.android.gms.common;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzk extends zzj {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f72326b;

    zzk(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.f72326b = bArr;
    }

    @Override // com.google.android.gms.common.zzj
    final byte[] h5() {
        return this.f72326b;
    }
}
