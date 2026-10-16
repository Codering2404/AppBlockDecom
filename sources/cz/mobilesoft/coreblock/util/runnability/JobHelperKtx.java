package cz.mobilesoft.coreblock.util.runnability;

import android.app.job.JobScheduler;
import android.content.Context;
import android.util.Log;
import com.evernote.android.job.JobManager;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.service.job.IntervalStartJob;
import cz.mobilesoft.coreblock.service.job.NotificationForPomodoroSession;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.PomodoroSession;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.DateHelper;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class JobHelperKtx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IntervalDao f129554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ProfileDao f129555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EventDataStore f129556c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final DevDataStore f129557d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final NotificationDataStore f129558e;

    public JobHelperKtx(IntervalDao intervalDao, ProfileDao profileDao, EventDataStore eventDataStore, DevDataStore devDataStore, NotificationDataStore notificationDataStore) {
        Intrinsics.checkNotNullParameter(intervalDao, "intervalDao");
        Intrinsics.checkNotNullParameter(profileDao, "profileDao");
        Intrinsics.checkNotNullParameter(eventDataStore, "eventDataStore");
        Intrinsics.checkNotNullParameter(devDataStore, "devDataStore");
        Intrinsics.checkNotNullParameter(notificationDataStore, "notificationDataStore");
        this.f129554a = intervalDao;
        this.f129555b = profileDao;
        this.f129556c = eventDataStore;
        this.f129557d = devDataStore;
        this.f129558e = notificationDataStore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005f, code lost:
    
        if (r11 == r0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0093, code lost:
    
        if (r11 == r0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0095, code lost:
    
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0093 -> B:26:0x0096). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object h(android.content.Context r10, kotlin.coroutines.Continuation r11) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r11 instanceof cz.mobilesoft.coreblock.util.runnability.JobHelperKtx$cancelDeprecatedForAllActiveProfiles$1
            if (r0 == 0) goto L14
            r0 = r11
            cz.mobilesoft.coreblock.util.runnability.JobHelperKtx$cancelDeprecatedForAllActiveProfiles$1 r0 = (cz.mobilesoft.coreblock.util.runnability.JobHelperKtx$cancelDeprecatedForAllActiveProfiles$1) r0
            int r1 = r0.f129577h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f129577h = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            cz.mobilesoft.coreblock.util.runnability.JobHelperKtx$cancelDeprecatedForAllActiveProfiles$1 r0 = new cz.mobilesoft.coreblock.util.runnability.JobHelperKtx$cancelDeprecatedForAllActiveProfiles$1
            r0.<init>(r9, r11)
            goto L12
        L1a:
            java.lang.Object r11 = r4.f129575f
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.f129577h
            r7 = 2
            r2 = 1
            if (r1 == 0) goto L4e
            if (r1 == r2) goto L46
            if (r1 != r7) goto L3e
            java.lang.Object r10 = r4.f129574d
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r10 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) r10
            java.lang.Object r10 = r4.f129573c
            java.util.Iterator r10 = (java.util.Iterator) r10
            java.lang.Object r1 = r4.f129572b
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r2 = r4.f129571a
            android.content.Context r2 = (android.content.Context) r2
            kotlin.ResultKt.b(r11)
            goto L96
        L3e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L46:
            java.lang.Object r10 = r4.f129571a
            android.content.Context r10 = (android.content.Context) r10
            kotlin.ResultKt.b(r11)
            goto L62
        L4e:
            kotlin.ResultKt.b(r11)
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r1 = r9.f129555b
            r4.f129571a = r10
            r4.f129577h = r2
            r2 = 1
            r3 = 0
            r5 = 2
            r6 = 0
            java.lang.Object r11 = cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao.v0(r1, r2, r3, r4, r5, r6)
            if (r11 != r0) goto L62
            goto L95
        L62:
            java.util.List r11 = (java.util.List) r11
            java.util.Iterator r1 = r11.iterator()
            r2 = r10
            r10 = r1
            r1 = r11
        L6b:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto Lac
            java.lang.Object r11 = r10.next()
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r11 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) r11
            cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao r3 = r9.f129554a
            long r5 = r11.r()
            r4.f129571a = r2
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r1)
            r4.f129572b = r8
            r4.f129573c = r10
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.a(r11)
            r4.f129574d = r11
            r4.f129577h = r7
            java.lang.Object r11 = r3.T(r5, r4)
            if (r11 != r0) goto L96
        L95:
            return r0
        L96:
            java.util.List r11 = (java.util.List) r11
            java.util.Iterator r11 = r11.iterator()
        L9c:
            boolean r3 = r11.hasNext()
            if (r3 == 0) goto L6b
            java.lang.Object r3 = r11.next()
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval r3 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval) r3
            r9.i(r3, r2)
            goto L9c
        Lac:
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.runnability.JobHelperKtx.h(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void i(Interval interval, Context context) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService(JobScheduler.class);
        if (jobScheduler == null) {
            return;
        }
        jobScheduler.cancel((int) interval.e());
        Log.d(JobHelper.class.getSimpleName(), "Job canceled for interval " + interval.e());
    }

    private final void m(Interval interval, Integer num) {
        long jA = (interval.a() * 60000) - DateHelper.i();
        IntervalStartJob.Companion companion = IntervalStartJob.f123296o;
        companion.a(interval.e(), interval.b() * 60000, jA < 0, false, num);
        companion.a(interval.e(), interval.a() * 60000, jA < 0, true, num);
    }

    public final void e(PomodoroSession pomodoroSession) {
        Intrinsics.checkNotNullParameter(pomodoroSession, "pomodoroSession");
        int i3 = 0;
        for (Object obj : pomodoroSession.f()) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            PomodoroSession.SessionMode sessionMode = (PomodoroSession.SessionMode) ((Pair) obj).a();
            JobManager.v().e("TAG_POMODORO_SESSION_JOB_" + sessionMode.c() + (i3 / 2));
            i3 = i4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0121, code lost:
    
        if (r2.m2(r4, r7, r0) == r1) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object f(cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r11, kotlin.coroutines.Continuation r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.runnability.JobHelperKtx.f(cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object g(android.content.Context r10, kotlin.coroutines.Continuation r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 209
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.runnability.JobHelperKtx.g(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x006b, code lost:
    
        if (r12 == r0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00c2, code lost:
    
        if (r12.n2(r5, r3, r4) == r0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00c4, code lost:
    
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00c2 -> B:26:0x00c5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object j(android.content.Context r11, kotlin.coroutines.Continuation r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.runnability.JobHelperKtx.j(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x006a, code lost:
    
        if (r14 == r0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0097, code lost:
    
        if (r14 == r0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0099, code lost:
    
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0097 -> B:26:0x009a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object k(android.content.Context r13, kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.runnability.JobHelperKtx.k(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void l(Profile profile) {
        Intrinsics.checkNotNullParameter(profile, "profile");
        JobManager.v().e("TAG_BEFORE_PAUSE_END_JOB_" + profile.r());
        CoroutinesHelperExtKt.d(new JobHelperKtx$onProfileResumed$1(this, profile, null));
    }

    public final void n(long j3, PomodoroSession pomodoroSession, boolean z2) {
        Intrinsics.checkNotNullParameter(pomodoroSession, "pomodoroSession");
        boolean zBooleanValue = ((Boolean) BuildersKt__BuildersKt.b(null, new JobHelperKtx$planPomodoroSessionNotifications$showNotifications$1(this, null), 1, null)).booleanValue();
        JobManager.i(LockieApplication.g()).e("PROFILE_DEACTIVATION_WITH_ID_" + j3);
        e(pomodoroSession);
        long jF = TimeHelperExt.f128663a.f();
        if (zBooleanValue) {
            JobHelper.D(j3, (pomodoroSession.m() - jF) + 500, jF, true);
        }
        boolean zBooleanValue2 = ((Boolean) BuildersKt__BuildersKt.b(null, new JobHelperKtx$planPomodoroSessionNotifications$pomodoroInSeconds$1(this, null), 1, null)).booleanValue();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long jG = pomodoroSession.g();
        if (zBooleanValue2) {
            jG *= (long) 60;
        }
        long minutes = timeUnit.toMinutes(jG);
        int i3 = 0;
        for (Object obj : pomodoroSession.f()) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Pair pair = (Pair) obj;
            PomodoroSession.SessionMode sessionMode = (PomodoroSession.SessionMode) pair.a();
            long jLongValue = ((Number) pair.b()).longValue();
            if (jLongValue > jF) {
                boolean z3 = zBooleanValue;
                NotificationForPomodoroSession.f123359k.b(sessionMode, i3 / 2, minutes, (sessionMode instanceof PomodoroSession.SessionMode.Focus ? pomodoroSession.k() : pomodoroSession.g()) + jLongValue, jLongValue - jF, z3);
                zBooleanValue = z3;
            }
            i3 = i4;
        }
        PomodoroSession.SessionMode sessionModeJ = pomodoroSession.j();
        int iC = pomodoroSession.c();
        if (z2) {
            NotificationForPomodoroSession.f123359k.a(sessionModeJ, iC, minutes, pomodoroSession.h(), zBooleanValue);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object o(cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.runnability.JobHelperKtx.o(cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0055, code lost:
    
        if (r9 == r0) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object p(kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r9 instanceof cz.mobilesoft.coreblock.util.runnability.JobHelperKtx$scheduleForAllActiveProfiles$1
            if (r0 == 0) goto L14
            r0 = r9
            cz.mobilesoft.coreblock.util.runnability.JobHelperKtx$scheduleForAllActiveProfiles$1 r0 = (cz.mobilesoft.coreblock.util.runnability.JobHelperKtx$scheduleForAllActiveProfiles$1) r0
            int r1 = r0.f129615g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f129615g = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            cz.mobilesoft.coreblock.util.runnability.JobHelperKtx$scheduleForAllActiveProfiles$1 r0 = new cz.mobilesoft.coreblock.util.runnability.JobHelperKtx$scheduleForAllActiveProfiles$1
            r0.<init>(r8, r9)
            goto L12
        L1a:
            java.lang.Object r9 = r4.f129613d
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.f129615g
            r7 = 2
            r2 = 1
            if (r1 == 0) goto L46
            if (r1 == r2) goto L42
            if (r1 != r7) goto L3a
            java.lang.Object r1 = r4.f129612c
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r1 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) r1
            java.lang.Object r1 = r4.f129611b
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r2 = r4.f129610a
            java.util.List r2 = (java.util.List) r2
            kotlin.ResultKt.b(r9)
            goto L5f
        L3a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L42:
            kotlin.ResultKt.b(r9)
            goto L58
        L46:
            kotlin.ResultKt.b(r9)
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r1 = r8.f129555b
            r4.f129615g = r2
            r2 = 1
            r3 = 0
            r5 = 2
            r6 = 0
            java.lang.Object r9 = cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao.v0(r1, r2, r3, r4, r5, r6)
            if (r9 != r0) goto L58
            goto L81
        L58:
            java.util.List r9 = (java.util.List) r9
            java.util.Iterator r1 = r9.iterator()
            r2 = r9
        L5f:
            boolean r9 = r1.hasNext()
            if (r9 == 0) goto L82
            java.lang.Object r9 = r1.next()
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r9 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) r9
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.a(r2)
            r4.f129610a = r3
            r4.f129611b = r1
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.a(r9)
            r4.f129612c = r3
            r4.f129615g = r7
            java.lang.Object r9 = r8.o(r9, r4)
            if (r9 != r0) goto L5f
        L81:
            return r0
        L82:
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.runnability.JobHelperKtx.p(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
