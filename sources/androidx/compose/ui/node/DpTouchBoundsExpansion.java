package androidx.compose.ui.node;

import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
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
public final class DpTouchBoundsExpansion {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f27318f = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f27319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f27320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f27321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f27322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f27323e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public /* synthetic */ DpTouchBoundsExpansion(float f3, float f4, float f5, float f6, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f3, f4, f5, f6, z2);
    }

    public final long a(Density density) {
        return TouchBoundsExpansion.d(TouchBoundsExpansion.f27637b.c(density.z0(this.f27319a), density.z0(this.f27320b), density.z0(this.f27321c), density.z0(this.f27322d), this.f27323e));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DpTouchBoundsExpansion)) {
            return false;
        }
        DpTouchBoundsExpansion dpTouchBoundsExpansion = (DpTouchBoundsExpansion) obj;
        return Dp.i(this.f27319a, dpTouchBoundsExpansion.f27319a) && Dp.i(this.f27320b, dpTouchBoundsExpansion.f27320b) && Dp.i(this.f27321c, dpTouchBoundsExpansion.f27321c) && Dp.i(this.f27322d, dpTouchBoundsExpansion.f27322d) && this.f27323e == dpTouchBoundsExpansion.f27323e;
    }

    public int hashCode() {
        return (((((((Dp.j(this.f27319a) * 31) + Dp.j(this.f27320b)) * 31) + Dp.j(this.f27321c)) * 31) + Dp.j(this.f27322d)) * 31) + Boolean.hashCode(this.f27323e);
    }

    public String toString() {
        return "DpTouchBoundsExpansion(start=" + ((Object) Dp.k(this.f27319a)) + ", top=" + ((Object) Dp.k(this.f27320b)) + ", end=" + ((Object) Dp.k(this.f27321c)) + ", bottom=" + ((Object) Dp.k(this.f27322d)) + ", isLayoutDirectionAware=" + this.f27323e + ')';
    }

    private DpTouchBoundsExpansion(float f3, float f4, float f5, float f6, boolean z2) {
        this.f27319a = f3;
        this.f27320b = f4;
        this.f27321c = f5;
        this.f27322d = f6;
        this.f27323e = z2;
        if (!(f3 >= 0.0f)) {
            InlineClassHelperKt.a("Left must be non-negative");
        }
        if (!(f4 >= 0.0f)) {
            InlineClassHelperKt.a("Top must be non-negative");
        }
        if (!(f5 >= 0.0f)) {
            InlineClassHelperKt.a("Right must be non-negative");
        }
        if (f6 >= 0.0f) {
            return;
        }
        InlineClassHelperKt.a("Bottom must be non-negative");
    }
}
