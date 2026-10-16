package com.google.firebase.crashlytics.internal.persistence;

import com.facebook.internal.Utility;
import com.facebook.stetho.common.Utf8Charset;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.breadcrumbs.PKU.tDEtWsFLJfe;
import com.google.firebase.crashlytics.internal.common.CrashlyticsAppQualitySessionsSubscriber;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class CrashlyticsReportPersistence {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Charset f89005e = Charset.forName(Utf8Charset.NAME);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f89006f = 15;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final CrashlyticsReportJsonTransform f89007g = new CrashlyticsReportJsonTransform();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Comparator f89008h = new Comparator() { // from class: w.a
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return ((File) obj2).getName().compareTo(((File) obj).getName());
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final FilenameFilter f89009i = new FilenameFilter() { // from class: w.b
        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            return str.startsWith("event");
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicInteger f89010a = new AtomicInteger(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FileStore f89011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SettingsProvider f89012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CrashlyticsAppQualitySessionsSubscriber f89013d;

    public CrashlyticsReportPersistence(FileStore fileStore, SettingsProvider settingsProvider, CrashlyticsAppQualitySessionsSubscriber crashlyticsAppQualitySessionsSubscriber) {
        this.f89011b = fileStore;
        this.f89012c = settingsProvider;
        this.f89013d = crashlyticsAppQualitySessionsSubscriber;
    }

    private void A(String str, long j3) {
        boolean z2;
        List<File> listR = this.f89011b.r(str, f89009i);
        if (listR.isEmpty()) {
            Logger.f().i("Session " + str + " has no events.");
            return;
        }
        Collections.sort(listR);
        ArrayList arrayList = new ArrayList();
        loop0: while (true) {
            z2 = false;
            for (File file : listR) {
                try {
                    arrayList.add(f89007g.j(y(file)));
                } catch (IOException e3) {
                    Logger.f().l("Could not add event to report for " + file, e3);
                }
                if (z2 || s(file.getName())) {
                    z2 = true;
                }
            }
        }
        if (!arrayList.isEmpty()) {
            B(this.f89011b.q(str, "report"), arrayList, j3, z2, UserMetadata.l(str, this.f89011b), this.f89013d.d(str));
        } else {
            Logger.f().k("Could not parse event files for session " + str);
        }
    }

    private void B(File file, List list, long j3, boolean z2, String str, String str2) {
        try {
            CrashlyticsReportJsonTransform crashlyticsReportJsonTransform = f89007g;
            CrashlyticsReport crashlyticsReportR = crashlyticsReportJsonTransform.L(y(file)).v(j3, z2, str).p(str2).r(list);
            CrashlyticsReport.Session sessionN = crashlyticsReportR.n();
            if (sessionN == null) {
                return;
            }
            Logger.f().b("appQualitySessionId: " + str2);
            D(z2 ? this.f89011b.l(sessionN.i()) : this.f89011b.n(sessionN.i()), crashlyticsReportJsonTransform.M(crashlyticsReportR));
        } catch (IOException e3) {
            Logger.f().l("Could not synthesize final report file for " + file, e3);
        }
    }

    private int C(String str, int i3) {
        List listR = this.f89011b.r(str, new FilenameFilter() { // from class: w.c
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str2) {
                return CrashlyticsReportPersistence.t(file, str2);
            }
        });
        Collections.sort(listR, new Comparator() { // from class: w.d
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return CrashlyticsReportPersistence.v((File) obj, (File) obj2);
            }
        });
        return f(listR, i3);
    }

    private static void D(File file, String str) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), f89005e);
        try {
            outputStreamWriter.write(str);
            outputStreamWriter.close();
        } catch (Throwable th) {
            try {
                outputStreamWriter.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static void E(File file, String str, long j3) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), f89005e);
        try {
            outputStreamWriter.write(str);
            file.setLastModified(h(j3));
            outputStreamWriter.close();
        } catch (Throwable th) {
            try {
                outputStreamWriter.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private SortedSet e(String str) {
        this.f89011b.d();
        SortedSet sortedSetP = p();
        if (str != null) {
            sortedSetP.remove(str);
        }
        if (sortedSetP.size() > 8) {
            while (sortedSetP.size() > 8) {
                String str2 = (String) sortedSetP.last();
                Logger.f().b("Removing session over cap: " + str2);
                this.f89011b.e(str2);
                sortedSetP.remove(str2);
            }
        }
        return sortedSetP;
    }

    private static int f(List list, int i3) {
        int size = list.size();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            if (size <= i3) {
                break;
            }
            FileStore.u(file);
            size--;
        }
        return size;
    }

    private void g() {
        int i3 = this.f89012c.b().f89051a.f89063b;
        List listN = n();
        int size = listN.size();
        if (size <= i3) {
            return;
        }
        Iterator it = listN.subList(i3, size).iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
    }

    private static long h(long j3) {
        return j3 * 1000;
    }

    private void j(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
    }

    private static String m(int i3, boolean z2) {
        return "event" + String.format(Locale.US, "%010d", Integer.valueOf(i3)) + (z2 ? "_" : "");
    }

    private List n() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f89011b.m());
        arrayList.addAll(this.f89011b.j());
        Comparator comparator = f89008h;
        Collections.sort(arrayList, comparator);
        List listO = this.f89011b.o();
        Collections.sort(listO, comparator);
        arrayList.addAll(listO);
        return arrayList;
    }

    private static String o(String str) {
        return str.substring(0, f89006f);
    }

    private static boolean s(String str) {
        return str.startsWith("event") && str.endsWith("_");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean t(File file, String str) {
        return str.startsWith("event") && !str.endsWith("_");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int v(File file, File file2) {
        return o(file.getName()).compareTo(o(file2.getName()));
    }

    private static String y(File file) throws IOException {
        byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int i3 = fileInputStream.read(bArr);
                if (i3 <= 0) {
                    String str = new String(byteArrayOutputStream.toByteArray(), f89005e);
                    fileInputStream.close();
                    return str;
                }
                byteArrayOutputStream.write(bArr, 0, i3);
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    private void z(File file, CrashlyticsReport.FilesPayload filesPayload, String str, CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        String strD = this.f89013d.d(str);
        try {
            CrashlyticsReportJsonTransform crashlyticsReportJsonTransform = f89007g;
            D(this.f89011b.i(str), crashlyticsReportJsonTransform.M(crashlyticsReportJsonTransform.L(y(file)).u(filesPayload).q(applicationExitInfo).p(strD)));
        } catch (IOException e3) {
            Logger.f().l("Could not synthesize final native report file for " + file, e3);
        }
    }

    public void i() {
        j(this.f89011b.o());
        j(this.f89011b.m());
        j(this.f89011b.j());
    }

    public void k(String str, long j3) {
        for (String str2 : e(str)) {
            Logger.f().i("Finalizing report for session " + str2);
            A(str2, j3);
            this.f89011b.e(str2);
        }
        g();
    }

    public void l(String str, CrashlyticsReport.FilesPayload filesPayload, CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        File fileQ = this.f89011b.q(str, "report");
        Logger.f().b("Writing native session report for " + str + " to file: " + fileQ);
        z(fileQ, filesPayload, str, applicationExitInfo);
    }

    public SortedSet p() {
        return new TreeSet(this.f89011b.f()).descendingSet();
    }

    public long q(String str) {
        return this.f89011b.q(str, "start-time").lastModified();
    }

    public boolean r() {
        return (this.f89011b.o().isEmpty() && this.f89011b.m().isEmpty() && this.f89011b.j().isEmpty()) ? false : true;
    }

    public void w(CrashlyticsReport.Session.Event event, String str, boolean z2) {
        int i3 = this.f89012c.b().f89051a.f89062a;
        try {
            D(this.f89011b.q(str, m(this.f89010a.getAndIncrement(), z2)), f89007g.k(event));
        } catch (IOException e3) {
            Logger.f().l("Could not persist event for session " + str, e3);
        }
        C(str, i3);
    }

    public void x(CrashlyticsReport crashlyticsReport) {
        CrashlyticsReport.Session sessionN = crashlyticsReport.n();
        if (sessionN == null) {
            Logger.f().b("Could not get session for report");
            return;
        }
        String strI = sessionN.i();
        try {
            D(this.f89011b.q(strI, "report"), f89007g.M(crashlyticsReport));
            E(this.f89011b.q(strI, "start-time"), "", sessionN.l());
        } catch (IOException e3) {
            Logger.f().c("Could not persist report for session " + strI, e3);
        }
    }

    public List u() {
        List<File> listN = n();
        ArrayList arrayList = new ArrayList();
        for (File file : listN) {
            try {
                arrayList.add(CrashlyticsReportWithSessionId.a(f89007g.L(y(file)), file.getName(), file));
            } catch (IOException e3) {
                Logger.f().l("Could not load report file " + file + tDEtWsFLJfe.wZPCF, e3);
                file.delete();
            }
        }
        return arrayList;
    }
}
