package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class PreferenceDao_Impl implements PreferenceDao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f54974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertionAdapter f54975b;

    /* JADX INFO: renamed from: androidx.work.impl.model.PreferenceDao_Impl$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 implements Callable<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f54977a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ PreferenceDao_Impl f54978b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long call() {
            Long lValueOf = null;
            Cursor cursorH = DBUtil.h(this.f54978b.f54974a, this.f54977a, false, null);
            try {
                if (cursorH.moveToFirst() && !cursorH.isNull(0)) {
                    lValueOf = Long.valueOf(cursorH.getLong(0));
                }
                return lValueOf;
            } finally {
                cursorH.close();
            }
        }

        protected void finalize() {
            this.f54977a.m();
        }
    }

    public PreferenceDao_Impl(RoomDatabase roomDatabase) {
        this.f54974a = roomDatabase;
        this.f54975b = new EntityInsertionAdapter<Preference>(roomDatabase) { // from class: androidx.work.impl.model.PreferenceDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, Preference preference) {
                if (preference.a() == null) {
                    supportSQLiteStatement.D(1);
                } else {
                    supportSQLiteStatement.s1(1, preference.a());
                }
                if (preference.b() == null) {
                    supportSQLiteStatement.D(2);
                } else {
                    supportSQLiteStatement.A(2, preference.b().longValue());
                }
            }
        };
    }

    public static List d() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.work.impl.model.PreferenceDao
    public void a(Preference preference) {
        this.f54974a.assertNotSuspendingTransaction();
        this.f54974a.beginTransaction();
        try {
            this.f54975b.insert(preference);
            this.f54974a.setTransactionSuccessful();
        } finally {
            this.f54974a.endTransaction();
        }
    }

    @Override // androidx.work.impl.model.PreferenceDao
    public Long b(String str) {
        RoomSQLiteQuery roomSQLiteQueryI = RoomSQLiteQuery.i("SELECT long_value FROM Preference where `key`=?", 1);
        if (str == null) {
            roomSQLiteQueryI.D(1);
        } else {
            roomSQLiteQueryI.s1(1, str);
        }
        this.f54974a.assertNotSuspendingTransaction();
        Long lValueOf = null;
        Cursor cursorH = DBUtil.h(this.f54974a, roomSQLiteQueryI, false, null);
        try {
            if (cursorH.moveToFirst() && !cursorH.isNull(0)) {
                lValueOf = Long.valueOf(cursorH.getLong(0));
            }
            return lValueOf;
        } finally {
            cursorH.close();
            roomSQLiteQueryI.m();
        }
    }
}
