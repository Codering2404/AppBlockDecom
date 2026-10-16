package com.applovin.impl;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.applovin.impl.db;
import com.facebook.internal.NativeProtocol;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class m2 extends Binder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f61330a;

    static {
        f61330a = xp.f65027a >= 30 ? IBinder.getSuggestedMaxIpcSizeBytes() : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
    }

    public static db a(IBinder iBinder) {
        int i3;
        db.a aVarF = db.f();
        int i4 = 0;
        int i5 = 1;
        while (i5 != 0) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInt(i4);
                try {
                    iBinder.transact(1, parcelObtain, parcelObtain2, 0);
                    while (true) {
                        i3 = parcelObtain2.readInt();
                        if (i3 == 1) {
                            aVarF.b((Bundle) b1.a(parcelObtain2.readBundle()));
                            i4++;
                        }
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    i5 = i3;
                } catch (RemoteException e3) {
                    throw new RuntimeException(e3);
                }
            } catch (Throwable th) {
                parcelObtain2.recycle();
                parcelObtain.recycle();
                throw th;
            }
        }
        return aVarF.a();
    }
}
