package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.view.View;
import com.facebook.internal.NativeProtocol;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbqc {
    public static final Intent zza(Uri uri, Context context, zzbap zzbapVar, View view, zzflc zzflcVar) {
        if (uri == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setData(uri);
        intent.setAction("android.intent.action.VIEW");
        return intent;
    }

    public static final ResolveInfo zzb(Intent intent, Context context, zzbap zzbapVar, View view, zzflc zzflcVar) {
        return zzc(intent, new ArrayList(), context, zzbapVar, view, zzflcVar);
    }

    public static final ResolveInfo zzc(Intent intent, ArrayList arrayList, Context context, zzbap zzbapVar, View view, zzflc zzflcVar) {
        ResolveInfo resolveInfo = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
            ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(intent, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
            if (listQueryIntentActivities != null && resolveInfoResolveActivity != null) {
                int i3 = 0;
                while (true) {
                    if (i3 >= listQueryIntentActivities.size()) {
                        break;
                    }
                    if (resolveInfoResolveActivity.activityInfo.name.equals(listQueryIntentActivities.get(i3).activityInfo.name)) {
                        resolveInfo = resolveInfoResolveActivity;
                        break;
                    }
                    i3++;
                }
            }
            arrayList.addAll(listQueryIntentActivities);
            return resolveInfo;
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzt.l().zzg(th, "OpenSystemBrowserHandler.getDefaultBrowserResolverForIntent");
            return resolveInfo;
        }
    }

    public static final Intent zzd(Intent intent, ResolveInfo resolveInfo, Context context, zzbap zzbapVar, View view, zzflc zzflcVar) {
        Intent intent2 = new Intent(intent);
        ActivityInfo activityInfo = resolveInfo.activityInfo;
        intent2.setClassName(activityInfo.packageName, activityInfo.name);
        return intent2;
    }
}
