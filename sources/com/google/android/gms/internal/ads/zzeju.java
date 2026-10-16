package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.ads.zzbhv;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeju {
    private final zzbhp zza;
    private final Context zzb;
    private final zzeiz zzc;
    private final VersionInfoParcel zzd;

    public zzeju(Context context, VersionInfoParcel versionInfoParcel, zzbhp zzbhpVar, zzeiz zzeizVar) {
        this.zzb = context;
        this.zzd = versionInfoParcel;
        this.zza = zzbhpVar;
        this.zzc = zzeizVar;
    }

    public final void zza(final boolean z2) {
        try {
            this.zzc.zza(new zzfok() { // from class: com.google.android.gms.internal.ads.zzejt
                @Override // com.google.android.gms.internal.ads.zzfok
                public final /* synthetic */ Object zza(Object obj) {
                    this.zza.zzb(z2, (SQLiteDatabase) obj);
                    return null;
                }
            });
        } catch (Exception e3) {
            String strValueOf = String.valueOf(e3.getMessage());
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.c("Error in offline signals database startup: ".concat(strValueOf));
        }
    }

    final /* synthetic */ Void zzb(boolean z2, SQLiteDatabase sQLiteDatabase) {
        if (z2) {
            this.zzb.deleteDatabase("OfflineUpload.db");
        } else {
            ArrayList arrayList = new ArrayList();
            Cursor cursorQuery = sQLiteDatabase.query("offline_signal_contents", new String[]{"serialized_proto_data"}, null, null, null, null, null);
            while (cursorQuery.moveToNext()) {
                try {
                    arrayList.add(zzbhv.zzaf.zza.zzk(cursorQuery.getBlob(cursorQuery.getColumnIndexOrThrow("serialized_proto_data"))));
                } catch (zziet e3) {
                    int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                    com.google.android.gms.ads.internal.util.client.zzo.c("Unable to deserialize proto from offline signals database:");
                    com.google.android.gms.ads.internal.util.client.zzo.c(e3.getMessage());
                }
            }
            cursorQuery.close();
            Context context = this.zzb;
            zzbhv.zzaf.zzc zzcVarZzB = zzbhv.zzaf.zzB();
            zzcVarZzB.zzB(context.getPackageName());
            zzcVarZzB.zzH(Build.MODEL);
            zzcVarZzB.zzo(zzejo.zzc(sQLiteDatabase, 0));
            zzcVarZzB.zzj(arrayList);
            zzcVarZzB.zzs(zzejo.zzc(sQLiteDatabase, 1));
            zzcVarZzB.zzQ(zzejo.zzc(sQLiteDatabase, 3));
            zzcVarZzB.zzw(com.google.android.gms.ads.internal.zzt.o().currentTimeMillis());
            zzcVarZzB.zzM(zzejo.zzd(sQLiteDatabase, 2));
            final zzbhv.zzaf zzafVarZzbu = zzcVarZzB.zzbu();
            int size = arrayList.size();
            long jZzb = 0;
            for (int i4 = 0; i4 < size; i4++) {
                zzbhv.zzaf.zza zzaVar = (zzbhv.zzaf.zza) arrayList.get(i4);
                if (zzaVar.zzf() == zzbhv.zzq.ENUM_TRUE && zzaVar.zzb() > jZzb) {
                    jZzb = zzaVar.zzb();
                }
            }
            if (jZzb != 0) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("value", Long.valueOf(jZzb));
                sQLiteDatabase.update("offline_signal_statistics", contentValues, "statistic_name = 'last_successful_request_time'", null);
            }
            zzbhp zzbhpVar = this.zza;
            zzbhpVar.zzb(new zzbho() { // from class: com.google.android.gms.internal.ads.zzejr
                @Override // com.google.android.gms.internal.ads.zzbho
                public final /* synthetic */ void zza(zzbhv.zzt.zza zzaVar2) {
                    zzaVar2.zzaf(zzafVarZzbu);
                }
            });
            VersionInfoParcel versionInfoParcel = this.zzd;
            zzbhv.zzar.zza zzaVarZzs = zzbhv.zzar.zzs();
            zzaVarZzs.zzc(versionInfoParcel.f70150b);
            zzaVarZzs.zzg(versionInfoParcel.f70151c);
            zzaVarZzs.zzk(true == versionInfoParcel.f70152d ? 0 : 2);
            final zzbhv.zzar zzarVarZzbu = zzaVarZzs.zzbu();
            zzbhpVar.zzb(new zzbho() { // from class: com.google.android.gms.internal.ads.zzejs
                @Override // com.google.android.gms.internal.ads.zzbho
                public final /* synthetic */ void zza(zzbhv.zzt.zza zzaVar2) {
                    zzbhv.zzm.zza zzaVarZzcc = zzaVar2.zzG().zzcc();
                    zzaVarZzcc.zzs(zzarVarZzbu);
                    zzaVar2.zzI(zzaVarZzcc);
                }
            });
            zzbhpVar.zzc(10004);
            zzejo.zzb(sQLiteDatabase);
        }
        return null;
    }
}
