package com.bumptech.glide.load.engine.bitmap_recycle;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ByteArrayAdapter implements ArrayAdapterInterface<byte[]> {
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    public int a() {
        return 1;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    public String c() {
        return "ByteArrayPool";
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public int b(byte[] bArr) {
        return bArr.length;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public byte[] newArray(int i3) {
        return new byte[i3];
    }
}
