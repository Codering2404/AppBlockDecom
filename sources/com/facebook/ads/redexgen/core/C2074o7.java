package com.facebook.ads.redexgen.core;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.o7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2074o7 implements BY {
    public MediaCodecInfo[] A00;
    public final int A01;

    public C2074o7(boolean z2, boolean z3) {
        int i3;
        if (z2 || z3) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        this.A01 = i3;
    }

    @EnsuresNonNull({"mediaCodecInfos"})
    private void A00() {
        if (this.A00 == null) {
            this.A00 = new MediaCodecList(this.A01).getCodecInfos();
        }
    }

    @Override // com.facebook.ads.redexgen.core.BY
    public final int A7P() {
        A00();
        return this.A00.length;
    }

    @Override // com.facebook.ads.redexgen.core.BY
    public final MediaCodecInfo A7Q(int i3) {
        A00();
        return this.A00[i3];
    }

    @Override // com.facebook.ads.redexgen.core.BY
    public final boolean AAR(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureRequired(str);
    }

    @Override // com.facebook.ads.redexgen.core.BY
    public final boolean AAS(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(str);
    }

    @Override // com.facebook.ads.redexgen.core.BY
    public final boolean AJ4() {
        return true;
    }
}
