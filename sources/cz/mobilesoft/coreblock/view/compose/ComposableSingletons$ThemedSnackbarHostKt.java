package cz.mobilesoft.coreblock.view.compose;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ButtonColors;
import androidx.compose.material.ButtonDefaults;
import androidx.compose.material.ButtonKt;
import androidx.compose.material.SnackbarData;
import androidx.compose.material.SnackbarKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
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
public final class ComposableSingletons$ThemedSnackbarHostKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$ThemedSnackbarHostKt f130402a = new ComposableSingletons$ThemedSnackbarHostKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function3 f130403b = ComposableLambdaKt.c(617472376, false, new Function3() { // from class: cz.mobilesoft.coreblock.view.compose.m1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$ThemedSnackbarHostKt.g((SnackbarData) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(final SnackbarData snackbarData, Composer composer, int i3) {
        ComposableLambda composableLambdaE;
        Intrinsics.checkNotNullParameter(snackbarData, "snackbarData");
        if (ComposerKt.M()) {
            ComposerKt.U(617472376, i3, -1, "cz.mobilesoft.coreblock.view.compose.ComposableSingletons$ThemedSnackbarHostKt.lambda$617472376.<anonymous> (ThemedSnackbarHost.kt:24)");
        }
        final String strA = snackbarData.a();
        if (strA != null) {
            composer.a0(-225209035);
            composableLambdaE = ComposableLambdaKt.e(-1634729130, true, new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.n1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposableSingletons$ThemedSnackbarHostKt.h(snackbarData, strA, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54);
            composer.U();
        } else {
            composer.a0(-224720754);
            composer.U();
            composableLambdaE = null;
        }
        SnackbarKt.c(PaddingKt.i(Modifier.b8, Dp.g(12)), composableLambdaE, false, RoundedCornerShapeKt.a(50), ComposeColorsKt.j(composer, 0).p(), 0L, 0.0f, ComposableLambdaKt.e(1372007103, true, new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.o1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ComposableSingletons$ThemedSnackbarHostKt.k(snackbarData, (Composer) obj, ((Integer) obj2).intValue());
            }
        }, composer, 54), composer, 12582918, 100);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(final SnackbarData snackbarData, final String str, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1634729130, i3, -1, "cz.mobilesoft.coreblock.view.compose.ComposableSingletons$ThemedSnackbarHostKt.lambda$617472376.<anonymous>.<anonymous> (ThemedSnackbarHost.kt:27)");
            }
            ButtonColors buttonColorsG = ButtonDefaults.f12323a.g(0L, ComposeColorsKt.j(composer, 0).b(), 0L, composer, ButtonDefaults.f12334l << 9, 5);
            boolean zI = composer.I(snackbarData);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.p1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$ThemedSnackbarHostKt.i(snackbarData);
                    }
                };
                composer.w(objG);
            }
            ButtonKt.c((Function0) objG, null, false, null, null, null, null, buttonColorsG, null, ComposableLambdaKt.e(-1622081517, true, new Function3() { // from class: cz.mobilesoft.coreblock.view.compose.q1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ComposableSingletons$ThemedSnackbarHostKt.j(str, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 805306368, 382);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(SnackbarData snackbarData) {
        snackbarData.b();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(String str, RowScope TextButton, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1622081517, i3, -1, "cz.mobilesoft.coreblock.view.compose.ComposableSingletons$ThemedSnackbarHostKt.lambda$617472376.<anonymous>.<anonymous>.<anonymous> (ThemedSnackbarHost.kt:31)");
            }
            androidx.compose.material.TextKt.c(str, null, ComposeColorsKt.j(composer, 0).b(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 131066);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(SnackbarData snackbarData, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1372007103, i3, -1, "cz.mobilesoft.coreblock.view.compose.ComposableSingletons$ThemedSnackbarHostKt.lambda$617472376.<anonymous>.<anonymous> (ThemedSnackbarHost.kt:44)");
            }
            androidx.compose.material.TextKt.c(snackbarData.getMessage(), null, ComposeColorsKt.j(composer, 0).l0(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 131066);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    public final Function3 f() {
        return f130403b;
    }
}
