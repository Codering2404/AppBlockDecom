package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@ParametersAreNonnullByDefault
public final class zzcbd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcbd> CREATOR = new zzcbe();
    public final Bundle zza;
    public final VersionInfoParcel zzb;
    public final ApplicationInfo zzc;
    public final String zzd;
    public final List zze;
    public final PackageInfo zzf;
    public final String zzg;
    public final String zzh;
    public zzfmu zzi;
    public String zzj;
    public final boolean zzk;
    public final boolean zzl;
    public final Bundle zzm;

    public zzcbd(Bundle bundle, VersionInfoParcel versionInfoParcel, ApplicationInfo applicationInfo, String str, List list, PackageInfo packageInfo, String str2, String str3, zzfmu zzfmuVar, String str4, boolean z2, boolean z3, Bundle bundle2) {
        this.zza = bundle;
        this.zzb = versionInfoParcel;
        this.zzd = str;
        this.zzc = applicationInfo;
        this.zze = list;
        this.zzf = packageInfo;
        this.zzg = str2;
        this.zzh = str3;
        this.zzi = zzfmuVar;
        this.zzj = str4;
        this.zzk = z2;
        this.zzl = z3;
        this.zzm = bundle2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        Bundle bundle = this.zza;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.j(parcel, 1, bundle, false);
        SafeParcelWriter.E(parcel, 2, this.zzb, i3, false);
        SafeParcelWriter.E(parcel, 3, this.zzc, i3, false);
        SafeParcelWriter.G(parcel, 4, this.zzd, false);
        SafeParcelWriter.I(parcel, 5, this.zze, false);
        SafeParcelWriter.E(parcel, 6, this.zzf, i3, false);
        SafeParcelWriter.G(parcel, 7, this.zzg, false);
        SafeParcelWriter.G(parcel, 9, this.zzh, false);
        SafeParcelWriter.E(parcel, 10, this.zzi, i3, false);
        SafeParcelWriter.G(parcel, 11, this.zzj, false);
        SafeParcelWriter.g(parcel, 12, this.zzk);
        SafeParcelWriter.g(parcel, 13, this.zzl);
        SafeParcelWriter.j(parcel, 14, this.zzm, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
