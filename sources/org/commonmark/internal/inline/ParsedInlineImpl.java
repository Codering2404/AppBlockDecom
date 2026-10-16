package org.commonmark.internal.inline;

import org.commonmark.node.Node;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class ParsedInlineImpl extends ParsedInline {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Node f145485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Position f145486b;

    ParsedInlineImpl(Node node, Position position) {
        this.f145485a = node;
        this.f145486b = position;
    }

    public Node c() {
        return this.f145485a;
    }

    public Position d() {
        return this.f145486b;
    }
}
