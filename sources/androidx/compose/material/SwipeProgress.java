package androidx.compose.material;

import kotlin.Deprecated;
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
@Deprecated
@Metadata
public final class SwipeProgress<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f14273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f14274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f14275c;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwipeProgress)) {
            return false;
        }
        SwipeProgress swipeProgress = (SwipeProgress) obj;
        return Intrinsics.areEqual(this.f14273a, swipeProgress.f14273a) && Intrinsics.areEqual(this.f14274b, swipeProgress.f14274b) && this.f14275c == swipeProgress.f14275c;
    }

    public int hashCode() {
        Object obj = this.f14273a;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Object obj2 = this.f14274b;
        return ((iHashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31) + Float.hashCode(this.f14275c);
    }

    public String toString() {
        return "SwipeProgress(from=" + this.f14273a + ", to=" + this.f14274b + ", fraction=" + this.f14275c + ')';
    }
}
