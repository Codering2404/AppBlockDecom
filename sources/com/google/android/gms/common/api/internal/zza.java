package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zza extends Fragment implements LifecycleFragment {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final WeakHashMap f71867b = new WeakHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzc f71868a = new zzc();

    public static zza b(Activity activity) {
        zza zzaVar;
        WeakHashMap weakHashMap = f71867b;
        WeakReference weakReference = (WeakReference) weakHashMap.get(activity);
        if (weakReference != null && (zzaVar = (zza) weakReference.get()) != null) {
            return zzaVar;
        }
        try {
            zza zzaVar2 = (zza) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
            if (zzaVar2 == null || zzaVar2.isRemoving()) {
                zzaVar2 = new zza();
                activity.getFragmentManager().beginTransaction().add(zzaVar2, "LifecycleFragmentImpl").commitAllowingStateLoss();
            }
            weakHashMap.put(activity, new WeakReference(zzaVar2));
            return zzaVar2;
        } catch (ClassCastException e3) {
            throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e3);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final void a(String str, LifecycleCallback lifecycleCallback) {
        this.f71868a.b(str, lifecycleCallback);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final LifecycleCallback c(String str, Class cls) {
        return this.f71868a.a(str, cls);
    }

    @Override // android.app.Fragment
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        this.f71868a.j(str, fileDescriptor, printWriter, strArr);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final Activity i() {
        return getActivity();
    }

    @Override // android.app.Fragment
    public final void onActivityResult(int i3, int i4, Intent intent) {
        super.onActivityResult(i3, i4, intent);
        this.f71868a.f(i3, i4, intent);
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f71868a.c(bundle);
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f71868a.i();
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f71868a.e();
    }

    @Override // android.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f71868a.g(bundle);
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f71868a.d();
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f71868a.h();
    }
}
