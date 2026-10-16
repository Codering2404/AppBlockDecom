package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.pl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2175pl implements AnonymousClass24 {
    public int A00;
    public long A01;
    public long A02;
    public Object A03;
    public Object A04;
    public boolean A05;
    public C2216qS A06 = C2216qS.A08;
    public static String[] A07 = {"4zGdQbqEEbqON0fsiZAaEQkKoAoKYmna", "yJpzHCnd9V3wUr5Wrx8duzmTaMKaViaS", "6le5bHbrSJ1W0fbLNXPlurR", "jvR1cNhZ0960aRA7pVRRRMqTg6KbIJja", "KqjZe5mn0dP", "Q", "Z7fKuPhHzVcFnrI", "fPry0FIfciS3iZV36uBdTRShtkwqjgIo"};
    public static final String A0D = C5C.A0h(0);
    public static final String A0A = C5C.A0h(1);
    public static final String A0C = C5C.A0h(2);
    public static final String A0B = C5C.A0h(3);
    public static final String A09 = C5C.A0h(4);
    public static final AnonymousClass23<C2175pl> A08 = new AnonymousClass23() { // from class: com.facebook.ads.redexgen.X.pp
        @Override // com.facebook.ads.redexgen.core.AnonymousClass23
        public final AnonymousClass24 A6f(Bundle bundle) {
            return C2175pl.A01(bundle);
        }
    };

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 13 out of bounds for length 12
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static C2175pl A01(Bundle bundle) {
        int i3 = bundle.getInt(A0D, 0);
        long j3 = bundle.getLong(A0A, -9223372036854775807L);
        long j4 = bundle.getLong(A0C, 0L);
        boolean z2 = bundle.getBoolean(A0B, false);
        Bundle bundle2 = bundle.getBundle(A09);
        C2216qS c2216qS = bundle2 != null ? (C2216qS) C2216qS.A09.A6f(bundle2) : C2216qS.A08;
        C2175pl c2175pl = new C2175pl();
        c2175pl.A0G(null, null, i3, j3, j4, c2216qS, z2);
        return c2175pl;
    }

    public final int A03() {
        return this.A06.A00;
    }

    public final int A04(int i3) {
        return this.A06.A07(i3).A00;
    }

    public final int A05(int i3) {
        return this.A06.A07(i3).A04();
    }

    public final int A06(int i3, int i4) {
        return this.A06.A07(i3).A05(i4);
    }

    public final int A07(long j3) {
        return this.A06.A05(j3, this.A01);
    }

    public final int A08(long j3) {
        return this.A06.A06(j3, this.A01);
    }

    public final long A09() {
        return this.A06.A02;
    }

    public final long A0A() {
        return this.A01;
    }

    public final long A0B() {
        return C5C.A0P(this.A02);
    }

    public final long A0C() {
        return this.A02;
    }

    public final long A0D(int i3) {
        return this.A06.A07(i3).A03;
    }

    public final long A0E(int i3, int i4) {
        C2217qT c2217qTA07 = this.A06.A07(i3);
        if (c2217qTA07.A00 != -1) {
            return c2217qTA07.A06[i4];
        }
        return -9223372036854775807L;
    }

    public final C2175pl A0F(Object obj, Object obj2, int i3, long j3, long j4) {
        return A0G(obj, obj2, i3, j3, j4, C2216qS.A08, false);
    }

    public final C2175pl A0G(Object obj, Object obj2, int i3, long j3, long j4, C2216qS c2216qS, boolean z2) {
        this.A03 = obj;
        this.A04 = obj2;
        this.A00 = i3;
        this.A01 = j3;
        this.A02 = j4;
        this.A06 = c2216qS;
        this.A05 = z2;
        return this;
    }

    public final boolean A0H(int i3) {
        return !this.A06.A07(i3).A07();
    }

    @MetaExoPlayerCustomization("Can be removed once MediaPeriodQueue is updated.")
    public final boolean A0I(int i3, int i4) {
        C2217qT c2217qT = this.A06.A05[i3];
        return (c2217qT.A00 == -1 || c2217qT.A05[i4] == 0) ? false : true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !getClass().equals(obj.getClass())) {
            return false;
        }
        C2175pl c2175pl = (C2175pl) obj;
        if (C5C.A1E(this.A03, c2175pl.A03) && C5C.A1E(this.A04, c2175pl.A04) && this.A00 == c2175pl.A00 && this.A01 == c2175pl.A01 && this.A02 == c2175pl.A02 && this.A05 == c2175pl.A05 && C5C.A1E(this.A06, c2175pl.A06)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = ((7 * 31) + (this.A03 == null ? 0 : this.A03.hashCode())) * 31;
        if (this.A04 != null) {
            Object obj = this.A04;
            String[] strArr = A07;
            if (strArr[3].charAt(31) != strArr[0].charAt(31)) {
                throw new RuntimeException();
            }
            A07[6] = "a7xjZFv85Fgc1YV";
            iHashCode = obj.hashCode();
        }
        return ((((((((((iHashCode2 + iHashCode) * 31) + this.A00) * 31) + ((int) (this.A01 ^ (this.A01 >>> 32)))) * 31) + ((int) (this.A02 ^ (this.A02 >>> 32)))) * 31) + (this.A05 ? 1 : 0)) * 31) + this.A06.hashCode();
    }
}
