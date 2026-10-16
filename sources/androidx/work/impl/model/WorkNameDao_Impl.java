package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class WorkNameDao_Impl implements WorkNameDao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f54998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertionAdapter f54999b;

    public WorkNameDao_Impl(RoomDatabase roomDatabase) {
        this.f54998a = roomDatabase;
        this.f54999b = new EntityInsertionAdapter<WorkName>(roomDatabase) { // from class: androidx.work.impl.model.WorkNameDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, WorkName workName) {
                if (workName.a() == null) {
                    supportSQLiteStatement.D(1);
                } else {
                    supportSQLiteStatement.s1(1, workName.a());
                }
                if (workName.b() == null) {
                    supportSQLiteStatement.D(2);
                } else {
                    supportSQLiteStatement.s1(2, workName.b());
                }
            }
        };
    }

    public static List c() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.work.impl.model.WorkNameDao
    public void a(WorkName workName) {
        this.f54998a.assertNotSuspendingTransaction();
        this.f54998a.beginTransaction();
        try {
            this.f54999b.insert(workName);
            this.f54998a.setTransactionSuccessful();
        } finally {
            this.f54998a.endTransaction();
        }
    }

    @Override // androidx.work.impl.model.WorkNameDao
    public List b(String str) {
        RoomSQLiteQuery roomSQLiteQueryI = RoomSQLiteQuery.i("SELECT name FROM workname WHERE work_spec_id=?", 1);
        if (str == null) {
            roomSQLiteQueryI.D(1);
        } else {
            roomSQLiteQueryI.s1(1, str);
        }
        this.f54998a.assertNotSuspendingTransaction();
        Cursor cursorH = DBUtil.h(this.f54998a, roomSQLiteQueryI, false, null);
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
}
