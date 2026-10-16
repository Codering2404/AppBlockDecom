package com.google.common.graph;

import com.google.errorprone.annotations.DoNotMock;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@DoNotMock
@ElementTypesAreNonnullByDefault
public interface Graph<N> extends BaseGraph<N> {
    @Override // 
    Set a(Object obj);

    @Override // com.google.common.graph.BaseGraph
    Set b();

    Set c(Object obj);

    boolean d();

    boolean e();

    Set f();

    @Override // com.google.common.graph.BaseGraph
    int g(Object obj);

    @Override // com.google.common.graph.BaseGraph
    int i(Object obj);

    @Override // com.google.common.graph.BaseGraph
    Set k(Object obj);
}
