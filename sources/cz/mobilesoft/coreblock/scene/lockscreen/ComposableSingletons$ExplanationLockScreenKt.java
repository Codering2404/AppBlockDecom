package cz.mobilesoft.coreblock.scene.lockscreen;

import androidx.compose.material.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class ComposableSingletons$ExplanationLockScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$ExplanationLockScreenKt f105322a = new ComposableSingletons$ExplanationLockScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f105323b = ComposableLambdaKt.c(-1999978727, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ExplanationLockScreenKt.q((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f105324c = ComposableLambdaKt.c(-2112192908, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ExplanationLockScreenKt.t((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function2 f105325d = ComposableLambdaKt.c(-2014943677, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ExplanationLockScreenKt.r((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Function2 f105326e = ComposableLambdaKt.c(1131300251, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.d
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ExplanationLockScreenKt.m((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Function2 f105327f = ComposableLambdaKt.c(-1772199423, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.e
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ExplanationLockScreenKt.o((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Function2 f105328g = ComposableLambdaKt.c(-547492167, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.f
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ExplanationLockScreenKt.u((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1131300251, i3, -1, "cz.mobilesoft.coreblock.scene.lockscreen.ComposableSingletons$ExplanationLockScreenKt.lambda$1131300251.<anonymous> (ExplanationLockScreen.kt:477)");
            }
            LockViewState lockViewState = new LockViewState(null, null, 0, 0, false, 0, false, false, false, false, false, false, false, null, false, null, null, null, null, null, null, null, false, null, null, false, null, 0.0f, false, false, false, null, null, null, false, PremiumState.Subscription.Yearly.INSTANCE, -1, 7, null);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$ExplanationLockScreenKt.n((LockViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            ExplanationLockScreenKt.q(lockViewState, (Function1) objG, true, false, false, composer, 432, 24);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(LockViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1772199423, i3, -1, "cz.mobilesoft.coreblock.scene.lockscreen.ComposableSingletons$ExplanationLockScreenKt.lambda$-1772199423.<anonymous> (ExplanationLockScreen.kt:487)");
            }
            LockViewState lockViewState = new LockViewState(null, null, 0, 0, false, 0, false, false, false, false, false, false, false, null, false, null, null, null, null, null, null, StringResources_androidKt.b(R.string.tj, composer, 0), false, null, null, false, null, 0.0f, false, false, false, null, null, null, false, PremiumState.Subscription.Yearly.INSTANCE, -2097153, 7, null);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$ExplanationLockScreenKt.p((LockViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            ExplanationLockScreenKt.q(lockViewState, (Function1) objG, false, true, true, composer, 28080, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(LockViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1999978727, i3, -1, "cz.mobilesoft.coreblock.scene.lockscreen.ComposableSingletons$ExplanationLockScreenKt.lambda$-1999978727.<anonymous> (ExplanationLockScreen.kt:217)");
            }
            IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.C1, composer, 6), "Close", null, ComposeColorsKt.j(composer, 0).b(), composer, 48, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2014943677, i3, -1, "cz.mobilesoft.coreblock.scene.lockscreen.ComposableSingletons$ExplanationLockScreenKt.lambda$-2014943677.<anonymous> (ExplanationLockScreen.kt:467)");
            }
            LockViewState lockViewState = new LockViewState(null, null, 0, 0, false, 0, false, false, false, false, false, false, false, null, false, null, null, null, null, null, null, null, false, null, null, false, null, 0.0f, false, false, false, null, null, null, false, PremiumState.Subscription.Yearly.INSTANCE, -1, 7, null);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$ExplanationLockScreenKt.s((LockViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            ExplanationLockScreenKt.q(lockViewState, (Function1) objG, false, false, false, composer, 432, 24);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(LockViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2112192908, i3, -1, "cz.mobilesoft.coreblock.scene.lockscreen.ComposableSingletons$ExplanationLockScreenKt.lambda$-2112192908.<anonymous> (ExplanationLockScreen.kt:228)");
            }
            IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.M3, composer, 6), "More", null, Color.r(ComposeColorsKt.j(composer, 0).q0(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), composer, 48, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-547492167, i3, -1, "cz.mobilesoft.coreblock.scene.lockscreen.ComposableSingletons$ExplanationLockScreenKt.lambda$-547492167.<anonymous> (ExplanationLockScreen.kt:504)");
            }
            LockViewState lockViewState = new LockViewState(null, null, 0, 0, false, 0, false, false, false, false, false, false, false, null, false, null, null, null, null, null, null, StringResources_androidKt.b(R.string.tj, composer, 0), false, null, null, false, null, 0.0f, false, false, false, null, null, null, false, PremiumState.Subscription.Yearly.INSTANCE, -2097153, 7, null);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.i
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$ExplanationLockScreenKt.v((LockViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            ExplanationLockScreenKt.q(lockViewState, (Function1) objG, false, true, false, composer, 28080, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(LockViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    public final Function2 k() {
        return f105323b;
    }

    public final Function2 l() {
        return f105324c;
    }
}
