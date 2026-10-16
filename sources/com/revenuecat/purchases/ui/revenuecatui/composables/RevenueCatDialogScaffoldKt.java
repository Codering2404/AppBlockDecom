package com.revenuecat.purchases.ui.revenuecatui.composables;

import android.os.Build;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material3.ScaffoldKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import com.revenuecat.purchases.ui.revenuecatui.extensions.ModifierExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.HelperFunctionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.WindowHelperKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
public final class RevenueCatDialogScaffoldKt {
    public static final void RevenueCatDialogScaffold(final Function0<Unit> handleCloseRequest, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i3) {
        int i4;
        final float fG;
        Intrinsics.checkNotNullParameter(handleCloseRequest, "handleCloseRequest");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerK = composer.k(-208613253);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(handleCloseRequest) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(content) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-208613253, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.RevenueCatDialogScaffold (RevenueCatDialogScaffold.kt:34)");
            }
            composerK.a0(5743785);
            int i5 = Build.VERSION.SDK_INT;
            if (i5 > 34) {
                WindowInsets.Companion companion = WindowInsets.f7172a;
                fG = Dp.g(WindowInsetsKt.f(WindowInsets_androidKt.b(companion, composerK, 6), composerK, 0).a() + WindowInsetsKt.f(WindowInsets_androidKt.d(companion, composerK, 6), composerK, 0).d());
            } else {
                fG = Dp.g(0);
            }
            composerK.U();
            BackHandlerKt.a(false, handleCloseRequest, composerK, (i4 << 3) & 112, 1);
            AndroidDialog_androidKt.a(handleCloseRequest, new DialogProperties(false, false, null, shouldUsePlatformDefaultWidth(composerK, 0), i5 <= 34, 7, null), ComposableLambdaKt.e(-754282670, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.RevenueCatDialogScaffoldKt.RevenueCatDialogScaffold.1
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

                public final void invoke(Composer composer2, int i6) {
                    if ((i6 & 3) == 2 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-754282670, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.RevenueCatDialogScaffold.<anonymous> (RevenueCatDialogScaffold.kt:51)");
                    }
                    Modifier modifierC = SizeKt.c(SizeKt.h(Modifier.b8, 0.0f, 1, null), RevenueCatDialogScaffoldKt.getDialogMaxHeightPercentage(composer2, 0));
                    long jR = Color.r(Color.f25715b.a(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null);
                    final float f3 = fG;
                    final Function2<Composer, Integer, Unit> function2 = content;
                    ScaffoldKt.a(modifierC, null, null, null, null, 0, jR, 0L, null, ComposableLambdaKt.e(-1072225887, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.RevenueCatDialogScaffoldKt.RevenueCatDialogScaffold.1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            invoke((PaddingValues) obj, (Composer) obj2, ((Number) obj3).intValue());
                            return Unit.f139807a;
                        }

                        public final void invoke(final PaddingValues paddingValues, Composer composer3, int i7) {
                            int i8;
                            Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
                            if ((i7 & 6) == 0) {
                                i8 = i7 | (composer3.Z(paddingValues) ? 4 : 2);
                            } else {
                                i8 = i7;
                            }
                            if ((i8 & 19) == 18 && composer3.l()) {
                                composer3.Q();
                                return;
                            }
                            if (ComposerKt.M()) {
                                ComposerKt.U(-1072225887, i8, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.RevenueCatDialogScaffold.<anonymous>.<anonymous> (RevenueCatDialogScaffold.kt:61)");
                            }
                            float f4 = 0;
                            boolean z2 = Dp.i(paddingValues.a(), Dp.g(f4)) && Dp.i(paddingValues.d(), Dp.g(f4));
                            Modifier modifierF = SizeKt.f(Modifier.b8, 0.0f, 1, null);
                            boolean z3 = Build.VERSION.SDK_INT <= 34;
                            composer3.a0(-1581046047);
                            boolean z4 = (i8 & 14) == 4;
                            Object objG = composer3.G();
                            if (z4 || objG == Composer.f23746a.a()) {
                                objG = new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.RevenueCatDialogScaffoldKt$RevenueCatDialogScaffold$1$1$1$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Modifier invoke(Modifier conditional) {
                                        Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                        return PaddingKt.h(conditional, paddingValues);
                                    }
                                };
                                composer3.w(objG);
                            }
                            composer3.U();
                            Modifier modifierM = PaddingKt.m(ModifierExtensionsKt.conditional(modifierF, z3, (Function1) objG), 0.0f, 0.0f, 0.0f, z2 ? f3 : Dp.g(f4), 7, null);
                            Function2<Composer, Integer, Unit> function22 = function2;
                            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
                            int iA = ComposablesKt.a(composer3, 0);
                            CompositionLocalMap compositionLocalMapU = composer3.u();
                            Modifier modifierF2 = ComposedModifierKt.f(composer3, modifierM);
                            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
                            Function0 function0A = companion2.a();
                            if (composer3.m() == null) {
                                ComposablesKt.c();
                            }
                            composer3.L();
                            if (composer3.i()) {
                                composer3.P(function0A);
                            } else {
                                composer3.v();
                            }
                            Composer composerA = Updater.a(composer3);
                            Updater.e(composerA, measurePolicyG, companion2.e());
                            Updater.e(composerA, compositionLocalMapU, companion2.g());
                            Function2 function2B = companion2.b();
                            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                                composerA.w(Integer.valueOf(iA));
                                composerA.p(Integer.valueOf(iA), function2B);
                            }
                            Updater.e(composerA, modifierF2, companion2.f());
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                            function22.invoke(composer3, 0);
                            composer3.y();
                            if (ComposerKt.M()) {
                                ComposerKt.T();
                            }
                        }
                    }, composer2, 54), composer2, 806879232, 446);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composerK, (i4 & 14) | 384, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.RevenueCatDialogScaffoldKt.RevenueCatDialogScaffold.2
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

                public final void invoke(Composer composer2, int i6) {
                    RevenueCatDialogScaffoldKt.RevenueCatDialogScaffold(handleCloseRequest, content, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final float getDialogMaxHeightPercentage(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1654283702, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.getDialogMaxHeightPercentage (RevenueCatDialogScaffold.kt:79)");
        }
        if (HelperFunctionsKt.windowAspectRatio(composer, 0) < 1.25f) {
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            return 1.0f;
        }
        float f3 = WindowHelperKt.hasCompactDimension(composer, 0) ? 1.0f : 0.85f;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return f3;
    }

    public static final boolean shouldUsePlatformDefaultWidth(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(242326841, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.shouldUsePlatformDefaultWidth (RevenueCatDialogScaffold.kt:88)");
        }
        boolean z2 = !WindowHelperKt.hasCompactDimension(composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return z2;
    }
}
