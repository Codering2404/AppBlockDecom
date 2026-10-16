package com.revenuecat.purchases.ui.revenuecatui.customercenter.views;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class EmailInputState {
    private final String email;
    private final boolean enabled;
    private final Function1<String, Unit> onEmailChange;
    private final Function1<Boolean, Unit> onFocusChanged;
    private final boolean showError;

    /* JADX WARN: Multi-variable type inference failed */
    public EmailInputState(String email, Function1<? super String, Unit> onEmailChange, Function1<? super Boolean, Unit> onFocusChanged, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(onEmailChange, "onEmailChange");
        Intrinsics.checkNotNullParameter(onFocusChanged, "onFocusChanged");
        this.email = email;
        this.onEmailChange = onEmailChange;
        this.onFocusChanged = onFocusChanged;
        this.showError = z2;
        this.enabled = z3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EmailInputState copy$default(EmailInputState emailInputState, String str, Function1 function1, Function1 function12, boolean z2, boolean z3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = emailInputState.email;
        }
        if ((i3 & 2) != 0) {
            function1 = emailInputState.onEmailChange;
        }
        if ((i3 & 4) != 0) {
            function12 = emailInputState.onFocusChanged;
        }
        if ((i3 & 8) != 0) {
            z2 = emailInputState.showError;
        }
        if ((i3 & 16) != 0) {
            z3 = emailInputState.enabled;
        }
        boolean z4 = z3;
        Function1 function13 = function12;
        return emailInputState.copy(str, function1, function13, z2, z4);
    }

    public final String component1() {
        return this.email;
    }

    public final Function1<String, Unit> component2() {
        return this.onEmailChange;
    }

    public final Function1<Boolean, Unit> component3() {
        return this.onFocusChanged;
    }

    public final boolean component4() {
        return this.showError;
    }

    public final boolean component5() {
        return this.enabled;
    }

    public final EmailInputState copy(String email, Function1<? super String, Unit> onEmailChange, Function1<? super Boolean, Unit> onFocusChanged, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(onEmailChange, "onEmailChange");
        Intrinsics.checkNotNullParameter(onFocusChanged, "onFocusChanged");
        return new EmailInputState(email, onEmailChange, onFocusChanged, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EmailInputState)) {
            return false;
        }
        EmailInputState emailInputState = (EmailInputState) obj;
        return Intrinsics.areEqual(this.email, emailInputState.email) && Intrinsics.areEqual(this.onEmailChange, emailInputState.onEmailChange) && Intrinsics.areEqual(this.onFocusChanged, emailInputState.onFocusChanged) && this.showError == emailInputState.showError && this.enabled == emailInputState.enabled;
    }

    public final String getEmail() {
        return this.email;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final Function1<String, Unit> getOnEmailChange() {
        return this.onEmailChange;
    }

    public final Function1<Boolean, Unit> getOnFocusChanged() {
        return this.onFocusChanged;
    }

    public final boolean getShowError() {
        return this.showError;
    }

    public int hashCode() {
        return (((((((this.email.hashCode() * 31) + this.onEmailChange.hashCode()) * 31) + this.onFocusChanged.hashCode()) * 31) + Boolean.hashCode(this.showError)) * 31) + Boolean.hashCode(this.enabled);
    }

    public String toString() {
        return "EmailInputState(email=" + this.email + ", onEmailChange=" + this.onEmailChange + ", onFocusChanged=" + this.onFocusChanged + ", showError=" + this.showError + ", enabled=" + this.enabled + ')';
    }
}
