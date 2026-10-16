package androidx.compose.material3;

import androidx.compose.foundation.shape.CornerBasedShape;
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
    private final CornerBasedShape f19836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CornerBasedShape f19837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CornerBasedShape f19838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CornerBasedShape f19839d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final CornerBasedShape f19840e;

    public Shapes(CornerBasedShape cornerBasedShape, CornerBasedShape cornerBasedShape2, CornerBasedShape cornerBasedShape3, CornerBasedShape cornerBasedShape4, CornerBasedShape cornerBasedShape5) {
        this.f19836a = cornerBasedShape;
        this.f19837b = cornerBasedShape2;
        this.f19838c = cornerBasedShape3;
        this.f19839d = cornerBasedShape4;
        this.f19840e = cornerBasedShape5;
    }

    public final CornerBasedShape a() {
        return this.f19840e;
    }

    public final CornerBasedShape b() {
        return this.f19836a;
    }

    public final CornerBasedShape c() {
        return this.f19839d;
    }

    public final CornerBasedShape d() {
        return this.f19838c;
    }

    public final CornerBasedShape e() {
        return this.f19837b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Shapes)) {
            return false;
        }
        Shapes shapes = (Shapes) obj;
        return Intrinsics.areEqual(this.f19836a, shapes.f19836a) && Intrinsics.areEqual(this.f19837b, shapes.f19837b) && Intrinsics.areEqual(this.f19838c, shapes.f19838c) && Intrinsics.areEqual(this.f19839d, shapes.f19839d) && Intrinsics.areEqual(this.f19840e, shapes.f19840e);
    }

    public int hashCode() {
        return (((((((this.f19836a.hashCode() * 31) + this.f19837b.hashCode()) * 31) + this.f19838c.hashCode()) * 31) + this.f19839d.hashCode()) * 31) + this.f19840e.hashCode();
    }

    public String toString() {
        return "Shapes(extraSmall=" + this.f19836a + ", small=" + this.f19837b + ", medium=" + this.f19838c + ", large=" + this.f19839d + ", extraLarge=" + this.f19840e + ')';
    }

    public /* synthetic */ Shapes(CornerBasedShape cornerBasedShape, CornerBasedShape cornerBasedShape2, CornerBasedShape cornerBasedShape3, CornerBasedShape cornerBasedShape4, CornerBasedShape cornerBasedShape5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? ShapeDefaults.f19830a.b() : cornerBasedShape, (i3 & 2) != 0 ? ShapeDefaults.f19830a.e() : cornerBasedShape2, (i3 & 4) != 0 ? ShapeDefaults.f19830a.d() : cornerBasedShape3, (i3 & 8) != 0 ? ShapeDefaults.f19830a.c() : cornerBasedShape4, (i3 & 16) != 0 ? ShapeDefaults.f19830a.a() : cornerBasedShape5);
    }
}
