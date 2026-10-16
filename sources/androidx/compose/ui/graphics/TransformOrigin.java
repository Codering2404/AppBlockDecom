package androidx.compose.ui.graphics;

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
public final class TransformOrigin {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f25955b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f25956c = TransformOriginKt.a(0.5f, 0.5f);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f25957a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return TransformOrigin.f25956c;
        }

        private Companion() {
        }
    }

    private /* synthetic */ TransformOrigin(long j3) {
        this.f25957a = j3;
    }

    public static final /* synthetic */ TransformOrigin b(long j3) {
        return new TransformOrigin(j3);
    }

    public static boolean d(long j3, Object obj) {
        return (obj instanceof TransformOrigin) && j3 == ((TransformOrigin) obj).j();
    }

    public static final boolean e(long j3, long j4) {
        return j3 == j4;
    }

    public static final float f(long j3) {
        return Float.intBitsToFloat((int) (j3 >> 32));
    }

    public static final float g(long j3) {
        return Float.intBitsToFloat((int) (j3 & 4294967295L));
    }

    public static int h(long j3) {
        return Long.hashCode(j3);
    }

    public static String i(long j3) {
        return "TransformOrigin(packedValue=" + j3 + ')';
    }

    public boolean equals(Object obj) {
        return d(this.f25957a, obj);
    }

    public int hashCode() {
        return h(this.f25957a);
    }

    public final /* synthetic */ long j() {
        return this.f25957a;
    }

    public String toString() {
        return i(this.f25957a);
    }

    public static long c(long j3) {
        return j3;
    }
}
