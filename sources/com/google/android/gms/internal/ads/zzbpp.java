package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.facebook.appevents.AppEventsConstants;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbpp {
    public static final zzbpq zza = zzbpo.zza;
    public static final zzbpq zzb = zzbpf.zza;
    public static final zzbpq zzc = zzbpg.zza;
    public static final zzbpq zzd = new zzbox();
    public static final zzbpq zze = new zzboy();
    public static final zzbpq zzf = zzbpl.zza;
    public static final zzbpq zzg = new zzboz();
    public static final zzbpq zzh = new zzbpa();
    public static final zzbpq zzi = zzbpm.zza;
    public static final zzbpq zzj = new zzbpb();
    public static final zzbpq zzk = new zzbpc();
    public static final zzbpq zzl = new zzcio();
    public static final zzbpq zzm = new zzcip();
    public static final zzbpq zzn = new zzboj();
    public static final zzbqh zzo = new zzbqh();
    public static final zzbpq zzp = new zzbpd();
    public static final zzbpq zzq = new zzbpe();
    public static final zzbpq zzr = new zzbok();
    public static final zzbpq zzs = new zzbol();
    public static final zzbpq zzt = new zzbom();
    public static final zzbpq zzu = new zzbon();
    public static final zzbpq zzv = new zzboo();
    public static final zzbpq zzw = new zzbop();
    public static final zzbpq zzx = new zzboq();
    public static final zzbpq zzy = new zzbor();
    public static final zzbpq zzz = new zzbos();
    public static final zzbpq zzA = new zzbot();
    public static final zzbpq zzB = new zzbov();
    public static final zzbpq zzC = new zzbow();

    public static ListenableFuture zza(zzcku zzckuVar, String str) {
        Uri uriZzd = Uri.parse(str);
        try {
            zzbap zzbapVarZzS = zzckuVar.zzS();
            zzflc zzflcVarZzT = zzckuVar.zzT();
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zznw)).booleanValue() || zzflcVarZzT == null) {
                if (zzbapVarZzS != null && zzbapVarZzS.zza(uriZzd)) {
                    uriZzd = zzbapVarZzS.zzd(uriZzd, zzckuVar.getContext(), zzckuVar.zzE(), zzckuVar.zzj());
                }
            } else if (zzbapVarZzS != null && zzbapVarZzS.zza(uriZzd)) {
                uriZzd = zzflcVarZzT.zza(uriZzd, zzckuVar.getContext(), zzckuVar.zzE(), zzckuVar.zzj());
            }
        } catch (zzbaq unused) {
            String strConcat = "Unable to append parameter to URL: ".concat(str);
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f(strConcat);
        }
        Map map = new HashMap();
        if (zzckuVar.zzC() != null) {
            map = zzckuVar.zzC().zzaw;
        }
        final String strZzb = zzceb.zzb(uriZzd, zzckuVar.getContext(), map);
        long jLongValue = ((Long) zzbkp.zze.zze()).longValue();
        if (jLongValue <= 0 || jLongValue > 261210000) {
            return zzhbw.zza(strZzb);
        }
        zzhbo zzhboVarZzw = zzhbo.zzw(zzckuVar.zzaF());
        zzbph zzbphVar = zzbph.zza;
        zzhcg zzhcgVar = zzcfr.zzh;
        return (zzhbo) zzhbw.zzg((zzhbo) zzhbw.zzk((zzhbo) zzhbw.zzg(zzhboVarZzw, Throwable.class, zzbphVar, zzhcgVar), new zzgta() { // from class: com.google.android.gms.internal.ads.zzbpi
            /* JADX WARN: Removed duplicated region for block: B:16:0x004f  */
            /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
            @Override // com.google.android.gms.internal.ads.zzgta
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final /* synthetic */ java.lang.Object apply(java.lang.Object r6) {
                /*
                    r5 = this;
                    java.lang.String r6 = (java.lang.String) r6
                    com.google.android.gms.internal.ads.zzbpq r0 = com.google.android.gms.internal.ads.zzbpp.zza
                    java.lang.String r0 = r1
                    if (r6 != 0) goto L9
                    goto L74
                L9:
                    com.google.android.gms.internal.ads.zzbka r1 = com.google.android.gms.internal.ads.zzbkp.zzf
                    java.lang.Object r1 = r1.zze()
                    java.lang.Boolean r1 = (java.lang.Boolean) r1
                    boolean r1 = r1.booleanValue()
                    if (r1 != 0) goto L18
                    goto L39
                L18:
                    java.lang.String r1 = ".googleadservices.com"
                    java.lang.String r2 = ".googlesyndication.com"
                    java.lang.String r3 = ".doubleclick.net"
                    java.lang.String[] r1 = new java.lang.String[]{r3, r1, r2}
                    android.net.Uri r2 = android.net.Uri.parse(r0)
                    java.lang.String r2 = r2.getHost()
                    r3 = 0
                L2b:
                    r4 = 3
                    if (r3 >= r4) goto L74
                    r4 = r1[r3]
                    boolean r4 = r2.endsWith(r4)
                    if (r4 != 0) goto L39
                    int r3 = r3 + 1
                    goto L2b
                L39:
                    com.google.android.gms.internal.ads.zzbka r1 = com.google.android.gms.internal.ads.zzbkp.zza
                    java.lang.Object r1 = r1.zze()
                    java.lang.String r1 = (java.lang.String) r1
                    com.google.android.gms.internal.ads.zzbka r2 = com.google.android.gms.internal.ads.zzbkp.zzb
                    java.lang.Object r2 = r2.zze()
                    java.lang.String r2 = (java.lang.String) r2
                    boolean r3 = android.text.TextUtils.isEmpty(r1)
                    if (r3 != 0) goto L53
                    java.lang.String r0 = r0.replace(r1, r6)
                L53:
                    boolean r1 = android.text.TextUtils.isEmpty(r2)
                    if (r1 != 0) goto L74
                    android.net.Uri r1 = android.net.Uri.parse(r0)
                    java.lang.String r3 = r1.getQueryParameter(r2)
                    boolean r3 = android.text.TextUtils.isEmpty(r3)
                    if (r3 == 0) goto L74
                    android.net.Uri$Builder r0 = r1.buildUpon()
                    android.net.Uri$Builder r6 = r0.appendQueryParameter(r2, r6)
                    java.lang.String r6 = r6.toString()
                    return r6
                L74:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbpi.apply(java.lang.Object):java.lang.Object");
            }
        }, zzhcgVar), Throwable.class, new zzgta() { // from class: com.google.android.gms.internal.ads.zzbpj
            @Override // com.google.android.gms.internal.ads.zzgta
            public final /* synthetic */ Object apply(Object obj) {
                Throwable th = (Throwable) obj;
                zzbpq zzbpqVar = zzbpp.zza;
                if (((Boolean) zzbkp.zzi.zze()).booleanValue()) {
                    com.google.android.gms.ads.internal.zzt.l().zzg(th, "prepareClickUrl.attestation2");
                }
                return strZzb;
            }
        }, zzhcgVar);
    }

    public static zzbpq zzb(final zzdky zzdkyVar, final zzctj zzctjVar) {
        return new zzbpq() { // from class: com.google.android.gms.internal.ads.zzbpk
            @Override // com.google.android.gms.internal.ads.zzbpq
            public final /* synthetic */ void zza(Object obj, Map map) {
                zzcku zzckuVar = (zzcku) obj;
                zzbpp.zzc(map, zzdkyVar);
                final String str = (String) map.get("u");
                if (str == null) {
                    int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                    com.google.android.gms.ads.internal.util.client.zzo.f("URL missing from click GMSG.");
                    return;
                }
                final zzctj zzctjVar2 = zzctjVar;
                zzhbo zzhboVarZzw = zzhbo.zzw(zzbpp.zza(zzckuVar, str));
                zzhbe zzhbeVar = new zzhbe() { // from class: com.google.android.gms.internal.ads.zzbpn
                    @Override // com.google.android.gms.internal.ads.zzhbe
                    public final /* synthetic */ ListenableFuture zza(Object obj2) {
                        zzctj zzctjVar3;
                        String str2 = (String) obj2;
                        zzbpq zzbpqVar = zzbpp.zza;
                        return (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzlw)).booleanValue() && (zzctjVar3 = zzctjVar2) != null && zzctj.zzc(str)) ? zzctjVar3.zzb(str2, com.google.android.gms.ads.internal.client.zzay.h()) : zzhbw.zza(str2);
                    }
                };
                zzhcg zzhcgVar = zzcfr.zza;
                zzhbw.zzr((zzhbo) zzhbw.zzj(zzhboVarZzw, zzhbeVar, zzhcgVar), new zzbou(zzckuVar), zzhcgVar);
            }
        };
    }

    public static void zzc(Map map, zzdky zzdkyVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzmg)).booleanValue() && map.containsKey("sc") && ((String) map.get("sc")).equals(AppEventsConstants.EVENT_PARAM_VALUE_YES) && zzdkyVar != null) {
            zzdkyVar.zzdu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ void zze(com.google.android.gms.internal.ads.zzcmg r16, java.util.Map r17) {
        /*
            Method dump skipped, instruction units count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbpp.zze(com.google.android.gms.internal.ads.zzcmg, java.util.Map):void");
    }
}
