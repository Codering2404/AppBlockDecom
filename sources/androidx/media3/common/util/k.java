package androidx.media3.common.util;

import android.content.Context;
import androidx.media3.common.util.NetworkTypeObserver;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NetworkTypeObserver.Receiver f41639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f41640b;

    public /* synthetic */ k(NetworkTypeObserver.Receiver receiver, Context context) {
        this.f41639a = receiver;
        this.f41640b = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        NetworkTypeObserver.this.i(this.f41640b);
    }
}
