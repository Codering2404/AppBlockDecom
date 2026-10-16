package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import d.qFm.sECyKyO;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AuthenticationExtensionsClientOutputs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AuthenticationExtensionsClientOutputs> CREATOR = new zzc();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final UvmEntries f72470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzf f72471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AuthenticationExtensionsCredPropsOutputs f72472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzh f72473d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f72474f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
    }

    AuthenticationExtensionsClientOutputs(UvmEntries uvmEntries, zzf zzfVar, AuthenticationExtensionsCredPropsOutputs authenticationExtensionsCredPropsOutputs, zzh zzhVar, String str) {
        this.f72470a = uvmEntries;
        this.f72471b = zzfVar;
        this.f72472c = authenticationExtensionsCredPropsOutputs;
        this.f72473d = zzhVar;
        this.f72474f = str;
    }

    public AuthenticationExtensionsCredPropsOutputs M() {
        return this.f72472c;
    }

    public UvmEntries N() {
        return this.f72470a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AuthenticationExtensionsClientOutputs)) {
            return false;
        }
        AuthenticationExtensionsClientOutputs authenticationExtensionsClientOutputs = (AuthenticationExtensionsClientOutputs) obj;
        return Objects.b(this.f72470a, authenticationExtensionsClientOutputs.f72470a) && Objects.b(this.f72471b, authenticationExtensionsClientOutputs.f72471b) && Objects.b(this.f72472c, authenticationExtensionsClientOutputs.f72472c) && Objects.b(this.f72473d, authenticationExtensionsClientOutputs.f72473d) && Objects.b(this.f72474f, authenticationExtensionsClientOutputs.f72474f);
    }

    public int hashCode() {
        return Objects.c(this.f72470a, this.f72471b, this.f72472c, this.f72473d, this.f72474f);
    }

    public final String toString() {
        return "AuthenticationExtensionsClientOutputs{" + O().toString() + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.E(parcel, 1, N(), i3, false);
        SafeParcelWriter.E(parcel, 2, this.f72471b, i3, false);
        SafeParcelWriter.E(parcel, 3, M(), i3, false);
        SafeParcelWriter.E(parcel, 4, this.f72473d, i3, false);
        SafeParcelWriter.G(parcel, 5, this.f72474f, false);
        SafeParcelWriter.b(parcel, iA);
    }

    public final JSONObject O() {
        try {
            JSONObject jSONObject = new JSONObject();
            AuthenticationExtensionsCredPropsOutputs authenticationExtensionsCredPropsOutputs = this.f72472c;
            if (authenticationExtensionsCredPropsOutputs != null) {
                jSONObject.put("credProps", authenticationExtensionsCredPropsOutputs.N());
            }
            UvmEntries uvmEntries = this.f72470a;
            if (uvmEntries != null) {
                jSONObject.put("uvm", uvmEntries.N());
            }
            zzh zzhVar = this.f72473d;
            if (zzhVar != null) {
                jSONObject.put("prf", zzhVar.M());
            }
            String str = this.f72474f;
            if (str != null) {
                jSONObject.put("txAuthSimple", str);
            }
            return jSONObject;
        } catch (JSONException e3) {
            throw new RuntimeException(sECyKyO.HqBoOqAKShcXp, e3);
        }
    }
}
