package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.androidx.media3.common.Format;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.pg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2171pg implements AnonymousClass24 {
    public static byte[] A05;
    public static final AnonymousClass23<C2171pg> A06;
    public static final String A07;
    public static final String A08;
    public int A00;
    public final int A01;
    public final int A02;
    public final String A03;
    public final C2208qI[] A04;

    public static String A02(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 15);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A05 = new byte[]{Framer.STDIN_REQUEST_FRAME_PREFIX, Ascii.FS, Ascii.DLE, Ascii.DC2, Ascii.GS, Ascii.SYN, 17, Ascii.SUB, Ascii.ESC, Framer.STDIN_REQUEST_FRAME_PREFIX, Ascii.SYN, 17, Framer.STDIN_REQUEST_FRAME_PREFIX, Ascii.DLE, 17, Ascii.SUB, Framer.STDIN_REQUEST_FRAME_PREFIX, 43, Ascii.CR, Ascii.RS, Ascii.FS, Ascii.DC4, 56, Ascii.CR, Ascii.DLE, 10, Ascii.SI, 69, Framer.STDIN_REQUEST_FRAME_PREFIX, 88, 100, 99, 107, 55, Framer.STDOUT_FRAME_PREFIX, 34, 32, 40, 99, 112, 119, Ascii.DEL, 35, 37, 54, 52, 60, 119, 103, 126, 119, 54, 57, 51, 119, 112, 62, 106, 71, 72, 72, 75, 92, 75, 64, 90, Ascii.SO, Ascii.SYN, 48, 35, Framer.ENTER_FRAME_PREFIX, 41, 5, 48, Framer.STDIN_FRAME_PREFIX, 55, Framer.STDERR_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 63, 48, 57, 43, 63, 57, 59, Framer.STDIN_FRAME_PREFIX, 40, 53, 54, 63, 122, 60, 54, 59, 61, 41, 61, 38, 44};
    }

    static {
        A05();
        A07 = C5C.A0h(0);
        A08 = C5C.A0h(1);
        A06 = new AnonymousClass23() { // from class: com.facebook.ads.redexgen.X.ph
            @Override // com.facebook.ads.redexgen.core.AnonymousClass23
            public final AnonymousClass24 A6f(Bundle bundle) {
                return C2171pg.A01(bundle);
            }
        };
    }

    public C2171pg(String str, C2208qI... c2208qIArr) {
        AbstractC04323y.A07(c2208qIArr.length > 0);
        this.A03 = str;
        this.A04 = c2208qIArr;
        this.A01 = c2208qIArr.length;
        int iA01 = C3J.A01(c2208qIArr[0].A0W);
        this.A02 = iA01 == -1 ? C3J.A01(c2208qIArr[0].A0S) : iA01;
        A04();
    }

    public C2171pg(C2208qI... c2208qIArr) {
        this(A02(0, 0, 114), c2208qIArr);
    }

    public static int A00(int i3) {
        return i3 | 16384;
    }

    public static /* synthetic */ C2171pg A01(Bundle bundle) {
        List listA01;
        List<Format> formats = bundle.getParcelableArrayList(A07);
        if (formats == null) {
            listA01 = MetaExoPlayerCustomizedCollections.A01();
        } else {
            listA01 = AnonymousClass44.A01(C2208qI.A0b, formats);
        }
        String id = bundle.getString(A08, A02(0, 0, 114));
        return new C2171pg(id, (C2208qI[]) listA01.toArray(new C2208qI[0]));
    }

    public static String A03(String str) {
        return (str == null || str.equals(A02(96, 3, 71))) ? A02(0, 0, 114) : str;
    }

    private void A04() {
        String strA03 = A03(this.A04[0].A0V);
        int iA00 = A00(this.A04[0].A0E);
        for (int i3 = 1; i3 < this.A04.length; i3++) {
            String language = this.A04[i3].A0V;
            if (!strA03.equals(A03(language))) {
                String str = this.A04[0].A0V;
                String str2 = this.A04[i3].A0V;
                String language2 = A02(77, 9, 81);
                A06(language2, str, str2, i3);
                return;
            }
            if (iA00 != A00(this.A04[i3].A0E)) {
                String binaryString = Integer.toBinaryString(this.A04[0].A0E);
                String binaryString2 = Integer.toBinaryString(this.A04[i3].A0E);
                String language3 = A02(86, 10, 85);
                A06(language3, binaryString, binaryString2, i3);
                return;
            }
        }
    }

    public static void A06(String str, String str2, String str3, int i3) {
        AbstractC04404g.A08(A02(67, 10, 77), A02(0, 0, 114), new IllegalStateException(A02(57, 10, 33) + str + A02(0, 30, 112) + str2 + A02(39, 17, 88) + str3 + A02(30, 9, 76) + i3 + A02(56, 1, 24)));
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0004 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A07(com.facebook.ads.redexgen.core.C2208qI r3) {
        /*
            r2 = this;
            r1 = 0
        L1:
            com.facebook.ads.redexgen.X.qI[] r0 = r2.A04
            int r0 = r0.length
            if (r1 >= r0) goto L10
            com.facebook.ads.redexgen.X.qI[] r0 = r2.A04
            r0 = r0[r1]
            if (r3 != r0) goto Ld
            return r1
        Ld:
            int r1 = r1 + 1
            goto L1
        L10:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2171pg.A07(com.facebook.ads.redexgen.X.qI):int");
    }

    public final C2208qI A08(int i3) {
        return this.A04[i3];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2171pg c2171pg = (C2171pg) obj;
        return this.A03.equals(c2171pg.A03) && Arrays.equals(this.A04, c2171pg.A04);
    }

    public final int hashCode() {
        if (this.A00 == 0) {
            int result = this.A03.hashCode();
            this.A00 = (((17 * 31) + result) * 31) + Arrays.hashCode(this.A04);
        }
        int result2 = this.A00;
        return result2;
    }
}
