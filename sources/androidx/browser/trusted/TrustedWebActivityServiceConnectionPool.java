package androidx.browser.trusted;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public final class TrustedWebActivityServiceConnectionPool {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class BindToServiceAsyncTask extends AsyncTask<Void, Void, Exception> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f2719a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Intent f2720b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ConnectionHolder f2721c;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Exception doInBackground(Void... voidArr) {
            try {
                if (this.f2719a.bindService(this.f2720b, this.f2721c, 4097)) {
                    return null;
                }
                this.f2719a.unbindService(this.f2721c);
                return new IllegalStateException("Could not bind to the service");
            } catch (SecurityException e3) {
                Log.w("TWAConnectionPool", "SecurityException while binding.", e3);
                return e3;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Exception exc) {
            if (exc != null) {
                this.f2721c.a(exc);
            }
        }
    }
}
