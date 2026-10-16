package com.superwall.supercel;

import com.sun.jna.Structure;
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
@Structure.FieldOrder({"onResult", "uniffiFree"})
public class UniffiVTableCallbackInterfaceResultCallback extends Structure {
    public UniffiCallbackInterfaceResultCallbackMethod0 onResult;
    public UniffiCallbackInterfaceFree uniffiFree;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class UniffiByValue extends UniffiVTableCallbackInterfaceResultCallback implements Structure.ByValue {
        /* JADX WARN: Multi-variable type inference failed */
        public UniffiByValue() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public /* synthetic */ UniffiByValue(UniffiCallbackInterfaceResultCallbackMethod0 uniffiCallbackInterfaceResultCallbackMethod0, UniffiCallbackInterfaceFree uniffiCallbackInterfaceFree, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : uniffiCallbackInterfaceResultCallbackMethod0, (i3 & 2) != 0 ? null : uniffiCallbackInterfaceFree);
        }

        public UniffiByValue(UniffiCallbackInterfaceResultCallbackMethod0 uniffiCallbackInterfaceResultCallbackMethod0, UniffiCallbackInterfaceFree uniffiCallbackInterfaceFree) {
            super(uniffiCallbackInterfaceResultCallbackMethod0, uniffiCallbackInterfaceFree);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UniffiVTableCallbackInterfaceResultCallback() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final void uniffiSetValue$supercel_release(UniffiVTableCallbackInterfaceResultCallback other) {
        Intrinsics.checkNotNullParameter(other, "other");
        this.onResult = other.onResult;
        this.uniffiFree = other.uniffiFree;
    }

    public /* synthetic */ UniffiVTableCallbackInterfaceResultCallback(UniffiCallbackInterfaceResultCallbackMethod0 uniffiCallbackInterfaceResultCallbackMethod0, UniffiCallbackInterfaceFree uniffiCallbackInterfaceFree, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : uniffiCallbackInterfaceResultCallbackMethod0, (i3 & 2) != 0 ? null : uniffiCallbackInterfaceFree);
    }

    public UniffiVTableCallbackInterfaceResultCallback(UniffiCallbackInterfaceResultCallbackMethod0 uniffiCallbackInterfaceResultCallbackMethod0, UniffiCallbackInterfaceFree uniffiCallbackInterfaceFree) {
        this.onResult = uniffiCallbackInterfaceResultCallbackMethod0;
        this.uniffiFree = uniffiCallbackInterfaceFree;
    }
}
