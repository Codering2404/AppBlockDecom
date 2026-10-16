package com.bumptech.glide.load;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ImageHeaderParserUtils {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface JpegMpfReader {
        boolean a(ImageHeaderParser imageHeaderParser);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface OrientationReader {
        int a(ImageHeaderParser imageHeaderParser);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface TypeReader {
        ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser);
    }

    public static int a(List list, final ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, final ArrayPool arrayPool) {
        return d(list, new OrientationReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.6
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.OrientationReader
            public int a(ImageHeaderParser imageHeaderParser) throws Throwable {
                RecyclableBufferedInputStream recyclableBufferedInputStream = null;
                try {
                    RecyclableBufferedInputStream recyclableBufferedInputStream2 = new RecyclableBufferedInputStream(new FileInputStream(parcelFileDescriptorRewinder.a().getFileDescriptor()), arrayPool);
                    try {
                        int iE = imageHeaderParser.e(recyclableBufferedInputStream2, arrayPool);
                        recyclableBufferedInputStream2.c();
                        parcelFileDescriptorRewinder.a();
                        return iE;
                    } catch (Throwable th) {
                        th = th;
                        recyclableBufferedInputStream = recyclableBufferedInputStream2;
                        if (recyclableBufferedInputStream != null) {
                            recyclableBufferedInputStream.c();
                        }
                        parcelFileDescriptorRewinder.a();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        });
    }

    public static int b(List list, final InputStream inputStream, final ArrayPool arrayPool) {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        inputStream.mark(5242880);
        return d(list, new OrientationReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.5
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.OrientationReader
            public int a(ImageHeaderParser imageHeaderParser) throws IOException {
                try {
                    return imageHeaderParser.e(inputStream, arrayPool);
                } finally {
                    inputStream.reset();
                }
            }
        });
    }

    public static int c(List list, final ByteBuffer byteBuffer, final ArrayPool arrayPool) {
        if (byteBuffer == null) {
            return -1;
        }
        return d(list, new OrientationReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.4
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.OrientationReader
            public int a(ImageHeaderParser imageHeaderParser) {
                try {
                    return imageHeaderParser.c(byteBuffer, arrayPool);
                } finally {
                    ByteBufferUtil.d(byteBuffer);
                }
            }
        });
    }

    private static int d(List list, OrientationReader orientationReader) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            int iA = orientationReader.a((ImageHeaderParser) list.get(i3));
            if (iA != -1) {
                return iA;
            }
        }
        return -1;
    }

    public static ImageHeaderParser.ImageType e(List list, final ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, final ArrayPool arrayPool) {
        return h(list, new TypeReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.3
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader
            public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws Throwable {
                RecyclableBufferedInputStream recyclableBufferedInputStream = null;
                try {
                    RecyclableBufferedInputStream recyclableBufferedInputStream2 = new RecyclableBufferedInputStream(new FileInputStream(parcelFileDescriptorRewinder.a().getFileDescriptor()), arrayPool);
                    try {
                        ImageHeaderParser.ImageType imageTypeD = imageHeaderParser.d(recyclableBufferedInputStream2);
                        recyclableBufferedInputStream2.c();
                        parcelFileDescriptorRewinder.a();
                        return imageTypeD;
                    } catch (Throwable th) {
                        th = th;
                        recyclableBufferedInputStream = recyclableBufferedInputStream2;
                        if (recyclableBufferedInputStream != null) {
                            recyclableBufferedInputStream.c();
                        }
                        parcelFileDescriptorRewinder.a();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        });
    }

    public static ImageHeaderParser.ImageType f(List list, final InputStream inputStream, ArrayPool arrayPool) {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        inputStream.mark(5242880);
        return h(list, new TypeReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.1
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader
            public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException {
                try {
                    return imageHeaderParser.d(inputStream);
                } finally {
                    inputStream.reset();
                }
            }
        });
    }

    public static ImageHeaderParser.ImageType g(List list, final ByteBuffer byteBuffer) {
        return byteBuffer == null ? ImageHeaderParser.ImageType.UNKNOWN : h(list, new TypeReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.2
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader
            public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) {
                try {
                    return imageHeaderParser.a(byteBuffer);
                } finally {
                    ByteBufferUtil.d(byteBuffer);
                }
            }
        });
    }

    private static ImageHeaderParser.ImageType h(List list, TypeReader typeReader) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            ImageHeaderParser.ImageType imageTypeA = typeReader.a((ImageHeaderParser) list.get(i3));
            if (imageTypeA != ImageHeaderParser.ImageType.UNKNOWN) {
                return imageTypeA;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    public static boolean i(List list, final ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, final ArrayPool arrayPool) {
        return l(list, new JpegMpfReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.9
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.JpegMpfReader
            public boolean a(ImageHeaderParser imageHeaderParser) throws Throwable {
                RecyclableBufferedInputStream recyclableBufferedInputStream = null;
                try {
                    RecyclableBufferedInputStream recyclableBufferedInputStream2 = new RecyclableBufferedInputStream(new FileInputStream(parcelFileDescriptorRewinder.a().getFileDescriptor()), arrayPool);
                    try {
                        boolean zF = imageHeaderParser.f(recyclableBufferedInputStream2, arrayPool);
                        recyclableBufferedInputStream2.c();
                        parcelFileDescriptorRewinder.a();
                        return zF;
                    } catch (Throwable th) {
                        th = th;
                        recyclableBufferedInputStream = recyclableBufferedInputStream2;
                        if (recyclableBufferedInputStream != null) {
                            recyclableBufferedInputStream.c();
                        }
                        parcelFileDescriptorRewinder.a();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        });
    }

    public static boolean j(List list, final InputStream inputStream, final ArrayPool arrayPool) {
        if (inputStream == null) {
            return false;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        inputStream.mark(5242880);
        return l(list, new JpegMpfReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.8
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.JpegMpfReader
            public boolean a(ImageHeaderParser imageHeaderParser) throws IOException {
                try {
                    return imageHeaderParser.f(inputStream, arrayPool);
                } finally {
                    inputStream.reset();
                }
            }
        });
    }

    public static boolean k(List list, final ByteBuffer byteBuffer, final ArrayPool arrayPool) {
        if (byteBuffer == null) {
            return false;
        }
        return l(list, new JpegMpfReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.7
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.JpegMpfReader
            public boolean a(ImageHeaderParser imageHeaderParser) {
                try {
                    return imageHeaderParser.b(byteBuffer, arrayPool);
                } finally {
                    ByteBufferUtil.d(byteBuffer);
                }
            }
        });
    }

    private static boolean l(List list, JpegMpfReader jpegMpfReader) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (jpegMpfReader.a((ImageHeaderParser) list.get(i3))) {
                return true;
            }
        }
        return false;
    }
}
