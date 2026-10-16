package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class MaterialTextInputPicker<S> extends PickerFragment<S> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f80861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private DateSelector f80862c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CalendarConstraints f80863d;

    static MaterialTextInputPicker y(DateSelector dateSelector, int i3, CalendarConstraints calendarConstraints) {
        MaterialTextInputPicker materialTextInputPicker = new MaterialTextInputPicker();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i3);
        bundle.putParcelable("DATE_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        materialTextInputPicker.setArguments(bundle);
        return materialTextInputPicker;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f80861b = bundle.getInt("THEME_RES_ID_KEY");
        this.f80862c = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f80863d = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f80862c.V1(layoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), this.f80861b)), viewGroup, bundle, this.f80863d, new OnSelectionChangedListener<S>() { // from class: com.google.android.material.datepicker.MaterialTextInputPicker.1
            @Override // com.google.android.material.datepicker.OnSelectionChangedListener
            public void a() {
                Iterator it = MaterialTextInputPicker.this.f80889a.iterator();
                while (it.hasNext()) {
                    ((OnSelectionChangedListener) it.next()).a();
                }
            }

            @Override // com.google.android.material.datepicker.OnSelectionChangedListener
            public void b(Object obj) {
                Iterator it = MaterialTextInputPicker.this.f80889a.iterator();
                while (it.hasNext()) {
                    ((OnSelectionChangedListener) it.next()).b(obj);
                }
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f80861b);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f80862c);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f80863d);
    }
}
