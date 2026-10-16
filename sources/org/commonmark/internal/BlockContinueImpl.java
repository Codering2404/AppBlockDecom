package org.commonmark.internal;

import org.commonmark.parser.block.BlockContinue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class BlockContinueImpl extends BlockContinue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f145365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f145366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f145367c;

    public BlockContinueImpl(int i3, int i4, boolean z2) {
        this.f145365a = i3;
        this.f145366b = i4;
        this.f145367c = z2;
    }

    public int e() {
        return this.f145366b;
    }

    public int f() {
        return this.f145365a;
    }

    public boolean g() {
        return this.f145367c;
    }
}
