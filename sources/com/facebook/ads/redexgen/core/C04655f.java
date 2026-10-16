package com.facebook.ads.redexgen.core;

import android.net.Uri;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5f, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@MetaExoPlayerCustomization("Using fbDataSpecExtension instead of Object")
public final class C04655f {
    public static byte[] A0A;
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public long A04;
    public Uri A05;
    public ML A06;
    public String A07;
    public Map<String, String> A08;
    public byte[] A09;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0A, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 15);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A0A = new byte[]{-35, -15, -18, -87, -2, -5, -14, -87, -10, -2, -4, -3, -87, -21, -18, -87, -4, -18, -3, -73};
    }

    public C04655f() {
        this.A01 = 1;
        this.A08 = Collections.emptyMap();
        this.A02 = -1L;
    }

    @MetaExoPlayerCustomization("Using fbDataSpecExtension instead of Object")
    public C04655f(C04685i c04685i) {
        this.A05 = c04685i.A06;
        this.A04 = c04685i.A05;
        this.A01 = c04685i.A01;
        this.A09 = c04685i.A0A;
        this.A08 = c04685i.A09;
        this.A03 = c04685i.A04;
        this.A02 = c04685i.A03;
        this.A07 = c04685i.A08;
        this.A00 = c04685i.A00;
        this.A06 = c04685i.A07;
    }

    public final C04655f A02(int i3) {
        this.A00 = i3;
        return this;
    }

    public final C04655f A03(long j3) {
        this.A02 = j3;
        return this;
    }

    public final C04655f A04(long j3) {
        this.A03 = j3;
        return this;
    }

    public final C04655f A05(long j3) {
        this.A04 = j3;
        return this;
    }

    public final C04655f A06(Uri uri) {
        this.A05 = uri;
        return this;
    }

    @MetaExoPlayerCustomization("Using fbDataSpecExtension instead of Object")
    public final C04655f A07(ML ml) {
        this.A06 = ml;
        return this;
    }

    public final C04655f A08(String str) {
        this.A07 = str;
        return this;
    }

    @MetaExoPlayerCustomization("D50990955; Ensure that fbDataSpecExtension is not null")
    public final C04685i A09() {
        ML ml;
        AbstractC04323y.A03(this.A05, A00(0, 20, 122));
        Uri uri = this.A05;
        long j3 = this.A04;
        int i3 = this.A01;
        byte[] bArr = this.A09;
        Map<String, String> map = this.A08;
        long j4 = this.A03;
        long j5 = this.A02;
        String str = this.A07;
        int i4 = this.A00;
        if (this.A06 != null) {
            ml = this.A06;
        } else {
            ml = new ML();
        }
        return new C04685i(uri, j3, i3, bArr, map, j4, j5, str, i4, ml);
    }
}
