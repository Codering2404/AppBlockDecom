package com.superwall.sdk.storage.core_data.entities;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.google.firebase.sessions.api.ITd.wgbAZXYjrv;
import com.superwall.sdk.storage.core_data.Converters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class ManagedTriggerRuleOccurrenceDao_Impl implements ManagedTriggerRuleOccurrenceDao {
    private final Converters __converters = new Converters();
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<ManagedTriggerRuleOccurrence> __insertionAdapterOfManagedTriggerRuleOccurrence;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

    public ManagedTriggerRuleOccurrenceDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfManagedTriggerRuleOccurrence = new EntityInsertionAdapter<ManagedTriggerRuleOccurrence>(roomDatabase) { // from class: com.superwall.sdk.storage.core_data.entities.ManagedTriggerRuleOccurrenceDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `ManagedTriggerRuleOccurrence` (`id`,`createdAt`,`occurrenceKey`) VALUES (?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, ManagedTriggerRuleOccurrence managedTriggerRuleOccurrence) {
                if (managedTriggerRuleOccurrence.getId() == null) {
                    supportSQLiteStatement.D(1);
                } else {
                    supportSQLiteStatement.A(1, managedTriggerRuleOccurrence.getId().intValue());
                }
                Long timestamp = ManagedTriggerRuleOccurrenceDao_Impl.this.__converters.toTimestamp(managedTriggerRuleOccurrence.getCreatedAt());
                if (timestamp == null) {
                    supportSQLiteStatement.D(2);
                } else {
                    supportSQLiteStatement.A(2, timestamp.longValue());
                }
                supportSQLiteStatement.s1(3, managedTriggerRuleOccurrence.getOccurrenceKey());
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(roomDatabase) { // from class: com.superwall.sdk.storage.core_data.entities.ManagedTriggerRuleOccurrenceDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM ManagedTriggerRuleOccurrence";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }

    @Override // com.superwall.sdk.storage.core_data.entities.ManagedTriggerRuleOccurrenceDao
    public Object countTriggerRuleOccurrencesSinceDate(Date date, String str, Continuation<? super Integer> continuation) {
        final RoomSQLiteQuery roomSQLiteQueryI = RoomSQLiteQuery.i("SELECT COUNT(*) FROM ManagedTriggerRuleOccurrence WHERE createdAt >= ? AND occurrenceKey = ?", 2);
        Long timestamp = this.__converters.toTimestamp(date);
        if (timestamp == null) {
            roomSQLiteQueryI.D(1);
        } else {
            roomSQLiteQueryI.A(1, timestamp.longValue());
        }
        roomSQLiteQueryI.s1(2, str);
        return CoroutinesRoom.a(this.__db, false, DBUtil.a(), new Callable<Integer>() { // from class: com.superwall.sdk.storage.core_data.entities.ManagedTriggerRuleOccurrenceDao_Impl.8
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() throws Exception {
                Cursor cursorH = DBUtil.h(ManagedTriggerRuleOccurrenceDao_Impl.this.__db, roomSQLiteQueryI, false, null);
                try {
                    int iValueOf = cursorH.moveToFirst() ? Integer.valueOf(cursorH.getInt(0)) : 0;
                    cursorH.close();
                    roomSQLiteQueryI.m();
                    return iValueOf;
                } catch (Throwable th) {
                    cursorH.close();
                    roomSQLiteQueryI.m();
                    throw th;
                }
            }
        }, continuation);
    }

    @Override // com.superwall.sdk.storage.core_data.entities.ManagedTriggerRuleOccurrenceDao
    public Object deleteAll(Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.__db, true, new Callable<Unit>() { // from class: com.superwall.sdk.storage.core_data.entities.ManagedTriggerRuleOccurrenceDao_Impl.4
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                SupportSQLiteStatement supportSQLiteStatementAcquire = ManagedTriggerRuleOccurrenceDao_Impl.this.__preparedStmtOfDeleteAll.acquire();
                try {
                    ManagedTriggerRuleOccurrenceDao_Impl.this.__db.beginTransaction();
                    try {
                        supportSQLiteStatementAcquire.X();
                        ManagedTriggerRuleOccurrenceDao_Impl.this.__db.setTransactionSuccessful();
                        return Unit.f139807a;
                    } finally {
                        ManagedTriggerRuleOccurrenceDao_Impl.this.__db.endTransaction();
                    }
                } finally {
                    ManagedTriggerRuleOccurrenceDao_Impl.this.__preparedStmtOfDeleteAll.release(supportSQLiteStatementAcquire);
                }
            }
        }, continuation);
    }

    @Override // com.superwall.sdk.storage.core_data.entities.ManagedTriggerRuleOccurrenceDao
    public Object getManagedTriggerRuleOccurrencesByKey(String str, Continuation<? super List<ManagedTriggerRuleOccurrence>> continuation) {
        final RoomSQLiteQuery roomSQLiteQueryI = RoomSQLiteQuery.i("SELECT * FROM ManagedTriggerRuleOccurrence WHERE occurrenceKey = ?", 1);
        roomSQLiteQueryI.s1(1, str);
        return CoroutinesRoom.a(this.__db, true, DBUtil.a(), new Callable<List<ManagedTriggerRuleOccurrence>>() { // from class: com.superwall.sdk.storage.core_data.entities.ManagedTriggerRuleOccurrenceDao_Impl.5
            @Override // java.util.concurrent.Callable
            public List<ManagedTriggerRuleOccurrence> call() throws Exception {
                ManagedTriggerRuleOccurrenceDao_Impl.this.__db.beginTransaction();
                try {
                    Cursor cursorH = DBUtil.h(ManagedTriggerRuleOccurrenceDao_Impl.this.__db, roomSQLiteQueryI, false, null);
                    try {
                        int iD = CursorUtil.d(cursorH, "id");
                        int iD2 = CursorUtil.d(cursorH, "createdAt");
                        int iD3 = CursorUtil.d(cursorH, "occurrenceKey");
                        ArrayList arrayList = new ArrayList(cursorH.getCount());
                        while (cursorH.moveToNext()) {
                            Integer numValueOf = cursorH.isNull(iD) ? null : Integer.valueOf(cursorH.getInt(iD));
                            Long lValueOf = cursorH.isNull(iD2) ? null : Long.valueOf(cursorH.getLong(iD2));
                            Date date = lValueOf == null ? null : ManagedTriggerRuleOccurrenceDao_Impl.this.__converters.toDate(lValueOf.longValue());
                            if (date == null) {
                                throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.");
                            }
                            arrayList.add(new ManagedTriggerRuleOccurrence(numValueOf, date, cursorH.getString(iD3)));
                        }
                        ManagedTriggerRuleOccurrenceDao_Impl.this.__db.setTransactionSuccessful();
                        cursorH.close();
                        roomSQLiteQueryI.m();
                        return arrayList;
                    } catch (Throwable th) {
                        cursorH.close();
                        roomSQLiteQueryI.m();
                        throw th;
                    }
                } finally {
                    ManagedTriggerRuleOccurrenceDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.superwall.sdk.storage.core_data.entities.ManagedTriggerRuleOccurrenceDao
    public Object getManagedTriggerRuleOccurrencesSinceDate(Date date, String str, Continuation<? super List<ManagedTriggerRuleOccurrence>> continuation) {
        final RoomSQLiteQuery roomSQLiteQueryI = RoomSQLiteQuery.i("SELECT * FROM ManagedTriggerRuleOccurrence WHERE createdAt >= ? AND occurrenceKey = ?", 2);
        Long timestamp = this.__converters.toTimestamp(date);
        if (timestamp == null) {
            roomSQLiteQueryI.D(1);
        } else {
            roomSQLiteQueryI.A(1, timestamp.longValue());
        }
        roomSQLiteQueryI.s1(2, str);
        return CoroutinesRoom.a(this.__db, true, DBUtil.a(), new Callable<List<ManagedTriggerRuleOccurrence>>() { // from class: com.superwall.sdk.storage.core_data.entities.ManagedTriggerRuleOccurrenceDao_Impl.6
            @Override // java.util.concurrent.Callable
            public List<ManagedTriggerRuleOccurrence> call() throws Exception {
                ManagedTriggerRuleOccurrenceDao_Impl.this.__db.beginTransaction();
                try {
                    Cursor cursorH = DBUtil.h(ManagedTriggerRuleOccurrenceDao_Impl.this.__db, roomSQLiteQueryI, false, null);
                    try {
                        int iD = CursorUtil.d(cursorH, "id");
                        int iD2 = CursorUtil.d(cursorH, "createdAt");
                        int iD3 = CursorUtil.d(cursorH, "occurrenceKey");
                        ArrayList arrayList = new ArrayList(cursorH.getCount());
                        while (cursorH.moveToNext()) {
                            Integer numValueOf = cursorH.isNull(iD) ? null : Integer.valueOf(cursorH.getInt(iD));
                            Long lValueOf = cursorH.isNull(iD2) ? null : Long.valueOf(cursorH.getLong(iD2));
                            Date date2 = lValueOf == null ? null : ManagedTriggerRuleOccurrenceDao_Impl.this.__converters.toDate(lValueOf.longValue());
                            if (date2 == null) {
                                throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.");
                            }
                            arrayList.add(new ManagedTriggerRuleOccurrence(numValueOf, date2, cursorH.getString(iD3)));
                        }
                        ManagedTriggerRuleOccurrenceDao_Impl.this.__db.setTransactionSuccessful();
                        cursorH.close();
                        roomSQLiteQueryI.m();
                        return arrayList;
                    } catch (Throwable th) {
                        cursorH.close();
                        roomSQLiteQueryI.m();
                        throw th;
                    }
                } finally {
                    ManagedTriggerRuleOccurrenceDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.superwall.sdk.storage.core_data.entities.ManagedTriggerRuleOccurrenceDao
    public Object insert(final ManagedTriggerRuleOccurrence managedTriggerRuleOccurrence, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.__db, true, new Callable<Unit>() { // from class: com.superwall.sdk.storage.core_data.entities.ManagedTriggerRuleOccurrenceDao_Impl.3
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                ManagedTriggerRuleOccurrenceDao_Impl.this.__db.beginTransaction();
                try {
                    ManagedTriggerRuleOccurrenceDao_Impl.this.__insertionAdapterOfManagedTriggerRuleOccurrence.insert(managedTriggerRuleOccurrence);
                    ManagedTriggerRuleOccurrenceDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.f139807a;
                } finally {
                    ManagedTriggerRuleOccurrenceDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.superwall.sdk.storage.core_data.entities.ManagedTriggerRuleOccurrenceDao
    public Object countTriggerRuleOccurrencesByKey(String str, Continuation<? super Integer> continuation) {
        final RoomSQLiteQuery roomSQLiteQueryI = RoomSQLiteQuery.i(wgbAZXYjrv.JsyAEGWKcXmYJxG, 1);
        roomSQLiteQueryI.s1(1, str);
        return CoroutinesRoom.a(this.__db, false, DBUtil.a(), new Callable<Integer>() { // from class: com.superwall.sdk.storage.core_data.entities.ManagedTriggerRuleOccurrenceDao_Impl.7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() throws Exception {
                Cursor cursorH = DBUtil.h(ManagedTriggerRuleOccurrenceDao_Impl.this.__db, roomSQLiteQueryI, false, null);
                try {
                    int iValueOf = cursorH.moveToFirst() ? Integer.valueOf(cursorH.getInt(0)) : 0;
                    cursorH.close();
                    roomSQLiteQueryI.m();
                    return iValueOf;
                } catch (Throwable th) {
                    cursorH.close();
                    roomSQLiteQueryI.m();
                    throw th;
                }
            }
        }, continuation);
    }
}
