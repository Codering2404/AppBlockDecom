package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class FixedDpInsets implements WindowInsets {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f6773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f6774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f6775d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f6776e;

    public /* synthetic */ FixedDpInsets(float f3, float f4, float f5, float f6, DefaultConstructorMarker defaultConstructorMarker) {
        this(f3, f4, f5, f6);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int a(Density density) {
        return density.z0(this.f6774c);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int b(Density density, LayoutDirection layoutDirection) {
        return density.z0(this.f6775d);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int c(Density density) {
        return density.z0(this.f6776e);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int d(Density density, LayoutDirection layoutDirection) {
        return density.z0(this.f6773b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FixedDpInsets)) {
            return false;
        }
        FixedDpInsets fixedDpInsets = (FixedDpInsets) obj;
        return Dp.i(this.f6773b, fixedDpInsets.f6773b) && Dp.i(this.f6774c, fixedDpInsets.f6774c) && Dp.i(this.f6775d, fixedDpInsets.f6775d) && Dp.i(this.f6776e, fixedDpInsets.f6776e);
    }

    public int hashCode() {
        return (((((Dp.j(this.f6773b) * 31) + Dp.j(this.f6774c)) * 31) + Dp.j(this.f6775d)) * 31) + Dp.j(this.f6776e);
    }

    public String toString() {
        return "Insets(left=" + ((Object) Dp.k(this.f6773b)) + ", top=" + ((Object) Dp.k(this.f6774c)) + ", right=" + ((Object) Dp.k(this.f6775d)) + ", bottom=" + ((Object) Dp.k(this.f6776e)) + ')';
    }

    private FixedDpInsets(float f3, float f4, float f5, float f6) {
        this.f6773b = f3;
        this.f6774c = f4;
        this.f6775d = f5;
        this.f6776e = f6;
    }
}
