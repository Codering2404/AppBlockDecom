package com.android.billingclient.api;

import android.content.Context;
import com.google.android.gms.internal.play_billing.zziu;
import com.google.android.gms.internal.play_billing.zziw;
import com.google.android.gms.internal.play_billing.zziy;
import com.google.android.gms.internal.play_billing.zzja;
import com.google.android.gms.internal.play_billing.zzji;
import com.google.android.gms.internal.play_billing.zzjp;
import com.google.android.gms.internal.play_billing.zzjr;
import com.google.android.gms.internal.play_billing.zzjz;
import com.google.android.gms.internal.play_billing.zzkf;
import com.google.android.gms.internal.play_billing.zzkh;
import com.google.android.gms.internal.play_billing.zzkn;
import com.google.android.gms.internal.play_billing.zzkr;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzdl implements zzcz {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zzjr f57583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdn f57584c;

    zzdl(Context context, zzjr zzjrVar) {
        this.f57584c = new zzdn(context);
        this.f57583b = zzjrVar;
    }

    private final void l(zziw zziwVar, zzjr zzjrVar) {
        if (zziwVar == null) {
            return;
        }
        try {
            zzkf zzkfVarZza = zzkh.zza();
            zzkfVarZza.zzd(zzjrVar);
            zzkfVarZza.zza(zziwVar);
            this.f57584c.a((zzkh) zzkfVarZza.zzi());
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingLogger", "Unable to log.", th);
        }
    }

    private final void m(zzja zzjaVar, zzjr zzjrVar) {
        if (zzjaVar == null) {
            return;
        }
        try {
            zzkf zzkfVarZza = zzkh.zza();
            zzkfVarZza.zzd(zzjrVar);
            zzkfVarZza.zzb(zzjaVar);
            this.f57584c.a((zzkh) zzkfVarZza.zzi());
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.zzcz
    public final void a(zzja zzjaVar, int i3) {
        try {
            zzjp zzjpVar = (zzjp) this.f57583b.zzq();
            zzjpVar.zzc(i3);
            this.f57583b = (zzjr) zzjpVar.zzi();
            g(zzjaVar);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.zzcz
    public final void b(zzji zzjiVar) {
        try {
            zzkf zzkfVarZza = zzkh.zza();
            zzkfVarZza.zzd(this.f57583b);
            zzkfVarZza.zzc(zzjiVar);
            this.f57584c.a((zzkh) zzkfVarZza.zzi());
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.zzcz
    public final void c(zziw zziwVar, long j3, boolean z2) {
        zzjr zzjrVar;
        try {
            zziu zziuVar = (zziu) zziwVar.zzq();
            zzjz zzjzVar = (zzjz) zziwVar.zze().zzq();
            zzjzVar.zza(z2);
            zziuVar.zzd(zzjzVar);
            zziw zziwVar2 = (zziw) zziuVar.zzi();
            if (j3 == 0) {
                zzjrVar = this.f57583b;
            } else {
                zzjp zzjpVar = (zzjp) this.f57583b.zzq();
                zzjpVar.zze(j3);
                zzjrVar = (zzjr) zzjpVar.zzi();
            }
            l(zziwVar2, zzjrVar);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.zzcz
    public final void d(zziw zziwVar, int i3, long j3) {
        try {
            zzjp zzjpVar = (zzjp) this.f57583b.zzq();
            zzjpVar.zzc(i3);
            zzjr zzjrVar = (zzjr) zzjpVar.zzi();
            this.f57583b = zzjrVar;
            if (j3 != 0) {
                zzjp zzjpVar2 = (zzjp) zzjrVar.zzq();
                zzjpVar2.zze(j3);
                zzjrVar = (zzjr) zzjpVar2.zzi();
            }
            l(zziwVar, zzjrVar);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.zzcz
    public final void e(zzkn zzknVar) {
        try {
            zzdn zzdnVar = this.f57584c;
            zzkf zzkfVarZza = zzkh.zza();
            zzkfVarZza.zzd(this.f57583b);
            zzkfVarZza.zze(zzknVar);
            zzdnVar.a((zzkh) zzkfVarZza.zzi());
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.zzcz
    public final void f(zziw zziwVar, int i3) {
        try {
            zzjp zzjpVar = (zzjp) this.f57583b.zzq();
            zzjpVar.zzc(i3);
            this.f57583b = (zzjr) zzjpVar.zzi();
            k(zziwVar);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.zzcz
    public final void g(zzja zzjaVar) {
        try {
            m(zzjaVar, this.f57583b);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.zzcz
    public final void h(zzkr zzkrVar) {
        if (zzkrVar == null) {
            return;
        }
        try {
            zzkf zzkfVarZza = zzkh.zza();
            zzkfVarZza.zzd(this.f57583b);
            zzkfVarZza.zzp(zzkrVar);
            this.f57584c.a((zzkh) zzkfVarZza.zzi());
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.zzcz
    public final void i(zzja zzjaVar, long j3, boolean z2) {
        zzjr zzjrVar;
        try {
            zziy zziyVar = (zziy) zzjaVar.zzq();
            zzjz zzjzVar = (zzjz) zzjaVar.zzc().zzq();
            zzjzVar.zza(z2);
            zziyVar.zzc(zzjzVar);
            zzja zzjaVar2 = (zzja) zziyVar.zzi();
            if (j3 == 0) {
                zzjrVar = this.f57583b;
            } else {
                zzjp zzjpVar = (zzjp) this.f57583b.zzq();
                zzjpVar.zze(j3);
                zzjrVar = (zzjr) zzjpVar.zzi();
            }
            m(zzjaVar2, zzjrVar);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.zzcz
    public final void j(zziw zziwVar, int i3, long j3, boolean z2) {
        zzjr zzjrVar;
        try {
            zzjp zzjpVar = (zzjp) this.f57583b.zzq();
            zzjpVar.zzc(i3);
            this.f57583b = (zzjr) zzjpVar.zzi();
            zziu zziuVar = (zziu) zziwVar.zzq();
            zzjz zzjzVar = (zzjz) zziwVar.zze().zzq();
            zzjzVar.zza(z2);
            zziuVar.zzd(zzjzVar);
            zziw zziwVar2 = (zziw) zziuVar.zzi();
            if (j3 == 0) {
                zzjrVar = this.f57583b;
            } else {
                zzjp zzjpVar2 = (zzjp) this.f57583b.zzq();
                zzjpVar2.zze(j3);
                zzjrVar = (zzjr) zzjpVar2.zzi();
            }
            l(zziwVar2, zzjrVar);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.zzcz
    public final void k(zziw zziwVar) {
        try {
            l(zziwVar, this.f57583b);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingLogger", "Unable to log.", th);
        }
    }
}
