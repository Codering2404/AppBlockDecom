package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.core.util.Pair;
import com.google.android.material.R;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.textfield.TextInputLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class RangeDateSelector implements DateSelector<Pair<Long, Long>> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = new Parcelable.Creator<RangeDateSelector>() { // from class: com.google.android.material.datepicker.RangeDateSelector.3
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public RangeDateSelector createFromParcel(Parcel parcel) {
            RangeDateSelector rangeDateSelector = new RangeDateSelector();
            rangeDateSelector.f80893d = (Long) parcel.readValue(Long.class.getClassLoader());
            rangeDateSelector.f80894f = (Long) parcel.readValue(Long.class.getClassLoader());
            return rangeDateSelector;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public RangeDateSelector[] newArray(int i3) {
            return new RangeDateSelector[i3];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CharSequence f80890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f80891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f80892c = " ";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Long f80893d = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Long f80894f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Long f80895g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Long f80896h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private SimpleDateFormat f80897i;

    private void g(TextInputLayout textInputLayout, TextInputLayout textInputLayout2) {
        if (textInputLayout.getError() != null && this.f80891b.contentEquals(textInputLayout.getError())) {
            textInputLayout.setError(null);
        }
        if (textInputLayout2.getError() == null || !" ".contentEquals(textInputLayout2.getError())) {
            return;
        }
        textInputLayout2.setError(null);
    }

    private boolean i(long j3, long j4) {
        return j3 <= j4;
    }

    private void j(TextInputLayout textInputLayout, TextInputLayout textInputLayout2) {
        textInputLayout.setError(this.f80891b);
        textInputLayout2.setError(" ");
    }

    private void k(TextInputLayout textInputLayout, TextInputLayout textInputLayout2) {
        if (!TextUtils.isEmpty(textInputLayout.getError())) {
            this.f80890a = textInputLayout.getError();
        } else if (TextUtils.isEmpty(textInputLayout2.getError())) {
            this.f80890a = null;
        } else {
            this.f80890a = textInputLayout2.getError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(TextInputLayout textInputLayout, TextInputLayout textInputLayout2, OnSelectionChangedListener onSelectionChangedListener) {
        Long l3 = this.f80895g;
        if (l3 == null || this.f80896h == null) {
            g(textInputLayout, textInputLayout2);
            onSelectionChangedListener.a();
        } else if (i(l3.longValue(), this.f80896h.longValue())) {
            this.f80893d = this.f80895g;
            this.f80894f = this.f80896h;
            onSelectionChangedListener.b(r2());
        } else {
            j(textInputLayout, textInputLayout2);
            onSelectionChangedListener.a();
        }
        k(textInputLayout, textInputLayout2);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int V(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return MaterialAttributes.d(context, Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(R.dimen.f79589r0) ? R.attr.O : R.attr.M, MaterialDatePicker.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View V1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, CalendarConstraints calendarConstraints, final OnSelectionChangedListener onSelectionChangedListener) {
        View viewInflate = layoutInflater.inflate(R.layout.H, viewGroup, false);
        final TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(R.id.Y);
        final TextInputLayout textInputLayout2 = (TextInputLayout) viewInflate.findViewById(R.id.X);
        EditText editText = textInputLayout.getEditText();
        EditText editText2 = textInputLayout2.getEditText();
        if (ManufacturerUtils.b()) {
            editText.setInputType(17);
            editText2.setInputType(17);
        }
        this.f80891b = viewInflate.getResources().getString(R.string.M);
        SimpleDateFormat simpleDateFormatF = this.f80897i;
        boolean z2 = simpleDateFormatF != null;
        if (!z2) {
            simpleDateFormatF = UtcDates.f();
        }
        SimpleDateFormat simpleDateFormat = simpleDateFormatF;
        Long l3 = this.f80893d;
        if (l3 != null) {
            editText.setText(simpleDateFormat.format(l3));
            this.f80895g = this.f80893d;
        }
        Long l4 = this.f80894f;
        if (l4 != null) {
            editText2.setText(simpleDateFormat.format(l4));
            this.f80896h = this.f80894f;
        }
        String pattern = z2 ? simpleDateFormat.toPattern() : UtcDates.g(viewInflate.getResources(), simpleDateFormat);
        textInputLayout.setPlaceholderText(pattern);
        textInputLayout2.setPlaceholderText(pattern);
        editText.addTextChangedListener(new DateFormatTextWatcher(pattern, simpleDateFormat, textInputLayout, calendarConstraints) { // from class: com.google.android.material.datepicker.RangeDateSelector.1
            @Override // com.google.android.material.datepicker.DateFormatTextWatcher
            void d() {
                RangeDateSelector.this.f80895g = null;
                RangeDateSelector.this.l(textInputLayout, textInputLayout2, onSelectionChangedListener);
            }

            @Override // com.google.android.material.datepicker.DateFormatTextWatcher
            void e(Long l5) {
                RangeDateSelector.this.f80895g = l5;
                RangeDateSelector.this.l(textInputLayout, textInputLayout2, onSelectionChangedListener);
            }
        });
        editText2.addTextChangedListener(new DateFormatTextWatcher(pattern, simpleDateFormat, textInputLayout2, calendarConstraints) { // from class: com.google.android.material.datepicker.RangeDateSelector.2
            @Override // com.google.android.material.datepicker.DateFormatTextWatcher
            void d() {
                RangeDateSelector.this.f80896h = null;
                RangeDateSelector.this.l(textInputLayout, textInputLayout2, onSelectionChangedListener);
            }

            @Override // com.google.android.material.datepicker.DateFormatTextWatcher
            void e(Long l5) {
                RangeDateSelector.this.f80896h = l5;
                RangeDateSelector.this.l(textInputLayout, textInputLayout2, onSelectionChangedListener);
            }
        });
        DateSelector.T1(editText, editText2);
        return viewInflate;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public Pair r2() {
        return new Pair(this.f80893d, this.f80894f);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean k2() {
        Long l3 = this.f80893d;
        return (l3 == null || this.f80894f == null || !i(l3.longValue(), this.f80894f.longValue())) ? false : true;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection o2() {
        ArrayList arrayList = new ArrayList();
        Long l3 = this.f80893d;
        if (l3 != null) {
            arrayList.add(l3);
        }
        Long l4 = this.f80894f;
        if (l4 != null) {
            arrayList.add(l4);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String u1(Context context) {
        Resources resources = context.getResources();
        Long l3 = this.f80893d;
        if (l3 == null && this.f80894f == null) {
            return resources.getString(R.string.T);
        }
        Long l4 = this.f80894f;
        if (l4 == null) {
            return resources.getString(R.string.R, DateStrings.c(l3.longValue()));
        }
        if (l3 == null) {
            return resources.getString(R.string.Q, DateStrings.c(l4.longValue()));
        }
        Pair pairA = DateStrings.a(l3, l4);
        return resources.getString(R.string.S, pairA.f34340a, pairA.f34341b);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection w1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair(this.f80893d, this.f80894f));
        return arrayList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeValue(this.f80893d);
        parcel.writeValue(this.f80894f);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String z(Context context) {
        Resources resources = context.getResources();
        Pair pairA = DateStrings.a(this.f80893d, this.f80894f);
        Object obj = pairA.f34340a;
        String string = obj == null ? resources.getString(R.string.E) : (String) obj;
        Object obj2 = pairA.f34341b;
        return resources.getString(R.string.C, string, obj2 == null ? resources.getString(R.string.E) : (String) obj2);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void z2(long j3) {
        Long l3 = this.f80893d;
        if (l3 == null) {
            this.f80893d = Long.valueOf(j3);
        } else if (this.f80894f == null && i(l3.longValue(), j3)) {
            this.f80894f = Long.valueOf(j3);
        } else {
            this.f80894f = null;
            this.f80893d = Long.valueOf(j3);
        }
    }
}
