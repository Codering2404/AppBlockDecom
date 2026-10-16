package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class SimpleToken extends Token {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final short f91670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final short f91671d;

    SimpleToken(Token token, int i3, int i4) {
        super(token);
        this.f91670c = (short) i3;
        this.f91671d = (short) i4;
    }

    @Override // com.google.zxing.aztec.encoder.Token
    void c(BitArray bitArray, byte[] bArr) {
        bitArray.c(this.f91670c, this.f91671d);
    }

    public String toString() {
        short s2 = this.f91670c;
        short s3 = this.f91671d;
        return "<" + Integer.toBinaryString((s2 & ((1 << s3) - 1)) | (1 << s3) | (1 << this.f91671d)).substring(1) + '>';
    }
}
