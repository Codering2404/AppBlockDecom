package cz.mobilesoft.coreblock.scene.insights;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.storage.room.entity.core.MoodCheckInEntity;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.IconCircleBackgroundKt;
import cz.mobilesoft.coreblock.view.compose.material3.CardsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public final class InsightsScreenMoodCheckInKt {
    public static final void e(Modifier modifier, final MoodCheckInEntity moodCheckInEntity, final Function0 onMoodCheckInCardClicked, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        final Modifier modifier3;
        int i6;
        long jL0;
        long jP;
        Unit unit;
        Intrinsics.checkNotNullParameter(onMoodCheckInCardClicked, "onMoodCheckInCardClicked");
        Composer composerK = composer.k(-2141412731);
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
            i5 |= composerK.Z(moodCheckInEntity) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.I(onMoodCheckInCardClicked) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i5 & 147) != 146, i5 & 1)) {
            Modifier modifier4 = i7 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(-2141412731, i5, -1, "cz.mobilesoft.coreblock.scene.insights.MoodCheckIn (InsightsScreenMoodCheckIn.kt:34)");
            }
            boolean z2 = moodCheckInEntity == null;
            Modifier modifierH = SizeKt.h(modifier4, 0.0f, 1, null);
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion.k(), composerK, 0);
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
            Modifier.Companion companion3 = Modifier.b8;
            SpacerKt.a(SizeKt.i(companion3, Dp.g(24)), composerK, 6);
            Modifier modifierH2 = SizeKt.h(companion3, 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.e(), companion.i(), composerK, 54);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierH2);
            Function0 function0A2 = companion2.a();
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
            Updater.e(composerA2, measurePolicyB, companion2.e());
            Updater.e(composerA2, compositionLocalMapU2, companion2.g());
            Function2 function2B2 = companion2.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            boolean z3 = z2;
            Modifier modifier5 = modifier4;
            TextKt.c(StringResources_androidKt.b(R.string.ek, composerK, 0), null, ComposeColorsKt.j(composerK, 0).p(), 0L, null, FontWeight.f29233b.h(), null, 0L, null, TextAlign.h(TextAlign.f29616b.f()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).h(), composerK, 196608, 0, 64986);
            composerK = composerK;
            int i8 = i5 & 896;
            boolean z4 = i8 == 256;
            Object objG = composerK.G();
            if (z4 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.m6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InsightsScreenMoodCheckInKt.f(onMoodCheckInCardClicked);
                    }
                };
                composerK.w(objG);
            }
            Modifier modifierF3 = ClickableKt.f(companion3, false, null, null, (Function0) objG, 7, null);
            if (z3) {
                composerK.a0(77363569);
                i6 = 0;
                jL0 = ComposeColorsKt.j(composerK, 0).b();
            } else {
                i6 = 0;
                composerK.a0(77364178);
                jL0 = ComposeColorsKt.j(composerK, 0).l0();
            }
            composerK.U();
            float fG = Dp.g(32);
            if (z3) {
                composerK.a0(77367216);
                jP = ComposeColorsKt.j(composerK, i6).q0();
            } else {
                composerK.a0(77367799);
                jP = ComposeColorsKt.j(composerK, i6).p();
            }
            composerK.U();
            IconCircleBackgroundKt.c(modifierF3, fG, 0.0f, VectorResources_androidKt.b(ImageVector.f26323k, z3 ? R.drawable.f95558r0 : R.drawable.V1, composerK, 6), jP, jL0, null, composerK, 48, 68);
            composerK.y();
            if (moodCheckInEntity == null) {
                composerK.a0(-505520970);
                composerK.U();
                unit = null;
            } else {
                composerK.a0(-505520969);
                SpacerKt.a(SizeKt.i(companion3, Dp.g(8)), composerK, 6);
                Modifier modifierH3 = SizeKt.h(companion3, 0.0f, 1, null);
                long jO = Color.o(Color.f25715b.j());
                long jU = ComposeColorsKt.j(composerK, 0).u();
                boolean z5 = i8 == 256;
                Object objG2 = composerK.G();
                if (z5 || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.n6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return InsightsScreenMoodCheckInKt.g(onMoodCheckInCardClicked);
                        }
                    };
                    composerK.w(objG2);
                }
                CardsKt.n(modifierH3, 0.0f, jU, 0.0f, jO, false, null, (Function0) objG2, ComposableLambdaKt.e(1116523610, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.o6
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return InsightsScreenMoodCheckInKt.h(moodCheckInEntity, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerK, 54), composerK, 100663302, 106);
                composerK = composerK;
                Unit unit2 = Unit.f139807a;
                composerK.U();
                unit = Unit.f139807a;
            }
            if (unit == null) {
                composerK.a0(-503979153);
                SpacerKt.a(SizeKt.i(companion3, Dp.g(16)), composerK, 6);
                Unit unit3 = Unit.f139807a;
                composerK.U();
            } else {
                composerK.a0(-986139216);
                composerK.U();
            }
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.p6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsScreenMoodCheckInKt.i(modifier3, moodCheckInEntity, onMoodCheckInCardClicked, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(MoodCheckInEntity moodCheckInEntity, ColumnScope BorderedCard, Composer composer, int i3) {
        int i4;
        String strB;
        Intrinsics.checkNotNullParameter(BorderedCard, "$this$BorderedCard");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1116523610, i3, -1, "cz.mobilesoft.coreblock.scene.insights.MoodCheckIn.<anonymous>.<anonymous>.<anonymous> (InsightsScreenMoodCheckIn.kt:89)");
            }
            Modifier modifierI = PaddingKt.i(SizeKt.h(Modifier.b8, 0.0f, 1, null), Dp.g(16));
            Arrangement arrangement = Arrangement.f6574a;
            float fG = Dp.g(8);
            Alignment.Companion companion = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.q(fG, companion.i()), companion.g(), composer, 54);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierI);
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
            TextKt.c(StringResources_androidKt.b(moodCheckInEntity.d().getNameRes(), composer, 0), null, moodCheckInEntity.d().getColor(composer, 0), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 0, 0, 65530);
            String strF = moodCheckInEntity.f();
            if (strF == null || StringsKt.p0(strF)) {
                composer.a0(1335607286);
                i4 = 0;
                strB = StringResources_androidKt.b(R.string.Zk, composer, 0);
                composer.U();
            } else {
                composer.a0(1335608687);
                composer.U();
                strB = "\"" + moodCheckInEntity.f() + "\"";
                i4 = 0;
            }
            TextKt.c(strB, null, ComposeColorsKt.j(composer, i4).q(), 0L, null, null, null, 0L, null, null, 0L, TextOverflow.f29661b.b(), false, 5, 0, null, ComposeTypographyKt.g(composer, i4).a(), composer, 0, 3120, 55290);
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
    public static final Unit i(Modifier modifier, MoodCheckInEntity moodCheckInEntity, Function0 function0, int i3, int i4, Composer composer, int i5) {
        e(modifier, moodCheckInEntity, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }
}
