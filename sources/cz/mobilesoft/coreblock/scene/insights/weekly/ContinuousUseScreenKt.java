package cz.mobilesoft.coreblock.scene.insights.weekly;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.view.compose.CardType;
import cz.mobilesoft.coreblock.view.compose.ComposeCardsKt;
import cz.mobilesoft.statistics.model.RecordDuration;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ContinuousUseScreenKt {
    public static final void f(final WeeklyInsightsViewState viewState, final Function1 onTap, final Function2 onNewScheduleClicked, Composer composer, final int i3) {
        int i4;
        final Function1 function1;
        final Function2 function2;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onTap, "onTap");
        Intrinsics.checkNotNullParameter(onNewScheduleClicked, "onNewScheduleClicked");
        Composer composerK = composer.k(-1965196256);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(viewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onTap) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onNewScheduleClicked) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1965196256, i4, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.ContinuousUseScreen (ContinuousUseScreen.kt:35)");
            }
            RecordDuration recordDurationQ = viewState.q();
            if (recordDurationQ == null) {
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                ScopeUpdateScope scopeUpdateScopeN = composerK.n();
                if (scopeUpdateScopeN != null) {
                    scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.b0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ContinuousUseScreenKt.g(viewState, onTap, onNewScheduleClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = context.getApplicationContext().getPackageManager();
                composerK.w(objG);
            }
            PackageManager packageManager = (PackageManager) objG;
            boolean Z = composerK.Z(recordDurationQ.a());
            Object objG2 = composerK.G();
            if (Z || objG2 == companion.a()) {
                Intrinsics.checkNotNull(packageManager);
                objG2 = viewState.d(packageManager, recordDurationQ.a());
                composerK.w(objG2);
            }
            Pair pair = (Pair) objG2;
            function1 = onTap;
            function2 = onNewScheduleClicked;
            i((Drawable) pair.f(), recordDurationQ.c(), (String) pair.e(), recordDurationQ.a(), viewState.h(), function1, function2, composerK, (i4 << 12) & 4128768);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function1 = onTap;
            function2 = onNewScheduleClicked;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN2 = composerK.n();
        if (scopeUpdateScopeN2 != null) {
            scopeUpdateScopeN2.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.c0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ContinuousUseScreenKt.h(viewState, function1, function2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(WeeklyInsightsViewState weeklyInsightsViewState, Function1 function1, Function2 function2, int i3, Composer composer, int i4) {
        f(weeklyInsightsViewState, function1, function2, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(WeeklyInsightsViewState weeklyInsightsViewState, Function1 function1, Function2 function2, int i3, Composer composer, int i4) {
        f(weeklyInsightsViewState, function1, function2, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void i(final Drawable drawable, final long j3, final String appName, final String packageName, final boolean z2, final Function1 onTap, final Function2 onNewScheduleClicked, Composer composer, final int i3) {
        final Drawable drawable2;
        int i4;
        boolean z3;
        Composer composer2;
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(onTap, "onTap");
        Intrinsics.checkNotNullParameter(onNewScheduleClicked, "onNewScheduleClicked");
        Composer composerK = composer.k(1662602877);
        if ((i3 & 6) == 0) {
            drawable2 = drawable;
            i4 = (composerK.I(drawable2) ? 4 : 2) | i3;
        } else {
            drawable2 = drawable;
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.f(j3) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(appName) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.Z(packageName) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            z3 = z2;
            i4 |= composerK.b(z3) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            z3 = z2;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.I(onTap) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerK.I(onNewScheduleClicked) ? 1048576 : 524288;
        }
        int i5 = i4;
        if (composerK.r((599187 & i5) != 599186, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1662602877, i5, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.ContinuousUseScreenContent (ContinuousUseScreen.kt:61)");
            }
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            String strB = StringResources_androidKt.b(R.string.r8, composerK, 0);
            int i6 = R.string.Gh;
            String lowerCase = StringResources_androidKt.b(R.string.Qj, composerK, 0).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            AnnotatedString annotatedStringJ = StringHelperExtKt.j(context, i6, ComposeColorsKt.j(composerK, 0).b(), new String[]{appName, (j3 / ((long) 60)) + " " + lowerCase});
            final boolean z4 = z3;
            composer2 = composerK;
            ComponentsKt.k(strB, annotatedStringJ, false, onTap, ComposableLambdaKt.e(-1513649769, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.d0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ContinuousUseScreenKt.j(drawable2, appName, z4, onNewScheduleClicked, packageName, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, ((i5 >> 6) & 7168) | 24576, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.e0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ContinuousUseScreenKt.l(drawable, j3, appName, packageName, z2, onTap, onNewScheduleClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Drawable drawable, final String str, boolean z2, final Function2 function2, final String str2, ColumnScope BaseWeeklyInsightsScreen, Composer composer, int i3) {
        int i4;
        Composer composer2;
        Intrinsics.checkNotNullParameter(BaseWeeklyInsightsScreen, "$this$BaseWeeklyInsightsScreen");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(BaseWeeklyInsightsScreen) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1513649769, i4, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.ContinuousUseScreenContent.<anonymous> (ContinuousUseScreen.kt:77)");
            }
            Modifier.Companion companion = Modifier.b8;
            SpacerKt.a(ColumnScope.b(BaseWeeklyInsightsScreen, companion, 1.0f, false, 2, null), composer, 0);
            ComponentsKt.g(drawable, 0.0f, 0.0f, null, null, composer, 0, 30);
            float f3 = 12;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            TextKt.c(str, null, 0L, 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, TextStyle.e(ComposeTypographyKt.g(composer, 0).e(), 0L, TextUnitKt.i(48), FontWeight.f29233b.h(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777209, null), composer, 0, 0, 65022);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            SpacerKt.a(ColumnScope.b(BaseWeeklyInsightsScreen, companion, 1.0f, false, 2, null), composer, 0);
            if (z2) {
                composer.a0(-278072177);
                ComponentsKt.o(StringResources_androidKt.b(R.string.Uv, composer, 0), composer, 0);
                SpacerKt.a(SizeKt.i(companion, Dp.g(26)), composer, 6);
                CardType.Custom custom = new CardType.Custom(ComposeColorsKt.j(composer, 0).e(), Color.n(ComposeColorsKt.j(composer, 0).F()), null, Dp.d(Dp.g(1)), 4, null);
                Modifier modifierK = SizeKt.k(companion, Dp.g(120), 0.0f, 2, null);
                boolean Z = composer.Z(function2) | composer.Z(str) | composer.Z(str2);
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.f0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ContinuousUseScreenKt.k(function2, str, str2);
                        }
                    };
                    composer.w(objG);
                }
                composer2 = composer;
                ComposeCardsKt.m(modifierK, custom, (Function0) objG, ComposableSingletons$ContinuousUseScreenKt.f103870a.b(), composer2, 3078, 0);
            } else {
                composer2 = composer;
                composer2.a0(-281677973);
            }
            composer2.U();
            SpacerKt.a(SizeKt.i(companion, Dp.g(44)), composer2, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(Function2 function2, String str, String str2) {
        function2.invoke(str, str2);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(Drawable drawable, long j3, String str, String str2, boolean z2, Function1 function1, Function2 function2, int i3, Composer composer, int i4) {
        i(drawable, j3, str, str2, z2, function1, function2, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
