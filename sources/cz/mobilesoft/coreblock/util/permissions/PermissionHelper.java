package cz.mobilesoft.coreblock.util.permissions;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.dto.Pair;
import cz.mobilesoft.coreblock.enums.Permission;
import cz.mobilesoft.coreblock.scene.permission.PermissionWizardActivity;
import cz.mobilesoft.coreblock.service.CheckGrantedPermissionService;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.CrashHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
public class PermissionHelper {
    public static boolean a(Activity activity, Map map) {
        boolean zShouldShowRequestPermissionRationale;
        boolean z2;
        Boolean bool;
        Boolean bool2 = (Boolean) map.get("android.permission.ACCESS_FINE_LOCATION");
        if (bool2 == null || bool2.booleanValue()) {
            zShouldShowRequestPermissionRationale = false;
            z2 = false;
        } else {
            zShouldShowRequestPermissionRationale = activity.shouldShowRequestPermissionRationale("android.permission.ACCESS_FINE_LOCATION");
            z2 = true;
        }
        if (Build.VERSION.SDK_INT >= 29 && (bool = (Boolean) map.get("android.permission.ACCESS_BACKGROUND_LOCATION")) != null && !bool.booleanValue()) {
            zShouldShowRequestPermissionRationale |= activity.shouldShowRequestPermissionRationale("android.permission.ACCESS_BACKGROUND_LOCATION");
            z2 = true;
        }
        if (!z2) {
            return true;
        }
        PrefManager.f126839a.G2(zShouldShowRequestPermissionRationale);
        return false;
    }

    public static String[] b() {
        int i3 = Build.VERSION.SDK_INT;
        return i3 >= 30 ? h(LockieApplication.g()) ? new String[]{"android.permission.ACCESS_BACKGROUND_LOCATION"} : new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"} : i3 == 29 ? new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_BACKGROUND_LOCATION"} : new String[]{"android.permission.ACCESS_FINE_LOCATION"};
    }

    public static Pair c() {
        return new Pair(Integer.valueOf(p() ? R.string.sn : R.string.rn), Integer.valueOf(R.string.qn));
    }

    public static String[] d() {
        ArrayList arrayList = new ArrayList(Arrays.asList(b()));
        arrayList.add(0, "android.permission.ACCESS_WIFI_STATE");
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static boolean e(Context context) {
        return Build.VERSION.SDK_INT >= 29 ? f(context) && h(context) : h(context);
    }

    public static boolean f(Context context) {
        return Build.VERSION.SDK_INT < 29 || ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_BACKGROUND_LOCATION") == 0;
    }

    public static boolean g(Context context) {
        return Settings.canDrawOverlays(context);
    }

    public static boolean h(Context context) {
        return ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    public static boolean i(Context context) {
        return NotificationManagerCompat.e(context).contains(context.getPackageName());
    }

    public static List j(Context context, String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (ContextCompat.checkSelfPermission(context, str) != 0) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static boolean k(Context context) {
        try {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            if (appOpsManager != null) {
                try {
                    return appOpsManager.checkOpNoThrow("android:get_usage_stats", Process.myUid(), context.getPackageName()) == 0;
                } catch (Throwable th) {
                    CrashHelper.j(th);
                }
            }
        } catch (NoClassDefFoundError unused) {
        }
        return true;
    }

    public static boolean l(Context context) {
        return m(context, LockieApplication.f());
    }

    public static boolean m(Context context, Class cls) {
        if (cls == null) {
            return false;
        }
        ComponentName componentName = new ComponentName(context, (Class<?>) cls);
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_accessibility_services");
        if (string == null) {
            return false;
        }
        TextUtils.SimpleStringSplitter simpleStringSplitter = new TextUtils.SimpleStringSplitter(':');
        simpleStringSplitter.setString(string);
        while (simpleStringSplitter.hasNext()) {
            ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(simpleStringSplitter.next());
            if (componentNameUnflattenFromString != null && componentNameUnflattenFromString.equals(componentName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean n() {
        return Build.VERSION.SDK_INT >= 33;
    }

    public static boolean o(Context context) {
        if (n()) {
            return NotificationManagerCompat.d(context).a();
        }
        return true;
    }

    public static boolean p() {
        return Build.MANUFACTURER.toLowerCase().contains("samsung");
    }

    public static boolean q(Context context, ComponentName componentName) {
        try {
            context.startActivity(new Intent("android.settings.APP_NOTIFICATION_SETTINGS").putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName()));
            Permission.POST_NOTIFICATIONS post_notifications = new Permission.POST_NOTIFICATIONS();
            CheckGrantedPermissionService.t(context, post_notifications, post_notifications.g(context), componentName);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    public static void r(Context context) {
        PermissionWizardActivity.o0(context);
    }
}
