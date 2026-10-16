package com.google.android.libraries.places.internal;

import com.facebook.internal.AnalyticsEvents;
import com.google.android.libraries.places.api.model.PhotoMetadata;
import com.google.android.libraries.places.api.net.FetchPhotoRequest;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzkl extends zzld {
    zzkl(FetchPhotoRequest fetchPhotoRequest, String str, zznh zznhVar) {
        super(fetchPhotoRequest, null, str, zznhVar);
    }

    @Override // com.google.android.libraries.places.internal.zzld
    public final Map e() {
        FetchPhotoRequest fetchPhotoRequest = (FetchPhotoRequest) a();
        PhotoMetadata photoMetadataE = fetchPhotoRequest.e();
        HashMap map = new HashMap();
        zzld.g(map, "maxheight", fetchPhotoRequest.c(), null);
        zzld.g(map, "maxwidth", fetchPhotoRequest.d(), null);
        map.put("photoreference", photoMetadataE.g());
        return map;
    }

    @Override // com.google.android.libraries.places.internal.zzld
    protected final String f() {
        return AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO;
    }
}
