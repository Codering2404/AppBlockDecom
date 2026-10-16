package com.google.android.libraries.places.widget.internal.placedetails;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzat implements ViewModelProvider.Factory {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Application f79231b;

    zzat(Application application) {
        this.f79231b = application;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final ViewModel create(Class modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        return new zzbj(this.f79231b);
    }
}
