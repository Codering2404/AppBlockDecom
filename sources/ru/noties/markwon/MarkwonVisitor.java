package ru.noties.markwon;

import org.commonmark.node.Node;
import org.commonmark.node.Visitor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public interface MarkwonVisitor extends Visitor {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Builder {
        MarkwonVisitor a(MarkwonConfiguration markwonConfiguration, RenderProps renderProps);

        Builder b(Class cls, NodeVisitor nodeVisitor);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface NodeVisitor<N extends Node> {
        void a(MarkwonVisitor markwonVisitor, Node node);
    }

    void B();

    SpannableBuilder builder();

    void clear();

    void d(int i3, Object obj);

    void f(Node node);

    boolean i(Node node);

    int length();

    RenderProps q();

    void r(Node node, int i3);

    MarkwonConfiguration x();

    void z();
}
