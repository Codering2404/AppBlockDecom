package com.facebook.ads.redexgen.core;

import com.facebook.ads.redexgen.core.FL;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public interface FI<T extends FL> {
    void AEc(T t2, long j3, long j4, boolean z2);

    void AEe(T t2, long j3, long j4);

    FJ AEf(T t2, long j3, long j4, IOException iOException, int i3);

    @MetaExoPlayerCustomization(type = {"MERGED"}, value = "For Media3 Migration Backward Compatibility")
    void AEi(T t2, long j3, long j4, int i3);
}
