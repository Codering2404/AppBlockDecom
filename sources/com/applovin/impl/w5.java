package com.applovin.impl;

import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.applovin.impl.lc;
import com.applovin.impl.y6;
import com.applovin.impl.y7;
import com.applovin.impl.z6;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class w5 implements y6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f64575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final y7 f64576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f64577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f64578d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f64579e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f64580f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f64581g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final HashMap f64582h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final t4 f64583i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final lc f64584j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final pd f64585k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final UUID f64586l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final e f64587m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f64588n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f64589o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private HandlerThread f64590p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private c f64591q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private y4 f64592r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private y6.a f64593s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private byte[] f64594t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private byte[] f64595u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private y7.a f64596v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private y7.d f64597w;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface a {
        void a();

        void a(w5 w5Var);

        void a(Exception exc, boolean z2);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface b {
        void a(w5 w5Var, int i3);

        void b(w5 w5Var, int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f64600a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f64601b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f64602c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f64603d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f64604e;

        public d(long j3, boolean z2, long j4, Object obj) {
            this.f64600a = j3;
            this.f64601b = z2;
            this.f64602c = j4;
            this.f64603d = obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class e extends Handler {
        public e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Pair pair = (Pair) message.obj;
            Object obj = pair.first;
            Object obj2 = pair.second;
            int i3 = message.what;
            if (i3 == 0) {
                w5.this.b(obj, obj2);
            } else {
                if (i3 != 1) {
                    return;
                }
                w5.this.a(obj, obj2);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class f extends IOException {
        public f(Throwable th) {
            super(th);
        }
    }

    public w5(UUID uuid, y7 y7Var, a aVar, b bVar, List list, int i3, boolean z2, boolean z3, byte[] bArr, HashMap map, pd pdVar, Looper looper, lc lcVar) {
        if (i3 == 1 || i3 == 3) {
            b1.a(bArr);
        }
        this.f64586l = uuid;
        this.f64577c = aVar;
        this.f64578d = bVar;
        this.f64576b = y7Var;
        this.f64579e = i3;
        this.f64580f = z2;
        this.f64581g = z3;
        if (bArr != null) {
            this.f64595u = bArr;
            this.f64575a = null;
        } else {
            this.f64575a = Collections.unmodifiableList((List) b1.a(list));
        }
        this.f64582h = map;
        this.f64585k = pdVar;
        this.f64583i = new t4();
        this.f64584j = lcVar;
        this.f64588n = 2;
        this.f64587m = new e(looper);
    }

    private boolean g() {
        int i3 = this.f64588n;
        return i3 == 3 || i3 == 4;
    }

    private void h() {
        if (this.f64579e == 0 && this.f64588n == 4) {
            xp.a((Object) this.f64594t);
            a(false);
        }
    }

    private boolean j() {
        if (g()) {
            return true;
        }
        try {
            byte[] bArrD = this.f64576b.d();
            this.f64594t = bArrD;
            this.f64592r = this.f64576b.d(bArrD);
            final int i3 = 3;
            this.f64588n = 3;
            a(new q4() { // from class: com.applovin.impl.h70
                @Override // com.applovin.impl.q4
                public final void accept(Object obj) {
                    ((z6.a) obj).a(i3);
                }
            });
            b1.a(this.f64594t);
            return true;
        } catch (NotProvisionedException unused) {
            this.f64577c.a(this);
            return false;
        } catch (Exception e3) {
            a(e3, 1);
            return false;
        }
    }

    private boolean l() {
        try {
            this.f64576b.a(this.f64594t, this.f64595u);
            return true;
        } catch (Exception e3) {
            a(e3, 1);
            return false;
        }
    }

    @Override // com.applovin.impl.y6
    public Map d() {
        byte[] bArr = this.f64594t;
        if (bArr == null) {
            return null;
        }
        return this.f64576b.b(bArr);
    }

    @Override // com.applovin.impl.y6
    public final UUID e() {
        return this.f64586l;
    }

    @Override // com.applovin.impl.y6
    public final y4 f() {
        return this.f64592r;
    }

    @Override // com.applovin.impl.y6
    public final y6.a getError() {
        if (this.f64588n == 1) {
            return this.f64593s;
        }
        return null;
    }

    public void i() {
        if (j()) {
            a(true);
        }
    }

    public void k() {
        this.f64597w = this.f64576b.b();
        ((c) xp.a(this.f64591q)).a(0, b1.a(this.f64597w), true);
    }

    @Override // com.applovin.impl.y6
    public boolean c() {
        return this.f64580f;
    }

    private void a(q4 q4Var) {
        Iterator it = this.f64583i.a().iterator();
        while (it.hasNext()) {
            q4Var.accept((z6.a) it.next());
        }
    }

    @Override // com.applovin.impl.y6
    public void b(z6.a aVar) {
        b1.b(this.f64589o >= 0);
        if (aVar != null) {
            this.f64583i.a(aVar);
        }
        int i3 = this.f64589o + 1;
        this.f64589o = i3;
        if (i3 == 1) {
            b1.b(this.f64588n == 2);
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.f64590p = handlerThread;
            handlerThread.start();
            this.f64591q = new c(this.f64590p.getLooper());
            if (j()) {
                a(true);
            }
        } else if (aVar != null && g() && this.f64583i.b(aVar) == 1) {
            aVar.a(this.f64588n);
        }
        this.f64578d.a(this, this.f64589o);
    }

    private void a(boolean z2) {
        if (this.f64581g) {
            return;
        }
        byte[] bArr = (byte[]) xp.a((Object) this.f64594t);
        int i3 = this.f64579e;
        if (i3 != 0 && i3 != 1) {
            if (i3 == 2) {
                if (this.f64595u == null || l()) {
                    a(bArr, 2, z2);
                    return;
                }
                return;
            }
            if (i3 != 3) {
                return;
            }
            b1.a(this.f64595u);
            b1.a(this.f64594t);
            a(this.f64595u, 3, z2);
            return;
        }
        if (this.f64595u == null) {
            a(bArr, 1, z2);
            return;
        }
        if (this.f64588n == 4 || l()) {
            long jA = a();
            if (this.f64579e != 0 || jA > 60) {
                if (jA <= 0) {
                    a(new yb(), 2);
                    return;
                } else {
                    this.f64588n = 4;
                    a(new q4() { // from class: com.applovin.impl.d70
                        @Override // com.applovin.impl.q4
                        public final void accept(Object obj) {
                            ((z6.a) obj).c();
                        }
                    });
                    return;
                }
            }
            oc.a("DefaultDrmSession", "Offline license has expired or will expire soon. Remaining seconds: " + jA);
            a(bArr, 2, z2);
        }
    }

    @Override // com.applovin.impl.y6
    public final int b() {
        return this.f64588n;
    }

    public void b(Exception exc, boolean z2) {
        a(exc, z2 ? 1 : 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Object obj, Object obj2) {
        if (obj == this.f64597w) {
            if (this.f64588n == 2 || g()) {
                this.f64597w = null;
                if (obj2 instanceof Exception) {
                    this.f64577c.a((Exception) obj2, false);
                    return;
                }
                try {
                    this.f64576b.a((byte[]) obj2);
                    this.f64577c.a();
                } catch (Exception e3) {
                    this.f64577c.a(e3, true);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f64598a;

        public c(Looper looper) {
            super(looper);
        }

        private boolean a(Message message, qd qdVar) {
            d dVar = (d) message.obj;
            if (!dVar.f64601b) {
                return false;
            }
            int i3 = dVar.f64604e + 1;
            dVar.f64604e = i3;
            if (i3 > w5.this.f64584j.a(3)) {
                return false;
            }
            long jA = w5.this.f64584j.a(new lc.a(new mc(dVar.f64600a, qdVar.f62605a, qdVar.f62606b, qdVar.f62607c, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime() - dVar.f64602c, qdVar.f62608d), new td(3), qdVar.getCause() instanceof IOException ? (IOException) qdVar.getCause() : new f(qdVar.getCause()), dVar.f64604e));
            if (jA == -9223372036854775807L) {
                return false;
            }
            synchronized (this) {
                try {
                    if (this.f64598a) {
                        return false;
                    }
                    sendMessageDelayed(Message.obtain(message), jA);
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object objA;
            d dVar = (d) message.obj;
            try {
                int i3 = message.what;
                if (i3 == 0) {
                    w5 w5Var = w5.this;
                    objA = w5Var.f64585k.a(w5Var.f64586l, (y7.d) dVar.f64603d);
                } else {
                    if (i3 != 1) {
                        throw new RuntimeException();
                    }
                    w5 w5Var2 = w5.this;
                    objA = w5Var2.f64585k.a(w5Var2.f64586l, (y7.a) dVar.f64603d);
                }
            } catch (qd e3) {
                boolean zA = a(message, e3);
                objA = e3;
                if (zA) {
                    return;
                }
            } catch (Exception e4) {
                oc.c("DefaultDrmSession", "Key/provisioning request produced an unexpected exception. Not retrying.", e4);
                objA = e4;
            }
            w5.this.f64584j.a(dVar.f64600a);
            synchronized (this) {
                try {
                    if (!this.f64598a) {
                        w5.this.f64587m.obtainMessage(message.what, Pair.create(dVar.f64603d, objA)).sendToTarget();
                    }
                } finally {
                }
            }
        }

        void a(int i3, Object obj, boolean z2) {
            obtainMessage(i3, new d(mc.a(), z2, SystemClock.elapsedRealtime(), obj)).sendToTarget();
        }

        public synchronized void a() {
            removeCallbacksAndMessages(null);
            this.f64598a = true;
        }
    }

    public boolean a(byte[] bArr) {
        return Arrays.equals(this.f64594t, bArr);
    }

    private void a(final Exception exc, int i3) {
        this.f64593s = new y6.a(exc, c7.a(exc, i3));
        oc.a("DefaultDrmSession", "DRM session error", exc);
        a(new q4() { // from class: com.applovin.impl.e70
            @Override // com.applovin.impl.q4
            public final void accept(Object obj) {
                ((z6.a) obj).a(exc);
            }
        });
        if (this.f64588n != 4) {
            this.f64588n = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Object obj, Object obj2) {
        if (obj == this.f64596v && g()) {
            this.f64596v = null;
            if (obj2 instanceof Exception) {
                a((Exception) obj2, false);
                return;
            }
            try {
                byte[] bArr = (byte[]) obj2;
                if (this.f64579e == 3) {
                    this.f64576b.b((byte[]) xp.a((Object) this.f64595u), bArr);
                    a(new q4() { // from class: com.applovin.impl.f70
                        @Override // com.applovin.impl.q4
                        public final void accept(Object obj3) {
                            ((z6.a) obj3).b();
                        }
                    });
                    return;
                }
                byte[] bArrB = this.f64576b.b(this.f64594t, bArr);
                int i3 = this.f64579e;
                if ((i3 == 2 || (i3 == 0 && this.f64595u != null)) && bArrB != null && bArrB.length != 0) {
                    this.f64595u = bArrB;
                }
                this.f64588n = 4;
                a(new q4() { // from class: com.applovin.impl.g70
                    @Override // com.applovin.impl.q4
                    public final void accept(Object obj3) {
                        ((z6.a) obj3).a();
                    }
                });
            } catch (Exception e3) {
                a(e3, true);
            }
        }
    }

    private void a(Exception exc, boolean z2) {
        if (exc instanceof NotProvisionedException) {
            this.f64577c.a(this);
        } else {
            a(exc, z2 ? 1 : 2);
        }
    }

    public void a(int i3) {
        if (i3 != 2) {
            return;
        }
        h();
    }

    private void a(byte[] bArr, int i3, boolean z2) {
        try {
            this.f64596v = this.f64576b.a(bArr, this.f64575a, i3, this.f64582h);
            ((c) xp.a(this.f64591q)).a(1, b1.a(this.f64596v), z2);
        } catch (Exception e3) {
            a(e3, true);
        }
    }

    @Override // com.applovin.impl.y6
    public void a(z6.a aVar) {
        b1.b(this.f64589o > 0);
        int i3 = this.f64589o - 1;
        this.f64589o = i3;
        if (i3 == 0) {
            this.f64588n = 0;
            ((e) xp.a(this.f64587m)).removeCallbacksAndMessages(null);
            ((c) xp.a(this.f64591q)).a();
            this.f64591q = null;
            ((HandlerThread) xp.a(this.f64590p)).quit();
            this.f64590p = null;
            this.f64592r = null;
            this.f64593s = null;
            this.f64596v = null;
            this.f64597w = null;
            byte[] bArr = this.f64594t;
            if (bArr != null) {
                this.f64576b.c(bArr);
                this.f64594t = null;
            }
        }
        if (aVar != null) {
            this.f64583i.c(aVar);
            if (this.f64583i.b(aVar) == 0) {
                aVar.d();
            }
        }
        this.f64578d.b(this, this.f64589o);
    }

    @Override // com.applovin.impl.y6
    public boolean a(String str) {
        return this.f64576b.a((byte[]) b1.b(this.f64594t), str);
    }

    private long a() {
        if (!t2.f63863d.equals(this.f64586l)) {
            return Long.MAX_VALUE;
        }
        Pair pair = (Pair) b1.a(bs.a(this));
        return Math.min(((Long) pair.first).longValue(), ((Long) pair.second).longValue());
    }
}
