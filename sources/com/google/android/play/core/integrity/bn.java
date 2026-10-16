package com.google.android.play.core.integrity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class bn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final com.google.android.play.integrity.internal.ae f83031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.play.integrity.internal.s f83032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f83033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TaskCompletionSource f83034d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final at f83035e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final k f83036f;

    bn(Context context, com.google.android.play.integrity.internal.s sVar, at atVar, k kVar) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f83034d = taskCompletionSource;
        this.f83033c = context.getPackageName();
        this.f83032b = sVar;
        this.f83035e = atVar;
        this.f83036f = kVar;
        com.google.android.play.integrity.internal.ae aeVar = new com.google.android.play.integrity.internal.ae(context, sVar, "ExpressIntegrityService", bo.f83037a, new com.google.android.play.integrity.internal.z() { // from class: com.google.android.play.core.integrity.bd
            @Override // com.google.android.play.integrity.internal.z
            public final Object a(IBinder iBinder) {
                return com.google.android.play.integrity.internal.h.x3(iBinder);
            }
        }, null);
        this.f83031a = aeVar;
        aeVar.c().post(new be(this, taskCompletionSource, context));
    }

    static /* bridge */ /* synthetic */ Bundle a(bn bnVar, String str, long j3, long j4, int i3) {
        Bundle bundle = new Bundle();
        bundle.putString("package.name", bnVar.f83033c);
        bundle.putLong("cloud.prj", j3);
        bundle.putString("nonce", str);
        bundle.putLong("warm.up.sid", j4);
        bundle.putInt("playcore.integrity.version.major", 1);
        bundle.putInt("playcore.integrity.version.minor", 3);
        bundle.putInt("playcore.integrity.version.patch", 0);
        bundle.putInt("webview.request.mode", 0);
        ArrayList arrayList = new ArrayList();
        com.google.android.play.integrity.internal.d.b(5, arrayList);
        bundle.putParcelableArrayList("event_timestamps", new ArrayList<>(com.google.android.play.integrity.internal.d.a(arrayList)));
        return bundle;
    }

    static /* bridge */ /* synthetic */ Bundle b(bn bnVar, long j3, int i3) {
        Bundle bundle = new Bundle();
        bundle.putString("package.name", bnVar.f83033c);
        bundle.putLong("cloud.prj", j3);
        bundle.putInt("playcore.integrity.version.major", 1);
        bundle.putInt("playcore.integrity.version.minor", 3);
        bundle.putInt("playcore.integrity.version.patch", 0);
        bundle.putInt("webview.request.mode", 0);
        ArrayList arrayList = new ArrayList();
        com.google.android.play.integrity.internal.d.b(4, arrayList);
        bundle.putParcelableArrayList("event_timestamps", new ArrayList<>(com.google.android.play.integrity.internal.d.a(arrayList)));
        return bundle;
    }

    static /* bridge */ /* synthetic */ boolean k(bn bnVar) {
        return bnVar.f83034d.getTask().isSuccessful() && ((Integer) bnVar.f83034d.getTask().getResult()).intValue() == 0;
    }

    final Task c(Activity activity, Bundle bundle) {
        int i3 = bundle.getInt("dialog.intent.type");
        this.f83032b.d("requestAndShowDialog(%s)", Integer.valueOf(i3));
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f83031a.t(new bh(this, taskCompletionSource, bundle, activity, taskCompletionSource, i3), taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    public final Task d(String str, long j3, long j4, int i3) {
        this.f83032b.d("requestExpressIntegrityToken(%s)", Long.valueOf(j4));
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f83031a.t(new bg(this, taskCompletionSource, 0, str, j3, j4, taskCompletionSource), taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    public final Task e(long j3, int i3) {
        this.f83032b.d("warmUpIntegrityToken(%s)", Long.valueOf(j3));
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f83031a.t(new bf(this, taskCompletionSource, 0, j3, taskCompletionSource), taskCompletionSource);
        return taskCompletionSource.getTask();
    }
}
