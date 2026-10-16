package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzccb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzccb> CREATOR = new zzccc();
    public final String zza;
    public final int zzb;

    public zzccb(String str, int i3) {
        this.zza = str;
        this.zzb = i3;
    }

    public static zzccb zza(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        return new zzccb(jSONArray.getJSONObject(0).optString("rb_type"), jSONArray.getJSONObject(0).optInt("rb_amount"));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzccb)) {
            return false;
        }
        zzccb zzccbVar = (zzccb) obj;
        return Objects.b(this.zza, zzccbVar.zza) && Objects.b(Integer.valueOf(this.zzb), Integer.valueOf(zzccbVar.zzb));
    }

    public final int hashCode() {
        return Objects.c(this.zza, Integer.valueOf(this.zzb));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        String str = this.zza;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 2, str, false);
        SafeParcelWriter.u(parcel, 3, this.zzb);
        SafeParcelWriter.b(parcel, iA);
    }
}
