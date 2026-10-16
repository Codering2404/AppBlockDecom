package com.facebook.ads.redexgen.core;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import com.applovin.exoplayer2.common.base.Ascii;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class K2 {
    public static byte[] A07;
    public static String[] A08 = {"kwH2IgvZBGVpLaminurwcFHn", "J6e0tkh1Ff6tZSOwzR7AwbvIu8fVWeGQ", "bmiWbLOqDwiyYFUNe9As1QTlUgH4xYog", "dMXPCdyZdj7A6mfCnV5k3qiAvM2EcvhL", "upBvpVjUbbd4tW9uVknw3ChYtDg3XaKB", "lx9xVZ51GyjZV5dkAVxa", "4OpeXOwoxJhsdURDQeyl4TBKgN5cofiY", "16zjJfNWedSO35u1fMpvBODfGSUbEH9B"};
    public static final byte[] A09;
    public static final byte[] A0A;
    public static final byte[] A0B;
    public Bitmap A00;
    public final Canvas A01;
    public final Paint A02 = new Paint();
    public final Paint A03;
    public final C0823Ju A04;
    public final C0824Jv A05;
    public final K1 A06;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C0823Ju A04(C04544u c04544u, int i3) {
        int iA04;
        int iA042;
        int iA043;
        int iA044;
        int i4 = 8;
        int iA045 = c04544u.A04(8);
        c04544u.A09(8);
        int i5 = i3 - 2;
        int[] iArrA0F = A0F();
        int[] iArrA0G = A0G();
        int[] iArrA0H = A0H();
        while (i5 > 0) {
            int iA046 = c04544u.A04(i4);
            int iA047 = c04544u.A04(i4);
            int i6 = i5 - 2;
            int[] iArr = (iA047 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? iArrA0F : (iA047 & 64) != 0 ? iArrA0G : iArrA0H;
            int i7 = iA047 & 1;
            String[] strArr = A08;
            if (strArr[2].charAt(19) == strArr[6].charAt(19)) {
                throw new RuntimeException();
            }
            A08[3] = "yhDNrhcDigDR24Kxe5BS389mQBs2ZM2v";
            if (i7 != 0) {
                iA04 = c04544u.A04(i4);
                iA042 = c04544u.A04(i4);
                iA043 = c04544u.A04(i4);
                iA044 = c04544u.A04(i4);
                i5 = i6 - 4;
            } else {
                iA04 = c04544u.A04(6) << 2;
                iA042 = c04544u.A04(4) << 4;
                iA043 = c04544u.A04(4) << 4;
                iA044 = c04544u.A04(2) << 6;
                i5 = i6 - 2;
            }
            if (iA04 == 0) {
                iA042 = 0;
                if (A08[3].charAt(20) != '3') {
                    throw new RuntimeException();
                }
                A08[7] = "NRFOfVblegIP33K9RsgAL0VferudmJOb";
                iA043 = 0;
                iA044 = 255;
            }
            iArr[iA046] = A00(255 - (iA044 & 255), C5C.A07((int) (((double) iA04) + (((double) (iA042 - 128)) * 1.402d)), 0, 255), C5C.A07((int) ((((double) iA04) - (((double) (iA043 - 128)) * 0.34414d)) - (((double) (iA042 - 128)) * 0.71414d)), 0, 255), C5C.A07((int) (((double) iA04) + (((double) (iA043 - 128)) * 1.772d)), 0, 255));
            i4 = 8;
        }
        return new C0823Ju(iA045, iArrA0F, iArrA0G, iArrA0H);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C0824Jv A05(C04544u c04544u) {
        int iA04;
        int iA042;
        int iA043;
        int iA044;
        c04544u.A09(4);
        boolean zA0H = c04544u.A0H();
        c04544u.A09(3);
        int iA045 = c04544u.A04(16);
        int iA046 = c04544u.A04(16);
        if (zA0H) {
            iA04 = c04544u.A04(16);
            iA044 = c04544u.A04(16);
            iA042 = c04544u.A04(16);
            iA043 = c04544u.A04(16);
        } else {
            iA04 = 0;
            iA042 = 0;
            iA043 = iA046;
            iA044 = iA045;
        }
        return new C0824Jv(iA045, iA046, iA04, iA044, iA042, iA043);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C0828Jz A08(C04544u c04544u, int i3) {
        int i4 = 8;
        int iA04 = c04544u.A04(8);
        c04544u.A09(4);
        boolean zA0H = c04544u.A0H();
        c04544u.A09(3);
        int iA042 = c04544u.A04(16);
        int iA043 = c04544u.A04(16);
        int iA044 = c04544u.A04(3);
        int iA045 = c04544u.A04(3);
        c04544u.A09(2);
        int iA046 = c04544u.A04(8);
        int iA047 = c04544u.A04(8);
        int iA048 = c04544u.A04(4);
        int iA049 = c04544u.A04(2);
        c04544u.A09(2);
        int i5 = i3 - 10;
        SparseArray sparseArray = new SparseArray();
        while (i5 > 0) {
            int iA0410 = c04544u.A04(16);
            int iA0411 = c04544u.A04(2);
            int iA0412 = c04544u.A04(2);
            int iA0413 = c04544u.A04(12);
            c04544u.A09(4);
            int iA0414 = c04544u.A04(12);
            i5 -= 6;
            int iA0415 = 0;
            int iA0416 = 0;
            if (iA0411 == 1 || iA0411 == 2) {
                iA0415 = c04544u.A04(i4);
                iA0416 = c04544u.A04(i4);
                i5 -= 2;
            }
            sparseArray.put(iA0410, new K0(iA0411, iA0412, iA0413, iA0414, iA0415, iA0416));
            i4 = 8;
        }
        return new C0828Jz(iA04, zA0H, iA042, iA043, iA044, iA045, iA046, iA047, iA048, iA049, sparseArray);
    }

    public static String A09(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 22);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0A() {
        A07 = new byte[]{63, Ascii.SUB, Ascii.SI, Ascii.SUB, 91, Ascii.GS, Ascii.DC2, Ascii.RS, Ascii.ETB, Ascii.US, 91, Ascii.ETB, Ascii.RS, Ascii.NAK, Ascii.FS, Ascii.SI, 19, 91, Ascii.RS, 3, Ascii.CAN, Ascii.RS, Ascii.RS, Ascii.US, 8, 91, Ascii.ETB, Ascii.DC2, Ascii.SYN, Ascii.DC2, Ascii.SI, 98, 80, 68, 118, 71, 84, 85, 67, 84};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final List<C2158pT> A0I(byte[] bArr, int i3) {
        C04544u c04544u = new C04544u(bArr, i3);
        while (c04544u.A01() >= 48 && c04544u.A04(8) == 15) {
            A0B(c04544u, this.A06);
        }
        C0826Jx c0826Jx = this.A06.A01;
        if (c0826Jx == null) {
            return Collections.emptyList();
        }
        C0824Jv c0824Jv = this.A06.A00 != null ? this.A06.A00 : this.A05;
        if (this.A00 == null || c0824Jv.A05 + 1 != this.A00.getWidth() || c0824Jv.A00 + 1 != this.A00.getHeight()) {
            this.A00 = Bitmap.createBitmap(c0824Jv.A05 + 1, c0824Jv.A00 + 1, Bitmap.Config.ARGB_8888);
            this.A01.setBitmap(this.A00);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<C0827Jy> sparseArray = c0826Jx.A03;
        for (int i4 = 0; i4 < sparseArray.size(); i4++) {
            this.A01.save();
            C0827Jy c0827JyValueAt = sparseArray.valueAt(i4);
            C0828Jz c0828Jz = this.A06.A08.get(sparseArray.keyAt(i4));
            int i5 = c0827JyValueAt.A00 + c0824Jv.A02;
            int i6 = c0827JyValueAt.A01 + c0824Jv.A04;
            this.A01.clipRect(i5, i6, Math.min(c0828Jz.A08 + i5, c0824Jv.A01), Math.min(c0828Jz.A02 + i6, c0824Jv.A03));
            C0823Ju c0823Ju = this.A06.A06.get(c0828Jz.A00);
            if (c0823Ju == null && (c0823Ju = this.A06.A04.get(c0828Jz.A00)) == null) {
                c0823Ju = this.A04;
            }
            SparseArray<K0> sparseArray2 = c0828Jz.A09;
            for (int i7 = 0; i7 < sparseArray2.size(); i7++) {
                int iKeyAt = sparseArray2.keyAt(i7);
                K0 k0ValueAt = sparseArray2.valueAt(i7);
                C0825Jw c0825Jw = this.A06.A07.get(iKeyAt);
                if (c0825Jw == null) {
                    c0825Jw = this.A06.A05.get(iKeyAt);
                }
                if (c0825Jw != null) {
                    A0C(c0825Jw, c0823Ju, c0828Jz.A01, i5 + k0ValueAt.A02, i6 + k0ValueAt.A05, c0825Jw.A01 ? null : this.A02, this.A01);
                }
            }
            if (A08[4].charAt(14) != '9') {
                throw new RuntimeException();
            }
            A08[0] = "Y9Cu9eZ8R7HUBmBBCZ1DilUT";
            if (c0828Jz.A0A) {
                this.A03.setColor(c0828Jz.A01 == 3 ? c0823Ju.A03[c0828Jz.A07] : c0828Jz.A01 == 2 ? c0823Ju.A02[c0828Jz.A06] : c0823Ju.A01[c0828Jz.A05]);
                this.A01.drawRect(i5, i6, c0828Jz.A08 + i5, c0828Jz.A02 + i6, this.A03);
            }
            arrayList.add(new C04223o().A0D(Bitmap.createBitmap(this.A00, i5, i6, c0828Jz.A08, c0828Jz.A02)).A04(i5 / c0824Jv.A05).A0A(0).A07(i6 / c0824Jv.A00, 0).A09(0).A06(c0828Jz.A08 / c0824Jv.A05).A03(c0828Jz.A02 / c0824Jv.A00).A0H());
            this.A01.drawColor(0, PorterDuff.Mode.CLEAR);
            this.A01.restore();
        }
        return Collections.unmodifiableList(arrayList);
    }

    static {
        A0A();
        A09 = new byte[]{0, 7, 8, Ascii.SI};
        A0A = new byte[]{0, 119, -120, -1};
        A0B = new byte[]{0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    }

    public K2(int i3, int i4) {
        this.A02.setStyle(Paint.Style.FILL_AND_STROKE);
        this.A02.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.A02.setPathEffect(null);
        this.A03 = new Paint();
        this.A03.setStyle(Paint.Style.FILL);
        this.A03.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        this.A03.setPathEffect(null);
        this.A01 = new Canvas();
        this.A05 = new C0824Jv(719, 575, 0, 719, 0, 575);
        this.A04 = new C0823Ju(0, A0F(), A0G(), A0H());
        this.A06 = new K1(i3, i4);
    }

    public static int A00(int i3, int i4, int i5, int i6) {
        return (i3 << 24) | (i4 << 16) | (i5 << 8) | i6;
    }

    public static int A01(C04544u c04544u, int[] iArr, byte[] bArr, int i3, int i4, Paint paint, Canvas canvas) {
        boolean z2 = false;
        do {
            int iA04 = 0;
            int iA042 = c04544u.A04(2);
            if (iA042 != 0) {
                iA04 = 1;
            } else if (c04544u.A0H()) {
                iA04 = c04544u.A04(3) + 3;
                iA042 = c04544u.A04(2);
            } else if (c04544u.A0H()) {
                iA04 = 1;
                iA042 = 0;
            } else {
                switch (c04544u.A04(2)) {
                    case 0:
                        z2 = true;
                        iA042 = 0;
                        break;
                    case 1:
                        iA04 = 2;
                        iA042 = 0;
                        break;
                    case 2:
                        int iA043 = c04544u.A04(4);
                        if (A08[7].charAt(9) != 'e') {
                            A08[7] = "PWQusWjmzTX1R8w37TeIuijcGSqhz46U";
                            iA04 = iA043 + 12;
                            iA042 = c04544u.A04(2);
                        } else {
                            throw new RuntimeException();
                        }
                        break;
                    case 3:
                        iA04 = c04544u.A04(8) + 29;
                        iA042 = c04544u.A04(2);
                        break;
                    default:
                        iA042 = 0;
                        break;
                }
            }
            if (iA04 != 0 && paint != null) {
                if (bArr != null) {
                    iA042 = bArr[iA042];
                }
                paint.setColor(iArr[iA042]);
                canvas.drawRect(i3, i4, i3 + iA04, i4 + 1, paint);
            }
            i3 += iA04;
        } while (!z2);
        return i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0071 A[PHI: r0
      0x0071: PHI (r0v20 int) = (r0v18 int), (r0v23 int) binds: [B:25:0x0080, B:22:0x006f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A02(com.facebook.ads.redexgen.core.C04544u r14, int[] r15, byte[] r16, int r17, int r18, android.graphics.Paint r19, android.graphics.Canvas r20) {
        /*
            Method dump skipped, instruction units count: 216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.K2.A02(com.facebook.ads.redexgen.X.4u, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    public static int A03(C04544u c04544u, int[] iArr, byte[] bArr, int i3, int i4, Paint paint, Canvas canvas) {
        int runLength;
        int i5 = i3;
        boolean z2 = false;
        do {
            int iA04 = c04544u.A04(8);
            if (iA04 != 0) {
                runLength = 1;
            } else if (!c04544u.A0H()) {
                runLength = c04544u.A04(7);
                if (runLength != 0) {
                    iA04 = 0;
                } else {
                    z2 = true;
                    runLength = 0;
                    iA04 = 0;
                }
            } else {
                runLength = c04544u.A04(7);
                iA04 = c04544u.A04(8);
            }
            if (runLength != 0 && paint != null) {
                if (bArr != null) {
                    iA04 = bArr[iA04];
                }
                paint.setColor(iArr[iA04]);
                if (A08[3].charAt(20) != '3') {
                    throw new RuntimeException();
                }
                A08[3] = "mqxvpcZRbZaRJOXRSA703vBu0XWYN9Vd";
                canvas.drawRect(i5, i4, i5 + runLength, i4 + 1, paint);
            }
            i5 += runLength;
        } while (!z2);
        return i5;
    }

    public static C0825Jw A06(C04544u c04544u) {
        int iA04 = c04544u.A04(16);
        c04544u.A09(4);
        int objectCodingMethod = c04544u.A04(2);
        boolean zA0H = c04544u.A0H();
        c04544u.A09(1);
        byte[] bottomFieldData = C5C.A07;
        byte[] bArr = C5C.A07;
        if (objectCodingMethod == 1) {
            int numberOfCodes = c04544u.A04(8);
            c04544u.A09(numberOfCodes * 16);
        } else if (objectCodingMethod == 0) {
            int iA042 = c04544u.A04(16);
            int topFieldDataLength = c04544u.A04(16);
            int objectId = A08[4].charAt(14);
            if (objectId != 57) {
                throw new RuntimeException();
            }
            A08[7] = "H05iJqDXaQUoFjCcOPsdhLa69PYGJoEl";
            if (iA042 > 0) {
                bottomFieldData = new byte[iA042];
                c04544u.A0G(bottomFieldData, 0, iA042);
            }
            if (topFieldDataLength > 0) {
                bArr = new byte[topFieldDataLength];
                c04544u.A0G(bArr, 0, topFieldDataLength);
            } else {
                bArr = bottomFieldData;
            }
        }
        return new C0825Jw(iA04, zA0H, bottomFieldData, bArr);
    }

    public static C0826Jx A07(C04544u c04544u, int i3) {
        int iA04 = c04544u.A04(8);
        int iA042 = c04544u.A04(4);
        int iA043 = c04544u.A04(2);
        c04544u.A09(2);
        int i4 = i3 - 2;
        SparseArray sparseArray = new SparseArray();
        while (i4 > 0) {
            int remainingLength = c04544u.A04(8);
            c04544u.A09(8);
            int version = c04544u.A04(16);
            int timeoutSecs = c04544u.A04(16);
            i4 -= 6;
            sparseArray.put(remainingLength, new C0827Jy(version, timeoutSecs));
        }
        return new C0826Jx(iA04, iA042, iA043, sparseArray);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0111  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A0B(com.facebook.ads.redexgen.core.C04544u r7, com.facebook.ads.redexgen.core.K1 r8) {
        /*
            Method dump skipped, instruction units count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.K2.A0B(com.facebook.ads.redexgen.X.4u, com.facebook.ads.redexgen.X.K1):void");
    }

    public static void A0C(C0825Jw c0825Jw, C0823Ju c0823Ju, int i3, int i4, int i5, Paint paint, Canvas canvas) {
        int[] iArr;
        if (i3 == 3) {
            iArr = c0823Ju.A03;
        } else if (i3 == 2) {
            iArr = c0823Ju.A02;
        } else {
            iArr = c0823Ju.A01;
        }
        A0D(c0825Jw.A03, iArr, i3, i4, i5, paint, canvas);
        A0D(c0825Jw.A02, iArr, i3, i4, i5 + 1, paint, canvas);
    }

    public static void A0D(byte[] bArr, int[] iArr, int i3, int i4, int i5, Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        int i6 = i5;
        C04544u c04544u = new C04544u(bArr);
        byte[] clutMapTable2To8 = null;
        byte[] clutMapTable2To4 = null;
        byte[] bArrA0E = null;
        int line = i4;
        while (c04544u.A01() != 0) {
            switch (c04544u.A04(8)) {
                case 16:
                    if (i3 == 3) {
                        bArr2 = clutMapTable2To4 == null ? A0A : clutMapTable2To4;
                    } else if (i3 == 2) {
                        bArr2 = clutMapTable2To8 == null ? A09 : clutMapTable2To8;
                    } else {
                        bArr2 = null;
                    }
                    line = A01(c04544u, iArr, bArr2, line, i6, paint, canvas);
                    c04544u.A06();
                    break;
                case 17:
                    if (i3 == 3) {
                        bArr3 = bArrA0E == null ? A0B : bArrA0E;
                    } else {
                        bArr3 = null;
                    }
                    line = A02(c04544u, iArr, bArr3, line, i6, paint, canvas);
                    c04544u.A06();
                    break;
                case 18:
                    line = A03(c04544u, iArr, null, line, i6, paint, canvas);
                    break;
                case 32:
                    clutMapTable2To8 = A0E(4, 4, c04544u);
                    break;
                case 33:
                    clutMapTable2To4 = A0E(4, 8, c04544u);
                    break;
                case 34:
                    bArrA0E = A0E(16, 8, c04544u);
                    break;
                case 240:
                    i6 += 2;
                    line = i4;
                    break;
            }
        }
    }

    public static byte[] A0E(int i3, int i4, C04544u c04544u) {
        byte[] bArr = new byte[i3];
        for (int i5 = 0; i5 < i3; i5++) {
            bArr[i5] = (byte) c04544u.A04(i4);
        }
        return bArr;
    }

    public static int[] A0F() {
        int[] iArr = new int[4];
        iArr[0] = 0;
        iArr[1] = -1;
        iArr[2] = -16777216;
        String[] strArr = A08;
        if (strArr[2].charAt(19) == strArr[6].charAt(19)) {
            throw new RuntimeException();
        }
        A08[1] = "Jw8cEdbjQQjFC79Gk6sPH9AUdvvWBQg4";
        iArr[3] = -8421505;
        return iArr;
    }

    public static int[] A0G() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i3 = 1; i3 < iArr.length; i3++) {
            if (i3 < 8) {
                int i4 = (i3 & 1) != 0 ? 255 : 0;
                iArr[i3] = A00(255, i4, (i3 & 2) != 0 ? 255 : 0, (i3 & 4) != 0 ? 255 : 0);
            } else {
                int i5 = (i3 & 1) != 0 ? 127 : 0;
                int i6 = (i3 & 2) != 0 ? 127 : 0;
                int i7 = i3 & 4;
                if (A08[4].charAt(14) != '9') {
                    throw new RuntimeException();
                }
                A08[3] = "UrHD9QQTZDyJKzMppguU3aPtXoZ0irSR";
                iArr[i3] = A00(255, i5, i6, i7 == 0 ? 0 : 127);
            }
        }
        return iArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:131:0x0029, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int[] A0H() {
        /*
            Method dump skipped, instruction units count: 358
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.K2.A0H():int[]");
    }

    public final void A0J() {
        this.A06.A00();
    }
}
