package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.Spatializer;
import android.media.Spatializer$OnSpatializerStateChangedListener;
import android.os.Handler;
import android.os.Looper;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ef, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0680Ef {
    public static byte[] A04;
    public static String[] A05 = {"XChyMIA3IiBLGVc4JUcuiIFhw0olIHd5", "L1RbhyPLCDSvJWoCYJVALOKwr45Jj", "4i4NfCjlBic1LnGuByjRmO6XDD8s", "fp6arCeubKdlGGxkl3wydgWAbBMIIbeF", "pgUH6rfDE1GExBA3fVJRXk8gj61UjiI1", "O5JAn4ITNRkPEp9cAHFgOejRoj0rukGX", "JccK1QqImqh6kMtQx4F4QpK5m5M4", "faWXzGQd6eAsmBqhrITpsBscnTY0oqi8"};
    public Spatializer$OnSpatializerStateChangedListener A00;
    public Handler A01;
    public final Spatializer A02;
    public final boolean A03;

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 37);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A04 = new byte[]{101, 113, 96, 109, 107, 88, 76, 93, 80, 86, Ascii.SYN, 92, 88, 90, 10, Ascii.DC4, 83, 86, 90};
    }

    static {
        A02();
    }

    public C0680Ef(Spatializer spatializer) {
        this.A02 = spatializer;
        this.A03 = spatializer.getImmersiveAudioLevel() != 0;
    }

    public static C0680Ef A00(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(A01(0, 5, 33));
        if (audioManager == null) {
            return null;
        }
        return new C0680Ef(audioManager.getSpatializer());
    }

    public final void A03(C05659h c05659h, Looper looper) {
        if (this.A00 != null || this.A01 != null) {
            return;
        }
        this.A00 = new C0679Ee(this, c05659h);
        this.A01 = new Handler(looper);
        Spatializer spatializer = this.A02;
        Handler handler = this.A01;
        Objects.requireNonNull(handler);
        spatializer.addOnSpatializerStateChangedListener(new C9N(handler), this.A00);
    }

    public final boolean A04() {
        return this.A02.isAvailable();
    }

    public final boolean A05() {
        return this.A02.isEnabled();
    }

    public final boolean A06() {
        return this.A03;
    }

    public final boolean A07(C2214qQ c2214qQ, C2208qI c2208qI) {
        int i3;
        if (A01(5, 14, 28).equals(c2208qI.A0W) && c2208qI.A06 == 16) {
            i3 = 12;
        } else {
            i3 = c2208qI.A06;
        }
        AudioFormat.Builder encoding = new AudioFormat.Builder().setEncoding(2);
        int linearChannelCount = C5C.A01(i3);
        AudioFormat.Builder channelMask = encoding.setChannelMask(linearChannelCount);
        if (c2208qI.A0G != -1) {
            int linearChannelCount2 = c2208qI.A0G;
            channelMask.setSampleRate(linearChannelCount2);
        }
        Spatializer spatializer = this.A02;
        AudioAttributes audioAttributes = c2214qQ.A01().A00;
        AudioFormat audioFormatBuild = channelMask.build();
        if (A05[1].length() != 29) {
            throw new RuntimeException();
        }
        A05[5] = "fxex8oBXLxgy8X4V5eG1x3lhnMHn34Gl";
        return spatializer.canBeSpatialized(audioAttributes, audioFormatBuild);
    }
}
