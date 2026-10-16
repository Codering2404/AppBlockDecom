package androidx.constraintlayout.compose.carousel;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class SwipeProgress<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f31139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f31140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f31141c;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwipeProgress)) {
            return false;
        }
        SwipeProgress swipeProgress = (SwipeProgress) obj;
        return Intrinsics.areEqual(this.f31139a, swipeProgress.f31139a) && Intrinsics.areEqual(this.f31140b, swipeProgress.f31140b) && this.f31141c == swipeProgress.f31141c;
    }

    public int hashCode() {
        Object obj = this.f31139a;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Object obj2 = this.f31140b;
        return ((iHashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31) + Float.hashCode(this.f31141c);
    }

    public String toString() {
        return "SwipeProgress(from=" + this.f31139a + ", to=" + this.f31140b + ", fraction=" + this.f31141c + ')';
    }
}
