package com.google.android.gms.auth.api.identity;

import android.accounts.Account;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AuthorizationRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<AuthorizationRequest> CREATOR = new zbe();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f71043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f71044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f71045c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f71046d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Account f71047f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f71048g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f71049h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f71050i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Bundle f71051j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List f71052a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f71053b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f71054c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f71055d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Account f71056e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f71057f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f71058g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f71059h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private Bundle f71060i;

        private final String i(String str) {
            Preconditions.m(str);
            String str2 = this.f71053b;
            boolean z2 = true;
            if (str2 != null && !str2.equals(str)) {
                z2 = false;
            }
            Preconditions.b(z2, "two different server client ids provided");
            return str;
        }

        public AuthorizationRequest a() {
            return new AuthorizationRequest(this.f71052a, this.f71053b, this.f71054c, this.f71055d, this.f71056e, this.f71057f, this.f71058g, this.f71059h, this.f71060i);
        }

        public Builder b(String str) {
            this.f71057f = Preconditions.g(str);
            return this;
        }

        public Builder c(String str, boolean z2) {
            i(str);
            this.f71053b = str;
            this.f71054c = true;
            this.f71059h = z2;
            return this;
        }

        public Builder d(Account account) {
            this.f71056e = (Account) Preconditions.m(account);
            return this;
        }

        public Builder e(List list) {
            boolean z2 = false;
            if (list != null && !list.isEmpty()) {
                z2 = true;
            }
            Preconditions.b(z2, "requestedScopes cannot be null or empty");
            this.f71052a = list;
            return this;
        }

        public final Builder f(zbd zbdVar, String str) {
            Preconditions.n(zbdVar, "Resource parameter cannot be null");
            Preconditions.n(str, "Resource parameter value cannot be null");
            if (this.f71060i == null) {
                this.f71060i = new Bundle();
            }
            this.f71060i.putString(zbdVar.f71159a, str);
            return this;
        }

        public final Builder g(String str) {
            i(str);
            this.f71053b = str;
            this.f71055d = true;
            return this;
        }

        public final Builder h(String str) {
            this.f71058g = str;
            return this;
        }
    }

    AuthorizationRequest(List list, String str, boolean z2, boolean z3, Account account, String str2, String str3, boolean z4, Bundle bundle) {
        boolean z5 = false;
        if (list != null && !list.isEmpty()) {
            z5 = true;
        }
        Preconditions.b(z5, "requestedScopes cannot be null or empty");
        this.f71043a = list;
        this.f71044b = str;
        this.f71045c = z2;
        this.f71046d = z3;
        this.f71047f = account;
        this.f71048g = str2;
        this.f71049h = str3;
        this.f71050i = z4;
        this.f71051j = bundle;
    }

    public static Builder M() {
        return new Builder();
    }

    public static Builder z0(AuthorizationRequest authorizationRequest) {
        zbd zbdVar;
        Preconditions.m(authorizationRequest);
        Builder builderM = M();
        builderM.e(authorizationRequest.O());
        Bundle bundle = authorizationRequest.f71051j;
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                String string = bundle.getString(str);
                zbd[] zbdVarArrValues = zbd.values();
                int length = zbdVarArrValues.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        zbdVar = null;
                        break;
                    }
                    zbdVar = zbdVarArrValues[i3];
                    if (zbdVar.f71159a.equals(str)) {
                        break;
                    }
                    i3++;
                }
                if (string != null && zbdVar != null) {
                    builderM.f(zbdVar, string);
                }
            }
        }
        boolean zJ0 = authorizationRequest.j0();
        String str2 = authorizationRequest.f71049h;
        String strN = authorizationRequest.N();
        Account account = authorizationRequest.getAccount();
        String strG0 = authorizationRequest.g0();
        if (str2 != null) {
            builderM.h(str2);
        }
        if (strN != null) {
            builderM.b(strN);
        }
        if (account != null) {
            builderM.d(account);
        }
        if (authorizationRequest.f71046d && strG0 != null) {
            builderM.g(strG0);
        }
        if (authorizationRequest.w0() && strG0 != null) {
            builderM.c(strG0, zJ0);
        }
        return builderM;
    }

    public String N() {
        return this.f71048g;
    }

    public List O() {
        return this.f71043a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AuthorizationRequest)) {
            return false;
        }
        AuthorizationRequest authorizationRequest = (AuthorizationRequest) obj;
        if (this.f71043a.size() == authorizationRequest.f71043a.size() && this.f71043a.containsAll(authorizationRequest.f71043a)) {
            Bundle bundle = authorizationRequest.f71051j;
            Bundle bundle2 = this.f71051j;
            if (bundle2 == null) {
                if (bundle == null) {
                    bundle = null;
                }
                return false;
            }
            if (bundle2 == null || bundle != null) {
                if (bundle2 != null) {
                    if (bundle2.size() != bundle.size()) {
                        return false;
                    }
                    for (String str : this.f71051j.keySet()) {
                        if (!Objects.b(this.f71051j.getString(str), bundle.getString(str))) {
                            return false;
                        }
                    }
                }
                if (this.f71045c == authorizationRequest.f71045c && this.f71050i == authorizationRequest.f71050i && this.f71046d == authorizationRequest.f71046d && Objects.b(this.f71044b, authorizationRequest.f71044b) && Objects.b(this.f71047f, authorizationRequest.f71047f) && Objects.b(this.f71048g, authorizationRequest.f71048g) && Objects.b(this.f71049h, authorizationRequest.f71049h)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public String g0() {
        return this.f71044b;
    }

    public Account getAccount() {
        return this.f71047f;
    }

    public int hashCode() {
        return Objects.c(this.f71043a, this.f71044b, Boolean.valueOf(this.f71045c), Boolean.valueOf(this.f71050i), Boolean.valueOf(this.f71046d), this.f71047f, this.f71048g, this.f71049h, this.f71051j);
    }

    public boolean j0() {
        return this.f71050i;
    }

    public boolean w0() {
        return this.f71045c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.K(parcel, 1, O(), false);
        SafeParcelWriter.G(parcel, 2, g0(), false);
        SafeParcelWriter.g(parcel, 3, w0());
        SafeParcelWriter.g(parcel, 4, this.f71046d);
        SafeParcelWriter.E(parcel, 5, getAccount(), i3, false);
        SafeParcelWriter.G(parcel, 6, N(), false);
        SafeParcelWriter.G(parcel, 7, this.f71049h, false);
        SafeParcelWriter.g(parcel, 8, j0());
        SafeParcelWriter.j(parcel, 9, this.f71051j, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
