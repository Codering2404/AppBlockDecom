package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.nonagon.devicetier.DeviceTierManager;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzcnj implements zzcrq {

    @Nullable
    private static zzcnj zza;

    private static synchronized zzcnj zzH(Context context, @Nullable zzbvc zzbvcVar, int i3, boolean z2, int i4, zzcot zzcotVar) {
        try {
            zzcnj zzcnjVar = zza;
            if (zzcnjVar != null) {
                return zzcnjVar;
            }
            long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.o().currentTimeMillis();
            zzbiq.zza(context);
            if (((Boolean) zzbki.zze.zze()).booleanValue()) {
                zzbib.zza(context);
            }
            zzflu zzfluVarZza = zzflu.zza(context);
            VersionInfoParcel versionInfoParcelZzb = zzfluVarZza.zzb(ModuleDescriptor.MODULE_VERSION, false, i4);
            zzfluVarZza.zzc(zzbvcVar);
            zzcpi zzcpiVar = new zzcpi(null);
            zzcnk zzcnkVar = new zzcnk();
            zzcnkVar.zza(versionInfoParcelZzb);
            zzcnkVar.zzb(context);
            zzcnkVar.zzc(jCurrentTimeMillis);
            zzcpiVar.zza(new zzcnl(zzcnkVar, null));
            zzcpiVar.zzb(new zzcqf(zzcotVar));
            zzcnj zzcnjVarZzc = zzcpiVar.zzc();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzpl)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.i().zza(zzfoa.zzc(), zzcnjVarZzc.zzD(), context);
                com.google.android.gms.ads.internal.zzt.i().zzb();
            }
            ((zzeeb) ((zzcox) zzcnjVarZzc).zzs.zzb()).zza();
            ((zzcnc) ((zzcox) zzcnjVarZzc).zzr.zzb()).zza(context, versionInfoParcelZzb);
            com.google.android.gms.ads.internal.zzt.l().zze(context, versionInfoParcelZzb, zzcnjVarZzc.zzD());
            com.google.android.gms.ads.internal.zzt.n().zza(context);
            com.google.android.gms.ads.internal.zzt.g().N(context);
            com.google.android.gms.ads.internal.zzt.g().O(context);
            com.google.android.gms.ads.internal.util.zzd.a(context);
            com.google.android.gms.ads.internal.zzt.k().zza(context);
            com.google.android.gms.ads.internal.zzt.a().a(context);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzpH)).booleanValue()) {
                String str = (String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzpI);
                if (!str.isEmpty()) {
                    if (Arrays.asList(str.split(",")).contains(context.getPackageName())) {
                        zzcnjVarZzc.zzE().zza(com.google.android.gms.ads.internal.zzt.k());
                    }
                }
            } else {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzpG)).booleanValue()) {
                    zzcnjVarZzc.zzE().zza(com.google.android.gms.ads.internal.zzt.k());
                }
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzpR)).booleanValue()) {
                ((DeviceTierManager) ((zzcox) zzcnjVarZzc).zzm.zzb()).c();
            }
            ((com.google.android.gms.ads.internal.util.zzbz) ((zzcox) zzcnjVarZzc).zzay.zzb()).a();
            zzcea.zzb(context);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhh)).booleanValue()) {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzbi)).booleanValue()) {
                    new zzeju(context, versionInfoParcelZzb, new zzbhp(new zzbhu(context)), new zzeiz(new zzeiv(context), (zzhcg) ((zzcox) zzcnjVarZzc).zzd.zzb())).zza(com.google.android.gms.ads.internal.zzt.l().zzo().zzx());
                }
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzpA)).booleanValue()) {
                zzcnjVarZzc.zzg().zza();
            }
            zza = zzcnjVarZzc;
            return zzcnjVarZzc;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static zzcnj zza(Context context, @Nullable zzbvc zzbvcVar, int i3) {
        return zzH(context, zzbvcVar, ModuleDescriptor.MODULE_VERSION, false, i3, new zzcot());
    }

    public abstract zzebc zzA();

    public abstract zzflo zzB();

    public abstract zzedo zzC();

    public abstract zzdzl zzD();

    abstract zzdwu zzE();

    @Override // com.google.android.gms.internal.ads.zzcrq
    public final zzcet zzF() {
        return zzG();
    }

    public abstract zzcet zzG();

    public abstract Executor zzb();

    public abstract ScheduledExecutorService zzc();

    public abstract zzdfs zzd();

    public abstract zzcqr zze();

    public abstract zzftb zzf();

    public abstract zzehg zzg();

    public abstract zzehi zzh();

    public abstract zzcwp zzi();

    public abstract zzfgu zzj();

    public abstract zzcuy zzk();

    public abstract zzffg zzl();

    public abstract zzdnf zzm();

    public abstract zzfik zzn();

    public abstract zzdob zzo();

    public abstract zzdvq zzp();

    public abstract zzfjy zzq();

    public abstract com.google.android.gms.ads.nonagon.signalgeneration.zzw zzr();

    public abstract com.google.android.gms.ads.nonagon.signalgeneration.zzap zzs();

    public abstract com.google.android.gms.ads.nonagon.signalgeneration.zzq zzt();

    public abstract zzekr zzu();

    public abstract zzflx zzv();

    public abstract zzecr zzw();

    public abstract zzfqj zzx();

    @Override // com.google.android.gms.internal.ads.zzcrq
    public final zzfdm zzy(zzcbd zzcbdVar, int i3) {
        return zzz(new zzfep(zzcbdVar, i3));
    }

    protected abstract zzfdm zzz(zzfep zzfepVar);
}
