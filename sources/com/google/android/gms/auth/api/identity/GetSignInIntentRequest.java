package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class GetSignInIntentRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetSignInIntentRequest> CREATOR = new zbl();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f71111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f71112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f71113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f71114d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f71115f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f71116g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f71117a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f71118b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f71119c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f71120d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f71121e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f71122f;

        public GetSignInIntentRequest a() {
            return new GetSignInIntentRequest(this.f71117a, this.f71118b, this.f71119c, this.f71120d, this.f71121e, this.f71122f);
        }

        public Builder b(String str) {
            this.f71118b = str;
            return this;
        }

        public Builder c(String str) {
            this.f71120d = str;
            return this;
        }

        public Builder d(boolean z2) {
            this.f71121e = z2;
            return this;
        }

        public Builder e(String str) {
            Preconditions.m(str);
            this.f71117a = str;
            return this;
        }

        public final Builder f(String str) {
            this.f71119c = str;
            return this;
        }

        public final Builder g(int i3) {
            this.f71122f = i3;
            return this;
        }
    }

    GetSignInIntentRequest(String str, String str2, String str3, String str4, boolean z2, int i3) {
        Preconditions.m(str);
        this.f71111a = str;
        this.f71112b = str2;
        this.f71113c = str3;
        this.f71114d = str4;
        this.f71115f = z2;
        this.f71116g = i3;
    }

    public static Builder M() {
        return new Builder();
    }

    public static Builder w0(GetSignInIntentRequest getSignInIntentRequest) {
        Preconditions.m(getSignInIntentRequest);
        Builder builderM = M();
        builderM.e(getSignInIntentRequest.g0());
        builderM.c(getSignInIntentRequest.O());
        builderM.b(getSignInIntentRequest.N());
        builderM.d(getSignInIntentRequest.f71115f);
        builderM.g(getSignInIntentRequest.f71116g);
        String str = getSignInIntentRequest.f71113c;
        if (str != null) {
            builderM.f(str);
        }
        return builderM;
    }

    public String N() {
        return this.f71112b;
    }

    public String O() {
        return this.f71114d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GetSignInIntentRequest)) {
            return false;
        }
        GetSignInIntentRequest getSignInIntentRequest = (GetSignInIntentRequest) obj;
        return Objects.b(this.f71111a, getSignInIntentRequest.f71111a) && Objects.b(this.f71114d, getSignInIntentRequest.f71114d) && Objects.b(this.f71112b, getSignInIntentRequest.f71112b) && Objects.b(Boolean.valueOf(this.f71115f), Boolean.valueOf(getSignInIntentRequest.f71115f)) && this.f71116g == getSignInIntentRequest.f71116g;
    }

    public String g0() {
        return this.f71111a;
    }

    public int hashCode() {
        return Objects.c(this.f71111a, this.f71112b, this.f71114d, Boolean.valueOf(this.f71115f), Integer.valueOf(this.f71116g));
    }

    public boolean j0() {
        return this.f71115f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 1, g0(), false);
        SafeParcelWriter.G(parcel, 2, N(), false);
        SafeParcelWriter.G(parcel, 3, this.f71113c, false);
        SafeParcelWriter.G(parcel, 4, O(), false);
        SafeParcelWriter.g(parcel, 5, j0());
        SafeParcelWriter.u(parcel, 6, this.f71116g);
        SafeParcelWriter.b(parcel, iA);
    }
}
