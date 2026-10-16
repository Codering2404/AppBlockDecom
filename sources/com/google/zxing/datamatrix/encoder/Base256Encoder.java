package com.google.zxing.datamatrix.encoder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class Base256Encoder implements Encoder {
    Base256Encoder() {
    }

    private static char c(char c3, int i3) {
        int i4 = c3 + ((i3 * 149) % 255) + 1;
        return i4 <= 255 ? (char) i4 : (char) (i4 - 256);
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public void a(EncoderContext encoderContext) {
        StringBuilder sb = new StringBuilder();
        sb.append((char) 0);
        while (true) {
            if (!encoderContext.i()) {
                break;
            }
            sb.append(encoderContext.c());
            encoderContext.f91879f++;
            if (HighLevelEncoder.n(encoderContext.d(), encoderContext.f91879f, b()) != b()) {
                encoderContext.o(0);
                break;
            }
        }
        int length = sb.length() - 1;
        int iA = encoderContext.a() + length + 1;
        encoderContext.q(iA);
        boolean z2 = encoderContext.g().a() - iA > 0;
        if (encoderContext.i() || z2) {
            if (length <= 249) {
                sb.setCharAt(0, (char) length);
            } else {
                if (length > 1555) {
                    throw new IllegalStateException("Message length not in valid ranges: ".concat(String.valueOf(length)));
                }
                sb.setCharAt(0, (char) ((length / 250) + 249));
                sb.insert(1, (char) (length % 250));
            }
        }
        int length2 = sb.length();
        for (int i3 = 0; i3 < length2; i3++) {
            encoderContext.r(c(sb.charAt(i3), encoderContext.a() + 1));
        }
    }

    public int b() {
        return 5;
    }
}
