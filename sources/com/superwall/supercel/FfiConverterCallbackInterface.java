package com.superwall.supercel;

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
public abstract class FfiConverterCallbackInterface<CallbackInterface> implements FfiConverter<CallbackInterface, Long> {
    private final UniffiHandleMap<CallbackInterface> handleMap = new UniffiHandleMap<>();

    @Override // com.superwall.supercel.FfiConverter
    /* JADX INFO: renamed from: allocationSize-I7RO_PI */
    public long mo1348allocationSizeI7RO_PI(CallbackInterface value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return 8L;
    }

    public final void drop$supercel_release(long j3) throws InternalException {
        this.handleMap.remove(j3);
    }

    public final UniffiHandleMap<CallbackInterface> getHandleMap$supercel_release() {
        return this.handleMap;
    }

    @Override // com.superwall.supercel.FfiConverter
    public /* bridge */ /* synthetic */ Object lift(Long l3) {
        return lift(l3.longValue());
    }

    @Override // com.superwall.supercel.FfiConverter
    public CallbackInterface liftFromRustBuffer(RustBuffer.ByValue byValue) {
        return (CallbackInterface) FfiConverter.DefaultImpls.liftFromRustBuffer(this, byValue);
    }

    @Override // com.superwall.supercel.FfiConverter
    public RustBuffer.ByValue lowerIntoRustBuffer(CallbackInterface callbackinterface) {
        return FfiConverter.DefaultImpls.lowerIntoRustBuffer(this, callbackinterface);
    }

    @Override // com.superwall.supercel.FfiConverter
    public CallbackInterface read(ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        return lift(buf.getLong());
    }

    @Override // com.superwall.supercel.FfiConverter
    public void write(CallbackInterface value, ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(buf, "buf");
        buf.putLong(lower((Object) value).longValue());
    }

    public CallbackInterface lift(long j3) {
        return this.handleMap.get(j3);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.superwall.supercel.FfiConverter
    public Long lower(CallbackInterface value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return Long.valueOf(this.handleMap.insert(value));
    }
}
