package com.applovin.impl;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.AudioTrack;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.applovin.impl.d6;
import com.applovin.impl.il;
import com.applovin.impl.m1;
import com.applovin.impl.o1;
import com.applovin.impl.qh;
import com.applovin.impl.rh;
import com.applovin.impl.rk;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ck extends d2 implements qh {
    private int A;
    private int B;
    private m5 C;
    private m5 D;
    private int E;
    private l1 F;
    private float G;
    private boolean H;
    private List I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private q6 N;
    private xq O;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final qi[] f58917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c4 f58918c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f58919d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b8 f58920e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final c f58921f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final d f58922g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final CopyOnWriteArraySet f58923h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final r0 f58924i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final m1 f58925j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final o1 f58926k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final il f58927l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final gr f58928m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final cs f58929n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final long f58930o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private e9 f58931p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private e9 f58932q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private AudioTrack f58933r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Object f58934s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Surface f58935t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private SurfaceHolder f58936u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private rk f58937v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f58938w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private TextureView f58939x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f58940y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f58941z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f58942a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ti f58943b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private l3 f58944c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f58945d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private vo f58946e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private ce f58947f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private kc f58948g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private y1 f58949h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private r0 f58950i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private Looper f58951j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private l1 f58952k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f58953l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f58954m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private boolean f58955n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private boolean f58956o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f58957p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f58958q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private boolean f58959r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private jj f58960s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private long f58961t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private long f58962u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private jc f58963v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private long f58964w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private long f58965x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private boolean f58966y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private boolean f58967z;

        public b(Context context) {
            this(context, new j6(context), new b6());
        }

        static /* synthetic */ uh m(b bVar) {
            bVar.getClass();
            return null;
        }

        public b(Context context, ti tiVar, n8 n8Var) {
            this(context, tiVar, new l6(context), new h6(context, n8Var), new e6(), s5.a(context), new r0(l3.f61106a));
        }

        public ck a() {
            b1.b(!this.f58967z);
            this.f58967z = true;
            return new ck(this);
        }

        public b(Context context, ti tiVar, vo voVar, ce ceVar, kc kcVar, y1 y1Var, r0 r0Var) {
            this.f58942a = context;
            this.f58943b = tiVar;
            this.f58946e = voVar;
            this.f58947f = ceVar;
            this.f58948g = kcVar;
            this.f58949h = y1Var;
            this.f58950i = r0Var;
            this.f58951j = xp.d();
            this.f58952k = l1.f61090g;
            this.f58954m = 0;
            this.f58957p = 1;
            this.f58958q = 0;
            this.f58959r = true;
            this.f58960s = jj.f60765g;
            this.f58961t = 5000L;
            this.f58962u = 15000L;
            this.f58963v = new d6.b().a();
            this.f58944c = l3.f61106a;
            this.f58964w = 500L;
            this.f58965x = 2000L;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class c implements wq, q1, ao, ef, SurfaceHolder.Callback, TextureView.SurfaceTextureListener, rk.b, o1.b, m1.b, il.b, qh.c, a8 {
        private c() {
        }

        @Override // com.applovin.impl.q1
        public void a(String str, long j3, long j4) {
            ck.this.f58924i.a(str, j3, j4);
        }

        @Override // com.applovin.impl.q1
        public void b(String str) {
            ck.this.f58924i.b(str);
        }

        @Override // com.applovin.impl.m1.b
        public void c() {
            ck.this.a(false, -1, 3);
        }

        @Override // com.applovin.impl.il.b
        public void d(int i3) {
            q6 q6VarB = ck.b(ck.this.f58927l);
            if (q6VarB.equals(ck.this.N)) {
                return;
            }
            ck.this.N = q6VarB;
            Iterator it = ck.this.f58923h.iterator();
            while (it.hasNext()) {
                ((qh.e) it.next()).a(q6VarB);
            }
        }

        @Override // com.applovin.impl.o1.b
        public void f(int i3) {
            boolean zL = ck.this.l();
            ck.this.a(zL, i3, ck.b(zL, i3));
        }

        @Override // com.applovin.impl.a8
        public void g(boolean z2) {
            ck.this.Y();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i4) {
            ck.this.a(surfaceTexture);
            ck.this.a(i3, i4);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            ck.this.a((Object) null);
            ck.this.a(0, 0);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i4) {
            ck.this.a(i3, i4);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i4, int i5) {
            ck.this.a(i4, i5);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (ck.this.f58938w) {
                ck.this.a(surfaceHolder.getSurface());
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (ck.this.f58938w) {
                ck.this.a((Object) null);
            }
            ck.this.a(0, 0);
        }

        @Override // com.applovin.impl.q1
        public void a(m5 m5Var) {
            ck.this.D = m5Var;
            ck.this.f58924i.a(m5Var);
        }

        @Override // com.applovin.impl.q1
        public void b(e9 e9Var, p5 p5Var) {
            ck.this.f58932q = e9Var;
            ck.this.f58924i.b(e9Var, p5Var);
        }

        @Override // com.applovin.impl.q1
        public void c(Exception exc) {
            ck.this.f58924i.c(exc);
        }

        @Override // com.applovin.impl.q1
        public void c(m5 m5Var) {
            ck.this.f58924i.c(m5Var);
            ck.this.f58932q = null;
            ck.this.D = null;
        }

        @Override // com.applovin.impl.q1
        public void a(long j3) {
            ck.this.f58924i.a(j3);
        }

        @Override // com.applovin.impl.q1
        public void b(int i3, long j3, long j4) {
            ck.this.f58924i.b(i3, j3, j4);
        }

        @Override // com.applovin.impl.q1
        public void a(Exception exc) {
            ck.this.f58924i.a(exc);
        }

        @Override // com.applovin.impl.qh.c
        public void b(int i3) {
            ck.this.Y();
        }

        @Override // com.applovin.impl.ao
        public void a(List list) {
            ck.this.I = list;
            Iterator it = ck.this.f58923h.iterator();
            while (it.hasNext()) {
                ((qh.e) it.next()).a(list);
            }
        }

        @Override // com.applovin.impl.wq
        public void b(Exception exc) {
            ck.this.f58924i.b(exc);
        }

        @Override // com.applovin.impl.qh.c
        public void c(boolean z2) {
            ck.k(ck.this);
        }

        @Override // com.applovin.impl.wq
        public void d(m5 m5Var) {
            ck.this.C = m5Var;
            ck.this.f58924i.d(m5Var);
        }

        @Override // com.applovin.impl.wq
        public void b(String str, long j3, long j4) {
            ck.this.f58924i.b(str, j3, j4);
        }

        @Override // com.applovin.impl.wq
        public void b(m5 m5Var) {
            ck.this.f58924i.b(m5Var);
            ck.this.f58931p = null;
            ck.this.C = null;
        }

        @Override // com.applovin.impl.wq
        public void a(int i3, long j3) {
            ck.this.f58924i.a(i3, j3);
        }

        @Override // com.applovin.impl.ef
        public void a(af afVar) {
            ck.this.f58924i.a(afVar);
            ck.this.f58920e.a(afVar);
            Iterator it = ck.this.f58923h.iterator();
            while (it.hasNext()) {
                ((qh.e) it.next()).a(afVar);
            }
        }

        @Override // com.applovin.impl.rk.b
        public void b(Surface surface) {
            ck.this.a(surface);
        }

        @Override // com.applovin.impl.o1.b
        public void b(float f3) {
            ck.this.X();
        }

        @Override // com.applovin.impl.qh.c
        public void a(boolean z2, int i3) {
            ck.this.Y();
        }

        @Override // com.applovin.impl.wq
        public void a(Object obj, long j3) {
            ck.this.f58924i.a(obj, j3);
            if (ck.this.f58934s == obj) {
                Iterator it = ck.this.f58923h.iterator();
                while (it.hasNext()) {
                    ((qh.e) it.next()).a();
                }
            }
        }

        @Override // com.applovin.impl.q1
        public void a(boolean z2) {
            if (ck.this.H == z2) {
                return;
            }
            ck.this.H = z2;
            ck.this.U();
        }

        @Override // com.applovin.impl.il.b
        public void a(int i3, boolean z2) {
            Iterator it = ck.this.f58923h.iterator();
            while (it.hasNext()) {
                ((qh.e) it.next()).b(i3, z2);
            }
        }

        @Override // com.applovin.impl.wq
        public void a(String str) {
            ck.this.f58924i.a(str);
        }

        @Override // com.applovin.impl.wq
        public void a(long j3, int i3) {
            ck.this.f58924i.a(j3, i3);
        }

        @Override // com.applovin.impl.wq
        public void a(e9 e9Var, p5 p5Var) {
            ck.this.f58931p = e9Var;
            ck.this.f58924i.a(e9Var, p5Var);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // com.applovin.impl.wq
        public void a(xq xqVar) {
            ck.this.O = xqVar;
            ck.this.f58924i.a(xqVar);
            Iterator it = ck.this.f58923h.iterator();
            while (it.hasNext()) {
                ((qh.e) it.next()).a(xqVar);
            }
        }

        @Override // com.applovin.impl.rk.b
        public void a(Surface surface) {
            ck.this.a((Object) null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.applovin.impl.ck, com.applovin.impl.d2] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.applovin.impl.ck] */
    protected ck(b bVar) throws Throwable {
        ck ckVar;
        ?? d2Var = new d2();
        c4 c4Var = new c4();
        d2Var.f58918c = c4Var;
        try {
            Context applicationContext = bVar.f58942a.getApplicationContext();
            d2Var.f58919d = applicationContext;
            r0 r0Var = bVar.f58950i;
            d2Var.f58924i = r0Var;
            b.m(bVar);
            d2Var.F = bVar.f58952k;
            d2Var.f58940y = bVar.f58957p;
            d2Var.f58941z = bVar.f58958q;
            d2Var.H = bVar.f58956o;
            d2Var.f58930o = bVar.f58965x;
            c cVar = new c();
            d2Var.f58921f = cVar;
            d dVar = new d();
            d2Var.f58922g = dVar;
            d2Var.f58923h = new CopyOnWriteArraySet();
            Handler handler = new Handler(bVar.f58951j);
            qi[] qiVarArrA = bVar.f58943b.a(handler, cVar, cVar, cVar, cVar);
            d2Var.f58917b = qiVarArrA;
            d2Var.G = 1.0f;
            if (xp.f65027a < 21) {
                d2Var.E = d2Var.d(0);
            } else {
                d2Var.E = t2.a(applicationContext);
            }
            d2Var.I = Collections.EMPTY_LIST;
            d2Var.J = true;
            try {
                try {
                    b8 b8Var = new b8(qiVarArrA, bVar.f58946e, bVar.f58947f, bVar.f58948g, bVar.f58949h, r0Var, bVar.f58959r, bVar.f58960s, bVar.f58961t, bVar.f58962u, bVar.f58963v, bVar.f58964w, bVar.f58966y, bVar.f58944c, bVar.f58951j, this, new qh.b.a().a(20, 21, 22, 23, 24, 25, 26, 27).a());
                    d2Var = this;
                    d2Var.f58920e = b8Var;
                    b8Var.a((qh.c) cVar);
                    b8Var.a((a8) cVar);
                    if (bVar.f58945d > 0) {
                        b8Var.c(bVar.f58945d);
                    }
                    m1 m1Var = new m1(bVar.f58942a, handler, cVar);
                    d2Var.f58925j = m1Var;
                    m1Var.a(bVar.f58955n);
                    o1 o1Var = new o1(bVar.f58942a, handler, cVar);
                    d2Var.f58926k = o1Var;
                    o1Var.b(bVar.f58953l ? d2Var.F : null);
                    il ilVar = new il(bVar.f58942a, handler, cVar);
                    d2Var.f58927l = ilVar;
                    ilVar.a(xp.e(d2Var.F.f61094c));
                    gr grVar = new gr(bVar.f58942a);
                    d2Var.f58928m = grVar;
                    grVar.a(bVar.f58954m != 0);
                    cs csVar = new cs(bVar.f58942a);
                    d2Var.f58929n = csVar;
                    csVar.a(bVar.f58954m == 2);
                    d2Var.N = b(ilVar);
                    d2Var.O = xq.f65042f;
                    d2Var.a(1, 10, Integer.valueOf(d2Var.E));
                    d2Var.a(2, 10, Integer.valueOf(d2Var.E));
                    d2Var.a(1, 3, d2Var.F);
                    d2Var.a(2, 4, Integer.valueOf(d2Var.f58940y));
                    d2Var.a(2, 5, Integer.valueOf(d2Var.f58941z));
                    d2Var.a(1, 9, Boolean.valueOf(d2Var.H));
                    d2Var.a(2, 7, dVar);
                    d2Var.a(6, 8, dVar);
                    c4Var.e();
                } catch (Throwable th) {
                    th = th;
                    ckVar = this;
                    ckVar.f58918c.e();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                ckVar = this;
            }
        } catch (Throwable th3) {
            th = th3;
            ckVar = d2Var;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        this.f58924i.a(this.H);
        Iterator it = this.f58923h.iterator();
        while (it.hasNext()) {
            ((qh.e) it.next()).a(this.H);
        }
    }

    private void W() {
        if (this.f58937v != null) {
            this.f58920e.a(this.f58922g).a(ColorExtractionConstants.MAX_PIXEL_SAMPLES).a((Object) null).j();
            this.f58937v.b(this.f58921f);
            this.f58937v = null;
        }
        TextureView textureView = this.f58939x;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.f58921f) {
                oc.d("SimpleExoPlayer", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.f58939x.setSurfaceTextureListener(null);
            }
            this.f58939x = null;
        }
        SurfaceHolder surfaceHolder = this.f58936u;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.f58921f);
            this.f58936u = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        a(1, 2, Float.valueOf(this.G * this.f58926k.d()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        int iO = o();
        boolean z2 = false;
        if (iO != 1) {
            if (iO == 2 || iO == 3) {
                boolean zS = S();
                gr grVar = this.f58928m;
                if (l() && !zS) {
                    z2 = true;
                }
                grVar.b(z2);
                this.f58929n.b(l());
                return;
            }
            if (iO != 4) {
                throw new IllegalStateException();
            }
        }
        this.f58928m.b(false);
        this.f58929n.b(false);
    }

    private void Z() {
        this.f58918c.b();
        if (Thread.currentThread() != p().getThread()) {
            String strA = xp.a("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://exoplayer.dev/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), p().getThread().getName());
            if (this.J) {
                throw new IllegalStateException(strA);
            }
            oc.c("SimpleExoPlayer", strA, this.K ? null : new IllegalStateException());
            this.K = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(boolean z2, int i3) {
        return (!z2 || i3 == 1) ? 1 : 2;
    }

    static /* synthetic */ uh k(ck ckVar) {
        ckVar.getClass();
        return null;
    }

    @Override // com.applovin.impl.qh
    public to A() {
        Z();
        return this.f58920e.A();
    }

    @Override // com.applovin.impl.qh
    public ud C() {
        return this.f58920e.C();
    }

    @Override // com.applovin.impl.qh
    public int E() {
        Z();
        return this.f58920e.E();
    }

    @Override // com.applovin.impl.qh
    public long F() {
        Z();
        return this.f58920e.F();
    }

    public void R() {
        Z();
        W();
        a((Object) null);
        a(0, 0);
    }

    public boolean S() {
        Z();
        return this.f58920e.S();
    }

    @Override // com.applovin.impl.qh
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public z7 c() {
        Z();
        return this.f58920e.c();
    }

    public void V() {
        AudioTrack audioTrack;
        Z();
        if (xp.f65027a < 21 && (audioTrack = this.f58933r) != null) {
            audioTrack.release();
            this.f58933r = null;
        }
        this.f58925j.a(false);
        this.f58927l.c();
        this.f58928m.b(false);
        this.f58929n.b(false);
        this.f58926k.e();
        this.f58920e.W();
        this.f58924i.i();
        W();
        Surface surface = this.f58935t;
        if (surface != null) {
            surface.release();
            this.f58935t = null;
        }
        if (this.L) {
            c8.a(b1.a((Object) null));
            throw null;
        }
        this.I = Collections.EMPTY_LIST;
        this.M = true;
    }

    @Override // com.applovin.impl.qh
    public long getCurrentPosition() {
        Z();
        return this.f58920e.getCurrentPosition();
    }

    @Override // com.applovin.impl.qh
    public long getDuration() {
        Z();
        return this.f58920e.getDuration();
    }

    @Override // com.applovin.impl.qh
    public int m() {
        Z();
        return this.f58920e.m();
    }

    @Override // com.applovin.impl.qh
    public fo n() {
        Z();
        return this.f58920e.n();
    }

    @Override // com.applovin.impl.qh
    public int o() {
        Z();
        return this.f58920e.o();
    }

    @Override // com.applovin.impl.qh
    public Looper p() {
        return this.f58920e.p();
    }

    @Override // com.applovin.impl.qh
    public long q() {
        Z();
        return this.f58920e.q();
    }

    @Override // com.applovin.impl.qh
    public boolean r() {
        Z();
        return this.f58920e.r();
    }

    @Override // com.applovin.impl.qh
    public long s() {
        Z();
        return this.f58920e.s();
    }

    @Override // com.applovin.impl.qh
    public int t() {
        Z();
        return this.f58920e.t();
    }

    @Override // com.applovin.impl.qh
    public int v() {
        Z();
        return this.f58920e.v();
    }

    @Override // com.applovin.impl.qh
    public List x() {
        Z();
        return this.I;
    }

    @Override // com.applovin.impl.qh
    public xq z() {
        return this.O;
    }

    private int d(int i3) {
        AudioTrack audioTrack = this.f58933r;
        if (audioTrack != null && audioTrack.getAudioSessionId() != i3) {
            this.f58933r.release();
            this.f58933r = null;
        }
        if (this.f58933r == null) {
            this.f58933r = new AudioTrack(3, 4000, 4, 2, 2, 0, i3);
        }
        return this.f58933r.getAudioSessionId();
    }

    @Override // com.applovin.impl.qh
    public long e() {
        Z();
        return this.f58920e.e();
    }

    @Override // com.applovin.impl.qh
    public int f() {
        Z();
        return this.f58920e.f();
    }

    @Override // com.applovin.impl.qh
    public long g() {
        Z();
        return this.f58920e.g();
    }

    @Override // com.applovin.impl.qh
    public long h() {
        Z();
        return this.f58920e.h();
    }

    @Override // com.applovin.impl.qh
    public qh.b i() {
        Z();
        return this.f58920e.i();
    }

    @Override // com.applovin.impl.qh
    public int j() {
        Z();
        return this.f58920e.j();
    }

    @Override // com.applovin.impl.qh
    public po k() {
        Z();
        return this.f58920e.k();
    }

    @Override // com.applovin.impl.qh
    public boolean l() {
        Z();
        return this.f58920e.l();
    }

    public void c(SurfaceHolder surfaceHolder) {
        Z();
        if (surfaceHolder == null) {
            R();
            return;
        }
        W();
        this.f58938w = true;
        this.f58936u = surfaceHolder;
        surfaceHolder.addCallback(this.f58921f);
        Surface surface = surfaceHolder.getSurface();
        if (surface != null && surface.isValid()) {
            a(surface);
            Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
            a(surfaceFrame.width(), surfaceFrame.height());
        } else {
            a((Object) null);
            a(0, 0);
        }
    }

    @Override // com.applovin.impl.qh
    public void b(qh.e eVar) {
        b1.a(eVar);
        this.f58923h.add(eVar);
        a((qh.c) eVar);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class d implements uq, v2, rh.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private uq f58969a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private v2 f58970b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private uq f58971c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private v2 f58972d;

        private d() {
        }

        @Override // com.applovin.impl.rh.b
        public void a(int i3, Object obj) {
            if (i3 == 7) {
                this.f58969a = (uq) obj;
                return;
            }
            if (i3 == 8) {
                this.f58970b = (v2) obj;
                return;
            }
            if (i3 != 10000) {
                return;
            }
            rk rkVar = (rk) obj;
            if (rkVar == null) {
                this.f58971c = null;
                this.f58972d = null;
            } else {
                this.f58971c = rkVar.getVideoFrameMetadataListener();
                this.f58972d = rkVar.getCameraMotionListener();
            }
        }

        @Override // com.applovin.impl.v2
        public void a(long j3, float[] fArr) {
            v2 v2Var = this.f58972d;
            if (v2Var != null) {
                v2Var.a(j3, fArr);
            }
            v2 v2Var2 = this.f58970b;
            if (v2Var2 != null) {
                v2Var2.a(j3, fArr);
            }
        }

        @Override // com.applovin.impl.v2
        public void a() {
            v2 v2Var = this.f58972d;
            if (v2Var != null) {
                v2Var.a();
            }
            v2 v2Var2 = this.f58970b;
            if (v2Var2 != null) {
                v2Var2.a();
            }
        }

        @Override // com.applovin.impl.uq
        public void a(long j3, long j4, e9 e9Var, MediaFormat mediaFormat) {
            long j5;
            long j6;
            e9 e9Var2;
            MediaFormat mediaFormat2;
            uq uqVar = this.f58971c;
            if (uqVar != null) {
                uqVar.a(j3, j4, e9Var, mediaFormat);
                mediaFormat2 = mediaFormat;
                e9Var2 = e9Var;
                j6 = j4;
                j5 = j3;
            } else {
                j5 = j3;
                j6 = j4;
                e9Var2 = e9Var;
                mediaFormat2 = mediaFormat;
            }
            uq uqVar2 = this.f58969a;
            if (uqVar2 != null) {
                uqVar2.a(j5, j6, e9Var2, mediaFormat2);
            }
        }
    }

    @Override // com.applovin.impl.qh
    public void b(SurfaceView surfaceView) {
        Z();
        a(surfaceView == null ? null : surfaceView.getHolder());
    }

    @Override // com.applovin.impl.qh
    public boolean d() {
        Z();
        return this.f58920e.d();
    }

    @Override // com.applovin.impl.qh
    public void b(TextureView textureView) {
        Z();
        if (textureView == null || textureView != this.f58939x) {
            return;
        }
        R();
    }

    @Override // com.applovin.impl.qh
    public void b() {
        Z();
        boolean zL = l();
        int iA = this.f58926k.a(zL, 2);
        a(zL, iA, b(zL, iA));
        this.f58920e.b();
    }

    public void a(qh.c cVar) {
        b1.a(cVar);
        this.f58920e.a(cVar);
    }

    public void a(SurfaceHolder surfaceHolder) {
        Z();
        if (surfaceHolder == null || surfaceHolder != this.f58936u) {
            return;
        }
        R();
    }

    @Override // com.applovin.impl.qh
    public ph a() {
        Z();
        return this.f58920e.a();
    }

    public void b(qh.c cVar) {
        this.f58920e.e(cVar);
    }

    private void b(SurfaceHolder surfaceHolder) {
        this.f58938w = false;
        this.f58936u = surfaceHolder;
        surfaceHolder.addCallback(this.f58921f);
        Surface surface = this.f58936u.getSurface();
        if (surface != null && surface.isValid()) {
            Rect surfaceFrame = this.f58936u.getSurfaceFrame();
            a(surfaceFrame.width(), surfaceFrame.height());
        } else {
            a(0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i3, int i4) {
        if (i3 == this.A && i4 == this.B) {
            return;
        }
        this.A = i3;
        this.B = i4;
        this.f58924i.a(i3, i4);
        Iterator it = this.f58923h.iterator();
        while (it.hasNext()) {
            ((qh.e) it.next()).a(i3, i4);
        }
    }

    @Override // com.applovin.impl.qh
    public void a(qh.e eVar) {
        b1.a(eVar);
        this.f58923h.remove(eVar);
        b((qh.c) eVar);
    }

    @Override // com.applovin.impl.qh
    public void b(boolean z2) {
        Z();
        this.f58920e.b(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static q6 b(il ilVar) {
        return new q6(0, ilVar.b(), ilVar.a());
    }

    @Override // com.applovin.impl.qh
    public void a(int i3, long j3) {
        Z();
        this.f58924i.h();
        this.f58920e.a(i3, j3);
    }

    private void a(int i3, int i4, Object obj) {
        for (qi qiVar : this.f58917b) {
            if (qiVar.e() == i3) {
                this.f58920e.a(qiVar).a(i4).a(obj).j();
            }
        }
    }

    public void a(ae aeVar) {
        Z();
        this.f58920e.a(aeVar);
    }

    @Override // com.applovin.impl.qh
    public void a(boolean z2) {
        Z();
        int iA = this.f58926k.a(z2, o());
        a(z2, iA, b(z2, iA));
    }

    @Override // com.applovin.impl.qh
    public void a(int i3) {
        Z();
        this.f58920e.a(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        a(surface);
        this.f58935t = surface;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Object obj) {
        boolean z2;
        ArrayList arrayList = new ArrayList();
        qi[] qiVarArr = this.f58917b;
        int length = qiVarArr.length;
        int i3 = 0;
        while (true) {
            z2 = true;
            if (i3 >= length) {
                break;
            }
            qi qiVar = qiVarArr[i3];
            if (qiVar.e() == 2) {
                arrayList.add(this.f58920e.a(qiVar).a(1).a(obj).j());
            }
            i3++;
        }
        Object obj2 = this.f58934s;
        if (obj2 == null || obj2 == obj) {
            z2 = false;
        } else {
            try {
                int size = arrayList.size();
                int i4 = 0;
                while (i4 < size) {
                    Object obj3 = arrayList.get(i4);
                    i4++;
                    ((rh) obj3).a(this.f58930o);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
            }
            z2 = false;
            Object obj4 = this.f58934s;
            Surface surface = this.f58935t;
            if (obj4 == surface) {
                surface.release();
                this.f58935t = null;
            }
        }
        this.f58934s = obj;
        if (z2) {
            this.f58920e.a(false, z7.a(new f8(3), 1003));
        }
    }

    @Override // com.applovin.impl.qh
    public void a(SurfaceView surfaceView) {
        Z();
        if (surfaceView instanceof tq) {
            W();
            a((Object) surfaceView);
            b(surfaceView.getHolder());
        } else {
            if (surfaceView instanceof rk) {
                W();
                this.f58937v = (rk) surfaceView;
                this.f58920e.a(this.f58922g).a(ColorExtractionConstants.MAX_PIXEL_SAMPLES).a(this.f58937v).j();
                this.f58937v.a(this.f58921f);
                a(this.f58937v.getVideoSurface());
                b(surfaceView.getHolder());
                return;
            }
            c(surfaceView == null ? null : surfaceView.getHolder());
        }
    }

    @Override // com.applovin.impl.qh
    public void a(TextureView textureView) {
        Z();
        if (textureView == null) {
            R();
            return;
        }
        W();
        this.f58939x = textureView;
        if (textureView.getSurfaceTextureListener() != null) {
            oc.d("SimpleExoPlayer", "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.f58921f);
        SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        if (surfaceTexture == null) {
            a((Object) null);
            a(0, 0);
        } else {
            a(surfaceTexture);
            a(textureView.getWidth(), textureView.getHeight());
        }
    }

    public void a(float f3) {
        Z();
        float fA = xp.a(f3, 0.0f, 1.0f);
        if (this.G == fA) {
            return;
        }
        this.G = fA;
        X();
        this.f58924i.a(fA);
        Iterator it = this.f58923h.iterator();
        while (it.hasNext()) {
            ((qh.e) it.next()).a(fA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z2, int i3, int i4) {
        int i5 = 0;
        boolean z3 = z2 && i3 != -1;
        if (z3 && i3 != 1) {
            i5 = 1;
        }
        this.f58920e.a(z3, i5, i4);
    }
}
