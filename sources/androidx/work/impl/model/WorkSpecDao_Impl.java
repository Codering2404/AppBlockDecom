package androidx.work.impl.model;

import android.database.Cursor;
import androidx.glance.session.ecY.lisODU;
import androidx.lifecycle.LiveData;
import androidx.media3.extractor.jpeg.xWt.jTYhJgqLBN;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import coil.target.Yb.oUcQRqOVfOC;
import com.facebook.internal.ServerProtocol;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class WorkSpecDao_Impl implements WorkSpecDao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f55065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertionAdapter f55066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EntityDeletionOrUpdateAdapter f55067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SharedSQLiteStatement f55068d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final SharedSQLiteStatement f55069e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final SharedSQLiteStatement f55070f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final SharedSQLiteStatement f55071g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final SharedSQLiteStatement f55072h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final SharedSQLiteStatement f55073i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final SharedSQLiteStatement f55074j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final SharedSQLiteStatement f55075k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final SharedSQLiteStatement f55076l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final SharedSQLiteStatement f55077m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final SharedSQLiteStatement f55078n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final SharedSQLiteStatement f55079o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final SharedSQLiteStatement f55080p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final SharedSQLiteStatement f55081q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final SharedSQLiteStatement f55082r;

    /* JADX INFO: renamed from: androidx.work.impl.model.WorkSpecDao_Impl$18, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass18 implements Callable<List<String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f55092a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ WorkSpecDao_Impl f55093b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            this.f55093b.f55065a.beginTransaction();
            try {
                Cursor cursorH = DBUtil.h(this.f55093b.f55065a, this.f55092a, false, null);
                try {
                    ArrayList arrayList = new ArrayList(cursorH.getCount());
                    while (cursorH.moveToNext()) {
                        arrayList.add(cursorH.isNull(0) ? null : cursorH.getString(0));
                    }
                    this.f55093b.f55065a.setTransactionSuccessful();
                    cursorH.close();
                    return arrayList;
                } catch (Throwable th) {
                    cursorH.close();
                    throw th;
                }
            } finally {
                this.f55093b.f55065a.endTransaction();
            }
        }

        protected void finalize() {
            this.f55092a.m();
        }
    }

    /* JADX INFO: renamed from: androidx.work.impl.model.WorkSpecDao_Impl$20, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass20 implements Callable<List<WorkSpec.WorkInfoPojo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f55097a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ WorkSpecDao_Impl f55098b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            this.f55098b.f55065a.beginTransaction();
            try {
                Cursor cursorH = DBUtil.h(this.f55098b.f55065a, this.f55097a, true, null);
                try {
                    HashMap map = new HashMap();
                    HashMap map2 = new HashMap();
                    while (cursorH.moveToNext()) {
                        String string = cursorH.getString(0);
                        if (((ArrayList) map.get(string)) == null) {
                            map.put(string, new ArrayList());
                        }
                        String string2 = cursorH.getString(0);
                        if (((ArrayList) map2.get(string2)) == null) {
                            map2.put(string2, new ArrayList());
                        }
                    }
                    cursorH.moveToPosition(-1);
                    this.f55098b.K(map);
                    this.f55098b.J(map2);
                    ArrayList arrayList = new ArrayList(cursorH.getCount());
                    while (cursorH.moveToNext()) {
                        String string3 = cursorH.isNull(0) ? null : cursorH.getString(0);
                        WorkInfo.State stateF = WorkTypeConverters.f(cursorH.getInt(1));
                        Data dataG = Data.g(cursorH.isNull(2) ? null : cursorH.getBlob(2));
                        int i3 = cursorH.getInt(3);
                        int i4 = cursorH.getInt(4);
                        long j3 = cursorH.getLong(13);
                        long j4 = cursorH.getLong(14);
                        long j5 = cursorH.getLong(15);
                        BackoffPolicy backoffPolicyC = WorkTypeConverters.c(cursorH.getInt(16));
                        long j6 = cursorH.getLong(17);
                        long j7 = cursorH.getLong(18);
                        int i5 = cursorH.getInt(19);
                        long j8 = cursorH.getLong(20);
                        int i6 = cursorH.getInt(21);
                        Constraints constraints = new Constraints(WorkTypeConverters.d(cursorH.getInt(5)), cursorH.getInt(6) != 0, cursorH.getInt(7) != 0, cursorH.getInt(8) != 0, cursorH.getInt(9) != 0, cursorH.getLong(10), cursorH.getLong(11), WorkTypeConverters.b(cursorH.isNull(12) ? null : cursorH.getBlob(12)));
                        ArrayList arrayList2 = (ArrayList) map.get(cursorH.getString(0));
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        ArrayList arrayList3 = (ArrayList) map2.get(cursorH.getString(0));
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        arrayList.add(new WorkSpec.WorkInfoPojo(string3, stateF, dataG, j3, j4, j5, constraints, i3, backoffPolicyC, j6, j7, i5, i4, j8, i6, arrayList2, arrayList3));
                    }
                    this.f55098b.f55065a.setTransactionSuccessful();
                    cursorH.close();
                    return arrayList;
                } catch (Throwable th) {
                    cursorH.close();
                    throw th;
                }
            } finally {
                this.f55098b.f55065a.endTransaction();
            }
        }

        protected void finalize() {
            this.f55097a.m();
        }
    }

    /* JADX INFO: renamed from: androidx.work.impl.model.WorkSpecDao_Impl$21, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass21 implements Callable<List<WorkSpec.WorkInfoPojo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f55099a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ WorkSpecDao_Impl f55100b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            this.f55100b.f55065a.beginTransaction();
            try {
                Cursor cursorH = DBUtil.h(this.f55100b.f55065a, this.f55099a, true, null);
                try {
                    HashMap map = new HashMap();
                    HashMap map2 = new HashMap();
                    while (cursorH.moveToNext()) {
                        String string = cursorH.getString(0);
                        if (((ArrayList) map.get(string)) == null) {
                            map.put(string, new ArrayList());
                        }
                        String string2 = cursorH.getString(0);
                        if (((ArrayList) map2.get(string2)) == null) {
                            map2.put(string2, new ArrayList());
                        }
                    }
                    cursorH.moveToPosition(-1);
                    this.f55100b.K(map);
                    this.f55100b.J(map2);
                    ArrayList arrayList = new ArrayList(cursorH.getCount());
                    while (cursorH.moveToNext()) {
                        String string3 = cursorH.isNull(0) ? null : cursorH.getString(0);
                        WorkInfo.State stateF = WorkTypeConverters.f(cursorH.getInt(1));
                        Data dataG = Data.g(cursorH.isNull(2) ? null : cursorH.getBlob(2));
                        int i3 = cursorH.getInt(3);
                        int i4 = cursorH.getInt(4);
                        long j3 = cursorH.getLong(13);
                        long j4 = cursorH.getLong(14);
                        long j5 = cursorH.getLong(15);
                        BackoffPolicy backoffPolicyC = WorkTypeConverters.c(cursorH.getInt(16));
                        long j6 = cursorH.getLong(17);
                        long j7 = cursorH.getLong(18);
                        int i5 = cursorH.getInt(19);
                        long j8 = cursorH.getLong(20);
                        int i6 = cursorH.getInt(21);
                        Constraints constraints = new Constraints(WorkTypeConverters.d(cursorH.getInt(5)), cursorH.getInt(6) != 0, cursorH.getInt(7) != 0, cursorH.getInt(8) != 0, cursorH.getInt(9) != 0, cursorH.getLong(10), cursorH.getLong(11), WorkTypeConverters.b(cursorH.isNull(12) ? null : cursorH.getBlob(12)));
                        ArrayList arrayList2 = (ArrayList) map.get(cursorH.getString(0));
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        ArrayList arrayList3 = (ArrayList) map2.get(cursorH.getString(0));
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        arrayList.add(new WorkSpec.WorkInfoPojo(string3, stateF, dataG, j3, j4, j5, constraints, i3, backoffPolicyC, j6, j7, i5, i4, j8, i6, arrayList2, arrayList3));
                    }
                    this.f55100b.f55065a.setTransactionSuccessful();
                    cursorH.close();
                    return arrayList;
                } catch (Throwable th) {
                    cursorH.close();
                    throw th;
                }
            } finally {
                this.f55100b.f55065a.endTransaction();
            }
        }

        protected void finalize() {
            this.f55099a.m();
        }
    }

    /* JADX INFO: renamed from: androidx.work.impl.model.WorkSpecDao_Impl$22, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass22 implements Callable<List<WorkSpec.WorkInfoPojo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f55101a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ WorkSpecDao_Impl f55102b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            this.f55102b.f55065a.beginTransaction();
            try {
                Cursor cursorH = DBUtil.h(this.f55102b.f55065a, this.f55101a, true, null);
                try {
                    HashMap map = new HashMap();
                    HashMap map2 = new HashMap();
                    while (cursorH.moveToNext()) {
                        String string = cursorH.getString(0);
                        if (((ArrayList) map.get(string)) == null) {
                            map.put(string, new ArrayList());
                        }
                        String string2 = cursorH.getString(0);
                        if (((ArrayList) map2.get(string2)) == null) {
                            map2.put(string2, new ArrayList());
                        }
                    }
                    cursorH.moveToPosition(-1);
                    this.f55102b.K(map);
                    this.f55102b.J(map2);
                    ArrayList arrayList = new ArrayList(cursorH.getCount());
                    while (cursorH.moveToNext()) {
                        String string3 = cursorH.isNull(0) ? null : cursorH.getString(0);
                        WorkInfo.State stateF = WorkTypeConverters.f(cursorH.getInt(1));
                        Data dataG = Data.g(cursorH.isNull(2) ? null : cursorH.getBlob(2));
                        int i3 = cursorH.getInt(3);
                        int i4 = cursorH.getInt(4);
                        long j3 = cursorH.getLong(13);
                        long j4 = cursorH.getLong(14);
                        long j5 = cursorH.getLong(15);
                        BackoffPolicy backoffPolicyC = WorkTypeConverters.c(cursorH.getInt(16));
                        long j6 = cursorH.getLong(17);
                        long j7 = cursorH.getLong(18);
                        int i5 = cursorH.getInt(19);
                        long j8 = cursorH.getLong(20);
                        int i6 = cursorH.getInt(21);
                        Constraints constraints = new Constraints(WorkTypeConverters.d(cursorH.getInt(5)), cursorH.getInt(6) != 0, cursorH.getInt(7) != 0, cursorH.getInt(8) != 0, cursorH.getInt(9) != 0, cursorH.getLong(10), cursorH.getLong(11), WorkTypeConverters.b(cursorH.isNull(12) ? null : cursorH.getBlob(12)));
                        ArrayList arrayList2 = (ArrayList) map.get(cursorH.getString(0));
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        ArrayList arrayList3 = (ArrayList) map2.get(cursorH.getString(0));
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        arrayList.add(new WorkSpec.WorkInfoPojo(string3, stateF, dataG, j3, j4, j5, constraints, i3, backoffPolicyC, j6, j7, i5, i4, j8, i6, arrayList2, arrayList3));
                    }
                    this.f55102b.f55065a.setTransactionSuccessful();
                    cursorH.close();
                    return arrayList;
                } catch (Throwable th) {
                    cursorH.close();
                    throw th;
                }
            } finally {
                this.f55102b.f55065a.endTransaction();
            }
        }

        protected void finalize() {
            this.f55101a.m();
        }
    }

    /* JADX INFO: renamed from: androidx.work.impl.model.WorkSpecDao_Impl$23, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass23 implements Callable<List<WorkSpec.WorkInfoPojo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f55103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ WorkSpecDao_Impl f55104b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            this.f55104b.f55065a.beginTransaction();
            try {
                Cursor cursorH = DBUtil.h(this.f55104b.f55065a, this.f55103a, true, null);
                try {
                    HashMap map = new HashMap();
                    HashMap map2 = new HashMap();
                    while (cursorH.moveToNext()) {
                        String string = cursorH.getString(0);
                        if (((ArrayList) map.get(string)) == null) {
                            map.put(string, new ArrayList());
                        }
                        String string2 = cursorH.getString(0);
                        if (((ArrayList) map2.get(string2)) == null) {
                            map2.put(string2, new ArrayList());
                        }
                    }
                    cursorH.moveToPosition(-1);
                    this.f55104b.K(map);
                    this.f55104b.J(map2);
                    ArrayList arrayList = new ArrayList(cursorH.getCount());
                    while (cursorH.moveToNext()) {
                        String string3 = cursorH.isNull(0) ? null : cursorH.getString(0);
                        WorkInfo.State stateF = WorkTypeConverters.f(cursorH.getInt(1));
                        Data dataG = Data.g(cursorH.isNull(2) ? null : cursorH.getBlob(2));
                        int i3 = cursorH.getInt(3);
                        int i4 = cursorH.getInt(4);
                        long j3 = cursorH.getLong(13);
                        long j4 = cursorH.getLong(14);
                        long j5 = cursorH.getLong(15);
                        BackoffPolicy backoffPolicyC = WorkTypeConverters.c(cursorH.getInt(16));
                        long j6 = cursorH.getLong(17);
                        long j7 = cursorH.getLong(18);
                        int i5 = cursorH.getInt(19);
                        long j8 = cursorH.getLong(20);
                        int i6 = cursorH.getInt(21);
                        Constraints constraints = new Constraints(WorkTypeConverters.d(cursorH.getInt(5)), cursorH.getInt(6) != 0, cursorH.getInt(7) != 0, cursorH.getInt(8) != 0, cursorH.getInt(9) != 0, cursorH.getLong(10), cursorH.getLong(11), WorkTypeConverters.b(cursorH.isNull(12) ? null : cursorH.getBlob(12)));
                        ArrayList arrayList2 = (ArrayList) map.get(cursorH.getString(0));
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        ArrayList arrayList3 = (ArrayList) map2.get(cursorH.getString(0));
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        arrayList.add(new WorkSpec.WorkInfoPojo(string3, stateF, dataG, j3, j4, j5, constraints, i3, backoffPolicyC, j6, j7, i5, i4, j8, i6, arrayList2, arrayList3));
                    }
                    this.f55104b.f55065a.setTransactionSuccessful();
                    cursorH.close();
                    return arrayList;
                } catch (Throwable th) {
                    cursorH.close();
                    throw th;
                }
            } finally {
                this.f55104b.f55065a.endTransaction();
            }
        }

        protected void finalize() {
            this.f55103a.m();
        }
    }

    /* JADX INFO: renamed from: androidx.work.impl.model.WorkSpecDao_Impl$24, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass24 implements Callable<List<WorkSpec.WorkInfoPojo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f55105a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ WorkSpecDao_Impl f55106b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            this.f55106b.f55065a.beginTransaction();
            try {
                Cursor cursorH = DBUtil.h(this.f55106b.f55065a, this.f55105a, true, null);
                try {
                    HashMap map = new HashMap();
                    HashMap map2 = new HashMap();
                    while (cursorH.moveToNext()) {
                        String string = cursorH.getString(0);
                        if (((ArrayList) map.get(string)) == null) {
                            map.put(string, new ArrayList());
                        }
                        String string2 = cursorH.getString(0);
                        if (((ArrayList) map2.get(string2)) == null) {
                            map2.put(string2, new ArrayList());
                        }
                    }
                    cursorH.moveToPosition(-1);
                    this.f55106b.K(map);
                    this.f55106b.J(map2);
                    ArrayList arrayList = new ArrayList(cursorH.getCount());
                    while (cursorH.moveToNext()) {
                        String string3 = cursorH.isNull(0) ? null : cursorH.getString(0);
                        WorkInfo.State stateF = WorkTypeConverters.f(cursorH.getInt(1));
                        Data dataG = Data.g(cursorH.isNull(2) ? null : cursorH.getBlob(2));
                        int i3 = cursorH.getInt(3);
                        int i4 = cursorH.getInt(4);
                        long j3 = cursorH.getLong(13);
                        long j4 = cursorH.getLong(14);
                        long j5 = cursorH.getLong(15);
                        BackoffPolicy backoffPolicyC = WorkTypeConverters.c(cursorH.getInt(16));
                        long j6 = cursorH.getLong(17);
                        long j7 = cursorH.getLong(18);
                        int i5 = cursorH.getInt(19);
                        long j8 = cursorH.getLong(20);
                        int i6 = cursorH.getInt(21);
                        Constraints constraints = new Constraints(WorkTypeConverters.d(cursorH.getInt(5)), cursorH.getInt(6) != 0, cursorH.getInt(7) != 0, cursorH.getInt(8) != 0, cursorH.getInt(9) != 0, cursorH.getLong(10), cursorH.getLong(11), WorkTypeConverters.b(cursorH.isNull(12) ? null : cursorH.getBlob(12)));
                        ArrayList arrayList2 = (ArrayList) map.get(cursorH.getString(0));
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        ArrayList arrayList3 = (ArrayList) map2.get(cursorH.getString(0));
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        arrayList.add(new WorkSpec.WorkInfoPojo(string3, stateF, dataG, j3, j4, j5, constraints, i3, backoffPolicyC, j6, j7, i5, i4, j8, i6, arrayList2, arrayList3));
                    }
                    this.f55106b.f55065a.setTransactionSuccessful();
                    cursorH.close();
                    return arrayList;
                } catch (Throwable th) {
                    cursorH.close();
                    throw th;
                }
            } finally {
                this.f55106b.f55065a.endTransaction();
            }
        }

        protected void finalize() {
            this.f55105a.m();
        }
    }

    /* JADX INFO: renamed from: androidx.work.impl.model.WorkSpecDao_Impl$25, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass25 implements Callable<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f55107a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ WorkSpecDao_Impl f55108b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long call() {
            Cursor cursorH = DBUtil.h(this.f55108b.f55065a, this.f55107a, false, null);
            try {
                Long lValueOf = Long.valueOf(cursorH.moveToFirst() ? cursorH.getLong(0) : 0L);
                cursorH.close();
                return lValueOf;
            } catch (Throwable th) {
                cursorH.close();
                throw th;
            }
        }

        protected void finalize() {
            this.f55107a.m();
        }
    }

    public WorkSpecDao_Impl(RoomDatabase roomDatabase) {
        this.f55065a = roomDatabase;
        this.f55066b = new EntityInsertionAdapter<WorkSpec>(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`last_enqueue_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`period_count`,`generation`,`next_schedule_time_override`,`next_schedule_time_override_generation`,`stop_reason`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, WorkSpec workSpec) throws Throwable {
                String str = workSpec.f55013a;
                if (str == null) {
                    supportSQLiteStatement.D(1);
                } else {
                    supportSQLiteStatement.s1(1, str);
                }
                WorkTypeConverters workTypeConverters = WorkTypeConverters.f55123a;
                supportSQLiteStatement.A(2, WorkTypeConverters.j(workSpec.f55014b));
                String str2 = workSpec.f55015c;
                if (str2 == null) {
                    supportSQLiteStatement.D(3);
                } else {
                    supportSQLiteStatement.s1(3, str2);
                }
                String str3 = workSpec.f55016d;
                if (str3 == null) {
                    supportSQLiteStatement.D(4);
                } else {
                    supportSQLiteStatement.s1(4, str3);
                }
                byte[] bArrL = Data.l(workSpec.f55017e);
                if (bArrL == null) {
                    supportSQLiteStatement.D(5);
                } else {
                    supportSQLiteStatement.B(5, bArrL);
                }
                byte[] bArrL2 = Data.l(workSpec.f55018f);
                if (bArrL2 == null) {
                    supportSQLiteStatement.D(6);
                } else {
                    supportSQLiteStatement.B(6, bArrL2);
                }
                supportSQLiteStatement.A(7, workSpec.f55019g);
                supportSQLiteStatement.A(8, workSpec.f55020h);
                supportSQLiteStatement.A(9, workSpec.f55021i);
                supportSQLiteStatement.A(10, workSpec.f55023k);
                supportSQLiteStatement.A(11, WorkTypeConverters.a(workSpec.f55024l));
                supportSQLiteStatement.A(12, workSpec.f55025m);
                supportSQLiteStatement.A(13, workSpec.f55026n);
                supportSQLiteStatement.A(14, workSpec.f55027o);
                supportSQLiteStatement.A(15, workSpec.f55028p);
                supportSQLiteStatement.A(16, workSpec.f55029q ? 1L : 0L);
                supportSQLiteStatement.A(17, WorkTypeConverters.h(workSpec.f55030r));
                supportSQLiteStatement.A(18, workSpec.i());
                supportSQLiteStatement.A(19, workSpec.f());
                supportSQLiteStatement.A(20, workSpec.g());
                supportSQLiteStatement.A(21, workSpec.h());
                supportSQLiteStatement.A(22, workSpec.j());
                Constraints constraints = workSpec.f55022j;
                if (constraints == null) {
                    supportSQLiteStatement.D(23);
                    supportSQLiteStatement.D(24);
                    supportSQLiteStatement.D(25);
                    supportSQLiteStatement.D(26);
                    supportSQLiteStatement.D(27);
                    supportSQLiteStatement.D(28);
                    supportSQLiteStatement.D(29);
                    supportSQLiteStatement.D(30);
                    return;
                }
                supportSQLiteStatement.A(23, WorkTypeConverters.g(constraints.d()));
                supportSQLiteStatement.A(24, constraints.g() ? 1L : 0L);
                supportSQLiteStatement.A(25, constraints.h() ? 1L : 0L);
                supportSQLiteStatement.A(26, constraints.f() ? 1L : 0L);
                supportSQLiteStatement.A(27, constraints.i() ? 1L : 0L);
                supportSQLiteStatement.A(28, constraints.b());
                supportSQLiteStatement.A(29, constraints.a());
                byte[] bArrI = WorkTypeConverters.i(constraints.c());
                if (bArrI == null) {
                    supportSQLiteStatement.D(30);
                } else {
                    supportSQLiteStatement.B(30, bArrI);
                }
            }
        };
        this.f55067c = new EntityDeletionOrUpdateAdapter<WorkSpec>(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `WorkSpec` SET `id` = ?,`state` = ?,`worker_class_name` = ?,`input_merger_class_name` = ?,`input` = ?,`output` = ?,`initial_delay` = ?,`interval_duration` = ?,`flex_duration` = ?,`run_attempt_count` = ?,`backoff_policy` = ?,`backoff_delay_duration` = ?,`last_enqueue_time` = ?,`minimum_retention_duration` = ?,`schedule_requested_at` = ?,`run_in_foreground` = ?,`out_of_quota_policy` = ?,`period_count` = ?,`generation` = ?,`next_schedule_time_override` = ?,`next_schedule_time_override_generation` = ?,`stop_reason` = ?,`required_network_type` = ?,`requires_charging` = ?,`requires_device_idle` = ?,`requires_battery_not_low` = ?,`requires_storage_not_low` = ?,`trigger_content_update_delay` = ?,`trigger_max_content_delay` = ?,`content_uri_triggers` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, WorkSpec workSpec) throws Throwable {
                String str = workSpec.f55013a;
                if (str == null) {
                    supportSQLiteStatement.D(1);
                } else {
                    supportSQLiteStatement.s1(1, str);
                }
                WorkTypeConverters workTypeConverters = WorkTypeConverters.f55123a;
                supportSQLiteStatement.A(2, WorkTypeConverters.j(workSpec.f55014b));
                String str2 = workSpec.f55015c;
                if (str2 == null) {
                    supportSQLiteStatement.D(3);
                } else {
                    supportSQLiteStatement.s1(3, str2);
                }
                String str3 = workSpec.f55016d;
                if (str3 == null) {
                    supportSQLiteStatement.D(4);
                } else {
                    supportSQLiteStatement.s1(4, str3);
                }
                byte[] bArrL = Data.l(workSpec.f55017e);
                if (bArrL == null) {
                    supportSQLiteStatement.D(5);
                } else {
                    supportSQLiteStatement.B(5, bArrL);
                }
                byte[] bArrL2 = Data.l(workSpec.f55018f);
                if (bArrL2 == null) {
                    supportSQLiteStatement.D(6);
                } else {
                    supportSQLiteStatement.B(6, bArrL2);
                }
                supportSQLiteStatement.A(7, workSpec.f55019g);
                supportSQLiteStatement.A(8, workSpec.f55020h);
                supportSQLiteStatement.A(9, workSpec.f55021i);
                supportSQLiteStatement.A(10, workSpec.f55023k);
                supportSQLiteStatement.A(11, WorkTypeConverters.a(workSpec.f55024l));
                supportSQLiteStatement.A(12, workSpec.f55025m);
                supportSQLiteStatement.A(13, workSpec.f55026n);
                supportSQLiteStatement.A(14, workSpec.f55027o);
                supportSQLiteStatement.A(15, workSpec.f55028p);
                supportSQLiteStatement.A(16, workSpec.f55029q ? 1L : 0L);
                supportSQLiteStatement.A(17, WorkTypeConverters.h(workSpec.f55030r));
                supportSQLiteStatement.A(18, workSpec.i());
                supportSQLiteStatement.A(19, workSpec.f());
                supportSQLiteStatement.A(20, workSpec.g());
                supportSQLiteStatement.A(21, workSpec.h());
                supportSQLiteStatement.A(22, workSpec.j());
                Constraints constraints = workSpec.f55022j;
                if (constraints != null) {
                    supportSQLiteStatement.A(23, WorkTypeConverters.g(constraints.d()));
                    supportSQLiteStatement.A(24, constraints.g() ? 1L : 0L);
                    supportSQLiteStatement.A(25, constraints.h() ? 1L : 0L);
                    supportSQLiteStatement.A(26, constraints.f() ? 1L : 0L);
                    supportSQLiteStatement.A(27, constraints.i() ? 1L : 0L);
                    supportSQLiteStatement.A(28, constraints.b());
                    supportSQLiteStatement.A(29, constraints.a());
                    byte[] bArrI = WorkTypeConverters.i(constraints.c());
                    if (bArrI == null) {
                        supportSQLiteStatement.D(30);
                    } else {
                        supportSQLiteStatement.B(30, bArrI);
                    }
                } else {
                    supportSQLiteStatement.D(23);
                    supportSQLiteStatement.D(24);
                    supportSQLiteStatement.D(25);
                    supportSQLiteStatement.D(26);
                    supportSQLiteStatement.D(27);
                    supportSQLiteStatement.D(28);
                    supportSQLiteStatement.D(29);
                    supportSQLiteStatement.D(30);
                }
                String str4 = workSpec.f55013a;
                if (str4 == null) {
                    supportSQLiteStatement.D(31);
                } else {
                    supportSQLiteStatement.s1(31, str4);
                }
            }
        };
        this.f55068d = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM workspec WHERE id=?";
            }
        };
        this.f55069e = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET state=? WHERE id=?";
            }
        };
        this.f55070f = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET stop_reason = CASE WHEN state=1 THEN 1 ELSE -256 END, state=5 WHERE id=?";
            }
        };
        this.f55071g = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.6
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET period_count=period_count+1 WHERE id=?";
            }
        };
        this.f55072h = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.7
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET output=? WHERE id=?";
            }
        };
        this.f55073i = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.8
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET last_enqueue_time=? WHERE id=?";
            }
        };
        this.f55074j = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.9
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
            }
        };
        this.f55075k = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.10
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
            }
        };
        this.f55076l = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.11
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET next_schedule_time_override=? WHERE id=?";
            }
        };
        this.f55077m = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.12
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET next_schedule_time_override=9223372036854775807 WHERE (id=? AND next_schedule_time_override_generation=?)";
            }
        };
        this.f55078n = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.13
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
            }
        };
        this.f55079o = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.14
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
            }
        };
        this.f55080p = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.15
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
            }
        };
        this.f55081q = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.16
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET generation=generation+1 WHERE id=?";
            }
        };
        this.f55082r = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.17
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET stop_reason=? WHERE id=?";
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(HashMap map) {
        int i3;
        Set<String> setKeySet = map.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (map.size() > 999) {
            HashMap map2 = new HashMap(999);
            loop0: while (true) {
                i3 = 0;
                for (String str : setKeySet) {
                    map2.put(str, (ArrayList) map.get(str));
                    i3++;
                    if (i3 == 999) {
                        break;
                    }
                }
                J(map2);
                map2 = new HashMap(999);
            }
            if (i3 > 0) {
                J(map2);
                return;
            }
            return;
        }
        StringBuilder sbB = StringUtil.b();
        sbB.append("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
        int size = setKeySet.size();
        StringUtil.a(sbB, size);
        sbB.append(")");
        RoomSQLiteQuery roomSQLiteQueryI = RoomSQLiteQuery.i(sbB.toString(), size);
        int i4 = 1;
        for (String str2 : setKeySet) {
            if (str2 == null) {
                roomSQLiteQueryI.D(i4);
            } else {
                roomSQLiteQueryI.s1(i4, str2);
            }
            i4++;
        }
        Cursor cursorH = DBUtil.h(this.f55065a, roomSQLiteQueryI, false, null);
        try {
            int iC = CursorUtil.c(cursorH, "work_spec_id");
            if (iC == -1) {
                return;
            }
            while (cursorH.moveToNext()) {
                ArrayList arrayList = (ArrayList) map.get(cursorH.getString(iC));
                if (arrayList != null) {
                    arrayList.add(Data.g(cursorH.isNull(0) ? null : cursorH.getBlob(0)));
                }
            }
        } finally {
            cursorH.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(HashMap map) {
        int i3;
        Set<String> setKeySet = map.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (map.size() > 999) {
            HashMap map2 = new HashMap(999);
            loop0: while (true) {
                i3 = 0;
                for (String str : setKeySet) {
                    map2.put(str, (ArrayList) map.get(str));
                    i3++;
                    if (i3 == 999) {
                        break;
                    }
                }
                K(map2);
                map2 = new HashMap(999);
            }
            if (i3 > 0) {
                K(map2);
                return;
            }
            return;
        }
        StringBuilder sbB = StringUtil.b();
        sbB.append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
        int size = setKeySet.size();
        StringUtil.a(sbB, size);
        sbB.append(")");
        RoomSQLiteQuery roomSQLiteQueryI = RoomSQLiteQuery.i(sbB.toString(), size);
        int i4 = 1;
        for (String str2 : setKeySet) {
            if (str2 == null) {
                roomSQLiteQueryI.D(i4);
            } else {
                roomSQLiteQueryI.s1(i4, str2);
            }
            i4++;
        }
        Cursor cursorH = DBUtil.h(this.f55065a, roomSQLiteQueryI, false, null);
        try {
            int iC = CursorUtil.c(cursorH, "work_spec_id");
            if (iC == -1) {
                return;
            }
            while (cursorH.moveToNext()) {
                ArrayList arrayList = (ArrayList) map.get(cursorH.getString(iC));
                if (arrayList != null) {
                    arrayList.add(cursorH.isNull(0) ? null : cursorH.getString(0));
                }
            }
        } finally {
            cursorH.close();
        }
    }

    public static List O() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public boolean A() {
        boolean z2 = false;
        RoomSQLiteQuery roomSQLiteQueryI = RoomSQLiteQuery.i("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", 0);
        this.f55065a.assertNotSuspendingTransaction();
        Cursor cursorH = DBUtil.h(this.f55065a, roomSQLiteQueryI, false, null);
        try {
            if (cursorH.moveToFirst()) {
                if (cursorH.getInt(0) != 0) {
                    z2 = true;
                }
            }
            return z2;
        } finally {
            cursorH.close();
            roomSQLiteQueryI.m();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int C(String str) {
        this.f55065a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f55075k.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.D(1);
        } else {
            supportSQLiteStatementAcquire.s1(1, str);
        }
        this.f55065a.beginTransaction();
        try {
            int iX = supportSQLiteStatementAcquire.X();
            this.f55065a.setTransactionSuccessful();
            return iX;
        } finally {
            this.f55065a.endTransaction();
            this.f55075k.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List D(String str) {
        RoomSQLiteQuery roomSQLiteQueryI = RoomSQLiteQuery.i("SELECT id, state, output, run_attempt_count, generation, required_network_type, requires_charging,requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            roomSQLiteQueryI.D(1);
        } else {
            roomSQLiteQueryI.s1(1, str);
        }
        this.f55065a.assertNotSuspendingTransaction();
        this.f55065a.beginTransaction();
        try {
            Cursor cursorH = DBUtil.h(this.f55065a, roomSQLiteQueryI, true, null);
            try {
                HashMap map = new HashMap();
                HashMap map2 = new HashMap();
                while (cursorH.moveToNext()) {
                    String string = cursorH.getString(0);
                    if (((ArrayList) map.get(string)) == null) {
                        map.put(string, new ArrayList());
                    }
                    String string2 = cursorH.getString(0);
                    if (((ArrayList) map2.get(string2)) == null) {
                        map2.put(string2, new ArrayList());
                    }
                }
                cursorH.moveToPosition(-1);
                K(map);
                J(map2);
                ArrayList arrayList = new ArrayList(cursorH.getCount());
                while (cursorH.moveToNext()) {
                    String string3 = cursorH.isNull(0) ? null : cursorH.getString(0);
                    WorkInfo.State stateF = WorkTypeConverters.f(cursorH.getInt(1));
                    Data dataG = Data.g(cursorH.isNull(2) ? null : cursorH.getBlob(2));
                    int i3 = cursorH.getInt(3);
                    int i4 = cursorH.getInt(4);
                    long j3 = cursorH.getLong(13);
                    long j4 = cursorH.getLong(14);
                    long j5 = cursorH.getLong(15);
                    BackoffPolicy backoffPolicyC = WorkTypeConverters.c(cursorH.getInt(16));
                    long j6 = cursorH.getLong(17);
                    long j7 = cursorH.getLong(18);
                    int i5 = cursorH.getInt(19);
                    long j8 = cursorH.getLong(20);
                    int i6 = cursorH.getInt(21);
                    Constraints constraints = new Constraints(WorkTypeConverters.d(cursorH.getInt(5)), cursorH.getInt(6) != 0, cursorH.getInt(7) != 0, cursorH.getInt(8) != 0, cursorH.getInt(9) != 0, cursorH.getLong(10), cursorH.getLong(11), WorkTypeConverters.b(cursorH.isNull(12) ? null : cursorH.getBlob(12)));
                    ArrayList arrayList2 = (ArrayList) map.get(cursorH.getString(0));
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    ArrayList arrayList3 = (ArrayList) map2.get(cursorH.getString(0));
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                    }
                    arrayList.add(new WorkSpec.WorkInfoPojo(string3, stateF, dataG, j3, j4, j5, constraints, i3, backoffPolicyC, j6, j7, i5, i4, j8, i6, arrayList2, arrayList3));
                }
                this.f55065a.setTransactionSuccessful();
                cursorH.close();
                roomSQLiteQueryI.m();
                return arrayList;
            } catch (Throwable th) {
                cursorH.close();
                roomSQLiteQueryI.m();
                throw th;
            }
        } finally {
            this.f55065a.endTransaction();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public LiveData E(List list) {
        StringBuilder sbB = StringUtil.b();
        sbB.append("SELECT id, state, output, run_attempt_count, generation, required_network_type, requires_charging,requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (");
        int size = list.size();
        StringUtil.a(sbB, size);
        sbB.append(")");
        final RoomSQLiteQuery roomSQLiteQueryI = RoomSQLiteQuery.i(sbB.toString(), size);
        Iterator it = list.iterator();
        int i3 = 1;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str == null) {
                roomSQLiteQueryI.D(i3);
            } else {
                roomSQLiteQueryI.s1(i3, str);
            }
            i3++;
        }
        return this.f55065a.getInvalidationTracker().o(new String[]{"WorkTag", "WorkProgress", "workspec"}, true, new Callable<List<WorkSpec.WorkInfoPojo>>() { // from class: androidx.work.impl.model.WorkSpecDao_Impl.19
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public List call() {
                WorkSpecDao_Impl.this.f55065a.beginTransaction();
                try {
                    Cursor cursorH = DBUtil.h(WorkSpecDao_Impl.this.f55065a, roomSQLiteQueryI, true, null);
                    try {
                        HashMap map = new HashMap();
                        HashMap map2 = new HashMap();
                        while (cursorH.moveToNext()) {
                            String string = cursorH.getString(0);
                            if (((ArrayList) map.get(string)) == null) {
                                map.put(string, new ArrayList());
                            }
                            String string2 = cursorH.getString(0);
                            if (((ArrayList) map2.get(string2)) == null) {
                                map2.put(string2, new ArrayList());
                            }
                        }
                        cursorH.moveToPosition(-1);
                        WorkSpecDao_Impl.this.K(map);
                        WorkSpecDao_Impl.this.J(map2);
                        ArrayList arrayList = new ArrayList(cursorH.getCount());
                        while (cursorH.moveToNext()) {
                            String string3 = cursorH.isNull(0) ? null : cursorH.getString(0);
                            WorkInfo.State stateF = WorkTypeConverters.f(cursorH.getInt(1));
                            Data dataG = Data.g(cursorH.isNull(2) ? null : cursorH.getBlob(2));
                            int i4 = cursorH.getInt(3);
                            int i5 = cursorH.getInt(4);
                            long j3 = cursorH.getLong(13);
                            long j4 = cursorH.getLong(14);
                            long j5 = cursorH.getLong(15);
                            BackoffPolicy backoffPolicyC = WorkTypeConverters.c(cursorH.getInt(16));
                            long j6 = cursorH.getLong(17);
                            long j7 = cursorH.getLong(18);
                            int i6 = cursorH.getInt(19);
                            long j8 = cursorH.getLong(20);
                            int i7 = cursorH.getInt(21);
                            Constraints constraints = new Constraints(WorkTypeConverters.d(cursorH.getInt(5)), cursorH.getInt(6) != 0, cursorH.getInt(7) != 0, cursorH.getInt(8) != 0, cursorH.getInt(9) != 0, cursorH.getLong(10), cursorH.getLong(11), WorkTypeConverters.b(cursorH.isNull(12) ? null : cursorH.getBlob(12)));
                            ArrayList arrayList2 = (ArrayList) map.get(cursorH.getString(0));
                            if (arrayList2 == null) {
                                arrayList2 = new ArrayList();
                            }
                            ArrayList arrayList3 = (ArrayList) map2.get(cursorH.getString(0));
                            if (arrayList3 == null) {
                                arrayList3 = new ArrayList();
                            }
                            arrayList.add(new WorkSpec.WorkInfoPojo(string3, stateF, dataG, j3, j4, j5, constraints, i4, backoffPolicyC, j6, j7, i6, i5, j8, i7, arrayList2, arrayList3));
                        }
                        WorkSpecDao_Impl.this.f55065a.setTransactionSuccessful();
                        cursorH.close();
                        return arrayList;
                    } catch (Throwable th) {
                        cursorH.close();
                        throw th;
                    }
                } finally {
                    WorkSpecDao_Impl.this.f55065a.endTransaction();
                }
            }

            protected void finalize() {
                roomSQLiteQueryI.m();
            }
        });
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int F(String str) {
        this.f55065a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f55074j.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.D(1);
        } else {
            supportSQLiteStatementAcquire.s1(1, str);
        }
        this.f55065a.beginTransaction();
        try {
            int iX = supportSQLiteStatementAcquire.X();
            this.f55065a.setTransactionSuccessful();
            return iX;
        } finally {
            this.f55065a.endTransaction();
            this.f55074j.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void H(String str, int i3) {
        this.f55065a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f55077m.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.D(1);
        } else {
            supportSQLiteStatementAcquire.s1(1, str);
        }
        supportSQLiteStatementAcquire.A(2, i3);
        this.f55065a.beginTransaction();
        try {
            supportSQLiteStatementAcquire.X();
            this.f55065a.setTransactionSuccessful();
        } finally {
            this.f55065a.endTransaction();
            this.f55077m.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List I(List list) {
        StringBuilder sbB = StringUtil.b();
        sbB.append("SELECT id, state, output, run_attempt_count, generation, required_network_type, requires_charging,requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (");
        int size = list.size();
        StringUtil.a(sbB, size);
        sbB.append(")");
        RoomSQLiteQuery roomSQLiteQueryI = RoomSQLiteQuery.i(sbB.toString(), size);
        Iterator it = list.iterator();
        int i3 = 1;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str == null) {
                roomSQLiteQueryI.D(i3);
            } else {
                roomSQLiteQueryI.s1(i3, str);
            }
            i3++;
        }
        this.f55065a.assertNotSuspendingTransaction();
        this.f55065a.beginTransaction();
        try {
            Cursor cursorH = DBUtil.h(this.f55065a, roomSQLiteQueryI, true, null);
            try {
                HashMap map = new HashMap();
                HashMap map2 = new HashMap();
                while (cursorH.moveToNext()) {
                    String string = cursorH.getString(0);
                    if (((ArrayList) map.get(string)) == null) {
                        map.put(string, new ArrayList());
                    }
                    String string2 = cursorH.getString(0);
                    if (((ArrayList) map2.get(string2)) == null) {
                        map2.put(string2, new ArrayList());
                    }
                }
                cursorH.moveToPosition(-1);
                K(map);
                J(map2);
                ArrayList arrayList = new ArrayList(cursorH.getCount());
                while (cursorH.moveToNext()) {
                    String string3 = cursorH.isNull(0) ? null : cursorH.getString(0);
                    WorkInfo.State stateF = WorkTypeConverters.f(cursorH.getInt(1));
                    Data dataG = Data.g(cursorH.isNull(2) ? null : cursorH.getBlob(2));
                    int i4 = cursorH.getInt(3);
                    int i5 = cursorH.getInt(4);
                    long j3 = cursorH.getLong(13);
                    long j4 = cursorH.getLong(14);
                    long j5 = cursorH.getLong(15);
                    BackoffPolicy backoffPolicyC = WorkTypeConverters.c(cursorH.getInt(16));
                    long j6 = cursorH.getLong(17);
                    long j7 = cursorH.getLong(18);
                    int i6 = cursorH.getInt(19);
                    long j8 = cursorH.getLong(20);
                    int i7 = cursorH.getInt(21);
                    Constraints constraints = new Constraints(WorkTypeConverters.d(cursorH.getInt(5)), cursorH.getInt(6) != 0, cursorH.getInt(7) != 0, cursorH.getInt(8) != 0, cursorH.getInt(9) != 0, cursorH.getLong(10), cursorH.getLong(11), WorkTypeConverters.b(cursorH.isNull(12) ? null : cursorH.getBlob(12)));
                    ArrayList arrayList2 = (ArrayList) map.get(cursorH.getString(0));
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    ArrayList arrayList3 = (ArrayList) map2.get(cursorH.getString(0));
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                    }
                    arrayList.add(new WorkSpec.WorkInfoPojo(string3, stateF, dataG, j3, j4, j5, constraints, i4, backoffPolicyC, j6, j7, i6, i5, j8, i7, arrayList2, arrayList3));
                }
                this.f55065a.setTransactionSuccessful();
                cursorH.close();
                roomSQLiteQueryI.m();
                return arrayList;
            } catch (Throwable th) {
                cursorH.close();
                roomSQLiteQueryI.m();
                throw th;
            }
        } finally {
            this.f55065a.endTransaction();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void a(String str, int i3) {
        this.f55065a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f55082r.acquire();
        supportSQLiteStatementAcquire.A(1, i3);
        if (str == null) {
            supportSQLiteStatementAcquire.D(2);
        } else {
            supportSQLiteStatementAcquire.s1(2, str);
        }
        this.f55065a.beginTransaction();
        try {
            supportSQLiteStatementAcquire.X();
            this.f55065a.setTransactionSuccessful();
        } finally {
            this.f55065a.endTransaction();
            this.f55082r.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void b(WorkSpec workSpec) {
        this.f55065a.assertNotSuspendingTransaction();
        this.f55065a.beginTransaction();
        try {
            this.f55067c.f(workSpec);
            this.f55065a.setTransactionSuccessful();
        } finally {
            this.f55065a.endTransaction();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void c(String str) {
        this.f55065a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f55068d.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.D(1);
        } else {
            supportSQLiteStatementAcquire.s1(1, str);
        }
        this.f55065a.beginTransaction();
        try {
            supportSQLiteStatementAcquire.X();
            this.f55065a.setTransactionSuccessful();
        } finally {
            this.f55065a.endTransaction();
            this.f55068d.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void d() {
        this.f55065a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f55080p.acquire();
        this.f55065a.beginTransaction();
        try {
            supportSQLiteStatementAcquire.X();
            this.f55065a.setTransactionSuccessful();
        } finally {
            this.f55065a.endTransaction();
            this.f55080p.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void e(String str) {
        this.f55065a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f55071g.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.D(1);
        } else {
            supportSQLiteStatementAcquire.s1(1, str);
        }
        this.f55065a.beginTransaction();
        try {
            supportSQLiteStatementAcquire.X();
            this.f55065a.setTransactionSuccessful();
        } finally {
            this.f55065a.endTransaction();
            this.f55071g.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List f(long j3) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryI = RoomSQLiteQuery.i("SELECT * FROM workspec WHERE last_enqueue_time >= ? AND state IN (2, 3, 5) ORDER BY last_enqueue_time DESC", 1);
        roomSQLiteQueryI.A(1, j3);
        this.f55065a.assertNotSuspendingTransaction();
        Cursor cursorH = DBUtil.h(this.f55065a, roomSQLiteQueryI, false, null);
        try {
            int iD = CursorUtil.d(cursorH, "id");
            int iD2 = CursorUtil.d(cursorH, ServerProtocol.DIALOG_PARAM_STATE);
            int iD3 = CursorUtil.d(cursorH, "worker_class_name");
            int iD4 = CursorUtil.d(cursorH, "input_merger_class_name");
            int iD5 = CursorUtil.d(cursorH, "input");
            int iD6 = CursorUtil.d(cursorH, "output");
            int iD7 = CursorUtil.d(cursorH, "initial_delay");
            int iD8 = CursorUtil.d(cursorH, "interval_duration");
            int iD9 = CursorUtil.d(cursorH, "flex_duration");
            int iD10 = CursorUtil.d(cursorH, "run_attempt_count");
            int iD11 = CursorUtil.d(cursorH, "backoff_policy");
            int iD12 = CursorUtil.d(cursorH, "backoff_delay_duration");
            int iD13 = CursorUtil.d(cursorH, "last_enqueue_time");
            int iD14 = CursorUtil.d(cursorH, "minimum_retention_duration");
            roomSQLiteQuery = roomSQLiteQueryI;
            try {
                int iD15 = CursorUtil.d(cursorH, "schedule_requested_at");
                int iD16 = CursorUtil.d(cursorH, "run_in_foreground");
                int iD17 = CursorUtil.d(cursorH, "out_of_quota_policy");
                int iD18 = CursorUtil.d(cursorH, "period_count");
                int iD19 = CursorUtil.d(cursorH, "generation");
                int iD20 = CursorUtil.d(cursorH, "next_schedule_time_override");
                int iD21 = CursorUtil.d(cursorH, "next_schedule_time_override_generation");
                int iD22 = CursorUtil.d(cursorH, "stop_reason");
                int iD23 = CursorUtil.d(cursorH, "required_network_type");
                int iD24 = CursorUtil.d(cursorH, "requires_charging");
                int iD25 = CursorUtil.d(cursorH, "requires_device_idle");
                int iD26 = CursorUtil.d(cursorH, "requires_battery_not_low");
                int iD27 = CursorUtil.d(cursorH, "requires_storage_not_low");
                int iD28 = CursorUtil.d(cursorH, "trigger_content_update_delay");
                int iD29 = CursorUtil.d(cursorH, "trigger_max_content_delay");
                int iD30 = CursorUtil.d(cursorH, "content_uri_triggers");
                int i3 = iD14;
                ArrayList arrayList = new ArrayList(cursorH.getCount());
                while (cursorH.moveToNext()) {
                    String string = cursorH.isNull(iD) ? null : cursorH.getString(iD);
                    WorkInfo.State stateF = WorkTypeConverters.f(cursorH.getInt(iD2));
                    String string2 = cursorH.isNull(iD3) ? null : cursorH.getString(iD3);
                    String string3 = cursorH.isNull(iD4) ? null : cursorH.getString(iD4);
                    Data dataG = Data.g(cursorH.isNull(iD5) ? null : cursorH.getBlob(iD5));
                    Data dataG2 = Data.g(cursorH.isNull(iD6) ? null : cursorH.getBlob(iD6));
                    long j4 = cursorH.getLong(iD7);
                    long j5 = cursorH.getLong(iD8);
                    long j6 = cursorH.getLong(iD9);
                    int i4 = cursorH.getInt(iD10);
                    BackoffPolicy backoffPolicyC = WorkTypeConverters.c(cursorH.getInt(iD11));
                    long j7 = cursorH.getLong(iD12);
                    long j8 = cursorH.getLong(iD13);
                    int i5 = i3;
                    long j9 = cursorH.getLong(i5);
                    int i6 = iD;
                    int i7 = iD15;
                    long j10 = cursorH.getLong(i7);
                    iD15 = i7;
                    int i8 = iD16;
                    boolean z2 = cursorH.getInt(i8) != 0;
                    iD16 = i8;
                    int i9 = iD17;
                    OutOfQuotaPolicy outOfQuotaPolicyE = WorkTypeConverters.e(cursorH.getInt(i9));
                    iD17 = i9;
                    int i10 = iD18;
                    int i11 = cursorH.getInt(i10);
                    iD18 = i10;
                    int i12 = iD19;
                    int i13 = cursorH.getInt(i12);
                    iD19 = i12;
                    int i14 = iD20;
                    long j11 = cursorH.getLong(i14);
                    iD20 = i14;
                    int i15 = iD21;
                    int i16 = cursorH.getInt(i15);
                    iD21 = i15;
                    int i17 = iD22;
                    int i18 = cursorH.getInt(i17);
                    iD22 = i17;
                    int i19 = iD23;
                    NetworkType networkTypeD = WorkTypeConverters.d(cursorH.getInt(i19));
                    iD23 = i19;
                    int i20 = iD24;
                    boolean z3 = cursorH.getInt(i20) != 0;
                    iD24 = i20;
                    int i21 = iD25;
                    boolean z4 = cursorH.getInt(i21) != 0;
                    iD25 = i21;
                    int i22 = iD26;
                    boolean z5 = cursorH.getInt(i22) != 0;
                    iD26 = i22;
                    int i23 = iD27;
                    boolean z6 = cursorH.getInt(i23) != 0;
                    iD27 = i23;
                    int i24 = iD28;
                    long j12 = cursorH.getLong(i24);
                    iD28 = i24;
                    int i25 = iD29;
                    long j13 = cursorH.getLong(i25);
                    iD29 = i25;
                    int i26 = iD30;
                    iD30 = i26;
                    arrayList.add(new WorkSpec(string, stateF, string2, string3, dataG, dataG2, j4, j5, j6, new Constraints(networkTypeD, z3, z4, z5, z6, j12, j13, WorkTypeConverters.b(cursorH.isNull(i26) ? null : cursorH.getBlob(i26))), i4, backoffPolicyC, j7, j8, j9, j10, z2, outOfQuotaPolicyE, i11, i13, j11, i16, i18));
                    iD = i6;
                    i3 = i5;
                }
                cursorH.close();
                roomSQLiteQuery.m();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorH.close();
                roomSQLiteQuery.m();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryI;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void g(WorkSpec workSpec) {
        this.f55065a.assertNotSuspendingTransaction();
        this.f55065a.beginTransaction();
        try {
            this.f55066b.insert(workSpec);
            this.f55065a.setTransactionSuccessful();
        } finally {
            this.f55065a.endTransaction();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List h() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryI = RoomSQLiteQuery.i("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.f55065a.assertNotSuspendingTransaction();
        Cursor cursorH = DBUtil.h(this.f55065a, roomSQLiteQueryI, false, null);
        try {
            int iD = CursorUtil.d(cursorH, "id");
            int iD2 = CursorUtil.d(cursorH, ServerProtocol.DIALOG_PARAM_STATE);
            int iD3 = CursorUtil.d(cursorH, "worker_class_name");
            int iD4 = CursorUtil.d(cursorH, "input_merger_class_name");
            int iD5 = CursorUtil.d(cursorH, "input");
            int iD6 = CursorUtil.d(cursorH, "output");
            int iD7 = CursorUtil.d(cursorH, "initial_delay");
            int iD8 = CursorUtil.d(cursorH, "interval_duration");
            int iD9 = CursorUtil.d(cursorH, "flex_duration");
            int iD10 = CursorUtil.d(cursorH, "run_attempt_count");
            int iD11 = CursorUtil.d(cursorH, "backoff_policy");
            int iD12 = CursorUtil.d(cursorH, "backoff_delay_duration");
            int iD13 = CursorUtil.d(cursorH, "last_enqueue_time");
            int iD14 = CursorUtil.d(cursorH, "minimum_retention_duration");
            roomSQLiteQuery = roomSQLiteQueryI;
            try {
                int iD15 = CursorUtil.d(cursorH, "schedule_requested_at");
                int iD16 = CursorUtil.d(cursorH, "run_in_foreground");
                int iD17 = CursorUtil.d(cursorH, "out_of_quota_policy");
                int iD18 = CursorUtil.d(cursorH, "period_count");
                int iD19 = CursorUtil.d(cursorH, "generation");
                int iD20 = CursorUtil.d(cursorH, "next_schedule_time_override");
                int iD21 = CursorUtil.d(cursorH, "next_schedule_time_override_generation");
                int iD22 = CursorUtil.d(cursorH, "stop_reason");
                int iD23 = CursorUtil.d(cursorH, "required_network_type");
                int iD24 = CursorUtil.d(cursorH, "requires_charging");
                int iD25 = CursorUtil.d(cursorH, "requires_device_idle");
                int iD26 = CursorUtil.d(cursorH, "requires_battery_not_low");
                int iD27 = CursorUtil.d(cursorH, "requires_storage_not_low");
                int iD28 = CursorUtil.d(cursorH, "trigger_content_update_delay");
                int iD29 = CursorUtil.d(cursorH, "trigger_max_content_delay");
                int iD30 = CursorUtil.d(cursorH, "content_uri_triggers");
                int i3 = iD14;
                ArrayList arrayList = new ArrayList(cursorH.getCount());
                while (cursorH.moveToNext()) {
                    String string = cursorH.isNull(iD) ? null : cursorH.getString(iD);
                    WorkInfo.State stateF = WorkTypeConverters.f(cursorH.getInt(iD2));
                    String string2 = cursorH.isNull(iD3) ? null : cursorH.getString(iD3);
                    String string3 = cursorH.isNull(iD4) ? null : cursorH.getString(iD4);
                    Data dataG = Data.g(cursorH.isNull(iD5) ? null : cursorH.getBlob(iD5));
                    Data dataG2 = Data.g(cursorH.isNull(iD6) ? null : cursorH.getBlob(iD6));
                    long j3 = cursorH.getLong(iD7);
                    long j4 = cursorH.getLong(iD8);
                    long j5 = cursorH.getLong(iD9);
                    int i4 = cursorH.getInt(iD10);
                    BackoffPolicy backoffPolicyC = WorkTypeConverters.c(cursorH.getInt(iD11));
                    long j6 = cursorH.getLong(iD12);
                    long j7 = cursorH.getLong(iD13);
                    int i5 = i3;
                    long j8 = cursorH.getLong(i5);
                    int i6 = iD;
                    int i7 = iD15;
                    long j9 = cursorH.getLong(i7);
                    iD15 = i7;
                    int i8 = iD16;
                    boolean z2 = cursorH.getInt(i8) != 0;
                    iD16 = i8;
                    int i9 = iD17;
                    OutOfQuotaPolicy outOfQuotaPolicyE = WorkTypeConverters.e(cursorH.getInt(i9));
                    iD17 = i9;
                    int i10 = iD18;
                    int i11 = cursorH.getInt(i10);
                    iD18 = i10;
                    int i12 = iD19;
                    int i13 = cursorH.getInt(i12);
                    iD19 = i12;
                    int i14 = iD20;
                    long j10 = cursorH.getLong(i14);
                    iD20 = i14;
                    int i15 = iD21;
                    int i16 = cursorH.getInt(i15);
                    iD21 = i15;
                    int i17 = iD22;
                    int i18 = cursorH.getInt(i17);
                    iD22 = i17;
                    int i19 = iD23;
                    NetworkType networkTypeD = WorkTypeConverters.d(cursorH.getInt(i19));
                    iD23 = i19;
                    int i20 = iD24;
                    boolean z3 = cursorH.getInt(i20) != 0;
                    iD24 = i20;
                    int i21 = iD25;
                    boolean z4 = cursorH.getInt(i21) != 0;
                    iD25 = i21;
                    int i22 = iD26;
                    boolean z5 = cursorH.getInt(i22) != 0;
                    iD26 = i22;
                    int i23 = iD27;
                    boolean z6 = cursorH.getInt(i23) != 0;
                    iD27 = i23;
                    int i24 = iD28;
                    long j11 = cursorH.getLong(i24);
                    iD28 = i24;
                    int i25 = iD29;
                    long j12 = cursorH.getLong(i25);
                    iD29 = i25;
                    int i26 = iD30;
                    iD30 = i26;
                    arrayList.add(new WorkSpec(string, stateF, string2, string3, dataG, dataG2, j3, j4, j5, new Constraints(networkTypeD, z3, z4, z5, z6, j11, j12, WorkTypeConverters.b(cursorH.isNull(i26) ? null : cursorH.getBlob(i26))), i4, backoffPolicyC, j6, j7, j8, j9, z2, outOfQuotaPolicyE, i11, i13, j10, i16, i18));
                    iD = i6;
                    i3 = i5;
                }
                cursorH.close();
                roomSQLiteQuery.m();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorH.close();
                roomSQLiteQuery.m();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryI;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List i(String str) {
        RoomSQLiteQuery roomSQLiteQueryI = RoomSQLiteQuery.i("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            roomSQLiteQueryI.D(1);
        } else {
            roomSQLiteQueryI.s1(1, str);
        }
        this.f55065a.assertNotSuspendingTransaction();
        Cursor cursorH = DBUtil.h(this.f55065a, roomSQLiteQueryI, false, null);
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

    @Override // androidx.work.impl.model.WorkSpecDao
    public WorkSpec.WorkInfoPojo j(String str) {
        RoomSQLiteQuery roomSQLiteQueryI = RoomSQLiteQuery.i("SELECT id, state, output, run_attempt_count, generation, required_network_type, requires_charging,requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id=?", 1);
        if (str == null) {
            roomSQLiteQueryI.D(1);
        } else {
            roomSQLiteQueryI.s1(1, str);
        }
        this.f55065a.assertNotSuspendingTransaction();
        this.f55065a.beginTransaction();
        try {
            WorkSpec.WorkInfoPojo workInfoPojo = null;
            byte[] blob = null;
            Cursor cursorH = DBUtil.h(this.f55065a, roomSQLiteQueryI, true, null);
            try {
                HashMap map = new HashMap();
                HashMap map2 = new HashMap();
                while (cursorH.moveToNext()) {
                    String string = cursorH.getString(0);
                    if (((ArrayList) map.get(string)) == null) {
                        map.put(string, new ArrayList());
                    }
                    String string2 = cursorH.getString(0);
                    if (((ArrayList) map2.get(string2)) == null) {
                        map2.put(string2, new ArrayList());
                    }
                }
                cursorH.moveToPosition(-1);
                K(map);
                J(map2);
                if (cursorH.moveToFirst()) {
                    String string3 = cursorH.isNull(0) ? null : cursorH.getString(0);
                    WorkInfo.State stateF = WorkTypeConverters.f(cursorH.getInt(1));
                    Data dataG = Data.g(cursorH.isNull(2) ? null : cursorH.getBlob(2));
                    int i3 = cursorH.getInt(3);
                    int i4 = cursorH.getInt(4);
                    long j3 = cursorH.getLong(13);
                    long j4 = cursorH.getLong(14);
                    long j5 = cursorH.getLong(15);
                    BackoffPolicy backoffPolicyC = WorkTypeConverters.c(cursorH.getInt(16));
                    long j6 = cursorH.getLong(17);
                    long j7 = cursorH.getLong(18);
                    int i5 = cursorH.getInt(19);
                    long j8 = cursorH.getLong(20);
                    int i6 = cursorH.getInt(21);
                    NetworkType networkTypeD = WorkTypeConverters.d(cursorH.getInt(5));
                    boolean z2 = cursorH.getInt(6) != 0;
                    boolean z3 = cursorH.getInt(7) != 0;
                    boolean z4 = cursorH.getInt(8) != 0;
                    boolean z5 = cursorH.getInt(9) != 0;
                    long j9 = cursorH.getLong(10);
                    long j10 = cursorH.getLong(11);
                    if (!cursorH.isNull(12)) {
                        blob = cursorH.getBlob(12);
                    }
                    Constraints constraints = new Constraints(networkTypeD, z2, z3, z4, z5, j9, j10, WorkTypeConverters.b(blob));
                    ArrayList arrayList = (ArrayList) map.get(cursorH.getString(0));
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    ArrayList arrayList2 = (ArrayList) map2.get(cursorH.getString(0));
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    workInfoPojo = new WorkSpec.WorkInfoPojo(string3, stateF, dataG, j3, j4, j5, constraints, i3, backoffPolicyC, j6, j7, i5, i4, j8, i6, arrayList, arrayList2);
                }
                this.f55065a.setTransactionSuccessful();
                cursorH.close();
                roomSQLiteQueryI.m();
                return workInfoPojo;
            } catch (Throwable th) {
                cursorH.close();
                roomSQLiteQueryI.m();
                throw th;
            }
        } finally {
            this.f55065a.endTransaction();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public WorkInfo.State k(String str) {
        RoomSQLiteQuery roomSQLiteQueryI = RoomSQLiteQuery.i("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            roomSQLiteQueryI.D(1);
        } else {
            roomSQLiteQueryI.s1(1, str);
        }
        this.f55065a.assertNotSuspendingTransaction();
        WorkInfo.State stateF = null;
        Cursor cursorH = DBUtil.h(this.f55065a, roomSQLiteQueryI, false, null);
        try {
            if (cursorH.moveToFirst()) {
                Integer numValueOf = cursorH.isNull(0) ? null : Integer.valueOf(cursorH.getInt(0));
                if (numValueOf != null) {
                    WorkTypeConverters workTypeConverters = WorkTypeConverters.f55123a;
                    stateF = WorkTypeConverters.f(numValueOf.intValue());
                }
            }
            return stateF;
        } finally {
            cursorH.close();
            roomSQLiteQueryI.m();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public WorkSpec l(String str) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int iD;
        int iD2;
        int iD3;
        int iD4;
        int iD5;
        int iD6;
        int iD7;
        int iD8;
        int iD9;
        int iD10;
        int iD11;
        int iD12;
        int iD13;
        int iD14;
        WorkSpec workSpec;
        RoomSQLiteQuery roomSQLiteQueryI = RoomSQLiteQuery.i("SELECT * FROM workspec WHERE id=?", 1);
        if (str == null) {
            roomSQLiteQueryI.D(1);
        } else {
            roomSQLiteQueryI.s1(1, str);
        }
        this.f55065a.assertNotSuspendingTransaction();
        Cursor cursorH = DBUtil.h(this.f55065a, roomSQLiteQueryI, false, null);
        try {
            iD = CursorUtil.d(cursorH, "id");
            iD2 = CursorUtil.d(cursorH, ServerProtocol.DIALOG_PARAM_STATE);
            iD3 = CursorUtil.d(cursorH, "worker_class_name");
            iD4 = CursorUtil.d(cursorH, "input_merger_class_name");
            iD5 = CursorUtil.d(cursorH, "input");
            iD6 = CursorUtil.d(cursorH, "output");
            iD7 = CursorUtil.d(cursorH, "initial_delay");
            iD8 = CursorUtil.d(cursorH, "interval_duration");
            iD9 = CursorUtil.d(cursorH, "flex_duration");
            iD10 = CursorUtil.d(cursorH, "run_attempt_count");
            iD11 = CursorUtil.d(cursorH, "backoff_policy");
            iD12 = CursorUtil.d(cursorH, "backoff_delay_duration");
            iD13 = CursorUtil.d(cursorH, "last_enqueue_time");
            iD14 = CursorUtil.d(cursorH, "minimum_retention_duration");
            roomSQLiteQuery = roomSQLiteQueryI;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryI;
        }
        try {
            int iD15 = CursorUtil.d(cursorH, "schedule_requested_at");
            int iD16 = CursorUtil.d(cursorH, "run_in_foreground");
            int iD17 = CursorUtil.d(cursorH, "out_of_quota_policy");
            int iD18 = CursorUtil.d(cursorH, "period_count");
            int iD19 = CursorUtil.d(cursorH, "generation");
            int iD20 = CursorUtil.d(cursorH, "next_schedule_time_override");
            int iD21 = CursorUtil.d(cursorH, "next_schedule_time_override_generation");
            int iD22 = CursorUtil.d(cursorH, "stop_reason");
            int iD23 = CursorUtil.d(cursorH, "required_network_type");
            int iD24 = CursorUtil.d(cursorH, "requires_charging");
            int iD25 = CursorUtil.d(cursorH, "requires_device_idle");
            int iD26 = CursorUtil.d(cursorH, "requires_battery_not_low");
            int iD27 = CursorUtil.d(cursorH, "requires_storage_not_low");
            int iD28 = CursorUtil.d(cursorH, "trigger_content_update_delay");
            int iD29 = CursorUtil.d(cursorH, "trigger_max_content_delay");
            int iD30 = CursorUtil.d(cursorH, "content_uri_triggers");
            if (cursorH.moveToFirst()) {
                workSpec = new WorkSpec(cursorH.isNull(iD) ? null : cursorH.getString(iD), WorkTypeConverters.f(cursorH.getInt(iD2)), cursorH.isNull(iD3) ? null : cursorH.getString(iD3), cursorH.isNull(iD4) ? null : cursorH.getString(iD4), Data.g(cursorH.isNull(iD5) ? null : cursorH.getBlob(iD5)), Data.g(cursorH.isNull(iD6) ? null : cursorH.getBlob(iD6)), cursorH.getLong(iD7), cursorH.getLong(iD8), cursorH.getLong(iD9), new Constraints(WorkTypeConverters.d(cursorH.getInt(iD23)), cursorH.getInt(iD24) != 0, cursorH.getInt(iD25) != 0, cursorH.getInt(iD26) != 0, cursorH.getInt(iD27) != 0, cursorH.getLong(iD28), cursorH.getLong(iD29), WorkTypeConverters.b(cursorH.isNull(iD30) ? null : cursorH.getBlob(iD30))), cursorH.getInt(iD10), WorkTypeConverters.c(cursorH.getInt(iD11)), cursorH.getLong(iD12), cursorH.getLong(iD13), cursorH.getLong(iD14), cursorH.getLong(iD15), cursorH.getInt(iD16) != 0, WorkTypeConverters.e(cursorH.getInt(iD17)), cursorH.getInt(iD18), cursorH.getInt(iD19), cursorH.getLong(iD20), cursorH.getInt(iD21), cursorH.getInt(iD22));
            } else {
                workSpec = null;
            }
            cursorH.close();
            roomSQLiteQuery.m();
            return workSpec;
        } catch (Throwable th2) {
            th = th2;
            cursorH.close();
            roomSQLiteQuery.m();
            throw th;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int m(String str) {
        this.f55065a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f55070f.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.D(1);
        } else {
            supportSQLiteStatementAcquire.s1(1, str);
        }
        this.f55065a.beginTransaction();
        try {
            int iX = supportSQLiteStatementAcquire.X();
            this.f55065a.setTransactionSuccessful();
            return iX;
        } finally {
            this.f55065a.endTransaction();
            this.f55070f.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List n(String str) {
        RoomSQLiteQuery roomSQLiteQueryI = RoomSQLiteQuery.i("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            roomSQLiteQueryI.D(1);
        } else {
            roomSQLiteQueryI.s1(1, str);
        }
        this.f55065a.assertNotSuspendingTransaction();
        Cursor cursorH = DBUtil.h(this.f55065a, roomSQLiteQueryI, false, null);
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

    @Override // androidx.work.impl.model.WorkSpecDao
    public List o(String str) {
        RoomSQLiteQuery roomSQLiteQueryI = RoomSQLiteQuery.i("SELECT output FROM workspec WHERE id IN\n             (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
        if (str == null) {
            roomSQLiteQueryI.D(1);
        } else {
            roomSQLiteQueryI.s1(1, str);
        }
        this.f55065a.assertNotSuspendingTransaction();
        Cursor cursorH = DBUtil.h(this.f55065a, roomSQLiteQueryI, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorH.getCount());
            while (cursorH.moveToNext()) {
                arrayList.add(Data.g(cursorH.isNull(0) ? null : cursorH.getBlob(0)));
            }
            return arrayList;
        } finally {
            cursorH.close();
            roomSQLiteQueryI.m();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List p(String str) {
        RoomSQLiteQuery roomSQLiteQueryI = RoomSQLiteQuery.i("SELECT id, state, output, run_attempt_count, generation, required_network_type, requires_charging,requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            roomSQLiteQueryI.D(1);
        } else {
            roomSQLiteQueryI.s1(1, str);
        }
        this.f55065a.assertNotSuspendingTransaction();
        this.f55065a.beginTransaction();
        try {
            Cursor cursorH = DBUtil.h(this.f55065a, roomSQLiteQueryI, true, null);
            try {
                HashMap map = new HashMap();
                HashMap map2 = new HashMap();
                while (cursorH.moveToNext()) {
                    String string = cursorH.getString(0);
                    if (((ArrayList) map.get(string)) == null) {
                        map.put(string, new ArrayList());
                    }
                    String string2 = cursorH.getString(0);
                    if (((ArrayList) map2.get(string2)) == null) {
                        map2.put(string2, new ArrayList());
                    }
                }
                cursorH.moveToPosition(-1);
                K(map);
                J(map2);
                ArrayList arrayList = new ArrayList(cursorH.getCount());
                while (cursorH.moveToNext()) {
                    String string3 = cursorH.isNull(0) ? null : cursorH.getString(0);
                    WorkInfo.State stateF = WorkTypeConverters.f(cursorH.getInt(1));
                    Data dataG = Data.g(cursorH.isNull(2) ? null : cursorH.getBlob(2));
                    int i3 = cursorH.getInt(3);
                    int i4 = cursorH.getInt(4);
                    long j3 = cursorH.getLong(13);
                    long j4 = cursorH.getLong(14);
                    long j5 = cursorH.getLong(15);
                    BackoffPolicy backoffPolicyC = WorkTypeConverters.c(cursorH.getInt(16));
                    long j6 = cursorH.getLong(17);
                    long j7 = cursorH.getLong(18);
                    int i5 = cursorH.getInt(19);
                    long j8 = cursorH.getLong(20);
                    int i6 = cursorH.getInt(21);
                    Constraints constraints = new Constraints(WorkTypeConverters.d(cursorH.getInt(5)), cursorH.getInt(6) != 0, cursorH.getInt(7) != 0, cursorH.getInt(8) != 0, cursorH.getInt(9) != 0, cursorH.getLong(10), cursorH.getLong(11), WorkTypeConverters.b(cursorH.isNull(12) ? null : cursorH.getBlob(12)));
                    ArrayList arrayList2 = (ArrayList) map.get(cursorH.getString(0));
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    ArrayList arrayList3 = (ArrayList) map2.get(cursorH.getString(0));
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                    }
                    arrayList.add(new WorkSpec.WorkInfoPojo(string3, stateF, dataG, j3, j4, j5, constraints, i3, backoffPolicyC, j6, j7, i5, i4, j8, i6, arrayList2, arrayList3));
                }
                this.f55065a.setTransactionSuccessful();
                cursorH.close();
                roomSQLiteQueryI.m();
                return arrayList;
            } catch (Throwable th) {
                cursorH.close();
                roomSQLiteQueryI.m();
                throw th;
            }
        } finally {
            this.f55065a.endTransaction();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int r() {
        this.f55065a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f55079o.acquire();
        this.f55065a.beginTransaction();
        try {
            int iX = supportSQLiteStatementAcquire.X();
            this.f55065a.setTransactionSuccessful();
            return iX;
        } finally {
            this.f55065a.endTransaction();
            this.f55079o.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int s(String str, long j3) {
        this.f55065a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f55078n.acquire();
        supportSQLiteStatementAcquire.A(1, j3);
        if (str == null) {
            supportSQLiteStatementAcquire.D(2);
        } else {
            supportSQLiteStatementAcquire.s1(2, str);
        }
        this.f55065a.beginTransaction();
        try {
            int iX = supportSQLiteStatementAcquire.X();
            this.f55065a.setTransactionSuccessful();
            return iX;
        } finally {
            this.f55065a.endTransaction();
            this.f55078n.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List t(String str) {
        RoomSQLiteQuery roomSQLiteQueryI = RoomSQLiteQuery.i("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            roomSQLiteQueryI.D(1);
        } else {
            roomSQLiteQueryI.s1(1, str);
        }
        this.f55065a.assertNotSuspendingTransaction();
        Cursor cursorH = DBUtil.h(this.f55065a, roomSQLiteQueryI, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorH.getCount());
            while (cursorH.moveToNext()) {
                arrayList.add(new WorkSpec.IdAndState(cursorH.isNull(0) ? null : cursorH.getString(0), WorkTypeConverters.f(cursorH.getInt(1))));
            }
            return arrayList;
        } finally {
            cursorH.close();
            roomSQLiteQueryI.m();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List u(int i3) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryI = RoomSQLiteQuery.i("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY last_enqueue_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND LENGTH(content_uri_triggers)=0 AND state NOT IN (2, 3, 5))", 1);
        roomSQLiteQueryI.A(1, i3);
        this.f55065a.assertNotSuspendingTransaction();
        Cursor cursorH = DBUtil.h(this.f55065a, roomSQLiteQueryI, false, null);
        try {
            int iD = CursorUtil.d(cursorH, "id");
            int iD2 = CursorUtil.d(cursorH, ServerProtocol.DIALOG_PARAM_STATE);
            int iD3 = CursorUtil.d(cursorH, "worker_class_name");
            int iD4 = CursorUtil.d(cursorH, "input_merger_class_name");
            int iD5 = CursorUtil.d(cursorH, "input");
            int iD6 = CursorUtil.d(cursorH, "output");
            int iD7 = CursorUtil.d(cursorH, "initial_delay");
            int iD8 = CursorUtil.d(cursorH, "interval_duration");
            int iD9 = CursorUtil.d(cursorH, "flex_duration");
            int iD10 = CursorUtil.d(cursorH, "run_attempt_count");
            int iD11 = CursorUtil.d(cursorH, "backoff_policy");
            int iD12 = CursorUtil.d(cursorH, "backoff_delay_duration");
            int iD13 = CursorUtil.d(cursorH, "last_enqueue_time");
            int iD14 = CursorUtil.d(cursorH, "minimum_retention_duration");
            roomSQLiteQuery = roomSQLiteQueryI;
            try {
                int iD15 = CursorUtil.d(cursorH, "schedule_requested_at");
                int iD16 = CursorUtil.d(cursorH, "run_in_foreground");
                int iD17 = CursorUtil.d(cursorH, "out_of_quota_policy");
                int iD18 = CursorUtil.d(cursorH, "period_count");
                int iD19 = CursorUtil.d(cursorH, "generation");
                int iD20 = CursorUtil.d(cursorH, "next_schedule_time_override");
                int iD21 = CursorUtil.d(cursorH, "next_schedule_time_override_generation");
                int iD22 = CursorUtil.d(cursorH, "stop_reason");
                int iD23 = CursorUtil.d(cursorH, "required_network_type");
                int iD24 = CursorUtil.d(cursorH, "requires_charging");
                int iD25 = CursorUtil.d(cursorH, "requires_device_idle");
                int iD26 = CursorUtil.d(cursorH, "requires_battery_not_low");
                int iD27 = CursorUtil.d(cursorH, "requires_storage_not_low");
                int iD28 = CursorUtil.d(cursorH, "trigger_content_update_delay");
                int iD29 = CursorUtil.d(cursorH, "trigger_max_content_delay");
                int iD30 = CursorUtil.d(cursorH, "content_uri_triggers");
                int i4 = iD14;
                ArrayList arrayList = new ArrayList(cursorH.getCount());
                while (cursorH.moveToNext()) {
                    String string = cursorH.isNull(iD) ? null : cursorH.getString(iD);
                    WorkInfo.State stateF = WorkTypeConverters.f(cursorH.getInt(iD2));
                    String string2 = cursorH.isNull(iD3) ? null : cursorH.getString(iD3);
                    String string3 = cursorH.isNull(iD4) ? null : cursorH.getString(iD4);
                    Data dataG = Data.g(cursorH.isNull(iD5) ? null : cursorH.getBlob(iD5));
                    Data dataG2 = Data.g(cursorH.isNull(iD6) ? null : cursorH.getBlob(iD6));
                    long j3 = cursorH.getLong(iD7);
                    long j4 = cursorH.getLong(iD8);
                    long j5 = cursorH.getLong(iD9);
                    int i5 = cursorH.getInt(iD10);
                    BackoffPolicy backoffPolicyC = WorkTypeConverters.c(cursorH.getInt(iD11));
                    long j6 = cursorH.getLong(iD12);
                    long j7 = cursorH.getLong(iD13);
                    int i6 = i4;
                    long j8 = cursorH.getLong(i6);
                    int i7 = iD;
                    int i8 = iD15;
                    long j9 = cursorH.getLong(i8);
                    iD15 = i8;
                    int i9 = iD16;
                    boolean z2 = cursorH.getInt(i9) != 0;
                    iD16 = i9;
                    int i10 = iD17;
                    OutOfQuotaPolicy outOfQuotaPolicyE = WorkTypeConverters.e(cursorH.getInt(i10));
                    iD17 = i10;
                    int i11 = iD18;
                    int i12 = cursorH.getInt(i11);
                    iD18 = i11;
                    int i13 = iD19;
                    int i14 = cursorH.getInt(i13);
                    iD19 = i13;
                    int i15 = iD20;
                    long j10 = cursorH.getLong(i15);
                    iD20 = i15;
                    int i16 = iD21;
                    int i17 = cursorH.getInt(i16);
                    iD21 = i16;
                    int i18 = iD22;
                    int i19 = cursorH.getInt(i18);
                    iD22 = i18;
                    int i20 = iD23;
                    NetworkType networkTypeD = WorkTypeConverters.d(cursorH.getInt(i20));
                    iD23 = i20;
                    int i21 = iD24;
                    boolean z3 = cursorH.getInt(i21) != 0;
                    iD24 = i21;
                    int i22 = iD25;
                    boolean z4 = cursorH.getInt(i22) != 0;
                    iD25 = i22;
                    int i23 = iD26;
                    boolean z5 = cursorH.getInt(i23) != 0;
                    iD26 = i23;
                    int i24 = iD27;
                    boolean z6 = cursorH.getInt(i24) != 0;
                    iD27 = i24;
                    int i25 = iD28;
                    long j11 = cursorH.getLong(i25);
                    iD28 = i25;
                    int i26 = iD29;
                    long j12 = cursorH.getLong(i26);
                    iD29 = i26;
                    int i27 = iD30;
                    iD30 = i27;
                    arrayList.add(new WorkSpec(string, stateF, string2, string3, dataG, dataG2, j3, j4, j5, new Constraints(networkTypeD, z3, z4, z5, z6, j11, j12, WorkTypeConverters.b(cursorH.isNull(i27) ? null : cursorH.getBlob(i27))), i5, backoffPolicyC, j6, j7, j8, j9, z2, outOfQuotaPolicyE, i12, i14, j10, i17, i19));
                    iD = i7;
                    i4 = i6;
                }
                cursorH.close();
                roomSQLiteQuery.m();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorH.close();
                roomSQLiteQuery.m();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryI;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int v(WorkInfo.State state, String str) {
        this.f55065a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f55069e.acquire();
        supportSQLiteStatementAcquire.A(1, WorkTypeConverters.j(state));
        if (str == null) {
            supportSQLiteStatementAcquire.D(2);
        } else {
            supportSQLiteStatementAcquire.s1(2, str);
        }
        this.f55065a.beginTransaction();
        try {
            int iX = supportSQLiteStatementAcquire.X();
            this.f55065a.setTransactionSuccessful();
            return iX;
        } finally {
            this.f55065a.endTransaction();
            this.f55069e.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void w(String str, Data data) throws Throwable {
        this.f55065a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f55072h.acquire();
        byte[] bArrL = Data.l(data);
        if (bArrL == null) {
            supportSQLiteStatementAcquire.D(1);
        } else {
            supportSQLiteStatementAcquire.B(1, bArrL);
        }
        if (str == null) {
            supportSQLiteStatementAcquire.D(2);
        } else {
            supportSQLiteStatementAcquire.s1(2, str);
        }
        this.f55065a.beginTransaction();
        try {
            supportSQLiteStatementAcquire.X();
            this.f55065a.setTransactionSuccessful();
        } finally {
            this.f55065a.endTransaction();
            this.f55072h.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void x(String str, long j3) {
        this.f55065a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f55073i.acquire();
        supportSQLiteStatementAcquire.A(1, j3);
        if (str == null) {
            supportSQLiteStatementAcquire.D(2);
        } else {
            supportSQLiteStatementAcquire.s1(2, str);
        }
        this.f55065a.beginTransaction();
        try {
            supportSQLiteStatementAcquire.X();
            this.f55065a.setTransactionSuccessful();
        } finally {
            this.f55065a.endTransaction();
            this.f55073i.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List y() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryI = RoomSQLiteQuery.i("SELECT * FROM workspec WHERE state=1", 0);
        this.f55065a.assertNotSuspendingTransaction();
        Cursor cursorH = DBUtil.h(this.f55065a, roomSQLiteQueryI, false, null);
        try {
            int iD = CursorUtil.d(cursorH, "id");
            int iD2 = CursorUtil.d(cursorH, ServerProtocol.DIALOG_PARAM_STATE);
            int iD3 = CursorUtil.d(cursorH, "worker_class_name");
            int iD4 = CursorUtil.d(cursorH, "input_merger_class_name");
            int iD5 = CursorUtil.d(cursorH, "input");
            int iD6 = CursorUtil.d(cursorH, "output");
            int iD7 = CursorUtil.d(cursorH, "initial_delay");
            int iD8 = CursorUtil.d(cursorH, "interval_duration");
            int iD9 = CursorUtil.d(cursorH, "flex_duration");
            int iD10 = CursorUtil.d(cursorH, "run_attempt_count");
            int iD11 = CursorUtil.d(cursorH, "backoff_policy");
            int iD12 = CursorUtil.d(cursorH, "backoff_delay_duration");
            int iD13 = CursorUtil.d(cursorH, "last_enqueue_time");
            int iD14 = CursorUtil.d(cursorH, "minimum_retention_duration");
            roomSQLiteQuery = roomSQLiteQueryI;
            try {
                int iD15 = CursorUtil.d(cursorH, "schedule_requested_at");
                int iD16 = CursorUtil.d(cursorH, "run_in_foreground");
                int iD17 = CursorUtil.d(cursorH, "out_of_quota_policy");
                int iD18 = CursorUtil.d(cursorH, "period_count");
                int iD19 = CursorUtil.d(cursorH, "generation");
                int iD20 = CursorUtil.d(cursorH, "next_schedule_time_override");
                int iD21 = CursorUtil.d(cursorH, "next_schedule_time_override_generation");
                int iD22 = CursorUtil.d(cursorH, "stop_reason");
                int iD23 = CursorUtil.d(cursorH, "required_network_type");
                int iD24 = CursorUtil.d(cursorH, "requires_charging");
                int iD25 = CursorUtil.d(cursorH, "requires_device_idle");
                int iD26 = CursorUtil.d(cursorH, "requires_battery_not_low");
                int iD27 = CursorUtil.d(cursorH, "requires_storage_not_low");
                int iD28 = CursorUtil.d(cursorH, "trigger_content_update_delay");
                int iD29 = CursorUtil.d(cursorH, "trigger_max_content_delay");
                int iD30 = CursorUtil.d(cursorH, "content_uri_triggers");
                int i3 = iD14;
                ArrayList arrayList = new ArrayList(cursorH.getCount());
                while (cursorH.moveToNext()) {
                    String string = cursorH.isNull(iD) ? null : cursorH.getString(iD);
                    WorkInfo.State stateF = WorkTypeConverters.f(cursorH.getInt(iD2));
                    String string2 = cursorH.isNull(iD3) ? null : cursorH.getString(iD3);
                    String string3 = cursorH.isNull(iD4) ? null : cursorH.getString(iD4);
                    Data dataG = Data.g(cursorH.isNull(iD5) ? null : cursorH.getBlob(iD5));
                    Data dataG2 = Data.g(cursorH.isNull(iD6) ? null : cursorH.getBlob(iD6));
                    long j3 = cursorH.getLong(iD7);
                    long j4 = cursorH.getLong(iD8);
                    long j5 = cursorH.getLong(iD9);
                    int i4 = cursorH.getInt(iD10);
                    BackoffPolicy backoffPolicyC = WorkTypeConverters.c(cursorH.getInt(iD11));
                    long j6 = cursorH.getLong(iD12);
                    long j7 = cursorH.getLong(iD13);
                    int i5 = i3;
                    long j8 = cursorH.getLong(i5);
                    int i6 = iD;
                    int i7 = iD15;
                    long j9 = cursorH.getLong(i7);
                    iD15 = i7;
                    int i8 = iD16;
                    boolean z2 = cursorH.getInt(i8) != 0;
                    iD16 = i8;
                    int i9 = iD17;
                    OutOfQuotaPolicy outOfQuotaPolicyE = WorkTypeConverters.e(cursorH.getInt(i9));
                    iD17 = i9;
                    int i10 = iD18;
                    int i11 = cursorH.getInt(i10);
                    iD18 = i10;
                    int i12 = iD19;
                    int i13 = cursorH.getInt(i12);
                    iD19 = i12;
                    int i14 = iD20;
                    long j10 = cursorH.getLong(i14);
                    iD20 = i14;
                    int i15 = iD21;
                    int i16 = cursorH.getInt(i15);
                    iD21 = i15;
                    int i17 = iD22;
                    int i18 = cursorH.getInt(i17);
                    iD22 = i17;
                    int i19 = iD23;
                    NetworkType networkTypeD = WorkTypeConverters.d(cursorH.getInt(i19));
                    iD23 = i19;
                    int i20 = iD24;
                    boolean z3 = cursorH.getInt(i20) != 0;
                    iD24 = i20;
                    int i21 = iD25;
                    boolean z4 = cursorH.getInt(i21) != 0;
                    iD25 = i21;
                    int i22 = iD26;
                    boolean z5 = cursorH.getInt(i22) != 0;
                    iD26 = i22;
                    int i23 = iD27;
                    boolean z6 = cursorH.getInt(i23) != 0;
                    iD27 = i23;
                    int i24 = iD28;
                    long j11 = cursorH.getLong(i24);
                    iD28 = i24;
                    int i25 = iD29;
                    long j12 = cursorH.getLong(i25);
                    iD29 = i25;
                    int i26 = iD30;
                    iD30 = i26;
                    arrayList.add(new WorkSpec(string, stateF, string2, string3, dataG, dataG2, j3, j4, j5, new Constraints(networkTypeD, z3, z4, z5, z6, j11, j12, WorkTypeConverters.b(cursorH.isNull(i26) ? null : cursorH.getBlob(i26))), i4, backoffPolicyC, j6, j7, j8, j9, z2, outOfQuotaPolicyE, i11, i13, j10, i16, i18));
                    iD = i6;
                    i3 = i5;
                }
                cursorH.close();
                roomSQLiteQuery.m();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorH.close();
                roomSQLiteQuery.m();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryI;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List z() {
        RoomSQLiteQuery roomSQLiteQueryI = RoomSQLiteQuery.i("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5)", 0);
        this.f55065a.assertNotSuspendingTransaction();
        Cursor cursorH = DBUtil.h(this.f55065a, roomSQLiteQueryI, false, null);
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

    @Override // androidx.work.impl.model.WorkSpecDao
    public List B() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryI = RoomSQLiteQuery.i("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 AND LENGTH(content_uri_triggers)<>0 ORDER BY last_enqueue_time", 0);
        this.f55065a.assertNotSuspendingTransaction();
        Cursor cursorH = DBUtil.h(this.f55065a, roomSQLiteQueryI, false, null);
        try {
            int iD = CursorUtil.d(cursorH, "id");
            int iD2 = CursorUtil.d(cursorH, ServerProtocol.DIALOG_PARAM_STATE);
            int iD3 = CursorUtil.d(cursorH, "worker_class_name");
            int iD4 = CursorUtil.d(cursorH, "input_merger_class_name");
            int iD5 = CursorUtil.d(cursorH, "input");
            int iD6 = CursorUtil.d(cursorH, "output");
            int iD7 = CursorUtil.d(cursorH, "initial_delay");
            int iD8 = CursorUtil.d(cursorH, "interval_duration");
            int iD9 = CursorUtil.d(cursorH, "flex_duration");
            int iD10 = CursorUtil.d(cursorH, "run_attempt_count");
            int iD11 = CursorUtil.d(cursorH, "backoff_policy");
            int iD12 = CursorUtil.d(cursorH, "backoff_delay_duration");
            int iD13 = CursorUtil.d(cursorH, "last_enqueue_time");
            int iD14 = CursorUtil.d(cursorH, "minimum_retention_duration");
            roomSQLiteQuery = roomSQLiteQueryI;
            try {
                int iD15 = CursorUtil.d(cursorH, "schedule_requested_at");
                int iD16 = CursorUtil.d(cursorH, "run_in_foreground");
                int iD17 = CursorUtil.d(cursorH, "out_of_quota_policy");
                int iD18 = CursorUtil.d(cursorH, "period_count");
                int iD19 = CursorUtil.d(cursorH, "generation");
                int iD20 = CursorUtil.d(cursorH, "next_schedule_time_override");
                int iD21 = CursorUtil.d(cursorH, "next_schedule_time_override_generation");
                int iD22 = CursorUtil.d(cursorH, "stop_reason");
                int iD23 = CursorUtil.d(cursorH, "required_network_type");
                int iD24 = CursorUtil.d(cursorH, "requires_charging");
                int iD25 = CursorUtil.d(cursorH, "requires_device_idle");
                int iD26 = CursorUtil.d(cursorH, "requires_battery_not_low");
                int iD27 = CursorUtil.d(cursorH, lisODU.uDzkVamqRZxfe);
                int iD28 = CursorUtil.d(cursorH, "trigger_content_update_delay");
                int iD29 = CursorUtil.d(cursorH, "trigger_max_content_delay");
                int iD30 = CursorUtil.d(cursorH, "content_uri_triggers");
                int i3 = iD14;
                ArrayList arrayList = new ArrayList(cursorH.getCount());
                while (cursorH.moveToNext()) {
                    String string = cursorH.isNull(iD) ? null : cursorH.getString(iD);
                    WorkInfo.State stateF = WorkTypeConverters.f(cursorH.getInt(iD2));
                    String string2 = cursorH.isNull(iD3) ? null : cursorH.getString(iD3);
                    String string3 = cursorH.isNull(iD4) ? null : cursorH.getString(iD4);
                    Data dataG = Data.g(cursorH.isNull(iD5) ? null : cursorH.getBlob(iD5));
                    Data dataG2 = Data.g(cursorH.isNull(iD6) ? null : cursorH.getBlob(iD6));
                    long j3 = cursorH.getLong(iD7);
                    long j4 = cursorH.getLong(iD8);
                    long j5 = cursorH.getLong(iD9);
                    int i4 = cursorH.getInt(iD10);
                    BackoffPolicy backoffPolicyC = WorkTypeConverters.c(cursorH.getInt(iD11));
                    long j6 = cursorH.getLong(iD12);
                    long j7 = cursorH.getLong(iD13);
                    int i5 = i3;
                    long j8 = cursorH.getLong(i5);
                    int i6 = iD;
                    int i7 = iD15;
                    long j9 = cursorH.getLong(i7);
                    iD15 = i7;
                    int i8 = iD16;
                    boolean z2 = cursorH.getInt(i8) != 0;
                    iD16 = i8;
                    int i9 = iD17;
                    OutOfQuotaPolicy outOfQuotaPolicyE = WorkTypeConverters.e(cursorH.getInt(i9));
                    iD17 = i9;
                    int i10 = iD18;
                    int i11 = cursorH.getInt(i10);
                    iD18 = i10;
                    int i12 = iD19;
                    int i13 = cursorH.getInt(i12);
                    iD19 = i12;
                    int i14 = iD20;
                    long j10 = cursorH.getLong(i14);
                    iD20 = i14;
                    int i15 = iD21;
                    int i16 = cursorH.getInt(i15);
                    iD21 = i15;
                    int i17 = iD22;
                    int i18 = cursorH.getInt(i17);
                    iD22 = i17;
                    int i19 = iD23;
                    NetworkType networkTypeD = WorkTypeConverters.d(cursorH.getInt(i19));
                    iD23 = i19;
                    int i20 = iD24;
                    boolean z3 = cursorH.getInt(i20) != 0;
                    iD24 = i20;
                    int i21 = iD25;
                    boolean z4 = cursorH.getInt(i21) != 0;
                    iD25 = i21;
                    int i22 = iD26;
                    boolean z5 = cursorH.getInt(i22) != 0;
                    iD26 = i22;
                    int i23 = iD27;
                    boolean z6 = cursorH.getInt(i23) != 0;
                    iD27 = i23;
                    int i24 = iD28;
                    long j11 = cursorH.getLong(i24);
                    iD28 = i24;
                    int i25 = iD29;
                    long j12 = cursorH.getLong(i25);
                    iD29 = i25;
                    int i26 = iD30;
                    iD30 = i26;
                    arrayList.add(new WorkSpec(string, stateF, string2, string3, dataG, dataG2, j3, j4, j5, new Constraints(networkTypeD, z3, z4, z5, z6, j11, j12, WorkTypeConverters.b(cursorH.isNull(i26) ? null : cursorH.getBlob(i26))), i4, backoffPolicyC, j6, j7, j8, j9, z2, outOfQuotaPolicyE, i11, i13, j10, i16, i18));
                    iD = i6;
                    i3 = i5;
                }
                cursorH.close();
                roomSQLiteQuery.m();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorH.close();
                roomSQLiteQuery.m();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryI;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int G() {
        RoomSQLiteQuery roomSQLiteQueryI = RoomSQLiteQuery.i(oUcQRqOVfOC.LvPAOV, 0);
        this.f55065a.assertNotSuspendingTransaction();
        Cursor cursorH = DBUtil.h(this.f55065a, roomSQLiteQueryI, false, null);
        try {
            return cursorH.moveToFirst() ? cursorH.getInt(0) : 0;
        } finally {
            cursorH.close();
            roomSQLiteQueryI.m();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List q(int i3) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int iD;
        int iD2;
        int iD3;
        int iD4;
        int iD5;
        int iD6;
        int iD7;
        int iD8;
        int iD9;
        int iD10;
        int iD11;
        int iD12;
        int iD13;
        int iD14;
        RoomSQLiteQuery roomSQLiteQueryI = RoomSQLiteQuery.i("SELECT * FROM workspec WHERE state=0 ORDER BY last_enqueue_time LIMIT ?", 1);
        roomSQLiteQueryI.A(1, i3);
        this.f55065a.assertNotSuspendingTransaction();
        Cursor cursorH = DBUtil.h(this.f55065a, roomSQLiteQueryI, false, null);
        try {
            iD = CursorUtil.d(cursorH, "id");
            iD2 = CursorUtil.d(cursorH, ServerProtocol.DIALOG_PARAM_STATE);
            iD3 = CursorUtil.d(cursorH, "worker_class_name");
            iD4 = CursorUtil.d(cursorH, "input_merger_class_name");
            iD5 = CursorUtil.d(cursorH, "input");
            iD6 = CursorUtil.d(cursorH, "output");
            iD7 = CursorUtil.d(cursorH, "initial_delay");
            iD8 = CursorUtil.d(cursorH, "interval_duration");
            iD9 = CursorUtil.d(cursorH, "flex_duration");
            iD10 = CursorUtil.d(cursorH, "run_attempt_count");
            iD11 = CursorUtil.d(cursorH, "backoff_policy");
            iD12 = CursorUtil.d(cursorH, "backoff_delay_duration");
            iD13 = CursorUtil.d(cursorH, "last_enqueue_time");
            iD14 = CursorUtil.d(cursorH, "minimum_retention_duration");
            roomSQLiteQuery = roomSQLiteQueryI;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryI;
        }
        try {
            int iD15 = CursorUtil.d(cursorH, "schedule_requested_at");
            int iD16 = CursorUtil.d(cursorH, "run_in_foreground");
            int iD17 = CursorUtil.d(cursorH, "out_of_quota_policy");
            int iD18 = CursorUtil.d(cursorH, "period_count");
            int iD19 = CursorUtil.d(cursorH, "generation");
            int iD20 = CursorUtil.d(cursorH, "next_schedule_time_override");
            int iD21 = CursorUtil.d(cursorH, "next_schedule_time_override_generation");
            int iD22 = CursorUtil.d(cursorH, jTYhJgqLBN.IOM);
            int iD23 = CursorUtil.d(cursorH, "required_network_type");
            int iD24 = CursorUtil.d(cursorH, "requires_charging");
            int iD25 = CursorUtil.d(cursorH, "requires_device_idle");
            int iD26 = CursorUtil.d(cursorH, "requires_battery_not_low");
            int iD27 = CursorUtil.d(cursorH, "requires_storage_not_low");
            int iD28 = CursorUtil.d(cursorH, "trigger_content_update_delay");
            int iD29 = CursorUtil.d(cursorH, "trigger_max_content_delay");
            int iD30 = CursorUtil.d(cursorH, "content_uri_triggers");
            int i4 = iD14;
            ArrayList arrayList = new ArrayList(cursorH.getCount());
            while (cursorH.moveToNext()) {
                String string = cursorH.isNull(iD) ? null : cursorH.getString(iD);
                WorkInfo.State stateF = WorkTypeConverters.f(cursorH.getInt(iD2));
                String string2 = cursorH.isNull(iD3) ? null : cursorH.getString(iD3);
                String string3 = cursorH.isNull(iD4) ? null : cursorH.getString(iD4);
                Data dataG = Data.g(cursorH.isNull(iD5) ? null : cursorH.getBlob(iD5));
                Data dataG2 = Data.g(cursorH.isNull(iD6) ? null : cursorH.getBlob(iD6));
                long j3 = cursorH.getLong(iD7);
                long j4 = cursorH.getLong(iD8);
                long j5 = cursorH.getLong(iD9);
                int i5 = cursorH.getInt(iD10);
                BackoffPolicy backoffPolicyC = WorkTypeConverters.c(cursorH.getInt(iD11));
                long j6 = cursorH.getLong(iD12);
                long j7 = cursorH.getLong(iD13);
                int i6 = i4;
                long j8 = cursorH.getLong(i6);
                int i7 = iD;
                int i8 = iD15;
                long j9 = cursorH.getLong(i8);
                iD15 = i8;
                int i9 = iD16;
                boolean z2 = cursorH.getInt(i9) != 0;
                iD16 = i9;
                int i10 = iD17;
                OutOfQuotaPolicy outOfQuotaPolicyE = WorkTypeConverters.e(cursorH.getInt(i10));
                iD17 = i10;
                int i11 = iD18;
                int i12 = cursorH.getInt(i11);
                iD18 = i11;
                int i13 = iD19;
                int i14 = cursorH.getInt(i13);
                iD19 = i13;
                int i15 = iD20;
                long j10 = cursorH.getLong(i15);
                iD20 = i15;
                int i16 = iD21;
                int i17 = cursorH.getInt(i16);
                iD21 = i16;
                int i18 = iD22;
                int i19 = cursorH.getInt(i18);
                iD22 = i18;
                int i20 = iD23;
                NetworkType networkTypeD = WorkTypeConverters.d(cursorH.getInt(i20));
                iD23 = i20;
                int i21 = iD24;
                boolean z3 = cursorH.getInt(i21) != 0;
                iD24 = i21;
                int i22 = iD25;
                boolean z4 = cursorH.getInt(i22) != 0;
                iD25 = i22;
                int i23 = iD26;
                boolean z5 = cursorH.getInt(i23) != 0;
                iD26 = i23;
                int i24 = iD27;
                boolean z6 = cursorH.getInt(i24) != 0;
                iD27 = i24;
                int i25 = iD28;
                long j11 = cursorH.getLong(i25);
                iD28 = i25;
                int i26 = iD29;
                long j12 = cursorH.getLong(i26);
                iD29 = i26;
                int i27 = iD30;
                iD30 = i27;
                arrayList.add(new WorkSpec(string, stateF, string2, string3, dataG, dataG2, j3, j4, j5, new Constraints(networkTypeD, z3, z4, z5, z6, j11, j12, WorkTypeConverters.b(cursorH.isNull(i27) ? null : cursorH.getBlob(i27))), i5, backoffPolicyC, j6, j7, j8, j9, z2, outOfQuotaPolicyE, i12, i14, j10, i17, i19));
                iD = i7;
                i4 = i6;
            }
            cursorH.close();
            roomSQLiteQuery.m();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            cursorH.close();
            roomSQLiteQuery.m();
            throw th;
        }
    }
}
