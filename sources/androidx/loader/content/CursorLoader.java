package androidx.loader.content;

import android.database.Cursor;
import android.net.Uri;
import androidx.core.content.ContentResolverCompat;
import androidx.core.os.CancellationSignal;
import androidx.core.os.OperationCanceledException;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class CursorLoader extends AsyncTaskLoader<Cursor> {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final Loader.ForceLoadContentObserver f40283p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    Uri f40284q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    String[] f40285r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    String f40286s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    String[] f40287t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    String f40288u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    Cursor f40289v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    CancellationSignal f40290w;

    @Override // androidx.loader.content.AsyncTaskLoader
    public void A() {
        super.A();
        synchronized (this) {
            try {
                CancellationSignal cancellationSignal = this.f40290w;
                if (cancellationSignal != null) {
                    cancellationSignal.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.loader.content.Loader
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public void f(Cursor cursor) {
        if (k()) {
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        Cursor cursor2 = this.f40289v;
        this.f40289v = cursor;
        if (l()) {
            super.f(cursor);
        }
        if (cursor2 == null || cursor2 == cursor || cursor2.isClosed()) {
            return;
        }
        cursor2.close();
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public Cursor F() {
        synchronized (this) {
            if (E()) {
                throw new OperationCanceledException();
            }
            this.f40290w = new CancellationSignal();
        }
        try {
            Cursor cursorB = ContentResolverCompat.b(i().getContentResolver(), this.f40284q, this.f40285r, this.f40286s, this.f40287t, this.f40288u, this.f40290w);
            if (cursorB != null) {
                try {
                    cursorB.getCount();
                    cursorB.registerContentObserver(this.f40283p);
                } catch (RuntimeException e3) {
                    cursorB.close();
                    throw e3;
                }
            }
            synchronized (this) {
                this.f40290w = null;
            }
            return cursorB;
        } catch (Throwable th) {
            synchronized (this) {
                this.f40290w = null;
                throw th;
            }
        }
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public void G(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return;
        }
        cursor.close();
    }

    @Override // androidx.loader.content.AsyncTaskLoader, androidx.loader.content.Loader
    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.g(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("mUri=");
        printWriter.println(this.f40284q);
        printWriter.print(str);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.f40285r));
        printWriter.print(str);
        printWriter.print("mSelection=");
        printWriter.println(this.f40286s);
        printWriter.print(str);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.f40287t));
        printWriter.print(str);
        printWriter.print("mSortOrder=");
        printWriter.println(this.f40288u);
        printWriter.print(str);
        printWriter.print("mCursor=");
        printWriter.println(this.f40289v);
        printWriter.print(str);
        printWriter.print("mContentChanged=");
        printWriter.println(this.f40298h);
    }

    @Override // androidx.loader.content.Loader
    protected void q() {
        super.q();
        s();
        Cursor cursor = this.f40289v;
        if (cursor != null && !cursor.isClosed()) {
            this.f40289v.close();
        }
        this.f40289v = null;
    }

    @Override // androidx.loader.content.Loader
    protected void r() {
        Cursor cursor = this.f40289v;
        if (cursor != null) {
            f(cursor);
        }
        if (y() || this.f40289v == null) {
            h();
        }
    }

    @Override // androidx.loader.content.Loader
    protected void s() {
        b();
    }
}
