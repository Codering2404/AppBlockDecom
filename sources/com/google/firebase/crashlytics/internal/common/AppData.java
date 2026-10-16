package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class AppData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f88298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f88299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f88300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f88301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f88302e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f88303f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f88304g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DevelopmentPlatformProvider f88305h;

    public AppData(String str, String str2, List list, String str3, String str4, String str5, String str6, DevelopmentPlatformProvider developmentPlatformProvider) {
        this.f88298a = str;
        this.f88299b = str2;
        this.f88300c = list;
        this.f88301d = str3;
        this.f88302e = str4;
        this.f88303f = str5;
        this.f88304g = str6;
        this.f88305h = developmentPlatformProvider;
    }

    public static AppData a(Context context, IdManager idManager, String str, String str2, List list, DevelopmentPlatformProvider developmentPlatformProvider) throws PackageManager.NameNotFoundException {
        String packageName = context.getPackageName();
        String strG = idManager.g();
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        String strB = b(packageInfo);
        String str3 = packageInfo.versionName;
        if (str3 == null) {
            str3 = "0.0";
        }
        return new AppData(str, str2, list, strG, packageName, strB, str3, developmentPlatformProvider);
    }

    private static String b(PackageInfo packageInfo) {
        return Long.toString(packageInfo.getLongVersionCode());
    }
}
