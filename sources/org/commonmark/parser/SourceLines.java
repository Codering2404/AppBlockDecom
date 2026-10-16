package org.commonmark.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.commonmark.node.SourceSpan;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class SourceLines {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f145567a = new ArrayList();

    public static SourceLines b() {
        return new SourceLines();
    }

    public static SourceLines g(List list) {
        SourceLines sourceLines = new SourceLines();
        sourceLines.f145567a.addAll(list);
        return sourceLines;
    }

    public static SourceLines h(SourceLine sourceLine) {
        SourceLines sourceLines = new SourceLines();
        sourceLines.a(sourceLine);
        return sourceLines;
    }

    public void a(SourceLine sourceLine) {
        this.f145567a.add(sourceLine);
    }

    public String c() {
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < this.f145567a.size(); i3++) {
            if (i3 != 0) {
                sb.append('\n');
            }
            sb.append(((SourceLine) this.f145567a.get(i3)).a());
        }
        return sb.toString();
    }

    public List d() {
        return this.f145567a;
    }

    public List e() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f145567a.iterator();
        while (it.hasNext()) {
            SourceSpan sourceSpanB = ((SourceLine) it.next()).b();
            if (sourceSpanB != null) {
                arrayList.add(sourceSpanB);
            }
        }
        return arrayList;
    }

    public boolean f() {
        return this.f145567a.isEmpty();
    }
}
