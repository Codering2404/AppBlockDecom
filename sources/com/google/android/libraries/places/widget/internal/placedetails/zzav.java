package com.google.android.libraries.places.widget.internal.placedetails;

import androidx.lifecycle.MutableLiveData;
import com.google.android.libraries.places.api.model.PhotoMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzav {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PhotoMetadata f79232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f79233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableLiveData f79234c;

    public zzav(PhotoMetadata metadata, int i3, MutableLiveData destination) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(destination, "destination");
        this.f79232a = metadata;
        this.f79233b = i3;
        this.f79234c = destination;
    }

    public final PhotoMetadata a() {
        return this.f79232a;
    }

    public final int b() {
        return this.f79233b;
    }

    public final MutableLiveData c() {
        return this.f79234c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzav)) {
            return false;
        }
        zzav zzavVar = (zzav) obj;
        return Intrinsics.areEqual(this.f79232a, zzavVar.f79232a) && this.f79233b == zzavVar.f79233b && Intrinsics.areEqual(this.f79234c, zzavVar.f79234c);
    }

    public final int hashCode() {
        return (((this.f79232a.hashCode() * 31) + Integer.hashCode(this.f79233b)) * 31) + this.f79234c.hashCode();
    }

    public final String toString() {
        PhotoMetadata photoMetadata = this.f79232a;
        int length = String.valueOf(photoMetadata).length();
        int i3 = this.f79233b;
        int length2 = String.valueOf(i3).length();
        MutableLiveData mutableLiveData = this.f79234c;
        StringBuilder sb = new StringBuilder(length + 40 + length2 + 14 + String.valueOf(mutableLiveData).length() + 1);
        sb.append("PhotoUriRequest(metadata=");
        sb.append(photoMetadata);
        sb.append(", maxDimension=");
        sb.append(i3);
        sb.append(", destination=");
        sb.append(mutableLiveData);
        sb.append(")");
        return sb.toString();
    }
}
