package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.facebook.share.HKJ.pnxuebdT;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class SchemaManager extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f69570c = "INSERT INTO global_log_event_state VALUES (" + System.currentTimeMillis() + ")";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static int f69571d = 7;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Migration f69572f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Migration f69573g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Migration f69574h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Migration f69575i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Migration f69576j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Migration f69577k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Migration f69578l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final List f69579m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f69580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f69581b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Migration {
        void a(SQLiteDatabase sQLiteDatabase);
    }

    static {
        Migration migration = new Migration() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.b0
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager.Migration
            public final void a(SQLiteDatabase sQLiteDatabase) {
                SchemaManager.a(sQLiteDatabase);
            }
        };
        f69572f = migration;
        Migration migration2 = new Migration() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.c0
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager.Migration
            public final void a(SQLiteDatabase sQLiteDatabase) {
                SchemaManager.j(sQLiteDatabase);
            }
        };
        f69573g = migration2;
        Migration migration3 = new Migration() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.d0
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager.Migration
            public final void a(SQLiteDatabase sQLiteDatabase) {
                sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
            }
        };
        f69574h = migration3;
        Migration migration4 = new Migration() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.e0
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager.Migration
            public final void a(SQLiteDatabase sQLiteDatabase) {
                SchemaManager.k(sQLiteDatabase);
            }
        };
        f69575i = migration4;
        Migration migration5 = new Migration() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.f0
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager.Migration
            public final void a(SQLiteDatabase sQLiteDatabase) {
                SchemaManager.f(sQLiteDatabase);
            }
        };
        f69576j = migration5;
        Migration migration6 = new Migration() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.g0
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager.Migration
            public final void a(SQLiteDatabase sQLiteDatabase) {
                sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN product_id INTEGER");
            }
        };
        f69577k = migration6;
        Migration migration7 = new Migration() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.h0
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager.Migration
            public final void a(SQLiteDatabase sQLiteDatabase) {
                SchemaManager.b(sQLiteDatabase);
            }
        };
        f69578l = migration7;
        f69579m = Arrays.asList(migration, migration2, migration3, migration4, migration5, migration6, migration7);
    }

    SchemaManager(Context context, String str, int i3) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i3);
        this.f69581b = false;
        this.f69580a = i3;
    }

    public static /* synthetic */ void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)");
        sQLiteDatabase.execSQL("CREATE INDEX events_backend_id on events(context_id)");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)");
    }

    public static /* synthetic */ void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN pseudonymous_id TEXT");
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN experiment_ids_clear_blob BLOB");
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN experiment_ids_encrypted_blob BLOB");
    }

    public static /* synthetic */ void f(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        sQLiteDatabase.execSQL("CREATE TABLE log_event_dropped (log_source VARCHAR(45) NOT NULL,reason INTEGER NOT NULL,events_dropped_count BIGINT NOT NULL,PRIMARY KEY(log_source, reason))");
        sQLiteDatabase.execSQL("CREATE TABLE global_log_event_state (last_metrics_upload_ms BIGINT PRIMARY KEY)");
        sQLiteDatabase.execSQL(f69570c);
    }

    public static /* synthetic */ void j(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
        sQLiteDatabase.execSQL("DROP INDEX contexts_backend_priority");
    }

    public static /* synthetic */ void k(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN inline BOOLEAN NOT NULL DEFAULT 1");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("CREATE TABLE event_payloads (sequence_num INTEGER NOT NULL, event_id INTEGER NOT NULL, bytes BLOB NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE,PRIMARY KEY (sequence_num, event_id))");
    }

    private void l(SQLiteDatabase sQLiteDatabase) {
        if (this.f69581b) {
            return;
        }
        onConfigure(sQLiteDatabase);
    }

    private void m(SQLiteDatabase sQLiteDatabase, int i3) {
        l(sQLiteDatabase);
        n(sQLiteDatabase, 0, i3);
    }

    private void n(SQLiteDatabase sQLiteDatabase, int i3, int i4) {
        List list = f69579m;
        if (i4 <= list.size()) {
            while (i3 < i4) {
                ((Migration) f69579m.get(i3)).a(sQLiteDatabase);
                i3++;
            }
            return;
        }
        throw new IllegalArgumentException("Migration from " + i3 + " to " + i4 + " was requested, but cannot be performed. Only " + list.size() + " migrations are provided");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.f69581b = true;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        m(sQLiteDatabase, this.f69580a);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        l(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i4) {
        l(sQLiteDatabase);
        n(sQLiteDatabase, i3, i4);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i4) {
        sQLiteDatabase.execSQL("DROP TABLE events");
        sQLiteDatabase.execSQL("DROP TABLE event_metadata");
        sQLiteDatabase.execSQL("DROP TABLE transport_contexts");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL(pnxuebdT.XhXbYeHUccLws);
        m(sQLiteDatabase, i4);
    }
}
