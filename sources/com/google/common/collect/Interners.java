package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMakerInternalMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class Interners {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class InternerBuilder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class InternerFunction<E> implements Function<E, E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Interner f84157a;

        @Override // com.google.common.base.Function
        public Object apply(Object obj) {
            return this.f84157a.a(obj);
        }

        @Override // com.google.common.base.Function
        public boolean equals(Object obj) {
            if (obj instanceof InternerFunction) {
                return this.f84157a.equals(((InternerFunction) obj).f84157a);
            }
            return false;
        }

        public int hashCode() {
            return this.f84157a.hashCode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class InternerImpl<E> implements Interner<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MapMakerInternalMap f84158a;

        @Override // com.google.common.collect.Interner
        public Object a(Object obj) {
            Object key;
            do {
                MapMakerInternalMap.InternalEntry internalEntryC = this.f84158a.c(obj);
                if (internalEntryC != null && (key = internalEntryC.getKey()) != null) {
                    return key;
                }
            } while (((MapMaker.Dummy) this.f84158a.putIfAbsent(obj, MapMaker.Dummy.VALUE)) != null);
            return obj;
        }
    }
}
