package cz.mobilesoft.coreblock.scene.insights;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

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
public final class InsightsScreenDistractionsKt {
    public static final void d(LazyListScope lazyListScope, final InsightsViewState viewState) {
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        LazyListScope.c(lazyListScope, null, null, ComposableSingletons$InsightsScreenDistractionsKt.f102577a.b(), 3, null);
        LazyListScope.c(lazyListScope, null, null, ComposableLambdaKt.c(908674902, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.s4
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return InsightsScreenDistractionsKt.e(viewState, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(InsightsViewState insightsViewState, LazyItemScope item, Composer composer, int i3) {
        String str;
        String str2;
        String lowerCase;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(908674902, i3, -1, "cz.mobilesoft.coreblock.scene.insights.distractions.<anonymous> (InsightsScreenDistractions.kt:47)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierK = PaddingKt.k(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3), 0.0f, 2, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.o(Dp.g(f3)), Alignment.f25072a.l(), composer, 6);
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
            Double dS = insightsViewState.S();
            Double dK0 = insightsViewState.k0();
            if (dS == null) {
                composer.a0(218842178);
                composer.U();
                str = "×";
                str2 = null;
            } else {
                composer.a0(218842179);
                double dDoubleValue = dS.doubleValue();
                Modifier modifierC = RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null);
                Object objG = composer.G();
                if (objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.t4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return InsightsScreenDistractionsKt.f();
                        }
                    };
                    composer.w(objG);
                }
                str = "×";
                str2 = null;
                InsightsScreenComponentsKt.l1(ClickableKt.d(modifierC, null, null, false, null, null, (Function0) objG, 28, null), StringResources_androidKt.b(R.string.GD, composer, 0), MathKt.c(dDoubleValue) + "×", null, StringResources_androidKt.b(R.string.WD, composer, 0), R.drawable.f95567u0, composer, 0, 8);
                composer.U();
            }
            if (dK0 == null) {
                composer.a0(219705311);
            } else {
                composer.a0(219705312);
                double dDoubleValue2 = dK0.doubleValue();
                String str3 = str;
                Modifier modifierC2 = RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null);
                Object objG2 = composer.G();
                if (objG2 == Composer.f23746a.a()) {
                    objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.u4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return InsightsScreenDistractionsKt.g();
                        }
                    };
                    composer.w(objG2);
                }
                Modifier modifierD = ClickableKt.d(modifierC2, null, null, false, null, null, (Function0) objG2, 28, null);
                String strB = StringResources_androidKt.b(R.string.tA, composer, 0);
                String str4 = MathKt.c(dDoubleValue2) + str3;
                int i4 = R.drawable.F2;
                if (dDoubleValue2 > insightsViewState.T()) {
                    composer.a0(1865805381);
                    lowerCase = StringResources_androidKt.b(R.string.Fn, composer, 0).toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    composer.U();
                } else {
                    composer.a0(1865913322);
                    composer.U();
                    lowerCase = str2;
                }
                InsightsScreenComponentsKt.l1(modifierD, strB, str4, lowerCase, StringResources_androidKt.b(R.string.XD, composer, 0), i4, composer, 0, 0);
            }
            composer.U();
            if (dS == null || dK0 == null) {
                composer.a0(220836037);
                BoxKt.a(RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null), composer, 0);
            } else {
                composer.a0(216895720);
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
    public static final Unit f() {
        AnswersHelper.f128199a.q2();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g() {
        AnswersHelper.f128199a.r2();
        return Unit.f139807a;
    }
}
