package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.facebook.AccessToken;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.Strings;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzahv extends AbstractSafeParcelable implements zzaez<zzahv> {
    public static final Parcelable.Creator<zzahv> CREATOR = new zzahu();
    private static final String zza = "zzahv";
    private String zzb;
    private String zzc;
    private Long zzd;
    private String zze;
    private Long zzf;

    public zzahv() {
        this.zzf = Long.valueOf(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaez
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final zzahv zza(String str) throws zzacn {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = Strings.a(jSONObject.optString("refresh_token"));
            this.zzc = Strings.a(jSONObject.optString("access_token"));
            this.zzd = Long.valueOf(jSONObject.optLong(AccessToken.EXPIRES_IN_KEY, 0L));
            this.zze = Strings.a(jSONObject.optString("token_type"));
            this.zzf = Long.valueOf(System.currentTimeMillis());
            return this;
        } catch (NullPointerException | JSONException e3) {
            throw zzajk.zza(e3, zza, str);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 2, this.zzb, false);
        SafeParcelWriter.G(parcel, 3, this.zzc, false);
        SafeParcelWriter.B(parcel, 4, Long.valueOf(zza()), false);
        SafeParcelWriter.G(parcel, 5, this.zze, false);
        Long l3 = this.zzf;
        l3.longValue();
        SafeParcelWriter.B(parcel, 6, l3, false);
        SafeParcelWriter.b(parcel, iA);
    }

    public final long zza() {
        Long l3 = this.zzd;
        if (l3 == null) {
            return 0L;
        }
        return l3.longValue();
    }

    public final long zzb() {
        return this.zzf.longValue();
    }

    public final String zzc() {
        return this.zzc;
    }

    public final String zze() {
        return this.zze;
    }

    public final String zzf() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("refresh_token", this.zzb);
            jSONObject.put("access_token", this.zzc);
            jSONObject.put(AccessToken.EXPIRES_IN_KEY, this.zzd);
            jSONObject.put("token_type", this.zze);
            jSONObject.put("issued_at", this.zzf);
            return jSONObject.toString();
        } catch (JSONException e3) {
            Log.d(zza, "Failed to convert GetTokenResponse to JSON");
            throw new zzaao(e3);
        }
    }

    public final boolean zzg() {
        return DefaultClock.c().currentTimeMillis() + 300000 < this.zzf.longValue() + (this.zzd.longValue() * 1000);
    }

    public static zzahv zzb(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            zzahv zzahvVar = new zzahv();
            zzahvVar.zzb = jSONObject.optString("refresh_token", null);
            zzahvVar.zzc = jSONObject.optString("access_token", null);
            zzahvVar.zzd = Long.valueOf(jSONObject.optLong(AccessToken.EXPIRES_IN_KEY));
            zzahvVar.zze = jSONObject.optString("token_type", null);
            zzahvVar.zzf = Long.valueOf(jSONObject.optLong("issued_at"));
            return zzahvVar;
        } catch (JSONException e3) {
            Log.d(zza, "Failed to read GetTokenResponse from JSONObject");
            throw new zzaao(e3);
        }
    }

    public final void zzc(String str) {
        this.zzb = Preconditions.g(str);
    }

    public zzahv(String str, String str2, Long l3, String str3) {
        this(str, str2, l3, str3, Long.valueOf(System.currentTimeMillis()));
    }

    zzahv(String str, String str2, Long l3, String str3, Long l4) {
        this.zzb = str;
        this.zzc = str2;
        this.zzd = l3;
        this.zze = str3;
        this.zzf = l4;
    }

    public final String zzd() {
        return this.zzb;
    }
}
