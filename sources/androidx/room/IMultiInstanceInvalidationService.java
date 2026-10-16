package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.room.IMultiInstanceInvalidationCallback;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface IMultiInstanceInvalidationService extends IInterface {
    public static final String o8 = "androidx$room$IMultiInstanceInvalidationService".replace('$', '.');

    int W2(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, String str);

    void Y1(int i3, String[] strArr);

    void d5(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int i3);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Stub extends Binder implements IMultiInstanceInvalidationService {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static class Proxy implements IMultiInstanceInvalidationService {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f52165a;

            Proxy(IBinder iBinder) {
                this.f52165a = iBinder;
            }

            @Override // androidx.room.IMultiInstanceInvalidationService
            public int W2(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMultiInstanceInvalidationService.o8);
                    parcelObtain.writeStrongInterface(iMultiInstanceInvalidationCallback);
                    parcelObtain.writeString(str);
                    this.f52165a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.room.IMultiInstanceInvalidationService
            public void Y1(int i3, String[] strArr) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMultiInstanceInvalidationService.o8);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeStringArray(strArr);
                    this.f52165a.transact(3, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f52165a;
            }

            @Override // androidx.room.IMultiInstanceInvalidationService
            public void d5(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int i3) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMultiInstanceInvalidationService.o8);
                    parcelObtain.writeStrongInterface(iMultiInstanceInvalidationCallback);
                    parcelObtain.writeInt(i3);
                    this.f52165a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IMultiInstanceInvalidationService.o8);
        }

        public static IMultiInstanceInvalidationService x3(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IMultiInstanceInvalidationService.o8);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IMultiInstanceInvalidationService)) ? new Proxy(iBinder) : (IMultiInstanceInvalidationService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i4) {
            String str = IMultiInstanceInvalidationService.o8;
            if (i3 >= 1 && i3 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i3 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i3 == 1) {
                int iW2 = W2(IMultiInstanceInvalidationCallback.Stub.x3(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(iW2);
            } else if (i3 == 2) {
                d5(IMultiInstanceInvalidationCallback.Stub.x3(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
            } else {
                if (i3 != 3) {
                    return super.onTransact(i3, parcel, parcel2, i4);
                }
                Y1(parcel.readInt(), parcel.createStringArray());
            }
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Default implements IMultiInstanceInvalidationService {
        @Override // androidx.room.IMultiInstanceInvalidationService
        public int W2(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, String str) {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public void Y1(int i3, String[] strArr) {
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public void d5(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int i3) {
        }
    }
}
