package androidx.window.layout.util;

import android.content.Context;
import android.graphics.Rect;
import android.view.WindowInsets;
import android.view.WindowManager;
import androidx.core.view.WindowInsetsCompat;
import androidx.window.layout.WindowMetrics;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ContextCompatHelperApi30 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ContextCompatHelperApi30 f54437a = new ContextCompatHelperApi30();

    private ContextCompatHelperApi30() {
    }

    public final Rect a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Rect bounds = ((WindowManager) context.getSystemService(WindowManager.class)).getCurrentWindowMetrics().getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "wm.currentWindowMetrics.bounds");
        return bounds;
    }

    public final WindowInsetsCompat b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        WindowInsets windowInsets = ((WindowManager) context.getSystemService(WindowManager.class)).getCurrentWindowMetrics().getWindowInsets();
        Intrinsics.checkNotNullExpressionValue(windowInsets, "context.getSystemService…indowMetrics.windowInsets");
        WindowInsetsCompat windowInsetsCompatZ = WindowInsetsCompat.z(windowInsets);
        Intrinsics.checkNotNullExpressionValue(windowInsetsCompatZ, "toWindowInsetsCompat(platformInsets)");
        return windowInsetsCompatZ;
    }

    public final WindowMetrics c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        WindowManager windowManager = (WindowManager) context.getSystemService(WindowManager.class);
        WindowInsetsCompat windowInsetsCompatZ = WindowInsetsCompat.z(windowManager.getCurrentWindowMetrics().getWindowInsets());
        Intrinsics.checkNotNullExpressionValue(windowInsetsCompatZ, "toWindowInsetsCompat(wm.…ndowMetrics.windowInsets)");
        Rect bounds = windowManager.getCurrentWindowMetrics().getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "wm.currentWindowMetrics.bounds");
        return new WindowMetrics(bounds, windowInsetsCompatZ);
    }
}
