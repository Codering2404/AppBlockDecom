package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class BeginSignInRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<BeginSignInRequest> CREATOR = new zbg();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PasswordRequestOptions f71067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final GoogleIdTokenRequestOptions f71068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f71069c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f71070d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f71071f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final PasskeysRequestOptions f71072g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final PasskeyJsonRequestOptions f71073h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f71074i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private PasswordRequestOptions f71075a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private GoogleIdTokenRequestOptions f71076b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private PasskeysRequestOptions f71077c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private PasskeyJsonRequestOptions f71078d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f71079e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f71080f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f71081g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f71082h;

        public Builder() {
            PasswordRequestOptions.Builder builderM = PasswordRequestOptions.M();
            builderM.b(false);
            this.f71075a = builderM.a();
            GoogleIdTokenRequestOptions.Builder builderM2 = GoogleIdTokenRequestOptions.M();
            builderM2.g(false);
            this.f71076b = builderM2.b();
            PasskeysRequestOptions.Builder builderM3 = PasskeysRequestOptions.M();
            builderM3.d(false);
            this.f71077c = builderM3.a();
            PasskeyJsonRequestOptions.Builder builderM4 = PasskeyJsonRequestOptions.M();
            builderM4.c(false);
            this.f71078d = builderM4.a();
        }

        public BeginSignInRequest a() {
            return new BeginSignInRequest(this.f71075a, this.f71076b, this.f71079e, this.f71080f, this.f71081g, this.f71077c, this.f71078d, this.f71082h);
        }

        public Builder b(boolean z2) {
            this.f71080f = z2;
            return this;
        }

        public Builder c(GoogleIdTokenRequestOptions googleIdTokenRequestOptions) {
            this.f71076b = (GoogleIdTokenRequestOptions) Preconditions.m(googleIdTokenRequestOptions);
            return this;
        }

        public Builder d(PasskeyJsonRequestOptions passkeyJsonRequestOptions) {
            this.f71078d = (PasskeyJsonRequestOptions) Preconditions.m(passkeyJsonRequestOptions);
            return this;
        }

        public Builder e(PasskeysRequestOptions passkeysRequestOptions) {
            this.f71077c = (PasskeysRequestOptions) Preconditions.m(passkeysRequestOptions);
            return this;
        }

        public Builder f(PasswordRequestOptions passwordRequestOptions) {
            this.f71075a = (PasswordRequestOptions) Preconditions.m(passwordRequestOptions);
            return this;
        }

        public Builder g(boolean z2) {
            this.f71082h = z2;
            return this;
        }

        public final Builder h(String str) {
            this.f71079e = str;
            return this;
        }

        public final Builder i(int i3) {
            this.f71081g = i3;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    public static final class GoogleIdTokenRequestOptions extends AbstractSafeParcelable {
        public static final Parcelable.Creator<GoogleIdTokenRequestOptions> CREATOR = new zbm();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f71083a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f71084b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f71085c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f71086d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f71087f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final List f71088g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f71089h;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private boolean f71090a = false;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private String f71091b = null;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private String f71092c = null;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private boolean f71093d = true;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private String f71094e = null;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private List f71095f = null;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private boolean f71096g = false;

            public Builder a(String str, List list) {
                this.f71094e = (String) Preconditions.n(str, "linkedServiceId must be provided if you want to associate linked accounts.");
                this.f71095f = list;
                return this;
            }

            public GoogleIdTokenRequestOptions b() {
                return new GoogleIdTokenRequestOptions(this.f71090a, this.f71091b, this.f71092c, this.f71093d, this.f71094e, this.f71095f, this.f71096g);
            }

            public Builder c(boolean z2) {
                this.f71093d = z2;
                return this;
            }

            public Builder d(String str) {
                this.f71092c = str;
                return this;
            }

            public Builder e(boolean z2) {
                this.f71096g = z2;
                return this;
            }

            public Builder f(String str) {
                this.f71091b = Preconditions.g(str);
                return this;
            }

            public Builder g(boolean z2) {
                this.f71090a = z2;
                return this;
            }
        }

        GoogleIdTokenRequestOptions(boolean z2, String str, String str2, boolean z3, String str3, List list, boolean z4) {
            boolean z5 = true;
            if (z3 && z4) {
                z5 = false;
            }
            Preconditions.b(z5, "filterByAuthorizedAccounts and requestVerifiedPhoneNumber must not both be true; the Verified Phone Number feature only works in sign-ups.");
            this.f71083a = z2;
            if (z2) {
                Preconditions.n(str, "serverClientId must be provided if Google ID tokens are requested");
            }
            this.f71084b = str;
            this.f71085c = str2;
            this.f71086d = z3;
            Parcelable.Creator<BeginSignInRequest> creator = BeginSignInRequest.CREATOR;
            ArrayList arrayList = null;
            if (list != null && !list.isEmpty()) {
                arrayList = new ArrayList(list);
                Collections.sort(arrayList);
            }
            this.f71088g = arrayList;
            this.f71087f = str3;
            this.f71089h = z4;
        }

        public static Builder M() {
            return new Builder();
        }

        public boolean N() {
            return this.f71086d;
        }

        public List O() {
            return this.f71088g;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof GoogleIdTokenRequestOptions)) {
                return false;
            }
            GoogleIdTokenRequestOptions googleIdTokenRequestOptions = (GoogleIdTokenRequestOptions) obj;
            return this.f71083a == googleIdTokenRequestOptions.f71083a && Objects.b(this.f71084b, googleIdTokenRequestOptions.f71084b) && Objects.b(this.f71085c, googleIdTokenRequestOptions.f71085c) && this.f71086d == googleIdTokenRequestOptions.f71086d && Objects.b(this.f71087f, googleIdTokenRequestOptions.f71087f) && Objects.b(this.f71088g, googleIdTokenRequestOptions.f71088g) && this.f71089h == googleIdTokenRequestOptions.f71089h;
        }

        public String g0() {
            return this.f71087f;
        }

        public boolean h1() {
            return this.f71089h;
        }

        public int hashCode() {
            return Objects.c(Boolean.valueOf(this.f71083a), this.f71084b, this.f71085c, Boolean.valueOf(this.f71086d), this.f71087f, this.f71088g, Boolean.valueOf(this.f71089h));
        }

        public String j0() {
            return this.f71085c;
        }

        public String w0() {
            return this.f71084b;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            int iA = SafeParcelWriter.a(parcel);
            SafeParcelWriter.g(parcel, 1, z0());
            SafeParcelWriter.G(parcel, 2, w0(), false);
            SafeParcelWriter.G(parcel, 3, j0(), false);
            SafeParcelWriter.g(parcel, 4, N());
            SafeParcelWriter.G(parcel, 5, g0(), false);
            SafeParcelWriter.I(parcel, 6, O(), false);
            SafeParcelWriter.g(parcel, 7, h1());
            SafeParcelWriter.b(parcel, iA);
        }

        public boolean z0() {
            return this.f71083a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    public static final class PasskeyJsonRequestOptions extends AbstractSafeParcelable {
        public static final Parcelable.Creator<PasskeyJsonRequestOptions> CREATOR = new zbn();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f71097a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f71098b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private boolean f71099a = false;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private String f71100b;

            public PasskeyJsonRequestOptions a() {
                return new PasskeyJsonRequestOptions(this.f71099a, this.f71100b);
            }

            public Builder b(String str) {
                this.f71100b = str;
                return this;
            }

            public Builder c(boolean z2) {
                this.f71099a = z2;
                return this;
            }
        }

        PasskeyJsonRequestOptions(boolean z2, String str) {
            if (z2) {
                Preconditions.m(str);
            }
            this.f71097a = z2;
            this.f71098b = str;
        }

        public static Builder M() {
            return new Builder();
        }

        public String N() {
            return this.f71098b;
        }

        public boolean O() {
            return this.f71097a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PasskeyJsonRequestOptions)) {
                return false;
            }
            PasskeyJsonRequestOptions passkeyJsonRequestOptions = (PasskeyJsonRequestOptions) obj;
            return this.f71097a == passkeyJsonRequestOptions.f71097a && Objects.b(this.f71098b, passkeyJsonRequestOptions.f71098b);
        }

        public int hashCode() {
            return Objects.c(Boolean.valueOf(this.f71097a), this.f71098b);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            int iA = SafeParcelWriter.a(parcel);
            SafeParcelWriter.g(parcel, 1, O());
            SafeParcelWriter.G(parcel, 2, N(), false);
            SafeParcelWriter.b(parcel, iA);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    public static final class PasskeysRequestOptions extends AbstractSafeParcelable {
        public static final Parcelable.Creator<PasskeysRequestOptions> CREATOR = new zbo();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f71101a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final byte[] f71102b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f71103c;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private boolean f71104a = false;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private byte[] f71105b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private String f71106c;

            public PasskeysRequestOptions a() {
                return new PasskeysRequestOptions(this.f71104a, this.f71105b, this.f71106c);
            }

            public Builder b(byte[] bArr) {
                this.f71105b = bArr;
                return this;
            }

            public Builder c(String str) {
                this.f71106c = str;
                return this;
            }

            public Builder d(boolean z2) {
                this.f71104a = z2;
                return this;
            }
        }

        PasskeysRequestOptions(boolean z2, byte[] bArr, String str) {
            if (z2) {
                Preconditions.m(bArr);
                Preconditions.m(str);
            }
            this.f71101a = z2;
            this.f71102b = bArr;
            this.f71103c = str;
        }

        public static Builder M() {
            return new Builder();
        }

        public byte[] N() {
            return this.f71102b;
        }

        public String O() {
            return this.f71103c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PasskeysRequestOptions)) {
                return false;
            }
            PasskeysRequestOptions passkeysRequestOptions = (PasskeysRequestOptions) obj;
            return this.f71101a == passkeysRequestOptions.f71101a && Arrays.equals(this.f71102b, passkeysRequestOptions.f71102b) && java.util.Objects.equals(this.f71103c, passkeysRequestOptions.f71103c);
        }

        public boolean g0() {
            return this.f71101a;
        }

        public int hashCode() {
            return (java.util.Objects.hash(Boolean.valueOf(this.f71101a), this.f71103c) * 31) + Arrays.hashCode(this.f71102b);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            int iA = SafeParcelWriter.a(parcel);
            SafeParcelWriter.g(parcel, 1, g0());
            SafeParcelWriter.l(parcel, 2, N(), false);
            SafeParcelWriter.G(parcel, 3, O(), false);
            SafeParcelWriter.b(parcel, iA);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    public static final class PasswordRequestOptions extends AbstractSafeParcelable {
        public static final Parcelable.Creator<PasswordRequestOptions> CREATOR = new zbp();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f71107a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private boolean f71108a = false;

            public PasswordRequestOptions a() {
                return new PasswordRequestOptions(this.f71108a);
            }

            public Builder b(boolean z2) {
                this.f71108a = z2;
                return this;
            }
        }

        PasswordRequestOptions(boolean z2) {
            this.f71107a = z2;
        }

        public static Builder M() {
            return new Builder();
        }

        public boolean N() {
            return this.f71107a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof PasswordRequestOptions) && this.f71107a == ((PasswordRequestOptions) obj).f71107a;
        }

        public int hashCode() {
            return Objects.c(Boolean.valueOf(this.f71107a));
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            int iA = SafeParcelWriter.a(parcel);
            SafeParcelWriter.g(parcel, 1, N());
            SafeParcelWriter.b(parcel, iA);
        }
    }

    BeginSignInRequest(PasswordRequestOptions passwordRequestOptions, GoogleIdTokenRequestOptions googleIdTokenRequestOptions, String str, boolean z2, int i3, PasskeysRequestOptions passkeysRequestOptions, PasskeyJsonRequestOptions passkeyJsonRequestOptions, boolean z3) {
        this.f71067a = (PasswordRequestOptions) Preconditions.m(passwordRequestOptions);
        this.f71068b = (GoogleIdTokenRequestOptions) Preconditions.m(googleIdTokenRequestOptions);
        this.f71069c = str;
        this.f71070d = z2;
        this.f71071f = i3;
        if (passkeysRequestOptions == null) {
            PasskeysRequestOptions.Builder builderM = PasskeysRequestOptions.M();
            builderM.d(false);
            passkeysRequestOptions = builderM.a();
        }
        this.f71072g = passkeysRequestOptions;
        if (passkeyJsonRequestOptions == null) {
            PasskeyJsonRequestOptions.Builder builderM2 = PasskeyJsonRequestOptions.M();
            builderM2.c(false);
            passkeyJsonRequestOptions = builderM2.a();
        }
        this.f71073h = passkeyJsonRequestOptions;
        this.f71074i = z3;
    }

    public static Builder M() {
        return new Builder();
    }

    public static Builder h1(BeginSignInRequest beginSignInRequest) {
        Preconditions.m(beginSignInRequest);
        Builder builderM = M();
        builderM.c(beginSignInRequest.N());
        builderM.f(beginSignInRequest.j0());
        builderM.e(beginSignInRequest.g0());
        builderM.d(beginSignInRequest.O());
        builderM.b(beginSignInRequest.f71070d);
        builderM.i(beginSignInRequest.f71071f);
        builderM.g(beginSignInRequest.f71074i);
        String str = beginSignInRequest.f71069c;
        if (str != null) {
            builderM.h(str);
        }
        return builderM;
    }

    public GoogleIdTokenRequestOptions N() {
        return this.f71068b;
    }

    public PasskeyJsonRequestOptions O() {
        return this.f71073h;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BeginSignInRequest)) {
            return false;
        }
        BeginSignInRequest beginSignInRequest = (BeginSignInRequest) obj;
        return Objects.b(this.f71067a, beginSignInRequest.f71067a) && Objects.b(this.f71068b, beginSignInRequest.f71068b) && Objects.b(this.f71072g, beginSignInRequest.f71072g) && Objects.b(this.f71073h, beginSignInRequest.f71073h) && Objects.b(this.f71069c, beginSignInRequest.f71069c) && this.f71070d == beginSignInRequest.f71070d && this.f71071f == beginSignInRequest.f71071f && this.f71074i == beginSignInRequest.f71074i;
    }

    public PasskeysRequestOptions g0() {
        return this.f71072g;
    }

    public int hashCode() {
        return Objects.c(this.f71067a, this.f71068b, this.f71072g, this.f71073h, this.f71069c, Boolean.valueOf(this.f71070d), Integer.valueOf(this.f71071f), Boolean.valueOf(this.f71074i));
    }

    public PasswordRequestOptions j0() {
        return this.f71067a;
    }

    public boolean w0() {
        return this.f71074i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.E(parcel, 1, j0(), i3, false);
        SafeParcelWriter.E(parcel, 2, N(), i3, false);
        SafeParcelWriter.G(parcel, 3, this.f71069c, false);
        SafeParcelWriter.g(parcel, 4, z0());
        SafeParcelWriter.u(parcel, 5, this.f71071f);
        SafeParcelWriter.E(parcel, 6, g0(), i3, false);
        SafeParcelWriter.E(parcel, 7, O(), i3, false);
        SafeParcelWriter.g(parcel, 8, w0());
        SafeParcelWriter.b(parcel, iA);
    }

    public boolean z0() {
        return this.f71070d;
    }
}
