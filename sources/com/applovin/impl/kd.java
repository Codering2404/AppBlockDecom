package com.applovin.impl;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.impl.g1;
import com.applovin.impl.gd;
import com.applovin.impl.md;
import com.applovin.impl.mediation.nativeAds.xNe.qRMDmh;
import com.applovin.impl.o5;
import com.applovin.impl.y6;
import com.facebook.ads.AdError;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.stetho.dumpapp.Framer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class kd extends e2 {
    private static final byte[] I0 = {0, 0, 1, 103, 66, -64, Ascii.VT, -38, 37, -112, 0, 0, 1, 104, -50, Ascii.SI, 19, 32, 0, 0, 1, 101, -120, -124, Ascii.CR, -50, 113, Ascii.CAN, -96, 0, 47, -65, Ascii.FS, Framer.STDOUT_FRAME_PREFIX, -61, 39, 93, Framer.EXIT_FRAME_PREFIX};
    private final long[] A;
    private boolean A0;
    private e9 B;
    private boolean B0;
    private e9 C;
    private boolean C0;
    private y6 D;
    private z7 D0;
    private y6 E;
    protected m5 E0;
    private MediaCrypto F;
    private long F0;
    private boolean G;
    private long G0;
    private long H;
    private int H0;
    private float I;
    private float J;
    private gd K;
    private e9 L;
    private MediaFormat M;
    private boolean N;
    private float O;
    private ArrayDeque P;
    private a Q;
    private jd R;
    private int S;
    private boolean T;
    private boolean U;
    private boolean V;
    private boolean W;
    private boolean X;
    private boolean Y;
    private boolean Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private boolean f60983a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private boolean f60984b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private boolean f60985c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private s2 f60986d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private long f60987e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private int f60988f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private int f60989g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private ByteBuffer f60990h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private boolean f60991i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private boolean f60992j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private boolean f60993k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private boolean f60994l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private boolean f60995m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final gd.b f60996n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private boolean f60997n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final ld f60998o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private int f60999o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f61000p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private int f61001p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final float f61002q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private int f61003q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final o5 f61004r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private boolean f61005r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final o5 f61006s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private boolean f61007s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final o5 f61008t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private boolean f61009t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final g2 f61010u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private long f61011u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final eo f61012v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private long f61013v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final ArrayList f61014w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private boolean f61015w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final MediaCodec.BufferInfo f61016x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    private boolean f61017x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final long[] f61018y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    private boolean f61019y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final long[] f61020z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    private boolean f61021z0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class a extends Exception {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f61022a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f61023b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final jd f61024c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f61025d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final a f61026f;

        public a(e9 e9Var, Throwable th, boolean z2, int i3) {
            this("Decoder init failed: [" + i3 + "], " + e9Var, th, e9Var.f59394m, z2, null, a(i3), null);
        }

        private static String a(int i3) {
            return "com.applovin.exoplayer2.mediacodec.MediaCodecRenderer_" + (i3 < 0 ? "neg_" : "") + Math.abs(i3);
        }

        public a(e9 e9Var, Throwable th, boolean z2, jd jdVar) {
            this("Decoder init failed: " + jdVar.f60691a + ", " + e9Var, th, e9Var.f59394m, z2, jdVar, xp.f65027a >= 21 ? a(th) : null, null);
        }

        private static String a(Throwable th) {
            if (th instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            return null;
        }

        private a(String str, Throwable th, String str2, boolean z2, jd jdVar, String str3, a aVar) {
            super(str, th);
            this.f61022a = str2;
            this.f61023b = z2;
            this.f61024c = jdVar;
            this.f61025d = str3;
            this.f61026f = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a a(a aVar) {
            return new a(getMessage(), getCause(), this.f61022a, this.f61023b, this.f61024c, this.f61025d, aVar);
        }
    }

    public kd(int i3, gd.b bVar, ld ldVar, boolean z2, float f3) {
        super(i3);
        this.f60996n = bVar;
        this.f60998o = (ld) b1.a(ldVar);
        this.f61000p = z2;
        this.f61002q = f3;
        this.f61004r = o5.i();
        this.f61006s = new o5(0);
        this.f61008t = new o5(2);
        g2 g2Var = new g2();
        this.f61010u = g2Var;
        this.f61012v = new eo();
        this.f61014w = new ArrayList();
        this.f61016x = new MediaCodec.BufferInfo();
        this.I = 1.0f;
        this.J = 1.0f;
        this.H = -9223372036854775807L;
        this.f61018y = new long[10];
        this.f61020z = new long[10];
        this.A = new long[10];
        this.F0 = -9223372036854775807L;
        this.G0 = -9223372036854775807L;
        g2Var.g(0);
        g2Var.f62183c.order(ByteOrder.nativeOrder());
        this.O = -1.0f;
        this.S = 0;
        this.f60999o0 = 0;
        this.f60988f0 = -1;
        this.f60989g0 = -1;
        this.f60987e0 = -9223372036854775807L;
        this.f61011u0 = -9223372036854775807L;
        this.f61013v0 = -9223372036854775807L;
        this.f61001p0 = 0;
        this.f61003q0 = 0;
    }

    private void A() {
        this.f60995m0 = false;
        this.f61010u.b();
        this.f61008t.b();
        this.f60994l0 = false;
        this.f60993k0 = false;
    }

    private boolean B() {
        if (this.f61005r0) {
            this.f61001p0 = 1;
            if (this.U || this.W) {
                this.f61003q0 = 3;
                return false;
            }
            this.f61003q0 = 1;
        }
        return true;
    }

    private void C() throws z7 {
        if (!this.f61005r0) {
            T();
        } else {
            this.f61001p0 = 1;
            this.f61003q0 = 3;
        }
    }

    private boolean D() throws z7 {
        if (this.f61005r0) {
            this.f61001p0 = 1;
            if (this.U || this.W) {
                this.f61003q0 = 3;
                return false;
            }
            this.f61003q0 = 2;
        } else {
            b0();
        }
        return true;
    }

    private boolean E() throws z7 {
        gd gdVar = this.K;
        if (gdVar == null || this.f61001p0 == 2 || this.f61015w0) {
            return false;
        }
        if (this.f60988f0 < 0) {
            int iD = gdVar.d();
            this.f60988f0 = iD;
            if (iD < 0) {
                return false;
            }
            this.f61006s.f62183c = this.K.a(iD);
            this.f61006s.b();
        }
        if (this.f61001p0 == 1) {
            if (!this.f60985c0) {
                this.f61007s0 = true;
                this.K.a(this.f60988f0, 0, 0, 0L, 4);
                Y();
            }
            this.f61001p0 = 2;
            return false;
        }
        if (this.f60983a0) {
            this.f60983a0 = false;
            ByteBuffer byteBuffer = this.f61006s.f62183c;
            byte[] bArr = I0;
            byteBuffer.put(bArr);
            this.K.a(this.f60988f0, 0, bArr.length, 0L, 0);
            Y();
            this.f61005r0 = true;
            return true;
        }
        if (this.f60999o0 == 1) {
            for (int i3 = 0; i3 < this.L.f59396o.size(); i3++) {
                this.f61006s.f62183c.put((byte[]) this.L.f59396o.get(i3));
            }
            this.f60999o0 = 2;
        }
        int iPosition = this.f61006s.f62183c.position();
        f9 f9VarR = r();
        try {
            int iA = a(f9VarR, this.f61006s, 0);
            if (j()) {
                this.f61013v0 = this.f61011u0;
            }
            if (iA == -3) {
                return false;
            }
            if (iA == -5) {
                if (this.f60999o0 == 2) {
                    this.f61006s.b();
                    this.f60999o0 = 1;
                }
                a(f9VarR);
                return true;
            }
            if (this.f61006s.e()) {
                if (this.f60999o0 == 2) {
                    this.f61006s.b();
                    this.f60999o0 = 1;
                }
                this.f61015w0 = true;
                if (!this.f61005r0) {
                    R();
                    return false;
                }
                try {
                    if (!this.f60985c0) {
                        this.f61007s0 = true;
                        this.K.a(this.f60988f0, 0, 0, 0L, 4);
                        Y();
                    }
                    return false;
                } catch (MediaCodec.CryptoException e3) {
                    throw a(e3, this.B, t2.a(e3.getErrorCode()));
                }
            }
            if (!this.f61005r0 && !this.f61006s.f()) {
                this.f61006s.b();
                if (this.f60999o0 == 2) {
                    this.f60999o0 = 1;
                }
                return true;
            }
            boolean zH = this.f61006s.h();
            if (zH) {
                this.f61006s.f62182b.a(iPosition);
            }
            if (this.T && !zH) {
                yf.a(this.f61006s.f62183c);
                if (this.f61006s.f62183c.position() == 0) {
                    return true;
                }
                this.T = false;
            }
            o5 o5Var = this.f61006s;
            long jA = o5Var.f62185f;
            s2 s2Var = this.f60986d0;
            if (s2Var != null) {
                jA = s2Var.a(this.B, o5Var);
                this.f61011u0 = Math.max(this.f61011u0, this.f60986d0.a(this.B));
            }
            long j3 = jA;
            if (this.f61006s.d()) {
                this.f61014w.add(Long.valueOf(j3));
            }
            if (this.f61019y0) {
                this.f61012v.a(j3, this.B);
                this.f61019y0 = false;
            }
            this.f61011u0 = Math.max(this.f61011u0, j3);
            this.f61006s.g();
            if (this.f61006s.c()) {
                a(this.f61006s);
            }
            b(this.f61006s);
            try {
                if (zH) {
                    this.K.a(this.f60988f0, 0, this.f61006s.f62182b, j3, 0);
                } else {
                    this.K.a(this.f60988f0, 0, this.f61006s.f62183c.limit(), j3, 0);
                }
                Y();
                this.f61005r0 = true;
                this.f60999o0 = 0;
                this.E0.f61370c++;
                return true;
            } catch (MediaCodec.CryptoException e4) {
                throw a(e4, this.B, t2.a(e4.getErrorCode()));
            }
        } catch (o5.a e5) {
            a(e5);
            e(0);
            F();
            return true;
        }
    }

    private void F() {
        try {
            this.K.b();
        } finally {
            W();
        }
    }

    private boolean O() {
        return this.f60989g0 >= 0;
    }

    private void R() throws z7 {
        int i3 = this.f61003q0;
        if (i3 == 1) {
            F();
            return;
        }
        if (i3 == 2) {
            F();
            b0();
        } else if (i3 == 3) {
            T();
        } else {
            this.f61017x0 = true;
            V();
        }
    }

    private void S() {
        this.f61009t0 = true;
        MediaFormat mediaFormatE = this.K.e();
        if (this.S != 0 && mediaFormatE.getInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY) == 32 && mediaFormatE.getInteger(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY) == 32) {
            this.f60984b0 = true;
            return;
        }
        if (this.Z) {
            mediaFormatE.setInteger("channel-count", 1);
        }
        this.M = mediaFormatE;
        this.N = true;
    }

    private void T() throws z7 {
        U();
        P();
    }

    private void Y() {
        this.f60988f0 = -1;
        this.f61006s.f62183c = null;
    }

    private void Z() {
        this.f60989g0 = -1;
        this.f60990h0 = null;
    }

    private void b0() throws z7 {
        try {
            this.F.setMediaDrmSession(a(this.E).f60944b);
            b(this.E);
            this.f61001p0 = 0;
            this.f61003q0 = 0;
        } catch (MediaCryptoException e3) {
            throw a(e3, this.B, 6006);
        }
    }

    private List d(boolean z2) {
        List listA = a(this.f60998o, this.B, z2);
        if (!listA.isEmpty() || !z2) {
            return listA;
        }
        List listA2 = a(this.f60998o, this.B, false);
        if (!listA2.isEmpty()) {
            oc.d("MediaCodecRenderer", "Drm session requires secure decoder for " + this.B.f59394m + ", but no secure decoder available. Trying to proceed with " + listA2 + ".");
        }
        return listA2;
    }

    private boolean e(int i3) throws z7 {
        f9 f9VarR = r();
        this.f61004r.b();
        int iA = a(f9VarR, this.f61004r, i3 | 4);
        if (iA == -5) {
            a(f9VarR);
            return true;
        }
        if (iA != -4 || !this.f61004r.e()) {
            return false;
        }
        this.f61015w0 = true;
        R();
        return false;
    }

    private void z() throws z7 {
        b1.b(!this.f61015w0);
        f9 f9VarR = r();
        this.f61008t.b();
        do {
            this.f61008t.b();
            int iA = a(f9VarR, this.f61008t, 0);
            if (iA == -5) {
                a(f9VarR);
                return;
            }
            if (iA != -4) {
                if (iA != -3) {
                    throw new IllegalStateException();
                }
                return;
            } else {
                if (this.f61008t.e()) {
                    this.f61015w0 = true;
                    return;
                }
                if (this.f61019y0) {
                    e9 e9Var = (e9) b1.a(this.B);
                    this.C = e9Var;
                    a(e9Var, (MediaFormat) null);
                    this.f61019y0 = false;
                }
                this.f61008t.g();
            }
        } while (this.f61010u.a(this.f61008t));
        this.f60994l0 = true;
    }

    protected final boolean G() throws z7 {
        boolean zH = H();
        if (zH) {
            P();
        }
        return zH;
    }

    protected boolean H() {
        if (this.K == null) {
            return false;
        }
        if (this.f61003q0 == 3 || this.U || ((this.V && !this.f61009t0) || (this.W && this.f61007s0))) {
            U();
            return true;
        }
        F();
        return false;
    }

    protected final gd I() {
        return this.K;
    }

    protected final jd J() {
        return this.R;
    }

    protected boolean K() {
        return false;
    }

    protected final MediaFormat L() {
        return this.M;
    }

    protected final long M() {
        return this.G0;
    }

    protected float N() {
        return this.I;
    }

    protected final void P() throws z7 {
        e9 e9Var;
        if (this.K != null || this.f60993k0 || (e9Var = this.B) == null) {
            return;
        }
        if (this.E == null && c(e9Var)) {
            b(this.B);
            return;
        }
        b(this.E);
        String str = this.B.f59394m;
        y6 y6Var = this.D;
        if (y6Var != null) {
            if (this.F == null) {
                k9 k9VarA = a(y6Var);
                if (k9VarA != null) {
                    try {
                        MediaCrypto mediaCrypto = new MediaCrypto(k9VarA.f60943a, k9VarA.f60944b);
                        this.F = mediaCrypto;
                        this.G = !k9VarA.f60945c && mediaCrypto.requiresSecureDecoderComponent(str);
                    } catch (MediaCryptoException e3) {
                        throw a(e3, this.B, 6006);
                    }
                } else if (this.D.getError() == null) {
                    return;
                }
            }
            if (k9.f60942d) {
                int iB = this.D.b();
                if (iB == 1) {
                    y6.a aVar = (y6.a) b1.a(this.D.getError());
                    throw a(aVar, this.B, aVar.f65158a);
                }
                if (iB != 4) {
                    return;
                }
            }
        }
        try {
            a(this.F, this.G);
        } catch (a e4) {
            throw a(e4, this.B, 4001);
        }
    }

    protected void Q() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void U() {
        try {
            gd gdVar = this.K;
            if (gdVar != null) {
                gdVar.a();
                this.E0.f61369b++;
                g(this.R.f60691a);
            }
            this.K = null;
            try {
                MediaCrypto mediaCrypto = this.F;
                if (mediaCrypto != null) {
                    mediaCrypto.release();
                }
            } finally {
            }
        } catch (Throwable th) {
            this.K = null;
            try {
                MediaCrypto mediaCrypto2 = this.F;
                if (mediaCrypto2 != null) {
                    mediaCrypto2.release();
                }
                throw th;
            } finally {
            }
        }
    }

    protected void V() {
    }

    protected void W() {
        Y();
        Z();
        this.f60987e0 = -9223372036854775807L;
        this.f61007s0 = false;
        this.f61005r0 = false;
        this.f60983a0 = false;
        this.f60984b0 = false;
        this.f60991i0 = false;
        this.f60992j0 = false;
        this.f61014w.clear();
        this.f61011u0 = -9223372036854775807L;
        this.f61013v0 = -9223372036854775807L;
        s2 s2Var = this.f60986d0;
        if (s2Var != null) {
            s2Var.a();
        }
        this.f61001p0 = 0;
        this.f61003q0 = 0;
        this.f60999o0 = this.f60997n0 ? 1 : 0;
    }

    protected void X() {
        W();
        this.D0 = null;
        this.f60986d0 = null;
        this.P = null;
        this.R = null;
        this.L = null;
        this.M = null;
        this.N = false;
        this.f61009t0 = false;
        this.O = -1.0f;
        this.S = 0;
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = false;
        this.X = false;
        this.Y = false;
        this.Z = false;
        this.f60985c0 = false;
        this.f60997n0 = false;
        this.f60999o0 = 0;
        this.G = false;
    }

    protected abstract float a(float f3, e9 e9Var, e9[] e9VarArr);

    protected abstract int a(ld ldVar, e9 e9Var);

    protected abstract gd.a a(jd jdVar, e9 e9Var, MediaCrypto mediaCrypto, float f3);

    protected abstract p5 a(jd jdVar, e9 e9Var, e9 e9Var2);

    protected abstract List a(ld ldVar, e9 e9Var, boolean z2);

    protected abstract void a(e9 e9Var, MediaFormat mediaFormat);

    protected void a(o5 o5Var) {
    }

    protected abstract void a(Exception exc);

    protected abstract void a(String str, long j3, long j4);

    protected abstract boolean a(long j3, long j4, gd gdVar, ByteBuffer byteBuffer, int i3, int i4, int i5, long j5, boolean z2, boolean z3, e9 e9Var);

    protected final void a0() {
        this.f61021z0 = true;
    }

    protected abstract void b(o5 o5Var);

    protected boolean b(jd jdVar) {
        return true;
    }

    protected boolean c(e9 e9Var) {
        return false;
    }

    protected final void f(long j3) {
        e9 e9Var = (e9) this.f61012v.c(j3);
        if (e9Var == null && this.N) {
            e9Var = (e9) this.f61012v.c();
        }
        if (e9Var != null) {
            this.C = e9Var;
        } else if (!this.N || this.C == null) {
            return;
        }
        a(this.C, this.M);
        this.N = false;
    }

    protected abstract void g(String str);

    @Override // com.applovin.impl.e2, com.applovin.impl.ri
    public final int m() {
        return 8;
    }

    @Override // com.applovin.impl.e2
    protected void v() {
        this.B = null;
        this.F0 = -9223372036854775807L;
        this.G0 = -9223372036854775807L;
        this.H0 = 0;
        H();
    }

    @Override // com.applovin.impl.e2
    protected void w() {
        try {
            A();
            U();
        } finally {
            c((y6) null);
        }
    }

    @Override // com.applovin.impl.e2
    protected void x() {
    }

    @Override // com.applovin.impl.e2
    protected void y() {
    }

    private static boolean a(jd jdVar) {
        String str = jdVar.f60691a;
        int i3 = xp.f65027a;
        if (i3 <= 25 && "OMX.rk.video_decoder.avc".equals(str)) {
            return true;
        }
        if (i3 <= 17 && qRMDmh.fCrgxgusIU.equals(str)) {
            return true;
        }
        if (i3 > 29 || !("OMX.broadcom.video_decoder.tunnel".equals(str) || "OMX.broadcom.video_decoder.tunnel.secure".equals(str))) {
            return "Amazon".equals(xp.f65029c) && "AFTS".equals(xp.f65030d) && jdVar.f60697g;
        }
        return true;
    }

    private boolean b(long j3, long j4) throws z7 {
        boolean z2;
        b1.b(!this.f61017x0);
        if (this.f61010u.m()) {
            g2 g2Var = this.f61010u;
            z2 = false;
            if (!a(j3, j4, null, g2Var.f62183c, this.f60989g0, 0, g2Var.l(), this.f61010u.j(), this.f61010u.d(), this.f61010u.e(), this.C)) {
                return false;
            }
            d(this.f61010u.k());
            this.f61010u.b();
        } else {
            z2 = false;
        }
        if (this.f61015w0) {
            this.f61017x0 = true;
            return z2;
        }
        if (this.f60994l0) {
            b1.b(this.f61010u.a(this.f61008t));
            this.f60994l0 = z2;
        }
        if (this.f60995m0) {
            if (this.f61010u.m()) {
                return true;
            }
            A();
            this.f60995m0 = z2;
            P();
            if (!this.f60993k0) {
                return z2;
            }
        }
        z();
        if (this.f61010u.m()) {
            this.f61010u.g();
        }
        if (this.f61010u.m() || this.f61015w0 || this.f60995m0) {
            return true;
        }
        return z2;
    }

    private boolean c(long j3, long j4) throws z7 {
        boolean z2;
        boolean zA;
        gd gdVar;
        ByteBuffer byteBuffer;
        int i3;
        MediaCodec.BufferInfo bufferInfo;
        int iA;
        if (!O()) {
            if (this.X && this.f61007s0) {
                try {
                    iA = this.K.a(this.f61016x);
                } catch (IllegalStateException unused) {
                    R();
                    if (this.f61017x0) {
                        U();
                    }
                    return false;
                }
            } else {
                iA = this.K.a(this.f61016x);
            }
            if (iA < 0) {
                if (iA == -2) {
                    S();
                    return true;
                }
                if (this.f60985c0 && (this.f61015w0 || this.f61001p0 == 2)) {
                    R();
                }
                return false;
            }
            if (this.f60984b0) {
                this.f60984b0 = false;
                this.K.a(iA, false);
                return true;
            }
            MediaCodec.BufferInfo bufferInfo2 = this.f61016x;
            if (bufferInfo2.size == 0 && (bufferInfo2.flags & 4) != 0) {
                R();
                return false;
            }
            this.f60989g0 = iA;
            ByteBuffer byteBufferB = this.K.b(iA);
            this.f60990h0 = byteBufferB;
            if (byteBufferB != null) {
                byteBufferB.position(this.f61016x.offset);
                ByteBuffer byteBuffer2 = this.f60990h0;
                MediaCodec.BufferInfo bufferInfo3 = this.f61016x;
                byteBuffer2.limit(bufferInfo3.offset + bufferInfo3.size);
            }
            if (this.Y) {
                MediaCodec.BufferInfo bufferInfo4 = this.f61016x;
                if (bufferInfo4.presentationTimeUs == 0 && (bufferInfo4.flags & 4) != 0) {
                    long j5 = this.f61011u0;
                    if (j5 != -9223372036854775807L) {
                        bufferInfo4.presentationTimeUs = j5;
                    }
                }
            }
            this.f60991i0 = c(this.f61016x.presentationTimeUs);
            long j6 = this.f61013v0;
            long j7 = this.f61016x.presentationTimeUs;
            this.f60992j0 = j6 == j7;
            f(j7);
        }
        if (this.X && this.f61007s0) {
            try {
                gdVar = this.K;
                byteBuffer = this.f60990h0;
                i3 = this.f60989g0;
                bufferInfo = this.f61016x;
                z2 = false;
            } catch (IllegalStateException unused2) {
                z2 = false;
            }
            try {
                zA = a(j3, j4, gdVar, byteBuffer, i3, bufferInfo.flags, 1, bufferInfo.presentationTimeUs, this.f60991i0, this.f60992j0, this.C);
            } catch (IllegalStateException unused3) {
                R();
                if (this.f61017x0) {
                    U();
                }
                return z2;
            }
        } else {
            z2 = false;
            gd gdVar2 = this.K;
            ByteBuffer byteBuffer3 = this.f60990h0;
            int i4 = this.f60989g0;
            MediaCodec.BufferInfo bufferInfo5 = this.f61016x;
            zA = a(j3, j4, gdVar2, byteBuffer3, i4, bufferInfo5.flags, 1, bufferInfo5.presentationTimeUs, this.f60991i0, this.f60992j0, this.C);
        }
        if (zA) {
            d(this.f61016x.presentationTimeUs);
            boolean z3 = (this.f61016x.flags & 4) != 0 ? true : z2;
            Z();
            if (!z3) {
                return true;
            }
            R();
        }
        return z2;
    }

    private boolean e(long j3) {
        return this.H == -9223372036854775807L || SystemClock.elapsedRealtime() - j3 < this.H;
    }

    private static boolean f(String str) {
        return xp.f65027a == 29 && "c2.android.aac.decoder".equals(str);
    }

    @Override // com.applovin.impl.qi
    public boolean d() {
        if (this.B == null) {
            return false;
        }
        if (u() || O()) {
            return true;
        }
        return this.f60987e0 != -9223372036854775807L && SystemClock.elapsedRealtime() < this.f60987e0;
    }

    private boolean a(jd jdVar, e9 e9Var, y6 y6Var, y6 y6Var2) {
        k9 k9VarA;
        if (y6Var == y6Var2) {
            return false;
        }
        if (y6Var2 == null || y6Var == null || xp.f65027a < 23) {
            return true;
        }
        UUID uuid = t2.f63864e;
        if (uuid.equals(y6Var.e()) || uuid.equals(y6Var2.e()) || (k9VarA = a(y6Var2)) == null) {
            return true;
        }
        return !jdVar.f60697g && (k9VarA.f60945c ? false : y6Var2.a(e9Var.f59394m));
    }

    private boolean e(e9 e9Var) throws z7 {
        if (xp.f65027a >= 23 && this.K != null && this.f61003q0 != 3 && b() != 0) {
            float fA = a(this.J, e9Var, t());
            float f3 = this.O;
            if (f3 == fA) {
                return true;
            }
            if (fA == -1.0f) {
                C();
                return false;
            }
            if (f3 == -1.0f && fA <= this.f61002q) {
                return true;
            }
            Bundle bundle = new Bundle();
            bundle.putFloat("operating-rate", fA);
            this.K.a(bundle);
            this.O = fA;
        }
        return true;
    }

    protected void d(long j3) {
        while (true) {
            int i3 = this.H0;
            if (i3 == 0 || j3 < this.A[0]) {
                return;
            }
            long[] jArr = this.f61018y;
            this.F0 = jArr[0];
            this.G0 = this.f61020z[0];
            int i4 = i3 - 1;
            this.H0 = i4;
            System.arraycopy(jArr, 1, jArr, 0, i4);
            long[] jArr2 = this.f61020z;
            System.arraycopy(jArr2, 1, jArr2, 0, this.H0);
            long[] jArr3 = this.A;
            System.arraycopy(jArr3, 1, jArr3, 0, this.H0);
            Q();
        }
    }

    public void a(boolean z2) {
        this.A0 = z2;
    }

    private k9 a(y6 y6Var) throws z7 {
        y4 y4VarF = y6Var.f();
        if (y4VarF != null && !(y4VarF instanceof k9)) {
            throw a(new IllegalArgumentException("Expecting FrameworkCryptoConfig but found: " + y4VarF), this.B, AdError.MEDIAVIEW_MISSING_ERROR_CODE);
        }
        return (k9) y4VarF;
    }

    protected static boolean d(e9 e9Var) {
        int i3 = e9Var.F;
        return i3 == 0 || i3 == 2;
    }

    private void a(jd jdVar, MediaCrypto mediaCrypto) throws Exception {
        gd gdVarA;
        String str = jdVar.f60691a;
        int i3 = xp.f65027a;
        float fA = i3 < 23 ? -1.0f : a(this.J, this.B, t());
        float f3 = fA > this.f61002q ? fA : -1.0f;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        ko.a("createCodec:" + str);
        gd.a aVarA = a(jdVar, this.B, mediaCrypto, f3);
        if (this.A0 && i3 >= 23) {
            gdVarA = new g1.b(e(), this.B0, this.C0).a(aVarA);
        } else {
            gdVarA = this.f60996n.a(aVarA);
        }
        float f4 = f3;
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        this.K = gdVarA;
        this.R = jdVar;
        this.O = f4;
        this.L = this.B;
        this.S = a(str);
        this.T = a(str, this.L);
        this.U = e(str);
        this.V = f(str);
        this.W = c(str);
        this.X = d(str);
        this.Y = b(str);
        this.Z = b(str, this.L);
        this.f60985c0 = a(jdVar) || K();
        if (gdVarA.c()) {
            this.f60997n0 = true;
            this.f60999o0 = 1;
            this.f60983a0 = this.S != 0;
        }
        if ("c2.android.mp3.decoder".equals(jdVar.f60691a)) {
            this.f60986d0 = new s2();
        }
        if (b() == 2) {
            this.f60987e0 = SystemClock.elapsedRealtime() + 1000;
        }
        this.E0.f61368a++;
        a(str, jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
    }

    private static boolean d(String str) {
        return xp.f65027a == 21 && "OMX.google.aac.decoder".equals(str);
    }

    private static boolean e(String str) {
        int i3 = xp.f65027a;
        if (i3 < 18) {
            return true;
        }
        if (i3 == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) {
            return true;
        }
        if (i3 == 19 && xp.f65030d.startsWith("SM-G800")) {
            return "OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str);
        }
        return false;
    }

    public void b(boolean z2) {
        this.B0 = z2;
    }

    private void b(e9 e9Var) {
        A();
        String str = e9Var.f59394m;
        if (!"audio/mp4a-latm".equals(str) && !"audio/mpeg".equals(str) && !"audio/opus".equals(str)) {
            this.f61010u.i(1);
        } else {
            this.f61010u.i(32);
        }
        this.f60993k0 = true;
    }

    private static boolean b(IllegalStateException illegalStateException) {
        return illegalStateException instanceof MediaCodec.CodecException;
    }

    private void b(y6 y6Var) {
        y6.a(this.D, y6Var);
        this.D = y6Var;
    }

    public void c(boolean z2) {
        this.C0 = z2;
    }

    private static boolean b(String str) {
        if (xp.f65027a >= 21 || !"OMX.SEC.mp3.dec".equals(str) || !"samsung".equals(xp.f65029c)) {
            return false;
        }
        String str2 = xp.f65028b;
        return str2.startsWith("baffin") || str2.startsWith("grand") || str2.startsWith("fortuna") || str2.startsWith("gprimelte") || str2.startsWith("j2y18lte") || str2.startsWith("ms01");
    }

    private boolean c(long j3) {
        int size = this.f61014w.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (((Long) this.f61014w.get(i3)).longValue() == j3) {
                this.f61014w.remove(i3);
                return true;
            }
        }
        return false;
    }

    @Override // com.applovin.impl.qi
    public boolean c() {
        return this.f61017x0;
    }

    private static boolean c(IllegalStateException illegalStateException) {
        if (illegalStateException instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) illegalStateException).isRecoverable();
        }
        return false;
    }

    private void c(y6 y6Var) {
        y6.a(this.E, y6Var);
        this.E = y6Var;
    }

    private static boolean c(String str) {
        int i3 = xp.f65027a;
        if (i3 <= 23 && "OMX.google.vorbis.decoder".equals(str)) {
            return true;
        }
        if (i3 > 19) {
            return false;
        }
        String str2 = xp.f65028b;
        if ("hb2000".equals(str2) || "stvm8".equals(str2)) {
            return "OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str);
        }
        return false;
    }

    private static boolean b(String str, e9 e9Var) {
        return xp.f65027a <= 18 && e9Var.f59407z == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
    }

    private void a(MediaCrypto mediaCrypto, boolean z2) throws a {
        if (this.P == null) {
            try {
                List listD = d(z2);
                ArrayDeque arrayDeque = new ArrayDeque();
                this.P = arrayDeque;
                if (this.f61000p) {
                    arrayDeque.addAll(listD);
                } else if (!listD.isEmpty()) {
                    this.P.add((jd) listD.get(0));
                }
                this.Q = null;
            } catch (md.c e3) {
                throw new a(this.B, e3, z2, -49998);
            }
        }
        if (!this.P.isEmpty()) {
            while (this.K == null) {
                jd jdVar = (jd) this.P.peekFirst();
                if (!b(jdVar)) {
                    return;
                }
                try {
                    a(jdVar, mediaCrypto);
                } catch (Exception e4) {
                    oc.c("MediaCodecRenderer", "Failed to initialize decoder: " + jdVar, e4);
                    this.P.removeFirst();
                    a aVar = new a(this.B, e4, z2, jdVar);
                    a(aVar);
                    if (this.Q != null) {
                        this.Q = this.Q.a(aVar);
                    } else {
                        this.Q = aVar;
                    }
                    if (this.P.isEmpty()) {
                        throw this.Q;
                    }
                }
            }
            this.P = null;
            return;
        }
        throw new a(this.B, (Throwable) null, z2, -49999);
    }

    @Override // com.applovin.impl.e2
    protected void a(boolean z2, boolean z3) {
        this.E0 = new m5();
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected com.applovin.impl.p5 a(com.applovin.impl.f9 r12) throws com.applovin.impl.z7 {
        /*
            Method dump skipped, instruction units count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.kd.a(com.applovin.impl.f9):com.applovin.impl.p5");
    }

    @Override // com.applovin.impl.e2
    protected void a(long j3, boolean z2) throws z7 {
        this.f61015w0 = false;
        this.f61017x0 = false;
        this.f61021z0 = false;
        if (this.f60993k0) {
            this.f61010u.b();
            this.f61008t.b();
            this.f60994l0 = false;
        } else {
            G();
        }
        if (this.f61012v.e() > 0) {
            this.f61019y0 = true;
        }
        this.f61012v.a();
        int i3 = this.H0;
        if (i3 != 0) {
            int i4 = i3 - 1;
            this.G0 = this.f61020z[i4];
            this.F0 = this.f61018y[i4];
            this.H0 = 0;
        }
    }

    @Override // com.applovin.impl.e2
    protected void a(e9[] e9VarArr, long j3, long j4) {
        if (this.G0 == -9223372036854775807L) {
            b1.b(this.F0 == -9223372036854775807L);
            this.F0 = j3;
            this.G0 = j4;
            return;
        }
        int i3 = this.H0;
        if (i3 == this.f61020z.length) {
            oc.d("MediaCodecRenderer", "Too many stream changes, so dropping offset: " + this.f61020z[this.H0 - 1]);
        } else {
            this.H0 = i3 + 1;
        }
        long[] jArr = this.f61018y;
        int i4 = this.H0 - 1;
        jArr[i4] = j3;
        this.f61020z[i4] = j4;
        this.A[i4] = this.f61011u0;
    }

    @Override // com.applovin.impl.qi
    public void a(long j3, long j4) throws z7 {
        boolean z2 = false;
        if (this.f61021z0) {
            this.f61021z0 = false;
            R();
        }
        z7 z7Var = this.D0;
        if (z7Var == null) {
            try {
                if (this.f61017x0) {
                    V();
                    return;
                }
                if (this.B != null || e(2)) {
                    P();
                    if (this.f60993k0) {
                        ko.a("bypassRender");
                        while (b(j3, j4)) {
                        }
                        ko.a();
                    } else if (this.K != null) {
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        ko.a("drainAndFeed");
                        while (c(j3, j4) && e(jElapsedRealtime)) {
                        }
                        while (E() && e(jElapsedRealtime)) {
                        }
                        ko.a();
                    } else {
                        this.E0.f61371d += b(j3);
                        e(1);
                    }
                    this.E0.a();
                    return;
                }
                return;
            } catch (IllegalStateException e3) {
                if (a(e3)) {
                    a((Exception) e3);
                    if (xp.f65027a >= 21 && c(e3)) {
                        z2 = true;
                    }
                    if (z2) {
                        U();
                    }
                    throw a(a(e3, J()), this.B, z2, 4003);
                }
                throw e3;
            }
        }
        this.D0 = null;
        throw z7Var;
    }

    protected final void a(z7 z7Var) {
        this.D0 = z7Var;
    }

    @Override // com.applovin.impl.qi
    public void a(float f3, float f4) throws z7 {
        this.I = f3;
        this.J = f4;
        e(this.L);
    }

    @Override // com.applovin.impl.ri
    public final int a(e9 e9Var) throws z7 {
        try {
            return a(this.f60998o, e9Var);
        } catch (md.c e3) {
            throw a(e3, e9Var, 4002);
        }
    }

    protected id a(Throwable th, jd jdVar) {
        return new id(th, jdVar);
    }

    private static boolean a(IllegalStateException illegalStateException) {
        if (xp.f65027a >= 21 && b(illegalStateException)) {
            return true;
        }
        StackTraceElement[] stackTrace = illegalStateException.getStackTrace();
        return stackTrace.length > 0 && stackTrace[0].getClassName().equals("android.media.MediaCodec");
    }

    private int a(String str) {
        int i3 = xp.f65027a;
        if (i3 <= 25 && "OMX.Exynos.avc.dec.secure".equals(str)) {
            String str2 = xp.f65030d;
            if (str2.startsWith("SM-T585") || str2.startsWith("SM-A510") || str2.startsWith("SM-A520") || str2.startsWith("SM-J700")) {
                return 2;
            }
        }
        if (i3 >= 24) {
            return 0;
        }
        if (!"OMX.Nvidia.h264.decode".equals(str) && !"OMX.Nvidia.h264.decode.secure".equals(str)) {
            return 0;
        }
        String str3 = xp.f65028b;
        return ("flounder".equals(str3) || "flounder_lte".equals(str3) || "grouper".equals(str3) || "tilapia".equals(str3)) ? 1 : 0;
    }

    private static boolean a(String str, e9 e9Var) {
        return xp.f65027a < 21 && e9Var.f59396o.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }
}
