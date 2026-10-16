package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzd extends Fragment implements LifecycleFragment {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final WeakHashMap f71875b = new WeakHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzc f71876a = new zzc();

    public static zzd w(FragmentActivity fragmentActivity) {
        zzd zzdVar;
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        WeakHashMap weakHashMap = f71875b;
        WeakReference weakReference = (WeakReference) weakHashMap.get(fragmentActivity);
        if (weakReference != null && (zzdVar = (zzd) weakReference.get()) != null) {
            return zzdVar;
        }
        try {
            zzd zzdVar2 = (zzd) supportFragmentManager.n0("SLifecycleFragmentImpl");
            if (zzdVar2 == null || zzdVar2.isRemoving()) {
                zzdVar2 = new zzd();
                supportFragmentManager.q().e(zzdVar2, "SLifecycleFragmentImpl").k();
            }
            weakHashMap.put(fragmentActivity, new WeakReference(zzdVar2));
            return zzdVar2;
        } catch (ClassCastException e3) {
            throw new IllegalStateException("Fragment with tag SLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e3);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final void a(String str, LifecycleCallback lifecycleCallback) {
        this.f71876a.b(str, lifecycleCallback);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final LifecycleCallback c(String str, Class cls) {
        return this.f71876a.a(str, cls);
    }

    @Override // androidx.fragment.app.Fragment
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        this.f71876a.j(str, fileDescriptor, printWriter, strArr);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final Activity i() {
        return getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int i3, int i4, Intent intent) {
        super.onActivityResult(i3, i4, intent);
        this.f71876a.f(i3, i4, intent);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f71876a.c(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f71876a.i();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f71876a.e();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f71876a.g(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f71876a.d();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f71876a.h();
    }
}
