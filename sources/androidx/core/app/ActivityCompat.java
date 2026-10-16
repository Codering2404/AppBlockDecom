package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.ActivityCompat;
import androidx.core.app.SharedElementCallback;
import androidx.core.content.ContextCompat;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ActivityCompat extends ContextCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static PermissionCompatDelegate f33572a;

    /* JADX INFO: renamed from: androidx.core.app.ActivityCompat$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String[] f33573a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f33574b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f33575c;

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[this.f33573a.length];
            PackageManager packageManager = this.f33574b.getPackageManager();
            String packageName = this.f33574b.getPackageName();
            int length = this.f33573a.length;
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = packageManager.checkPermission(this.f33573a[i3], packageName);
            }
            ((OnRequestPermissionsResultCallback) this.f33574b).onRequestPermissionsResult(this.f33575c, this.f33573a, iArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api21Impl {
        static void a(Activity activity) {
            activity.finishAfterTransition();
        }

        static void b(Activity activity) {
            activity.postponeEnterTransition();
        }

        static void c(Activity activity, android.app.SharedElementCallback sharedElementCallback) {
            activity.setEnterSharedElementCallback(sharedElementCallback);
        }

        static void d(Activity activity, android.app.SharedElementCallback sharedElementCallback) {
            activity.setExitSharedElementCallback(sharedElementCallback);
        }

        static void e(Activity activity) {
            activity.startPostponedEnterTransition();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api22Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api23Impl {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static void a(Object obj) {
            ((SharedElementCallback.OnSharedElementsReadyListener) obj).onSharedElementsReady();
        }

        static void b(Activity activity, String[] strArr, int i3) {
            activity.requestPermissions(strArr, i3);
        }

        static boolean c(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api28Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api30Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api31Impl {
        static boolean a(Activity activity, String str) {
            try {
                return ((Boolean) PackageManager.class.getMethod("shouldShowRequestPermissionRationale", String.class).invoke(activity.getApplication().getPackageManager(), str)).booleanValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return activity.shouldShowRequestPermissionRationale(str);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api32Impl {
        static boolean a(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnRequestPermissionsResultCallback {
        void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface PermissionCompatDelegate {
        boolean a(Activity activity, String[] strArr, int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface RequestPermissionsRequestCodeValidator {
        void validateRequestPermissionsRequestCode(int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SharedElementCallback21Impl extends android.app.SharedElementCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SharedElementCallback f33576a;

        SharedElementCallback21Impl(SharedElementCallback sharedElementCallback) {
            this.f33576a = sharedElementCallback;
        }

        @Override // android.app.SharedElementCallback
        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            return this.f33576a.b(view, matrix, rectF);
        }

        @Override // android.app.SharedElementCallback
        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return this.f33576a.c(context, parcelable);
        }

        @Override // android.app.SharedElementCallback
        public void onMapSharedElements(List list, Map map) {
            this.f33576a.d(list, map);
        }

        @Override // android.app.SharedElementCallback
        public void onRejectSharedElements(List list) {
            this.f33576a.e(list);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementEnd(List list, List list2, List list3) {
            this.f33576a.f(list, list2, list3);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementStart(List list, List list2, List list3) {
            this.f33576a.g(list, list2, list3);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementsArrived(List list, List list2, final SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
            this.f33576a.h(list, list2, new SharedElementCallback.OnSharedElementsReadyListener() { // from class: androidx.core.app.a
                @Override // androidx.core.app.SharedElementCallback.OnSharedElementsReadyListener
                public final void onSharedElementsReady() {
                    ActivityCompat.Api23Impl.a(onSharedElementsReadyListener);
                }
            });
        }
    }

    public static void a(Activity activity) {
        activity.finishAffinity();
    }

    public static void b(Activity activity) {
        Api21Impl.a(activity);
    }

    public static void c(Activity activity) {
        Api21Impl.b(activity);
    }

    public static void d(Activity activity) {
        activity.recreate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void e(Activity activity, String[] strArr, int i3) {
        PermissionCompatDelegate permissionCompatDelegate = f33572a;
        if (permissionCompatDelegate == null || !permissionCompatDelegate.a(activity, strArr, i3)) {
            HashSet hashSet = new HashSet();
            for (int i4 = 0; i4 < strArr.length; i4++) {
                if (TextUtils.isEmpty(strArr[i4])) {
                    throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
                }
                if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(strArr[i4], "android.permission.POST_NOTIFICATIONS")) {
                    hashSet.add(Integer.valueOf(i4));
                }
            }
            int size = hashSet.size();
            String[] strArr2 = size > 0 ? new String[strArr.length - size] : strArr;
            if (size > 0) {
                if (size == strArr.length) {
                    return;
                }
                int i5 = 0;
                for (int i6 = 0; i6 < strArr.length; i6++) {
                    if (!hashSet.contains(Integer.valueOf(i6))) {
                        strArr2[i5] = strArr[i6];
                        i5++;
                    }
                }
            }
            if (activity instanceof RequestPermissionsRequestCodeValidator) {
                ((RequestPermissionsRequestCodeValidator) activity).validateRequestPermissionsRequestCode(i3);
            }
            Api23Impl.b(activity, strArr, i3);
        }
    }

    public static void f(Activity activity, SharedElementCallback sharedElementCallback) {
        Api21Impl.c(activity, sharedElementCallback != null ? new SharedElementCallback21Impl(sharedElementCallback) : null);
    }

    public static void g(Activity activity, SharedElementCallback sharedElementCallback) {
        Api21Impl.d(activity, sharedElementCallback != null ? new SharedElementCallback21Impl(sharedElementCallback) : null);
    }

    public static boolean h(Activity activity, String str) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 33 || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return i3 >= 32 ? Api32Impl.a(activity, str) : i3 == 31 ? Api31Impl.a(activity, str) : Api23Impl.c(activity, str);
        }
        return false;
    }

    public static void i(Activity activity, Intent intent, int i3, Bundle bundle) {
        activity.startActivityForResult(intent, i3, bundle);
    }

    public static void j(Activity activity, IntentSender intentSender, int i3, Intent intent, int i4, int i5, int i6, Bundle bundle) {
        activity.startIntentSenderForResult(intentSender, i3, intent, i4, i5, i6, bundle);
    }

    public static void k(Activity activity) {
        Api21Impl.e(activity);
    }
}
