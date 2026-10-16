package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
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
public final class LazyListBeyondBoundsModifierKt {
    public static final LazyLayoutBeyondBoundsState a(LazyListState lazyListState, int i3, Composer composer, int i4) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1877443446, i4, -1, "androidx.compose.foundation.lazy.rememberLazyListBeyondBoundsState (LazyListBeyondBoundsModifier.kt:27)");
        }
        boolean z2 = ((((i4 & 14) ^ 6) > 4 && composer.Z(lazyListState)) || (i4 & 6) == 4) | ((((i4 & 112) ^ 48) > 32 && composer.e(i3)) || (i4 & 48) == 32);
        Object objG = composer.G();
        if (z2 || objG == Composer.f23746a.a()) {
            objG = new LazyListBeyondBoundsState(lazyListState, i3);
            composer.w(objG);
        }
        LazyListBeyondBoundsState lazyListBeyondBoundsState = (LazyListBeyondBoundsState) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return lazyListBeyondBoundsState;
    }
}
