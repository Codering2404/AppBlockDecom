package com.google.android.libraries.places.widget;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.places.widget.PlaceDetailsCompactFragment;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzi implements Parcelable {
    public static final Parcelable.Creator<zzi> CREATOR = new zzh();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f79447a;

    public zzi(List content) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.f79447a = content;
    }

    public final List c() {
        return this.f79447a;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof zzi) && Intrinsics.areEqual(this.f79447a, ((zzi) obj).f79447a);
    }

    public final int hashCode() {
        return this.f79447a.hashCode();
    }

    public final String toString() {
        List list = this.f79447a;
        StringBuilder sb = new StringBuilder(String.valueOf(list).length() + 31);
        sb.append("ParcelableContentList(content=");
        sb.append(list);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i3) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        List list = this.f79447a;
        dest.writeInt(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            dest.writeString(((PlaceDetailsCompactFragment.Content) it.next()).name());
        }
    }
}
