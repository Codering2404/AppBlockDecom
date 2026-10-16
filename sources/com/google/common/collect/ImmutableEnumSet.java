package com.google.common.collect;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.Enum;
import java.util.Collection;
import java.util.EnumSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class ImmutableEnumSet<E extends Enum<E>> extends ImmutableSet<E> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final transient EnumSet f84012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private transient int f84013d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class EnumSerializedForm<E extends Enum<E>> implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final EnumSet f84014a;

        EnumSerializedForm(EnumSet enumSet) {
            this.f84014a = enumSet;
        }

        Object readResolve() {
            return new ImmutableEnumSet(this.f84014a.clone());
        }
    }

    static ImmutableSet I(EnumSet enumSet) {
        int size = enumSet.size();
        return size != 0 ? size != 1 ? new ImmutableEnumSet(enumSet) : ImmutableSet.A((Enum) Iterables.m(enumSet)) : ImmutableSet.z();
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f84012c.contains(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        if (collection instanceof ImmutableEnumSet) {
            collection = ((ImmutableEnumSet) collection).f84012c;
        }
        return this.f84012c.containsAll(collection);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableEnumSet) {
            obj = ((ImmutableEnumSet) obj).f84012c;
        }
        return this.f84012c.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean g() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    /* JADX INFO: renamed from: h */
    public UnmodifiableIterator iterator() {
        return Iterators.O(this.f84012c.iterator());
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        int i3 = this.f84013d;
        if (i3 != 0) {
            return i3;
        }
        int iHashCode = this.f84012c.hashCode();
        this.f84013d = iHashCode;
        return iHashCode;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f84012c.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f84012c.size();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return this.f84012c.toString();
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new EnumSerializedForm(this.f84012c);
    }

    @Override // com.google.common.collect.ImmutableSet
    boolean y() {
        return true;
    }

    private ImmutableEnumSet(EnumSet enumSet) {
        this.f84012c = enumSet;
    }
}
