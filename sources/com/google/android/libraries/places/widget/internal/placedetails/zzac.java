package com.google.android.libraries.places.widget.internal.placedetails;

import android.text.style.ClickableSpan;
import android.view.View;
import com.google.android.libraries.places.api.model.Place;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzac extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzad f79146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Place f79147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzo f79148c;

    zzac(zzad zzadVar, Place place, zzo zzoVar) {
        this.f79146a = zzadVar;
        this.f79147b = place;
        this.f79148c = zzoVar;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View widget) {
        Intrinsics.checkNotNullParameter(widget, "widget");
        zzad zzadVar = this.f79146a;
        zzadVar.h(zzad.i(this.f79147b));
        zzo zzoVar = this.f79148c;
        if (zzoVar != null) {
            zzoVar.g(zzadVar.f79150b);
        }
    }
}
