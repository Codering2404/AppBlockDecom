package com.facebook.ads.redexgen.core;

import android.os.Looper;
import android.os.SystemClock;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.n7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2013n7 {
    public static byte[] A03;
    public static String[] A04 = {"unLJAGqnT9K2C6pR52hzklfZHwTRg6Yr", "LeSEUls9Myr0akOYyr4ALINYOEymKOkL", "W8GYPv6JCblyMHrg4mb8qhrlE9HlP5p8", "LeDDfwbzgRXTDhaT1cwFWvWAB6ITTWPz", "taf7WKL89SeyG6P6BerDozU5lBYArJ2v", "", "BSTJObkWS6NqTAYjIRk7bCGrxc9Lgut2", "ohz3nwuOVveogY5495fLWWA936p3Bkwf"};
    public static final FJ A05;
    public static final FJ A06;
    public static final FJ A07;
    public static final FJ A08;
    public FK<? extends FL> A00;
    public IOException A01;
    public final InterfaceExecutorC0702Fb A02;

    public static String A06(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 59);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A03 = new byte[]{62, 3, Ascii.DC4, 43, Ascii.ETB, Ascii.SUB, 2, Ascii.RS, 9, 65, 55, Ascii.DC4, Ascii.SUB, Ascii.US, Ascii.RS, 9, 65};
    }

    static {
        A07();
        A07 = A01(false, -9223372036854775807L);
        A08 = A01(true, -9223372036854775807L);
        A05 = new FJ(2, -9223372036854775807L);
        A06 = new FJ(3, -9223372036854775807L);
    }

    @MetaExoPlayerCustomization(type = {"MERGED"})
    public C2013n7(InterfaceExecutorC0702Fb interfaceExecutorC0702Fb) {
        this.A02 = interfaceExecutorC0702Fb;
    }

    @MetaExoPlayerCustomization(type = {"MERGED"})
    public C2013n7(String str) {
        this(AbstractC0701Fa.A00(C5C.A0u(A06(0, 17, 64) + str), new AnonymousClass49() { // from class: com.facebook.ads.redexgen.X.n8
            @Override // com.facebook.ads.redexgen.core.AnonymousClass49
            public final void A39(Object obj) {
                ((ExecutorService) obj).shutdown();
            }
        }));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.FI != com.facebook.ads.androidx.media3.exoplayer.upstream.Loader$Callback<T extends com.facebook.ads.redexgen.X.FL> */
    @MetaExoPlayerCustomization("D14742363 Needed to accept supplied looper for Exo2DashLiveManifestFetcher manifest loading")
    private final <T extends FL> long A00(Looper looper, T t2, FI<T> fi, int i3) {
        AbstractC04323y.A08(looper != null);
        this.A01 = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        new FK(this, looper, t2, fi, i3, jElapsedRealtime).A06(0L);
        return jElapsedRealtime;
    }

    public static FJ A01(boolean z2, long j3) {
        return new FJ(z2 ? 1 : 0, j3);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.FI != com.facebook.ads.androidx.media3.exoplayer.upstream.Loader$Callback<T extends com.facebook.ads.redexgen.X.FL> */
    public final <T extends FL> long A08(T t2, FI<T> fi, int i3) {
        Looper looper = (Looper) AbstractC04323y.A02(Looper.myLooper());
        return A00(looper, t2, fi, i3);
    }

    public final void A09() {
        ((FK) AbstractC04323y.A02(this.A00)).A07(false);
    }

    public final void A0A() {
        this.A01 = null;
    }

    public final void A0B(int i3) throws IOException {
        if (this.A01 == null) {
            if (this.A00 != null) {
                FK<? extends FL> fk = this.A00;
                if (i3 == Integer.MIN_VALUE) {
                    FK<? extends FL> fk2 = this.A00;
                    String[] strArr = A04;
                    if (strArr[6].charAt(7) == strArr[1].charAt(7)) {
                        throw new RuntimeException();
                    }
                    A04[2] = "wo2YdO45DQEJfRTdGKzxAcazBLTDj4mX";
                    i3 = fk2.A06;
                }
                fk.A05(i3);
                return;
            }
            return;
        }
        throw this.A01;
    }

    public final void A0C(FM fm) {
        if (this.A00 != null) {
            FK<? extends FL> fk = this.A00;
            String[] strArr = A04;
            if (strArr[5].length() == strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[4] = "XVuhTdSnDMDRP6HltjyP328n9S8al0u6";
            strArr2[0] = "1piWh3nqPhJ4K6qVEs9qRP5dHkNT6n7u";
            fk.A07(true);
        }
        if (fm != null) {
            this.A02.execute(new FN(fm));
        }
        this.A02.AHb();
    }

    public final boolean A0D() {
        return this.A01 != null;
    }

    public final boolean A0E() {
        return this.A00 != null;
    }
}
