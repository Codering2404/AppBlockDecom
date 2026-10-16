package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzatm extends zzbke {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ImmutableList f75863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LinkedHashMap f75864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Queue f75865d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LinkedHashMap f75866e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Set f75867f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f75868g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f75869h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f75870i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private zzbmg f75871j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private zzbnp f75872k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private zzbmg f75873l;

    zzatm(zzbiw zzbiwVar, ImmutableList immutableList, Set set, Executor executor) {
        super(zzbiwVar);
        this.f75864c = new LinkedHashMap();
        this.f75865d = new ArrayDeque();
        this.f75866e = new LinkedHashMap();
        this.f75863b = immutableList;
        this.f75868g = immutableList.size();
        this.f75867f = set;
    }

    private final boolean f() {
        return !this.f75864c.isEmpty();
    }

    private final void g() {
        if (this.f75869h) {
            Queue<zzatl> queue = this.f75865d;
            for (zzatl zzatlVar : queue) {
                Iterator it = Lists.o(this.f75863b.subList(0, zzatlVar.d())).iterator();
                while (it.hasNext()) {
                    Iterator it2 = Lists.o((List) it.next()).iterator();
                    while (it2.hasNext()) {
                        if (this.f75867f.contains((zzasm) it2.next())) {
                            Preconditions.u(zzatlVar.c(), "Response message cannot be null");
                        }
                    }
                    if (!zzatlVar.a()) {
                        return;
                    } else {
                        zzatlVar.e(zzatlVar.d() - 1);
                    }
                }
            }
            while (!queue.isEmpty() && ((zzatl) queue.peek()).b()) {
                e().b(((zzatl) queue.poll()).c());
            }
            h();
        }
    }

    private final void h() {
        if (!f() && this.f75865d.isEmpty() && this.f75870i) {
            Iterator it = Lists.o(this.f75863b).iterator();
            while (it.hasNext()) {
                for (zzasm zzasmVar : Lists.o((List) it.next())) {
                    zzbnp zzbnpVar = this.f75872k;
                    zzbmg zzbmgVar = this.f75873l;
                    this.f75867f.contains(zzasmVar);
                }
            }
            if (this.f75866e.isEmpty()) {
                e().c(this.f75872k, this.f75873l);
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbiw
    public final void a(zzbmg zzbmgVar) {
        this.f75871j = zzbmgVar;
        Iterator it = Lists.o(this.f75863b.subList(0, this.f75868g)).iterator();
        while (it.hasNext()) {
            this.f75868g--;
            Iterator it2 = Lists.o((List) it.next()).iterator();
            while (it2.hasNext()) {
                this.f75867f.contains((zzasm) it2.next());
            }
            if (f()) {
                return;
            }
        }
        e().a(this.f75871j);
        this.f75869h = true;
        g();
    }

    @Override // com.google.android.libraries.places.internal.zzbiw
    public final void b(Object obj) {
        this.f75865d.add(new zzatl(this, obj, this.f75863b.size()));
        g();
    }

    @Override // com.google.android.libraries.places.internal.zzbiw
    public final void c(zzbnp zzbnpVar, zzbmg zzbmgVar) {
        this.f75872k = zzbnpVar;
        this.f75873l = zzbmgVar;
        this.f75870i = true;
        h();
    }
}
