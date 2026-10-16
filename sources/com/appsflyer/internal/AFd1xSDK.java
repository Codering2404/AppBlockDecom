package com.appsflyer.internal;

import androidx.glance.color.Tq.KqqtdetwHMIO;
import com.appsflyer.AFLogger;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFd1xSDK implements Runnable {
    final ExecutorService AFInAppEventType;
    public Executor valueOf = Executors.newSingleThreadExecutor();
    private Timer afInfoLog = new Timer(true);
    public final List<AFd1vSDK> AFKeystoreWrapper = new CopyOnWriteArrayList();
    final Set<AFd1tSDK> values = new CopyOnWriteArraySet();
    final Set<AFd1tSDK> AFInAppEventParameterName = Collections.newSetFromMap(new ConcurrentHashMap());
    final NavigableSet<AFd1uSDK<?>> afRDLog = new ConcurrentSkipListSet();
    final NavigableSet<AFd1uSDK<?>> AFLogger = new ConcurrentSkipListSet();
    final List<AFd1uSDK<?>> afDebugLog = new ArrayList();
    final Set<AFd1uSDK<?>> afErrorLog = Collections.newSetFromMap(new ConcurrentHashMap());

    /* JADX INFO: renamed from: com.appsflyer.internal.AFd1xSDK$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public class AnonymousClass4 implements Runnable {
        private /* synthetic */ AFd1uSDK AFInAppEventType;

        public AnonymousClass4(AFd1uSDK aFd1uSDK) {
            this.AFInAppEventType = aFd1uSDK;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean zAdd;
            synchronized (AFd1xSDK.this.afRDLog) {
                try {
                    if (AFd1xSDK.this.afErrorLog.contains(this.AFInAppEventType)) {
                        StringBuilder sb = new StringBuilder("QUEUE: tried to add already running task: ");
                        sb.append(this.AFInAppEventType);
                        AFLogger.afDebugLog(sb.toString());
                        return;
                    }
                    if (!AFd1xSDK.this.afRDLog.contains(this.AFInAppEventType) && !AFd1xSDK.this.AFLogger.contains(this.AFInAppEventType)) {
                        AFd1xSDK aFd1xSDK = AFd1xSDK.this;
                        AFd1uSDK aFd1uSDK = this.AFInAppEventType;
                        for (AFd1tSDK aFd1tSDK : aFd1uSDK.values) {
                            if (aFd1xSDK.AFInAppEventParameterName.contains(aFd1tSDK)) {
                                aFd1uSDK.valueOf.add(aFd1tSDK);
                            }
                        }
                        if (AFd1xSDK.this.AFInAppEventType(this.AFInAppEventType)) {
                            zAdd = AFd1xSDK.this.afRDLog.add(this.AFInAppEventType);
                        } else {
                            zAdd = AFd1xSDK.this.AFLogger.add(this.AFInAppEventType);
                            if (zAdd) {
                                StringBuilder sb2 = new StringBuilder("QUEUE: new task was blocked: ");
                                sb2.append(this.AFInAppEventType);
                                AFLogger.afDebugLog(sb2.toString());
                                this.AFInAppEventType.AFInAppEventParameterName();
                            }
                        }
                        if (zAdd) {
                            AFd1xSDK aFd1xSDK2 = AFd1xSDK.this;
                            aFd1xSDK2.afRDLog.addAll(aFd1xSDK2.afDebugLog);
                            AFd1xSDK.this.afDebugLog.clear();
                        } else {
                            StringBuilder sb3 = new StringBuilder(KqqtdetwHMIO.PiOgnypmbLIjx);
                            sb3.append(this.AFInAppEventType);
                            AFLogger.afDebugLog(sb3.toString());
                        }
                        if (!zAdd) {
                            StringBuilder sb4 = new StringBuilder("QUEUE: tried to add already pending task: ");
                            sb4.append(this.AFInAppEventType);
                            AFLogger.afWarnLog(sb4.toString());
                            return;
                        }
                        AFd1xSDK.this.AFInAppEventParameterName.add(this.AFInAppEventType.AFInAppEventParameterName);
                        StringBuilder sb5 = new StringBuilder("QUEUE: new task added: ");
                        sb5.append(this.AFInAppEventType);
                        AFLogger.afDebugLog(sb5.toString());
                        for (AFd1vSDK aFd1vSDK : AFd1xSDK.this.AFKeystoreWrapper) {
                        }
                        AFd1xSDK aFd1xSDK3 = AFd1xSDK.this;
                        aFd1xSDK3.AFInAppEventType.submit(aFd1xSDK3);
                        AFd1xSDK aFd1xSDK4 = AFd1xSDK.this;
                        synchronized (aFd1xSDK4.afRDLog) {
                            try {
                                for (int size = (aFd1xSDK4.afRDLog.size() + aFd1xSDK4.AFLogger.size()) - 40; size > 0; size--) {
                                    boolean zIsEmpty = aFd1xSDK4.AFLogger.isEmpty();
                                    boolean zIsEmpty2 = aFd1xSDK4.afRDLog.isEmpty();
                                    if (zIsEmpty2 || zIsEmpty) {
                                        if (!zIsEmpty2) {
                                            aFd1xSDK4.valueOf(aFd1xSDK4.afRDLog);
                                        } else if (!zIsEmpty) {
                                            aFd1xSDK4.valueOf(aFd1xSDK4.AFLogger);
                                        }
                                    } else if (aFd1xSDK4.afRDLog.first().compareTo(aFd1xSDK4.AFLogger.first()) > 0) {
                                        aFd1xSDK4.valueOf(aFd1xSDK4.afRDLog);
                                    } else {
                                        aFd1xSDK4.valueOf(aFd1xSDK4.AFLogger);
                                    }
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        return;
                    }
                    StringBuilder sb6 = new StringBuilder("QUEUE: tried to add already scheduled task: ");
                    sb6.append(this.AFInAppEventType);
                    AFLogger.afDebugLog(sb6.toString());
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public AFd1xSDK(ExecutorService executorService) {
        this.AFInAppEventType = executorService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean AFInAppEventType(AFd1uSDK<?> aFd1uSDK) {
        return this.values.containsAll(aFd1uSDK.valueOf);
    }

    public static boolean AFKeystoreWrapper(AFd1uSDK<?> aFd1uSDK) {
        return ((aFd1uSDK instanceof AFd1eSDK) && aFd1uSDK.AFInAppEventParameterName == AFd1tSDK.ARS_VALIDATE) ? false : true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.afRDLog) {
            try {
                final AFd1uSDK<?> aFd1uSDKPollFirst = this.afRDLog.pollFirst();
                if (aFd1uSDKPollFirst == null) {
                    return;
                }
                this.afErrorLog.add(aFd1uSDKPollFirst);
                long jAFInAppEventType = aFd1uSDKPollFirst.AFInAppEventType();
                AFd1wSDK aFd1wSDK = new AFd1wSDK(Thread.currentThread());
                if (jAFInAppEventType > 0) {
                    this.afInfoLog.schedule(aFd1wSDK, jAFInAppEventType);
                }
                this.valueOf.execute(new Runnable() { // from class: com.appsflyer.internal.AFd1xSDK.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Iterator<AFd1vSDK> it = AFd1xSDK.this.AFKeystoreWrapper.iterator();
                        while (it.hasNext()) {
                            it.next().AFInAppEventType(aFd1uSDKPollFirst);
                        }
                    }
                });
                if (!this.afRDLog.isEmpty()) {
                    this.AFInAppEventType.submit(this);
                }
                try {
                    AFLogger.afDebugLog("QUEUE: starting task execution: ".concat(String.valueOf(aFd1uSDKPollFirst)));
                    final AFc1bSDK aFc1bSDKCall = aFd1uSDKPollFirst.call();
                    aFd1wSDK.cancel();
                    this.valueOf.execute(new Runnable() { // from class: com.appsflyer.internal.AFd1xSDK.5
                        @Override // java.lang.Runnable
                        public final void run() {
                            StringBuilder sb = new StringBuilder("QUEUE: execution finished for ");
                            sb.append(aFd1uSDKPollFirst);
                            sb.append(", result: ");
                            sb.append(aFc1bSDKCall);
                            AFLogger.afDebugLog(sb.toString());
                            AFd1xSDK.this.afErrorLog.remove(aFd1uSDKPollFirst);
                            Iterator<AFd1vSDK> it = AFd1xSDK.this.AFKeystoreWrapper.iterator();
                            while (it.hasNext()) {
                                it.next().AFKeystoreWrapper(aFd1uSDKPollFirst, aFc1bSDKCall);
                            }
                            if (aFc1bSDKCall == AFc1bSDK.SUCCESS) {
                                AFd1xSDK.this.values.add(aFd1uSDKPollFirst.AFInAppEventParameterName);
                                AFd1xSDK.AFInAppEventParameterName(AFd1xSDK.this);
                                return;
                            }
                            if (!aFd1uSDKPollFirst.valueOf()) {
                                AFd1xSDK.this.values.add(aFd1uSDKPollFirst.AFInAppEventParameterName);
                                AFd1xSDK.AFInAppEventParameterName(AFd1xSDK.this);
                            } else if (AFd1xSDK.AFKeystoreWrapper(aFd1uSDKPollFirst)) {
                                synchronized (AFd1xSDK.this.afRDLog) {
                                    try {
                                        AFd1xSDK.this.afDebugLog.add(aFd1uSDKPollFirst);
                                        for (AFd1vSDK aFd1vSDK : AFd1xSDK.this.AFKeystoreWrapper) {
                                        }
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                }
                            }
                        }
                    });
                } catch (InterruptedIOException | InterruptedException unused) {
                    AFLogger.afDebugLog("QUEUE: task was interrupted: ".concat(String.valueOf(aFd1uSDKPollFirst)));
                    final AFc1bSDK aFc1bSDK = AFc1bSDK.TIMEOUT;
                    aFd1uSDKPollFirst.AFKeystoreWrapper = aFc1bSDK;
                    this.valueOf.execute(new Runnable() { // from class: com.appsflyer.internal.AFd1xSDK.5
                        @Override // java.lang.Runnable
                        public final void run() {
                            StringBuilder sb = new StringBuilder("QUEUE: execution finished for ");
                            sb.append(aFd1uSDKPollFirst);
                            sb.append(", result: ");
                            sb.append(aFc1bSDK);
                            AFLogger.afDebugLog(sb.toString());
                            AFd1xSDK.this.afErrorLog.remove(aFd1uSDKPollFirst);
                            Iterator<AFd1vSDK> it = AFd1xSDK.this.AFKeystoreWrapper.iterator();
                            while (it.hasNext()) {
                                it.next().AFKeystoreWrapper(aFd1uSDKPollFirst, aFc1bSDK);
                            }
                            if (aFc1bSDK == AFc1bSDK.SUCCESS) {
                                AFd1xSDK.this.values.add(aFd1uSDKPollFirst.AFInAppEventParameterName);
                                AFd1xSDK.AFInAppEventParameterName(AFd1xSDK.this);
                                return;
                            }
                            if (!aFd1uSDKPollFirst.valueOf()) {
                                AFd1xSDK.this.values.add(aFd1uSDKPollFirst.AFInAppEventParameterName);
                                AFd1xSDK.AFInAppEventParameterName(AFd1xSDK.this);
                            } else if (AFd1xSDK.AFKeystoreWrapper(aFd1uSDKPollFirst)) {
                                synchronized (AFd1xSDK.this.afRDLog) {
                                    try {
                                        AFd1xSDK.this.afDebugLog.add(aFd1uSDKPollFirst);
                                        for (AFd1vSDK aFd1vSDK : AFd1xSDK.this.AFKeystoreWrapper) {
                                        }
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                }
                            }
                        }
                    });
                } catch (Throwable unused2) {
                    aFd1wSDK.cancel();
                    final AFc1bSDK aFc1bSDK2 = AFc1bSDK.FAILURE;
                    this.valueOf.execute(new Runnable() { // from class: com.appsflyer.internal.AFd1xSDK.5
                        @Override // java.lang.Runnable
                        public final void run() {
                            StringBuilder sb = new StringBuilder("QUEUE: execution finished for ");
                            sb.append(aFd1uSDKPollFirst);
                            sb.append(", result: ");
                            sb.append(aFc1bSDK2);
                            AFLogger.afDebugLog(sb.toString());
                            AFd1xSDK.this.afErrorLog.remove(aFd1uSDKPollFirst);
                            Iterator<AFd1vSDK> it = AFd1xSDK.this.AFKeystoreWrapper.iterator();
                            while (it.hasNext()) {
                                it.next().AFKeystoreWrapper(aFd1uSDKPollFirst, aFc1bSDK2);
                            }
                            if (aFc1bSDK2 == AFc1bSDK.SUCCESS) {
                                AFd1xSDK.this.values.add(aFd1uSDKPollFirst.AFInAppEventParameterName);
                                AFd1xSDK.AFInAppEventParameterName(AFd1xSDK.this);
                                return;
                            }
                            if (!aFd1uSDKPollFirst.valueOf()) {
                                AFd1xSDK.this.values.add(aFd1uSDKPollFirst.AFInAppEventParameterName);
                                AFd1xSDK.AFInAppEventParameterName(AFd1xSDK.this);
                            } else if (AFd1xSDK.AFKeystoreWrapper(aFd1uSDKPollFirst)) {
                                synchronized (AFd1xSDK.this.afRDLog) {
                                    try {
                                        AFd1xSDK.this.afDebugLog.add(aFd1uSDKPollFirst);
                                        for (AFd1vSDK aFd1vSDK : AFd1xSDK.this.AFKeystoreWrapper) {
                                        }
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                }
                            }
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    final void valueOf(NavigableSet<AFd1uSDK<?>> navigableSet) {
        AFd1uSDK<?> aFd1uSDKPollFirst = navigableSet.pollFirst();
        this.values.add(aFd1uSDKPollFirst.AFInAppEventParameterName);
        Iterator<AFd1vSDK> it = this.AFKeystoreWrapper.iterator();
        while (it.hasNext()) {
            it.next().valueOf(aFd1uSDKPollFirst);
        }
    }

    static /* synthetic */ void AFInAppEventParameterName(AFd1xSDK aFd1xSDK) {
        synchronized (aFd1xSDK.afRDLog) {
            try {
                Iterator<AFd1uSDK<?>> it = aFd1xSDK.AFLogger.iterator();
                boolean z2 = false;
                while (it.hasNext()) {
                    AFd1uSDK<?> next = it.next();
                    if (aFd1xSDK.AFInAppEventType(next)) {
                        it.remove();
                        aFd1xSDK.afRDLog.add(next);
                        z2 = true;
                    }
                }
                if (z2) {
                    aFd1xSDK.AFInAppEventType.submit(aFd1xSDK);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
