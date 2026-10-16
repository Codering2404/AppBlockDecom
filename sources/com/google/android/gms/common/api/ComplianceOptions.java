package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ComplianceOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ComplianceOptions> CREATOR;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ComplianceOptions f71497f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f71498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f71499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f71500c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f71501d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f71502a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f71503b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f71504c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f71505d = true;

        public ComplianceOptions a() {
            return new ComplianceOptions(this.f71502a, this.f71503b, this.f71504c, this.f71505d);
        }

        public Builder b(int i3) {
            this.f71502a = i3;
            return this;
        }

        public Builder c(int i3) {
            this.f71503b = i3;
            return this;
        }

        public Builder d(boolean z2) {
            this.f71505d = z2;
            return this;
        }

        public Builder e(int i3) {
            this.f71504c = i3;
            return this;
        }
    }

    static {
        Builder builderM = M();
        builderM.b(-1);
        builderM.c(-1);
        builderM.e(0);
        builderM.d(true);
        f71497f = builderM.a();
        CREATOR = new zzc();
    }

    ComplianceOptions(int i3, int i4, int i5, boolean z2) {
        this.f71498a = i3;
        this.f71499b = i4;
        this.f71500c = i5;
        this.f71501d = z2;
    }

    public static Builder M() {
        return new Builder();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ComplianceOptions)) {
            return false;
        }
        ComplianceOptions complianceOptions = (ComplianceOptions) obj;
        return this.f71498a == complianceOptions.f71498a && this.f71499b == complianceOptions.f71499b && this.f71500c == complianceOptions.f71500c && this.f71501d == complianceOptions.f71501d;
    }

    public final int hashCode() {
        return Objects.c(Integer.valueOf(this.f71498a), Integer.valueOf(this.f71499b), Integer.valueOf(this.f71500c), Boolean.valueOf(this.f71501d));
    }

    public final String toString() {
        int i3 = this.f71498a;
        int length = String.valueOf(i3).length();
        int i4 = this.f71499b;
        int length2 = String.valueOf(i4).length();
        int i5 = this.f71500c;
        int length3 = String.valueOf(i5).length();
        boolean z2 = this.f71501d;
        StringBuilder sb = new StringBuilder(length + 55 + length2 + 19 + length3 + 13 + String.valueOf(z2).length() + 1);
        sb.append("ComplianceOptions{callerProductId=");
        sb.append(i3);
        sb.append(", dataOwnerProductId=");
        sb.append(i4);
        sb.append(", processingReason=");
        sb.append(i5);
        sb.append(", isUserData=");
        sb.append(z2);
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.f71498a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, i4);
        SafeParcelWriter.u(parcel, 2, this.f71499b);
        SafeParcelWriter.u(parcel, 3, this.f71500c);
        SafeParcelWriter.g(parcel, 4, this.f71501d);
        SafeParcelWriter.b(parcel, iA);
    }
}
