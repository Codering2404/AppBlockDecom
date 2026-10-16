package kotlin.ranges;

import com.facebook.FacebookContentProvider;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.internal.UProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

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
public class ULongProgression implements Iterable<ULong>, KMappedMarker {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f140244d = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f140245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f140246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f140247c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public /* synthetic */ ULongProgression(long j3, long j4, long j5, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, j5);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ULongProgression)) {
            return false;
        }
        if (isEmpty() && ((ULongProgression) obj).isEmpty()) {
            return true;
        }
        ULongProgression uLongProgression = (ULongProgression) obj;
        return this.f140245a == uLongProgression.f140245a && this.f140246b == uLongProgression.f140246b && this.f140247c == uLongProgression.f140247c;
    }

    public final long g() {
        return this.f140245a;
    }

    public final long h() {
        return this.f140246b;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j3 = this.f140245a;
        int iB = ((int) ULong.b(j3 ^ ULong.b(j3 >>> 32))) * 31;
        long j4 = this.f140246b;
        int iB2 = (iB + ((int) ULong.b(j4 ^ ULong.b(j4 >>> 32)))) * 31;
        long j5 = this.f140247c;
        return iB2 + ((int) ((j5 >>> 32) ^ j5));
    }

    public boolean isEmpty() {
        long j3 = this.f140247c;
        long j4 = this.f140245a;
        long j5 = this.f140246b;
        return j3 > 0 ? Long.compareUnsigned(j4, j5) > 0 : Long.compareUnsigned(j4, j5) < 0;
    }

    @Override // java.lang.Iterable
    public final Iterator<ULong> iterator() {
        return new ULongProgressionIterator(this.f140245a, this.f140246b, this.f140247c, null);
    }

    public String toString() {
        StringBuilder sb;
        long j3;
        if (this.f140247c > 0) {
            sb = new StringBuilder();
            sb.append((Object) ULong.f(this.f140245a));
            sb.append(FacebookContentProvider.INVALID_FILE_NAME);
            sb.append((Object) ULong.f(this.f140246b));
            sb.append(" step ");
            j3 = this.f140247c;
        } else {
            sb = new StringBuilder();
            sb.append((Object) ULong.f(this.f140245a));
            sb.append(" downTo ");
            sb.append((Object) ULong.f(this.f140246b));
            sb.append(" step ");
            j3 = -this.f140247c;
        }
        sb.append(j3);
        return sb.toString();
    }

    private ULongProgression(long j3, long j4, long j5) {
        if (j5 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j5 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.f140245a = j3;
        this.f140246b = UProgressionUtilKt.c(j3, j4, j5);
        this.f140247c = j5;
    }
}
