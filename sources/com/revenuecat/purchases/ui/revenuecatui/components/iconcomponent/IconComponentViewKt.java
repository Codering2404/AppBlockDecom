package com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import com.emergetools.snapshots.annotations.EmergeSnapshotConfig;
import com.revenuecat.purchases.ui.revenuecatui.components.PreviewHelpersKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ImagePreviewsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final /* synthetic */ class IconComponentViewKt {
    /* JADX WARN: Removed duplicated region for block: B:114:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void IconComponentView(final com.revenuecat.purchases.ui.revenuecatui.components.style.IconComponentStyle r19, final com.revenuecat.purchases.ui.revenuecatui.data.PaywallState.Loaded.Components r20, androidx.compose.ui.Modifier r21, androidx.compose.runtime.Composer r22, final int r23, final int r24) {
        /*
            Method dump skipped, instruction units count: 698
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentViewKt.IconComponentView(com.revenuecat.purchases.ui.revenuecatui.components.style.IconComponentStyle, com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Shape IconComponentView$lambda$3(State<? extends Shape> state) {
        return (Shape) state.getValue();
    }

    private static final ColorFilter IconComponentView$lambda$5(State<? extends ColorFilter> state) {
        return (ColorFilter) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @EmergeSnapshotConfig(precision = 0.99f)
    public static final void IconComponentView_Margin_Preview(Composer composer, final int i3) {
        Composer composerK = composer.k(-178260139);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-178260139, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentView_Margin_Preview (IconComponentView.kt:107)");
            }
            ImagePreviewsKt.ProvidePreviewImageLoader(PreviewHelpersKt.previewImageLoader(0, composerK, 0, 1), ComposableSingletons$IconComponentViewKt.INSTANCE.m718getLambda2$revenuecatui_defaultsBc8Release(), composerK, 48);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentViewKt.IconComponentView_Margin_Preview.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    IconComponentViewKt.IconComponentView_Margin_Preview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void IconComponentView_Preview(Composer composer, final int i3) {
        Composer composerK = composer.k(1522961854);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1522961854, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentView_Preview (IconComponentView.kt:88)");
            }
            ImagePreviewsKt.ProvidePreviewImageLoader(PreviewHelpersKt.previewImageLoader(0, composerK, 0, 1), ComposableSingletons$IconComponentViewKt.INSTANCE.m717getLambda1$revenuecatui_defaultsBc8Release(), composerK, 48);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentViewKt.IconComponentView_Preview.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    IconComponentViewKt.IconComponentView_Preview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }
}
