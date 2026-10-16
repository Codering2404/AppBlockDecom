package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ApiMetadata extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ApiMetadata> CREATOR = zza.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ApiMetadata f71479d = N().a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ApiMetadata f71480f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ComplianceOptions f71481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f71482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f71483c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ComplianceOptions f71484a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f71485b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f71486c;

        public ApiMetadata a() {
            ApiMetadata apiMetadata = new ApiMetadata(this.f71484a, this.f71485b);
            apiMetadata.O(this.f71486c);
            return apiMetadata;
        }

        final /* synthetic */ Builder b(boolean z2) {
            this.f71486c = z2;
            return this;
        }
    }

    static {
        Builder builderN = N();
        builderN.b(true);
        f71480f = builderN.a();
    }

    ApiMetadata(ComplianceOptions complianceOptions, boolean z2) {
        this.f71481a = complianceOptions;
        this.f71482b = z2;
    }

    public static final ApiMetadata M() {
        return f71479d;
    }

    public static Builder N() {
        return new Builder();
    }

    final /* synthetic */ void O(boolean z2) {
        this.f71483c = z2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ApiMetadata)) {
            return false;
        }
        ApiMetadata apiMetadata = (ApiMetadata) obj;
        return Objects.b(this.f71481a, apiMetadata.f71481a) && this.f71483c == apiMetadata.f71483c && this.f71482b == apiMetadata.f71482b;
    }

    public final int hashCode() {
        return Objects.c(this.f71481a, Boolean.valueOf(this.f71483c), Boolean.valueOf(this.f71482b));
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f71481a);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 31);
        sb.append("ApiMetadata(complianceOptions=");
        sb.append(strValueOf);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        if (this.f71483c) {
            parcel.setDataPosition(parcel.dataPosition() - 4);
            parcel.setDataSize(parcel.dataSize() - 4);
            return;
        }
        parcel.writeInt(-204102970);
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.E(parcel, 1, this.f71481a, i3, false);
        SafeParcelWriter.g(parcel, 2, this.f71482b);
        SafeParcelWriter.b(parcel, iA);
    }
}
