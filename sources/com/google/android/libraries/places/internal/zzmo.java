package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.net.FetchPhotoRequest;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.FetchResolvedPhotoUriRequest;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import com.google.android.libraries.places.api.net.SearchByTextRequest;
import com.google.android.libraries.places.api.net.SearchNearbyRequest;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public interface zzmo {
    void a(SearchNearbyRequest searchNearbyRequest, zzmy zzmyVar);

    void b(FindCurrentPlaceRequest findCurrentPlaceRequest, Task task, long j3, long j4, zzmy zzmyVar);

    void c(FindAutocompletePredictionsRequest findAutocompletePredictionsRequest, int i3, zzmy zzmyVar);

    void d(FetchResolvedPhotoUriRequest fetchResolvedPhotoUriRequest, zzmy zzmyVar);

    void e(Task task, long j3, long j4, int i3, zzmy zzmyVar, com.google.android.libraries.places.api.auth.zzb zzbVar);

    void f(FetchPlaceRequest fetchPlaceRequest, int i3, zzmy zzmyVar);

    void g(Task task, long j3, long j4, int i3, zzmy zzmyVar, com.google.android.libraries.places.api.auth.zzb zzbVar);

    void h(SearchByTextRequest searchByTextRequest, zzmy zzmyVar);

    void i(Task task, long j3, long j4, zzmy zzmyVar);

    void j(FetchPlaceRequest fetchPlaceRequest, int i3, zzmy zzmyVar);

    void k(Task task, long j3, long j4, zzmy zzmyVar);

    void l(FetchPhotoRequest fetchPhotoRequest, zzmy zzmyVar);

    void m(Task task, long j3, long j4, zzmy zzmyVar, com.google.android.libraries.places.api.auth.zzb zzbVar);

    void n(SearchNearbyRequest searchNearbyRequest, Task task, long j3, long j4, zzmy zzmyVar, com.google.android.libraries.places.api.auth.zzb zzbVar);

    void o(SearchByTextRequest searchByTextRequest, Task task, long j3, long j4, zzmy zzmyVar, com.google.android.libraries.places.api.auth.zzb zzbVar);
}
