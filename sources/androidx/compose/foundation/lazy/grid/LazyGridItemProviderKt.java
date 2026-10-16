package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.reflect.KProperty0;

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
public final class LazyGridItemProviderKt {
    public static final Function0 a(final LazyGridState lazyGridState, Function1 function1, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1898306282, i3, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridItemProviderLambda (LazyGridItemProvider.kt:42)");
        }
        final State stateP = SnapshotStateKt.p(function1, composer, (i3 >> 3) & 14);
        boolean z2 = (((i3 & 14) ^ 6) > 4 && composer.Z(lazyGridState)) || (i3 & 6) == 4;
        Object objG = composer.G();
        if (z2 || objG == Composer.f23746a.a()) {
            final State stateD = SnapshotStateKt.d(SnapshotStateKt.o(), new Function0<LazyGridIntervalContent>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridItemProviderKt$rememberLazyGridItemProviderLambda$1$intervalContentState$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final LazyGridIntervalContent invoke() {
                    return new LazyGridIntervalContent((Function1) stateP.getValue());
                }
            });
            final State stateD2 = SnapshotStateKt.d(SnapshotStateKt.o(), new Function0<LazyGridItemProviderImpl>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridItemProviderKt$rememberLazyGridItemProviderLambda$1$itemProviderState$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final LazyGridItemProviderImpl invoke() {
                    LazyGridIntervalContent lazyGridIntervalContent = (LazyGridIntervalContent) stateD.getValue();
                    return new LazyGridItemProviderImpl(lazyGridState, lazyGridIntervalContent, new NearestRangeKeyIndexMap(lazyGridState.y(), lazyGridIntervalContent));
                }
            });
            objG = new PropertyReference0Impl(stateD2) { // from class: androidx.compose.foundation.lazy.grid.LazyGridItemProviderKt$rememberLazyGridItemProviderLambda$1$1
                @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
                public Object get() {
                    return ((State) this.receiver).getValue();
                }
            };
            composer.w(objG);
        }
        KProperty0 kProperty0 = (KProperty0) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return kProperty0;
    }
}
