package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.semantics.CollectionInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

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
public final class LazyStaggeredGridSemanticsKt {
    public static final LazyLayoutSemanticState a(final LazyStaggeredGridState lazyStaggeredGridState, boolean z2, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1629354903, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridSemanticState (LazyStaggeredGridSemantics.kt:31)");
        }
        boolean z3 = ((((i3 & 14) ^ 6) > 4 && composer.Z(lazyStaggeredGridState)) || (i3 & 6) == 4) | ((((i3 & 112) ^ 48) > 32 && composer.b(z2)) || (i3 & 48) == 32);
        Object objG = composer.G();
        if (z3 || objG == Composer.f23746a.a()) {
            objG = new LazyLayoutSemanticState() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSemanticsKt$rememberLazyStaggeredGridSemanticState$1$1
                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                public int a() {
                    return lazyStaggeredGridState.y().c() + lazyStaggeredGridState.y().b();
                }

                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                public float b() {
                    return LazyLayoutSemanticsKt.a(lazyStaggeredGridState.s(), lazyStaggeredGridState.t(), lazyStaggeredGridState.f());
                }

                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                public Object c(int i4, Continuation continuation) {
                    Object objN = LazyStaggeredGridState.N(lazyStaggeredGridState, i4, 0, continuation, 2, null);
                    return objN == IntrinsicsKt.f() ? objN : Unit.f139807a;
                }

                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                public CollectionInfo d() {
                    return new CollectionInfo(-1, -1);
                }

                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                public int e() {
                    return (int) (lazyStaggeredGridState.y().getOrientation() == Orientation.f6031a ? lazyStaggeredGridState.y().a() & 4294967295L : lazyStaggeredGridState.y().a() >> 32);
                }

                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                public float f() {
                    return LazyLayoutSemanticsKt.b(lazyStaggeredGridState.s(), lazyStaggeredGridState.t());
                }
            };
            composer.w(objG);
        }
        LazyStaggeredGridSemanticsKt$rememberLazyStaggeredGridSemanticState$1$1 lazyStaggeredGridSemanticsKt$rememberLazyStaggeredGridSemanticState$1$1 = (LazyStaggeredGridSemanticsKt$rememberLazyStaggeredGridSemanticState$1$1) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return lazyStaggeredGridSemanticsKt$rememberLazyStaggeredGridSemanticState$1$1;
    }
}
