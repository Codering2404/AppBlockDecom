package com.google.android.gms.common.wrappers;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Process;
import androidx.core.util.Pair;
import com.google.android.gms.common.util.PlatformVersion;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class PackageManagerWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Context f72307a;

    public PackageManagerWrapper(Context context) {
        this.f72307a = context;
    }

    public int a(String str) {
        return this.f72307a.checkCallingOrSelfPermission(str);
    }

    public int b(String str, String str2) {
        return this.f72307a.getPackageManager().checkPermission(str, str2);
    }

    public ApplicationInfo c(String str, int i3) {
        return this.f72307a.getPackageManager().getApplicationInfo(str, i3);
    }

    public CharSequence d(String str) {
        Context context = this.f72307a;
        return context.getPackageManager().getApplicationLabel(context.getPackageManager().getApplicationInfo(str, 0));
    }

    public Pair e(String str) throws PackageManager.NameNotFoundException {
        Context context = this.f72307a;
        ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
        return Pair.a(context.getPackageManager().getApplicationLabel(applicationInfo), context.getPackageManager().getApplicationIcon(applicationInfo));
    }

    public PackageInfo f(String str, int i3) {
        return this.f72307a.getPackageManager().getPackageInfo(str, i3);
    }

    public boolean g() {
        if (Binder.getCallingUid() == Process.myUid()) {
            return InstantApps.a(this.f72307a);
        }
        if (!PlatformVersion.e()) {
            return false;
        }
        Context context = this.f72307a;
        String nameForUid = context.getPackageManager().getNameForUid(Binder.getCallingUid());
        if (nameForUid != null) {
            return context.getPackageManager().isInstantApp(nameForUid);
        }
        return false;
    }

    public final boolean h(int i3, String str) {
        try {
            AppOpsManager appOpsManager = (AppOpsManager) this.f72307a.getSystemService("appops");
            if (appOpsManager == null) {
                throw new NullPointerException("context.getSystemService(Context.APP_OPS_SERVICE) is null");
            }
            appOpsManager.checkPackage(i3, str);
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }
}
