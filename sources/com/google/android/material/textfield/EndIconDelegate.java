package com.google.android.material.textfield;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class EndIconDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final TextInputLayout f82267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final EndCompoundLayout f82268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Context f82269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final CheckableImageButton f82270d;

    EndIconDelegate(EndCompoundLayout endCompoundLayout) {
        this.f82267a = endCompoundLayout.f82237a;
        this.f82268b = endCompoundLayout;
        this.f82269c = endCompoundLayout.getContext();
        this.f82270d = endCompoundLayout.r();
    }

    int c() {
        return 0;
    }

    int d() {
        return 0;
    }

    View.OnFocusChangeListener e() {
        return null;
    }

    View.OnClickListener f() {
        return null;
    }

    View.OnFocusChangeListener g() {
        return null;
    }

    AccessibilityManagerCompat.TouchExplorationStateChangeListener h() {
        return null;
    }

    boolean i(int i3) {
        return true;
    }

    boolean j() {
        return false;
    }

    boolean k() {
        return false;
    }

    boolean l() {
        return false;
    }

    boolean m() {
        return false;
    }

    final void r() {
        this.f82268b.L(false);
    }

    boolean t() {
        return false;
    }

    void s() {
    }

    void u() {
    }

    void a(Editable editable) {
    }

    void n(EditText editText) {
    }

    void q(boolean z2) {
    }

    void o(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    void p(View view, AccessibilityEvent accessibilityEvent) {
    }

    void b(CharSequence charSequence, int i3, int i4, int i5) {
    }
}
