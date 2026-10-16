package com.google.zxing.datamatrix.encoder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class EdifactEncoder implements Encoder {
    EdifactEncoder() {
    }

    private static void b(char c3, StringBuilder sb) {
        if (c3 >= ' ' && c3 <= '?') {
            sb.append(c3);
        } else if (c3 < '@' || c3 > '^') {
            HighLevelEncoder.e(c3);
        } else {
            sb.append((char) (c3 - '@'));
        }
    }

    private static String c(CharSequence charSequence, int i3) {
        int length = charSequence.length() - i3;
        if (length == 0) {
            throw new IllegalStateException("StringBuilder must not be empty");
        }
        int iCharAt = (charSequence.charAt(i3) << 18) + ((length >= 2 ? charSequence.charAt(i3 + 1) : (char) 0) << '\f') + ((length >= 3 ? charSequence.charAt(i3 + 2) : (char) 0) << 6) + (length >= 4 ? charSequence.charAt(i3 + 3) : (char) 0);
        char c3 = (char) ((iCharAt >> 16) & 255);
        char c4 = (char) ((iCharAt >> 8) & 255);
        char c5 = (char) (iCharAt & 255);
        StringBuilder sb = new StringBuilder(3);
        sb.append(c3);
        if (length >= 2) {
            sb.append(c4);
        }
        if (length >= 3) {
            sb.append(c5);
        }
        return sb.toString();
    }

    private static void e(EncoderContext encoderContext, CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length == 0) {
                return;
            }
            boolean z2 = true;
            if (length == 1) {
                encoderContext.p();
                int iA = encoderContext.g().a() - encoderContext.a();
                int iF = encoderContext.f();
                if (iF > iA) {
                    encoderContext.q(encoderContext.a() + 1);
                    iA = encoderContext.g().a() - encoderContext.a();
                }
                if (iF <= iA && iA <= 2) {
                    return;
                }
            }
            if (length > 4) {
                throw new IllegalStateException("Count must not exceed 4");
            }
            int i3 = length - 1;
            String strC = c(charSequence, 0);
            if (encoderContext.i() || i3 > 2) {
                z2 = false;
            }
            if (i3 <= 2) {
                encoderContext.q(encoderContext.a() + i3);
                if (encoderContext.g().a() - encoderContext.a() >= 3) {
                    encoderContext.q(encoderContext.a() + strC.length());
                    z2 = false;
                }
            }
            if (z2) {
                encoderContext.k();
                encoderContext.f91879f -= i3;
            } else {
                encoderContext.s(strC);
            }
        } finally {
            encoderContext.o(0);
        }
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public void a(EncoderContext encoderContext) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!encoderContext.i()) {
                break;
            }
            b(encoderContext.c(), sb);
            encoderContext.f91879f++;
            if (sb.length() >= 4) {
                encoderContext.s(c(sb, 0));
                sb.delete(0, 4);
                if (HighLevelEncoder.n(encoderContext.d(), encoderContext.f91879f, d()) != d()) {
                    encoderContext.o(0);
                    break;
                }
            }
        }
        sb.append((char) 31);
        e(encoderContext, sb);
    }

    public int d() {
        return 4;
    }
}
