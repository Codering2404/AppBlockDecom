package com.revenuecat.purchases.ui.revenuecatui.templates;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt;
import com.revenuecat.purchases.ui.revenuecatui.PaywallMode;
import com.revenuecat.purchases.ui.revenuecatui.PaywallOptions;
import com.revenuecat.purchases.ui.revenuecatui.UIConstant;
import com.revenuecat.purchases.ui.revenuecatui.composables.ConsistentPackageContentViewKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.InsetSpacersKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.IntroEligibilityStateViewKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.MarkdownKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.PaywallBackgroundKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallStateKt;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.MockViewModel;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.TestData;
import com.revenuecat.purchases.ui.revenuecatui.extensions.ModifierExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.extensions.PackageExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.WindowHelperKt;
import java.util.Iterator;
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
public final class Template4Kt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void CheckmarkBox(final boolean r15, final com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration.Colors r16, androidx.compose.ui.Modifier r17, androidx.compose.runtime.Composer r18, final int r19, final int r20) {
        /*
            Method dump skipped, instruction units count: 343
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt.CheckmarkBox(boolean, com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration$Colors, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void DiscountRelativeToMostExpensivePerMonth(final java.lang.String r11, final com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration.Colors r12, final boolean r13, androidx.compose.runtime.Composer r14, final int r15) {
        /*
            r0 = -1807074170(0xffffffff944a3c86, float:-1.021033E-26)
            androidx.compose.runtime.Composer r8 = r14.k(r0)
            r14 = r15 & 6
            if (r14 != 0) goto L16
            boolean r14 = r8.Z(r11)
            if (r14 == 0) goto L13
            r14 = 4
            goto L14
        L13:
            r14 = 2
        L14:
            r14 = r14 | r15
            goto L17
        L16:
            r14 = r15
        L17:
            r1 = r15 & 48
            if (r1 != 0) goto L27
            boolean r1 = r8.Z(r12)
            if (r1 == 0) goto L24
            r1 = 32
            goto L26
        L24:
            r1 = 16
        L26:
            r14 = r14 | r1
        L27:
            r1 = r15 & 384(0x180, float:5.38E-43)
            if (r1 != 0) goto L37
            boolean r1 = r8.b(r13)
            if (r1 == 0) goto L34
            r1 = 256(0x100, float:3.59E-43)
            goto L36
        L34:
            r1 = 128(0x80, float:1.8E-43)
        L36:
            r14 = r14 | r1
        L37:
            r1 = r14 & 147(0x93, float:2.06E-43)
            r2 = 146(0x92, float:2.05E-43)
            if (r1 != r2) goto L49
            boolean r1 = r8.l()
            if (r1 != 0) goto L44
            goto L49
        L44:
            r8.Q()
            goto Lb6
        L49:
            boolean r1 = androidx.compose.runtime.ComposerKt.M()
            if (r1 == 0) goto L55
            r1 = -1
            java.lang.String r2 = "com.revenuecat.purchases.ui.revenuecatui.templates.DiscountRelativeToMostExpensivePerMonth (Template4.kt:373)"
            androidx.compose.runtime.ComposerKt.U(r0, r14, r1, r2)
        L55:
            if (r11 == 0) goto L67
            java.util.Locale r14 = java.util.Locale.ROOT
            java.lang.String r14 = r11.toUpperCase(r14)
            java.lang.String r0 = "toUpperCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r0)
            if (r14 != 0) goto L65
            goto L67
        L65:
            r1 = r14
            goto L6a
        L67:
            java.lang.String r14 = ""
            goto L65
        L6a:
            if (r13 == 0) goto L72
            long r2 = r12.m1094getText20d7_KjU()
        L70:
            r3 = r2
            goto L77
        L72:
            long r2 = r12.m1095getText30d7_KjU()
            goto L70
        L77:
            androidx.compose.material3.MaterialTheme r14 = androidx.compose.material3.MaterialTheme.f18110a
            int r0 = androidx.compose.material3.MaterialTheme.f18111b
            androidx.compose.material3.Typography r14 = r14.c(r8, r0)
            androidx.compose.ui.text.TextStyle r5 = r14.d()
            androidx.compose.ui.text.font.FontWeight$Companion r14 = androidx.compose.ui.text.font.FontWeight.f29233b
            androidx.compose.ui.text.font.FontWeight r6 = r14.b()
            androidx.compose.ui.text.style.TextAlign$Companion r14 = androidx.compose.ui.text.style.TextAlign.f29616b
            int r7 = r14.a()
            androidx.compose.ui.Modifier$Companion r14 = androidx.compose.ui.Modifier.b8
            com.revenuecat.purchases.ui.revenuecatui.UIConstant r0 = com.revenuecat.purchases.ui.revenuecatui.UIConstant.INSTANCE
            float r0 = r0.m690getDefaultHorizontalPaddingD9Ej5fM()
            com.revenuecat.purchases.ui.revenuecatui.templates.Template4UIConstants r2 = com.revenuecat.purchases.ui.revenuecatui.templates.Template4UIConstants.INSTANCE
            float r2 = r2.m1210getDiscountVerticalPaddingD9Ej5fM()
            androidx.compose.ui.Modifier r14 = androidx.compose.foundation.layout.PaddingKt.j(r14, r0, r2)
            com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt$DiscountRelativeToMostExpensivePerMonth$1 r0 = new kotlin.jvm.functions.Function1<androidx.compose.ui.semantics.SemanticsPropertyReceiver, kotlin.Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt.DiscountRelativeToMostExpensivePerMonth.1
                static {
                    /*
                        com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt$DiscountRelativeToMostExpensivePerMonth$1 r0 = new com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt$DiscountRelativeToMostExpensivePerMonth$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt$DiscountRelativeToMostExpensivePerMonth$1) com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt.DiscountRelativeToMostExpensivePerMonth.1.INSTANCE com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt$DiscountRelativeToMostExpensivePerMonth$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt.AnonymousClass1.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 1
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt.AnonymousClass1.<init>():void");
                }

                public final void invoke(androidx.compose.ui.semantics.SemanticsPropertyReceiver r2) {
                    /*
                        r1 = this;
                        java.lang.String r0 = "$this$clearAndSetSemantics"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt.AnonymousClass1.invoke(androidx.compose.ui.semantics.SemanticsPropertyReceiver):void");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r1) {
                    /*
                        r0 = this;
                        androidx.compose.ui.semantics.SemanticsPropertyReceiver r1 = (androidx.compose.ui.semantics.SemanticsPropertyReceiver) r1
                        r0.invoke(r1)
                        kotlin.Unit r1 = kotlin.Unit.f139807a
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt.AnonymousClass1.invoke(java.lang.Object):java.lang.Object");
                }
            }
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.semantics.SemanticsModifierKt.c(r14, r0)
            r9 = 24576(0x6000, float:3.4438E-41)
            r10 = 0
            com.revenuecat.purchases.ui.revenuecatui.composables.AutoResizedTextKt.m870AutoResizedTextW72HBGU(r1, r2, r3, r5, r6, r7, r8, r9, r10)
            boolean r14 = androidx.compose.runtime.ComposerKt.M()
            if (r14 == 0) goto Lb6
            androidx.compose.runtime.ComposerKt.T()
        Lb6:
            androidx.compose.runtime.ScopeUpdateScope r14 = r8.n()
            if (r14 == 0) goto Lc4
            com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt$DiscountRelativeToMostExpensivePerMonth$2 r0 = new com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt$DiscountRelativeToMostExpensivePerMonth$2
            r0.<init>()
            r14.a(r0)
        Lc4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt.DiscountRelativeToMostExpensivePerMonth(java.lang.String, com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration$Colors, boolean, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: OfferName-3IgeMak, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1201OfferName3IgeMak(com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration.PackageInfo r32, final long r33, androidx.compose.ui.Modifier r35, androidx.compose.runtime.Composer r36, final int r37, final int r38) {
        /*
            Method dump skipped, instruction units count: 530
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt.m1201OfferName3IgeMak(com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration$PackageInfo, long, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Packages(final PaywallState.Loaded.Legacy legacy, final PaywallViewModel paywallViewModel, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(2132177050);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(legacy) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(paywallViewModel) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(2132177050, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Packages (Template4.kt:217)");
            }
            BoxWithConstraintsKt.a(null, null, false, ComposableLambdaKt.e(-1700467196, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt.Packages.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(BoxWithConstraintsScope BoxWithConstraints, Composer composer2, int i5) {
                    Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
                    if ((i5 & 6) == 0) {
                        i5 |= composer2.Z(BoxWithConstraints) ? 4 : 2;
                    }
                    if ((i5 & 19) == 18 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-1700467196, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Packages.<anonymous> (Template4.kt:234)");
                    }
                    float fPackages$packageWidth = Template4Kt.Packages$packageWidth(BoxWithConstraints, legacy.getTemplateConfiguration().getPackages().getAll().size());
                    Modifier modifierB = ScrollKt.b(SizeKt.h(IntrinsicKt.a(Modifier.b8, IntrinsicSize.f6986a), 0.0f, 1, null), ScrollKt.c(0, composer2, 0, 1), false, null, false, 14, null);
                    Template4UIConstants template4UIConstants = Template4UIConstants.INSTANCE;
                    Modifier modifierJ = PaddingKt.j(modifierB, template4UIConstants.m1213getPackagesHorizontalPaddingD9Ej5fM(), UIConstant.INSTANCE.m693getDefaultVerticalSpacingD9Ej5fM());
                    Arrangement.HorizontalOrVertical horizontalOrVerticalO = Arrangement.f6574a.o(template4UIConstants.m1212getPackageHorizontalSpacingD9Ej5fM());
                    PaywallState.Loaded.Legacy legacy2 = legacy;
                    PaywallViewModel paywallViewModel2 = paywallViewModel;
                    MeasurePolicy measurePolicyB = RowKt.b(horizontalOrVerticalO, Alignment.f25072a.l(), composer2, 6);
                    int iA = ComposablesKt.a(composer2, 0);
                    CompositionLocalMap compositionLocalMapU = composer2.u();
                    Modifier modifierF = ComposedModifierKt.f(composer2, modifierJ);
                    ComposeUiNode.Companion companion = ComposeUiNode.f8;
                    Function0 function0A = companion.a();
                    if (composer2.m() == null) {
                        ComposablesKt.c();
                    }
                    composer2.L();
                    if (composer2.i()) {
                        composer2.P(function0A);
                    } else {
                        composer2.v();
                    }
                    Composer composerA = Updater.a(composer2);
                    Updater.e(composerA, measurePolicyB, companion.e());
                    Updater.e(composerA, compositionLocalMapU, companion.g());
                    Function2 function2B = companion.b();
                    if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                        composerA.w(Integer.valueOf(iA));
                        composerA.p(Integer.valueOf(iA), function2B);
                    }
                    Updater.e(composerA, modifierF, companion.f());
                    RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
                    composer2.a0(632318323);
                    Iterator<T> it = legacy2.getTemplateConfiguration().getPackages().getAll().iterator();
                    while (it.hasNext()) {
                        Template4Kt.SelectPackageButton(legacy2, (TemplateConfiguration.PackageInfo) it.next(), paywallViewModel2, SizeKt.A(Modifier.b8, fPackages$packageWidth), composer2, 0, 0);
                    }
                    composer2.U();
                    composer2.y();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composerK, 3072, 7);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt.Packages.2
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
                    Template4Kt.Packages(legacy, paywallViewModel, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float Packages$packageWidth(BoxWithConstraintsScope boxWithConstraintsScope, float f3) {
        float fPackages$packagesToDisplay = Packages$packagesToDisplay(f3);
        Template4UIConstants template4UIConstants = Template4UIConstants.INSTANCE;
        return Dp.g(Dp.g(Dp.g(boxWithConstraintsScope.d() - Dp.g(template4UIConstants.m1213getPackagesHorizontalPaddingD9Ej5fM() * 2)) - Dp.g(template4UIConstants.m1212getPackageHorizontalSpacingD9Ej5fM() * (fPackages$packagesToDisplay - 1))) / fPackages$packagesToDisplay);
    }

    private static final float Packages$packagesToDisplay(float f3) {
        return Math.min(Math.min(3.5f, f3), 3.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:113:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void SelectPackageButton(final com.revenuecat.purchases.ui.revenuecatui.data.PaywallState.Loaded.Legacy r30, final com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration.PackageInfo r31, final com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel r32, androidx.compose.ui.Modifier r33, androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instruction units count: 876
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt.SelectPackageButton(com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Legacy, com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration$PackageInfo, com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SelectPackageButtonContent(final TemplateConfiguration.PackageInfo packageInfo, final TemplateConfiguration.Colors colors, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(2102143927);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(packageInfo) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(colors) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(2102143927, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.SelectPackageButtonContent (Template4.kt:346)");
            }
            Arrangement.HorizontalOrVertical horizontalOrVerticalO = Arrangement.f6574a.o(Template4UIConstants.INSTANCE.m1211getPackageButtonContentVerticalSpacingD9Ej5fM());
            Alignment.Horizontal horizontalG = Alignment.f25072a.g();
            Modifier.Companion companion = Modifier.b8;
            MeasurePolicy measurePolicyA = ColumnKt.a(horizontalOrVerticalO, horizontalG, composerK, 54);
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            m1201OfferName3IgeMak(packageInfo, colors.m1093getText10d7_KjU(), ColumnScope.b(ColumnScopeInstance.f6666a, SizeKt.G(companion, null, false, 3, null), 1.0f, false, 2, null), composerK, i4 & 14, 0);
            TextKt.c(packageInfo.getRcPackage().getProduct().getPrice().getFormatted(), null, colors.m1093getText10d7_KjU(), 0L, null, FontWeight.f29233b.h(), null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.f18110a.c(composerK, MaterialTheme.f18111b).b(), composerK, 196608, 0, 65498);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt.SelectPackageButtonContent.2
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
                    Template4Kt.SelectPackageButtonContent(packageInfo, colors, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final void Template4(final PaywallState.Loaded.Legacy state, final PaywallViewModel viewModel, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer composerK = composer.k(596926027);
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
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(596926027, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template4 (Template4.kt:102)");
            }
            if (PaywallStateKt.isInFullScreenMode(state)) {
                composerK.a0(-1356655279);
                int i5 = i4 & 14;
                boolean zShouldUseLandscapeLayout = WindowHelperKt.shouldUseLandscapeLayout(state, composerK, i5);
                Modifier.Companion companion = Modifier.b8;
                Modifier modifierF = SizeKt.f(companion, 0.0f, 1, null);
                Alignment.Companion companion2 = Alignment.f25072a;
                MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
                int iA = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU = composerK.u();
                Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierF);
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
                Updater.e(composerA, measurePolicyG, companion3.e());
                Updater.e(composerA, compositionLocalMapU, companion3.g());
                Function2 function2B = companion3.b();
                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                    composerA.w(Integer.valueOf(iA));
                    composerA.p(Integer.valueOf(iA), function2B);
                }
                Updater.e(composerA, modifierF2, companion3.f());
                final BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                composerK.a0(-1319514881);
                if (!zShouldUseLandscapeLayout) {
                    PaywallBackgroundKt.PaywallBackground(boxScopeInstance, state.getTemplateConfiguration(), composerK, 6);
                }
                composerK.U();
                composerK.a0(-1319508245);
                Object objG = composerK.G();
                Composer.Companion companion4 = Composer.f23746a;
                if (objG == companion4.a()) {
                    objG = new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt$Template4$1$1$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Modifier invoke(Modifier conditional) {
                            Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                            return boxScopeInstance.f(Modifier.b8, Alignment.f25072a.e());
                        }
                    };
                    composerK.w(objG);
                }
                composerK.U();
                Modifier modifierConditional = ModifierExtensionsKt.conditional(companion, zShouldUseLandscapeLayout, (Function1) objG);
                boolean z2 = !zShouldUseLandscapeLayout;
                composerK.a0(-1319503568);
                Object objG2 = composerK.G();
                if (objG2 == companion4.a()) {
                    objG2 = new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt$Template4$1$2$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Modifier invoke(Modifier conditional) {
                            Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                            Modifier modifierF3 = boxScopeInstance.f(Modifier.b8, Alignment.f25072a.b());
                            UIConstant uIConstant = UIConstant.INSTANCE;
                            float f3 = 0;
                            return ClipKt.a(modifierF3, RoundedCornerShapeKt.e(uIConstant.m689getDefaultCornerRadiusD9Ej5fM(), uIConstant.m689getDefaultCornerRadiusD9Ej5fM(), Dp.g(f3), Dp.g(f3)));
                        }
                    };
                    composerK.w(objG2);
                }
                composerK.U();
                Modifier modifierD = BackgroundKt.d(ModifierExtensionsKt.conditional(modifierConditional, z2, (Function1) objG2), PaywallStateKt.getCurrentColors(state, composerK, i5).m1088getBackground0d7_KjU(), null, 2, null);
                MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), companion2.k(), composerK, 0);
                int iA2 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU2 = composerK.u();
                Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierD);
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
                Updater.e(composerA2, measurePolicyA, companion3.e());
                Updater.e(composerA2, compositionLocalMapU2, companion3.g());
                Function2 function2B2 = companion3.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                    composerA2.w(Integer.valueOf(iA2));
                    composerA2.p(Integer.valueOf(iA2), function2B2);
                }
                Updater.e(composerA2, modifierF3, companion3.f());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
                composerK.a0(-1458604088);
                if (zShouldUseLandscapeLayout) {
                    InsetSpacersKt.StatusBarSpacer(composerK, 0);
                }
                composerK.U();
                Template4MainContent(state, viewModel, composerK, i4 & 126);
                composerK.y();
                composerK.y();
                composerK.U();
            } else {
                composerK.a0(-1355397392);
                Template4MainContent(state, viewModel, composerK, i4 & 126);
                composerK.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt.Template4.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i6) {
                    Template4Kt.Template4(state, viewModel, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template4MainContent(final PaywallState.Loaded.Legacy legacy, PaywallViewModel paywallViewModel, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Modifier.Companion companion;
        int i5;
        Arrangement arrangement;
        SnapshotMutationPolicy snapshotMutationPolicy;
        final PaywallState.Loaded.Legacy legacy2;
        Composer composer3;
        final PaywallViewModel paywallViewModel2 = paywallViewModel;
        Composer composerK = composer.k(-1408056045);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(legacy) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(paywallViewModel2) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
            legacy2 = legacy;
            composer3 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1408056045, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template4MainContent (Template4.kt:148)");
            }
            final TemplateConfiguration.Colors currentColors = legacy.getTemplateConfiguration().getCurrentColors(composerK, 0);
            Modifier.Companion companion2 = Modifier.b8;
            UIConstant uIConstant = UIConstant.INSTANCE;
            Modifier modifierM = PaddingKt.m(companion2, 0.0f, uIConstant.m693getDefaultVerticalSpacingD9Ej5fM(), 0.0f, 0.0f, 13, null);
            Arrangement arrangement2 = Arrangement.f6574a;
            Arrangement.HorizontalOrVertical horizontalOrVerticalO = arrangement2.o(uIConstant.m693getDefaultVerticalSpacingD9Ej5fM());
            Alignment.Companion companion3 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(horizontalOrVerticalO, companion3.g(), composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierM);
            ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
            Function0 function0A = companion4.a();
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
            Updater.e(composerA, measurePolicyA, companion4.e());
            Updater.e(composerA, compositionLocalMapU, companion4.g());
            Function2 function2B = companion4.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion4.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            composerK.a0(-1434964265);
            if (PaywallStateKt.isInFullScreenMode(legacy)) {
                companion = companion2;
                arrangement = arrangement2;
                i5 = i4;
                snapshotMutationPolicy = null;
                MarkdownKt.m901MarkdownDkhmgE0(PaywallStateKt.getSelectedLocalization(legacy).getTitle(), PaddingKt.k(companion2, uIConstant.m690getDefaultHorizontalPaddingD9Ej5fM(), 0.0f, 2, null), currentColors.m1093getText10d7_KjU(), MaterialTheme.f18110a.c(composerK, MaterialTheme.f18111b).g(), 0L, FontWeight.f29233b.a(), null, null, TextAlign.h(TextAlign.f29616b.a()), false, true, false, composerK, 196608, 54, 720);
                composer2 = composerK;
            } else {
                composer2 = composerK;
                companion = companion2;
                i5 = i4;
                arrangement = arrangement2;
                snapshotMutationPolicy = null;
            }
            composer2.U();
            composer2.a0(-1434945388);
            Object objG = composer2.G();
            Composer.Companion companion5 = Composer.f23746a;
            if (objG == companion5.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.valueOf(legacy.getTemplateConfiguration().getMode() != PaywallMode.FOOTER_CONDENSED), snapshotMutationPolicy, 2, snapshotMutationPolicy);
                composer2.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            composer2.U();
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.h(), companion3.g(), composer2, 48);
            int iA2 = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU2 = composer2.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer2, companion);
            Function0 function0A2 = companion4.a();
            if (composer2.m() == null) {
                ComposablesKt.c();
            }
            composer2.L();
            if (composer2.i()) {
                composer2.P(function0A2);
            } else {
                composer2.v();
            }
            Composer composerA2 = Updater.a(composer2);
            Updater.e(composerA2, measurePolicyA2, companion4.e());
            Updater.e(composerA2, compositionLocalMapU2, companion4.g());
            Function2 function2B2 = companion4.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion4.f());
            Composer composer4 = composer2;
            AnimatedVisibilityKt.g(columnScopeInstance, Template4MainContent$lambda$9$lambda$5(mutableState), null, EnterExitTransitionKt.m(null, companion3.a(), false, null, 13, null), EnterExitTransitionKt.A(null, companion3.a(), false, null, 13, null), "SelectPackagesVisibility", ComposableLambdaKt.e(492758735, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt$Template4MainContent$1$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((AnimatedVisibilityScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer5, int i6) {
                    Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                    if (ComposerKt.M()) {
                        ComposerKt.U(492758735, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template4MainContent.<anonymous>.<anonymous>.<anonymous> (Template4.kt:182)");
                    }
                    Template4Kt.Packages(legacy, paywallViewModel2, composer5, 0);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composer2, 54), composer4, 1797126, 2);
            AnimatedVisibilityKt.g(columnScopeInstance, Template4MainContent$lambda$9$lambda$5(mutableState), null, null, null, null, ComposableSingletons$Template4Kt.INSTANCE.m1171getLambda1$revenuecatui_defaultsBc8Release(), composer4, 1572870, 30);
            ConsistentPackageContentViewKt.ConsistentPackageContentView(legacy, ComposableLambdaKt.e(-1316875667, true, new Function3<TemplateConfiguration.PackageInfo, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt$Template4MainContent$1$1$2
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((TemplateConfiguration.PackageInfo) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(TemplateConfiguration.PackageInfo it, Composer composer5, int i6) {
                    int i7;
                    Intrinsics.checkNotNullParameter(it, "it");
                    if ((i6 & 6) == 0) {
                        i7 = i6 | (composer5.Z(it) ? 4 : 2);
                    } else {
                        i7 = i6;
                    }
                    if ((i7 & 19) == 18 && composer5.l()) {
                        composer5.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-1316875667, i7, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template4MainContent.<anonymous>.<anonymous>.<anonymous> (Template4.kt:190)");
                    }
                    IntroEligibilityStateViewKt.m892IntroEligibilityStateViewQETHhvg(it.getLocalization().getOfferDetails(), it.getLocalization().getOfferDetailsWithIntroOffer(), it.getLocalization().getOfferDetailsWithMultipleIntroOffers(), PackageExtensionsKt.getOfferEligibility(it), currentColors.m1093getText10d7_KjU(), MaterialTheme.f18110a.c(composer5, MaterialTheme.f18111b).c(), null, TextAlign.h(TextAlign.f29616b.a()), false, SizeKt.h(Modifier.b8, 0.0f, 1, null), composer5, 805306368, 320);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composer4, 54), composer4, (i5 & 14) | 48);
            composer4.y();
            int i6 = i5 & 112;
            PurchaseButtonKt.m923PurchaseButtonhGBTI10(legacy, paywallViewModel2, null, 0.0f, null, composer4, i5 & 126, 28);
            legacy2 = legacy;
            TemplateConfiguration templateConfiguration = legacy2.getTemplateConfiguration();
            composer4.a0(-1434895273);
            Object objG2 = composer4.G();
            if (objG2 == companion5.a()) {
                objG2 = new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt$Template4MainContent$1$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1204invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m1204invoke() {
                        Template4Kt.Template4MainContent$lambda$9$lambda$6(mutableState, !Template4Kt.Template4MainContent$lambda$9$lambda$5(r0));
                    }
                };
                composer4.w(objG2);
            }
            composer4.U();
            paywallViewModel2 = paywallViewModel;
            FooterKt.Footer(templateConfiguration, paywallViewModel2, null, null, (Function0) objG2, composer4, i6 | 24576, 12);
            composer3 = composer4;
            composer3.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer3.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt.Template4MainContent.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer5, int i7) {
                    Template4Kt.Template4MainContent(legacy2, paywallViewModel2, composer5, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Template4MainContent$lambda$9$lambda$5(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template4MainContent$lambda$9$lambda$6(MutableState<Boolean> mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template4PaywallFooterCondensedPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(-1780033640);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1780033640, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template4PaywallFooterCondensedPreview (Template4.kt:488)");
            }
            InternalPaywallKt.InternalPaywall(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt.Template4PaywallFooterCondensedPreview.1
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1205invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1205invoke();
                    return Unit.f139807a;
                }
            }).build(), new MockViewModel(PaywallMode.FOOTER_CONDENSED, TestData.INSTANCE.getTemplate4Offering(), null, false, false, 28, null), composerK, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt.Template4PaywallFooterCondensedPreview.2
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
                    Template4Kt.Template4PaywallFooterCondensedPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template4PaywallFooterPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(-1022674125);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1022674125, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template4PaywallFooterPreview (Template4.kt:477)");
            }
            InternalPaywallKt.InternalPaywall(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt.Template4PaywallFooterPreview.1
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1206invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1206invoke();
                    return Unit.f139807a;
                }
            }).build(), new MockViewModel(PaywallMode.FOOTER, TestData.INSTANCE.getTemplate4Offering(), null, false, false, 28, null), composerK, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt.Template4PaywallFooterPreview.2
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
                    Template4Kt.Template4PaywallFooterPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template4PaywallPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(-1574269896);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1574269896, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template4PaywallPreview (Template4.kt:466)");
            }
            InternalPaywallKt.InternalPaywall(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt.Template4PaywallPreview.1
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1207invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1207invoke();
                    return Unit.f139807a;
                }
            }).build(), new MockViewModel(null, TestData.INSTANCE.getTemplate4Offering(), null, false, false, 29, null), composerK, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt.Template4PaywallPreview.2
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
                    Template4Kt.Template4PaywallPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }
}
