package com.bumptech.glide.load.engine;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class CallbackException extends RuntimeException {
    private static final long serialVersionUID = -7530898992688511851L;

    CallbackException(Throwable th) {
        super("Unexpected exception thrown by non-Glide code", th);
    }
}
