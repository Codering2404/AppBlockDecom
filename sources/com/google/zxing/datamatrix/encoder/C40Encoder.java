package com.google.zxing.datamatrix.encoder;

import com.sun.jna.Function;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class C40Encoder implements Encoder {
    C40Encoder() {
    }

    private int b(EncoderContext encoderContext, StringBuilder sb, StringBuilder sb2, int i3) {
        int length = sb.length();
        sb.delete(length - i3, length);
        encoderContext.f91879f--;
        int iC = c(encoderContext.c(), sb2);
        encoderContext.k();
        return iC;
    }

    private static String d(CharSequence charSequence, int i3) {
        int iCharAt = (charSequence.charAt(i3) * 1600) + (charSequence.charAt(i3 + 1) * '(') + charSequence.charAt(i3 + 2) + 1;
        return new String(new char[]{(char) (iCharAt / Function.MAX_NARGS), (char) (iCharAt % Function.MAX_NARGS)});
    }

    static void g(EncoderContext encoderContext, StringBuilder sb) {
        encoderContext.s(d(sb, 0));
        sb.delete(0, 3);
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public void a(EncoderContext encoderContext) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!encoderContext.i()) {
                break;
            }
            char c3 = encoderContext.c();
            encoderContext.f91879f++;
            int iC = c(c3, sb);
            int iA = encoderContext.a() + ((sb.length() / 3) << 1);
            encoderContext.q(iA);
            int iA2 = encoderContext.g().a() - iA;
            if (!encoderContext.i()) {
                StringBuilder sb2 = new StringBuilder();
                if (sb.length() % 3 == 2 && (iA2 < 2 || iA2 > 2)) {
                    iC = b(encoderContext, sb, sb2, iC);
                }
                while (sb.length() % 3 == 1 && ((iC <= 3 && iA2 != 1) || iC > 3)) {
                    iC = b(encoderContext, sb, sb2, iC);
                }
            } else if (sb.length() % 3 == 0 && HighLevelEncoder.n(encoderContext.d(), encoderContext.f91879f, e()) != e()) {
                encoderContext.o(0);
                break;
            }
        }
        f(encoderContext, sb);
    }

    int c(char c3, StringBuilder sb) {
        if (c3 == ' ') {
            sb.append((char) 3);
            return 1;
        }
        if (c3 >= '0' && c3 <= '9') {
            sb.append((char) (c3 - ','));
            return 1;
        }
        if (c3 >= 'A' && c3 <= 'Z') {
            sb.append((char) (c3 - '3'));
            return 1;
        }
        if (c3 < ' ') {
            sb.append((char) 0);
            sb.append(c3);
            return 2;
        }
        if (c3 >= '!' && c3 <= '/') {
            sb.append((char) 1);
            sb.append((char) (c3 - '!'));
            return 2;
        }
        if (c3 >= ':' && c3 <= '@') {
            sb.append((char) 1);
            sb.append((char) (c3 - '+'));
            return 2;
        }
        if (c3 >= '[' && c3 <= '_') {
            sb.append((char) 1);
            sb.append((char) (c3 - 'E'));
            return 2;
        }
        if (c3 < '`' || c3 > 127) {
            sb.append("\u0001\u001e");
            return c((char) (c3 - 128), sb) + 2;
        }
        sb.append((char) 2);
        sb.append((char) (c3 - '`'));
        return 2;
    }

    public int e() {
        return 1;
    }

    void f(EncoderContext encoderContext, StringBuilder sb) {
        int length = (sb.length() / 3) << 1;
        int length2 = sb.length() % 3;
        int iA = encoderContext.a() + length;
        encoderContext.q(iA);
        int iA2 = encoderContext.g().a() - iA;
        if (length2 == 2) {
            sb.append((char) 0);
            while (sb.length() >= 3) {
                g(encoderContext, sb);
            }
            if (encoderContext.i()) {
                encoderContext.r((char) 254);
            }
        } else if (iA2 == 1 && length2 == 1) {
            while (sb.length() >= 3) {
                g(encoderContext, sb);
            }
            if (encoderContext.i()) {
                encoderContext.r((char) 254);
            }
            encoderContext.f91879f--;
        } else {
            if (length2 != 0) {
                throw new IllegalStateException("Unexpected case. Please report!");
            }
            while (sb.length() >= 3) {
                g(encoderContext, sb);
            }
            if (iA2 > 0 || encoderContext.i()) {
                encoderContext.r((char) 254);
            }
        }
        encoderContext.o(0);
    }
}
