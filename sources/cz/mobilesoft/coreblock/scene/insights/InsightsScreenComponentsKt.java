package cz.mobilesoft.coreblock.scene.insights;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.DividerKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.material.SwitchColors;
import androidx.compose.material.TextFieldColors;
import androidx.compose.material.TextFieldDefaults;
import androidx.compose.material.TextKt;
import androidx.compose.material3.SheetState;
import androidx.compose.material3.SliderDefaults;
import androidx.compose.material3.SliderState;
import androidx.compose.material3.SnackbarHostKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TooltipState;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.TextUnitKt;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.dto.Category;
import cz.mobilesoft.coreblock.enums.AppDistractionType;
import cz.mobilesoft.coreblock.enums.Limit;
import cz.mobilesoft.coreblock.enums.MoodType;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.enums.Product;
import cz.mobilesoft.coreblock.enums.ScheduleEmoji;
import cz.mobilesoft.coreblock.scene.insights.InsightsViewEvent;
import cz.mobilesoft.coreblock.scene.insights.InsightsViewState;
import cz.mobilesoft.coreblock.scene.insights.MoodCheckInOpenTrigger;
import cz.mobilesoft.coreblock.scene.permission.PermissionActivity;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleSelectViewState;
import cz.mobilesoft.coreblock.storage.room.entity.core.MoodCheckInEntity;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.ComposableExtKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.ComparableExtKt;
import cz.mobilesoft.coreblock.util.helperextension.ModifierExtKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelper;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.CardType;
import cz.mobilesoft.coreblock.view.compose.ChipKt;
import cz.mobilesoft.coreblock.view.compose.ComposeBottomSheetsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeCardsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeCheckablesKt;
import cz.mobilesoft.coreblock.view.compose.SectionedItemKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import cz.mobilesoft.coreblock.view.graph.GraphData;
import cz.mobilesoft.statistics.model.AggregatedItemRecord;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.xn.YvFRmou;
import kotlin.enums.EnumEntries;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.xmlpull.v1.XmlPullParserException;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class InsightsScreenComponentsKt {
    /* JADX WARN: Removed duplicated region for block: B:113:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void A1(final androidx.compose.runtime.MutableState r25, java.lang.Integer r26, java.lang.String r27, final kotlin.jvm.functions.Function1 r28, final kotlin.jvm.functions.Function3 r29, final kotlin.jvm.functions.Function0 r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instruction units count: 549
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.InsightsScreenComponentsKt.A1(androidx.compose.runtime.MutableState, java.lang.Integer, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A2(InsightsViewState insightsViewState, Function1 function1, int i3, Composer composer, int i4) {
        z2(insightsViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B1(MutableState mutableState, Integer num, String str, Function1 function1, Function3 function3, Function0 function0, int i3, int i4, Composer composer, int i5) {
        A1(mutableState, num, str, function1, function3, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B2(Function1 function1, int i3, InsightsViewState.TrendInterval trendInterval) {
        Intrinsics.checkNotNullParameter(trendInterval, "trendInterval");
        function1.invoke(new InsightsViewEvent.OnTrendIntervalSelected(trendInterval));
        return Unit.f139807a;
    }

    private static final long C1(State state) {
        return ((Color) state.getValue()).B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String C2(InsightsViewState.TrendInterval SelectableChipRow, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(SelectableChipRow, "$this$SelectableChipRow");
        composer.a0(551182499);
        if (ComposerKt.M()) {
            ComposerKt.U(551182499, i3, -1, "cz.mobilesoft.coreblock.scene.insights.TrendChips.<anonymous> (InsightsScreenComponents.kt:192)");
        }
        String shortTitle = SelectableChipRow.getShortTitle();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return shortTitle;
    }

    private static final String D1(MutableState mutableState) {
        return (String) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D2(InsightsViewState insightsViewState, Function1 function1, int i3, Composer composer, int i4) {
        z2(insightsViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E1(MutableState mutableState, String str) {
        mutableState.setValue(str);
    }

    public static final void E2(final boolean z2, final long j3, final String subtitle, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Composer composerK = composer.k(-248294418);
        if ((i3 & 6) == 0) {
            i4 = (composerK.b(z2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.f(j3) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(subtitle) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        int i5 = i4;
        if (composerK.r((i5 & 147) != 146, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-248294418, i5, -1, "cz.mobilesoft.coreblock.scene.insights.TrendContent (InsightsScreenComponents.kt:403)");
            }
            Alignment.Companion companion = Alignment.f25072a;
            Alignment.Horizontal horizontalG = companion.g();
            Modifier.Companion companion2 = Modifier.b8;
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), horizontalG, composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, companion2);
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
            G2(null, z2, 0.0f, 0.0f, composerK, (i5 << 3) & 112, 13);
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.h(), companion.g(), composerK, 48);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, companion2);
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
            Updater.e(composerA2, measurePolicyA2, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            String strF = StringHelper.f((Context) composerK.q(AndroidCompositionLocals_androidKt.g()), ((long) 1000) * j3);
            TextStyle textStyleE = ComposeTypographyKt.g(composerK, 0).e();
            long jI = TextUnitKt.i(56);
            long jI2 = TextUnitKt.i(68);
            FontWeight.Companion companion4 = FontWeight.f29233b;
            TextKt.c(strF, null, ComposeColorsKt.j(composerK, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.e(textStyleE, 0L, jI, companion4.h(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, jI2, null, null, null, 0, 0, null, 16646137, null), composerK, 0, 0, 65530);
            TextKt.c(subtitle, null, ComposeColorsKt.j(composerK, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.e(ComposeTypographyKt.g(composerK, 0).h(), 0L, 0L, companion4.h(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composerK, (i5 >> 6) & 14, 0, 65530);
            composerK = composerK;
            composerK.y();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.f4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsScreenComponentsKt.F2(z2, j3, subtitle, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F1(final FocusManager focusManager, final MutableState mutableState, final MutableState mutableState2, Integer num, final MutableState mutableState3, final Function3 function3, final State state, final MutableState mutableState4, final MutableState mutableState5, ColumnScope AppBottomSheet, SheetState it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AppBottomSheet, "$this$AppBottomSheet");
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 129) != 128, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1042865069, i3, -1, "cz.mobilesoft.coreblock.scene.insights.MoodCheckInBottomSheet.<anonymous> (InsightsScreenComponents.kt:959)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierG = ModifierExtKt.g(SizeKt.b(SizeKt.h(companion, 0.0f, 1, null), 0.0f, Dp.g(240), 1, null), focusManager);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierG);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A);
            } else {
                composer.v();
            }
            Composer composerA = Updater.a(composer);
            Updater.e(composerA, measurePolicyG, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            int i4 = R.dimen.f95468b;
            Modifier modifierG2 = ScrollKt.g(SizeKt.h(PaddingKt.j(companion, PrimitiveResources_androidKt.a(R.dimen.f95467a, composer, 0), PrimitiveResources_androidKt.a(i4, composer, 0)), 0.0f, 1, null), ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null);
            Alignment.Horizontal horizontalG = companion2.g();
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), horizontalG, composer, 48);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierG2);
            Function0 function0A2 = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A2);
            } else {
                composer.v();
            }
            Composer composerA2 = Updater.a(composer);
            Updater.e(composerA2, measurePolicyA, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            float f3 = 24;
            SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer, 6);
            Modifier modifierK = PaddingKt.k(companion, PrimitiveResources_androidKt.a(i4, composer, 0), 0.0f, 2, null);
            String strB = StringResources_androidKt.b(R.string.ck, composer, 0);
            TextStyle textStyleF = ComposeTypographyKt.g(composer, 0).f();
            long jP = ComposeColorsKt.j(composer, 0).p();
            TextAlign.Companion companion4 = TextAlign.f29616b;
            TextKt.c(strB, modifierK, jP, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, textStyleF, composer, 0, 0, 65016);
            SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer, 6);
            MoodType moodType = (MoodType) mutableState.getValue();
            Alignment alignmentE = companion2.e();
            Object objG = composer.G();
            Composer.Companion companion5 = Composer.f23746a;
            if (objG == companion5.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.y1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return InsightsScreenComponentsKt.G1((AnimatedContentTransitionScope) obj);
                    }
                };
                composer.w(objG);
            }
            AnimatedContentKt.b(moodType, null, (Function1) objG, alignmentE, null, null, ComposableLambdaKt.e(-508397703, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.insights.z1
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return InsightsScreenComponentsKt.K1(state, (AnimatedContentScope) obj, (MoodType) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composer, 54), composer, 1576320, 50);
            SpacerKt.a(SizeKt.v(companion, Dp.g(16)), composer, 6);
            Object objG2 = composer.G();
            if (objG2 == companion5.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.a2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InsightsScreenComponentsKt.L1(mutableState4);
                    }
                };
                composer.w(objG2);
            }
            j2(mutableState, mutableState2, num, (Function0) objG2, composer, 3126, 0);
            float f4 = 8;
            SpacerKt.a(SizeKt.v(companion, Dp.g(f4)), composer, 6);
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.e(), companion2.i(), composer, 54);
            int iA3 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU3 = composer.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer, modifierH);
            Function0 function0A3 = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A3);
            } else {
                composer.v();
            }
            Composer composerA3 = Updater.a(composer);
            Updater.e(composerA3, measurePolicyB, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            TextKt.c(StringResources_androidKt.b(MoodType.VeryDistracted.getNameRes(), composer, 0), null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).d(), composer, 0, 0, 65530);
            TextKt.c(StringResources_androidKt.b(MoodType.InControl.getNameRes(), composer, 0), null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).d(), composer, 0, 0, 65530);
            composer.y();
            SpacerKt.a(SizeKt.v(companion, Dp.g(32)), composer, 6);
            Modifier modifierH2 = SizeKt.h(companion, 0.0f, 1, null);
            composer.a0(1988095425);
            AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
            composer.a0(1988096616);
            int iS = builder.s(new SpanStyle(ComposeColorsKt.j(composer, 0).q(), ComposeTypographyKt.g(composer, 0).a().n(), FontWeight.f29233b.h(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65528, (DefaultConstructorMarker) null));
            try {
                builder.l(StringResources_androidKt.b(R.string.R, composer, 0));
                builder.l(" ");
                Unit unit = Unit.f139807a;
                builder.q(iS);
                composer.U();
                composer.a0(1988117029);
                iS = builder.s(new SpanStyle(ComposeColorsKt.j(composer, 0).q(), ComposeTypographyKt.g(composer, 0).d().n(), ComposeTypographyKt.g(composer, 0).d().q(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65528, (DefaultConstructorMarker) null));
                try {
                    builder.l(StringResources_androidKt.b(R.string.Um, composer, 0));
                    builder.q(iS);
                    composer.U();
                    AnnotatedString annotatedStringT = builder.t();
                    composer.U();
                    TextKt.d(annotatedStringT, modifierH2, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.f()), 0L, 0, false, 0, 0, null, null, null, composer, 48, 0, 261624);
                    SpacerKt.a(SizeKt.v(companion, Dp.g(f4)), composer, 6);
                    MeasurePolicy measurePolicyG2 = BoxKt.g(companion2.o(), false);
                    int iA4 = ComposablesKt.a(composer, 0);
                    CompositionLocalMap compositionLocalMapU4 = composer.u();
                    Modifier modifierF4 = ComposedModifierKt.f(composer, companion);
                    Function0 function0A4 = companion3.a();
                    if (composer.m() == null) {
                        ComposablesKt.c();
                    }
                    composer.L();
                    if (composer.i()) {
                        composer.P(function0A4);
                    } else {
                        composer.v();
                    }
                    Composer composerA4 = Updater.a(composer);
                    Updater.e(composerA4, measurePolicyG2, companion3.e());
                    Updater.e(composerA4, compositionLocalMapU4, companion3.g());
                    Function2 function2B4 = companion3.b();
                    if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                        composerA4.w(Integer.valueOf(iA4));
                        composerA4.p(Integer.valueOf(iA4), function2B4);
                    }
                    Updater.e(composerA4, modifierF4, companion3.f());
                    String strD1 = D1(mutableState5);
                    Modifier modifierH3 = SizeKt.h(companion, 0.0f, 1, null);
                    RoundedCornerShape roundedCornerShapeD = RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(R.dimen.f95480n, composer, 0));
                    TextFieldColors textFieldColorsO = TextFieldDefaults.f14636a.o(ComposeColorsKt.j(composer, 0).p(), 0L, ComposeColorsKt.j(composer, 0).v(), 0L, 0L, ComposeColorsKt.j(composer, 0).b(), Color.f25715b.j(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer, 1572864, 0, 48, 2097050);
                    TextStyle textStyleA = ComposeTypographyKt.g(composer, 0).a();
                    KeyboardOptions keyboardOptions = new KeyboardOptions(KeyboardCapitalization.f29372b.c(), null, 0, 0, null, null, null, 126, null);
                    Object objG3 = composer.G();
                    if (objG3 == companion5.a()) {
                        objG3 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.b2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return InsightsScreenComponentsKt.M1(mutableState5, (String) obj);
                            }
                        };
                        composer.w(objG3);
                    }
                    OutlinedTextFieldKt.c(strD1, (Function1) objG3, modifierH3, false, false, textStyleA, null, ComposableSingletons$InsightsScreenComponentsKt.f102566a.p(), null, null, false, null, keyboardOptions, null, false, 3, 3, null, roundedCornerShapeD, textFieldColorsO, composer, 12583344, 1769856, 159576);
                    composer.y();
                    SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer, 6);
                    String strB2 = StringResources_androidKt.b(R.string.ik, composer, 0);
                    boolean zI = composer.I(focusManager) | composer.Z(mutableState3) | composer.Z(function3);
                    Object objG4 = composer.G();
                    if (zI || objG4 == companion5.a()) {
                        Function0 function0 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.c2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return InsightsScreenComponentsKt.N1(focusManager, mutableState3, function3, mutableState, mutableState2, mutableState4, mutableState5);
                            }
                        };
                        composer.w(function0);
                        objG4 = function0;
                    }
                    ComposeButtonsKt.J(null, strB2, false, false, null, (Function0) objG4, composer, 3072, 21);
                    composer.y();
                    composer.y();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                } finally {
                }
            } finally {
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F2(boolean z2, long j3, String str, int i3, Composer composer, int i4) {
        E2(z2, j3, str, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContentTransform G1(AnimatedContentTransitionScope AnimatedContent) {
        Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
        return AnimatedContent.b(AnimatedContentKt.f(EnterExitTransitionKt.E(AnimationSpecKt.n(200, 0, null, 6, null), new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.v2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(InsightsScreenComponentsKt.H1(((Integer) obj).intValue()));
            }
        }).c(EnterExitTransitionKt.o(AnimationSpecKt.n(200, 0, null, 6, null), 0.0f, 2, null)), EnterExitTransitionKt.J(AnimationSpecKt.n(200, 0, null, 6, null), new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.w2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(InsightsScreenComponentsKt.I1(((Integer) obj).intValue()));
            }
        }).c(EnterExitTransitionKt.q(AnimationSpecKt.n(200, 0, null, 6, null), 0.0f, 2, null))), AnimatedContentKt.c(false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.x2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return InsightsScreenComponentsKt.J1((IntSize) obj, (IntSize) obj2);
            }
        }));
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void G2(androidx.compose.ui.Modifier r16, final boolean r17, float r18, float r19, androidx.compose.runtime.Composer r20, final int r21, final int r22) {
        /*
            Method dump skipped, instruction units count: 462
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.InsightsScreenComponentsKt.G2(androidx.compose.ui.Modifier, boolean, float, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int H1(int i3) {
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H2(Modifier modifier, boolean z2, float f3, float f4, int i3, int i4, Composer composer, int i5) {
        G2(modifier, z2, f3, f4, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int I1(int i3) {
        return -i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec J1(IntSize intSize, IntSize intSize2) {
        return AnimationSpecKt.n(200, 0, null, 6, null);
    }

    public static final void K0(final boolean z2, final boolean z3, final List schedules, final MutableState showAddToBlockingBottomSheet, final SnackbarHostState snackbarHostState, final Function1 onScheduleClicked, final Function0 onNewScheduleClicked, final Function0 onSelectionConfirmed, final Function0 onDismiss, final Function1 onAppsLimitPremiumBadgeClicked, final Function0 onLockedScheduleClicked, Composer composer, final int i3, final int i4) {
        boolean z4;
        int i5;
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(schedules, "schedules");
        Intrinsics.checkNotNullParameter(showAddToBlockingBottomSheet, "showAddToBlockingBottomSheet");
        Intrinsics.checkNotNullParameter(snackbarHostState, "snackbarHostState");
        Intrinsics.checkNotNullParameter(onScheduleClicked, "onScheduleClicked");
        Intrinsics.checkNotNullParameter(onNewScheduleClicked, "onNewScheduleClicked");
        Intrinsics.checkNotNullParameter(onSelectionConfirmed, "onSelectionConfirmed");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Intrinsics.checkNotNullParameter(onAppsLimitPremiumBadgeClicked, "onAppsLimitPremiumBadgeClicked");
        Intrinsics.checkNotNullParameter(onLockedScheduleClicked, "onLockedScheduleClicked");
        Composer composerK = composer.k(2033560273);
        if ((i3 & 6) == 0) {
            z4 = z2;
            i5 = (composerK.b(z4) ? 4 : 2) | i3;
        } else {
            z4 = z2;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.b(z3) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.I(schedules) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerK.Z(showAddToBlockingBottomSheet) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i5 |= composerK.Z(snackbarHostState) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i5 |= composerK.I(onScheduleClicked) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i5 |= composerK.I(onNewScheduleClicked) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i5 |= composerK.I(onSelectionConfirmed) ? 8388608 : 4194304;
        }
        if ((100663296 & i3) == 0) {
            i5 |= composerK.I(onDismiss) ? 67108864 : 33554432;
        }
        if ((805306368 & i3) == 0) {
            i5 |= composerK.I(onAppsLimitPremiumBadgeClicked) ? 536870912 : 268435456;
        }
        if ((i4 & 6) == 0) {
            i6 = i4 | (composerK.I(onLockedScheduleClicked) ? 4 : 2);
        } else {
            i6 = i4;
        }
        if (composerK.r(((i5 & 306783379) == 306783378 && (i6 & 3) == 2) ? false : true, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2033560273, i5, i6, "cz.mobilesoft.coreblock.scene.insights.AddToBlockingBottomSheet (InsightsScreenComponents.kt:1147)");
            }
            final boolean z5 = z4;
            ComposableLambda composableLambdaE = ComposableLambdaKt.e(614533042, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.insights.i1
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return InsightsScreenComponentsKt.L0(snackbarHostState, z5, z3, schedules, onScheduleClicked, onNewScheduleClicked, onAppsLimitPremiumBadgeClicked, onLockedScheduleClicked, onSelectionConfirmed, (ColumnScope) obj, (SheetState) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerK, 54);
            boolean z6 = ((234881024 & i5) == 67108864) | ((i5 & 7168) == 2048);
            Object objG = composerK.G();
            if (z6 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.t1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InsightsScreenComponentsKt.N0(onDismiss, showAddToBlockingBottomSheet);
                    }
                };
                composerK.w(objG);
            }
            composer2 = composerK;
            ComposeBottomSheetsKt.f(null, null, true, composableLambdaE, null, (Function0) objG, composer2, 3456, 19);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.e2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsScreenComponentsKt.O0(z2, z3, schedules, showAddToBlockingBottomSheet, snackbarHostState, onScheduleClicked, onNewScheduleClicked, onSelectionConfirmed, onDismiss, onAppsLimitPremiumBadgeClicked, onLockedScheduleClicked, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K1(State state, AnimatedContentScope AnimatedContent, MoodType moodCheckValue, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
        Intrinsics.checkNotNullParameter(moodCheckValue, "moodCheckValue");
        if (ComposerKt.M()) {
            ComposerKt.U(-508397703, i3, -1, "cz.mobilesoft.coreblock.scene.insights.MoodCheckInBottomSheet.<anonymous>.<anonymous>.<anonymous>.<anonymous> (InsightsScreenComponents.kt:1003)");
        }
        TextKt.c(StringResources_androidKt.b(moodCheckValue.getNameRes(), composer, 0), null, C1(state), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).g(), composer, 0, 0, 65018);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L0(SnackbarHostState snackbarHostState, boolean z2, boolean z3, List list, Function1 function1, Function0 function0, Function1 function12, Function0 function02, final Function0 function03, ColumnScope AppBottomSheet, SheetState it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AppBottomSheet, "$this$AppBottomSheet");
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 129) != 128, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(614533042, i3, -1, "cz.mobilesoft.coreblock.scene.insights.AddToBlockingBottomSheet.<anonymous> (InsightsScreenComponents.kt:1151)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierB = SizeKt.b(SizeKt.h(companion, 0.0f, 1, null), 0.0f, Dp.g(240), 1, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierB);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A);
            } else {
                composer.v();
            }
            Composer composerA = Updater.a(composer);
            Updater.e(composerA, measurePolicyG, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Modifier modifierG = ScrollKt.g(SizeKt.h(PaddingKt.k(companion, 0.0f, Dp.g(8), 1, null), 0.0f, 1, null), ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), companion2.k(), composer, 0);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierG);
            Function0 function0A2 = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A2);
            } else {
                composer.v();
            }
            Composer composerA2 = Updater.a(composer);
            Updater.e(composerA2, measurePolicyA, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            Z1(z2, z3, list, function1, function0, function12, function02, composer, 0);
            SpacerKt.a(SizeKt.i(companion, Dp.g(42)), composer, 6);
            String strB = StringResources_androidKt.b(R.string.Lt, composer, 0);
            boolean Z = composer.Z(function03);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.f2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InsightsScreenComponentsKt.M0(function03);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.J(null, strB, false, false, null, (Function0) objG, composer, 0, 29);
            composer.y();
            SnackbarHostKt.b(snackbarHostState, PaddingKt.m(boxScopeInstance.f(companion, companion2.b()), 0.0f, 0.0f, 0.0f, Dp.g(16), 7, null), null, composer, 0, 4);
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L1(MutableState mutableState) {
        mutableState.setValue(Boolean.TRUE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M0(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M1(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        E1(mutableState, it);
        return Unit.f139807a;
    }

    public static final void M2(LazyListScope lazyListScope, final InsightsViewState viewState, final Function1 onEvent, final MutableState showAddToBlockingBottomSheet) {
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(showAddToBlockingBottomSheet, "showAddToBlockingBottomSheet");
        LazyListScope.c(lazyListScope, null, null, ComposableSingletons$InsightsScreenComponentsKt.f102566a.o(), 3, null);
        LazyListScope.c(lazyListScope, null, null, ComposableLambdaKt.c(-1914064942, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.k2
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return InsightsScreenComponentsKt.N2(viewState, onEvent, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.c(lazyListScope, null, null, ComposableLambdaKt.c(1496166547, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.l2
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return InsightsScreenComponentsKt.P2(viewState, onEvent, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.c(lazyListScope, null, null, ComposableLambdaKt.c(611430740, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.m2
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return InsightsScreenComponentsKt.U2(viewState, showAddToBlockingBottomSheet, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N0(Function0 function0, MutableState mutableState) {
        function0.invoke();
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N1(FocusManager focusManager, MutableState mutableState, Function3 function3, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5) {
        FocusManager.m(focusManager, false, 1, null);
        mutableState.setValue(MoodCheckInOpenTrigger.Closed.f102954a);
        function3.invoke(mutableState2.getValue(), mutableState3.getValue(), D1(mutableState5));
        if (D1(mutableState5).length() != 0 || ((Boolean) mutableState4.getValue()).booleanValue()) {
            AnswersHelper.f128199a.B1();
        } else {
            AnswersHelper.f128199a.A1();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N2(InsightsViewState insightsViewState, final Function1 function1, LazyItemScope item, Composer composer, int i3) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1914064942, i3, -1, "cz.mobilesoft.coreblock.scene.insights.detailContent.<anonymous> (InsightsScreenComponents.kt:712)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 8;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            Modifier modifierH = SizeKt.h(PaddingKt.k(companion, Dp.g(f3), 0.0f, 2, null), 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.e(), Alignment.f25072a.l(), composer, 6);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierH);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A);
            } else {
                composer.v();
            }
            Composer composerA = Updater.a(composer);
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            composer.a0(-1642236344);
            Iterator<AppDistractionType> it = AppDistractionType.getEntries().iterator();
            while (it.hasNext()) {
                final AppDistractionType next = it.next();
                AppDistractionType appDistractionTypeU = insightsViewState.U();
                boolean z2 = appDistractionTypeU == null ? next == AppDistractionType.Neutral : appDistractionTypeU == next;
                boolean Z = composer.Z(function1) | composer.e(next.ordinal());
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.k3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return InsightsScreenComponentsKt.O2(function1, next);
                        }
                    };
                    composer.w(objG);
                }
                P0(rowScopeInstance, z2, next, (Function0) objG, composer, 6);
            }
            composer.U();
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O0(boolean z2, boolean z3, List list, MutableState mutableState, SnackbarHostState snackbarHostState, Function1 function1, Function0 function0, Function0 function02, Function0 function03, Function1 function12, Function0 function04, int i3, int i4, Composer composer, int i5) {
        K0(z2, z3, list, mutableState, snackbarHostState, function1, function0, function02, function03, function12, function04, composer, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O1(Function0 function0, MutableState mutableState) {
        function0.invoke();
        mutableState.setValue(MoodCheckInOpenTrigger.Closed.f102954a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O2(Function1 function1, AppDistractionType appDistractionType) {
        function1.invoke(new InsightsViewEvent.OnAppTypeUpdated(appDistractionType));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9, types: [boolean, int] */
    public static final void P0(final RowScope rowScope, final boolean z2, final AppDistractionType appDistractionType, final Function0 function0, Composer composer, final int i3) throws XmlPullParserException, IOException {
        int i4;
        long jE;
        ?? r9;
        long jF;
        int i5;
        long jP;
        long jP2;
        Composer composerK = composer.k(579040577);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(rowScope) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.e(appDistractionType.ordinal()) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function0) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(579040577, i4, -1, "cz.mobilesoft.coreblock.scene.insights.AppTypeButton (InsightsScreenComponents.kt:796)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 8;
            Modifier modifierA = ClipKt.a(RowScope.c(rowScope, SizeKt.B(PaddingKt.i(companion, Dp.g(f3)), Dp.g(64), Dp.g(120)), 1.0f, false, 2, null), RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(R.dimen.f95480n, composerK, 0)));
            if (z2) {
                composerK.a0(-1887737402);
                composerK.U();
                jE = appDistractionType.m1357getColor0d7_KjU();
            } else {
                composerK.a0(-1887736800);
                jE = ComposeColorsKt.j(composerK, 0).E();
                composerK.U();
            }
            Modifier modifierD = BackgroundKt.d(modifierA, jE, null, 2, null);
            boolean z3 = (i4 & 7168) == 2048;
            Object objG = composerK.G();
            if (z3 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.j4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InsightsScreenComponentsKt.Q0(function0);
                    }
                };
                composerK.w(objG);
            }
            Modifier modifierF = ClickableKt.f(modifierD, false, null, null, (Function0) objG, 7, null);
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
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Modifier modifierF3 = boxScopeInstance.f(PaddingKt.k(SizeKt.f(companion, 0.0f, 1, null), 0.0f, Dp.g(16), 1, null), companion2.m());
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.e(), companion2.g(), composerK, 54);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF4 = ComposedModifierKt.f(composerK, modifierF3);
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
            Updater.e(composerA2, modifierF4, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            Modifier modifierV = SizeKt.v(companion, Dp.g(48));
            if (z2) {
                composerK.a0(-494272886);
                r9 = 0;
                jF = ComposeColorsKt.j(composerK, 0).q0();
            } else {
                r9 = 0;
                composerK.a0(-494272280);
                jF = ComposeColorsKt.j(composerK, 0).F();
            }
            composerK.U();
            Modifier modifierC = BackgroundKt.c(modifierV, jF, RoundedCornerShapeKt.g());
            MeasurePolicy measurePolicyG2 = BoxKt.g(companion2.o(), r9);
            int iA3 = ComposablesKt.a(composerK, r9);
            CompositionLocalMap compositionLocalMapU3 = composerK.u();
            Modifier modifierF5 = ComposedModifierKt.f(composerK, modifierC);
            Function0 function0A3 = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A3);
            } else {
                composerK.v();
            }
            Composer composerA3 = Updater.a(composerK);
            Updater.e(composerA3, measurePolicyG2, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF5, companion3.f());
            Modifier modifierF6 = boxScopeInstance.f(companion, companion2.e());
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, appDistractionType.getIconRes(), composerK, 6);
            if (z2) {
                composerK.a0(1816002020);
                composerK.U();
                jP = appDistractionType.m1357getColor0d7_KjU();
                i5 = 0;
            } else {
                composerK.a0(1816002603);
                i5 = 0;
                jP = ComposeColorsKt.j(composerK, 0).p();
                composerK.U();
            }
            int i6 = i5;
            IconKt.b(imageVectorB, null, modifierF6, jP, composerK, 48, 0);
            composerK.y();
            Modifier modifierM = PaddingKt.m(companion, 0.0f, Dp.g(f3), 0.0f, 0.0f, 13, null);
            String strB = StringResources_androidKt.b(appDistractionType.getNameRes(), composerK, i6);
            TextStyle textStyleD = ComposeTypographyKt.g(composerK, i6).d();
            int iA4 = TextAlign.f29616b.a();
            if (z2) {
                composerK.a0(-494245526);
                jP2 = ComposeColorsKt.j(composerK, i6).q0();
            } else {
                composerK.a0(-494244943);
                jP2 = ComposeColorsKt.j(composerK, i6).p();
            }
            composerK.U();
            TextKt.c(strB, modifierM, jP2, 0L, null, null, null, 0L, null, TextAlign.h(iA4), 0L, 0, false, 0, 0, null, textStyleD, composerK, 48, 0, 65016);
            composerK = composerK;
            composerK.y();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.k4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsScreenComponentsKt.R0(rowScope, z2, appDistractionType, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void P1(final PaddingValues paddingValues, final InsightsViewState viewState, final Function1 onEvent, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(-1506957587);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(paddingValues) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(viewState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onEvent) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1506957587, i4, -1, "cz.mobilesoft.coreblock.scene.insights.PermissionsContent (InsightsScreenComponents.kt:518)");
            }
            final ManagedActivityResultLauncher managedActivityResultLauncherX2 = X2(onEvent, composerK, (i4 >> 6) & 14);
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierG = ScrollKt.g(SizeKt.f(PaddingKt.h(WindowInsetsPaddingKt.d(companion, WindowInsets_androidKt.e(WindowInsets.f7172a, composerK, 6)), paddingValues), 0.0f, 1, null), ScrollKt.c(0, composerK, 0, 1), false, null, false, 14, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.g(), composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierG);
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
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            int i5 = i4;
            ImageKt.a(PainterResources_androidKt.c(R.drawable.N7, composerK, 0), null, PaddingKt.m(companion, 0.0f, Dp.g(32), 0.0f, 0.0f, 13, null), null, null, 0.0f, null, composerK, 432, 120);
            String strB = StringResources_androidKt.b(R.string.ah, composerK, 0);
            TextStyle textStyleH = ComposeTypographyKt.g(composerK, 0).h();
            TextAlign.Companion companion3 = TextAlign.f29616b;
            TextKt.c(strB, SizeKt.g(PaddingKt.m(companion, 0.0f, Dp.g(8), 0.0f, 0.0f, 13, null), 0.7f), 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion3.a()), 0L, 0, false, 0, 0, null, textStyleH, composerK, 48, 0, 65020);
            TextKt.c(StringResources_androidKt.b(R.string.Zg, composerK, 0), SizeKt.g(PaddingKt.m(companion, 0.0f, Dp.g(16), 0.0f, 0.0f, 13, null), 0.8f), ComposeColorsKt.j(composerK, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(companion3.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).b(), composerK, 48, 0, 65016);
            composerK = composerK;
            Modifier modifierM = PaddingKt.m(companion, 0.0f, Dp.g(24), 0.0f, 0.0f, 13, null);
            ButtonType.SmallRound smallRound = new ButtonType.SmallRound(null, null, StringResources_androidKt.b(R.string.l8, composerK, 0), null, false, 27, null);
            ButtonColor.Accent accent = new ButtonColor.Accent(false, null, false, null, 15, null);
            boolean zI = composerK.I(context) | ((i5 & 112) == 32) | composerK.I(managedActivityResultLauncherX2);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.o4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InsightsScreenComponentsKt.Q1(context, viewState, managedActivityResultLauncherX2);
                    }
                };
                composerK.w(objG);
            }
            ComposeButtonsKt.i0(modifierM, smallRound, accent, (Function0) objG, composerK, 6, 0);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.p4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsScreenComponentsKt.R1(paddingValues, viewState, onEvent, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P2(final InsightsViewState insightsViewState, final Function1 function1, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1496166547, i3, -1, "cz.mobilesoft.coreblock.scene.insights.detailContent.<anonymous> (InsightsScreenComponents.kt:735)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            DividerKt.a(PaddingKt.k(companion, Dp.g(f3), 0.0f, 2, null), 0L, 0.0f, 0.0f, composer, 6, 14);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            boolean zB = composer.b(insightsViewState.s0());
            Object objG = composer.G();
            if (zB || objG == Composer.f23746a.a()) {
                objG = SnapshotStateKt.e(new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.i3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(InsightsScreenComponentsKt.Q2(insightsViewState));
                    }
                });
                composer.w(objG);
            }
            final State state = (State) objG;
            ComposeCardsKt.m(PaddingKt.i(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3)), new CardType.Surface(null, null, null, 7, null), null, ComposableLambdaKt.e(-1556738034, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.j3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsScreenComponentsKt.R2(insightsViewState, state, function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 3462, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q0(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q1(Context context, InsightsViewState insightsViewState, ManagedActivityResultLauncher managedActivityResultLauncher) {
        managedActivityResultLauncher.b(PermissionActivity.Companion.b(PermissionActivity.f111772j, context, insightsViewState.O(), true, false, false, null, null, 112, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Q2(InsightsViewState insightsViewState) {
        return insightsViewState.s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R0(RowScope rowScope, boolean z2, AppDistractionType appDistractionType, Function0 function0, int i3, Composer composer, int i4) throws XmlPullParserException, IOException {
        P0(rowScope, z2, appDistractionType, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R1(PaddingValues paddingValues, InsightsViewState insightsViewState, Function1 function1, int i3, Composer composer, int i4) {
        P1(paddingValues, insightsViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R2(InsightsViewState insightsViewState, State state, final Function1 function1, Composer composer, int i3) throws XmlPullParserException, IOException {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1556738034, i3, -1, "cz.mobilesoft.coreblock.scene.insights.detailContent.<anonymous>.<anonymous> (InsightsScreenComponents.kt:755)");
            }
            String strB = StringResources_androidKt.b(R.string.Vd, composer, 0);
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.f95536l2, composer, 6);
            float fG = Dp.g(24);
            float fG2 = Dp.g(12);
            long jK = Color.f25715b.k();
            String strB2 = StringResources_androidKt.b(R.string.V0, composer, 0);
            Modifier modifierH = SizeKt.h(Modifier.b8, 0.0f, 1, null);
            PaddingValues paddingValuesA = PaddingKt.a(Dp.g(16));
            TextStyle textStyleI = ComposeTypographyKt.g(composer, 0).i();
            TextStyle textStyleD = ComposeTypographyKt.g(composer, 0).d();
            boolean z2 = !insightsViewState.v0();
            SwitchColors switchColorsN = ComposeColorsKt.n(composer, 0);
            Dp dpD = Dp.d(fG);
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.o3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return InsightsScreenComponentsKt.S2(function1, ((Boolean) obj).booleanValue());
                    }
                };
                composer.w(objG);
            }
            Function1 function12 = (Function1) objG;
            boolean Z2 = composer.Z(function1);
            Object objG2 = composer.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.p3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InsightsScreenComponentsKt.T2(function1);
                    }
                };
                composer.w(objG2);
            }
            ComposeCheckablesKt.l(modifierH, state, false, strB, strB2, paddingValuesA, fG2, imageVectorB, dpD, jK, false, textStyleI, textStyleD, false, true, z2, switchColorsN, function12, (Function0) objG2, composer, 907739142, 24576, 9220);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void S0(final androidx.compose.ui.graphics.vector.ImageVector r24, boolean r25, final kotlin.jvm.functions.Function0 r26, androidx.compose.runtime.Composer r27, final int r28, final int r29) {
        /*
            Method dump skipped, instruction units count: 383
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.InsightsScreenComponentsKt.S0(androidx.compose.ui.graphics.vector.ImageVector, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void S1(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(-1415798784);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.Z(paddingValues) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1415798784, i4, -1, "cz.mobilesoft.coreblock.scene.insights.PremiumBox (InsightsScreenComponents.kt:1340)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierF = SizeKt.f(PaddingKt.h(companion, paddingValues), 0.0f, 1, null);
            Object objG = composerK.G();
            Composer.Companion companion2 = Composer.f23746a;
            if (objG == companion2.a()) {
                objG = InteractionSourceKt.a();
                composerK.w(objG);
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objG;
            Object objG2 = composerK.G();
            if (objG2 == companion2.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.q1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InsightsScreenComponentsKt.T1();
                    }
                };
                composerK.w(objG2);
            }
            Modifier modifierD = ClickableKt.d(modifierF, mutableInteractionSource, null, false, null, null, (Function0) objG2, 28, null);
            Alignment.Companion companion3 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion3.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierD);
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
            Updater.e(composerA, measurePolicyG, companion4.e());
            Updater.e(composerA, compositionLocalMapU, companion4.g());
            Function2 function2B = companion4.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF2, companion4.f());
            float f3 = 16;
            float f4 = 24;
            Modifier modifierI = PaddingKt.i(BackgroundKt.c(SizeKt.h(PaddingKt.m(PaddingKt.k(BoxScopeInstance.f6642a.f(companion, companion3.b()), Dp.g(f3), 0.0f, 2, null), 0.0f, 0.0f, 0.0f, Dp.g(f4), 7, null), 0.0f, 1, null), ComposeColorsKt.j(composerK, 0).l0(), RoundedCornerShapeKt.d(Dp.g(f3))), Dp.g(f4));
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.o(Dp.g(12)), companion3.g(), composerK, 54);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierI);
            Function0 function0A2 = companion4.a();
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
            Updater.e(composerA2, measurePolicyA, companion4.e());
            Updater.e(composerA2, compositionLocalMapU2, companion4.g());
            Function2 function2B2 = companion4.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF3, companion4.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            String strB = StringResources_androidKt.b(R.string.ch, composerK, 0);
            TextStyle textStyleG = ComposeTypographyKt.g(composerK, 0).g();
            long jP = ComposeColorsKt.j(composerK, 0).p();
            TextAlign.Companion companion5 = TextAlign.f29616b;
            TextKt.c(strB, modifierH, jP, 0L, null, null, null, 0L, null, TextAlign.h(companion5.a()), 0L, 0, false, 0, 0, null, textStyleG, composerK, 48, 0, 65016);
            TextKt.c(StringResources_androidKt.b(R.string.bh, composerK, 0), SizeKt.h(companion, 0.0f, 1, null), ComposeColorsKt.j(composerK, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(companion5.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).b(), composerK, 48, 0, 65016);
            ButtonType.SmallRound smallRound = new ButtonType.SmallRound(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.s4, composerK, 6), Color.n(ComposeColorsKt.j(composerK, 0).q0()), StringResources_androidKt.b(R.string.bC, composerK, 0), null, false, 24, null);
            ButtonColor.Premium premium = new ButtonColor.Premium(false, null, false, null, 15, null);
            boolean zI = composerK.I(context);
            Object objG3 = composerK.G();
            if (zI || objG3 == companion2.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.r1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InsightsScreenComponentsKt.U1(context);
                    }
                };
                composerK.w(objG3);
            }
            ComposeButtonsKt.i0(null, smallRound, premium, (Function0) objG3, composerK, 0, 1);
            composer2 = composerK;
            composer2.y();
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.s1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsScreenComponentsKt.V1(paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S2(Function1 function1, boolean z2) {
        function1.invoke(new InsightsViewEvent.OnItemExcludedFromReports(z2));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T0(ImageVector imageVector, boolean z2, Function0 function0, int i3, int i4, Composer composer, int i5) {
        S0(imageVector, z2, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T1() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T2(Function1 function1) {
        function1.invoke(InsightsViewEvent.OnExcludePremiumCardClicked.f102679a);
        return Unit.f139807a;
    }

    private static final void U0(final Category category, final String str, final Function1 function1, final boolean z2, Composer composer, final int i3) {
        int i4;
        final Category category2;
        Composer composerK = composer.k(-1598474571);
        if ((i3 & 6) == 0) {
            i4 = (composerK.e(category.ordinal()) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(str) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function1) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.b(z2) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1598474571, i4, -1, "cz.mobilesoft.coreblock.scene.insights.CategoryChip (InsightsScreenComponents.kt:877)");
            }
            final long jB = ComposeColorsKt.j(composerK, 0).b();
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierA = ClipKt.a(companion, RoundedCornerShapeKt.a(50));
            boolean z3 = ((i4 & 896) == 256) | ((i4 & 14) == 4);
            Object objG = composerK.G();
            if (z3 || objG == Composer.f23746a.a()) {
                category2 = category;
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.q3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InsightsScreenComponentsKt.V0(function1, category2);
                    }
                };
                composerK.w(objG);
            } else {
                category2 = category;
            }
            Modifier modifierI = SizeKt.i(BackgroundKt.d(ClickableKt.f(modifierA, false, null, null, (Function0) objG, 7, null), ComposeColorsKt.j(composerK, 0).X(), null, 2, null), Dp.g(40));
            boolean zF = composerK.f(jB);
            Object objG2 = composerK.G();
            if (zF || objG2 == Composer.f23746a.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.r3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return InsightsScreenComponentsKt.W0(jB, (Modifier) obj);
                    }
                };
                composerK.w(objG2);
            }
            Modifier modifierK = PaddingKt.k(ComposableExtKt.r(modifierI, z2, (Function1) objG2), Dp.g(12), 0.0f, 2, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.i(), composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierK);
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            float f3 = 6;
            IconKt.a(PainterResources_androidKt.c(category2.getIconRes(), composerK, 0), null, SizeKt.v(PaddingKt.i(BackgroundKt.c(companion, ComposeColorsKt.j(composerK, 0).i(), RoundedCornerShapeKt.d(Dp.g(f3))), Dp.g(3)), Dp.g(24)), Color.f25715b.k(), composerK, 3120, 0);
            SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composerK, 6);
            TextKt.c(str, null, ComposeColorsKt.j(composerK, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).d(), composerK, (i4 >> 3) & 14, 0, 65530);
            composerK = composerK;
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.s3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsScreenComponentsKt.X0(category, str, function1, z2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U1(Context context) {
        context.startActivity(Paywall.c(Paywall.f113165a, context, new PaywallTarget.LimitScreen(PremiumFeature.STATISTICS), "statistics_tab", "statistics_usage", false, false, false, null, 240, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U2(InsightsViewState insightsViewState, final MutableState mutableState, LazyItemScope item, Composer composer, int i3) {
        Composer composer2;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(611430740, i3, -1, "cz.mobilesoft.coreblock.scene.insights.detailContent.<anonymous> (InsightsScreenComponents.kt:781)");
            }
            if (!insightsViewState.p0() || insightsViewState.f0()) {
                composer2 = composer;
                composer2.a0(148390702);
            } else {
                composer.a0(176941485);
                String strB = StringResources_androidKt.b(R.string.S, composer, 0);
                boolean Z = composer.Z(mutableState);
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.m3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return InsightsScreenComponentsKt.V2(mutableState);
                        }
                    };
                    composer.w(objG);
                }
                composer2 = composer;
                ComposeButtonsKt.J(null, strB, false, false, null, (Function0) objG, composer2, 0, 29);
            }
            composer2.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V0(Function1 function1, Category category) {
        function1.invoke(category);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V1(PaddingValues paddingValues, int i3, Composer composer, int i4) {
        S1(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V2(MutableState mutableState) {
        mutableState.setValue(Boolean.TRUE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier W0(long j3, Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return BorderKt.f(applyIf, Dp.g(2), j3, RoundedCornerShapeKt.a(50));
    }

    public static final void W1(Composer composer, final int i3) throws XmlPullParserException, IOException {
        Composer composer2;
        Composer composerK = composer.k(2114682494);
        if (composerK.r(i3 != 0, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2114682494, i3, -1, "cz.mobilesoft.coreblock.scene.insights.PremiumCard (InsightsScreenComponents.kt:1410)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            float f3 = 16;
            Modifier modifierH = SizeKt.h(PaddingKt.m(PaddingKt.k(Modifier.b8, Dp.g(f3), 0.0f, 2, null), 0.0f, 0.0f, 0.0f, Dp.g(8), 7, null), 0.0f, 1, null);
            String strB = StringResources_androidKt.b(R.string.Pg, composerK, 0);
            long jQ = ComposeColorsKt.j(composerK, 0).q();
            PremiumFeature premiumFeature = PremiumFeature.STATISTICS;
            PaddingValues paddingValuesC = PaddingKt.c(Dp.g(f3), 0.0f, 2, null);
            boolean zI = composerK.I(context);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.u1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InsightsScreenComponentsKt.X1(context);
                    }
                };
                composerK.w(objG);
            }
            composer2 = composerK;
            ComposeCardsKt.s(modifierH, premiumFeature, false, null, 0L, jQ, false, false, false, null, strB, null, false, paddingValuesC, false, (Function0) objG, composer2, 54, 3456, 19420);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.v1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsScreenComponentsKt.Y1(i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void W2(LazyListScope lazyListScope) {
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        LazyListScope.c(lazyListScope, null, null, ComposableSingletons$InsightsScreenComponentsKt.f102566a.m(), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X0(Category category, String str, Function1 function1, boolean z2, int i3, Composer composer, int i4) {
        U0(category, str, function1, z2, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X1(Context context) {
        context.startActivity(Paywall.c(Paywall.f113165a, context, new PaywallTarget.LimitScreen(PremiumFeature.STATISTICS), "statistics_tab", "statistics_usage", false, false, false, null, 240, null));
        return Unit.f139807a;
    }

    public static final ManagedActivityResultLauncher X2(final Function1 onEvent, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        if (ComposerKt.M()) {
            ComposerKt.U(267230765, i3, -1, "cz.mobilesoft.coreblock.scene.insights.getStatisticsPermissionLauncher (InsightsScreenComponents.kt:149)");
        }
        ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
        boolean z2 = (((i3 & 14) ^ 6) > 4 && composer.Z(onEvent)) || (i3 & 6) == 4;
        Object objG = composer.G();
        if (z2 || objG == Composer.f23746a.a()) {
            objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.d4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return InsightsScreenComponentsKt.Y2(onEvent, (ActivityResult) obj);
                }
            };
            composer.w(objG);
        }
        ManagedActivityResultLauncher managedActivityResultLauncherA = ActivityResultRegistryKt.a(startActivityForResult, (Function1) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return managedActivityResultLauncherA;
    }

    private static final void Y0(InsightsViewState insightsViewState, Function1 function1, Composer composer, final int i3) {
        final InsightsViewState insightsViewState2;
        final Function1 function12;
        Composer composer2;
        InsightsViewState insightsViewState3 = insightsViewState;
        Composer composerK = composer.k(-963815703);
        int i4 = (i3 & 6) == 0 ? (composerK.Z(insightsViewState3) ? 4 : 2) | i3 : i3;
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        int i5 = i4;
        if (composerK.r((i5 & 19) != 18, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-963815703, i5, -1, "cz.mobilesoft.coreblock.scene.insights.CategoryRow (InsightsScreenComponents.kt:850)");
            }
            Modifier modifierB = ScrollKt.b(SizeKt.h(PaddingKt.k(Modifier.b8, Dp.g(16), 0.0f, 2, null), 0.0f, 1, null), ScrollKt.c(0, composerK, 0, 1), false, null, false, 14, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.o(Dp.g(6)), Alignment.f25072a.i(), composerK, 54);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierB);
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
            Updater.e(composerA, measurePolicyB, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            composerK.a0(-492606526);
            for (Map.Entry entry : insightsViewState3.t().entrySet()) {
                U0((Category) entry.getKey(), InsightsViewState.H(insightsViewState3, ((Number) entry.getValue()).intValue(), false, 2, null), function1, entry.getKey() == insightsViewState3.Z(), composerK, (i5 << 3) & 896);
                insightsViewState3 = insightsViewState3;
            }
            insightsViewState2 = insightsViewState3;
            function12 = function1;
            composer2 = composerK;
            composer2.U();
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            insightsViewState2 = insightsViewState3;
            function12 = function1;
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.n3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsScreenComponentsKt.Z0(insightsViewState2, function12, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y1(int i3, Composer composer, int i4) throws XmlPullParserException, IOException {
        W1(composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y2(Function1 function1, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new InsightsViewEvent.OnPermissionResult(it));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z0(InsightsViewState insightsViewState, Function1 function1, int i3, Composer composer, int i4) {
        Y0(insightsViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void Z1(final boolean z2, final boolean z3, final List list, final Function1 function1, final Function0 function0, final Function1 function12, final Function0 function02, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(307176056);
        if ((i3 & 6) == 0) {
            i4 = (composerK.b(z2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z3) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(list) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function1) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(function0) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.I(function12) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerK.I(function02) ? 1048576 : 524288;
        }
        if (composerK.r((599187 & i4) != 599186, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(307176056, i4, -1, "cz.mobilesoft.coreblock.scene.insights.SchedulesContent (InsightsScreenComponents.kt:1248)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierH = SizeKt.h(PaddingKt.k(companion, Dp.g(f3), 0.0f, 2, null), 0.0f, 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.g(), composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierH);
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
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            TextKt.c(StringResources_androidKt.b(R.string.S, composerK, 0), SizeKt.h(companion, 0.0f, 1, null), ComposeColorsKt.j(composerK, 0).p(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.f()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).g(), composerK, 48, 0, 65016);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composerK, 6);
            long jI = ComposeColorsKt.j(composerK, 0).i();
            Function3 function3 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.y2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return InsightsScreenComponentsKt.a2((ScheduleSelectViewState.ScheduleDto) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            Function3 function32 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.z2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return InsightsScreenComponentsKt.b2((ScheduleSelectViewState.ScheduleDto) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            Function3 function33 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.b3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return InsightsScreenComponentsKt.c2((ScheduleSelectViewState.ScheduleDto) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            InsightsScreenComponentsKt$SchedulesContent$1$4 insightsScreenComponentsKt$SchedulesContent$1$4 = new Function3<ScheduleSelectViewState.ScheduleDto, Composer, Integer, Color>() { // from class: cz.mobilesoft.coreblock.scene.insights.InsightsScreenComponentsKt$SchedulesContent$1$4
                public final long c(ScheduleSelectViewState.ScheduleDto schedule, Composer composer3, int i5) {
                    long jK;
                    Intrinsics.checkNotNullParameter(schedule, "schedule");
                    composer3.a0(839236356);
                    if (ComposerKt.M()) {
                        ComposerKt.U(839236356, i5, -1, "cz.mobilesoft.coreblock.scene.insights.SchedulesContent.<anonymous>.<anonymous> (InsightsScreenComponents.kt:1293)");
                    }
                    ScheduleEmoji scheduleEmojiG = schedule.g();
                    if ((scheduleEmojiG != null ? scheduleEmojiG.getIconResId() : null) == null) {
                        composer3.a0(685726075);
                        jK = ComposeColorsKt.j(composer3, 0).p();
                        composer3.U();
                    } else {
                        composer3.a0(685798429);
                        composer3.U();
                        jK = Color.f25715b.k();
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                    composer3.U();
                    return jK;
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return Color.n(c((ScheduleSelectViewState.ScheduleDto) obj, (Composer) obj2, ((Number) obj3).intValue()));
                }
            };
            Function3 function34 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.c3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return InsightsScreenComponentsKt.d2((ScheduleSelectViewState.ScheduleDto) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            Function3 function35 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.d3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return Boolean.valueOf(InsightsScreenComponentsKt.e2(z2, (ScheduleSelectViewState.ScheduleDto) obj, (Composer) obj2, ((Integer) obj3).intValue()));
                }
            };
            Function3 function36 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.e3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return Boolean.valueOf(InsightsScreenComponentsKt.f2((ScheduleSelectViewState.ScheduleDto) obj, (Composer) obj2, ((Integer) obj3).intValue()));
                }
            };
            Function3 function37 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.f3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return Boolean.valueOf(InsightsScreenComponentsKt.g2((ScheduleSelectViewState.ScheduleDto) obj, (Composer) obj2, ((Integer) obj3).intValue()));
                }
            };
            InsightsScreenComponentsKt$SchedulesContent$1$9 insightsScreenComponentsKt$SchedulesContent$1$9 = new Function3<ScheduleSelectViewState.ScheduleDto, Composer, Integer, Color>() { // from class: cz.mobilesoft.coreblock.scene.insights.InsightsScreenComponentsKt$SchedulesContent$1$9
                public final Color c(ScheduleSelectViewState.ScheduleDto schedule, Composer composer3, int i5) {
                    Color colorN;
                    long jQ;
                    Intrinsics.checkNotNullParameter(schedule, "schedule");
                    composer3.a0(1781467157);
                    if (ComposerKt.M()) {
                        ComposerKt.U(1781467157, i5, -1, "cz.mobilesoft.coreblock.scene.insights.SchedulesContent.<anonymous>.<anonymous> (InsightsScreenComponents.kt:1306)");
                    }
                    if (!schedule.d() || (schedule.j() && schedule.i() && !schedule.e())) {
                        composer3.a0(-1222547415);
                        long jQ2 = ComposeColorsKt.j(composer3, 0).q();
                        composer3.U();
                        colorN = Color.n(jQ2);
                    } else {
                        composer3.a0(-1222659263);
                        if (schedule.c()) {
                            composer3.a0(-1702006981);
                            jQ = ComposeColorsKt.j(composer3, 0).b();
                        } else {
                            composer3.a0(-1702006366);
                            jQ = ComposeColorsKt.j(composer3, 0).q();
                        }
                        composer3.U();
                        composer3.U();
                        colorN = Color.n(jQ);
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                    composer3.U();
                    return colorN;
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return c((ScheduleSelectViewState.ScheduleDto) obj, (Composer) obj2, ((Number) obj3).intValue());
                }
            };
            boolean z4 = ((3670016 & i4) == 1048576) | ((i4 & 7168) == 2048) | ((458752 & i4) == 131072);
            Object objG = composerK.G();
            if (z4 || objG == Composer.f23746a.a()) {
                objG = new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.g3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return InsightsScreenComponentsKt.h2(function02, function1, function12, (ScheduleSelectViewState.ScheduleDto) obj, ((Integer) obj2).intValue());
                    }
                };
                composerK.w(objG);
            }
            SectionedItemKt.f0(list, function3, function32, null, null, function33, insightsScreenComponentsKt$SchedulesContent$1$4, function34, function35, function36, null, null, function37, true, false, false, 0L, null, insightsScreenComponentsKt$SchedulesContent$1$9, 0L, null, null, jI, null, null, (Function2) objG, composerK, (i4 >> 6) & 14, 3072, 0, 14542348);
            FlatButtonsKt.u(PaddingKt.m(companion, 0.0f, Dp.g(f3), 0.0f, 0.0f, 13, null), Dp.g(40), 0.0f, null, z3 ? FlatButtonColors.Secondary.f131167a : FlatButtonColors.PremiumReversed.f131165a, null, StringResources_androidKt.b(R.string.g4, composerK, 0), ComposeTypographyKt.g(composerK, 0).i(), 0L, Integer.valueOf(z3 ? R.drawable.f95558r0 : R.drawable.s4), null, false, false, function0, composerK, 54, ((i4 >> 3) & 7168) | 384, 3372);
            composer2 = composerK;
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.h3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsScreenComponentsKt.i2(z2, z3, list, function1, function0, function12, function02, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void Z2(LazyListScope lazyListScope, PackageManager packageManager, Context context, final InsightsViewState viewState, final Function1 onEvent, final MutableState moodCheckInOpenTrigger) {
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(packageManager, "packageManager");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(moodCheckInOpenTrigger, "moodCheckInOpenTrigger");
        if (viewState.u() && viewState.a0() != InsightsViewState.InsightsPeriodType.Trend) {
            GraphData graphDataL = viewState.l();
            if ((graphDataL != null ? graphDataL.g() : null) == null) {
                LazyListScope.c(lazyListScope, null, null, ComposableLambdaKt.c(2015302264, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.w1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return InsightsScreenComponentsKt.a3(viewState, onEvent, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }), 3, null);
            }
        }
        InsightsViewState.InsightsPeriodType insightsPeriodTypeA0 = viewState.a0();
        InsightsViewState.InsightsPeriodType insightsPeriodType = InsightsViewState.InsightsPeriodType.Trend;
        if (insightsPeriodTypeA0 == insightsPeriodType) {
            TrendScreenTimeComparisonKt.g(lazyListScope, context, viewState);
            TopTrendAppsKt.u(lazyListScope, packageManager, context, viewState);
        }
        if (viewState.d0()) {
            InsightsScreenApplicationListKt.J(lazyListScope, viewState, onEvent);
        }
        if (viewState.r0()) {
            W2(lazyListScope);
        } else {
            InsightsScreenApplicationListKt.O(lazyListScope, packageManager, context, viewState, viewState.W(), onEvent);
        }
        InsightsScreenBlockSessionsKt.l(lazyListScope, packageManager, viewState);
        if (viewState.a0() != insightsPeriodType) {
            InsightsScreenHabitsListKt.B(lazyListScope, viewState);
        }
        if (viewState.a0() != insightsPeriodType) {
            InsightsScreenFocusKt.b(lazyListScope, viewState);
        }
        if (viewState.a0() != insightsPeriodType) {
            InsightsScreenDistractionsKt.d(lazyListScope, viewState);
        }
        if (viewState.a0() == InsightsViewState.InsightsPeriodType.Day) {
            LazyListScope.c(lazyListScope, "mood-check-in", null, ComposableLambdaKt.c(1360433883, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.x1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return InsightsScreenComponentsKt.c3(viewState, moodCheckInOpenTrigger, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 2, null);
        }
        LazyListScope.c(lazyListScope, null, null, ComposableSingletons$InsightsScreenComponentsKt.f102566a.n(), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String a2(ScheduleSelectViewState.ScheduleDto schedule, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(schedule, "schedule");
        composer.a0(-588716157);
        if (ComposerKt.M()) {
            ComposerKt.U(-588716157, i3, -1, "cz.mobilesoft.coreblock.scene.insights.SchedulesContent.<anonymous>.<anonymous> (InsightsScreenComponents.kt:1270)");
        }
        String strK = schedule.k();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return strK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a3(InsightsViewState insightsViewState, final Function1 function1, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2015302264, i3, -1, "cz.mobilesoft.coreblock.scene.insights.overviewContent.<anonymous> (InsightsScreenComponents.kt:597)");
            }
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.r2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return InsightsScreenComponentsKt.b3(function1, (Category) obj);
                    }
                };
                composer.w(objG);
            }
            Y0(insightsViewState, (Function1) objG, composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b1(Function1 function1, int i3, InsightsViewState.InsightsPeriodType insightType) {
        Intrinsics.checkNotNullParameter(insightType, "insightType");
        function1.invoke(new InsightsViewEvent.OnInsightTypeSelected(insightType));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String b2(ScheduleSelectViewState.ScheduleDto schedule, Composer composer, int i3) {
        int limitValue;
        String strB;
        Intrinsics.checkNotNullParameter(schedule, "schedule");
        composer.a0(-1968501470);
        if (ComposerKt.M()) {
            ComposerKt.U(-1968501470, i3, -1, "cz.mobilesoft.coreblock.scene.insights.SchedulesContent.<anonymous>.<anonymous> (InsightsScreenComponents.kt:1272)");
        }
        if (schedule.d()) {
            composer.a0(-143770688);
            strB = StringResources_androidKt.b(schedule.c() ? R.string.f95863z : R.string.wg, composer, 0);
            composer.U();
        } else {
            composer.a0(-143617424);
            if (schedule.m()) {
                Limit limit = PremiumFeature.QUICK_BLOCK_APPS_UNLIMITED.getLimit();
                if (limit == null) {
                    limit = Limit.APP_WEB_LIMIT_QUICK_BLOCK;
                }
                limitValue = limit.getLimitValue();
            } else {
                Limit limit2 = PremiumFeature.PROFILES_APPS_UNLIMITED.getLimit();
                limitValue = limit2 != null ? limit2.getLimitValue() : Product.APPLICATIONS.getLimit();
            }
            String lowerCase = StringResources_androidKt.b(schedule.m() ? PremiumFeature.QUICK_BLOCK_APPS_UNLIMITED.getTitleResId() : PremiumFeature.PROFILES_APPS_UNLIMITED.getTitleResId(), composer, 0).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            strB = limitValue + "/" + limitValue + " " + lowerCase;
            composer.U();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return strB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b3(Function1 function1, Category it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new InsightsViewEvent.OnCategorySelected(it));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String c1(InsightsViewState.InsightsPeriodType SelectableChipRow, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(SelectableChipRow, "$this$SelectableChipRow");
        composer.a0(-1665996631);
        if (ComposerKt.M()) {
            ComposerKt.U(-1665996631, i3, -1, "cz.mobilesoft.coreblock.scene.insights.Chips.<anonymous> (InsightsScreenComponents.kt:170)");
        }
        String lowerCase = StringResources_androidKt.b(SelectableChipRow.getTitleRes(), composer, 0).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String strC = StringHelperExtKt.c(lowerCase);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return strC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Painter c2(ScheduleSelectViewState.ScheduleDto schedule, Composer composer, int i3) {
        Integer iconResId;
        Intrinsics.checkNotNullParameter(schedule, "schedule");
        composer.a0(1639644989);
        if (ComposerKt.M()) {
            ComposerKt.U(1639644989, i3, -1, "cz.mobilesoft.coreblock.scene.insights.SchedulesContent.<anonymous>.<anonymous> (InsightsScreenComponents.kt:1290)");
        }
        ScheduleEmoji scheduleEmojiG = schedule.g();
        Painter painterC = PainterResources_androidKt.c((scheduleEmojiG == null || (iconResId = scheduleEmojiG.getIconResId()) == null) ? R.drawable.r6 : iconResId.intValue(), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return painterC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c3(final InsightsViewState insightsViewState, final MutableState mutableState, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1360433883, i3, -1, "cz.mobilesoft.coreblock.scene.insights.overviewContent.<anonymous> (InsightsScreenComponents.kt:660)");
            }
            Modifier modifierK = PaddingKt.k(Modifier.b8, Dp.g(16), 0.0f, 2, null);
            MoodCheckInEntity moodCheckInEntityX = insightsViewState.x();
            boolean Z = composer.Z(mutableState) | composer.Z(insightsViewState);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.u2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InsightsScreenComponentsKt.d3(mutableState, insightsViewState);
                    }
                };
                composer.w(objG);
            }
            InsightsScreenMoodCheckInKt.e(modifierK, moodCheckInEntityX, (Function0) objG, composer, 6, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d1(Modifier modifier, InsightsViewState insightsViewState, Function1 function1, int i3, int i4, Composer composer, int i5) {
        a1(modifier, insightsViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean d2(ScheduleSelectViewState.ScheduleDto schedule, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(schedule, "schedule");
        composer.a0(-837195586);
        if (ComposerKt.M()) {
            ComposerKt.U(-837195586, i3, -1, "cz.mobilesoft.coreblock.scene.insights.SchedulesContent.<anonymous>.<anonymous> (InsightsScreenComponents.kt:1299)");
        }
        boolean zJ = schedule.j();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return Boolean.valueOf(zJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d3(MutableState mutableState, InsightsViewState insightsViewState) {
        LocalDate localDateB;
        mutableState.setValue(MoodCheckInOpenTrigger.Manual.f102955a);
        MoodCheckInEntity moodCheckInEntityX = insightsViewState.x();
        if (moodCheckInEntityX != null && (localDateB = moodCheckInEntityX.b()) != null && localDateB.isBefore(LocalDate.now())) {
            AnswersHelper.f128199a.I3();
        }
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void e1(androidx.compose.ui.Modifier r20, float r21, final cz.mobilesoft.coreblock.enums.AppDistractionType r22, androidx.compose.runtime.Composer r23, final int r24, final int r25) {
        /*
            Method dump skipped, instruction units count: 364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.InsightsScreenComponentsKt.e1(androidx.compose.ui.Modifier, float, cz.mobilesoft.coreblock.enums.AppDistractionType, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean e2(boolean z2, ScheduleSelectViewState.ScheduleDto schedule, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(schedule, "schedule");
        composer.a0(2077986397);
        if (ComposerKt.M()) {
            ComposerKt.U(2077986397, i3, -1, "cz.mobilesoft.coreblock.scene.insights.SchedulesContent.<anonymous>.<anonymous> (InsightsScreenComponents.kt:1300)");
        }
        boolean z3 = (schedule.j() && schedule.i() && z2) ? false : true;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f1(Modifier modifier, float f3, AppDistractionType appDistractionType, int i3, int i4, Composer composer, int i5) {
        e1(modifier, f3, appDistractionType, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f2(ScheduleSelectViewState.ScheduleDto schedule, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(schedule, "schedule");
        composer.a0(698201084);
        if (ComposerKt.M()) {
            ComposerKt.U(698201084, i3, -1, "cz.mobilesoft.coreblock.scene.insights.SchedulesContent.<anonymous>.<anonymous> (InsightsScreenComponents.kt:1301)");
        }
        boolean z2 = schedule.j() && schedule.i() && !schedule.e();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return z2;
    }

    public static final void g1(final PackageManager packageManager, final InsightsViewState viewState, final MutableState showExcludedAppsBottomSheet, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(packageManager, "packageManager");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(showExcludedAppsBottomSheet, "showExcludedAppsBottomSheet");
        Composer composerK = composer.k(-1938078816);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(packageManager) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(viewState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(showExcludedAppsBottomSheet) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1938078816, i4, -1, "cz.mobilesoft.coreblock.scene.insights.ExcludedAppsBottomSheet (InsightsScreenComponents.kt:1205)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            ComposableLambda composableLambdaE = ComposableLambdaKt.e(-1185385889, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.insights.n1
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return InsightsScreenComponentsKt.h1(viewState, showExcludedAppsBottomSheet, context, packageManager, (ColumnScope) obj, (SheetState) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerK, 54);
            boolean z2 = (i4 & 896) == 256;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.o1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InsightsScreenComponentsKt.j1(showExcludedAppsBottomSheet);
                    }
                };
                composerK.w(objG);
            }
            ComposeBottomSheetsKt.f(null, null, true, composableLambdaE, null, (Function0) objG, composerK, 3456, 19);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.p1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsScreenComponentsKt.k1(packageManager, viewState, showExcludedAppsBottomSheet, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g2(ScheduleSelectViewState.ScheduleDto schedule, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(schedule, "schedule");
        composer.a0(864133536);
        if (ComposerKt.M()) {
            ComposerKt.U(864133536, i3, -1, "cz.mobilesoft.coreblock.scene.insights.SchedulesContent.<anonymous>.<anonymous> (InsightsScreenComponents.kt:1302)");
        }
        boolean z2 = !schedule.d();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h1(final InsightsViewState insightsViewState, final MutableState mutableState, final Context context, PackageManager packageManager, ColumnScope AppBottomSheet, SheetState it, Composer composer, int i3) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(AppBottomSheet, "$this$AppBottomSheet");
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer2.r((i3 & 129) != 128, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1185385889, i3, -1, "cz.mobilesoft.coreblock.scene.insights.ExcludedAppsBottomSheet.<anonymous> (InsightsScreenComponents.kt:1210)");
            }
            Modifier modifierB = SizeKt.b(SizeKt.h(BackgroundKt.d(Modifier.b8, ComposeColorsKt.j(composer2, 0).l0(), null, 2, null), 0.0f, 1, null), 0.0f, Dp.g(240), 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer2, 0);
            int iA = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU = composer2.u();
            Modifier modifierF = ComposedModifierKt.f(composer2, modifierB);
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
            Updater.e(composerA, measurePolicyA, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            List<AggregatedItemRecord> listB = insightsViewState.B();
            if (listB == null) {
                composer2.a0(85056864);
                composer2.U();
            } else {
                composer2.a0(85056865);
                for (final AggregatedItemRecord aggregatedItemRecord : listB) {
                    boolean Z = composer2.Z(aggregatedItemRecord.e());
                    Object objG = composer2.G();
                    if (Z || objG == Composer.f23746a.a()) {
                        objG = insightsViewState.g(packageManager, aggregatedItemRecord.e());
                        composer2.w(objG);
                    }
                    Pair pair = (Pair) objG;
                    String str = (String) pair.a();
                    Drawable drawable = (Drawable) pair.b();
                    String strH = InsightsViewState.H(insightsViewState, aggregatedItemRecord.c(), false, 2, null);
                    boolean Z2 = composer2.Z(mutableState) | composer2.I(context) | composer2.I(aggregatedItemRecord) | composer2.Z(insightsViewState);
                    Object objG2 = composer2.G();
                    if (Z2 || objG2 == Composer.f23746a.a()) {
                        objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.d2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return InsightsScreenComponentsKt.i1(mutableState, context, aggregatedItemRecord, insightsViewState);
                            }
                        };
                        composer2.w(objG2);
                    }
                    InsightsScreenApplicationListKt.u(strH, aggregatedItemRecord, null, str, drawable, true, (Function0) objG2, composer2, 196608, 4);
                    composer2 = composer;
                }
                composer.U();
            }
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h2(Function0 function0, Function1 function1, Function1 function12, ScheduleSelectViewState.ScheduleDto schedule, int i3) {
        Intrinsics.checkNotNullParameter(schedule, "schedule");
        if (schedule.j() && schedule.i() && !schedule.e()) {
            function0.invoke();
        } else if (schedule.d()) {
            function1.invoke(Integer.valueOf(i3));
        } else {
            function12.invoke(Boolean.valueOf(schedule.m()));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i1(MutableState mutableState, Context context, AggregatedItemRecord aggregatedItemRecord, InsightsViewState insightsViewState) {
        mutableState.setValue(Boolean.FALSE);
        context.startActivity(InsightsActivity.f102590g.a(context, aggregatedItemRecord.e(), insightsViewState.a0()));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i2(boolean z2, boolean z3, List list, Function1 function1, Function0 function0, Function1 function12, Function0 function02, int i3, Composer composer, int i4) {
        Z1(z2, z3, list, function1, function0, function12, function02, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j1(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0438  */
    /* JADX WARN: Removed duplicated region for block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void j2(final androidx.compose.runtime.MutableState r46, final androidx.compose.runtime.MutableState r47, java.lang.Integer r48, kotlin.jvm.functions.Function0 r49, androidx.compose.runtime.Composer r50, final int r51, final int r52) {
        /*
            Method dump skipped, instruction units count: 1097
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.InsightsScreenComponentsKt.j2(androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, java.lang.Integer, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k1(PackageManager packageManager, InsightsViewState insightsViewState, MutableState mutableState, int i3, Composer composer, int i4) {
        g1(packageManager, insightsViewState, mutableState, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k2() {
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:135:0x048e  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x049a  */
    /* JADX WARN: Removed duplicated region for block: B:140:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void l1(androidx.compose.ui.Modifier r42, final java.lang.String r43, final java.lang.String r44, java.lang.String r45, java.lang.String r46, final int r47, androidx.compose.runtime.Composer r48, final int r49, final int r50) {
        /*
            Method dump skipped, instruction units count: 1197
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.InsightsScreenComponentsKt.l1(androidx.compose.ui.Modifier, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l2(MutableState mutableState, MutableState mutableState2, Integer num, Function0 function0, int i3, int i4, Composer composer, int i5) {
        j2(mutableState, mutableState2, num, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier m1(final CoroutineScope coroutineScope, final TooltipState tooltipState, Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return ClickableKt.f(applyIf, false, null, null, new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.l4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return InsightsScreenComponentsKt.n1(coroutineScope, tooltipState);
            }
        }, 7, null);
    }

    private static final float m2(MutableFloatState mutableFloatState) {
        return mutableFloatState.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n1(CoroutineScope coroutineScope, TooltipState tooltipState) {
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new InsightsScreenComponentsKt$FocusTile$1$1$1$1(tooltipState, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n2(MutableFloatState mutableFloatState, float f3) {
        mutableFloatState.s(f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o1(Modifier modifier, String str, String str2, String str3, String str4, int i3, int i4, int i5, Composer composer, int i6) {
        l1(modifier, str, str2, str3, str4, i3, composer, RecomposeScopeImplKt.a(i4 | 1), i5);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int o2(MutableFloatState mutableFloatState) {
        return MathKt.d(m2(mutableFloatState));
    }

    public static final void p1(InsightsViewState viewState, final Function1 onEvent, Composer composer, final int i3) {
        int i4;
        final InsightsViewState insightsViewState;
        int i5;
        int i6;
        Object obj;
        int i7;
        boolean z2;
        long jA;
        String upperCase;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(-2026728996);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.Z(viewState) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onEvent) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2026728996, i4, -1, "cz.mobilesoft.coreblock.scene.insights.Header (InsightsScreenComponents.kt:300)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            Object objG = composerK.G();
            Composer.Companion companion2 = Composer.f23746a;
            if (objG == companion2.a()) {
                objG = InteractionSourceKt.a();
                composerK.w(objG);
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objG;
            boolean z3 = (i4 & 112) == 32;
            Object objG2 = composerK.G();
            if (z3 || objG2 == companion2.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.n2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InsightsScreenComponentsKt.q1(onEvent);
                    }
                };
                composerK.w(objG2);
            }
            Modifier modifierD = ClickableKt.d(modifierH, mutableInteractionSource, null, false, null, null, (Function0) objG2, 28, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.g(), composerK, 48);
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
            float f3 = 6;
            SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composerK, 6);
            AppDistractionType appDistractionTypeF = viewState.f();
            if (appDistractionTypeF == null) {
                composerK.a0(1294619547);
                composerK.U();
                i5 = i4;
                i6 = 6;
                i7 = 1;
                obj = null;
            } else {
                composerK.a0(1294619548);
                i5 = i4;
                i6 = 6;
                obj = null;
                i7 = 1;
                TextKt.c(StringResources_androidKt.b(appDistractionTypeF.getNameRes(), composerK, 0), PaddingKt.j(BackgroundKt.c(companion, Color.r(appDistractionTypeF.m1357getColor0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.a(50)), Dp.g(f3), Dp.g(2)), appDistractionTypeF.m1357getColor0d7_KjU(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, TextStyle.e(ComposeTypographyKt.g(composerK, 0).j(), 0L, TextUnitKt.i(12), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777213, null), composerK, 0, 0, 65016);
                composerK = composerK;
                Unit unit = Unit.f139807a;
                composerK.U();
            }
            InsightsViewState.InsightsPeriodType insightsPeriodTypeA0 = viewState.a0();
            InsightsViewState.InsightsPeriodType insightsPeriodType = InsightsViewState.InsightsPeriodType.Trend;
            if (insightsPeriodTypeA0 == insightsPeriodType) {
                composerK.a0(1295378893);
                SpacerKt.a(SizeKt.i(companion, Dp.g(8)), composerK, i6);
                G2(null, ComparableExtKt.e(viewState.e(), 0L), 0.0f, 0.0f, composerK, 0, 13);
            } else {
                composerK.a0(1281652496);
            }
            composerK.U();
            float f4 = 8;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composerK, i6);
            Modifier modifierH2 = SizeKt.h(companion, 0.0f, i7, obj);
            String strD = viewState.D();
            TextStyle textStyleE = TextStyle.e(ComposeTypographyKt.g(composerK, 0).e(), 0L, TextUnitKt.i(40), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777213, null);
            TextAlign.Companion companion4 = TextAlign.f29616b;
            Composer composer2 = composerK;
            TextKt.c(strD, modifierH2, ComposeColorsKt.j(composerK, 0).p(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, textStyleE, composer2, 48, 0, 65016);
            composerK = composer2;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composerK, i6);
            String strE = viewState.E((Context) composerK.q(AndroidCompositionLocals_androidKt.g()));
            if (viewState.a0() != insightsPeriodType) {
                composerK.a0(1296150297);
                Modifier modifierH3 = SizeKt.h(companion, 0.0f, 1, obj);
                TextStyle textStyleJ = ComposeTypographyKt.g(composerK, 0).j();
                int iA2 = companion4.a();
                long jQ = ComposeColorsKt.j(composerK, 0).q();
                TextAlign textAlignH = TextAlign.h(iA2);
                insightsViewState = viewState;
                TextKt.c(strE, modifierH3, jQ, 0L, null, null, null, 0L, null, textAlignH, 0L, 0, false, 0, 0, null, textStyleJ, composerK, 48, 0, 65016);
                composerK = composerK;
                composerK.U();
            } else {
                insightsViewState = viewState;
                if (StringsKt.p0(strE)) {
                    composerK.a0(1281652496);
                } else {
                    composerK.a0(1296487298);
                    Float fJ0 = insightsViewState.j0();
                    if (fJ0 != null) {
                        z2 = fJ0.floatValue() >= 0.0f;
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        composerK.a0(1288751317);
                        jA = ComposeColorsKt.j(composerK, 0).c0();
                    } else {
                        composerK.a0(1288751831);
                        jA = ComposeColorsKt.j(composerK, 0).A();
                    }
                    composerK.U();
                    long j3 = jA;
                    Modifier modifierH4 = SizeKt.h(companion, 0.0f, 1, obj);
                    if (z2) {
                        composerK.a0(1296754363);
                        upperCase = StringResources_androidKt.b(R.string.Vg, composerK, 0).toUpperCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                        composerK.U();
                    } else {
                        composerK.a0(1296876379);
                        upperCase = StringResources_androidKt.b(R.string.Ug, composerK, 0).toUpperCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                        composerK.U();
                    }
                    TextKt.c(upperCase, modifierH4, ComposeColorsKt.j(composerK, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).j(), composerK, 48, 0, 65016);
                    SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composerK, i6);
                    x2(null, strE, j3, z2, composerK, 0, 1);
                    composerK = composerK;
                    SpacerKt.a(SizeKt.i(companion, Dp.g(12)), composerK, i6);
                }
                composerK.U();
            }
            s1(insightsViewState, composerK, i5 & 14);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            insightsViewState = viewState;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.o2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return InsightsScreenComponentsKt.r1(insightsViewState, onEvent, i3, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int p2(State state) {
        return ((Number) state.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q1(Function1 function1) {
        function1.invoke(new InsightsViewEvent.OnBarSelected(null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q2(CoroutineScope coroutineScope, MutableFloatState mutableFloatState, Animatable animatable, float f3) {
        n2(mutableFloatState, f3);
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new InsightsScreenComponentsKt$SmoothSnapSlider$4$1$2$1$1(animatable, f3, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r1(InsightsViewState insightsViewState, Function1 function1, int i3, Composer composer, int i4) {
        p1(insightsViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r2(CoroutineScope coroutineScope, MutableFloatState mutableFloatState, Animatable animatable) {
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new InsightsScreenComponentsKt$SmoothSnapSlider$4$1$3$1$1(animatable, MathKt.d(m2(mutableFloatState)), null), 3, null);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void s1(final cz.mobilesoft.coreblock.scene.insights.InsightsViewState r49, androidx.compose.runtime.Composer r50, final int r51) {
        /*
            Method dump skipped, instruction units count: 696
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.InsightsScreenComponentsKt.s1(cz.mobilesoft.coreblock.scene.insights.InsightsViewState, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s2(long j3, final long j4, SliderState it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2061027525, i3, -1, "cz.mobilesoft.coreblock.scene.insights.SmoothSnapSlider.<anonymous>.<anonymous>.<anonymous> (InsightsScreenComponents.kt:1783)");
            }
            Modifier modifierV = SizeKt.v(Modifier.b8, Dp.g(24));
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.g4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return InsightsScreenComponentsKt.t2((SemanticsPropertyReceiver) obj);
                    }
                };
                composer.w(objG);
            }
            SurfaceKt.a(SemanticsModifierKt.f(modifierV, false, (Function1) objG, 1, null), RoundedCornerShapeKt.g(), j3, 0L, 0.0f, Dp.g(4), null, ComposableLambdaKt.e(-606397376, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.i4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsScreenComponentsKt.u2(j4, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 12779520, 88);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t1(InsightsViewState insightsViewState, int i3, Composer composer, int i4) {
        s1(insightsViewState, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t2(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.d0(semantics, "Mood slider");
        return Unit.f139807a;
    }

    public static final void u1(Modifier modifier, final InsightsViewState viewState, final Function1 onEvent, Composer composer, final int i3, final int i4) throws XmlPullParserException, IOException {
        Modifier modifier2;
        int i5;
        final Modifier modifier3;
        PagerState pagerState;
        int i6;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(1725981347);
        int i7 = i4 & 1;
        if (i7 != 0) {
            i5 = i3 | 6;
            modifier2 = modifier;
        } else if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i5 = (composerK.Z(modifier2) ? 4 : 2) | i3;
        } else {
            modifier2 = modifier;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.Z(viewState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.I(onEvent) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        int i8 = i5;
        if (composerK.r((i8 & 147) != 146, i8 & 1)) {
            Modifier modifier4 = i7 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(1725981347, i8, -1, "cz.mobilesoft.coreblock.scene.insights.IntervalNavigation (InsightsScreenComponents.kt:201)");
            }
            int i9 = i8 & 112;
            boolean z2 = i9 == 32;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.p2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Integer.valueOf(InsightsScreenComponentsKt.v1(viewState));
                    }
                };
                composerK.w(objG);
            }
            PagerState pagerStateL = PagerStateKt.l(0, 0.0f, (Function0) objG, composerK, 6, 2);
            Integer numValueOf = Integer.valueOf(viewState.v());
            boolean Z = composerK.Z(pagerStateL) | (i9 == 32);
            Object objG2 = composerK.G();
            if (Z || objG2 == Composer.f23746a.a()) {
                objG2 = new InsightsScreenComponentsKt$IntervalNavigation$1$1(viewState, pagerStateL, null);
                composerK.w(objG2);
            }
            EffectsKt.g(numValueOf, (Function2) objG2, composerK, 0);
            Modifier modifierI = SizeKt.i(SizeKt.h(PaddingKt.k(modifier4, Dp.g(20), 0.0f, 2, null), 0.0f, 1, null), Dp.g(30));
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.i(), composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierI);
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
            Updater.e(composerA, measurePolicyB, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            InsightsViewState.InsightsPeriodType insightsPeriodTypeA0 = viewState.a0();
            InsightsViewState.InsightsPeriodType insightsPeriodType = InsightsViewState.InsightsPeriodType.Trend;
            if (insightsPeriodTypeA0 != insightsPeriodType) {
                composerK.a0(-647147956);
                ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.v4, composerK, 6);
                boolean zS = viewState.s();
                boolean z3 = (i8 & 896) == 256;
                Object objG3 = composerK.G();
                if (z3 || objG3 == Composer.f23746a.a()) {
                    objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.a3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return InsightsScreenComponentsKt.w1(onEvent);
                        }
                    };
                    composerK.w(objG3);
                }
                pagerState = pagerStateL;
                i6 = 256;
                S0(imageVectorB, zS, (Function0) objG3, composerK, 0, 0);
            } else {
                pagerState = pagerStateL;
                i6 = Function.MAX_NARGS;
                composerK.a0(-657155965);
            }
            composerK.U();
            int i10 = i6;
            Modifier modifier5 = modifier4;
            PagerKt.a(pagerState, RowScope.c(rowScopeInstance, Modifier.b8, 1.0f, false, 2, null), null, null, 1, 0.0f, null, null, false, false, null, null, SnapPosition.Center.f6486a, null, ComposableLambdaKt.e(-467670690, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.insights.l3
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return InsightsScreenComponentsKt.x1(viewState, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerK, 54), composerK, 100687872, 24960, 12012);
            composerK = composerK;
            if (viewState.a0() != insightsPeriodType) {
                composerK.a0(-646166248);
                ImageVector imageVectorB2 = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.P3, composerK, 6);
                boolean zR = viewState.r();
                boolean z4 = (i8 & 896) == i10;
                Object objG4 = composerK.G();
                if (z4 || objG4 == Composer.f23746a.a()) {
                    objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.w3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return InsightsScreenComponentsKt.y1(onEvent);
                        }
                    };
                    composerK.w(objG4);
                }
                S0(imageVectorB2, zR, (Function0) objG4, composerK, 0, 0);
            } else {
                composerK.a0(-657155965);
            }
            composerK.U();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier3 = modifier5;
        } else {
            composerK.Q();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.h4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsScreenComponentsKt.z1(modifier3, viewState, onEvent, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u2(long j3, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-606397376, i3, -1, "cz.mobilesoft.coreblock.scene.insights.SmoothSnapSlider.<anonymous>.<anonymous>.<anonymous>.<anonymous> (InsightsScreenComponents.kt:1793)");
            }
            Alignment.Companion companion = Alignment.f25072a;
            Alignment alignmentE = companion.e();
            Modifier.Companion companion2 = Modifier.b8;
            MeasurePolicy measurePolicyG = BoxKt.g(alignmentE, false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, companion2);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A);
            } else {
                composer.v();
            }
            Composer composerA = Updater.a(composer);
            Updater.e(composerA, measurePolicyG, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.y5, composer, 6), null, SizeKt.v(BoxScopeInstance.f6642a.f(companion2, companion.e()), Dp.g(18)), j3, composer, 3120, 0);
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int v1(InsightsViewState insightsViewState) {
        return insightsViewState.K().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v2(BoxScope boxScope, final float f3, final long j3, final int i3, final int i4, final float f4, SliderState sliderState, Composer composer, int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(sliderState, "sliderState");
        if ((i5 & 6) == 0) {
            i6 = i5 | ((i5 & 8) == 0 ? composer.Z(sliderState) : composer.I(sliderState) ? 4 : 2);
        } else {
            i6 = i5;
        }
        if (composer.r((i6 & 19) != 18, i6 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2003045252, i6, -1, "cz.mobilesoft.coreblock.scene.insights.SmoothSnapSlider.<anonymous>.<anonymous>.<anonymous> (InsightsScreenComponents.kt:1806)");
            }
            Modifier modifierF = boxScope.f(SizeKt.i(SizeKt.h(Modifier.b8, 0.0f, 1, null), f3), Alignment.f25072a.e());
            boolean zF = composer.f(j3);
            Object objG = composer.G();
            if (zF || objG == Composer.f23746a.a()) {
                Function1 function1 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.m4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return InsightsScreenComponentsKt.w2(i3, i4, f4, j3, f3, (DrawScope) obj);
                    }
                };
                composer.w(function1);
                objG = function1;
            }
            CanvasKt.b(modifierF, (Function1) objG, composer, 0);
            SliderDefaults sliderDefaults = SliderDefaults.f19885a;
            Color.Companion companion = Color.f25715b;
            sliderDefaults.f(sliderState, null, false, sliderDefaults.j(companion.j(), companion.j(), companion.j(), companion.j(), companion.j(), 0L, 0L, 0L, 0L, 0L, composer, 28086, 6, 992), null, null, 0.0f, 0.0f, composer, 100687872 | SliderState.f20184q | (i6 & 14), 230);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w1(Function1 function1) {
        function1.invoke(InsightsViewEvent.OnPreviousIntervalClicked.f102692a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w2(int i3, int i4, float f3, long j3, float f4, DrawScope drawScope) {
        DrawScope Canvas = drawScope;
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        float fIntBitsToFloat = Float.intBitsToFloat((int) (Canvas.b() >> 32)) / i3;
        int i5 = 0;
        while (i5 < i4) {
            long jE = Offset.e((((long) Float.floatToRawIntBits((i5 * fIntBitsToFloat) - (Canvas.M1(f3) / 2))) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L));
            float fM1 = Canvas.M1(f3);
            DrawScope.L1(Canvas, j3, jE, Size.d((((long) Float.floatToRawIntBits(Canvas.M1(f4))) & 4294967295L) | (Float.floatToRawIntBits(fM1) << 32)), 0.0f, null, null, 0, 120, null);
            i5++;
            Canvas = drawScope;
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x1(InsightsViewState insightsViewState, PagerScope HorizontalPager, int i3, Composer composer, int i4) {
        Intrinsics.checkNotNullParameter(HorizontalPager, "$this$HorizontalPager");
        if (ComposerKt.M()) {
            ComposerKt.U(-467670690, i4, -1, "cz.mobilesoft.coreblock.scene.insights.IntervalNavigation.<anonymous>.<anonymous> (InsightsScreenComponents.kt:241)");
        }
        Modifier modifierH = SizeKt.h(Modifier.b8, 0.0f, 1, null);
        String upperCase = insightsViewState.y().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        TextKt.c(upperCase, modifierH, ComposeColorsKt.j(composer, 0).b(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 48, 0, 65016);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    public static final void x2(Modifier modifier, final String text, final long j3, final boolean z2, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        final Modifier modifier3;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer composerK = composer.k(-323245295);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            modifier2 = modifier;
        } else if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i5 = (composerK.Z(modifier2) ? 4 : 2) | i3;
        } else {
            modifier2 = modifier;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.Z(text) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.f(j3) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerK.b(z2) ? 2048 : 1024;
        }
        if (composerK.r((i5 & 1171) != 1170, i5 & 1)) {
            Modifier modifier4 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(-323245295, i5, -1, "cz.mobilesoft.coreblock.scene.insights.TextWithIconAndBackground (InsightsScreenComponents.kt:1466)");
            }
            Modifier modifierJ = PaddingKt.j(BackgroundKt.c(modifier4, Color.r(j3, 0.1f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.a(50)), Dp.g(4), Dp.g(2));
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.i(), composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierJ);
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
            Updater.e(composerA, measurePolicyB, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            Modifier modifier5 = modifier4;
            int i7 = i5;
            IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.K6, composerK, 6), null, RotateKt.a(SizeKt.v(Modifier.b8, Dp.g(16)), z2 ? 0.0f : 180.0f), j3, composerK, 48 | ((i5 << 3) & 7168), 0);
            TextKt.c(text, null, j3, 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, TextStyle.e(ComposeTypographyKt.g(composerK, 0).j(), 0L, TextUnitKt.i(12), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777213, null), composerK, ((i7 >> 3) & 14) | (i7 & 896), 0, 65018);
            composerK = composerK;
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier3 = modifier5;
        } else {
            composerK.Q();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.s2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsScreenComponentsKt.y2(modifier3, text, j3, z2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y1(Function1 function1) {
        function1.invoke(InsightsViewEvent.OnNextIntervalClicked.f102690a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y2(Modifier modifier, String str, long j3, boolean z2, int i3, int i4, Composer composer, int i5) {
        x2(modifier, str, j3, z2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z1(Modifier modifier, InsightsViewState insightsViewState, Function1 function1, int i3, int i4, Composer composer, int i5) throws XmlPullParserException, IOException {
        u1(modifier, insightsViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void z2(final InsightsViewState viewState, final Function1 onEvent, Composer composer, final int i3) {
        int i4;
        ScopeUpdateScope scopeUpdateScopeN;
        Function2 function2;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(709676159);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(viewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onEvent) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(709676159, i4, -1, "cz.mobilesoft.coreblock.scene.insights.TrendChips (InsightsScreenComponents.kt:178)");
            }
            if (viewState.i().size() <= 1) {
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                scopeUpdateScopeN = composerK.n();
                if (scopeUpdateScopeN != null) {
                    function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.g2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return InsightsScreenComponentsKt.A2(viewState, onEvent, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    scopeUpdateScopeN.a(function2);
                }
                return;
            }
            Modifier modifierK = PaddingKt.k(Modifier.b8, Dp.g(20), 0.0f, 2, null);
            long jQ0 = ComposeColorsKt.j(composerK, 0).q0();
            List listI = viewState.i();
            List listI2 = viewState.i();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listI2, 10));
            Iterator it = listI2.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(((InsightsViewState.TrendInterval) it.next()).ordinal()));
            }
            int iIndexOf = arrayList.indexOf(Integer.valueOf(viewState.b0()));
            boolean z2 = (i4 & 112) == 32;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.h2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return InsightsScreenComponentsKt.B2(onEvent, ((Integer) obj).intValue(), (InsightsViewState.TrendInterval) obj2);
                    }
                };
                composerK.w(objG);
            }
            ChipKt.o(modifierK, false, 0.0f, listI, iIndexOf, jQ0, (Function2) objG, null, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.i2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return InsightsScreenComponentsKt.C2((InsightsViewState.TrendInterval) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 6, 134);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.j2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsScreenComponentsKt.D2(viewState, onEvent, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeN.a(function2);
        }
    }

    public static final void a1(Modifier modifier, final InsightsViewState viewState, final Function1 onEvent, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        final Modifier modifier3;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(-1301488395);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            modifier2 = modifier;
        } else if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i5 = (composerK.Z(modifier2) ? 4 : 2) | i3;
        } else {
            modifier2 = modifier;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.Z(viewState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.I(onEvent) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i5 & 147) != 146, i5 & 1)) {
            modifier3 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(-1301488395, i5, -1, YvFRmou.hmVolKsrmGTIgeR);
            }
            Modifier modifierK = PaddingKt.k(modifier3, Dp.g(20), 0.0f, 2, null);
            EnumEntries<InsightsViewState.InsightsPeriodType> entries = InsightsViewState.InsightsPeriodType.getEntries();
            int iOrdinal = viewState.a0().ordinal();
            long jQ0 = ComposeColorsKt.j(composerK, 0).q0();
            boolean z2 = (i5 & 896) == 256;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.q4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return InsightsScreenComponentsKt.b1(onEvent, ((Integer) obj).intValue(), (InsightsViewState.InsightsPeriodType) obj2);
                    }
                };
                composerK.w(objG);
            }
            ChipKt.o(modifierK, false, 0.0f, entries, iOrdinal, jQ0, (Function2) objG, null, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.r4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return InsightsScreenComponentsKt.c1((InsightsViewState.InsightsPeriodType) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 0, 134);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.j1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsScreenComponentsKt.d1(modifier3, viewState, onEvent, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
