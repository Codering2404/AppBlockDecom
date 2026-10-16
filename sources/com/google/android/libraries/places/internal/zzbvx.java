package com.google.android.libraries.places.internal;

import com.facebook.internal.ServerProtocol;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbvx extends WeakReference {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final boolean f77039f = Boolean.parseBoolean(System.getProperty("io.grpc.ManagedChannel.enableAllocationTracking", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final RuntimeException f77040g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ReferenceQueue f77041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentMap f77042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f77043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Reference f77044d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f77045e;

    static {
        RuntimeException runtimeException = new RuntimeException("ManagedChannel allocation site not recorded.  Set -Dio.grpc.ManagedChannel.enableAllocationTracking=true to enable it");
        runtimeException.setStackTrace(new StackTraceElement[0]);
        f77040g = runtimeException;
    }

    zzbvx(zzbvy zzbvyVar, zzblw zzblwVar, ReferenceQueue referenceQueue, ConcurrentMap concurrentMap) {
        super(zzbvyVar, referenceQueue);
        this.f77045e = new AtomicBoolean();
        this.f77044d = new SoftReference(f77039f ? new RuntimeException("ManagedChannel allocation site") : f77040g);
        this.f77043c = zzblwVar.toString();
        this.f77041a = referenceQueue;
        this.f77042b = concurrentMap;
        concurrentMap.put(this, this);
        a(referenceQueue);
    }

    static int a(ReferenceQueue referenceQueue) {
        int i3 = 0;
        while (true) {
            zzbvx zzbvxVar = (zzbvx) referenceQueue.poll();
            if (zzbvxVar == null) {
                return i3;
            }
            RuntimeException runtimeException = (RuntimeException) zzbvxVar.f77044d.get();
            zzbvxVar.c();
            if (!zzbvxVar.f77045e.get()) {
                i3++;
                Level level = Level.SEVERE;
                if (zzbvy.f77048e.isLoggable(level)) {
                    String property = System.getProperty("line.separator");
                    StringBuilder sb = new StringBuilder(String.valueOf(property).length() + 127);
                    sb.append("*~*~*~ Previous channel {0} was garbage collected without being shut down! ~*~*~*");
                    sb.append(property);
                    sb.append("    Make sure to call shutdown()/shutdownNow()");
                    LogRecord logRecord = new LogRecord(level, sb.toString());
                    logRecord.setLoggerName(zzbvy.f77048e.getName());
                    logRecord.setParameters(new Object[]{zzbvxVar.f77043c});
                    logRecord.setThrown(runtimeException);
                    zzbvy.f77048e.log(logRecord);
                }
            }
        }
    }

    private final void c() {
        super.clear();
        this.f77042b.remove(this);
        this.f77044d.clear();
    }

    final /* synthetic */ void b() {
        if (this.f77045e.getAndSet(true)) {
            return;
        }
        clear();
    }

    @Override // java.lang.ref.Reference
    public final void clear() {
        c();
        a(this.f77041a);
    }
}
