package com.google.android.material.timepicker;

import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class TimePickerTextInputKeyController implements TextView.OnEditorActionListener, View.OnKeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ChipTextInputComboView f82497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ChipTextInputComboView f82498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TimeModel f82499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f82500d = false;

    TimePickerTextInputKeyController(ChipTextInputComboView chipTextInputComboView, ChipTextInputComboView chipTextInputComboView2, TimeModel timeModel) {
        this.f82497a = chipTextInputComboView;
        this.f82498b = chipTextInputComboView2;
        this.f82499c = timeModel;
    }

    private void b(EditText editText) {
        if (editText.getSelectionStart() == 0 && editText.length() == 2) {
            editText.getText().clear();
        }
    }

    private void c(int i3) {
        this.f82498b.setChecked(i3 == 12);
        this.f82497a.setChecked(i3 == 10);
        this.f82499c.f82485g = i3;
    }

    private boolean d(int i3, KeyEvent keyEvent, EditText editText) {
        Editable text = editText.getText();
        if (text == null) {
            return false;
        }
        if (i3 >= 7 && i3 <= 16 && keyEvent.getAction() == 1 && editText.getSelectionStart() == 2 && text.length() == 2) {
            c(12);
            return true;
        }
        b(editText);
        return false;
    }

    private boolean e(int i3, KeyEvent keyEvent, EditText editText) {
        if (i3 == 67 && keyEvent.getAction() == 0 && TextUtils.isEmpty(editText.getText())) {
            c(10);
            return true;
        }
        b(editText);
        return false;
    }

    public void a() {
        TextInputLayout textInputLayoutE = this.f82497a.e();
        TextInputLayout textInputLayoutE2 = this.f82498b.e();
        EditText editText = textInputLayoutE.getEditText();
        EditText editText2 = textInputLayoutE2.getEditText();
        editText.setImeOptions(268435461);
        editText2.setImeOptions(268435462);
        editText.setOnEditorActionListener(this);
        editText.setOnKeyListener(this);
        editText2.setOnKeyListener(this);
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
        boolean z2 = i3 == 5;
        if (z2) {
            c(12);
        }
        return z2;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i3, KeyEvent keyEvent) {
        if (this.f82500d) {
            return false;
        }
        this.f82500d = true;
        EditText editText = (EditText) view;
        boolean zE = this.f82499c.f82485g == 12 ? e(i3, keyEvent, editText) : d(i3, keyEvent, editText);
        this.f82500d = false;
        return zE;
    }
}
