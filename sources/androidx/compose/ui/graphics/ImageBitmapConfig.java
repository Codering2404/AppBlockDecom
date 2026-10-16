package androidx.compose.ui.graphics;

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
public final class ImageBitmapConfig {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f25784b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f25785c = g(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f25786d = g(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f25787e = g(2);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f25788f = g(3);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f25789g = g(4);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f25790a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return ImageBitmapConfig.f25786d;
        }

        public final int b() {
            return ImageBitmapConfig.f25785c;
        }

        public final int c() {
            return ImageBitmapConfig.f25788f;
        }

        public final int d() {
            return ImageBitmapConfig.f25789g;
        }

        public final int e() {
            return ImageBitmapConfig.f25787e;
        }

        private Companion() {
        }
    }

    private /* synthetic */ ImageBitmapConfig(int i3) {
        this.f25790a = i3;
    }

    public static final /* synthetic */ ImageBitmapConfig f(int i3) {
        return new ImageBitmapConfig(i3);
    }

    public static boolean h(int i3, Object obj) {
        return (obj instanceof ImageBitmapConfig) && i3 == ((ImageBitmapConfig) obj).l();
    }

    public static final boolean i(int i3, int i4) {
        return i3 == i4;
    }

    public static int j(int i3) {
        return Integer.hashCode(i3);
    }

    public static String k(int i3) {
        return i(i3, f25785c) ? "Argb8888" : i(i3, f25786d) ? "Alpha8" : i(i3, f25787e) ? "Rgb565" : i(i3, f25788f) ? "F16" : i(i3, f25789g) ? "Gpu" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }

    public boolean equals(Object obj) {
        return h(this.f25790a, obj);
    }

    public int hashCode() {
        return j(this.f25790a);
    }

    public final /* synthetic */ int l() {
        return this.f25790a;
    }

    public String toString() {
        return k(this.f25790a);
    }

    public static int g(int i3) {
        return i3;
    }
}
