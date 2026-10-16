package com.google.zxing.pdf417.encoder;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.stetho.dumpapp.Framer;
import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class PDF417HighLevelEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f92033a = {48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 51, 52, 53, 54, 55, 56, 57, 38, Ascii.CR, 9, 44, 58, 35, Framer.STDIN_FRAME_PREFIX, 46, 36, 47, 43, 37, 42, 61, 94, 0, 32, 0, 0, 0};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f92034b = {59, 60, 62, 64, 91, 92, 93, Framer.STDIN_REQUEST_FRAME_PREFIX, 96, 126, Framer.ENTER_FRAME_PREFIX, Ascii.CR, 9, 44, 58, 10, Framer.STDIN_FRAME_PREFIX, 46, 36, 47, 34, 124, 42, 40, 41, 63, 123, 125, 39, 0};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final byte[] f92035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final byte[] f92036d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Charset f92037e;

    /* JADX INFO: renamed from: com.google.zxing.pdf417.encoder.PDF417HighLevelEncoder$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f92038a;

        static {
            int[] iArr = new int[Compaction.values().length];
            f92038a = iArr;
            try {
                iArr[Compaction.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f92038a[Compaction.BYTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f92038a[Compaction.NUMERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        byte[] bArr = new byte[ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD];
        f92035c = bArr;
        f92036d = new byte[ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD];
        f92037e = StandardCharsets.ISO_8859_1;
        Arrays.fill(bArr, (byte) -1);
        int i3 = 0;
        int i4 = 0;
        while (true) {
            byte[] bArr2 = f92033a;
            if (i4 >= bArr2.length) {
                break;
            }
            byte b3 = bArr2[i4];
            if (b3 > 0) {
                f92035c[b3] = (byte) i4;
            }
            i4++;
        }
        Arrays.fill(f92036d, (byte) -1);
        while (true) {
            byte[] bArr3 = f92034b;
            if (i3 >= bArr3.length) {
                return;
            }
            byte b4 = bArr3[i3];
            if (b4 > 0) {
                f92036d[b4] = (byte) i3;
            }
            i3++;
        }
    }

    private static int a(String str, int i3, Charset charset) throws WriterException {
        int i4;
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        int length = str.length();
        int i5 = i3;
        while (i5 < length) {
            char cCharAt = str.charAt(i5);
            int i6 = 0;
            while (i6 < 13 && k(cCharAt) && (i4 = i5 + (i6 = i6 + 1)) < length) {
                cCharAt = str.charAt(i4);
            }
            if (i6 >= 13) {
                return i5 - i3;
            }
            char cCharAt2 = str.charAt(i5);
            if (!charsetEncoderNewEncoder.canEncode(cCharAt2)) {
                throw new WriterException("Non-encodable character detected: " + cCharAt2 + " (Unicode: " + ((int) cCharAt2) + ')');
            }
            i5++;
        }
        return i5 - i3;
    }

    private static int b(CharSequence charSequence, int i3) {
        int length = charSequence.length();
        int i4 = 0;
        if (i3 < length) {
            char cCharAt = charSequence.charAt(i3);
            while (k(cCharAt) && i3 < length) {
                i4++;
                i3++;
                if (i3 < length) {
                    cCharAt = charSequence.charAt(i3);
                }
            }
        }
        return i4;
    }

    private static int c(CharSequence charSequence, int i3) {
        int length = charSequence.length();
        int i4 = i3;
        while (i4 < length) {
            char cCharAt = charSequence.charAt(i4);
            int i5 = 0;
            while (i5 < 13 && k(cCharAt) && i4 < length) {
                i5++;
                i4++;
                if (i4 < length) {
                    cCharAt = charSequence.charAt(i4);
                }
            }
            if (i5 < 13) {
                if (i5 <= 0) {
                    if (!n(charSequence.charAt(i4))) {
                        break;
                    }
                    i4++;
                }
            } else {
                return (i4 - i3) - i5;
            }
        }
        return i4 - i3;
    }

    private static void d(byte[] bArr, int i3, int i4, int i5, StringBuilder sb) {
        int i6;
        if (i4 == 1 && i5 == 0) {
            sb.append((char) 913);
        } else if (i4 % 6 == 0) {
            sb.append((char) 924);
        } else {
            sb.append((char) 901);
        }
        if (i4 >= 6) {
            char[] cArr = new char[5];
            i6 = i3;
            while ((i3 + i4) - i6 >= 6) {
                long j3 = 0;
                for (int i7 = 0; i7 < 6; i7++) {
                    j3 = (j3 << 8) + ((long) (bArr[i6 + i7] & 255));
                }
                for (int i8 = 0; i8 < 5; i8++) {
                    cArr[i8] = (char) (j3 % 900);
                    j3 /= 900;
                }
                for (int i9 = 4; i9 >= 0; i9--) {
                    sb.append(cArr[i9]);
                }
                i6 += 6;
            }
        } else {
            i6 = i3;
        }
        while (i6 < i3 + i4) {
            sb.append((char) (bArr[i6] & 255));
            i6++;
        }
    }

    static String e(String str, Compaction compaction, Charset charset) throws WriterException {
        CharacterSetECI characterSetECIA;
        StringBuilder sb = new StringBuilder(str.length());
        if (charset == null) {
            charset = f92037e;
        } else if (!f92037e.equals(charset) && (characterSetECIA = CharacterSetECI.a(charset.name())) != null) {
            h(characterSetECIA.b(), sb);
        }
        int length = str.length();
        int i3 = AnonymousClass1.f92038a[compaction.ordinal()];
        if (i3 == 1) {
            g(str, 0, length, sb, 0);
        } else if (i3 == 2) {
            byte[] bytes = str.getBytes(charset);
            d(bytes, 0, bytes.length, 1, sb);
        } else if (i3 != 3) {
            int i4 = 0;
            int iG = 0;
            int i5 = 0;
            while (i4 < length) {
                int iB = b(str, i4);
                if (iB >= 13) {
                    sb.append((char) 902);
                    f(str, i4, iB, sb);
                    i4 += iB;
                    iG = 0;
                    i5 = 2;
                } else {
                    int iC = c(str, i4);
                    if (iC >= 5 || iB == length) {
                        if (i5 != 0) {
                            sb.append((char) 900);
                            iG = 0;
                            i5 = 0;
                        }
                        iG = g(str, i4, iC, sb, iG);
                        i4 += iC;
                    } else {
                        int iA = a(str, i4, charset);
                        if (iA == 0) {
                            iA = 1;
                        }
                        int i6 = iA + i4;
                        byte[] bytes2 = str.substring(i4, i6).getBytes(charset);
                        if (bytes2.length == 1 && i5 == 0) {
                            d(bytes2, 0, 1, 0, sb);
                        } else {
                            d(bytes2, 0, bytes2.length, i5, sb);
                            i5 = 1;
                            iG = 0;
                        }
                        i4 = i6;
                    }
                }
            }
        } else {
            sb.append((char) 902);
            f(str, 0, length, sb);
        }
        return sb.toString();
    }

    private static void f(String str, int i3, int i4, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder((i4 / 3) + 1);
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        BigInteger bigIntegerValueOf2 = BigInteger.valueOf(0L);
        int i5 = 0;
        while (i5 < i4) {
            sb2.setLength(0);
            int iMin = Math.min(44, i4 - i5);
            StringBuilder sb3 = new StringBuilder(AppEventsConstants.EVENT_PARAM_VALUE_YES);
            int i6 = i3 + i5;
            sb3.append(str.substring(i6, i6 + iMin));
            BigInteger bigInteger = new BigInteger(sb3.toString());
            do {
                sb2.append((char) bigInteger.mod(bigIntegerValueOf).intValue());
                bigInteger = bigInteger.divide(bigIntegerValueOf);
            } while (!bigInteger.equals(bigIntegerValueOf2));
            for (int length = sb2.length() - 1; length >= 0; length--) {
                sb.append(sb2.charAt(length));
            }
            i5 += iMin;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x00f4 A[EDGE_INSN: B:73:0x00f4->B:55:0x00f4 BREAK  A[LOOP:0: B:3:0x000f->B:90:0x000f], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x000f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int g(java.lang.CharSequence r16, int r17, int r18, java.lang.StringBuilder r19, int r20) {
        /*
            Method dump skipped, instruction units count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.encoder.PDF417HighLevelEncoder.g(java.lang.CharSequence, int, int, java.lang.StringBuilder, int):int");
    }

    private static void h(int i3, StringBuilder sb) throws WriterException {
        if (i3 >= 0 && i3 < 900) {
            sb.append((char) 927);
            sb.append((char) i3);
        } else if (i3 < 810900) {
            sb.append((char) 926);
            sb.append((char) ((i3 / 900) - 1));
            sb.append((char) (i3 % 900));
        } else {
            if (i3 >= 811800) {
                throw new WriterException("ECI number not in valid range from 0..811799, but was ".concat(String.valueOf(i3)));
            }
            sb.append((char) 925);
            sb.append((char) (810900 - i3));
        }
    }

    private static boolean i(char c3) {
        if (c3 != ' ') {
            return c3 >= 'a' && c3 <= 'z';
        }
        return true;
    }

    private static boolean j(char c3) {
        if (c3 != ' ') {
            return c3 >= 'A' && c3 <= 'Z';
        }
        return true;
    }

    private static boolean k(char c3) {
        return c3 >= '0' && c3 <= '9';
    }

    private static boolean l(char c3) {
        return f92035c[c3] != -1;
    }

    private static boolean m(char c3) {
        return f92036d[c3] != -1;
    }

    private static boolean n(char c3) {
        if (c3 == '\t' || c3 == '\n' || c3 == '\r') {
            return true;
        }
        return c3 >= ' ' && c3 <= '~';
    }
}
