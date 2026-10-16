package com.revenuecat.purchases.ui.revenuecatui.components.text;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.paywalls.components.properties.ColorInfo;
import com.revenuecat.purchases.paywalls.components.properties.FontWeight;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.ui.revenuecatui.components.PreviewHelpersKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.LocalizationKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.FontSpec;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessor;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessorV2;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
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
public final /* synthetic */ class TextComponentViewKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0222  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void TextComponentView(final com.revenuecat.purchases.ui.revenuecatui.components.style.TextComponentStyle r50, final com.revenuecat.purchases.ui.revenuecatui.data.PaywallState.Loaded.Components r51, androidx.compose.ui.Modifier r52, com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallComponentInteractionTracker r53, androidx.compose.runtime.Composer r54, final int r55, final int r56) {
        /*
            Method dump skipped, instruction units count: 592
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt.TextComponentView(com.revenuecat.purchases.ui.revenuecatui.components.style.TextComponentStyle, com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components, androidx.compose.ui.Modifier, com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallComponentInteractionTracker, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TextComponentView_Preview_Customizations(Composer composer, final int i3) {
        Composer composerK = composer.k(1310256028);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1310256028, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentView_Preview_Customizations (TextComponentView.kt:293)");
            }
            ColorStyles colorStyles = new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(ColorKt.f(255, 0, 0, 0, 8, null))), null, 2, null);
            FontWeight fontWeight = FontWeight.BLACK;
            HorizontalAlignment horizontalAlignment = HorizontalAlignment.LEADING;
            TextComponentView(PreviewHelpersKt.previewTextComponentStyle$default("Hello, world", colorStyles, 13, fontWeight, null, horizontalAlignment, horizontalAlignment, new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(ColorKt.f(222, 222, 222, 0, 8, null))), null, 2, null), false, null, new Padding(10.0d, 10.0d, 20.0d, 20.0d), new Padding(20.0d, 20.0d, 10.0d, 10.0d), null, null, null, null, 62224, null), PreviewHelpersKt.previewEmptyState(null, composerK, 0, 1), null, null, composerK, 0, 12);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt.TextComponentView_Preview_Customizations.1
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
                    TextComponentViewKt.TextComponentView_Preview_Customizations(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TextComponentView_Preview_Default(Composer composer, final int i3) {
        Composer composerK = composer.k(1838187961);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1838187961, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentView_Preview_Default (TextComponentView.kt:189)");
            }
            TextComponentView(PreviewHelpersKt.previewTextComponentStyle$default("Hello, world", new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.a())), null, 2, null), 0, null, null, null, null, null, false, null, null, null, null, null, null, null, 65532, null), PreviewHelpersKt.previewEmptyState(null, composerK, 0, 1), null, null, composerK, 0, 12);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt.TextComponentView_Preview_Default.1
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
                    TextComponentViewKt.TextComponentView_Preview_Default(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TextComponentView_Preview_FontSize(Composer composer, final int i3) {
        Composer composerK = composer.k(793345132);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(793345132, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentView_Preview_FontSize (TextComponentView.kt:263)");
            }
            ColorStyles colorStyles = new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.a())), null, 2, null);
            SizeConstraint.Fit fit = SizeConstraint.Fit.INSTANCE;
            TextComponentView(PreviewHelpersKt.previewTextComponentStyle$default("Hello, world", colorStyles, 28, null, null, null, null, null, false, new Size(fit, fit), null, null, null, null, null, null, 65016, null), PreviewHelpersKt.previewEmptyState(null, composerK, 0, 1), null, null, composerK, 0, 12);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt.TextComponentView_Preview_FontSize.1
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
                    TextComponentViewKt.TextComponentView_Preview_FontSize(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TextComponentView_Preview_HeadingXlExtraBold(Composer composer, final int i3) {
        Composer composerK = composer.k(-1682911299);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1682911299, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentView_Preview_HeadingXlExtraBold (TextComponentView.kt:201)");
            }
            MaterialThemeKt.b(null, null, null, ComposableSingletons$TextComponentViewKt.INSTANCE.m847getLambda2$revenuecatui_defaultsBc8Release(), composerK, 3072, 7);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt.TextComponentView_Preview_HeadingXlExtraBold.1
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
                    TextComponentViewKt.TextComponentView_Preview_HeadingXlExtraBold(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TextComponentView_Preview_HorizontalAlignment(Composer composer, final int i3) {
        Composer composerK = composer.k(-43764709);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-43764709, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentView_Preview_HorizontalAlignment (TextComponentView.kt:277)");
            }
            ColorStyles colorStyles = new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.a())), null, 2, null);
            SizeConstraint.Fit fit = SizeConstraint.Fit.INSTANCE;
            TextComponentView(PreviewHelpersKt.previewTextComponentStyle$default("Hello, world", colorStyles, 0, null, null, null, HorizontalAlignment.TRAILING, null, false, new Size(fit, fit), null, null, null, null, null, null, 64956, null), PreviewHelpersKt.previewEmptyState(null, composerK, 0, 1), SizeKt.C(Modifier.b8, Dp.g(RCHTTPStatusCodes.BAD_REQUEST), 0.0f, 2, null), null, composerK, 384, 8);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt.TextComponentView_Preview_HorizontalAlignment.1
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
                    TextComponentViewKt.TextComponentView_Preview_HorizontalAlignment(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TextComponentView_Preview_LinearGradient(Composer composer, final int i3) {
        Composer composerK = composer.k(702292295);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(702292295, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentView_Preview_LinearGradient (TextComponentView.kt:325)");
            }
            Color.Companion companion = Color.f25715b;
            TextComponentView(PreviewHelpersKt.previewTextComponentStyle$default("Do not allow people to dim your shine because they are blinded. Tell them to put some sunglasses on.", new ColorStyles(ColorStyleKt.toColorStyle(new ColorInfo.Gradient.Linear(135.0f, CollectionsKt.listOf((Object[]) new ColorInfo.Gradient.Point[]{new ColorInfo.Gradient.Point(ColorKt.k(companion.c()), 10.0f), new ColorInfo.Gradient.Point(ColorKt.k(ColorKt.f(0, 102, 255, 0, 8, null)), 30.0f), new ColorInfo.Gradient.Point(ColorKt.k(ColorKt.f(160, 0, 160, 0, 8, null)), 80.0f)}))), null, 2, null), 15, FontWeight.MEDIUM, null, HorizontalAlignment.LEADING, null, new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.a())), null, 2, null), false, new Size(new SizeConstraint.Fixed(UInt.b(200), null), SizeConstraint.Fit.INSTANCE), new Padding(10.0d, 10.0d, 20.0d, 20.0d), new Padding(20.0d, 20.0d, 10.0d, 10.0d), null, null, null, null, 61776, null), PreviewHelpersKt.previewEmptyState(null, composerK, 0, 1), null, null, composerK, 0, 12);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt.TextComponentView_Preview_LinearGradient.1
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
                    TextComponentViewKt.TextComponentView_Preview_LinearGradient(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TextComponentView_Preview_Markdown(Composer composer, final int i3) {
        Composer composerK = composer.k(1145662669);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1145662669, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentView_Preview_Markdown (TextComponentView.kt:312)");
            }
            TextComponentView(PreviewHelpersKt.previewTextComponentStyle$default("Hello, **bold**, *italic* or _italic2_ with ~strikethrough~, ~~strikethrough2~~ and `monospace`. Click [here](https://revenuecat.com)", new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.a())), null, 2, null), 0, null, null, null, null, null, false, null, null, null, null, null, null, null, 65532, null), PreviewHelpersKt.previewEmptyState(null, composerK, 0, 1), null, null, composerK, 0, 12);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt.TextComponentView_Preview_Markdown.1
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
                    TextComponentViewKt.TextComponentView_Preview_Markdown(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TextComponentView_Preview_MonospaceFont(Composer composer, final int i3) {
        Composer composerK = composer.k(-744412312);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-744412312, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentView_Preview_MonospaceFont (TextComponentView.kt:249)");
            }
            ColorStyles colorStyles = new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.a())), null, 2, null);
            FontSpec.Generic.Monospace monospace = FontSpec.Generic.Monospace.INSTANCE;
            SizeConstraint.Fit fit = SizeConstraint.Fit.INSTANCE;
            TextComponentView(PreviewHelpersKt.previewTextComponentStyle$default("Hello, world", colorStyles, 0, null, monospace, null, null, null, false, new Size(fit, fit), null, null, null, null, null, null, 65004, null), PreviewHelpersKt.previewEmptyState(null, composerK, 0, 1), null, null, composerK, 0, 12);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt.TextComponentView_Preview_MonospaceFont.1
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
                    TextComponentViewKt.TextComponentView_Preview_MonospaceFont(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TextComponentView_Preview_RadialGradient(Composer composer, final int i3) {
        Composer composerK = composer.k(261376653);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(261376653, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentView_Preview_RadialGradient (TextComponentView.kt:363)");
            }
            Color.Companion companion = Color.f25715b;
            TextComponentView(PreviewHelpersKt.previewTextComponentStyle$default("Do not allow people to dim your shine because they are blinded. Tell them to put some sunglasses on.", new ColorStyles(ColorStyleKt.toColorStyle(new ColorInfo.Gradient.Radial(CollectionsKt.listOf((Object[]) new ColorInfo.Gradient.Point[]{new ColorInfo.Gradient.Point(ColorKt.k(companion.c()), 10.0f), new ColorInfo.Gradient.Point(ColorKt.k(ColorKt.f(0, 102, 255, 0, 8, null)), 80.0f), new ColorInfo.Gradient.Point(ColorKt.k(ColorKt.f(160, 0, 160, 0, 8, null)), 100.0f)}))), null, 2, null), 15, FontWeight.MEDIUM, null, HorizontalAlignment.LEADING, null, new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.a())), null, 2, null), false, new Size(new SizeConstraint.Fixed(UInt.b(200), null), SizeConstraint.Fit.INSTANCE), new Padding(10.0d, 10.0d, 20.0d, 20.0d), new Padding(20.0d, 20.0d, 10.0d, 10.0d), null, null, null, null, 61776, null), PreviewHelpersKt.previewEmptyState(null, composerK, 0, 1), null, null, composerK, 0, 12);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt.TextComponentView_Preview_RadialGradient.1
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
                    TextComponentViewKt.TextComponentView_Preview_RadialGradient(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TextComponentView_Preview_SansSerifFont(Composer composer, final int i3) {
        Composer composerK = composer.k(570489761);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(570489761, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentView_Preview_SansSerifFont (TextComponentView.kt:235)");
            }
            ColorStyles colorStyles = new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.a())), null, 2, null);
            FontSpec.Generic.SansSerif sansSerif = FontSpec.Generic.SansSerif.INSTANCE;
            SizeConstraint.Fit fit = SizeConstraint.Fit.INSTANCE;
            TextComponentView(PreviewHelpersKt.previewTextComponentStyle$default("Hello, world", colorStyles, 0, null, sansSerif, null, null, null, false, new Size(fit, fit), null, null, null, null, null, null, 65004, null), PreviewHelpersKt.previewEmptyState(null, composerK, 0, 1), null, null, composerK, 0, 12);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt.TextComponentView_Preview_SansSerifFont.1
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
                    TextComponentViewKt.TextComponentView_Preview_SansSerifFont(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TextComponentView_Preview_SerifFont(Composer composer, final int i3) {
        Composer composerK = composer.k(2065783982);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(2065783982, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentView_Preview_SerifFont (TextComponentView.kt:221)");
            }
            ColorStyles colorStyles = new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.a())), null, 2, null);
            FontSpec.Generic.Serif serif = FontSpec.Generic.Serif.INSTANCE;
            SizeConstraint.Fit fit = SizeConstraint.Fit.INSTANCE;
            TextComponentView(PreviewHelpersKt.previewTextComponentStyle$default("Hello, world", colorStyles, 0, null, serif, null, null, null, false, new Size(fit, fit), null, null, null, null, null, null, 65004, null), PreviewHelpersKt.previewEmptyState(null, composerK, 0, 1), null, null, composerK, 0, 12);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt.TextComponentView_Preview_SerifFont.1
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
                    TextComponentViewKt.TextComponentView_Preview_SerifFont(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Double discountPercentage(Long l3, Long l4) {
        if (l3 == null || l4 == null || l4.longValue() <= l3.longValue()) {
            return null;
        }
        return Double.valueOf((l4.longValue() - l3.longValue()) / l4.longValue());
    }

    private static final String rememberProcessedText(final PaywallState.Loaded.Components components, final TextComponentState textComponentState, Composer composer, int i3) {
        composer.a0(-2070949083);
        if (ComposerKt.M()) {
            ComposerKt.U(-2070949083, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.rememberProcessedText (TextComponentView.kt:136)");
        }
        composer.a0(1040310122);
        boolean z2 = ((((i3 & 14) ^ 6) > 4 && composer.Z(components)) || (i3 & 6) == 4) | ((((i3 & 112) ^ 48) > 32 && composer.Z(textComponentState)) || (i3 & 48) == 32);
        Object objG = composer.G();
        if (z2 || objG == Composer.f23746a.a()) {
            objG = SnapshotStateKt.e(new Function0<String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt$rememberProcessedText$processedText$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    VariableProcessor.PackageContext packageContext;
                    Locale javaLocale = LocalizationKt.toJavaLocale(components.getLocale());
                    Locale javaLocale2 = LocalizationKt.toJavaLocale(components.getCurrencyLocale());
                    Package applicablePackage = textComponentState.getApplicablePackage();
                    if (applicablePackage != null) {
                        PaywallState.Loaded.Components components2 = components;
                        Price pricePricePerMonth$default = StoreProduct.pricePerMonth$default(applicablePackage.getProduct(), null, 1, null);
                        packageContext = new VariableProcessor.PackageContext(TextComponentViewKt.discountPercentage(pricePricePerMonth$default != null ? Long.valueOf(pricePricePerMonth$default.getAmountMicros()) : null, components2.getMostExpensivePricePerMonthMicros()), !components2.getShowPricesWithDecimals());
                    } else {
                        packageContext = null;
                    }
                    return VariableProcessorV2.INSTANCE.processVariables(textComponentState.getText(), textComponentState.getLocalizedVariableKeys(), components.getVariableConfig(), components.getVariableDataProvider(), packageContext, applicablePackage, textComponentState.getSubscriptionOption(), javaLocale2, javaLocale, components.getCurrentDate(), textComponentState.getCountdownTime(), textComponentState.getCountFrom(), components.getCustomVariables(), components.getDefaultCustomVariables());
                }
            });
            composer.w(objG);
        }
        composer.U();
        String strRememberProcessedText$lambda$3 = rememberProcessedText$lambda$3((State) objG);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return strRememberProcessedText$lambda$3;
    }

    private static final String rememberProcessedText$lambda$3(State<String> state) {
        return (String) state.getValue();
    }
}
