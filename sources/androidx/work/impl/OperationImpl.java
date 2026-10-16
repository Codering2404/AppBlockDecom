package androidx.work.impl;

import androidx.lifecycle.MutableLiveData;
import androidx.work.Operation;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class OperationImpl implements Operation {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableLiveData f54634c = new MutableLiveData();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SettableFuture f54635d = SettableFuture.s();

    public OperationImpl() {
        a(Operation.f54552b);
    }

    public void a(Operation.State state) {
        this.f54634c.n(state);
        if (state instanceof Operation.State.SUCCESS) {
            this.f54635d.o((Operation.State.SUCCESS) state);
        } else if (state instanceof Operation.State.FAILURE) {
            this.f54635d.p(((Operation.State.FAILURE) state).a());
        }
    }

    @Override // androidx.work.Operation
    public ListenableFuture getResult() {
        return this.f54635d;
    }
}
