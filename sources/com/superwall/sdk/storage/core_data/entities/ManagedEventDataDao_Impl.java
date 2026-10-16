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
import com.superwall.sdk.storage.core_data.Converters;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class ManagedEventDataDao_Impl implements ManagedEventDataDao {
    private final Converters __converters = new Converters();
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<ManagedEventData> __insertionAdapterOfManagedEventData;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

    public ManagedEventDataDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfManagedEventData = new EntityInsertionAdapter<ManagedEventData>(roomDatabase) { // from class: com.superwall.sdk.storage.core_data.entities.ManagedEventDataDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `ManagedEventData` (`id`,`createdAt`,`name`,`parameters`) VALUES (?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, ManagedEventData managedEventData) {
                supportSQLiteStatement.s1(1, managedEventData.getId());
                Long timestamp = ManagedEventDataDao_Impl.this.__converters.toTimestamp(managedEventData.getCreatedAt());
                if (timestamp == null) {
                    supportSQLiteStatement.D(2);
                } else {
                    supportSQLiteStatement.A(2, timestamp.longValue());
                }
                supportSQLiteStatement.s1(3, managedEventData.getName());
                supportSQLiteStatement.s1(4, ManagedEventDataDao_Impl.this.__converters.fromMap(managedEventData.getParameters()));
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(roomDatabase) { // from class: com.superwall.sdk.storage.core_data.entities.ManagedEventDataDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM ManagedEventData";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }

    @Override // com.superwall.sdk.storage.core_data.entities.ManagedEventDataDao
    public Object countEventsByNameInPeriod(String str, Date date, Date date2, Continuation<? super Integer> continuation) {
        final RoomSQLiteQuery roomSQLiteQueryI = RoomSQLiteQuery.i("\n        SELECT COUNT(*) FROM ManagedEventData \n        WHERE name = ? \n        AND createdAt BETWEEN ? AND ?\n        ", 3);
        roomSQLiteQueryI.s1(1, str);
        Long timestamp = this.__converters.toTimestamp(date);
        if (timestamp == null) {
            roomSQLiteQueryI.D(2);
        } else {
            roomSQLiteQueryI.A(2, timestamp.longValue());
        }
        Long timestamp2 = this.__converters.toTimestamp(date2);
        if (timestamp2 == null) {
            roomSQLiteQueryI.D(3);
        } else {
            roomSQLiteQueryI.A(3, timestamp2.longValue());
        }
        return CoroutinesRoom.a(this.__db, false, DBUtil.a(), new Callable<Integer>() { // from class: com.superwall.sdk.storage.core_data.entities.ManagedEventDataDao_Impl.6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() throws Exception {
                Cursor cursorH = DBUtil.h(ManagedEventDataDao_Impl.this.__db, roomSQLiteQueryI, false, null);
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

    @Override // com.superwall.sdk.storage.core_data.entities.ManagedEventDataDao
    public Object deleteAll(Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.__db, true, new Callable<Unit>() { // from class: com.superwall.sdk.storage.core_data.entities.ManagedEventDataDao_Impl.4
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                SupportSQLiteStatement supportSQLiteStatementAcquire = ManagedEventDataDao_Impl.this.__preparedStmtOfDeleteAll.acquire();
                try {
                    ManagedEventDataDao_Impl.this.__db.beginTransaction();
                    try {
                        supportSQLiteStatementAcquire.X();
                        ManagedEventDataDao_Impl.this.__db.setTransactionSuccessful();
                        return Unit.f139807a;
                    } finally {
                        ManagedEventDataDao_Impl.this.__db.endTransaction();
                    }
                } finally {
                    ManagedEventDataDao_Impl.this.__preparedStmtOfDeleteAll.release(supportSQLiteStatementAcquire);
                }
            }
        }, continuation);
    }

    @Override // com.superwall.sdk.storage.core_data.entities.ManagedEventDataDao
    public Object getLastSavedEvent(String str, Date date, Continuation<? super ManagedEventData> continuation) {
        final RoomSQLiteQuery roomSQLiteQueryI = RoomSQLiteQuery.i("\n        SELECT * FROM ManagedEventData \n        WHERE name = ? \n        AND (? IS NULL OR createdAt < ?) \n        ORDER BY createdAt DESC \n        LIMIT 1\n    ", 3);
        roomSQLiteQueryI.s1(1, str);
        Long timestamp = this.__converters.toTimestamp(date);
        if (timestamp == null) {
            roomSQLiteQueryI.D(2);
        } else {
            roomSQLiteQueryI.A(2, timestamp.longValue());
        }
        Long timestamp2 = this.__converters.toTimestamp(date);
        if (timestamp2 == null) {
            roomSQLiteQueryI.D(3);
        } else {
            roomSQLiteQueryI.A(3, timestamp2.longValue());
        }
        return CoroutinesRoom.a(this.__db, false, DBUtil.a(), new Callable<ManagedEventData>() { // from class: com.superwall.sdk.storage.core_data.entities.ManagedEventDataDao_Impl.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public ManagedEventData call() throws Exception {
                ManagedEventData managedEventData = null;
                Date date2 = null;
                Cursor cursorH = DBUtil.h(ManagedEventDataDao_Impl.this.__db, roomSQLiteQueryI, false, null);
                try {
                    int iD = CursorUtil.d(cursorH, "id");
                    int iD2 = CursorUtil.d(cursorH, "createdAt");
                    int iD3 = CursorUtil.d(cursorH, "name");
                    int iD4 = CursorUtil.d(cursorH, "parameters");
                    if (cursorH.moveToFirst()) {
                        String string = cursorH.getString(iD);
                        Long lValueOf = cursorH.isNull(iD2) ? null : Long.valueOf(cursorH.getLong(iD2));
                        if (lValueOf != null) {
                            date2 = ManagedEventDataDao_Impl.this.__converters.toDate(lValueOf.longValue());
                        }
                        if (date2 == null) {
                            throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.");
                        }
                        managedEventData = new ManagedEventData(string, date2, cursorH.getString(iD3), ManagedEventDataDao_Impl.this.__converters.toMap(cursorH.getString(iD4)));
                    }
                    cursorH.close();
                    roomSQLiteQueryI.m();
                    return managedEventData;
                } catch (Throwable th) {
                    cursorH.close();
                    roomSQLiteQueryI.m();
                    throw th;
                }
            }
        }, continuation);
    }

    @Override // com.superwall.sdk.storage.core_data.entities.ManagedEventDataDao
    public Object insert(final ManagedEventData managedEventData, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.__db, true, new Callable<Unit>() { // from class: com.superwall.sdk.storage.core_data.entities.ManagedEventDataDao_Impl.3
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                ManagedEventDataDao_Impl.this.__db.beginTransaction();
                try {
                    ManagedEventDataDao_Impl.this.__insertionAdapterOfManagedEventData.insert(managedEventData);
                    ManagedEventDataDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.f139807a;
                } finally {
                    ManagedEventDataDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }
}
