package com.bumptech.glide.load.resource.transcode;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bytes.BytesResource;
import java.io.ByteArrayOutputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class BitmapBytesTranscoder implements ResourceTranscoder<Bitmap, byte[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bitmap.CompressFormat f67010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f67011b;

    public BitmapBytesTranscoder() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    public Resource a(Resource resource, Options options) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ((Bitmap) resource.get()).compress(this.f67010a, this.f67011b, byteArrayOutputStream);
        resource.a();
        return new BytesResource(byteArrayOutputStream.toByteArray());
    }

    public BitmapBytesTranscoder(Bitmap.CompressFormat compressFormat, int i3) {
        this.f67010a = compressFormat;
        this.f67011b = i3;
    }
}
