package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fido.fido2.api.common.ErrorCode;
import com.google.android.gms.internal.fido.zzbi;
import com.google.android.gms.internal.fido.zzbj;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AuthenticatorErrorResponse extends AuthenticatorResponse {
    public static final Parcelable.Creator<AuthenticatorErrorResponse> CREATOR = new zzl();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ErrorCode f72485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f72486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f72487c;

    AuthenticatorErrorResponse(int i3, String str, int i4) {
        try {
            this.f72485a = ErrorCode.d(i3);
            this.f72486b = str;
            this.f72487c = i4;
        } catch (ErrorCode.UnsupportedErrorCodeException e3) {
            throw new IllegalArgumentException(e3);
        }
    }

    public ErrorCode M() {
        return this.f72485a;
    }

    public int N() {
        return this.f72485a.c();
    }

    public String O() {
        return this.f72486b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AuthenticatorErrorResponse)) {
            return false;
        }
        AuthenticatorErrorResponse authenticatorErrorResponse = (AuthenticatorErrorResponse) obj;
        return Objects.b(this.f72485a, authenticatorErrorResponse.f72485a) && Objects.b(this.f72486b, authenticatorErrorResponse.f72486b) && Objects.b(Integer.valueOf(this.f72487c), Integer.valueOf(authenticatorErrorResponse.f72487c));
    }

    public final JSONObject g0() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", this.f72485a.c());
            String str = this.f72486b;
            if (str == null) {
                return jSONObject;
            }
            jSONObject.put("message", str);
            return jSONObject;
        } catch (JSONException e3) {
            throw new RuntimeException("Error encoding AuthenticatorErrorResponse to JSON object", e3);
        }
    }

    public int hashCode() {
        return Objects.c(this.f72485a, this.f72486b, Integer.valueOf(this.f72487c));
    }

    public String toString() {
        zzbi zzbiVarZza = zzbj.zza(this);
        zzbiVarZza.zza("errorCode", this.f72485a.c());
        String str = this.f72486b;
        if (str != null) {
            zzbiVarZza.zzb("errorMessage", str);
        }
        return zzbiVarZza.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 2, N());
        SafeParcelWriter.G(parcel, 3, O(), false);
        SafeParcelWriter.u(parcel, 4, this.f72487c);
        SafeParcelWriter.b(parcel, iA);
    }
}
