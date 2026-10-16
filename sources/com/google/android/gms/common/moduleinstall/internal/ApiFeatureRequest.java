package com.google.android.gms.common.moduleinstall.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ApiFeatureRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ApiFeatureRequest> CREATOR = new zac();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Comparator f72151f = new Comparator() { // from class: com.google.android.gms.common.moduleinstall.internal.zab
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            Feature feature = (Feature) obj;
            Feature feature2 = (Feature) obj2;
            Parcelable.Creator<ApiFeatureRequest> creator = ApiFeatureRequest.CREATOR;
            return !feature.getName().equals(feature2.getName()) ? feature.getName().compareTo(feature2.getName()) : (feature.N() > feature2.N() ? 1 : (feature.N() == feature2.N() ? 0 : -1));
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f72152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f72153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f72154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f72155d;

    public ApiFeatureRequest(List list, boolean z2, String str, String str2) {
        Preconditions.m(list);
        this.f72152a = list;
        this.f72153b = z2;
        this.f72154c = str;
        this.f72155d = str2;
    }

    public List M() {
        return this.f72152a;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ApiFeatureRequest)) {
            return false;
        }
        ApiFeatureRequest apiFeatureRequest = (ApiFeatureRequest) obj;
        return this.f72153b == apiFeatureRequest.f72153b && Objects.b(this.f72152a, apiFeatureRequest.f72152a) && Objects.b(this.f72154c, apiFeatureRequest.f72154c) && Objects.b(this.f72155d, apiFeatureRequest.f72155d);
    }

    public final int hashCode() {
        return Objects.c(Boolean.valueOf(this.f72153b), this.f72152a, this.f72154c, this.f72155d);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.K(parcel, 1, M(), false);
        SafeParcelWriter.g(parcel, 2, this.f72153b);
        SafeParcelWriter.G(parcel, 3, this.f72154c, false);
        SafeParcelWriter.G(parcel, 4, this.f72155d, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
