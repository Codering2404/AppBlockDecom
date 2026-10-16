package com.revenuecat.purchases.ui.revenuecatui.composables;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.widget.Toast;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.ui.revenuecatui.PaywallMode;
import com.revenuecat.purchases.ui.revenuecatui.R;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.ColorsFactory;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.MockViewModel;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.TestData;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.templates.Template2TestDataKt;
import com.revenuecat.purchases.ui.revenuecatui.extensions.UrisKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import com.sun.jna.Function;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;

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
public final class FooterKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Button-sW7UJKQ, reason: not valid java name */
    public static final void m882ButtonsW7UJKQ(final RowScope rowScope, final long j3, final Modifier modifier, final int[] iArr, final Function0<Unit> function0, Composer composer, final int i3) {
        Composer composer2;
        Composer composerK = composer.k(-806477784);
        int i4 = (i3 & 6) == 0 ? (composerK.Z(rowScope) ? 4 : 2) | i3 : i3;
        if ((i3 & 48) == 0) {
            i4 |= composerK.f(j3) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(modifier) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(function0) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        composerK.K(2067025279, Integer.valueOf(iArr.length));
        for (int i5 : iArr) {
            i4 |= composerK.e(i5) ? 2048 : 0;
        }
        composerK.X();
        if ((i4 & 7168) == 0) {
            i4 |= 1024;
        }
        if ((i4 & 9363) == 9362 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-806477784, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.Button (Footer.kt:222)");
            }
            final String strB = StringResources_androidKt.b(ArraysKt.first(iArr), composerK, 0);
            Modifier.Companion companion = Modifier.b8;
            int i6 = i4;
            Modifier modifierC = RowScope.c(rowScope, companion, 1.0f, false, 2, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            Modifier modifierD = rowScope.d(modifierC, companion2.i());
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), companion2.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierD);
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
            composerK.a0(814498096);
            boolean z2 = (i6 & 57344) == 16384;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new FooterKt$Button$1$1$1(function0);
                composerK.w(objG);
            }
            KFunction kFunction = (KFunction) objG;
            composerK.U();
            PaddingValues paddingValuesA = PaddingKt.a(Dp.g(4));
            Modifier modifierC2 = columnScopeInstance.c(companion, companion2.g());
            composerK.a0(814504399);
            boolean Z = composerK.Z(strB);
            Object objG2 = composerK.G();
            if (Z || objG2 == Composer.f23746a.a()) {
                objG2 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt$Button$1$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((SemanticsPropertyReceiver) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(SemanticsPropertyReceiver semantics) {
                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        SemanticsPropertiesKt.y0(semantics, new AnnotatedString(strB, null, null, 6, null));
                    }
                };
                composerK.w(objG2);
            }
            composerK.U();
            composer2 = composerK;
            ButtonKt.e((Function0) kFunction, SemanticsModifierKt.e(modifierC2, true, (Function1) objG2), false, null, null, null, null, paddingValuesA, null, ComposableLambdaKt.e(365963733, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt$Button$1$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(RowScope TextButton, Composer composer3, int i7) {
                    Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                    int i8 = (i7 & 6) == 0 ? i7 | (composer3.Z(TextButton) ? 4 : 2) : i7;
                    if ((i8 & 19) == 18 && composer3.l()) {
                        composer3.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(365963733, i8, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.Button.<anonymous>.<anonymous> (Footer.kt:246)");
                    }
                    Modifier modifierC3 = SemanticsModifierKt.c(Modifier.b8, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt$Button$1$3.1
                        public final void invoke(SemanticsPropertyReceiver clearAndSetSemantics) {
                            Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return Unit.f139807a;
                        }
                    });
                    composer3.a0(-1033561293);
                    int[] iArr2 = iArr;
                    final Modifier modifier2 = modifier;
                    final long j4 = j3;
                    ArrayList arrayList = new ArrayList(iArr2.length);
                    for (final int i9 : iArr2) {
                        arrayList.add(ComposableLambdaKt.e(-1943754282, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt$Button$1$3$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.f139807a;
                            }

                            public final void invoke(Composer composer4, int i10) {
                                if ((i10 & 3) == 2 && composer4.l()) {
                                    composer4.Q();
                                    return;
                                }
                                if (ComposerKt.M()) {
                                    ComposerKt.U(-1943754282, i10, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.Button.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Footer.kt:252)");
                                }
                                String strB2 = StringResources_androidKt.b(i9, composer4, 0);
                                int iA2 = TextAlign.f29616b.a();
                                TextKt.c(strB2, modifier2, j4, 0L, null, null, null, 0L, null, TextAlign.h(iA2), 0L, 0, false, 1, 0, null, FooterConstants.INSTANCE.style(composer4, 6), composer4, 0, 3456, 52728);
                                if (ComposerKt.M()) {
                                    ComposerKt.T();
                                }
                            }
                        }, composer3, 54));
                    }
                    composer3.U();
                    composer3.a0(-1033543484);
                    int[] iArr3 = iArr;
                    final Modifier modifier3 = modifier;
                    final long j5 = j3;
                    ArrayList arrayList2 = new ArrayList(iArr3.length);
                    for (final int i10 : iArr3) {
                        arrayList2.add(ComposableLambdaKt.e(1301841013, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt$Button$1$3$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.f139807a;
                            }

                            public final void invoke(Composer composer4, int i11) {
                                if ((i11 & 3) == 2 && composer4.l()) {
                                    composer4.Q();
                                    return;
                                }
                                if (ComposerKt.M()) {
                                    ComposerKt.U(1301841013, i11, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.Button.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Footer.kt:265)");
                                }
                                String strB2 = StringResources_androidKt.b(i10, composer4, 0);
                                int iA2 = TextAlign.f29616b.a();
                                TextKt.c(strB2, modifier3, j5, 0L, null, null, null, 0L, null, TextAlign.h(iA2), 0L, 0, true, 0, 0, null, FooterConstants.INSTANCE.style(composer4, 6), composer4, 0, 384, 60920);
                                if (ComposerKt.M()) {
                                    ComposerKt.T();
                                }
                            }
                        }, composer3, 54));
                    }
                    composer3.U();
                    AdaptiveComposableKt.AdaptiveComposable(TextButton, modifierC3, FooterKt.Button_sW7UJKQ$merge(arrayList, arrayList2), composer3, i8 & 14, 0);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composer2, 817889280, 380);
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt$Button$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i7) {
                    RowScope rowScope2 = rowScope;
                    long j4 = j3;
                    Modifier modifier2 = modifier;
                    int[] iArr2 = iArr;
                    FooterKt.m882ButtonsW7UJKQ(rowScope2, j4, modifier2, Arrays.copyOf(iArr2, iArr2.length), function0, composer3, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> List<T> Button_sW7UJKQ$merge(List<? extends T> list, List<? extends T> list2) {
        return CollectionsKt.plus((Collection) list, (Iterable) list2);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0162  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void Footer(final com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration r17, final com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel r18, androidx.compose.ui.Modifier r19, com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration.Colors r20, kotlin.jvm.functions.Function0<kotlin.Unit> r21, androidx.compose.runtime.Composer r22, final int r23, final int r24) {
        /*
            Method dump skipped, instruction units count: 450
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt.Footer(com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration, com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel, androidx.compose.ui.Modifier, com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration$Colors, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FooterPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(-1861228911);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1861228911, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.FooterPreview (Footer.kt:300)");
            }
            PaywallMode paywallMode = PaywallMode.FULL_SCREEN;
            List listEmptyList = CollectionsKt.emptyList();
            URL url = new URL("https://revenuecat.com/tos");
            URL url2 = new URL("https://revenuecat.com/privacy");
            PaywallData.Configuration.Images images = new PaywallData.Configuration.Images((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
            TestData testData = TestData.INSTANCE;
            Footer(paywallMode, new PaywallData.Configuration(listEmptyList, (String) null, images, (Map) null, Template2TestDataKt.getTemplate2(testData).getConfig().getColors(), (Map) null, (List) null, false, true, url, url2, 104, (DefaultConstructorMarker) null), ColorsFactory.INSTANCE.create(Template2TestDataKt.getTemplate2(testData).getConfig().getColors().getLight()), new MockViewModel(paywallMode, testData.getTemplate2Offering(), null, false, false, 28, null), null, null, composerK, 6, 48);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt.FooterPreview.1
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
                    FooterKt.FooterPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Separator-RPmYEkk, reason: not valid java name */
    public static final void m883SeparatorRPmYEkk(final RowScope rowScope, final long j3, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(1035469312);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(rowScope) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.f(j3) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1035469312, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.Separator (Footer.kt:199)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            Modifier modifierC = RowScope.c(rowScope, SizeKt.G(modifierH, companion2.e(), false, 2, null), 0.5f, false, 2, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), companion2.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierC);
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
            BoxKt.a(BackgroundKt.d(ClipKt.a(SizeKt.v(companion, Dp.g(5)), RoundedCornerShapeKt.g()), j3, null, 2, null), composerK, 0);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt$Separator$2
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
                    FooterKt.m883SeparatorRPmYEkk(rowScope, j3, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openURL(final Context context, URL url) {
        String string = url.toString();
        Intrinsics.checkNotNullExpressionValue(string, "url.toString()");
        UrisKt.openUriOrElse(context, string, new Function1<Exception, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt.openURL.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Exception) obj);
                return Unit.f139807a;
            }

            public final void invoke(Exception exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                String string2 = exception instanceof ActivityNotFoundException ? context.getString(R.string.no_browser_cannot_open_link) : context.getString(R.string.cannot_open_link);
                Intrinsics.checkNotNullExpressionValue(string2, "if (exception is Activit…nnot_open_link)\n        }");
                Toast.makeText(context, string2, 0).show();
                Logger.INSTANCE.w(string2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:188:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0116  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void Footer(final com.revenuecat.purchases.ui.revenuecatui.PaywallMode r23, com.revenuecat.purchases.paywalls.PaywallData.Configuration r24, final com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration.Colors r25, final com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel r26, androidx.compose.ui.Modifier r27, kotlin.jvm.functions.Function0<kotlin.Unit> r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instruction units count: 897
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt.Footer(com.revenuecat.purchases.ui.revenuecatui.PaywallMode, com.revenuecat.purchases.paywalls.PaywallData$Configuration, com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration$Colors, com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }
}
