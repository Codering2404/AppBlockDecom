package androidx.compose.animation.core;

import androidx.collection.IntListKt;
import androidx.collection.IntObjectMapKt;
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
public final class ArcAnimationSpec<T> implements DurationBasedAnimationSpec<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f3867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f3868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f3869c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Easing f3870d;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ArcAnimationSpec)) {
            return false;
        }
        ArcAnimationSpec arcAnimationSpec = (ArcAnimationSpec) obj;
        if (ArcMode.d(this.f3867a, arcAnimationSpec.f3867a) && this.f3868b == arcAnimationSpec.f3868b && this.f3869c == arcAnimationSpec.f3869c) {
            return Intrinsics.areEqual(this.f3870d, arcAnimationSpec.f3870d);
        }
        return false;
    }

    public int hashCode() {
        return (((((ArcMode.e(this.f3867a) * 31) + this.f3868b) * 31) + this.f3869c) * 31) + this.f3870d.hashCode();
    }

    @Override // androidx.compose.animation.core.FiniteAnimationSpec, androidx.compose.animation.core.AnimationSpec
    public VectorizedDurationBasedAnimationSpec a(TwoWayConverter twoWayConverter) {
        return new VectorizedKeyframesSpec(IntListKt.c(0, this.f3868b), IntObjectMapKt.a(), this.f3868b, this.f3869c, this.f3870d, this.f3867a, null);
    }
}
