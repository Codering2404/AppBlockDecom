package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.impl.model.WorkTagDao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class WorkTagDao_Impl implements WorkTagDao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f55118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertionAdapter f55119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SharedSQLiteStatement f55120c;

    public WorkTagDao_Impl(RoomDatabase roomDatabase) {
        this.f55118a = roomDatabase;
        this.f55119b = new EntityInsertionAdapter<WorkTag>(roomDatabase) { // from class: androidx.work.impl.model.WorkTagDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, WorkTag workTag) {
                if (workTag.a() == null) {
                    supportSQLiteStatement.D(1);
                } else {
                    supportSQLiteStatement.s1(1, workTag.a());
                }
                if (workTag.b() == null) {
                    supportSQLiteStatement.D(2);
                } else {
                    supportSQLiteStatement.s1(2, workTag.b());
                }
            }
        };
        this.f55120c = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkTagDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM worktag WHERE work_spec_id=?";
            }
        };
    }

    public static List f() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.work.impl.model.WorkTagDao
    public List a(String str) {
        RoomSQLiteQuery roomSQLiteQueryI = RoomSQLiteQuery.i("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", 1);
        if (str == null) {
            roomSQLiteQueryI.D(1);
        } else {
            roomSQLiteQueryI.s1(1, str);
        }
        this.f55118a.assertNotSuspendingTransaction();
        Cursor cursorH = DBUtil.h(this.f55118a, roomSQLiteQueryI, false, null);
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

    @Override // androidx.work.impl.model.WorkTagDao
    public void b(String str) {
        this.f55118a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f55120c.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.D(1);
        } else {
            supportSQLiteStatementAcquire.s1(1, str);
        }
        this.f55118a.beginTransaction();
        try {
            supportSQLiteStatementAcquire.X();
            this.f55118a.setTransactionSuccessful();
        } finally {
            this.f55118a.endTransaction();
            this.f55120c.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkTagDao
    public void c(WorkTag workTag) {
        this.f55118a.assertNotSuspendingTransaction();
        this.f55118a.beginTransaction();
        try {
            this.f55119b.insert(workTag);
            this.f55118a.setTransactionSuccessful();
        } finally {
            this.f55118a.endTransaction();
        }
    }

    @Override // androidx.work.impl.model.WorkTagDao
    public void e(String str, Set set) {
        WorkTagDao.DefaultImpls.a(this, str, set);
    }
}
