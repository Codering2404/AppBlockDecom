package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompatApi21;
import android.support.v4.media.MediaDescriptionCompatApi23;
import android.support.v4.media.session.MediaSessionCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new Parcelable.Creator<MediaDescriptionCompat>() { // from class: android.support.v4.media.MediaDescriptionCompat.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            return MediaDescriptionCompat.a(MediaDescriptionCompatApi21.a(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MediaDescriptionCompat[] newArray(int i3) {
            return new MediaDescriptionCompat[i3];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CharSequence f178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CharSequence f179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CharSequence f180d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Bitmap f181f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Uri f182g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Bundle f183h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Uri f184i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Object f185j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f186a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private CharSequence f187b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private CharSequence f188c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private CharSequence f189d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Bitmap f190e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Uri f191f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Bundle f192g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Uri f193h;

        public MediaDescriptionCompat a() {
            return new MediaDescriptionCompat(this.f186a, this.f187b, this.f188c, this.f189d, this.f190e, this.f191f, this.f192g, this.f193h);
        }

        public Builder b(CharSequence charSequence) {
            this.f189d = charSequence;
            return this;
        }

        public Builder c(Bundle bundle) {
            this.f192g = bundle;
            return this;
        }

        public Builder d(Bitmap bitmap) {
            this.f190e = bitmap;
            return this;
        }

        public Builder e(Uri uri) {
            this.f191f = uri;
            return this;
        }

        public Builder f(String str) {
            this.f186a = str;
            return this;
        }

        public Builder g(Uri uri) {
            this.f193h = uri;
            return this;
        }

        public Builder h(CharSequence charSequence) {
            this.f188c = charSequence;
            return this;
        }

        public Builder i(CharSequence charSequence) {
            this.f187b = charSequence;
            return this;
        }
    }

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f177a = str;
        this.f178b = charSequence;
        this.f179c = charSequence2;
        this.f180d = charSequence3;
        this.f181f = bitmap;
        this.f182g = uri;
        this.f183h = bundle;
        this.f184i = uri2;
    }

    public static MediaDescriptionCompat a(Object obj) {
        Uri uri;
        Bundle bundle = null;
        if (obj == null) {
            return null;
        }
        Builder builder = new Builder();
        builder.f(MediaDescriptionCompatApi21.f(obj));
        builder.i(MediaDescriptionCompatApi21.h(obj));
        builder.h(MediaDescriptionCompatApi21.g(obj));
        builder.b(MediaDescriptionCompatApi21.b(obj));
        builder.d(MediaDescriptionCompatApi21.d(obj));
        builder.e(MediaDescriptionCompatApi21.e(obj));
        Bundle bundleC = MediaDescriptionCompatApi21.c(obj);
        if (bundleC != null) {
            MediaSessionCompat.a(bundleC);
            uri = (Uri) bundleC.getParcelable("android.support.v4.media.description.MEDIA_URI");
        } else {
            uri = null;
        }
        if (uri == null) {
            bundle = bundleC;
        } else if (!bundleC.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") || bundleC.size() != 2) {
            bundleC.remove("android.support.v4.media.description.MEDIA_URI");
            bundleC.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
            bundle = bundleC;
        }
        builder.c(bundle);
        if (uri != null) {
            builder.g(uri);
        } else {
            builder.g(MediaDescriptionCompatApi23.a(obj));
        }
        MediaDescriptionCompat mediaDescriptionCompatA = builder.a();
        mediaDescriptionCompatA.f185j = obj;
        return mediaDescriptionCompatA;
    }

    public Object c() {
        Object obj = this.f185j;
        if (obj != null) {
            return obj;
        }
        Object objB = MediaDescriptionCompatApi21.Builder.b();
        MediaDescriptionCompatApi21.Builder.g(objB, this.f177a);
        MediaDescriptionCompatApi21.Builder.i(objB, this.f178b);
        MediaDescriptionCompatApi21.Builder.h(objB, this.f179c);
        MediaDescriptionCompatApi21.Builder.c(objB, this.f180d);
        MediaDescriptionCompatApi21.Builder.e(objB, this.f181f);
        MediaDescriptionCompatApi21.Builder.f(objB, this.f182g);
        MediaDescriptionCompatApi21.Builder.d(objB, this.f183h);
        MediaDescriptionCompatApi23.Builder.a(objB, this.f184i);
        Object objA = MediaDescriptionCompatApi21.Builder.a(objB);
        this.f185j = objA;
        return objA;
    }

    public String d() {
        return this.f177a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return ((Object) this.f178b) + ", " + ((Object) this.f179c) + ", " + ((Object) this.f180d);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        MediaDescriptionCompatApi21.i(c(), parcel, i3);
    }
}
