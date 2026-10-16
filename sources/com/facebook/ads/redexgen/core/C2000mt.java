package com.facebook.ads.redexgen.core;

import android.net.Uri;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.mt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2000mt implements InterfaceC0755Hd {
    public final byte[] A00 = new byte[4096];

    @Override // com.facebook.ads.redexgen.core.InterfaceC0755Hd
    public final /* synthetic */ int AIp(InterfaceC03882c interfaceC03882c, int i3, boolean z2) {
        return AbstractC0752Ha.A00(this, interfaceC03882c, i3, z2);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0755Hd
    public final /* synthetic */ void AIr(C04554v c04554v, int i3) {
        AbstractC0752Ha.A01(this, c04554v, i3);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0755Hd
    public final void A6e(C2208qI c2208qI) {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0755Hd
    public final int AIq(InterfaceC03882c interfaceC03882c, int i3, boolean z2, int i4) throws IOException {
        int bytesSkipped = interfaceC03882c.read(this.A00, 0, Math.min(this.A00.length, i3));
        if (bytesSkipped == -1) {
            if (z2) {
                return -1;
            }
            throw new EOFException();
        }
        return bytesSkipped;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0755Hd
    public final void AIs(C04554v c04554v, int i3, int i4) {
        c04554v.A0g(i3);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0755Hd
    public final void AIu(long j3, int i3, int i4, int i5, C0753Hb c0753Hb) {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0755Hd
    @MetaExoPlayerCustomization("New API added for Meta")
    public final void AKf(Uri uri) {
    }
}
