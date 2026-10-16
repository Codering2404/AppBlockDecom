package cz.mobilesoft.coreblock.scene.streaks.milestone;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

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
public final class ComposableSingletons$StreakMilestoneScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$StreakMilestoneScreenKt f120934a = new ComposableSingletons$StreakMilestoneScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f120935b = ComposableLambdaKt.c(-42116427, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.milestone.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StreakMilestoneScreenKt.k((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f120936c = ComposableLambdaKt.c(103061517, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.milestone.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StreakMilestoneScreenKt.g((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function2 f120937d = ComposableLambdaKt.c(-159842955, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.milestone.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StreakMilestoneScreenKt.i((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(103061517, i3, -1, "cz.mobilesoft.coreblock.scene.streaks.milestone.ComposableSingletons$StreakMilestoneScreenKt.lambda$103061517.<anonymous> (StreakMilestoneScreen.kt:309)");
            }
            PaddingValues paddingValuesC = PaddingKt.c(0.0f, 0.0f, 3, null);
            StreakMilestoneViewState streakMilestoneViewStateB = StreakMilestoneScreenKt.B(7);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.streaks.milestone.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$StreakMilestoneScreenKt.h();
                    }
                };
                composer.w(objG);
            }
            StreakMilestoneScreenKt.k(paddingValuesC, streakMilestoneViewStateB, (Function0) objG, false, composer, 3462, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-159842955, i3, -1, "cz.mobilesoft.coreblock.scene.streaks.milestone.ComposableSingletons$StreakMilestoneScreenKt.lambda$-159842955.<anonymous> (StreakMilestoneScreen.kt:323)");
            }
            PaddingValues paddingValuesC = PaddingKt.c(0.0f, 0.0f, 3, null);
            StreakMilestoneViewState streakMilestoneViewStateB = StreakMilestoneScreenKt.B(100);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.streaks.milestone.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$StreakMilestoneScreenKt.j();
                    }
                };
                composer.w(objG);
            }
            StreakMilestoneScreenKt.k(paddingValuesC, streakMilestoneViewStateB, (Function0) objG, false, composer, 3462, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-42116427, i3, -1, "cz.mobilesoft.coreblock.scene.streaks.milestone.ComposableSingletons$StreakMilestoneScreenKt.lambda$-42116427.<anonymous> (StreakMilestoneScreen.kt:295)");
            }
            PaddingValues paddingValuesC = PaddingKt.c(0.0f, 0.0f, 3, null);
            StreakMilestoneViewState streakMilestoneViewStateB = StreakMilestoneScreenKt.B(1);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.streaks.milestone.d
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$StreakMilestoneScreenKt.l();
                    }
                };
                composer.w(objG);
            }
            StreakMilestoneScreenKt.k(paddingValuesC, streakMilestoneViewStateB, (Function0) objG, false, composer, 3462, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l() {
        return Unit.f139807a;
    }
}
