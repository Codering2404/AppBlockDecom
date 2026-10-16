package androidx.room;

import android.content.Context;
import android.content.Intent;
import androidx.room.RoomDatabase;
import androidx.room.util.MigrationUtil;
import androidx.sqlite.SQLiteDriver;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public class DatabaseConfiguration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f52127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f52128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SupportSQLiteOpenHelper.Factory f52129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RoomDatabase.MigrationContainer f52130d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f52131e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f52132f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RoomDatabase.JournalMode f52133g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Executor f52134h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Executor f52135i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Intent f52136j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f52137k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f52138l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Set f52139m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f52140n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final File f52141o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Callable f52142p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final RoomDatabase.PrepackagedDatabaseCallback f52143q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List f52144r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final List f52145s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f52146t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final SQLiteDriver f52147u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final CoroutineContext f52148v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f52149w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f52150x;

    public DatabaseConfiguration(Context context, String str, SupportSQLiteOpenHelper.Factory factory, RoomDatabase.MigrationContainer migrationContainer, List list, boolean z2, RoomDatabase.JournalMode journalMode, Executor queryExecutor, Executor transactionExecutor, Intent intent, boolean z3, boolean z4, Set set, String str2, File file, Callable callable, RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, List typeConverters, List autoMigrationSpecs, boolean z5, SQLiteDriver sQLiteDriver, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(migrationContainer, "migrationContainer");
        Intrinsics.checkNotNullParameter(journalMode, "journalMode");
        Intrinsics.checkNotNullParameter(queryExecutor, "queryExecutor");
        Intrinsics.checkNotNullParameter(transactionExecutor, "transactionExecutor");
        Intrinsics.checkNotNullParameter(typeConverters, "typeConverters");
        Intrinsics.checkNotNullParameter(autoMigrationSpecs, "autoMigrationSpecs");
        this.f52127a = context;
        this.f52128b = str;
        this.f52129c = factory;
        this.f52130d = migrationContainer;
        this.f52131e = list;
        this.f52132f = z2;
        this.f52133g = journalMode;
        this.f52134h = queryExecutor;
        this.f52135i = transactionExecutor;
        this.f52136j = intent;
        this.f52137k = z3;
        this.f52138l = z4;
        this.f52139m = set;
        this.f52140n = str2;
        this.f52141o = file;
        this.f52142p = callable;
        this.f52143q = prepackagedDatabaseCallback;
        this.f52144r = typeConverters;
        this.f52145s = autoMigrationSpecs;
        this.f52146t = z5;
        this.f52147u = sQLiteDriver;
        this.f52148v = coroutineContext;
        this.f52149w = intent != null;
        this.f52150x = true;
    }

    public static /* synthetic */ DatabaseConfiguration b(DatabaseConfiguration databaseConfiguration, Context context, String str, SupportSQLiteOpenHelper.Factory factory, RoomDatabase.MigrationContainer migrationContainer, List list, boolean z2, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, Intent intent, boolean z3, boolean z4, Set set, String str2, File file, Callable callable, RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, List list2, List list3, boolean z5, SQLiteDriver sQLiteDriver, CoroutineContext coroutineContext, int i3, Object obj) {
        CoroutineContext coroutineContext2;
        SQLiteDriver sQLiteDriver2;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
        }
        Context context2 = (i3 & 1) != 0 ? databaseConfiguration.f52127a : context;
        String str3 = (i3 & 2) != 0 ? databaseConfiguration.f52128b : str;
        SupportSQLiteOpenHelper.Factory factory2 = (i3 & 4) != 0 ? databaseConfiguration.f52129c : factory;
        RoomDatabase.MigrationContainer migrationContainer2 = (i3 & 8) != 0 ? databaseConfiguration.f52130d : migrationContainer;
        List list4 = (i3 & 16) != 0 ? databaseConfiguration.f52131e : list;
        boolean z6 = (i3 & 32) != 0 ? databaseConfiguration.f52132f : z2;
        RoomDatabase.JournalMode journalMode2 = (i3 & 64) != 0 ? databaseConfiguration.f52133g : journalMode;
        Executor executor3 = (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? databaseConfiguration.f52134h : executor;
        Executor executor4 = (i3 & Function.MAX_NARGS) != 0 ? databaseConfiguration.f52135i : executor2;
        Intent intent2 = (i3 & 512) != 0 ? databaseConfiguration.f52136j : intent;
        boolean z7 = (i3 & 1024) != 0 ? databaseConfiguration.f52137k : z3;
        boolean z8 = (i3 & 2048) != 0 ? databaseConfiguration.f52138l : z4;
        Set set2 = (i3 & 4096) != 0 ? databaseConfiguration.f52139m : set;
        String str4 = (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? databaseConfiguration.f52140n : str2;
        Context context3 = context2;
        File file2 = (i3 & 16384) != 0 ? databaseConfiguration.f52141o : file;
        Callable callable2 = (i3 & 32768) != 0 ? databaseConfiguration.f52142p : callable;
        RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback2 = (i3 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? databaseConfiguration.f52143q : prepackagedDatabaseCallback;
        List list5 = (i3 & 131072) != 0 ? databaseConfiguration.f52144r : list2;
        List list6 = (i3 & 262144) != 0 ? databaseConfiguration.f52145s : list3;
        boolean z9 = (i3 & 524288) != 0 ? databaseConfiguration.f52146t : z5;
        SQLiteDriver sQLiteDriver3 = (i3 & 1048576) != 0 ? databaseConfiguration.f52147u : sQLiteDriver;
        if ((i3 & 2097152) != 0) {
            sQLiteDriver2 = sQLiteDriver3;
            coroutineContext2 = databaseConfiguration.f52148v;
        } else {
            coroutineContext2 = coroutineContext;
            sQLiteDriver2 = sQLiteDriver3;
        }
        return databaseConfiguration.a(context3, str3, factory2, migrationContainer2, list4, z6, journalMode2, executor3, executor4, intent2, z7, z8, set2, str4, file2, callable2, prepackagedDatabaseCallback2, list5, list6, z9, sQLiteDriver2, coroutineContext2);
    }

    public final DatabaseConfiguration a(Context context, String str, SupportSQLiteOpenHelper.Factory factory, RoomDatabase.MigrationContainer migrationContainer, List list, boolean z2, RoomDatabase.JournalMode journalMode, Executor queryExecutor, Executor transactionExecutor, Intent intent, boolean z3, boolean z4, Set set, String str2, File file, Callable callable, RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, List typeConverters, List autoMigrationSpecs, boolean z5, SQLiteDriver sQLiteDriver, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(migrationContainer, "migrationContainer");
        Intrinsics.checkNotNullParameter(journalMode, "journalMode");
        Intrinsics.checkNotNullParameter(queryExecutor, "queryExecutor");
        Intrinsics.checkNotNullParameter(transactionExecutor, "transactionExecutor");
        Intrinsics.checkNotNullParameter(typeConverters, "typeConverters");
        Intrinsics.checkNotNullParameter(autoMigrationSpecs, "autoMigrationSpecs");
        return new DatabaseConfiguration(context, str, factory, migrationContainer, list, z2, journalMode, queryExecutor, transactionExecutor, intent, z3, z4, set, str2, file, callable, prepackagedDatabaseCallback, typeConverters, autoMigrationSpecs, z5, sQLiteDriver, coroutineContext);
    }

    public final Set c() {
        return this.f52139m;
    }

    public final boolean d() {
        return this.f52150x;
    }

    public boolean e(int i3, int i4) {
        return MigrationUtil.d(this, i3, i4);
    }

    public final void f(boolean z2) {
        this.f52150x = z2;
    }
}
