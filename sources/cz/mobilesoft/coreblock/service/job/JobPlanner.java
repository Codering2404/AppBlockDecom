package cz.mobilesoft.coreblock.service.job;

import android.content.ComponentName;
import androidx.compose.animation.core.Xrg.muQRKXGtpOhe;
import com.applovin.exoplayer2.common.base.Ascii;
import com.evernote.android.job.Job;
import com.evernote.android.job.JobCreator;
import com.evernote.android.job.JobManager;
import cz.mobilesoft.coreblock.util.updates.InAppUpdateCheckJob;
import cz.mobilesoft.coreblock.util.updates.InAppUpdatePendingNotificationJob;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
public class JobPlanner implements JobCreator {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static JobPlanner f123339b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JobEventsListener f123340a;

    private JobPlanner() {
    }

    public static JobPlanner b() {
        if (f123339b == null) {
            f123339b = new JobPlanner();
        }
        return f123339b;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.evernote.android.job.JobCreator
    public Job a(String str) {
        str.getClass();
        byte b3 = -1;
        switch (str.hashCode()) {
            case -1914372606:
                if (str.equals("TAG_MOCK_DAILY_INSIGHTS_MOTIVATION_JOB")) {
                    b3 = 0;
                }
                break;
            case -1499868633:
                if (str.equals("TAG_NOTIFICATION_STATISTICS_WEEK_COMPARISON")) {
                    b3 = 1;
                }
                break;
            case -1425360676:
                if (str.equals("TAG_MOCK_NOTIFICATION_STATISTICS_WEEK_COMPARISON")) {
                    b3 = 2;
                }
                break;
            case -1408281430:
                if (str.equals("TAG_TRIAL_EXPIRING")) {
                    b3 = 3;
                }
                break;
            case -1028776943:
                if (str.equals("IN_APP_UPDATE_PENDING_NOTIFICATION")) {
                    b3 = 4;
                }
                break;
            case -937791955:
                if (str.equals("TAG_TRIAL_CONVERSION_REMINDER")) {
                    b3 = 5;
                }
                break;
            case -880119535:
                if (str.equals("TAG_AUTO_TRIAL_EXPIRED")) {
                    b3 = 6;
                }
                break;
            case -819249247:
                if (str.equals("LOCK_SERVICE_CHECK_NOW")) {
                    b3 = 7;
                }
                break;
            case -810363216:
                if (str.equals("TAG_APPLICATION_ACCESS_UPDATE")) {
                    b3 = 8;
                }
                break;
            case -797756533:
                if (str.equals("TAG_STREAK_NUDGE_NOTIFICATION")) {
                    b3 = 9;
                }
                break;
            case -645458908:
                if (str.equals("TAG_DISCOUNT_NOTIFICATION")) {
                    b3 = 10;
                }
                break;
            case -405133043:
                if (str.equals("TAG_DAILY_INSIGHTS_MOTIVATION_JOB")) {
                    b3 = Ascii.VT;
                }
                break;
            case -387919387:
                if (str.equals("TAG_CAMPAIGN_BEFORE_EXPIRATION")) {
                    b3 = Ascii.FF;
                }
                break;
            case -164215126:
                if (str.equals("LOCK_SERVICE_CHECK")) {
                    b3 = Ascii.CR;
                }
                break;
            case 160782186:
                if (str.equals("WIFI_CHANGED")) {
                    b3 = Ascii.SO;
                }
                break;
            case 305369335:
                if (str.equals("TAG_STREAK_ACHIEVEMENT_NOTIFICATION")) {
                    b3 = Ascii.SI;
                }
                break;
            case 373058678:
                if (str.equals("WIFI_AVAILABLE_NOW")) {
                    b3 = Ascii.DLE;
                }
                break;
            case 759087270:
                if (str.equals("DETAIL_CHANGED")) {
                    b3 = 17;
                }
                break;
            case 851603505:
                if (str.equals("GEOFENCE_RECREATION")) {
                    b3 = Ascii.DC2;
                }
                break;
            case 1414373625:
                if (str.equals("TAG_CAMPAIGN_EXPIRATION")) {
                    b3 = 19;
                }
                break;
            case 1458248497:
                if (str.equals("LOCK_SERVICE_RESTART")) {
                    b3 = Ascii.DC4;
                }
                break;
            case 1642061644:
                if (str.equals("LOCK_COMPONENT_START")) {
                    b3 = Ascii.NAK;
                }
                break;
            case 1708502947:
                if (str.equals("TAG_CANCELLED_TRIAL")) {
                    b3 = Ascii.SYN;
                }
                break;
            case 1860928311:
                if (str.equals("TAG_SUBSCRIPTION_EXPIRED_OFFER_1")) {
                    b3 = Ascii.ETB;
                }
                break;
            case 1860928312:
                if (str.equals("TAG_SUBSCRIPTION_EXPIRED_OFFER_2")) {
                    b3 = Ascii.CAN;
                }
                break;
            case 1883906034:
                if (str.equals("STRICT_MODE_STARTED_NOW")) {
                    b3 = Ascii.EM;
                }
                break;
            case 1969748722:
                if (str.equals("PROFILE_ACTIVATED_NOW")) {
                    b3 = Ascii.SUB;
                }
                break;
            case 1998661119:
                if (str.equals("WIFI_AVAILABLE")) {
                    b3 = Ascii.ESC;
                }
                break;
            case 2072342277:
                if (str.equals("TAG_IN_APP_UPDATE_CHECK")) {
                    b3 = Ascii.FS;
                }
                break;
        }
        switch (b3) {
            case 0:
                return new MockDailyInsightsMotivationJob();
            case 1:
                return new NotificationStatisticsWeekComparisonJob();
            case 2:
                return new MockNotificationStatisticsWeekComparisonJob();
            case 3:
                return new TrialExpiringNotificationJob();
            case 4:
                return new InAppUpdatePendingNotificationJob();
            case 5:
                return new TrialConversionReminderJob();
            case 6:
                return new AutoTrialExpiredNotificationJob();
            case 7:
            case 13:
                return new LockServiceCheckJob();
            case 8:
                return new ApplicationAccessUpdateJob();
            case 9:
                return new StreakNudgeNotificationJob();
            case 10:
                return new DiscountNotificationJob();
            case 11:
                return new DailyInsightsMotivationJob();
            case 12:
                return new CampaignBeforeExpirationJob();
            case 14:
            case 16:
            case 27:
                return new WifiAvailableCheckJob();
            case 15:
                return new StreakAchievementNotificationJob();
            case 17:
                return new DetailChangedJob();
            case 18:
                return new GeofenceRecreationJob();
            case 19:
                return new CampaignExpirationJob();
            case 20:
                return new LockServiceRestartJob();
            case 21:
                return new ComponentStartJob();
            case 22:
                return new CancelledTrialNotificationJob();
            case 23:
                return new SubscriptionExpiredOffer1Job();
            case 24:
                return new SubscriptionExpiredOffer2Job();
            case 25:
                return new StrictModeStartJob();
            case 26:
                return new ProfileActivatedNowJob();
            case 28:
                return new InAppUpdateCheckJob();
            default:
                if (str.startsWith("INTERVAL_START_") || str.startsWith("INTERVAL_END_")) {
                    return new IntervalStartJob();
                }
                if (str.startsWith("AUTO_LOCK_")) {
                    return new AutoLockJob();
                }
                if (str.startsWith("PROFILE_DEACTIVATION_WITH_ID_")) {
                    return new ProfileDeactivationJob();
                }
                if (str.startsWith("TAG_PROFILE_RESUME_WITH_ID_")) {
                    return new ProfileResumeJob();
                }
                if (str.startsWith("TAG_BEFORE_PROFILE_START_JOB_")) {
                    return new NotificationBeforeProfileStartJob();
                }
                if (str.startsWith("TAG_BEFORE_PAUSE_END_JOB_")) {
                    return new NotificationBeforePauseEndJob();
                }
                if (str.startsWith("TAG_POMODORO_SESSION_JOB_")) {
                    return new NotificationForPomodoroSession();
                }
                return null;
        }
    }

    public JobEventsListener c() {
        return this.f123340a;
    }

    public void d(long j3) {
        AutoLockJob.D(j3);
    }

    public void e(long j3) {
        CampaignBeforeExpirationJob.f123184m.c(j3);
    }

    public void f(long j3) {
        CampaignExpirationJob.f123198k.c(j3);
    }

    public void g(ComponentName componentName) {
        ComponentStartJob.f123202k.a(componentName);
    }

    public void h(String str) {
        DailyInsightsMotivationJob.f123204n.a(str);
    }

    public void i(long j3) {
        InAppUpdatePendingNotificationJob.f129853k.a(j3);
    }

    public void k(long j3, long j4, long j5, boolean z2) {
        ProfileDeactivationJob.D(j3, j4, j5, z2, true);
    }

    public void l(long j3, long j4, long j5, boolean z2) {
        ProfileDeactivationJob.D(j3, j4, j5, z2, false);
    }

    public void m(long j3, long j4, boolean z2, boolean z3) {
        ProfileDeactivationJob.C(j3, j4, z2, z3);
    }

    public void n(long j3, long j4) {
        ProfileResumeJob.z(j3, j4);
    }

    public void o(boolean z2) {
        SubscriptionExpiredOffer2Job.f123483l.b(z2);
    }

    public void p() {
        JobManager.v().e("TAG_IN_APP_UPDATE_CHECK");
        InAppUpdateCheckJob.f129848k.a();
    }

    public void q(JobEventsListener jobEventsListener) {
        this.f123340a = jobEventsListener;
    }

    public void j(String str) {
        str.getClass();
        byte b3 = -1;
        switch (str.hashCode()) {
            case -1499868633:
                if (str.equals("TAG_NOTIFICATION_STATISTICS_WEEK_COMPARISON")) {
                    b3 = 0;
                }
                break;
            case -819249247:
                if (str.equals("LOCK_SERVICE_CHECK_NOW")) {
                    b3 = 1;
                }
                break;
            case -810363216:
                if (str.equals("TAG_APPLICATION_ACCESS_UPDATE")) {
                    b3 = 2;
                }
                break;
            case -797756533:
                if (str.equals("TAG_STREAK_NUDGE_NOTIFICATION")) {
                    b3 = 3;
                }
                break;
            case -645458908:
                if (str.equals("TAG_DISCOUNT_NOTIFICATION")) {
                    b3 = 4;
                }
                break;
            case -164215126:
                if (str.equals("LOCK_SERVICE_CHECK")) {
                    b3 = 5;
                }
                break;
            case 160782186:
                if (str.equals("WIFI_CHANGED")) {
                    b3 = 6;
                }
                break;
            case 305369335:
                if (str.equals("TAG_STREAK_ACHIEVEMENT_NOTIFICATION")) {
                    b3 = 7;
                }
                break;
            case 373058678:
                if (str.equals("WIFI_AVAILABLE_NOW")) {
                    b3 = 8;
                }
                break;
            case 759087270:
                if (str.equals("DETAIL_CHANGED")) {
                    b3 = 9;
                }
                break;
            case 851603505:
                if (str.equals(muQRKXGtpOhe.WAG)) {
                    b3 = 10;
                }
                break;
            case 1458248497:
                if (str.equals("LOCK_SERVICE_RESTART")) {
                    b3 = Ascii.VT;
                }
                break;
            case 1860928311:
                if (str.equals("TAG_SUBSCRIPTION_EXPIRED_OFFER_1")) {
                    b3 = Ascii.FF;
                }
                break;
            case 1860928312:
                if (str.equals("TAG_SUBSCRIPTION_EXPIRED_OFFER_2")) {
                    b3 = Ascii.CR;
                }
                break;
            case 1883906034:
                if (str.equals("STRICT_MODE_STARTED_NOW")) {
                    b3 = Ascii.SO;
                }
                break;
            case 1969748722:
                if (str.equals("PROFILE_ACTIVATED_NOW")) {
                    b3 = Ascii.SI;
                }
                break;
            case 1998661119:
                if (str.equals("WIFI_AVAILABLE")) {
                    b3 = Ascii.DLE;
                }
                break;
        }
        switch (b3) {
            case 0:
                NotificationStatisticsWeekComparisonJob.f123401n.a();
                break;
            case 1:
                LockServiceCheckJob.x();
                break;
            case 2:
                ApplicationAccessUpdateJob.x();
                break;
            case 3:
                StreakNudgeNotificationJob.f123468m.b();
                break;
            case 4:
                DiscountNotificationJob.f123237n.c();
                break;
            case 5:
                LockServiceCheckJob.y();
                break;
            case 6:
                WifiAvailableCheckJob.I();
                break;
            case 7:
                StreakAchievementNotificationJob.f123454p.a();
                break;
            case 8:
                WifiAvailableCheckJob.G();
                break;
            case 9:
                DetailChangedJob.f123229l.a();
                break;
            case 10:
                GeofenceRecreationJob.C();
                break;
            case 11:
                LockServiceRestartJob.f123341k.a();
                break;
            case 12:
                SubscriptionExpiredOffer1Job.f123477l.b();
                break;
            case 13:
                SubscriptionExpiredOffer2Job.f123483l.b(false);
                break;
            case 14:
                StrictModeStartJob.x();
                break;
            case 15:
                ProfileActivatedNowJob.f123406l.a();
                break;
            case 16:
                WifiAvailableCheckJob.H();
                break;
        }
    }
}
