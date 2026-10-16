package com.google.common.graph;

import com.google.errorprone.annotations.DoNotMock;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@DoNotMock
@ElementTypesAreNonnullByDefault
public interface Network<N, E> extends SuccessorsFunction<N>, PredecessorsFunction<N> {
    @Override // com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    Set a(Object obj);

    Set b();

    Set c(Object obj);

    boolean d();

    boolean e();

    Set f();

    Set h(Object obj);

    boolean l();

    EndpointPair n(Object obj);
}
