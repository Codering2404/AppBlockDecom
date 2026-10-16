package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.AdError;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzdv implements zzcc {
    private static final String zza = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL,'%s' INTEGER NOT NULL);", "gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time");
    private final zzdu zzb;
    private volatile zzbj zzc;
    private final Context zzd;
    private final String zze;
    private long zzf;
    private final Clock zzg;
    private final int zzh;
    private final zzey zzi;

    zzdv(zzey zzeyVar, Context context) {
        Context applicationContext = context.getApplicationContext();
        this.zzd = applicationContext;
        this.zze = "gtm_urls.db";
        this.zzi = zzeyVar;
        this.zzg = DefaultClock.c();
        this.zzb = new zzdu(this, applicationContext, "gtm_urls.db");
        this.zzc = new zzfi(applicationContext, new zzdt(this));
        this.zzf = 0L;
        this.zzh = AdError.SERVER_ERROR_CODE;
    }

    static /* synthetic */ void zzi(zzdv zzdvVar, long j3, long j4) {
        SQLiteDatabase sQLiteDatabaseZzk = zzdvVar.zzk("Error opening database for getNumStoredHits.");
        if (sQLiteDatabaseZzk == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("hit_first_send_time", Long.valueOf(j4));
        try {
            sQLiteDatabaseZzk.update("gtm_hits", contentValues, "hit_id=?", new String[]{String.valueOf(j3)});
        } catch (SQLiteException unused) {
            Log.w("GoogleTagManager", "Error setting HIT_FIRST_DISPATCH_TIME for hitId: " + j3);
            zzdvVar.zzl(j3);
        }
    }

    private final SQLiteDatabase zzk(String str) {
        try {
            return this.zzb.getWritableDatabase();
        } catch (SQLiteException unused) {
            Log.w("GoogleTagManager", str);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzl(long j3) {
        zzj(new String[]{String.valueOf(j3)});
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x014a A[Catch: all -> 0x00de, TryCatch #14 {all -> 0x00de, blocks: (B:27:0x00bc, B:30:0x00c3, B:32:0x00d0, B:38:0x00fe, B:37:0x00e3, B:53:0x0125, B:55:0x014a, B:60:0x0160), top: B:124:0x00bc }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01bb  */
    /* JADX WARN: Type inference failed for: r0v40, types: [com.google.android.gms.tagmanager.zzey] */
    /* JADX WARN: Type inference failed for: r13v10, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r13v20 */
    /* JADX WARN: Type inference failed for: r13v21 */
    /* JADX WARN: Type inference failed for: r13v22 */
    /* JADX WARN: Type inference failed for: r13v8, types: [boolean] */
    /* JADX WARN: Type inference failed for: r13v9 */
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
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    @Override // com.google.android.gms.tagmanager.zzcc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 524
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzdv.zza():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v10, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [android.database.Cursor] */
    @Override // com.google.android.gms.tagmanager.zzcc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzb(long r19, java.lang.String r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzdv.zzb(long, java.lang.String):void");
    }

    final int zzc() {
        SQLiteDatabase sQLiteDatabaseZzk = zzk("Error opening database for getNumStoredHits.");
        if (sQLiteDatabaseZzk == null) {
            return 0;
        }
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = sQLiteDatabaseZzk.rawQuery("SELECT COUNT(*) from gtm_hits", null);
                int i3 = cursorRawQuery.moveToFirst() ? (int) cursorRawQuery.getLong(0) : 0;
                cursorRawQuery.close();
                return i3;
            } catch (SQLiteException unused) {
                Log.w("GoogleTagManager", "Error getting numStoredHits");
                if (cursorRawQuery == null) {
                    return 0;
                }
                cursorRawQuery.close();
                return 0;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    final void zzj(String[] strArr) {
        int length;
        SQLiteDatabase sQLiteDatabaseZzk;
        if (strArr == null || (length = strArr.length) == 0 || (sQLiteDatabaseZzk = zzk("Error opening database for deleteHits.")) == null) {
            return;
        }
        try {
            sQLiteDatabaseZzk.delete("gtm_hits", String.format("HIT_ID in (%s)", TextUtils.join(",", Collections.nCopies(length, "?"))), strArr);
            this.zzi.zza(zzc() == 0);
        } catch (SQLiteException unused) {
            Log.w("GoogleTagManager", "Error deleting hits");
        }
    }
}
