package com.applovin.impl;

import android.os.Handler;
import com.applovin.impl.ae;
import com.applovin.impl.be;
import com.applovin.impl.z6;
import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class b4 extends c2 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final HashMap f58544g = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Handler f58545h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private xo f58546i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ae f58551a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ae.b f58552b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a f58553c;

        public b(ae aeVar, ae.b bVar, a aVar) {
            this.f58551a = aeVar;
            this.f58552b = bVar;
            this.f58553c = aVar;
        }
    }

    protected b4() {
    }

    protected int a(Object obj, int i3) {
        return i3;
    }

    protected abstract ae.a a(Object obj, ae.a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public abstract void a(Object obj, ae aeVar, fo foVar);

    @Override // com.applovin.impl.c2
    protected void e() {
        for (b bVar : this.f58544g.values()) {
            bVar.f58551a.a(bVar.f58552b);
        }
    }

    @Override // com.applovin.impl.c2
    protected void f() {
        for (b bVar : this.f58544g.values()) {
            bVar.f58551a.b(bVar.f58552b);
        }
    }

    @Override // com.applovin.impl.c2
    protected void h() {
        for (b bVar : this.f58544g.values()) {
            bVar.f58551a.c(bVar.f58552b);
            bVar.f58551a.a((be) bVar.f58553c);
            bVar.f58551a.a((z6) bVar.f58553c);
        }
        this.f58544g.clear();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class a implements be, z6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f58547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private be.a f58548b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private z6.a f58549c;

        public a(Object obj) {
            this.f58548b = b4.this.b((ae.a) null);
            this.f58549c = b4.this.a((ae.a) null);
            this.f58547a = obj;
        }

        private td a(td tdVar) {
            long jA = b4.this.a(this.f58547a, tdVar.f63927f);
            long jA2 = b4.this.a(this.f58547a, tdVar.f63928g);
            return (jA == tdVar.f63927f && jA2 == tdVar.f63928g) ? tdVar : new td(tdVar.f63922a, tdVar.f63923b, tdVar.f63924c, tdVar.f63925d, tdVar.f63926e, jA, jA2);
        }

        private boolean f(int i3, ae.a aVar) {
            ae.a aVarA;
            if (aVar != null) {
                aVarA = b4.this.a(this.f58547a, aVar);
                if (aVarA == null) {
                    return false;
                }
            } else {
                aVarA = null;
            }
            int iA = b4.this.a(this.f58547a, i3);
            be.a aVar2 = this.f58548b;
            if (aVar2.f58638a != iA || !xp.a(aVar2.f58639b, aVarA)) {
                this.f58548b = b4.this.a(iA, aVarA, 0L);
            }
            z6.a aVar3 = this.f58549c;
            if (aVar3.f65371a == iA && xp.a(aVar3.f65372b, aVarA)) {
                return true;
            }
            this.f58549c = b4.this.a(iA, aVarA);
            return true;
        }

        @Override // com.applovin.impl.z6
        public void b(int i3, ae.a aVar) {
            if (f(i3, aVar)) {
                this.f58549c.d();
            }
        }

        @Override // com.applovin.impl.z6
        public void c(int i3, ae.a aVar) {
            if (f(i3, aVar)) {
                this.f58549c.c();
            }
        }

        @Override // com.applovin.impl.z6
        public void d(int i3, ae.a aVar) {
            if (f(i3, aVar)) {
                this.f58549c.a();
            }
        }

        @Override // com.applovin.impl.be
        public void b(int i3, ae.a aVar, mc mcVar, td tdVar) {
            if (f(i3, aVar)) {
                this.f58548b.c(mcVar, a(tdVar));
            }
        }

        @Override // com.applovin.impl.be
        public void c(int i3, ae.a aVar, mc mcVar, td tdVar) {
            if (f(i3, aVar)) {
                this.f58548b.b(mcVar, a(tdVar));
            }
        }

        @Override // com.applovin.impl.be
        public void a(int i3, ae.a aVar, td tdVar) {
            if (f(i3, aVar)) {
                this.f58548b.a(a(tdVar));
            }
        }

        @Override // com.applovin.impl.z6
        public void a(int i3, ae.a aVar) {
            if (f(i3, aVar)) {
                this.f58549c.b();
            }
        }

        @Override // com.applovin.impl.z6
        public void a(int i3, ae.a aVar, int i4) {
            if (f(i3, aVar)) {
                this.f58549c.a(i4);
            }
        }

        @Override // com.applovin.impl.z6
        public void a(int i3, ae.a aVar, Exception exc) {
            if (f(i3, aVar)) {
                this.f58549c.a(exc);
            }
        }

        @Override // com.applovin.impl.be
        public void a(int i3, ae.a aVar, mc mcVar, td tdVar) {
            if (f(i3, aVar)) {
                this.f58548b.a(mcVar, a(tdVar));
            }
        }

        @Override // com.applovin.impl.be
        public void a(int i3, ae.a aVar, mc mcVar, td tdVar, IOException iOException, boolean z2) {
            if (f(i3, aVar)) {
                this.f58548b.a(mcVar, a(tdVar), iOException, z2);
            }
        }
    }

    protected long a(Object obj, long j3) {
        return j3;
    }

    protected final void a(final Object obj, ae aeVar) {
        b1.a(!this.f58544g.containsKey(obj));
        ae.b bVar = new ae.b() { // from class: com.applovin.impl.us
            @Override // com.applovin.impl.ae.b
            public final void a(ae aeVar2, fo foVar) {
                this.f64345a.a(obj, aeVar2, foVar);
            }
        };
        a aVar = new a(obj);
        this.f58544g.put(obj, new b(aeVar, bVar, aVar));
        aeVar.a((Handler) b1.a(this.f58545h), (be) aVar);
        aeVar.a((Handler) b1.a(this.f58545h), (z6) aVar);
        aeVar.a(bVar, this.f58546i);
        if (g()) {
            return;
        }
        aeVar.a(bVar);
    }

    @Override // com.applovin.impl.c2
    protected void a(xo xoVar) {
        this.f58546i = xoVar;
        this.f58545h = xp.a();
    }
}
