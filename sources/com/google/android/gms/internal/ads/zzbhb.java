package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbhb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbhb> CREATOR = new zzbhc();
    public final String zza;
    public final long zzb;
    public final String zzc;
    public final String zzd;
    public final String zze;
    public final Bundle zzf;
    public final boolean zzg;
    public long zzh;
    public String zzi;
    public int zzj;

    zzbhb(String str, long j3, String str2, String str3, String str4, Bundle bundle, boolean z2, long j4, String str5, int i3) {
        this.zza = str;
        this.zzb = j3;
        this.zzc = str2 == null ? "" : str2;
        this.zzd = str3 == null ? "" : str3;
        this.zze = str4 == null ? "" : str4;
        this.zzf = bundle == null ? new Bundle() : bundle;
        this.zzg = z2;
        this.zzh = j4;
        this.zzi = str5;
        this.zzj = i3;
    }

    public static zzbhb zza(Uri uri) {
        try {
            if (!"gcache".equals(uri.getScheme())) {
                return null;
            }
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments.size() != 2) {
                int size = pathSegments.size();
                StringBuilder sb = new StringBuilder(String.valueOf(size).length() + 51);
                sb.append("Expected 2 path parts for namespace and id, found :");
                sb.append(size);
                String string = sb.toString();
                int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.f(string);
                return null;
            }
            String str = pathSegments.get(0);
            String str2 = pathSegments.get(1);
            String host = uri.getHost();
            String queryParameter = uri.getQueryParameter("url");
            boolean zEquals = AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(uri.getQueryParameter("read_only"));
            String queryParameter2 = uri.getQueryParameter("expiration");
            long j3 = queryParameter2 == null ? 0L : Long.parseLong(queryParameter2);
            Bundle bundle = new Bundle();
            for (String str3 : uri.getQueryParameterNames()) {
                if (str3.startsWith("tag.")) {
                    bundle.putString(str3.substring(4), uri.getQueryParameter(str3));
                }
            }
            return new zzbhb(queryParameter, j3, host, str, str2, bundle, zEquals, 0L, "", 0);
        } catch (NullPointerException e3) {
            e = e3;
            int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Unable to parse Uri into cache offering.", e);
            return null;
        } catch (NumberFormatException e4) {
            e = e4;
            int i42 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Unable to parse Uri into cache offering.", e);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        String str = this.zza;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 2, str, false);
        SafeParcelWriter.z(parcel, 3, this.zzb);
        SafeParcelWriter.G(parcel, 4, this.zzc, false);
        SafeParcelWriter.G(parcel, 5, this.zzd, false);
        SafeParcelWriter.G(parcel, 6, this.zze, false);
        SafeParcelWriter.j(parcel, 7, this.zzf, false);
        SafeParcelWriter.g(parcel, 8, this.zzg);
        SafeParcelWriter.z(parcel, 9, this.zzh);
        SafeParcelWriter.G(parcel, 10, this.zzi, false);
        SafeParcelWriter.u(parcel, 11, this.zzj);
        SafeParcelWriter.b(parcel, iA);
    }
}
