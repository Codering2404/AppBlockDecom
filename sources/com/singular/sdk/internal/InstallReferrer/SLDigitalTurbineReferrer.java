package com.singular.sdk.internal.InstallReferrer;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import com.singular.sdk.internal.SingularLog;
import com.singular.sdk.internal.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class SLDigitalTurbineReferrer implements SLInstallReferrerService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SingularLog f92576a = SingularLog.f(SLDigitalTurbineReferrer.class.getSimpleName());

    private boolean a(Context context, String str, ResolveInfo resolveInfo) {
        return str != null && context.getPackageManager().checkPermission(str, resolveInfo.providerInfo.packageName) == 0;
    }

    private String b(Context context, ResolveInfo resolveInfo) {
        String str = resolveInfo.providerInfo.authority;
        if (Utils.U(str)) {
            return null;
        }
        return g(context, str);
    }

    private String d(String str, String str2) {
        return String.format("content://%s/%s", str, str2);
    }

    private String e(Context context, String str, ContentProviderClient contentProviderClient) {
        try {
            Uri uri = Uri.parse(str);
            String[] strArr = {"encrypted_data"};
            Cursor cursorQuery = contentProviderClient != null ? contentProviderClient.query(uri, strArr, "package_name=?", new String[]{context.getPackageName()}, null) : context.getContentResolver().query(uri, strArr, null, null, null);
            if (cursorQuery == null) {
                f92576a.b("Read content provider cursor null content uri [%s]", str);
                return null;
            }
            if (!cursorQuery.moveToFirst()) {
                f92576a.b("Read content provider cursor empty content uri [%s]", str);
                cursorQuery.close();
                return null;
            }
            String string = cursorQuery.getString(0);
            f92576a.a("Read Content Provider Payload is " + string);
            cursorQuery.close();
            return string;
        } catch (Throwable th) {
            f92576a.e("Exception read content provider uri [%s] error [%s]", str, th.getMessage());
            return null;
        }
    }

    private String f(Context context, String str) {
        try {
            List<ResolveInfo> listQueryIntentContentProviders = Build.VERSION.SDK_INT >= 33 ? context.getPackageManager().queryIntentContentProviders(new Intent("com.singular.preinstall.READ_PERMISSION_SINGULAR"), PackageManager.ResolveInfoFlags.of(131072L)) : context.getPackageManager().queryIntentContentProviders(new Intent("com.singular.preinstall.READ_PERMISSION_SINGULAR"), 131072);
            ArrayList arrayList = new ArrayList();
            for (ResolveInfo resolveInfo : listQueryIntentContentProviders) {
                if (a(context, str, resolveInfo)) {
                    String strB = b(context, resolveInfo);
                    if (!Utils.U(strB)) {
                        arrayList.add(strB);
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                f92576a.a("Payload read successfully from URI: " + arrayList);
                return (String) arrayList.get(0);
            }
        } catch (Throwable th) {
            f92576a.c("Failed to read content provider intent action: " + Utils.l(th));
        }
        f92576a.a("No payloads found in content providers.");
        return null;
    }

    private String g(Context context, String str) {
        try {
            ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(str);
            String strE = e(context, d(str, "trackers"), contentProviderClientAcquireUnstableContentProviderClient);
            contentProviderClientAcquireUnstableContentProviderClient.release();
            return strE;
        } catch (Throwable th) {
            f92576a.c("Failed to read content provider with client: " + Utils.l(th));
            return null;
        }
    }

    public void c(Context context, SLInstallReferrerCompletionHandler sLInstallReferrerCompletionHandler) {
        if (context == null) {
            sLInstallReferrerCompletionHandler.a(null);
            return;
        }
        HashMap map = new HashMap();
        String strF = f(context, "android.permission.INSTALL_PACKAGES");
        if (strF == null) {
            sLInstallReferrerCompletionHandler.a(null);
        } else {
            map.put("dt_referrer", strF);
            sLInstallReferrerCompletionHandler.a(map);
        }
    }
}
