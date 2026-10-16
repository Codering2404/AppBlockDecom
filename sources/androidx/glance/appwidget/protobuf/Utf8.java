package androidx.glance.appwidget.protobuf;

import com.applovin.exoplayer2.common.base.Ascii;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class Utf8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Processor f39313a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class DecodeUtil {
        /* JADX INFO: Access modifiers changed from: private */
        public static void h(byte b3, byte b4, byte b5, byte b6, char[] cArr, int i3) throws InvalidProtocolBufferException {
            if (m(b4) || (((b3 << Ascii.FS) + (b4 + 112)) >> 30) != 0 || m(b5) || m(b6)) {
                throw InvalidProtocolBufferException.d();
            }
            int iR = ((b3 & 7) << 18) | (r(b4) << 12) | (r(b5) << 6) | r(b6);
            cArr[i3] = l(iR);
            cArr[i3 + 1] = q(iR);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void i(byte b3, char[] cArr, int i3) {
            cArr[i3] = (char) b3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void j(byte b3, byte b4, byte b5, char[] cArr, int i3) throws InvalidProtocolBufferException {
            if (m(b4) || ((b3 == -32 && b4 < -96) || ((b3 == -19 && b4 >= -96) || m(b5)))) {
                throw InvalidProtocolBufferException.d();
            }
            cArr[i3] = (char) (((b3 & Ascii.SI) << 12) | (r(b4) << 6) | r(b5));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void k(byte b3, byte b4, char[] cArr, int i3) throws InvalidProtocolBufferException {
            if (b3 < -62 || m(b4)) {
                throw InvalidProtocolBufferException.d();
            }
            cArr[i3] = (char) (((b3 & Ascii.US) << 6) | r(b4));
        }

        private static char l(int i3) {
            return (char) ((i3 >>> 10) + 55232);
        }

        private static boolean m(byte b3) {
            return b3 > -65;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean n(byte b3) {
            return b3 >= 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean o(byte b3) {
            return b3 < -16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean p(byte b3) {
            return b3 < -32;
        }

        private static char q(int i3) {
            return (char) ((i3 & 1023) + 56320);
        }

        private static int r(byte b3) {
            return b3 & 63;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class Processor {
        Processor() {
        }

        private static int m(ByteBuffer byteBuffer, int i3, int i4) {
            int iM = i3 + Utf8.m(byteBuffer, i3, i4);
            while (iM < i4) {
                int i5 = iM + 1;
                byte b3 = byteBuffer.get(iM);
                if (b3 >= 0) {
                    iM = i5;
                } else if (b3 < -32) {
                    if (i5 >= i4) {
                        return b3;
                    }
                    if (b3 < -62 || byteBuffer.get(i5) > -65) {
                        return -1;
                    }
                    iM += 2;
                } else {
                    if (b3 >= -16) {
                        if (i5 >= i4 - 2) {
                            return Utf8.q(byteBuffer, b3, i5, i4 - i5);
                        }
                        int i6 = iM + 2;
                        byte b4 = byteBuffer.get(i5);
                        if (b4 <= -65 && (((b3 << Ascii.FS) + (b4 + 112)) >> 30) == 0) {
                            int i7 = iM + 3;
                            if (byteBuffer.get(i6) <= -65) {
                                iM += 4;
                                if (byteBuffer.get(i7) > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                    if (i5 >= i4 - 1) {
                        return Utf8.q(byteBuffer, b3, i5, i4 - i5);
                    }
                    int i8 = iM + 2;
                    byte b5 = byteBuffer.get(i5);
                    if (b5 > -65 || ((b3 == -32 && b5 < -96) || ((b3 == -19 && b5 >= -96) || byteBuffer.get(i8) > -65))) {
                        return -1;
                    }
                    iM += 3;
                }
            }
            return 0;
        }

        final String a(ByteBuffer byteBuffer, int i3, int i4) {
            if (byteBuffer.hasArray()) {
                return b(byteBuffer.array(), byteBuffer.arrayOffset() + i3, i4);
            }
            return byteBuffer.isDirect() ? d(byteBuffer, i3, i4) : c(byteBuffer, i3, i4);
        }

        abstract String b(byte[] bArr, int i3, int i4);

        final String c(ByteBuffer byteBuffer, int i3, int i4) throws InvalidProtocolBufferException {
            if ((i3 | i4 | ((byteBuffer.limit() - i3) - i4)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i3), Integer.valueOf(i4)));
            }
            int i5 = i3 + i4;
            char[] cArr = new char[i4];
            int i6 = 0;
            while (i3 < i5) {
                byte b3 = byteBuffer.get(i3);
                if (!DecodeUtil.n(b3)) {
                    break;
                }
                i3++;
                DecodeUtil.i(b3, cArr, i6);
                i6++;
            }
            int i7 = i6;
            while (i3 < i5) {
                int i8 = i3 + 1;
                byte b4 = byteBuffer.get(i3);
                if (DecodeUtil.n(b4)) {
                    int i9 = i7 + 1;
                    DecodeUtil.i(b4, cArr, i7);
                    int i10 = i8;
                    while (i10 < i5) {
                        byte b5 = byteBuffer.get(i10);
                        if (!DecodeUtil.n(b5)) {
                            break;
                        }
                        i10++;
                        DecodeUtil.i(b5, cArr, i9);
                        i9++;
                    }
                    i7 = i9;
                    i3 = i10;
                } else if (DecodeUtil.p(b4)) {
                    if (i8 >= i5) {
                        throw InvalidProtocolBufferException.d();
                    }
                    i3 += 2;
                    DecodeUtil.k(b4, byteBuffer.get(i8), cArr, i7);
                    i7++;
                } else if (DecodeUtil.o(b4)) {
                    if (i8 >= i5 - 1) {
                        throw InvalidProtocolBufferException.d();
                    }
                    int i11 = i3 + 2;
                    i3 += 3;
                    DecodeUtil.j(b4, byteBuffer.get(i8), byteBuffer.get(i11), cArr, i7);
                    i7++;
                } else {
                    if (i8 >= i5 - 2) {
                        throw InvalidProtocolBufferException.d();
                    }
                    byte b6 = byteBuffer.get(i8);
                    int i12 = i3 + 3;
                    byte b7 = byteBuffer.get(i3 + 2);
                    i3 += 4;
                    DecodeUtil.h(b4, b6, b7, byteBuffer.get(i12), cArr, i7);
                    i7 += 2;
                }
            }
            return new String(cArr, 0, i7);
        }

        abstract String d(ByteBuffer byteBuffer, int i3, int i4);

        abstract int e(CharSequence charSequence, byte[] bArr, int i3, int i4);

        final void f(CharSequence charSequence, ByteBuffer byteBuffer) {
            if (byteBuffer.hasArray()) {
                int iArrayOffset = byteBuffer.arrayOffset();
                byteBuffer.position(Utf8.i(charSequence, byteBuffer.array(), byteBuffer.position() + iArrayOffset, byteBuffer.remaining()) - iArrayOffset);
            } else if (byteBuffer.isDirect()) {
                h(charSequence, byteBuffer);
            } else {
                g(charSequence, byteBuffer);
            }
        }

        final void g(CharSequence charSequence, ByteBuffer byteBuffer) {
            int i3;
            int length = charSequence.length();
            int iPosition = byteBuffer.position();
            int i4 = 0;
            while (i4 < length) {
                try {
                    char cCharAt = charSequence.charAt(i4);
                    if (cCharAt >= 128) {
                        break;
                    }
                    byteBuffer.put(iPosition + i4, (byte) cCharAt);
                    i4++;
                } catch (IndexOutOfBoundsException unused) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i4) + " at index " + (byteBuffer.position() + Math.max(i4, (iPosition - byteBuffer.position()) + 1)));
                }
            }
            if (i4 == length) {
                byteBuffer.position(iPosition + i4);
                return;
            }
            iPosition += i4;
            while (i4 < length) {
                char cCharAt2 = charSequence.charAt(i4);
                if (cCharAt2 < 128) {
                    byteBuffer.put(iPosition, (byte) cCharAt2);
                } else if (cCharAt2 < 2048) {
                    int i5 = iPosition + 1;
                    try {
                        byteBuffer.put(iPosition, (byte) ((cCharAt2 >>> 6) | 192));
                        byteBuffer.put(i5, (byte) ((cCharAt2 & '?') | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                        iPosition = i5;
                    } catch (IndexOutOfBoundsException unused2) {
                        iPosition = i5;
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i4) + " at index " + (byteBuffer.position() + Math.max(i4, (iPosition - byteBuffer.position()) + 1)));
                    }
                } else {
                    if (cCharAt2 >= 55296 && 57343 >= cCharAt2) {
                        int i6 = i4 + 1;
                        if (i6 != length) {
                            try {
                                char cCharAt3 = charSequence.charAt(i6);
                                if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                    int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                    int i7 = iPosition + 1;
                                    try {
                                        byteBuffer.put(iPosition, (byte) ((codePoint >>> 18) | 240));
                                        i3 = iPosition + 2;
                                    } catch (IndexOutOfBoundsException unused3) {
                                        iPosition = i7;
                                        i4 = i6;
                                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i4) + " at index " + (byteBuffer.position() + Math.max(i4, (iPosition - byteBuffer.position()) + 1)));
                                    }
                                    try {
                                        byteBuffer.put(i7, (byte) (((codePoint >>> 12) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                                        iPosition += 3;
                                        byteBuffer.put(i3, (byte) (((codePoint >>> 6) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                                        byteBuffer.put(iPosition, (byte) ((codePoint & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                                        i4 = i6;
                                    } catch (IndexOutOfBoundsException unused4) {
                                        i4 = i6;
                                        iPosition = i3;
                                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i4) + " at index " + (byteBuffer.position() + Math.max(i4, (iPosition - byteBuffer.position()) + 1)));
                                    }
                                } else {
                                    i4 = i6;
                                }
                            } catch (IndexOutOfBoundsException unused5) {
                            }
                        }
                        throw new UnpairedSurrogateException(i4, length);
                    }
                    int i8 = iPosition + 1;
                    byteBuffer.put(iPosition, (byte) ((cCharAt2 >>> '\f') | 224));
                    iPosition += 2;
                    byteBuffer.put(i8, (byte) (((cCharAt2 >>> 6) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                    byteBuffer.put(iPosition, (byte) ((cCharAt2 & '?') | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                }
                i4++;
                iPosition++;
            }
            byteBuffer.position(iPosition);
        }

        abstract void h(CharSequence charSequence, ByteBuffer byteBuffer);

        final boolean i(ByteBuffer byteBuffer, int i3, int i4) {
            return k(0, byteBuffer, i3, i4) == 0;
        }

        final boolean j(byte[] bArr, int i3, int i4) {
            return l(0, bArr, i3, i4) == 0;
        }

        final int k(int i3, ByteBuffer byteBuffer, int i4, int i5) {
            if (!byteBuffer.hasArray()) {
                return byteBuffer.isDirect() ? o(i3, byteBuffer, i4, i5) : n(i3, byteBuffer, i4, i5);
            }
            int iArrayOffset = byteBuffer.arrayOffset();
            return l(i3, byteBuffer.array(), i4 + iArrayOffset, iArrayOffset + i5);
        }

        abstract int l(int i3, byte[] bArr, int i4, int i5);

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
        
            if (r8.get(r9) > (-65)) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x004c, code lost:
        
            if (r8.get(r9) > (-65)) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x008f, code lost:
        
            if (r8.get(r7) > (-65)) goto L53;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final int n(int r7, java.nio.ByteBuffer r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L92
                if (r9 < r10) goto L5
                return r7
            L5:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L1e
                r7 = -62
                if (r0 < r7) goto L1d
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L1a
                goto L1d
            L1a:
                r9 = r7
                goto L92
            L1d:
                return r2
            L1e:
                r4 = -16
                if (r0 >= r4) goto L4f
                int r7 = r7 >> 8
                int r7 = ~r7
                byte r7 = (byte) r7
                if (r7 != 0) goto L38
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r7 < r10) goto L35
                int r7 = androidx.glance.appwidget.protobuf.Utf8.a(r0, r9)
                return r7
            L35:
                r5 = r9
                r9 = r7
                r7 = r5
            L38:
                if (r7 > r3) goto L4e
                r4 = -96
                if (r0 != r1) goto L40
                if (r7 < r4) goto L4e
            L40:
                r1 = -19
                if (r0 != r1) goto L46
                if (r7 >= r4) goto L4e
            L46:
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L1a
            L4e:
                return r2
            L4f:
                int r1 = r7 >> 8
                int r1 = ~r1
                byte r1 = (byte) r1
                if (r1 != 0) goto L64
                int r7 = r9 + 1
                byte r1 = r8.get(r9)
                if (r7 < r10) goto L62
                int r7 = androidx.glance.appwidget.protobuf.Utf8.a(r0, r1)
                return r7
            L62:
                r9 = 0
                goto L6a
            L64:
                int r7 = r7 >> 16
                byte r7 = (byte) r7
                r5 = r9
                r9 = r7
                r7 = r5
            L6a:
                if (r9 != 0) goto L7c
                int r9 = r7 + 1
                byte r7 = r8.get(r7)
                if (r9 < r10) goto L79
                int r7 = androidx.glance.appwidget.protobuf.Utf8.b(r0, r1, r7)
                return r7
            L79:
                r5 = r9
                r9 = r7
                r7 = r5
            L7c:
                if (r1 > r3) goto L91
                int r0 = r0 << 28
                int r1 = r1 + 112
                int r0 = r0 + r1
                int r0 = r0 >> 30
                if (r0 != 0) goto L91
                if (r9 > r3) goto L91
                int r9 = r7 + 1
                byte r7 = r8.get(r7)
                if (r7 <= r3) goto L92
            L91:
                return r2
            L92:
                int r7 = m(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.protobuf.Utf8.Processor.n(int, java.nio.ByteBuffer, int, int):int");
        }

        abstract int o(int i3, ByteBuffer byteBuffer, int i4, int i5);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SafeProcessor extends Processor {
        SafeProcessor() {
        }

        private static int p(byte[] bArr, int i3, int i4) {
            while (i3 < i4 && bArr[i3] >= 0) {
                i3++;
            }
            if (i3 >= i4) {
                return 0;
            }
            return q(bArr, i3, i4);
        }

        private static int q(byte[] bArr, int i3, int i4) {
            while (i3 < i4) {
                int i5 = i3 + 1;
                byte b3 = bArr[i3];
                if (b3 < 0) {
                    if (b3 < -32) {
                        if (i5 >= i4) {
                            return b3;
                        }
                        if (b3 >= -62) {
                            i3 += 2;
                            if (bArr[i5] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (b3 >= -16) {
                        if (i5 >= i4 - 2) {
                            return Utf8.r(bArr, i5, i4);
                        }
                        int i6 = i3 + 2;
                        byte b4 = bArr[i5];
                        if (b4 <= -65 && (((b3 << Ascii.FS) + (b4 + 112)) >> 30) == 0) {
                            int i7 = i3 + 3;
                            if (bArr[i6] <= -65) {
                                i3 += 4;
                                if (bArr[i7] > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                    if (i5 >= i4 - 1) {
                        return Utf8.r(bArr, i5, i4);
                    }
                    int i8 = i3 + 2;
                    byte b5 = bArr[i5];
                    if (b5 <= -65 && ((b3 != -32 || b5 >= -96) && (b3 != -19 || b5 < -96))) {
                        i3 += 3;
                        if (bArr[i8] > -65) {
                        }
                    }
                    return -1;
                }
                i3 = i5;
            }
            return 0;
        }

        @Override // androidx.glance.appwidget.protobuf.Utf8.Processor
        String b(byte[] bArr, int i3, int i4) throws InvalidProtocolBufferException {
            if ((i3 | i4 | ((bArr.length - i3) - i4)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i3), Integer.valueOf(i4)));
            }
            int i5 = i3 + i4;
            char[] cArr = new char[i4];
            int i6 = 0;
            while (i3 < i5) {
                byte b3 = bArr[i3];
                if (!DecodeUtil.n(b3)) {
                    break;
                }
                i3++;
                DecodeUtil.i(b3, cArr, i6);
                i6++;
            }
            int i7 = i6;
            while (i3 < i5) {
                int i8 = i3 + 1;
                byte b4 = bArr[i3];
                if (DecodeUtil.n(b4)) {
                    int i9 = i7 + 1;
                    DecodeUtil.i(b4, cArr, i7);
                    int i10 = i8;
                    while (i10 < i5) {
                        byte b5 = bArr[i10];
                        if (!DecodeUtil.n(b5)) {
                            break;
                        }
                        i10++;
                        DecodeUtil.i(b5, cArr, i9);
                        i9++;
                    }
                    i7 = i9;
                    i3 = i10;
                } else if (DecodeUtil.p(b4)) {
                    if (i8 >= i5) {
                        throw InvalidProtocolBufferException.d();
                    }
                    i3 += 2;
                    DecodeUtil.k(b4, bArr[i8], cArr, i7);
                    i7++;
                } else if (DecodeUtil.o(b4)) {
                    if (i8 >= i5 - 1) {
                        throw InvalidProtocolBufferException.d();
                    }
                    int i11 = i3 + 2;
                    i3 += 3;
                    DecodeUtil.j(b4, bArr[i8], bArr[i11], cArr, i7);
                    i7++;
                } else {
                    if (i8 >= i5 - 2) {
                        throw InvalidProtocolBufferException.d();
                    }
                    byte b6 = bArr[i8];
                    int i12 = i3 + 3;
                    byte b7 = bArr[i3 + 2];
                    i3 += 4;
                    DecodeUtil.h(b4, b6, b7, bArr[i12], cArr, i7);
                    i7 += 2;
                }
            }
            return new String(cArr, 0, i7);
        }

        @Override // androidx.glance.appwidget.protobuf.Utf8.Processor
        String d(ByteBuffer byteBuffer, int i3, int i4) {
            return c(byteBuffer, i3, i4);
        }

        @Override // androidx.glance.appwidget.protobuf.Utf8.Processor
        int e(CharSequence charSequence, byte[] bArr, int i3, int i4) {
            int i5;
            int i6;
            char cCharAt;
            int length = charSequence.length();
            int i7 = i4 + i3;
            int i8 = 0;
            while (i8 < length && (i6 = i8 + i3) < i7 && (cCharAt = charSequence.charAt(i8)) < 128) {
                bArr[i6] = (byte) cCharAt;
                i8++;
            }
            if (i8 == length) {
                return i3 + length;
            }
            int i9 = i3 + i8;
            while (i8 < length) {
                char cCharAt2 = charSequence.charAt(i8);
                if (cCharAt2 < 128 && i9 < i7) {
                    bArr[i9] = (byte) cCharAt2;
                    i9++;
                } else if (cCharAt2 < 2048 && i9 <= i7 - 2) {
                    int i10 = i9 + 1;
                    bArr[i9] = (byte) ((cCharAt2 >>> 6) | 960);
                    i9 += 2;
                    bArr[i10] = (byte) ((cCharAt2 & '?') | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                } else {
                    if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i9 > i7 - 3) {
                        if (i9 > i7 - 4) {
                            if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i5 = i8 + 1) == charSequence.length() || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i5)))) {
                                throw new UnpairedSurrogateException(i8, length);
                            }
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i9);
                        }
                        int i11 = i8 + 1;
                        if (i11 != charSequence.length()) {
                            char cCharAt3 = charSequence.charAt(i11);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                bArr[i9] = (byte) ((codePoint >>> 18) | 240);
                                bArr[i9 + 1] = (byte) (((codePoint >>> 12) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                                int i12 = i9 + 3;
                                bArr[i9 + 2] = (byte) (((codePoint >>> 6) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                                i9 += 4;
                                bArr[i12] = (byte) ((codePoint & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                                i8 = i11;
                            } else {
                                i8 = i11;
                            }
                        }
                        throw new UnpairedSurrogateException(i8 - 1, length);
                    }
                    bArr[i9] = (byte) ((cCharAt2 >>> '\f') | 480);
                    int i13 = i9 + 2;
                    bArr[i9 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                    i9 += 3;
                    bArr[i13] = (byte) ((cCharAt2 & '?') | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                }
                i8++;
            }
            return i9;
        }

        @Override // androidx.glance.appwidget.protobuf.Utf8.Processor
        void h(CharSequence charSequence, ByteBuffer byteBuffer) {
            g(charSequence, byteBuffer);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
        
            if (r8[r9] > (-65)) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0046, code lost:
        
            if (r8[r9] > (-65)) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0083, code lost:
        
            if (r8[r7] > (-65)) goto L53;
         */
        @Override // androidx.glance.appwidget.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        int l(int r7, byte[] r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L86
                if (r9 < r10) goto L5
                return r7
            L5:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L1c
                r7 = -62
                if (r0 < r7) goto L1b
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r9 <= r3) goto L18
                goto L1b
            L18:
                r9 = r7
                goto L86
            L1b:
                return r2
            L1c:
                r4 = -16
                if (r0 >= r4) goto L49
                int r7 = r7 >> 8
                int r7 = ~r7
                byte r7 = (byte) r7
                if (r7 != 0) goto L34
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r7 < r10) goto L31
                int r7 = androidx.glance.appwidget.protobuf.Utf8.a(r0, r9)
                return r7
            L31:
                r5 = r9
                r9 = r7
                r7 = r5
            L34:
                if (r7 > r3) goto L48
                r4 = -96
                if (r0 != r1) goto L3c
                if (r7 < r4) goto L48
            L3c:
                r1 = -19
                if (r0 != r1) goto L42
                if (r7 >= r4) goto L48
            L42:
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r9 <= r3) goto L18
            L48:
                return r2
            L49:
                int r1 = r7 >> 8
                int r1 = ~r1
                byte r1 = (byte) r1
                if (r1 != 0) goto L5c
                int r7 = r9 + 1
                r1 = r8[r9]
                if (r7 < r10) goto L5a
                int r7 = androidx.glance.appwidget.protobuf.Utf8.a(r0, r1)
                return r7
            L5a:
                r9 = 0
                goto L62
            L5c:
                int r7 = r7 >> 16
                byte r7 = (byte) r7
                r5 = r9
                r9 = r7
                r7 = r5
            L62:
                if (r9 != 0) goto L72
                int r9 = r7 + 1
                r7 = r8[r7]
                if (r9 < r10) goto L6f
                int r7 = androidx.glance.appwidget.protobuf.Utf8.b(r0, r1, r7)
                return r7
            L6f:
                r5 = r9
                r9 = r7
                r7 = r5
            L72:
                if (r1 > r3) goto L85
                int r0 = r0 << 28
                int r1 = r1 + 112
                int r0 = r0 + r1
                int r0 = r0 >> 30
                if (r0 != 0) goto L85
                if (r9 > r3) goto L85
                int r9 = r7 + 1
                r7 = r8[r7]
                if (r7 <= r3) goto L86
            L85:
                return r2
            L86:
                int r7 = p(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.protobuf.Utf8.SafeProcessor.l(int, byte[], int, int):int");
        }

        @Override // androidx.glance.appwidget.protobuf.Utf8.Processor
        int o(int i3, ByteBuffer byteBuffer, int i4, int i5) {
            return n(i3, byteBuffer, i4, i5);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class UnpairedSurrogateException extends IllegalArgumentException {
        UnpairedSurrogateException(int i3, int i4) {
            super("Unpaired surrogate at index " + i3 + " of " + i4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class UnsafeProcessor extends Processor {
        UnsafeProcessor() {
        }

        static boolean p() {
            return UnsafeUtil.J() && UnsafeUtil.K();
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
        
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0064, code lost:
        
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static int q(long r10, int r12) {
            /*
                int r0 = s(r10, r12)
                long r1 = (long) r0
                long r10 = r10 + r1
                int r12 = r12 - r0
            L7:
                r0 = 0
                r1 = r0
            L9:
                r2 = 1
                if (r12 <= 0) goto L1a
                long r4 = r10 + r2
                byte r1 = androidx.glance.appwidget.protobuf.UnsafeUtil.x(r10)
                if (r1 < 0) goto L19
                int r12 = r12 + (-1)
                r10 = r4
                goto L9
            L19:
                r10 = r4
            L1a:
                if (r12 != 0) goto L1d
                return r0
            L1d:
                int r0 = r12 + (-1)
                r4 = -32
                r5 = -1
                r6 = -65
                if (r1 >= r4) goto L3a
                if (r0 != 0) goto L29
                return r1
            L29:
                int r12 = r12 + (-2)
                r0 = -62
                if (r1 < r0) goto L39
                long r2 = r2 + r10
                byte r10 = androidx.glance.appwidget.protobuf.UnsafeUtil.x(r10)
                if (r10 <= r6) goto L37
                goto L39
            L37:
                r10 = r2
                goto L7
            L39:
                return r5
            L3a:
                r7 = -16
                r8 = 2
                if (r1 >= r7) goto L65
                r7 = 2
                if (r0 >= r7) goto L48
                int r10 = u(r10, r1, r0)
                return r10
            L48:
                int r12 = r12 + (-3)
                long r2 = r2 + r10
                byte r0 = androidx.glance.appwidget.protobuf.UnsafeUtil.x(r10)
                if (r0 > r6) goto L64
                r7 = -96
                if (r1 != r4) goto L57
                if (r0 < r7) goto L64
            L57:
                r4 = -19
                if (r1 != r4) goto L5d
                if (r0 >= r7) goto L64
            L5d:
                long r10 = r10 + r8
                byte r0 = androidx.glance.appwidget.protobuf.UnsafeUtil.x(r2)
                if (r0 <= r6) goto L7
            L64:
                return r5
            L65:
                r4 = 3
                if (r0 >= r4) goto L6d
                int r10 = u(r10, r1, r0)
                return r10
            L6d:
                int r12 = r12 + (-4)
                long r2 = r2 + r10
                byte r0 = androidx.glance.appwidget.protobuf.UnsafeUtil.x(r10)
                if (r0 > r6) goto L8f
                int r1 = r1 << 28
                int r0 = r0 + 112
                int r1 = r1 + r0
                int r0 = r1 >> 30
                if (r0 != 0) goto L8f
                long r8 = r8 + r10
                byte r0 = androidx.glance.appwidget.protobuf.UnsafeUtil.x(r2)
                if (r0 > r6) goto L8f
                r0 = 3
                long r10 = r10 + r0
                byte r0 = androidx.glance.appwidget.protobuf.UnsafeUtil.x(r8)
                if (r0 <= r6) goto L7
            L8f:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.protobuf.Utf8.UnsafeProcessor.q(long, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
        
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0064, code lost:
        
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static int r(byte[] r10, long r11, int r13) {
            /*
                int r0 = t(r10, r11, r13)
                int r13 = r13 - r0
                long r0 = (long) r0
                long r11 = r11 + r0
            L7:
                r0 = 0
                r1 = r0
            L9:
                r2 = 1
                if (r13 <= 0) goto L1a
                long r4 = r11 + r2
                byte r1 = androidx.glance.appwidget.protobuf.UnsafeUtil.y(r10, r11)
                if (r1 < 0) goto L19
                int r13 = r13 + (-1)
                r11 = r4
                goto L9
            L19:
                r11 = r4
            L1a:
                if (r13 != 0) goto L1d
                return r0
            L1d:
                int r0 = r13 + (-1)
                r4 = -32
                r5 = -1
                r6 = -65
                if (r1 >= r4) goto L3a
                if (r0 != 0) goto L29
                return r1
            L29:
                int r13 = r13 + (-2)
                r0 = -62
                if (r1 < r0) goto L39
                long r2 = r2 + r11
                byte r11 = androidx.glance.appwidget.protobuf.UnsafeUtil.y(r10, r11)
                if (r11 <= r6) goto L37
                goto L39
            L37:
                r11 = r2
                goto L7
            L39:
                return r5
            L3a:
                r7 = -16
                r8 = 2
                if (r1 >= r7) goto L65
                r7 = 2
                if (r0 >= r7) goto L48
                int r10 = v(r10, r1, r11, r0)
                return r10
            L48:
                int r13 = r13 + (-3)
                long r2 = r2 + r11
                byte r0 = androidx.glance.appwidget.protobuf.UnsafeUtil.y(r10, r11)
                if (r0 > r6) goto L64
                r7 = -96
                if (r1 != r4) goto L57
                if (r0 < r7) goto L64
            L57:
                r4 = -19
                if (r1 != r4) goto L5d
                if (r0 >= r7) goto L64
            L5d:
                long r11 = r11 + r8
                byte r0 = androidx.glance.appwidget.protobuf.UnsafeUtil.y(r10, r2)
                if (r0 <= r6) goto L7
            L64:
                return r5
            L65:
                r4 = 3
                if (r0 >= r4) goto L6d
                int r10 = v(r10, r1, r11, r0)
                return r10
            L6d:
                int r13 = r13 + (-4)
                long r2 = r2 + r11
                byte r0 = androidx.glance.appwidget.protobuf.UnsafeUtil.y(r10, r11)
                if (r0 > r6) goto L8f
                int r1 = r1 << 28
                int r0 = r0 + 112
                int r1 = r1 + r0
                int r0 = r1 >> 30
                if (r0 != 0) goto L8f
                long r8 = r8 + r11
                byte r0 = androidx.glance.appwidget.protobuf.UnsafeUtil.y(r10, r2)
                if (r0 > r6) goto L8f
                r0 = 3
                long r11 = r11 + r0
                byte r0 = androidx.glance.appwidget.protobuf.UnsafeUtil.y(r10, r8)
                if (r0 <= r6) goto L7
            L8f:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.protobuf.Utf8.UnsafeProcessor.r(byte[], long, int):int");
        }

        private static int s(long j3, int i3) {
            if (i3 < 16) {
                return 0;
            }
            int i4 = (int) ((-j3) & 7);
            int i5 = i4;
            while (i5 > 0) {
                long j4 = 1 + j3;
                if (UnsafeUtil.x(j3) < 0) {
                    return i4 - i5;
                }
                i5--;
                j3 = j4;
            }
            int i6 = i3 - i4;
            while (i6 >= 8 && (UnsafeUtil.E(j3) & (-9187201950435737472L)) == 0) {
                j3 += 8;
                i6 -= 8;
            }
            return i3 - i6;
        }

        private static int t(byte[] bArr, long j3, int i3) {
            int i4 = 0;
            if (i3 < 16) {
                return 0;
            }
            int i5 = 8 - (((int) j3) & 7);
            while (i4 < i5) {
                long j4 = 1 + j3;
                if (UnsafeUtil.y(bArr, j3) < 0) {
                    return i4;
                }
                i4++;
                j3 = j4;
            }
            while (true) {
                int i6 = i4 + 8;
                if (i6 > i3 || (UnsafeUtil.F(bArr, UnsafeUtil.f39296h + j3) & (-9187201950435737472L)) != 0) {
                    break;
                }
                j3 += 8;
                i4 = i6;
            }
            while (i4 < i3) {
                long j5 = j3 + 1;
                if (UnsafeUtil.y(bArr, j3) < 0) {
                    return i4;
                }
                i4++;
                j3 = j5;
            }
            return i3;
        }

        private static int u(long j3, int i3, int i4) {
            if (i4 == 0) {
                return Utf8.n(i3);
            }
            if (i4 == 1) {
                return Utf8.o(i3, UnsafeUtil.x(j3));
            }
            if (i4 == 2) {
                return Utf8.p(i3, UnsafeUtil.x(j3), UnsafeUtil.x(j3 + 1));
            }
            throw new AssertionError();
        }

        private static int v(byte[] bArr, int i3, long j3, int i4) {
            if (i4 == 0) {
                return Utf8.n(i3);
            }
            if (i4 == 1) {
                return Utf8.o(i3, UnsafeUtil.y(bArr, j3));
            }
            if (i4 == 2) {
                return Utf8.p(i3, UnsafeUtil.y(bArr, j3), UnsafeUtil.y(bArr, j3 + 1));
            }
            throw new AssertionError();
        }

        @Override // androidx.glance.appwidget.protobuf.Utf8.Processor
        String b(byte[] bArr, int i3, int i4) throws InvalidProtocolBufferException {
            Charset charset = Internal.f39080b;
            String str = new String(bArr, i3, i4, charset);
            if (str.contains("�") && !Arrays.equals(str.getBytes(charset), Arrays.copyOfRange(bArr, i3, i4 + i3))) {
                throw InvalidProtocolBufferException.d();
            }
            return str;
        }

        @Override // androidx.glance.appwidget.protobuf.Utf8.Processor
        String d(ByteBuffer byteBuffer, int i3, int i4) throws InvalidProtocolBufferException {
            if ((i3 | i4 | ((byteBuffer.limit() - i3) - i4)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i3), Integer.valueOf(i4)));
            }
            long jK = UnsafeUtil.k(byteBuffer) + ((long) i3);
            long j3 = ((long) i4) + jK;
            char[] cArr = new char[i4];
            int i5 = 0;
            while (jK < j3) {
                byte bX = UnsafeUtil.x(jK);
                if (!DecodeUtil.n(bX)) {
                    break;
                }
                jK++;
                DecodeUtil.i(bX, cArr, i5);
                i5++;
            }
            int i6 = i5;
            while (jK < j3) {
                long j4 = jK + 1;
                byte bX2 = UnsafeUtil.x(jK);
                if (DecodeUtil.n(bX2)) {
                    int i7 = i6 + 1;
                    DecodeUtil.i(bX2, cArr, i6);
                    long j5 = j4;
                    while (j5 < j3) {
                        byte bX3 = UnsafeUtil.x(j5);
                        if (!DecodeUtil.n(bX3)) {
                            break;
                        }
                        j5++;
                        DecodeUtil.i(bX3, cArr, i7);
                        i7++;
                    }
                    i6 = i7;
                    jK = j5;
                } else if (DecodeUtil.p(bX2)) {
                    if (j4 >= j3) {
                        throw InvalidProtocolBufferException.d();
                    }
                    jK += 2;
                    DecodeUtil.k(bX2, UnsafeUtil.x(j4), cArr, i6);
                    i6++;
                } else if (DecodeUtil.o(bX2)) {
                    if (j4 >= j3 - 1) {
                        throw InvalidProtocolBufferException.d();
                    }
                    long j6 = 2 + jK;
                    jK += 3;
                    DecodeUtil.j(bX2, UnsafeUtil.x(j4), UnsafeUtil.x(j6), cArr, i6);
                    i6++;
                } else {
                    if (j4 >= j3 - 2) {
                        throw InvalidProtocolBufferException.d();
                    }
                    byte bX4 = UnsafeUtil.x(j4);
                    long j7 = jK + 3;
                    byte bX5 = UnsafeUtil.x(2 + jK);
                    jK += 4;
                    DecodeUtil.h(bX2, bX4, bX5, UnsafeUtil.x(j7), cArr, i6);
                    i6 += 2;
                }
            }
            return new String(cArr, 0, i6);
        }

        @Override // androidx.glance.appwidget.protobuf.Utf8.Processor
        int e(CharSequence charSequence, byte[] bArr, int i3, int i4) {
            long j3;
            long j4;
            long j5;
            int i5;
            char cCharAt;
            long j6 = i3;
            long j7 = ((long) i4) + j6;
            int length = charSequence.length();
            if (length > i4 || bArr.length - i4 < i3) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + (i3 + i4));
            }
            int i6 = 0;
            while (true) {
                j3 = 1;
                if (i6 >= length || (cCharAt = charSequence.charAt(i6)) >= 128) {
                    break;
                }
                UnsafeUtil.R(bArr, j6, (byte) cCharAt);
                i6++;
                j6 = 1 + j6;
            }
            if (i6 == length) {
                return (int) j6;
            }
            while (i6 < length) {
                char cCharAt2 = charSequence.charAt(i6);
                if (cCharAt2 < 128 && j6 < j7) {
                    UnsafeUtil.R(bArr, j6, (byte) cCharAt2);
                    j5 = j7;
                    j4 = j3;
                    j6 += j3;
                } else if (cCharAt2 >= 2048 || j6 > j7 - 2) {
                    j4 = j3;
                    if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || j6 > j7 - 3) {
                        j5 = j7;
                        if (j6 > j5 - 4) {
                            if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i5 = i6 + 1) == length || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i5)))) {
                                throw new UnpairedSurrogateException(i6, length);
                            }
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + j6);
                        }
                        int i7 = i6 + 1;
                        if (i7 != length) {
                            char cCharAt3 = charSequence.charAt(i7);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                UnsafeUtil.R(bArr, j6, (byte) ((codePoint >>> 18) | 240));
                                UnsafeUtil.R(bArr, j6 + j4, (byte) (((codePoint >>> 12) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                                long j8 = j6 + 3;
                                UnsafeUtil.R(bArr, j6 + 2, (byte) (((codePoint >>> 6) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                                j6 += 4;
                                UnsafeUtil.R(bArr, j8, (byte) ((codePoint & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                                i6 = i7;
                            } else {
                                i6 = i7;
                            }
                        }
                        throw new UnpairedSurrogateException(i6 - 1, length);
                    }
                    UnsafeUtil.R(bArr, j6, (byte) ((cCharAt2 >>> '\f') | 480));
                    long j9 = j6 + 2;
                    j5 = j7;
                    UnsafeUtil.R(bArr, j6 + j4, (byte) (((cCharAt2 >>> 6) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                    j6 += 3;
                    UnsafeUtil.R(bArr, j9, (byte) ((cCharAt2 & '?') | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                } else {
                    j4 = j3;
                    long j10 = j6 + j4;
                    UnsafeUtil.R(bArr, j6, (byte) ((cCharAt2 >>> 6) | 960));
                    j6 += 2;
                    UnsafeUtil.R(bArr, j10, (byte) ((cCharAt2 & '?') | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                    j5 = j7;
                }
                i6++;
                j3 = j4;
                j7 = j5;
            }
            return (int) j6;
        }

        @Override // androidx.glance.appwidget.protobuf.Utf8.Processor
        void h(CharSequence charSequence, ByteBuffer byteBuffer) {
            long j3;
            char c3;
            long j4;
            long j5;
            long j6;
            int i3;
            char c4;
            char cCharAt;
            long jK = UnsafeUtil.k(byteBuffer);
            long jPosition = ((long) byteBuffer.position()) + jK;
            long jLimit = ((long) byteBuffer.limit()) + jK;
            int length = charSequence.length();
            if (length > jLimit - jPosition) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + byteBuffer.limit());
            }
            int i4 = 0;
            while (true) {
                j3 = 1;
                c3 = 128;
                if (i4 >= length || (cCharAt = charSequence.charAt(i4)) >= 128) {
                    break;
                }
                UnsafeUtil.Q(jPosition, (byte) cCharAt);
                i4++;
                jPosition = 1 + jPosition;
            }
            if (i4 == length) {
                byteBuffer.position((int) (jPosition - jK));
                return;
            }
            while (i4 < length) {
                char cCharAt2 = charSequence.charAt(i4);
                if (cCharAt2 >= c3 || jPosition >= jLimit) {
                    j4 = j3;
                    if (cCharAt2 < 2048 && jPosition <= jLimit - 2) {
                        long j7 = jPosition + j4;
                        UnsafeUtil.Q(jPosition, (byte) ((cCharAt2 >>> 6) | 960));
                        jPosition += 2;
                        UnsafeUtil.Q(j7, (byte) ((cCharAt2 & '?') | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                        j5 = jK;
                        j6 = jLimit;
                    } else {
                        if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || jPosition > jLimit - 3) {
                            j5 = jK;
                            j6 = jLimit;
                            if (jPosition > j6 - 4) {
                                if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i3 = i4 + 1) == length || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i3)))) {
                                    throw new UnpairedSurrogateException(i4, length);
                                }
                                throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + jPosition);
                            }
                            int i5 = i4 + 1;
                            if (i5 != length) {
                                char cCharAt3 = charSequence.charAt(i5);
                                if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                    int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                    UnsafeUtil.Q(jPosition, (byte) ((codePoint >>> 18) | 240));
                                    c4 = 128;
                                    UnsafeUtil.Q(jPosition + j4, (byte) (((codePoint >>> 12) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                                    long j8 = jPosition + 3;
                                    UnsafeUtil.Q(jPosition + 2, (byte) (((codePoint >>> 6) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                                    jPosition += 4;
                                    UnsafeUtil.Q(j8, (byte) ((codePoint & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                                    i4 = i5;
                                } else {
                                    i4 = i5;
                                }
                            }
                            throw new UnpairedSurrogateException(i4 - 1, length);
                        }
                        UnsafeUtil.Q(jPosition, (byte) ((cCharAt2 >>> '\f') | 480));
                        j5 = jK;
                        long j9 = jPosition + 2;
                        j6 = jLimit;
                        UnsafeUtil.Q(jPosition + j4, (byte) (((cCharAt2 >>> 6) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                        jPosition += 3;
                        UnsafeUtil.Q(j9, (byte) ((cCharAt2 & '?') | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                    }
                    c4 = 128;
                } else {
                    UnsafeUtil.Q(jPosition, (byte) cCharAt2);
                    j5 = jK;
                    j6 = jLimit;
                    c4 = c3;
                    jPosition += j3;
                    j4 = j3;
                }
                i4++;
                c3 = c4;
                j3 = j4;
                jK = j5;
                jLimit = j6;
            }
            byteBuffer.position((int) (jPosition - jK));
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x0058, code lost:
        
            if (androidx.glance.appwidget.protobuf.UnsafeUtil.y(r12, r0) > (-65)) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x009e, code lost:
        
            if (androidx.glance.appwidget.protobuf.UnsafeUtil.y(r12, r0) > (-65)) goto L59;
         */
        @Override // androidx.glance.appwidget.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        int l(int r11, byte[] r12, int r13, int r14) {
            /*
                r10 = this;
                r0 = r13 | r14
                int r1 = r12.length
                int r1 = r1 - r14
                r0 = r0 | r1
                if (r0 < 0) goto La8
                long r0 = (long) r13
                long r13 = (long) r14
                if (r11 == 0) goto La1
                int r2 = (r0 > r13 ? 1 : (r0 == r13 ? 0 : -1))
                if (r2 < 0) goto L10
                return r11
            L10:
                byte r2 = (byte) r11
                r3 = -32
                r4 = -1
                r5 = -65
                r6 = 1
                if (r2 >= r3) goto L2a
                r11 = -62
                if (r2 < r11) goto L29
                long r6 = r6 + r0
                byte r11 = androidx.glance.appwidget.protobuf.UnsafeUtil.y(r12, r0)
                if (r11 <= r5) goto L26
                goto L29
            L26:
                r0 = r6
                goto La1
            L29:
                return r4
            L2a:
                r8 = -16
                if (r2 >= r8) goto L5e
                int r11 = r11 >> 8
                int r11 = ~r11
                byte r11 = (byte) r11
                if (r11 != 0) goto L44
                long r8 = r0 + r6
                byte r11 = androidx.glance.appwidget.protobuf.UnsafeUtil.y(r12, r0)
                int r0 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
                if (r0 < 0) goto L43
                int r11 = androidx.glance.appwidget.protobuf.Utf8.a(r2, r11)
                return r11
            L43:
                r0 = r8
            L44:
                if (r11 > r5) goto L5d
                r8 = -96
                if (r2 != r3) goto L4c
                if (r11 < r8) goto L5d
            L4c:
                r3 = -19
                if (r2 != r3) goto L52
                if (r11 >= r8) goto L5d
            L52:
                long r2 = r0 + r6
                byte r11 = androidx.glance.appwidget.protobuf.UnsafeUtil.y(r12, r0)
                if (r11 <= r5) goto L5b
                goto L5d
            L5b:
                r0 = r2
                goto La1
            L5d:
                return r4
            L5e:
                int r3 = r11 >> 8
                int r3 = ~r3
                byte r3 = (byte) r3
                if (r3 != 0) goto L76
                long r8 = r0 + r6
                byte r3 = androidx.glance.appwidget.protobuf.UnsafeUtil.y(r12, r0)
                int r11 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
                if (r11 < 0) goto L73
                int r11 = androidx.glance.appwidget.protobuf.Utf8.a(r2, r3)
                return r11
            L73:
                r11 = 0
                r0 = r8
                goto L79
            L76:
                int r11 = r11 >> 16
                byte r11 = (byte) r11
            L79:
                if (r11 != 0) goto L8b
                long r8 = r0 + r6
                byte r11 = androidx.glance.appwidget.protobuf.UnsafeUtil.y(r12, r0)
                int r0 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
                if (r0 < 0) goto L8a
                int r11 = androidx.glance.appwidget.protobuf.Utf8.b(r2, r3, r11)
                return r11
            L8a:
                r0 = r8
            L8b:
                if (r3 > r5) goto La0
                int r2 = r2 << 28
                int r3 = r3 + 112
                int r2 = r2 + r3
                int r2 = r2 >> 30
                if (r2 != 0) goto La0
                if (r11 > r5) goto La0
                long r2 = r0 + r6
                byte r11 = androidx.glance.appwidget.protobuf.UnsafeUtil.y(r12, r0)
                if (r11 <= r5) goto L5b
            La0:
                return r4
            La1:
                long r13 = r13 - r0
                int r11 = (int) r13
                int r11 = r(r12, r0, r11)
                return r11
            La8:
                java.lang.ArrayIndexOutOfBoundsException r11 = new java.lang.ArrayIndexOutOfBoundsException
                int r12 = r12.length
                java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
                java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
                java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
                java.lang.Object[] r12 = new java.lang.Object[]{r12, r13, r14}
                java.lang.String r13 = "Array length=%d, index=%d, limit=%d"
                java.lang.String r12 = java.lang.String.format(r13, r12)
                r11.<init>(r12)
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.protobuf.Utf8.UnsafeProcessor.l(int, byte[], int, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
        
            if (androidx.glance.appwidget.protobuf.UnsafeUtil.x(r0) > (-65)) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0061, code lost:
        
            if (androidx.glance.appwidget.protobuf.UnsafeUtil.x(r0) > (-65)) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00a3, code lost:
        
            if (androidx.glance.appwidget.protobuf.UnsafeUtil.x(r0) > (-65)) goto L57;
         */
        @Override // androidx.glance.appwidget.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        int o(int r10, java.nio.ByteBuffer r11, int r12, int r13) {
            /*
                Method dump skipped, instruction units count: 205
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.protobuf.Utf8.UnsafeProcessor.o(int, java.nio.ByteBuffer, int, int):int");
        }
    }

    static {
        f39313a = (!UnsafeProcessor.p() || Android.c()) ? new SafeProcessor() : new UnsafeProcessor();
    }

    static String g(ByteBuffer byteBuffer, int i3, int i4) {
        return f39313a.a(byteBuffer, i3, i4);
    }

    static String h(byte[] bArr, int i3, int i4) {
        return f39313a.b(bArr, i3, i4);
    }

    static int i(CharSequence charSequence, byte[] bArr, int i3, int i4) {
        return f39313a.e(charSequence, bArr, i3, i4);
    }

    static void j(CharSequence charSequence, ByteBuffer byteBuffer) {
        f39313a.f(charSequence, byteBuffer);
    }

    static int k(CharSequence charSequence) {
        int length = charSequence.length();
        int i3 = 0;
        while (i3 < length && charSequence.charAt(i3) < 128) {
            i3++;
        }
        int iL = length;
        while (true) {
            if (i3 < length) {
                char cCharAt = charSequence.charAt(i3);
                if (cCharAt >= 2048) {
                    iL += l(charSequence, i3);
                    break;
                }
                iL += (127 - cCharAt) >>> 31;
                i3++;
            } else {
                break;
            }
        }
        if (iL >= length) {
            return iL;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) iL) + 4294967296L));
    }

    private static int l(CharSequence charSequence, int i3) {
        int length = charSequence.length();
        int i4 = 0;
        while (i3 < length) {
            char cCharAt = charSequence.charAt(i3);
            if (cCharAt < 2048) {
                i4 += (127 - cCharAt) >>> 31;
            } else {
                i4 += 2;
                if (55296 <= cCharAt && cCharAt <= 57343) {
                    if (Character.codePointAt(charSequence, i3) < 65536) {
                        throw new UnpairedSurrogateException(i3, length);
                    }
                    i3++;
                }
            }
            i3++;
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int m(ByteBuffer byteBuffer, int i3, int i4) {
        int i5 = i4 - 7;
        int i6 = i3;
        while (i6 < i5 && (byteBuffer.getLong(i6) & (-9187201950435737472L)) == 0) {
            i6 += 8;
        }
        return i6 - i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int n(int i3) {
        if (i3 > -12) {
            return -1;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int o(int i3, int i4) {
        if (i3 > -12 || i4 > -65) {
            return -1;
        }
        return i3 ^ (i4 << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int p(int i3, int i4, int i5) {
        if (i3 > -12 || i4 > -65 || i5 > -65) {
            return -1;
        }
        return (i3 ^ (i4 << 8)) ^ (i5 << 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int q(ByteBuffer byteBuffer, int i3, int i4, int i5) {
        if (i5 == 0) {
            return n(i3);
        }
        if (i5 == 1) {
            return o(i3, byteBuffer.get(i4));
        }
        if (i5 == 2) {
            return p(i3, byteBuffer.get(i4), byteBuffer.get(i4 + 1));
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int r(byte[] bArr, int i3, int i4) {
        byte b3 = bArr[i3 - 1];
        int i5 = i4 - i3;
        if (i5 == 0) {
            return n(b3);
        }
        if (i5 == 1) {
            return o(b3, bArr[i3]);
        }
        if (i5 == 2) {
            return p(b3, bArr[i3], bArr[i3 + 1]);
        }
        throw new AssertionError();
    }

    static boolean s(ByteBuffer byteBuffer) {
        return f39313a.i(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
    }

    static boolean t(byte[] bArr) {
        return f39313a.j(bArr, 0, bArr.length);
    }

    static boolean u(byte[] bArr, int i3, int i4) {
        return f39313a.j(bArr, i3, i4);
    }

    static int v(int i3, ByteBuffer byteBuffer, int i4, int i5) {
        return f39313a.k(i3, byteBuffer, i4, i5);
    }

    static int w(int i3, byte[] bArr, int i4, int i5) {
        return f39313a.l(i3, bArr, i4, i5);
    }
}
