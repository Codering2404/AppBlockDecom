package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.nW, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2038nW implements AnonymousClass24 {
    public static byte[] A03;
    public static String[] A04 = {"kjXOolT", "y1uosoppcQ2KAnagmdUHUDs2pqKkNOP", "9S5fCrLfVI6Z6wWSlA", "LW4KLvv", "ESAoxwChDjEBJ2YD38hEjiU5IsN", "MD8cz6uZEkXt7x64XO0blzPRBkN5Dhm8", "wv8vTraLOdvtLK52tGc0aCYgNtDO0cFF", "ftZS2reRIxcEfCn6parOlN78mV3R9Y2K"};
    public static final AnonymousClass23<C2038nW> A05;
    public static final C2038nW A06;
    public static final String A07;
    public int A00;
    public final int A01;
    public final BP<C2171pg> A02;

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 95);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        byte[] bArr = {119, 79, 86, 78, 83, 74, 86, Framer.STDIN_REQUEST_FRAME_PREFIX, Ascii.SUB, 83, 94, Framer.STDIN_REQUEST_FRAME_PREFIX, 84, 78, 83, 89, 91, 86, Ascii.SUB, 110, 72, 91, 89, 81, 125, 72, 85, 79, 74, 73, Ascii.SUB, 91, 94, 94, Framer.STDIN_REQUEST_FRAME_PREFIX, 94, Ascii.SUB, 78, 85, Ascii.SUB, 85, 84, Framer.STDIN_REQUEST_FRAME_PREFIX, Ascii.SUB, 110, 72, 91, 89, 81, 125, 72, 85, 79, 74, 123, 72, 72, 91, 67, Ascii.DC4, 81, 119, 100, 102, 110, 66, 119, 106, 112, 117, 68, 119, 119, 100, 124};
        if (A04[5].charAt(31) == 'Q') {
            throw new RuntimeException();
        }
        A04[4] = "LoVxB454";
        A03 = bArr;
    }

    static {
        A03();
        A06 = new C2038nW(new C2171pg[0]);
        A07 = C5C.A0h(0);
        A05 = new AnonymousClass23() { // from class: com.facebook.ads.redexgen.X.nX
            @Override // com.facebook.ads.redexgen.core.AnonymousClass23
            public final AnonymousClass24 A6f(Bundle bundle) {
                return C2038nW.A00(bundle);
            }
        };
    }

    public C2038nW(C2171pg... c2171pgArr) {
        this.A02 = BP.A07(c2171pgArr);
        this.A01 = c2171pgArr.length;
        A02();
    }

    public static /* synthetic */ C2038nW A00(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(A07);
        if (parcelableArrayList == null) {
            return new C2038nW(new C2171pg[0]);
        }
        return new C2038nW((C2171pg[]) AnonymousClass44.A01(C2171pg.A06, parcelableArrayList).toArray(new C2171pg[0]));
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0007 */
    /* JADX WARN: Incorrect condition in loop: B:7:0x0011 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A02() {
        /*
            r7 = this;
            r6 = 0
        L1:
            com.facebook.ads.redexgen.X.BP<com.facebook.ads.redexgen.X.pg> r0 = r7.A02
            int r0 = r0.size()
            if (r6 >= r0) goto L50
            int r5 = r6 + 1
        Lb:
            com.facebook.ads.redexgen.X.BP<com.facebook.ads.redexgen.X.pg> r0 = r7.A02
            int r0 = r0.size()
            if (r5 >= r0) goto L4d
            com.facebook.ads.redexgen.X.BP<com.facebook.ads.redexgen.X.pg> r0 = r7.A02
            java.lang.Object r1 = r0.get(r6)
            com.facebook.ads.redexgen.X.pg r1 = (com.facebook.ads.redexgen.core.C2171pg) r1
            com.facebook.ads.redexgen.X.BP<com.facebook.ads.redexgen.X.pg> r0 = r7.A02
            java.lang.Object r0 = r0.get(r5)
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L4a
            r2 = 0
            r1 = 60
            r0 = 101(0x65, float:1.42E-43)
            java.lang.String r0 = A01(r2, r1, r0)
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            r4.<init>(r0)
            r2 = 60
            r1 = 15
            r0 = 90
            java.lang.String r3 = A01(r2, r1, r0)
            r2 = 0
            r1 = 0
            r0 = 115(0x73, float:1.61E-43)
            java.lang.String r0 = A01(r2, r1, r0)
            com.facebook.ads.redexgen.core.AbstractC04404g.A08(r3, r0, r4)
        L4a:
            int r5 = r5 + 1
            goto Lb
        L4d:
            int r6 = r6 + 1
            goto L1
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2038nW.A02():void");
    }

    public final int A04(C2171pg c2171pg) {
        int index = this.A02.indexOf(c2171pg);
        if (index >= 0) {
            return index;
        }
        return -1;
    }

    public final C2171pg A05(int i3) {
        return this.A02.get(i3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2038nW c2038nW = (C2038nW) obj;
        return this.A01 == c2038nW.A01 && this.A02.equals(c2038nW.A02);
    }

    public final int hashCode() {
        if (this.A00 == 0) {
            this.A00 = this.A02.hashCode();
        }
        int i3 = this.A00;
        String[] strArr = A04;
        if (strArr[3].length() != strArr[0].length()) {
            throw new RuntimeException();
        }
        A04[6] = "ifk0Ba0Zppjn7MlaJBrmzFqZbJ0HKklT";
        return i3;
    }
}
