package com.google.android.libraries.places.api.net;

import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.internal.zzmy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public interface PlacesClient {
    Task a(FetchPhotoRequest fetchPhotoRequest, zzmy zzmyVar);

    Task b(FindAutocompletePredictionsRequest findAutocompletePredictionsRequest, zzmy zzmyVar);

    Task c(FindAutocompletePredictionsRequest findAutocompletePredictionsRequest);

    Task d(SearchByTextRequest searchByTextRequest, zzmy zzmyVar);

    Task e(IsOpenRequest isOpenRequest, zzmy zzmyVar);

    Task f(FetchResolvedPhotoUriRequest fetchResolvedPhotoUriRequest, zzmy zzmyVar);

    Task g(FetchPlaceRequest fetchPlaceRequest, zzmy zzmyVar);

    Task h(FindCurrentPlaceRequest findCurrentPlaceRequest, zzmy zzmyVar);

    Task i(FetchPlaceRequest fetchPlaceRequest);

    Task j(SearchNearbyRequest searchNearbyRequest, zzmy zzmyVar);

    void zzk();

    void zzl();

    void zzm();
}
