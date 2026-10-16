package androidx.compose.ui.draw;

import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@JvmInline
public final class BlurredEdgeTreatment {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f25380b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Shape f25381c = d(RectangleShapeKt.a());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Shape f25382d = d(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Shape f25383a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Shape a() {
            return BlurredEdgeTreatment.f25381c;
        }

        public final Shape b() {
            return BlurredEdgeTreatment.f25382d;
        }

        private Companion() {
        }
    }

    private /* synthetic */ BlurredEdgeTreatment(Shape shape) {
        this.f25383a = shape;
    }

    public static final /* synthetic */ BlurredEdgeTreatment c(Shape shape) {
        return new BlurredEdgeTreatment(shape);
    }

    public static boolean e(Shape shape, Object obj) {
        return (obj instanceof BlurredEdgeTreatment) && Intrinsics.areEqual(shape, ((BlurredEdgeTreatment) obj).h());
    }

    public static int f(Shape shape) {
        if (shape == null) {
            return 0;
        }
        return shape.hashCode();
    }

    public static String g(Shape shape) {
        return "BlurredEdgeTreatment(shape=" + shape + ')';
    }

    public boolean equals(Object obj) {
        return e(this.f25383a, obj);
    }

    public final /* synthetic */ Shape h() {
        return this.f25383a;
    }

    public int hashCode() {
        return f(this.f25383a);
    }

    public String toString() {
        return g(this.f25383a);
    }

    public static Shape d(Shape shape) {
        return shape;
    }
}
