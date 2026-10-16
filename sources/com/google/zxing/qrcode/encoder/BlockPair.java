package com.google.zxing.qrcode.encoder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class BlockPair {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f92088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f92089b;

    BlockPair(byte[] bArr, byte[] bArr2) {
        this.f92088a = bArr;
        this.f92089b = bArr2;
    }

    public byte[] a() {
        return this.f92088a;
    }

    public byte[] b() {
        return this.f92089b;
    }
}
