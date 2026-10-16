package com.google.android.libraries.places.widget.internal.placedetails;

import androidx.recyclerview.widget.GridLayoutManager;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zze extends GridLayoutManager.SpanSizeLookup {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ zzl f79336e;

    zze(zzl zzlVar) {
        this.f79336e = zzlVar;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
    public final int f(int i3) {
        return this.f79336e.getItemViewType(i3) != 0 ? 1 : 2;
    }
}
