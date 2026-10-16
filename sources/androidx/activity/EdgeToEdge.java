package androidx.activity;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.activity.SystemBarStyle;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class EdgeToEdge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f357a = Color.argb(230, 255, 255, 255);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f358b = Color.argb(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, 27, 27, 27);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static EdgeToEdgeImpl f359c;

    public static final void a(ComponentActivity componentActivity, SystemBarStyle statusBarStyle, SystemBarStyle navigationBarStyle) {
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        Intrinsics.checkNotNullParameter(statusBarStyle, "statusBarStyle");
        Intrinsics.checkNotNullParameter(navigationBarStyle, "navigationBarStyle");
        View decorView = componentActivity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
        Function1 function1B = statusBarStyle.b();
        Resources resources = decorView.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "view.resources");
        boolean zBooleanValue = ((Boolean) function1B.invoke(resources)).booleanValue();
        Function1 function1B2 = navigationBarStyle.b();
        Resources resources2 = decorView.getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "view.resources");
        boolean zBooleanValue2 = ((Boolean) function1B2.invoke(resources2)).booleanValue();
        EdgeToEdgeImpl edgeToEdgeApi30 = f359c;
        if (edgeToEdgeApi30 == null) {
            int i3 = Build.VERSION.SDK_INT;
            edgeToEdgeApi30 = i3 >= 30 ? new EdgeToEdgeApi30() : i3 >= 29 ? new EdgeToEdgeApi29() : new EdgeToEdgeApi28();
        }
        EdgeToEdgeImpl edgeToEdgeImpl = edgeToEdgeApi30;
        Window window = componentActivity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "window");
        edgeToEdgeImpl.b(statusBarStyle, navigationBarStyle, window, decorView, zBooleanValue, zBooleanValue2);
        Window window2 = componentActivity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window2, "window");
        edgeToEdgeImpl.a(window2);
    }

    public static /* synthetic */ void b(ComponentActivity componentActivity, SystemBarStyle systemBarStyle, SystemBarStyle systemBarStyle2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            systemBarStyle = SystemBarStyle.Companion.b(SystemBarStyle.f419e, 0, 0, null, 4, null);
        }
        if ((i3 & 2) != 0) {
            systemBarStyle2 = SystemBarStyle.Companion.b(SystemBarStyle.f419e, f357a, f358b, null, 4, null);
        }
        a(componentActivity, systemBarStyle, systemBarStyle2);
    }
}
