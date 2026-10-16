package com.google.zxing;

import com.google.zxing.common.BitMatrix;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class BinaryBitmap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Binarizer f91575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BitMatrix f91576b;

    public BitMatrix a() {
        if (this.f91576b == null) {
            this.f91576b = this.f91575a.a();
        }
        return this.f91576b;
    }

    public String toString() {
        try {
            return a().toString();
        } catch (NotFoundException unused) {
            return "";
        }
    }
}
