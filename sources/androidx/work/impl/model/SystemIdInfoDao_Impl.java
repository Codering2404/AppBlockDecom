package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.impl.model.SystemIdInfoDao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class SystemIdInfoDao_Impl implements SystemIdInfoDao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f54987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertionAdapter f54988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SharedSQLiteStatement f54989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SharedSQLiteStatement f54990d;

    public SystemIdInfoDao_Impl(RoomDatabase roomDatabase) {
        this.f54987a = roomDatabase;
        this.f54988b = new EntityInsertionAdapter<SystemIdInfo>(roomDatabase) { // from class: androidx.work.impl.model.SystemIdInfoDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`generation`,`system_id`) VALUES (?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, SystemIdInfo systemIdInfo) {
                String str = systemIdInfo.f54984a;
                if (str == null) {
                    supportSQLiteStatement.D(1);
                } else {
                    supportSQLiteStatement.s1(1, str);
                }
                supportSQLiteStatement.A(2, systemIdInfo.a());
                supportSQLiteStatement.A(3, systemIdInfo.f54986c);
            }
        };
        this.f54989c = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.SystemIdInfoDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM SystemIdInfo where work_spec_id=? AND generation=?";
            }
        };
        this.f54990d = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.SystemIdInfoDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM SystemIdInfo where work_spec_id=?";
            }
        };
    }

    public static List j() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public SystemIdInfo b(WorkGenerationalId workGenerationalId) {
        return SystemIdInfoDao.DefaultImpls.a(this, workGenerationalId);
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public SystemIdInfo c(String str, int i3) {
        RoomSQLiteQuery roomSQLiteQueryI = RoomSQLiteQuery.i("SELECT * FROM SystemIdInfo WHERE work_spec_id=? AND generation=?", 2);
        if (str == null) {
            roomSQLiteQueryI.D(1);
        } else {
            roomSQLiteQueryI.s1(1, str);
        }
        roomSQLiteQueryI.A(2, i3);
        this.f54987a.assertNotSuspendingTransaction();
        SystemIdInfo systemIdInfo = null;
        String string = null;
        Cursor cursorH = DBUtil.h(this.f54987a, roomSQLiteQueryI, false, null);
        try {
            int iD = CursorUtil.d(cursorH, "work_spec_id");
            int iD2 = CursorUtil.d(cursorH, "generation");
            int iD3 = CursorUtil.d(cursorH, "system_id");
            if (cursorH.moveToFirst()) {
                if (!cursorH.isNull(iD)) {
                    string = cursorH.getString(iD);
                }
                systemIdInfo = new SystemIdInfo(string, cursorH.getInt(iD2), cursorH.getInt(iD3));
            }
            return systemIdInfo;
        } finally {
            cursorH.close();
            roomSQLiteQueryI.m();
        }
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public void d(WorkGenerationalId workGenerationalId) {
        SystemIdInfoDao.DefaultImpls.b(this, workGenerationalId);
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public List e() {
        RoomSQLiteQuery roomSQLiteQueryI = RoomSQLiteQuery.i("SELECT DISTINCT work_spec_id FROM SystemIdInfo", 0);
        this.f54987a.assertNotSuspendingTransaction();
        Cursor cursorH = DBUtil.h(this.f54987a, roomSQLiteQueryI, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorH.getCount());
            while (cursorH.moveToNext()) {
                arrayList.add(cursorH.isNull(0) ? null : cursorH.getString(0));
            }
            return arrayList;
        } finally {
            cursorH.close();
            roomSQLiteQueryI.m();
        }
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public void f(SystemIdInfo systemIdInfo) {
        this.f54987a.assertNotSuspendingTransaction();
        this.f54987a.beginTransaction();
        try {
            this.f54988b.insert(systemIdInfo);
            this.f54987a.setTransactionSuccessful();
        } finally {
            this.f54987a.endTransaction();
        }
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public void g(String str, int i3) {
        this.f54987a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f54989c.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.D(1);
        } else {
            supportSQLiteStatementAcquire.s1(1, str);
        }
        supportSQLiteStatementAcquire.A(2, i3);
        this.f54987a.beginTransaction();
        try {
            supportSQLiteStatementAcquire.X();
            this.f54987a.setTransactionSuccessful();
        } finally {
            this.f54987a.endTransaction();
            this.f54989c.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public void i(String str) {
        this.f54987a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f54990d.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.D(1);
        } else {
            supportSQLiteStatementAcquire.s1(1, str);
        }
        this.f54987a.beginTransaction();
        try {
            supportSQLiteStatementAcquire.X();
            this.f54987a.setTransactionSuccessful();
        } finally {
            this.f54987a.endTransaction();
            this.f54990d.release(supportSQLiteStatementAcquire);
        }
    }
}
