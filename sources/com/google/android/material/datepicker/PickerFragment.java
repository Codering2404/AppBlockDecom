package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class PickerFragment<S> extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final LinkedHashSet f80889a = new LinkedHashSet();

    PickerFragment() {
    }

    boolean w(OnSelectionChangedListener onSelectionChangedListener) {
        return this.f80889a.add(onSelectionChangedListener);
    }

    void x() {
        this.f80889a.clear();
    }
}
