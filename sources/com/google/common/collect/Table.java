package com.google.common.collect;

import com.google.errorprone.annotations.DoNotMock;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@DoNotMock
@ElementTypesAreNonnullByDefault
public interface Table<R, C, V> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Cell<R, C, V> {
        Object a();

        Object b();

        Object getValue();
    }

    Map C();

    Set O0();

    void clear();

    boolean containsValue(Object obj);

    boolean equals(Object obj);

    int hashCode();

    Map l();

    int size();

    Collection values();
}
