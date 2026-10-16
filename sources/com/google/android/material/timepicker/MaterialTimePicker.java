package com.google.android.material.timepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.timepicker.TimePickerView;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class MaterialTimePicker extends DialogFragment implements TimePickerView.OnDoubleTapListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TimePickerView f82455f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ViewStub f82456g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TimePickerClockPresenter f82457h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TimePickerTextInputPresenter f82458i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private TimePickerPresenter f82459j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f82460k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f82461l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private CharSequence f82463n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private CharSequence f82465p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private CharSequence f82467r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private MaterialButton f82468s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Button f82469t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private TimeModel f82471v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set f82451a = new LinkedHashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set f82452b = new LinkedHashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set f82453c = new LinkedHashSet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set f82454d = new LinkedHashSet();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f82462m = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f82464o = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f82466q = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f82470u = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f82472w = 0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
    }

    private Pair F(int i3) {
        if (i3 == 0) {
            return new Pair(Integer.valueOf(this.f82460k), Integer.valueOf(R.string.f79722u));
        }
        if (i3 == 1) {
            return new Pair(Integer.valueOf(this.f82461l), Integer.valueOf(R.string.f79719r));
        }
        throw new IllegalArgumentException("no icon for mode: " + i3);
    }

    private int G() {
        int i3 = this.f82472w;
        if (i3 != 0) {
            return i3;
        }
        TypedValue typedValueA = MaterialAttributes.a(requireContext(), R.attr.T);
        if (typedValueA == null) {
            return 0;
        }
        return typedValueA.data;
    }

    private TimePickerPresenter H(int i3, TimePickerView timePickerView, ViewStub viewStub) {
        if (i3 != 0) {
            if (this.f82458i == null) {
                this.f82458i = new TimePickerTextInputPresenter((LinearLayout) viewStub.inflate(), this.f82471v);
            }
            this.f82458i.f();
            return this.f82458i;
        }
        TimePickerClockPresenter timePickerClockPresenter = this.f82457h;
        if (timePickerClockPresenter == null) {
            timePickerClockPresenter = new TimePickerClockPresenter(timePickerView, this.f82471v);
        }
        this.f82457h = timePickerClockPresenter;
        return timePickerClockPresenter;
    }

    private void I(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        TimeModel timeModel = (TimeModel) bundle.getParcelable("TIME_PICKER_TIME_MODEL");
        this.f82471v = timeModel;
        if (timeModel == null) {
            this.f82471v = new TimeModel();
        }
        this.f82470u = bundle.getInt("TIME_PICKER_INPUT_MODE", this.f82471v.f82482c != 1 ? 0 : 1);
        this.f82462m = bundle.getInt("TIME_PICKER_TITLE_RES", 0);
        this.f82463n = bundle.getCharSequence("TIME_PICKER_TITLE_TEXT");
        this.f82464o = bundle.getInt("TIME_PICKER_POSITIVE_BUTTON_TEXT_RES", 0);
        this.f82465p = bundle.getCharSequence("TIME_PICKER_POSITIVE_BUTTON_TEXT");
        this.f82466q = bundle.getInt("TIME_PICKER_NEGATIVE_BUTTON_TEXT_RES", 0);
        this.f82467r = bundle.getCharSequence("TIME_PICKER_NEGATIVE_BUTTON_TEXT");
        this.f82472w = bundle.getInt("TIME_PICKER_OVERRIDE_THEME_RES_ID", 0);
    }

    private void J() {
        Button button = this.f82469t;
        if (button != null) {
            button.setVisibility(isCancelable() ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(MaterialButton materialButton) {
        if (materialButton == null || this.f82455f == null || this.f82456g == null) {
            return;
        }
        TimePickerPresenter timePickerPresenter = this.f82459j;
        if (timePickerPresenter != null) {
            timePickerPresenter.a();
        }
        TimePickerPresenter timePickerPresenterH = H(this.f82470u, this.f82455f, this.f82456g);
        this.f82459j = timePickerPresenterH;
        timePickerPresenterH.show();
        this.f82459j.invalidate();
        Pair pairF = F(this.f82470u);
        materialButton.setIconResource(((Integer) pairF.first).intValue());
        materialButton.setContentDescription(getResources().getString(((Integer) pairF.second).intValue()));
        materialButton.sendAccessibilityEvent(4);
    }

    public static /* synthetic */ void y(MaterialTimePicker materialTimePicker) {
        TimePickerPresenter timePickerPresenter = materialTimePicker.f82459j;
        if (timePickerPresenter instanceof TimePickerTextInputPresenter) {
            ((TimePickerTextInputPresenter) timePickerPresenter).i();
        }
    }

    @Override // com.google.android.material.timepicker.TimePickerView.OnDoubleTapListener
    public void d() {
        this.f82470u = 1;
        L(this.f82468s);
        this.f82458i.i();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it = this.f82453c.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnCancelListener) it.next()).onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        I(bundle);
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), G());
        Context context = dialog.getContext();
        int i3 = R.attr.S;
        int i4 = R.style.T;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(context, null, i3, i4);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.F5, i3, i4);
        this.f82461l = typedArrayObtainStyledAttributes.getResourceId(R.styleable.H5, 0);
        this.f82460k = typedArrayObtainStyledAttributes.getResourceId(R.styleable.I5, 0);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.G5, 0);
        typedArrayObtainStyledAttributes.recycle();
        materialShapeDrawable.P(context);
        materialShapeDrawable.a0(ColorStateList.valueOf(color));
        Window window = dialog.getWindow();
        window.setBackgroundDrawable(materialShapeDrawable);
        window.requestFeature(1);
        window.setLayout(-2, -2);
        materialShapeDrawable.Z(ViewCompat.t(window.getDecorView()));
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.f79689t, viewGroup);
        TimePickerView timePickerView = (TimePickerView) viewGroup2.findViewById(R.id.C);
        this.f82455f = timePickerView;
        timePickerView.z(this);
        this.f82456g = (ViewStub) viewGroup2.findViewById(R.id.f79665y);
        this.f82468s = (MaterialButton) viewGroup2.findViewById(R.id.A);
        TextView textView = (TextView) viewGroup2.findViewById(R.id.f79640k);
        int i3 = this.f82462m;
        if (i3 != 0) {
            textView.setText(i3);
        } else if (!TextUtils.isEmpty(this.f82463n)) {
            textView.setText(this.f82463n);
        }
        L(this.f82468s);
        Button button = (Button) viewGroup2.findViewById(R.id.B);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.timepicker.MaterialTimePicker.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Iterator it = MaterialTimePicker.this.f82451a.iterator();
                while (it.hasNext()) {
                    ((View.OnClickListener) it.next()).onClick(view);
                }
                MaterialTimePicker.this.dismiss();
            }
        });
        int i4 = this.f82464o;
        if (i4 != 0) {
            button.setText(i4);
        } else if (!TextUtils.isEmpty(this.f82465p)) {
            button.setText(this.f82465p);
        }
        Button button2 = (Button) viewGroup2.findViewById(R.id.f79666z);
        this.f82469t = button2;
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.timepicker.MaterialTimePicker.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Iterator it = MaterialTimePicker.this.f82452b.iterator();
                while (it.hasNext()) {
                    ((View.OnClickListener) it.next()).onClick(view);
                }
                MaterialTimePicker.this.dismiss();
            }
        });
        int i5 = this.f82466q;
        if (i5 != 0) {
            this.f82469t.setText(i5);
        } else if (!TextUtils.isEmpty(this.f82467r)) {
            this.f82469t.setText(this.f82467r);
        }
        J();
        this.f82468s.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.timepicker.MaterialTimePicker.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MaterialTimePicker materialTimePicker = MaterialTimePicker.this;
                materialTimePicker.f82470u = materialTimePicker.f82470u == 0 ? 1 : 0;
                MaterialTimePicker materialTimePicker2 = MaterialTimePicker.this;
                materialTimePicker2.L(materialTimePicker2.f82468s);
            }
        });
        return viewGroup2;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f82459j = null;
        this.f82457h = null;
        this.f82458i = null;
        TimePickerView timePickerView = this.f82455f;
        if (timePickerView != null) {
            timePickerView.z(null);
            this.f82455f = null;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it = this.f82454d.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnDismissListener) it.next()).onDismiss(dialogInterface);
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("TIME_PICKER_TIME_MODEL", this.f82471v);
        bundle.putInt("TIME_PICKER_INPUT_MODE", this.f82470u);
        bundle.putInt("TIME_PICKER_TITLE_RES", this.f82462m);
        bundle.putCharSequence("TIME_PICKER_TITLE_TEXT", this.f82463n);
        bundle.putInt("TIME_PICKER_POSITIVE_BUTTON_TEXT_RES", this.f82464o);
        bundle.putCharSequence("TIME_PICKER_POSITIVE_BUTTON_TEXT", this.f82465p);
        bundle.putInt("TIME_PICKER_NEGATIVE_BUTTON_TEXT_RES", this.f82466q);
        bundle.putCharSequence("TIME_PICKER_NEGATIVE_BUTTON_TEXT", this.f82467r);
        bundle.putInt("TIME_PICKER_OVERRIDE_THEME_RES_ID", this.f82472w);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (this.f82459j instanceof TimePickerTextInputPresenter) {
            view.postDelayed(new Runnable() { // from class: com.google.android.material.timepicker.b
                @Override // java.lang.Runnable
                public final void run() {
                    MaterialTimePicker.y(this.f82532a);
                }
            }, 100L);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public void setCancelable(boolean z2) {
        super.setCancelable(z2);
        J();
    }
}
