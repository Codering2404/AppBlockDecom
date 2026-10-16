package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public class ImmutableListMultimap<K, V> extends ImmutableMultimap<K, V> implements ListMultimap<K, V> {
    private static final long serialVersionUID = 0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder<K, V> extends ImmutableMultimap.Builder<K, V> {
        public ImmutableListMultimap e() {
            return (ImmutableListMultimap) super.a();
        }

        public Builder f(Object obj, Object obj2) {
            super.d(obj, obj2);
            return this;
        }
    }

    ImmutableListMultimap(ImmutableMap immutableMap, int i3) {
        super(immutableMap, i3);
    }

    public static ImmutableListMultimap A() {
        return EmptyImmutableListMultimap.f83908i;
    }

    public static ImmutableListMultimap B(Object obj, Object obj2) {
        Builder builderX = x();
        builderX.f(obj, obj2);
        return builderX.e();
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
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
            ImmutableList.Builder builderO = ImmutableList.o();
            for (int i7 = 0; i7 < i6; i7++) {
                Object object2 = objectInputStream.readObject();
                Objects.requireNonNull(object2);
                builderO.a(object2);
            }
            builderA.g(object, builderO.m());
            i4 += i6;
        }
        try {
            ImmutableMultimap.FieldSettersHolder.f84069a.b(this, builderA.d());
            ImmutableMultimap.FieldSettersHolder.f84070b.a(this, i4);
        } catch (IllegalArgumentException e3) {
            throw ((InvalidObjectException) new InvalidObjectException(e3.getMessage()).initCause(e3));
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Serialization.j(this, objectOutputStream);
    }

    public static Builder x() {
        return new Builder();
    }

    static ImmutableListMultimap y(Collection collection, Comparator comparator) {
        if (collection.isEmpty()) {
            return A();
        }
        ImmutableMap.Builder builder = new ImmutableMap.Builder(collection.size());
        Iterator it = collection.iterator();
        int size = 0;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            ImmutableList.Builder builder2 = (ImmutableList.Builder) entry.getValue();
            ImmutableList immutableListM = comparator == null ? builder2.m() : builder2.n(comparator);
            builder.g(key, immutableListM);
            size += immutableListM.size();
        }
        return new ImmutableListMultimap(builder.d(), size);
    }

    @Override // com.google.common.collect.ImmutableMultimap
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public final ImmutableList a(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultimap
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public ImmutableList get(Object obj) {
        ImmutableList immutableList = (ImmutableList) this.f84055g.get(obj);
        return immutableList == null ? ImmutableList.y() : immutableList;
    }
}
