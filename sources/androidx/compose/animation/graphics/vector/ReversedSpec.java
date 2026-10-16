package androidx.compose.animation.graphics.vector;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorizedFiniteAnimationSpec;
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
final class ReversedSpec<T> implements FiniteAnimationSpec<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FiniteAnimationSpec f4443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f4444b;

    public ReversedSpec(FiniteAnimationSpec finiteAnimationSpec, int i3) {
        this.f4443a = finiteAnimationSpec;
        this.f4444b = i3;
    }

    @Override // androidx.compose.animation.core.AnimationSpec
    public VectorizedFiniteAnimationSpec a(TwoWayConverter twoWayConverter) {
        return new VectorizedReversedSpec(this.f4443a.a(twoWayConverter), ((long) this.f4444b) * 1000000);
    }
}
