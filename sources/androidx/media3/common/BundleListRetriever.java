package androidx.media3.common;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import androidx.media3.common.util.Util;
import com.facebook.internal.NativeProtocol;
import com.google.common.collect.ImmutableList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class BundleListRetriever extends Binder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f40539b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImmutableList f40540a;

    static {
        f40539b = Util.f41609a >= 30 ? IBinder.getSuggestedMaxIpcSizeBytes() : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Binder
    protected boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i4) {
        if (i3 != 1) {
            return super.onTransact(i3, parcel, parcel2, i4);
        }
        if (parcel2 == null) {
            return false;
        }
        int size = this.f40540a.size();
        int i5 = parcel.readInt();
        while (i5 < size && parcel2.dataSize() < f40539b) {
            parcel2.writeInt(1);
            parcel2.writeBundle((Bundle) this.f40540a.get(i5));
            i5++;
        }
        parcel2.writeInt(i5 < size ? 2 : 0);
        return true;
    }
}
