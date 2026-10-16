package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class BinaryShiftToken extends Token {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final short f91661c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final short f91662d;

    BinaryShiftToken(Token token, int i3, int i4) {
        super(token);
        this.f91661c = (short) i3;
        this.f91662d = (short) i4;
    }

    @Override // com.google.zxing.aztec.encoder.Token
    public void c(BitArray bitArray, byte[] bArr) {
        int i3 = 0;
        while (true) {
            short s2 = this.f91662d;
            if (i3 >= s2) {
                return;
            }
            if (i3 == 0 || (i3 == 31 && s2 <= 62)) {
                bitArray.c(31, 5);
                short s3 = this.f91662d;
                if (s3 > 62) {
                    bitArray.c(s3 - 31, 16);
                } else if (i3 == 0) {
                    bitArray.c(Math.min((int) s3, 31), 5);
                } else {
                    bitArray.c(s3 - 31, 5);
                }
            }
            bitArray.c(bArr[this.f91661c + i3], 8);
            i3++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append((int) this.f91661c);
        sb.append("::");
        sb.append((this.f91661c + this.f91662d) - 1);
        sb.append('>');
        return sb.toString();
    }
}
