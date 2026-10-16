package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.androidx.media3.common.Timeline;
import com.facebook.stetho.dumpapp.Framer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class AA extends AbstractC2213qP implements InterfaceC2121os {
    public static byte[] A0N;
    public static String[] A0O = {"ryR4HSm2zR8tip5OkgYwdb0JWy9e3v2W", "Fm5MoQAoRuRRmRXPK4I4CJ8bYaju2JW1", "syIAGKVT8Ewa7Rni6nktnCNdH4Ja85Gc", "ScHbfbbxkU", "HZJXjhizoNO31MnMnm7FxQnRU8I8lePN", "YCsl9os6nHqs6yB8LR1hlQvfR5oCt3rk", "Ml6mHBX1GsWDWNWH2EtCrt2HpilhtHKz", "59SI8zfcXXU2xe69nRlPKARsr0343GFe"};
    public float A00;
    public int A01;
    public int A02;
    public Surface A03;
    public SurfaceHolder A04;
    public TextureView A05;
    public C2214qQ A06;
    public C2208qI A07;
    public C2208qI A08;
    public C6I A09;
    public C6I A0A;
    public InterfaceC0646Cx A0B;
    public boolean A0C;
    public final Handler A0D;
    public final AC A0E;
    public final SurfaceHolderCallbackC2115om A0F;
    public final InterfaceC2112oj A0G;
    public final CopyOnWriteArraySet<InterfaceC05528p> A0H;
    public final CopyOnWriteArraySet<C3U> A0I;
    public final CopyOnWriteArraySet<InterfaceC0605Bf> A0J;
    public final CopyOnWriteArraySet<GQ> A0K;
    public final CopyOnWriteArraySet<InterfaceC2114ol> A0L;
    public final InterfaceC2117oo[] A0M;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public AA(Context context, InterfaceC05317t interfaceC05317t, AbstractC0697Ew abstractC0697Ew, AnonymousClass74 anonymousClass74, F6 f6, A6 a6, InterfaceC1859kO<AnonymousClass45, InterfaceC2112oj> interfaceC1859kO, AnonymousClass45 anonymousClass45) {
        this.A0F = new SurfaceHolderCallbackC2115om(this);
        this.A0L = new CopyOnWriteArraySet<>();
        this.A0J = new CopyOnWriteArraySet<>();
        this.A0K = new CopyOnWriteArraySet<>();
        this.A0H = new CopyOnWriteArraySet<>();
        Looper looperMyLooper = Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper();
        this.A0D = new Handler(looperMyLooper);
        this.A0M = interfaceC05317t.A5Y(this.A0D, this.A0F, this.A0F, this.A0F, this.A0F, a6);
        this.A00 = 1.0f;
        this.A01 = 0;
        this.A06 = C2214qQ.A07;
        this.A02 = 1;
        this.A0E = A06(this.A0M, abstractC0697Ew, anonymousClass74, f6, anonymousClass45);
        this.A0G = interfaceC1859kO.A4B(anonymousClass45);
        this.A0G.AJf(this.A0E, looperMyLooper);
        this.A0I = new CopyOnWriteArraySet<>();
    }

    public static String A07(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0N, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 61);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0E() {
        A0N = new byte[]{-41, -19, -15, -12, -16, -23, -55, -4, -13, -44, -16, -27, -3, -23, -10, Ascii.FF, 46, 43, Ascii.US, Ascii.SUB, Ascii.FS, Ascii.RS, Ascii.CR, Ascii.RS, Framer.STDOUT_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX, 46, 43, Ascii.RS, 5, 34, 44, Framer.STDIN_FRAME_PREFIX, Ascii.RS, 39, Ascii.RS, 43, -39, Ascii.SUB, 37, 43, Ascii.RS, Ascii.SUB, Ascii.GS, Framer.STDERR_FRAME_PREFIX, -39, 46, 39, 44, Ascii.RS, Framer.STDIN_FRAME_PREFIX, -39, 40, 43, -39, 43, Ascii.RS, 41, 37, Ascii.SUB, Ascii.FS, Ascii.RS, Ascii.GS, -25};
    }

    static {
        A0E();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.kO != com.google.common.base.Function<com.facebook.ads.androidx.media3.common.util.Clock, com.facebook.ads.androidx.media3.exoplayer.analytics.AnalyticsCollector> */
    public AA(Context context, InterfaceC05317t interfaceC05317t, AbstractC0697Ew abstractC0697Ew, AnonymousClass74 anonymousClass74, F6 f6, A6 a6, InterfaceC1859kO<AnonymousClass45, InterfaceC2112oj> interfaceC1859kO) {
        this(context, interfaceC05317t, abstractC0697Ew, anonymousClass74, f6, a6, interfaceC1859kO, AnonymousClass45.A00);
    }

    @Deprecated
    public AA(InterfaceC05317t interfaceC05317t, AbstractC0697Ew abstractC0697Ew, AnonymousClass74 anonymousClass74, F6 f6, A6 a6) {
        this(null, interfaceC05317t, abstractC0697Ew, anonymousClass74, f6, a6, new InterfaceC1859kO() { // from class: com.facebook.ads.redexgen.X.or
            @Override // com.facebook.ads.redexgen.core.InterfaceC1859kO
            public final Object A4B(Object obj) {
                return new A8((AnonymousClass45) obj);
            }
        });
    }

    private final AC A06(InterfaceC2117oo[] interfaceC2117ooArr, AbstractC0697Ew abstractC0697Ew, AnonymousClass74 anonymousClass74, F6 f6, AnonymousClass45 anonymousClass45) {
        return new AC(interfaceC2117ooArr, abstractC0697Ew, anonymousClass74, f6, anonymousClass45);
    }

    private void A0D() {
        if (this.A05 != null) {
            if (this.A05.getSurfaceTextureListener() != this.A0F) {
                Log.w(A07(0, 15, 71), A07(15, 49, 124));
            } else {
                this.A05.setSurfaceTextureListener(null);
            }
            this.A05 = null;
        }
        if (this.A04 != null) {
            this.A04.removeCallback(this.A0F);
            String[] strArr = A0O;
            if (strArr[6].length() == strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0O;
            strArr2[6] = "1mt3T64XRkFMJTK0AHNCLCnfNjMbTppi";
            strArr2[3] = "rnp4JtgfYQ";
            this.A04 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0F(Surface surface, boolean z2) {
        ArrayList arrayList = new ArrayList();
        for (InterfaceC2117oo interfaceC2117oo : this.A0M) {
            if (interfaceC2117oo.A9N() == 2) {
                arrayList.add(this.A0E.A0L(interfaceC2117oo).A07(1).A08(surface).A06());
            }
        }
        if (this.A03 != null && this.A03 != surface) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((C05157d) it.next()).A0C();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            if (this.A0C) {
                this.A03.release();
            }
        }
        this.A03 = surface;
        this.A0C = z2;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2213qP
    public final void A0H(int i3, long j3) {
        this.A0G.ACe();
        this.A0E.A0H(i3, j3);
    }

    public final int A0I() {
        return this.A01;
    }

    public final C2208qI A0J() {
        return this.A07;
    }

    public final C2208qI A0K() {
        return this.A08;
    }

    public final void A0L() {
        this.A0E.A0M();
        A0D();
        if (this.A03 != null) {
            if (this.A0C) {
                this.A03.release();
            }
            this.A03 = null;
        }
        if (this.A0B != null) {
            this.A0B.AIS(this.A0G);
            this.A0B = null;
        }
    }

    public final void A0M(float f3) {
        float fA00 = C5C.A00(f3, 0.0f, 1.0f);
        if (this.A00 == fA00) {
            return;
        }
        this.A00 = fA00;
        for (InterfaceC2117oo interfaceC2117oo : this.A0M) {
            if (interfaceC2117oo.A9N() == 1) {
                this.A0E.A0L(interfaceC2117oo).A07(2).A08(Float.valueOf(fA00)).A06();
            }
        }
    }

    public final void A0N(Surface surface) {
        A0D();
        A0F(surface, false);
    }

    public final void A0O(C3U c3u) {
        this.A0E.A0O(c3u);
        this.A0I.add(c3u);
    }

    public final void A0P(InterfaceC2114ol interfaceC2114ol) {
        this.A0L.add(interfaceC2114ol);
    }

    public final void A0Q(InterfaceC0646Cx interfaceC0646Cx) {
        A0R(interfaceC0646Cx, true, true);
    }

    public final void A0R(InterfaceC0646Cx interfaceC0646Cx, boolean z2, boolean z3) {
        if (this.A0B != null) {
            this.A0B.AIS(this.A0G);
        }
        this.A0B = interfaceC0646Cx;
        interfaceC0646Cx.A3z(this.A0D, this.A0G);
        this.A0E.A0P(interfaceC0646Cx, z2, z3);
    }

    public final void A0S(boolean z2) {
        this.A0E.A0Q(z2);
    }

    public final boolean A0T() {
        return this.A0E.A0R();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC04113b
    public final long A77() {
        return this.A0E.A77();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC04113b
    public final long A7T() {
        return this.A0E.A7T();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC04113b
    public final int A7Y() {
        return this.A0E.A7Y();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC04113b
    public final int A7Z() {
        return this.A0E.A7Z();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC04113b
    public final int A7b() {
        return this.A0E.A7b();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC04113b
    public final int A7c() {
        return this.A0E.A7c();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC04113b
    public final long A7e() {
        return this.A0E.A7e();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC04113b
    public final Timeline A7g() {
        return this.A0E.A7g();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC04113b
    public final int A7h() {
        return this.A0E.A7h();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC04113b
    public final long A7s() {
        return this.A0E.A7s();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC04113b
    public final long A9J() {
        return this.A0E.A9J();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC04113b
    public final boolean AAd() {
        return this.A0E.AAd();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC04113b
    public final void AKG(boolean z2) {
        this.A0E.AKG(z2);
        if (this.A0B != null) {
            this.A0B.AIS(this.A0G);
            this.A0B = null;
            if (z2) {
                this.A0B = null;
            }
        }
    }
}
