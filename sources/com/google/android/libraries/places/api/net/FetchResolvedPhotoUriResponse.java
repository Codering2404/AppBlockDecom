package com.google.android.libraries.places.api.net;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class FetchResolvedPhotoUriResponse {
    public static FetchResolvedPhotoUriResponse b(Uri uri) {
        return new zzi(uri);
    }

    public abstract Uri a();
}
