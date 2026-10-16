package androidx.core.app.unusedapprestrictions;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface IUnusedAppRestrictionsBackportCallback extends IInterface {
    public static final String j8 = "androidx$core$app$unusedapprestrictions$IUnusedAppRestrictionsBackportCallback".replace('$', '.');

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Default implements IUnusedAppRestrictionsBackportCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    void P1(boolean z2, boolean z3);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Stub extends Binder implements IUnusedAppRestrictionsBackportCallback {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static class Proxy implements IUnusedAppRestrictionsBackportCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f33821a;

            Proxy(IBinder iBinder) {
                this.f33821a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f33821a;
            }
        }

        public Stub() {
            attachInterface(this, IUnusedAppRestrictionsBackportCallback.j8);
        }

        public static IUnusedAppRestrictionsBackportCallback x3(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IUnusedAppRestrictionsBackportCallback.j8);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IUnusedAppRestrictionsBackportCallback)) ? new Proxy(iBinder) : (IUnusedAppRestrictionsBackportCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i4) {
            String str = IUnusedAppRestrictionsBackportCallback.j8;
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
            P1(parcel.readInt() != 0, parcel.readInt() != 0);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
