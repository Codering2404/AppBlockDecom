package com.google.zxing.datamatrix.encoder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class ASCIIEncoder implements Encoder {
    ASCIIEncoder() {
    }

    private static char b(char c3, char c4) {
        if (HighLevelEncoder.f(c3) && HighLevelEncoder.f(c4)) {
            return (char) (((c3 - '0') * 10) + (c4 - '0') + 130);
        }
        throw new IllegalArgumentException("not digits: " + c3 + c4);
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public void a(EncoderContext encoderContext) {
        if (HighLevelEncoder.a(encoderContext.d(), encoderContext.f91879f) >= 2) {
            encoderContext.r(b(encoderContext.d().charAt(encoderContext.f91879f), encoderContext.d().charAt(encoderContext.f91879f + 1)));
            encoderContext.f91879f += 2;
            return;
        }
        char c3 = encoderContext.c();
        int iN = HighLevelEncoder.n(encoderContext.d(), encoderContext.f91879f, c());
        if (iN == c()) {
            if (!HighLevelEncoder.g(c3)) {
                encoderContext.r((char) (c3 + 1));
                encoderContext.f91879f++;
                return;
            } else {
                encoderContext.r((char) 235);
                encoderContext.r((char) (c3 - 127));
                encoderContext.f91879f++;
                return;
            }
        }
        if (iN == 1) {
            encoderContext.r((char) 230);
            encoderContext.o(1);
            return;
        }
        if (iN == 2) {
            encoderContext.r((char) 239);
            encoderContext.o(2);
            return;
        }
        if (iN == 3) {
            encoderContext.r((char) 238);
            encoderContext.o(3);
        } else if (iN == 4) {
            encoderContext.r((char) 240);
            encoderContext.o(4);
        } else {
            if (iN != 5) {
                throw new IllegalStateException("Illegal mode: ".concat(String.valueOf(iN)));
            }
            encoderContext.r((char) 231);
            encoderContext.o(5);
        }
    }

    public int c() {
        return 0;
    }
}
