package androidx.work.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.work.multiprocess.IWorkManagerImplCallback;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface IListenableWorkerImpl extends IInterface {
    public static final String p8 = "androidx$work$multiprocess$IListenableWorkerImpl".replace('$', '.');

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Default implements IListenableWorkerImpl {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    void E0(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback);

    void a4(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Stub extends Binder implements IListenableWorkerImpl {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static class Proxy implements IListenableWorkerImpl {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f55271a;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f55271a;
            }
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i4) {
            String str = IListenableWorkerImpl.p8;
            if (i3 >= 1 && i3 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i3 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i3 == 1) {
                E0(parcel.createByteArray(), IWorkManagerImplCallback.Stub.x3(parcel.readStrongBinder()));
            } else {
                if (i3 != 2) {
                    return super.onTransact(i3, parcel, parcel2, i4);
                }
                a4(parcel.createByteArray(), IWorkManagerImplCallback.Stub.x3(parcel.readStrongBinder()));
            }
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
