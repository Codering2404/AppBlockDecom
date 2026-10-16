package com.revenuecat.purchases.ui.revenuecatui.customercenter.data;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
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
public final class CreateSupportTicketData {
    public static final int $stable = 0;
    private final Function0<Unit> onCancel;
    private final Function0<Unit> onClose;
    private final Function4<String, String, Function0<Unit>, Function0<Unit>, Unit> onSubmit;

    /* JADX WARN: Multi-variable type inference failed */
    public CreateSupportTicketData(Function4<? super String, ? super String, ? super Function0<Unit>, ? super Function0<Unit>, Unit> onSubmit, Function0<Unit> onCancel, Function0<Unit> onClose) {
        Intrinsics.checkNotNullParameter(onSubmit, "onSubmit");
        Intrinsics.checkNotNullParameter(onCancel, "onCancel");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        this.onSubmit = onSubmit;
        this.onCancel = onCancel;
        this.onClose = onClose;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CreateSupportTicketData copy$default(CreateSupportTicketData createSupportTicketData, Function4 function4, Function0 function0, Function0 function02, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function4 = createSupportTicketData.onSubmit;
        }
        if ((i3 & 2) != 0) {
            function0 = createSupportTicketData.onCancel;
        }
        if ((i3 & 4) != 0) {
            function02 = createSupportTicketData.onClose;
        }
        return createSupportTicketData.copy(function4, function0, function02);
    }

    public final Function4<String, String, Function0<Unit>, Function0<Unit>, Unit> component1() {
        return this.onSubmit;
    }

    public final Function0<Unit> component2() {
        return this.onCancel;
    }

    public final Function0<Unit> component3() {
        return this.onClose;
    }

    public final CreateSupportTicketData copy(Function4<? super String, ? super String, ? super Function0<Unit>, ? super Function0<Unit>, Unit> onSubmit, Function0<Unit> onCancel, Function0<Unit> onClose) {
        Intrinsics.checkNotNullParameter(onSubmit, "onSubmit");
        Intrinsics.checkNotNullParameter(onCancel, "onCancel");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        return new CreateSupportTicketData(onSubmit, onCancel, onClose);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CreateSupportTicketData)) {
            return false;
        }
        CreateSupportTicketData createSupportTicketData = (CreateSupportTicketData) obj;
        return Intrinsics.areEqual(this.onSubmit, createSupportTicketData.onSubmit) && Intrinsics.areEqual(this.onCancel, createSupportTicketData.onCancel) && Intrinsics.areEqual(this.onClose, createSupportTicketData.onClose);
    }

    public final /* synthetic */ Function0 getOnCancel() {
        return this.onCancel;
    }

    public final /* synthetic */ Function0 getOnClose() {
        return this.onClose;
    }

    public final /* synthetic */ Function4 getOnSubmit() {
        return this.onSubmit;
    }

    public int hashCode() {
        return (((this.onSubmit.hashCode() * 31) + this.onCancel.hashCode()) * 31) + this.onClose.hashCode();
    }

    public String toString() {
        return "CreateSupportTicketData(onSubmit=" + this.onSubmit + ", onCancel=" + this.onCancel + ", onClose=" + this.onClose + ')';
    }
}
