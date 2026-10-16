package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.data.InputStreamRewinder;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.ByteBufferUtil;
import com.bumptech.glide.util.Preconditions;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
interface ImageReader {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class InputStreamImageReader implements ImageReader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InputStreamRewinder f66893a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayPool f66894b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List f66895c;

        InputStreamImageReader(InputStream inputStream, List list, ArrayPool arrayPool) {
            this.f66894b = (ArrayPool) Preconditions.e(arrayPool);
            this.f66895c = (List) Preconditions.e(list);
            this.f66893a = new InputStreamRewinder(inputStream, arrayPool);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public Bitmap a(BitmapFactory.Options options) {
            return GlideBitmapFactory.c(this.f66893a.a(), options, this);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public boolean b() {
            return ImageHeaderParserUtils.j(this.f66895c, this.f66893a.a(), this.f66894b);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public void c() {
            this.f66893a.c();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public int d() {
            return ImageHeaderParserUtils.b(this.f66895c, this.f66893a.a(), this.f66894b);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public ImageHeaderParser.ImageType e() {
            return ImageHeaderParserUtils.f(this.f66895c, this.f66893a.a(), this.f66894b);
        }
    }

    Bitmap a(BitmapFactory.Options options);

    boolean b();

    void c();

    int d();

    ImageHeaderParser.ImageType e();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class ByteArrayReader implements ImageReader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final byte[] f66884a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f66885b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ArrayPool f66886c;

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public Bitmap a(BitmapFactory.Options options) {
            return GlideBitmapFactory.a(this.f66884a, options, this);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public boolean b() {
            return ImageHeaderParserUtils.k(this.f66885b, ByteBuffer.wrap(this.f66884a), this.f66886c);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public int d() {
            return ImageHeaderParserUtils.c(this.f66885b, ByteBuffer.wrap(this.f66884a), this.f66886c);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public ImageHeaderParser.ImageType e() {
            return ImageHeaderParserUtils.g(this.f66885b, ByteBuffer.wrap(this.f66884a));
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public void c() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class ByteBufferReader implements ImageReader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ByteBuffer f66887a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f66888b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ArrayPool f66889c;

        ByteBufferReader(ByteBuffer byteBuffer, List list, ArrayPool arrayPool) {
            this.f66887a = byteBuffer;
            this.f66888b = list;
            this.f66889c = arrayPool;
        }

        private InputStream f() {
            return ByteBufferUtil.g(ByteBufferUtil.d(this.f66887a));
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public Bitmap a(BitmapFactory.Options options) {
            return GlideBitmapFactory.c(f(), options, this);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public boolean b() {
            return ImageHeaderParserUtils.k(this.f66888b, ByteBufferUtil.d(this.f66887a), this.f66889c);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public int d() {
            return ImageHeaderParserUtils.c(this.f66888b, ByteBufferUtil.d(this.f66887a), this.f66889c);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public ImageHeaderParser.ImageType e() {
            return ImageHeaderParserUtils.g(this.f66888b, ByteBufferUtil.d(this.f66887a));
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public void c() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class FileReader implements ImageReader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final File f66890a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f66891b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ArrayPool f66892c;

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public Bitmap a(BitmapFactory.Options options) throws Throwable {
            RecyclableBufferedInputStream recyclableBufferedInputStream = null;
            try {
                RecyclableBufferedInputStream recyclableBufferedInputStream2 = new RecyclableBufferedInputStream(new FileInputStream(this.f66890a), this.f66892c);
                try {
                    Bitmap bitmapC = GlideBitmapFactory.c(recyclableBufferedInputStream2, options, this);
                    try {
                        recyclableBufferedInputStream2.close();
                    } catch (IOException unused) {
                    }
                    return bitmapC;
                } catch (Throwable th) {
                    th = th;
                    recyclableBufferedInputStream = recyclableBufferedInputStream2;
                    if (recyclableBufferedInputStream != null) {
                        try {
                            recyclableBufferedInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public boolean b() throws Throwable {
            FileInputStream fileInputStream;
            Throwable th;
            try {
                fileInputStream = new FileInputStream(this.f66890a);
                try {
                    boolean zJ = ImageHeaderParserUtils.j(this.f66891b, fileInputStream, this.f66892c);
                    try {
                        fileInputStream.close();
                    } catch (IOException unused) {
                    }
                    return zJ;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                fileInputStream = null;
                th = th3;
            }
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public int d() throws Throwable {
            RecyclableBufferedInputStream recyclableBufferedInputStream;
            Throwable th;
            try {
                recyclableBufferedInputStream = new RecyclableBufferedInputStream(new FileInputStream(this.f66890a), this.f66892c);
                try {
                    int iB = ImageHeaderParserUtils.b(this.f66891b, recyclableBufferedInputStream, this.f66892c);
                    try {
                        recyclableBufferedInputStream.close();
                    } catch (IOException unused) {
                    }
                    return iB;
                } catch (Throwable th2) {
                    th = th2;
                    if (recyclableBufferedInputStream != null) {
                        try {
                            recyclableBufferedInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                recyclableBufferedInputStream = null;
                th = th3;
            }
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public ImageHeaderParser.ImageType e() throws Throwable {
            RecyclableBufferedInputStream recyclableBufferedInputStream;
            Throwable th;
            try {
                recyclableBufferedInputStream = new RecyclableBufferedInputStream(new FileInputStream(this.f66890a), this.f66892c);
                try {
                    ImageHeaderParser.ImageType imageTypeF = ImageHeaderParserUtils.f(this.f66891b, recyclableBufferedInputStream, this.f66892c);
                    try {
                        recyclableBufferedInputStream.close();
                    } catch (IOException unused) {
                    }
                    return imageTypeF;
                } catch (Throwable th2) {
                    th = th2;
                    if (recyclableBufferedInputStream != null) {
                        try {
                            recyclableBufferedInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                recyclableBufferedInputStream = null;
                th = th3;
            }
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public void c() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class ParcelFileDescriptorImageReader implements ImageReader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ArrayPool f66896a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f66897b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ParcelFileDescriptorRewinder f66898c;

        ParcelFileDescriptorImageReader(ParcelFileDescriptor parcelFileDescriptor, List list, ArrayPool arrayPool) {
            this.f66896a = (ArrayPool) Preconditions.e(arrayPool);
            this.f66897b = (List) Preconditions.e(list);
            this.f66898c = new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public Bitmap a(BitmapFactory.Options options) {
            return GlideBitmapFactory.b(this.f66898c.a().getFileDescriptor(), options, this);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public boolean b() {
            return ImageHeaderParserUtils.i(this.f66897b, this.f66898c, this.f66896a);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public int d() {
            return ImageHeaderParserUtils.a(this.f66897b, this.f66898c, this.f66896a);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public ImageHeaderParser.ImageType e() {
            return ImageHeaderParserUtils.e(this.f66897b, this.f66898c, this.f66896a);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public void c() {
        }
    }
}
