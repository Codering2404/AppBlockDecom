package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.libraries.places.api.net.Pagination;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.api.net.SearchByTextRequest;
import com.google.android.libraries.places.api.net.SearchByTextResponse;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzgm implements Pagination {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PlacesClient f77855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzmy f77856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SearchByTextRequest.Builder f77857c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f77859e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f77861g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Integer f77858d = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f77860f = false;

    public zzgm(PlacesClient placesClient, SearchByTextRequest searchByTextRequest, String str, zzmy zzmyVar, int i3) {
        this.f77855a = placesClient;
        this.f77861g = i3;
        this.f77857c = searchByTextRequest.w();
        this.f77859e = str;
        this.f77856b = zzmyVar;
    }

    final /* synthetic */ Task a(SearchByTextResponse searchByTextResponse) {
        this.f77859e = searchByTextResponse.f();
        this.f77860f = false;
        this.f77861g++;
        return Tasks.forResult(searchByTextResponse);
    }
}
