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
@Structure.FieldOrder({"callStatus"})
public class UniffiForeignFutureStructVoid extends Structure {
    public UniffiRustCallStatus.ByValue callStatus;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class UniffiByValue extends UniffiForeignFutureStructVoid implements Structure.ByValue {
        /* JADX WARN: Multi-variable type inference failed */
        public UniffiByValue() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public /* synthetic */ UniffiByValue(UniffiRustCallStatus.ByValue byValue, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? new UniffiRustCallStatus.ByValue() : byValue);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UniffiByValue(UniffiRustCallStatus.ByValue callStatus) {
            super(callStatus);
            Intrinsics.checkNotNullParameter(callStatus, "callStatus");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UniffiForeignFutureStructVoid() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final void uniffiSetValue$supercel_release(UniffiForeignFutureStructVoid other) {
        Intrinsics.checkNotNullParameter(other, "other");
        this.callStatus = other.callStatus;
    }

    public /* synthetic */ UniffiForeignFutureStructVoid(UniffiRustCallStatus.ByValue byValue, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new UniffiRustCallStatus.ByValue() : byValue);
    }

    public UniffiForeignFutureStructVoid(UniffiRustCallStatus.ByValue callStatus) {
        Intrinsics.checkNotNullParameter(callStatus, "callStatus");
        this.callStatus = callStatus;
    }
}
