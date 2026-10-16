package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.SystemClock;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class GP {
    public final Handler A00;
    public final GQ A01;

    public GP(Handler handler, GQ gq) {
        this.A00 = gq != null ? (Handler) AbstractC04323y.A01(handler) : null;
        this.A01 = gq;
    }

    public final void A00(final int i3, final long j3) {
        if (this.A00 != null) {
            this.A00.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.GL
                @Override // java.lang.Runnable
                public final void run() {
                    this.A02.A02(i3, j3);
                }
            });
        }
    }

    public final void A01(final int i3, final long j3) {
        if (this.A00 != null) {
            this.A00.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.GC
                @Override // java.lang.Runnable
                public final void run() {
                    this.A02.A03(i3, j3);
                }
            });
        }
    }

    public final /* synthetic */ void A02(int i3, long j3) {
        ((GQ) C5C.A0f(this.A01)).ADU(i3, j3);
    }

    public final /* synthetic */ void A03(int i3, long j3) {
        ((GQ) C5C.A0f(this.A01)).ADl(i3, j3);
    }

    @MetaExoPlayerCustomization("New event handler")
    public final void A04(int i3, C2208qI c2208qI) {
        if (this.A01 != null) {
            this.A00.post(new GO(this, i3, c2208qI));
        }
    }

    public final void A05(final C2208qI c2208qI, final C6L c6l) {
        if (this.A00 != null) {
            this.A00.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.GI
                @Override // java.lang.Runnable
                public final void run() {
                    this.A02.A06(c2208qI, c6l);
                }
            });
        }
    }

    public final /* synthetic */ void A06(C2208qI c2208qI, C6L c6l) {
        ((GQ) C5C.A0f(this.A01)).AGU(c2208qI);
        ((GQ) C5C.A0f(this.A01)).AGV(c2208qI, c6l);
    }

    public final void A07(final C2161pW c2161pW) {
        if (this.A00 != null) {
            this.A00.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.GK
                @Override // java.lang.Runnable
                public final void run() {
                    this.A01.A08(c2161pW);
                }
            });
        }
    }

    public final /* synthetic */ void A08(C2161pW c2161pW) {
        ((GQ) C5C.A0f(this.A01)).AGb(c2161pW);
    }

    public final void A09(final C6I c6i) {
        c6i.A02();
        if (this.A00 != null) {
            this.A00.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.GM
                @Override // java.lang.Runnable
                public final void run() {
                    this.A01.A0B(c6i);
                }
            });
        }
    }

    public final void A0A(final C6I c6i) {
        if (this.A00 != null) {
            this.A00.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.GG
                @Override // java.lang.Runnable
                public final void run() {
                    this.A01.A0C(c6i);
                }
            });
        }
    }

    public final /* synthetic */ void A0B(C6I c6i) {
        c6i.A02();
        ((GQ) C5C.A0f(this.A01)).AGO(c6i);
    }

    public final /* synthetic */ void A0C(C6I c6i) {
        ((GQ) C5C.A0f(this.A01)).AGP(c6i);
    }

    public final void A0D(final Object obj) {
        if (this.A00 != null) {
            final long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.A00.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.GH
                @Override // java.lang.Runnable
                public final void run() {
                    this.A01.A0E(obj, jElapsedRealtime);
                }
            });
        }
    }

    public final /* synthetic */ void A0E(Object obj, long j3) {
        ((GQ) C5C.A0f(this.A01)).AFf(obj, j3);
    }

    @MetaExoPlayerCustomization("New event handler")
    public final void A0F(final String str) {
        if (this.A00 != null) {
            this.A00.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.GJ
                @Override // java.lang.Runnable
                public final void run() {
                }
            });
        }
    }

    public final void A0G(final String str, final long j3, final long j4) {
        if (this.A00 != null) {
            this.A00.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.GF
                @Override // java.lang.Runnable
                public final void run() {
                    this.A02.A0H(str, j3, j4);
                }
            });
        }
    }

    public final /* synthetic */ void A0H(String str, long j3, long j4) {
        ((GQ) C5C.A0f(this.A01)).AGN(str, j3, j4);
    }
}
