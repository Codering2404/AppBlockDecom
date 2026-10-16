package com.applovin.impl;

import android.media.ResourceBusyException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.applovin.impl.a7;
import com.applovin.impl.w5;
import com.applovin.impl.x6;
import com.applovin.impl.y6;
import com.applovin.impl.y7;
import com.applovin.impl.z6;
import com.facebook.ads.AdError;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class x5 implements a7 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final UUID f64815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final y7.c f64816d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final pd f64817e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HashMap f64818f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f64819g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int[] f64820h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f64821i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final g f64822j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final lc f64823k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final h f64824l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final long f64825m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final List f64826n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Set f64827o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Set f64828p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f64829q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private y7 f64830r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private w5 f64831s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private w5 f64832t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Looper f64833u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Handler f64834v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f64835w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private byte[] f64836x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    volatile d f64837y;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f64841d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f64843f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final HashMap f64838a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private UUID f64839b = t2.f63863d;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private y7.c f64840c = l9.f61168d;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private lc f64844g = new f6();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int[] f64842e = new int[0];

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f64845h = 300000;

        public b a(boolean z2) {
            this.f64841d = z2;
            return this;
        }

        public b b(boolean z2) {
            this.f64843f = z2;
            return this;
        }

        public b a(int... iArr) {
            for (int i3 : iArr) {
                boolean z2 = true;
                if (i3 != 2 && i3 != 1) {
                    z2 = false;
                }
                b1.a(z2);
            }
            this.f64842e = (int[]) iArr.clone();
            return this;
        }

        public b a(UUID uuid, y7.c cVar) {
            this.f64839b = (UUID) b1.a(uuid);
            this.f64840c = (y7.c) b1.a(cVar);
            return this;
        }

        public x5 a(pd pdVar) {
            return new x5(this.f64839b, this.f64840c, pdVar, this.f64838a, this.f64841d, this.f64842e, this.f64843f, this.f64844g, this.f64845h);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class c implements y7.b {
        private c() {
        }

        @Override // com.applovin.impl.y7.b
        public void a(y7 y7Var, byte[] bArr, int i3, int i4, byte[] bArr2) {
            ((d) b1.a(x5.this.f64837y)).obtainMessage(i3, bArr).sendToTarget();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr == null) {
                return;
            }
            for (w5 w5Var : x5.this.f64826n) {
                if (w5Var.a(bArr)) {
                    w5Var.a(message.what);
                    return;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class e extends Exception {
        private e(UUID uuid) {
            super("Media does not support uuid: " + uuid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class f implements a7.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final z6.a f64848b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private y6 f64849c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f64850d;

        public f(z6.a aVar) {
            this.f64848b = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            if (this.f64850d) {
                return;
            }
            y6 y6Var = this.f64849c;
            if (y6Var != null) {
                y6Var.a(this.f64848b);
            }
            x5.this.f64827o.remove(this);
            this.f64850d = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(e9 e9Var) {
            if (x5.this.f64829q == 0 || this.f64850d) {
                return;
            }
            x5 x5Var = x5.this;
            this.f64849c = x5Var.a((Looper) b1.a(x5Var.f64833u), this.f64848b, e9Var, false);
            x5.this.f64827o.add(this);
        }

        public void a(final e9 e9Var) {
            ((Handler) b1.a(x5.this.f64834v)).post(new Runnable() { // from class: com.applovin.impl.m80
                @Override // java.lang.Runnable
                public final void run() {
                    this.f61390a.b(e9Var);
                }
            });
        }

        @Override // com.applovin.impl.a7.b
        public void a() {
            xp.a((Handler) b1.a(x5.this.f64834v), new Runnable() { // from class: com.applovin.impl.n80
                @Override // java.lang.Runnable
                public final void run() {
                    this.f61986a.c();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class h implements w5.b {
        private h() {
        }

        @Override // com.applovin.impl.w5.b
        public void a(w5 w5Var, int i3) {
            if (x5.this.f64825m != -9223372036854775807L) {
                x5.this.f64828p.remove(w5Var);
                ((Handler) b1.a(x5.this.f64834v)).removeCallbacksAndMessages(w5Var);
            }
        }

        @Override // com.applovin.impl.w5.b
        public void b(final w5 w5Var, int i3) {
            if (i3 == 1 && x5.this.f64829q > 0 && x5.this.f64825m != -9223372036854775807L) {
                x5.this.f64828p.add(w5Var);
                ((Handler) b1.a(x5.this.f64834v)).postAtTime(new Runnable() { // from class: com.applovin.impl.o80
                    @Override // java.lang.Runnable
                    public final void run() {
                        w5Var.a((z6.a) null);
                    }
                }, w5Var, SystemClock.uptimeMillis() + x5.this.f64825m);
            } else if (i3 == 0) {
                x5.this.f64826n.remove(w5Var);
                if (x5.this.f64831s == w5Var) {
                    x5.this.f64831s = null;
                }
                if (x5.this.f64832t == w5Var) {
                    x5.this.f64832t = null;
                }
                x5.this.f64822j.b(w5Var);
                if (x5.this.f64825m != -9223372036854775807L) {
                    ((Handler) b1.a(x5.this.f64834v)).removeCallbacksAndMessages(w5Var);
                    x5.this.f64828p.remove(w5Var);
                }
            }
            x5.this.c();
        }
    }

    private x5(UUID uuid, y7.c cVar, pd pdVar, HashMap map, boolean z2, int[] iArr, boolean z3, lc lcVar, long j3) {
        b1.a(uuid);
        b1.a(!t2.f63861b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f64815c = uuid;
        this.f64816d = cVar;
        this.f64817e = pdVar;
        this.f64818f = map;
        this.f64819g = z2;
        this.f64820h = iArr;
        this.f64821i = z3;
        this.f64823k = lcVar;
        this.f64822j = new g();
        this.f64824l = new h();
        this.f64835w = 0;
        this.f64826n = new ArrayList();
        this.f64827o = rj.b();
        this.f64828p = rj.b();
        this.f64825m = j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.f64830r != null && this.f64829q == 0 && this.f64826n.isEmpty() && this.f64827o.isEmpty()) {
            ((y7) b1.a(this.f64830r)).a();
            this.f64830r = null;
        }
    }

    private void d() {
        pp it = hb.a((Collection) this.f64828p).iterator();
        while (it.hasNext()) {
            ((y6) it.next()).a((z6.a) null);
        }
    }

    private void e() {
        pp it = hb.a((Collection) this.f64827o).iterator();
        while (it.hasNext()) {
            ((f) it.next()).a();
        }
    }

    private void b(Looper looper) {
        if (this.f64837y == null) {
            this.f64837y = new d(looper);
        }
    }

    @Override // com.applovin.impl.a7
    public y6 a(Looper looper, z6.a aVar, e9 e9Var) {
        b1.b(this.f64829q > 0);
        a(looper);
        return a(looper, aVar, e9Var, true);
    }

    @Override // com.applovin.impl.a7
    public a7.b b(Looper looper, z6.a aVar, e9 e9Var) {
        b1.b(this.f64829q > 0);
        a(looper);
        f fVar = new f(aVar);
        fVar.a(e9Var);
        return fVar;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class g implements w5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Set f64852a = new HashSet();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private w5 f64853b;

        public g() {
        }

        @Override // com.applovin.impl.w5.a
        public void a() {
            this.f64853b = null;
            db dbVarA = db.a((Collection) this.f64852a);
            this.f64852a.clear();
            pp it = dbVarA.iterator();
            while (it.hasNext()) {
                ((w5) it.next()).i();
            }
        }

        public void b(w5 w5Var) {
            this.f64852a.remove(w5Var);
            if (this.f64853b == w5Var) {
                this.f64853b = null;
                if (this.f64852a.isEmpty()) {
                    return;
                }
                w5 w5Var2 = (w5) this.f64852a.iterator().next();
                this.f64853b = w5Var2;
                w5Var2.k();
            }
        }

        @Override // com.applovin.impl.w5.a
        public void a(Exception exc, boolean z2) {
            this.f64853b = null;
            db dbVarA = db.a((Collection) this.f64852a);
            this.f64852a.clear();
            pp it = dbVarA.iterator();
            while (it.hasNext()) {
                ((w5) it.next()).b(exc, z2);
            }
        }

        @Override // com.applovin.impl.w5.a
        public void a(w5 w5Var) {
            this.f64852a.add(w5Var);
            if (this.f64853b != null) {
                return;
            }
            this.f64853b = w5Var;
            w5Var.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public y6 a(Looper looper, z6.a aVar, e9 e9Var, boolean z2) {
        List listA;
        b(looper);
        x6 x6Var = e9Var.f59397p;
        if (x6Var == null) {
            return a(hf.e(e9Var.f59394m), z2);
        }
        w5 w5Var = null;
        Object[] objArr = 0;
        if (this.f64836x == null) {
            listA = a((x6) b1.a(x6Var), this.f64815c, false);
            if (listA.isEmpty()) {
                e eVar = new e(this.f64815c);
                oc.a("DefaultDrmSessionMgr", "DRM error", eVar);
                if (aVar != null) {
                    aVar.a(eVar);
                }
                return new t7(new y6.a(eVar, AdError.AD_ASSETS_UNSUPPORTED_TYPE_ERROR_CODE));
            }
        } else {
            listA = null;
        }
        if (!this.f64819g) {
            w5Var = this.f64832t;
        } else {
            Iterator it = this.f64826n.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                w5 w5Var2 = (w5) it.next();
                if (xp.a(w5Var2.f64575a, listA)) {
                    w5Var = w5Var2;
                    break;
                }
            }
        }
        if (w5Var == null) {
            w5 w5VarA = a(listA, false, aVar, z2);
            if (!this.f64819g) {
                this.f64832t = w5VarA;
            }
            this.f64826n.add(w5VarA);
            return w5VarA;
        }
        w5Var.b(aVar);
        return w5Var;
    }

    @Override // com.applovin.impl.a7
    public final void b() {
        int i3 = this.f64829q;
        this.f64829q = i3 + 1;
        if (i3 != 0) {
            return;
        }
        if (this.f64830r == null) {
            y7 y7VarA = this.f64816d.a(this.f64815c);
            this.f64830r = y7VarA;
            y7VarA.a(new c());
        } else if (this.f64825m != -9223372036854775807L) {
            for (int i4 = 0; i4 < this.f64826n.size(); i4++) {
                ((w5) this.f64826n.get(i4)).b(null);
            }
        }
    }

    private static boolean a(y6 y6Var) {
        if (y6Var.b() == 1) {
            return xp.f65027a < 19 || (((y6.a) b1.a(y6Var.getError())).getCause() instanceof ResourceBusyException);
        }
        return false;
    }

    private boolean a(x6 x6Var) {
        if (this.f64836x != null) {
            return true;
        }
        if (a(x6Var, this.f64815c, true).isEmpty()) {
            if (x6Var.f64861d != 1 || !x6Var.a(0).a(t2.f63861b)) {
                return false;
            }
            oc.d("DefaultDrmSessionMgr", "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + this.f64815c);
        }
        String str = x6Var.f64860c;
        if (str == null || "cenc".equals(str)) {
            return true;
        }
        return "cbcs".equals(str) ? xp.f65027a >= 25 : ("cbc1".equals(str) || "cens".equals(str)) ? false : true;
    }

    private w5 a(List list, boolean z2, z6.a aVar) {
        b1.a(this.f64830r);
        w5 w5Var = new w5(this.f64815c, this.f64830r, this.f64822j, this.f64824l, list, this.f64835w, this.f64821i | z2, z2, this.f64836x, this.f64818f, this.f64817e, (Looper) b1.a(this.f64833u), this.f64823k);
        w5Var.b(aVar);
        if (this.f64825m != -9223372036854775807L) {
            w5Var.b(null);
        }
        return w5Var;
    }

    private w5 a(List list, boolean z2, z6.a aVar, boolean z3) {
        w5 w5VarA = a(list, z2, aVar);
        if (a(w5VarA) && !this.f64828p.isEmpty()) {
            d();
            a(w5VarA, aVar);
            w5VarA = a(list, z2, aVar);
        }
        if (!a(w5VarA) || !z3 || this.f64827o.isEmpty()) {
            return w5VarA;
        }
        e();
        if (!this.f64828p.isEmpty()) {
            d();
        }
        a(w5VarA, aVar);
        return a(list, z2, aVar);
    }

    @Override // com.applovin.impl.a7
    public int a(e9 e9Var) {
        int iC = ((y7) b1.a(this.f64830r)).c();
        x6 x6Var = e9Var.f59397p;
        if (x6Var == null) {
            if (xp.a(this.f64820h, hf.e(e9Var.f59394m)) == -1) {
                return 0;
            }
        } else if (!a(x6Var)) {
            return 1;
        }
        return iC;
    }

    private synchronized void a(Looper looper) {
        try {
            Looper looper2 = this.f64833u;
            if (looper2 == null) {
                this.f64833u = looper;
                this.f64834v = new Handler(looper);
            } else {
                b1.b(looper2 == looper);
                b1.a(this.f64834v);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private y6 a(int i3, boolean z2) {
        y7 y7Var = (y7) b1.a(this.f64830r);
        if ((y7Var.c() == 2 && k9.f60942d) || xp.a(this.f64820h, i3) == -1 || y7Var.c() == 1) {
            return null;
        }
        w5 w5Var = this.f64831s;
        if (w5Var == null) {
            w5 w5VarA = a((List) db.h(), true, (z6.a) null, z2);
            this.f64826n.add(w5VarA);
            this.f64831s = w5VarA;
        } else {
            w5Var.b(null);
        }
        return this.f64831s;
    }

    @Override // com.applovin.impl.a7
    public final void a() {
        int i3 = this.f64829q - 1;
        this.f64829q = i3;
        if (i3 != 0) {
            return;
        }
        if (this.f64825m != -9223372036854775807L) {
            ArrayList arrayList = new ArrayList(this.f64826n);
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                ((w5) arrayList.get(i4)).a((z6.a) null);
            }
        }
        e();
        c();
    }

    public void a(int i3, byte[] bArr) {
        b1.b(this.f64826n.isEmpty());
        if (i3 == 1 || i3 == 3) {
            b1.a(bArr);
        }
        this.f64835w = i3;
        this.f64836x = bArr;
    }

    private void a(y6 y6Var, z6.a aVar) {
        y6Var.a(aVar);
        if (this.f64825m != -9223372036854775807L) {
            y6Var.a((z6.a) null);
        }
    }

    private static List a(x6 x6Var, UUID uuid, boolean z2) {
        ArrayList arrayList = new ArrayList(x6Var.f64861d);
        for (int i3 = 0; i3 < x6Var.f64861d; i3++) {
            x6.b bVarA = x6Var.a(i3);
            if ((bVarA.a(uuid) || (t2.f63862c.equals(uuid) && bVarA.a(t2.f63861b))) && (bVarA.f64866f != null || z2)) {
                arrayList.add(bVarA);
            }
        }
        return arrayList;
    }
}
