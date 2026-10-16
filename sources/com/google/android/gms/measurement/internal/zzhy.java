package com.google.android.gms.measurement.internal;

import android.os.Process;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzhy extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f73868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BlockingQueue f73869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f73870c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzhz f73871d;

    public zzhy(zzhz zzhzVar, String str, BlockingQueue blockingQueue) {
        Objects.requireNonNull(zzhzVar);
        this.f73871d = zzhzVar;
        this.f73870c = false;
        Preconditions.m(str);
        Preconditions.m(blockingQueue);
        this.f73868a = new Object();
        this.f73869b = blockingQueue;
        setName(str);
    }

    private final void b() {
        zzhz zzhzVar = this.f73871d;
        synchronized (zzhzVar.B()) {
            try {
                if (!this.f73870c) {
                    zzhzVar.C().release();
                    zzhzVar.B().notifyAll();
                    if (this == zzhzVar.x()) {
                        zzhzVar.y(null);
                    } else if (this == zzhzVar.z()) {
                        zzhzVar.A(null);
                    } else {
                        zzhzVar.f73997a.a().o().a("Current scheduler thread is neither worker nor network");
                    }
                    this.f73870c = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void c(InterruptedException interruptedException) {
        this.f73871d.f73997a.a().r().b(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    public final void a() {
        Object obj = this.f73868a;
        synchronized (obj) {
            obj.notifyAll();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        boolean z2 = false;
        while (!z2) {
            try {
                this.f73871d.C().acquire();
                z2 = true;
            } catch (InterruptedException e3) {
                c(e3);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                BlockingQueue blockingQueue = this.f73869b;
                zzhx zzhxVar = (zzhx) blockingQueue.poll();
                if (zzhxVar != null) {
                    Process.setThreadPriority(true != zzhxVar.f73865b ? 10 : threadPriority);
                    zzhxVar.run();
                } else {
                    Object obj = this.f73868a;
                    synchronized (obj) {
                        if (blockingQueue.peek() == null) {
                            this.f73871d.D();
                            try {
                                obj.wait(30000L);
                            } catch (InterruptedException e4) {
                                c(e4);
                            }
                        }
                    }
                    synchronized (this.f73871d.B()) {
                        if (this.f73869b.peek() == null) {
                            b();
                            b();
                            return;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            b();
            throw th;
        }
    }
}
