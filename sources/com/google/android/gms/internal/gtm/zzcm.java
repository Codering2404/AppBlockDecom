package com.google.android.gms.internal.gtm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import d.qFm.sECyKyO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcm extends zzbu {
    private boolean zza;
    private final zzcg zzb;
    private final zzfg zzc;
    private final zzfe zzd;
    private final zzce zze;
    private long zzf;
    private final zzcy zzg;
    private final zzcy zzh;
    private final zzfq zzi;
    private long zzj;
    private boolean zzk;

    protected zzcm(zzbx zzbxVar, zzby zzbyVar) {
        super(zzbxVar);
        Preconditions.m(zzbyVar);
        this.zzf = Long.MIN_VALUE;
        this.zzd = new zzfe(zzbxVar);
        this.zzb = new zzcg(zzbxVar);
        this.zzc = new zzfg(zzbxVar);
        this.zze = new zzce(zzbxVar);
        this.zzi = new zzfq(zzC());
        this.zzg = new zzci(this, zzbxVar);
        this.zzh = new zzcj(this, zzbxVar);
    }

    private final void zzaf() {
        zzda zzdaVarZzy = zzy();
        if (zzdaVarZzy.zze()) {
            zzdaVarZzy.zza();
        }
    }

    private final void zzag() {
        if (this.zzg.zzh()) {
            zzN("All hits dispatched or no network/service. Going to power save mode");
        }
        this.zzg.zzf();
    }

    private final void zzah() {
        long jZzc;
        zzda zzdaVarZzy = zzy();
        if (zzdaVarZzy.zzc() && !zzdaVarZzy.zze()) {
            com.google.android.gms.analytics.zzr.h();
            zzV();
            try {
                jZzc = this.zzb.zzc();
            } catch (SQLiteException e3) {
                zzJ("Failed to get min/max hit times from local store", e3);
                jZzc = 0;
            }
            if (jZzc != 0) {
                long jAbs = Math.abs(zzC().currentTimeMillis() - jZzc);
                zzw();
                if (jAbs <= ((Long) zzew.zzn.zzb()).longValue()) {
                    zzw();
                    zzO("Dispatch alarm scheduled (ms)", Long.valueOf(zzcv.zzd()));
                    zzdaVarZzy.zzb();
                }
            }
        }
    }

    private final void zzai(zzbz zzbzVar, zzay zzayVar) {
        Preconditions.m(zzbzVar);
        Preconditions.m(zzayVar);
        com.google.android.gms.analytics.zza zzaVar = new com.google.android.gms.analytics.zza(zzt());
        zzaVar.f(zzbzVar.zzc());
        zzaVar.g(zzbzVar.zzf());
        com.google.android.gms.analytics.zzh zzhVarD = zzaVar.d();
        zzbg zzbgVar = (zzbg) zzhVarD.b(zzbg.class);
        zzbgVar.zzk("data");
        zzbgVar.zzl(true);
        zzhVarD.g(zzayVar);
        zzbb zzbbVar = (zzbb) zzhVarD.b(zzbb.class);
        zzax zzaxVar = (zzax) zzhVarD.b(zzax.class);
        for (Map.Entry entry : zzbzVar.zzd().entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if ("an".equals(str)) {
                zzaxVar.zzk(str2);
            } else if ("av".equals(str)) {
                zzaxVar.zzl(str2);
            } else if ("aid".equals(str)) {
                zzaxVar.zzi(str2);
            } else if ("aiid".equals(str)) {
                zzaxVar.zzj(str2);
            } else if ("uid".equals(str)) {
                zzbgVar.zzm(str2);
            } else {
                zzbbVar.zze(str, str2);
            }
        }
        zzG("Sending installation campaign to", zzbzVar.zzc(), zzayVar);
        zzhVarD.j(zzA().zza());
        zzhVarD.k();
    }

    private final boolean zzaj(String str) {
        return Wrappers.a(zzo()).a(str) == 0;
    }

    static /* bridge */ /* synthetic */ void zzc(zzcm zzcmVar) {
        try {
            zzcmVar.zzb.zza();
            zzcmVar.zzad();
        } catch (SQLiteException e3) {
            zzcmVar.zzR("Failed to delete stale hits", e3);
        }
        zzcy zzcyVar = zzcmVar.zzh;
        zzcmVar.zzw();
        zzcyVar.zzg(86400000L);
    }

    public final void zzY(long j3) {
        com.google.android.gms.analytics.zzr.h();
        zzV();
        if (j3 < 0) {
            j3 = 0;
        }
        this.zzf = j3;
        zzad();
    }

    final void zzZ() {
        zzV();
        Preconditions.r(!this.zza, "Analytics backend already started");
        this.zza = true;
        zzq().i(new zzck(this));
    }

    public final long zza() {
        long j3 = this.zzf;
        if (j3 != Long.MIN_VALUE) {
            return j3;
        }
        zzw();
        long jLongValue = ((Long) zzew.zzi.zzb()).longValue();
        zzfv zzfvVarZzB = zzB();
        zzfvVarZzB.zzV();
        if (!zzfvVarZzB.zzc) {
            return jLongValue;
        }
        zzfv zzfvVarZzB2 = zzB();
        zzfvVarZzB2.zzV();
        return ((long) zzfvVarZzB2.zzd) * 1000;
    }

    public final void zzab() {
        com.google.android.gms.analytics.zzr.h();
        zzV();
        zzE("Sync dispatching local hits");
        long j3 = this.zzj;
        zzw();
        zzi();
        try {
            zzae();
            zzA().zzi();
            zzad();
            if (this.zzj != j3) {
                this.zzd.zzb();
            }
        } catch (Exception e3) {
            zzJ("Sync local dispatch failed", e3);
            zzad();
        }
    }

    public final void zzac() {
        zzV();
        com.google.android.gms.analytics.zzr.h();
        this.zzk = true;
        this.zze.zzc();
        zzad();
    }

    public final void zzad() {
        long jMin;
        com.google.android.gms.analytics.zzr.h();
        zzV();
        if (!this.zzk) {
            zzw();
            if (zza() > 0) {
                if (this.zzb.zzab()) {
                    this.zzd.zzc();
                    zzag();
                    zzaf();
                    return;
                }
                if (!((Boolean) zzew.zzJ.zzb()).booleanValue()) {
                    this.zzd.zza();
                    if (!this.zzd.zzd()) {
                        zzag();
                        zzaf();
                        zzah();
                        return;
                    }
                }
                zzah();
                long jZza = zza();
                long jZzb = zzA().zzb();
                if (jZzb != 0) {
                    jMin = jZza - Math.abs(zzC().currentTimeMillis() - jZzb);
                    if (jMin <= 0) {
                        zzw();
                        jMin = Math.min(zzcv.zze(), jZza);
                    }
                } else {
                    zzw();
                    jMin = Math.min(zzcv.zze(), jZza);
                }
                zzO("Dispatch scheduled (ms)", Long.valueOf(jMin));
                if (!this.zzg.zzh()) {
                    this.zzg.zzg(jMin);
                    return;
                } else {
                    this.zzg.zze(Math.max(1L, jMin + this.zzg.zzb()));
                    return;
                }
            }
        }
        this.zzd.zzc();
        zzag();
        zzaf();
    }

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
    protected final boolean zzae() {
        boolean z2;
        com.google.android.gms.analytics.zzr.h();
        zzV();
        zzN("Dispatching a batch of local hits");
        if (this.zze.zzg()) {
            z2 = false;
        } else {
            zzw();
            z2 = true;
        }
        boolean zZze = this.zzc.zze();
        if (z2 && !zZze) {
            zzN("No network or service available. Will retry later");
            return false;
        }
        zzw();
        int iZzh = zzcv.zzh();
        zzw();
        long jMax = Math.max(iZzh, zzcv.zzg());
        ArrayList arrayList = new ArrayList();
        long jMax2 = 0;
        while (true) {
            try {
                try {
                    this.zzb.zzm();
                    arrayList.clear();
                    try {
                        List listZzj = this.zzb.zzj(jMax);
                        if (listZzj.isEmpty()) {
                            zzN("Store is empty, nothing to dispatch");
                            zzag();
                            zzaf();
                            try {
                                this.zzb.zzaa();
                                this.zzb.zzZ();
                                return false;
                            } catch (SQLiteException e3) {
                                zzJ("Failed to commit local dispatch transaction", e3);
                                zzag();
                                zzaf();
                                return false;
                            }
                        }
                        zzO("Hits loaded from store. count", Integer.valueOf(listZzj.size()));
                        Iterator it = listZzj.iterator();
                        while (it.hasNext()) {
                            if (((zzez) it.next()).zzb() == jMax2) {
                                zzK("Database contains successfully uploaded hit", Long.valueOf(jMax2), Integer.valueOf(listZzj.size()));
                                zzag();
                                zzaf();
                                try {
                                    this.zzb.zzaa();
                                    this.zzb.zzZ();
                                    return false;
                                } catch (SQLiteException e4) {
                                    zzJ("Failed to commit local dispatch transaction", e4);
                                    zzag();
                                    zzaf();
                                    return false;
                                }
                            }
                        }
                        if (this.zze.zzg()) {
                            zzw();
                            zzN("Service connected, sending hits to the service");
                            while (!listZzj.isEmpty()) {
                                zzez zzezVar = (zzez) listZzj.get(0);
                                if (!this.zze.zzh(zzezVar)) {
                                    break;
                                }
                                jMax2 = Math.max(jMax2, zzezVar.zzb());
                                listZzj.remove(zzezVar);
                                zzF("Hit sent do device AnalyticsService for delivery", zzezVar);
                                try {
                                    this.zzb.zzn(zzezVar.zzb());
                                    arrayList.add(Long.valueOf(zzezVar.zzb()));
                                } catch (SQLiteException e5) {
                                    zzJ("Failed to remove hit that was send for delivery", e5);
                                    zzag();
                                    zzaf();
                                    try {
                                        this.zzb.zzaa();
                                        this.zzb.zzZ();
                                        return false;
                                    } catch (SQLiteException e6) {
                                        zzJ("Failed to commit local dispatch transaction", e6);
                                        zzag();
                                        zzaf();
                                        return false;
                                    }
                                }
                            }
                        }
                        if (this.zzc.zze()) {
                            List listZzc = this.zzc.zzc(listZzj);
                            Iterator it2 = listZzc.iterator();
                            while (it2.hasNext()) {
                                jMax2 = Math.max(jMax2, ((Long) it2.next()).longValue());
                            }
                            try {
                                this.zzb.zzY(listZzc);
                                arrayList.addAll(listZzc);
                            } catch (SQLiteException e7) {
                                zzJ("Failed to remove successfully uploaded hits", e7);
                                zzag();
                                zzaf();
                                try {
                                    this.zzb.zzaa();
                                    this.zzb.zzZ();
                                    return false;
                                } catch (SQLiteException e8) {
                                    zzJ("Failed to commit local dispatch transaction", e8);
                                    zzag();
                                    zzaf();
                                    return false;
                                }
                            }
                        }
                        if (arrayList.isEmpty()) {
                            try {
                                this.zzb.zzaa();
                                this.zzb.zzZ();
                                return false;
                            } catch (SQLiteException e9) {
                                zzJ("Failed to commit local dispatch transaction", e9);
                                zzag();
                                zzaf();
                                return false;
                            }
                        }
                        try {
                            this.zzb.zzaa();
                            this.zzb.zzZ();
                        } catch (SQLiteException e10) {
                            zzJ("Failed to commit local dispatch transaction", e10);
                            zzag();
                            zzaf();
                            return false;
                        }
                    } catch (SQLiteException e11) {
                        zzR("Failed to read hits from persisted store", e11);
                        zzag();
                        zzaf();
                        try {
                            this.zzb.zzaa();
                            this.zzb.zzZ();
                            return false;
                        } catch (SQLiteException e12) {
                            zzJ("Failed to commit local dispatch transaction", e12);
                            zzag();
                            zzaf();
                            return false;
                        }
                    }
                } catch (Throwable th) {
                    this.zzb.zzaa();
                    this.zzb.zzZ();
                    throw th;
                }
                this.zzb.zzaa();
                this.zzb.zzZ();
                throw th;
            } catch (SQLiteException e13) {
                zzJ("Failed to commit local dispatch transaction", e13);
                zzag();
                zzaf();
                return false;
            }
        }
    }

    public final long zzb(zzbz zzbzVar, boolean z2) {
        Preconditions.m(zzbzVar);
        zzV();
        com.google.android.gms.analytics.zzr.h();
        try {
            try {
                this.zzb.zzm();
                zzcg zzcgVar = this.zzb;
                String strZzb = zzbzVar.zzb();
                Preconditions.g(strZzb);
                zzcgVar.zzV();
                com.google.android.gms.analytics.zzr.h();
                int iDelete = zzcgVar.zzf().delete(DiagnosticsEntry.PROPERTIES_KEY, "app_uid=? AND cid<>?", new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO, strZzb});
                if (iDelete > 0) {
                    zzcgVar.zzO("Deleted property records", Integer.valueOf(iDelete));
                }
                long jZze = this.zzb.zze(0L, zzbzVar.zzb(), zzbzVar.zzc());
                zzbzVar.zze(1 + jZze);
                zzcg zzcgVar2 = this.zzb;
                Preconditions.m(zzbzVar);
                zzcgVar2.zzV();
                com.google.android.gms.analytics.zzr.h();
                SQLiteDatabase sQLiteDatabaseZzf = zzcgVar2.zzf();
                Map mapZzd = zzbzVar.zzd();
                Preconditions.m(mapZzd);
                Uri.Builder builder = new Uri.Builder();
                for (Map.Entry entry : mapZzd.entrySet()) {
                    builder.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
                }
                String encodedQuery = builder.build().getEncodedQuery();
                if (encodedQuery == null) {
                    encodedQuery = "";
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_uid", (Long) 0L);
                contentValues.put("cid", zzbzVar.zzb());
                contentValues.put("tid", zzbzVar.zzc());
                contentValues.put("adid", Integer.valueOf(zzbzVar.zzf() ? 1 : 0));
                contentValues.put("hits_count", Long.valueOf(zzbzVar.zza()));
                contentValues.put(NativeProtocol.WEB_DIALOG_PARAMS, encodedQuery);
                try {
                    if (sQLiteDatabaseZzf.insertWithOnConflict(DiagnosticsEntry.PROPERTIES_KEY, null, contentValues, 5) == -1) {
                        zzcgVar2.zzI("Failed to insert/update a property (got -1)");
                    }
                } catch (SQLiteException e3) {
                    zzcgVar2.zzJ("Error storing a property", e3);
                }
                this.zzb.zzaa();
                try {
                    this.zzb.zzZ();
                } catch (SQLiteException e4) {
                    zzJ("Failed to end transaction", e4);
                }
                return jZze;
            } catch (SQLiteException e5) {
                zzJ("Failed to update Analytics property", e5);
                try {
                    this.zzb.zzZ();
                } catch (SQLiteException e6) {
                    zzJ("Failed to end transaction", e6);
                }
                return -1L;
            }
        } catch (Throwable th) {
            try {
                this.zzb.zzZ();
            } catch (SQLiteException e7) {
                zzJ("Failed to end transaction", e7);
            }
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbu
    protected final void zzd() {
        this.zzb.zzW();
        this.zzc.zzW();
        this.zze.zzW();
    }

    public final void zzf(zzdb zzdbVar) {
        zzg(zzdbVar, this.zzj);
    }

    public final void zzg(zzdb zzdbVar, long j3) {
        com.google.android.gms.analytics.zzr.h();
        zzV();
        long jZzb = zzA().zzb();
        zzF("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(jZzb != 0 ? Math.abs(zzC().currentTimeMillis() - jZzb) : -1L));
        zzw();
        zzi();
        try {
            zzae();
            zzA().zzi();
            zzad();
            if (zzdbVar != null) {
                zzdbVar.zza(null);
            }
            if (this.zzj != j3) {
                this.zzd.zzb();
            }
        } catch (Exception e3) {
            zzJ("Local dispatch failed", e3);
            zzA().zzi();
            zzad();
            if (zzdbVar != null) {
                zzdbVar.zza(e3);
            }
        }
    }

    public final void zzh() {
        com.google.android.gms.analytics.zzr.h();
        zzV();
        zzw();
        zzN("Delete all hits from local store");
        try {
            zzcg zzcgVar = this.zzb;
            com.google.android.gms.analytics.zzr.h();
            zzcgVar.zzV();
            zzcgVar.zzf().delete("hits2", null, null);
            zzcg zzcgVar2 = this.zzb;
            com.google.android.gms.analytics.zzr.h();
            zzcgVar2.zzV();
            zzcgVar2.zzf().delete(DiagnosticsEntry.PROPERTIES_KEY, null, null);
            zzad();
        } catch (SQLiteException e3) {
            zzR("Failed to delete hits from store", e3);
        }
        zzi();
        if (this.zze.zze()) {
            zzN("Device service unavailable. Can't clear hits stored on the device service.");
        }
    }

    protected final void zzi() {
        if (this.zzk) {
            return;
        }
        zzw();
        if (zzcv.zzl() && !this.zze.zzg()) {
            zzw();
            if (this.zzi.zzc(((Long) zzew.zzO.zzb()).longValue())) {
                this.zzi.zzb();
                zzN("Connecting to service");
                if (this.zze.zzf()) {
                    zzN("Connected to service");
                    this.zzi.zza();
                    zzm();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0185 A[Catch: SQLiteException -> 0x00cc, TryCatch #3 {SQLiteException -> 0x00cc, blocks: (B:16:0x0079, B:17:0x0098, B:19:0x009e, B:21:0x00b2, B:23:0x00ba, B:25:0x00c2, B:28:0x00cf, B:31:0x00db, B:33:0x00e4, B:76:0x01ee, B:34:0x00ef, B:36:0x010a, B:38:0x011b, B:59:0x0172, B:39:0x011e, B:57:0x016e, B:61:0x0185, B:62:0x0188, B:63:0x0189, B:65:0x01b7, B:67:0x01c6, B:75:0x01e9, B:66:0x01bf, B:68:0x01cb, B:70:0x01d7, B:73:0x01df), top: B:82:0x0079, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01b7 A[Catch: SQLiteException -> 0x00cc, TryCatch #3 {SQLiteException -> 0x00cc, blocks: (B:16:0x0079, B:17:0x0098, B:19:0x009e, B:21:0x00b2, B:23:0x00ba, B:25:0x00c2, B:28:0x00cf, B:31:0x00db, B:33:0x00e4, B:76:0x01ee, B:34:0x00ef, B:36:0x010a, B:38:0x011b, B:59:0x0172, B:39:0x011e, B:57:0x016e, B:61:0x0185, B:62:0x0188, B:63:0x0189, B:65:0x01b7, B:67:0x01c6, B:75:0x01e9, B:66:0x01bf, B:68:0x01cb, B:70:0x01d7, B:73:0x01df), top: B:82:0x0079, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01bf A[Catch: SQLiteException -> 0x00cc, TryCatch #3 {SQLiteException -> 0x00cc, blocks: (B:16:0x0079, B:17:0x0098, B:19:0x009e, B:21:0x00b2, B:23:0x00ba, B:25:0x00c2, B:28:0x00cf, B:31:0x00db, B:33:0x00e4, B:76:0x01ee, B:34:0x00ef, B:36:0x010a, B:38:0x011b, B:59:0x0172, B:39:0x011e, B:57:0x016e, B:61:0x0185, B:62:0x0188, B:63:0x0189, B:65:0x01b7, B:67:0x01c6, B:75:0x01e9, B:66:0x01bf, B:68:0x01cb, B:70:0x01d7, B:73:0x01df), top: B:82:0x0079, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01d7 A[Catch: SQLiteException -> 0x01dd, TryCatch #5 {SQLiteException -> 0x01dd, blocks: (B:68:0x01cb, B:70:0x01d7, B:73:0x01df), top: B:85:0x01cb, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01df A[Catch: SQLiteException -> 0x01dd, TRY_LEAVE, TryCatch #5 {SQLiteException -> 0x01dd, blocks: (B:68:0x01cb, B:70:0x01d7, B:73:0x01df), top: B:85:0x01cb, outer: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzj(com.google.android.gms.internal.gtm.zzez r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 513
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzcm.zzj(com.google.android.gms.internal.gtm.zzez):void");
    }

    protected final void zzk(zzbz zzbzVar) {
        com.google.android.gms.analytics.zzr.h();
        zzF("Sending first hit to property", zzbzVar.zzc());
        zzfq zzfqVarZzf = zzA().zzf();
        zzw();
        if (zzfqVarZzf.zzc(zzcv.zzc())) {
            return;
        }
        String strZzg = zzA().zzg();
        if (TextUtils.isEmpty(strZzg)) {
            return;
        }
        zzay zzayVarZzb = zzfu.zzb(zzz(), strZzg);
        zzF("Found relevant installation campaign", zzayVarZzb);
        zzai(zzbzVar, zzayVarZzb);
    }

    final void zzl() {
        com.google.android.gms.analytics.zzr.h();
        this.zzj = zzC().currentTimeMillis();
    }

    protected final void zzm() {
        com.google.android.gms.analytics.zzr.h();
        zzw();
        com.google.android.gms.analytics.zzr.h();
        zzV();
        zzw();
        zzw();
        if (!zzcv.zzl()) {
            zzQ("Service client disabled. Can't dispatch local hits to device AnalyticsService");
        }
        if (!this.zze.zzg()) {
            zzN("Service not connected");
            return;
        }
        if (this.zzb.zzab()) {
            return;
        }
        zzN("Dispatching local hits to device AnalyticsService");
        while (true) {
            try {
                zzcg zzcgVar = this.zzb;
                zzw();
                List listZzj = zzcgVar.zzj(zzcv.zzh());
                if (listZzj.isEmpty()) {
                    zzad();
                    return;
                }
                while (!listZzj.isEmpty()) {
                    zzez zzezVar = (zzez) listZzj.get(0);
                    if (!this.zze.zzh(zzezVar)) {
                        zzad();
                        return;
                    }
                    listZzj.remove(zzezVar);
                    try {
                        this.zzb.zzn(zzezVar.zzb());
                    } catch (SQLiteException e3) {
                        zzJ("Failed to remove hit that was send for delivery", e3);
                        zzag();
                        zzaf();
                        return;
                    }
                }
            } catch (SQLiteException e4) {
                zzJ("Failed to read hits from store", e4);
                zzag();
                zzaf();
                return;
            }
        }
    }

    public final void zzn(String str) {
        Preconditions.g(str);
        com.google.android.gms.analytics.zzr.h();
        zzw();
        zzay zzayVarZzb = zzfu.zzb(zzz(), str);
        if (zzayVarZzb == null) {
            zzR("Parsing failed. Ignoring invalid campaign data", str);
            return;
        }
        String strZzg = zzA().zzg();
        if (str.equals(strZzg)) {
            zzQ("Ignoring duplicate install campaign");
            return;
        }
        if (!TextUtils.isEmpty(strZzg)) {
            zzK("Ignoring multiple install campaigns. original, new", strZzg, str);
            return;
        }
        zzA().zzh(str);
        zzfq zzfqVarZzf = zzA().zzf();
        zzw();
        if (zzfqVarZzf.zzc(zzcv.zzc())) {
            zzR("Campaign received too late, ignoring", zzayVarZzb);
            return;
        }
        zzF("Received installation campaign", zzayVarZzb);
        zzcg zzcgVar = this.zzb;
        zzcgVar.zzV();
        com.google.android.gms.analytics.zzr.h();
        SQLiteDatabase sQLiteDatabaseZzf = zzcgVar.zzf();
        Cursor cursorQuery = null;
        try {
            try {
                String[] strArr = {"cid", "tid", "adid", "hits_count", NativeProtocol.WEB_DIALOG_PARAMS};
                zzcgVar.zzw();
                int iIntValue = ((Integer) zzew.zzh.zzb()).intValue();
                cursorQuery = sQLiteDatabaseZzf.query(DiagnosticsEntry.PROPERTIES_KEY, strArr, "app_uid=?", new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO}, null, null, null, String.valueOf(iIntValue));
                ArrayList arrayList = new ArrayList();
                int i3 = 0;
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(0);
                        String string2 = cursorQuery.getString(1);
                        boolean z2 = cursorQuery.getInt(2) != 0;
                        long j3 = cursorQuery.getInt(3);
                        Map mapZzl = zzcgVar.zzl(cursorQuery.getString(4));
                        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                            zzcgVar.zzS("Read property with empty client id or tracker id", string, string2);
                        } else {
                            arrayList.add(new zzbz(0L, string, string2, z2, j3, mapZzl));
                        }
                    } while (cursorQuery.moveToNext());
                }
                if (arrayList.size() >= iIntValue) {
                    zzcgVar.zzQ("Sending hits to too many properties. Campaign report might be incorrect");
                }
                cursorQuery.close();
                int size = arrayList.size();
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    zzai((zzbz) obj, zzayVarZzb);
                }
            } catch (SQLiteException e3) {
                zzcgVar.zzJ("Error loading hits from the database", e3);
                throw e3;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    protected final void zzaa() {
        zzV();
        zzw();
        com.google.android.gms.analytics.zzr.h();
        Context contextZza = zzt().zza();
        if (!zzfk.zzb(contextZza)) {
            zzQ("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!zzfp.zzh(contextZza)) {
            zzI("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!CampaignTrackingReceiver.zzb(contextZza)) {
            zzQ("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
        zzA().zza();
        if (!zzaj("android.permission.ACCESS_NETWORK_STATE")) {
            zzI("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            zzac();
        }
        if (!zzaj(sECyKyO.BvFdS)) {
            zzI("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            zzac();
        }
        if (zzfp.zzh(zzo())) {
            zzN("AnalyticsService registered in the app manifest and enabled");
        } else {
            zzw();
            zzQ("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!this.zzk) {
            zzw();
            if (!this.zzb.zzab()) {
                zzi();
            }
        }
        zzad();
    }
}
