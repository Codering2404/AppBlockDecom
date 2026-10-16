package com.google.android.gms.common.images;

import android.net.Uri;
import com.google.android.gms.common.internal.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f71942a;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zad) {
            return Objects.b(((zad) obj).f71942a, this.f71942a);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.c(this.f71942a);
    }
}
