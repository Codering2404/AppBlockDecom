package com.facebook.ads.redexgen.core;

import com.facebook.ads.androidx.media3.common.Timeline;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7Z, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C7Z {
    public static final C2056no A0E = new C2056no(new Object());
    public final int A00;
    public final long A01;
    public final long A02;
    public final Timeline A03;
    public final C2056no A04;
    public final C2056no A05;
    public final C2038nW A06;
    public final C0698Ex A07;

    @MetaExoPlayerCustomization(type = {"NEW_CLASS_ARG"}, value = "Start Stall Logging")
    public final EnumC1774ir A08;

    @MetaExoPlayerCustomization(type = {"NEW_CLASS_ARG"}, value = "Determine if stall is from Audio for logging")
    public final boolean A09;
    public final boolean A0A;
    public volatile long A0B;
    public volatile long A0C;
    public volatile long A0D;

    public C7Z(Timeline timeline, long j3, C2038nW c2038nW, C0698Ex c0698Ex) {
        this(timeline, A0E, j3, -9223372036854775807L, 1, false, c2038nW, c0698Ex, A0E, j3, j3, j3, EnumC1774ir.A09, false);
    }

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "Customized to call base constructor")
    public C7Z(Timeline timeline, C2056no c2056no, long j3, long j4, int i3, boolean z2, C2038nW c2038nW, C0698Ex c0698Ex, C2056no c2056no2, long j5, long j6, long j7) {
        this(timeline, c2056no, j3, j4, i3, z2, c2038nW, c0698Ex, c2056no2, j5, j6, j7, EnumC1774ir.A09, false);
    }

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "Customized to add new parameters")
    public C7Z(@MetaExoPlayerCustomization(type = {"NEW_METHOD_ARGS"}) Timeline timeline, @MetaExoPlayerCustomization(type = {"NEW_METHOD_ARGS"}) C2056no c2056no, long j3, long j4, int i3, boolean z2, C2038nW c2038nW, C0698Ex c0698Ex, C2056no c2056no2, long j5, long j6, long j7, EnumC1774ir enumC1774ir, boolean z3) {
        this.A03 = timeline;
        this.A05 = c2056no;
        this.A02 = j3;
        this.A01 = j4;
        this.A0C = j3;
        this.A00 = i3;
        this.A0A = z2;
        this.A06 = c2038nW;
        this.A07 = c0698Ex;
        this.A04 = c2056no2;
        this.A0B = j5;
        this.A0D = j6;
        this.A0C = j7;
        this.A08 = enumC1774ir;
        this.A09 = z3;
    }

    public static void A00(C7Z c7z, C7Z c7z2) {
        c7z2.A0C = c7z.A0C;
        c7z2.A0B = c7z.A0B;
        c7z2.A0D = c7z.A0D;
    }

    public final C7Z A01(int i3) {
        C7Z c7z = new C7Z(this.A03, this.A05, this.A02, this.A01, i3, this.A0A, this.A06, this.A07, this.A04, this.A0B, this.A0D, this.A0C, this.A08, this.A09);
        A00(this, c7z);
        return c7z;
    }

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "Stall Reason Logging in Hero")
    public final C7Z A02(int i3, EnumC1774ir enumC1774ir, boolean z2) {
        C7Z c7z = new C7Z(this.A03, this.A05, this.A02, this.A01, i3, this.A0A, this.A06, this.A07, this.A04, this.A0B, this.A0D, this.A0C, enumC1774ir, z2);
        A00(this, c7z);
        return c7z;
    }

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "To track Audio Stalls for Logging")
    public final C7Z A03(int i3, boolean z2) {
        C7Z c7z = new C7Z(this.A03, this.A05, this.A02, this.A01, i3, this.A0A, this.A06, this.A07, this.A04, this.A0B, this.A0D, this.A0C, this.A08, z2);
        A00(this, c7z);
        return c7z;
    }

    public final C7Z A04(Timeline timeline) {
        C7Z c7z = new C7Z(timeline, this.A05, this.A02, this.A01, this.A00, this.A0A, this.A06, this.A07, this.A04, this.A0B, this.A0D, this.A0C, this.A08, this.A09);
        A00(this, c7z);
        return c7z;
    }

    public final C7Z A05(C2056no c2056no) {
        return new C7Z(this.A03, this.A05, this.A02, this.A01, this.A00, this.A0A, this.A06, this.A07, c2056no, this.A0B, this.A0D, this.A0C, this.A08, this.A09);
    }

    public final C7Z A06(C2056no c2056no, long j3, long j4, long j5) {
        long j6 = j4;
        Timeline timeline = this.A03;
        if (!c2056no.A00()) {
            j6 = -9223372036854775807L;
        }
        return new C7Z(timeline, c2056no, j3, j6, this.A00, this.A0A, this.A06, this.A07, this.A04, this.A0B, j5, j3);
    }

    public final C7Z A07(C2038nW c2038nW, C0698Ex c0698Ex) {
        C7Z c7z = new C7Z(this.A03, this.A05, this.A02, this.A01, this.A00, this.A0A, c2038nW, c0698Ex, this.A04, this.A0B, this.A0D, this.A0C, this.A08, this.A09);
        A00(this, c7z);
        return c7z;
    }

    public final C7Z A08(boolean z2) {
        C7Z c7z = new C7Z(this.A03, this.A05, this.A02, this.A01, this.A00, z2, this.A06, this.A07, this.A04, this.A0B, this.A0D, this.A0C, this.A08, this.A09);
        A00(this, c7z);
        return c7z;
    }
}
