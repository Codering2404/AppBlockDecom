package com.google.android.play.core.integrity;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f83076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f83077c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f83079e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.play.integrity.internal.s f83075a = new com.google.android.play.integrity.internal.s("IntegrityDialogWrapper");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f83078d = new Object();

    y(String str, long j3) {
        this.f83076b = str;
        this.f83077c = j3;
    }

    public final Task a(Activity activity, int i3) {
        synchronized (this.f83078d) {
            try {
                if (this.f83079e) {
                    return Tasks.forResult(0);
                }
                this.f83079e = true;
                this.f83075a.a("checkAndShowDialog(%s)", Integer.valueOf(i3));
                Bundle bundle = new Bundle();
                bundle.putInt("dialog.intent.type", i3);
                bundle.putString("package.name", this.f83076b);
                bundle.putInt("playcore.integrity.version.major", 1);
                bundle.putInt("playcore.integrity.version.minor", 3);
                bundle.putInt("playcore.integrity.version.patch", 0);
                bundle.putLong("request.token.sid", this.f83077c);
                return b(activity, bundle);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    abstract Task b(Activity activity, Bundle bundle);
}
