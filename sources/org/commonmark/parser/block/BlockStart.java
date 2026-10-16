package org.commonmark.parser.block;

import org.commonmark.internal.BlockStartImpl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class BlockStart {
    protected BlockStart() {
    }

    public static BlockStart c() {
        return null;
    }

    public static BlockStart d(BlockParser... blockParserArr) {
        return new BlockStartImpl(blockParserArr);
    }

    public abstract BlockStart a(int i3);

    public abstract BlockStart b(int i3);

    public abstract BlockStart e();
}
