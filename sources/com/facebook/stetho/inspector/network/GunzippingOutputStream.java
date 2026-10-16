package com.facebook.stetho.inspector.network;

import com.facebook.stetho.common.ExceptionUtil;
import com.facebook.stetho.common.Util;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.zip.GZIPInputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class GunzippingOutputStream extends FilterOutputStream {
    private static final ExecutorService sExecutor = Executors.newCachedThreadPool();
    private final Future<Void> mCopyFuture;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class GunzippingCallable implements Callable<Void> {
        private final InputStream mIn;
        private final OutputStream mOut;

        public GunzippingCallable(InputStream inputStream, OutputStream outputStream) {
            this.mIn = inputStream;
            this.mOut = outputStream;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws IOException {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(this.mIn);
            try {
                Util.copy(gZIPInputStream, this.mOut, new byte[1024]);
                gZIPInputStream.close();
                this.mOut.close();
                return null;
            } catch (Throwable th) {
                gZIPInputStream.close();
                this.mOut.close();
                throw th;
            }
        }
    }

    private GunzippingOutputStream(OutputStream outputStream, Future<Void> future) throws IOException {
        super(outputStream);
        this.mCopyFuture = future;
    }

    public static GunzippingOutputStream create(OutputStream outputStream) throws IOException {
        PipedInputStream pipedInputStream = new PipedInputStream();
        return new GunzippingOutputStream(new PipedOutputStream(pipedInputStream), sExecutor.submit(new GunzippingCallable(pipedInputStream, outputStream)));
    }

    private static <T> T getAndRethrow(Future<T> future) throws Throwable {
        while (true) {
            try {
                return future.get();
            } catch (InterruptedException unused) {
            } catch (ExecutionException e3) {
                Throwable cause = e3.getCause();
                ExceptionUtil.propagateIfInstanceOf(cause, IOException.class);
                ExceptionUtil.propagate(cause);
            }
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        try {
            super.close();
            getAndRethrow(this.mCopyFuture);
        } catch (Throwable th) {
            try {
                getAndRethrow(this.mCopyFuture);
            } catch (IOException unused) {
            }
            throw th;
        }
    }
}
