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
public final class DependencyDao_Impl implements DependencyDao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f54969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertionAdapter f54970b;

    public DependencyDao_Impl(RoomDatabase roomDatabase) {
        this.f54969a = roomDatabase;
        this.f54970b = new EntityInsertionAdapter<Dependency>(roomDatabase) { // from class: androidx.work.impl.model.DependencyDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, Dependency dependency) {
                if (dependency.b() == null) {
                    supportSQLiteStatement.D(1);
                } else {
                    supportSQLiteStatement.s1(1, dependency.b());
                }
                if (dependency.a() == null) {
                    supportSQLiteStatement.D(2);
                } else {
                    supportSQLiteStatement.s1(2, dependency.a());
                }
            }
        };
    }

    public static List e() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.work.impl.model.DependencyDao
    public void a(Dependency dependency) {
        this.f54969a.assertNotSuspendingTransaction();
        this.f54969a.beginTransaction();
        try {
            this.f54970b.insert(dependency);
            this.f54969a.setTransactionSuccessful();
        } finally {
            this.f54969a.endTransaction();
        }
    }

    @Override // androidx.work.impl.model.DependencyDao
    public List b(String str) {
        RoomSQLiteQuery roomSQLiteQueryI = RoomSQLiteQuery.i("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            roomSQLiteQueryI.D(1);
        } else {
            roomSQLiteQueryI.s1(1, str);
        }
        this.f54969a.assertNotSuspendingTransaction();
        Cursor cursorH = DBUtil.h(this.f54969a, roomSQLiteQueryI, false, null);
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

    @Override // androidx.work.impl.model.DependencyDao
    public boolean c(String str) {
        RoomSQLiteQuery roomSQLiteQueryI = RoomSQLiteQuery.i("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", 1);
        if (str == null) {
            roomSQLiteQueryI.D(1);
        } else {
            roomSQLiteQueryI.s1(1, str);
        }
        this.f54969a.assertNotSuspendingTransaction();
        boolean z2 = false;
        Cursor cursorH = DBUtil.h(this.f54969a, roomSQLiteQueryI, false, null);
        try {
            if (cursorH.moveToFirst()) {
                z2 = cursorH.getInt(0) != 0;
            }
            return z2;
        } finally {
            cursorH.close();
            roomSQLiteQueryI.m();
        }
    }

    @Override // androidx.work.impl.model.DependencyDao
    public boolean d(String str) {
        RoomSQLiteQuery roomSQLiteQueryI = RoomSQLiteQuery.i("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            roomSQLiteQueryI.D(1);
        } else {
            roomSQLiteQueryI.s1(1, str);
        }
        this.f54969a.assertNotSuspendingTransaction();
        boolean z2 = false;
        Cursor cursorH = DBUtil.h(this.f54969a, roomSQLiteQueryI, false, null);
        try {
            if (cursorH.moveToFirst()) {
                z2 = cursorH.getInt(0) != 0;
            }
            return z2;
        } finally {
            cursorH.close();
            roomSQLiteQueryI.m();
        }
    }
}
