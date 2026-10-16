package cz.mobilesoft.coreblock.scene.insights;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material.TextKt;
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
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.insights.InsightsViewState;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.statistics.model.AggregatedItemRecord;
import kotlin.Metadata;
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
public final class ComposableSingletons$InsightsScreenApplicationListKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$InsightsScreenApplicationListKt f102561a = new ComposableSingletons$InsightsScreenApplicationListKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function3 f102562b = ComposableLambdaKt.c(544036975, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.b
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$InsightsScreenApplicationListKt.l((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f102563c = ComposableLambdaKt.c(-105444524, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$InsightsScreenApplicationListKt.p((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function2 f102564d = ComposableLambdaKt.c(-1408270631, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.d
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$InsightsScreenApplicationListKt.t((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Function2 f102565e = ComposableLambdaKt.c(804364659, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.e
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$InsightsScreenApplicationListKt.m((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(RowScope ButtonFlat, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(ButtonFlat, "$this$ButtonFlat");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(544036975, i3, -1, "cz.mobilesoft.coreblock.scene.insights.ComposableSingletons$InsightsScreenApplicationListKt.lambda$544036975.<anonymous> (InsightsScreenApplicationList.kt:285)");
            }
            TextKt.c(StringResources_androidKt.b(R.string.Bg, composer, 0), null, ComposeColorsKt.j(composer, 0).q0(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).i(), composer, 0, 0, 65530);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(804364659, i3, -1, "cz.mobilesoft.coreblock.scene.insights.ComposableSingletons$InsightsScreenApplicationListKt.lambda$804364659.<anonymous> (InsightsScreenApplicationList.kt:634)");
            }
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.i
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$InsightsScreenApplicationListKt.n((LazyListScope) obj);
                    }
                };
                composer.w(objG);
            }
            LazyDslKt.b(null, null, null, false, null, null, null, false, null, (Function1) objG, composer, 805306368, 511);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        InsightsScreenApplicationListKt.J(LazyColumn, new InsightsViewState(null, null, false, null, null, null, InsightsViewState.InsightsPeriodType.Day, 0, null, null, null, 0, null, null, null, null, null, null, null, null, CollectionsKt.listOf(new AggregatedItemRecord(5400, "Instagram", null, null, 1, "Distractive", null, 76, null)), null, 0, null, false, false, null, false, false, null, null, null, null, null, null, null, null, null, false, 0L, false, false, false, null, false, false, false, -1048641, 32767, null), new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ComposableSingletons$InsightsScreenApplicationListKt.o((InsightsViewEvent) obj);
            }
        });
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(InsightsViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-105444524, i3, -1, "cz.mobilesoft.coreblock.scene.insights.ComposableSingletons$InsightsScreenApplicationListKt.lambda$-105444524.<anonymous> (InsightsScreenApplicationList.kt:583)");
            }
            Modifier.Companion companion = Modifier.b8;
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, companion);
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
            AggregatedItemRecord aggregatedItemRecord = new AggregatedItemRecord(300, "", null, null, 1, null, null, 108, null);
            Object objG = composer.G();
            Composer.Companion companion3 = Composer.f23746a;
            if (objG == companion3.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$InsightsScreenApplicationListKt.q();
                    }
                };
                composer.w(objG);
            }
            InsightsScreenApplicationListKt.u("1h 2m", aggregatedItemRecord, null, "com.example.myapplication", null, false, (Function0) objG, composer, 1600518, 36);
            AggregatedItemRecord aggregatedItemRecord2 = new AggregatedItemRecord(300, "", null, null, 1, null, null, 108, null);
            Object objG2 = composer.G();
            if (objG2 == companion3.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.g
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$InsightsScreenApplicationListKt.r();
                    }
                };
                composer.w(objG2);
            }
            InsightsScreenApplicationListKt.u("1h 2m", aggregatedItemRecord2, null, "Google Play Store", null, false, (Function0) objG2, composer, 1600518, 36);
            AggregatedItemRecord aggregatedItemRecord3 = new AggregatedItemRecord(300, "", null, null, 1, null, null, 108, null);
            Object objG3 = composer.G();
            if (objG3 == companion3.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.h
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$InsightsScreenApplicationListKt.s();
                    }
                };
                composer.w(objG3);
            }
            InsightsScreenApplicationListKt.u("1h 2m", aggregatedItemRecord3, null, "App", null, false, (Function0) objG3, composer, 1600518, 36);
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
    public static final Unit q() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1408270631, i3, -1, "cz.mobilesoft.coreblock.scene.insights.ComposableSingletons$InsightsScreenApplicationListKt.lambda$-1408270631.<anonymous> (InsightsScreenApplicationList.kt:626)");
            }
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$InsightsScreenApplicationListKt.u((InsightsViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            InsightsScreenApplicationListKt.F((Function1) objG, composer, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(InsightsViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    public final Function3 k() {
        return f102562b;
    }
}
