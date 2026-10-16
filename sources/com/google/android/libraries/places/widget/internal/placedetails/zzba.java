package com.google.android.libraries.places.widget.internal.placedetails;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnFailureListener;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final /* synthetic */ class zzba implements OnFailureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbj f79242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ LatLng f79243b;

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final /* synthetic */ void onFailure(Exception exc) {
        zzbj.L0(this.f79242a, this.f79243b, exc);
    }
}
