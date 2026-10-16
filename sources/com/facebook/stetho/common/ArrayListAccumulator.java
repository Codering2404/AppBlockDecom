package com.facebook.stetho.common;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ArrayListAccumulator<E> extends ArrayList<E> implements Accumulator<E> {
    @Override // com.facebook.stetho.common.Accumulator
    public void store(E e3) {
        add(e3);
    }
}
