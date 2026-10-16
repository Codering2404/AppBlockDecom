package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface IMultiInstanceInvalidationCallback extends IInterface {
    public static final String n8 = "androidx$room$IMultiInstanceInvalidationCallback".replace('$', '.');

    void g0(String[] strArr);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Stub extends Binder implements IMultiInstanceInvalidationCallback {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static class Proxy implements IMultiInstanceInvalidationCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f52164a;

            Proxy(IBinder iBinder) {
                this.f52164a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f52164a;
            }

            @Override // androidx.room.IMultiInstanceInvalidationCallback
            public void g0(String[] strArr) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMultiInstanceInvalidationCallback.n8);
                    parcelObtain.writeStringArray(strArr);
                    this.f52164a.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IMultiInstanceInvalidationCallback.n8);
        }

        public static IMultiInstanceInvalidationCallback x3(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IMultiInstanceInvalidationCallback.n8);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IMultiInstanceInvalidationCallback)) ? new Proxy(iBinder) : (IMultiInstanceInvalidationCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i4) {
            String str = IMultiInstanceInvalidationCallback.n8;
            if (i3 >= 1 && i3 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i3 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i3 != 1) {
                return super.onTransact(i3, parcel, parcel2, i4);
            }
            g0(parcel.createStringArray());
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Default implements IMultiInstanceInvalidationCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // androidx.room.IMultiInstanceInvalidationCallback
        public void g0(String[] strArr) {
        }
    }
}
