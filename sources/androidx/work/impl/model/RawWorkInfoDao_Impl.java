package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import com.facebook.internal.ServerProtocol;
import cz.mobilesoft.coreblock.view.screen.ohO.MHoiDDglUlPJC;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class RawWorkInfoDao_Impl implements RawWorkInfoDao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f54979a;

    /* JADX INFO: renamed from: androidx.work.impl.model.RawWorkInfoDao_Impl$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements Callable<List<WorkSpec.WorkInfoPojo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SupportSQLiteQuery f54980a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ RawWorkInfoDao_Impl f54981b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            Data dataG;
            boolean z2;
            boolean z3;
            boolean z4;
            Set setB;
            int i3;
            Cursor cursorH = DBUtil.h(this.f54981b.f54979a, this.f54980a, true, null);
            try {
                int iC = CursorUtil.c(cursorH, "id");
                int iC2 = CursorUtil.c(cursorH, ServerProtocol.DIALOG_PARAM_STATE);
                int iC3 = CursorUtil.c(cursorH, "output");
                int iC4 = CursorUtil.c(cursorH, "initial_delay");
                int iC5 = CursorUtil.c(cursorH, "interval_duration");
                int iC6 = CursorUtil.c(cursorH, "flex_duration");
                int iC7 = CursorUtil.c(cursorH, "run_attempt_count");
                int iC8 = CursorUtil.c(cursorH, "backoff_policy");
                int iC9 = CursorUtil.c(cursorH, "backoff_delay_duration");
                int iC10 = CursorUtil.c(cursorH, "last_enqueue_time");
                int iC11 = CursorUtil.c(cursorH, "period_count");
                int iC12 = CursorUtil.c(cursorH, "generation");
                int iC13 = CursorUtil.c(cursorH, "next_schedule_time_override");
                int iC14 = CursorUtil.c(cursorH, "stop_reason");
                int iC15 = CursorUtil.c(cursorH, "required_network_type");
                int iC16 = CursorUtil.c(cursorH, "requires_charging");
                int iC17 = CursorUtil.c(cursorH, "requires_device_idle");
                int iC18 = CursorUtil.c(cursorH, "requires_battery_not_low");
                int iC19 = CursorUtil.c(cursorH, "requires_storage_not_low");
                int iC20 = CursorUtil.c(cursorH, "trigger_content_update_delay");
                int iC21 = CursorUtil.c(cursorH, "trigger_max_content_delay");
                int iC22 = CursorUtil.c(cursorH, "content_uri_triggers");
                HashMap map = new HashMap();
                int i4 = iC13;
                HashMap map2 = new HashMap();
                while (cursorH.moveToNext()) {
                    int i5 = iC12;
                    String string = cursorH.getString(iC);
                    if (((ArrayList) map.get(string)) == null) {
                        i3 = iC11;
                        map.put(string, new ArrayList());
                    } else {
                        i3 = iC11;
                    }
                    String string2 = cursorH.getString(iC);
                    if (((ArrayList) map2.get(string2)) == null) {
                        map2.put(string2, new ArrayList());
                    }
                    iC12 = i5;
                    iC11 = i3;
                }
                int i6 = iC11;
                int i7 = iC12;
                cursorH.moveToPosition(-1);
                this.f54981b.c(map);
                this.f54981b.b(map2);
                ArrayList arrayList = new ArrayList(cursorH.getCount());
                while (cursorH.moveToNext()) {
                    String string3 = (iC == -1 || cursorH.isNull(iC)) ? null : cursorH.getString(iC);
                    WorkInfo.State stateF = iC2 == -1 ? null : WorkTypeConverters.f(cursorH.getInt(iC2));
                    if (iC3 == -1) {
                        dataG = null;
                    } else {
                        dataG = Data.g(cursorH.isNull(iC3) ? null : cursorH.getBlob(iC3));
                    }
                    long j3 = iC4 == -1 ? 0L : cursorH.getLong(iC4);
                    long j4 = iC5 == -1 ? 0L : cursorH.getLong(iC5);
                    long j5 = iC6 == -1 ? 0L : cursorH.getLong(iC6);
                    boolean z5 = false;
                    int i8 = iC7 == -1 ? 0 : cursorH.getInt(iC7);
                    BackoffPolicy backoffPolicyC = iC8 == -1 ? null : WorkTypeConverters.c(cursorH.getInt(iC8));
                    long j6 = iC9 == -1 ? 0L : cursorH.getLong(iC9);
                    long j7 = iC10 == -1 ? 0L : cursorH.getLong(iC10);
                    int i9 = i6;
                    int i10 = i9 == -1 ? 0 : cursorH.getInt(i9);
                    i6 = i9;
                    int i11 = i7;
                    int i12 = i11 == -1 ? 0 : cursorH.getInt(i11);
                    i7 = i11;
                    int i13 = i4;
                    long j8 = i13 == -1 ? 0L : cursorH.getLong(i13);
                    i4 = i13;
                    int i14 = iC14;
                    int i15 = i14 == -1 ? 0 : cursorH.getInt(i14);
                    iC14 = i14;
                    int i16 = iC15;
                    NetworkType networkTypeD = i16 == -1 ? null : WorkTypeConverters.d(cursorH.getInt(i16));
                    iC15 = i16;
                    int i17 = iC16;
                    if (i17 == -1) {
                        z2 = false;
                    } else {
                        z2 = cursorH.getInt(i17) != 0;
                    }
                    iC16 = i17;
                    int i18 = iC17;
                    if (i18 == -1) {
                        z3 = false;
                    } else {
                        z3 = cursorH.getInt(i18) != 0;
                    }
                    iC17 = i18;
                    int i19 = iC18;
                    if (i19 == -1) {
                        z4 = false;
                    } else {
                        z4 = cursorH.getInt(i19) != 0;
                    }
                    iC18 = i19;
                    int i20 = iC19;
                    if (i20 != -1 && cursorH.getInt(i20) != 0) {
                        z5 = true;
                    }
                    iC19 = i20;
                    int i21 = iC20;
                    boolean z6 = z5;
                    long j9 = i21 == -1 ? 0L : cursorH.getLong(i21);
                    iC20 = i21;
                    int i22 = iC21;
                    long j10 = i22 != -1 ? cursorH.getLong(i22) : 0L;
                    iC21 = i22;
                    int i23 = iC22;
                    long j11 = j10;
                    if (i23 == -1) {
                        setB = null;
                    } else {
                        setB = WorkTypeConverters.b(cursorH.isNull(i23) ? null : cursorH.getBlob(i23));
                    }
                    Constraints constraints = new Constraints(networkTypeD, z2, z3, z4, z6, j9, j11, setB);
                    ArrayList arrayList2 = (ArrayList) map.get(cursorH.getString(iC));
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    ArrayList arrayList3 = (ArrayList) map2.get(cursorH.getString(iC));
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                    }
                    arrayList.add(new WorkSpec.WorkInfoPojo(string3, stateF, dataG, j3, j4, j5, constraints, i8, backoffPolicyC, j6, j7, i10, i12, j8, i15, arrayList2, arrayList3));
                    iC22 = i23;
                }
                cursorH.close();
                return arrayList;
            } catch (Throwable th) {
                cursorH.close();
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.work.impl.model.RawWorkInfoDao_Impl$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 implements Callable<List<WorkSpec.WorkInfoPojo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SupportSQLiteQuery f54982a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ RawWorkInfoDao_Impl f54983b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            Data dataG;
            boolean z2;
            boolean z3;
            boolean z4;
            Set setB;
            int i3;
            Cursor cursorH = DBUtil.h(this.f54983b.f54979a, this.f54982a, true, null);
            try {
                int iC = CursorUtil.c(cursorH, "id");
                int iC2 = CursorUtil.c(cursorH, ServerProtocol.DIALOG_PARAM_STATE);
                int iC3 = CursorUtil.c(cursorH, "output");
                int iC4 = CursorUtil.c(cursorH, "initial_delay");
                int iC5 = CursorUtil.c(cursorH, "interval_duration");
                int iC6 = CursorUtil.c(cursorH, "flex_duration");
                int iC7 = CursorUtil.c(cursorH, "run_attempt_count");
                int iC8 = CursorUtil.c(cursorH, "backoff_policy");
                int iC9 = CursorUtil.c(cursorH, "backoff_delay_duration");
                int iC10 = CursorUtil.c(cursorH, "last_enqueue_time");
                int iC11 = CursorUtil.c(cursorH, "period_count");
                int iC12 = CursorUtil.c(cursorH, "generation");
                int iC13 = CursorUtil.c(cursorH, "next_schedule_time_override");
                int iC14 = CursorUtil.c(cursorH, "stop_reason");
                int iC15 = CursorUtil.c(cursorH, "required_network_type");
                int iC16 = CursorUtil.c(cursorH, "requires_charging");
                int iC17 = CursorUtil.c(cursorH, "requires_device_idle");
                int iC18 = CursorUtil.c(cursorH, "requires_battery_not_low");
                int iC19 = CursorUtil.c(cursorH, "requires_storage_not_low");
                int iC20 = CursorUtil.c(cursorH, "trigger_content_update_delay");
                int iC21 = CursorUtil.c(cursorH, "trigger_max_content_delay");
                int iC22 = CursorUtil.c(cursorH, "content_uri_triggers");
                HashMap map = new HashMap();
                int i4 = iC13;
                HashMap map2 = new HashMap();
                while (cursorH.moveToNext()) {
                    int i5 = iC12;
                    String string = cursorH.getString(iC);
                    if (((ArrayList) map.get(string)) == null) {
                        i3 = iC11;
                        map.put(string, new ArrayList());
                    } else {
                        i3 = iC11;
                    }
                    String string2 = cursorH.getString(iC);
                    if (((ArrayList) map2.get(string2)) == null) {
                        map2.put(string2, new ArrayList());
                    }
                    iC12 = i5;
                    iC11 = i3;
                }
                int i6 = iC11;
                int i7 = iC12;
                cursorH.moveToPosition(-1);
                this.f54983b.c(map);
                this.f54983b.b(map2);
                ArrayList arrayList = new ArrayList(cursorH.getCount());
                while (cursorH.moveToNext()) {
                    String string3 = (iC == -1 || cursorH.isNull(iC)) ? null : cursorH.getString(iC);
                    WorkInfo.State stateF = iC2 == -1 ? null : WorkTypeConverters.f(cursorH.getInt(iC2));
                    if (iC3 == -1) {
                        dataG = null;
                    } else {
                        dataG = Data.g(cursorH.isNull(iC3) ? null : cursorH.getBlob(iC3));
                    }
                    long j3 = iC4 == -1 ? 0L : cursorH.getLong(iC4);
                    long j4 = iC5 == -1 ? 0L : cursorH.getLong(iC5);
                    long j5 = iC6 == -1 ? 0L : cursorH.getLong(iC6);
                    boolean z5 = false;
                    int i8 = iC7 == -1 ? 0 : cursorH.getInt(iC7);
                    BackoffPolicy backoffPolicyC = iC8 == -1 ? null : WorkTypeConverters.c(cursorH.getInt(iC8));
                    long j6 = iC9 == -1 ? 0L : cursorH.getLong(iC9);
                    long j7 = iC10 == -1 ? 0L : cursorH.getLong(iC10);
                    int i9 = i6;
                    int i10 = i9 == -1 ? 0 : cursorH.getInt(i9);
                    i6 = i9;
                    int i11 = i7;
                    int i12 = i11 == -1 ? 0 : cursorH.getInt(i11);
                    i7 = i11;
                    int i13 = i4;
                    long j8 = i13 == -1 ? 0L : cursorH.getLong(i13);
                    i4 = i13;
                    int i14 = iC14;
                    int i15 = i14 == -1 ? 0 : cursorH.getInt(i14);
                    iC14 = i14;
                    int i16 = iC15;
                    NetworkType networkTypeD = i16 == -1 ? null : WorkTypeConverters.d(cursorH.getInt(i16));
                    iC15 = i16;
                    int i17 = iC16;
                    if (i17 == -1) {
                        z2 = false;
                    } else {
                        z2 = cursorH.getInt(i17) != 0;
                    }
                    iC16 = i17;
                    int i18 = iC17;
                    if (i18 == -1) {
                        z3 = false;
                    } else {
                        z3 = cursorH.getInt(i18) != 0;
                    }
                    iC17 = i18;
                    int i19 = iC18;
                    if (i19 == -1) {
                        z4 = false;
                    } else {
                        z4 = cursorH.getInt(i19) != 0;
                    }
                    iC18 = i19;
                    int i20 = iC19;
                    if (i20 != -1 && cursorH.getInt(i20) != 0) {
                        z5 = true;
                    }
                    iC19 = i20;
                    int i21 = iC20;
                    boolean z6 = z5;
                    long j9 = i21 == -1 ? 0L : cursorH.getLong(i21);
                    iC20 = i21;
                    int i22 = iC21;
                    long j10 = i22 != -1 ? cursorH.getLong(i22) : 0L;
                    iC21 = i22;
                    int i23 = iC22;
                    long j11 = j10;
                    if (i23 == -1) {
                        setB = null;
                    } else {
                        setB = WorkTypeConverters.b(cursorH.isNull(i23) ? null : cursorH.getBlob(i23));
                    }
                    Constraints constraints = new Constraints(networkTypeD, z2, z3, z4, z6, j9, j11, setB);
                    ArrayList arrayList2 = (ArrayList) map.get(cursorH.getString(iC));
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    ArrayList arrayList3 = (ArrayList) map2.get(cursorH.getString(iC));
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                    }
                    arrayList.add(new WorkSpec.WorkInfoPojo(string3, stateF, dataG, j3, j4, j5, constraints, i8, backoffPolicyC, j6, j7, i10, i12, j8, i15, arrayList2, arrayList3));
                    iC22 = i23;
                }
                cursorH.close();
                return arrayList;
            } catch (Throwable th) {
                cursorH.close();
                throw th;
            }
        }
    }

    public RawWorkInfoDao_Impl(RoomDatabase roomDatabase) {
        this.f54979a = roomDatabase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(HashMap map) {
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
                b(map2);
                map2 = new HashMap(999);
            }
            if (i3 > 0) {
                b(map2);
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
        Cursor cursorH = DBUtil.h(this.f54979a, roomSQLiteQueryI, false, null);
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
    public void c(HashMap map) {
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
                c(map2);
                map2 = new HashMap(999);
            }
            if (i3 > 0) {
                c(map2);
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
        Cursor cursorH = DBUtil.h(this.f54979a, roomSQLiteQueryI, false, null);
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

    public static List g() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.work.impl.model.RawWorkInfoDao
    public List a(SupportSQLiteQuery supportSQLiteQuery) {
        Data dataG;
        boolean z2;
        boolean z3;
        boolean z4;
        Set setB;
        int i3;
        this.f54979a.assertNotSuspendingTransaction();
        Cursor cursorH = DBUtil.h(this.f54979a, supportSQLiteQuery, true, null);
        try {
            int iC = CursorUtil.c(cursorH, "id");
            int iC2 = CursorUtil.c(cursorH, ServerProtocol.DIALOG_PARAM_STATE);
            int iC3 = CursorUtil.c(cursorH, "output");
            int iC4 = CursorUtil.c(cursorH, "initial_delay");
            int iC5 = CursorUtil.c(cursorH, "interval_duration");
            int iC6 = CursorUtil.c(cursorH, "flex_duration");
            int iC7 = CursorUtil.c(cursorH, "run_attempt_count");
            int iC8 = CursorUtil.c(cursorH, "backoff_policy");
            int iC9 = CursorUtil.c(cursorH, "backoff_delay_duration");
            int iC10 = CursorUtil.c(cursorH, "last_enqueue_time");
            int iC11 = CursorUtil.c(cursorH, "period_count");
            int iC12 = CursorUtil.c(cursorH, "generation");
            int iC13 = CursorUtil.c(cursorH, "next_schedule_time_override");
            int iC14 = CursorUtil.c(cursorH, MHoiDDglUlPJC.DstsQ);
            int iC15 = CursorUtil.c(cursorH, "required_network_type");
            int iC16 = CursorUtil.c(cursorH, "requires_charging");
            int iC17 = CursorUtil.c(cursorH, "requires_device_idle");
            int iC18 = CursorUtil.c(cursorH, "requires_battery_not_low");
            int iC19 = CursorUtil.c(cursorH, "requires_storage_not_low");
            int iC20 = CursorUtil.c(cursorH, "trigger_content_update_delay");
            int iC21 = CursorUtil.c(cursorH, "trigger_max_content_delay");
            int iC22 = CursorUtil.c(cursorH, "content_uri_triggers");
            HashMap map = new HashMap();
            int i4 = iC13;
            HashMap map2 = new HashMap();
            while (cursorH.moveToNext()) {
                int i5 = iC12;
                String string = cursorH.getString(iC);
                if (((ArrayList) map.get(string)) == null) {
                    i3 = iC11;
                    map.put(string, new ArrayList());
                } else {
                    i3 = iC11;
                }
                String string2 = cursorH.getString(iC);
                if (((ArrayList) map2.get(string2)) == null) {
                    map2.put(string2, new ArrayList());
                }
                iC12 = i5;
                iC11 = i3;
            }
            int i6 = iC11;
            int i7 = iC12;
            cursorH.moveToPosition(-1);
            c(map);
            b(map2);
            ArrayList arrayList = new ArrayList(cursorH.getCount());
            while (cursorH.moveToNext()) {
                String string3 = (iC == -1 || cursorH.isNull(iC)) ? null : cursorH.getString(iC);
                WorkInfo.State stateF = iC2 == -1 ? null : WorkTypeConverters.f(cursorH.getInt(iC2));
                if (iC3 == -1) {
                    dataG = null;
                } else {
                    dataG = Data.g(cursorH.isNull(iC3) ? null : cursorH.getBlob(iC3));
                }
                long j3 = iC4 == -1 ? 0L : cursorH.getLong(iC4);
                long j4 = iC5 == -1 ? 0L : cursorH.getLong(iC5);
                long j5 = iC6 == -1 ? 0L : cursorH.getLong(iC6);
                boolean z5 = false;
                int i8 = iC7 == -1 ? 0 : cursorH.getInt(iC7);
                BackoffPolicy backoffPolicyC = iC8 == -1 ? null : WorkTypeConverters.c(cursorH.getInt(iC8));
                long j6 = iC9 == -1 ? 0L : cursorH.getLong(iC9);
                long j7 = iC10 == -1 ? 0L : cursorH.getLong(iC10);
                int i9 = i6;
                int i10 = i9 == -1 ? 0 : cursorH.getInt(i9);
                i6 = i9;
                int i11 = i7;
                int i12 = i11 == -1 ? 0 : cursorH.getInt(i11);
                i7 = i11;
                int i13 = i4;
                long j8 = i13 == -1 ? 0L : cursorH.getLong(i13);
                i4 = i13;
                int i14 = iC14;
                int i15 = i14 == -1 ? 0 : cursorH.getInt(i14);
                iC14 = i14;
                int i16 = iC15;
                NetworkType networkTypeD = i16 == -1 ? null : WorkTypeConverters.d(cursorH.getInt(i16));
                iC15 = i16;
                int i17 = iC16;
                if (i17 == -1) {
                    z2 = false;
                } else {
                    z2 = cursorH.getInt(i17) != 0;
                }
                iC16 = i17;
                int i18 = iC17;
                if (i18 == -1) {
                    z3 = false;
                } else {
                    z3 = cursorH.getInt(i18) != 0;
                }
                iC17 = i18;
                int i19 = iC18;
                if (i19 == -1) {
                    z4 = false;
                } else {
                    z4 = cursorH.getInt(i19) != 0;
                }
                iC18 = i19;
                int i20 = iC19;
                if (i20 != -1 && cursorH.getInt(i20) != 0) {
                    z5 = true;
                }
                iC19 = i20;
                int i21 = iC20;
                boolean z6 = z5;
                long j9 = i21 == -1 ? 0L : cursorH.getLong(i21);
                iC20 = i21;
                int i22 = iC21;
                long j10 = i22 != -1 ? cursorH.getLong(i22) : 0L;
                iC21 = i22;
                int i23 = iC22;
                long j11 = j10;
                if (i23 == -1) {
                    setB = null;
                } else {
                    setB = WorkTypeConverters.b(cursorH.isNull(i23) ? null : cursorH.getBlob(i23));
                }
                Constraints constraints = new Constraints(networkTypeD, z2, z3, z4, z6, j9, j11, setB);
                ArrayList arrayList2 = (ArrayList) map.get(cursorH.getString(iC));
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                ArrayList arrayList3 = (ArrayList) map2.get(cursorH.getString(iC));
                if (arrayList3 == null) {
                    arrayList3 = new ArrayList();
                }
                arrayList.add(new WorkSpec.WorkInfoPojo(string3, stateF, dataG, j3, j4, j5, constraints, i8, backoffPolicyC, j6, j7, i10, i12, j8, i15, arrayList2, arrayList3));
                iC22 = i23;
            }
            cursorH.close();
            return arrayList;
        } catch (Throwable th) {
            cursorH.close();
            throw th;
        }
    }
}
