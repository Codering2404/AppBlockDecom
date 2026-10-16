package androidx.core.os;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class ParcelableCompat {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ParcelableCompatCreatorHoneycombMR2<T> implements Parcelable.ClassLoaderCreator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ParcelableCompatCreatorCallbacks f34164a;

        @Override // android.os.Parcelable.Creator
        public Object createFromParcel(Parcel parcel) {
            return this.f34164a.createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public Object[] newArray(int i3) {
            return this.f34164a.newArray(i3);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return this.f34164a.createFromParcel(parcel, classLoader);
        }
    }
}
