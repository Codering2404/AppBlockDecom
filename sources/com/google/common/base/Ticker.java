package com.google.common.base;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class Ticker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Ticker f83428a = new Ticker() { // from class: com.google.common.base.Ticker.1
        @Override // com.google.common.base.Ticker
        public long a() {
            return System.nanoTime();
        }
    };

    protected Ticker() {
    }

    public static Ticker b() {
        return f83428a;
    }

    public abstract long a();
}
