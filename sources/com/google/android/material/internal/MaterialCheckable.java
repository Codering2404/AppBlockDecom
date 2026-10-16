package com.google.android.material.internal;

import android.widget.Checkable;
import com.google.android.material.internal.MaterialCheckable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public interface MaterialCheckable<T extends MaterialCheckable<T>> extends Checkable {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnCheckedChangeListener<C> {
        void a(Object obj, boolean z2);
    }

    int getId();

    void setInternalOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener);
}
