package com.applovin.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.applovin.impl.a9;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l3 f59953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ia f59954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f59955c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CopyOnWriteArraySet f59956d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ArrayDeque f59957e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ArrayDeque f59958f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f59959g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface a {
        void a(Object obj);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface b {
        void a(Object obj, a9 a9Var);
    }

    public gc(Looper looper, l3 l3Var, b bVar) {
        this(new CopyOnWriteArraySet(), looper, l3Var, bVar);
    }

    private gc(CopyOnWriteArraySet copyOnWriteArraySet, Looper looper, l3 l3Var, b bVar) {
        this.f59953a = l3Var;
        this.f59956d = copyOnWriteArraySet;
        this.f59955c = bVar;
        this.f59957e = new ArrayDeque();
        this.f59958f = new ArrayDeque();
        this.f59954b = l3Var.a(looper, new Handler.Callback() { // from class: com.applovin.impl.jx
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f60825a.a(message);
            }
        });
    }

    public void a(Object obj) {
        if (this.f59959g) {
            return;
        }
        b1.a(obj);
        this.f59956d.add(new c(obj));
    }

    public void b() {
        Iterator it = this.f59956d.iterator();
        while (it.hasNext()) {
            ((c) it.next()).b(this.f59955c);
        }
        this.f59956d.clear();
        this.f59959g = true;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f59960a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private a9.b f59961b = new a9.b();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f59962c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f59963d;

        public c(Object obj) {
            this.f59960a = obj;
        }

        public void a(int i3, a aVar) {
            if (this.f59963d) {
                return;
            }
            if (i3 != -1) {
                this.f59961b.a(i3);
            }
            this.f59962c = true;
            aVar.a(this.f59960a);
        }

        public void b(b bVar) {
            this.f59963d = true;
            if (this.f59962c) {
                bVar.a(this.f59960a, this.f59961b.a());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            return this.f59960a.equals(((c) obj).f59960a);
        }

        public int hashCode() {
            return this.f59960a.hashCode();
        }

        public void a(b bVar) {
            if (this.f59963d || !this.f59962c) {
                return;
            }
            a9 a9VarA = this.f59961b.a();
            this.f59961b = new a9.b();
            this.f59962c = false;
            bVar.a(this.f59960a, a9VarA);
        }
    }

    public void a() {
        if (this.f59958f.isEmpty()) {
            return;
        }
        if (!this.f59954b.a(0)) {
            ia iaVar = this.f59954b;
            iaVar.a(iaVar.d(0));
        }
        boolean zIsEmpty = this.f59957e.isEmpty();
        this.f59957e.addAll(this.f59958f);
        this.f59958f.clear();
        if (zIsEmpty) {
            while (!this.f59957e.isEmpty()) {
                ((Runnable) this.f59957e.peekFirst()).run();
                this.f59957e.removeFirst();
            }
        }
    }

    public void b(Object obj) {
        for (c cVar : this.f59956d) {
            if (cVar.f59960a.equals(obj)) {
                cVar.b(this.f59955c);
                this.f59956d.remove(cVar);
            }
        }
    }

    public void b(int i3, a aVar) {
        a(i3, aVar);
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Message message) {
        Iterator it = this.f59956d.iterator();
        while (it.hasNext()) {
            ((c) it.next()).a(this.f59955c);
            if (this.f59954b.a(0)) {
                return true;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(CopyOnWriteArraySet copyOnWriteArraySet, int i3, a aVar) {
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ((c) it.next()).a(i3, aVar);
        }
    }

    public void a(final int i3, final a aVar) {
        final CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet(this.f59956d);
        this.f59958f.add(new Runnable() { // from class: com.applovin.impl.kx
            @Override // java.lang.Runnable
            public final void run() {
                gc.a(copyOnWriteArraySet, i3, aVar);
            }
        });
    }

    public gc a(Looper looper, b bVar) {
        return new gc(this.f59956d, looper, this.f59953a, bVar);
    }
}
