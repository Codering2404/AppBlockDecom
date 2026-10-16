package org.commonmark.internal.inline;

import org.commonmark.node.Node;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class ParsedInline {
    protected ParsedInline() {
    }

    public static ParsedInline a() {
        return null;
    }

    public static ParsedInline b(Node node, Position position) {
        if (node == null) {
            throw new NullPointerException("node must not be null");
        }
        if (position != null) {
            return new ParsedInlineImpl(node, position);
        }
        throw new NullPointerException("position must not be null");
    }
}
