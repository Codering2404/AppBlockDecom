package com.google.zxing.datamatrix.encoder;

import com.google.zxing.Dimension;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class HighLevelEncoder {
    public static int a(CharSequence charSequence, int i3) {
        int length = charSequence.length();
        int i4 = 0;
        if (i3 < length) {
            char cCharAt = charSequence.charAt(i3);
            while (f(cCharAt) && i3 < length) {
                i4++;
                i3++;
                if (i3 < length) {
                    cCharAt = charSequence.charAt(i3);
                }
            }
        }
        return i4;
    }

    public static String b(String str, SymbolShapeHint symbolShapeHint, Dimension dimension, Dimension dimension2) {
        int iE = 0;
        Encoder[] encoderArr = {new ASCIIEncoder(), new C40Encoder(), new TextEncoder(), new X12Encoder(), new EdifactEncoder(), new Base256Encoder()};
        EncoderContext encoderContext = new EncoderContext(str);
        encoderContext.n(symbolShapeHint);
        encoderContext.l(dimension, dimension2);
        if (str.startsWith("[)>\u001e05\u001d") && str.endsWith("\u001e\u0004")) {
            encoderContext.r((char) 236);
            encoderContext.m(2);
            encoderContext.f91879f += 7;
        } else if (str.startsWith("[)>\u001e06\u001d") && str.endsWith("\u001e\u0004")) {
            encoderContext.r((char) 237);
            encoderContext.m(2);
            encoderContext.f91879f += 7;
        }
        while (encoderContext.i()) {
            encoderArr[iE].a(encoderContext);
            if (encoderContext.e() >= 0) {
                iE = encoderContext.e();
                encoderContext.j();
            }
        }
        int iA = encoderContext.a();
        encoderContext.p();
        int iA2 = encoderContext.g().a();
        if (iA < iA2 && iE != 0 && iE != 5 && iE != 4) {
            encoderContext.r((char) 254);
        }
        StringBuilder sbB = encoderContext.b();
        if (sbB.length() < iA2) {
            sbB.append((char) 129);
        }
        while (sbB.length() < iA2) {
            sbB.append(o((char) 129, sbB.length() + 1));
        }
        return encoderContext.b().toString();
    }

    private static int c(float[] fArr, int[] iArr, int i3, byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
        for (int i4 = 0; i4 < 6; i4++) {
            int iCeil = (int) Math.ceil(fArr[i4]);
            iArr[i4] = iCeil;
            if (i3 > iCeil) {
                Arrays.fill(bArr, (byte) 0);
                i3 = iCeil;
            }
            if (i3 == iCeil) {
                bArr[i4] = (byte) (bArr[i4] + 1);
            }
        }
        return i3;
    }

    private static int d(byte[] bArr) {
        int i3 = 0;
        for (int i4 = 0; i4 < 6; i4++) {
            i3 += bArr[i4];
        }
        return i3;
    }

    static void e(char c3) {
        String hexString = Integer.toHexString(c3);
        throw new IllegalArgumentException("Illegal character: " + c3 + " (0x" + ("0000".substring(0, 4 - hexString.length()) + hexString) + ')');
    }

    static boolean f(char c3) {
        return c3 >= '0' && c3 <= '9';
    }

    static boolean g(char c3) {
        return c3 >= 128 && c3 <= 255;
    }

    private static boolean h(char c3) {
        if (c3 == ' ') {
            return true;
        }
        if (c3 < '0' || c3 > '9') {
            return c3 >= 'A' && c3 <= 'Z';
        }
        return true;
    }

    private static boolean i(char c3) {
        return c3 >= ' ' && c3 <= '^';
    }

    private static boolean j(char c3) {
        if (c3 == ' ') {
            return true;
        }
        if (c3 < '0' || c3 > '9') {
            return c3 >= 'a' && c3 <= 'z';
        }
        return true;
    }

    private static boolean k(char c3) {
        if (m(c3) || c3 == ' ') {
            return true;
        }
        if (c3 < '0' || c3 > '9') {
            return c3 >= 'A' && c3 <= 'Z';
        }
        return true;
    }

    private static boolean l(char c3) {
        return false;
    }

    private static boolean m(char c3) {
        return c3 == '\r' || c3 == '*' || c3 == '>';
    }

    /* JADX WARN: Code restructure failed: missing block: B:118:0x01d8, code lost:
    
        return r17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static int n(java.lang.CharSequence r21, int r22, int r23) {
        /*
            Method dump skipped, instruction units count: 481
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.datamatrix.encoder.HighLevelEncoder.n(java.lang.CharSequence, int, int):int");
    }

    private static char o(char c3, int i3) {
        int i4 = c3 + ((i3 * 149) % 253) + 1;
        if (i4 > 254) {
            i4 -= 254;
        }
        return (char) i4;
    }
}
