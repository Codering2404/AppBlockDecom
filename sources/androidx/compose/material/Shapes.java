package androidx.compose.material;

import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class Shapes {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CornerBasedShape f13754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CornerBasedShape f13755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CornerBasedShape f13756c;

    public Shapes(CornerBasedShape cornerBasedShape, CornerBasedShape cornerBasedShape2, CornerBasedShape cornerBasedShape3) {
        this.f13754a = cornerBasedShape;
        this.f13755b = cornerBasedShape2;
        this.f13756c = cornerBasedShape3;
    }

    public static /* synthetic */ Shapes b(Shapes shapes, CornerBasedShape cornerBasedShape, CornerBasedShape cornerBasedShape2, CornerBasedShape cornerBasedShape3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            cornerBasedShape = shapes.f13754a;
        }
        if ((i3 & 2) != 0) {
            cornerBasedShape2 = shapes.f13755b;
        }
        if ((i3 & 4) != 0) {
            cornerBasedShape3 = shapes.f13756c;
        }
        return shapes.a(cornerBasedShape, cornerBasedShape2, cornerBasedShape3);
    }

    public final Shapes a(CornerBasedShape cornerBasedShape, CornerBasedShape cornerBasedShape2, CornerBasedShape cornerBasedShape3) {
        return new Shapes(cornerBasedShape, cornerBasedShape2, cornerBasedShape3);
    }

    public final CornerBasedShape c() {
        return this.f13756c;
    }

    public final CornerBasedShape d() {
        return this.f13755b;
    }

    public final CornerBasedShape e() {
        return this.f13754a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Shapes)) {
            return false;
        }
        Shapes shapes = (Shapes) obj;
        return Intrinsics.areEqual(this.f13754a, shapes.f13754a) && Intrinsics.areEqual(this.f13755b, shapes.f13755b) && Intrinsics.areEqual(this.f13756c, shapes.f13756c);
    }

    public int hashCode() {
        return (((this.f13754a.hashCode() * 31) + this.f13755b.hashCode()) * 31) + this.f13756c.hashCode();
    }

    public String toString() {
        return "Shapes(small=" + this.f13754a + ", medium=" + this.f13755b + ", large=" + this.f13756c + ')';
    }

    public /* synthetic */ Shapes(CornerBasedShape cornerBasedShape, CornerBasedShape cornerBasedShape2, CornerBasedShape cornerBasedShape3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? RoundedCornerShapeKt.d(Dp.g(4)) : cornerBasedShape, (i3 & 2) != 0 ? RoundedCornerShapeKt.d(Dp.g(4)) : cornerBasedShape2, (i3 & 4) != 0 ? RoundedCornerShapeKt.d(Dp.g(0)) : cornerBasedShape3);
    }
}
