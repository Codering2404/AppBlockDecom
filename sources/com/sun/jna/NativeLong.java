package com.sun.jna;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class NativeLong extends IntegerType {
    public static final int SIZE = Native.LONG_SIZE;
    private static final long serialVersionUID = 1;

    public NativeLong() {
        this(0L);
    }

    public NativeLong(long j3) {
        this(j3, false);
    }

    public NativeLong(long j3, boolean z2) {
        super(SIZE, j3, z2);
    }
}
