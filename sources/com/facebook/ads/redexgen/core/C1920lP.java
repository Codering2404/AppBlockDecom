package com.facebook.ads.redexgen.core;

import android.util.SparseArray;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lP, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1920lP implements LE {
    public static byte[] A02;
    public static String[] A03 = {"H5L2tIFZt", "7T8ctTOgfri2uFWYkrl4fLjFw3zYZmyw", "rpSuNqLmPSNrp8BaktpsZc4frut4njZi", "OS1ujTmztQNXT6hqD6nsoX0kfRSYmmsY", "PkY6KfFeVbpCvwlFdEj", "TmaVkoyYGnCbszGh0vcMc", "p0AihzwiszaEN", "o1l4pHohEGjnpBhSGl6NtukXiQnI0CCo"};
    public final int A00;
    public final List<C2208qI> A01;

    public static String A02(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 72);
        }
        return new String(bArrCopyOfRange);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private List<C2208qI> A03(LD ld) {
        String strA02;
        int i3;
        if (A05(32)) {
            return this.A01;
        }
        C04554v c04554v = new C04554v(ld.A03);
        List<C2208qI> arrayList = this.A01;
        while (c04554v.A07() > 0) {
            int iA0I = c04554v.A0I();
            int iA09 = c04554v.A09() + c04554v.A0I();
            if (iA0I == 134) {
                arrayList = new ArrayList<>();
                int iA0I2 = c04554v.A0I() & 31;
                for (int i4 = 0; i4 < iA0I2; i4++) {
                    String strA0W = c04554v.A0W(3);
                    int iA0I3 = c04554v.A0I();
                    boolean z2 = (iA0I3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0;
                    if (z2) {
                        strA02 = A02(19, 19, 47);
                        i3 = iA0I3 & 63;
                    } else {
                        strA02 = A02(0, 19, 57);
                        i3 = 1;
                    }
                    byte bA0I = (byte) c04554v.A0I();
                    c04554v.A0g(1);
                    List<byte[]> listA04 = null;
                    if (z2) {
                        boolean z3 = (bA0I & 64) != 0;
                        if (A03[5].length() != 21) {
                            throw new RuntimeException();
                        }
                        String[] strArr = A03;
                        strArr[6] = "Fx9tcNCtSciYr";
                        strArr[4] = "fWuzF8xs7o61BMX22RC";
                        listA04 = AnonymousClass46.A04(z3);
                    }
                    arrayList.add(new C03992p().A11(strA02).A10(strA0W).A0Z(i3).A12(listA04).A14());
                }
            }
            c04554v.A0f(iA09);
        }
        return arrayList;
    }

    public static void A04() {
        A02 = new byte[]{-30, -15, -15, -19, -22, -28, -30, -11, -22, -16, -17, -80, -28, -26, -30, -82, -73, -79, -71, -40, -25, -25, -29, -32, -38, -40, -21, -32, -26, -27, -90, -38, -36, -40, -92, -82, -89, -81, Ascii.FF, Ascii.ESC, Ascii.ESC, Ascii.ETB, Ascii.DC4, Ascii.SO, Ascii.FF, Ascii.US, Ascii.DC4, Ascii.SUB, Ascii.EM, -38, Framer.ENTER_FRAME_PREFIX, Ascii.EM, Ascii.SI, -39, Ascii.SI, Framer.ENTER_FRAME_PREFIX, Ascii.CR, -39, Ascii.FF, Ascii.DC4, Ascii.US, -61, -46, -46, -50, -53, -59, -61, -42, -53, -47, -48, -111, -38, -113, -43, -59, -42, -57, -107, -105};
    }

    static {
        A04();
    }

    public C1920lP() {
        this(0);
    }

    @MetaExoPlayerCustomization("Replaces ImmutableList.of with MetaExoPlayerCustomizedCollections")
    public C1920lP(int i3) {
        this(i3, MetaExoPlayerCustomizedCollections.A03(new C2208qI[0]));
    }

    public C1920lP(int i3, List<C2208qI> list) {
        this.A00 = i3;
        this.A01 = list;
    }

    private L9 A00(LD ld) {
        return new L9(A03(ld));
    }

    private LJ A01(LD ld) {
        return new LJ(A03(ld));
    }

    private boolean A05(int i3) {
        return (this.A00 & i3) != 0;
    }

    @Override // com.facebook.ads.redexgen.core.LE
    public final SparseArray<LH> A5Q() {
        return new SparseArray<>();
    }

    @Override // com.facebook.ads.redexgen.core.LE
    public final LH A5V(int i3, LD ld) {
        switch (i3) {
            case 2:
            case ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD /* 128 */:
                return new C1909lE(new C1917lM(A01(ld)));
            case 3:
            case 4:
                return new C1909lE(new C1911lG(ld.A01));
            case 15:
                if (A05(2)) {
                    return null;
                }
                return new C1909lE(new C1921lQ(false, ld.A01));
            case 16:
                return new C1909lE(new C1916lL(A01(ld)));
            case 17:
                if (A05(2)) {
                    return null;
                }
                return new C1909lE(new C1912lH(ld.A01));
            case 21:
                return new C1909lE(new C1913lI());
            case 27:
                if (A05(4)) {
                    return null;
                }
                return new C1909lE(new C1915lK(A00(ld), A05(1), A05(8)));
            case 36:
                return new C1909lE(new C1914lJ(A00(ld)));
            case 89:
                return new C1909lE(new C1918lN(ld.A02));
            case 129:
            case 135:
                return new C1909lE(new C1927lW(ld.A01));
            case 130:
                if (!A05(64)) {
                    return null;
                }
                break;
            case 134:
                if (A05(16)) {
                    return null;
                }
                return new C1904l9(new C1910lF(A02(61, 20, 26)));
            case 138:
                break;
            case 172:
                return new C1909lE(new C1924lT(ld.A01));
            case 257:
                return new C1904l9(new C1910lF(A02(38, 23, 99)));
            default:
                return null;
        }
        return new C1909lE(new C1919lO(ld.A01));
    }
}
