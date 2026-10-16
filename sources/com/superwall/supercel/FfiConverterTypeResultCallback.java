package com.superwall.supercel;

import com.sun.jna.Pointer;
import com.superwall.supercel.FfiConverter;
import com.superwall.supercel.RustBuffer;
import java.nio.ByteBuffer;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class FfiConverterTypeResultCallback implements FfiConverter<ResultCallback, Pointer> {
    public static final FfiConverterTypeResultCallback INSTANCE = new FfiConverterTypeResultCallback();

    private FfiConverterTypeResultCallback() {
    }

    @Override // com.superwall.supercel.FfiConverter
    /* JADX INFO: renamed from: allocationSize-I7RO_PI, reason: avoid collision after fix types in other method and not valid java name and merged with bridge method [inline-methods] */
    public long mo1348allocationSizeI7RO_PI(ResultCallback value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return 8L;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.superwall.supercel.FfiConverter
    public ResultCallback liftFromRustBuffer(RustBuffer.ByValue byValue) {
        return (ResultCallback) FfiConverter.DefaultImpls.liftFromRustBuffer(this, byValue);
    }

    @Override // com.superwall.supercel.FfiConverter
    public RustBuffer.ByValue lowerIntoRustBuffer(ResultCallback resultCallback) {
        return FfiConverter.DefaultImpls.lowerIntoRustBuffer(this, resultCallback);
    }

    @Override // com.superwall.supercel.FfiConverter
    public ResultCallback lift(Pointer value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new ResultCallback(value);
    }

    @Override // com.superwall.supercel.FfiConverter
    public Pointer lower(ResultCallback value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return value.uniffiClonePointer();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.superwall.supercel.FfiConverter
    public ResultCallback read(ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        return lift(new Pointer(buf.getLong()));
    }

    @Override // com.superwall.supercel.FfiConverter
    public void write(ResultCallback value, ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(buf, "buf");
        buf.putLong(Pointer.nativeValue(lower(value)));
    }
}
