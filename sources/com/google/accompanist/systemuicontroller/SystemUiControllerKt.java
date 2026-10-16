package com.google.accompanist.systemuicontroller;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.window.DialogWindowProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class SystemUiControllerKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f68864a = ColorKt.e(0.0f, 0.0f, 0.0f, 0.3f, null, 16, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Function1 f68865b = new Function1<Color, Color>() { // from class: com.google.accompanist.systemuicontroller.SystemUiControllerKt$BlackScrimmed$1
        public final long c(long j3) {
            return ColorKt.h(SystemUiControllerKt.f68864a, j3);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Color.n(c(((Color) obj).B()));
        }
    };

    private static final Window c(Context baseContext) {
        while (!(baseContext instanceof Activity)) {
            if (!(baseContext instanceof ContextWrapper)) {
                return null;
            }
            baseContext = ((ContextWrapper) baseContext).getBaseContext();
            Intrinsics.checkNotNullExpressionValue(baseContext, "baseContext");
        }
        return ((Activity) baseContext).getWindow();
    }

    private static final Window d(Composer composer, int i3) {
        composer.F(1009281237);
        if (ComposerKt.M()) {
            ComposerKt.U(1009281237, i3, -1, "com.google.accompanist.systemuicontroller.findWindow (SystemUiController.kt:191)");
        }
        ViewParent parent = ((View) composer.q(AndroidCompositionLocals_androidKt.j())).getParent();
        DialogWindowProvider dialogWindowProvider = parent instanceof DialogWindowProvider ? (DialogWindowProvider) parent : null;
        Window window = dialogWindowProvider != null ? dialogWindowProvider.getWindow() : null;
        if (window == null) {
            Context context = ((View) composer.q(AndroidCompositionLocals_androidKt.j())).getContext();
            Intrinsics.checkNotNullExpressionValue(context, "LocalView.current.context");
            window = c(context);
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.Y();
        return window;
    }

    public static final SystemUiController e(Window window, Composer composer, int i3, int i4) {
        composer.F(-715745933);
        if ((i4 & 1) != 0) {
            window = d(composer, 0);
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-715745933, i3, -1, "com.google.accompanist.systemuicontroller.rememberSystemUiController (SystemUiController.kt:183)");
        }
        View view = (View) composer.q(AndroidCompositionLocals_androidKt.j());
        composer.F(511388516);
        boolean Z = composer.Z(view) | composer.Z(window);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new AndroidSystemUiController(view, window);
            composer.w(objG);
        }
        composer.Y();
        AndroidSystemUiController androidSystemUiController = (AndroidSystemUiController) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.Y();
        return androidSystemUiController;
    }
}
