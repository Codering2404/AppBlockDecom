package cz.mobilesoft.coreblock.util.runnability;

import android.content.ComponentName;
import com.evernote.android.job.JobManager;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.service.job.AutoTrialExpiredNotificationJob;
import cz.mobilesoft.coreblock.service.job.JobPlanner;
import cz.mobilesoft.coreblock.service.job.TrialExpiringNotificationJob;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.notifications.NotificationHelper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
public class JobHelper {
    public static void A() {
        JobPlanner.b().j("LOCK_SERVICE_CHECK");
    }

    public static void B() {
        JobPlanner.b().j("LOCK_SERVICE_RESTART");
    }

    public static void C() {
        JobPlanner.b().j("TAG_NOTIFICATION_STATISTICS_WEEK_COMPARISON");
    }

    public static void D(long j3, long j4, long j5, boolean z2) {
        JobPlanner.b().k(j3, j4, j5, z2);
    }

    public static void E(long j3, long j4, long j5, boolean z2) {
        JobPlanner.b().l(j3, j4, j5, z2);
    }

    public static void F(long j3) {
        JobPlanner.b().d(j3);
    }

    public static void G(long j3, long j4) {
        JobPlanner.b().n(j3, j4);
    }

    public static void H() {
        JobPlanner.b().j("TAG_STREAK_ACHIEVEMENT_NOTIFICATION");
    }

    public static void I() {
        JobPlanner.b().j("TAG_STREAK_NUDGE_NOTIFICATION");
    }

    public static void J() {
        JobPlanner.b().j("TAG_SUBSCRIPTION_EXPIRED_OFFER_1");
    }

    public static void K(boolean z2) {
        JobPlanner.b().o(z2);
    }

    public static void L() {
        J();
        K(false);
    }

    public static void M(boolean z2) {
        JobPlanner.b().j(z2 ? "WIFI_AVAILABLE" : "WIFI_AVAILABLE_NOW");
    }

    public static void N(ComponentName componentName) {
        JobPlanner.b().g(componentName);
    }

    public static void O() {
        JobPlanner.b().j("STRICT_MODE_STARTED_NOW");
    }

    public static void a() {
        NotificationHelper.f128940a.b(LockieApplication.g());
        JobManager.v().e("TAG_AUTO_TRIAL_EXPIRED");
    }

    public static void b() {
        JobManager.v().e("TAG_DISCOUNT_NOTIFICATION");
    }

    public static void c() {
        JobManager.v().e("TAG_CAMPAIGN_BEFORE_EXPIRATION");
        JobManager.v().e("TAG_CAMPAIGN_EXPIRATION");
    }

    public static void d() {
        JobManager.v().e("IN_APP_UPDATE_PENDING_NOTIFICATION");
    }

    public static void e() {
        JobManager.v().e("TAG_STREAK_ACHIEVEMENT_NOTIFICATION");
    }

    public static void f() {
        JobManager.v().e("TAG_STREAK_NUDGE_NOTIFICATION");
    }

    public static void g() {
        PrefManager.f126839a.J2(-1);
        JobManager.v().e("TAG_SUBSCRIPTION_EXPIRED_OFFER_1");
    }

    public static void h() {
        PrefManager.f126839a.J2(-1);
        JobManager.v().e("TAG_SUBSCRIPTION_EXPIRED_OFFER_2");
    }

    public static void i() {
        g();
        h();
    }

    public static void j() {
        NotificationHelper.f128940a.j(LockieApplication.g());
        JobManager.v().e("TAG_TRIAL_EXPIRING");
    }

    public static void k(long j3) {
        JobManager.i(LockieApplication.g()).e("PROFILE_DEACTIVATION_WITH_ID_" + j3);
    }

    public static void l() {
        JobManager.i(LockieApplication.g()).e("LOCK_SERVICE_RESTART");
    }

    public static void m() {
        JobPlanner.b().j("PROFILE_ACTIVATED_NOW");
    }

    public static void n(long j3) {
        AutoTrialExpiredNotificationJob.f123175l.b(j3);
    }

    public static void o(long j3) {
        TrialExpiringNotificationJob.f123508k.b(j3);
    }

    public static void p() {
        JobPlanner.b().j("PROFILE_ACTIVATED_NOW");
    }

    public static void q(long j3, long j4, boolean z2, boolean z3) {
        JobPlanner.b().m(j3, j4, z2, z3);
    }

    public static void r() {
        JobPlanner.b().j("DETAIL_CHANGED");
    }

    public static void s() {
        JobPlanner.b().p();
    }

    public static void t() {
        JobPlanner.b().j("TAG_APPLICATION_ACCESS_UPDATE");
    }

    public static void u(String str) {
        JobPlanner.b().h(str);
    }

    public static void v() {
        JobPlanner.b().j("TAG_DISCOUNT_NOTIFICATION");
    }

    public static void w(long j3) {
        JobPlanner.b().e(j3);
        JobPlanner.b().f(j3);
    }

    public static void x() {
        JobPlanner.b().j("GEOFENCE_RECREATION");
    }

    public static void y() {
        JobPlanner.b().j("LOCK_SERVICE_CHECK_NOW");
    }

    public static void z(long j3) {
        JobPlanner.b().i(j3);
    }
}
