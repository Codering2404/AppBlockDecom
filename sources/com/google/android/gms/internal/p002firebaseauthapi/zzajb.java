package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.firebase.auth.internal.zzr;
import cz.mobilesoft.coreblock.scene.permission.permissions.success.lbR.YgVrd;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzajb extends AbstractSafeParcelable implements zzafa {
    public static final Parcelable.Creator<zzajb> CREATOR = new zzaja();
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private String zzg;
    private String zzh;
    private boolean zzi;
    private boolean zzj;
    private String zzk;
    private String zzl;
    private String zzm;
    private String zzn;
    private boolean zzo;
    private String zzp;

    public zzajb() {
        this.zzi = true;
        this.zzj = true;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 2, this.zza, false);
        SafeParcelWriter.G(parcel, 3, this.zzb, false);
        SafeParcelWriter.G(parcel, 4, this.zzc, false);
        SafeParcelWriter.G(parcel, 5, this.zzd, false);
        SafeParcelWriter.G(parcel, 6, this.zze, false);
        SafeParcelWriter.G(parcel, 7, this.zzf, false);
        SafeParcelWriter.G(parcel, 8, this.zzg, false);
        SafeParcelWriter.G(parcel, 9, this.zzh, false);
        SafeParcelWriter.g(parcel, 10, this.zzi);
        SafeParcelWriter.g(parcel, 11, this.zzj);
        SafeParcelWriter.G(parcel, 12, this.zzk, false);
        SafeParcelWriter.G(parcel, 13, this.zzl, false);
        SafeParcelWriter.G(parcel, 14, this.zzm, false);
        SafeParcelWriter.G(parcel, 15, this.zzn, false);
        SafeParcelWriter.g(parcel, 16, this.zzo);
        SafeParcelWriter.G(parcel, 17, this.zzp, false);
        SafeParcelWriter.b(parcel, iA);
    }

    public final zzajb zza(boolean z2) {
        this.zzj = false;
        return this;
    }

    public final zzajb zzb(boolean z2) {
        this.zzo = true;
        return this;
    }

    public final zzajb zzc(boolean z2) {
        this.zzi = true;
        return this;
    }

    public final zzajb zza(String str) {
        this.zzb = Preconditions.g(str);
        return this;
    }

    public final zzajb zzb(String str) {
        this.zzn = str;
        return this;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafa
    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("autoCreate", this.zzj);
        jSONObject.put("returnSecureToken", this.zzi);
        String str = this.zzb;
        if (str != null) {
            jSONObject.put("idToken", str);
        }
        String str2 = this.zzg;
        if (str2 != null) {
            jSONObject.put("postBody", str2);
        }
        String str3 = this.zzn;
        if (str3 != null) {
            jSONObject.put("tenantId", str3);
        }
        String str4 = this.zzp;
        if (str4 != null) {
            jSONObject.put("pendingToken", str4);
        }
        if (!TextUtils.isEmpty(this.zzl)) {
            jSONObject.put("sessionId", this.zzl);
        }
        if (!TextUtils.isEmpty(this.zzm)) {
            jSONObject.put("requestUri", this.zzm);
        } else {
            String str5 = this.zza;
            if (str5 != null) {
                jSONObject.put("requestUri", str5);
            }
        }
        jSONObject.put("returnIdpCredential", this.zzo);
        return jSONObject.toString();
    }

    public zzajb(zzr zzrVar, String str) {
        Preconditions.m(zzrVar);
        this.zzl = Preconditions.g(zzrVar.d());
        this.zzm = Preconditions.g(str);
        this.zze = Preconditions.g(zzrVar.c());
        this.zzi = true;
        this.zzg = "providerId=" + this.zze;
    }

    public zzajb(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.zza = YgVrd.gEZAEibpjTKJ;
        this.zzc = str;
        this.zzd = str2;
        this.zzh = str5;
        this.zzk = str6;
        this.zzn = str7;
        this.zzp = str8;
        this.zzi = true;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(this.zzd) && TextUtils.isEmpty(this.zzk)) {
            throw new IllegalArgumentException("idToken, accessToken and authCode cannot all be null");
        }
        this.zze = Preconditions.g(str3);
        this.zzf = null;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.zzc)) {
            sb.append("id_token=");
            sb.append(this.zzc);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.zzd)) {
            sb.append("access_token=");
            sb.append(this.zzd);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.zzf)) {
            sb.append("identifier=");
            sb.append(this.zzf);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.zzh)) {
            sb.append("oauth_token_secret=");
            sb.append(this.zzh);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.zzk)) {
            sb.append("code=");
            sb.append(this.zzk);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(str9)) {
            sb.append("nonce=");
            sb.append(str9);
            sb.append("&");
        }
        sb.append("providerId=");
        sb.append(this.zze);
        this.zzg = sb.toString();
        this.zzj = true;
    }

    zzajb(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z2, boolean z3, String str9, String str10, String str11, String str12, boolean z4, String str13) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
        this.zzf = str6;
        this.zzg = str7;
        this.zzh = str8;
        this.zzi = z2;
        this.zzj = z3;
        this.zzk = str9;
        this.zzl = str10;
        this.zzm = str11;
        this.zzn = str12;
        this.zzo = z4;
        this.zzp = str13;
    }
}
