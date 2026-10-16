package androidx.compose.material;

import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

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
final class BottomAppBarCutoutShape implements Shape {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Shape f12099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FabPlacement f12100b;

    public BottomAppBarCutoutShape(Shape shape, FabPlacement fabPlacement) {
        this.f12099a = shape;
        this.f12100b = fabPlacement;
    }

    private final void a(Path path, LayoutDirection layoutDirection, Density density) {
        float fM1 = density.M1(AppBarKt.f11821e);
        float f3 = 2 * fM1;
        long jA = SizeKt.a(this.f12100b.c() + f3, this.f12100b.a() + f3);
        float fB = this.f12100b.b() - fM1;
        float fI = fB + Size.i(jA);
        float fG = Size.g(jA) / 2.0f;
        OutlineKt.a(path, this.f12099a.mo29createOutlinePq9zytI(jA, layoutDirection, density));
        path.p(OffsetKt.a(fB, -fG));
        if (Intrinsics.areEqual(this.f12099a, RoundedCornerShapeKt.g())) {
            b(path, fB, fI, fG, density.M1(AppBarKt.f11822f), 0.0f);
        }
    }

    private final void b(Path path, float f3, float f4, float f5, float f6, float f7) {
        float f8 = -((float) Math.sqrt((f5 * f5) - (f7 * f7)));
        float f9 = f5 + f8;
        float f10 = f3 + f9;
        float f11 = f4 - f9;
        Pair pairO = AppBarKt.o(f8 - 1.0f, f7, f5);
        float fFloatValue = ((Number) pairO.a()).floatValue() + f5;
        float fFloatValue2 = ((Number) pairO.b()).floatValue() - f7;
        path.a(f10 - f6, 0.0f);
        path.m(f10 - 1.0f, 0.0f, f3 + fFloatValue, fFloatValue2);
        path.c(f4 - fFloatValue, fFloatValue2);
        path.m(f11 + 1.0f, 0.0f, f6 + f11, 0.0f);
        path.close();
    }

    @Override // androidx.compose.ui.graphics.Shape
    /* JADX INFO: renamed from: createOutline-Pq9zytI */
    public Outline mo29createOutlinePq9zytI(long j3, LayoutDirection layoutDirection, Density density) {
        Path pathA = AndroidPath_androidKt.a();
        Path.d(pathA, new Rect(0.0f, 0.0f, Size.i(j3), Size.g(j3)), null, 2, null);
        Path pathA2 = AndroidPath_androidKt.a();
        a(pathA2, layoutDirection, density);
        pathA2.v(pathA, pathA2, PathOperation.f25845b.a());
        return new Outline.Generic(pathA2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BottomAppBarCutoutShape)) {
            return false;
        }
        BottomAppBarCutoutShape bottomAppBarCutoutShape = (BottomAppBarCutoutShape) obj;
        return Intrinsics.areEqual(this.f12099a, bottomAppBarCutoutShape.f12099a) && Intrinsics.areEqual(this.f12100b, bottomAppBarCutoutShape.f12100b);
    }

    public int hashCode() {
        return (this.f12099a.hashCode() * 31) + this.f12100b.hashCode();
    }

    public String toString() {
        return "BottomAppBarCutoutShape(cutoutShape=" + this.f12099a + ", fabPlacement=" + this.f12100b + ')';
    }
}
