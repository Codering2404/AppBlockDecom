package androidx.compose.foundation.shape;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

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
public abstract class CornerBasedShape implements Shape {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CornerSize f9020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CornerSize f9021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CornerSize f9022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CornerSize f9023d;

    public CornerBasedShape(CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4) {
        this.f9020a = cornerSize;
        this.f9021b = cornerSize2;
        this.f9022c = cornerSize3;
        this.f9023d = cornerSize4;
    }

    public static /* synthetic */ CornerBasedShape c(CornerBasedShape cornerBasedShape, CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
        }
        if ((i3 & 1) != 0) {
            cornerSize = cornerBasedShape.f9020a;
        }
        if ((i3 & 2) != 0) {
            cornerSize2 = cornerBasedShape.f9021b;
        }
        if ((i3 & 4) != 0) {
            cornerSize3 = cornerBasedShape.f9022c;
        }
        if ((i3 & 8) != 0) {
            cornerSize4 = cornerBasedShape.f9023d;
        }
        return cornerBasedShape.b(cornerSize, cornerSize2, cornerSize3, cornerSize4);
    }

    public final CornerBasedShape a(CornerSize cornerSize) {
        return b(cornerSize, cornerSize, cornerSize, cornerSize);
    }

    public abstract CornerBasedShape b(CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4);

    @Override // androidx.compose.ui.graphics.Shape
    /* JADX INFO: renamed from: createOutline-Pq9zytI */
    public final Outline mo29createOutlinePq9zytI(long j3, LayoutDirection layoutDirection, Density density) {
        float fA = this.f9020a.a(j3, density);
        float fA2 = this.f9021b.a(j3, density);
        float fA3 = this.f9022c.a(j3, density);
        float fA4 = this.f9023d.a(j3, density);
        float fH = Size.h(j3);
        float f3 = fA + fA4;
        if (f3 > fH) {
            float f4 = fH / f3;
            fA *= f4;
            fA4 *= f4;
        }
        float f5 = fA2 + fA3;
        if (f5 > fH) {
            float f6 = fH / f5;
            fA2 *= f6;
            fA3 *= f6;
        }
        if (!(fA >= 0.0f && fA2 >= 0.0f && fA3 >= 0.0f && fA4 >= 0.0f)) {
            InlineClassHelperKt.a("Corner size in Px can't be negative(topStart = " + fA + ", topEnd = " + fA2 + ", bottomEnd = " + fA3 + ", bottomStart = " + fA4 + ")!");
        }
        return d(j3, fA, fA2, fA3, fA4, layoutDirection);
    }

    public abstract Outline d(long j3, float f3, float f4, float f5, float f6, LayoutDirection layoutDirection);

    public final CornerSize e() {
        return this.f9022c;
    }

    public final CornerSize f() {
        return this.f9023d;
    }

    public final CornerSize g() {
        return this.f9021b;
    }

    public final CornerSize h() {
        return this.f9020a;
    }
}
