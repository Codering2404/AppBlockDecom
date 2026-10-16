package androidx.compose.material3.carousel;

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
final class ShiftPointRange {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f21738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f21739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f21740c;

    public ShiftPointRange(int i3, int i4, float f3) {
        this.f21738a = i3;
        this.f21739b = i4;
        this.f21740c = f3;
    }

    public final int a() {
        return this.f21738a;
    }

    public final float b() {
        return this.f21740c;
    }

    public final int c() {
        return this.f21739b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShiftPointRange)) {
            return false;
        }
        ShiftPointRange shiftPointRange = (ShiftPointRange) obj;
        return this.f21738a == shiftPointRange.f21738a && this.f21739b == shiftPointRange.f21739b && Float.compare(this.f21740c, shiftPointRange.f21740c) == 0;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.f21738a) * 31) + Integer.hashCode(this.f21739b)) * 31) + Float.hashCode(this.f21740c);
    }

    public String toString() {
        return "ShiftPointRange(fromStepIndex=" + this.f21738a + ", toStepIndex=" + this.f21739b + ", steppedInterpolation=" + this.f21740c + ')';
    }
}
