package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AuthenticationExtensionsCredPropsOutputs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AuthenticationExtensionsCredPropsOutputs> CREATOR = new zze();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f72475a;

    public AuthenticationExtensionsCredPropsOutputs(boolean z2) {
        this.f72475a = z2;
    }

    public boolean M() {
        return this.f72475a;
    }

    public final JSONObject N() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("rk", this.f72475a);
            return jSONObject;
        } catch (JSONException e3) {
            throw new RuntimeException("Error encoding AuthenticationExtensionsCredPropsOutputs to JSON object", e3);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof AuthenticationExtensionsCredPropsOutputs) && this.f72475a == ((AuthenticationExtensionsCredPropsOutputs) obj).f72475a;
    }

    public int hashCode() {
        return Objects.c(Boolean.valueOf(this.f72475a));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.g(parcel, 1, M());
        SafeParcelWriter.b(parcel, iA);
    }
}
