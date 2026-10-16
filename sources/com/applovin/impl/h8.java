package com.applovin.impl;

import com.applovin.impl.yg;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class h8 implements ol {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b5 f60143a = new b5();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final rl f60144b = new rl();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Deque f60145c = new ArrayDeque();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f60146d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f60147e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class a implements nl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f60148a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final db f60149b;

        public a(long j3, db dbVar) {
            this.f60148a = j3;
            this.f60149b = dbVar;
        }

        @Override // com.applovin.impl.nl
        public int a() {
            return 1;
        }

        @Override // com.applovin.impl.nl
        public List b(long j3) {
            return j3 >= this.f60148a ? this.f60149b : db.h();
        }

        @Override // com.applovin.impl.nl
        public long a(int i3) {
            b1.a(i3 == 0);
            return this.f60148a;
        }

        @Override // com.applovin.impl.nl
        public int a(long j3) {
            return this.f60148a > j3 ? 0 : -1;
        }
    }

    public h8() {
        for (int i3 = 0; i3 < 2; i3++) {
            this.f60145c.addFirst(new fk(new yg.a() { // from class: com.applovin.impl.sx
                @Override // com.applovin.impl.yg.a
                public final void a(yg ygVar) {
                    this.f63837a.a((sl) ygVar);
                }
            }));
        }
        this.f60146d = 0;
    }

    @Override // com.applovin.impl.l5
    public void b() {
        b1.b(!this.f60147e);
        this.f60144b.b();
        this.f60146d = 0;
    }

    @Override // com.applovin.impl.l5
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public rl d() {
        b1.b(!this.f60147e);
        if (this.f60146d != 0) {
            return null;
        }
        this.f60146d = 1;
        return this.f60144b;
    }

    @Override // com.applovin.impl.l5
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public sl c() {
        b1.b(!this.f60147e);
        if (this.f60146d != 2 || this.f60145c.isEmpty()) {
            return null;
        }
        sl slVar = (sl) this.f60145c.removeFirst();
        if (this.f60144b.e()) {
            slVar.b(4);
        } else {
            rl rlVar = this.f60144b;
            slVar.a(this.f60144b.f62185f, new a(rlVar.f62185f, this.f60143a.a(((ByteBuffer) b1.a(rlVar.f62183c)).array())), 0L);
        }
        this.f60144b.b();
        this.f60146d = 0;
        return slVar;
    }

    @Override // com.applovin.impl.ol
    public void a(long j3) {
    }

    @Override // com.applovin.impl.l5
    public void a(rl rlVar) {
        b1.b(!this.f60147e);
        b1.b(this.f60146d == 1);
        b1.a(this.f60144b == rlVar);
        this.f60146d = 2;
    }

    @Override // com.applovin.impl.l5
    public void a() {
        this.f60147e = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(sl slVar) {
        b1.b(this.f60145c.size() < 2);
        b1.a(!this.f60145c.contains(slVar));
        slVar.b();
        this.f60145c.addFirst(slVar);
    }
}
