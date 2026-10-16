package com.google.android.libraries.places.api.net;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.PhotoMetadata;
import com.google.android.libraries.places.internal.zzmq;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public abstract class FetchPhotoRequest implements zzmq {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    public static abstract class Builder {
        public FetchPhotoRequest a() {
            PhotoMetadata photoMetadataG = g();
            if (c() == null && b() == null) {
                int iF = photoMetadataG.f();
                if (iF > 0) {
                    f(Integer.valueOf(iF));
                }
                int iE = photoMetadataG.e();
                if (iE > 0) {
                    e(Integer.valueOf(iE));
                }
            }
            return h();
        }

        public abstract Integer b();

        public abstract Integer c();

        public abstract Builder d(CancellationToken cancellationToken);

        public abstract Builder e(Integer num);

        public abstract Builder f(Integer num);

        abstract PhotoMetadata g();

        abstract FetchPhotoRequest h();
    }

    public static Builder b(PhotoMetadata photoMetadata) {
        zza zzaVar = new zza();
        zzaVar.i(photoMetadata);
        return zzaVar;
    }

    @Override // com.google.android.libraries.places.internal.zzmq
    public abstract CancellationToken a();

    public abstract Integer c();

    public abstract Integer d();

    public abstract PhotoMetadata e();
}
