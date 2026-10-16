package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class Token {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Token f91677b = new SimpleToken(null, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Token f91678a;

    Token(Token token) {
        this.f91678a = token;
    }

    final Token a(int i3, int i4) {
        return new SimpleToken(this, i3, i4);
    }

    final Token b(int i3, int i4) {
        return new BinaryShiftToken(this, i3, i4);
    }

    abstract void c(BitArray bitArray, byte[] bArr);

    final Token d() {
        return this.f91678a;
    }
}
