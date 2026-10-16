package com.google.android.material.textfield;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class PasswordToggleEndIconDelegate extends EndIconDelegate {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f82315e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private EditText f82316f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final View.OnClickListener f82317g;

    PasswordToggleEndIconDelegate(EndCompoundLayout endCompoundLayout, int i3) {
        super(endCompoundLayout);
        this.f82315e = R.drawable.f79606a;
        this.f82317g = new View.OnClickListener() { // from class: com.google.android.material.textfield.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PasswordToggleEndIconDelegate.v(this.f82401a, view);
            }
        };
        if (i3 != 0) {
            this.f82315e = i3;
        }
    }

    public static /* synthetic */ void v(PasswordToggleEndIconDelegate passwordToggleEndIconDelegate, View view) {
        EditText editText = passwordToggleEndIconDelegate.f82316f;
        if (editText == null) {
            return;
        }
        int selectionEnd = editText.getSelectionEnd();
        if (passwordToggleEndIconDelegate.w()) {
            passwordToggleEndIconDelegate.f82316f.setTransformationMethod(null);
        } else {
            passwordToggleEndIconDelegate.f82316f.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        if (selectionEnd >= 0) {
            passwordToggleEndIconDelegate.f82316f.setSelection(selectionEnd);
        }
        passwordToggleEndIconDelegate.r();
    }

    private boolean w() {
        EditText editText = this.f82316f;
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    private static boolean x(EditText editText) {
        if (editText != null) {
            return editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224;
        }
        return false;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void b(CharSequence charSequence, int i3, int i4, int i5) {
        r();
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    int c() {
        return R.string.f79704d0;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    int d() {
        return this.f82315e;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    View.OnClickListener f() {
        return this.f82317g;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    boolean l() {
        return true;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    boolean m() {
        return !w();
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void n(EditText editText) {
        this.f82316f = editText;
        r();
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void s() {
        if (x(this.f82316f)) {
            this.f82316f.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void u() {
        EditText editText = this.f82316f;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
