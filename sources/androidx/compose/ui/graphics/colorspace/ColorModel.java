package androidx.compose.ui.graphics.colorspace;

import com.facebook.internal.AnalyticsEvents;
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
public final class ColorModel {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f25969b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f25970c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f25971d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f25972e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long f25973f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f25974a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return ColorModel.f25972e;
        }

        public final long b() {
            return ColorModel.f25970c;
        }

        public final long c() {
            return ColorModel.f25971d;
        }

        private Companion() {
        }
    }

    static {
        long j3 = 3;
        long j4 = j3 << 32;
        f25970c = d((((long) 0) & 4294967295L) | j4);
        f25971d = d((((long) 1) & 4294967295L) | j4);
        f25972e = d(j4 | (((long) 2) & 4294967295L));
        f25973f = d((j3 & 4294967295L) | (((long) 4) << 32));
    }

    public static boolean e(long j3, Object obj) {
        return (obj instanceof ColorModel) && j3 == ((ColorModel) obj).j();
    }

    public static final boolean f(long j3, long j4) {
        return j3 == j4;
    }

    public static final int g(long j3) {
        return (int) (j3 >> 32);
    }

    public static int h(long j3) {
        return Long.hashCode(j3);
    }

    public static String i(long j3) {
        return f(j3, f25970c) ? "Rgb" : f(j3, f25971d) ? "Xyz" : f(j3, f25972e) ? "Lab" : f(j3, f25973f) ? "Cmyk" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }

    public boolean equals(Object obj) {
        return e(this.f25974a, obj);
    }

    public int hashCode() {
        return h(this.f25974a);
    }

    public final /* synthetic */ long j() {
        return this.f25974a;
    }

    public String toString() {
        return i(this.f25974a);
    }

    public static long d(long j3) {
        return j3;
    }
}
