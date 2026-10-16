package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.crashlytics.internal.ProcessDetailsProvider;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.TrimmedThrowableData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class CrashlyticsReportDataCapture {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Map f88398g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final String f88399h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f88400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final IdManager f88401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AppData f88402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final StackTraceTrimmingStrategy f88403d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final SettingsProvider f88404e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ProcessDetailsProvider f88405f = ProcessDetailsProvider.f88283a;

    static {
        HashMap map = new HashMap();
        f88398g = map;
        map.put("armeabi", 5);
        map.put("armeabi-v7a", 6);
        map.put("arm64-v8a", 9);
        map.put("x86", 0);
        map.put("x86_64", 1);
        f88399h = String.format(Locale.US, "Crashlytics Android SDK/%s", "20.0.2");
    }

    public CrashlyticsReportDataCapture(Context context, IdManager idManager, AppData appData, StackTraceTrimmingStrategy stackTraceTrimmingStrategy, SettingsProvider settingsProvider) {
        this.f88400a = context;
        this.f88401b = idManager;
        this.f88402c = appData;
        this.f88403d = stackTraceTrimmingStrategy;
        this.f88404e = settingsProvider;
    }

    private CrashlyticsReport.Session.Event.Application.ProcessDetails A(CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        return this.f88405f.a(applicationExitInfo.e(), applicationExitInfo.d(), applicationExitInfo.c());
    }

    private CrashlyticsReport.ApplicationExitInfo a(CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        List listUnmodifiableList;
        if (!this.f88404e.b().f89052b.f89061c || this.f88402c.f88300c.size() <= 0) {
            listUnmodifiableList = null;
        } else {
            ArrayList arrayList = new ArrayList();
            for (BuildIdInfo buildIdInfo : this.f88402c.f88300c) {
                arrayList.add(CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch.a().d(buildIdInfo.c()).b(buildIdInfo.a()).c(buildIdInfo.b()).a());
            }
            listUnmodifiableList = Collections.unmodifiableList(arrayList);
        }
        return CrashlyticsReport.ApplicationExitInfo.a().c(applicationExitInfo.c()).e(applicationExitInfo.e()).g(applicationExitInfo.g()).i(applicationExitInfo.i()).d(applicationExitInfo.d()).f(applicationExitInfo.f()).h(applicationExitInfo.h()).j(applicationExitInfo.j()).b(listUnmodifiableList).a();
    }

    private CrashlyticsReport.Builder b() {
        return CrashlyticsReport.b().l("20.0.2").h(this.f88402c.f88298a).i(this.f88401b.a().c()).g(this.f88401b.a().e()).f(this.f88401b.a().d()).d(this.f88402c.f88303f).e(this.f88402c.f88304g).k(4);
    }

    private static long f(long j3) {
        if (j3 > 0) {
            return j3;
        }
        return 0L;
    }

    private static int g() {
        Integer num;
        String str = Build.CPU_ABI;
        if (TextUtils.isEmpty(str) || (num = (Integer) f88398g.get(str.toLowerCase(Locale.US))) == null) {
            return 7;
        }
        return num.intValue();
    }

    private CrashlyticsReport.Session.Event.Application.Execution.BinaryImage h() {
        return CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.a().b(0L).d(0L).c(this.f88402c.f88302e).e(this.f88402c.f88299b).a();
    }

    private List i() {
        return Collections.singletonList(h());
    }

    private CrashlyticsReport.Session.Event.Application j(int i3, CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        return CrashlyticsReport.Session.Event.Application.a().c(Boolean.valueOf(applicationExitInfo.c() != 100)).d(A(applicationExitInfo)).h(i3).f(o(applicationExitInfo)).a();
    }

    private CrashlyticsReport.Session.Event.Application k(int i3, TrimmedThrowableData trimmedThrowableData, Thread thread, int i4, int i5, boolean z2) {
        Boolean boolValueOf;
        CrashlyticsReport.Session.Event.Application.ProcessDetails processDetailsE = this.f88405f.e(this.f88400a);
        if (processDetailsE.b() > 0) {
            boolValueOf = Boolean.valueOf(processDetailsE.b() != 100);
        } else {
            boolValueOf = null;
        }
        return CrashlyticsReport.Session.Event.Application.a().c(boolValueOf).d(processDetailsE).b(this.f88405f.d(this.f88400a)).h(i3).f(p(trimmedThrowableData, thread, i4, i5, z2)).a();
    }

    private CrashlyticsReport.Session.Event.Device l(int i3) {
        BatteryState batteryStateA = BatteryState.a(this.f88400a);
        Float fB = batteryStateA.b();
        Double dValueOf = fB != null ? Double.valueOf(fB.doubleValue()) : null;
        int iC = batteryStateA.c();
        boolean zN = CommonUtils.n(this.f88400a);
        return CrashlyticsReport.Session.Event.Device.a().b(dValueOf).c(iC).f(zN).e(i3).g(f(CommonUtils.b(this.f88400a) - CommonUtils.a(this.f88400a))).d(CommonUtils.c(Environment.getDataDirectory().getPath())).a();
    }

    private CrashlyticsReport.Session.Event.Application.Execution.Exception m(TrimmedThrowableData trimmedThrowableData, int i3, int i4) {
        return n(trimmedThrowableData, i3, i4, 0);
    }

    private CrashlyticsReport.Session.Event.Application.Execution.Exception n(TrimmedThrowableData trimmedThrowableData, int i3, int i4, int i5) {
        String str = trimmedThrowableData.f89096b;
        String str2 = trimmedThrowableData.f89095a;
        StackTraceElement[] stackTraceElementArr = trimmedThrowableData.f89097c;
        int i6 = 0;
        if (stackTraceElementArr == null) {
            stackTraceElementArr = new StackTraceElement[0];
        }
        TrimmedThrowableData trimmedThrowableData2 = trimmedThrowableData.f89098d;
        if (i5 >= i4) {
            TrimmedThrowableData trimmedThrowableData3 = trimmedThrowableData2;
            while (trimmedThrowableData3 != null) {
                trimmedThrowableData3 = trimmedThrowableData3.f89098d;
                i6++;
            }
        }
        CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder builderD = CrashlyticsReport.Session.Event.Application.Execution.Exception.a().f(str).e(str2).c(r(stackTraceElementArr, i3)).d(i6);
        if (trimmedThrowableData2 != null && i6 == 0) {
            builderD.b(n(trimmedThrowableData2, i3, i4, i5 + 1));
        }
        return builderD.a();
    }

    private CrashlyticsReport.Session.Event.Application.Execution o(CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        return CrashlyticsReport.Session.Event.Application.Execution.a().b(applicationExitInfo).e(w()).c(i()).a();
    }

    private CrashlyticsReport.Session.Event.Application.Execution p(TrimmedThrowableData trimmedThrowableData, Thread thread, int i3, int i4, boolean z2) {
        return CrashlyticsReport.Session.Event.Application.Execution.a().f(z(trimmedThrowableData, thread, i3, z2)).d(m(trimmedThrowableData, i3, i4)).e(w()).c(i()).a();
    }

    private CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame q(StackTraceElement stackTraceElement, CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder builder) {
        long lineNumber = 0;
        long jMax = stackTraceElement.isNativeMethod() ? Math.max(stackTraceElement.getLineNumber(), 0L) : 0L;
        String str = stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
        String fileName = stackTraceElement.getFileName();
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            lineNumber = stackTraceElement.getLineNumber();
        }
        return builder.e(jMax).f(str).b(fileName).d(lineNumber).a();
    }

    private List r(StackTraceElement[] stackTraceElementArr, int i3) {
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            arrayList.add(q(stackTraceElement, CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.a().c(i3)));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private CrashlyticsReport.Session.Application s() {
        return CrashlyticsReport.Session.Application.a().e(this.f88401b.f()).g(this.f88402c.f88303f).d(this.f88402c.f88304g).f(this.f88401b.a().c()).b(this.f88402c.f88305h.d()).c(this.f88402c.f88305h.e()).a();
    }

    private CrashlyticsReport.Session t(String str, long j3) {
        return CrashlyticsReport.Session.a().m(j3).j(str).h(f88399h).b(s()).l(v()).e(u()).i(3).a();
    }

    private CrashlyticsReport.Session.Device u() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        int iG = g();
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        long jB = CommonUtils.b(this.f88400a);
        long blockCount = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        boolean zX = CommonUtils.x();
        int iL = CommonUtils.l();
        String str = Build.MANUFACTURER;
        return CrashlyticsReport.Session.Device.a().b(iG).f(Build.MODEL).c(iAvailableProcessors).h(jB).d(blockCount).i(zX).j(iL).e(str).g(Build.PRODUCT).a();
    }

    private CrashlyticsReport.Session.OperatingSystem v() {
        return CrashlyticsReport.Session.OperatingSystem.a().d(3).e(Build.VERSION.RELEASE).b(Build.VERSION.CODENAME).c(CommonUtils.y()).a();
    }

    private CrashlyticsReport.Session.Event.Application.Execution.Signal w() {
        return CrashlyticsReport.Session.Event.Application.Execution.Signal.a().d(AppEventsConstants.EVENT_PARAM_VALUE_NO).c(AppEventsConstants.EVENT_PARAM_VALUE_NO).b(0L).a();
    }

    private CrashlyticsReport.Session.Event.Application.Execution.Thread x(Thread thread, StackTraceElement[] stackTraceElementArr) {
        return y(thread, stackTraceElementArr, 0);
    }

    private CrashlyticsReport.Session.Event.Application.Execution.Thread y(Thread thread, StackTraceElement[] stackTraceElementArr, int i3) {
        return CrashlyticsReport.Session.Event.Application.Execution.Thread.a().d(thread.getName()).c(i3).b(r(stackTraceElementArr, i3)).a();
    }

    private List z(TrimmedThrowableData trimmedThrowableData, Thread thread, int i3, boolean z2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(y(thread, trimmedThrowableData.f89097c, i3));
        if (z2) {
            for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                Thread key = entry.getKey();
                if (!key.equals(thread)) {
                    arrayList.add(x(key, this.f88403d.a(entry.getValue())));
                }
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public CrashlyticsReport.Session.Event c(CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        int i3 = this.f88400a.getResources().getConfiguration().orientation;
        return CrashlyticsReport.Session.Event.a().g("anr").f(applicationExitInfo.i()).b(j(i3, a(applicationExitInfo))).c(l(i3)).a();
    }

    public CrashlyticsReport.Session.Event d(Throwable th, Thread thread, String str, long j3, int i3, int i4, boolean z2) {
        int i5 = this.f88400a.getResources().getConfiguration().orientation;
        return CrashlyticsReport.Session.Event.a().g(str).f(j3).b(k(i5, TrimmedThrowableData.a(th, this.f88403d), thread, i3, i4, z2)).c(l(i5)).a();
    }

    public CrashlyticsReport e(String str, long j3) {
        return b().m(t(str, j3)).a();
    }
}
