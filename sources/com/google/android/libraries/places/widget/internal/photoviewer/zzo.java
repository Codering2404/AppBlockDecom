package com.google.android.libraries.places.widget.internal.photoviewer;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzo implements Parcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new zzn();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f79121a;

    public zzo(List photoPageData) {
        Intrinsics.checkNotNullParameter(photoPageData, "photoPageData");
        this.f79121a = photoPageData;
    }

    public final List c() {
        return this.f79121a;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof zzo) && Intrinsics.areEqual(this.f79121a, ((zzo) obj).f79121a);
    }

    public final int hashCode() {
        return this.f79121a.hashCode();
    }

    public final String toString() {
        List list = this.f79121a;
        StringBuilder sb = new StringBuilder(list.toString().length() + 43);
        sb.append("ParcelablePhotoPageDataList(photoPageData=");
        sb.append(list);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i3) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        List list = this.f79121a;
        dest.writeInt(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((zzd) it.next()).writeToParcel(dest, i3);
        }
    }
}
