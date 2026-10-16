package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.CD, reason: from Kotlin metadata */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH\u0016J(\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u0015"}, d2 = {"Lcom/facebook/video/heroplayer/exocustom/NoOpMediaCodecPoolTracker;", "Lcom/facebook/video/heroplayer/exocustom/MediaCodecPoolTracker;", "<init>", "()V", "reportCodecCreated", "", "creatingEvent", "Lcom/facebook/video/heroplayer/exocustom/MediaCodecPoolTracker$CreatingEvent;", "codecInstanceId", "", "reportCodecReleasing", "source", "Lcom/facebook/video/heroplayer/exocustom/MediaCodecPoolTracker$Source;", "reportCodecReleased", "reportCodecAcquiredFromPool", "isVideo", "", "codecName", "", "reportCodecReturnedToPool", "Companion", "fbandroid.java.com.facebook.video.heroplayer.exocustom.exocustom"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NoOpMediaCodecPoolTracker extends MediaCodecPoolTracker {
    public static byte[] A00;
    public static final C1812jc A01;
    public static final NoOpMediaCodecPoolTracker A02;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 17);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{36, 40, 35, 34, 36, 9, 38, 42, 34, 9, Ascii.CAN, Ascii.SI, Ascii.VT, Ascii.RS, 3, 4, Ascii.CR, 47, Ascii.FS, Ascii.SI, 4, Ascii.RS, 84, 72, 82, 85, 68, 66};
    }

    static {
        A01();
        A01 = new C1812jc(null);
        A02 = new NoOpMediaCodecPoolTracker();
    }

    @Override // com.facebook.ads.redexgen.core.MediaCodecPoolTracker
    public final void A06(C1799jJ c1799jJ, int i3) {
        C2222qY.A09(c1799jJ, A00(9, 13, 123));
    }

    @Override // com.facebook.ads.redexgen.core.MediaCodecPoolTracker
    public final void A07(EnumC1801jL enumC1801jL, int i3) {
        C2222qY.A09(enumC1801jL, A00(22, 6, 54));
    }

    @Override // com.facebook.ads.redexgen.core.MediaCodecPoolTracker
    public final void A08(EnumC1801jL enumC1801jL, int i3) {
        C2222qY.A09(enumC1801jL, A00(22, 6, 54));
    }

    @Override // com.facebook.ads.redexgen.core.MediaCodecPoolTracker
    public final void A09(EnumC1801jL enumC1801jL, int i3) {
        C2222qY.A09(enumC1801jL, A00(22, 6, 54));
    }

    @Override // com.facebook.ads.redexgen.core.MediaCodecPoolTracker
    public final void A0A(boolean z2, String str, EnumC1801jL enumC1801jL, int i3) {
        C2222qY.A09(str, A00(0, 9, 86));
        C2222qY.A09(enumC1801jL, A00(22, 6, 54));
    }
}
