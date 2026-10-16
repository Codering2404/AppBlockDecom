package com.google.common.reflect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ForwardingMapEntry;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.Iterators;
import com.google.common.reflect.MutableTypeToInstanceMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class MutableTypeToInstanceMap<B> extends ForwardingMap<TypeToken<? extends B>, B> implements TypeToInstanceMap<B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f85543a;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class UnmodifiableEntry<K, V> extends ForwardingMapEntry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map.Entry f85544a;

        private UnmodifiableEntry(Map.Entry entry) {
            this.f85544a = (Map.Entry) Preconditions.t(entry);
        }

        public static /* synthetic */ UnmodifiableEntry T1(Map.Entry entry) {
            return new UnmodifiableEntry(entry);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Iterator b2(Iterator it) {
            return Iterators.N(it, new Function() { // from class: com.google.common.reflect.a
                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    return MutableTypeToInstanceMap.UnmodifiableEntry.T1((Map.Entry) obj);
                }
            });
        }

        static Set c2(final Set set) {
            return new ForwardingSet<Map.Entry<Object, Object>>() { // from class: com.google.common.reflect.MutableTypeToInstanceMap.UnmodifiableEntry.1
                @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                public Iterator iterator() {
                    return UnmodifiableEntry.b2(super.iterator());
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection
                public Set k2() {
                    return set;
                }

                @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
                public Object[] toArray() {
                    return b2();
                }

                @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
                public Object[] toArray(Object[] objArr) {
                    return c2(objArr);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
        /* JADX INFO: renamed from: I1 */
        public Map.Entry k2() {
            return this.f85544a;
        }

        @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
        public Object setValue(Object obj) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    /* JADX INFO: renamed from: I1 */
    public Map k2() {
        return this.f85543a;
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    /* JADX INFO: renamed from: c2, reason: merged with bridge method [inline-methods] */
    public Object put(TypeToken typeToken, Object obj) {
        throw new UnsupportedOperationException("Please use putInstance() instead.");
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public Set entrySet() {
        return UnmodifiableEntry.c2(super.entrySet());
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public void putAll(Map map) {
        throw new UnsupportedOperationException("Please use putInstance() instead.");
    }
}
