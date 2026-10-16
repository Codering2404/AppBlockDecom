package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzblt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzblt> CREATOR = new zzblu();
    public final int zza;
    public final boolean zzb;
    public final int zzc;
    public final boolean zzd;
    public final int zze;
    public final com.google.android.gms.ads.internal.client.zzfw zzf;
    public final boolean zzg;
    public final int zzh;
    public final int zzi;
    public final boolean zzj;
    public final int zzk;

    public zzblt(int i3, boolean z2, int i4, boolean z3, int i5, com.google.android.gms.ads.internal.client.zzfw zzfwVar, boolean z4, int i6, int i7, boolean z5, int i8) {
        this.zza = i3;
        this.zzb = z2;
        this.zzc = i4;
        this.zzd = z3;
        this.zze = i5;
        this.zzf = zzfwVar;
        this.zzg = z4;
        this.zzh = i6;
        this.zzj = z5;
        this.zzi = i7;
        this.zzk = i8;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.ads.nativead.NativeAdOptions zza(com.google.android.gms.internal.ads.zzblt r5) {
        /*
            com.google.android.gms.ads.nativead.NativeAdOptions$Builder r0 = new com.google.android.gms.ads.nativead.NativeAdOptions$Builder
            r0.<init>()
            if (r5 != 0) goto Lc
            com.google.android.gms.ads.nativead.NativeAdOptions r5 = r0.a()
            return r5
        Lc:
            int r1 = r5.zza
            r2 = 2
            if (r1 == r2) goto L45
            r3 = 3
            if (r1 == r3) goto L39
            r4 = 4
            if (r1 == r4) goto L18
            goto L4a
        L18:
            boolean r1 = r5.zzg
            r0.e(r1)
            int r1 = r5.zzh
            r0.d(r1)
            int r1 = r5.zzi
            boolean r4 = r5.zzj
            r0.b(r1, r4)
            int r1 = r5.zzk
            r4 = 1
            if (r1 != 0) goto L30
        L2e:
            r2 = r4
            goto L36
        L30:
            if (r1 != r2) goto L34
            r2 = r3
            goto L36
        L34:
            if (r1 != r4) goto L2e
        L36:
            r0.q(r2)
        L39:
            com.google.android.gms.ads.internal.client.zzfw r1 = r5.zzf
            if (r1 == 0) goto L45
            com.google.android.gms.ads.VideoOptions r2 = new com.google.android.gms.ads.VideoOptions
            r2.<init>(r1)
            r0.h(r2)
        L45:
            int r1 = r5.zze
            r0.c(r1)
        L4a:
            boolean r1 = r5.zzb
            r0.g(r1)
            boolean r5 = r5.zzd
            r0.f(r5)
            com.google.android.gms.ads.nativead.NativeAdOptions r5 = r0.a()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzblt.zza(com.google.android.gms.internal.ads.zzblt):com.google.android.gms.ads.nativead.NativeAdOptions");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.zza;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, i4);
        SafeParcelWriter.g(parcel, 2, this.zzb);
        SafeParcelWriter.u(parcel, 3, this.zzc);
        SafeParcelWriter.g(parcel, 4, this.zzd);
        SafeParcelWriter.u(parcel, 5, this.zze);
        SafeParcelWriter.E(parcel, 6, this.zzf, i3, false);
        SafeParcelWriter.g(parcel, 7, this.zzg);
        SafeParcelWriter.u(parcel, 8, this.zzh);
        SafeParcelWriter.u(parcel, 9, this.zzi);
        SafeParcelWriter.g(parcel, 10, this.zzj);
        SafeParcelWriter.u(parcel, 11, this.zzk);
        SafeParcelWriter.b(parcel, iA);
    }

    @Deprecated
    public zzblt(NativeAdOptions nativeAdOptions) {
        this(4, nativeAdOptions.f(), nativeAdOptions.b(), nativeAdOptions.e(), nativeAdOptions.a(), nativeAdOptions.d() != null ? new com.google.android.gms.ads.internal.client.zzfw(nativeAdOptions.d()) : null, nativeAdOptions.g(), nativeAdOptions.c(), 0, false, 0);
    }
}
