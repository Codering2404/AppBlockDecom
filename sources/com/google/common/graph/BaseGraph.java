package com.google.common.graph;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
interface BaseGraph<N> extends SuccessorsFunction<N>, PredecessorsFunction<N> {
    @Override // com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    Set a(Object obj);

    Set b();

    Set c(Object obj);

    boolean d();

    boolean e();

    Set f();

    int g(Object obj);

    Set h(Object obj);

    int i(Object obj);

    int j(Object obj);

    Set k(Object obj);
}
