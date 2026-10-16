package androidx.browser.browseractions;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.content.FileProvider;
import androidx.core.util.AtomicFile;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class BrowserServiceFileProvider extends FileProvider {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static Object f2576i = new Object();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class FileCleanupTask extends AsyncTask<Void, Void, Void> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f2580b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final long f2581c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final long f2582d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f2583a;

        static {
            TimeUnit timeUnit = TimeUnit.DAYS;
            f2580b = timeUnit.toMillis(7L);
            f2581c = timeUnit.toMillis(7L);
            f2582d = timeUnit.toMillis(1L);
        }

        FileCleanupTask(Context context) {
            this.f2583a = context.getApplicationContext();
        }

        private static boolean b(File file) {
            return file.getName().endsWith("..png");
        }

        private static boolean c(SharedPreferences sharedPreferences) {
            return System.currentTimeMillis() > sharedPreferences.getLong("last_cleanup_time", System.currentTimeMillis()) + f2581c;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            SharedPreferences sharedPreferences = this.f2583a.getSharedPreferences(this.f2583a.getPackageName() + ".image_provider", 0);
            if (!c(sharedPreferences)) {
                return null;
            }
            synchronized (BrowserServiceFileProvider.f2576i) {
                try {
                    File file = new File(this.f2583a.getFilesDir(), "image_provider");
                    if (!file.exists()) {
                        return null;
                    }
                    File[] fileArrListFiles = file.listFiles();
                    long jCurrentTimeMillis = System.currentTimeMillis() - f2580b;
                    boolean z2 = true;
                    for (File file2 : fileArrListFiles) {
                        if (b(file2) && file2.lastModified() < jCurrentTimeMillis && !file2.delete()) {
                            Log.e("BrowserServiceFP", "Fail to delete image: " + file2.getAbsoluteFile());
                            z2 = false;
                        }
                    }
                    long jCurrentTimeMillis2 = z2 ? System.currentTimeMillis() : (System.currentTimeMillis() - f2581c) + f2582d;
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    editorEdit.putLong("last_cleanup_time", jCurrentTimeMillis2);
                    editorEdit.apply();
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class FileSaveTask extends AsyncTask<String, Void, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f2584a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f2585b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Bitmap f2586c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Uri f2587d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final ResolvableFuture f2588e;

        private void c(File file) {
            FileOutputStream fileOutputStreamD;
            AtomicFile atomicFile = new AtomicFile(file);
            try {
                fileOutputStreamD = atomicFile.d();
            } catch (IOException e3) {
                e = e3;
                fileOutputStreamD = null;
            }
            try {
                this.f2586c.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStreamD);
                fileOutputStreamD.close();
                atomicFile.b(fileOutputStreamD);
                this.f2588e.o(this.f2587d);
            } catch (IOException e4) {
                e = e4;
                atomicFile.a(fileOutputStreamD);
                this.f2588e.p(e);
            }
        }

        private void d() {
            File file = new File(this.f2584a.getFilesDir(), "image_provider");
            synchronized (BrowserServiceFileProvider.f2576i) {
                try {
                    if (!file.exists() && !file.mkdir()) {
                        this.f2588e.p(new IOException("Could not create file directory."));
                        return;
                    }
                    File file2 = new File(file, this.f2585b + ".png");
                    if (file2.exists()) {
                        this.f2588e.o(this.f2587d);
                    } else {
                        c(file2);
                    }
                    file2.setLastModified(System.currentTimeMillis());
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(String... strArr) {
            d();
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r3) {
            new FileCleanupTask(this.f2584a).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
        }
    }

    public static ListenableFuture l(final ContentResolver contentResolver, final Uri uri) {
        final ResolvableFuture resolvableFutureS = ResolvableFuture.s();
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() { // from class: androidx.browser.browseractions.BrowserServiceFileProvider.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(uri, "r");
                    if (parcelFileDescriptorOpenFileDescriptor == null) {
                        resolvableFutureS.p(new FileNotFoundException());
                        return;
                    }
                    Bitmap bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                    parcelFileDescriptorOpenFileDescriptor.close();
                    if (bitmapDecodeFileDescriptor == null) {
                        resolvableFutureS.p(new IOException("File could not be decoded."));
                    } else {
                        resolvableFutureS.o(bitmapDecodeFileDescriptor);
                    }
                } catch (IOException e3) {
                    resolvableFutureS.p(e3);
                }
            }
        });
        return resolvableFutureS;
    }
}
