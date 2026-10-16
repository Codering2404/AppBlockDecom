package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.timepicker.TimePickerView;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class TimePickerTextInputPresenter implements TimePickerView.OnSelectionChange, TimePickerPresenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinearLayout f82501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TimeModel f82502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TextWatcher f82503c = new TextWatcherAdapter() { // from class: com.google.android.material.timepicker.TimePickerTextInputPresenter.1
        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    TimePickerTextInputPresenter.this.f82502b.j(0);
                } else {
                    TimePickerTextInputPresenter.this.f82502b.j(Integer.parseInt(editable.toString()));
                }
            } catch (NumberFormatException unused) {
            }
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TextWatcher f82504d = new TextWatcherAdapter() { // from class: com.google.android.material.timepicker.TimePickerTextInputPresenter.2
        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    TimePickerTextInputPresenter.this.f82502b.i(0);
                } else {
                    TimePickerTextInputPresenter.this.f82502b.i(Integer.parseInt(editable.toString()));
                }
            } catch (NumberFormatException unused) {
            }
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ChipTextInputComboView f82505f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ChipTextInputComboView f82506g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final TimePickerTextInputKeyController f82507h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final EditText f82508i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final EditText f82509j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private MaterialButtonToggleGroup f82510k;

    public TimePickerTextInputPresenter(LinearLayout linearLayout, final TimeModel timeModel) {
        this.f82501a = linearLayout;
        this.f82502b = timeModel;
        Resources resources = linearLayout.getResources();
        ChipTextInputComboView chipTextInputComboView = (ChipTextInputComboView) linearLayout.findViewById(R.id.f79663w);
        this.f82505f = chipTextInputComboView;
        ChipTextInputComboView chipTextInputComboView2 = (ChipTextInputComboView) linearLayout.findViewById(R.id.f79658t);
        this.f82506g = chipTextInputComboView2;
        int i3 = R.id.f79662v;
        TextView textView = (TextView) chipTextInputComboView.findViewById(i3);
        TextView textView2 = (TextView) chipTextInputComboView2.findViewById(i3);
        textView.setText(resources.getString(R.string.f79721t));
        textView2.setText(resources.getString(R.string.f79720s));
        int i4 = R.id.f79635h0;
        chipTextInputComboView.setTag(i4, 12);
        chipTextInputComboView2.setTag(i4, 10);
        if (timeModel.f82482c == 0) {
            k();
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.google.android.material.timepicker.TimePickerTextInputPresenter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TimePickerTextInputPresenter.this.d(((Integer) view.getTag(R.id.f79635h0)).intValue());
            }
        };
        chipTextInputComboView2.setOnClickListener(onClickListener);
        chipTextInputComboView.setOnClickListener(onClickListener);
        chipTextInputComboView2.c(timeModel.f());
        chipTextInputComboView.c(timeModel.g());
        this.f82508i = chipTextInputComboView2.e().getEditText();
        this.f82509j = chipTextInputComboView.e().getEditText();
        this.f82507h = new TimePickerTextInputKeyController(chipTextInputComboView2, chipTextInputComboView, timeModel);
        chipTextInputComboView2.f(new ClickActionDelegate(linearLayout.getContext(), R.string.f79712k) { // from class: com.google.android.material.timepicker.TimePickerTextInputPresenter.4
            @Override // com.google.android.material.timepicker.ClickActionDelegate, androidx.core.view.AccessibilityDelegateCompat
            public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.g(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.m0(view.getResources().getString(timeModel.d(), String.valueOf(timeModel.e())));
            }
        });
        chipTextInputComboView.f(new ClickActionDelegate(linearLayout.getContext(), R.string.f79714m) { // from class: com.google.android.material.timepicker.TimePickerTextInputPresenter.5
            @Override // com.google.android.material.timepicker.ClickActionDelegate, androidx.core.view.AccessibilityDelegateCompat
            public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.g(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.m0(view.getResources().getString(R.string.f79715n, String.valueOf(timeModel.f82484f)));
            }
        });
        g();
    }

    public static /* synthetic */ void b(TimePickerTextInputPresenter timePickerTextInputPresenter, MaterialButtonToggleGroup materialButtonToggleGroup, int i3, boolean z2) {
        timePickerTextInputPresenter.getClass();
        if (z2) {
            timePickerTextInputPresenter.f82502b.k(i3 == R.id.f79654r ? 1 : 0);
        }
    }

    private void e() {
        this.f82508i.addTextChangedListener(this.f82504d);
        this.f82509j.addTextChangedListener(this.f82503c);
    }

    private void h() {
        this.f82508i.removeTextChangedListener(this.f82504d);
        this.f82509j.removeTextChangedListener(this.f82503c);
    }

    private void j(TimeModel timeModel) {
        h();
        Locale locale = this.f82501a.getResources().getConfiguration().locale;
        String str = String.format(locale, "%02d", Integer.valueOf(timeModel.f82484f));
        String str2 = String.format(locale, "%02d", Integer.valueOf(timeModel.e()));
        this.f82505f.g(str);
        this.f82506g.g(str2);
        e();
        l();
    }

    private void k() {
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) this.f82501a.findViewById(R.id.f79656s);
        this.f82510k = materialButtonToggleGroup;
        materialButtonToggleGroup.b(new MaterialButtonToggleGroup.OnButtonCheckedListener() { // from class: com.google.android.material.timepicker.d
            @Override // com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener
            public final void a(MaterialButtonToggleGroup materialButtonToggleGroup2, int i3, boolean z2) {
                TimePickerTextInputPresenter.b(this.f82534a, materialButtonToggleGroup2, i3, z2);
            }
        });
        this.f82510k.setVisibility(0);
        l();
    }

    private void l() {
        MaterialButtonToggleGroup materialButtonToggleGroup = this.f82510k;
        if (materialButtonToggleGroup == null) {
            return;
        }
        materialButtonToggleGroup.e(this.f82502b.f82486h == 0 ? R.id.f79652q : R.id.f79654r);
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void a() {
        View focusedChild = this.f82501a.getFocusedChild();
        if (focusedChild != null) {
            ViewUtils.n(focusedChild, false);
        }
        this.f82501a.setVisibility(8);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.OnSelectionChange
    public void d(int i3) {
        this.f82502b.f82485g = i3;
        this.f82505f.setChecked(i3 == 12);
        this.f82506g.setChecked(i3 == 10);
        l();
    }

    public void f() {
        this.f82505f.setChecked(false);
        this.f82506g.setChecked(false);
    }

    public void g() {
        e();
        j(this.f82502b);
        this.f82507h.a();
    }

    public void i() {
        this.f82505f.setChecked(this.f82502b.f82485g == 12);
        this.f82506g.setChecked(this.f82502b.f82485g == 10);
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void invalidate() {
        j(this.f82502b);
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void show() {
        this.f82501a.setVisibility(0);
        d(this.f82502b.f82485g);
    }
}
