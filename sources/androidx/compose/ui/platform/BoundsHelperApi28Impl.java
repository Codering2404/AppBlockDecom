package androidx.compose.ui.platform;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.DisplayCutout;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
final class BoundsHelperApi28Impl implements BoundsHelper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final BoundsHelperApi28Impl f27924b = new BoundsHelperApi28Impl();

    private BoundsHelperApi28Impl() {
    }

    @Override // androidx.compose.ui.platform.BoundsHelper
    public Rect a(Activity activity) throws Exception {
        DisplayCutout displayCutoutF;
        Rect rect = new Rect();
        Configuration configuration = activity.getResources().getConfiguration();
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            if (activity.isInMultiWindowMode()) {
                Object objInvoke = obj.getClass().getDeclaredMethod("getBounds", null).invoke(obj, null);
                Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type android.graphics.Rect");
                rect.set((Rect) objInvoke);
            } else {
                Object objInvoke2 = obj.getClass().getDeclaredMethod("getAppBounds", null).invoke(obj, null);
                Intrinsics.checkNotNull(objInvoke2, "null cannot be cast to non-null type android.graphics.Rect");
                rect.set((Rect) objInvoke2);
            }
        } catch (Exception e3) {
            if (!(e3 instanceof NoSuchFieldException ? true : e3 instanceof NoSuchMethodException ? true : e3 instanceof IllegalAccessException ? true : e3 instanceof InvocationTargetException)) {
                throw e3;
            }
            AndroidWindowInfo_androidKt.h(activity, rect);
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        if (!activity.isInMultiWindowMode()) {
            int iG = AndroidWindowInfo_androidKt.g(activity);
            int i3 = rect.bottom;
            if (i3 + iG == point.y) {
                rect.bottom = i3 + iG;
            } else {
                int i4 = rect.right;
                if (i4 + iG == point.x) {
                    rect.right = i4 + iG;
                } else if (rect.left == iG) {
                    rect.left = 0;
                }
            }
        }
        if ((rect.width() < point.x || rect.height() < point.y) && !activity.isInMultiWindowMode() && (displayCutoutF = AndroidWindowInfo_androidKt.f(defaultDisplay)) != null) {
            if (rect.left == displayCutoutF.getSafeInsetLeft()) {
                rect.left = 0;
            }
            if (point.x - rect.right == displayCutoutF.getSafeInsetRight()) {
                rect.right += displayCutoutF.getSafeInsetRight();
            }
            if (rect.top == displayCutoutF.getSafeInsetTop()) {
                rect.top = 0;
            }
            if (point.y - rect.bottom == displayCutoutF.getSafeInsetBottom()) {
                rect.bottom += displayCutoutF.getSafeInsetBottom();
            }
        }
        return rect;
    }
}
