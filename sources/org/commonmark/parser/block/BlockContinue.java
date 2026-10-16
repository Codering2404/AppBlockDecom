package org.commonmark.parser.block;

import org.commonmark.internal.BlockContinueImpl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class BlockContinue {
    protected BlockContinue() {
    }

    public static BlockContinue a(int i3) {
        return new BlockContinueImpl(-1, i3, false);
    }

    public static BlockContinue b(int i3) {
        return new BlockContinueImpl(i3, -1, false);
    }

    public static BlockContinue c() {
        return new BlockContinueImpl(-1, -1, true);
    }

    public static BlockContinue d() {
        return null;
    }
}
