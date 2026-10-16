package cz.mobilesoft.coreblock.scene.insights;

import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.TextKt;
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
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorMatrix;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import coil.compose.SingletonAsyncImageKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.dto.AppSessions;
import cz.mobilesoft.coreblock.dto.InsightsBlockingSessions;
import cz.mobilesoft.coreblock.enums.AppDistractionType;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
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
public final class InsightsScreenBlockSessionsKt {
    private static final void f(final InsightsBlockingSessions insightsBlockingSessions, final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-1474881434);
        if ((i3 & 6) == 0) {
            i4 = ((i3 & 8) == 0 ? composerK.Z(insightsBlockingSessions) : composerK.I(insightsBlockingSessions) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1474881434, i4, -1, "cz.mobilesoft.coreblock.scene.insights.BlockSessionsContent (InsightsScreenBlockSessions.kt:77)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 8;
            Modifier modifierI = PaddingKt.i(BorderKt.f(SizeKt.h(PaddingKt.k(companion, Dp.g(16), 0.0f, 2, null), 0.0f, 1, null), Dp.g(1), ComposeColorsKt.j(composerK, 0).F(), RoundedCornerShapeKt.a(50)), Dp.g(f3));
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
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            Alignment.Vertical verticalI = companion2.i();
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), verticalI, composerK, 48);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierH);
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
            Updater.e(composerA2, measurePolicyB, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            Modifier modifierC = RowScope.c(RowScopeInstance.f7101a, PaddingKt.m(companion, Dp.g(f3), 0.0f, 0.0f, 0.0f, 14, null), 1.0f, false, 2, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), companion2.k(), composerK, 0);
            int iA3 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU3 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierC);
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
            Updater.e(composerA3, measurePolicyA, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            int i5 = i4;
            TextKt.c(StringResources_androidKt.b(R.string.uc, composerK, 0), null, ComposeColorsKt.j(composerK, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).i(), composerK, 0, 0, 65530);
            TextKt.c(StringResources_androidKt.b(R.string.G3, composerK, 0), null, ComposeColorsKt.j(composerK, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.e(ComposeTypographyKt.g(composerK, 0).j(), 0L, TextUnitKt.i(11), FontWeight.f29233b.g(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777209, null), composerK, 0, 0, 65530);
            composerK = composerK;
            composerK.y();
            h(insightsBlockingSessions, function1, composerK, InsightsBlockingSessions.f96930c | (i5 & 14) | (i5 & 112));
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.f1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsScreenBlockSessionsKt.g(insightsBlockingSessions, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(InsightsBlockingSessions insightsBlockingSessions, Function1 function1, int i3, Composer composer, int i4) {
        f(insightsBlockingSessions, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void h(final InsightsBlockingSessions insightsBlockingSessions, final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-923037748);
        if ((i3 & 6) == 0) {
            i4 = ((i3 & 8) == 0 ? composerK.Z(insightsBlockingSessions) : composerK.I(insightsBlockingSessions) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-923037748, i4, -1, "cz.mobilesoft.coreblock.scene.insights.DistractionBox (InsightsScreenBlockSessions.kt:124)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierB = IntrinsicKt.b(SizeKt.i(companion, Dp.g(40)), IntrinsicSize.f6986a);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
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
            Updater.e(composerA, measurePolicyG, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            float f3 = 8;
            Modifier modifierF2 = boxScopeInstance.f(PaddingKt.k(companion, Dp.g(f3), 0.0f, 2, null), companion2.e());
            Alignment.Vertical verticalI = companion2.i();
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), verticalI, composerK, 48);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierF2);
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
            Updater.e(composerA2, measurePolicyB, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF3, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            float f4 = 20;
            Modifier modifierA = AlphaKt.a(SizeKt.v(companion, Dp.g(f4)), 0.0f);
            int i5 = R.drawable.f95563t;
            IconKt.a(PainterResources_androidKt.c(i5, composerK, 0), null, modifierA, ComposeColorsKt.j(composerK, 0).q0(), composerK, 432, 0);
            TextKt.c(String.valueOf(insightsBlockingSessions.b()), AlphaKt.a(companion, 0.0f), ComposeColorsKt.j(composerK, 0).q0(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).i(), composerK, 48, 0, 65528);
            int i6 = i4 << 3;
            j(null, insightsBlockingSessions, function1, composerK, (i6 & 896) | (InsightsBlockingSessions.f96930c << 3) | (i6 & 112), 1);
            composerK.y();
            Modifier modifierA2 = ClipKt.a(SizeKt.f(companion, 0.0f, 1, null), RoundedCornerShapeKt.a(50));
            Brush.Companion companion4 = Brush.Companion;
            AppDistractionType appDistractionType = AppDistractionType.Productive;
            Color colorN = Color.n(Color.o(appDistractionType.m1357getColor0d7_KjU()));
            AppDistractionType appDistractionType2 = AppDistractionType.Neutral;
            Color colorN2 = Color.n(Color.o(Color.r(appDistractionType2.m1357getColor0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null)));
            AppDistractionType appDistractionType3 = AppDistractionType.Distractive;
            BoxKt.a(BorderKt.h(BackgroundKt.b(modifierA2, Brush.Companion.b(companion4, CollectionsKt.listOf((Object[]) new Color[]{colorN, colorN2, Color.n(Color.o(Color.r(appDistractionType3.m1357getColor0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null)))}), 0.0f, 0.0f, 0, 14, null), null, 0.0f, 6, null), Dp.g(1), Brush.Companion.b(companion4, CollectionsKt.listOf((Object[]) new Color[]{Color.n(Color.o(appDistractionType.m1357getColor0d7_KjU())), Color.n(Color.o(appDistractionType2.m1357getColor0d7_KjU())), Color.n(Color.o(appDistractionType3.m1357getColor0d7_KjU()))}), 0.0f, 0.0f, 0, 14, null), RoundedCornerShapeKt.a(50)), composerK, 0);
            Modifier modifierF4 = boxScopeInstance.f(PaddingKt.k(companion, Dp.g(f3), 0.0f, 2, null), companion2.h());
            MeasurePolicy measurePolicyB2 = RowKt.b(arrangement.g(), companion2.i(), composerK, 48);
            int iA3 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU3 = composerK.u();
            Modifier modifierF5 = ComposedModifierKt.f(composerK, modifierF4);
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
            Updater.e(composerA3, measurePolicyB2, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF5, companion3.f());
            IconKt.a(PainterResources_androidKt.c(i5, composerK, 0), null, SizeKt.v(companion, Dp.g(f4)), ComposeColorsKt.j(composerK, 0).q0(), composerK, 432, 0);
            TextKt.c(String.valueOf(insightsBlockingSessions.b()), null, ComposeColorsKt.j(composerK, 0).q0(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).i(), composerK, 0, 0, 65530);
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.g1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsScreenBlockSessionsKt.i(insightsBlockingSessions, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(InsightsBlockingSessions insightsBlockingSessions, Function1 function1, int i3, Composer composer, int i4) {
        h(insightsBlockingSessions, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v6 */
    private static final void j(Modifier modifier, final InsightsBlockingSessions insightsBlockingSessions, final Function1 function1, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        final Modifier modifier3;
        Composer composerK = composer.k(-228332357);
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
            i5 |= (i3 & 64) == 0 ? composerK.Z(insightsBlockingSessions) : composerK.I(insightsBlockingSessions) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.I(function1) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        ?? r9 = 0;
        int i7 = 1;
        if (composerK.r((i5 & 147) != 146, i5 & 1)) {
            Modifier modifier4 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(-228332357, i5, -1, "cz.mobilesoft.coreblock.scene.insights.IconRow (InsightsScreenBlockSessions.kt:221)");
            }
            Modifier modifierM = PaddingKt.m(modifier4, Dp.g(12), 0.0f, 0.0f, 0.0f, 14, null);
            modifier3 = modifier4;
            Arrangement arrangement = Arrangement.f6574a;
            float fG = Dp.g(-8);
            Alignment.Companion companion = Alignment.f25072a;
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.p(fG, companion.j()), companion.l(), composerK, 6);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierM);
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
            ColorFilter.Companion companion3 = ColorFilter.f25730b;
            float[] fArrC = ColorMatrix.c(null, 1, null);
            ColorMatrix.f(fArrC, 0.0f);
            ColorFilter colorFilterA = companion3.a(fArrC);
            composerK.a0(1341070395);
            Iterator it = insightsBlockingSessions.a().iterator();
            int i8 = 0;
            while (it.hasNext()) {
                Object next = it.next();
                int i9 = i8 + 1;
                if (i8 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                AppSessions appSessions = (AppSessions) next;
                boolean Z = composerK.Z(appSessions.a());
                Object objG = composerK.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = (Pair) function1.invoke(appSessions.a());
                    composerK.w(objG);
                }
                Drawable drawable = (Drawable) ((Pair) objG).b();
                Modifier.Companion companion4 = Modifier.b8;
                float f3 = i7;
                Modifier modifierF2 = BorderKt.f(ClipKt.a(ZIndexModifierKt.a(SizeKt.v(PaddingKt.i(companion4, Dp.g(f3)), Dp.g(24)), -i8), RoundedCornerShapeKt.a(50)), Dp.g(f3), ComposeColorsKt.j(composerK, r9).e(), RoundedCornerShapeKt.a(50));
                MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), r9);
                int iA2 = ComposablesKt.a(composerK, r9);
                CompositionLocalMap compositionLocalMapU2 = composerK.u();
                Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierF2);
                ComposeUiNode.Companion companion5 = ComposeUiNode.f8;
                Function0 function0A2 = companion5.a();
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
                Iterator it2 = it;
                Updater.e(composerA2, measurePolicyG, companion5.e());
                Updater.e(composerA2, compositionLocalMapU2, companion5.g());
                Function2 function2B2 = companion5.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                    composerA2.w(Integer.valueOf(iA2));
                    composerA2.p(Integer.valueOf(iA2), function2B2);
                }
                Updater.e(composerA2, modifierF3, companion5.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                SingletonAsyncImageKt.a(drawable, null, SizeKt.f(PaddingKt.i(companion4, Dp.g(f3)), 0.0f, 1, null), null, null, null, null, 0.0f, colorFilterA, 0, composerK, 432, 760);
                composerK.y();
                i7 = 1;
                i8 = i9;
                it = it2;
                r9 = 0;
            }
            composerK.U();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.h1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsScreenBlockSessionsKt.k(modifier3, insightsBlockingSessions, function1, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(Modifier modifier, InsightsBlockingSessions insightsBlockingSessions, Function1 function1, int i3, int i4, Composer composer, int i5) {
        j(modifier, insightsBlockingSessions, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void l(LazyListScope lazyListScope, final PackageManager packageManager, final InsightsViewState viewState) {
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(packageManager, "packageManager");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        final InsightsBlockingSessions insightsBlockingSessionsN = viewState.n();
        if (insightsBlockingSessionsN == null || insightsBlockingSessionsN.a().isEmpty()) {
            return;
        }
        LazyListScope.c(lazyListScope, null, null, ComposableLambdaKt.c(504302692, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.d1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return InsightsScreenBlockSessionsKt.m(insightsBlockingSessionsN, viewState, packageManager, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(InsightsBlockingSessions insightsBlockingSessions, final InsightsViewState insightsViewState, final PackageManager packageManager, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(504302692, i3, -1, "cz.mobilesoft.coreblock.scene.insights.blockSessions.<anonymous> (InsightsScreenBlockSessions.kt:60)");
            }
            SpacerKt.a(SizeKt.i(Modifier.b8, Dp.g(8)), composer, 6);
            boolean Z = composer.Z(insightsViewState) | composer.I(packageManager);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.e1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return InsightsScreenBlockSessionsKt.n(insightsViewState, packageManager, (String) obj);
                    }
                };
                composer.w(objG);
            }
            f(insightsBlockingSessions, (Function1) objG, composer, InsightsBlockingSessions.f96930c);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair n(InsightsViewState insightsViewState, PackageManager packageManager, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return insightsViewState.g(packageManager, it);
    }
}
