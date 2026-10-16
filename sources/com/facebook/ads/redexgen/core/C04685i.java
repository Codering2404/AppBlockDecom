package com.facebook.ads.redexgen.core;

import android.net.Uri;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5i, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C04685i {
    public static byte[] A0B;

    @MetaExoPlayerCustomization
    public static final C04685i A0C;
    public final int A00;
    public final int A01;

    @Deprecated
    public final long A02;
    public final long A03;
    public final long A04;
    public final long A05;
    public final Uri A06;

    @MetaExoPlayerCustomization("Using fbDataSpecExtension instead of Object")
    public final ML A07;
    public final String A08;
    public final Map<String, String> A09;
    public final byte[] A0A;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 21 out of bounds for length 21
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    @MetaExoPlayerCustomization("Replacement of customData Object with fbDataSpecExtension")
    public C04685i(Uri uri, long j3, int i3, byte[] bArr, Map<String, String> map, long j4, long j5, String str, int i4, ML ml) {
        boolean z2 = true;
        AbstractC04323y.A07(j3 + j4 >= 0);
        AbstractC04323y.A07(j4 >= 0);
        if (j5 <= 0 && j5 != -1) {
            z2 = false;
        }
        AbstractC04323y.A07(z2);
        this.A06 = uri;
        this.A05 = j3;
        this.A01 = i3;
        this.A0A = (bArr == null || bArr.length == 0) ? null : bArr;
        this.A09 = Collections.unmodifiableMap(new HashMap(map));
        this.A04 = j4;
        this.A02 = j3 + j4;
        this.A03 = j5;
        this.A08 = str;
        this.A00 = i4;
        this.A07 = ml;
    }

    public static String A02(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0B, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 42);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A0B = new byte[]{-123, -84, -96, -112, -83, -64, -83, -97, -68, -79, -81, -89, -52, -54, -39, -116, -119, -123, -120, -52, -53, -49, -48, -88, -88, -80, -80, -88, 111, -90, -71, -80, 111, -91, -94, -75, -94, -76, -80, -74, -77, -92, -90, -61, -61, -61, 122, -78, -83, -81, -79, -82, -69, -69, -73, 122, -81, -69, -71};
    }

    static {
        A03();
        AnonymousClass35.A03(A02(24, 19, 23));
        A0C = new C04685i(Uri.parse(A02(43, 16, 34)));
    }

    public C04685i(Uri uri) {
        this(uri, 0, -1);
    }

    @MetaExoPlayerCustomization
    @Deprecated
    public C04685i(Uri uri, int i3, int i4) {
        this(uri, 0L, 1, null, Collections.emptyMap(), 0L, -1L, null, i3, new ML(A02(0, 0, 9), -1L, false, -1, -1, -1, -1, false, false, i4, -1L, new MK(), false, -1, -1, -1L, -1L, -1, null, -1, null, null, MJ.A02, -1, false, null, A02(0, 0, 9), A02(0, 0, 9), null, -1L, -1L));
    }

    @MetaExoPlayerCustomization("creation and passage of FbDataSpecExtension")
    @Deprecated
    public C04685i(Uri uri, long j3, long j4, String str) {
        this(uri, 0L, 1, null, Collections.emptyMap(), j3, j4, str, 0, new ML());
    }

    private final String A00() {
        return A01(this.A01);
    }

    public static String A01(int i3) {
        switch (i3) {
            case 1:
                return A02(12, 3, 91);
            case 2:
                return A02(19, 4, 82);
            case 3:
                return A02(15, 4, 26);
            default:
                throw new IllegalStateException();
        }
    }

    public final C04655f A04() {
        return new C04655f(this);
    }

    @MetaExoPlayerCustomization("Replacement of customData Object with fbDataSpecExtension + new copy creation")
    public final C04685i A05(long j3, long j4) {
        if (j3 == 0 && this.A03 == j4) {
            return this;
        }
        return new C04685i(this.A06, this.A05, this.A01, this.A0A, this.A09, this.A04 + j3, j4, this.A08, this.A00, new ML(this.A07));
    }

    public final boolean A06(int i3) {
        return (this.A00 & i3) == i3;
    }

    @MetaExoPlayerCustomization("Stringification of fbDataSpecExtension (last two items)")
    public final String toString() {
        StringBuilder sbAppend = new StringBuilder().append(A02(3, 9, 34)).append(A00()).append(A02(0, 1, 59)).append(this.A06);
        String strA02 = A02(1, 2, 86);
        return sbAppend.append(strA02).append(this.A04).append(strA02).append(this.A03).append(strA02).append(this.A08).append(strA02).append(this.A00).append(strA02).append(this.A07).append(strA02).append(this.A07.A0P).append(A02(23, 1, 33)).toString();
    }
}
