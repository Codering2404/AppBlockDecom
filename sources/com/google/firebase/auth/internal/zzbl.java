package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.p002firebaseauthapi.zzaen;
import com.google.android.gms.internal.p002firebaseauthapi.zzajb;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbl {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f87919d = 3600000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final com.google.android.gms.internal.p002firebaseauthapi.zzah f87920e = com.google.android.gms.internal.p002firebaseauthapi.zzah.zza("firebaseAppName", "firebaseUserUid", "operation", "tenantId", "verifyAssertionRequest", "statusCode", "statusMessage", "timestamp");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final zzbl f87921f = new zzbl();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Task f87922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Task f87923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f87924c = 0;

    public static void b(Context context, Status status) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        editorEdit.putInt("statusCode", status.O());
        editorEdit.putString("statusMessage", status.g0());
        editorEdit.putLong("timestamp", DefaultClock.c().currentTimeMillis());
        editorEdit.commit();
    }

    public static void c(Context context, zzajb zzajbVar, String str, String str2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        editorEdit.putString("verifyAssertionRequest", SafeParcelableSerializer.f(zzajbVar));
        editorEdit.putString("operation", str);
        editorEdit.putString("tenantId", str2);
        editorEdit.putLong("timestamp", DefaultClock.c().currentTimeMillis());
        editorEdit.commit();
    }

    public static void d(Context context, FirebaseAuth firebaseAuth) {
        Preconditions.m(context);
        Preconditions.m(firebaseAuth);
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        editorEdit.putString("firebaseAppName", firebaseAuth.b().o());
        editorEdit.commit();
    }

    public static void e(Context context, String str, String str2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        editorEdit.putString("recaptchaToken", str);
        editorEdit.putString("operation", str2);
        editorEdit.putLong("timestamp", DefaultClock.c().currentTimeMillis());
        editorEdit.commit();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void f(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        com.google.android.gms.internal.p002firebaseauthapi.zzah zzahVar = f87920e;
        int size = zzahVar.size();
        int i3 = 0;
        while (i3 < size) {
            E e3 = zzahVar.get(i3);
            i3++;
            editorEdit.remove((String) e3);
        }
        editorEdit.commit();
    }

    public static zzbl i() {
        return f87921f;
    }

    public final void a(Context context) {
        Preconditions.m(context);
        f(context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0));
        this.f87922a = null;
        this.f87924c = 0L;
    }

    public final void g(FirebaseAuth firebaseAuth) {
        zzajb zzajbVar;
        String string;
        Preconditions.m(firebaseAuth);
        SharedPreferences sharedPreferences = firebaseAuth.b().l().getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0);
        if (firebaseAuth.b().o().equals(sharedPreferences.getString("firebaseAppName", ""))) {
            if (!sharedPreferences.contains("verifyAssertionRequest")) {
                if (sharedPreferences.contains("recaptchaToken")) {
                    String string2 = sharedPreferences.getString("recaptchaToken", "");
                    String string3 = sharedPreferences.getString("operation", "");
                    this.f87924c = sharedPreferences.getLong("timestamp", 0L);
                    string3.getClass();
                    this.f87923b = string3.equals("com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA") ? Tasks.forResult(string2) : null;
                    f(sharedPreferences);
                    return;
                }
                if (sharedPreferences.contains("statusCode")) {
                    Status status = new Status(sharedPreferences.getInt("statusCode", 17062), sharedPreferences.getString("statusMessage", ""));
                    this.f87924c = sharedPreferences.getLong("timestamp", 0L);
                    f(sharedPreferences);
                    this.f87922a = Tasks.forException(zzaen.zza(status));
                    return;
                }
                return;
            }
            zzajbVar = (zzajb) SafeParcelableSerializer.c(sharedPreferences.getString("verifyAssertionRequest", ""), zzajb.CREATOR);
            String string4 = sharedPreferences.getString("operation", "");
            String string5 = sharedPreferences.getString("tenantId", null);
            string = sharedPreferences.getString("firebaseUserUid", "");
            this.f87924c = sharedPreferences.getLong("timestamp", 0L);
            if (string5 != null) {
                firebaseAuth.j(string5);
                zzajbVar.zzb(string5);
            }
            string4.getClass();
            switch (string4) {
                case "com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE":
                    if (!firebaseAuth.c().j0().equals(string)) {
                        this.f87922a = null;
                        break;
                    } else {
                        this.f87922a = firebaseAuth.K(firebaseAuth.c(), com.google.firebase.auth.zze.h1(zzajbVar));
                        break;
                    }
                    break;
                case "com.google.firebase.auth.internal.NONGMSCORE_LINK":
                    if (!firebaseAuth.c().j0().equals(string)) {
                        this.f87922a = null;
                        break;
                    } else {
                        this.f87922a = firebaseAuth.p(firebaseAuth.c(), com.google.firebase.auth.zze.h1(zzajbVar));
                        break;
                    }
                    break;
                case "com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN":
                    this.f87922a = firebaseAuth.k(com.google.firebase.auth.zze.h1(zzajbVar));
                    break;
                default:
                    this.f87922a = null;
                    break;
            }
            f(sharedPreferences);
        }
    }

    public final Task h() {
        if (DefaultClock.c().currentTimeMillis() - this.f87924c < f87919d) {
            return this.f87923b;
        }
        return null;
    }
}
