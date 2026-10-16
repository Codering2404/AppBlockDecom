package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class ConsumingQueueIterator<T> extends AbstractIterator<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Queue f83869c;

    ConsumingQueueIterator(Queue queue) {
        this.f83869c = (Queue) Preconditions.t(queue);
    }

    @Override // com.google.common.collect.AbstractIterator
    protected Object a() {
        return this.f83869c.isEmpty() ? b() : this.f83869c.remove();
    }
}
