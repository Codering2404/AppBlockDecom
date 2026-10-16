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
public class SavePasswordRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SavePasswordRequest> CREATOR = new zbs();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SignInPassword f71136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f71137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f71138c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private SignInPassword f71139a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f71140b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f71141c;

        public SavePasswordRequest a() {
            return new SavePasswordRequest(this.f71139a, this.f71140b, this.f71141c);
        }

        public Builder b(SignInPassword signInPassword) {
            this.f71139a = signInPassword;
            return this;
        }

        public final Builder c(String str) {
            this.f71140b = str;
            return this;
        }

        public final Builder d(int i3) {
            this.f71141c = i3;
            return this;
        }
    }

    SavePasswordRequest(SignInPassword signInPassword, String str, int i3) {
        this.f71136a = (SignInPassword) Preconditions.m(signInPassword);
        this.f71137b = str;
        this.f71138c = i3;
    }

    public static Builder M() {
        return new Builder();
    }

    public static Builder O(SavePasswordRequest savePasswordRequest) {
        Preconditions.m(savePasswordRequest);
        Builder builderM = M();
        builderM.b(savePasswordRequest.N());
        builderM.d(savePasswordRequest.f71138c);
        String str = savePasswordRequest.f71137b;
        if (str != null) {
            builderM.c(str);
        }
        return builderM;
    }

    public SignInPassword N() {
        return this.f71136a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SavePasswordRequest)) {
            return false;
        }
        SavePasswordRequest savePasswordRequest = (SavePasswordRequest) obj;
        return Objects.b(this.f71136a, savePasswordRequest.f71136a) && Objects.b(this.f71137b, savePasswordRequest.f71137b) && this.f71138c == savePasswordRequest.f71138c;
    }

    public int hashCode() {
        return Objects.c(this.f71136a, this.f71137b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.E(parcel, 1, N(), i3, false);
        SafeParcelWriter.G(parcel, 2, this.f71137b, false);
        SafeParcelWriter.u(parcel, 3, this.f71138c);
        SafeParcelWriter.b(parcel, iA);
    }
}
