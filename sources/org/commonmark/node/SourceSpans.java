package org.commonmark.node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class SourceSpans {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List f145546a;

    public static SourceSpans c() {
        return new SourceSpans();
    }

    public void a(List list) {
        if (list.isEmpty()) {
            return;
        }
        if (this.f145546a == null) {
            this.f145546a = new ArrayList();
        }
        if (this.f145546a.isEmpty()) {
            this.f145546a.addAll(list);
            return;
        }
        int size = this.f145546a.size() - 1;
        SourceSpan sourceSpan = (SourceSpan) this.f145546a.get(size);
        SourceSpan sourceSpan2 = (SourceSpan) list.get(0);
        if (sourceSpan.c() != sourceSpan2.c() || sourceSpan.a() + sourceSpan.b() != sourceSpan2.a()) {
            this.f145546a.addAll(list);
        } else {
            this.f145546a.set(size, SourceSpan.d(sourceSpan.c(), sourceSpan.a(), sourceSpan.b() + sourceSpan2.b()));
            this.f145546a.addAll(list.subList(1, list.size()));
        }
    }

    public void b(Iterable iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            a(((Node) it.next()).h());
        }
    }

    public List d() {
        List list = this.f145546a;
        return list != null ? list : Collections.EMPTY_LIST;
    }
}
