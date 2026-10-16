package com.google.zxing.qrcode.encoder;

import com.google.android.gms.common.api.Api;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class Encoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f92093a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* JADX INFO: renamed from: com.google.zxing.qrcode.encoder.Encoder$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f92094a;

        static {
            int[] iArr = new int[Mode.values().length];
            f92094a = iArr;
            try {
                iArr[Mode.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f92094a[Mode.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f92094a[Mode.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f92094a[Mode.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static void a(String str, BitArray bitArray, String str2) throws WriterException {
        try {
            for (byte b3 : str.getBytes(str2)) {
                bitArray.c(b3, 8);
            }
        } catch (UnsupportedEncodingException e3) {
            throw new WriterException(e3);
        }
    }

    static void b(CharSequence charSequence, BitArray bitArray) throws WriterException {
        int length = charSequence.length();
        int i3 = 0;
        while (i3 < length) {
            int iP = p(charSequence.charAt(i3));
            if (iP == -1) {
                throw new WriterException();
            }
            int i4 = i3 + 1;
            if (i4 < length) {
                int iP2 = p(charSequence.charAt(i4));
                if (iP2 == -1) {
                    throw new WriterException();
                }
                bitArray.c((iP * 45) + iP2, 11);
                i3 += 2;
            } else {
                bitArray.c(iP, 6);
                i3 = i4;
            }
        }
    }

    static void c(String str, Mode mode, BitArray bitArray, String str2) throws WriterException {
        int i3 = AnonymousClass1.f92094a[mode.ordinal()];
        if (i3 == 1) {
            h(str, bitArray);
            return;
        }
        if (i3 == 2) {
            b(str, bitArray);
        } else if (i3 == 3) {
            a(str, bitArray, str2);
        } else {
            if (i3 != 4) {
                throw new WriterException("Invalid mode: ".concat(String.valueOf(mode)));
            }
            e(str, bitArray);
        }
    }

    private static void d(CharacterSetECI characterSetECI, BitArray bitArray) {
        bitArray.c(Mode.ECI.a(), 4);
        bitArray.c(characterSetECI.b(), 8);
    }

    static void e(String str, BitArray bitArray) throws WriterException {
        int i3;
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            for (int i4 = 0; i4 < length; i4 += 2) {
                int i5 = ((bytes[i4] & 255) << 8) | (bytes[i4 + 1] & 255);
                int i6 = 33088;
                if (i5 >= 33088 && i5 <= 40956) {
                    i3 = i5 - i6;
                } else if (i5 < 57408 || i5 > 60351) {
                    i3 = -1;
                } else {
                    i6 = 49472;
                    i3 = i5 - i6;
                }
                if (i3 == -1) {
                    throw new WriterException("Invalid byte sequence");
                }
                bitArray.c(((i3 >> 8) * 192) + (i3 & 255), 13);
            }
        } catch (UnsupportedEncodingException e3) {
            throw new WriterException(e3);
        }
    }

    static void f(int i3, Version version, Mode mode, BitArray bitArray) throws WriterException {
        int iB = mode.b(version);
        int i4 = 1 << iB;
        if (i3 < i4) {
            bitArray.c(i3, iB);
            return;
        }
        throw new WriterException(i3 + " is bigger than " + (i4 - 1));
    }

    static void g(Mode mode, BitArray bitArray) {
        bitArray.c(mode.a(), 4);
    }

    static void h(CharSequence charSequence, BitArray bitArray) {
        int length = charSequence.length();
        int i3 = 0;
        while (i3 < length) {
            int iCharAt = charSequence.charAt(i3) - '0';
            int i4 = i3 + 2;
            if (i4 < length) {
                bitArray.c((iCharAt * 100) + ((charSequence.charAt(i3 + 1) - '0') * 10) + (charSequence.charAt(i4) - '0'), 10);
                i3 += 3;
            } else {
                i3++;
                if (i3 < length) {
                    bitArray.c((iCharAt * 10) + (charSequence.charAt(i3) - '0'), 7);
                    i3 = i4;
                } else {
                    bitArray.c(iCharAt, 4);
                }
            }
        }
    }

    private static int i(Mode mode, BitArray bitArray, BitArray bitArray2, Version version) {
        return bitArray.i() + mode.b(version) + bitArray2.i();
    }

    private static int j(ByteMatrix byteMatrix) {
        return MaskUtil.a(byteMatrix) + MaskUtil.c(byteMatrix) + MaskUtil.d(byteMatrix) + MaskUtil.e(byteMatrix);
    }

    private static int k(BitArray bitArray, ErrorCorrectionLevel errorCorrectionLevel, Version version, ByteMatrix byteMatrix) throws WriterException {
        int i3 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int i4 = -1;
        for (int i5 = 0; i5 < 8; i5++) {
            MatrixUtil.a(bitArray, errorCorrectionLevel, version, i5, byteMatrix);
            int iJ = j(byteMatrix);
            if (iJ < i3) {
                i4 = i5;
                i3 = iJ;
            }
        }
        return i4;
    }

    private static Mode l(String str, String str2) {
        if ("Shift_JIS".equals(str2) && s(str)) {
            return Mode.KANJI;
        }
        boolean z2 = false;
        boolean z3 = false;
        for (int i3 = 0; i3 < str.length(); i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt >= '0' && cCharAt <= '9') {
                z3 = true;
            } else {
                if (p(cCharAt) == -1) {
                    return Mode.BYTE;
                }
                z2 = true;
            }
        }
        return z2 ? Mode.ALPHANUMERIC : z3 ? Mode.NUMERIC : Mode.BYTE;
    }

    private static Version m(int i3, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        for (int i4 = 1; i4 <= 40; i4++) {
            Version versionE = Version.e(i4);
            if (v(i3, versionE, errorCorrectionLevel)) {
                return versionE;
            }
        }
        throw new WriterException("Data too big");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.zxing.qrcode.encoder.QRCode n(java.lang.String r6, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel r7, java.util.Map r8) throws com.google.zxing.WriterException {
        /*
            Method dump skipped, instruction units count: 235
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.encoder.Encoder.n(java.lang.String, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel, java.util.Map):com.google.zxing.qrcode.encoder.QRCode");
    }

    static byte[] o(byte[] bArr, int i3) {
        int length = bArr.length;
        int[] iArr = new int[length + i3];
        for (int i4 = 0; i4 < length; i4++) {
            iArr[i4] = bArr[i4] & 255;
        }
        new ReedSolomonEncoder(GenericGF.f91825l).b(iArr, i3);
        byte[] bArr2 = new byte[i3];
        for (int i5 = 0; i5 < i3; i5++) {
            bArr2[i5] = (byte) iArr[length + i5];
        }
        return bArr2;
    }

    static int p(int i3) {
        int[] iArr = f92093a;
        if (i3 < iArr.length) {
            return iArr[i3];
        }
        return -1;
    }

    static void q(int i3, int i4, int i5, int i6, int[] iArr, int[] iArr2) throws WriterException {
        if (i6 >= i5) {
            throw new WriterException("Block ID too large");
        }
        int i7 = i3 % i5;
        int i8 = i5 - i7;
        int i9 = i3 / i5;
        int i10 = i9 + 1;
        int i11 = i4 / i5;
        int i12 = i11 + 1;
        int i13 = i9 - i11;
        int i14 = i10 - i12;
        if (i13 != i14) {
            throw new WriterException("EC bytes mismatch");
        }
        if (i5 != i8 + i7) {
            throw new WriterException("RS blocks mismatch");
        }
        if (i3 != ((i11 + i13) * i8) + ((i12 + i14) * i7)) {
            throw new WriterException("Total bytes mismatch");
        }
        if (i6 < i8) {
            iArr[0] = i11;
            iArr2[0] = i13;
        } else {
            iArr[0] = i12;
            iArr2[0] = i14;
        }
    }

    static BitArray r(BitArray bitArray, int i3, int i4, int i5) throws WriterException {
        if (bitArray.j() != i4) {
            throw new WriterException("Number of bits and data bytes does not match");
        }
        ArrayList arrayList = new ArrayList(i5);
        int i6 = 0;
        int i7 = 0;
        int iMax = 0;
        int iMax2 = 0;
        while (i6 < i5) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            int i8 = i3;
            int i9 = i4;
            int i10 = i5;
            q(i8, i9, i10, i6, iArr, iArr2);
            int i11 = iArr[0];
            byte[] bArr = new byte[i11];
            bitArray.m(i7 << 3, bArr, 0, i11);
            byte[] bArrO = o(bArr, iArr2[0]);
            arrayList.add(new BlockPair(bArr, bArrO));
            iMax = Math.max(iMax, i11);
            iMax2 = Math.max(iMax2, bArrO.length);
            i7 += iArr[0];
            i6++;
            i3 = i8;
            i4 = i9;
            i5 = i10;
        }
        int i12 = i3;
        if (i4 != i7) {
            throw new WriterException("Data bytes does not match offset");
        }
        BitArray bitArray2 = new BitArray();
        for (int i13 = 0; i13 < iMax; i13++) {
            int size = arrayList.size();
            int i14 = 0;
            while (i14 < size) {
                Object obj = arrayList.get(i14);
                i14++;
                byte[] bArrA = ((BlockPair) obj).a();
                if (i13 < bArrA.length) {
                    bitArray2.c(bArrA[i13], 8);
                }
            }
        }
        for (int i15 = 0; i15 < iMax2; i15++) {
            int size2 = arrayList.size();
            int i16 = 0;
            while (i16 < size2) {
                Object obj2 = arrayList.get(i16);
                i16++;
                byte[] bArrB = ((BlockPair) obj2).b();
                if (i15 < bArrB.length) {
                    bitArray2.c(bArrB[i15], 8);
                }
            }
        }
        if (i12 == bitArray2.j()) {
            return bitArray2;
        }
        throw new WriterException("Interleaving error: " + i12 + " and " + bitArray2.j() + " differ.");
    }

    private static boolean s(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i3 = 0; i3 < length; i3 += 2) {
                int i4 = bytes[i3] & 255;
                if ((i4 < 129 || i4 > 159) && (i4 < 224 || i4 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    private static Version t(ErrorCorrectionLevel errorCorrectionLevel, Mode mode, BitArray bitArray, BitArray bitArray2) {
        return m(i(mode, bitArray, bitArray2, m(i(mode, bitArray, bitArray2, Version.e(1)), errorCorrectionLevel)), errorCorrectionLevel);
    }

    static void u(int i3, BitArray bitArray) throws WriterException {
        int i4 = i3 << 3;
        if (bitArray.i() > i4) {
            throw new WriterException("data bits cannot fit in the QR Code" + bitArray.i() + " > " + i4);
        }
        for (int i5 = 0; i5 < 4 && bitArray.i() < i4; i5++) {
            bitArray.a(false);
        }
        int i6 = bitArray.i() & 7;
        if (i6 > 0) {
            while (i6 < 8) {
                bitArray.a(false);
                i6++;
            }
        }
        int iJ = i3 - bitArray.j();
        for (int i7 = 0; i7 < iJ; i7++) {
            bitArray.c((i7 & 1) == 0 ? 236 : 17, 8);
        }
        if (bitArray.i() != i4) {
            throw new WriterException("Bits size does not equal capacity");
        }
    }

    private static boolean v(int i3, Version version, ErrorCorrectionLevel errorCorrectionLevel) {
        return version.d() - version.c(errorCorrectionLevel).d() >= (i3 + 7) / 8;
    }
}
