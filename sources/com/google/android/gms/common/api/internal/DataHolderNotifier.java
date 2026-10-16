package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class DataHolderNotifier<L> implements ListenerHolder.Notifier<L> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DataHolder f71558a;

    protected abstract void a(Object obj, DataHolder dataHolder);

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void notifyListener(Object obj) {
        a(obj, this.f71558a);
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public void onNotifyListenerFailed() {
        DataHolder dataHolder = this.f71558a;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }
}
