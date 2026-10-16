package com.applovin.impl;

import android.content.Context;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import com.applovin.impl.e9;
import com.applovin.impl.gd;
import com.applovin.impl.q1;
import com.applovin.impl.qi;
import com.applovin.impl.r1;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class hd extends kd implements fd {
    private final Context J0;
    private final q1.a K0;
    private final r1 L0;
    private int M0;
    private boolean N0;
    private e9 O0;
    private long P0;
    private boolean Q0;
    private boolean R0;
    private boolean S0;
    private boolean T0;
    private qi.a U0;

    public hd(Context context, gd.b bVar, ld ldVar, boolean z2, Handler handler, q1 q1Var, r1 r1Var) {
        super(1, bVar, ldVar, z2, 44100.0f);
        this.J0 = context.getApplicationContext();
        this.L0 = r1Var;
        this.K0 = new q1.a(handler, q1Var);
        r1Var.a(new b());
    }

    private static boolean c0() {
        if (xp.f65027a != 23) {
            return false;
        }
        String str = xp.f65030d;
        return "ZTE B2017G".equals(str) || "AXON 7 mini".equals(str);
    }

    private void e0() {
        long jA = this.L0.a(c());
        if (jA != Long.MIN_VALUE) {
            if (!this.R0) {
                jA = Math.max(this.P0, jA);
            }
            this.P0 = jA;
            this.R0 = false;
        }
    }

    private static boolean h(String str) {
        if (xp.f65027a >= 24 || !"OMX.SEC.aac.dec".equals(str) || !"samsung".equals(xp.f65029c)) {
            return false;
        }
        String str2 = xp.f65028b;
        return str2.startsWith("zeroflte") || str2.startsWith("herolte") || str2.startsWith("heroqlte");
    }

    @Override // com.applovin.impl.kd
    protected void Q() {
        super.Q();
        this.L0.i();
    }

    @Override // com.applovin.impl.kd
    protected void V() throws z7 {
        try {
            this.L0.f();
        } catch (r1.e e3) {
            throw a(e3, e3.f62714c, e3.f62713b, 5002);
        }
    }

    @Override // com.applovin.impl.kd, com.applovin.impl.qi
    public boolean c() {
        return super.c() && this.L0.c();
    }

    @Override // com.applovin.impl.kd, com.applovin.impl.qi
    public boolean d() {
        return this.L0.g() || super.d();
    }

    protected void d0() {
        this.R0 = true;
    }

    @Override // com.applovin.impl.kd
    protected void g(String str) {
        this.K0.a(str);
    }

    @Override // com.applovin.impl.qi, com.applovin.impl.ri
    public String getName() {
        return "MediaCodecAudioRenderer";
    }

    @Override // com.applovin.impl.fd
    public long p() {
        if (b() == 2) {
            e0();
        }
        return this.P0;
    }

    @Override // com.applovin.impl.kd, com.applovin.impl.e2
    protected void v() {
        this.S0 = true;
        try {
            this.L0.b();
            try {
                super.v();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.v();
                throw th;
            } finally {
            }
        }
    }

    @Override // com.applovin.impl.kd, com.applovin.impl.e2
    protected void w() {
        try {
            super.w();
        } finally {
            if (this.S0) {
                this.S0 = false;
                this.L0.reset();
            }
        }
    }

    @Override // com.applovin.impl.kd, com.applovin.impl.e2
    protected void x() {
        super.x();
        this.L0.j();
    }

    @Override // com.applovin.impl.kd, com.applovin.impl.e2
    protected void y() {
        e0();
        this.L0.pause();
        super.y();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class b implements r1.c {
        private b() {
        }

        @Override // com.applovin.impl.r1.c
        public void a(Exception exc) {
            oc.a("MediaCodecAudioRenderer", "Audio sink error", exc);
            hd.this.K0.b(exc);
        }

        @Override // com.applovin.impl.r1.c
        public void b(long j3) {
            if (hd.this.U0 != null) {
                hd.this.U0.a(j3);
            }
        }

        @Override // com.applovin.impl.r1.c
        public void a() {
            if (hd.this.U0 != null) {
                hd.this.U0.a();
            }
        }

        @Override // com.applovin.impl.r1.c
        public void b() {
            hd.this.d0();
        }

        @Override // com.applovin.impl.r1.c
        public void a(long j3) {
            hd.this.K0.b(j3);
        }

        @Override // com.applovin.impl.r1.c
        public void a(boolean z2) {
            hd.this.K0.b(z2);
        }

        @Override // com.applovin.impl.r1.c
        public void a(int i3, long j3, long j4) {
            hd.this.K0.b(i3, j3, j4);
        }
    }

    @Override // com.applovin.impl.kd
    protected p5 a(jd jdVar, e9 e9Var, e9 e9Var2) {
        p5 p5VarA = jdVar.a(e9Var, e9Var2);
        int i3 = p5VarA.f62415e;
        if (a(jdVar, e9Var2) > this.M0) {
            i3 |= 64;
        }
        int i4 = i3;
        return new p5(jdVar.f60691a, e9Var, e9Var2, i4 != 0 ? 0 : p5VarA.f62414d, i4);
    }

    @Override // com.applovin.impl.kd
    protected void b(o5 o5Var) {
        if (!this.Q0 || o5Var.d()) {
            return;
        }
        if (Math.abs(o5Var.f62185f - this.P0) > 500000) {
            this.P0 = o5Var.f62185f;
        }
        this.Q0 = false;
    }

    @Override // com.applovin.impl.kd
    protected boolean c(e9 e9Var) {
        return this.L0.a(e9Var);
    }

    public hd(Context context, ld ldVar, boolean z2, Handler handler, q1 q1Var, r1 r1Var) {
        this(context, gd.b.f59971a, ldVar, z2, handler, q1Var, r1Var);
    }

    private int a(jd jdVar, e9 e9Var) {
        int i3;
        if (!"OMX.google.raw.decoder".equals(jdVar.f60691a) || (i3 = xp.f65027a) >= 24 || (i3 == 23 && xp.d(this.J0))) {
            return e9Var.f59395n;
        }
        return -1;
    }

    protected int a(jd jdVar, e9 e9Var, e9[] e9VarArr) {
        int iA = a(jdVar, e9Var);
        if (e9VarArr.length == 1) {
            return iA;
        }
        for (e9 e9Var2 : e9VarArr) {
            if (jdVar.a(e9Var, e9Var2).f62414d != 0) {
                iA = Math.max(iA, a(jdVar, e9Var2));
            }
        }
        return iA;
    }

    @Override // com.applovin.impl.kd
    protected float a(float f3, e9 e9Var, e9[] e9VarArr) {
        int iMax = -1;
        for (e9 e9Var2 : e9VarArr) {
            int i3 = e9Var2.A;
            if (i3 != -1) {
                iMax = Math.max(iMax, i3);
            }
        }
        if (iMax == -1) {
            return -1.0f;
        }
        return iMax * f3;
    }

    @Override // com.applovin.impl.kd
    protected List a(ld ldVar, e9 e9Var, boolean z2) {
        jd jdVarA;
        String str = e9Var.f59394m;
        if (str == null) {
            return Collections.EMPTY_LIST;
        }
        if (this.L0.a(e9Var) && (jdVarA = md.a()) != null) {
            return Collections.singletonList(jdVarA);
        }
        List listA = md.a(ldVar.a(str, z2, false), e9Var);
        if ("audio/eac3-joc".equals(str)) {
            ArrayList arrayList = new ArrayList(listA);
            arrayList.addAll(ldVar.a("audio/eac3", z2, false));
            listA = arrayList;
        }
        return Collections.unmodifiableList(listA);
    }

    @Override // com.applovin.impl.e2, com.applovin.impl.qi
    public fd l() {
        return this;
    }

    @Override // com.applovin.impl.kd
    protected gd.a a(jd jdVar, e9 e9Var, MediaCrypto mediaCrypto, float f3) {
        this.M0 = a(jdVar, e9Var, t());
        this.N0 = h(jdVar.f60691a);
        MediaFormat mediaFormatA = a(e9Var, jdVar.f60693c, this.M0, f3);
        this.O0 = (!"audio/raw".equals(jdVar.f60692b) || "audio/raw".equals(e9Var.f59394m)) ? null : e9Var;
        return gd.a.a(jdVar, mediaFormatA, e9Var, mediaCrypto);
    }

    @Override // com.applovin.impl.fd
    public ph a() {
        return this.L0.a();
    }

    @Override // com.applovin.impl.e2, com.applovin.impl.rh.b
    public void a(int i3, Object obj) {
        if (i3 == 2) {
            this.L0.a(((Float) obj).floatValue());
            return;
        }
        if (i3 == 3) {
            this.L0.a((l1) obj);
            return;
        }
        if (i3 != 6) {
            switch (i3) {
                case 9:
                    this.L0.b(((Boolean) obj).booleanValue());
                    break;
                case 10:
                    this.L0.a(((Integer) obj).intValue());
                    break;
                case 11:
                    this.U0 = (qi.a) obj;
                    break;
                default:
                    super.a(i3, obj);
                    break;
            }
            return;
        }
        this.L0.a((v1) obj);
    }

    @Override // com.applovin.impl.kd
    protected void a(Exception exc) {
        oc.a("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.K0.a(exc);
    }

    @Override // com.applovin.impl.kd
    protected void a(String str, long j3, long j4) {
        this.K0.a(str, j3, j4);
    }

    @Override // com.applovin.impl.kd, com.applovin.impl.e2
    protected void a(boolean z2, boolean z3) {
        super.a(z2, z3);
        this.K0.b(this.E0);
        if (q().f63719a) {
            this.L0.e();
        } else {
            this.L0.d();
        }
    }

    @Override // com.applovin.impl.kd
    protected p5 a(f9 f9Var) throws z7 {
        p5 p5VarA = super.a(f9Var);
        this.K0.a(f9Var.f59641b, p5VarA);
        return p5VarA;
    }

    @Override // com.applovin.impl.kd
    protected void a(e9 e9Var, MediaFormat mediaFormat) throws z7 {
        int iD;
        int i3;
        e9 e9Var2 = this.O0;
        int[] iArr = null;
        if (e9Var2 != null) {
            e9Var = e9Var2;
        } else if (I() != null) {
            if ("audio/raw".equals(e9Var.f59394m)) {
                iD = e9Var.B;
            } else if (xp.f65027a >= 24 && mediaFormat.containsKey("pcm-encoding")) {
                iD = mediaFormat.getInteger("pcm-encoding");
            } else if (mediaFormat.containsKey("v-bits-per-sample")) {
                iD = xp.d(mediaFormat.getInteger("v-bits-per-sample"));
            } else {
                iD = "audio/raw".equals(e9Var.f59394m) ? e9Var.B : 2;
            }
            e9 e9VarA = new e9.b().f("audio/raw").j(iD).e(e9Var.C).f(e9Var.D).c(mediaFormat.getInteger("channel-count")).n(mediaFormat.getInteger("sample-rate")).a();
            if (this.N0 && e9VarA.f59407z == 6 && (i3 = e9Var.f59407z) < 6) {
                iArr = new int[i3];
                for (int i4 = 0; i4 < e9Var.f59407z; i4++) {
                    iArr[i4] = i4;
                }
            }
            e9Var = e9VarA;
        }
        try {
            this.L0.a(e9Var, 0, iArr);
        } catch (r1.a e3) {
            throw a(e3, e3.f62706a, 5001);
        }
    }

    @Override // com.applovin.impl.kd, com.applovin.impl.e2
    protected void a(long j3, boolean z2) throws z7 {
        super.a(j3, z2);
        if (this.T0) {
            this.L0.h();
        } else {
            this.L0.b();
        }
        this.P0 = j3;
        this.Q0 = true;
        this.R0 = true;
    }

    @Override // com.applovin.impl.kd
    protected boolean a(long j3, long j4, gd gdVar, ByteBuffer byteBuffer, int i3, int i4, int i5, long j5, boolean z2, boolean z3, e9 e9Var) throws z7 {
        b1.a(byteBuffer);
        if (this.O0 != null && (i4 & 2) != 0) {
            ((gd) b1.a(gdVar)).a(i3, false);
            return true;
        }
        if (z2) {
            if (gdVar != null) {
                gdVar.a(i3, false);
            }
            this.E0.f61373f += i5;
            this.L0.i();
            return true;
        }
        try {
            if (!this.L0.a(byteBuffer, j5, i5)) {
                return false;
            }
            if (gdVar != null) {
                gdVar.a(i3, false);
            }
            this.E0.f61372e += i5;
            return true;
        } catch (r1.b e3) {
            throw a(e3, e3.f62709c, e3.f62708b, 5001);
        } catch (r1.e e4) {
            throw a(e4, e9Var, e4.f62713b, 5002);
        }
    }

    @Override // com.applovin.impl.fd
    public void a(ph phVar) {
        this.L0.a(phVar);
    }

    @Override // com.applovin.impl.kd
    protected int a(ld ldVar, e9 e9Var) {
        if (!hf.g(e9Var.f59394m)) {
            return ri.a(0);
        }
        int i3 = xp.f65027a >= 21 ? 32 : 0;
        boolean z2 = e9Var.F != 0;
        boolean zD = kd.d(e9Var);
        int i4 = 8;
        if (zD && this.L0.a(e9Var) && (!z2 || md.a() != null)) {
            return ri.a(4, 8, i3);
        }
        if ("audio/raw".equals(e9Var.f59394m) && !this.L0.a(e9Var)) {
            return ri.a(1);
        }
        if (!this.L0.a(xp.b(2, e9Var.f59407z, e9Var.A))) {
            return ri.a(1);
        }
        List listA = a(ldVar, e9Var, false);
        if (listA.isEmpty()) {
            return ri.a(1);
        }
        if (!zD) {
            return ri.a(2);
        }
        jd jdVar = (jd) listA.get(0);
        boolean zB = jdVar.b(e9Var);
        if (zB && jdVar.c(e9Var)) {
            i4 = 16;
        }
        return ri.a(zB ? 4 : 3, i4, i3);
    }

    protected MediaFormat a(e9 e9Var, String str, int i3, float f3) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("channel-count", e9Var.f59407z);
        mediaFormat.setInteger("sample-rate", e9Var.A);
        rd.a(mediaFormat, e9Var.f59396o);
        rd.a(mediaFormat, "max-input-size", i3);
        int i4 = xp.f65027a;
        if (i4 >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f3 != -1.0f && !c0()) {
                mediaFormat.setFloat("operating-rate", f3);
            }
        }
        if (i4 <= 28 && "audio/ac4".equals(e9Var.f59394m)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        if (i4 >= 24 && this.L0.b(xp.b(4, e9Var.f59407z, e9Var.A)) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        return mediaFormat;
    }
}
