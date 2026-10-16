package com.google.firebase.messaging;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ImageDownload implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final URL f89410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Future f89411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Task f89412c;

    private ImageDownload(URL url) {
        this.f89410a = url;
    }

    public static /* synthetic */ void a(ImageDownload imageDownload, TaskCompletionSource taskCompletionSource) {
        imageDownload.getClass();
        try {
            taskCompletionSource.setResult(imageDownload.b());
        } catch (Exception e3) {
            taskCompletionSource.setException(e3);
        }
    }

    private byte[] c() throws IOException {
        URLConnection uRLConnectionOpenConnection = this.f89410a.openConnection();
        if (uRLConnectionOpenConnection.getContentLength() > 1048576) {
            throw new IOException("Content-Length exceeds max size of 1048576");
        }
        InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
        try {
            byte[] bArrD = ByteStreams.d(ByteStreams.b(inputStream, 1048577L));
            if (inputStream != null) {
                inputStream.close();
            }
            if (Log.isLoggable("FirebaseMessaging", 2)) {
                Log.v("FirebaseMessaging", "Downloaded " + bArrD.length + " bytes from " + this.f89410a);
            }
            if (bArrD.length <= 1048576) {
                return bArrD;
            }
            throw new IOException("Image exceeds max size of 1048576");
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static ImageDownload f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new ImageDownload(new URL(str));
        } catch (MalformedURLException unused) {
            Log.w("FirebaseMessaging", "Not downloading image, bad URL: " + str);
            return null;
        }
    }

    public Bitmap b() throws IOException {
        if (Log.isLoggable("FirebaseMessaging", 4)) {
            Log.i("FirebaseMessaging", "Starting download of: " + this.f89410a);
        }
        byte[] bArrC = c();
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrC, 0, bArrC.length);
        if (bitmapDecodeByteArray == null) {
            throw new IOException("Failed to decode image: " + this.f89410a);
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Successfully downloaded image: " + this.f89410a);
        }
        return bitmapDecodeByteArray;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f89411b.cancel(true);
    }

    public Task i() {
        return (Task) Preconditions.m(this.f89412c);
    }

    public void j(ExecutorService executorService) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f89411b = executorService.submit(new Runnable() { // from class: com.google.firebase.messaging.t
            @Override // java.lang.Runnable
            public final void run() {
                ImageDownload.a(this.f89600a, taskCompletionSource);
            }
        });
        this.f89412c = taskCompletionSource.getTask();
    }
}
