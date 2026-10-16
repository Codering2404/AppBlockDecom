package cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.datetimepicker;

import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.media3.exoplayer.audio.wRw.CbYNFSEGaQj;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import androidx.navigation.compose.NavHostControllerKt;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewEvent;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewState;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ComposableSingletons$DateTimePickerScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$DateTimePickerScreenKt f100220a = new ComposableSingletons$DateTimePickerScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f100221b = ComposableLambdaKt.c(-1874360862, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.datetimepicker.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DateTimePickerScreenKt.f((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f100222c = ComposableLambdaKt.c(-1485923249, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.datetimepicker.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DateTimePickerScreenKt.e((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1485923249, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.datetimepicker.ComposableSingletons$DateTimePickerScreenKt.lambda$-1485923249.<anonymous> (DateTimePickerScreen.kt:108)");
            }
            TextKt.c(StringResources_androidKt.b(R.string.uF, composer, 0), null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).g(), composer, 0, 0, 65530);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(PauseBlockingViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    public final Function2 d() {
        return f100222c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1874360862, i3, -1, CbYNFSEGaQj.hdObnpR);
            }
            PauseBlockingViewState pauseBlockingViewState = new PauseBlockingViewState(null, null, null, null, null, 31, null);
            NavHostController navHostControllerB = NavHostControllerKt.b(new Navigator[0], composer, 0);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.datetimepicker.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$DateTimePickerScreenKt.g((PauseBlockingViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            DateTimePickerScreenKt.t(navHostControllerB, (Function1) objG, pauseBlockingViewState, composer, 48);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }
}
