package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.inputmethodservice.InputMethodService;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.WindowManager;
import androidx.core.view.WindowInsetsCompat;
import androidx.window.core.Bounds;
import androidx.window.layout.util.ActivityCompatHelperApi24;
import androidx.window.layout.util.ContextCompatHelper;
import androidx.window.layout.util.ContextCompatHelperApi30;
import androidx.window.layout.util.DisplayCompatHelperApi28;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public final class WindowMetricsCalculatorCompat implements WindowMetricsCalculator {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WindowMetricsCalculatorCompat f54373b = new WindowMetricsCalculatorCompat();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f54374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ArrayList f54375d;

    static {
        String simpleName = WindowMetricsCalculatorCompat.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "WindowMetricsCalculatorC…at::class.java.simpleName");
        f54374c = simpleName;
        f54375d = CollectionsKt.arrayListOf(Integer.valueOf(WindowInsetsCompat.Type.h()), Integer.valueOf(WindowInsetsCompat.Type.g()), Integer.valueOf(WindowInsetsCompat.Type.b()), Integer.valueOf(WindowInsetsCompat.Type.d()), Integer.valueOf(WindowInsetsCompat.Type.j()), Integer.valueOf(WindowInsetsCompat.Type.f()), Integer.valueOf(WindowInsetsCompat.Type.k()), Integer.valueOf(WindowInsetsCompat.Type.c()));
    }

    private WindowMetricsCalculatorCompat() {
    }

    private final DisplayCutout f(Display display) {
        try {
            Constructor<?> constructor = Class.forName("android.view.DisplayInfo").getConstructor(null);
            constructor.setAccessible(true);
            Object objNewInstance = constructor.newInstance(null);
            Method declaredMethod = display.getClass().getDeclaredMethod("getDisplayInfo", objNewInstance.getClass());
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(display, objNewInstance);
            Field declaredField = objNewInstance.getClass().getDeclaredField("displayCutout");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(objNewInstance);
            if (obj instanceof DisplayCutout) {
                return (DisplayCutout) obj;
            }
        } catch (ClassNotFoundException e3) {
            Log.w(f54374c, e3);
        } catch (IllegalAccessException e4) {
            Log.w(f54374c, e4);
        } catch (InstantiationException e5) {
            Log.w(f54374c, e5);
        } catch (NoSuchFieldException e6) {
            Log.w(f54374c, e6);
        } catch (NoSuchMethodException e7) {
            Log.w(f54374c, e7);
        } catch (InvocationTargetException e8) {
            Log.w(f54374c, e8);
        }
        return null;
    }

    private final int g(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private final void i(Activity activity, Rect rect) {
        activity.getWindowManager().getDefaultDisplay().getRectSize(rect);
    }

    @Override // androidx.window.layout.WindowMetricsCalculator
    public WindowMetrics a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 30) {
            return ContextCompatHelperApi30.f54437a.c(context);
        }
        Context contextA = ContextCompatHelper.f54435a.a(context);
        if (contextA instanceof Activity) {
            return b((Activity) contextA);
        }
        if (!(contextA instanceof InputMethodService)) {
            throw new IllegalArgumentException(context + " is not a UiContext");
        }
        Object systemService = context.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        Intrinsics.checkNotNullExpressionValue(defaultDisplay, "wm.defaultDisplay");
        Point pointH = h(defaultDisplay);
        return new WindowMetrics(new Rect(0, 0, pointH.x, pointH.y), null, 2, null);
    }

    @Override // androidx.window.layout.WindowMetricsCalculator
    public WindowMetrics b(Activity activity) throws Exception {
        WindowInsetsCompat windowInsetsCompatA;
        Intrinsics.checkNotNullParameter(activity, "activity");
        int i3 = Build.VERSION.SDK_INT;
        Rect rectA = i3 >= 30 ? ContextCompatHelperApi30.f54437a.a(activity) : i3 >= 29 ? d(activity) : c(activity);
        if (i3 >= 30) {
            windowInsetsCompatA = e(activity);
        } else {
            windowInsetsCompatA = new WindowInsetsCompat.Builder().a();
            Intrinsics.checkNotNullExpressionValue(windowInsetsCompatA, "{\n            WindowInse…ilder().build()\n        }");
        }
        return new WindowMetrics(new Bounds(rectA), windowInsetsCompatA);
    }

    public final Rect c(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Rect rect = new Rect();
        Configuration configuration = activity.getResources().getConfiguration();
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            if (ActivityCompatHelperApi24.f54434a.a(activity)) {
                Object objInvoke = obj.getClass().getDeclaredMethod("getBounds", null).invoke(obj, null);
                Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type android.graphics.Rect");
                rect.set((Rect) objInvoke);
            } else {
                Object objInvoke2 = obj.getClass().getDeclaredMethod("getAppBounds", null).invoke(obj, null);
                Intrinsics.checkNotNull(objInvoke2, "null cannot be cast to non-null type android.graphics.Rect");
                rect.set((Rect) objInvoke2);
            }
        } catch (IllegalAccessException e3) {
            Log.w(f54374c, e3);
            i(activity, rect);
        } catch (NoSuchFieldException e4) {
            Log.w(f54374c, e4);
            i(activity, rect);
        } catch (NoSuchMethodException e5) {
            Log.w(f54374c, e5);
            i(activity, rect);
        } catch (InvocationTargetException e6) {
            Log.w(f54374c, e6);
            i(activity, rect);
        }
        Display currentDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        currentDisplay.getRealSize(point);
        ActivityCompatHelperApi24 activityCompatHelperApi24 = ActivityCompatHelperApi24.f54434a;
        if (!activityCompatHelperApi24.a(activity)) {
            int iG = g(activity);
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
        if ((rect.width() < point.x || rect.height() < point.y) && !activityCompatHelperApi24.a(activity)) {
            Intrinsics.checkNotNullExpressionValue(currentDisplay, "currentDisplay");
            DisplayCutout displayCutoutF = f(currentDisplay);
            if (displayCutoutF != null) {
                int i5 = rect.left;
                DisplayCompatHelperApi28 displayCompatHelperApi28 = DisplayCompatHelperApi28.f54438a;
                if (i5 == displayCompatHelperApi28.b(displayCutoutF)) {
                    rect.left = 0;
                }
                if (point.x - rect.right == displayCompatHelperApi28.c(displayCutoutF)) {
                    rect.right += displayCompatHelperApi28.c(displayCutoutF);
                }
                if (rect.top == displayCompatHelperApi28.d(displayCutoutF)) {
                    rect.top = 0;
                }
                if (point.y - rect.bottom == displayCompatHelperApi28.a(displayCutoutF)) {
                    rect.bottom += displayCompatHelperApi28.a(displayCutoutF);
                }
            }
        }
        return rect;
    }

    public final Rect d(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Configuration configuration = activity.getResources().getConfiguration();
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            Object objInvoke = obj.getClass().getDeclaredMethod("getBounds", null).invoke(obj, null);
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type android.graphics.Rect");
            return new Rect((Rect) objInvoke);
        } catch (IllegalAccessException e3) {
            Log.w(f54374c, e3);
            return c(activity);
        } catch (NoSuchFieldException e4) {
            Log.w(f54374c, e4);
            return c(activity);
        } catch (NoSuchMethodException e5) {
            Log.w(f54374c, e5);
            return c(activity);
        } catch (InvocationTargetException e6) {
            Log.w(f54374c, e6);
            return c(activity);
        }
    }

    public final WindowInsetsCompat e(Context context) throws Exception {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 30) {
            return ContextCompatHelperApi30.f54437a.b(context);
        }
        throw new Exception("Incompatible SDK version");
    }

    public final Point h(Display display) {
        Intrinsics.checkNotNullParameter(display, "display");
        Point point = new Point();
        display.getRealSize(point);
        return point;
    }
}
