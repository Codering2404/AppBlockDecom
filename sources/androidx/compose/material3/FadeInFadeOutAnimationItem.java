package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
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
final class FadeInFadeOutAnimationItem<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f17751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function3 f17752b;

    public FadeInFadeOutAnimationItem(Object obj, Function3 function3) {
        this.f17751a = obj;
        this.f17752b = function3;
    }

    public final Object a() {
        return this.f17751a;
    }

    public final Function3 b() {
        return this.f17752b;
    }

    public final Object c() {
        return this.f17751a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FadeInFadeOutAnimationItem)) {
            return false;
        }
        FadeInFadeOutAnimationItem fadeInFadeOutAnimationItem = (FadeInFadeOutAnimationItem) obj;
        return Intrinsics.areEqual(this.f17751a, fadeInFadeOutAnimationItem.f17751a) && Intrinsics.areEqual(this.f17752b, fadeInFadeOutAnimationItem.f17752b);
    }

    public int hashCode() {
        Object obj = this.f17751a;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.f17752b.hashCode();
    }

    public String toString() {
        return "FadeInFadeOutAnimationItem(key=" + this.f17751a + ", transition=" + this.f17752b + ')';
    }
}
