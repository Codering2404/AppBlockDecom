package androidx.compose.material3;

import com.facebook.FacebookContentProvider;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@JvmInline
public final class SliderRange {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f20181b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f20182c = SliderKt.i(Float.NaN, Float.NaN);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f20183a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return SliderRange.f20182c;
        }

        private Companion() {
        }
    }

    private /* synthetic */ SliderRange(long j3) {
        this.f20183a = j3;
    }

    public static final /* synthetic */ SliderRange b(long j3) {
        return new SliderRange(j3);
    }

    public static boolean d(long j3, Object obj) {
        return (obj instanceof SliderRange) && j3 == ((SliderRange) obj).j();
    }

    public static final boolean e(long j3, long j4) {
        return j3 == j4;
    }

    public static final float f(long j3) {
        if (j3 != f20182c) {
            return Float.intBitsToFloat((int) (j3 & 4294967295L));
        }
        throw new IllegalStateException("SliderRange is unspecified");
    }

    public static final float g(long j3) {
        if (j3 != f20182c) {
            return Float.intBitsToFloat((int) (j3 >> 32));
        }
        throw new IllegalStateException("SliderRange is unspecified");
    }

    public static int h(long j3) {
        return Long.hashCode(j3);
    }

    public static String i(long j3) {
        if (!SliderKt.x(j3)) {
            return "FloatRange.Unspecified";
        }
        return g(j3) + FacebookContentProvider.INVALID_FILE_NAME + f(j3);
    }

    public boolean equals(Object obj) {
        return d(this.f20183a, obj);
    }

    public int hashCode() {
        return h(this.f20183a);
    }

    public final /* synthetic */ long j() {
        return this.f20183a;
    }

    public String toString() {
        return i(this.f20183a);
    }

    public static long c(long j3) {
        return j3;
    }
}
