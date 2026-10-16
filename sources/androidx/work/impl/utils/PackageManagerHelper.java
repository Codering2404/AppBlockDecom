package androidx.work.impl.utils;

import android.content.ComponentName;
import android.content.Context;
import androidx.work.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class PackageManagerHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f55160a = Logger.i("PackageManagerHelper");

    private static int a(Context context, String str) {
        return context.getPackageManager().getComponentEnabledSetting(new ComponentName(context, str));
    }

    private static boolean b(int i3, boolean z2) {
        return i3 == 0 ? z2 : i3 == 1;
    }

    public static void c(Context context, Class cls, boolean z2) {
        try {
            if (z2 == b(a(context, cls.getName()), false)) {
                Logger.e().a(f55160a, "Skipping component enablement for " + cls.getName());
                return;
            }
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls.getName()), z2 ? 1 : 2, 1);
            Logger loggerE = Logger.e();
            String str = f55160a;
            StringBuilder sb = new StringBuilder();
            sb.append(cls.getName());
            sb.append(" ");
            sb.append(z2 ? "enabled" : "disabled");
            loggerE.a(str, sb.toString());
        } catch (Exception e3) {
            Logger loggerE2 = Logger.e();
            String str2 = f55160a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cls.getName());
            sb2.append("could not be ");
            sb2.append(z2 ? "enabled" : "disabled");
            loggerE2.b(str2, sb2.toString(), e3);
        }
    }
}
