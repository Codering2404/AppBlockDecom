package com.facebook.ads.redexgen.core;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8Q, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C8Q {
    public static final AudioAttributes A00 = new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(0).build();

    public static int A00(int i3, int i4) {
        for (int i5 = 8; i5 > 0; i5--) {
            AudioFormat.Builder sampleRate = new AudioFormat.Builder().setEncoding(i3).setSampleRate(i4);
            int channelCount = C5C.A01(i5);
            AudioFormat audioFormat = sampleRate.setChannelMask(channelCount).build();
            if (AudioTrack.isDirectPlaybackSupported(audioFormat, A00)) {
                return i5;
            }
        }
        return 0;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2K != com.google.common.collect.ImmutableList$Builder<java.lang.Integer> */
    /* JADX WARN: Multi-variable type inference failed */
    public static int[] A01() {
        C2K c2kA01 = BP.A01();
        C4C it = C8R.A06.keySet().iterator();
        while (it.hasNext()) {
            int encoding = ((Integer) it.next()).intValue();
            if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(encoding).setSampleRate(48000).build(), A00)) {
                c2kA01.A04(Integer.valueOf(encoding));
            }
        }
        c2kA01.A04(2);
        return AbstractC0592As.A0B(c2kA01.A05());
    }
}
