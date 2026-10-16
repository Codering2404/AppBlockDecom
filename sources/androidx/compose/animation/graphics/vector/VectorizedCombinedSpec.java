package androidx.compose.animation.graphics.vector;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.VectorizedFiniteAnimationSpec;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;

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
final class VectorizedCombinedSpec<V extends AnimationVector> implements VectorizedFiniteAnimationSpec<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f4466a;

    public VectorizedCombinedSpec(List list) {
        this.f4466a = list;
    }

    private final Pair h(long j3) {
        Object objPrevious;
        List list = this.f4466a;
        ListIterator listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            }
            objPrevious = listIterator.previous();
            if (((Number) ((Pair) objPrevious).a()).longValue() <= j3) {
                break;
            }
        }
        Pair pair = (Pair) objPrevious;
        return pair == null ? (Pair) CollectionsKt.first(this.f4466a) : pair;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public long b(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        Pair pair = (Pair) CollectionsKt.last(this.f4466a);
        return ((Number) pair.a()).longValue() + ((VectorizedFiniteAnimationSpec) pair.b()).b(animationVector, animationVector2, animationVector3);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector f(long j3, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        Pair pairH = h(j3);
        return ((VectorizedFiniteAnimationSpec) pairH.b()).f(j3 - ((Number) pairH.a()).longValue(), animationVector, animationVector2, animationVector3);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector g(long j3, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        Pair pairH = h(j3);
        return ((VectorizedFiniteAnimationSpec) pairH.b()).g(j3 - ((Number) pairH.a()).longValue(), animationVector, animationVector2, animationVector3);
    }
}
