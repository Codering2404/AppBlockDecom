package com.revenuecat.purchases.ui.revenuecatui.customercenter.views;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
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
public final class DescriptionInputState {
    private final String description;
    private final boolean enabled;
    private final Function1<String, Unit> onDescriptionChange;
    private final Function0<Unit> onSubmit;
    private final boolean showDone;

    /* JADX WARN: Multi-variable type inference failed */
    public DescriptionInputState(String description, Function1<? super String, Unit> onDescriptionChange, boolean z2, boolean z3, Function0<Unit> onSubmit) {
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(onDescriptionChange, "onDescriptionChange");
        Intrinsics.checkNotNullParameter(onSubmit, "onSubmit");
        this.description = description;
        this.onDescriptionChange = onDescriptionChange;
        this.enabled = z2;
        this.showDone = z3;
        this.onSubmit = onSubmit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DescriptionInputState copy$default(DescriptionInputState descriptionInputState, String str, Function1 function1, boolean z2, boolean z3, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = descriptionInputState.description;
        }
        if ((i3 & 2) != 0) {
            function1 = descriptionInputState.onDescriptionChange;
        }
        if ((i3 & 4) != 0) {
            z2 = descriptionInputState.enabled;
        }
        if ((i3 & 8) != 0) {
            z3 = descriptionInputState.showDone;
        }
        if ((i3 & 16) != 0) {
            function0 = descriptionInputState.onSubmit;
        }
        Function0 function02 = function0;
        boolean z4 = z2;
        return descriptionInputState.copy(str, function1, z4, z3, function02);
    }

    public final String component1() {
        return this.description;
    }

    public final Function1<String, Unit> component2() {
        return this.onDescriptionChange;
    }

    public final boolean component3() {
        return this.enabled;
    }

    public final boolean component4() {
        return this.showDone;
    }

    public final Function0<Unit> component5() {
        return this.onSubmit;
    }

    public final DescriptionInputState copy(String description, Function1<? super String, Unit> onDescriptionChange, boolean z2, boolean z3, Function0<Unit> onSubmit) {
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(onDescriptionChange, "onDescriptionChange");
        Intrinsics.checkNotNullParameter(onSubmit, "onSubmit");
        return new DescriptionInputState(description, onDescriptionChange, z2, z3, onSubmit);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DescriptionInputState)) {
            return false;
        }
        DescriptionInputState descriptionInputState = (DescriptionInputState) obj;
        return Intrinsics.areEqual(this.description, descriptionInputState.description) && Intrinsics.areEqual(this.onDescriptionChange, descriptionInputState.onDescriptionChange) && this.enabled == descriptionInputState.enabled && this.showDone == descriptionInputState.showDone && Intrinsics.areEqual(this.onSubmit, descriptionInputState.onSubmit);
    }

    public final String getDescription() {
        return this.description;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final Function1<String, Unit> getOnDescriptionChange() {
        return this.onDescriptionChange;
    }

    public final Function0<Unit> getOnSubmit() {
        return this.onSubmit;
    }

    public final boolean getShowDone() {
        return this.showDone;
    }

    public int hashCode() {
        return (((((((this.description.hashCode() * 31) + this.onDescriptionChange.hashCode()) * 31) + Boolean.hashCode(this.enabled)) * 31) + Boolean.hashCode(this.showDone)) * 31) + this.onSubmit.hashCode();
    }

    public String toString() {
        return "DescriptionInputState(description=" + this.description + ", onDescriptionChange=" + this.onDescriptionChange + ", enabled=" + this.enabled + ", showDone=" + this.showDone + ", onSubmit=" + this.onSubmit + ')';
    }

    public /* synthetic */ DescriptionInputState(String str, Function1 function1, boolean z2, boolean z3, Function0 function0, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, function1, z2, (i3 & 8) != 0 ? false : z3, (i3 & 16) != 0 ? new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.DescriptionInputState.1
            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m1038invoke() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m1038invoke();
                return Unit.f139807a;
            }
        } : function0);
    }
}
