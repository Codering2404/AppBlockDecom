package kotlin.time;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import kotlin.Metadata;
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
public final class Instant implements Comparable<Instant>, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f140650c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Instant f140651d = new Instant(-31557014167219200L, 0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Instant f140652f = new Instant(31556889864403199L, 999999999);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f140653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f140654b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Instant a(long j3, int i3) {
            return b(j3, i3);
        }

        public final Instant b(long j3, long j4) {
            long j5 = j4 / 1000000000;
            if ((j4 ^ 1000000000) < 0 && j5 * 1000000000 != j4) {
                j5--;
            }
            long j6 = j3 + j5;
            if ((j3 ^ j6) < 0 && (j5 ^ j3) >= 0) {
                return j3 > 0 ? Instant.f140650c.c() : Instant.f140650c.d();
            }
            if (j6 < -31557014167219200L) {
                return d();
            }
            if (j6 > 31556889864403199L) {
                return c();
            }
            long j7 = j4 % 1000000000;
            return new Instant(j6, (int) (j7 + ((((j7 ^ 1000000000) & ((-j7) | j7)) >> 63) & 1000000000)));
        }

        public final Instant c() {
            return Instant.f140652f;
        }

        public final Instant d() {
            return Instant.f140651d;
        }

        private Companion() {
        }
    }

    public Instant(long j3, int i3) {
        this.f140653a = j3;
        this.f140654b = i3;
        if (-31557014167219200L > j3 || j3 >= 31556889864403200L) {
            throw new IllegalArgumentException("Instant exceeds minimum or maximum instant");
        }
    }

    private final void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final Object writeReplace() {
        return InstantJvmKt.a(this);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(Instant other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iCompare = Intrinsics.compare(this.f140653a, other.f140653a);
        return iCompare != 0 ? iCompare : Intrinsics.compare(this.f140654b, other.f140654b);
    }

    public final long d() {
        return this.f140653a;
    }

    public final int e() {
        return this.f140654b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Instant)) {
            return false;
        }
        Instant instant = (Instant) obj;
        return this.f140653a == instant.f140653a && this.f140654b == instant.f140654b;
    }

    public int hashCode() {
        return Long.hashCode(this.f140653a) + (this.f140654b * 51);
    }

    public String toString() {
        return InstantKt.b(this);
    }
}
