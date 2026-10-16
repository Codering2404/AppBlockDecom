package androidx.room;

import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

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
public final class TriggerBasedInvalidationTracker {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Companion f52394l = new Companion(null);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String[] f52395m = {"INSERT", "UPDATE", "DELETE"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f52396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f52397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f52398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f52399d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Function1 f52400e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map f52401f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String[] f52402g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ObservedTableStates f52403h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ObservedTableVersions f52404i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final AtomicBoolean f52405j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Function0 f52406k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String b(String str, String str2) {
            return "room_table_modification_trigger_" + str + '_' + str2;
        }

        private Companion() {
        }
    }

    public TriggerBasedInvalidationTracker(RoomDatabase database, Map shadowTablesMap, Map viewTables, String[] tableNames, boolean z2, Function1 onInvalidatedTablesIds) {
        String lowerCase;
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(shadowTablesMap, "shadowTablesMap");
        Intrinsics.checkNotNullParameter(viewTables, "viewTables");
        Intrinsics.checkNotNullParameter(tableNames, "tableNames");
        Intrinsics.checkNotNullParameter(onInvalidatedTablesIds, "onInvalidatedTablesIds");
        this.f52396a = database;
        this.f52397b = shadowTablesMap;
        this.f52398c = viewTables;
        this.f52399d = z2;
        this.f52400e = onInvalidatedTablesIds;
        this.f52405j = new AtomicBoolean(false);
        this.f52406k = new Function0() { // from class: androidx.room.s
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(TriggerBasedInvalidationTracker.o());
            }
        };
        this.f52401f = new LinkedHashMap();
        int length = tableNames.length;
        String[] strArr = new String[length];
        for (int i3 = 0; i3 < length; i3++) {
            String str = tableNames[i3];
            Locale locale = Locale.ROOT;
            String lowerCase2 = str.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            this.f52401f.put(lowerCase2, Integer.valueOf(i3));
            String str2 = (String) this.f52397b.get(tableNames[i3]);
            if (str2 != null) {
                lowerCase = str2.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            } else {
                lowerCase = null;
            }
            if (lowerCase != null) {
                lowerCase2 = lowerCase;
            }
            strArr[i3] = lowerCase2;
        }
        this.f52402g = strArr;
        for (Map.Entry entry : this.f52397b.entrySet()) {
            String str3 = (String) entry.getValue();
            Locale locale2 = Locale.ROOT;
            String lowerCase3 = str3.toLowerCase(locale2);
            Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
            if (this.f52401f.containsKey(lowerCase3)) {
                String lowerCase4 = ((String) entry.getKey()).toLowerCase(locale2);
                Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                Map map = this.f52401f;
                map.put(lowerCase4, MapsKt.getValue(map, lowerCase3));
            }
        }
        this.f52403h = new ObservedTableStates(this.f52402g.length);
        this.f52404i = new ObservedTableVersions(this.f52402g.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object j(androidx.room.PooledConnection r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.room.TriggerBasedInvalidationTracker$checkInvalidatedTables$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.room.TriggerBasedInvalidationTracker$checkInvalidatedTables$1 r0 = (androidx.room.TriggerBasedInvalidationTracker$checkInvalidatedTables$1) r0
            int r1 = r0.f52410d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f52410d = r1
            goto L18
        L13:
            androidx.room.TriggerBasedInvalidationTracker$checkInvalidatedTables$1 r0 = new androidx.room.TriggerBasedInvalidationTracker$checkInvalidatedTables$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f52408b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f52410d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r6 = r0.f52407a
            java.util.Set r6 = (java.util.Set) r6
            kotlin.ResultKt.b(r7)
            return r6
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            java.lang.Object r6 = r0.f52407a
            androidx.room.PooledConnection r6 = (androidx.room.PooledConnection) r6
            kotlin.ResultKt.b(r7)
            goto L55
        L40:
            kotlin.ResultKt.b(r7)
            androidx.room.q r7 = new androidx.room.q
            r7.<init>()
            r0.f52407a = r6
            r0.f52410d = r4
            java.lang.String r2 = "SELECT * FROM room_table_modification_log WHERE invalidated = 1"
            java.lang.Object r7 = r6.d(r2, r7, r0)
            if (r7 != r1) goto L55
            goto L6c
        L55:
            java.util.Set r7 = (java.util.Set) r7
            r2 = r7
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L6d
            r0.f52407a = r7
            r0.f52410d = r3
            java.lang.String r2 = "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1"
            java.lang.Object r6 = androidx.room.TransactorKt.b(r6, r2, r0)
            if (r6 != r1) goto L6d
        L6c:
            return r1
        L6d:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker.j(androidx.room.PooledConnection, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set k(SQLiteStatement statement) {
        Intrinsics.checkNotNullParameter(statement, "statement");
        Set setCreateSetBuilder = SetsKt.createSetBuilder();
        while (statement.B2()) {
            setCreateSetBuilder.add(Integer.valueOf((int) statement.getLong(0)));
        }
        return SetsKt.build(setCreateSetBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object n(kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r9 instanceof androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$1 r0 = (androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$1) r0
            int r1 = r0.f52431d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f52431d = r1
            goto L18
        L13:
            androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$1 r0 = new androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$1
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.f52429b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f52431d
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r0 = r0.f52428a
            androidx.room.concurrent.CloseBarrier r0 = (androidx.room.concurrent.CloseBarrier) r0
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L2d
            goto L89
        L2d:
            r9 = move-exception
            goto La2
        L30:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L38:
            kotlin.ResultKt.b(r9)
            androidx.room.RoomDatabase r9 = r8.f52396a
            androidx.room.concurrent.CloseBarrier r9 = r9.getCloseBarrier$room_runtime()
            boolean r2 = r9.a()
            if (r2 == 0) goto La6
            java.util.concurrent.atomic.AtomicBoolean r2 = r8.f52405j     // Catch: java.lang.Throwable -> L58
            r4 = 0
            boolean r2 = r2.compareAndSet(r3, r4)     // Catch: java.lang.Throwable -> L58
            if (r2 != 0) goto L5d
            java.util.Set r0 = kotlin.collections.SetsKt.emptySet()     // Catch: java.lang.Throwable -> L58
            r9.d()
            return r0
        L58:
            r0 = move-exception
            r7 = r0
            r0 = r9
            r9 = r7
            goto La2
        L5d:
            kotlin.jvm.functions.Function0 r2 = r8.f52406k     // Catch: java.lang.Throwable -> L58
            java.lang.Object r2 = r2.invoke()     // Catch: java.lang.Throwable -> L58
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch: java.lang.Throwable -> L58
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Throwable -> L58
            if (r2 != 0) goto L73
            java.util.Set r0 = kotlin.collections.SetsKt.emptySet()     // Catch: java.lang.Throwable -> L58
            r9.d()
            return r0
        L73:
            androidx.room.RoomDatabase r2 = r8.f52396a     // Catch: java.lang.Throwable -> L58
            androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1 r5 = new androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1     // Catch: java.lang.Throwable -> L58
            r6 = 0
            r5.<init>(r8, r6)     // Catch: java.lang.Throwable -> L58
            r0.f52428a = r9     // Catch: java.lang.Throwable -> L58
            r0.f52431d = r3     // Catch: java.lang.Throwable -> L58
            java.lang.Object r0 = r2.useConnection(r4, r5, r0)     // Catch: java.lang.Throwable -> L58
            if (r0 != r1) goto L86
            return r1
        L86:
            r7 = r0
            r0 = r9
            r9 = r7
        L89:
            java.util.Set r9 = (java.util.Set) r9     // Catch: java.lang.Throwable -> L2d
            r1 = r9
            java.util.Collection r1 = (java.util.Collection) r1     // Catch: java.lang.Throwable -> L2d
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L2d
            if (r1 != 0) goto L9e
            androidx.room.ObservedTableVersions r1 = r8.f52404i     // Catch: java.lang.Throwable -> L2d
            r1.b(r9)     // Catch: java.lang.Throwable -> L2d
            kotlin.jvm.functions.Function1 r1 = r8.f52400e     // Catch: java.lang.Throwable -> L2d
            r1.invoke(r9)     // Catch: java.lang.Throwable -> L2d
        L9e:
            r0.d()
            return r9
        La2:
            r0.d()
            throw r9
        La6:
            java.util.Set r9 = kotlin.collections.SetsKt.emptySet()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker.n(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean o() {
        return true;
    }

    private final String[] u(String[] strArr) {
        Set setCreateSetBuilder = SetsKt.createSetBuilder();
        for (String str : strArr) {
            Map map = this.f52398c;
            String lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            Set set = (Set) map.get(lowerCase);
            if (set != null) {
                setCreateSetBuilder.addAll(set);
            } else {
                setCreateSetBuilder.add(str);
            }
        }
        return (String[]) SetsKt.build(setCreateSetBuilder).toArray(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0074, code lost:
    
        if (androidx.room.TransactorKt.b(r13, r15, r0) == r1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00e0, code lost:
    
        if (androidx.room.TransactorKt.b(r7, r15, r0) == r1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00e2, code lost:
    
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00e0 -> B:28:0x00e3). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object w(androidx.room.PooledConnection r13, int r14, kotlin.coroutines.Continuation r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker.w(androidx.room.PooledConnection, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0085 -> B:20:0x0087). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object x(androidx.room.PooledConnection r10, int r11, kotlin.coroutines.Continuation r12) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r12 instanceof androidx.room.TriggerBasedInvalidationTracker$stopTrackingTable$1
            if (r0 == 0) goto L13
            r0 = r12
            androidx.room.TriggerBasedInvalidationTracker$stopTrackingTable$1 r0 = (androidx.room.TriggerBasedInvalidationTracker$stopTrackingTable$1) r0
            int r1 = r0.f52462i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f52462i = r1
            goto L18
        L13:
            androidx.room.TriggerBasedInvalidationTracker$stopTrackingTable$1 r0 = new androidx.room.TriggerBasedInvalidationTracker$stopTrackingTable$1
            r0.<init>(r9, r12)
        L18:
            java.lang.Object r12 = r0.f52460g
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f52462i
            r3 = 1
            if (r2 == 0) goto L42
            if (r2 != r3) goto L3a
            int r10 = r0.f52459f
            int r11 = r0.f52458d
            java.lang.Object r2 = r0.f52457c
            java.lang.String[] r2 = (java.lang.String[]) r2
            java.lang.Object r4 = r0.f52456b
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r0.f52455a
            androidx.room.PooledConnection r5 = (androidx.room.PooledConnection) r5
            kotlin.ResultKt.b(r12)
            r12 = r4
            goto L87
        L3a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L42:
            kotlin.ResultKt.b(r12)
            java.lang.String[] r12 = r9.f52402g
            r11 = r12[r11]
            java.lang.String[] r12 = androidx.room.TriggerBasedInvalidationTracker.f52395m
            int r2 = r12.length
            r4 = 0
            r8 = r11
            r11 = r10
            r10 = r2
            r2 = r12
            r12 = r8
        L52:
            if (r4 >= r10) goto L8b
            r5 = r2[r4]
            androidx.room.TriggerBasedInvalidationTracker$Companion r6 = androidx.room.TriggerBasedInvalidationTracker.f52394l
            java.lang.String r5 = androidx.room.TriggerBasedInvalidationTracker.Companion.a(r6, r12, r5)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "DROP TRIGGER IF EXISTS `"
            r6.append(r7)
            r6.append(r5)
            r5 = 96
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            r0.f52455a = r11
            r0.f52456b = r12
            r0.f52457c = r2
            r0.f52458d = r4
            r0.f52459f = r10
            r0.f52462i = r3
            java.lang.Object r5 = androidx.room.TransactorKt.b(r11, r5, r0)
            if (r5 != r1) goto L85
            return r1
        L85:
            r5 = r11
            r11 = r4
        L87:
            int r4 = r11 + 1
            r11 = r5
            goto L52
        L8b:
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker.x(androidx.room.PooledConnection, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void l(SQLiteConnection connection) throws Exception {
        Intrinsics.checkNotNullParameter(connection, "connection");
        SQLiteStatement sQLiteStatementG2 = connection.G2("PRAGMA query_only");
        try {
            sQLiteStatementG2.B2();
            boolean zJ1 = sQLiteStatementG2.J1(0);
            AutoCloseableKt.a(sQLiteStatementG2, null);
            if (zJ1) {
                return;
            }
            SQLite.a(connection, "PRAGMA temp_store = MEMORY");
            SQLite.a(connection, "PRAGMA recursive_triggers = 1");
            SQLite.a(connection, "DROP TABLE IF EXISTS room_table_modification_log");
            if (this.f52399d) {
                SQLite.a(connection, "CREATE TEMP TABLE IF NOT EXISTS room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
            } else {
                SQLite.a(connection, StringsKt.O("CREATE TEMP TABLE IF NOT EXISTS room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)", "TEMP", "", false, 4, null));
            }
            this.f52403h.f();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.a(sQLiteStatementG2, th);
                throw th2;
            }
        }
    }

    public final Flow m(String[] resolvedTableNames, int[] tableIds, boolean z2) {
        Intrinsics.checkNotNullParameter(resolvedTableNames, "resolvedTableNames");
        Intrinsics.checkNotNullParameter(tableIds, "tableIds");
        return FlowKt.I(new TriggerBasedInvalidationTracker$createFlow$1(this, tableIds, z2, resolvedTableNames, null));
    }

    public final boolean p(int[] tableIds) {
        Intrinsics.checkNotNullParameter(tableIds, "tableIds");
        return this.f52403h.g(tableIds);
    }

    public final boolean q(int[] tableIds) {
        Intrinsics.checkNotNullParameter(tableIds, "tableIds");
        return this.f52403h.h(tableIds);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object r(java.lang.String[] r5, kotlin.jvm.functions.Function0 r6, kotlin.jvm.functions.Function0 r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r8 instanceof androidx.room.TriggerBasedInvalidationTracker$refreshInvalidation$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.room.TriggerBasedInvalidationTracker$refreshInvalidation$1 r0 = (androidx.room.TriggerBasedInvalidationTracker$refreshInvalidation$1) r0
            int r1 = r0.f52442f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f52442f = r1
            goto L18
        L13:
            androidx.room.TriggerBasedInvalidationTracker$refreshInvalidation$1 r0 = new androidx.room.TriggerBasedInvalidationTracker$refreshInvalidation$1
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.f52440c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f52442f
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r5 = r0.f52439b
            int[] r5 = (int[]) r5
            java.lang.Object r6 = r0.f52438a
            r7 = r6
            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L32
            goto L59
        L32:
            r5 = move-exception
            goto L8a
        L34:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3c:
            kotlin.ResultKt.b(r8)
            kotlin.Pair r5 = r4.z(r5)
            java.lang.Object r5 = r5.b()
            int[] r5 = (int[]) r5
            r6.invoke()
            r0.f52438a = r7     // Catch: java.lang.Throwable -> L32
            r0.f52439b = r5     // Catch: java.lang.Throwable -> L32
            r0.f52442f = r3     // Catch: java.lang.Throwable -> L32
            java.lang.Object r8 = r4.n(r0)     // Catch: java.lang.Throwable -> L32
            if (r8 != r1) goto L59
            return r1
        L59:
            java.util.Set r8 = (java.util.Set) r8     // Catch: java.lang.Throwable -> L32
            int r6 = r5.length     // Catch: java.lang.Throwable -> L32
            r0 = 0
            if (r6 != 0) goto L61
            r6 = r3
            goto L62
        L61:
            r6 = r0
        L62:
            if (r6 != 0) goto L7a
            int r6 = r5.length     // Catch: java.lang.Throwable -> L32
            r1 = r0
        L66:
            if (r1 >= r6) goto L78
            r2 = r5[r1]     // Catch: java.lang.Throwable -> L32
            java.lang.Integer r2 = kotlin.coroutines.jvm.internal.Boxing.d(r2)     // Catch: java.lang.Throwable -> L32
            boolean r2 = r8.contains(r2)     // Catch: java.lang.Throwable -> L32
            if (r2 == 0) goto L75
            goto L82
        L75:
            int r1 = r1 + 1
            goto L66
        L78:
            r3 = r0
            goto L82
        L7a:
            java.util.Collection r8 = (java.util.Collection) r8     // Catch: java.lang.Throwable -> L32
            boolean r5 = r8.isEmpty()     // Catch: java.lang.Throwable -> L32
            if (r5 != 0) goto L78
        L82:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.a(r3)     // Catch: java.lang.Throwable -> L32
            r7.invoke()
            return r5
        L8a:
            r7.invoke()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker.r(java.lang.String[], kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void s(Function0 onRefreshScheduled, Function0 onRefreshCompleted) {
        Intrinsics.checkNotNullParameter(onRefreshScheduled, "onRefreshScheduled");
        Intrinsics.checkNotNullParameter(onRefreshCompleted, "onRefreshCompleted");
        if (this.f52405j.compareAndSet(false, true)) {
            onRefreshScheduled.invoke();
            BuildersKt__Builders_commonKt.d(this.f52396a.getCoroutineScope(), new CoroutineName("Room Invalidation Tracker Refresh"), null, new TriggerBasedInvalidationTracker$refreshInvalidationAsync$3(this, onRefreshCompleted, null), 2, null);
        }
    }

    public final void t() {
        this.f52403h.i();
    }

    public final void v(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.f52406k = function0;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object y(kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof androidx.room.TriggerBasedInvalidationTracker$syncTriggers$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.room.TriggerBasedInvalidationTracker$syncTriggers$1 r0 = (androidx.room.TriggerBasedInvalidationTracker$syncTriggers$1) r0
            int r1 = r0.f52466d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f52466d = r1
            goto L18
        L13:
            androidx.room.TriggerBasedInvalidationTracker$syncTriggers$1 r0 = new androidx.room.TriggerBasedInvalidationTracker$syncTriggers$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f52464b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f52466d
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r0 = r0.f52463a
            androidx.room.concurrent.CloseBarrier r0 = (androidx.room.concurrent.CloseBarrier) r0
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L2d
            goto L5b
        L2d:
            r8 = move-exception
            goto L63
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L37:
            kotlin.ResultKt.b(r8)
            androidx.room.RoomDatabase r8 = r7.f52396a
            androidx.room.concurrent.CloseBarrier r8 = r8.getCloseBarrier$room_runtime()
            boolean r2 = r8.a()
            if (r2 == 0) goto L67
            androidx.room.RoomDatabase r2 = r7.f52396a     // Catch: java.lang.Throwable -> L5f
            androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1 r4 = new androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1     // Catch: java.lang.Throwable -> L5f
            r5 = 0
            r4.<init>(r7, r5)     // Catch: java.lang.Throwable -> L5f
            r0.f52463a = r8     // Catch: java.lang.Throwable -> L5f
            r0.f52466d = r3     // Catch: java.lang.Throwable -> L5f
            r3 = 0
            java.lang.Object r0 = r2.useConnection(r3, r4, r0)     // Catch: java.lang.Throwable -> L5f
            if (r0 != r1) goto L5a
            return r1
        L5a:
            r0 = r8
        L5b:
            r0.d()
            goto L67
        L5f:
            r0 = move-exception
            r6 = r0
            r0 = r8
            r8 = r6
        L63:
            r0.d()
            throw r8
        L67:
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker.y(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Pair z(String[] names) {
        Intrinsics.checkNotNullParameter(names, "names");
        String[] strArrU = u(names);
        int length = strArrU.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            String str = strArrU[i3];
            Map map = this.f52401f;
            String lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            Integer num = (Integer) map.get(lowerCase);
            if (num == null) {
                throw new IllegalArgumentException("There is no table with name " + str);
            }
            iArr[i3] = num.intValue();
        }
        return TuplesKt.a(strArrU, iArr);
    }
}
