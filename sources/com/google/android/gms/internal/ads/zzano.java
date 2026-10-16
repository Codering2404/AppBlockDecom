package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzano implements zzahk {
    private final zzahk zza;
    private final zzanj zzb;
    private zzanl zzg;
    private zzv zzh;
    private boolean zzi;
    private int zzd = 0;
    private int zze = 0;
    private byte[] zzf = zzfl.zzb;
    private final zzet zzc = new zzet();

    public zzano(zzahk zzahkVar, zzanj zzanjVar) {
        this.zza = zzahkVar;
        this.zzb = zzanjVar;
    }

    private final void zzi(int i3) {
        int length = this.zzf.length;
        int i4 = this.zze;
        if (length - i4 >= i3) {
            return;
        }
        int i5 = i4 - this.zzd;
        int iMax = Math.max(i5 + i5, i3 + i5);
        byte[] bArr = this.zzf;
        byte[] bArr2 = iMax <= bArr.length ? bArr : new byte[iMax];
        System.arraycopy(bArr, this.zzd, bArr2, 0, i5);
        this.zzd = 0;
        this.zze = i5;
        this.zzf = bArr2;
    }

    @Override // com.google.android.gms.internal.ads.zzahk
    public final void zzA(zzv zzvVar) {
        String str = zzvVar.zzp;
        str.getClass();
        zzgtj.zza(zzas.zzf(str) == 3);
        if (!zzvVar.equals(this.zzh)) {
            this.zzh = zzvVar;
            zzanj zzanjVar = this.zzb;
            this.zzg = zzanjVar.zza(zzvVar) ? zzanjVar.zzc(zzvVar) : null;
        }
        if (this.zzg == null) {
            this.zza.zzA(zzvVar);
            return;
        }
        zzahk zzahkVar = this.zza;
        zzt zztVarZza = zzvVar.zza();
        zztVarZza.zzo("application/x-media3-cues");
        zztVarZza.zzk(str);
        zztVarZza.zzt(Long.MAX_VALUE);
        zztVarZza.zzM(this.zzb.zzb(zzvVar));
        zzahkVar.zzA(zztVarZza.zzO());
    }

    @Override // com.google.android.gms.internal.ads.zzahk
    public final int zzb(zzj zzjVar, int i3, boolean z2, int i4) throws IOException {
        if (this.zzg == null) {
            return this.zza.zzb(zzjVar, i3, z2, 0);
        }
        zzi(i3);
        int iZza = zzjVar.zza(this.zzf, this.zze, i3);
        if (iZza != -1) {
            this.zze += iZza;
            return iZza;
        }
        if (z2) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.google.android.gms.internal.ads.zzahk
    public final void zzd(zzet zzetVar, int i3, int i4) {
        if (this.zzg == null) {
            this.zza.zzd(zzetVar, i3, i4);
            return;
        }
        zzi(i3);
        zzetVar.zzm(this.zzf, this.zze, i3);
        this.zze += i3;
    }

    @Override // com.google.android.gms.internal.ads.zzahk
    public final void zze(final long j3, final int i3, int i4, int i5, zzahj zzahjVar) {
        if (this.zzg == null) {
            this.zza.zze(j3, i3, i4, i5, zzahjVar);
            return;
        }
        zzgtj.zzb(zzahjVar == null, "DRM on subtitles is not supported");
        int i6 = (this.zze - i5) - i4;
        try {
            this.zzg.zza(this.zzf, i6, i4, zzank.zza(), new zzdt() { // from class: com.google.android.gms.internal.ads.zzann
                @Override // com.google.android.gms.internal.ads.zzdt
                public final /* synthetic */ void zza(Object obj) {
                    this.zza.zzh(j3, i3, (zzand) obj);
                }
            });
        } catch (RuntimeException e3) {
            if (!this.zzi) {
                throw e3;
            }
            zzeg.zzd("SubtitleTranscodingTO", "Parsing subtitles failed, ignoring sample.", e3);
        }
        int i7 = i6 + i4;
        this.zzd = i7;
        if (i7 == this.zze) {
            this.zzd = 0;
            this.zze = 0;
        }
    }

    public final void zzf(boolean z2) {
        this.zzi = true;
    }

    final /* synthetic */ void zzh(long j3, int i3, zzand zzandVar) {
        this.zzh.getClass();
        zzgwm zzgwmVar = zzandVar.zza;
        long j4 = zzandVar.zzc;
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(zzgwmVar.size());
        Iterator<E> it = zzgwmVar.iterator();
        while (it.hasNext()) {
            arrayList.add(((zzcx) it.next()).zzb());
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("c", arrayList);
        bundle.putLong("d", j4);
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeBundle(bundle);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        zzet zzetVar = this.zzc;
        int length = bArrMarshall.length;
        zzetVar.zzb(bArrMarshall, length);
        zzahk zzahkVar = this.zza;
        zzahkVar.zzc(zzetVar, length);
        long j5 = zzandVar.zzb;
        if (j5 == -9223372036854775807L) {
            zzgtj.zzi(this.zzh.zzu == Long.MAX_VALUE);
        } else {
            long j6 = this.zzh.zzu;
            j3 = j6 == Long.MAX_VALUE ? j3 + j5 : j5 + j6;
        }
        zzahkVar.zze(j3, i3 | 1, length, 0, null);
    }
}
