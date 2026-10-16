package com.bumptech.glide.signature;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.bumptech.glide.load.Key;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.experimental.kJ.HcgZcEUYo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ApplicationVersionSignature {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentMap f67257a = new ConcurrentHashMap();

    private static String b(PackageInfo packageInfo) {
        return packageInfo != null ? String.valueOf(packageInfo.versionCode) : UUID.randomUUID().toString();
    }

    public static Key c(Context context) {
        String packageName = context.getPackageName();
        ConcurrentMap concurrentMap = f67257a;
        Key key = (Key) concurrentMap.get(packageName);
        if (key != null) {
            return key;
        }
        Key keyD = d(context);
        Key key2 = (Key) concurrentMap.putIfAbsent(packageName, keyD);
        return key2 == null ? keyD : key2;
    }

    private static Key d(Context context) {
        return new ObjectKey(b(a(context)));
    }

    private static PackageInfo a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e3) {
            Log.e("AppVersionSignature", HcgZcEUYo.EdgNFdVuiV + context.getPackageName(), e3);
            return null;
        }
    }
}
