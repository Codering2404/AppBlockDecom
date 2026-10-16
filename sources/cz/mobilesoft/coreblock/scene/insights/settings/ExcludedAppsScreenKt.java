package cz.mobilesoft.coreblock.scene.insights.settings;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.TabKt;
import androidx.compose.material.TabRowKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import coil.compose.SingletonAsyncImageKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.dto.UsageAccess;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.scene.insights.InsightsScreenComponentsKt;
import cz.mobilesoft.coreblock.scene.insights.settings.ExcludedAppsViewEvent;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.scene.selection.ignorelist.IgnoreListSelectActivity;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Application;
import cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.view.compose.ToolbarKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
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
public final class ExcludedAppsScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(ExcludedAppsViewState excludedAppsViewState, final Function0 function0, Composer composer, int i3) throws XmlPullParserException, IOException {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-55110144, i3, -1, "cz.mobilesoft.coreblock.scene.insights.settings.Content.<anonymous> (ExcludedAppsScreen.kt:125)");
            }
            if ((excludedAppsViewState.e() != ExcludedAppsSections.Custom.ordinal() || excludedAppsViewState.c().isEmpty()) && (excludedAppsViewState.e() != ExcludedAppsSections.Default.ordinal() || excludedAppsViewState.d().isEmpty())) {
                composer.a0(-1114033566);
            } else {
                composer.a0(-1108494548);
                if (excludedAppsViewState.f()) {
                    composer.a0(-1108381708);
                    Modifier.Companion companion = Modifier.b8;
                    Modifier modifierK = PaddingKt.k(SizeKt.h(companion, 0.0f, 1, null), 0.0f, Dp.g(8), 1, null);
                    Alignment.Companion companion2 = Alignment.f25072a;
                    MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
                    int iA = ComposablesKt.a(composer, 0);
                    CompositionLocalMap compositionLocalMapU = composer.u();
                    Modifier modifierF = ComposedModifierKt.f(composer, modifierK);
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
                    Modifier modifierC = BackgroundKt.c(ClipKt.a(SizeKt.v(boxScopeInstance.f(companion, companion2.e()), Dp.g(48)), RoundedCornerShapeKt.g()), ComposeColorsKt.j(composer, 0).b(), RoundedCornerShapeKt.g());
                    boolean Z = composer.Z(function0);
                    Object objG = composer.G();
                    if (Z || objG == Composer.f23746a.a()) {
                        objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.o
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ExcludedAppsScreenKt.B(function0);
                            }
                        };
                        composer.w(objG);
                    }
                    Modifier modifierF2 = ClickableKt.f(modifierC, false, null, null, (Function0) objG, 7, null);
                    MeasurePolicy measurePolicyG2 = BoxKt.g(companion2.o(), false);
                    int iA2 = ComposablesKt.a(composer, 0);
                    CompositionLocalMap compositionLocalMapU2 = composer.u();
                    Modifier modifierF3 = ComposedModifierKt.f(composer, modifierF2);
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
                    Updater.e(composerA2, measurePolicyG2, companion3.e());
                    Updater.e(composerA2, compositionLocalMapU2, companion3.g());
                    Function2 function2B2 = companion3.b();
                    if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                        composerA2.w(Integer.valueOf(iA2));
                        composerA2.p(Integer.valueOf(iA2), function2B2);
                    }
                    Updater.e(composerA2, modifierF3, companion3.f());
                    IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.f95558r0, composer, 6), null, SizeKt.v(boxScopeInstance.f(companion, companion2.e()), Dp.g(24)), Color.f25715b.l(), composer, 3120, 0);
                    composer.y();
                    composer.y();
                    composer.U();
                } else {
                    composer.a0(-1108494331);
                    InsightsScreenComponentsKt.W1(composer, 0);
                    composer.U();
                }
            }
            composer.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(final ExcludedAppsViewState excludedAppsViewState, PackageManager packageManager, Function0 function0, Function0 function02, final Function1 function1, PaddingValues it, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(it) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(836871944, i4, -1, "cz.mobilesoft.coreblock.scene.insights.settings.Content.<anonymous> (ExcludedAppsScreen.kt:161)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = PaddingKt.h(companion, it);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            TextKt.c(StringResources_androidKt.b(R.string.Lg, composer, 0), PaddingKt.m(companion, Dp.g(16), 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).f(), composer, 48, 0, 65532);
            TabRowKt.b(excludedAppsViewState.e(), SizeKt.h(companion, 0.0f, 1, null), ComposeColorsKt.j(composer, 0).e(), ComposeColorsKt.j(composer, 0).b(), null, ComposableSingletons$ExcludedAppsScreenKt.f103421a.b(), ComposableLambdaKt.e(-2122147014, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ExcludedAppsScreenKt.D(excludedAppsViewState, function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 1769520, 16);
            int iE = excludedAppsViewState.e();
            if (iE == ExcludedAppsSections.Custom.ordinal()) {
                composer.a0(-1995561356);
                L(excludedAppsViewState.c(), packageManager, excludedAppsViewState.f(), function0, function02, function1, composer, 0);
                composer.U();
            } else {
                if (iE == ExcludedAppsSections.Default.ordinal()) {
                    composer.a0(-1995064333);
                    L(excludedAppsViewState.d(), packageManager, excludedAppsViewState.f(), function0, function02, function1, composer, 0);
                } else {
                    composer.a0(-2004555696);
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
    public static final Unit D(ExcludedAppsViewState excludedAppsViewState, final Function1 function1, Composer composer, int i3) {
        Composer composer2 = composer;
        boolean z2 = true;
        if (composer2.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2122147014, i3, -1, "cz.mobilesoft.coreblock.scene.insights.settings.Content.<anonymous>.<anonymous>.<anonymous> (ExcludedAppsScreen.kt:182)");
            }
            final int i4 = 0;
            for (ExcludedAppsSections excludedAppsSections : ExcludedAppsSections.getEntries()) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                final ExcludedAppsSections excludedAppsSections2 = excludedAppsSections;
                final boolean z3 = excludedAppsViewState.e() == i4 ? z2 : false;
                boolean Z = composer2.Z(function1) | composer2.e(i4);
                Object objG = composer2.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.s
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ExcludedAppsScreenKt.E(function1, i4);
                        }
                    };
                    composer2.w(objG);
                }
                TabKt.b(z3, (Function0) objG, null, false, ComposableLambdaKt.e(2072255111, z2, new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.t
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ExcludedAppsScreenKt.F(excludedAppsSections2, z3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54), null, null, 0L, 0L, composer2, 24576, 492);
                composer2 = composer;
                i4 = i5;
                z2 = z2;
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(Function1 function1, int i3) {
        function1.invoke(new ExcludedAppsViewEvent.OnTabSelected(i3));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(ExcludedAppsSections excludedAppsSections, boolean z2, Composer composer, int i3) {
        TextStyle textStyleA;
        long jL;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2072255111, i3, -1, "cz.mobilesoft.coreblock.scene.insights.settings.Content.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ExcludedAppsScreen.kt:186)");
            }
            String strC = StringHelperExtKt.c(StringResources_androidKt.b(excludedAppsSections.getTitleRes(), composer, 0));
            int iA = TextAlign.f29616b.a();
            if (z2) {
                composer.a0(-1427654455);
                textStyleA = ComposeTypographyKt.g(composer, 0).h();
            } else {
                composer.a0(-1427653844);
                textStyleA = ComposeTypographyKt.g(composer, 0).a();
            }
            composer.U();
            TextStyle textStyle = textStyleA;
            if (z2) {
                composer.a0(-1427651411);
                jL = ComposeColorsKt.j(composer, 0).b();
            } else {
                composer.a0(-1427650805);
                jL = ComposeColorsKt.j(composer, 0).L();
            }
            composer.U();
            TextKt.c(strC, null, jL, 0L, null, null, null, 0L, null, TextAlign.h(iA), 0L, 0, false, 0, 0, null, textStyle, composer, 0, 0, 65018);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(ExcludedAppsViewState excludedAppsViewState, Function0 function0, Function1 function1, PackageManager packageManager, Function0 function02, Function0 function03, int i3, int i4, Composer composer, int i5) {
        w(excludedAppsViewState, function0, function1, packageManager, function02, function03, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void H(final boolean z2, Function0 function0, Function0 function02, Composer composer, final int i3) {
        int i4;
        final Function0 function03;
        Composer composer2;
        final Function0 function04 = function0;
        Composer composerK = composer.k(1349330115);
        if ((i3 & 6) == 0) {
            i4 = (composerK.b(z2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function04) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function02) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1349330115, i4, -1, "cz.mobilesoft.coreblock.scene.insights.settings.EmptyView (ExcludedAppsScreen.kt:324)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierK = PaddingKt.k(ScrollKt.g(SizeKt.h(companion, 0.0f, 1, null), ScrollKt.c(0, composerK, 0, 1), false, null, false, 14, null), Dp.g(f3), 0.0f, 2, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.o(Dp.g(f3)), Alignment.f25072a.g(), composerK, 54);
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
            ImageKt.a(PainterResources_androidKt.c(R.drawable.H, composerK, 0), null, PaddingKt.m(companion, 0.0f, Dp.g(32), 0.0f, Dp.g(8), 5, null), null, null, 0.0f, null, composerK, 432, 120);
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            long jP = ComposeColorsKt.j(composerK, 0).p();
            String strB = StringResources_androidKt.b(R.string.Og, composerK, 0);
            TextStyle textStyleG = ComposeTypographyKt.g(composerK, 0).g();
            TextAlign.Companion companion3 = TextAlign.f29616b;
            boolean z3 = true;
            TextKt.c(strB, modifierH, jP, 0L, null, null, null, 0L, null, TextAlign.h(companion3.a()), 0L, 0, false, 0, 0, null, textStyleG, composerK, 48, 0, 65016);
            TextKt.c(StringResources_androidKt.b(R.string.Ng, composerK, 0), SizeKt.h(companion, 0.0f, 1, null), ComposeColorsKt.j(composerK, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(companion3.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).a(), composerK, 48, 0, 65016);
            if (z2) {
                function03 = function02;
                composerK.a0(1935950313);
                String strB2 = StringResources_androidKt.b(R.string.Mg, composerK, 0);
                float fG = Dp.g(40);
                float fG2 = Dp.g(24);
                Integer numValueOf = Integer.valueOf(R.drawable.f95550p0);
                if ((i5 & 112) != 32) {
                    z3 = false;
                }
                Object objG = composerK.G();
                if (z3 || objG == Composer.f23746a.a()) {
                    function04 = function0;
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.v
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ExcludedAppsScreenKt.J(function04);
                        }
                    };
                    composerK.w(objG);
                } else {
                    function04 = function0;
                }
                composer2 = composerK;
                FlatButtonsKt.u(null, fG, fG2, null, null, null, strB2, null, 0L, numValueOf, null, false, false, (Function0) objG, composer2, 432, 384, 3513);
                composer2.U();
            } else {
                composerK.a0(1935555032);
                String strB3 = StringResources_androidKt.b(R.string.JD, composerK, 0);
                float fG3 = Dp.g(40);
                int i6 = R.drawable.s4;
                FlatButtonColors.Premium premium = FlatButtonColors.Premium.f131164a;
                Integer numValueOf2 = Integer.valueOf(i6);
                boolean z4 = (i5 & 896) == 256;
                Object objG2 = composerK.G();
                if (z4 || objG2 == Composer.f23746a.a()) {
                    function03 = function02;
                    objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.u
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ExcludedAppsScreenKt.I(function03);
                        }
                    };
                    composerK.w(objG2);
                } else {
                    function03 = function02;
                }
                composer2 = composerK;
                FlatButtonsKt.u(null, fG3, 0.0f, null, premium, null, strB3, null, 0L, numValueOf2, null, false, false, (Function0) objG2, composer2, 24624, 384, 3501);
                composer2.U();
                function04 = function0;
            }
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function03 = function02;
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.w
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ExcludedAppsScreenKt.K(z2, function04, function03, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(boolean z2, Function0 function0, Function0 function02, int i3, Composer composer, int i4) {
        H(z2, function0, function02, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x00f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void L(final java.util.List r16, final android.content.pm.PackageManager r17, final boolean r18, final kotlin.jvm.functions.Function0 r19, final kotlin.jvm.functions.Function0 r20, final kotlin.jvm.functions.Function1 r21, androidx.compose.runtime.Composer r22, final int r23) {
        /*
            Method dump skipped, instruction units count: 669
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.settings.ExcludedAppsScreenKt.L(java.util.List, android.content.pm.PackageManager, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(List list, PackageManager packageManager, boolean z2, Function0 function0, Function0 function02, Function1 function1, int i3, Composer composer, int i4) {
        L(list, packageManager, z2, function0, function02, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(List list, PackageManager packageManager, boolean z2, Function0 function0, Function0 function02, Function1 function1, int i3, Composer composer, int i4) {
        L(list, packageManager, z2, function0, function02, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(final List list, final SnapshotStateMap snapshotStateMap, final Function1 function1, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final Function1 function12 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.x
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ExcludedAppsScreenKt.P((IgnoredStatisticsItem) obj);
            }
        };
        final ExcludedAppsScreenKt$ExcludedApps$lambda$7$0$$inlined$items$default$1 excludedAppsScreenKt$ExcludedApps$lambda$7$0$$inlined$items$default$1 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.ExcludedAppsScreenKt$ExcludedApps$lambda$7$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(Object obj) {
                return null;
            }
        };
        LazyColumn.h(list.size(), new Function1<Integer, Object>() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.ExcludedAppsScreenKt$ExcludedApps$lambda$7$0$$inlined$items$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i3) {
                return function12.invoke(list.get(i3));
            }
        }, new Function1<Integer, Object>() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.ExcludedAppsScreenKt$ExcludedApps$lambda$7$0$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i3) {
                return excludedAppsScreenKt$ExcludedApps$lambda$7$0$$inlined$items$default$1.invoke(list.get(i3));
            }
        }, ComposableLambdaKt.c(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.ExcludedAppsScreenKt$ExcludedApps$lambda$7$0$$inlined$items$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                return Unit.f139807a;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i3, Composer composer, int i4) {
                int i5;
                if ((i4 & 6) == 0) {
                    i5 = i4 | (composer.Z(lazyItemScope) ? 4 : 2);
                } else {
                    i5 = i4;
                }
                if ((i4 & 48) == 0) {
                    i5 |= composer.e(i3) ? 32 : 16;
                }
                if (!composer.r((i5 & 147) != 146, i5 & 1)) {
                    composer.Q();
                    return;
                }
                if (ComposerKt.M()) {
                    ComposerKt.U(-632812321, i5, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                final IgnoredStatisticsItem ignoredStatisticsItem = (IgnoredStatisticsItem) list.get(i3);
                composer.a0(1655834398);
                ExcludedAppInfo excludedAppInfo = (ExcludedAppInfo) MapsKt.getValue(snapshotStateMap, ignoredStatisticsItem.c());
                Modifier.Companion companion = Modifier.b8;
                float f3 = 24;
                Modifier modifierK = PaddingKt.k(SizeKt.i(SizeKt.h(companion, 0.0f, 1, null), Dp.g(48)), Dp.g(f3), 0.0f, 2, null);
                MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.i(), composer, 48);
                int iA = ComposablesKt.a(composer, 0);
                CompositionLocalMap compositionLocalMapU = composer.u();
                Modifier modifierF = ComposedModifierKt.f(composer, modifierK);
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
                SingletonAsyncImageKt.b(excludedAppInfo.a(), null, SizeKt.v(companion, Dp.g(32)), null, null, PainterResources_androidKt.c(R.drawable.H6, composer, 0), null, null, null, null, null, 0.0f, null, 0, composer, 432, 0, 16344);
                TextKt.c(excludedAppInfo.b(), PaddingKt.m(companion, PrimitiveResources_androidKt.a(R.dimen.f95467a, composer, 0), 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.f29661b.b(), false, 1, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 0, 3120, 55292);
                SpacerKt.a(RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null), composer, 0);
                Modifier modifierV = SizeKt.v(companion, Dp.g(f3));
                boolean Z = composer.Z(function1) | composer.I(ignoredStatisticsItem);
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    final Function1 function13 = function1;
                    objG = new Function0<Unit>() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.ExcludedAppsScreenKt$ExcludedApps$6$1$2$1$1$1
                        public final void c() {
                            function13.invoke(new ExcludedAppsViewEvent.OnRemoveClicked(ignoredStatisticsItem));
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            c();
                            return Unit.f139807a;
                        }
                    };
                    composer.w(objG);
                }
                IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.K4, composer, 6), null, ClickableKt.f(modifierV, false, null, null, (Function0) objG, 7, null), Color.f25715b.k(), composer, 3120, 0);
                composer.y();
                composer.U();
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }
        }));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object P(IgnoredStatisticsItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(List list, PackageManager packageManager, boolean z2, Function0 function0, Function0 function02, Function1 function1, int i3, Composer composer, int i4) {
        L(list, packageManager, z2, function0, function02, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void R(final ExcludedAppsViewState viewState, Function1 onEvent, Function0 function0, Composer composer, final int i3, final int i4) {
        int i5;
        Function1 function1;
        final ExcludedAppsViewState excludedAppsViewState;
        final Function0 function02;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(-723484482);
        if ((i3 & 6) == 0) {
            i5 = (composerK.Z(viewState) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.I(onEvent) ? 32 : 16;
        }
        int i6 = i4 & 4;
        if (i6 != 0) {
            i5 |= 384;
        } else if ((i3 & 384) == 0) {
            i5 |= composerK.I(function0) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i5 & 147) != 146, i5 & 1)) {
            if (i6 != 0) {
                Object objG = composerK.G();
                if (objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.d
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ExcludedAppsScreenKt.S();
                        }
                    };
                    composerK.w(objG);
                }
                function0 = (Function0) objG;
            }
            Function0 function03 = function0;
            if (ComposerKt.M()) {
                ComposerKt.U(-723484482, i5, -1, "cz.mobilesoft.coreblock.scene.insights.settings.ExcludedAppsScreen (ExcludedAppsScreen.kt:73)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Object objG2 = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG2 == companion.a()) {
                objG2 = context.getApplicationContext().getPackageManager();
                composerK.w(objG2);
            }
            PackageManager packageManager = (PackageManager) objG2;
            Intrinsics.checkNotNull(packageManager);
            int i7 = i5 & 14;
            boolean zI = composerK.I(context) | (i7 == 4);
            Object objG3 = composerK.G();
            if (zI || objG3 == companion.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ExcludedAppsScreenKt.T(context, viewState);
                    }
                };
                composerK.w(objG3);
            }
            Function0 function04 = (Function0) objG3;
            boolean zI2 = composerK.I(context);
            Object objG4 = composerK.G();
            if (zI2 || objG4 == companion.a()) {
                objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ExcludedAppsScreenKt.U(context);
                    }
                };
                composerK.w(objG4);
            }
            function1 = onEvent;
            w(viewState, function03, function1, packageManager, function04, (Function0) objG4, composerK, ((i5 >> 3) & 112) | i7 | ((i5 << 3) & 896), 0);
            excludedAppsViewState = viewState;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            function02 = function03;
        } else {
            function1 = onEvent;
            excludedAppsViewState = viewState;
            composerK.Q();
            function02 = function0;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            final Function1 function12 = function1;
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ExcludedAppsScreenKt.V(excludedAppsViewState, function12, function02, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T(Context context, ExcludedAppsViewState excludedAppsViewState) {
        IgnoreListSelectActivity.Companion companion = IgnoreListSelectActivity.f119109g;
        ArrayList arrayList = new ArrayList(Z(excludedAppsViewState.c()));
        List listC = excludedAppsViewState.c();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listC, 10));
        Iterator it = listC.iterator();
        while (it.hasNext()) {
            arrayList2.add(((IgnoredStatisticsItem) it.next()).c());
        }
        context.startActivity(companion.a(context, arrayList, null, new ArrayList(arrayList2)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(Context context) {
        context.startActivity(Paywall.c(Paywall.f113165a, context, new PaywallTarget.LimitScreen(PremiumFeature.STATISTICS), "statistics_tab", "statistics_usage", false, false, false, null, 240, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V(ExcludedAppsViewState excludedAppsViewState, Function1 function1, Function0 function0, int i3, int i4, Composer composer, int i5) {
        R(excludedAppsViewState, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final Application X(String str) {
        return new Application(str, str, str, false, null, 24, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object Y(PackageManager packageManager, List list, Continuation continuation) {
        return BuildersKt.g(Dispatchers.b(), new ExcludedAppsScreenKt$getAppInfos$2(list, packageManager, null), continuation);
    }

    private static final List Z(List list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((IgnoredStatisticsItem) obj).d() == UsageAccess.Type.APPLICATION) {
                arrayList.add(obj);
            }
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i3 = 0;
        int i4 = 0;
        while (i4 < size) {
            Object obj2 = arrayList.get(i4);
            i4++;
            if (hashSet.add(((IgnoredStatisticsItem) obj2).c())) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        int size2 = arrayList2.size();
        while (i3 < size2) {
            Object obj3 = arrayList2.get(i3);
            i3++;
            arrayList3.add(X(((IgnoredStatisticsItem) obj3).c()));
        }
        return arrayList3;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void w(final cz.mobilesoft.coreblock.scene.insights.settings.ExcludedAppsViewState r35, kotlin.jvm.functions.Function0 r36, final kotlin.jvm.functions.Function1 r37, final android.content.pm.PackageManager r38, final kotlin.jvm.functions.Function0 r39, final kotlin.jvm.functions.Function0 r40, androidx.compose.runtime.Composer r41, final int r42, final int r43) {
        /*
            Method dump skipped, instruction units count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.settings.ExcludedAppsScreenKt.w(cz.mobilesoft.coreblock.scene.insights.settings.ExcludedAppsViewState, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, android.content.pm.PackageManager, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(final Function0 function0, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(982006433, i3, -1, "cz.mobilesoft.coreblock.scene.insights.settings.Content.<anonymous> (ExcludedAppsScreen.kt:120)");
            }
            boolean Z = composer.Z(function0);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.m
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ExcludedAppsScreenKt.z(function0);
                    }
                };
                composer.w(objG);
            }
            ToolbarKt.d(null, null, (Function0) objG, composer, 0, 3);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }
}
