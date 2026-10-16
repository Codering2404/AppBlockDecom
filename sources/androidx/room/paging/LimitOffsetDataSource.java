package androidx.room.paging;

import android.database.Cursor;
import androidx.paging.PositionalDataSource;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.SQLiteStatement;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class LimitOffsetDataSource<T> extends PositionalDataSource<T> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final RoomSQLiteQuery f52700g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f52701h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f52702i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final RoomDatabase f52703j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final InvalidationTracker.Observer f52704k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f52705l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final AtomicBoolean f52706m;

    /* JADX INFO: renamed from: androidx.room.paging.LimitOffsetDataSource$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends InvalidationTracker.Observer {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ LimitOffsetDataSource f52707b;

        @Override // androidx.room.InvalidationTracker.Observer
        public void c(Set set) {
            this.f52707b.d();
        }
    }

    private RoomSQLiteQuery t(int i3, int i4) {
        RoomSQLiteQuery roomSQLiteQueryI = RoomSQLiteQuery.i(this.f52702i, this.f52700g.a() + 2);
        roomSQLiteQueryI.k(this.f52700g);
        roomSQLiteQueryI.A(roomSQLiteQueryI.a() - 1, i4);
        roomSQLiteQueryI.A(roomSQLiteQueryI.a(), i3);
        return roomSQLiteQueryI;
    }

    private void v() {
        if (this.f52706m.compareAndSet(false, true)) {
            this.f52703j.getInvalidationTracker().m(this.f52704k);
        }
    }

    @Override // androidx.paging.DataSource
    public boolean e() {
        v();
        this.f52703j.getInvalidationTracker().D();
        return super.e();
    }

    @Override // androidx.paging.PositionalDataSource
    public void l(PositionalDataSource.LoadInitialParams loadInitialParams, PositionalDataSource.LoadInitialCallback loadInitialCallback) throws Throwable {
        RoomSQLiteQuery roomSQLiteQueryT;
        int i3;
        RoomSQLiteQuery roomSQLiteQuery;
        v();
        List list = Collections.EMPTY_LIST;
        this.f52703j.beginTransaction();
        Cursor cursorQuery = null;
        try {
            int iS = s();
            if (iS != 0) {
                int i4 = PositionalDataSource.i(loadInitialParams, iS);
                roomSQLiteQueryT = t(i4, PositionalDataSource.j(loadInitialParams, i4, iS));
                try {
                    cursorQuery = this.f52703j.query(roomSQLiteQueryT);
                    List listQ = q(cursorQuery);
                    this.f52703j.setTransactionSuccessful();
                    roomSQLiteQuery = roomSQLiteQueryT;
                    i3 = i4;
                    list = listQ;
                } catch (Throwable th) {
                    th = th;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    this.f52703j.endTransaction();
                    if (roomSQLiteQueryT != null) {
                        roomSQLiteQueryT.m();
                    }
                    throw th;
                }
            } else {
                i3 = 0;
                roomSQLiteQuery = null;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            this.f52703j.endTransaction();
            if (roomSQLiteQuery != null) {
                roomSQLiteQuery.m();
            }
            loadInitialCallback.a(list, i3, iS);
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQueryT = null;
        }
    }

    @Override // androidx.paging.PositionalDataSource
    public void o(PositionalDataSource.LoadRangeParams loadRangeParams, PositionalDataSource.LoadRangeCallback loadRangeCallback) {
        loadRangeCallback.a(u(loadRangeParams.f50518a, loadRangeParams.f50519b));
    }

    protected List q(Cursor cursor) {
        return r(new CursorSQLiteStatement(cursor));
    }

    protected List r(SQLiteStatement sQLiteStatement) {
        throw new UnsupportedOperationException("Unexpected call to a function with no implementation that Room is supposed to generate. Please file a bug at: https://issuetracker.google.com/issues/new?component=413107&template=1096568.");
    }

    public int s() {
        v();
        RoomSQLiteQuery roomSQLiteQueryI = RoomSQLiteQuery.i(this.f52701h, this.f52700g.a());
        roomSQLiteQueryI.k(this.f52700g);
        Cursor cursorQuery = this.f52703j.query(roomSQLiteQueryI);
        try {
            if (cursorQuery.moveToFirst()) {
                return cursorQuery.getInt(0);
            }
            return 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryI.m();
        }
    }

    public List u(int i3, int i4) {
        RoomSQLiteQuery roomSQLiteQueryT = t(i3, i4);
        if (!this.f52705l) {
            Cursor cursorQuery = this.f52703j.query(roomSQLiteQueryT);
            try {
                return q(cursorQuery);
            } finally {
                cursorQuery.close();
                roomSQLiteQueryT.m();
            }
        }
        this.f52703j.beginTransaction();
        Cursor cursorQuery2 = null;
        try {
            cursorQuery2 = this.f52703j.query(roomSQLiteQueryT);
            List listQ = q(cursorQuery2);
            this.f52703j.setTransactionSuccessful();
            return listQ;
        } finally {
            if (cursorQuery2 != null) {
                cursorQuery2.close();
            }
            this.f52703j.endTransaction();
            roomSQLiteQueryT.m();
        }
    }
}
