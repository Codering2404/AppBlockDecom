package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.os.IResultReceiver;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new Parcelable.Creator<ResultReceiver>() { // from class: android.support.v4.os.ResultReceiver.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ResultReceiver createFromParcel(Parcel parcel) {
            return new ResultReceiver(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ResultReceiver[] newArray(int i3) {
            return new ResultReceiver[i3];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f320a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Handler f321b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    IResultReceiver f322c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class MyResultReceiver extends IResultReceiver.Stub {
        MyResultReceiver() {
        }

        @Override // android.support.v4.os.IResultReceiver
        public void l(int i3, Bundle bundle) {
            ResultReceiver resultReceiver = ResultReceiver.this;
            Handler handler = resultReceiver.f321b;
            if (handler != null) {
                handler.post(resultReceiver.new MyRunnable(i3, bundle));
            } else {
                resultReceiver.a(i3, bundle);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class MyRunnable implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f324a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Bundle f325b;

        MyRunnable(int i3, Bundle bundle) {
            this.f324a = i3;
            this.f325b = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            ResultReceiver.this.a(this.f324a, this.f325b);
        }
    }

    ResultReceiver(Parcel parcel) {
        this.f322c = IResultReceiver.Stub.x3(parcel.readStrongBinder());
    }

    public void c(int i3, Bundle bundle) {
        if (this.f320a) {
            Handler handler = this.f321b;
            if (handler != null) {
                handler.post(new MyRunnable(i3, bundle));
                return;
            } else {
                a(i3, bundle);
                return;
            }
        }
        IResultReceiver iResultReceiver = this.f322c;
        if (iResultReceiver != null) {
            try {
                iResultReceiver.l(i3, bundle);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        synchronized (this) {
            try {
                if (this.f322c == null) {
                    this.f322c = new MyResultReceiver();
                }
                parcel.writeStrongBinder(this.f322c.asBinder());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected void a(int i3, Bundle bundle) {
    }
}
