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
@Structure.FieldOrder({"computedProperty", "deviceProperty", "uniffiFree"})
public class UniffiVTableCallbackInterfaceHostContext extends Structure {
    public UniffiCallbackInterfaceHostContextMethod0 computedProperty;
    public UniffiCallbackInterfaceHostContextMethod1 deviceProperty;
    public UniffiCallbackInterfaceFree uniffiFree;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class UniffiByValue extends UniffiVTableCallbackInterfaceHostContext implements Structure.ByValue {
        public UniffiByValue() {
            this(null, null, null, 7, null);
        }

        public /* synthetic */ UniffiByValue(UniffiCallbackInterfaceHostContextMethod0 uniffiCallbackInterfaceHostContextMethod0, UniffiCallbackInterfaceHostContextMethod1 uniffiCallbackInterfaceHostContextMethod1, UniffiCallbackInterfaceFree uniffiCallbackInterfaceFree, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : uniffiCallbackInterfaceHostContextMethod0, (i3 & 2) != 0 ? null : uniffiCallbackInterfaceHostContextMethod1, (i3 & 4) != 0 ? null : uniffiCallbackInterfaceFree);
        }

        public UniffiByValue(UniffiCallbackInterfaceHostContextMethod0 uniffiCallbackInterfaceHostContextMethod0, UniffiCallbackInterfaceHostContextMethod1 uniffiCallbackInterfaceHostContextMethod1, UniffiCallbackInterfaceFree uniffiCallbackInterfaceFree) {
            super(uniffiCallbackInterfaceHostContextMethod0, uniffiCallbackInterfaceHostContextMethod1, uniffiCallbackInterfaceFree);
        }
    }

    public UniffiVTableCallbackInterfaceHostContext() {
        this(null, null, null, 7, null);
    }

    public final void uniffiSetValue$supercel_release(UniffiVTableCallbackInterfaceHostContext other) {
        Intrinsics.checkNotNullParameter(other, "other");
        this.computedProperty = other.computedProperty;
        this.deviceProperty = other.deviceProperty;
        this.uniffiFree = other.uniffiFree;
    }

    public /* synthetic */ UniffiVTableCallbackInterfaceHostContext(UniffiCallbackInterfaceHostContextMethod0 uniffiCallbackInterfaceHostContextMethod0, UniffiCallbackInterfaceHostContextMethod1 uniffiCallbackInterfaceHostContextMethod1, UniffiCallbackInterfaceFree uniffiCallbackInterfaceFree, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : uniffiCallbackInterfaceHostContextMethod0, (i3 & 2) != 0 ? null : uniffiCallbackInterfaceHostContextMethod1, (i3 & 4) != 0 ? null : uniffiCallbackInterfaceFree);
    }

    public UniffiVTableCallbackInterfaceHostContext(UniffiCallbackInterfaceHostContextMethod0 uniffiCallbackInterfaceHostContextMethod0, UniffiCallbackInterfaceHostContextMethod1 uniffiCallbackInterfaceHostContextMethod1, UniffiCallbackInterfaceFree uniffiCallbackInterfaceFree) {
        this.computedProperty = uniffiCallbackInterfaceHostContextMethod0;
        this.deviceProperty = uniffiCallbackInterfaceHostContextMethod1;
        this.uniffiFree = uniffiCallbackInterfaceFree;
    }
}
