package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.google.android.material.R;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.textfield.TextInputLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR = new Parcelable.Creator<SingleDateSelector>() { // from class: com.google.android.material.datepicker.SingleDateSelector.2
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SingleDateSelector createFromParcel(Parcel parcel) {
            SingleDateSelector singleDateSelector = new SingleDateSelector();
            singleDateSelector.f80907b = (Long) parcel.readValue(Long.class.getClassLoader());
            return singleDateSelector;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public SingleDateSelector[] newArray(int i3) {
            return new SingleDateSelector[i3];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CharSequence f80906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Long f80907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SimpleDateFormat f80908c;

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f80907b = null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int V(Context context) {
        return MaterialAttributes.d(context, R.attr.O, MaterialDatePicker.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View V1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, CalendarConstraints calendarConstraints, final OnSelectionChangedListener onSelectionChangedListener) {
        View viewInflate = layoutInflater.inflate(R.layout.G, viewGroup, false);
        final TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(R.id.W);
        EditText editText = textInputLayout.getEditText();
        if (ManufacturerUtils.b()) {
            editText.setInputType(17);
        }
        SimpleDateFormat simpleDateFormatF = this.f80908c;
        boolean z2 = simpleDateFormatF != null;
        if (!z2) {
            simpleDateFormatF = UtcDates.f();
        }
        SimpleDateFormat simpleDateFormat = simpleDateFormatF;
        String pattern = z2 ? simpleDateFormat.toPattern() : UtcDates.g(viewInflate.getResources(), simpleDateFormat);
        textInputLayout.setPlaceholderText(pattern);
        Long l3 = this.f80907b;
        if (l3 != null) {
            editText.setText(simpleDateFormat.format(l3));
        }
        editText.addTextChangedListener(new DateFormatTextWatcher(pattern, simpleDateFormat, textInputLayout, calendarConstraints) { // from class: com.google.android.material.datepicker.SingleDateSelector.1
            @Override // com.google.android.material.datepicker.DateFormatTextWatcher
            void d() {
                SingleDateSelector.this.f80906a = textInputLayout.getError();
                onSelectionChangedListener.a();
            }

            @Override // com.google.android.material.datepicker.DateFormatTextWatcher
            void e(Long l4) {
                if (l4 == null) {
                    SingleDateSelector.this.e();
                } else {
                    SingleDateSelector.this.z2(l4.longValue());
                }
                SingleDateSelector.this.f80906a = null;
                onSelectionChangedListener.b(SingleDateSelector.this.r2());
            }
        });
        DateSelector.T1(editText);
        return viewInflate;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Long r2() {
        return this.f80907b;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean k2() {
        return this.f80907b != null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection o2() {
        ArrayList arrayList = new ArrayList();
        Long l3 = this.f80907b;
        if (l3 != null) {
            arrayList.add(l3);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String u1(Context context) {
        Resources resources = context.getResources();
        Long l3 = this.f80907b;
        if (l3 == null) {
            return resources.getString(R.string.G);
        }
        return resources.getString(R.string.F, DateStrings.m(l3.longValue()));
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection w1() {
        return new ArrayList();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeValue(this.f80907b);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String z(Context context) {
        Resources resources = context.getResources();
        Long l3 = this.f80907b;
        return resources.getString(R.string.D, l3 == null ? resources.getString(R.string.E) : DateStrings.m(l3.longValue()));
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void z2(long j3) {
        this.f80907b = Long.valueOf(j3);
    }
}
