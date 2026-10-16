package com.google.android.gms.common.api.internal;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class LifecycleActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f71581a;

    public LifecycleActivity(Activity activity) {
        Preconditions.n(activity, "Activity must not be null");
        this.f71581a = activity;
    }

    public final boolean a() {
        return this.f71581a instanceof FragmentActivity;
    }

    public final boolean b() {
        return this.f71581a instanceof Activity;
    }

    public final Activity c() {
        return (Activity) this.f71581a;
    }

    public final FragmentActivity d() {
        return (FragmentActivity) this.f71581a;
    }
}
