package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.Poolable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class GroupedLinkedMap<K extends Poolable, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedEntry f66541a = new LinkedEntry();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f66542b = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class LinkedEntry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f66543a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List f66544b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        LinkedEntry f66545c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        LinkedEntry f66546d;

        LinkedEntry() {
            this(null);
        }

        public void a(Object obj) {
            if (this.f66544b == null) {
                this.f66544b = new ArrayList();
            }
            this.f66544b.add(obj);
        }

        public Object b() {
            int iC = c();
            if (iC > 0) {
                return this.f66544b.remove(iC - 1);
            }
            return null;
        }

        public int c() {
            List list = this.f66544b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        LinkedEntry(Object obj) {
            this.f66546d = this;
            this.f66545c = this;
            this.f66543a = obj;
        }
    }

    GroupedLinkedMap() {
    }

    private void b(LinkedEntry linkedEntry) {
        e(linkedEntry);
        LinkedEntry linkedEntry2 = this.f66541a;
        linkedEntry.f66546d = linkedEntry2;
        linkedEntry.f66545c = linkedEntry2.f66545c;
        g(linkedEntry);
    }

    private void c(LinkedEntry linkedEntry) {
        e(linkedEntry);
        LinkedEntry linkedEntry2 = this.f66541a;
        linkedEntry.f66546d = linkedEntry2.f66546d;
        linkedEntry.f66545c = linkedEntry2;
        g(linkedEntry);
    }

    private static void e(LinkedEntry linkedEntry) {
        LinkedEntry linkedEntry2 = linkedEntry.f66546d;
        linkedEntry2.f66545c = linkedEntry.f66545c;
        linkedEntry.f66545c.f66546d = linkedEntry2;
    }

    private static void g(LinkedEntry linkedEntry) {
        linkedEntry.f66545c.f66546d = linkedEntry;
        linkedEntry.f66546d.f66545c = linkedEntry;
    }

    public Object a(Poolable poolable) {
        LinkedEntry linkedEntry = (LinkedEntry) this.f66542b.get(poolable);
        if (linkedEntry == null) {
            linkedEntry = new LinkedEntry(poolable);
            this.f66542b.put(poolable, linkedEntry);
        } else {
            poolable.a();
        }
        b(linkedEntry);
        return linkedEntry.b();
    }

    public void d(Poolable poolable, Object obj) {
        LinkedEntry linkedEntry = (LinkedEntry) this.f66542b.get(poolable);
        if (linkedEntry == null) {
            linkedEntry = new LinkedEntry(poolable);
            c(linkedEntry);
            this.f66542b.put(poolable, linkedEntry);
        } else {
            poolable.a();
        }
        linkedEntry.a(obj);
    }

    public Object f() {
        for (LinkedEntry linkedEntry = this.f66541a.f66546d; !linkedEntry.equals(this.f66541a); linkedEntry = linkedEntry.f66546d) {
            Object objB = linkedEntry.b();
            if (objB != null) {
                return objB;
            }
            e(linkedEntry);
            this.f66542b.remove(linkedEntry.f66543a);
            ((Poolable) linkedEntry.f66543a).a();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        LinkedEntry linkedEntry = this.f66541a.f66545c;
        boolean z2 = false;
        while (!linkedEntry.equals(this.f66541a)) {
            sb.append('{');
            sb.append(linkedEntry.f66543a);
            sb.append(':');
            sb.append(linkedEntry.c());
            sb.append("}, ");
            linkedEntry = linkedEntry.f66545c;
            z2 = true;
        }
        if (z2) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }
}
