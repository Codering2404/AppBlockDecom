package com.superwall.sdk.models.transactions;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

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
@Serializable
public final class SavedTransaction {
    public static final Companion Companion = new Companion(null);
    private final long date;
    private final boolean hasExternalPurchaseController;
    private final String id;
    private final boolean isExternal;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<SavedTransaction> serializer() {
            return SavedTransaction$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ SavedTransaction(int i3, String str, long j3, boolean z2, boolean z3, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i3 & 15)) {
            PluginExceptionsKt.b(i3, 15, SavedTransaction$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.date = j3;
        this.hasExternalPurchaseController = z2;
        this.isExternal = z3;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(SavedTransaction savedTransaction, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.y(serialDescriptor, 0, savedTransaction.id);
        compositeEncoder.F(serialDescriptor, 1, savedTransaction.date);
        compositeEncoder.x(serialDescriptor, 2, savedTransaction.hasExternalPurchaseController);
        compositeEncoder.x(serialDescriptor, 3, savedTransaction.isExternal);
    }

    public final long getDate() {
        return this.date;
    }

    public final boolean getHasExternalPurchaseController() {
        return this.hasExternalPurchaseController;
    }

    public final String getId() {
        return this.id;
    }

    public final boolean isExternal() {
        return this.isExternal;
    }

    public SavedTransaction(String id, long j3, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
        this.date = j3;
        this.hasExternalPurchaseController = z2;
        this.isExternal = z3;
    }

    @SerialName
    public static /* synthetic */ void getDate$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getHasExternalPurchaseController$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName
    public static /* synthetic */ void isExternal$annotations() {
    }
}
