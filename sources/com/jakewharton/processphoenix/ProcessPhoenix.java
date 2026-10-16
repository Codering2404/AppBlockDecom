package com.jakewharton.processphoenix;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Process;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class ProcessPhoenix {
    private static Intent a(Context context) {
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getPackageManager();
        Intent leanbackLaunchIntentForPackage = packageManager.hasSystemFeature("android.software.leanback") ? packageManager.getLeanbackLaunchIntentForPackage(packageName) : null;
        if (leanbackLaunchIntentForPackage == null) {
            leanbackLaunchIntentForPackage = packageManager.getLaunchIntentForPackage(packageName);
        }
        if (leanbackLaunchIntentForPackage != null) {
            return leanbackLaunchIntentForPackage;
        }
        throw new IllegalStateException("Unable to determine default activity for " + packageName + ". Does an activity specify the DEFAULT category in its intent filter?");
    }

    public static void b(Context context) {
        c(context, a(context));
    }

    public static void c(Context context, Intent... intentArr) {
        if (intentArr.length < 1) {
            throw new IllegalArgumentException("intents cannot be empty");
        }
        intentArr[0].addFlags(268468224);
        Intent intent = new Intent(context, (Class<?>) PhoenixActivity.class);
        intent.addFlags(268435456);
        intent.putParcelableArrayListExtra("phoenix_restart_intents", new ArrayList<>(Arrays.asList(intentArr)));
        intent.putExtra("phoenix_main_process_pid", Process.myPid());
        context.startActivity(intent);
    }
}
