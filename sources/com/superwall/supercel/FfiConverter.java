package com.superwall.supercel;

import com.sun.jna.Pointer;
import com.superwall.supercel.RustBuffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public interface FfiConverter<KotlinType, FfiType> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
        /* JADX INFO: Thrown type has an unknown type hierarchy: E */
        public static <KotlinType, FfiType> KotlinType liftFromRustBuffer(FfiConverter<KotlinType, FfiType> ffiConverter, RustBuffer.ByValue rbuf) throws E, InternalException {
            Intrinsics.checkNotNullParameter(rbuf, "rbuf");
            ByteBuffer byteBufferAsByteBuffer = rbuf.asByteBuffer();
            Intrinsics.checkNotNull(byteBufferAsByteBuffer);
            try {
                KotlinType kotlintype = ffiConverter.read(byteBufferAsByteBuffer);
                if (byteBufferAsByteBuffer.hasRemaining()) {
                    throw new RuntimeException("junk remaining in buffer after lifting, something is very wrong!!");
                }
                return kotlintype;
            } finally {
                RustBuffer.Companion.free$supercel_release(rbuf);
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: E */
        public static <KotlinType, FfiType> RustBuffer.ByValue lowerIntoRustBuffer(FfiConverter<KotlinType, FfiType> ffiConverter, KotlinType kotlintype) throws E, InternalException {
            RustBuffer.ByValue byValueM1353allocVKZWuLQ$supercel_release = RustBuffer.Companion.m1353allocVKZWuLQ$supercel_release(ffiConverter.mo1348allocationSizeI7RO_PI(kotlintype));
            try {
                Pointer pointer = byValueM1353allocVKZWuLQ$supercel_release.data;
                Intrinsics.checkNotNull(pointer);
                ByteBuffer byteBuffer = pointer.getByteBuffer(0L, byValueM1353allocVKZWuLQ$supercel_release.capacity);
                byteBuffer.order(ByteOrder.BIG_ENDIAN);
                Intrinsics.checkNotNull(byteBuffer);
                ffiConverter.write(kotlintype, byteBuffer);
                byValueM1353allocVKZWuLQ$supercel_release.writeField("len", Long.valueOf(byteBuffer.position()));
                return byValueM1353allocVKZWuLQ$supercel_release;
            } catch (Throwable th) {
                RustBuffer.Companion.free$supercel_release(byValueM1353allocVKZWuLQ$supercel_release);
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: allocationSize-I7RO_PI, reason: not valid java name */
    long mo1348allocationSizeI7RO_PI(KotlinType kotlintype);

    KotlinType lift(FfiType ffitype);

    KotlinType liftFromRustBuffer(RustBuffer.ByValue byValue);

    FfiType lower(KotlinType kotlintype);

    RustBuffer.ByValue lowerIntoRustBuffer(KotlinType kotlintype);

    KotlinType read(ByteBuffer byteBuffer);

    void write(KotlinType kotlintype, ByteBuffer byteBuffer);
}
