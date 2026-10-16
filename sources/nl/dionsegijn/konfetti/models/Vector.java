package nl.dionsegijn.konfetti.models;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class Vector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f143773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f143774b;

    public Vector(float f3, float f4) {
        this.f143773a = f3;
        this.f143774b = f4;
    }

    public final void a(Vector v2) {
        Intrinsics.checkNotNullParameter(v2, "v");
        this.f143773a += v2.f143773a;
        this.f143774b += v2.f143774b;
    }

    public final void b(Vector v2, float f3) {
        Intrinsics.checkNotNullParameter(v2, "v");
        this.f143773a += v2.f143773a * f3;
        this.f143774b += v2.f143774b * f3;
    }

    public final float c() {
        return this.f143773a;
    }

    public final float d() {
        return this.f143774b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Vector)) {
            return false;
        }
        Vector vector = (Vector) obj;
        return Float.compare(this.f143773a, vector.f143773a) == 0 && Float.compare(this.f143774b, vector.f143774b) == 0;
    }

    public int hashCode() {
        return (Float.hashCode(this.f143773a) * 31) + Float.hashCode(this.f143774b);
    }

    public String toString() {
        return "Vector(x=" + this.f143773a + ", y=" + this.f143774b + ")";
    }

    public /* synthetic */ Vector(float f3, float f4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0.0f : f3, (i3 & 2) != 0 ? 0.0f : f4);
    }
}
