package cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback;

import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.SnackbarHostState;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.res.StringResources_androidKt;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.feedback.FeedbackViewEvent;
import cz.mobilesoft.coreblock.scene.feedback.FeedbackViewState;
import cz.mobilesoft.coreblock.scene.feedback.backdoorcode.reasonpicker.BackdoorReason;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ThemedSnackbarHostKt;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class ComposableSingletons$BackdoorFeedbackScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$BackdoorFeedbackScreenKt f102253a = new ComposableSingletons$BackdoorFeedbackScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f102254b = ComposableLambdaKt.c(-130631823, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback.r
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BackdoorFeedbackScreenKt.k((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f102255c = ComposableLambdaKt.c(-1936348057, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback.s
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BackdoorFeedbackScreenKt.m((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function3 f102256d = ComposableLambdaKt.c(938743752, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback.t
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$BackdoorFeedbackScreenKt.i((SnackbarHostState) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Function2 f102257e = ComposableLambdaKt.c(-1296991806, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback.u
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BackdoorFeedbackScreenKt.j((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(SnackbarHostState it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i3 |= composer.Z(it) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(938743752, i3, -1, "cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback.ComposableSingletons$BackdoorFeedbackScreenKt.lambda$938743752.<anonymous> (BackdoorFeedbackScreen.kt:196)");
            }
            ThemedSnackbarHostKt.b(it, null, composer, i3 & 14, 2);
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
                ComposerKt.U(-1296991806, i3, -1, "cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback.ComposableSingletons$BackdoorFeedbackScreenKt.lambda$-1296991806.<anonymous> (BackdoorFeedbackScreen.kt:252)");
            }
            TextKt.c(StringResources_androidKt.b(R.string.xC, composer, 0), null, ComposeColorsKt.j(composer, 0).s(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 0, 0, 65530);
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
                ComposerKt.U(-130631823, i3, -1, "cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback.ComposableSingletons$BackdoorFeedbackScreenKt.lambda$-130631823.<anonymous> (BackdoorFeedbackScreen.kt:78)");
            }
            FeedbackViewState feedbackViewState = new FeedbackViewState(null, null, null, null, null, false, false, 0, null, null, true, false, false, false, 15343, null);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback.v
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$BackdoorFeedbackScreenKt.l((FeedbackViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            BackdoorFeedbackScreenKt.o(feedbackViewState, (Function1) objG, ScaffoldKt.g(null, null, composer, 0, 3), BackdoorReason.DIDNT_MEET_EXPECTATIONS, composer, 3120);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(FeedbackViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1936348057, i3, -1, "cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback.ComposableSingletons$BackdoorFeedbackScreenKt.lambda$-1936348057.<anonymous> (BackdoorFeedbackScreen.kt:94)");
            }
            FeedbackViewState feedbackViewState = new FeedbackViewState(null, null, null, null, null, false, false, 0, null, null, false, false, false, false, 15343, null);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback.w
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$BackdoorFeedbackScreenKt.n((FeedbackViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            BackdoorFeedbackScreenKt.o(feedbackViewState, (Function1) objG, ScaffoldKt.g(null, null, composer, 0, 3), BackdoorReason.DIDNT_MEET_EXPECTATIONS, composer, 3120);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(FeedbackViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    public final Function2 g() {
        return f102257e;
    }

    public final Function3 h() {
        return f102256d;
    }
}
