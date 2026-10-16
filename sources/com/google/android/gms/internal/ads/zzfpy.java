package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.IBinder;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfpy implements zzfpw {
    private final Context zza;
    private final int zzp;
    private long zzb = 0;
    private long zzc = -1;
    private boolean zzd = false;
    private int zzq = 2;
    private int zzr = 2;
    private int zze = 0;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private zzfql zzj = zzfql.SCAR_REQUEST_TYPE_UNSPECIFIED;
    private String zzk = "";
    private String zzl = "";
    private String zzm = "";
    private boolean zzn = false;
    private boolean zzo = false;

    zzfpy(Context context, int i3) {
        this.zza = context;
        this.zzp = i3;
    }

    final /* synthetic */ long zzA() {
        return this.zzb;
    }

    final /* synthetic */ long zzB() {
        return this.zzc;
    }

    final /* synthetic */ boolean zzC() {
        return this.zzd;
    }

    final /* synthetic */ int zzD() {
        return this.zze;
    }

    final /* synthetic */ String zzE() {
        return this.zzf;
    }

    final /* synthetic */ String zzF() {
        return this.zzg;
    }

    final /* synthetic */ String zzG() {
        return this.zzh;
    }

    final /* synthetic */ String zzH() {
        return this.zzi;
    }

    final /* synthetic */ zzfql zzI() {
        return this.zzj;
    }

    final /* synthetic */ String zzJ() {
        return this.zzk;
    }

    final /* synthetic */ String zzK() {
        return this.zzl;
    }

    final /* synthetic */ String zzL() {
        return this.zzm;
    }

    public final synchronized zzfpy zzM(int i3) {
        this.zzq = i3;
        return this;
    }

    final /* synthetic */ int zzN() {
        return this.zzp;
    }

    final /* synthetic */ int zzO() {
        return this.zzq;
    }

    final /* synthetic */ int zzP() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzfpw
    public final /* bridge */ /* synthetic */ zzfpw zza() {
        zzq();
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfpw
    public final synchronized boolean zzb() {
        return this.zzo;
    }

    @Override // com.google.android.gms.internal.ads.zzfpw
    public final /* bridge */ /* synthetic */ zzfpw zzc() {
        zzr();
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfpw
    public final /* bridge */ /* synthetic */ zzfpw zzd(boolean z2) {
        zzs(z2);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfpw
    public final /* bridge */ /* synthetic */ zzfpw zze(String str) {
        zzt(str);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfpw
    public final /* bridge */ /* synthetic */ zzfpw zzf(zzfql zzfqlVar) {
        zzu(zzfqlVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfpw
    public final /* bridge */ /* synthetic */ zzfpw zzg(zzfkp zzfkpVar) {
        zzv(zzfkpVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfpw
    public final /* bridge */ /* synthetic */ zzfpw zzh(com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzw(zzeVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfpw
    public final /* bridge */ /* synthetic */ zzfpw zzi(String str) {
        zzx(str);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfpw
    public final /* bridge */ /* synthetic */ zzfpw zzj(Throwable th) {
        zzy(th);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfpw
    public final /* bridge */ /* synthetic */ zzfpw zzk(String str) {
        zzz(str);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfpw
    public final boolean zzl() {
        return !TextUtils.isEmpty(this.zzh);
    }

    @Override // com.google.android.gms.internal.ads.zzfpw
    public final synchronized zzfpz zzm() {
        try {
            if (this.zzn) {
                return null;
            }
            this.zzn = true;
            if (!this.zzo) {
                zzq();
            }
            if (this.zzc < 0) {
                zzr();
            }
            return new zzfpz(this, null);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfpw
    public final /* bridge */ /* synthetic */ zzfpw zzp(int i3) {
        zzM(i3);
        return this;
    }

    public final synchronized zzfpy zzq() {
        Configuration configuration;
        com.google.android.gms.ads.internal.util.zzz zzzVarJ = com.google.android.gms.ads.internal.zzt.j();
        Context context = this.zza;
        this.zze = zzzVarJ.k(context);
        Resources resources = context.getResources();
        int i3 = 2;
        if (resources != null && (configuration = resources.getConfiguration()) != null) {
            i3 = configuration.orientation == 2 ? 4 : 3;
        }
        this.zzr = i3;
        this.zzb = com.google.android.gms.ads.internal.zzt.o().a();
        this.zzo = true;
        return this;
    }

    public final synchronized zzfpy zzr() {
        this.zzc = com.google.android.gms.ads.internal.zzt.o().a();
        return this;
    }

    public final synchronized zzfpy zzs(boolean z2) {
        this.zzd = z2;
        return this;
    }

    public final synchronized zzfpy zzt(String str) {
        this.zzi = str;
        return this;
    }

    public final synchronized zzfpy zzu(zzfql zzfqlVar) {
        this.zzj = zzfqlVar;
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
    
        r2.zzg = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized com.google.android.gms.internal.ads.zzfpy zzv(com.google.android.gms.internal.ads.zzfkp r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzfki r0 = r3.zzb     // Catch: java.lang.Throwable -> Le
            java.lang.String r0 = r0.zzb     // Catch: java.lang.Throwable -> Le
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> Le
            if (r1 != 0) goto L10
            r2.zzf = r0     // Catch: java.lang.Throwable -> Le
            goto L10
        Le:
            r3 = move-exception
            goto L2e
        L10:
            java.util.List r3 = r3.zza     // Catch: java.lang.Throwable -> Le
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> Le
        L16:
            boolean r0 = r3.hasNext()     // Catch: java.lang.Throwable -> Le
            if (r0 == 0) goto L2c
            java.lang.Object r0 = r3.next()     // Catch: java.lang.Throwable -> Le
            com.google.android.gms.internal.ads.zzfkf r0 = (com.google.android.gms.internal.ads.zzfkf) r0     // Catch: java.lang.Throwable -> Le
            java.lang.String r0 = r0.zzab     // Catch: java.lang.Throwable -> Le
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> Le
            if (r1 != 0) goto L16
            r2.zzg = r0     // Catch: java.lang.Throwable -> Le
        L2c:
            monitor-exit(r2)
            return r2
        L2e:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> Le
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfpy.zzv(com.google.android.gms.internal.ads.zzfkp):com.google.android.gms.internal.ads.zzfpy");
    }

    public final synchronized zzfpy zzw(com.google.android.gms.ads.internal.client.zze zzeVar) {
        try {
            IBinder iBinder = zzeVar.f69855f;
            if (iBinder != null) {
                zzdck zzdckVar = (zzdck) iBinder;
                String strZzk = zzdckVar.zzk();
                if (!TextUtils.isEmpty(strZzk)) {
                    this.zzf = strZzk;
                }
                String strZzf = zzdckVar.zzf();
                if (!TextUtils.isEmpty(strZzf)) {
                    this.zzg = strZzf;
                }
            }
        } finally {
        }
        return this;
    }

    public final synchronized zzfpy zzx(String str) {
        this.zzh = str;
        return this;
    }

    public final synchronized zzfpy zzy(Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkd)).booleanValue()) {
            this.zzl = zzbzy.zzf(th);
            this.zzk = (String) zzgty.zza(zzgsx.zzc('\n')).zzd(zzbzy.zze(th)).iterator().next();
        }
        return this;
    }

    public final synchronized zzfpy zzz(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkd)).booleanValue()) {
            this.zzm = str;
        }
        return this;
    }
}
