package androidx.work.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface IWorkManagerImplCallback extends IInterface {
    public static final String r8 = "androidx$work$multiprocess$IWorkManagerImplCallback".replace('$', '.');

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Default implements IWorkManagerImplCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    void B4(byte[] bArr);

    void w(String str);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Stub extends Binder implements IWorkManagerImplCallback {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static class Proxy implements IWorkManagerImplCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f55273a;

            Proxy(IBinder iBinder) {
                this.f55273a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f55273a;
            }
        }

        public static IWorkManagerImplCallback x3(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IWorkManagerImplCallback.r8);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IWorkManagerImplCallback)) ? new Proxy(iBinder) : (IWorkManagerImplCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i4) {
            String str = IWorkManagerImplCallback.r8;
            if (i3 >= 1 && i3 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i3 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i3 == 1) {
                B4(parcel.createByteArray());
            } else {
                if (i3 != 2) {
                    return super.onTransact(i3, parcel, parcel2, i4);
                }
                w(parcel.readString());
            }
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
