package com.applovin.impl;

import android.os.Handler;
import com.applovin.impl.ae;
import com.applovin.impl.be;
import com.applovin.impl.wj;
import com.applovin.impl.z6;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class ee {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d f59466d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final be.a f59467e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final z6.a f59468f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final HashMap f59469g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Set f59470h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f59472j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private xo f59473k;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private wj f59471i = new wj.a(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final IdentityHashMap f59464b = new IdentityHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f59465c = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f59463a = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ae f59478a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ae.b f59479b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a f59480c;

        public b(ae aeVar, ae.b bVar, a aVar) {
            this.f59478a = aeVar;
            this.f59479b = bVar;
            this.f59480c = aVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class c implements de {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final wc f59481a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f59484d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f59485e;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List f59483c = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f59482b = new Object();

        public c(ae aeVar, boolean z2) {
            this.f59481a = new wc(aeVar, z2);
        }

        @Override // com.applovin.impl.de
        public Object a() {
            return this.f59482b;
        }

        @Override // com.applovin.impl.de
        public fo b() {
            return this.f59481a.i();
        }

        public void a(int i3) {
            this.f59484d = i3;
            this.f59485e = false;
            this.f59483c.clear();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface d {
        void a();
    }

    public ee(d dVar, r0 r0Var, Handler handler) {
        this.f59466d = dVar;
        be.a aVar = new be.a();
        this.f59467e = aVar;
        z6.a aVar2 = new z6.a();
        this.f59468f = aVar2;
        this.f59469g = new HashMap();
        this.f59470h = new HashSet();
        if (r0Var != null) {
            aVar.a(handler, r0Var);
            aVar2.a(handler, r0Var);
        }
    }

    public int c() {
        return this.f59463a.size();
    }

    public boolean d() {
        return this.f59472j;
    }

    public void e() {
        for (b bVar : this.f59469g.values()) {
            try {
                bVar.f59478a.c(bVar.f59479b);
            } catch (RuntimeException e3) {
                oc.a("MediaSourceList", "Failed to release child source.", e3);
            }
            bVar.f59478a.a((be) bVar.f59480c);
            bVar.f59478a.a((z6) bVar.f59480c);
        }
        this.f59469g.clear();
        this.f59470h.clear();
        this.f59472j = false;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class a implements be, z6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f59474a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private be.a f59475b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private z6.a f59476c;

        public a(c cVar) {
            this.f59475b = ee.this.f59467e;
            this.f59476c = ee.this.f59468f;
            this.f59474a = cVar;
        }

        private boolean f(int i3, ae.a aVar) {
            ae.a aVarB;
            if (aVar != null) {
                aVarB = ee.b(this.f59474a, aVar);
                if (aVarB == null) {
                    return false;
                }
            } else {
                aVarB = null;
            }
            int iB = ee.b(this.f59474a, i3);
            be.a aVar2 = this.f59475b;
            if (aVar2.f58638a != iB || !xp.a(aVar2.f58639b, aVarB)) {
                this.f59475b = ee.this.f59467e.a(iB, aVarB, 0L);
            }
            z6.a aVar3 = this.f59476c;
            if (aVar3.f65371a == iB && xp.a(aVar3.f65372b, aVarB)) {
                return true;
            }
            this.f59476c = ee.this.f59468f.a(iB, aVarB);
            return true;
        }

        @Override // com.applovin.impl.be
        public void a(int i3, ae.a aVar, td tdVar) {
            if (f(i3, aVar)) {
                this.f59475b.a(tdVar);
            }
        }

        @Override // com.applovin.impl.z6
        public void b(int i3, ae.a aVar) {
            if (f(i3, aVar)) {
                this.f59476c.d();
            }
        }

        @Override // com.applovin.impl.z6
        public void c(int i3, ae.a aVar) {
            if (f(i3, aVar)) {
                this.f59476c.c();
            }
        }

        @Override // com.applovin.impl.z6
        public void d(int i3, ae.a aVar) {
            if (f(i3, aVar)) {
                this.f59476c.a();
            }
        }

        @Override // com.applovin.impl.z6
        public void a(int i3, ae.a aVar) {
            if (f(i3, aVar)) {
                this.f59476c.b();
            }
        }

        @Override // com.applovin.impl.be
        public void b(int i3, ae.a aVar, mc mcVar, td tdVar) {
            if (f(i3, aVar)) {
                this.f59475b.c(mcVar, tdVar);
            }
        }

        @Override // com.applovin.impl.be
        public void c(int i3, ae.a aVar, mc mcVar, td tdVar) {
            if (f(i3, aVar)) {
                this.f59475b.b(mcVar, tdVar);
            }
        }

        @Override // com.applovin.impl.z6
        public void a(int i3, ae.a aVar, int i4) {
            if (f(i3, aVar)) {
                this.f59476c.a(i4);
            }
        }

        @Override // com.applovin.impl.z6
        public void a(int i3, ae.a aVar, Exception exc) {
            if (f(i3, aVar)) {
                this.f59476c.a(exc);
            }
        }

        @Override // com.applovin.impl.be
        public void a(int i3, ae.a aVar, mc mcVar, td tdVar) {
            if (f(i3, aVar)) {
                this.f59475b.a(mcVar, tdVar);
            }
        }

        @Override // com.applovin.impl.be
        public void a(int i3, ae.a aVar, mc mcVar, td tdVar, IOException iOException, boolean z2) {
            if (f(i3, aVar)) {
                this.f59475b.a(mcVar, tdVar, iOException, z2);
            }
        }
    }

    private void b() {
        Iterator it = this.f59470h.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.f59483c.isEmpty()) {
                a(cVar);
                it.remove();
            }
        }
    }

    private void c(c cVar) {
        if (cVar.f59485e && cVar.f59483c.isEmpty()) {
            b bVar = (b) b1.a((b) this.f59469g.remove(cVar));
            bVar.f59478a.c(bVar.f59479b);
            bVar.f59478a.a((be) bVar.f59480c);
            bVar.f59478a.a((z6) bVar.f59480c);
            this.f59470h.remove(cVar);
        }
    }

    private void d(c cVar) {
        wc wcVar = cVar.f59481a;
        ae.b bVar = new ae.b() { // from class: com.applovin.impl.yu
            @Override // com.applovin.impl.ae.b
            public final void a(ae aeVar, fo foVar) {
                this.f65263a.a(aeVar, foVar);
            }
        };
        a aVar = new a(cVar);
        this.f59469g.put(cVar, new b(wcVar, bVar, aVar));
        wcVar.a(xp.b(), (be) aVar);
        wcVar.a(xp.b(), (z6) aVar);
        wcVar.a(bVar, this.f59473k);
    }

    public fo a(int i3, List list, wj wjVar) {
        if (!list.isEmpty()) {
            this.f59471i = wjVar;
            for (int i4 = i3; i4 < list.size() + i3; i4++) {
                c cVar = (c) list.get(i4 - i3);
                if (i4 > 0) {
                    c cVar2 = (c) this.f59463a.get(i4 - 1);
                    cVar.a(cVar2.f59484d + cVar2.f59481a.i().b());
                } else {
                    cVar.a(0);
                }
                a(i4, cVar.f59481a.i().b());
                this.f59463a.add(i4, cVar);
                this.f59465c.put(cVar.f59482b, cVar);
                if (this.f59472j) {
                    d(cVar);
                    if (this.f59464b.isEmpty()) {
                        this.f59470h.add(cVar);
                    } else {
                        a(cVar);
                    }
                }
            }
        }
        return a();
    }

    private void b(c cVar) {
        this.f59470h.add(cVar);
        b bVar = (b) this.f59469g.get(cVar);
        if (bVar != null) {
            bVar.f59478a.b(bVar.f59479b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ae.a b(c cVar, ae.a aVar) {
        for (int i3 = 0; i3 < cVar.f59483c.size(); i3++) {
            if (((ae.a) cVar.f59483c.get(i3)).f64965d == aVar.f64965d) {
                return aVar.b(a(cVar, aVar.f64962a));
            }
        }
        return null;
    }

    private static Object b(Object obj) {
        return com.applovin.impl.b.d(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(c cVar, int i3) {
        return i3 + cVar.f59484d;
    }

    private void b(int i3, int i4) {
        for (int i5 = i4 - 1; i5 >= i3; i5--) {
            c cVar = (c) this.f59463a.remove(i5);
            this.f59465c.remove(cVar.f59482b);
            a(i5, -cVar.f59481a.i().b());
            cVar.f59485e = true;
            if (this.f59472j) {
                c(cVar);
            }
        }
    }

    private void a(int i3, int i4) {
        while (i3 < this.f59463a.size()) {
            ((c) this.f59463a.get(i3)).f59484d += i4;
            i3++;
        }
    }

    public vd a(ae.a aVar, n0 n0Var, long j3) {
        Object objB = b(aVar.f64962a);
        ae.a aVarB = aVar.b(a(aVar.f64962a));
        c cVar = (c) b1.a((c) this.f59465c.get(objB));
        b(cVar);
        cVar.f59483c.add(aVarB);
        vc vcVarA = cVar.f59481a.a(aVarB, n0Var, j3);
        this.f59464b.put(vcVarA, cVar);
        b();
        return vcVarA;
    }

    public fo a() {
        if (this.f59463a.isEmpty()) {
            return fo.f59732a;
        }
        int iB = 0;
        for (int i3 = 0; i3 < this.f59463a.size(); i3++) {
            c cVar = (c) this.f59463a.get(i3);
            cVar.f59484d = iB;
            iB += cVar.f59481a.i().b();
        }
        return new sh(this.f59463a, this.f59471i);
    }

    private void a(c cVar) {
        b bVar = (b) this.f59469g.get(cVar);
        if (bVar != null) {
            bVar.f59478a.a(bVar.f59479b);
        }
    }

    private static Object a(Object obj) {
        return com.applovin.impl.b.c(obj);
    }

    private static Object a(c cVar, Object obj) {
        return com.applovin.impl.b.a(cVar.f59482b, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ae aeVar, fo foVar) {
        this.f59466d.a();
    }

    public void a(xo xoVar) {
        b1.b(!this.f59472j);
        this.f59473k = xoVar;
        for (int i3 = 0; i3 < this.f59463a.size(); i3++) {
            c cVar = (c) this.f59463a.get(i3);
            d(cVar);
            this.f59470h.add(cVar);
        }
        this.f59472j = true;
    }

    public void a(vd vdVar) {
        c cVar = (c) b1.a((c) this.f59464b.remove(vdVar));
        cVar.f59481a.a(vdVar);
        cVar.f59483c.remove(((vc) vdVar).f64413a);
        if (!this.f59464b.isEmpty()) {
            b();
        }
        c(cVar);
    }

    public fo a(int i3, int i4, wj wjVar) {
        b1.a(i3 >= 0 && i3 <= i4 && i4 <= c());
        this.f59471i = wjVar;
        b(i3, i4);
        return a();
    }

    public fo a(List list, wj wjVar) {
        b(0, this.f59463a.size());
        return a(this.f59463a.size(), list, wjVar);
    }

    public fo a(wj wjVar) {
        int iC = c();
        if (wjVar.a() != iC) {
            wjVar = wjVar.d().b(0, iC);
        }
        this.f59471i = wjVar;
        return a();
    }
}
