package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.stetho.inspector.helper.qp.sKeKFMqmvNzY;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.GlobalMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.firebase.transport.LogSourceMetrics;
import com.google.android.datatransport.runtime.firebase.transport.StorageMetrics;
import com.google.android.datatransport.runtime.firebase.transport.TimeWindow;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.inject.Provider;
import javax.inject.Singleton;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Singleton
public class SQLiteEventStore implements EventStore, SynchronizationGuard, ClientHealthMetricsStore {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Encoding f69557g = Encoding.b("proto");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SchemaManager f69558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Clock f69559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Clock f69560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EventStoreConfig f69561d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Provider f69562f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface Function<T, U> {
        Object apply(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Metadata {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f69563a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final String f69564b;

        private Metadata(String str, String str2) {
            this.f69563a = str;
            this.f69564b = str2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface Producer<T> {
        Object a();
    }

    SQLiteEventStore(Clock clock, Clock clock2, EventStoreConfig eventStoreConfig, SchemaManager schemaManager, Provider provider) {
        this.f69558a = schemaManager;
        this.f69559b = clock;
        this.f69560c = clock2;
        this.f69561d = eventStoreConfig;
        this.f69562f = provider;
    }

    public static /* synthetic */ TimeWindow A0(final long j3, SQLiteDatabase sQLiteDatabase) {
        return (TimeWindow) V1(sQLiteDatabase.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]), new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.s
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                return SQLiteEventStore.i(j3, (Cursor) obj);
            }
        });
    }

    private List A1(List list, Map map) {
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            PersistedEvent persistedEvent = (PersistedEvent) listIterator.next();
            if (map.containsKey(Long.valueOf(persistedEvent.c()))) {
                EventInternal.Builder builderP = persistedEvent.b().p();
                for (Metadata metadata : (Set) map.get(Long.valueOf(persistedEvent.c()))) {
                    builderP.c(metadata.f69563a, metadata.f69564b);
                }
                listIterator.set(PersistedEvent.a(persistedEvent.c(), persistedEvent.d(), builderP.d()));
            }
        }
        return list;
    }

    public static /* synthetic */ Object C(long j3, TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j3));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{transportContext.b(), String.valueOf(PriorityMapping.a(transportContext.d()))}) < 1) {
            contentValues.put("backend_name", transportContext.b());
            contentValues.put("priority", Integer.valueOf(PriorityMapping.a(transportContext.d())));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }

    public static /* synthetic */ byte[] F(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        int length = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            length += blob.length;
        }
        byte[] bArr = new byte[length];
        int length2 = 0;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            byte[] bArr2 = (byte[]) arrayList.get(i3);
            System.arraycopy(bArr2, 0, bArr, length2, bArr2.length);
            length2 += bArr2.length;
        }
        return bArr;
    }

    private Map I1(SQLiteDatabase sQLiteDatabase, List list) {
        final HashMap map = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i3 = 0; i3 < list.size(); i3++) {
            sb.append(((PersistedEvent) list.get(i3)).c());
            if (i3 < list.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        V1(sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb.toString(), null, null, null, null), new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.o
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                return SQLiteEventStore.e0(map, (Cursor) obj);
            }
        });
        return map;
    }

    public static /* synthetic */ List J(SQLiteDatabase sQLiteDatabase) {
        return (List) V1(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.z
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                return SQLiteEventStore.k((Cursor) obj);
            }
        });
    }

    public static /* synthetic */ ClientMetrics K(SQLiteEventStore sQLiteEventStore, Map map, ClientMetrics.Builder builder, Cursor cursor) {
        sQLiteEventStore.getClass();
        while (cursor.moveToNext()) {
            String string = cursor.getString(0);
            LogEventDropped.Reason reasonO0 = sQLiteEventStore.O0(cursor.getInt(1));
            long j3 = cursor.getLong(2);
            if (!map.containsKey(string)) {
                map.put(string, new ArrayList());
            }
            ((List) map.get(string)).add(LogEventDropped.c().c(reasonO0).b(j3).a());
        }
        sQLiteEventStore.L1(builder, map);
        return builder.e(sQLiteEventStore.o1()).d(sQLiteEventStore.h1()).c((String) sQLiteEventStore.f69562f.get()).b();
    }

    private static byte[] K1(String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    private void L1(ClientMetrics.Builder builder, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            builder.a(LogSourceMetrics.c().c((String) entry.getKey()).b((List) entry.getValue()).a());
        }
    }

    public static /* synthetic */ Long M(SQLiteEventStore sQLiteEventStore, EventInternal eventInternal, TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        if (sQLiteEventStore.w1()) {
            sQLiteEventStore.f(1L, LogEventDropped.Reason.CACHE_FULL, eventInternal.n());
            return -1L;
        }
        long jU0 = sQLiteEventStore.U0(sQLiteDatabase, transportContext);
        int iE = sQLiteEventStore.f69561d.e();
        byte[] bArrA = eventInternal.e().a();
        boolean z2 = bArrA.length <= iE;
        ContentValues contentValues = new ContentValues();
        contentValues.put(SDKConstants.PARAM_CONTEXT_CONTEXT_ID, Long.valueOf(jU0));
        contentValues.put("transport_name", eventInternal.n());
        contentValues.put("timestamp_ms", Long.valueOf(eventInternal.f()));
        contentValues.put("uptime_ms", Long.valueOf(eventInternal.o()));
        contentValues.put("payload_encoding", eventInternal.e().b().a());
        contentValues.put("code", eventInternal.d());
        contentValues.put("num_attempts", (Integer) 0);
        contentValues.put("inline", Boolean.valueOf(z2));
        contentValues.put("payload", z2 ? bArrA : new byte[0]);
        contentValues.put(DiagnosticsTracker.PRODUCT_ID_KEY, eventInternal.l());
        contentValues.put("pseudonymous_id", eventInternal.m());
        contentValues.put("experiment_ids_clear_blob", eventInternal.g());
        contentValues.put("experiment_ids_encrypted_blob", eventInternal.h());
        long jInsert = sQLiteDatabase.insert("events", null, contentValues);
        if (!z2) {
            int iCeil = (int) Math.ceil(((double) bArrA.length) / ((double) iE));
            for (int i3 = 1; i3 <= iCeil; i3++) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArrA, (i3 - 1) * iE, Math.min(i3 * iE, bArrA.length));
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(jInsert));
                contentValues2.put("sequence_num", Integer.valueOf(i3));
                contentValues2.put("bytes", bArrCopyOfRange);
                sQLiteDatabase.insert("event_payloads", null, contentValues2);
            }
        }
        for (Map.Entry entry : eventInternal.k().entrySet()) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("event_id", Long.valueOf(jInsert));
            contentValues3.put("name", (String) entry.getKey());
            contentValues3.put("value", (String) entry.getValue());
            sQLiteDatabase.insert("event_metadata", null, contentValues3);
        }
        return Long.valueOf(jInsert);
    }

    public static /* synthetic */ Object N(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        return null;
    }

    public static /* synthetic */ Long O(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return null;
    }

    private LogEventDropped.Reason O0(int i3) {
        LogEventDropped.Reason reason = LogEventDropped.Reason.REASON_UNKNOWN;
        if (i3 == reason.J()) {
            return reason;
        }
        LogEventDropped.Reason reason2 = LogEventDropped.Reason.MESSAGE_TOO_OLD;
        if (i3 == reason2.J()) {
            return reason2;
        }
        LogEventDropped.Reason reason3 = LogEventDropped.Reason.CACHE_FULL;
        if (i3 == reason3.J()) {
            return reason3;
        }
        LogEventDropped.Reason reason4 = LogEventDropped.Reason.PAYLOAD_TOO_BIG;
        if (i3 == reason4.J()) {
            return reason4;
        }
        LogEventDropped.Reason reason5 = LogEventDropped.Reason.MAX_RETRIES_REACHED;
        if (i3 == reason5.J()) {
            return reason5;
        }
        LogEventDropped.Reason reason6 = LogEventDropped.Reason.INVALID_PAYLOD;
        if (i3 == reason6.J()) {
            return reason6;
        }
        LogEventDropped.Reason reason7 = LogEventDropped.Reason.SERVER_ERROR;
        if (i3 == reason7.J()) {
            return reason7;
        }
        Logging.a("SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN", Integer.valueOf(i3));
        return reason;
    }

    private byte[] Q1(long j3) {
        return (byte[]) V1(a1().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j3)}, null, null, "sequence_num"), new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.q
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                return SQLiteEventStore.F((Cursor) obj);
            }
        });
    }

    private void R0(final SQLiteDatabase sQLiteDatabase) {
        R1(new Producer() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.a
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Producer
            public final Object a() {
                return SQLiteEventStore.N(sQLiteDatabase);
            }
        }, new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.l
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                return SQLiteEventStore.T((Throwable) obj);
            }
        });
    }

    private Object R1(Producer producer, Function function) {
        long jA = this.f69560c.a();
        while (true) {
            try {
                return producer.a();
            } catch (SQLiteDatabaseLockedException e3) {
                if (this.f69560c.a() >= ((long) this.f69561d.b()) + jA) {
                    return function.apply(e3);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    private static Encoding S1(String str) {
        return str == null ? f69557g : Encoding.b(str);
    }

    public static /* synthetic */ Object T(Throwable th) {
        throw new SynchronizationException("Timed out while trying to acquire the lock.", th);
    }

    private static String T1(Iterable iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(((PersistedEvent) it.next()).c());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    private long U0(SQLiteDatabase sQLiteDatabase, TransportContext transportContext) {
        Long lT1 = t1(sQLiteDatabase, transportContext);
        if (lT1 != null) {
            return lT1.longValue();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", transportContext.b());
        contentValues.put("priority", Integer.valueOf(PriorityMapping.a(transportContext.d())));
        contentValues.put("next_request_ms", (Integer) 0);
        if (transportContext.c() != null) {
            contentValues.put("extras", Base64.encodeToString(transportContext.c(), 0));
        }
        return sQLiteDatabase.insert("transport_contexts", null, contentValues);
    }

    public static /* synthetic */ Object V(String str, LogEventDropped.Reason reason, long j3, SQLiteDatabase sQLiteDatabase) {
        if (((Boolean) V1(sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(reason.J())}), new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.n
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                return Boolean.valueOf(((Cursor) obj).getCount() > 0);
            }
        })).booleanValue()) {
            sQLiteDatabase.execSQL("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + j3 + " WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(reason.J())});
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("log_source", str);
        contentValues.put("reason", Integer.valueOf(reason.J()));
        contentValues.put("events_dropped_count", Long.valueOf(j3));
        sQLiteDatabase.insert("log_event_dropped", null, contentValues);
        return null;
    }

    static Object V1(Cursor cursor, Function function) {
        try {
            return function.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    public static /* synthetic */ Object e0(Map map, Cursor cursor) {
        while (true) {
            if (!cursor.moveToNext()) {
                return null;
            }
            long j3 = cursor.getLong(0);
            Set hashSet = (Set) map.get(Long.valueOf(j3));
            if (hashSet == null) {
                hashSet = new HashSet();
                map.put(Long.valueOf(j3), hashSet);
            }
            hashSet.add(new Metadata(cursor.getString(1), cursor.getString(2)));
        }
    }

    public static /* synthetic */ Integer g0(final SQLiteEventStore sQLiteEventStore, long j3, SQLiteDatabase sQLiteDatabase) {
        sQLiteEventStore.getClass();
        String[] strArr = {String.valueOf(j3)};
        V1(sQLiteDatabase.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr), new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.h
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                return SQLiteEventStore.n(this.f69599a, (Cursor) obj);
            }
        });
        return Integer.valueOf(sQLiteDatabase.delete("events", "timestamp_ms < ?", strArr));
    }

    private GlobalMetrics h1() {
        return GlobalMetrics.b().b(StorageMetrics.c().b(X0()).c(EventStoreConfig.f69552a.f()).a()).a();
    }

    public static /* synthetic */ TimeWindow i(long j3, Cursor cursor) {
        cursor.moveToNext();
        return TimeWindow.c().c(cursor.getLong(0)).b(j3).a();
    }

    private long i1() {
        return a1().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    public static /* synthetic */ List j(SQLiteEventStore sQLiteEventStore, TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        List listB1 = sQLiteEventStore.B1(sQLiteDatabase, transportContext, sQLiteEventStore.f69561d.d());
        for (Priority priority : Priority.values()) {
            if (priority != transportContext.d()) {
                int iD = sQLiteEventStore.f69561d.d() - listB1.size();
                if (iD <= 0) {
                    break;
                }
                listB1.addAll(sQLiteEventStore.B1(sQLiteDatabase, transportContext.f(priority), iD));
            }
        }
        return sQLiteEventStore.A1(listB1, sQLiteEventStore.I1(sQLiteDatabase, listB1));
    }

    public static /* synthetic */ Object j0(SQLiteEventStore sQLiteEventStore, List list, TransportContext transportContext, Cursor cursor) {
        sQLiteEventStore.getClass();
        while (cursor.moveToNext()) {
            long j3 = cursor.getLong(0);
            boolean z2 = cursor.getInt(7) != 0;
            EventInternal.Builder builderO = EventInternal.a().n(cursor.getString(1)).i(cursor.getLong(2)).o(cursor.getLong(3));
            if (z2) {
                builderO.h(new EncodedPayload(S1(cursor.getString(4)), cursor.getBlob(5)));
            } else {
                builderO.h(new EncodedPayload(S1(cursor.getString(4)), sQLiteEventStore.Q1(j3)));
            }
            if (!cursor.isNull(6)) {
                builderO.g(Integer.valueOf(cursor.getInt(6)));
            }
            if (!cursor.isNull(8)) {
                builderO.l(Integer.valueOf(cursor.getInt(8)));
            }
            if (!cursor.isNull(9)) {
                builderO.m(cursor.getString(9));
            }
            if (!cursor.isNull(10)) {
                builderO.j(cursor.getBlob(10));
            }
            if (!cursor.isNull(11)) {
                builderO.k(cursor.getBlob(11));
            }
            list.add(PersistedEvent.a(j3, transportContext, builderO.d()));
        }
        return null;
    }

    public static /* synthetic */ List k(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(TransportContext.a().b(cursor.getString(1)).d(PriorityMapping.b(cursor.getInt(2))).c(K1(cursor.getString(3))).a());
        }
        return arrayList;
    }

    public static /* synthetic */ Object l(SQLiteEventStore sQLiteEventStore, Cursor cursor) {
        sQLiteEventStore.getClass();
        while (cursor.moveToNext()) {
            sQLiteEventStore.f(cursor.getInt(0), LogEventDropped.Reason.MAX_RETRIES_REACHED, cursor.getString(1));
        }
        return null;
    }

    public static /* synthetic */ SQLiteDatabase m(Throwable th) {
        throw new SynchronizationException("Timed out while trying to open db.", th);
    }

    public static /* synthetic */ Object n(SQLiteEventStore sQLiteEventStore, Cursor cursor) {
        sQLiteEventStore.getClass();
        while (cursor.moveToNext()) {
            sQLiteEventStore.f(cursor.getInt(0), LogEventDropped.Reason.MESSAGE_TOO_OLD, cursor.getString(1));
        }
        return null;
    }

    private TimeWindow o1() {
        final long jA = this.f69559b.a();
        return (TimeWindow) u1(new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.r
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                return SQLiteEventStore.A0(jA, (SQLiteDatabase) obj);
            }
        });
    }

    public static /* synthetic */ Object q0(SQLiteEventStore sQLiteEventStore, SQLiteDatabase sQLiteDatabase) {
        sQLiteEventStore.getClass();
        sQLiteDatabase.compileStatement("DELETE FROM log_event_dropped").execute();
        sQLiteDatabase.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + sQLiteEventStore.f69559b.a()).execute();
        return null;
    }

    public static /* synthetic */ Object r(final SQLiteEventStore sQLiteEventStore, String str, String str2, SQLiteDatabase sQLiteDatabase) {
        sQLiteEventStore.getClass();
        sQLiteDatabase.compileStatement(str).execute();
        V1(sQLiteDatabase.rawQuery(str2, null), new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.k
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                return SQLiteEventStore.l(this.f69604a, (Cursor) obj);
            }
        });
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
        return null;
    }

    private Long t1(SQLiteDatabase sQLiteDatabase, TransportContext transportContext) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(transportContext.b(), String.valueOf(PriorityMapping.a(transportContext.d()))));
        if (transportContext.c() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(transportContext.c(), 0));
        } else {
            sb.append(" and extras is null");
        }
        return (Long) V1(sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null), new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.c
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                return SQLiteEventStore.O((Cursor) obj);
            }
        });
    }

    private long w() {
        return a1().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    public static /* synthetic */ ClientMetrics w0(final SQLiteEventStore sQLiteEventStore, String str, final Map map, final ClientMetrics.Builder builder, SQLiteDatabase sQLiteDatabase) {
        sQLiteEventStore.getClass();
        return (ClientMetrics) V1(sQLiteDatabase.rawQuery(str, new String[0]), new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.p
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                return SQLiteEventStore.K(this.f69609a, map, builder, (Cursor) obj);
            }
        });
    }

    private boolean w1() {
        return i1() * w() >= this.f69561d.f();
    }

    public static /* synthetic */ Boolean z(SQLiteEventStore sQLiteEventStore, TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        Long lT1 = sQLiteEventStore.t1(sQLiteDatabase, transportContext);
        return lT1 == null ? Boolean.FALSE : (Boolean) V1(sQLiteEventStore.a1().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{lT1.toString()}), new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.j
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                return Boolean.valueOf(((Cursor) obj).moveToNext());
            }
        });
    }

    public static /* synthetic */ Long z0(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return 0L;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public int I() {
        final long jA = this.f69559b.a() - this.f69561d.c();
        return ((Integer) u1(new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.y
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                return SQLiteEventStore.g0(this.f69618a, jA, (SQLiteDatabase) obj);
            }
        })).intValue();
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public void P(Iterable iterable) {
        if (iterable.iterator().hasNext()) {
            a1().compileStatement("DELETE FROM events WHERE _id in " + T1(iterable)).execute();
        }
    }

    long X0() {
        return i1() * w();
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public long Z0(TransportContext transportContext) {
        return ((Long) V1(a1().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{transportContext.b(), String.valueOf(PriorityMapping.a(transportContext.d()))}), new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.w
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                return SQLiteEventStore.z0((Cursor) obj);
            }
        })).longValue();
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore
    public void a() {
        u1(new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.f
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                return SQLiteEventStore.q0(this.f69595a, (SQLiteDatabase) obj);
            }
        });
    }

    SQLiteDatabase a1() {
        final SchemaManager schemaManager = this.f69558a;
        Objects.requireNonNull(schemaManager);
        return (SQLiteDatabase) R1(new Producer() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.t
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Producer
            public final Object a() {
                return schemaManager.getWritableDatabase();
            }
        }, new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.u
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                return SQLiteEventStore.m((Throwable) obj);
            }
        });
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard
    public Object b(SynchronizationGuard.CriticalSection criticalSection) {
        SQLiteDatabase sQLiteDatabaseA1 = a1();
        R0(sQLiteDatabaseA1);
        try {
            Object objD = criticalSection.d();
            sQLiteDatabaseA1.setTransactionSuccessful();
            return objD;
        } finally {
            sQLiteDatabaseA1.endTransaction();
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public void b0(final TransportContext transportContext, final long j3) {
        u1(new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.e
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                return SQLiteEventStore.C(j3, transportContext, (SQLiteDatabase) obj);
            }
        });
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore
    public ClientMetrics c() {
        final ClientMetrics.Builder builderE = ClientMetrics.e();
        final HashMap map = new HashMap();
        final String str = "SELECT log_source, reason, events_dropped_count FROM log_event_dropped";
        return (ClientMetrics) u1(new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.i
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                return SQLiteEventStore.w0(this.f69600a, str, map, builderE, (SQLiteDatabase) obj);
            }
        });
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public boolean c1(final TransportContext transportContext) {
        return ((Boolean) u1(new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.d
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                return SQLiteEventStore.z(this.f69591a, transportContext, (SQLiteDatabase) obj);
            }
        })).booleanValue();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f69558a.close();
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public void e1(Iterable iterable) {
        if (iterable.iterator().hasNext()) {
            final String str = "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + T1(iterable);
            final String str2 = "SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name";
            u1(new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.a0
                @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
                public final Object apply(Object obj) {
                    return SQLiteEventStore.r(this.f69586a, str, str2, (SQLiteDatabase) obj);
                }
            });
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore
    public void f(final long j3, final LogEventDropped.Reason reason, final String str) {
        u1(new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.g
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                return SQLiteEventStore.V(str, reason, j3, (SQLiteDatabase) obj);
            }
        });
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public Iterable i0() {
        return (Iterable) u1(new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.v
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                return SQLiteEventStore.J((SQLiteDatabase) obj);
            }
        });
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public PersistedEvent p2(final TransportContext transportContext, final EventInternal eventInternal) {
        Logging.b("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", transportContext.d(), eventInternal.n(), transportContext.b());
        long jLongValue = ((Long) u1(new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.x
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                return SQLiteEventStore.M(this.f69615a, eventInternal, transportContext, (SQLiteDatabase) obj);
            }
        })).longValue();
        if (jLongValue < 1) {
            return null;
        }
        return PersistedEvent.a(jLongValue, transportContext, eventInternal);
    }

    Object u1(Function function) {
        SQLiteDatabase sQLiteDatabaseA1 = a1();
        sQLiteDatabaseA1.beginTransaction();
        try {
            Object objApply = function.apply(sQLiteDatabaseA1);
            sQLiteDatabaseA1.setTransactionSuccessful();
            return objApply;
        } finally {
            sQLiteDatabaseA1.endTransaction();
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public Iterable y1(final TransportContext transportContext) {
        return (Iterable) u1(new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.b
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                return SQLiteEventStore.j(this.f69589a, transportContext, (SQLiteDatabase) obj);
            }
        });
    }

    private List B1(SQLiteDatabase sQLiteDatabase, final TransportContext transportContext, int i3) {
        final ArrayList arrayList = new ArrayList();
        Long lT1 = t1(sQLiteDatabase, transportContext);
        if (lT1 == null) {
            return arrayList;
        }
        V1(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline", DiagnosticsTracker.PRODUCT_ID_KEY, "pseudonymous_id", "experiment_ids_clear_blob", "experiment_ids_encrypted_blob"}, sKeKFMqmvNzY.SINQiBzcGgAcW, new String[]{lT1.toString()}, null, null, null, String.valueOf(i3)), new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.m
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                return SQLiteEventStore.j0(this.f69605a, arrayList, transportContext, (Cursor) obj);
            }
        });
        return arrayList;
    }
}
