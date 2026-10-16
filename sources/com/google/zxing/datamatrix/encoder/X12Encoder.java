package com.google.zxing.datamatrix.encoder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class X12Encoder extends C40Encoder {
    X12Encoder() {
    }

    @Override // com.google.zxing.datamatrix.encoder.C40Encoder, com.google.zxing.datamatrix.encoder.Encoder
    public void a(EncoderContext encoderContext) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!encoderContext.i()) {
                break;
            }
            char c3 = encoderContext.c();
            encoderContext.f91879f++;
            c(c3, sb);
            if (sb.length() % 3 == 0) {
                C40Encoder.g(encoderContext, sb);
                if (HighLevelEncoder.n(encoderContext.d(), encoderContext.f91879f, e()) != e()) {
                    encoderContext.o(0);
                    break;
                }
            }
        }
        f(encoderContext, sb);
    }

    @Override // com.google.zxing.datamatrix.encoder.C40Encoder
    int c(char c3, StringBuilder sb) {
        if (c3 == '\r') {
            sb.append((char) 0);
        } else if (c3 == ' ') {
            sb.append((char) 3);
        } else if (c3 == '*') {
            sb.append((char) 1);
        } else if (c3 == '>') {
            sb.append((char) 2);
        } else if (c3 >= '0' && c3 <= '9') {
            sb.append((char) (c3 - ','));
        } else if (c3 < 'A' || c3 > 'Z') {
            HighLevelEncoder.e(c3);
        } else {
            sb.append((char) (c3 - '3'));
        }
        return 1;
    }

    @Override // com.google.zxing.datamatrix.encoder.C40Encoder
    public int e() {
        return 3;
    }

    @Override // com.google.zxing.datamatrix.encoder.C40Encoder
    void f(EncoderContext encoderContext, StringBuilder sb) {
        encoderContext.p();
        int iA = encoderContext.g().a() - encoderContext.a();
        encoderContext.f91879f -= sb.length();
        if (encoderContext.f() > 1 || iA > 1 || encoderContext.f() != iA) {
            encoderContext.r((char) 254);
        }
        if (encoderContext.e() < 0) {
            encoderContext.o(0);
        }
    }
}
