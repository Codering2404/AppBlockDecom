package cz.mobilesoft.coreblock.view.badge;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.more.guestpassshare.screens.GuestPassShareContentComponentsKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
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
public final class ComposableSingletons$PremiumGiftCardKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$PremiumGiftCardKt f130100a = new ComposableSingletons$PremiumGiftCardKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f130101b = ComposableLambdaKt.c(1125995703, false, new Function2() { // from class: cz.mobilesoft.coreblock.view.badge.f
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PremiumGiftCardKt.m((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f130102c = ComposableLambdaKt.c(1570614916, false, new Function2() { // from class: cz.mobilesoft.coreblock.view.badge.i
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PremiumGiftCardKt.o((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function2 f130103d = ComposableLambdaKt.c(1352390781, false, new Function2() { // from class: cz.mobilesoft.coreblock.view.badge.j
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PremiumGiftCardKt.n((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Function2 f130104e = ComposableLambdaKt.c(-233642870, false, new Function2() { // from class: cz.mobilesoft.coreblock.view.badge.k
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PremiumGiftCardKt.w((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Function2 f130105f = ComposableLambdaKt.c(495269320, false, new Function2() { // from class: cz.mobilesoft.coreblock.view.badge.l
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PremiumGiftCardKt.q((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Function2 f130106g = ComposableLambdaKt.c(-1673161569, false, new Function2() { // from class: cz.mobilesoft.coreblock.view.badge.m
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PremiumGiftCardKt.s((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Function2 f130107h = ComposableLambdaKt.c(-1701327950, false, new Function2() { // from class: cz.mobilesoft.coreblock.view.badge.n
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PremiumGiftCardKt.t((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1125995703, i3, -1, "cz.mobilesoft.coreblock.view.badge.ComposableSingletons$PremiumGiftCardKt.lambda$1125995703.<anonymous> (PremiumGiftCard.kt:204)");
            }
            GuestPassShareContentComponentsKt.i(composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1352390781, i3, -1, "cz.mobilesoft.coreblock.view.badge.ComposableSingletons$PremiumGiftCardKt.lambda$1352390781.<anonymous> (PremiumGiftCard.kt:228)");
            }
            GuestPassShareContentComponentsKt.i(composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1570614916, i3, -1, "cz.mobilesoft.coreblock.view.badge.ComposableSingletons$PremiumGiftCardKt.lambda$1570614916.<anonymous> (PremiumGiftCard.kt:193)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierI = PaddingKt.i(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3));
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.o(Dp.g(f3)), Alignment.f25072a.l(), composer, 6);
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            Modifier modifierB = AspectRatioKt.b(companion, 0.8f, false, 2, null);
            String strC = StringResources_androidKt.c(R.string.Ke, new Object[]{14}, composer, 0);
            Function2 function2 = f130101b;
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.badge.g
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$PremiumGiftCardKt.p();
                    }
                };
                composer.w(objG);
            }
            PremiumGiftCardKt.g(modifierB, strC, null, function2, 0.0f, 0L, false, (Function0) objG, composer, 14158854, 52);
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
    public static final Unit p() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(495269320, i3, -1, "cz.mobilesoft.coreblock.view.badge.ComposableSingletons$PremiumGiftCardKt.lambda$495269320.<anonymous> (PremiumGiftCard.kt:241)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierI = PaddingKt.i(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3));
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.o(Dp.g(f3)), Alignment.f25072a.l(), composer, 6);
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            Modifier modifierB = AspectRatioKt.b(companion, 2.5f, false, 2, null);
            String strB = StringResources_androidKt.b(R.string.ok, composer, 0);
            Painter painterC = PainterResources_androidKt.c(R.drawable.z8, composer, 0);
            long jH = ComposeColorsKt.j(composer, 0).h();
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.badge.o
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$PremiumGiftCardKt.r();
                    }
                };
                composer.w(objG);
            }
            PremiumGiftCardKt.g(modifierB, strB, painterC, null, 0.3f, jH, true, (Function0) objG, composer, 14180358, 8);
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
    public static final Unit r() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1673161569, i3, -1, "cz.mobilesoft.coreblock.view.badge.ComposableSingletons$PremiumGiftCardKt.lambda$-1673161569.<anonymous> (PremiumGiftCard.kt:277)");
            }
            GuestPassShareContentComponentsKt.i(composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1701327950, i3, -1, "cz.mobilesoft.coreblock.view.badge.ComposableSingletons$PremiumGiftCardKt.lambda$-1701327950.<anonymous> (PremiumGiftCard.kt:265)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierI = PaddingKt.i(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3));
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.o(Dp.g(f3)), Alignment.f25072a.l(), composer, 6);
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            Modifier modifierB = AspectRatioKt.b(RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null), 0.8f, false, 2, null);
            String strC = StringResources_androidKt.c(R.string.Ke, new Object[]{14}, composer, 0);
            Function2 function2 = f130106g;
            Object objG = composer.G();
            Composer.Companion companion3 = Composer.f23746a;
            if (objG == companion3.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.badge.p
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$PremiumGiftCardKt.u();
                    }
                };
                composer.w(objG);
            }
            PremiumGiftCardKt.g(modifierB, strC, null, function2, 0.0f, 0L, false, (Function0) objG, composer, 14158848, 52);
            Modifier modifierB2 = AspectRatioKt.b(RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null), 0.8f, false, 2, null);
            String strB = StringResources_androidKt.b(R.string.ok, composer, 0);
            Painter painterC = PainterResources_androidKt.c(R.drawable.z8, composer, 0);
            long jH = ComposeColorsKt.j(composer, 0).h();
            Object objG2 = composer.G();
            if (objG2 == companion3.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.view.badge.q
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$PremiumGiftCardKt.v();
                    }
                };
                composer.w(objG2);
            }
            PremiumGiftCardKt.g(modifierB2, strB, painterC, null, 0.3f, jH, false, (Function0) objG2, composer, 14180352, 8);
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
    public static final Unit v() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-233642870, i3, -1, "cz.mobilesoft.coreblock.view.badge.ComposableSingletons$PremiumGiftCardKt.lambda$-233642870.<anonymous> (PremiumGiftCard.kt:217)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierI = PaddingKt.i(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3));
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.o(Dp.g(f3)), Alignment.f25072a.l(), composer, 6);
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            Modifier modifierB = AspectRatioKt.b(companion, 2.5f, false, 2, null);
            String strC = StringResources_androidKt.c(R.string.Ke, new Object[]{14}, composer, 0);
            Function2 function2 = f130103d;
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.badge.h
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$PremiumGiftCardKt.x();
                    }
                };
                composer.w(objG);
            }
            PremiumGiftCardKt.g(modifierB, strC, null, function2, 0.0f, 0L, true, (Function0) objG, composer, 14158854, 52);
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
    public static final Unit x() {
        return Unit.f139807a;
    }
}
