package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class ImmutableBiMap<K, V> extends ImmutableMap<K, V> implements BiMap<K, V> {
    private static final long serialVersionUID = 912559;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder<K, V> extends ImmutableMap.Builder<K, V> {
        public Builder() {
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public ImmutableBiMap a() {
            return d();
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public ImmutableBiMap c() {
            throw new UnsupportedOperationException("Not supported for bimaps");
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public ImmutableBiMap d() {
            int i3 = this.f84030c;
            if (i3 == 0) {
                return ImmutableBiMap.v();
            }
            if (this.f84028a != null) {
                if (this.f84031d) {
                    this.f84029b = Arrays.copyOf(this.f84029b, i3 * 2);
                }
                ImmutableMap.Builder.k(this.f84029b, this.f84030c, this.f84028a);
            }
            this.f84031d = true;
            return new RegularImmutableBiMap(this.f84029b, this.f84030c);
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public Builder g(Object obj, Object obj2) {
            super.g(obj, obj2);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public Builder h(Map.Entry entry) {
            super.h(entry);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public Builder i(Iterable iterable) {
            super.i(iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public Builder j(Map map) {
            super.j(map);
            return this;
        }

        Builder(int i3) {
            super(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class SerializedForm<K, V> extends ImmutableMap.SerializedForm<K, V> {
        private static final long serialVersionUID = 0;

        SerializedForm(ImmutableBiMap immutableBiMap) {
            super(immutableBiMap);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Builder b(int i3) {
            return new Builder(i3);
        }
    }

    ImmutableBiMap() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static ImmutableBiMap v() {
        return RegularImmutableBiMap.f84572k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public final ImmutableSet h() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.BiMap
    /* JADX INFO: renamed from: u */
    public abstract ImmutableBiMap u1();

    @Override // com.google.common.collect.ImmutableMap, java.util.Map, com.google.common.collect.BiMap
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public ImmutableSet values() {
        return u1().keySet();
    }

    @Override // com.google.common.collect.ImmutableMap
    Object writeReplace() {
        return new SerializedForm(this);
    }
}
