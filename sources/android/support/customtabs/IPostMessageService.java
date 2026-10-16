package android.support.customtabs;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.customtabs.ICustomTabsCallback;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public interface IPostMessageService extends IInterface {
    public static final String S7 = "android$support$customtabs$IPostMessageService".replace('$', '.');

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

    void F3(ICustomTabsCallback iCustomTabsCallback, String str, Bundle bundle);

    void G0(ICustomTabsCallback iCustomTabsCallback, Bundle bundle);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Stub extends Binder implements IPostMessageService {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static class Proxy implements IPostMessageService {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f84a;

            Proxy(IBinder iBinder) {
                this.f84a = iBinder;
            }

            @Override // android.support.customtabs.IPostMessageService
            public void G0(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IPostMessageService.S7);
                    parcelObtain.writeStrongInterface(iCustomTabsCallback);
                    _Parcel.d(parcelObtain, bundle, 0);
                    this.f84a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f84a;
            }
        }

        public static IPostMessageService x3(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IPostMessageService.S7);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IPostMessageService)) ? new Proxy(iBinder) : (IPostMessageService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i4) {
            String str = IPostMessageService.S7;
            if (i3 >= 1 && i3 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i3 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i3 == 2) {
                G0(ICustomTabsCallback.Stub.x3(parcel.readStrongBinder()), (Bundle) _Parcel.c(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
            } else {
                if (i3 != 3) {
                    return super.onTransact(i3, parcel, parcel2, i4);
                }
                F3(ICustomTabsCallback.Stub.x3(parcel.readStrongBinder()), parcel.readString(), (Bundle) _Parcel.c(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
            }
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Default implements IPostMessageService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.support.customtabs.IPostMessageService
        public void G0(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
        }
    }
}
