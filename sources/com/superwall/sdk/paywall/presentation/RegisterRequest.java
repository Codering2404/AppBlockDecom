package com.superwall.sdk.paywall.presentation;

import com.superwall.sdk.paywall.presentation.internal.request.PaywallOverrides;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public final class RegisterRequest {
    private final Function0<Unit> completion;
    private final PaywallPresentationHandler handler;
    private final Map<String, Object> params;
    private final PaywallOverrides paywallOverrides;
    private final String placement;

    public RegisterRequest(String placement, Map<String, ? extends Object> map, PaywallPresentationHandler paywallPresentationHandler, Function0<Unit> function0, PaywallOverrides paywallOverrides) {
        Intrinsics.checkNotNullParameter(placement, "placement");
        this.placement = placement;
        this.params = map;
        this.handler = paywallPresentationHandler;
        this.completion = function0;
        this.paywallOverrides = paywallOverrides;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RegisterRequest copy$default(RegisterRequest registerRequest, String str, Map map, PaywallPresentationHandler paywallPresentationHandler, Function0 function0, PaywallOverrides paywallOverrides, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = registerRequest.placement;
        }
        if ((i3 & 2) != 0) {
            map = registerRequest.params;
        }
        if ((i3 & 4) != 0) {
            paywallPresentationHandler = registerRequest.handler;
        }
        if ((i3 & 8) != 0) {
            function0 = registerRequest.completion;
        }
        if ((i3 & 16) != 0) {
            paywallOverrides = registerRequest.paywallOverrides;
        }
        PaywallOverrides paywallOverrides2 = paywallOverrides;
        PaywallPresentationHandler paywallPresentationHandler2 = paywallPresentationHandler;
        return registerRequest.copy(str, map, paywallPresentationHandler2, function0, paywallOverrides2);
    }

    public final String component1() {
        return this.placement;
    }

    public final Map<String, Object> component2() {
        return this.params;
    }

    public final PaywallPresentationHandler component3() {
        return this.handler;
    }

    public final Function0<Unit> component4() {
        return this.completion;
    }

    public final PaywallOverrides component5() {
        return this.paywallOverrides;
    }

    public final RegisterRequest copy(String placement, Map<String, ? extends Object> map, PaywallPresentationHandler paywallPresentationHandler, Function0<Unit> function0, PaywallOverrides paywallOverrides) {
        Intrinsics.checkNotNullParameter(placement, "placement");
        return new RegisterRequest(placement, map, paywallPresentationHandler, function0, paywallOverrides);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RegisterRequest)) {
            return false;
        }
        RegisterRequest registerRequest = (RegisterRequest) obj;
        return Intrinsics.areEqual(this.placement, registerRequest.placement) && Intrinsics.areEqual(this.params, registerRequest.params) && Intrinsics.areEqual(this.handler, registerRequest.handler) && Intrinsics.areEqual(this.completion, registerRequest.completion) && Intrinsics.areEqual(this.paywallOverrides, registerRequest.paywallOverrides);
    }

    public final Function0<Unit> getCompletion() {
        return this.completion;
    }

    public final PaywallPresentationHandler getHandler() {
        return this.handler;
    }

    public final Map<String, Object> getParams() {
        return this.params;
    }

    public final PaywallOverrides getPaywallOverrides() {
        return this.paywallOverrides;
    }

    public final String getPlacement() {
        return this.placement;
    }

    public int hashCode() {
        int iHashCode = this.placement.hashCode() * 31;
        Map<String, Object> map = this.params;
        int iHashCode2 = (iHashCode + (map == null ? 0 : map.hashCode())) * 31;
        PaywallPresentationHandler paywallPresentationHandler = this.handler;
        int iHashCode3 = (iHashCode2 + (paywallPresentationHandler == null ? 0 : paywallPresentationHandler.hashCode())) * 31;
        Function0<Unit> function0 = this.completion;
        int iHashCode4 = (iHashCode3 + (function0 == null ? 0 : function0.hashCode())) * 31;
        PaywallOverrides paywallOverrides = this.paywallOverrides;
        return iHashCode4 + (paywallOverrides != null ? paywallOverrides.hashCode() : 0);
    }

    public String toString() {
        return "RegisterRequest(placement=" + this.placement + ", params=" + this.params + ", handler=" + this.handler + ", completion=" + this.completion + ", paywallOverrides=" + this.paywallOverrides + ")";
    }
}
