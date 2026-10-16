package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.fido.zzgx;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzh> CREATOR = new zzi();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f72655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzgx f72656b;

    public zzh(boolean z2, zzgx zzgxVar) {
        this.f72655a = z2;
        this.f72656b = zzgxVar;
    }

    public final JSONObject M() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.f72655a) {
                jSONObject.put("enabled", true);
            }
            byte[] bArrN = N();
            if (bArrN != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("first", Base64.encodeToString(Arrays.copyOf(bArrN, 32), 11));
                if (bArrN.length == 64) {
                    jSONObject2.put("second", Base64.encodeToString(Arrays.copyOfRange(bArrN, 32, 64), 11));
                }
                jSONObject.put("results", jSONObject2);
            }
            return jSONObject;
        } catch (JSONException e3) {
            throw new RuntimeException("Error encoding AuthenticationExtensionsPrfOutputs to JSON object", e3);
        }
    }

    public final byte[] N() {
        zzgx zzgxVar = this.f72656b;
        if (zzgxVar == null) {
            return null;
        }
        return zzgxVar.zzm();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzh)) {
            return false;
        }
        zzh zzhVar = (zzh) obj;
        return this.f72655a == zzhVar.f72655a && Objects.b(this.f72656b, zzhVar.f72656b);
    }

    public final int hashCode() {
        return Objects.c(Boolean.valueOf(this.f72655a), this.f72656b);
    }

    public final String toString() {
        return "AuthenticationExtensionsPrfOutputs{" + M().toString() + "}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        boolean z2 = this.f72655a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.g(parcel, 1, z2);
        SafeParcelWriter.l(parcel, 2, N(), false);
        SafeParcelWriter.b(parcel, iA);
    }
}
