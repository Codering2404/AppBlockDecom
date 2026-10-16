package androidx.work.impl.model;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.Data;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class WorkProgressDao_Impl implements WorkProgressDao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f55003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertionAdapter f55004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SharedSQLiteStatement f55005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SharedSQLiteStatement f55006d;

    public WorkProgressDao_Impl(RoomDatabase roomDatabase) {
        this.f55003a = roomDatabase;
        this.f55004b = new EntityInsertionAdapter<WorkProgress>(roomDatabase) { // from class: androidx.work.impl.model.WorkProgressDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, WorkProgress workProgress) throws Throwable {
                if (workProgress.b() == null) {
                    supportSQLiteStatement.D(1);
                } else {
                    supportSQLiteStatement.s1(1, workProgress.b());
                }
                byte[] bArrL = Data.l(workProgress.a());
                if (bArrL == null) {
                    supportSQLiteStatement.D(2);
                } else {
                    supportSQLiteStatement.B(2, bArrL);
                }
            }
        };
        this.f55005c = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkProgressDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE from WorkProgress where work_spec_id=?";
            }
        };
        this.f55006d = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkProgressDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM WorkProgress";
            }
        };
    }

    public static List a() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.work.impl.model.WorkProgressDao
    public void b() {
        this.f55003a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f55006d.acquire();
        this.f55003a.beginTransaction();
        try {
            supportSQLiteStatementAcquire.X();
            this.f55003a.setTransactionSuccessful();
        } finally {
            this.f55003a.endTransaction();
            this.f55006d.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkProgressDao
    public void c(String str) {
        this.f55003a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f55005c.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.D(1);
        } else {
            supportSQLiteStatementAcquire.s1(1, str);
        }
        this.f55003a.beginTransaction();
        try {
            supportSQLiteStatementAcquire.X();
            this.f55003a.setTransactionSuccessful();
        } finally {
            this.f55003a.endTransaction();
            this.f55005c.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkProgressDao
    public void d(WorkProgress workProgress) {
        this.f55003a.assertNotSuspendingTransaction();
        this.f55003a.beginTransaction();
        try {
            this.f55004b.insert(workProgress);
            this.f55003a.setTransactionSuccessful();
        } finally {
            this.f55003a.endTransaction();
        }
    }
}
