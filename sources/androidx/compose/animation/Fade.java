package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
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
public final class Fade {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f3570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FiniteAnimationSpec f3571b;

    public Fade(float f3, FiniteAnimationSpec finiteAnimationSpec) {
        this.f3570a = f3;
        this.f3571b = finiteAnimationSpec;
    }

    public final float a() {
        return this.f3570a;
    }

    public final FiniteAnimationSpec b() {
        return this.f3571b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Fade)) {
            return false;
        }
        Fade fade = (Fade) obj;
        return Float.compare(this.f3570a, fade.f3570a) == 0 && Intrinsics.areEqual(this.f3571b, fade.f3571b);
    }

    public int hashCode() {
        return (Float.hashCode(this.f3570a) * 31) + this.f3571b.hashCode();
    }

    public String toString() {
        return "Fade(alpha=" + this.f3570a + ", animationSpec=" + this.f3571b + ')';
    }
}
