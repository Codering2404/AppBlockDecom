package com.google.common.collect;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Serialization;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public class ImmutableSetMultimap<K, V> extends ImmutableMultimap<K, V> implements SetMultimap<K, V> {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final transient ImmutableSet f84122i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private transient ImmutableSet f84123j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder<K, V> extends ImmutableMultimap.Builder<K, V> {
        @Override // com.google.common.collect.ImmutableMultimap.Builder
        ImmutableCollection.Builder c(int i3) {
            Comparator comparator = this.f84066c;
            return comparator == null ? ImmutableSet.p(i3) : new ImmutableSortedSet.Builder(comparator, i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final transient ImmutableSetMultimap f84124c;

        EntrySet(ImmutableSetMultimap immutableSetMultimap) {
            this.f84124c = immutableSetMultimap;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.f84124c.w1(entry.getKey(), entry.getValue());
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean g() {
            return false;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        /* JADX INFO: renamed from: h */
        public UnmodifiableIterator iterator() {
            return this.f84124c.i();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f84124c.size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        Object writeReplace() {
            return super.writeReplace();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SetFieldSettersHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Serialization.FieldSetter f84125a = Serialization.a(ImmutableSetMultimap.class, "emptySet");
    }

    ImmutableSetMultimap(ImmutableMap immutableMap, int i3, Comparator comparator) {
        super(immutableMap, i3);
        this.f84122i = x(comparator);
    }

    private static ImmutableSet.Builder C(Comparator comparator) {
        return comparator == null ? new ImmutableSet.Builder() : new ImmutableSortedSet.Builder(comparator);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        int i3 = objectInputStream.readInt();
        if (i3 < 0) {
            throw new InvalidObjectException("Invalid key count " + i3);
        }
        ImmutableMap.Builder builderA = ImmutableMap.a();
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            Object object = objectInputStream.readObject();
            Objects.requireNonNull(object);
            int i6 = objectInputStream.readInt();
            if (i6 <= 0) {
                throw new InvalidObjectException("Invalid value count " + i6);
            }
            ImmutableSet.Builder builderC = C(comparator);
            for (int i7 = 0; i7 < i6; i7++) {
                Object object2 = objectInputStream.readObject();
                Objects.requireNonNull(object2);
                builderC.e(object2);
            }
            ImmutableSet immutableSetN = builderC.n();
            if (immutableSetN.size() != i6) {
                throw new InvalidObjectException("Duplicate key-value pairs exist for key " + object);
            }
            builderA.g(object, immutableSetN);
            i4 += i6;
        }
        try {
            ImmutableMultimap.FieldSettersHolder.f84069a.b(this, builderA.d());
            ImmutableMultimap.FieldSettersHolder.f84070b.a(this, i4);
            SetFieldSettersHolder.f84125a.b(this, x(comparator));
        } catch (IllegalArgumentException e3) {
            throw ((InvalidObjectException) new InvalidObjectException(e3.getMessage()).initCause(e3));
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(B());
        Serialization.j(this, objectOutputStream);
    }

    private static ImmutableSet x(Comparator comparator) {
        return comparator == null ? ImmutableSet.z() : ImmutableSortedSet.M(comparator);
    }

    @Override // com.google.common.collect.ImmutableMultimap
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public final ImmutableSet a(Object obj) {
        throw new UnsupportedOperationException();
    }

    Comparator B() {
        ImmutableSet immutableSet = this.f84122i;
        if (immutableSet instanceof ImmutableSortedSet) {
            return ((ImmutableSortedSet) immutableSet).comparator();
        }
        return null;
    }

    @Override // com.google.common.collect.ImmutableMultimap
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public ImmutableSet b() {
        ImmutableSet immutableSet = this.f84123j;
        if (immutableSet != null) {
            return immutableSet;
        }
        EntrySet entrySet = new EntrySet(this);
        this.f84123j = entrySet;
        return entrySet;
    }

    @Override // com.google.common.collect.ImmutableMultimap
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public ImmutableSet get(Object obj) {
        return (ImmutableSet) MoreObjects.a((ImmutableSet) this.f84055g.get(obj), this.f84122i);
    }
}
