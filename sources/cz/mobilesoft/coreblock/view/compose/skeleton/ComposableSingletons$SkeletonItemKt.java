package cz.mobilesoft.coreblock.view.compose.skeleton;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.view.compose.skeleton.ComposableSingletons$SkeletonItemKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
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
public final class ComposableSingletons$SkeletonItemKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$SkeletonItemKt f131940a = new ComposableSingletons$SkeletonItemKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f131941b = ComposableLambdaKt.c(-1396087029, false, new Function2() { // from class: j2.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SkeletonItemKt.i((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f131942c = ComposableLambdaKt.c(615608267, false, new Function2() { // from class: j2.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SkeletonItemKt.h((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function2 f131943d = ComposableLambdaKt.c(-2023186072, false, new Function2() { // from class: j2.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SkeletonItemKt.j((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Function2 f131944e = ComposableLambdaKt.c(-775511239, false, new Function2() { // from class: j2.d
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SkeletonItemKt.l((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Function2 f131945f = ComposableLambdaKt.c(1045032460, false, new Function2() { // from class: j2.e
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SkeletonItemKt.g((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Function2 f131946g = ComposableLambdaKt.c(-657092621, false, new Function2() { // from class: j2.f
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SkeletonItemKt.k((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1045032460, i3, -1, "cz.mobilesoft.coreblock.view.compose.skeleton.ComposableSingletons$SkeletonItemKt.lambda$1045032460.<anonymous> (SkeletonItem.kt:222)");
            }
            SkeletonItemKt.k(0.0f, PaddingKt.i(Modifier.b8, Dp.g(16)), true, true, 0L, null, composer, 3504, 49);
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
                ComposerKt.U(615608267, i3, -1, "cz.mobilesoft.coreblock.view.compose.skeleton.ComposableSingletons$SkeletonItemKt.lambda$615608267.<anonymous> (SkeletonItem.kt:198)");
            }
            SkeletonItemKt.g(Dp.g(120), PaddingKt.i(Modifier.b8, Dp.g(16)), null, 0L, null, composer, 54, 28);
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
                ComposerKt.U(-1396087029, i3, -1, "cz.mobilesoft.coreblock.view.compose.skeleton.ComposableSingletons$SkeletonItemKt.lambda$-1396087029.<anonymous> (SkeletonItem.kt:190)");
            }
            SkeletonItemKt.i(Dp.g(48), null, 0L, null, composer, 6, 14);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2023186072, i3, -1, "cz.mobilesoft.coreblock.view.compose.skeleton.ComposableSingletons$SkeletonItemKt.lambda$-2023186072.<anonymous> (SkeletonItem.kt:206)");
            }
            SkeletonItemKt.o(0.6f, PaddingKt.i(Modifier.b8, Dp.g(16)), null, 0L, null, composer, 54, 28);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-657092621, i3, -1, "cz.mobilesoft.coreblock.view.compose.skeleton.ComposableSingletons$SkeletonItemKt.lambda$-657092621.<anonymous> (SkeletonItem.kt:234)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierI = PaddingKt.i(companion, Dp.g(f3));
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
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
            SkeletonItemKt.i(Dp.g(48), null, 0L, null, composer, 6, 14);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            SkeletonItemKt.g(Dp.g(100), null, null, 0L, null, composer, 6, 30);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            SkeletonItemKt.o(0.7f, null, null, 0L, null, composer, 6, 30);
            SpacerKt.a(SizeKt.i(companion, Dp.g(8)), composer, 6);
            SkeletonItemKt.o(0.5f, null, null, 0L, null, composer, 6, 30);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            SkeletonItemKt.k(0.0f, null, true, false, 0L, null, composer, 384, 59);
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
    public static final Unit l(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-775511239, i3, -1, "cz.mobilesoft.coreblock.view.compose.skeleton.ComposableSingletons$SkeletonItemKt.lambda$-775511239.<anonymous> (SkeletonItem.kt:214)");
            }
            SkeletonItemKt.p(3, PaddingKt.i(Modifier.b8, Dp.g(16)), null, 0.0f, 0L, null, composer, 54, 60);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }
}
