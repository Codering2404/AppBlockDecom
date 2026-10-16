package com.facebook.ads.redexgen.core;

import android.net.Uri;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Hd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public interface InterfaceC0755Hd {
    void A6e(C2208qI c2208qI);

    int AIp(InterfaceC03882c interfaceC03882c, int i3, boolean z2) throws IOException;

    int AIq(InterfaceC03882c interfaceC03882c, int i3, boolean z2, int i4) throws IOException;

    void AIr(C04554v c04554v, int i3);

    void AIs(C04554v c04554v, int i3, int i4);

    void AIu(long j3, int i3, int i4, int i5, C0753Hb c0753Hb);

    @MetaExoPlayerCustomization("New Meta API")
    void AKf(Uri uri);
}
