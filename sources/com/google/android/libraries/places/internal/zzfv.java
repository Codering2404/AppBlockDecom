package com.google.android.libraries.places.internal;

import android.location.Location;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.net.FetchPhotoRequest;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import com.google.common.collect.ImmutableList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public interface zzfv {
    Task a(FetchPhotoRequest fetchPhotoRequest, zzmy zzmyVar);

    Task b(FindAutocompletePredictionsRequest findAutocompletePredictionsRequest, zzmy zzmyVar);

    Task c(FindCurrentPlaceRequest findCurrentPlaceRequest, Location location, ImmutableList immutableList, zzmy zzmyVar);

    Task d(FetchPlaceRequest fetchPlaceRequest, zzmy zzmyVar);
}
