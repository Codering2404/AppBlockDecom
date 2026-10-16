package kotlin.io;

import com.facebook.internal.Utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: Access modifiers changed from: package-private */
/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public class FilesKt__FileReadWriteKt extends FilesKt__FilePathComponentsKt {
    public static final ByteBuffer c(int i3, CharsetEncoder encoder) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i3 * ((int) Math.ceil(encoder.maxBytesPerChar())));
        Intrinsics.checkNotNullExpressionValue(byteBufferAllocate, "allocate(...)");
        return byteBufferAllocate;
    }

    public static final CharsetEncoder d(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "<this>");
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
        return charsetEncoderNewEncoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction);
    }

    public static byte[] e(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new OutOfMemoryError("File " + file + " is too big (" + length + " bytes) to fit in memory.");
            }
            int i3 = (int) length;
            byte[] bArrCopyInto = new byte[i3];
            int i4 = i3;
            int i5 = 0;
            while (i4 > 0) {
                int i6 = fileInputStream.read(bArrCopyInto, i5, i4);
                if (i6 < 0) {
                    break;
                }
                i4 -= i6;
                i5 += i6;
            }
            if (i4 > 0) {
                bArrCopyInto = Arrays.copyOf(bArrCopyInto, i5);
                Intrinsics.checkNotNullExpressionValue(bArrCopyInto, "copyOf(...)");
            } else {
                int i7 = fileInputStream.read();
                if (i7 != -1) {
                    ExposingBufferByteArrayOutputStream exposingBufferByteArrayOutputStream = new ExposingBufferByteArrayOutputStream(8193);
                    exposingBufferByteArrayOutputStream.write(i7);
                    ByteStreamsKt.b(fileInputStream, exposingBufferByteArrayOutputStream, 0, 2, null);
                    int size = exposingBufferByteArrayOutputStream.size() + i3;
                    if (size < 0) {
                        throw new OutOfMemoryError("File " + file + " is too big to fit in memory.");
                    }
                    byte[] bArrA = exposingBufferByteArrayOutputStream.a();
                    byte[] bArrCopyOf = Arrays.copyOf(bArrCopyInto, size);
                    Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
                    bArrCopyInto = ArraysKt.copyInto(bArrA, bArrCopyOf, i3, 0, exposingBufferByteArrayOutputStream.size());
                }
            }
            CloseableKt.a(fileInputStream, null);
            return bArrCopyInto;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.a(fileInputStream, th);
                throw th2;
            }
        }
    }

    public static String f(File file, Charset charset) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        try {
            String strH = TextStreamsKt.h(inputStreamReader);
            CloseableKt.a(inputStreamReader, null);
            return strH;
        } finally {
        }
    }

    public static /* synthetic */ String g(File file, Charset charset, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charset = Charsets.f140510b;
        }
        return f(file, charset);
    }

    public static void h(File file, byte[] array) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(array, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(array);
            Unit unit = Unit.f139807a;
            CloseableKt.a(fileOutputStream, null);
        } finally {
        }
    }

    public static void i(File file, String text, Charset charset) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            k(fileOutputStream, text, charset);
            Unit unit = Unit.f139807a;
            CloseableKt.a(fileOutputStream, null);
        } finally {
        }
    }

    public static /* synthetic */ void j(File file, String str, Charset charset, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            charset = Charsets.f140510b;
        }
        i(file, str, charset);
    }

    public static final void k(OutputStream outputStream, String text, Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter(outputStream, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (text.length() < 16384) {
            byte[] bytes = text.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            outputStream.write(bytes);
            return;
        }
        CharsetEncoder charsetEncoderD = d(charset);
        CharBuffer charBufferAllocate = CharBuffer.allocate(Utility.DEFAULT_STREAM_BUFFER_SIZE);
        Intrinsics.checkNotNull(charsetEncoderD);
        ByteBuffer byteBufferC = c(Utility.DEFAULT_STREAM_BUFFER_SIZE, charsetEncoderD);
        int i3 = 0;
        int i4 = 0;
        while (i3 < text.length()) {
            int iMin = Math.min(8192 - i4, text.length() - i3);
            int i5 = i3 + iMin;
            char[] cArrArray = charBufferAllocate.array();
            Intrinsics.checkNotNullExpressionValue(cArrArray, "array(...)");
            text.getChars(i3, i5, cArrArray, i4);
            charBufferAllocate.limit(iMin + i4);
            i4 = 1;
            if (!charsetEncoderD.encode(charBufferAllocate, byteBufferC, i5 == text.length()).isUnderflow()) {
                throw new IllegalStateException("Check failed.");
            }
            outputStream.write(byteBufferC.array(), 0, byteBufferC.position());
            if (charBufferAllocate.position() != charBufferAllocate.limit()) {
                charBufferAllocate.put(0, charBufferAllocate.get());
            } else {
                i4 = 0;
            }
            charBufferAllocate.clear();
            byteBufferC.clear();
            i3 = i5;
        }
    }
}
