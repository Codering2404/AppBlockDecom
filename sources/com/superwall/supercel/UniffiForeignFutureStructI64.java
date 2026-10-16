package com.superwall.supercel;

import com.sun.jna.Structure;
import com.superwall.supercel.UniffiRustCallStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
@Structure.FieldOrder({"returnValue", "callStatus"})
public class UniffiForeignFutureStructI64 extends Structure {
    public UniffiRustCallStatus.ByValue callStatus;
    public long returnValue;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class UniffiByValue extends UniffiForeignFutureStructI64 implements Structure.ByValue {
        public UniffiByValue() {
            this(0L, null, 3, null);
        }

        public /* synthetic */ UniffiByValue(long j3, UniffiRustCallStatus.ByValue byValue, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? new UniffiRustCallStatus.ByValue() : byValue);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UniffiByValue(long j3, UniffiRustCallStatus.ByValue callStatus) {
            super(j3, callStatus);
            Intrinsics.checkNotNullParameter(callStatus, "callStatus");
        }
    }

    public UniffiForeignFutureStructI64() {
        this(0L, null, 3, null);
    }

    public final void uniffiSetValue$supercel_release(UniffiForeignFutureStructI64 other) {
        Intrinsics.checkNotNullParameter(other, "other");
        this.returnValue = other.returnValue;
        this.callStatus = other.callStatus;
    }

    public /* synthetic */ UniffiForeignFutureStructI64(long j3, UniffiRustCallStatus.ByValue byValue, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? new UniffiRustCallStatus.ByValue() : byValue);
    }

    public UniffiForeignFutureStructI64(long j3, UniffiRustCallStatus.ByValue callStatus) {
        Intrinsics.checkNotNullParameter(callStatus, "callStatus");
        this.returnValue = j3;
        this.callStatus = callStatus;
    }
}
