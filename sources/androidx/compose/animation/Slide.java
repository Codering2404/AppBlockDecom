package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
public final class Slide {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1 f3752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FiniteAnimationSpec f3753b;

    public Slide(Function1 function1, FiniteAnimationSpec finiteAnimationSpec) {
        this.f3752a = function1;
        this.f3753b = finiteAnimationSpec;
    }

    public final FiniteAnimationSpec a() {
        return this.f3753b;
    }

    public final Function1 b() {
        return this.f3752a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Slide)) {
            return false;
        }
        Slide slide = (Slide) obj;
        return Intrinsics.areEqual(this.f3752a, slide.f3752a) && Intrinsics.areEqual(this.f3753b, slide.f3753b);
    }

    public int hashCode() {
        return (this.f3752a.hashCode() * 31) + this.f3753b.hashCode();
    }

    public String toString() {
        return "Slide(slideOffset=" + this.f3752a + ", animationSpec=" + this.f3753b + ')';
    }
}
