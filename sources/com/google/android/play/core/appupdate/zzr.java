package com.google.android.play.core.appupdate;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.install.InstallException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzr {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final com.google.android.play.core.appupdate.internal.zzm f82926e = new com.google.android.play.core.appupdate.internal.zzm("AppUpdateService");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Intent f82927f = new Intent("com.google.android.play.core.install.BIND_UPDATE_SERVICE").setPackage("com.android.vending");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.google.android.play.core.appupdate.internal.zzx f82928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f82929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f82930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzt f82931d;

    static /* bridge */ /* synthetic */ Bundle b(zzr zzrVar, String str) {
        Integer numValueOf;
        Bundle bundle = new Bundle();
        bundle.putAll(h());
        bundle.putString("package.name", str);
        try {
            numValueOf = Integer.valueOf(zzrVar.f82930c.getPackageManager().getPackageInfo(zzrVar.f82930c.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
            f82926e.b("The current version of the app could not be retrieved", new Object[0]);
            numValueOf = null;
        }
        if (numValueOf != null) {
            bundle.putInt("app.version.code", numValueOf.intValue());
        }
        return bundle;
    }

    static /* bridge */ /* synthetic */ AppUpdateInfo e(zzr zzrVar, Bundle bundle, String str) {
        int i3 = bundle.getInt("version.code", -1);
        int i4 = bundle.getInt("update.availability");
        int i5 = bundle.getInt("install.status", 0);
        Integer numValueOf = bundle.getInt("client.version.staleness", -1) == -1 ? null : Integer.valueOf(bundle.getInt("client.version.staleness"));
        int i6 = bundle.getInt("in.app.update.priority", 0);
        long j3 = bundle.getLong("bytes.downloaded");
        long j4 = bundle.getLong("total.bytes.to.download");
        long j5 = bundle.getLong("additional.size.required");
        long jA = zzrVar.f82931d.a();
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("blocking.intent");
        PendingIntent pendingIntent2 = (PendingIntent) bundle.getParcelable("nonblocking.intent");
        PendingIntent pendingIntent3 = (PendingIntent) bundle.getParcelable("blocking.destructive.intent");
        PendingIntent pendingIntent4 = (PendingIntent) bundle.getParcelable("nonblocking.destructive.intent");
        HashMap map = new HashMap();
        map.put("blocking.destructive.intent", j(bundle.getIntegerArrayList("update.precondition.failures:blocking.destructive.intent")));
        map.put("nonblocking.destructive.intent", j(bundle.getIntegerArrayList("update.precondition.failures:nonblocking.destructive.intent")));
        map.put("blocking.intent", j(bundle.getIntegerArrayList("update.precondition.failures:blocking.intent")));
        map.put("nonblocking.intent", j(bundle.getIntegerArrayList("update.precondition.failures:nonblocking.intent")));
        return AppUpdateInfo.h(str, i3, i4, i5, numValueOf, i6, j3, j4, j5, jA, pendingIntent, pendingIntent2, pendingIntent3, pendingIntent4, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bundle h() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        Map mapA = com.google.android.play.core.appupdate.internal.zzi.a("app_update");
        bundle2.putInt("playcore_version_code", ((Integer) mapA.get("java")).intValue());
        if (mapA.containsKey(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE)) {
            bundle2.putInt("playcore_native_version", ((Integer) mapA.get(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE)).intValue());
        }
        if (mapA.containsKey("unity")) {
            bundle2.putInt("playcore_unity_version", ((Integer) mapA.get("unity")).intValue());
        }
        bundle.putAll(bundle2);
        bundle.putInt("playcore.version.code", 11004);
        return bundle;
    }

    private static Task i() {
        f82926e.b("onError(%d)", -9);
        return Tasks.forException(new InstallException(-9));
    }

    private static HashSet j(ArrayList arrayList) {
        HashSet hashSet = new HashSet();
        if (arrayList != null) {
            hashSet.addAll(arrayList);
        }
        return hashSet;
    }

    public final Task d(String str) {
        if (this.f82928a == null) {
            return i();
        }
        f82926e.d("requestUpdateInfo(%s)", str);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f82928a.s(new zzm(this, taskCompletionSource, str, taskCompletionSource), taskCompletionSource);
        return taskCompletionSource.getTask();
    }
}
