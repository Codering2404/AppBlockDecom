package org.commonmark.internal.inline;

import org.commonmark.node.Emphasis;
import org.commonmark.node.Node;
import org.commonmark.node.Nodes;
import org.commonmark.node.SourceSpans;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;
import org.commonmark.parser.delimiter.DelimiterProcessor;
import org.commonmark.parser.delimiter.DelimiterRun;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class EmphasisDelimiterProcessor implements DelimiterProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final char f145474a;

    protected EmphasisDelimiterProcessor(char c3) {
        this.f145474a = c3;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public char a() {
        return this.f145474a;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public int b() {
        return 1;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public char c() {
        return this.f145474a;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public int d(DelimiterRun delimiterRun, DelimiterRun delimiterRun2) {
        Node emphasis;
        if ((delimiterRun.c() || delimiterRun2.g()) && delimiterRun2.f() % 3 != 0 && (delimiterRun.f() + delimiterRun2.f()) % 3 == 0) {
            return 0;
        }
        int i3 = 2;
        if (delimiterRun.length() < 2 || delimiterRun2.length() < 2) {
            emphasis = new Emphasis(String.valueOf(this.f145474a));
            i3 = 1;
        } else {
            emphasis = new StrongEmphasis(String.valueOf(this.f145474a) + this.f145474a);
        }
        SourceSpans sourceSpansC = SourceSpans.c();
        sourceSpansC.b(delimiterRun.a(i3));
        Text textD = delimiterRun.d();
        for (Node node : Nodes.a(textD, delimiterRun2.b())) {
            emphasis.c(node);
            sourceSpansC.a(node.h());
        }
        sourceSpansC.b(delimiterRun2.e(i3));
        emphasis.l(sourceSpansC.d());
        textD.i(emphasis);
        return i3;
    }
}
