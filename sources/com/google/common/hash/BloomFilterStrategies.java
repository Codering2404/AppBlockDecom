package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.BloomFilter;
import com.google.common.primitives.Longs;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
enum BloomFilterStrategies implements BloomFilter.Strategy {
    MURMUR128_MITZ_32 { // from class: com.google.common.hash.BloomFilterStrategies.1
        @Override // com.google.common.hash.BloomFilter.Strategy
        public boolean O(Object obj, Funnel funnel, int i3, LockFreeBitArray lockFreeBitArray) {
            long jA = lockFreeBitArray.a();
            long jC = Hashing.a().c(obj, funnel).c();
            int i4 = (int) jC;
            int i5 = (int) (jC >>> 32);
            for (int i6 = 1; i6 <= i3; i6++) {
                int i7 = (i6 * i5) + i4;
                if (i7 < 0) {
                    i7 = ~i7;
                }
                if (!lockFreeBitArray.b(((long) i7) % jA)) {
                    return false;
                }
            }
            return true;
        }
    },
    MURMUR128_MITZ_64 { // from class: com.google.common.hash.BloomFilterStrategies.2
        private long b(byte[] bArr) {
            return Longs.d(bArr[7], bArr[6], bArr[5], bArr[4], bArr[3], bArr[2], bArr[1], bArr[0]);
        }

        private long c(byte[] bArr) {
            return Longs.d(bArr[15], bArr[14], bArr[13], bArr[12], bArr[11], bArr[10], bArr[9], bArr[8]);
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public boolean O(Object obj, Funnel funnel, int i3, LockFreeBitArray lockFreeBitArray) {
            long jA = lockFreeBitArray.a();
            byte[] bArrI = Hashing.a().c(obj, funnel).i();
            long jB = b(bArrI);
            long jC = c(bArrI);
            for (int i4 = 0; i4 < i3; i4++) {
                if (!lockFreeBitArray.b((Long.MAX_VALUE & jB) % jA)) {
                    return false;
                }
                jB += jC;
            }
            return true;
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class LockFreeBitArray {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AtomicLongArray f85066a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final LongAddable f85067b;

        LockFreeBitArray(long[] jArr) {
            Preconditions.e(jArr.length > 0, "data length is zero!");
            this.f85066a = new AtomicLongArray(jArr);
            this.f85067b = LongAddables.a();
            long jBitCount = 0;
            for (long j3 : jArr) {
                jBitCount += (long) Long.bitCount(j3);
            }
            this.f85067b.add(jBitCount);
        }

        public static long[] c(AtomicLongArray atomicLongArray) {
            int length = atomicLongArray.length();
            long[] jArr = new long[length];
            for (int i3 = 0; i3 < length; i3++) {
                jArr[i3] = atomicLongArray.get(i3);
            }
            return jArr;
        }

        long a() {
            return ((long) this.f85066a.length()) * 64;
        }

        boolean b(long j3) {
            return ((1 << ((int) j3)) & this.f85066a.get((int) (j3 >>> 6))) != 0;
        }

        public boolean equals(Object obj) {
            if (obj instanceof LockFreeBitArray) {
                return Arrays.equals(c(this.f85066a), c(((LockFreeBitArray) obj).f85066a));
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(c(this.f85066a));
        }
    }
}
