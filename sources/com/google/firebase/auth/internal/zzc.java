package com.google.firebase.auth.internal;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzc implements OnFailureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FirebaseAuth f87949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f87950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Activity f87951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f87952d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f87953e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzcg f87954f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f87955g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ zzb f87956h;

    public zzc(zzb zzbVar, FirebaseAuth firebaseAuth, String str, Activity activity, boolean z2, boolean z3, zzcg zzcgVar, TaskCompletionSource taskCompletionSource) {
        this.f87949a = firebaseAuth;
        this.f87950b = str;
        this.f87951c = activity;
        this.f87952d = z2;
        this.f87953e = z3;
        this.f87954f = zzcgVar;
        this.f87955g = taskCompletionSource;
        Objects.requireNonNull(zzbVar);
        this.f87956h = zzbVar;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        Log.e(zzb.f87895b, "Failed to get reCAPTCHA enterprise token: " + exc.getMessage() + "\n\n Using fallback methods.");
        if (this.f87949a.H().d("PHONE_PROVIDER")) {
            this.f87956h.d(this.f87949a, this.f87950b, this.f87951c, this.f87952d, this.f87953e, this.f87954f, this.f87955g);
        } else {
            this.f87955g.setResult(new zzm().b());
        }
    }
}
