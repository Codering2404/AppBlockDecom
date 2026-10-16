package com.revenuecat.purchases.ui.revenuecatui.templates;

import android.content.res.Configuration;
import android.graphics.Matrix;
import android.net.Uri;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt;
import com.revenuecat.purchases.ui.revenuecatui.PaywallMode;
import com.revenuecat.purchases.ui.revenuecatui.PaywallOptions;
import com.revenuecat.purchases.ui.revenuecatui.UIConstant;
import com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.MarkdownKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferDetailsKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.RemoteImageKt;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallStateKt;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.ProcessedLocalizedConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.MockViewModel;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.TestData;
import com.revenuecat.purchases.ui.revenuecatui.extensions.ModifierExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.WindowHelperKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

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
public final class Template1Kt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void CircleMask(final boolean z2, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-1244949301);
        if ((i3 & 6) == 0) {
            i4 = (composerK.b(z2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function2) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1244949301, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.CircleMask (Template1.kt:159)");
            }
            final float f3 = z2 ? 8.0f : 3.0f;
            Modifier modifierA = ClipKt.a(Modifier.b8, new Shape() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template1Kt$CircleMask$clipShape$1
                @Override // androidx.compose.ui.graphics.Shape
                /* JADX INFO: renamed from: createOutline-Pq9zytI */
                public Outline mo29createOutlinePq9zytI(long j3, LayoutDirection layoutDirection, Density density) {
                    Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
                    Intrinsics.checkNotNullParameter(density, "density");
                    Matrix matrix = new Matrix();
                    float f4 = f3;
                    matrix.preScale(f4, f4);
                    matrix.postTranslate(Template1Kt.CircleMask$circleOffsetX(f3, j3), Template1Kt.CircleMask$circleOffsetY(f3, j3));
                    Path pathA = AndroidPath_androidKt.a();
                    Path.l(pathA, RectKt.c(Offset.f25596b.c(), j3), null, 2, null);
                    if (!(pathA instanceof AndroidPath)) {
                        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
                    }
                    ((AndroidPath) pathA).A().transform(matrix);
                    return new Outline.Generic(pathA);
                }
            });
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierA);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, measurePolicyG, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            function2.invoke(composerK, Integer.valueOf((i4 >> 3) & 14));
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template1Kt.CircleMask.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    Template1Kt.CircleMask(z2, function2, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float CircleMask$circleOffsetX(float f3, long j3) {
        return (((Size.i(j3) * f3) - Size.i(j3)) / 2.0f) * (-1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float CircleMask$circleOffsetY(float f3, long j3) {
        return ((Size.g(j3) * f3) - Size.g(j3)) * (-1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CircleMaskPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(-414705569);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-414705569, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.CircleMaskPreview (Template1.kt:250)");
            }
            Modifier.Companion companion = Modifier.b8;
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, companion);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, measurePolicyG, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            BoxKt.a(SizeKt.f(BackgroundKt.d(companion, Color.f25715b.i(), null, 2, null), 0.0f, 1, null), composerK, 6);
            CircleMask(false, ComposableSingletons$Template1Kt.INSTANCE.m1169getLambda1$revenuecatui_defaultsBc8Release(), composerK, 54);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template1Kt.CircleMaskPreview.2
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
                    Template1Kt.CircleMaskPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void HeaderImage(final Uri uri, final boolean z2, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(2030386997);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(uri) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z2) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(2030386997, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.HeaderImage (Template1.kt:139)");
            }
            if (uri != null) {
                CircleMask(z2, ComposableLambdaKt.e(1134746342, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template1Kt$HeaderImage$1$1
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
                        if ((i5 & 3) == 2 && composer2.l()) {
                            composer2.Q();
                            return;
                        }
                        if (ComposerKt.M()) {
                            ComposerKt.U(1134746342, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.HeaderImage.<anonymous>.<anonymous> (Template1.kt:142)");
                        }
                        final int i6 = ((Configuration) composer2.q(AndroidCompositionLocals_androidKt.f())).screenHeightDp;
                        String string = uri.toString();
                        Intrinsics.checkNotNullExpressionValue(string, "uri.toString()");
                        Modifier modifierConditional = ModifierExtensionsKt.conditional(Modifier.b8, !z2, new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template1Kt$HeaderImage$1$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Modifier invoke(Modifier conditional) {
                                Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                return AspectRatioKt.b(conditional, 1.2f, false, 2, null);
                            }
                        });
                        boolean z3 = z2;
                        composer2.a0(-910575415);
                        boolean zE = composer2.e(i6);
                        Object objG = composer2.G();
                        if (zE || objG == Composer.f23746a.a()) {
                            objG = new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template1Kt$HeaderImage$1$1$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Modifier invoke(Modifier conditional) {
                                    Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                    return SizeKt.i(SizeKt.h(conditional, 0.0f, 1, null), Dp.g(Dp.g(i6) / 2.0f));
                                }
                            };
                            composer2.w(objG);
                        }
                        composer2.U();
                        RemoteImageKt.RemoteImage(string, ModifierExtensionsKt.conditional(modifierConditional, z3, (Function1) objG), null, ContentScale.f27054a.a(), null, null, 0.0f, null, composer2, 3072, 244);
                        if (ComposerKt.M()) {
                            ComposerKt.T();
                        }
                    }
                }, composerK, 54), composerK, ((i4 >> 3) & 14) | 48);
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template1Kt.HeaderImage.2
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
                    Template1Kt.HeaderImage(uri, z2, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final void Template1(final PaywallState.Loaded.Legacy state, PaywallViewModel viewModel, Composer composer, final int i3) {
        int i4;
        final PaywallViewModel paywallViewModel;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer composerK = composer.k(1499444075);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(state) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(viewModel) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
            paywallViewModel = viewModel;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1499444075, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template1 (Template1.kt:60)");
            }
            Modifier modifierH = SizeKt.h(Modifier.b8, 0.0f, 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.g(), composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierH);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, measurePolicyA, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            Template1MainContent(ColumnScopeInstance.f6666a, state, composerK, ((i4 << 3) & 112) | 6);
            paywallViewModel = viewModel;
            PurchaseButtonKt.m923PurchaseButtonhGBTI10(state, paywallViewModel, null, 0.0f, null, composerK, i4 & 126, 28);
            FooterKt.Footer(state.getTemplateConfiguration(), paywallViewModel, null, null, null, composerK, i4 & 112, 28);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template1Kt.Template1.2
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
                    Template1Kt.Template1(state, paywallViewModel, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template1CondensedFooterPaywallPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(-527429650);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-527429650, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template1CondensedFooterPaywallPreview (Template1.kt:241)");
            }
            InternalPaywallKt.InternalPaywall(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template1Kt.Template1CondensedFooterPaywallPreview.1
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1174invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1174invoke();
                    return Unit.f139807a;
                }
            }).build(), new MockViewModel(PaywallMode.FOOTER_CONDENSED, TestData.INSTANCE.getTemplate1Offering(), null, false, false, 28, null), composerK, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template1Kt.Template1CondensedFooterPaywallPreview.2
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
                    Template1Kt.Template1CondensedFooterPaywallPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template1FooterPaywallPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(1625504547);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1625504547, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template1FooterPaywallPreview (Template1.kt:232)");
            }
            InternalPaywallKt.InternalPaywall(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template1Kt.Template1FooterPaywallPreview.1
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1175invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1175invoke();
                    return Unit.f139807a;
                }
            }).build(), new MockViewModel(PaywallMode.FOOTER, TestData.INSTANCE.getTemplate1Offering(), null, false, false, 28, null), composerK, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template1Kt.Template1FooterPaywallPreview.2
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
                    Template1Kt.Template1FooterPaywallPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template1MainContent(ColumnScope columnScope, final PaywallState.Loaded.Legacy legacy, Composer composer, final int i3) {
        int i4;
        final ColumnScope columnScope2;
        TemplateConfiguration.Colors colors;
        int i5;
        Composer composerK = composer.k(-1400671009);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.Z(columnScope) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(legacy) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
            columnScope2 = columnScope;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1400671009, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template1MainContent (Template1.kt:74)");
            }
            ProcessedLocalizedConfiguration selectedLocalization = PaywallStateKt.getSelectedLocalization(legacy);
            int i6 = (i4 >> 3) & 14;
            TemplateConfiguration.Colors currentColors = PaywallStateKt.getCurrentColors(legacy, composerK, i6);
            if (PaywallStateKt.isInFullScreenMode(legacy)) {
                composerK.a0(908514334);
                boolean zShouldUseLandscapeLayout = WindowHelperKt.shouldUseLandscapeLayout(legacy, composerK, i6);
                Modifier.Companion companion = Modifier.b8;
                Modifier modifierB = ColumnScope.b(columnScope, SizeKt.d(ScrollKt.g(SizeKt.h(companion, 0.0f, 1, null), ScrollKt.c(0, composerK, 0, 1), false, null, false, 14, null), 0.0f, 1, null), 1.0f, false, 2, null);
                Alignment.Companion companion2 = Alignment.f25072a;
                MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.b(), companion2.g(), composerK, 54);
                int iA = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU = composerK.u();
                Modifier modifierF = ComposedModifierKt.f(composerK, modifierB);
                ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
                Function0 function0A = companion3.a();
                if (composerK.m() == null) {
                    ComposablesKt.c();
                }
                composerK.L();
                if (composerK.i()) {
                    composerK.P(function0A);
                } else {
                    composerK.v();
                }
                Composer composerA = Updater.a(composerK);
                Updater.e(composerA, measurePolicyA, companion3.e());
                Updater.e(composerA, compositionLocalMapU, companion3.g());
                Function2 function2B = companion3.b();
                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                    composerA.w(Integer.valueOf(iA));
                    composerA.p(Integer.valueOf(iA), function2B);
                }
                Updater.e(composerA, modifierF, companion3.f());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
                HeaderImage(legacy.getTemplateConfiguration().getImages().getHeaderUri(), zShouldUseLandscapeLayout, composerK, 0);
                SpacerKt.a(ColumnScope.b(columnScopeInstance, companion, 1.0f, false, 2, null), composerK, 0);
                String title = selectedLocalization.getTitle();
                MaterialTheme materialTheme = MaterialTheme.f18110a;
                int i7 = MaterialTheme.f18111b;
                TextStyle textStyleG = materialTheme.c(composerK, i7).g();
                FontWeight.Companion companion4 = FontWeight.f29233b;
                FontWeight fontWeightA = companion4.a();
                TextAlign.Companion companion5 = TextAlign.f29616b;
                int iA2 = companion5.a();
                long jM1093getText10d7_KjU = currentColors.m1093getText10d7_KjU();
                UIConstant uIConstant = UIConstant.INSTANCE;
                colors = null;
                MarkdownKt.m901MarkdownDkhmgE0(title, PaddingKt.j(companion, uIConstant.m690getDefaultHorizontalPaddingD9Ej5fM(), uIConstant.m693getDefaultVerticalSpacingD9Ej5fM()), jM1093getText10d7_KjU, textStyleG, 0L, fontWeightA, null, null, TextAlign.h(iA2), false, true, false, composerK, 196608, 54, 720);
                Modifier modifierK = PaddingKt.k(companion, uIConstant.m690getDefaultHorizontalPaddingD9Ej5fM(), 0.0f, 2, null);
                MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
                int iA3 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU2 = composerK.u();
                Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierK);
                Function0 function0A2 = companion3.a();
                if (composerK.m() == null) {
                    ComposablesKt.c();
                }
                composerK.L();
                if (composerK.i()) {
                    composerK.P(function0A2);
                } else {
                    composerK.v();
                }
                Composer composerA2 = Updater.a(composerK);
                Updater.e(composerA2, measurePolicyG, companion3.e());
                Updater.e(composerA2, compositionLocalMapU2, companion3.g());
                Function2 function2B2 = companion3.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA3))) {
                    composerA2.w(Integer.valueOf(iA3));
                    composerA2.p(Integer.valueOf(iA3), function2B2);
                }
                Updater.e(composerA2, modifierF2, companion3.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                String subtitle = selectedLocalization.getSubtitle();
                if (subtitle == null) {
                    subtitle = "";
                }
                MarkdownKt.m901MarkdownDkhmgE0(subtitle, PaddingKt.j(companion, uIConstant.m690getDefaultHorizontalPaddingD9Ej5fM(), uIConstant.m693getDefaultVerticalSpacingD9Ej5fM()), currentColors.m1093getText10d7_KjU(), materialTheme.c(composerK, i7).b(), 0L, companion4.g(), null, null, TextAlign.h(companion5.a()), false, true, false, composerK, 196608, 54, 720);
                composerK = composerK;
                composerK.y();
                i5 = 2;
                i6 = i6;
                columnScope2 = columnScope;
                SpacerKt.a(ColumnScope.b(columnScopeInstance, companion, 2.0f, false, 2, null), composerK, 0);
                composerK.y();
                composerK.U();
            } else {
                columnScope2 = columnScope;
                colors = null;
                i5 = 2;
                composerK.a0(910488166);
                SpacerKt.a(SizeKt.i(Modifier.b8, UIConstant.INSTANCE.m693getDefaultVerticalSpacingD9Ej5fM()), composerK, 0);
                composerK.U();
            }
            OfferDetailsKt.OfferDetails(legacy, colors, composerK, i6, i5);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template1Kt.Template1MainContent.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i8) {
                    Template1Kt.Template1MainContent(columnScope2, legacy, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template1NoFooterPaywallPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(363342818);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(363342818, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template1NoFooterPaywallPreview (Template1.kt:223)");
            }
            InternalPaywallKt.InternalPaywall(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template1Kt.Template1NoFooterPaywallPreview.1
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1176invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1176invoke();
                    return Unit.f139807a;
                }
            }).build(), new MockViewModel(null, TestData.INSTANCE.getTemplate1OfferingNoFooter(), null, false, false, 29, null), composerK, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template1Kt.Template1NoFooterPaywallPreview.2
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
                    Template1Kt.Template1NoFooterPaywallPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template1PaywallPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(854103102);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(854103102, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template1PaywallPreview (Template1.kt:214)");
            }
            InternalPaywallKt.InternalPaywall(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template1Kt.Template1PaywallPreview.1
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1177invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1177invoke();
                    return Unit.f139807a;
                }
            }).build(), new MockViewModel(null, TestData.INSTANCE.getTemplate1Offering(), null, false, false, 29, null), composerK, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template1Kt.Template1PaywallPreview.2
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
                    Template1Kt.Template1PaywallPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }
}
