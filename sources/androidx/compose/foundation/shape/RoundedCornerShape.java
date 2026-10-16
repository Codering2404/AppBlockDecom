package androidx.compose.foundation.shape;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Outline;
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
public final class RoundedCornerShape extends CornerBasedShape {
    public RoundedCornerShape(CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4) {
        super(cornerSize, cornerSize2, cornerSize3, cornerSize4);
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    public Outline d(long j3, float f3, float f4, float f5, float f6, LayoutDirection layoutDirection) {
        if (f3 + f4 + f5 + f6 == 0.0f) {
            return new Outline.Rectangle(SizeKt.c(j3));
        }
        Rect rectC = SizeKt.c(j3);
        LayoutDirection layoutDirection2 = LayoutDirection.f30001a;
        float f7 = layoutDirection == layoutDirection2 ? f3 : f4;
        long jB = CornerRadius.b((((long) Float.floatToRawIntBits(f7)) << 32) | (((long) Float.floatToRawIntBits(f7)) & 4294967295L));
        float f8 = layoutDirection == layoutDirection2 ? f4 : f3;
        long jB2 = CornerRadius.b((((long) Float.floatToRawIntBits(f8)) & 4294967295L) | (((long) Float.floatToRawIntBits(f8)) << 32));
        float f9 = layoutDirection == layoutDirection2 ? f5 : f6;
        long jB3 = CornerRadius.b((((long) Float.floatToRawIntBits(f9)) << 32) | (((long) Float.floatToRawIntBits(f9)) & 4294967295L));
        float f10 = layoutDirection == layoutDirection2 ? f6 : f5;
        return new Outline.Rounded(RoundRectKt.c(rectC, jB, jB2, jB3, CornerRadius.b((((long) Float.floatToRawIntBits(f10)) & 4294967295L) | (((long) Float.floatToRawIntBits(f10)) << 32))));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RoundedCornerShape)) {
            return false;
        }
        RoundedCornerShape roundedCornerShape = (RoundedCornerShape) obj;
        return Intrinsics.areEqual(h(), roundedCornerShape.h()) && Intrinsics.areEqual(g(), roundedCornerShape.g()) && Intrinsics.areEqual(e(), roundedCornerShape.e()) && Intrinsics.areEqual(f(), roundedCornerShape.f());
    }

    public int hashCode() {
        return (((((h().hashCode() * 31) + g().hashCode()) * 31) + e().hashCode()) * 31) + f().hashCode();
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public RoundedCornerShape b(CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4) {
        return new RoundedCornerShape(cornerSize, cornerSize2, cornerSize3, cornerSize4);
    }

    public String toString() {
        return "RoundedCornerShape(topStart = " + h() + ", topEnd = " + g() + ", bottomEnd = " + e() + ", bottomStart = " + f() + ')';
    }
}
