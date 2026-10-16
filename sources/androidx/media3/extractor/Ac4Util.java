package androidx.media3.extractor;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import com.facebook.ads.AdError;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class Ac4Util {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f46040a = {AdError.CACHE_ERROR_CODE, AdError.SERVER_ERROR_CODE, 1920, 1601, 1600, AdError.NO_FILL_ERROR_CODE, 1000, 960, 800, 800, 480, RCHTTPStatusCodes.BAD_REQUEST, RCHTTPStatusCodes.BAD_REQUEST, 2048};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Ac4Presentation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f46041a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f46042b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f46043c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f46044d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f46045e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f46046f;

        private Ac4Presentation() {
            this.f46041a = true;
            this.f46042b = -1;
            this.f46043c = -1;
            this.f46044d = true;
            this.f46045e = 2;
            this.f46046f = 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class SyncFrameInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f46047a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f46048b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f46049c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f46050d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f46051e;

        private SyncFrameInfo(int i3, int i4, int i5, int i6, int i7) {
            this.f46047a = i3;
            this.f46049c = i4;
            this.f46048b = i5;
            this.f46050d = i6;
            this.f46051e = i7;
        }
    }

    public static void a(int i3, ParsableByteArray parsableByteArray) {
        parsableByteArray.S(7);
        byte[] bArrE = parsableByteArray.e();
        bArrE[0] = -84;
        bArrE[1] = 64;
        bArrE[2] = -1;
        bArrE[3] = -1;
        bArrE[4] = (byte) ((i3 >> 16) & 255);
        bArrE[5] = (byte) ((i3 >> 8) & 255);
        bArrE[6] = (byte) (i3 & 255);
    }

    private static int b(int i3, boolean z2, int i4) {
        int iC = c(i3);
        if (i3 != 11 && i3 != 12 && i3 != 13 && i3 != 14) {
            return iC;
        }
        if (!z2) {
            iC -= 2;
        }
        return i4 != 0 ? i4 != 1 ? iC : iC - 2 : iC - 4;
    }

    private static int c(int i3) {
        switch (i3) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 5;
            case 4:
                return 6;
            case 5:
            case 7:
            case 9:
                return 7;
            case 6:
            case 8:
            case 10:
                return 8;
            case 11:
                return 11;
            case 12:
                return 12;
            case 13:
                return 13;
            case 14:
                return 14;
            case 15:
                return 24;
            default:
                return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:158:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x02ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static androidx.media3.common.Format d(androidx.media3.common.util.ParsableByteArray r19, java.lang.String r20, java.lang.String r21, androidx.media3.common.DrmInitData r22) throws androidx.media3.common.ParserException {
        /*
            Method dump skipped, instruction units count: 715
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.Ac4Util.d(androidx.media3.common.util.ParsableByteArray, java.lang.String, java.lang.String, androidx.media3.common.DrmInitData):androidx.media3.common.Format");
    }

    public static int e(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[16];
        int iPosition = byteBuffer.position();
        byteBuffer.get(bArr);
        byteBuffer.position(iPosition);
        return f(new ParsableBitArray(bArr)).f46051e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0082, code lost:
    
        if (r11 != 11) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0089, code lost:
    
        if (r11 != 11) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x008e, code lost:
    
        if (r11 != 8) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static androidx.media3.extractor.Ac4Util.SyncFrameInfo f(androidx.media3.common.util.ParsableBitArray r11) {
        /*
            r0 = 16
            int r1 = r11.h(r0)
            int r0 = r11.h(r0)
            r2 = 65535(0xffff, float:9.1834E-41)
            r3 = 4
            if (r0 != r2) goto L18
            r0 = 24
            int r0 = r11.h(r0)
            r2 = 7
            goto L19
        L18:
            r2 = r3
        L19:
            int r0 = r0 + r2
            r2 = 44097(0xac41, float:6.1793E-41)
            if (r1 != r2) goto L21
            int r0 = r0 + 2
        L21:
            r8 = r0
            r0 = 2
            int r1 = r11.h(r0)
            r2 = 3
            if (r1 != r2) goto L2f
            int r4 = j(r11, r0)
            int r1 = r1 + r4
        L2f:
            r5 = r1
            r1 = 10
            int r1 = r11.h(r1)
            boolean r4 = r11.g()
            if (r4 == 0) goto L45
            int r4 = r11.h(r2)
            if (r4 <= 0) goto L45
            r11.r(r0)
        L45:
            boolean r4 = r11.g()
            r6 = 44100(0xac44, float:6.1797E-41)
            r7 = 48000(0xbb80, float:6.7262E-41)
            if (r4 == 0) goto L53
            r4 = r7
            goto L55
        L53:
            r4 = r7
            r7 = r6
        L55:
            int r11 = r11.h(r3)
            if (r7 != r6) goto L65
            r6 = 13
            if (r11 != r6) goto L65
            int[] r0 = androidx.media3.extractor.Ac4Util.f46040a
            r11 = r0[r11]
        L63:
            r9 = r11
            goto L95
        L65:
            if (r7 != r4) goto L93
            int[] r4 = androidx.media3.extractor.Ac4Util.f46040a
            int r6 = r4.length
            if (r11 >= r6) goto L93
            r4 = r4[r11]
            int r1 = r1 % 5
            r6 = 8
            r9 = 1
            if (r1 == r9) goto L8c
            r9 = 11
            if (r1 == r0) goto L87
            if (r1 == r2) goto L8c
            if (r1 == r3) goto L7e
            goto L91
        L7e:
            if (r11 == r2) goto L84
            if (r11 == r6) goto L84
            if (r11 != r9) goto L91
        L84:
            int r11 = r4 + 1
            goto L63
        L87:
            if (r11 == r6) goto L84
            if (r11 != r9) goto L91
            goto L84
        L8c:
            if (r11 == r2) goto L84
            if (r11 != r6) goto L91
            goto L84
        L91:
            r9 = r4
            goto L95
        L93:
            r11 = 0
            goto L63
        L95:
            androidx.media3.extractor.Ac4Util$SyncFrameInfo r4 = new androidx.media3.extractor.Ac4Util$SyncFrameInfo
            r6 = 2
            r10 = 0
            r4.<init>(r5, r6, r7, r8, r9)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.Ac4Util.f(androidx.media3.common.util.ParsableBitArray):androidx.media3.extractor.Ac4Util$SyncFrameInfo");
    }

    public static int g(byte[] bArr, int i3) {
        int i4 = 7;
        if (bArr.length < 7) {
            return -1;
        }
        int i5 = ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        if (i5 == 65535) {
            i5 = ((bArr[4] & 255) << 16) | ((bArr[5] & 255) << 8) | (bArr[6] & 255);
        } else {
            i4 = 4;
        }
        if (i3 == 44097) {
            i4 += 2;
        }
        return i5 + i4;
    }

    private static void h(ParsableBitArray parsableBitArray, Ac4Presentation ac4Presentation) throws ParserException {
        int iH = parsableBitArray.h(5);
        parsableBitArray.r(2);
        if (parsableBitArray.g()) {
            parsableBitArray.r(5);
        }
        if (iH >= 7 && iH <= 10) {
            parsableBitArray.q();
        }
        if (parsableBitArray.g()) {
            int iH2 = parsableBitArray.h(3);
            if (ac4Presentation.f46042b == -1 && iH >= 0 && iH <= 15 && (iH2 == 0 || iH2 == 1)) {
                ac4Presentation.f46042b = iH;
            }
            if (parsableBitArray.g()) {
                l(parsableBitArray);
            }
        }
    }

    private static void i(ParsableBitArray parsableBitArray, Ac4Presentation ac4Presentation) throws ParserException {
        parsableBitArray.r(2);
        boolean zG = parsableBitArray.g();
        int iH = parsableBitArray.h(8);
        for (int i3 = 0; i3 < iH; i3++) {
            parsableBitArray.r(2);
            if (parsableBitArray.g()) {
                parsableBitArray.r(5);
            }
            if (zG) {
                parsableBitArray.r(24);
            } else {
                if (parsableBitArray.g()) {
                    if (!parsableBitArray.g()) {
                        parsableBitArray.r(4);
                    }
                    ac4Presentation.f46043c = parsableBitArray.h(6) + 1;
                }
                parsableBitArray.r(4);
            }
        }
        if (parsableBitArray.g()) {
            parsableBitArray.r(3);
            if (parsableBitArray.g()) {
                l(parsableBitArray);
            }
        }
    }

    private static int j(ParsableBitArray parsableBitArray, int i3) {
        int i4 = 0;
        while (true) {
            int iH = i4 + parsableBitArray.h(i3);
            if (!parsableBitArray.g()) {
                return iH;
            }
            i4 = (iH + 1) << i3;
        }
    }

    private static boolean k(ParsableBitArray parsableBitArray) {
        if (parsableBitArray.b() < 66) {
            return false;
        }
        parsableBitArray.r(66);
        return true;
    }

    private static void l(ParsableBitArray parsableBitArray) throws ParserException {
        int iH = parsableBitArray.h(6);
        if (iH < 2 || iH > 42) {
            throw ParserException.c(String.format("Invalid language tag bytes number: %d. Must be between 2 and 42.", Integer.valueOf(iH)));
        }
        parsableBitArray.r(iH * 8);
    }
}
