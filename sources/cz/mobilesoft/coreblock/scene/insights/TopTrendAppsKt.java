package cz.mobilesoft.coreblock.scene.insights;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
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
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.TileMode;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.google.accompanist.drawablepainter.DrawablePainterKt;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelper;
import cz.mobilesoft.coreblock.view.timepicker.ComposeSwipeableTimePickerKt;
import cz.mobilesoft.statistics.model.AppDifference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
public final class TopTrendAppsKt {
    private static final void j(final RowScope rowScope, final Context context, final Drawable drawable, final long j3, int i3, final boolean z2, final Function0 function0, Composer composer, final int i4) {
        int i5;
        Composer composer2;
        float fG;
        final int i6 = i3;
        Composer composerK = composer.k(1011601456);
        if ((i4 & 6) == 0) {
            i5 = (composerK.Z(rowScope) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if ((i4 & 48) == 0) {
            i5 |= composerK.I(context) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i5 |= composerK.I(drawable) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 3072) == 0) {
            i5 |= composerK.f(j3) ? 2048 : 1024;
        }
        if ((i4 & 24576) == 0) {
            i5 |= composerK.e(i6) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i4) == 0) {
            i5 |= composerK.b(z2) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i4) == 0) {
            i5 |= composerK.I(function0) ? 1048576 : 524288;
        }
        if (composerK.r((599187 & i5) != 599186, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1011601456, i5, -1, "cz.mobilesoft.coreblock.scene.insights.AppBox (TopTrendApps.kt:212)");
            }
            float fG2 = i6 != 0 ? i6 != 1 ? Dp.g(120) : Dp.g(ModuleDescriptor.MODULE_VERSION) : Dp.g(FacebookRequestErrorClassification.EC_INVALID_TOKEN);
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierI = SizeKt.i(RowScope.c(rowScope, companion, 1.0f, false, 2, null), fG2);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierI);
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
            Updater.e(composerA, modifierF, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            BoxKt.a(BackgroundKt.b(SizeKt.f(PaddingKt.m(companion, 0.0f, Dp.g(20), 0.0f, 0.0f, 13, null), 0.0f, 1, null), Brush.Companion.c(ComposeColorsKt.j(composerK, 0).n0(), Offset.e((((long) Float.floatToRawIntBits(0.0f)) & 4294967295L) | (((long) Float.floatToRawIntBits(0.0f)) << 32)), Offset.e((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(Float.POSITIVE_INFINITY)) & 4294967295L)), TileMode.f25948b.a()), RoundedCornerShapeKt.d(Dp.g(16)), 0.0f, 4, null), composerK, 0);
            Modifier modifierK0 = ComposeSwipeableTimePickerKt.k0(SizeKt.h(companion, 0.0f, 1, null), false, function0, 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), companion2.g(), composerK, 48);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierK0);
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
            Updater.e(composerA2, modifierF2, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            int i7 = i5;
            ImageKt.a(DrawablePainterKt.e(drawable, composerK, (i5 >> 6) & 14), null, SizeKt.v(companion, Dp.g(40)), null, null, 0.0f, null, composerK, 432, 120);
            if (z2) {
                composerK.a0(-120624743);
                if (i3 != 0) {
                    i6 = i3;
                    fG = i6 != 1 ? Dp.g(24) : Dp.g(30);
                } else {
                    i6 = i3;
                    fG = Dp.g(36);
                }
                ImageKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.C6, composerK, 6), null, SizeKt.v(PaddingKt.k(companion, 0.0f, Dp.g(8), 1, null), fG), null, null, 0.0f, null, composerK, 48, 120);
                composerK.U();
            } else {
                i6 = i3;
                composerK.a0(-120135904);
                l(i6, composerK, (i7 >> 12) & 14);
                composerK.U();
            }
            String str = z2 ? "+" : "-";
            TextKt.c(str + StringHelper.f(context, Math.abs(((long) 1000) * j3)), null, ComposeColorsKt.j(composerK, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).i(), composerK, 0, 0, 65530);
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.i8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TopTrendAppsKt.k(rowScope, context, drawable, j3, i6, z2, function0, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(RowScope rowScope, Context context, Drawable drawable, long j3, int i3, boolean z2, Function0 function0, int i4, Composer composer, int i5) {
        j(rowScope, context, drawable, j3, i3, z2, function0, composer, RecomposeScopeImplKt.a(i4 | 1));
        return Unit.f139807a;
    }

    private static final void l(final int i3, Composer composer, final int i4) {
        int i5;
        TextStyle textStyleE;
        Composer composerK = composer.k(1476310653);
        if ((i4 & 6) == 0) {
            i5 = (composerK.e(i3) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if (composerK.r((i5 & 3) != 2, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1476310653, i5, -1, "cz.mobilesoft.coreblock.scene.insights.Laurels (TopTrendApps.kt:284)");
            }
            float fG = i3 == 0 ? Dp.g(70) : Dp.g(56);
            if (i3 == 0) {
                composerK.a0(1395335231);
                textStyleE = ComposeTypographyKt.g(composerK, 0).e();
                composerK.U();
            } else if (i3 != 1) {
                composerK.a0(1395337171);
                textStyleE = TextStyle.e(ComposeTypographyKt.g(composerK, 0).f(), 0L, TextUnitKt.i(22), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777213, null);
                composerK.U();
            } else {
                composerK.a0(1395336095);
                textStyleE = ComposeTypographyKt.g(composerK, 0).f();
                composerK.U();
            }
            TextStyle textStyle = textStyleE;
            Modifier.Companion companion = Modifier.b8;
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, companion);
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
            Updater.e(composerA, modifierF, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            IconKt.d(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.p3, composerK, 6), null, SizeKt.v(companion, fG), ComposeColorsKt.j(composerK, 0).F(), composerK, 48, 0);
            TextKt.c(String.valueOf(i3 + 1), boxScopeInstance.f(companion, companion2.e()), ComposeColorsKt.j(composerK, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyle, composerK, 0, 0, 65528);
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.j8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TopTrendAppsKt.m(i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(int i3, int i4, Composer composer, int i5) {
        l(i3, composer, RecomposeScopeImplKt.a(i4 | 1));
        return Unit.f139807a;
    }

    private static final void n(final PackageManager packageManager, final Context context, final InsightsViewState insightsViewState, final List list, final boolean z2, Composer composer, final int i3) {
        boolean z3;
        Composer composerK = composer.k(866482816);
        int i4 = (i3 & 6) == 0 ? (composerK.I(packageManager) ? 4 : 2) | i3 : i3;
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(context) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(insightsViewState) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(list) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            z3 = z2;
            i4 |= composerK.b(z3) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            z3 = z2;
        }
        if (composerK.r((i4 & 9363) != 9362, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(866482816, i4, -1, "cz.mobilesoft.coreblock.scene.insights.TrendApps (TopTrendApps.kt:84)");
            }
            List<AppDifference> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (AppDifference appDifference : list2) {
                arrayList.add(TuplesKt.a(insightsViewState.g(packageManager, appDifference.b()).f(), Long.valueOf(appDifference.a())));
            }
            boolean zI = composerK.I(list) | composerK.I(context) | ((i4 & 896) == 256);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.d8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TopTrendAppsKt.o(list, context, insightsViewState, ((Integer) obj).intValue());
                    }
                };
                composerK.w(objG);
            }
            q(context, arrayList, z3, (Function1) objG, composerK, ((i4 >> 3) & 14) | ((i4 >> 6) & 896));
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.e8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TopTrendAppsKt.p(packageManager, context, insightsViewState, list, z2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(List list, Context context, InsightsViewState insightsViewState, int i3) {
        context.startActivity(InsightsActivity.f102590g.a(context, ((AppDifference) list.get(i3)).b(), insightsViewState.a0()));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(PackageManager packageManager, Context context, InsightsViewState insightsViewState, List list, boolean z2, int i3, Composer composer, int i4) {
        n(packageManager, context, insightsViewState, list, z2, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void q(final Context context, final List list, final boolean z2, final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(544625500);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(context) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(list) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.b(z2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function1) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(544625500, i4, -1, "cz.mobilesoft.coreblock.scene.insights.TrendAppsContent (TopTrendApps.kt:106)");
            }
            InsightsScreenHabitsListKt.o(null, null, null, ComposableLambdaKt.e(-595491071, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.f8
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TopTrendAppsKt.r(z2, list, context, function1, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 3072, 7);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.g8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TopTrendAppsKt.t(context, list, z2, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(boolean z2, List list, Context context, final Function1 function1, BoxScope BorderedBox, Composer composer, int i3) {
        long jA;
        Intrinsics.checkNotNullParameter(BorderedBox, "$this$BorderedBox");
        int i4 = (i3 & 6) == 0 ? i3 | (composer.Z(BorderedBox) ? 4 : 2) : i3;
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-595491071, i4, -1, "cz.mobilesoft.coreblock.scene.insights.TrendAppsContent.<anonymous> (TopTrendApps.kt:108)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierV = SizeKt.v(companion, Dp.g(32));
            Alignment.Companion companion2 = Alignment.f25072a;
            Modifier modifierF = BorderedBox.f(modifierV, companion2.n());
            if (z2) {
                composer.a0(-1036261340);
                jA = ComposeColorsKt.j(composer, 0).c0();
            } else {
                composer.a0(-1036260826);
                jA = ComposeColorsKt.j(composer, 0).A();
            }
            composer.U();
            Modifier modifierC = BackgroundKt.c(modifierF, jA, RoundedCornerShapeKt.a(50));
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierC);
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
            Updater.e(composerA, modifierF2, companion3.f());
            IconKt.d(VectorResources_androidKt.b(ImageVector.f26323k, z2 ? R.drawable.C6 : R.drawable.A6, composer, 6), null, BoxScopeInstance.f6642a.f(SizeKt.v(companion, Dp.g(24)), companion2.e()), ComposeColorsKt.j(composer, 0).q0(), composer, 48, 0);
            composer.y();
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), companion2.k(), composer, 0);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer, companion);
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
            Updater.e(composerA2, modifierF3, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            TextKt.c(StringResources_androidKt.b(z2 ? R.string.Ah : R.string.Ch, composer, 0), PaddingKt.m(companion, 0.0f, 0.0f, Dp.g(40), 0.0f, 11, null), ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).g(), composer, 48, 0, 65528);
            SpacerKt.a(SizeKt.i(companion, Dp.g(8)), composer, 6);
            TextKt.c(StringResources_androidKt.b(z2 ? R.string.Bh : R.string.Dh, composer, 0), null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 0, 0, 65530);
            Composer composer2 = composer;
            SpacerKt.a(SizeKt.i(companion, Dp.g(16)), composer2, 6);
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.o(Dp.g(6)), companion2.a(), composer2, 54);
            int iA3 = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU3 = composer2.u();
            Modifier modifierF4 = ComposedModifierKt.f(composer2, modifierH);
            Function0 function0A3 = companion3.a();
            if (composer2.m() == null) {
                ComposablesKt.c();
            }
            composer2.L();
            if (composer2.i()) {
                composer2.P(function0A3);
            } else {
                composer2.v();
            }
            Composer composerA3 = Updater.a(composer2);
            Updater.e(composerA3, measurePolicyB, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF4, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            composer2.a0(-1884257760);
            final int i5 = 0;
            for (Object obj : list) {
                int i6 = i5 + 1;
                if (i5 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Pair pair = (Pair) obj;
                Drawable drawable = (Drawable) pair.e();
                long jLongValue = ((Number) pair.f()).longValue();
                boolean Z = composer2.Z(function1) | composer2.e(i5);
                Object objG = composer2.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.h8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return TopTrendAppsKt.s(function1, i5);
                        }
                    };
                    composer2.w(objG);
                }
                j(rowScopeInstance, context, drawable, jLongValue, i5, z2, (Function0) objG, composer2, 6);
                i5 = i6;
            }
            composer2.U();
            composer2.y();
            if (z2) {
                composer2.a0(-1086102389);
                Modifier.Companion companion4 = Modifier.b8;
                float f3 = 12;
                SpacerKt.a(SizeKt.i(companion4, Dp.g(f3)), composer2, 6);
                Modifier modifierH2 = SizeKt.h(companion4, 0.0f, 1, null);
                Alignment.Companion companion5 = Alignment.f25072a;
                MeasurePolicy measurePolicyG2 = BoxKt.g(companion5.o(), false);
                int iA4 = ComposablesKt.a(composer2, 0);
                CompositionLocalMap compositionLocalMapU4 = composer2.u();
                Modifier modifierF5 = ComposedModifierKt.f(composer2, modifierH2);
                ComposeUiNode.Companion companion6 = ComposeUiNode.f8;
                Function0 function0A4 = companion6.a();
                if (composer2.m() == null) {
                    ComposablesKt.c();
                }
                composer2.L();
                if (composer2.i()) {
                    composer2.P(function0A4);
                } else {
                    composer2.v();
                }
                Composer composerA4 = Updater.a(composer2);
                Updater.e(composerA4, measurePolicyG2, companion6.e());
                Updater.e(composerA4, compositionLocalMapU4, companion6.g());
                Function2 function2B4 = companion6.b();
                if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                    composerA4.w(Integer.valueOf(iA4));
                    composerA4.p(Integer.valueOf(iA4), function2B4);
                }
                Updater.e(composerA4, modifierF5, companion6.f());
                float f4 = 2;
                Modifier modifierJ = PaddingKt.j(BackgroundKt.c(BoxScopeInstance.f6642a.f(companion4, companion5.e()), Color.r(ComposeColorsKt.j(composer2, 0).c0(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.a(50)), Dp.g(4), Dp.g(f4));
                MeasurePolicy measurePolicyB2 = RowKt.b(Arrangement.f6574a.g(), companion5.i(), composer2, 48);
                int iA5 = ComposablesKt.a(composer2, 0);
                CompositionLocalMap compositionLocalMapU5 = composer2.u();
                Modifier modifierF6 = ComposedModifierKt.f(composer2, modifierJ);
                Function0 function0A5 = companion6.a();
                if (composer2.m() == null) {
                    ComposablesKt.c();
                }
                composer2.L();
                if (composer2.i()) {
                    composer2.P(function0A5);
                } else {
                    composer2.v();
                }
                Composer composerA5 = Updater.a(composer2);
                Updater.e(composerA5, measurePolicyB2, companion6.e());
                Updater.e(composerA5, compositionLocalMapU5, companion6.g());
                Function2 function2B5 = companion6.b();
                if (composerA5.i() || !Intrinsics.areEqual(composerA5.G(), Integer.valueOf(iA5))) {
                    composerA5.w(Integer.valueOf(iA5));
                    composerA5.p(Integer.valueOf(iA5), function2B5);
                }
                Updater.e(composerA5, modifierF6, companion6.f());
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.f7101a;
                IconKt.d(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.S6, composer2, 6), null, SizeKt.v(PaddingKt.k(companion4, Dp.g(f4), 0.0f, 2, null), Dp.g(f3)), ComposeColorsKt.j(composer2, 0).c0(), composer2, 432, 0);
                TextKt.c(StringResources_androidKt.b(R.string.Xg, composer2, 0), null, ComposeColorsKt.j(composer2, 0).c0(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, TextStyle.e(ComposeTypographyKt.g(composer2, 0).j(), 0L, TextUnitKt.i(12), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777213, null), composer, 0, 0, 65018);
                composer2 = composer;
                composer2.y();
                composer2.y();
            } else {
                composer2.a0(-1092078569);
            }
            composer2.U();
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(Function1 function1, int i3) {
        function1.invoke(Integer.valueOf(i3));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(Context context, List list, boolean z2, Function1 function1, int i3, Composer composer, int i4) {
        q(context, list, z2, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void u(LazyListScope lazyListScope, final PackageManager packageManager, final Context context, final InsightsViewState viewState) {
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(packageManager, "packageManager");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        final List listM = viewState.m();
        if (listM != null) {
            LazyListScope.c(lazyListScope, null, null, ComposableLambdaKt.c(-1533942721, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.b8
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TopTrendAppsKt.v(packageManager, context, viewState, listM, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 3, null);
        }
        final List listO0 = viewState.o0();
        if (listO0 != null) {
            LazyListScope.c(lazyListScope, null, null, ComposableLambdaKt.c(-1987003992, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.c8
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TopTrendAppsKt.w(packageManager, context, viewState, listO0, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(PackageManager packageManager, Context context, InsightsViewState insightsViewState, List list, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1533942721, i3, -1, "cz.mobilesoft.coreblock.scene.insights.topTrendApps.<anonymous>.<anonymous> (TopTrendApps.kt:54)");
            }
            n(packageManager, context, insightsViewState, list, false, composer, 24576);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(PackageManager packageManager, Context context, InsightsViewState insightsViewState, List list, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1987003992, i3, -1, "cz.mobilesoft.coreblock.scene.insights.topTrendApps.<anonymous>.<anonymous> (TopTrendApps.kt:66)");
            }
            n(packageManager, context, insightsViewState, list, true, composer, 24576);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }
}
