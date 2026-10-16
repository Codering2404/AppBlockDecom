package cz.mobilesoft.coreblock.util.helperextension;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.text.format.DateUtils;
import android.util.Log;
import cz.mobilesoft.coreblock.BuildConfig;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import cz.mobilesoft.coreblock.storage.sharedprefs.flowproperty.BlockingFlowProperty;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.runnability.InitHelper;
import java.text.DateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;
import org.threeten.bp.Duration;
import org.threeten.bp.Instant;
import org.threeten.bp.ZoneId;

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
public final class TimeHelperExt implements InitHelper.OnInitializedListener, KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TimeHelperExt f128663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f128664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f128665c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Long f128666d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Long f128667f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static long f128668g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f128669h;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        final TimeHelperExt timeHelperExt = new TimeHelperExt();
        f128663a = timeHelperExt;
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        f128664b = LazyKt.a(lazyThreadSafetyModeB, new Function0<DevDataStore>() { // from class: cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = timeHelperExt;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DevDataStore.class), qualifier, objArr);
            }
        });
        f128665c = -1L;
        InitHelper.h(timeHelperExt);
        f128669h = 8;
    }

    private TimeHelperExt() {
    }

    public static final Calendar A() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(f128663a.f());
        Intrinsics.checkNotNullExpressionValue(calendar, "apply(...)");
        return calendar;
    }

    public static final long c() {
        return f128663a.f();
    }

    private final DevDataStore h() {
        return (DevDataStore) f128664b.getValue();
    }

    public static /* synthetic */ String j(TimeHelperExt timeHelperExt, Context context, long j3, boolean z2, boolean z3, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        if ((i3 & 8) != 0) {
            z3 = false;
        }
        return timeHelperExt.i(context, j3, z2, z3);
    }

    private final long r() {
        if (f128665c == -1) {
            f128665c = BuildConfig.f95357b.booleanValue() ? ((Number) new BlockingFlowProperty(h().d1()).b()).longValue() : 600000L;
        }
        return f128665c;
    }

    public final void B() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Long l3 = f128667f;
        boolean z2 = false;
        if (l3 != null && jElapsedRealtime - l3.longValue() < f128663a.r()) {
            z2 = true;
        }
        f128667f = Long.valueOf(jElapsedRealtime);
        long jCurrentTimeMillis = System.currentTimeMillis() - jElapsedRealtime;
        Long l4 = f128666d;
        f128668g = l4 != null ? jCurrentTimeMillis - l4.longValue() : 0L;
        Log.d("TimeHelper", LockieApplication.f95363i + ": Time changed, setting delta change to " + f128668g + " ms, switching to adjusted time");
        if (z2) {
            return;
        }
        Log.d("TimeHelper", LockieApplication.f95363i + ": Updating last delta time");
        f128666d = Long.valueOf(jCurrentTimeMillis);
    }

    public final Flow a(long j3, long j4) {
        return FlowKt.I(new TimeHelperExt$countdownUntilTimeTickerFlow$1(j3, j4, null));
    }

    public final Flow b(long j3, long j4) {
        return FlowKt.I(new TimeHelperExt$countdownUntilTimeTickerFlowRealTime$1(j3, j4, null));
    }

    public final Flow d(long j3, long j4) {
        return FlowKt.I(new TimeHelperExt$elapsedTimeTickerFlowRealTime$1(j4, j3, null));
    }

    public final Long e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            return Long.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime);
        } catch (PackageManager.NameNotFoundException e3) {
            CrashHelper.j(e3);
            return null;
        }
    }

    public final long f() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Long l3 = f128667f;
        if (l3 != null) {
            if (SystemClock.elapsedRealtime() - l3.longValue() < f128663a.r()) {
                return jCurrentTimeMillis - f128668g;
            }
            Log.d("TimeHelper", LockieApplication.f95363i + ": Limit spent, resetting last update time, switching to system time");
            f128667f = null;
        }
        return jCurrentTimeMillis;
    }

    public final int g() {
        return (int) (f() / ((long) 1000));
    }

    public final String i(Context context, long j3, boolean z2, boolean z3) {
        DateFormat dateFormatI;
        Intrinsics.checkNotNullParameter(context, "context");
        if (z2) {
            dateFormatI = DateHelperExtKt.h(context);
        } else {
            dateFormatI = DateHelperExtKt.i(context, (z3 && DateUtils.isToday(j3)) ? false : true, true);
        }
        String str = dateFormatI.format(new Date(j3));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public final String k(Context context, long j3) {
        Intrinsics.checkNotNullParameter(context, "context");
        String str = DateHelperExtKt.i(context, false, true).format(new Date(j3));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public final long l() {
        return TimeUnit.HOURS.toMillis(24L);
    }

    public final long m(long j3) {
        Instant instantA = Instant.A(j3);
        ZoneId zoneIdS = ZoneId.s();
        return instantA.p(zoneIdS).w().D(zoneIdS).v().S();
    }

    public final long n() {
        return LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY)).atTime(LocalTime.MIDNIGHT).atZone(java.time.ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public final Pair o() {
        java.time.ZoneId zoneIdSystemDefault = java.time.ZoneId.systemDefault();
        return new Pair(Long.valueOf(LocalDate.now().withDayOfMonth(1).atStartOfDay(zoneIdSystemDefault).toEpochSecond()), Long.valueOf(LocalDate.now().plusMonths(1L).withDayOfMonth(1).atStartOfDay(zoneIdSystemDefault).toEpochSecond() - 1));
    }

    @Override // cz.mobilesoft.coreblock.util.runnability.InitHelper.OnInitializedListener
    public void onInitialized() {
        B();
    }

    public final Pair p() {
        java.time.ZoneId zoneIdSystemDefault = java.time.ZoneId.systemDefault();
        LocalDate localDateNow = LocalDate.now(zoneIdSystemDefault);
        return new Pair(Long.valueOf(localDateNow.withDayOfMonth(1).atStartOfDay(zoneIdSystemDefault).toInstant().toEpochMilli()), Long.valueOf(localDateNow.plusMonths(1L).withDayOfMonth(1).atStartOfDay(zoneIdSystemDefault).toInstant().toEpochMilli()));
    }

    public final Pair q() {
        java.time.ZoneId zoneIdSystemDefault = java.time.ZoneId.systemDefault();
        return new Pair(Long.valueOf(LocalDate.now(zoneIdSystemDefault).minusMonths(1L).withDayOfMonth(1).atStartOfDay(zoneIdSystemDefault).toInstant().toEpochMilli()), Long.valueOf(LocalDate.now(zoneIdSystemDefault).withDayOfMonth(1).atStartOfDay(zoneIdSystemDefault).toInstant().toEpochMilli()));
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    public final Triple s(boolean z2, boolean z3, boolean z4, long j3) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long days = timeUnit.toDays(j3);
        if (z2 && days > 0) {
            j3 -= Duration.m(days).y();
        }
        long hours = timeUnit.toHours(j3);
        if (z3 && hours > 0) {
            j3 -= Duration.n(hours).y();
        }
        return new Triple(Long.valueOf(days), Long.valueOf(hours), Long.valueOf(timeUnit.toMinutes(j3)));
    }

    public final Pair t() {
        long epochSecond = LocalDate.now().atStartOfDay(java.time.ZoneId.systemDefault()).toEpochSecond();
        return new Pair(Integer.valueOf((int) epochSecond), Integer.valueOf((int) (((long) 86399) + epochSecond)));
    }

    public final Pair u() {
        long epochSecond = LocalDate.now().atStartOfDay(java.time.ZoneId.systemDefault()).toEpochSecond();
        return new Pair(Long.valueOf(epochSecond), Long.valueOf(((long) 86399) + epochSecond));
    }

    public final boolean v(LocalTime localTime, LocalTime startTime) {
        Intrinsics.checkNotNullParameter(localTime, "<this>");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        return !localTime.isBefore(startTime);
    }

    public final boolean w(long j3, long j4) {
        return j3 < System.currentTimeMillis() - j4;
    }

    public final boolean x(LocalTime localTime) {
        Intrinsics.checkNotNullParameter(localTime, "<this>");
        LocalTime localTimeOf = LocalTime.of(20, 0);
        Intrinsics.checkNotNullExpressionValue(localTimeOf, "of(...)");
        return v(localTime, localTimeOf);
    }

    public final boolean y(long j3) {
        return j3 > f();
    }

    public final boolean z(long j3) {
        return j3 < f();
    }
}
