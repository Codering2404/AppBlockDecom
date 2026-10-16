package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbcg extends zzbdf {
    private static final zzbdg zzh = new zzbdg();
    private final zzaxf zzi;
    private final Context zzj;
    private final zzazm zzk;

    public zzbcg(zzbbs zzbbsVar, String str, String str2, zzaxm zzaxmVar, int i3, int i4, Context context, zzawy zzawyVar, zzaxf zzaxfVar, zzazm zzazmVar) {
        super(zzbbsVar, "Y4Si1UCd8xFA1yCw6ohazV+GUSwhVa9ffV9ZnN++nWMAkqLsgU7cmmd4wBpbGVgj", "1k+Az7ZOHMkdpE7lGA2cF/gUEsamDqjjLqQDV0dmR3A=", zzaxmVar, i3, 27);
        this.zzj = context;
        this.zzi = zzaxfVar;
        this.zzk = zzazmVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final zzazj zzc() throws IllegalAccessException, InvocationTargetException {
        String str;
        zzbih zzbihVar = zzbiq.zzdE;
        int iZzb = (((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbihVar)).intValue() <= 0 || ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbihVar)).intValue() >= this.zzi.zzb()) ? this.zzi.zzb() : ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbihVar)).intValue();
        zzazj zzazjVar = new zzazj((String) this.zze.invoke(null, this.zzj, Boolean.FALSE, ""));
        zzazm zzazmVar = this.zzk;
        if (zzazmVar == null || zzazmVar.zza() == null) {
            str = "E";
        } else {
            try {
                str = (String) zzazmVar.zza().get(iZzb, TimeUnit.MILLISECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException unused) {
                str = "E";
            }
        }
        zzazjVar.zza = str;
        return zzazjVar;
    }

    private final String zzd() {
        try {
            zzbbs zzbbsVar = this.zza;
            if (zzbbsVar.zzm() != null) {
                zzbbsVar.zzm().get();
            }
            zzaym zzaymVarZzl = zzbbsVar.zzl();
            if (zzaymVarZzl == null || !zzaymVarZzl.zza()) {
                return null;
            }
            return zzaymVarZzl.zzb();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        int i3;
        zzazj zzazjVarZzc;
        zzazj zzazjVar;
        zzbdg zzbdgVar = zzh;
        Context context = this.zzj;
        AtomicReference atomicReferenceZza = zzbdgVar.zza(context.getPackageName());
        synchronized (atomicReferenceZza) {
            try {
                zzazj zzazjVar2 = (zzazj) atomicReferenceZza.get();
                if (zzazjVar2 == null || zzbbv.zzc(zzazjVar2.zza) || zzazjVar2.zza.equals("E") || zzazjVar2.zza.equals("0000000000000000000000000000000000000000000000000000000000000000")) {
                    if (zzbbv.zzc(null)) {
                        zzbbv.zzc(null);
                        i3 = 3;
                    } else {
                        i3 = 5;
                    }
                    if (this.zzk != null) {
                        zzazjVarZzc = zzc();
                    } else {
                        boolean z2 = false;
                        if (i3 == 3 && !this.zzi.zza()) {
                            z2 = true;
                        }
                        Boolean boolValueOf = Boolean.valueOf(z2);
                        Boolean bool = (Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzdq);
                        String strZzb = ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzdp)).booleanValue() ? zzb() : null;
                        if (bool.booleanValue() && this.zza.zzi() && zzbbv.zzc(strZzb)) {
                            strZzb = zzd();
                        }
                        zzazj zzazjVar3 = new zzazj((String) this.zze.invoke(null, context, boolValueOf, strZzb));
                        String str = zzazjVar3.zza;
                        if (zzbbv.zzc(str) || str.equals("E")) {
                            int i4 = i3 - 1;
                            if (i4 == 3) {
                                String strZzd = zzd();
                                if (!zzbbv.zzc(strZzd)) {
                                    zzazjVar3.zza = strZzd;
                                }
                            } else if (i4 == 4) {
                                throw null;
                            }
                        }
                        zzazjVarZzc = zzazjVar3;
                    }
                    atomicReferenceZza.set(zzazjVarZzc);
                }
                zzazjVar = (zzazj) atomicReferenceZza.get();
            } finally {
            }
        }
        zzaxm zzaxmVar = this.zzd;
        synchronized (zzaxmVar) {
            if (zzazjVar != null) {
                try {
                    zzaxmVar.zzo(zzazjVar.zza);
                    zzaxmVar.zzu(zzazjVar.zzb);
                    zzaxmVar.zzt(zzazjVar.zzc);
                    zzaxmVar.zzD(zzazjVar.zzd);
                    zzaxmVar.zzE(zzazjVar.zze);
                } finally {
                }
            }
        }
    }

    protected final String zzb() {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            byte[] bArrZzb = zzbbv.zzb((String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzdr));
            ArrayList arrayList = new ArrayList();
            arrayList.add(certificateFactory.generateCertificate(new ByteArrayInputStream(bArrZzb)));
            if (!Build.TYPE.equals("user")) {
                arrayList.add(certificateFactory.generateCertificate(new ByteArrayInputStream(zzbbv.zzb((String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzds)))));
            }
            Context context = this.zzj;
            return zzbdi.zza(context, context.getPackageName(), arrayList, this.zza.zzd());
        } catch (PackageManager.NameNotFoundException | InterruptedException | NoClassDefFoundError | CertificateEncodingException | CertificateException | ExecutionException unused) {
            return null;
        }
    }
}
