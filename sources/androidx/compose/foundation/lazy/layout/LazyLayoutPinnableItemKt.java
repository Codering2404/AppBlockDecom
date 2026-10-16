package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.layout.PinnableContainer;
import androidx.compose.ui.layout.PinnableContainerKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

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
public final class LazyLayoutPinnableItemKt {
    public static final void a(final Object obj, final int i3, final LazyLayoutPinnedItemList lazyLayoutPinnedItemList, final Function2 function2, Composer composer, final int i4) {
        int i5;
        Composer composerK = composer.k(-2079116560);
        if ((i4 & 6) == 0) {
            i5 = (composerK.I(obj) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if ((i4 & 48) == 0) {
            i5 |= composerK.e(i3) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i5 |= composerK.I(lazyLayoutPinnedItemList) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 3072) == 0) {
            i5 |= composerK.I(function2) ? 2048 : 1024;
        }
        if (composerK.r((i5 & 1171) != 1170, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2079116560, i5, -1, "androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItem (LazyLayoutPinnableItem.kt:50)");
            }
            boolean Z = composerK.Z(obj) | composerK.Z(lazyLayoutPinnedItemList);
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new LazyLayoutPinnableItem(obj, lazyLayoutPinnedItemList);
                composerK.w(objG);
            }
            final LazyLayoutPinnableItem lazyLayoutPinnableItem = (LazyLayoutPinnableItem) objG;
            lazyLayoutPinnableItem.e(i3);
            lazyLayoutPinnableItem.f((PinnableContainer) composerK.q(PinnableContainerKt.a()));
            boolean Z2 = composerK.Z(lazyLayoutPinnableItem);
            Object objG2 = composerK.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItemKt$LazyLayoutPinnableItem$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        final LazyLayoutPinnableItem lazyLayoutPinnableItem2 = lazyLayoutPinnableItem;
                        return new DisposableEffectResult() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItemKt$LazyLayoutPinnableItem$1$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                lazyLayoutPinnableItem2.d();
                            }
                        };
                    }
                };
                composerK.w(objG2);
            }
            EffectsKt.c(lazyLayoutPinnableItem, (Function1) objG2, composerK, 0);
            CompositionLocalKt.b(PinnableContainerKt.a().d(lazyLayoutPinnableItem), function2, composerK, ((i5 >> 6) & 112) | ProvidedValue.f24012i);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItemKt$LazyLayoutPinnableItem$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((Composer) obj2, ((Number) obj3).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i6) {
                    LazyLayoutPinnableItemKt.a(obj, i3, lazyLayoutPinnedItemList, function2, composer2, RecomposeScopeImplKt.a(i4 | 1));
                }
            });
        }
    }
}
