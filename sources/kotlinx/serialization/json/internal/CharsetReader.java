package kotlinx.serialization.json.internal;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class CharsetReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InputStream f143067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CharsetDecoder f143068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ByteBuffer f143069c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f143070d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private char f143071e;

    private final int a(char[] cArr, int i3, int i4) throws CharacterCodingException {
        CharBuffer charBufferWrap = CharBuffer.wrap(cArr, i3, i4);
        if (charBufferWrap.position() != 0) {
            charBufferWrap = charBufferWrap.slice();
        }
        boolean z2 = false;
        while (true) {
            CoderResult coderResultDecode = this.f143068b.decode(this.f143069c, charBufferWrap, z2);
            if (coderResultDecode.isUnderflow()) {
                if (!z2 && charBufferWrap.hasRemaining()) {
                    if (b() < 0) {
                        if (charBufferWrap.position() == 0 && !this.f143069c.hasRemaining()) {
                            z2 = true;
                            break;
                        }
                        this.f143068b.reset();
                        z2 = true;
                    } else {
                        continue;
                    }
                } else {
                    break;
                }
            } else {
                if (coderResultDecode.isOverflow()) {
                    charBufferWrap.position();
                    break;
                }
                coderResultDecode.throwException();
            }
        }
        if (z2) {
            this.f143068b.reset();
        }
        if (charBufferWrap.position() == 0) {
            return -1;
        }
        return charBufferWrap.position();
    }

    private final int b() {
        this.f143069c.compact();
        try {
            int iLimit = this.f143069c.limit();
            int iPosition = this.f143069c.position();
            int i3 = this.f143067a.read(this.f143069c.array(), this.f143069c.arrayOffset() + iPosition, iPosition <= iLimit ? iLimit - iPosition : 0);
            if (i3 < 0) {
                return i3;
            }
            ByteBuffer byteBuffer = this.f143069c;
            Intrinsics.checkNotNull(byteBuffer, "null cannot be cast to non-null type java.nio.Buffer");
            byteBuffer.position(iPosition + i3);
            this.f143069c.flip();
            return this.f143069c.remaining();
        } finally {
            this.f143069c.flip();
        }
    }

    private final int c() {
        if (this.f143070d) {
            this.f143070d = false;
            return this.f143071e;
        }
        char[] cArr = new char[2];
        int iD = d(cArr, 0, 2);
        if (iD == -1) {
            return -1;
        }
        if (iD == 1) {
            return cArr[0];
        }
        if (iD == 2) {
            this.f143071e = cArr[1];
            this.f143070d = true;
            return cArr[0];
        }
        throw new IllegalStateException(("Unreachable state: " + iD).toString());
    }

    public final int d(char[] array, int i3, int i4) {
        Intrinsics.checkNotNullParameter(array, "array");
        int i5 = 0;
        if (i4 == 0) {
            return 0;
        }
        if (i3 < 0 || i3 >= array.length || i4 < 0 || i3 + i4 > array.length) {
            throw new IllegalArgumentException(("Unexpected arguments: " + i3 + ", " + i4 + ", " + array.length).toString());
        }
        if (this.f143070d) {
            array[i3] = this.f143071e;
            i3++;
            i4--;
            this.f143070d = false;
            if (i4 == 0) {
                return 1;
            }
            i5 = 1;
        }
        if (i4 != 1) {
            return a(array, i3, i4) + i5;
        }
        int iC = c();
        if (iC != -1) {
            array[i3] = (char) iC;
            return i5 + 1;
        }
        if (i5 == 0) {
            return -1;
        }
        return i5;
    }
}
