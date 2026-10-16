package cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers;

import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.IconKt;
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
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ComposableSingletons$ExcludedUnsupportedBrowsersActivityKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$ExcludedUnsupportedBrowsersActivityKt f109642a = new ComposableSingletons$ExcludedUnsupportedBrowsersActivityKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f109643b = ComposableLambdaKt.c(-605599396, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ExcludedUnsupportedBrowsersActivityKt.i((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function3 f109644c = ComposableLambdaKt.c(781633208, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers.b
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$ExcludedUnsupportedBrowsersActivityKt.g((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function2 f109645d = ComposableLambdaKt.c(-1859538977, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ExcludedUnsupportedBrowsersActivityKt.h((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(781633208, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers.ComposableSingletons$ExcludedUnsupportedBrowsersActivityKt.lambda$781633208.<anonymous> (ExcludedUnsupportedBrowsersActivity.kt:101)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierF = BorderKt.f(SizeKt.h(PaddingKt.i(companion, Dp.g(f3)), 0.0f, 1, null), Dp.g(1), ComposeColorsKt.j(composer, 0).P(), RoundedCornerShapeKt.d(Dp.g(f3)));
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierF);
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
            Modifier modifierF3 = BoxScopeInstance.f6642a.f(SizeKt.h(companion, 0.0f, 1, null), companion2.h());
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), companion2.i(), composer, 48);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF4 = ComposedModifierKt.f(composer, modifierF3);
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
            Updater.e(composerA2, measurePolicyB, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF4, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            IconKt.a(PainterResources_androidKt.c(R.drawable.N2, composer, 0), null, PaddingKt.i(companion, Dp.g(f3)), ComposeColorsKt.j(composer, 0).b(), composer, 432, 0);
            TextKt.c(StringResources_androidKt.b(R.string.Xd, composer, 0), PaddingKt.m(companion, 0.0f, Dp.g(f3), Dp.g(f3), Dp.g(f3), 1, null), ComposeColorsKt.j(composer, 0).P(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).d(), composer, 0, 0, 65528);
            composer.y();
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
    public static final Unit h(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1859538977, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers.ComposableSingletons$ExcludedUnsupportedBrowsersActivityKt.lambda$-1859538977.<anonymous> (ExcludedUnsupportedBrowsersActivity.kt:157)");
            }
            IconKt.a(PainterResources_androidKt.c(R.drawable.C1, composer, 0), null, null, ComposeColorsKt.j(composer, 0).O(), composer, 48, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-605599396, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers.ComposableSingletons$ExcludedUnsupportedBrowsersActivityKt.lambda$-605599396.<anonymous> (ExcludedUnsupportedBrowsersActivity.kt:71)");
            }
            IconKt.a(PainterResources_androidKt.c(R.drawable.G0, composer, 0), null, null, ComposeColorsKt.j(composer, 0).b(), composer, 48, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    public final Function2 d() {
        return f109645d;
    }

    public final Function2 e() {
        return f109643b;
    }

    public final Function3 f() {
        return f109644c;
    }
}
