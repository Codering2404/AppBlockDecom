package com.google.zxing;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class NotFoundException extends ReaderException {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final NotFoundException f91611c;

    static {
        NotFoundException notFoundException = new NotFoundException();
        f91611c = notFoundException;
        notFoundException.setStackTrace(ReaderException.f91623b);
    }

    private NotFoundException() {
    }

    public static NotFoundException a() {
        return f91611c;
    }
}
