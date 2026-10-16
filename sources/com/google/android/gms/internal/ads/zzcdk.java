package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcdk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcdk> CREATOR = new zzcdl();
    public final String zza;
    public final String zzb;
    public final boolean zzc;
    public final boolean zzd;
    public final List zze;
    public final boolean zzf;
    public final boolean zzg;
    public final List zzh;

    public zzcdk(String str, String str2, boolean z2, boolean z3, List list, boolean z4, boolean z5, List list2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = z2;
        this.zzd = z3;
        this.zze = list;
        this.zzf = z4;
        this.zzg = z5;
        this.zzh = list2 == null ? new ArrayList() : list2;
    }

    public static zzcdk zza(JSONObject jSONObject) throws JSONException {
        return new zzcdk(jSONObject.optString("click_string", ""), jSONObject.optString("report_url", ""), jSONObject.optBoolean("rendered_ad_enabled", false), jSONObject.optBoolean("non_malicious_reporting_enabled", false), com.google.android.gms.ads.internal.util.zzbp.a(jSONObject.optJSONArray("allowed_headers"), null), jSONObject.optBoolean("protection_enabled", false), jSONObject.optBoolean("malicious_reporting_enabled", false), com.google.android.gms.ads.internal.util.zzbp.a(jSONObject.optJSONArray("webview_permissions"), null));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        String str = this.zza;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 2, str, false);
        SafeParcelWriter.G(parcel, 3, this.zzb, false);
        SafeParcelWriter.g(parcel, 4, this.zzc);
        SafeParcelWriter.g(parcel, 5, this.zzd);
        SafeParcelWriter.I(parcel, 6, this.zze, false);
        SafeParcelWriter.g(parcel, 7, this.zzf);
        SafeParcelWriter.g(parcel, 8, this.zzg);
        SafeParcelWriter.I(parcel, 9, this.zzh, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
