package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IFragmentWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class SupportFragmentWrapper extends IFragmentWrapper.Stub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Fragment f72378a;

    private SupportFragmentWrapper(Fragment fragment) {
        this.f72378a = fragment;
    }

    public static SupportFragmentWrapper x3(Fragment fragment) {
        if (fragment != null) {
            return new SupportFragmentWrapper(fragment);
        }
        return null;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void I0(Intent intent, int i3) {
        this.f72378a.startActivityForResult(intent, i3);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void X1(IObjectWrapper iObjectWrapper) {
        View view = (View) ObjectWrapper.h5(iObjectWrapper);
        Preconditions.m(view);
        this.f72378a.unregisterForContextMenu(view);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void e0(boolean z2) {
        this.f72378a.setMenuVisibility(z2);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void s4(Intent intent) {
        this.f72378a.startActivity(intent);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IObjectWrapper zzb() {
        return ObjectWrapper.i5(this.f72378a.getActivity());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final Bundle zzc() {
        return this.f72378a.getArguments();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final int zzd() {
        return this.f72378a.getId();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IFragmentWrapper zze() {
        return x3(this.f72378a.getParentFragment());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IObjectWrapper zzf() {
        return ObjectWrapper.i5(this.f72378a.getResources());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzg() {
        return this.f72378a.getRetainInstance();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final String zzh() {
        return this.f72378a.getTag();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IFragmentWrapper zzi() {
        return x3(this.f72378a.getTargetFragment());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final int zzj() {
        return this.f72378a.getTargetRequestCode();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzk() {
        return this.f72378a.getUserVisibleHint();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IObjectWrapper zzl() {
        return ObjectWrapper.i5(this.f72378a.getView());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzm() {
        return this.f72378a.isAdded();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzn() {
        return this.f72378a.isDetached();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzo() {
        return this.f72378a.isHidden();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzp() {
        return this.f72378a.isInLayout();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzq() {
        return this.f72378a.isRemoving();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzr() {
        return this.f72378a.isResumed();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzs() {
        return this.f72378a.isVisible();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzt(IObjectWrapper iObjectWrapper) {
        View view = (View) ObjectWrapper.h5(iObjectWrapper);
        Preconditions.m(view);
        this.f72378a.registerForContextMenu(view);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzu(boolean z2) {
        this.f72378a.setHasOptionsMenu(z2);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzw(boolean z2) {
        this.f72378a.setRetainInstance(z2);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzx(boolean z2) {
        this.f72378a.setUserVisibleHint(z2);
    }
}
