package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class FragmentHostCallback<E> extends FragmentContainer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Activity f37205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f37206b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f37207c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f37208d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final FragmentManager f37209f;

    FragmentHostCallback(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, new Handler(), 0);
    }

    @Override // androidx.fragment.app.FragmentContainer
    public View c(int i3) {
        return null;
    }

    @Override // androidx.fragment.app.FragmentContainer
    public boolean d() {
        return true;
    }

    Activity e() {
        return this.f37205a;
    }

    Context f() {
        return this.f37206b;
    }

    public Handler g() {
        return this.f37207c;
    }

    public abstract Object i();

    public LayoutInflater j() {
        return LayoutInflater.from(this.f37206b);
    }

    public boolean l(String str) {
        return false;
    }

    public void m(Fragment fragment, Intent intent, int i3, Bundle bundle) {
        if (i3 != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        ContextCompat.startActivity(this.f37206b, intent, bundle);
    }

    public void n(Fragment fragment, IntentSender intentSender, int i3, Intent intent, int i4, int i5, int i6, Bundle bundle) {
        if (i3 != -1) {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        ActivityCompat.j(this.f37205a, intentSender, i3, intent, i4, i5, i6, bundle);
    }

    FragmentHostCallback(Activity activity, Context context, Handler handler, int i3) {
        this.f37209f = new FragmentManagerImpl();
        this.f37205a = activity;
        this.f37206b = (Context) Preconditions.i(context, "context == null");
        this.f37207c = (Handler) Preconditions.i(handler, "handler == null");
        this.f37208d = i3;
    }

    public void o() {
    }

    public void k(Fragment fragment, String[] strArr, int i3) {
    }

    public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }
}
