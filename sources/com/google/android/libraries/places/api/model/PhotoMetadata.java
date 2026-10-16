package com.google.android.libraries.places.api.model;

import android.net.Uri;
import android.os.Parcelable;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class PhotoMetadata implements Parcelable {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public PhotoMetadata a() {
            PhotoMetadata photoMetadataH = h();
            int iF = photoMetadataH.f();
            Preconditions.h(iF >= 0, "Width must not be < 0, but was: %s.", iF);
            int iE = photoMetadataH.e();
            Preconditions.h(iE >= 0, "Height must not be < 0, but was: %s.", iE);
            Preconditions.e(!photoMetadataH.g().isEmpty(), "PhotoReference must not be empty.");
            return photoMetadataH;
        }

        public abstract Builder b(String str);

        public abstract Builder c(AuthorAttributions authorAttributions);

        public abstract Builder d(int i3);

        public abstract Builder e(int i3);

        public abstract Builder f(String str);

        public abstract Builder g(Uri uri);

        abstract PhotoMetadata h();
    }

    public static Builder a(String str) {
        zzbc zzbcVar = new zzbc();
        zzbcVar.i(str);
        zzbcVar.e(0);
        zzbcVar.d(0);
        zzbcVar.b("");
        return zzbcVar;
    }

    public abstract String c();

    public abstract AuthorAttributions d();

    public abstract int e();

    public abstract int f();

    public abstract String g();

    public abstract String h();

    public abstract Uri i();
}
