package com.applovin.impl;

import com.applovin.impl.yg;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
abstract class a3 implements ol {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayDeque f58154a = new ArrayDeque();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayDeque f58155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PriorityQueue f58156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f58157d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f58158e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f58159f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class b extends rl implements Comparable {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private long f58160k;

        private b() {
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            if (e() != bVar.e()) {
                return e() ? 1 : -1;
            }
            long j3 = this.f62185f - bVar.f62185f;
            if (j3 == 0) {
                j3 = this.f58160k - bVar.f58160k;
                if (j3 == 0) {
                    return 0;
                }
            }
            return j3 > 0 ? 1 : -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class c extends sl {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private yg.a f58161g;

        public c(yg.a aVar) {
            this.f58161g = aVar;
        }

        @Override // com.applovin.impl.yg
        public final void g() {
            this.f58161g.a(this);
        }
    }

    public a3() {
        for (int i3 = 0; i3 < 10; i3++) {
            this.f58154a.add(new b());
        }
        this.f58155b = new ArrayDeque();
        for (int i4 = 0; i4 < 2; i4++) {
            this.f58155b.add(new c(new yg.a() { // from class: com.applovin.impl.is
                @Override // com.applovin.impl.yg.a
                public final void a(yg ygVar) {
                    this.f60532a.a((sl) ygVar);
                }
            }));
        }
        this.f58156c = new PriorityQueue();
    }

    @Override // com.applovin.impl.l5
    public void a() {
    }

    protected abstract void a(rl rlVar);

    @Override // com.applovin.impl.l5
    public void b() {
        this.f58159f = 0L;
        this.f58158e = 0L;
        while (!this.f58156c.isEmpty()) {
            a((b) xp.a((b) this.f58156c.poll()));
        }
        b bVar = this.f58157d;
        if (bVar != null) {
            a(bVar);
            this.f58157d = null;
        }
    }

    protected abstract nl e();

    @Override // com.applovin.impl.l5
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public rl d() {
        b1.b(this.f58157d == null);
        if (this.f58154a.isEmpty()) {
            return null;
        }
        b bVar = (b) this.f58154a.pollFirst();
        this.f58157d = bVar;
        return bVar;
    }

    @Override // com.applovin.impl.l5
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public sl c() {
        if (this.f58155b.isEmpty()) {
            return null;
        }
        while (!this.f58156c.isEmpty() && ((b) xp.a((b) this.f58156c.peek())).f62185f <= this.f58158e) {
            b bVar = (b) xp.a((b) this.f58156c.poll());
            if (bVar.e()) {
                sl slVar = (sl) xp.a((sl) this.f58155b.pollFirst());
                slVar.b(4);
                a(bVar);
                return slVar;
            }
            a((rl) bVar);
            if (j()) {
                nl nlVarE = e();
                sl slVar2 = (sl) xp.a((sl) this.f58155b.pollFirst());
                slVar2.a(bVar.f62185f, nlVarE, Long.MAX_VALUE);
                a(bVar);
                return slVar2;
            }
            a(bVar);
        }
        return null;
    }

    protected final sl h() {
        return (sl) this.f58155b.pollFirst();
    }

    protected final long i() {
        return this.f58158e;
    }

    protected abstract boolean j();

    private void a(b bVar) {
        bVar.b();
        this.f58154a.add(bVar);
    }

    protected void a(sl slVar) {
        slVar.b();
        this.f58155b.add(slVar);
    }

    @Override // com.applovin.impl.ol
    public void a(long j3) {
        this.f58158e = j3;
    }

    @Override // com.applovin.impl.l5
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(rl rlVar) {
        b1.a(rlVar == this.f58157d);
        b bVar = (b) rlVar;
        if (bVar.d()) {
            a(bVar);
        } else {
            long j3 = this.f58159f;
            this.f58159f = 1 + j3;
            bVar.f58160k = j3;
            this.f58156c.add(bVar);
        }
        this.f58157d = null;
    }
}
