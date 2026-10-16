package com.superwall.supercel;

import com.superwall.supercel.FfiConverter;
import com.superwall.supercel.RustBuffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class FfiConverterString implements FfiConverter<String, RustBuffer.ByValue> {
    public static final FfiConverterString INSTANCE = new FfiConverterString();

    private FfiConverterString() {
    }

    public final ByteBuffer toUtf8(String value) throws CharacterCodingException {
        Intrinsics.checkNotNullParameter(value, "value");
        CharsetEncoder charsetEncoderNewEncoder = Charsets.f140510b.newEncoder();
        charsetEncoderNewEncoder.onMalformedInput(CodingErrorAction.REPORT);
        ByteBuffer byteBufferEncode = charsetEncoderNewEncoder.encode(CharBuffer.wrap(value));
        Intrinsics.checkNotNullExpressionValue(byteBufferEncode, "run(...)");
        return byteBufferEncode;
    }

    @Override // com.superwall.supercel.FfiConverter
    /* JADX INFO: renamed from: allocationSize-I7RO_PI, reason: avoid collision after fix types in other method and not valid java name and merged with bridge method [inline-methods] */
    public long mo1348allocationSizeI7RO_PI(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return ULong.b(ULong.b(ULong.b(value.length()) * 3) + 4);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: E */
    @Override // com.superwall.supercel.FfiConverter
    public String lift(RustBuffer.ByValue value) throws E, InternalException {
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            byte[] bArr = new byte[(int) value.len];
            ByteBuffer byteBufferAsByteBuffer = value.asByteBuffer();
            Intrinsics.checkNotNull(byteBufferAsByteBuffer);
            byteBufferAsByteBuffer.get(bArr);
            return new String(bArr, Charsets.f140510b);
        } finally {
            RustBuffer.Companion.free$supercel_release(value);
        }
    }

    @Override // com.superwall.supercel.FfiConverter
    public String liftFromRustBuffer(RustBuffer.ByValue byValue) {
        return (String) FfiConverter.DefaultImpls.liftFromRustBuffer(this, byValue);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: E */
    @Override // com.superwall.supercel.FfiConverter
    public RustBuffer.ByValue lower(String value) throws CharacterCodingException, E, InternalException {
        Intrinsics.checkNotNullParameter(value, "value");
        ByteBuffer utf8 = toUtf8(value);
        RustBuffer.ByValue byValueM1353allocVKZWuLQ$supercel_release = RustBuffer.Companion.m1353allocVKZWuLQ$supercel_release(ULong.b(utf8.limit()));
        ByteBuffer byteBufferAsByteBuffer = byValueM1353allocVKZWuLQ$supercel_release.asByteBuffer();
        Intrinsics.checkNotNull(byteBufferAsByteBuffer);
        byteBufferAsByteBuffer.put(utf8);
        return byValueM1353allocVKZWuLQ$supercel_release;
    }

    @Override // com.superwall.supercel.FfiConverter
    public RustBuffer.ByValue lowerIntoRustBuffer(String str) {
        return FfiConverter.DefaultImpls.lowerIntoRustBuffer(this, str);
    }

    @Override // com.superwall.supercel.FfiConverter
    public String read(ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        byte[] bArr = new byte[buf.getInt()];
        buf.get(bArr);
        return new String(bArr, Charsets.f140510b);
    }

    @Override // com.superwall.supercel.FfiConverter
    public void write(String value, ByteBuffer buf) throws CharacterCodingException {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(buf, "buf");
        ByteBuffer utf8 = toUtf8(value);
        buf.putInt(utf8.limit());
        buf.put(utf8);
    }
}
