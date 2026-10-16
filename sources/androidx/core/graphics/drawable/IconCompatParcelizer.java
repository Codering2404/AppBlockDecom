package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class IconCompatParcelizer {
    public static IconCompat read(VersionedParcel versionedParcel) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f34017a = versionedParcel.p(iconCompat.f34017a, 1);
        iconCompat.f34019c = versionedParcel.j(iconCompat.f34019c, 2);
        iconCompat.f34020d = versionedParcel.r(iconCompat.f34020d, 3);
        iconCompat.f34021e = versionedParcel.p(iconCompat.f34021e, 4);
        iconCompat.f34022f = versionedParcel.p(iconCompat.f34022f, 5);
        iconCompat.f34023g = (ColorStateList) versionedParcel.r(iconCompat.f34023g, 6);
        iconCompat.f34025i = versionedParcel.t(iconCompat.f34025i, 7);
        iconCompat.f34026j = versionedParcel.t(iconCompat.f34026j, 8);
        iconCompat.l();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, VersionedParcel versionedParcel) {
        versionedParcel.x(true, true);
        iconCompat.m(versionedParcel.f());
        int i3 = iconCompat.f34017a;
        if (-1 != i3) {
            versionedParcel.F(i3, 1);
        }
        byte[] bArr = iconCompat.f34019c;
        if (bArr != null) {
            versionedParcel.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f34020d;
        if (parcelable != null) {
            versionedParcel.H(parcelable, 3);
        }
        int i4 = iconCompat.f34021e;
        if (i4 != 0) {
            versionedParcel.F(i4, 4);
        }
        int i5 = iconCompat.f34022f;
        if (i5 != 0) {
            versionedParcel.F(i5, 5);
        }
        ColorStateList colorStateList = iconCompat.f34023g;
        if (colorStateList != null) {
            versionedParcel.H(colorStateList, 6);
        }
        String str = iconCompat.f34025i;
        if (str != null) {
            versionedParcel.J(str, 7);
        }
        String str2 = iconCompat.f34026j;
        if (str2 != null) {
            versionedParcel.J(str2, 8);
        }
    }
}
