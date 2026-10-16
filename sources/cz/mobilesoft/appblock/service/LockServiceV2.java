package cz.mobilesoft.appblock.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import cz.mobilesoft.appblock.R;
import cz.mobilesoft.appblock.service.LockRunnable;
import cz.mobilesoft.coreblock.dto.UsageAccess;
import cz.mobilesoft.coreblock.dto.events.PackageAdditionalBlockingDTO;
import cz.mobilesoft.coreblock.enums.EventShowAsType;
import cz.mobilesoft.coreblock.service.ForegroundServiceLauncher;
import cz.mobilesoft.coreblock.service.StatisticsSyncScheduler;
import cz.mobilesoft.coreblock.service.receiver.LocationProviderChangedReceiver;
import cz.mobilesoft.coreblock.service.receiver.NetworkStateChangedReceiver;
import cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore;
import cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import cz.mobilesoft.coreblock.storage.sharedprefs.flowproperty.BlockingFlowProperty;
import cz.mobilesoft.coreblock.usecase.lockservice.LockServiceRunReason;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.StatisticsHelper;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.DateHelper;
import cz.mobilesoft.coreblock.util.helperextension.StringHelper;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.util.notifications.NotificationChannelHelper;
import cz.mobilesoft.coreblock.util.notifications.NotificationHelper;
import cz.mobilesoft.coreblock.util.runnability.InitHelper;
import cz.mobilesoft.statistics.api.Statistics;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import kotlin.Unit;
import kotlin.comparisons.xn.YvFRmou;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import org.koin.java.KoinJavaComponent;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class LockServiceV2 extends ForegroundServiceLauncher.ForegroundService implements LockRunnable.Callback {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final ForegroundServiceLauncher f94535x = new ForegroundServiceLauncher(LockServiceV2.class);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static CoroutineScope f94536y = CoroutinesHelperExtKt.a(Dispatchers.b());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CoreMultiProcessDataStore f94537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f94538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f94539d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f94540f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f94541g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private PackageManager f94542h;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Pair f94546l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private LockSettingsAndStateChangedReceiver f94547m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private LocationProviderChangedReceiver f94548n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f94549o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private LockRunnable f94550p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Thread f94551q;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private volatile boolean f94554t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private volatile boolean f94555u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f94556v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f94557w;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Set f94543i = new HashSet();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Set f94544j = new HashSet();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Set f94545k = new HashSet();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final StatisticsSyncScheduler f94552r = new StatisticsSyncScheduler();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final CoroutineScope f94553s = CoroutinesHelperExtKt.a(Dispatchers.b());

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public class LockSettingsAndStateChangedReceiver extends BroadcastReceiver {
        public LockSettingsAndStateChangedReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction() != null) {
                Log.d("LockService", intent.getAction());
                String action = intent.getAction();
                action.getClass();
                switch (action) {
                    case "cz.mobilesoft.appblock.USAGE_LIMIT_CHANGED":
                        LockServiceV2.this.f94544j.clear();
                        break;
                    case "cz.mobilesoft.appblock.LOCK_OVERLAY_CLOSED":
                        if (LockServiceV2.this.f94550p != null) {
                            LockServiceV2.this.f94550p.H();
                            break;
                        }
                        break;
                    case "cz.mobilesoft.appblock.USAGE_LIMIT_SETTINGS_CHANGED":
                        int intExtra = intent.getIntExtra("DAY_BEGINNING_HOUR", -1);
                        if (intExtra != -1) {
                            LockServiceV2.this.f94541g = intExtra;
                            if (LockServiceV2.this.f94550p != null) {
                                LockServiceV2.this.f94550p.y0(intExtra);
                            }
                            break;
                        }
                        break;
                }
            }
        }
    }

    private void A() {
        this.f94543i = new HashSet();
        this.f94540f = false;
        this.f94544j.clear();
        this.f94545k.clear();
        this.f94546l = null;
    }

    private String B(List list) {
        if (list.isEmpty() && this.f94540f) {
            return getString(R.string.no_apps_found);
        }
        HashSet hashSet = new HashSet();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            hashSet.add(StringHelper.c(this.f94542h, (String) it.next()));
        }
        final StringBuilder sb = new StringBuilder();
        hashSet.stream().sorted().forEach(new Consumer() { // from class: cz.mobilesoft.appblock.service.t0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                LockServiceV2.j(sb, (String) obj);
            }
        });
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Notification E() {
        String string;
        String string2;
        PendingIntent pendingIntentL;
        Pair pair;
        NotificationChannelHelper.Channel channel = (!this.f94538c || this.f94546l == null) ? NotificationChannelHelper.Channel.STATE : NotificationChannelHelper.Channel.USAGE_LIMIT;
        boolean z2 = false;
        if (channel != NotificationChannelHelper.Channel.USAGE_LIMIT || (pair = this.f94546l) == null) {
            List listF = F();
            int size = listF.size();
            boolean z3 = this.f94555u && size == 0;
            if (this.f94539d && this.f94549o != null) {
                z2 = true;
            }
            string = this.f94540f ? getString(R.string.title_strict_mode_active) : (size == 0 && z2) ? this.f94549o : z3 ? getString(R.string.time_poke_service_notification_title) : size == 0 ? getString(R.string.active) : getResources().getQuantityString(R.plurals.blocked_apps_count_notification, size, Integer.valueOf(size));
            string2 = z3 ? getString(R.string.time_poke_service_notification_text) : B(listF);
            z2 = z3;
        } else {
            string = (String) pair.first;
            string2 = (String) pair.second;
        }
        if (z2) {
            pendingIntentL = NotificationHelper.m(getApplicationContext());
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("NOTIFICATION_OPENED_EVENT_NAME", "profile_blocking_notif_opened");
            pendingIntentL = NotificationHelper.l(getApplicationContext(), 955, true, bundle);
        }
        NotificationCompat.Builder builderB = new NotificationCompat.Builder(getApplicationContext(), channel.getId()).l(pendingIntentL).n(string).v(true).B(R.drawable.ic_appblock_notification);
        if (string2 == null || string2.isEmpty()) {
            string2 = getString(R.string.blocking_applications);
        }
        builderB.m(string2).D(new NotificationCompat.BigTextStyle().h(string2));
        return builderB.c();
    }

    private List F() {
        if (this.f94542h == null) {
            this.f94542h = getPackageManager();
        }
        ArrayList arrayList = new ArrayList();
        for (String str : this.f94543i) {
            if (InitHelper.p(this.f94542h, str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    private void J() {
        NotificationManagerCompat.d(this).b(ColorExtractionConstants.MAX_PIXEL_SAMPLES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(PackageAdditionalBlockingDTO packageAdditionalBlockingDTO) {
        LockRunnable lockRunnable = this.f94550p;
        if (lockRunnable == null || !lockRunnable.g0()) {
            b0();
            this.f94555u = false;
            if (this.f94550p != null) {
                Log.d("LockService", "==== Destroying the stopped runnable before replacing it ====");
                this.f94550p.o0(false);
                this.f94550p = null;
            }
            if (this.f94551q != null) {
                Log.d("LockService", "==== Interrupting thread ====");
                this.f94551q.interrupt();
                this.f94551q = null;
            }
            Log.d("LockService", "==== Initializing runnable ====");
            this.f94550p = new LockRunnable(getApplicationContext(), packageAdditionalBlockingDTO, this);
            Log.d("LockService", "==== Instantiating thread ====");
            Thread thread = new Thread(this.f94550p);
            this.f94551q = thread;
            thread.start();
            Log.d("LockService", "==== Thread started ====");
        } else if (packageAdditionalBlockingDTO != null) {
            this.f94550p.W().h(packageAdditionalBlockingDTO);
        }
        this.f94552r.f(getApplicationContext(), new Runnable() { // from class: cz.mobilesoft.appblock.service.v0
            @Override // java.lang.Runnable
            public final void run() {
                this.f95097a.X();
            }
        });
        d0();
        try {
            if (this.f94548n == null) {
                this.f94548n = LocationProviderChangedReceiver.f123612g.b(getApplicationContext());
            }
        } catch (IllegalStateException e3) {
            CrashHelper.j(e3);
        }
        try {
            NetworkStateChangedReceiver.w(getApplicationContext());
        } catch (IllegalStateException e4) {
            CrashHelper.j(e4);
        }
        try {
            AppInstallUninstallReceiver.c(getApplicationContext());
        } catch (IllegalStateException e5) {
            CrashHelper.j(e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object M(Boolean bool, Continuation continuation) {
        if (this.f94538c != bool.booleanValue()) {
            this.f94538c = bool.booleanValue();
            V();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object N(Boolean bool, Continuation continuation) {
        boolean z2 = this.f94539d;
        boolean z3 = z2 && bool.booleanValue();
        this.f94539d = z3;
        if (z3 != z2) {
            V();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object O(Boolean bool, Continuation continuation) {
        boolean z2 = this.f94539d;
        boolean z3 = z2 && bool.booleanValue();
        this.f94539d = z3;
        if (z3 != z2) {
            V();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object P(Integer num, Continuation continuation) {
        LockRunnable lockRunnable = this.f94550p;
        if (lockRunnable != null) {
            lockRunnable.V().M(TimeUnit.MINUTES.toMillis(num.intValue()));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object Q(EventShowAsType eventShowAsType, Continuation continuation) {
        LockRunnable lockRunnable = this.f94550p;
        if (lockRunnable != null) {
            lockRunnable.V().K(eventShowAsType);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object R(Boolean bool, Continuation continuation) {
        W();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object S(Set set, Continuation continuation) {
        W();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object T(Boolean bool, Continuation continuation) {
        W();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object U(Boolean bool, Continuation continuation) {
        W();
        return Unit.f139807a;
    }

    private void V() {
        f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        LockRunnable lockRunnable;
        if (this.f94554t || (lockRunnable = this.f94550p) == null || lockRunnable.g0()) {
            return;
        }
        if (LockServiceReasonsHelper.b(getApplicationContext()).contains(LockServiceRunReason.TIME_NUDGE)) {
            f0();
        } else {
            if (this.f94554t) {
                return;
            }
            Log.d("LockService", "==== Nothing justifies running any more, stopping ====");
            e0(getApplicationContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        if (this.f94554t) {
            return;
        }
        TimeNudgeEvaluationHelper.a(getApplicationContext());
        CoroutinesHelperExtKt.g(this.f94553s, new Runnable() { // from class: cz.mobilesoft.appblock.service.s0
            @Override // java.lang.Runnable
            public final void run() {
                this.f95082a.W();
            }
        });
    }

    private void b0() {
        if (this.f94557w) {
            return;
        }
        this.f94557w = true;
        StatisticsDataStore statisticsDataStore = (StatisticsDataStore) KoinJavaComponent.a(StatisticsDataStore.class);
        NotificationDataStore notificationDataStore = (NotificationDataStore) KoinJavaComponent.a(NotificationDataStore.class);
        this.f94537b = (CoreMultiProcessDataStore) KoinJavaComponent.a(CoreMultiProcessDataStore.class);
        this.f94538c = ((Boolean) new BlockingFlowProperty(notificationDataStore.a0()).b()).booleanValue();
        this.f94539d = ((Boolean) new BlockingFlowProperty(statisticsDataStore.Y()).b()).booleanValue() && ((Boolean) new BlockingFlowProperty(notificationDataStore.Y()).b()).booleanValue();
        FlowExtKt.i(notificationDataStore.a0(), f94536y, new FlowCollector() { // from class: cz.mobilesoft.appblock.service.w0
            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object obj, Continuation continuation) {
                return this.f95101a.M((Boolean) obj, continuation);
            }
        });
        FlowExtKt.i(notificationDataStore.Y(), f94536y, new FlowCollector() { // from class: cz.mobilesoft.appblock.service.x0
            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object obj, Continuation continuation) {
                return this.f95103a.N((Boolean) obj, continuation);
            }
        });
        FlowExtKt.i(statisticsDataStore.Y(), f94536y, new FlowCollector() { // from class: cz.mobilesoft.appblock.service.y0
            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object obj, Continuation continuation) {
                return this.f95105a.O((Boolean) obj, continuation);
            }
        });
        FlowExtKt.i(notificationDataStore.Q(), f94536y, new FlowCollector() { // from class: cz.mobilesoft.appblock.service.z0
            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object obj, Continuation continuation) {
                return this.f95107a.P((Integer) obj, continuation);
            }
        });
        FlowExtKt.i(notificationDataStore.R(), f94536y, new FlowCollector() { // from class: cz.mobilesoft.appblock.service.a1
            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object obj, Continuation continuation) {
                return this.f94714a.Q((EventShowAsType) obj, continuation);
            }
        });
    }

    public static void c0(Context context, Bundle bundle) {
        LockServiceHelperKt.a(context, bundle, f94535x, f94536y);
    }

    private void d0() {
        if (this.f94556v || this.f94537b == null) {
            return;
        }
        this.f94556v = true;
        StatisticsDataStore statisticsDataStore = (StatisticsDataStore) KoinJavaComponent.a(StatisticsDataStore.class);
        FlowExtKt.i(this.f94537b.t0(), this.f94553s, new FlowCollector() { // from class: cz.mobilesoft.appblock.service.b1
            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object obj, Continuation continuation) {
                return this.f94717a.R((Boolean) obj, continuation);
            }
        });
        FlowExtKt.i(this.f94537b.w0(), this.f94553s, new FlowCollector() { // from class: cz.mobilesoft.appblock.service.p0
            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object obj, Continuation continuation) {
                return this.f95064a.S((Set) obj, continuation);
            }
        });
        FlowExtKt.i(statisticsDataStore.Y(), this.f94553s, new FlowCollector() { // from class: cz.mobilesoft.appblock.service.q0
            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object obj, Continuation continuation) {
                return this.f95067a.T((Boolean) obj, continuation);
            }
        });
        FlowExtKt.i(statisticsDataStore.W(), this.f94553s, new FlowCollector() { // from class: cz.mobilesoft.appblock.service.r0
            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object obj, Continuation continuation) {
                return this.f95073a.U((Boolean) obj, continuation);
            }
        });
    }

    public static void e0(Context context) {
        f94535x.g(context);
    }

    public static /* synthetic */ void j(StringBuilder sb, String str) {
        if (sb.length() != 0) {
            sb.append(", ");
        }
        sb.append(str);
    }

    public Set C() {
        return this.f94543i;
    }

    public Set D() {
        return this.f94545k;
    }

    protected ForegroundServiceLauncher G() {
        return f94535x;
    }

    public LockRunnable H() {
        return this.f94550p;
    }

    public Set I() {
        return this.f94544j;
    }

    public boolean K() {
        return this.f94540f;
    }

    public void Y(Set set) {
        this.f94543i = set;
    }

    public void Z(boolean z2) {
        this.f94540f = z2;
    }

    @Override // cz.mobilesoft.appblock.service.LockRunnable.Callback
    public void a(long j3, String str, String str2) {
        long j4;
        long j5;
        long j6;
        if (!this.f94538c) {
            this.f94546l = null;
            return;
        }
        if (j3 > 0) {
            long j7 = j3 / 3600000;
            j6 = j7 % 24;
            long j8 = j3 - (j7 * 3600000);
            j5 = j8 / 60000;
            j4 = (j8 - (60000 * j5)) / 1000;
        } else {
            j4 = 0;
            j5 = 0;
            j6 = 0;
        }
        this.f94546l = new Pair(str, (j6 == 0 && j5 == 0) ? getString(R.string.app_allowed_second_left_schedule, Long.valueOf(j4), str2) : j6 == 0 ? getString(R.string.app_allowed_minute_and_second_left_schedule, Long.valueOf(j5), Long.valueOf(j4), str2) : getString(R.string.app_allowed_hour_minute_second_left_schedule, Long.valueOf(j6), Long.valueOf(j5), Long.valueOf(j4), str2));
        f0();
    }

    public void a0(Set set) {
        this.f94544j = set;
    }

    @Override // cz.mobilesoft.appblock.service.LockRunnable.Callback
    public void b() {
        this.f94544j.clear();
        this.f94546l = null;
        J();
        f0();
    }

    @Override // cz.mobilesoft.appblock.service.LockRunnable.Callback
    public void c(List list) {
        LockServiceExtKt.a(this, list);
    }

    @Override // cz.mobilesoft.appblock.service.LockRunnable.Callback
    public void d(int i3, String str, UsageLimit.PeriodType periodType) {
        if (!this.f94538c) {
            this.f94546l = null;
        } else {
            this.f94546l = new Pair(str, StringHelper.l(this, i3, periodType));
            f0();
        }
    }

    @Override // cz.mobilesoft.appblock.service.LockRunnable.Callback
    public void e() {
        if (!this.f94539d || !F().isEmpty()) {
            this.f94549o = null;
            f0();
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jG = StatisticsHelper.g(jCurrentTimeMillis);
        long jB = StatisticsHelper.b(jCurrentTimeMillis);
        LockRunnable lockRunnable = this.f94550p;
        List listJ = lockRunnable != null ? lockRunnable.J() : null;
        HashSet hashSet = new HashSet();
        hashSet.add(Integer.valueOf(UsageAccess.Type.APPLICATION.getTypeId()));
        hashSet.add(Integer.valueOf(UsageAccess.Type.WEBSITE.getTypeId()));
        Statistics.A(hashSet, listJ, jG, jB, new Continuation<Double>() { // from class: cz.mobilesoft.appblock.service.LockServiceV2.1
            @Override // kotlin.coroutines.Continuation
            public CoroutineContext getContext() {
                return EmptyCoroutineContext.f139889a;
            }

            @Override // kotlin.coroutines.Continuation
            public void resumeWith(Object obj) {
                if (obj instanceof Double) {
                    long jLongValue = ((Double) obj).longValue();
                    LockServiceV2 lockServiceV2 = LockServiceV2.this;
                    lockServiceV2.f94549o = StringHelperExtKt.p(lockServiceV2.getString(R.string.daily_usage_time), DateHelper.c(Long.valueOf(jLongValue)), " ");
                } else {
                    LockServiceV2 lockServiceV22 = LockServiceV2.this;
                    lockServiceV22.f94549o = lockServiceV22.getString(R.string.active);
                }
                LockServiceV2.this.f0();
            }
        });
    }

    @Override // cz.mobilesoft.appblock.service.LockRunnable.Callback
    public void f() {
        boolean zContains = LockServiceReasonsHelper.b(getApplicationContext()).contains(LockServiceRunReason.TIME_NUDGE);
        if (Thread.currentThread().isInterrupted()) {
            Log.d("LockService", "==== Stopped runnable was already replaced, leaving the decision to its successor ====");
            return;
        }
        if (!zContains) {
            e0(getApplicationContext());
            return;
        }
        Log.d("LockService", "==== Runnable stopped, service stays alive for Time Nudge ====");
        this.f94555u = true;
        A();
        f0();
    }

    public void f0() {
        NotificationManagerCompat.d(this).f(ColorExtractionConstants.MAX_PIXEL_SAMPLES, E());
    }

    @Override // cz.mobilesoft.coreblock.service.ForegroundServiceLauncher.ForegroundService
    public int g() {
        return ColorExtractionConstants.MAX_PIXEL_SAMPLES;
    }

    @Override // cz.mobilesoft.coreblock.service.ForegroundServiceLauncher.ForegroundService
    public Function0 h() {
        return new Function0() { // from class: cz.mobilesoft.appblock.service.u0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f95092a.E();
            }
        };
    }

    @Override // cz.mobilesoft.coreblock.service.ForegroundServiceLauncher.ForegroundService, android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.d("LockService", "==== OnCreate called, starting ====");
        try {
            startForeground(ColorExtractionConstants.MAX_PIXEL_SAMPLES, E());
        } catch (Exception e3) {
            CrashHelper.j(e3);
        }
        this.f94547m = new LockSettingsAndStateChangedReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("cz.mobilesoft.appblock.USAGE_LIMIT_CHANGED");
        intentFilter.addAction("cz.mobilesoft.appblock.LOCK_OVERLAY_CLOSED");
        intentFilter.addAction("cz.mobilesoft.appblock.USAGE_LIMIT_SETTINGS_CHANGED");
        ContextExtKt.h(this, this.f94547m, intentFilter, 4);
        G().e(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f94554t = true;
        unregisterReceiver(this.f94547m);
        Log.d("LockService", "==== OnDestroy called, stopping ====");
        this.f94552r.g();
        CoroutineScopeKt.d(this.f94553s, null);
        LockRunnable lockRunnable = this.f94550p;
        if (lockRunnable != null) {
            lockRunnable.n0();
            this.f94550p = null;
        }
        if (this.f94551q != null) {
            Log.d("LockService", "==== Interrupting and nulling thread ====");
            this.f94551q.interrupt();
            this.f94551q = null;
        }
        LocationProviderChangedReceiver locationProviderChangedReceiver = this.f94548n;
        if (locationProviderChangedReceiver != null) {
            locationProviderChangedReceiver.r(getApplicationContext());
        }
        NetworkStateChangedReceiver.x(getApplicationContext());
        stopForeground(1);
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i4) {
        Log.d("LockService", YvFRmou.yCjDDMMmnc);
        final PackageAdditionalBlockingDTO packageAdditionalBlockingDTO = intent != null ? (PackageAdditionalBlockingDTO) intent.getParcelableExtra("USAGE_LIMIT_HOST") : null;
        InitHelper.h(new InitHelper.OnInitializedListener() { // from class: cz.mobilesoft.appblock.service.o0
            @Override // cz.mobilesoft.coreblock.util.runnability.InitHelper.OnInitializedListener
            public final void onInitialized() {
                this.f95059a.L(packageAdditionalBlockingDTO);
            }
        });
        return 1;
    }
}
