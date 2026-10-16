package org.commonmark.internal;

import java.util.LinkedHashMap;
import java.util.Map;
import org.commonmark.internal.util.Escaping;
import org.commonmark.node.LinkReferenceDefinition;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class LinkReferenceDefinitions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f145454a = new LinkedHashMap();

    public void a(LinkReferenceDefinition linkReferenceDefinition) {
        String strC = Escaping.c(linkReferenceDefinition.p());
        if (this.f145454a.containsKey(strC)) {
            return;
        }
        this.f145454a.put(strC, linkReferenceDefinition);
    }

    public LinkReferenceDefinition b(String str) {
        return (LinkReferenceDefinition) this.f145454a.get(Escaping.c(str));
    }
}
