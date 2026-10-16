package com.facebook.stetho.server;

import android.net.LocalServerSocket;
import android.net.LocalSocket;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.Util;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.BindException;
import java.net.SocketException;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nonnull;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class LocalSocketServer {
    private static final int MAX_BIND_RETRIES = 2;
    private static final int TIME_BETWEEN_BIND_RETRIES_MS = 1000;
    private static final String WORKER_THREAD_NAME_PREFIX = "StethoWorker";
    private final String mAddress;
    private final String mFriendlyName;
    private Thread mListenerThread;
    private LocalServerSocket mServerSocket;
    private final SocketHandler mSocketHandler;
    private boolean mStopped;
    private final AtomicInteger mThreadId = new AtomicInteger();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class WorkerThread extends Thread {
        private final LocalSocket mSocket;
        private final SocketHandler mSocketHandler;

        public WorkerThread(LocalSocket localSocket, SocketHandler socketHandler) {
            this.mSocket = localSocket;
            this.mSocketHandler = socketHandler;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                try {
                    try {
                        this.mSocketHandler.onAccepted(this.mSocket);
                        this.mSocket.close();
                    } catch (IOException e3) {
                        LogUtil.w("I/O error: %s", e3);
                        this.mSocket.close();
                    }
                } catch (IOException unused) {
                }
            } catch (Throwable th) {
                try {
                    this.mSocket.close();
                } catch (IOException unused2) {
                }
                throw th;
            }
        }
    }

    public LocalSocketServer(String str, String str2, SocketHandler socketHandler) {
        this.mFriendlyName = (String) Util.throwIfNull(str);
        this.mAddress = (String) Util.throwIfNull(str2);
        this.mSocketHandler = socketHandler;
    }

    @Nonnull
    private static LocalServerSocket bindToSocket(String str) throws IOException {
        int i3 = 2;
        BindException bindException = null;
        while (true) {
            try {
                if (LogUtil.isLoggable(3)) {
                    LogUtil.d("Trying to bind to @" + str);
                }
                return new LocalServerSocket(str);
            } catch (BindException e3) {
                LogUtil.w(e3, "Binding error, sleep 1000 ms...");
                if (bindException == null) {
                    bindException = e3;
                }
                Util.sleepUninterruptibly(1000L);
                int i4 = i3 - 1;
                if (i3 <= 0) {
                    throw bindException;
                }
                i3 = i4;
            }
        }
    }

    private void listenOnAddress(String str) throws IOException {
        this.mServerSocket = bindToSocket(str);
        LogUtil.i("Listening on @" + str);
        while (!Thread.interrupted()) {
            try {
                WorkerThread workerThread = new WorkerThread(this.mServerSocket.accept(), this.mSocketHandler);
                workerThread.setName("StethoWorker-" + this.mFriendlyName + "-" + this.mThreadId.incrementAndGet());
                workerThread.setDaemon(true);
                workerThread.start();
            } catch (InterruptedIOException unused) {
            } catch (SocketException e3) {
                if (Thread.interrupted()) {
                    LogUtil.i("Server shutdown on @" + str);
                }
                LogUtil.w(e3, "I/O error");
            } catch (IOException e4) {
                LogUtil.w(e4, "I/O error initialising connection thread");
            }
        }
        LogUtil.i("Server shutdown on @" + str);
    }

    public String getName() {
        return this.mFriendlyName;
    }

    public void run() throws IOException {
        synchronized (this) {
            try {
                if (this.mStopped) {
                    return;
                }
                this.mListenerThread = Thread.currentThread();
                listenOnAddress(this.mAddress);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void stop() {
        synchronized (this) {
            try {
                this.mStopped = true;
                Thread thread = this.mListenerThread;
                if (thread == null) {
                    return;
                }
                thread.interrupt();
                try {
                    LocalServerSocket localServerSocket = this.mServerSocket;
                    if (localServerSocket != null) {
                        localServerSocket.close();
                    }
                } catch (IOException unused) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
