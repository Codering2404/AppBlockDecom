package androidx.room;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.room.concurrent.CloseBarrier;
import androidx.room.coroutines.RunBlockingUninterruptible_androidKt;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.support.AutoCloser;
import androidx.room.support.AutoClosingRoomOpenHelper;
import androidx.room.support.AutoClosingRoomOpenHelperFactory;
import androidx.room.support.PrePackagedCopyOpenHelper;
import androidx.room.support.PrePackagedCopyOpenHelperFactory;
import androidx.room.support.QueryInterceptorOpenHelperFactory;
import androidx.room.util.DBUtil;
import androidx.room.util.KClassUtil;
import androidx.room.util.MigrationUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import androidx.sqlite.driver.SupportSQLiteConnection;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public abstract class RoomDatabase {
    public static final Companion Companion = new Companion(null);
    public static final int MAX_BIND_PARAMETER_CNT = 999;
    private boolean allowMainThreadQueries;
    private AutoCloser autoCloser;
    private DatabaseConfiguration configuration;
    private RoomConnectionManager connectionManager;
    private CoroutineScope coroutineScope;
    private Executor internalQueryExecutor;
    private InvalidationTracker internalTracker;
    private Executor internalTransactionExecutor;
    protected List<? extends Callback> mCallbacks;
    protected volatile SupportSQLiteDatabase mDatabase;
    private CoroutineContext transactionContext;
    private final CloseBarrier closeBarrier = new CloseBarrier(new RoomDatabase$closeBarrier$1(this));
    private final ThreadLocal<CoroutineContext> suspendingTransactionContext = new ThreadLocal<>();
    private final Map<KClass<?>, Object> typeConverters = new LinkedHashMap();
    private boolean useTempTrackingTable = true;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static class Builder<T extends RoomDatabase> {
        private File A;
        private Callable B;
        private SQLiteDriver C;
        private CoroutineContext D;
        private boolean E;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final KClass f52260a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Context f52261b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f52262c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Function0 f52263d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final List f52264e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private PrepackagedDatabaseCallback f52265f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private QueryCallback f52266g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Executor f52267h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private CoroutineContext f52268i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final List f52269j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private Executor f52270k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private Executor f52271l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private SupportSQLiteOpenHelper.Factory f52272m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private boolean f52273n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private JournalMode f52274o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private Intent f52275p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private long f52276q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private TimeUnit f52277r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final MigrationContainer f52278s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private Set f52279t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private final Set f52280u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private final List f52281v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private boolean f52282w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private boolean f52283x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private boolean f52284y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private String f52285z;

        public Builder(Context context, Class klass, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(klass, "klass");
            this.f52264e = new ArrayList();
            this.f52269j = new ArrayList();
            this.f52274o = JournalMode.f52286a;
            this.f52276q = -1L;
            this.f52278s = new MigrationContainer();
            this.f52279t = new LinkedHashSet();
            this.f52280u = new LinkedHashSet();
            this.f52281v = new ArrayList();
            this.f52282w = true;
            this.E = true;
            this.f52260a = JvmClassMappingKt.c(klass);
            this.f52261b = context;
            this.f52262c = str;
            this.f52263d = null;
        }

        public Builder a(Callback callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.f52264e.add(callback);
            return this;
        }

        public Builder b(Migration... migrations) {
            Intrinsics.checkNotNullParameter(migrations, "migrations");
            for (Migration migration : migrations) {
                this.f52280u.add(Integer.valueOf(migration.f52660a));
                this.f52280u.add(Integer.valueOf(migration.f52661b));
            }
            this.f52278s.b((Migration[]) Arrays.copyOf(migrations, migrations.length));
            return this;
        }

        public Builder c() {
            this.f52273n = true;
            return this;
        }

        public RoomDatabase d() {
            SupportSQLiteOpenHelper.Factory queryInterceptorOpenHelperFactory;
            SupportSQLiteOpenHelper.Factory factory;
            RoomDatabase roomDatabase;
            CoroutineContext coroutineContextB;
            Executor executor = this.f52270k;
            if (executor == null && this.f52271l == null) {
                Executor executorG = ArchTaskExecutor.g();
                this.f52271l = executorG;
                this.f52270k = executorG;
            } else if (executor != null && this.f52271l == null) {
                this.f52271l = executor;
            } else if (executor == null) {
                this.f52270k = this.f52271l;
            }
            RoomDatabaseKt.e(this.f52280u, this.f52279t);
            SQLiteDriver sQLiteDriver = this.C;
            if (sQLiteDriver == null && this.f52272m == null) {
                queryInterceptorOpenHelperFactory = new FrameworkSQLiteOpenHelperFactory();
            } else if (sQLiteDriver == null) {
                queryInterceptorOpenHelperFactory = this.f52272m;
            } else {
                if (this.f52272m != null) {
                    throw new IllegalArgumentException("A RoomDatabase cannot be configured with both a SQLiteDriver and a SupportOpenHelper.Factory.");
                }
                queryInterceptorOpenHelperFactory = null;
            }
            boolean z2 = this.f52276q > 0;
            boolean z3 = (this.f52285z == null && this.A == null && this.B == null) ? false : true;
            boolean z4 = this.f52266g != null;
            if (queryInterceptorOpenHelperFactory != null) {
                if (z2) {
                    if (this.f52262c == null) {
                        throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.");
                    }
                    long j3 = this.f52276q;
                    TimeUnit timeUnit = this.f52277r;
                    if (timeUnit == null) {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                    queryInterceptorOpenHelperFactory = new AutoClosingRoomOpenHelperFactory(queryInterceptorOpenHelperFactory, new AutoCloser(j3, timeUnit, null, 4, null));
                }
                if (z3) {
                    if (this.f52262c == null) {
                        throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
                    }
                    String str = this.f52285z;
                    int i3 = str == null ? 0 : 1;
                    File file = this.A;
                    int i4 = file == null ? 0 : 1;
                    Callable callable = this.B;
                    if (i3 + i4 + (callable != null ? 1 : 0) != 1) {
                        throw new IllegalArgumentException("More than one of createFromAsset(), createFromInputStream(), and createFromFile() were called on this Builder, but the database can only be created using one of the three configurations.");
                    }
                    queryInterceptorOpenHelperFactory = new PrePackagedCopyOpenHelperFactory(str, file, callable, queryInterceptorOpenHelperFactory);
                }
                if (z4) {
                    Executor executor2 = this.f52267h;
                    if ((executor2 == null || (coroutineContextB = ExecutorsKt.b(executor2)) == null) && (coroutineContextB = this.f52268i) == null) {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                    CoroutineScope coroutineScopeA = CoroutineScopeKt.a(coroutineContextB);
                    QueryCallback queryCallback = this.f52266g;
                    if (queryCallback == null) {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                    queryInterceptorOpenHelperFactory = new QueryInterceptorOpenHelperFactory(queryInterceptorOpenHelperFactory, coroutineScopeA, queryCallback);
                }
                factory = queryInterceptorOpenHelperFactory;
            } else {
                factory = null;
            }
            if (factory == null) {
                if (z2) {
                    throw new IllegalArgumentException("Auto Closing Database is not supported when an SQLiteDriver is configured.");
                }
                if (z3) {
                    throw new IllegalArgumentException("Pre-Package Database is not supported when an SQLiteDriver is configured.");
                }
                if (z4) {
                    throw new IllegalArgumentException("Query Callback is not supported when an SQLiteDriver is configured.");
                }
            }
            Context context = this.f52261b;
            String str2 = this.f52262c;
            MigrationContainer migrationContainer = this.f52278s;
            List list = this.f52264e;
            boolean z5 = this.f52273n;
            JournalMode journalModeB = this.f52274o.b(context);
            Executor executor3 = this.f52270k;
            if (executor3 == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            Executor executor4 = this.f52271l;
            if (executor4 == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration(context, str2, factory, migrationContainer, list, z5, journalModeB, executor3, executor4, this.f52275p, this.f52282w, this.f52283x, this.f52279t, this.f52285z, this.A, this.B, this.f52265f, this.f52269j, this.f52281v, this.f52284y, this.C, this.D);
            databaseConfiguration.f(this.E);
            Function0 function0 = this.f52263d;
            if (function0 == null || (roomDatabase = (RoomDatabase) function0.invoke()) == null) {
                roomDatabase = (RoomDatabase) KClassUtil.b(JvmClassMappingKt.a(this.f52260a), null, 2, null);
            }
            roomDatabase.init(databaseConfiguration);
            return roomDatabase;
        }

        public Builder e() {
            this.f52275p = this.f52262c != null ? new Intent(this.f52261b, (Class<?>) MultiInstanceInvalidationService.class) : null;
            return this;
        }

        public Builder f() {
            this.f52282w = false;
            this.f52283x = true;
            return this;
        }

        public Builder g(SupportSQLiteOpenHelper.Factory factory) {
            this.f52272m = factory;
            return this;
        }

        public Builder h(Executor executor) {
            Intrinsics.checkNotNullParameter(executor, "executor");
            if (this.D != null) {
                throw new IllegalArgumentException("This builder has already been configured with a CoroutineContext. A RoomDatabasecan only be configured with either an Executor or a CoroutineContext.");
            }
            this.f52270k = executor;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class Callback {
        public void a(SQLiteConnection connection) {
            Intrinsics.checkNotNullParameter(connection, "connection");
            if (connection instanceof SupportSQLiteConnection) {
                b(((SupportSQLiteConnection) connection).a());
            }
        }

        public void b(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
        }

        public void c(SQLiteConnection connection) {
            Intrinsics.checkNotNullParameter(connection, "connection");
            if (connection instanceof SupportSQLiteConnection) {
                d(((SupportSQLiteConnection) connection).a());
            }
        }

        public void d(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
        }

        public void e(SQLiteConnection connection) {
            Intrinsics.checkNotNullParameter(connection, "connection");
            if (connection instanceof SupportSQLiteConnection) {
                f(((SupportSQLiteConnection) connection).a());
            }
        }

        public void f(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class JournalMode {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final JournalMode f52286a = new JournalMode("AUTOMATIC", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final JournalMode f52287b = new JournalMode("TRUNCATE", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final JournalMode f52288c = new JournalMode("WRITE_AHEAD_LOGGING", 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ JournalMode[] f52289d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final /* synthetic */ EnumEntries f52290f;

        static {
            JournalMode[] journalModeArrA = a();
            f52289d = journalModeArrA;
            f52290f = EnumEntriesKt.a(journalModeArrA);
        }

        private JournalMode(String str, int i3) {
        }

        private static final /* synthetic */ JournalMode[] a() {
            return new JournalMode[]{f52286a, f52287b, f52288c};
        }

        public static JournalMode valueOf(String str) {
            return (JournalMode) Enum.valueOf(JournalMode.class, str);
        }

        public static JournalMode[] values() {
            return (JournalMode[]) f52289d.clone();
        }

        public final JournalMode b(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (this != f52286a) {
                return this;
            }
            Object systemService = context.getSystemService("activity");
            ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
            return (activityManager == null || activityManager.isLowRamDevice()) ? f52287b : f52288c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static class MigrationContainer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map f52291a = new LinkedHashMap();

        public final void a(Migration migration) {
            Intrinsics.checkNotNullParameter(migration, "migration");
            int i3 = migration.f52660a;
            int i4 = migration.f52661b;
            Map map = this.f52291a;
            Integer numValueOf = Integer.valueOf(i3);
            Object treeMap = map.get(numValueOf);
            if (treeMap == null) {
                treeMap = new TreeMap();
                map.put(numValueOf, treeMap);
            }
            TreeMap treeMap2 = (TreeMap) treeMap;
            if (treeMap2.containsKey(Integer.valueOf(i4))) {
                Log.w("ROOM", "Overriding migration " + treeMap2.get(Integer.valueOf(i4)) + " with " + migration);
            }
            treeMap2.put(Integer.valueOf(i4), migration);
        }

        public void b(Migration... migrations) {
            Intrinsics.checkNotNullParameter(migrations, "migrations");
            for (Migration migration : migrations) {
                a(migration);
            }
        }

        public final boolean c(int i3, int i4) {
            return MigrationUtil.a(this, i3, i4);
        }

        public List d(int i3, int i4) {
            return MigrationUtil.b(this, i3, i4);
        }

        public Map e() {
            return this.f52291a;
        }

        public final Pair f(int i3) {
            TreeMap treeMap = (TreeMap) this.f52291a.get(Integer.valueOf(i3));
            if (treeMap == null) {
                return null;
            }
            return TuplesKt.a(treeMap, treeMap.descendingKeySet());
        }

        public final Pair g(int i3) {
            TreeMap treeMap = (TreeMap) this.f52291a.get(Integer.valueOf(i3));
            if (treeMap == null) {
                return null;
            }
            return TuplesKt.a(treeMap, treeMap.keySet());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class PrepackagedDatabaseCallback {
        public void a(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface QueryCallback {
        void a(String str, List list);
    }

    /* JADX INFO: renamed from: androidx.room.RoomDatabase$performClear$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.room.RoomDatabase$performClear$1", f = "RoomDatabase.android.kt", l = {531}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f52292a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f52294c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String[] f52295d;

        /* JADX INFO: renamed from: androidx.room.RoomDatabase$performClear$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "androidx.room.RoomDatabase$performClear$1$1", f = "RoomDatabase.android.kt", l = {532, 533, 535, 541, 542, 543}, m = "invokeSuspend")
        static final class C00841 extends SuspendLambda implements Function2<Transactor, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f52296a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f52297b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ RoomDatabase f52298c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ boolean f52299d;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ String[] f52300f;

            /* JADX INFO: renamed from: androidx.room.RoomDatabase$performClear$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "androidx.room.RoomDatabase$performClear$1$1$1", f = "RoomDatabase.android.kt", l = {537, 539}, m = "invokeSuspend")
            static final class C00851 extends SuspendLambda implements Function2<TransactionScope<Unit>, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                Object f52301a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                int f52302b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                int f52303c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                int f52304d;

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                private /* synthetic */ Object f52305f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ boolean f52306g;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                final /* synthetic */ String[] f52307h;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00851(boolean z2, String[] strArr, Continuation continuation) {
                    super(2, continuation);
                    this.f52306g = z2;
                    this.f52307h = strArr;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    C00851 c00851 = new C00851(this.f52306g, this.f52307h, continuation);
                    c00851.f52305f = obj;
                    return c00851;
                }

                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
                public final Object invoke(TransactionScope transactionScope, Continuation continuation) {
                    return ((C00851) create(transactionScope, continuation)).invokeSuspend(Unit.f139807a);
                }

                /* JADX WARN: Code restructure failed: missing block: B:13:0x0044, code lost:
                
                    if (androidx.room.TransactorKt.b(r1, "PRAGMA defer_foreign_keys = TRUE", r9) == r0) goto L19;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:18:0x0077, code lost:
                
                    if (androidx.room.TransactorKt.b(r6, r10, r9) == r0) goto L19;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:19:0x0079, code lost:
                
                    return r0;
                 */
                /* JADX WARN: Removed duplicated region for block: B:17:0x0051  */
                /* JADX WARN: Removed duplicated region for block: B:21:0x007c  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0077 -> B:20:0x007a). Please report as a decompilation issue!!! */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
                    /*
                        r9 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r1 = r9.f52304d
                        r2 = 2
                        r3 = 1
                        if (r1 == 0) goto L2e
                        if (r1 == r3) goto L26
                        if (r1 != r2) goto L1e
                        int r1 = r9.f52303c
                        int r4 = r9.f52302b
                        java.lang.Object r5 = r9.f52301a
                        java.lang.String[] r5 = (java.lang.String[]) r5
                        java.lang.Object r6 = r9.f52305f
                        androidx.room.TransactionScope r6 = (androidx.room.TransactionScope) r6
                        kotlin.ResultKt.b(r10)
                        goto L7a
                    L1e:
                        java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r10.<init>(r0)
                        throw r10
                    L26:
                        java.lang.Object r1 = r9.f52305f
                        androidx.room.TransactionScope r1 = (androidx.room.TransactionScope) r1
                        kotlin.ResultKt.b(r10)
                        goto L47
                    L2e:
                        kotlin.ResultKt.b(r10)
                        java.lang.Object r10 = r9.f52305f
                        r1 = r10
                        androidx.room.TransactionScope r1 = (androidx.room.TransactionScope) r1
                        boolean r10 = r9.f52306g
                        if (r10 == 0) goto L47
                        r9.f52305f = r1
                        r9.f52304d = r3
                        java.lang.String r10 = "PRAGMA defer_foreign_keys = TRUE"
                        java.lang.Object r10 = androidx.room.TransactorKt.b(r1, r10, r9)
                        if (r10 != r0) goto L47
                        goto L79
                    L47:
                        java.lang.String[] r10 = r9.f52307h
                        int r4 = r10.length
                        r5 = 0
                        r6 = r1
                        r1 = r4
                        r4 = r5
                        r5 = r10
                    L4f:
                        if (r4 >= r1) goto L7c
                        r10 = r5[r4]
                        java.lang.StringBuilder r7 = new java.lang.StringBuilder
                        r7.<init>()
                        java.lang.String r8 = "DELETE FROM `"
                        r7.append(r8)
                        r7.append(r10)
                        r10 = 96
                        r7.append(r10)
                        java.lang.String r10 = r7.toString()
                        r9.f52305f = r6
                        r9.f52301a = r5
                        r9.f52302b = r4
                        r9.f52303c = r1
                        r9.f52304d = r2
                        java.lang.Object r10 = androidx.room.TransactorKt.b(r6, r10, r9)
                        if (r10 != r0) goto L7a
                    L79:
                        return r0
                    L7a:
                        int r4 = r4 + r3
                        goto L4f
                    L7c:
                        kotlin.Unit r10 = kotlin.Unit.f139807a
                        return r10
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabase.AnonymousClass1.C00841.C00851.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00841(RoomDatabase roomDatabase, boolean z2, String[] strArr, Continuation continuation) {
                super(2, continuation);
                this.f52298c = roomDatabase;
                this.f52299d = z2;
                this.f52300f = strArr;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                C00841 c00841 = new C00841(this.f52298c, this.f52299d, this.f52300f, continuation);
                c00841.f52297b = obj;
                return c00841;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Transactor transactor, Continuation continuation) {
                return ((C00841) create(transactor, continuation)).invokeSuspend(Unit.f139807a);
            }

            /* JADX WARN: Code restructure failed: missing block: B:33:0x00b5, code lost:
            
                if (androidx.room.TransactorKt.b(r1, "VACUUM", r7) != r0) goto L35;
             */
            /* JADX WARN: Removed duplicated region for block: B:18:0x005f  */
            /* JADX WARN: Removed duplicated region for block: B:21:0x0071 A[PHI: r1
              0x0071: PHI (r1v7 androidx.room.Transactor) = (r1v4 androidx.room.Transactor), (r1v4 androidx.room.Transactor), (r1v9 androidx.room.Transactor) binds: [B:17:0x005d, B:19:0x006e, B:10:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
            /* JADX WARN: Removed duplicated region for block: B:24:0x0088 A[PHI: r1
              0x0088: PHI (r1v10 androidx.room.Transactor) = (r1v7 androidx.room.Transactor), (r1v12 androidx.room.Transactor) binds: [B:22:0x0085, B:9:0x0029] A[DONT_GENERATE, DONT_INLINE]] */
            /* JADX WARN: Removed duplicated region for block: B:27:0x0094 A[PHI: r1 r8
              0x0094: PHI (r1v13 androidx.room.Transactor) = (r1v10 androidx.room.Transactor), (r1v15 androidx.room.Transactor) binds: [B:25:0x0091, B:8:0x0020] A[DONT_GENERATE, DONT_INLINE]
              0x0094: PHI (r8v14 java.lang.Object) = (r8v13 java.lang.Object), (r8v0 java.lang.Object) binds: [B:25:0x0091, B:8:0x0020] A[DONT_GENERATE, DONT_INLINE]] */
            /* JADX WARN: Removed duplicated region for block: B:29:0x009c  */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
                /*
                    Method dump skipped, instruction units count: 214
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabase.AnonymousClass1.C00841.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z2, String[] strArr, Continuation continuation) {
            super(2, continuation);
            this.f52294c = z2;
            this.f52295d = strArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return RoomDatabase.this.new AnonymousClass1(this.f52294c, this.f52295d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f52292a;
            if (i3 == 0) {
                ResultKt.b(obj);
                RoomConnectionManager roomConnectionManager = RoomDatabase.this.connectionManager;
                if (roomConnectionManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("connectionManager");
                    roomConnectionManager = null;
                }
                C00841 c00841 = new C00841(RoomDatabase.this, this.f52294c, this.f52295d, null);
                this.f52292a = 1;
                if (roomConnectionManager.K(false, c00841, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SupportSQLiteOpenHelper e(RoomDatabase roomDatabase, DatabaseConfiguration config) {
        Intrinsics.checkNotNullParameter(config, "config");
        return roomDatabase.createOpenHelper(config);
    }

    private final void f() {
        assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = getOpenHelper().getWritableDatabase();
        if (!writableDatabase.E()) {
            getInvalidationTracker().J();
        }
        if (writableDatabase.u2()) {
            writableDatabase.v0();
        } else {
            writableDatabase.H();
        }
    }

    private final void g() {
        getOpenHelper().getWritableDatabase().G0();
        if (inTransaction()) {
            return;
        }
        getInvalidationTracker().C();
    }

    private final boolean h() {
        CoroutineContext coroutineContext = this.suspendingTransactionContext.get();
        return (coroutineContext != null ? (TransactionElement) coroutineContext.get(TransactionElement.f52383b) : null) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        CoroutineScope coroutineScope = this.coroutineScope;
        RoomConnectionManager roomConnectionManager = null;
        if (coroutineScope == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coroutineScope");
            coroutineScope = null;
        }
        CoroutineScopeKt.e(coroutineScope, null, 1, null);
        getInvalidationTracker().H();
        RoomConnectionManager roomConnectionManager2 = this.connectionManager;
        if (roomConnectionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("connectionManager");
        } else {
            roomConnectionManager = roomConnectionManager2;
        }
        roomConnectionManager.F();
    }

    private final Object j(final Function0 function0) {
        if (!inCompatibilityMode()) {
            return DBUtil.e(this, false, true, new Function1() { // from class: androidx.room.i
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return RoomDatabase.m(function0, (SQLiteConnection) obj);
                }
            });
        }
        beginTransaction();
        try {
            Object objInvoke = function0.invoke();
            setTransactionSuccessful();
            return objInvoke;
        } finally {
            endTransaction();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(Runnable runnable) {
        runnable.run();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object l(Callable callable) {
        return callable.call();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object m(Function0 function0, SQLiteConnection it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return function0.invoke();
    }

    public static /* synthetic */ Cursor query$default(RoomDatabase roomDatabase, SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: query");
        }
        if ((i3 & 2) != 0) {
            cancellationSignal = null;
        }
        return roomDatabase.query(supportSQLiteQuery, cancellationSignal);
    }

    public final void addTypeConverter$room_runtime(KClass<?> kclass, Object converter) {
        Intrinsics.checkNotNullParameter(kclass, "kclass");
        Intrinsics.checkNotNullParameter(converter, "converter");
        this.typeConverters.put(kclass, converter);
    }

    public void assertNotMainThread() {
        if (!this.allowMainThreadQueries && isMainThread$room_runtime()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public void assertNotSuspendingTransaction() {
        if (inCompatibilityMode() && !inTransaction() && h()) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    @Deprecated
    public void beginTransaction() {
        assertNotMainThread();
        f();
    }

    public abstract void clearAllTables();

    public void close() {
        this.closeBarrier.b();
    }

    public SupportSQLiteStatement compileStatement(String sql) {
        Intrinsics.checkNotNullParameter(sql, "sql");
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return getOpenHelper().getWritableDatabase().x1(sql);
    }

    public List<Migration> createAutoMigrations(Map<KClass<? extends AutoMigrationSpec>, ? extends AutoMigrationSpec> autoMigrationSpecs) {
        Intrinsics.checkNotNullParameter(autoMigrationSpecs, "autoMigrationSpecs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(autoMigrationSpecs.size()));
        Iterator<T> it = autoMigrationSpecs.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(JvmClassMappingKt.a((KClass) entry.getKey()), entry.getValue());
        }
        return getAutoMigrations(linkedHashMap);
    }

    public final RoomConnectionManager createConnectionManager$room_runtime(DatabaseConfiguration configuration) {
        RoomOpenDelegate roomOpenDelegate;
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        try {
            RoomOpenDelegateMarker roomOpenDelegateMarkerCreateOpenDelegate = createOpenDelegate();
            Intrinsics.checkNotNull(roomOpenDelegateMarkerCreateOpenDelegate, "null cannot be cast to non-null type androidx.room.RoomOpenDelegate");
            roomOpenDelegate = (RoomOpenDelegate) roomOpenDelegateMarkerCreateOpenDelegate;
        } catch (NotImplementedError unused) {
            roomOpenDelegate = null;
        }
        return roomOpenDelegate == null ? new RoomConnectionManager(configuration, new Function1() { // from class: androidx.room.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RoomDatabase.e(this.f52654a, (DatabaseConfiguration) obj);
            }
        }, new RoomDatabase$createConnectionManager$2(this)) : new RoomConnectionManager(configuration, roomOpenDelegate, new RoomDatabase$createConnectionManager$3(this));
    }

    protected abstract InvalidationTracker createInvalidationTracker();

    protected RoomOpenDelegateMarker createOpenDelegate() {
        throw new NotImplementedError(null, 1, null);
    }

    @Deprecated
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        Intrinsics.checkNotNullParameter(config, "config");
        throw new NotImplementedError(null, 1, null);
    }

    @Deprecated
    public void endTransaction() {
        g();
    }

    @Deprecated
    public List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
        Intrinsics.checkNotNullParameter(autoMigrationSpecs, "autoMigrationSpecs");
        return CollectionsKt.emptyList();
    }

    public final CloseBarrier getCloseBarrier$room_runtime() {
        return this.closeBarrier;
    }

    public final CoroutineScope getCoroutineScope() {
        CoroutineScope coroutineScope = this.coroutineScope;
        if (coroutineScope != null) {
            return coroutineScope;
        }
        Intrinsics.throwUninitializedPropertyAccessException("coroutineScope");
        return null;
    }

    public final SQLiteDriver getDriver() {
        DatabaseConfiguration databaseConfiguration = this.configuration;
        if (databaseConfiguration == null) {
            Intrinsics.throwUninitializedPropertyAccessException("configuration");
            databaseConfiguration = null;
        }
        SQLiteDriver sQLiteDriver = databaseConfiguration.f52147u;
        if (sQLiteDriver != null) {
            return sQLiteDriver;
        }
        throw new IllegalStateException("No SQLiteDriver was configured with Room.");
    }

    public InvalidationTracker getInvalidationTracker() {
        InvalidationTracker invalidationTracker = this.internalTracker;
        if (invalidationTracker != null) {
            return invalidationTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("internalTracker");
        return null;
    }

    public SupportSQLiteOpenHelper getOpenHelper() {
        RoomConnectionManager roomConnectionManager = this.connectionManager;
        if (roomConnectionManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("connectionManager");
            roomConnectionManager = null;
        }
        SupportSQLiteOpenHelper supportSQLiteOpenHelperG = roomConnectionManager.G();
        if (supportSQLiteOpenHelperG != null) {
            return supportSQLiteOpenHelperG;
        }
        throw new IllegalStateException("Cannot return a SupportSQLiteOpenHelper since no SupportSQLiteOpenHelper.Factory was configured with Room.");
    }

    public final String getPath() {
        DatabaseConfiguration databaseConfiguration = this.configuration;
        DatabaseConfiguration databaseConfiguration2 = null;
        if (databaseConfiguration == null) {
            Intrinsics.throwUninitializedPropertyAccessException("configuration");
            databaseConfiguration = null;
        }
        String str = databaseConfiguration.f52128b;
        if (str == null) {
            return null;
        }
        DatabaseConfiguration databaseConfiguration3 = this.configuration;
        if (databaseConfiguration3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("configuration");
        } else {
            databaseConfiguration2 = databaseConfiguration3;
        }
        return databaseConfiguration2.f52127a.getDatabasePath(str).getPath();
    }

    public final CoroutineContext getQueryContext() {
        CoroutineScope coroutineScope = this.coroutineScope;
        if (coroutineScope == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coroutineScope");
            coroutineScope = null;
        }
        return coroutineScope.getCoroutineContext();
    }

    public Executor getQueryExecutor() {
        Executor executor = this.internalQueryExecutor;
        if (executor != null) {
            return executor;
        }
        Intrinsics.throwUninitializedPropertyAccessException("internalQueryExecutor");
        return null;
    }

    public Set<KClass<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecClasses() {
        Set<Class<? extends AutoMigrationSpec>> requiredAutoMigrationSpecs = getRequiredAutoMigrationSpecs();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(requiredAutoMigrationSpecs, 10));
        Iterator<T> it = requiredAutoMigrationSpecs.iterator();
        while (it.hasNext()) {
            arrayList.add(JvmClassMappingKt.c((Class) it.next()));
        }
        return CollectionsKt.toSet(arrayList);
    }

    @Deprecated
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return SetsKt.emptySet();
    }

    protected Map<KClass<?>, List<KClass<?>>> getRequiredTypeConverterClasses() {
        Set<Map.Entry<Class<?>, List<Class<?>>>> setEntrySet = getRequiredTypeConverters().entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Class cls = (Class) entry.getKey();
            List list = (List) entry.getValue();
            KClass kClassC = JvmClassMappingKt.c(cls);
            List list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList.add(JvmClassMappingKt.c((Class) it2.next()));
            }
            Pair pairA = TuplesKt.a(kClassC, arrayList);
            linkedHashMap.put(pairA.e(), pairA.f());
        }
        return linkedHashMap;
    }

    public final Map<KClass<?>, List<KClass<?>>> getRequiredTypeConverterClassesMap$room_runtime() {
        return getRequiredTypeConverterClasses();
    }

    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        return MapsKt.emptyMap();
    }

    public final ThreadLocal<CoroutineContext> getSuspendingTransactionContext() {
        return this.suspendingTransactionContext;
    }

    public final CoroutineContext getTransactionContext$room_runtime() {
        CoroutineContext coroutineContext = this.transactionContext;
        if (coroutineContext != null) {
            return coroutineContext;
        }
        Intrinsics.throwUninitializedPropertyAccessException("transactionContext");
        return null;
    }

    public Executor getTransactionExecutor() {
        Executor executor = this.internalTransactionExecutor;
        if (executor != null) {
            return executor;
        }
        Intrinsics.throwUninitializedPropertyAccessException("internalTransactionExecutor");
        return null;
    }

    @Deprecated
    public <T> T getTypeConverter(Class<T> klass) {
        Intrinsics.checkNotNullParameter(klass, "klass");
        return (T) this.typeConverters.get(JvmClassMappingKt.c(klass));
    }

    public final boolean getUseTempTrackingTable$room_runtime() {
        return this.useTempTrackingTable;
    }

    public final boolean inCompatibilityMode() {
        RoomConnectionManager roomConnectionManager = this.connectionManager;
        if (roomConnectionManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("connectionManager");
            roomConnectionManager = null;
        }
        return roomConnectionManager.G() != null;
    }

    public boolean inTransaction() {
        return isOpenInternal$room_runtime() && getOpenHelper().getWritableDatabase().E();
    }

    public void init(DatabaseConfiguration configuration) {
        CoroutineContext coroutineContext;
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.configuration = configuration;
        this.useTempTrackingTable = configuration.d();
        this.connectionManager = createConnectionManager$room_runtime(configuration);
        this.internalTracker = createInvalidationTracker();
        RoomDatabaseKt.d(this, configuration);
        RoomDatabaseKt.f(this, configuration);
        CoroutineContext coroutineContext2 = configuration.f52148v;
        CoroutineScope coroutineScope = null;
        if (coroutineContext2 != null) {
            CoroutineContext.Element element = coroutineContext2.get(ContinuationInterceptor.t8);
            Intrinsics.checkNotNull(element, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
            CoroutineDispatcher coroutineDispatcher = (CoroutineDispatcher) element;
            Executor executorA = ExecutorsKt.a(coroutineDispatcher);
            this.internalQueryExecutor = executorA;
            if (executorA == null) {
                Intrinsics.throwUninitializedPropertyAccessException("internalQueryExecutor");
                executorA = null;
            }
            this.internalTransactionExecutor = new TransactionExecutor(executorA);
            this.coroutineScope = CoroutineScopeKt.a(configuration.f52148v.plus(SupervisorKt.a((Job) configuration.f52148v.get(Job.v8))));
            if (inCompatibilityMode()) {
                CoroutineScope coroutineScope2 = this.coroutineScope;
                if (coroutineScope2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("coroutineScope");
                    coroutineScope2 = null;
                }
                coroutineContext = coroutineScope2.getCoroutineContext().plus(coroutineDispatcher.g0(1));
            } else {
                CoroutineScope coroutineScope3 = this.coroutineScope;
                if (coroutineScope3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("coroutineScope");
                    coroutineScope3 = null;
                }
                coroutineContext = coroutineScope3.getCoroutineContext();
            }
            this.transactionContext = coroutineContext;
        } else {
            this.internalQueryExecutor = configuration.f52134h;
            this.internalTransactionExecutor = new TransactionExecutor(configuration.f52135i);
            Executor executor = this.internalQueryExecutor;
            if (executor == null) {
                Intrinsics.throwUninitializedPropertyAccessException("internalQueryExecutor");
                executor = null;
            }
            CoroutineScope coroutineScopeA = CoroutineScopeKt.a(ExecutorsKt.b(executor).plus(SupervisorKt.b(null, 1, null)));
            this.coroutineScope = coroutineScopeA;
            if (coroutineScopeA == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coroutineScope");
                coroutineScopeA = null;
            }
            CoroutineContext coroutineContext3 = coroutineScopeA.getCoroutineContext();
            Executor executor2 = this.internalTransactionExecutor;
            if (executor2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("internalTransactionExecutor");
                executor2 = null;
            }
            this.transactionContext = coroutineContext3.plus(ExecutorsKt.b(executor2));
        }
        this.allowMainThreadQueries = configuration.f52132f;
        RoomConnectionManager roomConnectionManager = this.connectionManager;
        if (roomConnectionManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("connectionManager");
            roomConnectionManager = null;
        }
        SupportSQLiteOpenHelper supportSQLiteOpenHelperG = roomConnectionManager.G();
        if (supportSQLiteOpenHelperG != null) {
            while (!(supportSQLiteOpenHelperG instanceof PrePackagedCopyOpenHelper)) {
                if (!(supportSQLiteOpenHelperG instanceof DelegatingOpenHelper)) {
                    supportSQLiteOpenHelperG = null;
                    break;
                }
                supportSQLiteOpenHelperG = ((DelegatingOpenHelper) supportSQLiteOpenHelperG).getDelegate();
            }
        } else {
            supportSQLiteOpenHelperG = null;
            break;
        }
        PrePackagedCopyOpenHelper prePackagedCopyOpenHelper = (PrePackagedCopyOpenHelper) supportSQLiteOpenHelperG;
        if (prePackagedCopyOpenHelper != null) {
            prePackagedCopyOpenHelper.f(configuration);
        }
        RoomConnectionManager roomConnectionManager2 = this.connectionManager;
        if (roomConnectionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("connectionManager");
            roomConnectionManager2 = null;
        }
        SupportSQLiteOpenHelper supportSQLiteOpenHelperG2 = roomConnectionManager2.G();
        if (supportSQLiteOpenHelperG2 != null) {
            while (!(supportSQLiteOpenHelperG2 instanceof AutoClosingRoomOpenHelper)) {
                if (!(supportSQLiteOpenHelperG2 instanceof DelegatingOpenHelper)) {
                    supportSQLiteOpenHelperG2 = null;
                    break;
                }
                supportSQLiteOpenHelperG2 = ((DelegatingOpenHelper) supportSQLiteOpenHelperG2).getDelegate();
            }
        } else {
            supportSQLiteOpenHelperG2 = null;
            break;
        }
        AutoClosingRoomOpenHelper autoClosingRoomOpenHelper = (AutoClosingRoomOpenHelper) supportSQLiteOpenHelperG2;
        if (autoClosingRoomOpenHelper != null) {
            this.autoCloser = autoClosingRoomOpenHelper.a();
            AutoCloser autoCloserA = autoClosingRoomOpenHelper.a();
            CoroutineScope coroutineScope4 = this.coroutineScope;
            if (coroutineScope4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coroutineScope");
            } else {
                coroutineScope = coroutineScope4;
            }
            autoCloserA.k(coroutineScope);
            getInvalidationTracker().G(autoClosingRoomOpenHelper.a());
        }
        if (configuration.f52136j != null) {
            if (configuration.f52128b == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            getInvalidationTracker().t(configuration.f52127a, configuration.f52128b, configuration.f52136j);
        }
    }

    @Deprecated
    protected void internalInitInvalidationTracker(SupportSQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        internalInitInvalidationTracker(new SupportSQLiteConnection(db));
    }

    public final boolean isMainThread$room_runtime() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public boolean isOpen() {
        AutoCloser autoCloser = this.autoCloser;
        if (autoCloser != null) {
            return autoCloser.m();
        }
        RoomConnectionManager roomConnectionManager = this.connectionManager;
        if (roomConnectionManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("connectionManager");
            roomConnectionManager = null;
        }
        return roomConnectionManager.J();
    }

    public final boolean isOpenInternal$room_runtime() {
        AutoCloser autoCloser = this.autoCloser;
        if (autoCloser != null) {
            SupportSQLiteDatabase supportSQLiteDatabaseI = autoCloser.i();
            if (supportSQLiteDatabaseI != null) {
                return supportSQLiteDatabaseI.isOpen();
            }
            return false;
        }
        RoomConnectionManager roomConnectionManager = this.connectionManager;
        if (roomConnectionManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("connectionManager");
            roomConnectionManager = null;
        }
        return roomConnectionManager.J();
    }

    protected final void performClear(boolean z2, String... tableNames) {
        Intrinsics.checkNotNullParameter(tableNames, "tableNames");
        assertNotMainThread();
        assertNotSuspendingTransaction();
        RunBlockingUninterruptible_androidKt.a(new AnonymousClass1(z2, tableNames, null));
    }

    public final Cursor query(SupportSQLiteQuery query) {
        Intrinsics.checkNotNullParameter(query, "query");
        return query$default(this, query, null, 2, null);
    }

    public void runInTransaction(final Runnable body) {
        Intrinsics.checkNotNullParameter(body, "body");
        j(new Function0() { // from class: androidx.room.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RoomDatabase.k(body);
            }
        });
    }

    @Deprecated
    public void setTransactionSuccessful() {
        getOpenHelper().getWritableDatabase().t0();
    }

    public final void setUseTempTrackingTable$room_runtime(boolean z2) {
        this.useTempTrackingTable = z2;
    }

    public final <R> Object useConnection(boolean z2, Function2<? super Transactor, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        RoomConnectionManager roomConnectionManager = this.connectionManager;
        if (roomConnectionManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("connectionManager");
            roomConnectionManager = null;
        }
        return roomConnectionManager.K(z2, function2, continuation);
    }

    public final <T> T getTypeConverter(KClass<T> klass) {
        Intrinsics.checkNotNullParameter(klass, "klass");
        T t2 = (T) this.typeConverters.get(klass);
        Intrinsics.checkNotNull(t2, "null cannot be cast to non-null type T of androidx.room.RoomDatabase.getTypeConverter");
        return t2;
    }

    protected final void internalInitInvalidationTracker(SQLiteConnection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        getInvalidationTracker().u(connection);
    }

    public Cursor query(String query, Object[] objArr) {
        Intrinsics.checkNotNullParameter(query, "query");
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return getOpenHelper().getWritableDatabase().P0(new SimpleSQLiteQuery(query, objArr));
    }

    public <V> V runInTransaction(final Callable<V> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        return (V) j(new Function0() { // from class: androidx.room.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RoomDatabase.l(body);
            }
        });
    }

    public Cursor query(SupportSQLiteQuery query, CancellationSignal cancellationSignal) {
        Intrinsics.checkNotNullParameter(query, "query");
        assertNotMainThread();
        assertNotSuspendingTransaction();
        if (cancellationSignal != null) {
            return getOpenHelper().getWritableDatabase().f0(query, cancellationSignal);
        }
        return getOpenHelper().getWritableDatabase().P0(query);
    }

    @Deprecated
    protected static /* synthetic */ void getMCallbacks$annotations() {
    }

    @Deprecated
    protected static /* synthetic */ void getMDatabase$annotations() {
    }
}
