package com.google.common.collect;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
abstract class ImmutableMapEntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class EntrySetSerializedForm<K, V> implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ImmutableMap f84044a;

        EntrySetSerializedForm(ImmutableMap immutableMap) {
            this.f84044a = immutableMap;
        }

        Object readResolve() {
            return this.f84044a.entrySet();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class RegularEntrySet<K, V> extends ImmutableMapEntrySet<K, V> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final transient ImmutableMap f84045c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final transient ImmutableList f84046d;

        @Override // com.google.common.collect.ImmutableMapEntrySet
        ImmutableMap I() {
            return this.f84045c;
        }

        @Override // com.google.common.collect.ImmutableCollection
        int b(Object[] objArr, int i3) {
            return this.f84046d.b(objArr, i3);
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        /* JADX INFO: renamed from: h */
        public UnmodifiableIterator iterator() {
            return this.f84046d.iterator();
        }

        @Override // com.google.common.collect.ImmutableMapEntrySet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        Object writeReplace() {
            return super.writeReplace();
        }

        @Override // com.google.common.collect.ImmutableSet
        ImmutableList x() {
            return this.f84046d;
        }
    }

    ImmutableMapEntrySet() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use EntrySetSerializedForm");
    }

    abstract ImmutableMap I();

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = I().get(entry.getKey());
            if (obj2 != null && obj2.equals(entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean g() {
        return I().k();
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return I().hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return I().size();
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new EntrySetSerializedForm(I());
    }

    @Override // com.google.common.collect.ImmutableSet
    boolean y() {
        return I().j();
    }
}
