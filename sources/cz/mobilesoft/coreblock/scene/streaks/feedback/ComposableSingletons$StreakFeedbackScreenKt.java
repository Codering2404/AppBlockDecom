package cz.mobilesoft.coreblock.scene.streaks.feedback;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.res.StringResources_androidKt;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.feedback.FeedbackViewEvent;
import cz.mobilesoft.coreblock.scene.feedback.FeedbackViewState;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
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
public final class ComposableSingletons$StreakFeedbackScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$StreakFeedbackScreenKt f120836a = new ComposableSingletons$StreakFeedbackScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f120837b = ComposableLambdaKt.c(-457194873, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.feedback.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StreakFeedbackScreenKt.u((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f120838c = ComposableLambdaKt.c(1334283532, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.feedback.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StreakFeedbackScreenKt.l((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function2 f120839d = ComposableLambdaKt.c(1395370623, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.feedback.d
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StreakFeedbackScreenKt.o((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Function2 f120840e = ComposableLambdaKt.c(749393450, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.feedback.e
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StreakFeedbackScreenKt.r((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1334283532, i3, -1, "cz.mobilesoft.coreblock.scene.streaks.feedback.ComposableSingletons$StreakFeedbackScreenKt.lambda$1334283532.<anonymous> (StreakFeedbackScreen.kt:147)");
            }
            PaddingValues paddingValuesC = PaddingKt.c(0.0f, 0.0f, 3, null);
            FeedbackViewState feedbackViewState = new FeedbackViewState("The calendar looks great.", null, null, null, null, false, false, 0, null, null, false, false, false, false, 16382, null);
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.streaks.feedback.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$StreakFeedbackScreenKt.m((FeedbackViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            Function1 function1 = (Function1) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.streaks.feedback.g
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$StreakFeedbackScreenKt.n();
                    }
                };
                composer.w(objG2);
            }
            StreakFeedbackScreenKt.e(paddingValuesC, feedbackViewState, function1, (Function0) objG2, composer, 3462);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(FeedbackViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1395370623, i3, -1, "cz.mobilesoft.coreblock.scene.streaks.feedback.ComposableSingletons$StreakFeedbackScreenKt.lambda$1395370623.<anonymous> (StreakFeedbackScreen.kt:162)");
            }
            PaddingValues paddingValuesC = PaddingKt.c(0.0f, 0.0f, 3, null);
            FeedbackViewState feedbackViewState = new FeedbackViewState(null, null, null, null, null, false, false, 0, SetsKt.setOf((Object[]) new FeedbackViewState.FeedbackValidationError[]{FeedbackViewState.FeedbackValidationError.MessageIsEmpty, FeedbackViewState.FeedbackValidationError.EmailIsInvalid}), null, true, false, false, false, 15103, null);
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.streaks.feedback.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$StreakFeedbackScreenKt.p((FeedbackViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            Function1 function1 = (Function1) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.streaks.feedback.k
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$StreakFeedbackScreenKt.q();
                    }
                };
                composer.w(objG2);
            }
            StreakFeedbackScreenKt.e(paddingValuesC, feedbackViewState, function1, (Function0) objG2, composer, 3462);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(FeedbackViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(749393450, i3, -1, "cz.mobilesoft.coreblock.scene.streaks.feedback.ComposableSingletons$StreakFeedbackScreenKt.lambda$749393450.<anonymous> (StreakFeedbackScreen.kt:181)");
            }
            PaddingValues paddingValuesC = PaddingKt.c(0.0f, 0.0f, 3, null);
            FeedbackViewState feedbackViewState = new FeedbackViewState(null, null, null, null, null, false, true, 0, null, null, false, false, false, false, 16319, null);
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.streaks.feedback.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$StreakFeedbackScreenKt.s((FeedbackViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            Function1 function1 = (Function1) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.streaks.feedback.i
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$StreakFeedbackScreenKt.t();
                    }
                };
                composer.w(objG2);
            }
            StreakFeedbackScreenKt.e(paddingValuesC, feedbackViewState, function1, (Function0) objG2, composer, 3462);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(FeedbackViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-457194873, i3, -1, "cz.mobilesoft.coreblock.scene.streaks.feedback.ComposableSingletons$StreakFeedbackScreenKt.lambda$-457194873.<anonymous> (StreakFeedbackScreen.kt:101)");
            }
            TextKt.c(StringResources_androidKt.b(R.string.xC, composer, 0), null, ComposeColorsKt.j(composer, 0).s(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.f13091a.c(composer, MaterialTheme.f13092b).a(), composer, 0, 0, 65530);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    public final Function2 k() {
        return f120837b;
    }
}
