package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class RegisteredKey extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RegisteredKey> CREATOR = new zzj();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final KeyHandle f72752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f72753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f72754c;

    public RegisteredKey(KeyHandle keyHandle, String str, String str2) {
        this.f72752a = (KeyHandle) Preconditions.m(keyHandle);
        this.f72754c = str;
        this.f72753b = str2;
    }

    public String M() {
        return this.f72753b;
    }

    public String N() {
        return this.f72754c;
    }

    public KeyHandle O() {
        return this.f72752a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RegisteredKey)) {
            return false;
        }
        RegisteredKey registeredKey = (RegisteredKey) obj;
        String str = this.f72754c;
        if (str == null) {
            if (registeredKey.f72754c != null) {
                return false;
            }
        } else if (!str.equals(registeredKey.f72754c)) {
            return false;
        }
        if (!this.f72752a.equals(registeredKey.f72752a)) {
            return false;
        }
        String str2 = this.f72753b;
        if (str2 == null) {
            if (registeredKey.f72753b != null) {
                return false;
            }
        } else if (!str2.equals(registeredKey.f72753b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f72754c;
        int iHashCode = (((str == null ? 0 : str.hashCode()) + 31) * 31) + this.f72752a.hashCode();
        String str2 = this.f72753b;
        return (iHashCode * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("keyHandle", Base64.encodeToString(this.f72752a.M(), 11));
            if (this.f72752a.N() != ProtocolVersion.UNKNOWN) {
                jSONObject.put("version", this.f72752a.N().toString());
            }
            if (this.f72752a.O() != null) {
                jSONObject.put("transports", this.f72752a.O().toString());
            }
            String str = this.f72754c;
            if (str != null) {
                jSONObject.put("challenge", str);
            }
            String str2 = this.f72753b;
            if (str2 != null) {
                jSONObject.put("appId", str2);
            }
            return jSONObject.toString();
        } catch (JSONException e3) {
            throw new RuntimeException(e3);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.E(parcel, 2, O(), i3, false);
        SafeParcelWriter.G(parcel, 3, N(), false);
        SafeParcelWriter.G(parcel, 4, M(), false);
        SafeParcelWriter.b(parcel, iA);
    }
}
