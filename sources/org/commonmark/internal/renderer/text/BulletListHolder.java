package org.commonmark.internal.renderer.text;

import org.commonmark.node.BulletList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class BulletListHolder extends ListHolder {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final char f145495c;

    public BulletListHolder(ListHolder listHolder, BulletList bulletList) {
        super(listHolder);
        this.f145495c = bulletList.r();
    }

    public char c() {
        return this.f145495c;
    }
}
