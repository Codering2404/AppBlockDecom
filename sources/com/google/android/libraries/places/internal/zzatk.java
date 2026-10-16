package com.google.android.libraries.places.internal;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzatk extends zzbix {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbit f75840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbml f75841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ImmutableList f75842c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Executor f75843d;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zzbis f75849j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f75850k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private zzatj f75851l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f75853n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private zzbiw f75854o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private zzbmg f75855p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final zzati f75857r;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private zzbix f75859t;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set f75844e = Sets.k();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LinkedHashMap f75845f = new LinkedHashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Set f75846g = Sets.k();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f75856q = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f75858s = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Deque f75847h = new ArrayDeque();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Queue f75852m = new ArrayDeque();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Queue f75848i = new ArrayDeque();

    zzatk(zzbit zzbitVar, zzbml zzbmlVar, zzbis zzbisVar, int i3, ImmutableList immutableList) {
        this.f75840a = zzbitVar;
        this.f75841b = zzbmlVar;
        this.f75849j = zzbisVar;
        this.f75842c = immutableList;
        this.f75851l = zzatj.b(immutableList.size());
        Executor executorJ = zzbisVar.j();
        zzati zzatiVar = new zzati(executorJ == null ? MoreExecutors.a() : executorJ);
        this.f75857r = zzatiVar;
        final Executor executorE = MoreExecutors.e(zzatiVar);
        this.f75843d = new Executor() { // from class: com.google.android.libraries.places.internal.zzatb
            @Override // java.util.concurrent.Executor
            public final /* synthetic */ void execute(final Runnable runnable) {
                final zzatk zzatkVar = this.f75817a;
                executorE.execute(new Runnable() { // from class: com.google.android.libraries.places.internal.zzasr
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzatkVar.s(runnable);
                    }
                });
            }
        };
    }

    private final boolean A(zzats zzatsVar) {
        int iOrdinal = zzatsVar.c().ordinal();
        if (iOrdinal == 0) {
            return false;
        }
        if (iOrdinal == 1 || iOrdinal == 2) {
            throw null;
        }
        if (iOrdinal != 3) {
            if (iOrdinal != 4) {
                throw new IllegalStateException("Unrecognized outcome type: ".concat(String.valueOf(zzatsVar.c())));
            }
            this.f75851l.a();
            return false;
        }
        final ListenableFuture listenableFutureD = zzatsVar.d();
        this.f75844e.add(listenableFutureD);
        listenableFutureD.addListener(zzsc.a(new Runnable() { // from class: com.google.android.libraries.places.internal.zzasu
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f75800a.l(listenableFutureD);
            }
        }), this.f75843d);
        return false;
    }

    private final void B() {
        int iG = this.f75851l.g() - 1;
        if (iG == 1) {
            for (zzath zzathVar : this.f75847h) {
                if (zzathVar.e() <= this.f75851l.f()) {
                    C(zzathVar, zzathVar.e(), this.f75851l.f() + 1);
                }
            }
            return;
        }
        if (iG != 3) {
            return;
        }
        for (zzath zzathVar2 : this.f75847h) {
            C(zzathVar2, zzathVar2.e(), this.f75851l.d());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void C(final zzath zzathVar, int i3, int i4) {
        final zzasl zzaslVarA = zzasl.a(zzathVar.c());
        while (i3 < i4) {
            ImmutableList immutableList = (ImmutableList) this.f75842c.get(i3);
            int size = immutableList.size();
            for (int i5 = 0; i5 < size; i5++) {
                zzasm zzasmVar = (zzasm) immutableList.get(i5);
                zzats zzatsVarA = zzats.a();
                if (zzatsVarA.c().equals(zzatq.CONTINUE_AFTER)) {
                    ListenableFuture listenableFutureD = zzatsVarA.d();
                    zzathVar.d().put(zzasmVar, listenableFutureD);
                    listenableFutureD.addListener(zzsc.a(new Runnable() { // from class: com.google.android.libraries.places.internal.zzasw
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            this.f75804a.n(zzaslVarA, zzathVar);
                        }
                    }), this.f75843d);
                }
                A(zzatsVarA);
            }
            i3++;
        }
        zzathVar.f(i4);
        if (zzathVar.d().isEmpty()) {
            g();
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final void o(final zzasl zzaslVar, final zzath zzathVar) {
        Iterator it = zzathVar.d().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!((ListenableFuture) entry.getValue()).isDone()) {
                break;
            }
            it.remove();
            zzasm zzasmVar = (zzasm) entry.getKey();
            zzats zzatsVarA = zzats.a();
            if (zzatsVarA.c().equals(zzatq.CONTINUE_AFTER)) {
                ListenableFuture listenableFutureD = zzatsVarA.d();
                zzathVar.d().put(zzasmVar, listenableFutureD);
                listenableFutureD.addListener(zzsc.a(new Runnable() { // from class: com.google.android.libraries.places.internal.zzasx
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.f75807a.o(zzaslVar, zzathVar);
                    }
                }), this.f75843d);
            }
            A(zzatsVarA);
        }
        if (zzathVar.d().isEmpty()) {
            g();
            h();
        }
    }

    private final void g() {
        while (true) {
            Deque deque = this.f75847h;
            if (deque.isEmpty() || !((zzath) deque.peek()).a()) {
                return;
            }
            Object objC = ((zzath) deque.poll()).c();
            if (this.f75851l.g() == 4) {
                this.f75859t.b(objC);
            } else {
                this.f75848i.add(objC);
            }
        }
    }

    private final void h() {
        if (this.f75856q) {
            zzath zzathVar = (zzath) this.f75847h.peekLast();
            int iG = this.f75851l.g() - 1;
            if (iG != 1) {
                if (iG == 3 && zzathVar == null) {
                    this.f75859t.d();
                    return;
                }
                return;
            }
            if (zzathVar == null || zzathVar.b()) {
                z();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public final void i(zzbmg zzbmgVar) {
        final zzask zzaskVarA = zzask.a(this.f75841b, this.f75849j, zzbmgVar, this.f75840a.f());
        ImmutableList immutableList = (ImmutableList) this.f75842c.get(this.f75851l.e());
        int size = immutableList.size();
        for (int i3 = 0; i3 < size; i3++) {
            zzasm zzasmVar = (zzasm) immutableList.get(i3);
            zzats zzatsVarB = zzasmVar.b(y(zzaskVarA));
            if (zzatsVarB.c().equals(zzatq.CONTINUE_AFTER)) {
                ListenableFuture listenableFutureD = zzatsVarB.d();
                this.f75845f.put(zzasmVar, listenableFutureD);
                listenableFutureD.addListener(zzsc.a(new Runnable() { // from class: com.google.android.libraries.places.internal.zzass
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.f75796a.j(zzaskVarA);
                    }
                }), this.f75843d);
            }
            A(zzatsVarB);
            this.f75846g.add(zzasmVar);
        }
        if (this.f75845f.isEmpty()) {
            z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final void k(final zzask zzaskVar) {
        LinkedHashMap linkedHashMap = this.f75845f;
        if (linkedHashMap.isEmpty()) {
            return;
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!((ListenableFuture) entry.getValue()).isDone()) {
                break;
            }
            it.remove();
            zzasm zzasmVar = (zzasm) entry.getKey();
            zzats zzatsVarA = zzasmVar.a(y(zzaskVar));
            if (zzatsVarA.c().equals(zzatq.CONTINUE_AFTER)) {
                ListenableFuture listenableFutureD = zzatsVarA.d();
                linkedHashMap.put(zzasmVar, listenableFutureD);
                listenableFutureD.addListener(zzsc.a(new Runnable() { // from class: com.google.android.libraries.places.internal.zzast
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.f75798a.k(zzaskVar);
                    }
                }), this.f75843d);
            }
            A(zzatsVarA);
        }
        if (!linkedHashMap.isEmpty() || this.f75858s) {
            return;
        }
        z();
    }

    private final zzask y(zzask zzaskVar) {
        zzbis zzbisVar = this.f75849j;
        if (zzbisVar == zzaskVar.c()) {
            return zzaskVar;
        }
        return zzask.a(this.f75841b, zzbisVar, zzaskVar.b(), zzaskVar.d());
    }

    private final void z() {
        zzatj zzatjVarC = this.f75851l.c();
        this.f75851l = zzatjVarC;
        int iG = zzatjVarC.g() - 1;
        if (iG == 0) {
            i(this.f75855p);
            return;
        }
        if (iG != 2) {
            B();
            return;
        }
        zzbix zzbixVarD = this.f75840a.d(this.f75841b, this.f75849j);
        this.f75859t = zzbixVarD;
        zzbixVarD.a(this.f75854o, this.f75855p);
        int i3 = this.f75850k;
        if (i3 > 0) {
            this.f75859t.c(i3);
        }
        Iterator it = this.f75848i.iterator();
        while (it.hasNext()) {
            this.f75859t.b(it.next());
        }
        if (this.f75856q && this.f75847h.isEmpty()) {
            this.f75859t.d();
        }
        z();
    }

    @Override // com.google.android.libraries.places.internal.zzbix
    public final void a(zzbiw zzbiwVar, final zzbmg zzbmgVar) {
        ImmutableList immutableList = this.f75842c;
        Set set = this.f75846g;
        Executor executor = this.f75843d;
        this.f75854o = new zzatg(this, new zzatx(new zzatm(zzbiwVar, immutableList, set, executor)));
        this.f75855p = zzbmgVar;
        executor.execute(zzsc.a(new Runnable() { // from class: com.google.android.libraries.places.internal.zzasq
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f75792a.i(zzbmgVar);
            }
        }));
    }

    @Override // com.google.android.libraries.places.internal.zzbix
    public final void b(final Object obj) {
        this.f75843d.execute(zzsc.a(new Runnable() { // from class: com.google.android.libraries.places.internal.zzasv
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f75802a.m(obj);
            }
        }));
    }

    @Override // com.google.android.libraries.places.internal.zzbix
    public final void c(final int i3) {
        synchronized (this.f75852m) {
            this.f75853n += i3;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        Queue queue = this.f75852m;
        synchronized (queue) {
            try {
                if (!queue.isEmpty()) {
                    int i4 = this.f75853n;
                    for (int i5 = 0; i5 < i4; i5++) {
                        Object objPoll = queue.poll();
                        if (objPoll != null) {
                            arrayDeque.add(objPoll);
                            this.f75853n--;
                        }
                    }
                    boolean zIsEmpty = queue.isEmpty();
                    Iterator it = arrayDeque.iterator();
                    while (it.hasNext()) {
                        this.f75854o.b(it.next());
                    }
                    if (zIsEmpty) {
                        this.f75854o.c(zzbnp.f76488e, null);
                    }
                }
            } finally {
            }
        }
        this.f75843d.execute(zzsc.a(new Runnable() { // from class: com.google.android.libraries.places.internal.zzasy
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f75810a.p(i3);
            }
        }));
    }

    @Override // com.google.android.libraries.places.internal.zzbix
    public final void d() {
        this.f75843d.execute(zzsc.a(new Runnable() { // from class: com.google.android.libraries.places.internal.zzasz
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f75812a.q();
            }
        }));
    }

    @Override // com.google.android.libraries.places.internal.zzbix
    public final void e(final String str, final Throwable th) {
        this.f75843d.execute(zzsc.a(new Runnable() { // from class: com.google.android.libraries.places.internal.zzata
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f75814a.r(str, th);
            }
        }));
    }

    final /* synthetic */ void l(ListenableFuture listenableFuture) {
        this.f75844e.remove(listenableFuture);
    }

    final /* synthetic */ void m(Object obj) {
        this.f75847h.add(new zzath(this, obj, null));
        B();
    }

    final /* synthetic */ void p(int i3) {
        if (this.f75858s) {
            return;
        }
        if (this.f75851l.g() == 4) {
            this.f75859t.c(i3);
        } else {
            this.f75850k += i3;
        }
    }

    final /* synthetic */ void q() {
        if (this.f75858s) {
            return;
        }
        this.f75856q = true;
        h();
    }

    final /* synthetic */ void r(String str, Throwable th) {
        Iterator it = this.f75844e.iterator();
        while (it.hasNext()) {
            ((ListenableFuture) it.next()).cancel(true);
        }
        zzbix zzbixVar = this.f75859t;
        if (zzbixVar != null) {
            zzbixVar.e(str, th);
        }
    }

    final /* synthetic */ void s(Runnable runnable) {
        try {
            runnable.run();
        } catch (Throwable th) {
            this.f75858s = true;
            zzbiw zzbiwVar = this.f75854o;
            if (zzbiwVar != null) {
                zzbiwVar.c(zzbnp.b(th), new zzbmg());
                if (this.f75859t == null || this.f75851l.g() != 4) {
                    return;
                }
                this.f75859t.e(null, th);
            }
        }
    }

    final /* synthetic */ Executor t() {
        return this.f75843d;
    }

    final /* synthetic */ zzatj u() {
        return this.f75851l;
    }

    final /* synthetic */ zzati v() {
        return this.f75857r;
    }
}
