package cz.mobilesoft.coreblock.view.compose;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
final class DottedShape implements Shape {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f130471a;

    @Override // androidx.compose.ui.graphics.Shape
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Outline.Generic mo29createOutlinePq9zytI(long j3, LayoutDirection layoutDirection, Density density) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        Path pathA = AndroidPath_androidKt.a();
        int i3 = (int) (j3 >> 32);
        int iD = MathKt.d(Float.intBitsToFloat(i3) / density.M1(this.f130471a));
        float fIntBitsToFloat = Float.intBitsToFloat(i3) / iD;
        long jD = Size.d((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j3 & 4294967295L)))) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat / 2) << 32));
        for (int i4 = 0; i4 < iD; i4++) {
            Path.d(pathA, RectKt.c(Offset.e((((long) Float.floatToRawIntBits(i4 * fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L)), jD), null, 2, null);
        }
        pathA.close();
        return new Outline.Generic(pathA);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DottedShape) && Dp.i(this.f130471a, ((DottedShape) obj).f130471a);
    }

    public int hashCode() {
        return Dp.j(this.f130471a);
    }

    public String toString() {
        return "DottedShape(step=" + Dp.k(this.f130471a) + ")";
    }
}
