package com.google.android.libraries.places.internal;

import android.graphics.Bitmap;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzkm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Bitmap f78073a;

    public final zzkn a() {
        Preconditions.A(this.f78073a != null, "Photo must be set to non-null value.");
        return new zzkn(this.f78073a, null);
    }

    public final zzkm b(Bitmap bitmap) {
        this.f78073a = bitmap;
        return this;
    }
}
