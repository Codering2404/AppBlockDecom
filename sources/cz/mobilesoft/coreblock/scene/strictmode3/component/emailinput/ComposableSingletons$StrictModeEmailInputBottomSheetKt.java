package cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput;

import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.TextFieldValue;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class ComposableSingletons$StrictModeEmailInputBottomSheetKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$StrictModeEmailInputBottomSheetKt f121847a = new ComposableSingletons$StrictModeEmailInputBottomSheetKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f121848b = ComposableLambdaKt.c(1776643732, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StrictModeEmailInputBottomSheetKt.l((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f121849c = ComposableLambdaKt.c(-222973658, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StrictModeEmailInputBottomSheetKt.m((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function2 f121850d = ComposableLambdaKt.c(1648134545, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StrictModeEmailInputBottomSheetKt.i((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1648134545, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.ComposableSingletons$StrictModeEmailInputBottomSheetKt.lambda$1648134545.<anonymous> (StrictModeEmailInputBottomSheet.kt:280)");
            }
            TextFieldValue textFieldValue = new TextFieldValue("mail@mail.sk", 0L, (TextRange) null, 6, (DefaultConstructorMarker) null);
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$StrictModeEmailInputBottomSheetKt.j((StrictModeEmailInputBottomSheetViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            Function1 function1 = (Function1) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$StrictModeEmailInputBottomSheetKt.k();
                    }
                };
                composer.w(objG2);
            }
            StrictModeEmailInputBottomSheetKt.o(textFieldValue, function1, (Function0) objG2, composer, 438);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(StrictModeEmailInputBottomSheetViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1776643732, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.ComposableSingletons$StrictModeEmailInputBottomSheetKt.lambda$1776643732.<anonymous> (StrictModeEmailInputBottomSheet.kt:167)");
            }
            TextKt.c(StringResources_androidKt.b(R.string.Rc, composer, 0), null, ComposeColorsKt.j(composer, 0).M(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 0, 0, 65530);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-222973658, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.ComposableSingletons$StrictModeEmailInputBottomSheetKt.lambda$-222973658.<anonymous> (StrictModeEmailInputBottomSheet.kt:272)");
            }
            TextFieldValue textFieldValue = new TextFieldValue("", 0L, (TextRange) null, 6, (DefaultConstructorMarker) null);
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$StrictModeEmailInputBottomSheetKt.n((StrictModeEmailInputBottomSheetViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            Function1 function1 = (Function1) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.g
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$StrictModeEmailInputBottomSheetKt.o();
                    }
                };
                composer.w(objG2);
            }
            StrictModeEmailInputBottomSheetKt.x(textFieldValue, function1, (Function0) objG2, false, composer, 3510);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(StrictModeEmailInputBottomSheetViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o() {
        return Unit.f139807a;
    }

    public final Function2 h() {
        return f121848b;
    }
}
