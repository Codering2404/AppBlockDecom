package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import com.facebook.GraphRequest;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgj extends com.google.android.gms.internal.measurement.zzby {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzgl f73699a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgj(zzgl zzglVar, Context context, String str) {
        super(context, "google_app_measurement_local.db", null, 1);
        Objects.requireNonNull(zzglVar);
        this.f73699a = zzglVar;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getWritableDatabase() {
        try {
            return super.getWritableDatabase();
        } catch (SQLiteDatabaseLockedException e3) {
            throw e3;
        } catch (SQLiteException unused) {
            zzic zzicVar = this.f73699a.f73997a;
            zzicVar.a().o().a("Opening the local database failed, dropping and recreating it");
            zzicVar.w();
            if (!zzicVar.d().getDatabasePath("google_app_measurement_local.db").delete()) {
                zzicVar.a().o().b("Failed to delete corrupted local db file", "google_app_measurement_local.db");
            }
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException e4) {
                this.f73699a.f73997a.a().o().b("Failed to open local database. Events will bypass local storage", e4);
                return null;
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        zzaw.b(this.f73699a.f73997a.a(), sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) throws Throwable {
        zzaw.a(this.f73699a.f73997a.a(), sQLiteDatabase, GraphRequest.DEBUG_MESSAGES_KEY, "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)", "type,entry", zzgl.f73703e);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i4) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i4) {
    }
}
