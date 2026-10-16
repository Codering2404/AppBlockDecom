package org.commonmark.internal;

import org.commonmark.parser.block.BlockParser;
import org.commonmark.parser.block.BlockStart;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class BlockStartImpl extends BlockStart {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BlockParser[] f145369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f145370b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f145371c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f145372d = false;

    public BlockStartImpl(BlockParser... blockParserArr) {
        this.f145369a = blockParserArr;
    }

    @Override // org.commonmark.parser.block.BlockStart
    public BlockStart a(int i3) {
        this.f145371c = i3;
        return this;
    }

    @Override // org.commonmark.parser.block.BlockStart
    public BlockStart b(int i3) {
        this.f145370b = i3;
        return this;
    }

    @Override // org.commonmark.parser.block.BlockStart
    public BlockStart e() {
        this.f145372d = true;
        return this;
    }

    public BlockParser[] f() {
        return this.f145369a;
    }

    public int g() {
        return this.f145371c;
    }

    public int h() {
        return this.f145370b;
    }

    public boolean i() {
        return this.f145372d;
    }
}
