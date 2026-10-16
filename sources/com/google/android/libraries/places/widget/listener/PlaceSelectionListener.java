package com.google.android.libraries.places.widget.listener;

import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.model.Place;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public interface PlaceSelectionListener {
    void a(Status status);

    void c(Place place);
}
