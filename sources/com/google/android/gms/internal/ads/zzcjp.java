package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.util.IOUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcjp extends zzhh {
    private final Context zza;
    private final zzhp zzb;
    private final zzcjn zzc;
    private final String zzd;
    private final int zze;
    private final boolean zzf;
    private InputStream zzg;
    private boolean zzh;
    private Uri zzi;
    private volatile zzbhb zzj;
    private boolean zzk;
    private boolean zzl;
    private boolean zzm;
    private boolean zzn;
    private long zzo;
    private ListenableFuture zzp;
    private final AtomicLong zzq;

    public zzcjp(Context context, zzhp zzhpVar, String str, int i3, zzin zzinVar, zzcjn zzcjnVar) {
        super(false);
        this.zza = context;
        this.zzb = zzhpVar;
        this.zzc = zzcjnVar;
        this.zzd = str;
        this.zze = i3;
        this.zzk = false;
        this.zzl = false;
        this.zzm = false;
        this.zzn = false;
        this.zzo = 0L;
        this.zzq = new AtomicLong(-1L);
        this.zzp = null;
        this.zzf = ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcB)).booleanValue();
        zze(zzinVar);
    }

    private final boolean zzr() {
        if (!this.zzf) {
            return false;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzfn)).booleanValue() || this.zzm) {
            return ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzfo)).booleanValue() && !this.zzn;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int zza(byte[] bArr, int i3, int i4) throws IOException {
        if (!this.zzh) {
            throw new IOException("Attempt to read closed GcacheDataSource.");
        }
        InputStream inputStream = this.zzg;
        int iZza = inputStream != null ? inputStream.read(bArr, i3, i4) : this.zzb.zza(bArr, i3, i4);
        if (this.zzf && this.zzg == null) {
            return iZza;
        }
        zzh(iZza);
        return iZza;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.ads.zzhp
    public final long zzb(zzht zzhtVar) throws Throwable {
        zzbgy zzbgyVarZzc;
        Long l3;
        boolean z2;
        boolean z3;
        long jA;
        StringBuilder sb;
        zzbhn zzbhnVar;
        if (this.zzh) {
            throw new IOException("Attempt to open an already open GcacheDataSource.");
        }
        boolean z4 = true;
        this.zzh = true;
        Uri uri = zzhtVar.zza;
        this.zzi = uri;
        boolean z5 = this.zzf;
        if (z5 == 0) {
            zzg(zzhtVar);
        }
        this.zzj = zzbhb.zza(uri);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzfk)).booleanValue()) {
            if (this.zzj != null) {
                this.zzj.zzh = zzhtVar.zze;
                this.zzj.zzi = zzgua.zza(this.zzd);
                this.zzj.zzj = this.zze;
                zzbgyVarZzc = com.google.android.gms.ads.internal.zzt.n().zzc(this.zzj);
            } else {
                zzbgyVarZzc = null;
            }
            if (zzbgyVarZzc != null && zzbgyVarZzc.zza()) {
                this.zzk = zzbgyVarZzc.zzd();
                this.zzm = zzbgyVarZzc.zzg();
                this.zzn = zzbgyVarZzc.zze();
                this.zzo = zzbgyVarZzc.zzf();
                this.zzl = true;
                if (!zzr()) {
                    this.zzg = zzbgyVarZzc.zzb();
                    if (this.zzf) {
                        zzg(zzhtVar);
                    }
                    return -1L;
                }
            }
        } else if (this.zzj != null) {
            this.zzj.zzh = zzhtVar.zze;
            this.zzj.zzi = zzgua.zza(this.zzd);
            this.zzj.zzj = this.zze;
            if (this.zzj.zzg) {
                l3 = (Long) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzfm);
            } else {
                l3 = (Long) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzfl);
            }
            long jLongValue = l3.longValue();
            long jA2 = com.google.android.gms.ads.internal.zzt.o().a();
            com.google.android.gms.ads.internal.zzt.D();
            Future futureZza = zzbhm.zza(this.zza, this.zzj);
            try {
                try {
                    zzbhnVar = (zzbhn) futureZza.get(jLongValue, TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    th = th;
                    z4 = z5;
                }
            } catch (InterruptedException unused) {
                z3 = false;
            } catch (ExecutionException | TimeoutException unused2) {
                z2 = false;
            } catch (Throwable th2) {
                th = th2;
                z4 = false;
            }
            try {
                this.zzk = zzbhnVar.zzc();
                this.zzm = zzbhnVar.zzd();
                this.zzn = zzbhnVar.zzf();
                this.zzo = zzbhnVar.zze();
                if (!zzr()) {
                    this.zzg = zzbhnVar.zzb();
                    if (z5 != 0) {
                        zzg(zzhtVar);
                    }
                    long jA3 = com.google.android.gms.ads.internal.zzt.o().a() - jA2;
                    this.zzc.zza(true, jA3);
                    this.zzl = true;
                    StringBuilder sb2 = new StringBuilder(String.valueOf(jA3).length() + 24);
                    sb2.append("Cache connection took ");
                    sb2.append(jA3);
                    sb2.append("ms");
                    com.google.android.gms.ads.internal.util.zze.k(sb2.toString());
                    return -1L;
                }
                long jA4 = com.google.android.gms.ads.internal.zzt.o().a() - jA2;
                this.zzc.zza(true, jA4);
                this.zzl = true;
                sb = new StringBuilder(String.valueOf(jA4).length() + 24);
                sb.append("Cache connection took ");
                sb.append(jA4);
            } catch (InterruptedException unused3) {
                z3 = true;
                futureZza.cancel(true);
                Thread.currentThread().interrupt();
                jA = com.google.android.gms.ads.internal.zzt.o().a() - jA2;
                this.zzc.zza(z3, jA);
                this.zzl = z3;
                int length = String.valueOf(jA).length() + 24;
                sb = new StringBuilder(length);
                z5 = length;
                sb.append("Cache connection took ");
                sb.append(jA);
            } catch (ExecutionException | TimeoutException unused4) {
                z2 = true;
                futureZza.cancel(true);
                jA = com.google.android.gms.ads.internal.zzt.o().a() - jA2;
                this.zzc.zza(z2, jA);
                this.zzl = z2;
                int length2 = String.valueOf(jA).length() + 24;
                sb = new StringBuilder(length2);
                z5 = length2;
                sb.append("Cache connection took ");
                sb.append(jA);
            } catch (Throwable th3) {
                th = th3;
                long jA5 = com.google.android.gms.ads.internal.zzt.o().a() - jA2;
                this.zzc.zza(z4, jA5);
                this.zzl = z4;
                StringBuilder sb3 = new StringBuilder(String.valueOf(jA5).length() + 24);
                sb3.append("Cache connection took ");
                sb3.append(jA5);
                sb3.append("ms");
                com.google.android.gms.ads.internal.util.zze.k(sb3.toString());
                throw th;
            }
            sb.append("ms");
            com.google.android.gms.ads.internal.util.zze.k(sb.toString());
        }
        this.zzl = false;
        if (this.zzj != null) {
            zzhs zzhsVarZzb = zzhtVar.zzb();
            zzhsVarZzb.zza(Uri.parse(this.zzj.zza));
            zzhtVar = zzhsVarZzb.zze();
        }
        return this.zzb.zzb(zzhtVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final Uri zzc() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final void zzd() throws IOException {
        if (!this.zzh) {
            throw new IOException("Attempt to close an already closed GcacheDataSource.");
        }
        this.zzh = false;
        this.zzi = null;
        boolean z2 = (this.zzf && this.zzg == null) ? false : true;
        InputStream inputStream = this.zzg;
        if (inputStream != null) {
            IOUtils.a(inputStream);
            this.zzg = null;
        } else {
            this.zzb.zzd();
        }
        if (z2) {
            zzi();
        }
    }

    public final boolean zzk() {
        return this.zzk;
    }

    public final boolean zzl() {
        return this.zzl;
    }

    public final boolean zzm() {
        return this.zzm;
    }

    public final boolean zzn() {
        return this.zzn;
    }

    public final long zzo() {
        return this.zzo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long zzp() {
        if (this.zzj != null) {
            AtomicLong atomicLong = this.zzq;
            if (atomicLong.get() != -1) {
                return atomicLong.get();
            }
            synchronized (this) {
                try {
                    if (this.zzp == null) {
                        this.zzp = zzcfr.zza.submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzcjo
                            @Override // java.util.concurrent.Callable
                            public final /* synthetic */ Object call() {
                                return this.zza.zzq();
                            }
                        });
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.zzp.isDone()) {
                try {
                    this.zzq.compareAndSet(-1L, ((Long) this.zzp.get()).longValue());
                    return this.zzq.get();
                } catch (InterruptedException | ExecutionException unused) {
                }
            }
        }
        return -1L;
    }

    final /* synthetic */ Long zzq() {
        return Long.valueOf(com.google.android.gms.ads.internal.zzt.n().zzd(this.zzj));
    }
}
