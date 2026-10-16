package android.support.customtabs;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public interface IEngagementSignalsCallback extends IInterface {
    public static final String R7 = "android$support$customtabs$IEngagementSignalsCallback".replace('$', '.');

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static Object c(Parcel parcel, Parcelable.Creator creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void d(Parcel parcel, Parcelable parcelable, int i3) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcelable.writeToParcel(parcel, i3);
            }
        }
    }

    void A(int i3, Bundle bundle);

    void u(boolean z2, Bundle bundle);

    void x(boolean z2, Bundle bundle);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Stub extends Binder implements IEngagementSignalsCallback {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static class Proxy implements IEngagementSignalsCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f83a;

            Proxy(IBinder iBinder) {
                this.f83a = iBinder;
            }

            @Override // android.support.customtabs.IEngagementSignalsCallback
            public void A(int i3, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IEngagementSignalsCallback.R7);
                    parcelObtain.writeInt(i3);
                    _Parcel.d(parcelObtain, bundle, 0);
                    this.f83a.transact(3, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f83a;
            }

            @Override // android.support.customtabs.IEngagementSignalsCallback
            public void u(boolean z2, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IEngagementSignalsCallback.R7);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    _Parcel.d(parcelObtain, bundle, 0);
                    this.f83a.transact(4, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.IEngagementSignalsCallback
            public void x(boolean z2, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IEngagementSignalsCallback.R7);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    _Parcel.d(parcelObtain, bundle, 0);
                    this.f83a.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public static IEngagementSignalsCallback x3(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IEngagementSignalsCallback.R7);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IEngagementSignalsCallback)) ? new Proxy(iBinder) : (IEngagementSignalsCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i4) {
            String str = IEngagementSignalsCallback.R7;
            if (i3 >= 1 && i3 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i3 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i3 == 2) {
                x(parcel.readInt() != 0, (Bundle) _Parcel.c(parcel, Bundle.CREATOR));
            } else if (i3 == 3) {
                A(parcel.readInt(), (Bundle) _Parcel.c(parcel, Bundle.CREATOR));
            } else {
                if (i3 != 4) {
                    return super.onTransact(i3, parcel, parcel2, i4);
                }
                u(parcel.readInt() != 0, (Bundle) _Parcel.c(parcel, Bundle.CREATOR));
            }
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Default implements IEngagementSignalsCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.support.customtabs.IEngagementSignalsCallback
        public void A(int i3, Bundle bundle) {
        }

        @Override // android.support.customtabs.IEngagementSignalsCallback
        public void u(boolean z2, Bundle bundle) {
        }

        @Override // android.support.customtabs.IEngagementSignalsCallback
        public void x(boolean z2, Bundle bundle) {
        }
    }
}
