package com.google.android.gms.tagmanager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.gtm.zzgb;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbd implements zzaw {
    private static final String zza = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", "datalayer", "ID", "key", "value", "expires");
    private final Executor zzb;
    private final Context zzc;
    private final zzbb zzd;
    private final Clock zze;

    public zzbd(Context context) {
        Clock clockC = DefaultClock.c();
        ExecutorService executorServiceZza = zzgb.zza().zza(2);
        this.zzc = context;
        this.zze = clockC;
        this.zzb = executorServiceZza;
        this.zzd = new zzbb(this, context, "google_tagmanager.db");
    }

    static /* bridge */ /* synthetic */ List zzf(zzbd zzbdVar) {
        ObjectInputStream objectInputStream;
        try {
            zzbdVar.zzk(zzbdVar.zze.currentTimeMillis());
            SQLiteDatabase sQLiteDatabaseZzi = zzbdVar.zzi("Error opening database for loadSerialized.");
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            if (sQLiteDatabaseZzi != null) {
                Cursor cursorQuery = sQLiteDatabaseZzi.query("datalayer", new String[]{"key", "value"}, null, null, null, null, "ID", null);
                while (cursorQuery.moveToNext()) {
                    try {
                        arrayList.add(new zzbc(cursorQuery.getString(0), cursorQuery.getBlob(1)));
                    } finally {
                        cursorQuery.close();
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                zzbc zzbcVar = (zzbc) obj;
                String str = zzbcVar.zza;
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(zzbcVar.zzb);
                ObjectInputStream objectInputStream2 = null;
                object = null;
                object = null;
                object = null;
                Object object = null;
                try {
                    objectInputStream = new ObjectInputStream(byteArrayInputStream);
                    try {
                        object = objectInputStream.readObject();
                    } catch (IOException unused) {
                        if (objectInputStream != null) {
                        }
                        byteArrayInputStream.close();
                        arrayList2.add(new zzat(str, object));
                    } catch (ClassNotFoundException unused2) {
                        if (objectInputStream != null) {
                        }
                        byteArrayInputStream.close();
                        arrayList2.add(new zzat(str, object));
                    } catch (Throwable th) {
                        th = th;
                        objectInputStream2 = objectInputStream;
                        if (objectInputStream2 != null) {
                            try {
                                objectInputStream2.close();
                            } catch (IOException unused3) {
                                throw th;
                            }
                        }
                        byteArrayInputStream.close();
                        throw th;
                    }
                } catch (IOException unused4) {
                    objectInputStream = null;
                } catch (ClassNotFoundException unused5) {
                    objectInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                }
                try {
                    objectInputStream.close();
                    byteArrayInputStream.close();
                } catch (IOException unused6) {
                }
                arrayList2.add(new zzat(str, object));
            }
            return arrayList2;
        } finally {
            zzbdVar.zzj();
        }
    }

    static /* synthetic */ void zzg(zzbd zzbdVar, String str) {
        SQLiteDatabase sQLiteDatabaseZzi = zzbdVar.zzi("Error opening database for clearKeysWithPrefix.");
        if (sQLiteDatabaseZzi == null) {
            return;
        }
        try {
            zzdg.zzb.zzd("Cleared " + sQLiteDatabaseZzi.delete("datalayer", "key = ? OR key LIKE ?", new String[]{str, str + ".%"}) + " items");
        } catch (SQLiteException e3) {
            Log.w("GoogleTagManager", "Error deleting entries with key prefix: " + str + " (" + e3.toString() + ").");
        } finally {
            zzbdVar.zzj();
        }
    }

    private final SQLiteDatabase zzi(String str) {
        try {
            return this.zzd.getWritableDatabase();
        } catch (SQLiteException unused) {
            Log.w("GoogleTagManager", str);
            return null;
        }
    }

    private final void zzj() {
        try {
            this.zzd.close();
        } catch (SQLiteException unused) {
        }
    }

    private final void zzk(long j3) {
        SQLiteDatabase sQLiteDatabaseZzi = zzi("Error opening database for deleteOlderThan.");
        if (sQLiteDatabaseZzi == null) {
            return;
        }
        try {
            zzdg.zzb.zzd("Deleted " + sQLiteDatabaseZzi.delete("datalayer", "expires <= ?", new String[]{Long.toString(j3)}) + " expired items");
        } catch (SQLiteException unused) {
            Log.w("GoogleTagManager", "Error deleting old entries.");
        }
    }

    @Override // com.google.android.gms.tagmanager.zzaw
    public final void zza(String str) {
        this.zzb.execute(new zzba(this, str));
    }

    @Override // com.google.android.gms.tagmanager.zzaw
    public final void zzb(zzav zzavVar) {
        this.zzb.execute(new zzaz(this, zzavVar));
    }

    @Override // com.google.android.gms.tagmanager.zzaw
    public final void zzc(List list, long j3) throws Throwable {
        ObjectOutputStream objectOutputStream;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzat zzatVar = (zzat) it.next();
            String str = zzatVar.zza;
            Object obj = zzatVar.zzb;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream2 = null;
            byteArray = null;
            byte[] byteArray = null;
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream.writeObject(obj);
                    byteArray = byteArrayOutputStream.toByteArray();
                } catch (IOException unused) {
                    if (objectOutputStream != null) {
                    }
                    byteArrayOutputStream.close();
                    arrayList.add(new zzbc(str, byteArray));
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream2 = objectOutputStream;
                    if (objectOutputStream2 != null) {
                        try {
                            objectOutputStream2.close();
                        } catch (IOException unused2) {
                            throw th;
                        }
                    }
                    byteArrayOutputStream.close();
                    throw th;
                }
            } catch (IOException unused3) {
                objectOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                objectOutputStream.close();
                byteArrayOutputStream.close();
            } catch (IOException unused4) {
            }
            arrayList.add(new zzbc(str, byteArray));
        }
        this.zzb.execute(new zzay(this, arrayList, j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0051 A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #2 {all -> 0x0035, blocks: (B:4:0x0003, B:27:0x004c, B:29:0x0051, B:49:0x00bf, B:62:0x012c, B:63:0x012f, B:50:0x00c2, B:52:0x00eb, B:55:0x00ef, B:57:0x00f7, B:58:0x0110, B:60:0x0116, B:64:0x0130, B:67:0x013b, B:68:0x013f, B:70:0x0145, B:16:0x0031, B:78:0x0176, B:79:0x0179, B:26:0x0048), top: B:85:0x0003, outer: #0, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x012c A[Catch: all -> 0x0035, TryCatch #2 {all -> 0x0035, blocks: (B:4:0x0003, B:27:0x004c, B:29:0x0051, B:49:0x00bf, B:62:0x012c, B:63:0x012f, B:50:0x00c2, B:52:0x00eb, B:55:0x00ef, B:57:0x00f7, B:58:0x0110, B:60:0x0116, B:64:0x0130, B:67:0x013b, B:68:0x013f, B:70:0x0145, B:16:0x0031, B:78:0x0176, B:79:0x0179, B:26:0x0048), top: B:85:0x0003, outer: #0, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x013b A[Catch: all -> 0x0035, TryCatch #2 {all -> 0x0035, blocks: (B:4:0x0003, B:27:0x004c, B:29:0x0051, B:49:0x00bf, B:62:0x012c, B:63:0x012f, B:50:0x00c2, B:52:0x00eb, B:55:0x00ef, B:57:0x00f7, B:58:0x0110, B:60:0x0116, B:64:0x0130, B:67:0x013b, B:68:0x013f, B:70:0x0145, B:16:0x0031, B:78:0x0176, B:79:0x0179, B:26:0x0048), top: B:85:0x0003, outer: #0, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0176 A[Catch: all -> 0x0035, TRY_ENTER, TryCatch #2 {all -> 0x0035, blocks: (B:4:0x0003, B:27:0x004c, B:29:0x0051, B:49:0x00bf, B:62:0x012c, B:63:0x012f, B:50:0x00c2, B:52:0x00eb, B:55:0x00ef, B:57:0x00f7, B:58:0x0110, B:60:0x0116, B:64:0x0130, B:67:0x013b, B:68:0x013f, B:70:0x0145, B:16:0x0031, B:78:0x0176, B:79:0x0179, B:26:0x0048), top: B:85:0x0003, outer: #0, inners: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void zzl(java.util.List r18, long r19) {
        /*
            Method dump skipped, instruction units count: 384
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzbd.zzl(java.util.List, long):void");
    }
}
