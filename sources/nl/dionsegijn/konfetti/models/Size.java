package nl.dionsegijn.konfetti.models;

import android.content.res.Resources;
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
public final class Size {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f143771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f143772b;

    public Size(int i3, float f3) {
        this.f143771a = i3;
        this.f143772b = f3;
        if (f3 != 0.0f) {
            return;
        }
        throw new IllegalArgumentException(("mass=" + f3 + " must be != 0").toString());
    }

    public final float a() {
        return this.f143772b;
    }

    public final float b() {
        float f3 = this.f143771a;
        Resources system = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(system, "Resources.getSystem()");
        return f3 * system.getDisplayMetrics().density;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        return this.f143771a == size.f143771a && Float.compare(this.f143772b, size.f143772b) == 0;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f143771a) * 31) + Float.hashCode(this.f143772b);
    }

    public String toString() {
        return "Size(sizeInDp=" + this.f143771a + ", mass=" + this.f143772b + ")";
    }

    public /* synthetic */ Size(int i3, float f3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i4 & 2) != 0 ? 5.0f : f3);
    }
}
