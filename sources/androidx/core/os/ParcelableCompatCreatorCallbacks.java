package androidx.core.os;

import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public interface ParcelableCompatCreatorCallbacks<T> {
    Object createFromParcel(Parcel parcel, ClassLoader classLoader);

    Object[] newArray(int i3);
}
