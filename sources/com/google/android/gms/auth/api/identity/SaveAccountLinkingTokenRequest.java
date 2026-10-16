package com.google.android.gms.auth.api.identity;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class SaveAccountLinkingTokenRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SaveAccountLinkingTokenRequest> CREATOR = new zbq();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PendingIntent f71123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f71124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f71125c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f71126d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f71127f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f71128g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private PendingIntent f71129a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f71130b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f71131c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private List f71132d = new ArrayList();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f71133e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f71134f;

        public SaveAccountLinkingTokenRequest a() {
            Preconditions.b(this.f71129a != null, "Consent PendingIntent cannot be null");
            Preconditions.b("auth_code".equals(this.f71130b), "Invalid tokenType");
            Preconditions.b(!TextUtils.isEmpty(this.f71131c), "serviceId cannot be null or empty");
            Preconditions.b(this.f71132d != null, "scopes cannot be null");
            return new SaveAccountLinkingTokenRequest(this.f71129a, this.f71130b, this.f71131c, this.f71132d, this.f71133e, this.f71134f);
        }

        public Builder b(PendingIntent pendingIntent) {
            this.f71129a = pendingIntent;
            return this;
        }

        public Builder c(List list) {
            this.f71132d = list;
            return this;
        }

        public Builder d(String str) {
            this.f71131c = str;
            return this;
        }

        public Builder e(String str) {
            this.f71130b = str;
            return this;
        }

        public final Builder f(String str) {
            this.f71133e = str;
            return this;
        }

        public final Builder g(int i3) {
            this.f71134f = i3;
            return this;
        }
    }

    SaveAccountLinkingTokenRequest(PendingIntent pendingIntent, String str, String str2, List list, String str3, int i3) {
        this.f71123a = pendingIntent;
        this.f71124b = str;
        this.f71125c = str2;
        this.f71126d = list;
        this.f71127f = str3;
        this.f71128g = i3;
    }

    public static Builder M() {
        return new Builder();
    }

    public static Builder w0(SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest) {
        Preconditions.m(saveAccountLinkingTokenRequest);
        Builder builderM = M();
        builderM.c(saveAccountLinkingTokenRequest.O());
        builderM.d(saveAccountLinkingTokenRequest.g0());
        builderM.b(saveAccountLinkingTokenRequest.N());
        builderM.e(saveAccountLinkingTokenRequest.j0());
        builderM.g(saveAccountLinkingTokenRequest.f71128g);
        String str = saveAccountLinkingTokenRequest.f71127f;
        if (!TextUtils.isEmpty(str)) {
            builderM.f(str);
        }
        return builderM;
    }

    public PendingIntent N() {
        return this.f71123a;
    }

    public List O() {
        return this.f71126d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SaveAccountLinkingTokenRequest)) {
            return false;
        }
        SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest = (SaveAccountLinkingTokenRequest) obj;
        return this.f71126d.size() == saveAccountLinkingTokenRequest.f71126d.size() && this.f71126d.containsAll(saveAccountLinkingTokenRequest.f71126d) && Objects.b(this.f71123a, saveAccountLinkingTokenRequest.f71123a) && Objects.b(this.f71124b, saveAccountLinkingTokenRequest.f71124b) && Objects.b(this.f71125c, saveAccountLinkingTokenRequest.f71125c) && Objects.b(this.f71127f, saveAccountLinkingTokenRequest.f71127f) && this.f71128g == saveAccountLinkingTokenRequest.f71128g;
    }

    public String g0() {
        return this.f71125c;
    }

    public int hashCode() {
        return Objects.c(this.f71123a, this.f71124b, this.f71125c, this.f71126d, this.f71127f);
    }

    public String j0() {
        return this.f71124b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.E(parcel, 1, N(), i3, false);
        SafeParcelWriter.G(parcel, 2, j0(), false);
        SafeParcelWriter.G(parcel, 3, g0(), false);
        SafeParcelWriter.I(parcel, 4, O(), false);
        SafeParcelWriter.G(parcel, 5, this.f71127f, false);
        SafeParcelWriter.u(parcel, 6, this.f71128g);
        SafeParcelWriter.b(parcel, iA);
    }
}
