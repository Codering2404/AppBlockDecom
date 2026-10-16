package com.facebook.ads.redexgen.core;

import android.view.View;
import android.view.ViewGroup;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class RA {
    public static byte[] A09;
    public static String[] A0A = {"", "d6jyZ4YF4aAx6mY2oyMV8cMH3x1tTmGX", "6ShmsSFKDmdiSeaEbVJI0pMmhv", "Jy6CLSdjiTJVmxisrmhO9od6ZqYVQGpz", "aKDRqPZxmSwbRmY5O7VQCqOvGq0yRVmO", "vr6xx06LqTBYtEPA9ZzozSqPDwzkbNaY", "Y84hViIy7qYskGYmJ3QVEouknT", ""};
    public R9 A01;
    public RI A04;
    public final /* synthetic */ C7M A08;
    public final ArrayList<RK> A05 = new ArrayList<>();
    public ArrayList<RK> A02 = null;
    public final ArrayList<RK> A06 = new ArrayList<>();
    public final List<RK> A07 = Collections.unmodifiableList(this.A05);
    public int A03 = 2;
    public int A00 = 2;

    public static String A04(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A09, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 10);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A09 = new byte[]{113, 56, 34, Ascii.DLE, 37, 37, 48, Framer.STDERR_FRAME_PREFIX, 57, 52, 53, 107, 56, 86, 17, Ascii.CAN, Ascii.CAN, Ascii.CR, Ascii.ESC, 10, 68, 32, 39, 41, 64, 125, 108, 100, 41, 106, 102, 124, 103, 125, 51, 79, 72, Ascii.NAK, Ascii.DC2, 7, Ascii.DC2, 3, 92, 121, 91, 86, 86, Framer.STDIN_REQUEST_FRAME_PREFIX, 94, Ascii.SUB, 73, 89, 72, 91, 74, Ascii.SUB, 76, 83, Framer.STDIN_REQUEST_FRAME_PREFIX, 77, Ascii.SUB, 77, 83, 78, 82, Ascii.SUB, 91, 84, Ascii.SUB, 83, 84, 76, 91, 86, 83, 94, Ascii.SUB, 76, 83, Framer.STDIN_REQUEST_FRAME_PREFIX, 77, Ascii.DC4, Ascii.SUB, 115, 84, 76, 91, 86, 83, 94, Ascii.SUB, 76, 83, Framer.STDIN_REQUEST_FRAME_PREFIX, 77, 73, Ascii.SUB, 89, 91, 84, 84, 85, 78, Ascii.SUB, 88, Framer.STDIN_REQUEST_FRAME_PREFIX, Ascii.SUB, 72, Framer.STDIN_REQUEST_FRAME_PREFIX, 79, 73, Framer.STDIN_REQUEST_FRAME_PREFIX, 94, Ascii.SUB, 92, 72, 85, 87, Ascii.SUB, 73, 89, 72, 91, 74, Ascii.SYN, Ascii.SUB, 78, 82, Framer.STDIN_REQUEST_FRAME_PREFIX, 67, Ascii.SUB, 73, 82, 85, 79, 86, 94, Ascii.SUB, 72, Framer.STDIN_REQUEST_FRAME_PREFIX, 88, 85, 79, 84, 94, Ascii.SUB, 92, 72, 85, 87, Ascii.SUB, 72, Framer.STDIN_REQUEST_FRAME_PREFIX, 89, 67, 89, 86, Framer.STDIN_REQUEST_FRAME_PREFIX, 72, Ascii.SUB, 74, 85, 85, 86, Ascii.DC4, 116, 83, 94, 82, 83, 78, 84, 78, 73, 88, 83, 94, 68, Ascii.GS, 89, 88, 73, 88, 94, 73, 88, 89, 19, Ascii.GS, 116, 83, 75, 92, 81, 84, 89, Ascii.GS, 84, 73, 88, 80, Ascii.GS, 77, 82, 78, 84, 73, 84, 82, 83, Ascii.GS, Ascii.US, 56, 53, 57, 56, 37, 63, 37, 34, 51, 56, 53, 47, 118, Framer.STDERR_FRAME_PREFIX, 51, 34, 51, 53, 34, 51, Framer.STDERR_FRAME_PREFIX, Framer.EXIT_FRAME_PREFIX, 118, Ascii.US, 56, 32, 55, 58, 63, Framer.STDERR_FRAME_PREFIX, 118, 32, 63, 51, Framer.ENTER_FRAME_PREFIX, 118, 62, 57, 58, Framer.STDERR_FRAME_PREFIX, 51, 36, 118, 55, Framer.STDERR_FRAME_PREFIX, 55, 38, 34, 51, 36, 118, 38, 57, 37, 63, 34, 63, 57, 56, 89, 126, 102, 113, 124, 121, 116, 48, 121, 100, 117, 125, 48, 96, Ascii.DEL, 99, 121, 100, 121, Ascii.DEL, 126, 48, Ascii.DC2, 34, 51, 32, Framer.STDOUT_FRAME_PREFIX, Framer.STDOUT_FRAME_PREFIX, 36, 37, 97, 46, 51, 97, 32, 53, 53, 32, 34, 41, 36, 37, 97, 55, 40, 36, 54, Framer.STDERR_FRAME_PREFIX, 97, 44, 32, 56, 97, 47, 46, 53, 97, 35, 36, 97, 51, 36, 34, 56, 34, Framer.STDIN_FRAME_PREFIX, 36, 37, 111, 97, 40, Framer.STDERR_FRAME_PREFIX, Ascii.DC2, 34, 51, 32, Framer.STDOUT_FRAME_PREFIX, 123, 108, 85, 72, Ascii.CAN, 92, 93, 76, 89, 91, 80, 93, 92, Ascii.CAN, 78, 81, 93, 79, Ascii.CAN, 75, 80, 87, 77, 84, 92, Ascii.CAN, 90, 93, Ascii.CAN, 74, 93, 85, 87, 78, 93, 92, Ascii.CAN, 94, 74, 87, 85, Ascii.CAN, 106, 93, 91, 65, 91, 84, 93, 74, 110, 81, 93, 79, Ascii.CAN, 90, 93, 94, 87, 74, 93, Ascii.CAN, 81, 76, Ascii.CAN, 91, 89, 86, Ascii.CAN, 90, 93, Ascii.CAN, 74, 93, 91, 65, 91, 84, 93, 92, 2, Ascii.CAN, 87, 113, 122, 106, 109, 100, 35, 119, 108, 35, 113, 102, 96, 122, 96, 111, 102, 35, 98, 109, 35, 106, 100, 109, 108, 113, 102, 103, 35, 117, 106, 102, 116, 35, 107, 108, 111, 103, 102, 113, Framer.STDIN_FRAME_PREFIX, 35, 90, 108, 118, 35, 112, 107, 108, 118, 111, 103, 35, 101, 106, 113, 112, 119, 35, 96, 98, 111, 111, 35, 112, 119, 108, 115, 74, 100, 109, 108, 113, 106, 109, 100, 85, 106, 102, 116, 43, 117, 106, 102, 116, 42, 35, 97, 102, 101, 108, 113, 102, 35, 96, 98, 111, 111, 106, 109, 100, 35, 113, 102, 96, 122, 96, 111, 102, Framer.STDIN_FRAME_PREFIX, 48, Framer.STDERR_FRAME_PREFIX, 35, 1, 62, Framer.STDERR_FRAME_PREFIX, 32, 17, 56, 37, 7, 56, 36, 62, 35, 62, 56, 57, Ascii.SYN, 57, 51, 3, 46, 39, Framer.STDERR_FRAME_PREFIX, Ascii.GS, Ascii.DLE, 8, Ascii.RS, 4, 5, 81, Ascii.CAN, Ascii.US, Ascii.NAK, Ascii.DC4, 9, 81, 2, Ascii.EM, Ascii.RS, 4, Ascii.GS, Ascii.NAK, 81, Ascii.US, Ascii.RS, 5, 81, 19, Ascii.DC4, 81, 92, 64, 81, Ascii.DLE, Ascii.ETB, 5, Ascii.DC4, 3, 81, 4, Ascii.US, Ascii.EM, Ascii.CAN, Ascii.NAK, Ascii.CAN, Ascii.US, Ascii.SYN, 81, Ascii.DLE, 81, 7, Ascii.CAN, Ascii.DC4, 6, 75, 69, 68, 124, 67, 79, 93, Framer.EXIT_FRAME_PREFIX, 79, 73, 83, 73, 70, 79, 78};
    }

    static {
        A05();
    }

    public RA(C7M c7m) {
        this.A08 = c7m;
    }

    private final View A00(int i3, boolean z2) {
        return A0I(i3, z2, Long.MAX_VALUE).A0H;
    }

    private final RK A01(int i3) {
        int size;
        int iA04;
        if (this.A02 == null || (size = this.A02.size()) == 0) {
            return null;
        }
        for (int i4 = 0; i4 < size; i4++) {
            RK rk = this.A02.get(i4);
            if (!rk.A0m()) {
                int i5 = rk.A0O();
                if (i5 == i3) {
                    rk.A0Z(32);
                    return rk;
                }
            }
        }
        if (this.A08.A04.A0M() && (iA04 = this.A08.A00.A04(i3)) > 0) {
            int offsetPosition = this.A08.A04.A0B();
            if (iA04 < offsetPosition) {
                long jA0D = this.A08.A04.A0D(iA04);
                for (int i6 = 0; i6 < size; i6++) {
                    RK rk2 = this.A02.get(i6);
                    if (!rk2.A0m() && rk2.A0Q() == jA0D) {
                        rk2.A0Z(32);
                        return rk2;
                    }
                }
            }
        }
        return null;
    }

    private final RK A02(int i3, boolean z2) {
        View viewA08;
        int size = this.A05.size();
        for (int i4 = 0; i4 < size; i4++) {
            RK rk = this.A05.get(i4);
            if (!rk.A0m()) {
                int scrapCount = rk.A0O();
                if (scrapCount == i3 && !rk.A0f() && (this.A08.A0s.A09 || !rk.A0g())) {
                    rk.A0Z(32);
                    return rk;
                }
            }
        }
        if (!z2 && (viewA08 = this.A08.A01.A08(i3)) != null) {
            RK rkA0F = C7M.A0F(viewA08);
            this.A08.A01.A0G(viewA08);
            int iA07 = this.A08.A01.A07(viewA08);
            if (iA07 != -1) {
                this.A08.A01.A0C(iA07);
                A0S(viewA08);
                rkA0F.A0Z(8224);
                return rkA0F;
            }
            throw new IllegalStateException(A04(565, 52, 123) + rkA0F + this.A08.A1J());
        }
        int size2 = this.A06.size();
        for (int i5 = 0; i5 < size2; i5++) {
            RK holder = this.A06.get(i5);
            String[] strArr = A0A;
            String str = strArr[7];
            String str2 = strArr[0];
            int cacheSize = str.length();
            int scrapCount2 = str2.length();
            if (cacheSize != scrapCount2) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0A;
            strArr2[4] = "JIr6ryR6hWTh2WYmHdarh5TP4xAypylw";
            strArr2[1] = "npmC62BAQEqZygYceoAiNhkQGghR92x0";
            if (!holder.A0f()) {
                int scrapCount3 = holder.A0O();
                if (scrapCount3 == i3) {
                    if (!z2) {
                        this.A06.remove(i5);
                    }
                    return holder;
                }
            }
        }
        return null;
    }

    private final RK A03(long j3, int i3, boolean z2) {
        int count = this.A05.size();
        for (int i4 = count - 1; i4 >= 0; i4--) {
            RK rk = this.A05.get(i4);
            if (rk.A0Q() == j3 && !rk.A0m()) {
                int count2 = rk.A0N();
                if (i3 == count2) {
                    rk.A0Z(32);
                    boolean zA0g = rk.A0g();
                    String[] strArr = A0A;
                    String str = strArr[2];
                    String str2 = strArr[6];
                    int i5 = str.length();
                    int count3 = str2.length();
                    if (i5 == count3) {
                        String[] strArr2 = A0A;
                        strArr2[4] = "3Wf6vMFZ4V6K3VYEAeXlgILB3Kqn8tmj";
                        strArr2[1] = "2gRFj7AUivxslEY3Do0gPT185jjA6g6i";
                        if (zA0g && !this.A08.A0s.A07()) {
                            rk.A0a(2, 14);
                        }
                        return rk;
                    }
                } else if (z2) {
                    continue;
                } else {
                    this.A05.remove(i4);
                    C7M c7m = this.A08;
                    View view = rk.A0H;
                    String[] strArr3 = A0A;
                    String str3 = strArr3[7];
                    String str4 = strArr3[0];
                    int i6 = str3.length();
                    int count4 = str4.length();
                    if (i6 == count4) {
                        String[] strArr4 = A0A;
                        strArr4[5] = "QSy8SYzj9TGZXONlvrRd2Hl7xNggaX2t";
                        strArr4[3] = "FStY7c67BTbAcWAeNWEJdNOuKPlMCdqH";
                        c7m.removeDetachedView(view, false);
                        A0R(rk.A0H);
                    }
                }
                throw new RuntimeException();
            }
        }
        int count5 = this.A06.size();
        for (int i7 = count5 - 1; i7 >= 0; i7--) {
            RK rk2 = this.A06.get(i7);
            if (rk2.A0Q() == j3) {
                int count6 = rk2.A0N();
                if (i3 == count6) {
                    if (!z2) {
                        this.A06.remove(i7);
                    }
                    return rk2;
                }
                if (!z2) {
                    A07(i7);
                    String[] strArr5 = A0A;
                    String str5 = strArr5[7];
                    String str6 = strArr5[0];
                    int cacheSize = str5.length();
                    int count7 = str6.length();
                    if (cacheSize != count7) {
                        throw new RuntimeException();
                    }
                    String[] strArr6 = A0A;
                    strArr6[2] = "Px4MCeB3tpw5Kws4bgsL6OQ2tD";
                    strArr6[6] = "cZzmTfGm3PDqBsfSjCaAnG9aB7";
                    return null;
                }
            }
        }
        return null;
    }

    private final void A06() {
        int count = this.A06.size();
        for (int count2 = count - 1; count2 >= 0; count2--) {
            A07(count2);
        }
        this.A06.clear();
        if (C7M.A1E) {
            this.A08.A02.A02();
        }
    }

    private final void A07(int i3) {
        A0Z(this.A06.get(i3), true);
        this.A06.remove(i3);
    }

    private void A08(ViewGroup viewGroup, boolean z2) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof ViewGroup) {
                A08((ViewGroup) childAt, true);
            }
        }
        if (!z2) {
            return;
        }
        if (viewGroup.getVisibility() == 4) {
            viewGroup.setVisibility(0);
            viewGroup.setVisibility(4);
        } else {
            int visibility = viewGroup.getVisibility();
            viewGroup.setVisibility(4);
            viewGroup.setVisibility(visibility);
        }
    }

    private void A09(RK rk) {
        if (this.A08.A1q()) {
            View view = rk.A0H;
            if (Ph.A00(view) == 0) {
                Ph.A09(view, 1);
            }
            if (Ph.A0F(view)) {
                return;
            }
            String[] strArr = A0A;
            if (strArr[4].charAt(14) != strArr[1].charAt(14)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0A;
            strArr2[5] = "r5izwM6EITTd8J0QgfTuliuK3Ylx6gnH";
            strArr2[3] = "CLm8SGIYJT8sX0J5oMrTiG0qZUHKeksn";
            rk.A0Z(16384);
            Ph.A0B(view, this.A08.A09.A0A());
        }
    }

    private void A0A(RK rk) {
        if (rk.A0H instanceof ViewGroup) {
            A08((ViewGroup) rk.A0H, false);
        }
    }

    private final void A0B(RK rk) {
        if (0 != 0) {
            throw new NullPointerException(A04(617, 14, 32));
        }
        if (this.A08.A0s != null) {
            this.A08.A0t.A0B(rk);
        }
    }

    private final boolean A0C(RK rk) {
        if (rk.A0g()) {
            return this.A08.A0s.A07();
        }
        if (rk.A03 >= 0 && rk.A03 < this.A08.A04.A0B()) {
            if (!this.A08.A0s.A07()) {
                int iA0C = this.A08.A04.A0C(rk.A03);
                int type = rk.A0N();
                if (iA0C != type) {
                    return false;
                }
            }
            return !this.A08.A04.A0M() || rk.A0Q() == this.A08.A04.A0D(rk.A03);
        }
        throw new IndexOutOfBoundsException(A04(211, 60, 92) + rk + this.A08.A1J());
    }

    private boolean A0D(RK rk, int i3, int i4, long j3) {
        rk.A08 = this.A08;
        int iA0N = rk.A0N();
        long nanoTime = this.A08.getNanoTime();
        if (j3 != Long.MAX_VALUE && !this.A01.A0A(iA0N, nanoTime, j3)) {
            return false;
        }
        this.A08.A04.A0J(rk, i3);
        this.A01.A05(rk.A0N(), this.A08.getNanoTime() - nanoTime);
        A09(rk);
        if (this.A08.A0s.A07()) {
            rk.A04 = i4;
            return true;
        }
        return true;
    }

    public final int A0E() {
        return this.A05.size();
    }

    public final View A0F(int i3) {
        return this.A05.get(i3).A0H;
    }

    public final View A0G(int i3) {
        return A00(i3, false);
    }

    public final R9 A0H() {
        if (this.A01 == null) {
            this.A01 = new R9();
        }
        return this.A01;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0244  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.core.RK A0I(int r23, boolean r24, long r25) {
        /*
            Method dump skipped, instruction units count: 730
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.RA.A0I(int, boolean, long):com.facebook.ads.redexgen.X.RK");
    }

    public final List<RK> A0J() {
        return this.A07;
    }

    public final void A0K() {
        int size = this.A06.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.A06.get(i3).A0S();
        }
        int i4 = this.A05.size();
        for (int scrapCount = 0; scrapCount < i4; scrapCount++) {
            this.A05.get(scrapCount).A0S();
        }
        if (this.A02 != null) {
            int changedScrapCount = this.A02.size();
            for (int scrapCount2 = 0; scrapCount2 < changedScrapCount; scrapCount2++) {
                this.A02.get(scrapCount2).A0S();
            }
        }
    }

    public final void A0L() {
        this.A05.clear();
        if (this.A02 != null) {
            this.A02.clear();
        }
    }

    public final void A0M() {
        int size = this.A06.size();
        for (int i3 = 0; i3 < size; i3++) {
            R3 r3 = (R3) this.A06.get(i3).A0H.getLayoutParams();
            if (r3 != null) {
                r3.A01 = true;
            }
        }
    }

    public final void A0N() {
        if (this.A08.A04 != null && this.A08.A04.A0M()) {
            int size = this.A06.size();
            for (int i3 = 0; i3 < size; i3++) {
                RK rk = this.A06.get(i3);
                if (rk != null) {
                    rk.A0Z(6);
                    rk.A0c(null);
                }
            }
            return;
        }
        A06();
    }

    public final void A0O() {
        int i3 = this.A08.A06 != null ? this.A08.A06.A00 : 0;
        int extraCache = this.A03;
        this.A00 = extraCache + i3;
        int extraCache2 = this.A06.size();
        for (int i4 = extraCache2 - 1; i4 >= 0; i4--) {
            int size = this.A06.size();
            int i5 = this.A00;
            String[] strArr = A0A;
            String str = strArr[5];
            String str2 = strArr[3];
            int i6 = str.charAt(9);
            int extraCache3 = str2.charAt(9);
            if (i6 != extraCache3) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0A;
            strArr2[5] = "FM5srU9o6TBj8QlSYYqmaX9MZyJMPTMr";
            strArr2[3] = "mnADOFh1HT7Eu0tfTP5EsiAEmob0QgOc";
            if (size > i5) {
                A07(i4);
            } else {
                return;
            }
        }
    }

    public final void A0P() {
        this.A05.clear();
        A06();
    }

    public final void A0Q(int i3) {
        this.A03 = i3;
        A0O();
    }

    public final void A0R(View view) {
        RK rkA0F = C7M.A0F(view);
        rkA0F.A0F = null;
        rkA0F.A0G = false;
        rkA0F.A0U();
        A0X(rkA0F);
    }

    public final void A0S(View view) {
        RK rkA0F = C7M.A0F(view);
        if (rkA0F.A0o(12) || !rkA0F.A0j() || this.A08.A1y(rkA0F)) {
            if (!rkA0F.A0f() || rkA0F.A0g() || this.A08.A04.A0M()) {
                rkA0F.A0b(this, false);
                this.A05.add(rkA0F);
                return;
            }
            throw new IllegalArgumentException(A04(43, 122, 48) + this.A08.A1J());
        }
        if (this.A02 == null) {
            this.A02 = new ArrayList<>();
        }
        rkA0F.A0b(this, true);
        this.A02.add(rkA0F);
    }

    public final void A0T(View view) {
        RK rkA0F = C7M.A0F(view);
        if (rkA0F.A0i()) {
            this.A08.removeDetachedView(view, false);
        }
        if (rkA0F.A0h()) {
            rkA0F.A0Y();
        } else if (rkA0F.A0m()) {
            rkA0F.A0U();
        }
        A0X(rkA0F);
    }

    public final void A0U(AbstractC0996Qq abstractC0996Qq, AbstractC0996Qq abstractC0996Qq2, boolean z2) {
        A0P();
        A0H().A08(abstractC0996Qq, abstractC0996Qq2, z2);
    }

    public final void A0V(R9 r9) {
        if (this.A01 != null) {
            this.A01.A04();
        }
        this.A01 = r9;
        if (r9 != null) {
            R9 r92 = this.A01;
            AbstractC0996Qq adapter = this.A08.getAdapter();
            String[] strArr = A0A;
            if (strArr[2].length() != strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0A;
            strArr2[4] = "lsZK0accpgBQgJYjkQv5Abfcayw6pcR0";
            strArr2[1] = "Z7g3Rn3k4gV3vNYe90sCMa52PcoBzFf1";
            r92.A07(adapter);
        }
    }

    public final void A0W(RI ri) {
        this.A04 = ri;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x012f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0X(com.facebook.ads.redexgen.core.RK r9) {
        /*
            Method dump skipped, instruction units count: 396
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.RA.A0X(com.facebook.ads.redexgen.X.RK):void");
    }

    public final void A0Y(RK rk) {
        if (rk.A0G) {
            ArrayList<RK> arrayList = this.A02;
            String[] strArr = A0A;
            if (strArr[7].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0A;
            strArr2[2] = "g9dUUHlnr2dNWy2bvXbXpUnxFV";
            strArr2[6] = "1VljHDZyW4yQ7QRXruVc6WBcEp";
            arrayList.remove(rk);
        } else {
            this.A05.remove(rk);
        }
        rk.A0F = null;
        rk.A0G = false;
        rk.A0U();
    }

    public final void A0Z(RK rk, boolean z2) {
        C7M.A0s(rk);
        if (rk.A0o(16384)) {
            rk.A0a(0, 16384);
            Ph.A0B(rk.A0H, null);
        }
        if (z2) {
            A0B(rk);
        }
        rk.A08 = null;
        A0H().A09(rk);
    }
}
