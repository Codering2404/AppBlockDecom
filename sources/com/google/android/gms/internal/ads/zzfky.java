package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfky {
    public final com.google.android.gms.ads.internal.client.zzfw zza;
    public final zzbsb zzb;
    public final zzetc zzc;
    public final com.google.android.gms.ads.internal.client.zzm zzd;
    public final Bundle zze;
    public final com.google.android.gms.ads.internal.client.zzr zzf;
    public final String zzg;
    public final ArrayList zzh;
    public final ArrayList zzi;
    public final zzblt zzj;
    public final com.google.android.gms.ads.internal.client.zzx zzk;
    public final int zzl;
    public final AdManagerAdViewOptions zzm;
    public final PublisherAdViewOptions zzn;
    public final com.google.android.gms.ads.internal.client.zzcl zzo;
    public final zzfkm zzp;
    public final boolean zzq;
    public final boolean zzr;
    public final boolean zzs;
    public final Bundle zzt;
    public final AtomicLong zzu;
    public final boolean zzv;
    public final JSONArray zzw;
    public final com.google.android.gms.ads.internal.client.zzcp zzx;

    /* synthetic */ zzfky(zzfkx zzfkxVar, byte[] bArr) {
        this.zzf = zzfkxVar.zzF();
        this.zzg = zzfkxVar.zzG();
        this.zzx = zzfkxVar.zzac();
        this.zze = zzfkxVar.zzE().C;
        com.google.android.gms.ads.internal.client.zzm zzmVarZzE = zzfkxVar.zzE();
        com.google.android.gms.ads.internal.client.zzm zzmVarZzE2 = zzfkxVar.zzE();
        com.google.android.gms.ads.internal.client.zzm zzmVarZzE3 = zzfkxVar.zzE();
        com.google.android.gms.ads.internal.client.zzm zzmVarZzE4 = zzfkxVar.zzE();
        com.google.android.gms.ads.internal.client.zzm zzmVarZzE5 = zzfkxVar.zzE();
        com.google.android.gms.ads.internal.client.zzm zzmVarZzE6 = zzfkxVar.zzE();
        com.google.android.gms.ads.internal.client.zzm zzmVarZzE7 = zzfkxVar.zzE();
        int i3 = zzfkxVar.zzE().f69964a;
        long j3 = zzmVarZzE7.f69965b;
        Bundle bundle = zzmVarZzE6.f69966c;
        int i4 = zzmVarZzE5.f69967d;
        List list = zzmVarZzE4.f69968f;
        boolean z2 = zzmVarZzE3.f69969g;
        int i5 = zzmVarZzE2.f69970h;
        boolean z3 = true;
        if (!zzmVarZzE.f69971i && !zzfkxVar.zzI()) {
            z3 = false;
        }
        com.google.android.gms.ads.internal.client.zzm zzmVar = new com.google.android.gms.ads.internal.client.zzm(i3, j3, bundle, i4, list, z2, i5, z3, zzfkxVar.zzE().f69972j, zzfkxVar.zzE().f69973k, zzfkxVar.zzE().f69974l, zzfkxVar.zzE().f69975m, zzfkxVar.zzE().f69976n, zzfkxVar.zzE().f69977o, zzfkxVar.zzE().f69978p, zzfkxVar.zzE().f69979q, zzfkxVar.zzE().f69980r, zzfkxVar.zzE().f69981s, zzfkxVar.zzE().f69982t, zzfkxVar.zzE().f69983u, zzfkxVar.zzE().f69984v, zzfkxVar.zzE().f69985w, com.google.android.gms.ads.internal.util.zzs.A(zzfkxVar.zzE().f69986x), zzfkxVar.zzE().f69987y, zzfkxVar.zzE().f69988z, zzfkxVar.zzE().A, zzfkxVar.zzE().B);
        this.zzd = zzmVar;
        this.zza = zzfkxVar.zzH() != null ? zzfkxVar.zzH() : zzfkxVar.zzL() != null ? zzfkxVar.zzL().zzf : null;
        this.zzh = zzfkxVar.zzJ();
        this.zzi = zzfkxVar.zzK();
        this.zzj = zzfkxVar.zzJ() == null ? null : zzfkxVar.zzL() == null ? new zzblt(new NativeAdOptions.Builder().a()) : zzfkxVar.zzL();
        this.zzk = zzfkxVar.zzM();
        this.zzl = zzfkxVar.zzQ();
        this.zzm = zzfkxVar.zzN();
        this.zzn = zzfkxVar.zzO();
        this.zzo = zzfkxVar.zzP();
        this.zzb = zzfkxVar.zzR();
        this.zzp = new zzfkm(zzfkxVar.zzS(), null);
        this.zzq = zzfkxVar.zzT();
        this.zzr = zzfkxVar.zzU();
        this.zzc = zzfkxVar.zzV();
        this.zzs = zzfkxVar.zzW();
        this.zzt = zzfkxVar.zzX();
        this.zzu = zzmVar.B != 0 ? new AtomicLong(zzmVar.B) : zzfkxVar.zzY();
        this.zzv = zzfkxVar.zzZ();
        this.zzw = zzfkxVar.zzaa();
    }

    public final boolean zza() {
        return this.zzg.matches((String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzef));
    }
}
