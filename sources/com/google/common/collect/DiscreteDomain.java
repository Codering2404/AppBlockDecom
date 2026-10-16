package com.google.common.collect;

import com.google.android.gms.common.api.Api;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.lang.Comparable;
import java.math.BigInteger;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class DiscreteDomain<C extends Comparable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f83901a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class BigIntegerDomain extends DiscreteDomain<BigInteger> implements Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final BigIntegerDomain f83902b = new BigIntegerDomain();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final BigInteger f83903c = BigInteger.valueOf(Long.MIN_VALUE);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final BigInteger f83904d = BigInteger.valueOf(Long.MAX_VALUE);
        private static final long serialVersionUID = 0;

        BigIntegerDomain() {
            super(true);
        }

        private Object readResolve() {
            return f83902b;
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public long a(BigInteger bigInteger, BigInteger bigInteger2) {
            return bigInteger2.subtract(bigInteger).max(f83903c).min(f83904d).longValue();
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public BigInteger d(BigInteger bigInteger) {
            return bigInteger.add(BigInteger.ONE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.DiscreteDomain
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public BigInteger e(BigInteger bigInteger, long j3) {
            CollectPreconditions.c(j3, "distance");
            return bigInteger.add(BigInteger.valueOf(j3));
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public BigInteger f(BigInteger bigInteger) {
            return bigInteger.subtract(BigInteger.ONE);
        }

        public String toString() {
            return "DiscreteDomain.bigIntegers()";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class IntegerDomain extends DiscreteDomain<Integer> implements Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final IntegerDomain f83905b = new IntegerDomain();
        private static final long serialVersionUID = 0;

        IntegerDomain() {
            super(true);
        }

        private Object readResolve() {
            return f83905b;
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public long a(Integer num, Integer num2) {
            return ((long) num2.intValue()) - ((long) num.intValue());
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Integer b() {
            return Integer.valueOf(Api.BaseClientBuilder.API_PRIORITY_OTHER);
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Integer c() {
            return Integer.MIN_VALUE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Integer d(Integer num) {
            int iIntValue = num.intValue();
            if (iIntValue == Integer.MAX_VALUE) {
                return null;
            }
            return Integer.valueOf(iIntValue + 1);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.DiscreteDomain
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public Integer e(Integer num, long j3) {
            CollectPreconditions.c(j3, "distance");
            return Integer.valueOf(Ints.d(num.longValue() + j3));
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public Integer f(Integer num) {
            int iIntValue = num.intValue();
            if (iIntValue == Integer.MIN_VALUE) {
                return null;
            }
            return Integer.valueOf(iIntValue - 1);
        }

        public String toString() {
            return "DiscreteDomain.integers()";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class LongDomain extends DiscreteDomain<Long> implements Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final LongDomain f83906b = new LongDomain();
        private static final long serialVersionUID = 0;

        LongDomain() {
            super(true);
        }

        private Object readResolve() {
            return f83906b;
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public long a(Long l3, Long l4) {
            long jLongValue = l4.longValue() - l3.longValue();
            if (l4.longValue() > l3.longValue() && jLongValue < 0) {
                return Long.MAX_VALUE;
            }
            if (l4.longValue() >= l3.longValue() || jLongValue <= 0) {
                return jLongValue;
            }
            return Long.MIN_VALUE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Long b() {
            return Long.MAX_VALUE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Long c() {
            return Long.MIN_VALUE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Long d(Long l3) {
            long jLongValue = l3.longValue();
            if (jLongValue == Long.MAX_VALUE) {
                return null;
            }
            return Long.valueOf(jLongValue + 1);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.DiscreteDomain
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public Long e(Long l3, long j3) {
            CollectPreconditions.c(j3, "distance");
            long jLongValue = l3.longValue() + j3;
            if (jLongValue < 0) {
                Preconditions.e(l3.longValue() < 0, "overflow");
            }
            return Long.valueOf(jLongValue);
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public Long f(Long l3) {
            long jLongValue = l3.longValue();
            if (jLongValue == Long.MIN_VALUE) {
                return null;
            }
            return Long.valueOf(jLongValue - 1);
        }

        public String toString() {
            return "DiscreteDomain.longs()";
        }
    }

    public abstract long a(Comparable comparable, Comparable comparable2);

    public Comparable b() {
        throw new NoSuchElementException();
    }

    public Comparable c() {
        throw new NoSuchElementException();
    }

    public abstract Comparable d(Comparable comparable);

    Comparable e(Comparable comparable, long j3) {
        CollectPreconditions.c(j3, "distance");
        Comparable comparableD = comparable;
        for (long j4 = 0; j4 < j3; j4++) {
            comparableD = d(comparableD);
            if (comparableD == null) {
                throw new IllegalArgumentException("overflowed computing offset(" + comparable + ", " + j3 + ")");
            }
        }
        return comparableD;
    }

    public abstract Comparable f(Comparable comparable);

    protected DiscreteDomain() {
        this(false);
    }

    private DiscreteDomain(boolean z2) {
        this.f83901a = z2;
    }
}
