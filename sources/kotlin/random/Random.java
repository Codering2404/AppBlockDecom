package kotlin.random;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public abstract class Random {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Default f140182a = new Default(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Random f140183b = PlatformImplementationsKt.f139928a.b();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Default extends Random implements Serializable {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        private static final class Serialized implements Serializable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final Serialized f140184a = new Serialized();
            private static final long serialVersionUID = 0;

            private Serialized() {
            }

            private final Object readResolve() {
                return Random.f140182a;
            }
        }

        public /* synthetic */ Default(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
            throw new InvalidObjectException("Deserialization is supported via proxy only");
        }

        private final Object writeReplace() {
            return Serialized.f140184a;
        }

        @Override // kotlin.random.Random
        public int b(int i3) {
            return Random.f140183b.b(i3);
        }

        @Override // kotlin.random.Random
        public boolean c() {
            return Random.f140183b.c();
        }

        @Override // kotlin.random.Random
        public byte[] d(byte[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            return Random.f140183b.d(array);
        }

        @Override // kotlin.random.Random
        public byte[] e(byte[] array, int i3, int i4) {
            Intrinsics.checkNotNullParameter(array, "array");
            return Random.f140183b.e(array, i3, i4);
        }

        @Override // kotlin.random.Random
        public double f() {
            return Random.f140183b.f();
        }

        @Override // kotlin.random.Random
        public double g(double d3, double d4) {
            return Random.f140183b.g(d3, d4);
        }

        @Override // kotlin.random.Random
        public float h() {
            return Random.f140183b.h();
        }

        @Override // kotlin.random.Random
        public int i() {
            return Random.f140183b.i();
        }

        @Override // kotlin.random.Random
        public int j(int i3) {
            return Random.f140183b.j(i3);
        }

        @Override // kotlin.random.Random
        public int k(int i3, int i4) {
            return Random.f140183b.k(i3, i4);
        }

        @Override // kotlin.random.Random
        public long l() {
            return Random.f140183b.l();
        }

        @Override // kotlin.random.Random
        public long m(long j3, long j4) {
            return Random.f140183b.m(j3, j4);
        }

        private Default() {
        }
    }

    public abstract int b(int i3);

    public boolean c() {
        return b(1) != 0;
    }

    public byte[] d(byte[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return e(array, 0, array.length);
    }

    public byte[] e(byte[] array, int i3, int i4) {
        Intrinsics.checkNotNullParameter(array, "array");
        if (i3 < 0 || i3 > array.length || i4 < 0 || i4 > array.length) {
            throw new IllegalArgumentException(("fromIndex (" + i3 + ") or toIndex (" + i4 + ") are out of range: 0.." + array.length + '.').toString());
        }
        if (i3 > i4) {
            throw new IllegalArgumentException(("fromIndex (" + i3 + ") must be not greater than toIndex (" + i4 + ").").toString());
        }
        int i5 = (i4 - i3) / 4;
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = i();
            array[i3] = (byte) i7;
            array[i3 + 1] = (byte) (i7 >>> 8);
            array[i3 + 2] = (byte) (i7 >>> 16);
            array[i3 + 3] = (byte) (i7 >>> 24);
            i3 += 4;
        }
        int i8 = i4 - i3;
        int iB = b(i8 * 8);
        for (int i9 = 0; i9 < i8; i9++) {
            array[i3 + i9] = (byte) (iB >>> (i9 * 8));
        }
        return array;
    }

    public double f() {
        return PlatformRandomKt.a(b(26), b(27));
    }

    public double g(double d3, double d4) {
        double dF;
        RandomKt.c(d3, d4);
        double d5 = d4 - d3;
        if (!Double.isInfinite(d5) || Math.abs(d3) > Double.MAX_VALUE || Math.abs(d4) > Double.MAX_VALUE) {
            dF = d3 + (f() * d5);
        } else {
            double d6 = 2;
            double dF2 = f() * ((d4 / d6) - (d3 / d6));
            dF = d3 + dF2 + dF2;
        }
        return dF >= d4 ? Math.nextAfter(d4, Double.NEGATIVE_INFINITY) : dF;
    }

    public float h() {
        return b(24) / 1.6777216E7f;
    }

    public int i() {
        return b(32);
    }

    public int j(int i3) {
        return k(0, i3);
    }

    public int k(int i3, int i4) {
        int i5;
        int i6;
        int iB;
        RandomKt.d(i3, i4);
        int i7 = i4 - i3;
        if (i7 > 0 || i7 == Integer.MIN_VALUE) {
            if (((-i7) & i7) == i7) {
                iB = b(RandomKt.f(i7));
            } else {
                do {
                    i5 = i() >>> 1;
                    i6 = i5 % i7;
                } while ((i5 - i6) + (i7 - 1) < 0);
                iB = i6;
            }
            return i3 + iB;
        }
        while (true) {
            int i8 = i();
            if (i3 <= i8 && i8 < i4) {
                return i8;
            }
        }
    }

    public long l() {
        return (((long) i()) << 32) + ((long) i());
    }

    public long m(long j3, long j4) {
        long jL;
        long j5;
        long jB;
        int i3;
        RandomKt.e(j3, j4);
        long j6 = j4 - j3;
        if (j6 > 0) {
            if (((-j6) & j6) == j6) {
                int i4 = (int) j6;
                int i5 = (int) (j6 >>> 32);
                if (i4 != 0) {
                    i3 = b(RandomKt.f(i4));
                } else if (i5 == 1) {
                    i3 = i();
                } else {
                    jB = (((long) b(RandomKt.f(i5))) << 32) + (((long) i()) & 4294967295L);
                }
                jB = ((long) i3) & 4294967295L;
            } else {
                do {
                    jL = l() >>> 1;
                    j5 = jL % j6;
                } while ((jL - j5) + (j6 - 1) < 0);
                jB = j5;
            }
            return j3 + jB;
        }
        while (true) {
            long jL2 = l();
            if (j3 <= jL2 && jL2 < j4) {
                return jL2;
            }
        }
    }
}
