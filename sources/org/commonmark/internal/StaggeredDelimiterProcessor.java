package org.commonmark.internal;

import java.util.LinkedList;
import java.util.ListIterator;
import org.commonmark.parser.delimiter.DelimiterProcessor;
import org.commonmark.parser.delimiter.DelimiterRun;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
class StaggeredDelimiterProcessor implements DelimiterProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final char f145467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f145468b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LinkedList f145469c = new LinkedList();

    StaggeredDelimiterProcessor(char c3) {
        this.f145467a = c3;
    }

    private DelimiterProcessor f(int i3) {
        for (DelimiterProcessor delimiterProcessor : this.f145469c) {
            if (delimiterProcessor.b() <= i3) {
                return delimiterProcessor;
            }
        }
        return (DelimiterProcessor) this.f145469c.getFirst();
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public char a() {
        return this.f145467a;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public int b() {
        return this.f145468b;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public char c() {
        return this.f145467a;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public int d(DelimiterRun delimiterRun, DelimiterRun delimiterRun2) {
        return f(delimiterRun.length()).d(delimiterRun, delimiterRun2);
    }

    void e(DelimiterProcessor delimiterProcessor) {
        int iB = delimiterProcessor.b();
        ListIterator listIterator = this.f145469c.listIterator();
        while (listIterator.hasNext()) {
            DelimiterProcessor delimiterProcessor2 = (DelimiterProcessor) listIterator.next();
            int iB2 = delimiterProcessor2.b();
            if (iB > iB2) {
                listIterator.previous();
                listIterator.add(delimiterProcessor);
                return;
            } else if (iB == iB2) {
                throw new IllegalArgumentException("Cannot add two delimiter processors for char '" + this.f145467a + "' and minimum length " + iB + "; conflicting processors: " + delimiterProcessor2 + ", " + delimiterProcessor);
            }
        }
        this.f145469c.add(delimiterProcessor);
        this.f145468b = iB;
    }
}
