package com.applovin.impl.sdk;

import android.os.Process;
import com.applovin.impl.ka;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sj;
import java.lang.Thread;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AppLovinExceptionHandler implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AppLovinExceptionHandler f63131d = new AppLovinExceptionHandler();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set f63132a = new HashSet(2);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f63133b = new AtomicBoolean();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f63134c;

    public static AppLovinExceptionHandler shared() {
        return f63131d;
    }

    public void addSdk(j jVar) {
        if (this.f63132a.contains(jVar)) {
            return;
        }
        this.f63132a.add(jVar);
    }

    public void enable() {
        if (this.f63133b.compareAndSet(false, true)) {
            this.f63134c = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        long jLongValue = 500;
        for (j jVar : this.f63132a) {
            jVar.I();
            if (n.a()) {
                jVar.I().a("AppLovinExceptionHandler", "Detected unhandled exception");
            }
            jVar.D().a(ka.T, CollectionUtils.map("top_main_method", th.toString()));
            jVar.z().trackEventSynchronously("paused");
            jLongValue = ((Long) jVar.a(sj.p3)).longValue();
        }
        try {
            Thread.sleep(jLongValue);
        } catch (InterruptedException unused) {
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f63134c;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        } else {
            Process.killProcess(Process.myPid());
            System.exit(1);
        }
    }
}
