package com.facebook.stetho.common;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Util {
    public static void awaitUninterruptibly(CountDownLatch countDownLatch) {
        while (true) {
            try {
                countDownLatch.await();
                return;
            } catch (InterruptedException unused) {
            }
        }
    }

    public static void close(Closeable closeable, boolean z2) throws IOException {
        if (closeable != null) {
            if (!z2) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (IOException e3) {
                LogUtil.e(e3, "Hiding IOException because another is pending");
            }
        }
    }

    public static void copy(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        while (true) {
            int i3 = inputStream.read(bArr);
            if (i3 == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i3);
            }
        }
    }

    public static <T> T getUninterruptibly(Future<T> future, long j3, TimeUnit timeUnit) throws ExecutionException, TimeoutException {
        long millis = timeUnit.toMillis(j3);
        while (true) {
            try {
                return future.get(millis, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
                millis -= System.currentTimeMillis() - System.currentTimeMillis();
            }
        }
    }

    public static void joinUninterruptibly(Thread thread) {
        while (true) {
            try {
                thread.join();
                return;
            } catch (InterruptedException unused) {
            }
        }
    }

    public static String readAsUTF8(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copy(inputStream, byteArrayOutputStream, new byte[1024]);
        return byteArrayOutputStream.toString(Utf8Charset.NAME);
    }

    public static void sleepUninterruptibly(long j3) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        do {
            try {
                Thread.sleep(j3);
                return;
            } catch (InterruptedException unused) {
                j3 -= System.currentTimeMillis() - jCurrentTimeMillis;
            }
        } while (j3 > 0);
    }

    public static void throwIf(boolean z2) {
        if (z2) {
            throw new IllegalStateException();
        }
    }

    public static void throwIfNot(boolean z2) {
        if (!z2) {
            throw new IllegalStateException();
        }
    }

    public static void throwIfNotNull(Object obj) {
        if (obj != null) {
            throw new IllegalStateException();
        }
    }

    public static <T> T throwIfNull(T t2) {
        t2.getClass();
        return t2;
    }

    public static void throwIfNot(boolean z2, String str, Object... objArr) {
        if (!z2) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    public static <T1, T2> void throwIfNull(T1 t12, T2 t2) {
        throwIfNull(t12);
        throwIfNull(t2);
    }

    public static <T1, T2, T3> void throwIfNull(T1 t12, T2 t2, T3 t3) {
        throwIfNull(t12);
        throwIfNull(t2);
        throwIfNull(t3);
    }

    public static <T> T getUninterruptibly(Future<T> future) throws ExecutionException {
        while (true) {
            try {
                return future.get();
            } catch (InterruptedException unused) {
            }
        }
    }
}
