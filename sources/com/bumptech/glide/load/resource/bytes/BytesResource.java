package com.bumptech.glide.load.resource.bytes;

import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class BytesResource implements Resource<byte[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f66942a;

    public BytesResource(byte[] bArr) {
        this.f66942a = (byte[]) Preconditions.e(bArr);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Class b() {
        return byte[].class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public byte[] get() {
        return this.f66942a;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return this.f66942a.length;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void a() {
    }
}
