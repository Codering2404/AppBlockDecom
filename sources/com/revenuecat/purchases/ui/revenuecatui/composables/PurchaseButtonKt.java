package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import com.revenuecat.purchases.ui.revenuecatui.UIConstant;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.MockViewModel;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.TestData;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class PurchaseButtonKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void LoadingSpinner(final BoxScope boxScope, boolean z2, final TemplateConfiguration.Colors colors, Composer composer, final int i3) {
        int i4;
        final boolean z3;
        Composer composerK = composer.k(-268216038);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(boxScope) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(colors) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 147) == 146 && composerK.l()) {
            composerK.Q();
            z3 = z2;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-268216038, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.LoadingSpinner (PurchaseButton.kt:200)");
            }
            Modifier modifierF = boxScope.f(Modifier.b8, Alignment.f25072a.e());
            UIConstant uIConstant = UIConstant.INSTANCE;
            z3 = z2;
            AnimatedVisibilityKt.j(z3, modifierF, EnterExitTransitionKt.o(uIConstant.defaultAnimation(), 0.0f, 2, null), EnterExitTransitionKt.q(uIConstant.defaultAnimation(), 0.0f, 2, null), "PurchaseButton.LoadingSpinner", ComposableLambdaKt.e(-1498164238, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt.LoadingSpinner.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((AnimatedVisibilityScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer2, int i5) {
                    Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                    if (ComposerKt.M()) {
                        ComposerKt.U(-1498164238, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.LoadingSpinner.<anonymous> (PurchaseButton.kt:208)");
                    }
                    ProgressIndicatorKt.d(boxScope.f(Modifier.b8, Alignment.f25072a.e()), colors.m1090getCallToActionForeground0d7_KjU(), 0.0f, 0L, 0, composer2, 0, 28);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composerK, ((i4 >> 3) & 14) | 221184, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt.LoadingSpinner.2
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
                    PurchaseButtonKt.LoadingSpinner(boxScope, z3, colors, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:130:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01dc  */
    /* JADX INFO: renamed from: PurchaseButton-WH-ejsw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m922PurchaseButtonWHejsw(final com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration.Colors r31, final com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration.PackageConfiguration r32, final androidx.compose.runtime.MutableState<com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration.PackageInfo> r33, final com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel r34, final float r35, androidx.compose.ui.Modifier r36, androidx.compose.runtime.Composer r37, final int r38, final int r39) {
        /*
            Method dump skipped, instruction units count: 740
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt.m922PurchaseButtonWHejsw(com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration$Colors, com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration$PackageConfiguration, androidx.compose.runtime.MutableState, com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel, float, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:86:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0128  */
    /* JADX INFO: renamed from: PurchaseButton-hGBTI10, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m923PurchaseButtonhGBTI10(final com.revenuecat.purchases.ui.revenuecatui.data.PaywallState.Loaded.Legacy r13, final com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel r14, androidx.compose.ui.Modifier r15, float r16, com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration.Colors r17, androidx.compose.runtime.Composer r18, final int r19, final int r20) {
        /*
            Method dump skipped, instruction units count: 320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt.m923PurchaseButtonhGBTI10(com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Legacy, com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel, androidx.compose.ui.Modifier, float, com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration$Colors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PurchaseButtonPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(1498117025);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1498117025, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonPreview (PurchaseButton.kt:217)");
            }
            MockViewModel mockViewModel = new MockViewModel(null, TestData.INSTANCE.getTemplate2Offering(), null, true, false, 21, null);
            PaywallState.Loaded.Legacy legacyLoadedLegacyState = mockViewModel.loadedLegacyState();
            if (legacyLoadedLegacyState != null) {
                m923PurchaseButtonhGBTI10(legacyLoadedLegacyState, mockViewModel, null, 0.0f, null, composerK, 0, 28);
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt.PurchaseButtonPreview.1
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
                    PurchaseButtonKt.PurchaseButtonPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float PurchaseButton_WH_ejsw$lambda$6$lambda$0(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }

    private static final long PurchaseButton_WH_ejsw$lambda$6$lambda$1(State<Color> state) {
        return ((Color) state.getValue()).B();
    }

    private static final long PurchaseButton_WH_ejsw$lambda$6$lambda$2(State<Color> state) {
        return ((Color) state.getValue()).B();
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0033  */
    /* JADX INFO: renamed from: buttonBrush-A47ccPs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final androidx.compose.ui.graphics.Brush m925buttonBrushA47ccPs(long r7, androidx.compose.ui.graphics.Color r9, androidx.compose.runtime.Composer r10, int r11) {
        /*
            boolean r10 = androidx.compose.runtime.ComposerKt.M()
            if (r10 == 0) goto Lf
            r10 = -1
            java.lang.String r0 = "com.revenuecat.purchases.ui.revenuecatui.composables.buttonBrush (PurchaseButton.kt:188)"
            r1 = -58833710(0xfffffffffc7e44d2, float:-5.280957E36)
            androidx.compose.runtime.ComposerKt.U(r1, r11, r10, r0)
        Lf:
            if (r9 == 0) goto L33
            long r9 = r9.B()
            androidx.compose.ui.graphics.Brush$Companion r0 = androidx.compose.ui.graphics.Brush.Companion
            androidx.compose.ui.graphics.Color r11 = androidx.compose.ui.graphics.Color.n(r7)
            androidx.compose.ui.graphics.Color r9 = androidx.compose.ui.graphics.Color.n(r9)
            androidx.compose.ui.graphics.Color[] r9 = new androidx.compose.ui.graphics.Color[]{r11, r9}
            java.util.List r1 = kotlin.collections.CollectionsKt.listOf(r9)
            r5 = 14
            r6 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            androidx.compose.ui.graphics.Brush r9 = androidx.compose.ui.graphics.Brush.Companion.m(r0, r1, r2, r3, r4, r5, r6)
            if (r9 != 0) goto L39
        L33:
            androidx.compose.ui.graphics.SolidColor r9 = new androidx.compose.ui.graphics.SolidColor
            r10 = 0
            r9.<init>(r7, r10)
        L39:
            boolean r7 = androidx.compose.runtime.ComposerKt.M()
            if (r7 == 0) goto L42
            androidx.compose.runtime.ComposerKt.T()
        L42:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt.m925buttonBrushA47ccPs(long, androidx.compose.ui.graphics.Color, androidx.compose.runtime.Composer, int):androidx.compose.ui.graphics.Brush");
    }
}
