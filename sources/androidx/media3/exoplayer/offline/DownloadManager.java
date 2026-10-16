package androidx.media3.exoplayer.offline;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.offline.Downloader;
import androidx.media3.exoplayer.scheduler.Requirements;
import androidx.media3.exoplayer.scheduler.RequirementsWatcher;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DownloadManager {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Requirements f44388m = new Requirements(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f44389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InternalHandler f44390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RequirementsWatcher.Listener f44391c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CopyOnWriteArraySet f44392d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f44393e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f44394f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f44395g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f44396h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f44397i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f44398j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List f44399k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private RequirementsWatcher f44400l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class DownloadUpdate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Download f44401a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f44402b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List f44403c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Exception f44404d;

        public DownloadUpdate(Download download, boolean z2, List list, Exception exc) {
            this.f44401a = download;
            this.f44402b = z2;
            this.f44403c = list;
            this.f44404d = exc;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class InternalHandler extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f44405a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final HandlerThread f44406b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final WritableDownloadIndex f44407c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final DownloaderFactory f44408d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Handler f44409e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ArrayList f44410f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final HashMap f44411g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f44412h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f44413i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f44414j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f44415k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f44416l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private boolean f44417m;

        private void A(Task task) {
            if (task != null) {
                Assertions.g(!task.f44421d);
                task.f(false);
            }
        }

        private void B() {
            int i3 = 0;
            for (int i4 = 0; i4 < this.f44410f.size(); i4++) {
                Download download = (Download) this.f44410f.get(i4);
                Task taskY = (Task) this.f44411g.get(download.f44370a.f44429a);
                int i5 = download.f44371b;
                if (i5 == 0) {
                    taskY = y(taskY, download);
                } else if (i5 == 1) {
                    A(taskY);
                } else if (i5 == 2) {
                    Assertions.e(taskY);
                    x(taskY, download, i3);
                } else {
                    if (i5 != 5 && i5 != 7) {
                        throw new IllegalStateException();
                    }
                    z(taskY, download);
                }
                if (taskY != null && !taskY.f44421d) {
                    i3++;
                }
            }
        }

        private void C() {
            for (int i3 = 0; i3 < this.f44410f.size(); i3++) {
                Download download = (Download) this.f44410f.get(i3);
                if (download.f44371b == 2) {
                    try {
                        this.f44407c.b(download);
                    } catch (IOException e3) {
                        Log.e("DownloadManager", "Failed to update index.", e3);
                    }
                }
            }
            sendEmptyMessageDelayed(12, 5000L);
        }

        private void b(DownloadRequest downloadRequest, int i3) {
            Download downloadF = f(downloadRequest.f44429a, true);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (downloadF != null) {
                m(DownloadManager.j(downloadF, downloadRequest, i3, jCurrentTimeMillis));
            } else {
                m(new Download(downloadRequest, i3 == 0 ? 0 : 1, jCurrentTimeMillis, jCurrentTimeMillis, -1L, i3, 0));
            }
            B();
        }

        private boolean c() {
            return !this.f44413i && this.f44412h == 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int d(Download download, Download download2) {
            return Util.p(download.f44372c, download2.f44372c);
        }

        private static Download e(Download download, int i3, int i4) {
            return new Download(download.f44370a, i3, download.f44372c, System.currentTimeMillis(), download.f44374e, i4, 0, download.f44377h);
        }

        private Download f(String str, boolean z2) {
            int iG = g(str);
            if (iG != -1) {
                return (Download) this.f44410f.get(iG);
            }
            if (!z2) {
                return null;
            }
            try {
                return this.f44407c.h(str);
            } catch (IOException e3) {
                Log.e("DownloadManager", "Failed to load download: " + str, e3);
                return null;
            }
        }

        private int g(String str) {
            for (int i3 = 0; i3 < this.f44410f.size(); i3++) {
                if (((Download) this.f44410f.get(i3)).f44370a.f44429a.equals(str)) {
                    return i3;
                }
            }
            return -1;
        }

        private void h(int i3) {
            this.f44412h = i3;
            DownloadCursor downloadCursorE = null;
            try {
                try {
                    this.f44407c.g();
                    downloadCursorE = this.f44407c.e(0, 1, 2, 5, 7);
                    while (downloadCursorE.moveToNext()) {
                        this.f44410f.add(downloadCursorE.V0());
                    }
                } catch (IOException e3) {
                    Log.e("DownloadManager", "Failed to load index.", e3);
                    this.f44410f.clear();
                }
                this.f44409e.obtainMessage(1, new ArrayList(this.f44410f)).sendToTarget();
                B();
            } finally {
                Util.o(downloadCursorE);
            }
        }

        private void i(Task task, long j3) {
            Download download = (Download) Assertions.e(f(task.f44418a.f44429a, false));
            if (j3 == download.f44374e || j3 == -1) {
                return;
            }
            m(new Download(download.f44370a, download.f44371b, download.f44372c, System.currentTimeMillis(), j3, download.f44375f, download.f44376g, download.f44377h));
        }

        private void j(Download download, Exception exc) {
            Download download2 = new Download(download.f44370a, exc == null ? 3 : 4, download.f44372c, System.currentTimeMillis(), download.f44374e, download.f44375f, exc == null ? 0 : 1, download.f44377h);
            this.f44410f.remove(g(download2.f44370a.f44429a));
            try {
                this.f44407c.b(download2);
            } catch (IOException e3) {
                Log.e("DownloadManager", "Failed to update index.", e3);
            }
            this.f44409e.obtainMessage(3, new DownloadUpdate(download2, false, new ArrayList(this.f44410f), exc)).sendToTarget();
        }

        private void k(Download download) {
            if (download.f44371b == 7) {
                int i3 = download.f44375f;
                n(download, i3 == 0 ? 0 : 1, i3);
                B();
            } else {
                this.f44410f.remove(g(download.f44370a.f44429a));
                try {
                    this.f44407c.c(download.f44370a.f44429a);
                } catch (IOException unused) {
                    Log.d("DownloadManager", "Failed to remove from database");
                }
                this.f44409e.obtainMessage(3, new DownloadUpdate(download, true, new ArrayList(this.f44410f), null)).sendToTarget();
            }
        }

        private void l(Task task) {
            String str = task.f44418a.f44429a;
            this.f44411g.remove(str);
            boolean z2 = task.f44421d;
            if (z2) {
                this.f44417m = false;
            } else {
                int i3 = this.f44416l - 1;
                this.f44416l = i3;
                if (i3 == 0) {
                    removeMessages(12);
                }
            }
            if (task.f44424h) {
                B();
                return;
            }
            Exception exc = task.f44425i;
            if (exc != null) {
                Log.e("DownloadManager", "Task failed: " + task.f44418a + ", " + z2, exc);
            }
            Download download = (Download) Assertions.e(f(str, false));
            int i4 = download.f44371b;
            if (i4 == 2) {
                Assertions.g(!z2);
                j(download, exc);
            } else {
                if (i4 != 5 && i4 != 7) {
                    throw new IllegalStateException();
                }
                Assertions.g(z2);
                k(download);
            }
            B();
        }

        private Download m(Download download) {
            int i3 = download.f44371b;
            Assertions.g((i3 == 3 || i3 == 4) ? false : true);
            int iG = g(download.f44370a.f44429a);
            if (iG == -1) {
                this.f44410f.add(download);
                Collections.sort(this.f44410f, new a());
            } else {
                boolean z2 = download.f44372c != ((Download) this.f44410f.get(iG)).f44372c;
                this.f44410f.set(iG, download);
                if (z2) {
                    Collections.sort(this.f44410f, new a());
                }
            }
            try {
                this.f44407c.b(download);
            } catch (IOException e3) {
                Log.e("DownloadManager", "Failed to update index.", e3);
            }
            this.f44409e.obtainMessage(3, new DownloadUpdate(download, false, new ArrayList(this.f44410f), null)).sendToTarget();
            return download;
        }

        private Download n(Download download, int i3, int i4) {
            Assertions.g((i3 == 3 || i3 == 4) ? false : true);
            return m(e(download, i3, i4));
        }

        private void o() {
            Iterator it = this.f44411g.values().iterator();
            while (it.hasNext()) {
                ((Task) it.next()).f(true);
            }
            try {
                this.f44407c.g();
            } catch (IOException e3) {
                Log.e("DownloadManager", "Failed to update index.", e3);
            }
            this.f44410f.clear();
            this.f44406b.quit();
            synchronized (this) {
                this.f44405a = true;
                notifyAll();
            }
        }

        private void p() {
            ArrayList arrayList = new ArrayList();
            try {
                DownloadCursor downloadCursorE = this.f44407c.e(3, 4);
                while (downloadCursorE.moveToNext()) {
                    try {
                        arrayList.add(downloadCursorE.V0());
                    } finally {
                    }
                }
                downloadCursorE.close();
            } catch (IOException unused) {
                Log.d("DownloadManager", "Failed to load downloads.");
            }
            for (int i3 = 0; i3 < this.f44410f.size(); i3++) {
                ArrayList arrayList2 = this.f44410f;
                arrayList2.set(i3, e((Download) arrayList2.get(i3), 5, 0));
            }
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                this.f44410f.add(e((Download) arrayList.get(i4), 5, 0));
            }
            Collections.sort(this.f44410f, new a());
            try {
                this.f44407c.f();
            } catch (IOException e3) {
                Log.e("DownloadManager", "Failed to update index.", e3);
            }
            ArrayList arrayList3 = new ArrayList(this.f44410f);
            for (int i5 = 0; i5 < this.f44410f.size(); i5++) {
                this.f44409e.obtainMessage(3, new DownloadUpdate((Download) this.f44410f.get(i5), false, arrayList3, null)).sendToTarget();
            }
            B();
        }

        private void q(String str) {
            Download downloadF = f(str, true);
            if (downloadF != null) {
                n(downloadF, 5, 0);
                B();
            } else {
                Log.d("DownloadManager", "Failed to remove nonexistent download: " + str);
            }
        }

        private void r(boolean z2) {
            this.f44413i = z2;
            B();
        }

        private void s(int i3) {
            this.f44414j = i3;
            B();
        }

        private void t(int i3) {
            this.f44415k = i3;
        }

        private void u(int i3) {
            this.f44412h = i3;
            B();
        }

        private void v(Download download, int i3) {
            if (i3 == 0) {
                if (download.f44371b == 1) {
                    n(download, 0, 0);
                }
            } else if (i3 != download.f44375f) {
                int i4 = download.f44371b;
                if (i4 == 0 || i4 == 2) {
                    i4 = 1;
                }
                m(new Download(download.f44370a, i4, download.f44372c, System.currentTimeMillis(), download.f44374e, i3, 0, download.f44377h));
            }
        }

        private void w(String str, int i3) {
            if (str == null) {
                for (int i4 = 0; i4 < this.f44410f.size(); i4++) {
                    v((Download) this.f44410f.get(i4), i3);
                }
                try {
                    this.f44407c.d(i3);
                } catch (IOException e3) {
                    Log.e("DownloadManager", "Failed to set manual stop reason", e3);
                }
            } else {
                Download downloadF = f(str, false);
                if (downloadF != null) {
                    v(downloadF, i3);
                } else {
                    try {
                        this.f44407c.a(str, i3);
                    } catch (IOException e4) {
                        Log.e("DownloadManager", "Failed to set manual stop reason: " + str, e4);
                    }
                }
            }
            B();
        }

        private void x(Task task, Download download, int i3) {
            Assertions.g(!task.f44421d);
            if (!c() || i3 >= this.f44414j) {
                n(download, 0, 0);
                task.f(false);
            }
        }

        private Task y(Task task, Download download) {
            if (task != null) {
                Assertions.g(!task.f44421d);
                task.f(false);
                return task;
            }
            if (!c() || this.f44416l >= this.f44414j) {
                return null;
            }
            Download downloadN = n(download, 2, 0);
            Task task2 = new Task(downloadN.f44370a, this.f44408d.a(downloadN.f44370a), downloadN.f44377h, false, this.f44415k, this);
            this.f44411g.put(downloadN.f44370a.f44429a, task2);
            int i3 = this.f44416l;
            this.f44416l = i3 + 1;
            if (i3 == 0) {
                sendEmptyMessageDelayed(12, 5000L);
            }
            task2.start();
            return task2;
        }

        private void z(Task task, Download download) {
            if (task != null) {
                if (task.f44421d) {
                    return;
                }
                task.f(false);
            } else {
                if (this.f44417m) {
                    return;
                }
                Task task2 = new Task(download.f44370a, this.f44408d.a(download.f44370a), download.f44377h, true, this.f44415k, this);
                this.f44411g.put(download.f44370a.f44429a, task2);
                this.f44417m = true;
                task2.start();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = 0;
            switch (message.what) {
                case 1:
                    h(message.arg1);
                    i3 = 1;
                    this.f44409e.obtainMessage(2, i3, this.f44411g.size()).sendToTarget();
                    return;
                case 2:
                    r(message.arg1 != 0);
                    i3 = 1;
                    this.f44409e.obtainMessage(2, i3, this.f44411g.size()).sendToTarget();
                    return;
                case 3:
                    u(message.arg1);
                    i3 = 1;
                    this.f44409e.obtainMessage(2, i3, this.f44411g.size()).sendToTarget();
                    return;
                case 4:
                    w((String) message.obj, message.arg1);
                    i3 = 1;
                    this.f44409e.obtainMessage(2, i3, this.f44411g.size()).sendToTarget();
                    return;
                case 5:
                    s(message.arg1);
                    i3 = 1;
                    this.f44409e.obtainMessage(2, i3, this.f44411g.size()).sendToTarget();
                    return;
                case 6:
                    t(message.arg1);
                    i3 = 1;
                    this.f44409e.obtainMessage(2, i3, this.f44411g.size()).sendToTarget();
                    return;
                case 7:
                    b((DownloadRequest) message.obj, message.arg1);
                    i3 = 1;
                    this.f44409e.obtainMessage(2, i3, this.f44411g.size()).sendToTarget();
                    return;
                case 8:
                    q((String) message.obj);
                    i3 = 1;
                    this.f44409e.obtainMessage(2, i3, this.f44411g.size()).sendToTarget();
                    return;
                case 9:
                    p();
                    i3 = 1;
                    this.f44409e.obtainMessage(2, i3, this.f44411g.size()).sendToTarget();
                    return;
                case 10:
                    l((Task) message.obj);
                    this.f44409e.obtainMessage(2, i3, this.f44411g.size()).sendToTarget();
                    return;
                case 11:
                    i((Task) message.obj, Util.p1(message.arg1, message.arg2));
                    return;
                case 12:
                    C();
                    return;
                case 13:
                    o();
                    return;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Task extends Thread implements Downloader.ProgressListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DownloadRequest f44418a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Downloader f44419b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final DownloadProgress f44420c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f44421d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f44422f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private volatile InternalHandler f44423g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private volatile boolean f44424h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private Exception f44425i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f44426j;

        private static int g(int i3) {
            return Math.min((i3 - 1) * 1000, 5000);
        }

        @Override // androidx.media3.exoplayer.offline.Downloader.ProgressListener
        public void a(long j3, long j4, float f3) {
            this.f44420c.f44427a = j4;
            this.f44420c.f44428b = f3;
            if (j3 != this.f44426j) {
                this.f44426j = j3;
                InternalHandler internalHandler = this.f44423g;
                if (internalHandler != null) {
                    internalHandler.obtainMessage(11, (int) (j3 >> 32), (int) j3, this).sendToTarget();
                }
            }
        }

        public void f(boolean z2) {
            if (z2) {
                this.f44423g = null;
            }
            if (this.f44424h) {
                return;
            }
            this.f44424h = true;
            this.f44419b.cancel();
            interrupt();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                if (this.f44421d) {
                    this.f44419b.remove();
                } else {
                    long j3 = -1;
                    int i3 = 0;
                    while (!this.f44424h) {
                        try {
                            this.f44419b.a(this);
                            break;
                        } catch (IOException e3) {
                            if (!this.f44424h) {
                                long j4 = this.f44420c.f44427a;
                                if (j4 != j3) {
                                    i3 = 0;
                                    j3 = j4;
                                }
                                i3++;
                                if (i3 > this.f44422f) {
                                    throw e3;
                                }
                                Thread.sleep(g(i3));
                            }
                        }
                    }
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (Exception e4) {
                this.f44425i = e4;
            }
            InternalHandler internalHandler = this.f44423g;
            if (internalHandler != null) {
                internalHandler.obtainMessage(10, this).sendToTarget();
            }
        }

        private Task(DownloadRequest downloadRequest, Downloader downloader, DownloadProgress downloadProgress, boolean z2, int i3, InternalHandler internalHandler) {
            this.f44418a = downloadRequest;
            this.f44419b = downloader;
            this.f44420c = downloadProgress;
            this.f44421d = z2;
            this.f44422f = i3;
            this.f44423g = internalHandler;
            this.f44426j = -1L;
        }
    }

    static Download j(Download download, DownloadRequest downloadRequest, int i3, long j3) {
        int i4 = download.f44371b;
        long j4 = (i4 == 5 || download.c()) ? j3 : download.f44372c;
        int i5 = 7;
        if (i4 != 5 && i4 != 7) {
            i5 = i3 != 0 ? 1 : 0;
        }
        return new Download(download.f44370a.a(downloadRequest), i5, j4, j3, -1L, i3, 0);
    }

    private void k() {
        Iterator it = this.f44392d.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).a(this, this.f44398j);
        }
    }

    private void l(RequirementsWatcher requirementsWatcher, int i3) {
        Requirements requirementsF = requirementsWatcher.f();
        if (this.f44397i != i3) {
            this.f44397i = i3;
            this.f44393e++;
            this.f44390b.obtainMessage(3, i3, 0).sendToTarget();
        }
        boolean zT = t();
        Iterator it = this.f44392d.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).c(this, requirementsF, i3);
        }
        if (zT) {
            k();
        }
    }

    private void q(boolean z2) {
        if (this.f44396h == z2) {
            return;
        }
        this.f44396h = z2;
        this.f44393e++;
        this.f44390b.obtainMessage(2, z2 ? 1 : 0, 0).sendToTarget();
        boolean zT = t();
        Iterator it = this.f44392d.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).b(this, z2);
        }
        if (zT) {
            k();
        }
    }

    private boolean t() {
        boolean z2;
        if (this.f44396h || this.f44397i == 0) {
            z2 = false;
        } else {
            for (int i3 = 0; i3 < this.f44399k.size(); i3++) {
                if (((Download) this.f44399k.get(i3)).f44371b == 0) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
        }
        boolean z3 = this.f44398j != z2;
        this.f44398j = z2;
        return z3;
    }

    public void a(DownloadRequest downloadRequest, int i3) {
        this.f44393e++;
        this.f44390b.obtainMessage(7, i3, 0, downloadRequest).sendToTarget();
    }

    public void b(Listener listener) {
        Assertions.e(listener);
        this.f44392d.add(listener);
    }

    public List c() {
        return this.f44399k;
    }

    public boolean d() {
        return this.f44396h;
    }

    public int e() {
        return this.f44397i;
    }

    public Requirements f() {
        return this.f44400l.f();
    }

    public boolean g() {
        return this.f44394f == 0 && this.f44393e == 0;
    }

    public boolean h() {
        return this.f44395g;
    }

    public boolean i() {
        return this.f44398j;
    }

    public void m() {
        q(true);
    }

    public void n() {
        this.f44393e++;
        this.f44390b.obtainMessage(9).sendToTarget();
    }

    public void o(String str) {
        this.f44393e++;
        this.f44390b.obtainMessage(8, str).sendToTarget();
    }

    public void p() {
        q(false);
    }

    public void r(Requirements requirements) {
        if (requirements.equals(this.f44400l.f())) {
            return;
        }
        this.f44400l.j();
        RequirementsWatcher requirementsWatcher = new RequirementsWatcher(this.f44389a, this.f44391c, requirements);
        this.f44400l = requirementsWatcher;
        l(this.f44400l, requirementsWatcher.i());
    }

    public void s(String str, int i3) {
        this.f44393e++;
        this.f44390b.obtainMessage(4, i3, 0, str).sendToTarget();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Listener {
        default void a(DownloadManager downloadManager, boolean z2) {
        }

        default void b(DownloadManager downloadManager, boolean z2) {
        }

        default void c(DownloadManager downloadManager, Requirements requirements, int i3) {
        }
    }
}
