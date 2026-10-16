package com.google.common.hash;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.hash.BloomFilterStrategies;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class BloomFilter<T> implements Predicate<T>, Serializable {
    private static final long serialVersionUID = 912559;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BloomFilterStrategies.LockFreeBitArray f85055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f85056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Funnel f85057c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Strategy f85058d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class SerialForm<T> implements Serializable {
        private static final long serialVersionUID = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final long[] f85059a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f85060b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Funnel f85061c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Strategy f85062d;

        SerialForm(BloomFilter bloomFilter) {
            this.f85059a = BloomFilterStrategies.LockFreeBitArray.c(bloomFilter.f85055a.f85066a);
            this.f85060b = bloomFilter.f85056b;
            this.f85061c = bloomFilter.f85057c;
            this.f85062d = bloomFilter.f85058d;
        }

        Object readResolve() {
            return new BloomFilter(new BloomFilterStrategies.LockFreeBitArray(this.f85059a), this.f85060b, this.f85061c, this.f85062d);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface Strategy extends Serializable {
        boolean O(Object obj, Funnel funnel, int i3, BloomFilterStrategies.LockFreeBitArray lockFreeBitArray);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    private Object writeReplace() {
        return new SerialForm(this);
    }

    @Override // com.google.common.base.Predicate
    public boolean apply(Object obj) {
        return e(obj);
    }

    public boolean e(Object obj) {
        return this.f85058d.O(obj, this.f85057c, this.f85056b, this.f85055a);
    }

    @Override // com.google.common.base.Predicate
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BloomFilter) {
            BloomFilter bloomFilter = (BloomFilter) obj;
            if (this.f85056b == bloomFilter.f85056b && this.f85057c.equals(bloomFilter.f85057c) && this.f85055a.equals(bloomFilter.f85055a) && this.f85058d.equals(bloomFilter.f85058d)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.b(Integer.valueOf(this.f85056b), this.f85057c, this.f85058d, this.f85055a);
    }

    private BloomFilter(BloomFilterStrategies.LockFreeBitArray lockFreeBitArray, int i3, Funnel funnel, Strategy strategy) {
        Preconditions.h(i3 > 0, "numHashFunctions (%s) must be > 0", i3);
        Preconditions.h(i3 <= 255, "numHashFunctions (%s) must be <= 255", i3);
        this.f85055a = (BloomFilterStrategies.LockFreeBitArray) Preconditions.t(lockFreeBitArray);
        this.f85056b = i3;
        this.f85057c = (Funnel) Preconditions.t(funnel);
        this.f85058d = (Strategy) Preconditions.t(strategy);
    }
}
