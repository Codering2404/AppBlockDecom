package com.google.android.libraries.places.widget.internal.placedetails;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbm extends zzbq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f79274a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbm(Uri uri) {
        super(null);
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.f79274a = uri;
    }

    public final Uri a() {
        return this.f79274a;
    }
}
