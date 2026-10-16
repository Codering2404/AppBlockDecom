package cz.mobilesoft.coreblock.scene.streaks.detail;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import cz.mobilesoft.coreblock.scene.streaks.StreakStats;
import cz.mobilesoft.coreblock.scene.streaks.detail.StreakDetailViewState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public final class ComposableSingletons$StreakDetailScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$StreakDetailScreenKt f120657a = new ComposableSingletons$StreakDetailScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f120658b = ComposableLambdaKt.c(-533923672, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StreakDetailScreenKt.s((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f120659c = ComposableLambdaKt.c(670119379, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.d
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StreakDetailScreenKt.m((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function2 f120660d = ComposableLambdaKt.c(868198639, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.e
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StreakDetailScreenKt.p((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Function2 f120661e = ComposableLambdaKt.c(-753412932, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.f
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StreakDetailScreenKt.v((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(670119379, i3, -1, "cz.mobilesoft.coreblock.scene.streaks.detail.ComposableSingletons$StreakDetailScreenKt.lambda$670119379.<anonymous> (StreakDetailScreen.kt:697)");
            }
            PaddingValues paddingValuesC = PaddingKt.c(0.0f, 0.0f, 3, null);
            StreakDetailViewState streakDetailViewStateA0 = StreakDetailScreenKt.A0(StreakDetailViewState.SummaryState.NeverStarted.f120737a, new StreakStats(0, 0, 0, 7, null), true);
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.i
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$StreakDetailScreenKt.n((StreakDetailViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            Function1 function1 = (Function1) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.j
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$StreakDetailScreenKt.o();
                    }
                };
                composer.w(objG2);
            }
            StreakDetailScreenKt.P(paddingValuesC, streakDetailViewStateA0, function1, (Function0) objG2, composer, 3462);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(StreakDetailViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(868198639, i3, -1, "cz.mobilesoft.coreblock.scene.streaks.detail.ComposableSingletons$StreakDetailScreenKt.lambda$868198639.<anonymous> (StreakDetailScreen.kt:715)");
            }
            PaddingValues paddingValuesC = PaddingKt.c(0.0f, 0.0f, 3, null);
            StreakDetailViewState streakDetailViewStateB0 = StreakDetailScreenKt.B0(StreakDetailViewState.SummaryState.InactiveHistory.f120736a, new StreakStats(0, 9, 23), false, 4, null);
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.k
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$StreakDetailScreenKt.q((StreakDetailViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            Function1 function1 = (Function1) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.l
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$StreakDetailScreenKt.r();
                    }
                };
                composer.w(objG2);
            }
            StreakDetailScreenKt.P(paddingValuesC, streakDetailViewStateB0, function1, (Function0) objG2, composer, 3462);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(StreakDetailViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
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
                ComposerKt.U(-533923672, i3, -1, "cz.mobilesoft.coreblock.scene.streaks.detail.ComposableSingletons$StreakDetailScreenKt.lambda$-533923672.<anonymous> (StreakDetailScreen.kt:680)");
            }
            PaddingValues paddingValuesC = PaddingKt.c(0.0f, 0.0f, 3, null);
            StreakDetailViewState streakDetailViewStateB0 = StreakDetailScreenKt.B0(new StreakDetailViewState.SummaryState.Active(12), new StreakStats(12, 21, 46), false, 4, null);
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$StreakDetailScreenKt.t((StreakDetailViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            Function1 function1 = (Function1) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$StreakDetailScreenKt.u();
                    }
                };
                composer.w(objG2);
            }
            StreakDetailScreenKt.P(paddingValuesC, streakDetailViewStateB0, function1, (Function0) objG2, composer, 3462);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(StreakDetailViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
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
                ComposerKt.U(-753412932, i3, -1, "cz.mobilesoft.coreblock.scene.streaks.detail.ComposableSingletons$StreakDetailScreenKt.lambda$-753412932.<anonymous> (StreakDetailScreen.kt:731)");
            }
            PaddingValues paddingValuesC = PaddingKt.c(0.0f, 0.0f, 3, null);
            StreakDetailViewState streakDetailViewState = new StreakDetailViewState(true, null, null, null, 0, null, false, 126, null);
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$StreakDetailScreenKt.w((StreakDetailViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            Function1 function1 = (Function1) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.h
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$StreakDetailScreenKt.x();
                    }
                };
                composer.w(objG2);
            }
            StreakDetailScreenKt.P(paddingValuesC, streakDetailViewState, function1, (Function0) objG2, composer, 3510);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(StreakDetailViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x() {
        return Unit.f139807a;
    }
}
