package org.commonmark.ext.gfm.strikethrough.internal;

import org.commonmark.ext.gfm.strikethrough.Strikethrough;
import org.commonmark.node.Node;
import org.commonmark.node.Nodes;
import org.commonmark.node.SourceSpans;
import org.commonmark.node.Text;
import org.commonmark.parser.delimiter.DelimiterProcessor;
import org.commonmark.parser.delimiter.DelimiterRun;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class StrikethroughDelimiterProcessor implements DelimiterProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f145358a;

    public StrikethroughDelimiterProcessor(boolean z2) {
        this.f145358a = z2;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public char a() {
        return '~';
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public int b() {
        return this.f145358a ? 2 : 1;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public char c() {
        return '~';
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public int d(DelimiterRun delimiterRun, DelimiterRun delimiterRun2) {
        if (delimiterRun.length() != delimiterRun2.length() || delimiterRun.length() > 2) {
            return 0;
        }
        Text textD = delimiterRun.d();
        Strikethrough strikethrough = new Strikethrough();
        SourceSpans sourceSpans = new SourceSpans();
        sourceSpans.b(delimiterRun.a(delimiterRun.length()));
        for (Node node : Nodes.a(textD, delimiterRun2.b())) {
            strikethrough.c(node);
            sourceSpans.a(node.h());
        }
        sourceSpans.b(delimiterRun2.e(delimiterRun2.length()));
        strikethrough.l(sourceSpans.d());
        textD.i(strikethrough);
        return delimiterRun.length();
    }
}
