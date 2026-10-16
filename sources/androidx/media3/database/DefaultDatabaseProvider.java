package androidx.media3.database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultDatabaseProvider implements DatabaseProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SQLiteOpenHelper f41776a;

    @Override // androidx.media3.database.DatabaseProvider
    public SQLiteDatabase getReadableDatabase() {
        return this.f41776a.getReadableDatabase();
    }

    @Override // androidx.media3.database.DatabaseProvider
    public SQLiteDatabase getWritableDatabase() {
        return this.f41776a.getWritableDatabase();
    }
}
