package cz.mobilesoft.coreblock.util.runnability;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build;
import com.facebook.internal.NativeProtocol;
import cz.mobilesoft.coreblock.scene.permission.PermissionAutoStartHintActivity;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class AutoStartPermissionHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AutoStartPermissionHelper f129453a = new AutoStartPermissionHelper();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List f129454b = CollectionsKt.listOf((Object[]) new String[]{"com.asus.mobilemanager", "com.miui.securitycenter", "com.letv.android.letvsafe", "com.huawei.systemmanager", "com.coloros.safecenter", "com.oppo.safe", "com.iqoo.secure", "com.vivo.permissionmanager", "com.evenwell.powersaving.g3", "com.huawei.systemmanager", "com.samsung.android.lool", "com.oneplus.security"});

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f129455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f129456d;

    static {
        String BRAND = Build.BRAND;
        Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = BRAND.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        f129455c = lowerCase;
        f129456d = 8;
    }

    private AutoStartPermissionHelper() {
    }

    private final boolean a(Context context, List list, List list2) {
        List list3 = list;
        if ((list3 instanceof Collection) && list3.isEmpty()) {
            return false;
        }
        Iterator it = list3.iterator();
        while (it.hasNext()) {
            if (f129453a.r(context, (String) it.next())) {
                return t(context, list2);
            }
        }
        return false;
    }

    private final Pair b(boolean z2) {
        return TuplesKt.a(CollectionsKt.listOf("com.asus.mobilemanager"), CollectionsKt.listOf((Object[]) new Intent[]{g("com.asus.mobilemanager", "com.asus.mobilemanager.powersaver.PowerSaverSettings", z2), g("com.asus.mobilemanager", "com.asus.mobilemanager.autostart.AutoStartActivity", z2)}));
    }

    public static /* synthetic */ boolean d(AutoStartPermissionHelper autoStartPermissionHelper, Context context, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        return autoStartPermissionHelper.c(context, z2);
    }

    private final Pair e(boolean z2) {
        return TuplesKt.a(CollectionsKt.listOf("com.huawei.systemmanager"), CollectionsKt.listOf(g("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity", z2)));
    }

    private final Pair f(boolean z2) {
        return TuplesKt.a(CollectionsKt.listOf("com.huawei.systemmanager"), CollectionsKt.listOf((Object[]) new Intent[]{g("com.huawei.systemmanager", "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity", z2), g("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity", z2)}));
    }

    private final Intent g(String str, String str2, boolean z2) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str, str2));
        if (z2) {
            intent.addFlags(268435456);
        }
        return intent;
    }

    private final Pair h(boolean z2) {
        return TuplesKt.a(CollectionsKt.listOf("com.letv.android.letvsafe"), CollectionsKt.listOf(g("com.letv.android.letvsafe", "com.letv.android.letvsafe.AutobootManageActivity", z2)));
    }

    private final Pair i(boolean z2) {
        return TuplesKt.a(CollectionsKt.listOf("com.evenwell.powersaving.g3"), CollectionsKt.listOf(g("com.evenwell.powersaving.g3", "com.evenwell.powersaving.g3.exception.PowerSaverExceptionActivity", z2)));
    }

    private final Pair j(boolean z2) {
        return TuplesKt.a(CollectionsKt.listOf("com.oneplus.security"), CollectionsKt.listOf(g("com.oneplus.security", "com.oneplus.security.chainlaunch.view.ChainLaunchAppListActivity", z2)));
    }

    private final Pair k(boolean z2) {
        return TuplesKt.a(CollectionsKt.listOf((Object[]) new String[]{"com.coloros.safecenter", "com.oppo.safe"}), CollectionsKt.listOf((Object[]) new Intent[]{g("com.coloros.safecenter", "com.coloros.safecenter.permission.startup.StartupAppListActivity", z2), g("com.oppo.safe", "com.oppo.safe.permission.startup.StartupAppListActivity", z2), g("com.coloros.safecenter", "com.coloros.safecenter.startupapp.StartupAppListActivity", z2)}));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final Pair l(boolean z2) {
        String str = f129455c;
        switch (str.hashCode()) {
            case -1320380160:
                if (str.equals("oneplus")) {
                    return j(z2);
                }
                return null;
            case -1206476313:
                if (str.equals("huawei")) {
                    return f(z2);
                }
                return null;
            case -759499589:
                if (!str.equals("xiaomi")) {
                    return null;
                }
                break;
            case 3003984:
                if (str.equals("asus")) {
                    return b(z2);
                }
                return null;
            case 3318203:
                if (str.equals("letv")) {
                    return h(z2);
                }
                return null;
            case 3418016:
                if (str.equals("oppo")) {
                    return k(z2);
                }
                return null;
            case 3446443:
                if (!str.equals("poco")) {
                    return null;
                }
                break;
            case 3620012:
                if (str.equals("vivo")) {
                    return o(z2);
                }
                return null;
            case 99462250:
                if (str.equals("honor")) {
                    return e(z2);
                }
                return null;
            case 105000290:
                if (str.equals("nokia")) {
                    return i(z2);
                }
                return null;
            case 108389869:
                if (!str.equals("redmi")) {
                    return null;
                }
                break;
            case 1864941562:
                if (str.equals("samsung")) {
                    return n(z2);
                }
                return null;
            default:
                return null;
        }
        return p(z2);
    }

    private final Pair n(boolean z2) {
        return TuplesKt.a(CollectionsKt.listOf("com.samsung.android.lool"), CollectionsKt.listOf((Object[]) new Intent[]{g("com.samsung.android.lool", "com.samsung.android.sm.ui.battery.BatteryActivity", z2), g("com.samsung.android.lool", "com.samsung.android.sm.battery.ui.usage.CheckableAppListActivity", z2), g("com.samsung.android.lool", "com.samsung.android.sm.battery.ui.BatteryActivity", z2)}));
    }

    private final Pair o(boolean z2) {
        return TuplesKt.a(CollectionsKt.listOf((Object[]) new String[]{"com.iqoo.secure", "com.vivo.permissionmanager"}), CollectionsKt.listOf((Object[]) new Intent[]{g("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.AddWhiteListActivity", z2), g("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.BgStartUpManagerActivity", z2), g("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.BgStartUpManager", z2)}));
    }

    private final Pair p(boolean z2) {
        return TuplesKt.a(CollectionsKt.listOf("com.miui.securitycenter"), CollectionsKt.listOf(g("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity", z2)));
    }

    private final boolean q(Context context, Intent intent) {
        Intrinsics.checkNotNullExpressionValue(context.getPackageManager().queryIntentActivities(intent, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST), "queryIntentActivities(...)");
        return !r2.isEmpty();
    }

    private final boolean r(Context context, String str) {
        List<ApplicationInfo> installedApplications = context.getPackageManager().getInstalledApplications(0);
        Intrinsics.checkNotNullExpressionValue(installedApplications, "getInstalledApplications(...)");
        Iterator<ApplicationInfo> it = installedApplications.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next().packageName, str)) {
                return true;
            }
        }
        return false;
    }

    private final boolean s(Context context, boolean z2) {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            if (z2) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
            PermissionAutoStartHintActivity.f111786k.a(context);
            return true;
        } catch (Exception e3) {
            e3.printStackTrace();
            return false;
        }
    }

    private final boolean t(Context context, List list) throws Exception {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Intent intent = (Intent) it.next();
            AutoStartPermissionHelper autoStartPermissionHelper = f129453a;
            if (autoStartPermissionHelper.q(context, intent)) {
                autoStartPermissionHelper.u(context, intent);
                PermissionAutoStartHintActivity.f111786k.a(context);
                return true;
            }
        }
        return false;
    }

    private final void u(Context context, Intent intent) throws Exception {
        try {
            context.startActivity(intent);
        } catch (Exception e3) {
            e3.printStackTrace();
            throw e3;
        }
    }

    public final boolean c(Context context, boolean z2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Pair pairL = l(z2);
        if (pairL == null) {
            return false;
        }
        AutoStartPermissionHelper autoStartPermissionHelper = f129453a;
        boolean zA = autoStartPermissionHelper.a(context, (List) pairL.e(), (List) pairL.f());
        return (zA || !Intrinsics.areEqual(f129455c, "oppo")) ? zA : autoStartPermissionHelper.s(context, z2);
    }

    public final Intent m(Context context) {
        List<Intent> list;
        Intrinsics.checkNotNullParameter(context, "context");
        Pair pairL = l(false);
        if (pairL == null || (list = (List) pairL.f()) == null) {
            return null;
        }
        for (Intent intent : list) {
            if (f129453a.q(context, intent)) {
                return intent;
            }
        }
        return null;
    }
}
