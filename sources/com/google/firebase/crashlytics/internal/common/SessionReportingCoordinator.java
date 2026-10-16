package com.google.firebase.crashlytics.internal.common;

import android.app.ApplicationExitInfo;
import android.content.Context;
import com.facebook.internal.Utility;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import com.google.firebase.crashlytics.internal.metadata.EventMetadata;
import com.google.firebase.crashlytics.internal.metadata.LogFileManager;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class SessionReportingCoordinator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CrashlyticsReportDataCapture f88449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CrashlyticsReportPersistence f88450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DataTransportCrashlyticsReportSender f88451c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LogFileManager f88452d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final UserMetadata f88453e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final IdManager f88454f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final CrashlyticsWorkers f88455g;

    SessionReportingCoordinator(CrashlyticsReportDataCapture crashlyticsReportDataCapture, CrashlyticsReportPersistence crashlyticsReportPersistence, DataTransportCrashlyticsReportSender dataTransportCrashlyticsReportSender, LogFileManager logFileManager, UserMetadata userMetadata, IdManager idManager, CrashlyticsWorkers crashlyticsWorkers) {
        this.f88449a = crashlyticsReportDataCapture;
        this.f88450b = crashlyticsReportPersistence;
        this.f88451c = dataTransportCrashlyticsReportSender;
        this.f88452d = logFileManager;
        this.f88453e = userMetadata;
        this.f88454f = idManager;
        this.f88455g = crashlyticsWorkers;
    }

    public static /* synthetic */ void a(SessionReportingCoordinator sessionReportingCoordinator, CrashlyticsReport.Session.Event event, EventMetadata eventMetadata, boolean z2) {
        sessionReportingCoordinator.getClass();
        Logger.f().b("disk worker: log non-fatal event to persistence");
        sessionReportingCoordinator.f88450b.w(event, eventMetadata.b(), z2);
    }

    private CrashlyticsReport.Session.Event d(CrashlyticsReport.Session.Event event, LogFileManager logFileManager, UserMetadata userMetadata) {
        return e(event, logFileManager, userMetadata, Collections.EMPTY_MAP);
    }

    private CrashlyticsReport.Session.Event e(CrashlyticsReport.Session.Event event, LogFileManager logFileManager, UserMetadata userMetadata, Map map) {
        CrashlyticsReport.Session.Event.Builder builderH = event.h();
        String strC = logFileManager.c();
        if (strC != null) {
            builderH.d(CrashlyticsReport.Session.Event.Log.a().b(strC).a());
        } else {
            Logger.f().i("No log data to include with this event.");
        }
        List listO = o(userMetadata.g(map));
        List listO2 = o(userMetadata.h());
        if (!listO.isEmpty() || !listO2.isEmpty()) {
            builderH.b(event.b().i().e(listO).g(listO2).a());
        }
        return builderH.a();
    }

    private CrashlyticsReport.Session.Event f(CrashlyticsReport.Session.Event event, Map map) {
        return g(e(event, this.f88452d, this.f88453e, map), this.f88453e);
    }

    private CrashlyticsReport.Session.Event g(CrashlyticsReport.Session.Event event, UserMetadata userMetadata) {
        List listI = userMetadata.i();
        if (listI.isEmpty()) {
            return event;
        }
        CrashlyticsReport.Session.Event.Builder builderH = event.h();
        builderH.e(CrashlyticsReport.Session.Event.RolloutsState.a().b(listI).a());
        return builderH.a();
    }

    private static CrashlyticsReport.ApplicationExitInfo h(ApplicationExitInfo applicationExitInfo) {
        String strI = null;
        try {
            InputStream traceInputStream = applicationExitInfo.getTraceInputStream();
            if (traceInputStream != null) {
                strI = i(traceInputStream);
            }
        } catch (IOException e3) {
            Logger.f().k("Could not get input trace in application exit info: " + applicationExitInfo.toString() + " Error: " + e3);
        }
        return CrashlyticsReport.ApplicationExitInfo.a().c(applicationExitInfo.getImportance()).e(applicationExitInfo.getProcessName()).g(applicationExitInfo.getReason()).i(applicationExitInfo.getTimestamp()).d(applicationExitInfo.getPid()).f(applicationExitInfo.getPss()).h(applicationExitInfo.getRss()).j(strI).a();
    }

    public static String i(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
            } finally {
            }
        } catch (Throwable th) {
            try {
                bufferedInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
        while (true) {
            int i3 = bufferedInputStream.read(bArr);
            if (i3 == -1) {
                String string = byteArrayOutputStream.toString(StandardCharsets.UTF_8.name());
                byteArrayOutputStream.close();
                bufferedInputStream.close();
                return string;
            }
            byteArrayOutputStream.write(bArr, 0, i3);
            bufferedInputStream.close();
            throw th;
        }
    }

    public static SessionReportingCoordinator j(Context context, IdManager idManager, FileStore fileStore, AppData appData, LogFileManager logFileManager, UserMetadata userMetadata, StackTraceTrimmingStrategy stackTraceTrimmingStrategy, SettingsProvider settingsProvider, OnDemandCounter onDemandCounter, CrashlyticsAppQualitySessionsSubscriber crashlyticsAppQualitySessionsSubscriber, CrashlyticsWorkers crashlyticsWorkers) {
        return new SessionReportingCoordinator(new CrashlyticsReportDataCapture(context, idManager, appData, stackTraceTrimmingStrategy, settingsProvider), new CrashlyticsReportPersistence(fileStore, settingsProvider, crashlyticsAppQualitySessionsSubscriber), DataTransportCrashlyticsReportSender.b(context, settingsProvider, onDemandCounter), logFileManager, userMetadata, idManager, crashlyticsWorkers);
    }

    private CrashlyticsReportWithSessionId k(CrashlyticsReportWithSessionId crashlyticsReportWithSessionId) {
        if (crashlyticsReportWithSessionId.b().h() != null && crashlyticsReportWithSessionId.b().g() != null) {
            return crashlyticsReportWithSessionId;
        }
        FirebaseInstallationId firebaseInstallationIdD = this.f88454f.d(true);
        return CrashlyticsReportWithSessionId.a(crashlyticsReportWithSessionId.b().t(firebaseInstallationIdD.b()).s(firebaseInstallationIdD.a()), crashlyticsReportWithSessionId.d(), crashlyticsReportWithSessionId.c());
    }

    private ApplicationExitInfo n(String str, List list) {
        long jQ = this.f88450b.q(str);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ApplicationExitInfo applicationExitInfoA = androidx.work.impl.utils.b.a(it.next());
            if (applicationExitInfoA.getTimestamp() < jQ) {
                return null;
            }
            if (applicationExitInfoA.getReason() == 6) {
                return applicationExitInfoA;
            }
        }
        return null;
    }

    private static List o(Map map) {
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(map.size());
        for (Map.Entry entry : map.entrySet()) {
            arrayList.add(CrashlyticsReport.CustomAttribute.a().b((String) entry.getKey()).c((String) entry.getValue()).a());
        }
        Collections.sort(arrayList, new Comparator() { // from class: com.google.firebase.crashlytics.internal.common.w
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((CrashlyticsReport.CustomAttribute) obj).b().compareTo(((CrashlyticsReport.CustomAttribute) obj2).b());
            }
        });
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean s(Task task) {
        if (!task.isSuccessful()) {
            Logger.f().l("Crashlytics report could not be enqueued to DataTransport", task.getException());
            return false;
        }
        CrashlyticsReportWithSessionId crashlyticsReportWithSessionId = (CrashlyticsReportWithSessionId) task.getResult();
        Logger.f().b("Crashlytics report successfully enqueued to DataTransport: " + crashlyticsReportWithSessionId.d());
        File fileC = crashlyticsReportWithSessionId.c();
        if (fileC.delete()) {
            Logger.f().b("Deleted report file: " + fileC.getPath());
            return true;
        }
        Logger.f().k("Crashlytics could not delete report file: " + fileC.getPath());
        return true;
    }

    private void t(Throwable th, Thread thread, String str, final EventMetadata eventMetadata, boolean z2) {
        final boolean zEquals = str.equals("crash");
        final CrashlyticsReport.Session.Event eventF = f(this.f88449a.d(th, thread, str, eventMetadata.c(), 4, 8, z2), eventMetadata.a());
        if (z2) {
            this.f88450b.w(eventF, eventMetadata.b(), zEquals);
        } else {
            this.f88455g.f88492b.d(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.u
                @Override // java.lang.Runnable
                public final void run() {
                    SessionReportingCoordinator.a(this.f88479a, eventF, eventMetadata, zEquals);
                }
            });
        }
    }

    public void l(String str, List list, CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        Logger.f().b("SessionReportingCoordinator#finalizeSessionWithNativeEvent");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CrashlyticsReport.FilesPayload.File fileA = ((NativeSessionFile) it.next()).a();
            if (fileA != null) {
                arrayList.add(fileA);
            }
        }
        this.f88450b.l(str, CrashlyticsReport.FilesPayload.a().b(Collections.unmodifiableList(arrayList)).a(), applicationExitInfo);
    }

    public void m(long j3, String str) {
        this.f88450b.k(str, j3);
    }

    public boolean p() {
        return this.f88450b.r();
    }

    public SortedSet q() {
        return this.f88450b.p();
    }

    public void r(String str, long j3) {
        this.f88450b.x(this.f88449a.e(str, j3));
    }

    public void u(Throwable th, Thread thread, String str, long j3) {
        Logger.f().i("Persisting fatal event for session " + str);
        t(th, thread, "crash", new EventMetadata(str, j3), true);
    }

    public void v(Throwable th, Thread thread, EventMetadata eventMetadata) {
        Logger.f().i("Persisting non-fatal event for session " + eventMetadata.b());
        t(th, thread, "error", eventMetadata, false);
    }

    public void w(String str, List list, LogFileManager logFileManager, UserMetadata userMetadata) {
        ApplicationExitInfo applicationExitInfoN = n(str, list);
        if (applicationExitInfoN == null) {
            Logger.f().i("No relevant ApplicationExitInfo occurred during session: " + str);
            return;
        }
        CrashlyticsReport.Session.Event eventC = this.f88449a.c(h(applicationExitInfoN));
        Logger.f().b("Persisting anr for session " + str);
        this.f88450b.w(g(d(eventC, logFileManager, userMetadata), userMetadata), str, true);
    }

    public void x() {
        this.f88450b.i();
    }

    public Task y(Executor executor) {
        return z(executor, null);
    }

    public Task z(Executor executor, String str) {
        List<CrashlyticsReportWithSessionId> listU = this.f88450b.u();
        ArrayList arrayList = new ArrayList();
        for (CrashlyticsReportWithSessionId crashlyticsReportWithSessionId : listU) {
            if (str == null || str.equals(crashlyticsReportWithSessionId.d())) {
                arrayList.add(this.f88451c.c(k(crashlyticsReportWithSessionId), str != null).continueWith(executor, new Continuation() { // from class: com.google.firebase.crashlytics.internal.common.v
                    @Override // com.google.android.gms.tasks.Continuation
                    public final Object then(Task task) {
                        return Boolean.valueOf(this.f88483a.s(task));
                    }
                }));
            }
        }
        return Tasks.whenAll(arrayList);
    }
}
