package com.google.android.libraries.places.api.net;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.PhotoMetadata;
import com.google.android.libraries.places.internal.zzmq;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class FetchResolvedPhotoUriRequest implements zzmq {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public FetchResolvedPhotoUriRequest a() {
            PhotoMetadata photoMetadataG = g();
            Integer numC = c();
            Integer numB = b();
            Preconditions.e(photoMetadataG.h() != null, "To construct the FetchResolvedPhotoUriRequest, the provided PhotoMetadata must be fetched from Places API (New). You must first call initializeWithNewPlacesApiEnabled to initialize the PlaceClient and retrieve the PhotoMetadata. Once you have the PhotoMetadata, you must pass it into the FetchResolvedPhotoUriRequest.");
            if (numC != null) {
                Preconditions.m(numC.intValue() > 0, "Max width must not be < 1, but was: %s.", numC);
                Preconditions.j(numC.intValue() <= 4800, "Max width must not be > %s, but was: %s.", 4800, numC);
            }
            if (numB != null) {
                Preconditions.m(numB.intValue() > 0, "Max height must not be < 1, but was: %s.", numB);
                Preconditions.j(numB.intValue() <= 4800, "Max height must not be > %s, but was: %s.", 4800, numB);
            }
            if (numC == null && numB == null) {
                int iF = photoMetadataG.f();
                if (iF > 0) {
                    f(Integer.valueOf(Math.min(4800, iF)));
                }
                int iE = photoMetadataG.e();
                if (iE > 0) {
                    e(Integer.valueOf(Math.min(4800, iE)));
                }
            }
            Preconditions.A((c() == null && b() == null) ? false : true, "Must include max width or max height in the request.");
            return h();
        }

        public abstract Integer b();

        public abstract Integer c();

        public abstract Builder d(CancellationToken cancellationToken);

        public abstract Builder e(Integer num);

        public abstract Builder f(Integer num);

        abstract PhotoMetadata g();

        abstract FetchResolvedPhotoUriRequest h();
    }

    public static Builder b(PhotoMetadata photoMetadata) {
        zzg zzgVar = new zzg();
        zzgVar.i(photoMetadata);
        return zzgVar;
    }

    public static FetchResolvedPhotoUriRequest f(PhotoMetadata photoMetadata) {
        return b(photoMetadata).a();
    }

    @Override // com.google.android.libraries.places.internal.zzmq
    public abstract CancellationToken a();

    public abstract Integer c();

    public abstract Integer d();

    public abstract PhotoMetadata e();
}
