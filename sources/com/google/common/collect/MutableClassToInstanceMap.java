package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Primitives;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class MutableClassToInstanceMap<B> extends ForwardingMap<Class<? extends B>, B> implements ClassToInstanceMap<B>, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f84529a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SerializedForm<B> implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map f84533a;

        SerializedForm(Map map) {
            this.f84533a = map;
        }

        Object readResolve() {
            return MutableClassToInstanceMap.o2(this.f84533a);
        }
    }

    private MutableClassToInstanceMap(Map map) {
        this.f84529a = (Map) Preconditions.t(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object k2(Class cls, Object obj) {
        return Primitives.b(cls).cast(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map.Entry m2(final Map.Entry entry) {
        return new ForwardingMapEntry<Class<Object>, Object>() { // from class: com.google.common.collect.MutableClassToInstanceMap.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
            /* JADX INFO: renamed from: I1 */
            public Map.Entry k2() {
                return entry;
            }

            @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
            public Object setValue(Object obj) {
                MutableClassToInstanceMap.k2((Class) getKey(), obj);
                return super.setValue(obj);
            }
        };
    }

    public static MutableClassToInstanceMap o2(Map map) {
        return new MutableClassToInstanceMap(map);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    private Object writeReplace() {
        return new SerializedForm(k2());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    /* JADX INFO: renamed from: I1 */
    public Map k2() {
        return this.f84529a;
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public Set entrySet() {
        return new ForwardingSet<Map.Entry<Class<? extends B>, B>>() { // from class: com.google.common.collect.MutableClassToInstanceMap.2
            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return new TransformedIterator<Map.Entry<Class<? extends B>, B>, Map.Entry<Class<? extends B>, B>>(k2().iterator()) { // from class: com.google.common.collect.MutableClassToInstanceMap.2.1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    @Override // com.google.common.collect.TransformedIterator
                    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                    public Map.Entry a(Map.Entry entry) {
                        return MutableClassToInstanceMap.m2(entry);
                    }
                };
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection
            public Set k2() {
                return MutableClassToInstanceMap.this.k2().entrySet();
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

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public void putAll(Map map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            k2((Class) entry.getKey(), entry.getValue());
        }
        super.putAll(linkedHashMap);
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    /* JADX INFO: renamed from: r2, reason: merged with bridge method [inline-methods] */
    public Object put(Class cls, Object obj) {
        k2(cls, obj);
        return super.put(cls, obj);
    }
}
