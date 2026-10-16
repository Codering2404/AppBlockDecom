package androidx.loader.content;

import android.content.Context;
import android.database.ContentObserver;
import androidx.core.util.DebugUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class Loader<D> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f40291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    OnLoadCompleteListener f40292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    OnLoadCanceledListener f40293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Context f40294d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f40295e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f40296f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f40297g = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f40298h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f40299i = false;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public final class ForceLoadContentObserver extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Loader f40300a;

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z2) {
            this.f40300a.o();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnLoadCanceledListener<D> {
        void a(Loader loader);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnLoadCompleteListener<D> {
        void a(Loader loader, Object obj);
    }

    public Loader(Context context) {
        this.f40294d = context.getApplicationContext();
    }

    public void a() {
        this.f40296f = true;
        m();
    }

    public boolean b() {
        return n();
    }

    public void c() {
        this.f40299i = false;
    }

    public String d(Object obj) {
        StringBuilder sb = new StringBuilder(64);
        DebugUtils.a(obj, sb);
        sb.append("}");
        return sb.toString();
    }

    public void e() {
        OnLoadCanceledListener onLoadCanceledListener = this.f40293c;
        if (onLoadCanceledListener != null) {
            onLoadCanceledListener.a(this);
        }
    }

    public void f(Object obj) {
        OnLoadCompleteListener onLoadCompleteListener = this.f40292b;
        if (onLoadCompleteListener != null) {
            onLoadCompleteListener.a(this, obj);
        }
    }

    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f40291a);
        printWriter.print(" mListener=");
        printWriter.println(this.f40292b);
        if (this.f40295e || this.f40298h || this.f40299i) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f40295e);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f40298h);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f40299i);
        }
        if (this.f40296f || this.f40297g) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f40296f);
            printWriter.print(" mReset=");
            printWriter.println(this.f40297g);
        }
    }

    public void h() {
        p();
    }

    public Context i() {
        return this.f40294d;
    }

    public boolean j() {
        return this.f40296f;
    }

    public boolean k() {
        return this.f40297g;
    }

    public boolean l() {
        return this.f40295e;
    }

    protected boolean n() {
        return false;
    }

    public void o() {
        if (this.f40295e) {
            h();
        } else {
            this.f40298h = true;
        }
    }

    public void t(int i3, OnLoadCompleteListener onLoadCompleteListener) {
        if (this.f40292b != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f40292b = onLoadCompleteListener;
        this.f40291a = i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        DebugUtils.a(this, sb);
        sb.append(" id=");
        sb.append(this.f40291a);
        sb.append("}");
        return sb.toString();
    }

    public void u() {
        q();
        this.f40297g = true;
        this.f40295e = false;
        this.f40296f = false;
        this.f40298h = false;
        this.f40299i = false;
    }

    public void v() {
        if (this.f40299i) {
            o();
        }
    }

    public final void w() {
        this.f40295e = true;
        this.f40297g = false;
        this.f40296f = false;
        r();
    }

    public void x() {
        this.f40295e = false;
        s();
    }

    public boolean y() {
        boolean z2 = this.f40298h;
        this.f40298h = false;
        this.f40299i |= z2;
        return z2;
    }

    public void z(OnLoadCompleteListener onLoadCompleteListener) {
        OnLoadCompleteListener onLoadCompleteListener2 = this.f40292b;
        if (onLoadCompleteListener2 == null) {
            throw new IllegalStateException("No listener register");
        }
        if (onLoadCompleteListener2 != onLoadCompleteListener) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.f40292b = null;
    }

    protected void m() {
    }

    protected void p() {
    }

    protected void q() {
    }

    protected void r() {
    }

    protected void s() {
    }
}
