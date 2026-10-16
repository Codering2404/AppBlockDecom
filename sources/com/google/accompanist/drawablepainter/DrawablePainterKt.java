package com.google.accompanist.drawablepainter;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.ColorPainter;
import androidx.compose.ui.graphics.painter.Painter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
public final class DrawablePainterKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Lazy f68852a = LazyKt.a(LazyThreadSafetyMode.f139763c, new Function0<Handler>() { // from class: com.google.accompanist.drawablepainter.DrawablePainterKt$MAIN_HANDLER$2
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final long c(Drawable drawable) {
        return (drawable.getIntrinsicWidth() < 0 || drawable.getIntrinsicHeight() < 0) ? Size.f25617b.a() : SizeKt.a(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler d() {
        return (Handler) f68852a.getValue();
    }

    public static final Painter e(Drawable drawable, Composer composer, int i3) {
        Object drawablePainter;
        composer.F(1756822313);
        if (ComposerKt.M()) {
            ComposerKt.U(1756822313, i3, -1, "com.google.accompanist.drawablepainter.rememberDrawablePainter (DrawablePainter.kt:151)");
        }
        composer.F(-1791785024);
        boolean Z = composer.Z(drawable);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            if (drawable == null) {
                objG = EmptyPainter.f68854h;
            } else {
                if (drawable instanceof ColorDrawable) {
                    drawablePainter = new ColorPainter(ColorKt.b(((ColorDrawable) drawable).getColor()), null);
                } else {
                    Drawable drawableMutate = drawable.mutate();
                    Intrinsics.checkNotNullExpressionValue(drawableMutate, "mutate(...)");
                    drawablePainter = new DrawablePainter(drawableMutate);
                }
                objG = drawablePainter;
            }
            composer.w(objG);
        }
        Painter painter = (Painter) objG;
        composer.Y();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.Y();
        return painter;
    }
}
