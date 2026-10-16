package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzahs;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f87939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f87940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public zzahs f87941c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FirebaseApp f87942d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FirebaseAuth f87943e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public zzbs f87944f;

    public zzbx(FirebaseApp firebaseApp, FirebaseAuth firebaseAuth) {
        this(firebaseApp, firebaseAuth, new zzbv());
    }

    public static /* synthetic */ void c(zzbx zzbxVar, zzahs zzahsVar, Task task, String str) {
        synchronized (zzbxVar.f87939a) {
            zzbxVar.f87941c = zzahsVar;
            zzbxVar.f87940b.put(str, task);
        }
    }

    private final Task f(String str) {
        Task task;
        synchronized (this.f87939a) {
            task = (Task) this.f87940b.get(str);
        }
        return task;
    }

    public static String g(String str) {
        return com.google.android.gms.internal.p002firebaseauthapi.zzac.zzc(str) ? "*" : str;
    }

    public final Task a(String str, Boolean bool) {
        Task taskF;
        String strG = g(str);
        return (bool.booleanValue() || (taskF = f(strG)) == null) ? this.f87943e.r("RECAPTCHA_ENTERPRISE").continueWithTask(new zzbw(this, strG)) : taskF;
    }

    public final Task b(String str, Boolean bool, RecaptchaAction recaptchaAction) {
        String strG = g(str);
        Task taskF = f(strG);
        if (bool.booleanValue() || taskF == null) {
            taskF = a(strG, bool);
        }
        return taskF.continueWithTask(new zzbz(this, recaptchaAction));
    }

    public final boolean d(String str) {
        String strZzb;
        Preconditions.m(str);
        zzahs zzahsVar = this.f87941c;
        if (zzahsVar == null || (strZzb = zzahsVar.zzb(str)) == null) {
            return false;
        }
        return strZzb.equals("AUDIT");
    }

    public final boolean e(String str) {
        boolean z2;
        synchronized (this.f87939a) {
            try {
                zzahs zzahsVar = this.f87941c;
                z2 = zzahsVar != null && zzahsVar.zzc(str);
            } finally {
            }
        }
        return z2;
    }

    public zzbx(FirebaseApp firebaseApp, FirebaseAuth firebaseAuth, zzbs zzbsVar) {
        this.f87939a = new Object();
        this.f87940b = new HashMap();
        this.f87942d = firebaseApp;
        this.f87943e = firebaseAuth;
        this.f87944f = zzbsVar;
    }
}
