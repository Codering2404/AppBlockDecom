package com.google.android.gms.dynamic;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.dynamic.LifecycleDelegate;
import java.util.LinkedList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class DeferredLifecycleHelper<T extends LifecycleDelegate> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LifecycleDelegate f72372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Bundle f72373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LinkedList f72374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final OnDelegateCreatedListener f72375d = new zaa(this);

    public static void o(FrameLayout frameLayout) {
        GoogleApiAvailability googleApiAvailabilityQ = GoogleApiAvailability.q();
        Context context = frameLayout.getContext();
        int i3 = googleApiAvailabilityQ.i(context);
        String strC = com.google.android.gms.common.internal.zac.c(context, i3);
        String strB = com.google.android.gms.common.internal.zac.b(context, i3);
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        TextView textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        textView.setText(strC);
        linearLayout.addView(textView);
        Intent intentD = googleApiAvailabilityQ.d(context, i3, null);
        if (intentD != null) {
            Button button = new Button(context);
            button.setId(R.id.button1);
            button.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            button.setText(strB);
            linearLayout.addView(button);
            button.setOnClickListener(new zae(context, intentD));
        }
    }

    static /* bridge */ /* synthetic */ LifecycleDelegate p(DeferredLifecycleHelper deferredLifecycleHelper) {
        return deferredLifecycleHelper.f72372a;
    }

    private final void t(int i3) {
        while (!this.f72374c.isEmpty() && ((zah) this.f72374c.getLast()).a() >= i3) {
            this.f72374c.removeLast();
        }
    }

    private final void u(Bundle bundle, zah zahVar) {
        LifecycleDelegate lifecycleDelegate = this.f72372a;
        if (lifecycleDelegate != null) {
            zahVar.b(lifecycleDelegate);
            return;
        }
        if (this.f72374c == null) {
            this.f72374c = new LinkedList();
        }
        this.f72374c.add(zahVar);
        if (bundle != null) {
            Bundle bundle2 = this.f72373b;
            if (bundle2 == null) {
                this.f72373b = (Bundle) bundle.clone();
            } else {
                bundle2.putAll(bundle);
            }
        }
        a(this.f72375d);
    }

    protected abstract void a(OnDelegateCreatedListener onDelegateCreatedListener);

    public LifecycleDelegate b() {
        return this.f72372a;
    }

    protected void c(FrameLayout frameLayout) {
        o(frameLayout);
    }

    public void d(Bundle bundle) {
        u(bundle, new zac(this, bundle));
    }

    public View e(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        u(bundle, new zad(this, frameLayout, layoutInflater, viewGroup, bundle));
        if (this.f72372a == null) {
            c(frameLayout);
        }
        return frameLayout;
    }

    public void f() {
        LifecycleDelegate lifecycleDelegate = this.f72372a;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.onDestroy();
        } else {
            t(1);
        }
    }

    public void g() {
        LifecycleDelegate lifecycleDelegate = this.f72372a;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.d();
        } else {
            t(2);
        }
    }

    public void h(Activity activity, Bundle bundle, Bundle bundle2) {
        u(bundle2, new zab(this, activity, bundle, bundle2));
    }

    public void i() {
        LifecycleDelegate lifecycleDelegate = this.f72372a;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.onLowMemory();
        }
    }

    public void j() {
        LifecycleDelegate lifecycleDelegate = this.f72372a;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.onPause();
        } else {
            t(5);
        }
    }

    public void k() {
        u(null, new zag(this));
    }

    public void l(Bundle bundle) {
        LifecycleDelegate lifecycleDelegate = this.f72372a;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.onSaveInstanceState(bundle);
            return;
        }
        Bundle bundle2 = this.f72373b;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
    }

    public void m() {
        u(null, new zaf(this));
    }

    public void n() {
        LifecycleDelegate lifecycleDelegate = this.f72372a;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.onStop();
        } else {
            t(4);
        }
    }
}
