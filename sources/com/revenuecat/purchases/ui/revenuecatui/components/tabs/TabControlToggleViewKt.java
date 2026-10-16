package com.revenuecat.purchases.ui.revenuecatui.components.tabs;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.tooling.preview.PreviewParameter;
import com.revenuecat.purchases.paywalls.components.properties.ColorInfo;
import com.revenuecat.purchases.ui.revenuecatui.components.PreviewHelpersKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TabControlToggleComponentStyle;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
public final /* synthetic */ class TabControlToggleViewKt {
    /* JADX WARN: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void TabControlToggleView(final com.revenuecat.purchases.ui.revenuecatui.components.style.TabControlToggleComponentStyle r33, final com.revenuecat.purchases.ui.revenuecatui.data.PaywallState.Loaded.Components r34, androidx.compose.ui.Modifier r35, com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallComponentInteractionTracker r36, androidx.compose.runtime.Composer r37, final int r38, final int r39) {
        /*
            Method dump skipped, instruction units count: 418
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabControlToggleViewKt.TabControlToggleView(com.revenuecat.purchases.ui.revenuecatui.components.style.TabControlToggleComponentStyle, com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components, androidx.compose.ui.Modifier, com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallComponentInteractionTracker, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final boolean TabControlToggleView$lambda$2(State<Boolean> state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TabControlToggleView_Gradient_Preview(Composer composer, final int i3) {
        Composer composerK = composer.k(-813499163);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-813499163, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabControlToggleView_Gradient_Preview (TabControlToggleView.kt:105)");
            }
            Color.Companion companion = Color.f25715b;
            List listListOf = CollectionsKt.listOf((Object[]) new ColorInfo.Gradient.Point[]{new ColorInfo.Gradient.Point(ColorKt.k(companion.i()), 0.0f), new ColorInfo.Gradient.Point(ColorKt.k(companion.f()), 35.0f), new ColorInfo.Gradient.Point(ColorKt.k(companion.b()), 100.0f)});
            TabControlToggleView(new TabControlToggleComponentStyle(new ColorStyles(ColorStyleKt.toColorStyle(new ColorInfo.Gradient.Radial(listListOf)), null, 2, null), new ColorStyles(ColorStyleKt.toColorStyle(new ColorInfo.Gradient.Radial(listListOf)), null, 2, null), new ColorStyles(ColorStyleKt.toColorStyle(new ColorInfo.Gradient.Linear(90.0f, listListOf)), null, 2, null), new ColorStyles(ColorStyleKt.toColorStyle(new ColorInfo.Gradient.Linear(90.0f, listListOf)), null, 2, null), null, 16, null), PreviewHelpersKt.previewEmptyState(null, composerK, 0, 1), null, null, composerK, 0, 12);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabControlToggleViewKt.TabControlToggleView_Gradient_Preview.1
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
                    TabControlToggleViewKt.TabControlToggleView_Gradient_Preview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TabControlToggleView_Preview(@PreviewParameter final boolean z2, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(259221708);
        if ((i3 & 6) == 0) {
            i4 = (composerK.b(z2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i4 & 3) == 2 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(259221708, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabControlToggleView_Preview (TabControlToggleView.kt:78)");
            }
            Color.Companion companion = Color.f25715b;
            TabControlToggleView(new TabControlToggleComponentStyle(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.i())), ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.b()))), new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.b())), ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.i()))), new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.m())), ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.f()))), new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.f())), ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.m()))), null, 16, null), PreviewHelpersKt.previewEmptyState(Integer.valueOf(z2 ? 1 : 0), composerK, 0, 0), null, null, composerK, 0, 12);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabControlToggleViewKt.TabControlToggleView_Preview.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    TabControlToggleViewKt.TabControlToggleView_Preview(z2, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }
}
