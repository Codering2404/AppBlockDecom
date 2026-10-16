package androidx.compose.foundation.shape;

import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
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
public final class AbsoluteCutCornerShape extends CornerBasedShape {
    public AbsoluteCutCornerShape(CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4) {
        super(cornerSize, cornerSize2, cornerSize3, cornerSize4);
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    public Outline d(long j3, float f3, float f4, float f5, float f6, LayoutDirection layoutDirection) {
        if (f3 + f4 + f6 + f5 == 0.0f) {
            return new Outline.Rectangle(SizeKt.c(j3));
        }
        Path pathA = AndroidPath_androidKt.a();
        pathA.a(0.0f, f3);
        pathA.c(f3, 0.0f);
        int i3 = (int) (j3 >> 32);
        pathA.c(Float.intBitsToFloat(i3) - f4, 0.0f);
        pathA.c(Float.intBitsToFloat(i3), f4);
        int i4 = (int) (j3 & 4294967295L);
        pathA.c(Float.intBitsToFloat(i3), Float.intBitsToFloat(i4) - f5);
        pathA.c(Float.intBitsToFloat(i3) - f5, Float.intBitsToFloat(i4));
        pathA.c(f6, Float.intBitsToFloat(i4));
        pathA.c(0.0f, Float.intBitsToFloat(i4) - f6);
        pathA.close();
        return new Outline.Generic(pathA);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbsoluteCutCornerShape)) {
            return false;
        }
        AbsoluteCutCornerShape absoluteCutCornerShape = (AbsoluteCutCornerShape) obj;
        return Intrinsics.areEqual(h(), absoluteCutCornerShape.h()) && Intrinsics.areEqual(g(), absoluteCutCornerShape.g()) && Intrinsics.areEqual(e(), absoluteCutCornerShape.e()) && Intrinsics.areEqual(f(), absoluteCutCornerShape.f());
    }

    public int hashCode() {
        return (((((h().hashCode() * 31) + g().hashCode()) * 31) + e().hashCode()) * 31) + f().hashCode();
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public AbsoluteCutCornerShape b(CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4) {
        return new AbsoluteCutCornerShape(cornerSize, cornerSize2, cornerSize3, cornerSize4);
    }

    public String toString() {
        return "AbsoluteCutCornerShape(topLeft = " + h() + ", topRight = " + g() + ", bottomRight = " + e() + ", bottomLeft = " + f() + ')';
    }
}
