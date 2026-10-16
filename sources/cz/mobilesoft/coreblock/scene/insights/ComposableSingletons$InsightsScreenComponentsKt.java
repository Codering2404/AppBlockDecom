package cz.mobilesoft.coreblock.scene.insights;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.AppDistractionType;
import cz.mobilesoft.coreblock.enums.MoodType;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
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
public final class ComposableSingletons$InsightsScreenComponentsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$InsightsScreenComponentsKt f102566a = new ComposableSingletons$InsightsScreenComponentsKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function3 f102567b = ComposableLambdaKt.c(-2245398, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.l
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$InsightsScreenComponentsKt.y((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function3 f102568c = ComposableLambdaKt.c(-444635213, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.o
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$InsightsScreenComponentsKt.B((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function3 f102569d = ComposableLambdaKt.c(20491099, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.p
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$InsightsScreenComponentsKt.r((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Function2 f102570e = ComposableLambdaKt.c(564464334, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.q
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$InsightsScreenComponentsKt.s((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Function2 f102571f = ComposableLambdaKt.c(-316078972, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.r
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$InsightsScreenComponentsKt.A((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Function2 f102572g = ComposableLambdaKt.c(-1589122934, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.s
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$InsightsScreenComponentsKt.w((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Function2 f102573h = ComposableLambdaKt.c(659380093, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.t
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$InsightsScreenComponentsKt.t((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Function2 f102574i = ComposableLambdaKt.c(1282181748, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.u
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$InsightsScreenComponentsKt.q((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static Function2 f102575j = ComposableLambdaKt.c(-274936716, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.v
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$InsightsScreenComponentsKt.z((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static Function2 f102576k = ComposableLambdaKt.c(-1179614935, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.w
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$InsightsScreenComponentsKt.v((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-316078972, i3, -1, "cz.mobilesoft.coreblock.scene.insights.ComposableSingletons$InsightsScreenComponentsKt.lambda$-316078972.<anonymous> (InsightsScreenComponents.kt:1585)");
            }
            Modifier modifierA = SizeKt.A(Modifier.b8, Dp.g(164));
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.l(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierA);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
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
            Updater.e(composerA, measurePolicyB, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            String strB = StringResources_androidKt.b(R.string.Cj, composer, 0);
            int i4 = R.drawable.i4;
            String lowerCase = StringResources_androidKt.b(R.string.Fn, composer, 0).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            InsightsScreenComponentsKt.l1(null, strB, "1h 18m", lowerCase, null, i4, composer, 384, 17);
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
    public static final Unit B(LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-444635213, i3, -1, "cz.mobilesoft.coreblock.scene.insights.ComposableSingletons$InsightsScreenComponentsKt.lambda$-444635213.<anonymous> (InsightsScreenComponents.kt:675)");
            }
            SpacerKt.a(SizeKt.i(Modifier.b8, Dp.g(16)), composer, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1282181748, i3, -1, "cz.mobilesoft.coreblock.scene.insights.ComposableSingletons$InsightsScreenComponentsKt.lambda$1282181748.<anonymous> (InsightsScreenComponents.kt:1664)");
            }
            InsightsScreenComponentsKt.G2(null, true, 0.0f, 0.0f, composer, 48, 13);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(20491099, i3, -1, "cz.mobilesoft.coreblock.scene.insights.ComposableSingletons$InsightsScreenComponentsKt.lambda$20491099.<anonymous> (InsightsScreenComponents.kt:685)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            Modifier modifierH = SizeKt.h(PaddingKt.k(companion, Dp.g(f3), 0.0f, 2, null), 0.0f, 1, null);
            Arrangement arrangement = Arrangement.f6574a;
            float fG = Dp.g(8);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.p(fG, companion2.k()), companion2.a(), composer, 54);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierH);
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
            Updater.e(composerA, measurePolicyB, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            String strB = StringResources_androidKt.b(R.string.f95772b1, composer, 0);
            TextStyle textStyleH = ComposeTypographyKt.g(composer, 0).h();
            TextAlign.Companion companion4 = TextAlign.f29616b;
            TextKt.c(strB, null, 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, textStyleH, composer, 0, 0, 65022);
            TextKt.c(StringResources_androidKt.b(R.string.Tg, composer, 0), null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 0, 0, 65018);
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
    public static final Unit s(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(564464334, i3, -1, "cz.mobilesoft.coreblock.scene.insights.ComposableSingletons$InsightsScreenComponentsKt.lambda$564464334.<anonymous> (InsightsScreenComponents.kt:1097)");
            }
            TextKt.c(StringResources_androidKt.b(R.string.hk, composer, 0), null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 0, 0, 65530);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(Composer composer, int i3) throws XmlPullParserException, IOException {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(659380093, i3, -1, "cz.mobilesoft.coreblock.scene.insights.ComposableSingletons$InsightsScreenComponentsKt.lambda$659380093.<anonymous> (InsightsScreenComponents.kt:1644)");
            }
            float f3 = 16;
            Modifier modifierH = SizeKt.h(PaddingKt.k(Modifier.b8, Dp.g(f3), 0.0f, 2, null), 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.o(Dp.g(f3)), Alignment.f25072a.l(), composer, 6);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierH);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
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
            Updater.e(composerA, measurePolicyB, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            composer.a0(-1381903975);
            Iterator<AppDistractionType> it = AppDistractionType.getEntries().iterator();
            while (it.hasNext()) {
                AppDistractionType next = it.next();
                boolean z2 = next == AppDistractionType.Neutral;
                Object objG = composer.G();
                if (objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.n
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ComposableSingletons$InsightsScreenComponentsKt.u();
                        }
                    };
                    composer.w(objG);
                }
                InsightsScreenComponentsKt.P0(rowScopeInstance, z2, next, (Function0) objG, composer, 3078);
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
    public static final Unit u() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1179614935, i3, -1, "cz.mobilesoft.coreblock.scene.insights.ComposableSingletons$InsightsScreenComponentsKt.lambda$-1179614935.<anonymous> (InsightsScreenComponents.kt:1849)");
            }
            Modifier modifierI = PaddingKt.i(Modifier.b8, Dp.g(16));
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierI);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
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
            Updater.e(composerA, measurePolicyG, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Object objG = composer.G();
            Composer.Companion companion2 = Composer.f23746a;
            if (objG == companion2.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(MoodType.Neutral, null, 2, null);
                composer.w(objG);
            }
            MutableState mutableState = (MutableState) objG;
            Object objG2 = composer.G();
            if (objG2 == companion2.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(0, null, 2, null);
                composer.w(objG2);
            }
            InsightsScreenComponentsKt.j2(mutableState, (MutableState) objG2, null, null, composer, 54, 12);
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
    public static final Unit w(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1589122934, i3, -1, "cz.mobilesoft.coreblock.scene.insights.ComposableSingletons$InsightsScreenComponentsKt.lambda$-1589122934.<anonymous> (InsightsScreenComponents.kt:1603)");
            }
            PackageManager packageManager = ((Context) composer.q(AndroidCompositionLocals_androidKt.g())).getApplicationContext().getPackageManager();
            Intrinsics.checkNotNullExpressionValue(packageManager, "getPackageManager(...)");
            InsightsViewState insightsViewState = new InsightsViewState(null, null, false, null, null, null, null, 0, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, null, false, false, null, false, false, null, null, null, null, null, null, null, null, null, false, 0L, false, false, false, null, false, false, false, -1, 32767, null);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.m
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$InsightsScreenComponentsKt.x((InsightsViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            InsightsScreenToolbarsKt.w(packageManager, insightsViewState, (Function1) objG, composer, 384);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(InsightsViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2245398, i3, -1, "cz.mobilesoft.coreblock.scene.insights.ComposableSingletons$InsightsScreenComponentsKt.lambda$-2245398.<anonymous> (InsightsScreenComponents.kt:575)");
            }
            TextKt.c(StringResources_androidKt.b(R.string.sA, composer, 0), SizeKt.h(PaddingKt.m(PaddingKt.k(Modifier.b8, Dp.g(16), 0.0f, 2, null), 0.0f, Dp.g(32), 0.0f, 0.0f, 13, null), 0.0f, 1, null), ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 48, 0, 65016);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-274936716, i3, -1, "cz.mobilesoft.coreblock.scene.insights.ComposableSingletons$InsightsScreenComponentsKt.lambda$-274936716.<anonymous> (InsightsScreenComponents.kt:1674)");
            }
            InsightsScreenComponentsKt.E2(true, 3890L, "Daily average screen time", composer, 438);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    public final Function3 m() {
        return f102567b;
    }

    public final Function3 n() {
        return f102568c;
    }

    public final Function3 o() {
        return f102569d;
    }

    public final Function2 p() {
        return f102570e;
    }
}
