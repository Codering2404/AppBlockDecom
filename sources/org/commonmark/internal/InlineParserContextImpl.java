package org.commonmark.internal;

import java.util.List;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.parser.InlineParserContext;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class InlineParserContextImpl implements InlineParserContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f145423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkReferenceDefinitions f145424b;

    public InlineParserContextImpl(List list, LinkReferenceDefinitions linkReferenceDefinitions) {
        this.f145423a = list;
        this.f145424b = linkReferenceDefinitions;
    }

    @Override // org.commonmark.parser.InlineParserContext
    public LinkReferenceDefinition a(String str) {
        return this.f145424b.b(str);
    }

    @Override // org.commonmark.parser.InlineParserContext
    public List b() {
        return this.f145423a;
    }
}
