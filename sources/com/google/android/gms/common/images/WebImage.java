package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class WebImage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<WebImage> CREATOR = new zah();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f71929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Uri f71930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f71931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f71932d;

    WebImage(int i3, Uri uri, int i4, int i5) {
        this.f71929a = i3;
        this.f71930b = uri;
        this.f71931c = i4;
        this.f71932d = i5;
    }

    public int M() {
        return this.f71932d;
    }

    public Uri N() {
        return this.f71930b;
    }

    public int O() {
        return this.f71931c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof WebImage)) {
            WebImage webImage = (WebImage) obj;
            if (Objects.b(this.f71930b, webImage.f71930b) && this.f71931c == webImage.f71931c && this.f71932d == webImage.f71932d) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.c(this.f71930b, Integer.valueOf(this.f71931c), Integer.valueOf(this.f71932d));
    }

    public String toString() {
        return String.format(Locale.US, "Image %dx%d %s", Integer.valueOf(this.f71931c), Integer.valueOf(this.f71932d), this.f71930b.toString());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.f71929a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, i4);
        SafeParcelWriter.E(parcel, 2, N(), i3, false);
        SafeParcelWriter.u(parcel, 3, O());
        SafeParcelWriter.u(parcel, 4, M());
        SafeParcelWriter.b(parcel, iA);
    }
}
