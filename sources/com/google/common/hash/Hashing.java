package com.google.common.hash;

import com.google.errorprone.annotations.Immutable;
import java.util.Arrays;
import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class Hashing {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f85100a = (int) System.currentTimeMillis();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Immutable
    enum ChecksumType implements ImmutableSupplier<Checksum> {
        CRC_32("Hashing.crc32()") { // from class: com.google.common.hash.Hashing.ChecksumType.1
            @Override // com.google.common.base.Supplier
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Checksum get() {
                return new CRC32();
            }
        },
        ADLER_32("Hashing.adler32()") { // from class: com.google.common.hash.Hashing.ChecksumType.2
            @Override // com.google.common.base.Supplier
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Checksum get() {
                return new Adler32();
            }
        };


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HashFunction f85104a;

        ChecksumType(String str) {
            this.f85104a = new ChecksumHashFunction(this, 32, str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ConcatenatedHashFunction extends AbstractCompositeHashFunction {
        @Override // com.google.common.hash.HashFunction
        public int a() {
            int iA = 0;
            for (HashFunction hashFunction : this.f85047a) {
                iA += hashFunction.a();
            }
            return iA;
        }

        @Override // com.google.common.hash.AbstractCompositeHashFunction
        HashCode e(Hasher[] hasherArr) {
            byte[] bArr = new byte[a() / 8];
            int iJ = 0;
            for (Hasher hasher : hasherArr) {
                HashCode hashCodeI = hasher.i();
                iJ += hashCodeI.j(bArr, iJ, hashCodeI.d() / 8);
            }
            return HashCode.f(bArr);
        }

        public boolean equals(Object obj) {
            if (obj instanceof ConcatenatedHashFunction) {
                return Arrays.equals(this.f85047a, ((ConcatenatedHashFunction) obj).f85047a);
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(this.f85047a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class LinearCongruentialGenerator {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Md5Holder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final HashFunction f85105a = new MessageDigestHashFunction("MD5", "Hashing.md5()");
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Sha1Holder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final HashFunction f85106a = new MessageDigestHashFunction("SHA-1", "Hashing.sha1()");
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Sha256Holder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final HashFunction f85107a = new MessageDigestHashFunction("SHA-256", "Hashing.sha256()");
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Sha384Holder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final HashFunction f85108a = new MessageDigestHashFunction("SHA-384", "Hashing.sha384()");
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Sha512Holder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final HashFunction f85109a = new MessageDigestHashFunction("SHA-512", "Hashing.sha512()");
    }

    public static HashFunction a() {
        return Murmur3_128HashFunction.f85138b;
    }
}
