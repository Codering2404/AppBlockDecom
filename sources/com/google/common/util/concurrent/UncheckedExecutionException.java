package com.google.common.util.concurrent;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public class UncheckedExecutionException extends RuntimeException {
    private static final long serialVersionUID = 0;

    @Deprecated
    protected UncheckedExecutionException() {
    }

    public UncheckedExecutionException(Throwable th) {
        super(th);
    }
}
