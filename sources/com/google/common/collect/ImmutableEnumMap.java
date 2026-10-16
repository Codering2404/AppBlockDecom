package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.Enum;
import java.util.EnumMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class ImmutableEnumMap<K extends Enum<K>, V> extends ImmutableMap.IteratorBasedImmutableMap<K, V> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final transient EnumMap f84010f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class EnumSerializedForm<K extends Enum<K>, V> implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final EnumMap f84011a;

        EnumSerializedForm(EnumMap enumMap) {
            this.f84011a = enumMap;
        }

        Object readResolve() {
            return new ImmutableEnumMap(this.f84011a);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use EnumSerializedForm");
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean containsKey(Object obj) {
        return this.f84010f.containsKey(obj);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableEnumMap) {
            obj = ((ImmutableEnumMap) obj).f84010f;
        }
        return this.f84010f.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public Object get(Object obj) {
        return this.f84010f.get(obj);
    }

    @Override // com.google.common.collect.ImmutableMap
    boolean k() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableMap
    UnmodifiableIterator l() {
        return Iterators.O(this.f84010f.keySet().iterator());
    }

    @Override // java.util.Map
    public int size() {
        return this.f84010f.size();
    }

    @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
    UnmodifiableIterator t() {
        return Maps.T(this.f84010f.entrySet().iterator());
    }

    @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap, com.google.common.collect.ImmutableMap
    Object writeReplace() {
        return new EnumSerializedForm(this.f84010f);
    }

    private ImmutableEnumMap(EnumMap enumMap) {
        this.f84010f = enumMap;
        Preconditions.d(!enumMap.isEmpty());
    }
}
