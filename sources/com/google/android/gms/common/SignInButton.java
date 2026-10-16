package com.google.android.gms.common;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zaaa;
import com.google.android.gms.common.internal.zaz;
import com.google.android.gms.dynamic.RemoteCreator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class SignInButton extends FrameLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f71468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f71469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f71470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View.OnClickListener f71471d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ButtonSize {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ColorScheme {
    }

    private final void b(Context context) {
        View view = this.f71470c;
        if (view != null) {
            removeView(view);
        }
        try {
            this.f71470c = zaz.a(context, this.f71468a, this.f71469b);
        } catch (RemoteCreator.RemoteCreatorException unused) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            int i3 = this.f71468a;
            int i4 = this.f71469b;
            zaaa zaaaVar = new zaaa(context, null);
            zaaaVar.a(context.getResources(), i3, i4);
            this.f71470c = zaaaVar;
        }
        addView(this.f71470c);
        this.f71470c.setEnabled(isEnabled());
        this.f71470c.setOnClickListener(this);
    }

    public void a(int i3, int i4) {
        this.f71468a = i3;
        this.f71469b = i4;
        b(getContext());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener = this.f71471d;
        if (onClickListener == null || view != this.f71470c) {
            return;
        }
        onClickListener.onClick(this);
    }

    public void setColorScheme(int i3) {
        a(this.f71468a, i3);
    }

    @Override // android.view.View
    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        this.f71470c.setEnabled(z2);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f71471d = onClickListener;
        View view = this.f71470c;
        if (view != null) {
            view.setOnClickListener(this);
        }
    }

    @Deprecated
    public void setScopes(Scope[] scopeArr) {
        a(this.f71468a, this.f71469b);
    }

    public void setSize(int i3) {
        a(i3, this.f71469b);
    }
}
