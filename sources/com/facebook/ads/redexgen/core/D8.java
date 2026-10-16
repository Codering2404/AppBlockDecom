package com.facebook.ads.redexgen.core;

import android.os.Handler;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class D8 {
    public final int A00;
    public final C2056no A01;
    public final long A02;
    public final CopyOnWriteArrayList<D7> A03;

    public D8() {
        this(new CopyOnWriteArrayList(), 0, null, 0L);
    }

    public D8(CopyOnWriteArrayList<D7> copyOnWriteArrayList, int i3, C2056no c2056no, long j3) {
        this.A03 = copyOnWriteArrayList;
        this.A00 = i3;
        this.A01 = c2056no;
        this.A02 = j3;
    }

    private long A00(long j3) {
        long jA0P = C5C.A0P(j3);
        if (jA0P == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long mediaTimeMs = this.A02;
        return mediaTimeMs + jA0P;
    }

    @MetaExoPlayerCustomization(type = {"MERGED"}, value = "https://github.com/androidx/media/pull/1768")
    private final void A01(final Cq cq, final C0641Cs c0641Cs, final int i3) {
        for (D7 d7 : this.A03) {
            final D9 d9 = d7.A01;
            C5C.A1B(d7.A00, new Runnable() { // from class: com.facebook.ads.redexgen.X.D4
                @Override // java.lang.Runnable
                public final void run() {
                }
            });
        }
    }

    public final D8 A02(int i3, C2056no c2056no, long j3) {
        return new D8(this.A03, i3, c2056no, j3);
    }

    public final void A03(int i3, C2208qI c2208qI, int i4, Object obj, long j3) {
        A0C(new C0641Cs(1, i3, c2208qI, i4, obj, A00(j3), -9223372036854775807L));
    }

    public final void A04(Handler handler, D9 d9) {
        AbstractC04323y.A01(handler);
        AbstractC04323y.A01(d9);
        this.A03.add(new D7(handler, d9));
    }

    public final void A05(Cq cq, int i3, int i4, C2208qI c2208qI, int i5, Object obj, long j3, long j4) {
        A09(cq, new C0641Cs(i3, i4, c2208qI, i5, obj, A00(j3), A00(j4)));
    }

    @MetaExoPlayerCustomization(type = {"MERGED"}, value = "https://github.com/androidx/media/pull/1768")
    public final void A06(Cq cq, int i3, int i4, C2208qI c2208qI, int i5, Object obj, long j3, long j4, int i6) {
        A01(cq, new C0641Cs(i3, i4, c2208qI, i5, obj, A00(j3), A00(j4)), i6);
    }

    public final void A07(Cq cq, int i3, int i4, C2208qI c2208qI, int i5, Object obj, long j3, long j4, IOException iOException, boolean z2) {
        A0A(cq, new C0641Cs(i3, i4, c2208qI, i5, obj, A00(j3), A00(j4)), iOException, z2);
    }

    public final void A08(@MetaExoPlayerCustomization Cq cq, @MetaExoPlayerCustomization int i3, int i4, C2208qI c2208qI, int i5, Object obj, long j3, long j4, Object obj2, Object obj3) {
        A0B(cq, new C0641Cs(i3, i4, c2208qI, i5, obj, A00(j3), A00(j4)), obj2, obj3);
    }

    public final void A09(final Cq cq, final C0641Cs c0641Cs) {
        for (D7 d7 : this.A03) {
            final D9 listener = d7.A01;
            C5C.A1B(d7.A00, new Runnable() { // from class: com.facebook.ads.redexgen.X.D5
                @Override // java.lang.Runnable
                public final void run() {
                    this.A02.A0E(listener, cq, c0641Cs);
                }
            });
        }
    }

    public final void A0A(final Cq cq, final C0641Cs c0641Cs, final IOException iOException, final boolean z2) {
        for (D7 d7 : this.A03) {
            final D9 d9 = d7.A01;
            C5C.A1B(d7.A00, new Runnable() { // from class: com.facebook.ads.redexgen.X.D0
                @Override // java.lang.Runnable
                public final void run() {
                    this.A02.A0F(d9, cq, c0641Cs, iOException, z2);
                }
            });
        }
    }

    public final void A0B(@MetaExoPlayerCustomization final Cq cq, @MetaExoPlayerCustomization final C0641Cs c0641Cs, final Object obj, final Object obj2) {
        for (D7 d7 : this.A03) {
            final D9 d9 = d7.A01;
            C5C.A1B(d7.A00, new Runnable() { // from class: com.facebook.ads.redexgen.X.D1
                @Override // java.lang.Runnable
                public final void run() {
                    this.A02.A0G(d9, cq, c0641Cs, obj, obj2);
                }
            });
        }
    }

    public final void A0C(final C0641Cs c0641Cs) {
        for (D7 d7 : this.A03) {
            final D9 listener = d7.A01;
            C5C.A1B(d7.A00, new Runnable() { // from class: com.facebook.ads.redexgen.X.D2
                @Override // java.lang.Runnable
                public final void run() {
                    this.A01.A0H(listener, c0641Cs);
                }
            });
        }
    }

    public final void A0D(D9 d9) {
        for (D7 listenerAndHandler : this.A03) {
            if (listenerAndHandler.A01 == d9) {
                this.A03.remove(listenerAndHandler);
            }
        }
    }

    public final /* synthetic */ void A0E(D9 d9, Cq cq, C0641Cs c0641Cs) {
        d9.AEb(this.A00, this.A01, cq, c0641Cs);
    }

    public final /* synthetic */ void A0F(D9 d9, Cq cq, C0641Cs c0641Cs, IOException iOException, boolean z2) {
        d9.AEg(this.A00, this.A01, cq, c0641Cs, iOException, z2);
    }

    public final /* synthetic */ void A0G(D9 d9, Cq cq, C0641Cs c0641Cs, Object obj, Object obj2) {
        d9.AEd(this.A00, this.A01, cq, c0641Cs, obj, obj2);
    }

    public final /* synthetic */ void A0H(D9 d9, C0641Cs c0641Cs) {
        d9.ADk(this.A00, this.A01, c0641Cs);
    }
}
