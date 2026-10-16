package cz.mobilesoft.coreblock.view.compose;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.res.StringResources_androidKt;
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
public final class ComposableSingletons$LockDialogKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$LockDialogKt f130386a = new ComposableSingletons$LockDialogKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function3 f130387b = ComposableLambdaKt.c(2127933157, false, new Function3() { // from class: cz.mobilesoft.coreblock.view.compose.v0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$LockDialogKt.k((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function3 f130388c = ComposableLambdaKt.c(-1828746589, false, new Function3() { // from class: cz.mobilesoft.coreblock.view.compose.w0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$LockDialogKt.q((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function2 f130389d = ComposableLambdaKt.c(771896190, false, new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.x0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$LockDialogKt.p((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Function2 f130390e = ComposableLambdaKt.c(718211419, false, new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.y0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$LockDialogKt.l((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(RowScope TextButton, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2127933157, i3, -1, "cz.mobilesoft.coreblock.view.compose.ComposableSingletons$LockDialogKt.lambda$2127933157.<anonymous> (LockDialog.kt:98)");
            }
            androidx.compose.material3.TextKt.c(StringResources_androidKt.b(R.string.ij, composer, 0), null, ComposeColorsKt.j(composer, 0).b(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 0, 0, 65530);
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
                ComposerKt.U(718211419, i3, -1, "cz.mobilesoft.coreblock.view.compose.ComposableSingletons$LockDialogKt.lambda$718211419.<anonymous> (LockDialog.kt:128)");
            }
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.z0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$LockDialogKt.m();
                    }
                };
                composer.w(objG);
            }
            Function0 function0 = (Function0) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.a1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$LockDialogKt.n();
                    }
                };
                composer.w(objG2);
            }
            Function0 function02 = (Function0) objG2;
            Object objG3 = composer.G();
            if (objG3 == companion.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.b1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$LockDialogKt.o();
                    }
                };
                composer.w(objG3);
            }
            LockDialogKt.i(true, true, function0, function02, (Function0) objG3, composer, 28086);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n() {
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
                ComposerKt.U(771896190, i3, -1, "cz.mobilesoft.coreblock.view.compose.ComposableSingletons$LockDialogKt.lambda$771896190.<anonymous> (LockDialog.kt:43)");
            }
            androidx.compose.material3.TextKt.c(StringResources_androidKt.b(R.string.f95842s, composer, 0), null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).g(), composer, 0, 0, 65530);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(RowScope TextButton, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1828746589, i3, -1, "cz.mobilesoft.coreblock.view.compose.ComposableSingletons$LockDialogKt.lambda$-1828746589.<anonymous> (LockDialog.kt:114)");
            }
            androidx.compose.material3.TextKt.c(StringResources_androidKt.b(R.string.O4, composer, 0), null, ComposeColorsKt.j(composer, 0).b(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 0, 0, 65530);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    public final Function3 h() {
        return f130388c;
    }

    public final Function3 i() {
        return f130387b;
    }

    public final Function2 j() {
        return f130389d;
    }
}
