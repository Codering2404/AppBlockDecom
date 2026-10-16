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
public final class PathFillType {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f25834b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f25835c = d(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f25836d = d(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f25837a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return PathFillType.f25836d;
        }

        public final int b() {
            return PathFillType.f25835c;
        }

        private Companion() {
        }
    }

    private /* synthetic */ PathFillType(int i3) {
        this.f25837a = i3;
    }

    public static final /* synthetic */ PathFillType c(int i3) {
        return new PathFillType(i3);
    }

    public static boolean e(int i3, Object obj) {
        return (obj instanceof PathFillType) && i3 == ((PathFillType) obj).i();
    }

    public static final boolean f(int i3, int i4) {
        return i3 == i4;
    }

    public static int g(int i3) {
        return Integer.hashCode(i3);
    }

    public static String h(int i3) {
        return f(i3, f25835c) ? "NonZero" : f(i3, f25836d) ? "EvenOdd" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }

    public boolean equals(Object obj) {
        return e(this.f25837a, obj);
    }

    public int hashCode() {
        return g(this.f25837a);
    }

    public final /* synthetic */ int i() {
        return this.f25837a;
    }

    public String toString() {
        return h(this.f25837a);
    }

    public static int d(int i3) {
        return i3;
    }
}
