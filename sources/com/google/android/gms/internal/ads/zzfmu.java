package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfmu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfmu> CREATOR = new zzfmv();

    @Nullable
    public final Context zza;
    public final zzfmr zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final String zzf;
    public final int zzg;
    private final zzfmr[] zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int[] zzl;
    private final int[] zzm;

    public zzfmu(int i3, int i4, int i5, int i6, String str, int i7, int i8) {
        zzfmr[] zzfmrVarArrValues = zzfmr.values();
        this.zzh = zzfmrVarArrValues;
        int[] iArrZza = zzfms.zza();
        this.zzl = iArrZza;
        int[] iArrZza2 = zzfmt.zza();
        this.zzm = iArrZza2;
        this.zza = null;
        this.zzi = i3;
        this.zzb = zzfmrVarArrValues[i3];
        this.zzc = i4;
        this.zzd = i5;
        this.zze = i6;
        this.zzf = str;
        this.zzj = i7;
        this.zzg = iArrZza[i7];
        this.zzk = i8;
        int i9 = iArrZza2[i8];
    }

    @Nullable
    public static zzfmu zza(zzfmr zzfmrVar, Context context) {
        if (zzfmrVar == zzfmr.Rewarded) {
            return new zzfmu(context, zzfmrVar, ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzho)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhu)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhw)).intValue(), (String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhy), (String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhq), (String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhs));
        }
        if (zzfmrVar == zzfmr.Interstitial) {
            return new zzfmu(context, zzfmrVar, ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhp)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhv)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhx)).intValue(), (String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhz), (String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhr), (String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzht));
        }
        if (zzfmrVar != zzfmr.AppOpen) {
            return null;
        }
        return new zzfmu(context, zzfmrVar, ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhC)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhE)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhF)).intValue(), (String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhA), (String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhB), (String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhD));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.zzi;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, i4);
        SafeParcelWriter.u(parcel, 2, this.zzc);
        SafeParcelWriter.u(parcel, 3, this.zzd);
        SafeParcelWriter.u(parcel, 4, this.zze);
        SafeParcelWriter.G(parcel, 5, this.zzf, false);
        SafeParcelWriter.u(parcel, 6, this.zzj);
        SafeParcelWriter.u(parcel, 7, this.zzk);
        SafeParcelWriter.b(parcel, iA);
    }

    private zzfmu(@Nullable Context context, zzfmr zzfmrVar, int i3, int i4, int i5, String str, String str2, String str3) {
        this.zzh = zzfmr.values();
        this.zzl = zzfms.zza();
        this.zzm = zzfmt.zza();
        this.zza = context;
        this.zzi = zzfmrVar.ordinal();
        this.zzb = zzfmrVar;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = i5;
        this.zzf = str;
        int i6 = "oldest".equals(str2) ? 1 : (!"lru".equals(str2) && "lfu".equals(str2)) ? 3 : 2;
        this.zzg = i6;
        this.zzj = i6 - 1;
        this.zzk = 0;
    }
}
