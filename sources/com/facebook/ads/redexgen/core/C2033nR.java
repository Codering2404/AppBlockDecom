package com.facebook.ads.redexgen.core;

import com.facebook.ads.androidx.media3.common.Timeline;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.nR, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C2033nR implements InterfaceC0687Em {
    public static String[] A0B = {"ziZaTeBfSFNnIBcgtlZExnB4uOVj2q5B", "5IZt5NWgPCitKNTqtiA", "aLHVXVzU6ljMUMq9dZgrDfQ8JzHl8MF", "mvLcqO7QF6VGSUKAdCZC8bhhp8aLucng", "FQUZNhR4lN6thgMMBkcdaTgoY6ZzypcM", "72R8UBsha86AOqtb805OpiOBiH7oe8El", "AjNBccUrYW9zDFgtuo7TyJwkSvkBJU7y", "GkSBWsvGG5dBFRJxqtw9GV4lDtiTWOM"};
    public final float A00;
    public final float A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final long A07;
    public final AnonymousClass45 A08;

    @MetaExoPlayerCustomization("This is no longer set in the constructor")
    public final F6 A09;
    public final int A0A;

    public C2033nR() {
        this(ColorExtractionConstants.MAX_PIXEL_SAMPLES, 25000, 25000, 0.75f);
    }

    public C2033nR(int i3, int i4, int i5, float f3) {
        this(null, -1, i3, i4, i5, 1279, 719, f3, 0.75f, 2000L, AnonymousClass45.A00);
    }

    public C2033nR(F6 f6) {
        this(f6, -1, ColorExtractionConstants.MAX_PIXEL_SAMPLES, 25000, 25000, 1279, 719, 0.75f, 0.75f, 2000L, AnonymousClass45.A00);
    }

    public C2033nR(@MetaExoPlayerCustomization("No longer set through factory") F6 f6, @MetaExoPlayerCustomization("Non standard variable; used in oculus") int i3, @MetaExoPlayerCustomization("Removed from upstream") int i4, int i5, int i6, int i7, int i8, float f3, float f4, long j3, AnonymousClass45 anonymousClass45) {
        this.A09 = f6;
        this.A0A = i3;
        this.A05 = i4;
        this.A02 = i5;
        this.A06 = i6;
        this.A04 = i7;
        this.A03 = i8;
        this.A00 = f3;
        this.A01 = f4;
        this.A07 = j3;
        this.A08 = anonymousClass45;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BP != com.google.common.collect.ImmutableList<com.facebook.ads.androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection$AdaptationCheckpoint> */
    private final C03601a A00(C2171pg c2171pg, int[] iArr, int i3, F6 f6, BP<EU> bp) {
        return new C03601a(c2171pg, iArr, i3, f6, this.A0A, this.A05, this.A02, this.A06, this.A04, this.A03, this.A00, this.A01, this.A07, bp, this.A08);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BP != com.google.common.collect.ImmutableList<com.google.common.collect.ImmutableList<com.facebook.ads.androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection$AdaptationCheckpoint>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.ads.redexgen.core.InterfaceC0687Em
    public final InterfaceC2020nE[] A5b(C0686El[] c0686ElArr, F6 f6, C2056no c2056no, Timeline timeline) {
        InterfaceC2020nE interfaceC2020nEA00;
        BP bpA00 = C03601a.A00(c0686ElArr);
        InterfaceC2020nE[] interfaceC2020nEArr = new InterfaceC2020nE[c0686ElArr.length];
        for (int i3 = 0; i3 < c0686ElArr.length; i3++) {
            C0686El c0686El = c0686ElArr[i3];
            if (c0686El != null && c0686El.A02.length != 0) {
                int length = c0686El.A02.length;
                if (A0B[3].length() != 32) {
                    throw new RuntimeException();
                }
                A0B[1] = "4JDRhnBkti3";
                if (length == 1) {
                    interfaceC2020nEA00 = new C1Z(c0686El.A01, c0686El.A02[0], c0686El.A00);
                } else {
                    interfaceC2020nEA00 = A00(c0686El.A01, c0686El.A02, c0686El.A00, f6, (BP) bpA00.get(i3));
                }
                interfaceC2020nEArr[i3] = interfaceC2020nEA00;
            }
        }
        return interfaceC2020nEArr;
    }
}
