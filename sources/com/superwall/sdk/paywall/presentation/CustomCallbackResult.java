package com.superwall.sdk.paywall.presentation;

import java.util.Map;
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
public final class CustomCallbackResult {
    public static final Companion Companion = new Companion(null);
    private final Map<String, Object> data;
    private final CustomCallbackResultStatus status;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CustomCallbackResult failure$default(Companion companion, Map map, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                map = null;
            }
            return companion.failure(map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CustomCallbackResult success$default(Companion companion, Map map, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                map = null;
            }
            return companion.success(map);
        }

        public final CustomCallbackResult failure(Map<String, ? extends Object> map) {
            return new CustomCallbackResult(CustomCallbackResultStatus.FAILURE, map);
        }

        public final CustomCallbackResult success(Map<String, ? extends Object> map) {
            return new CustomCallbackResult(CustomCallbackResultStatus.SUCCESS, map);
        }

        private Companion() {
        }
    }

    public CustomCallbackResult(CustomCallbackResultStatus status, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(status, "status");
        this.status = status;
        this.data = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CustomCallbackResult copy$default(CustomCallbackResult customCallbackResult, CustomCallbackResultStatus customCallbackResultStatus, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            customCallbackResultStatus = customCallbackResult.status;
        }
        if ((i3 & 2) != 0) {
            map = customCallbackResult.data;
        }
        return customCallbackResult.copy(customCallbackResultStatus, map);
    }

    public final CustomCallbackResultStatus component1() {
        return this.status;
    }

    public final Map<String, Object> component2() {
        return this.data;
    }

    public final CustomCallbackResult copy(CustomCallbackResultStatus status, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(status, "status");
        return new CustomCallbackResult(status, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomCallbackResult)) {
            return false;
        }
        CustomCallbackResult customCallbackResult = (CustomCallbackResult) obj;
        return this.status == customCallbackResult.status && Intrinsics.areEqual(this.data, customCallbackResult.data);
    }

    public final Map<String, Object> getData() {
        return this.data;
    }

    public final CustomCallbackResultStatus getStatus() {
        return this.status;
    }

    public int hashCode() {
        int iHashCode = this.status.hashCode() * 31;
        Map<String, Object> map = this.data;
        return iHashCode + (map == null ? 0 : map.hashCode());
    }

    public String toString() {
        return "CustomCallbackResult(status=" + this.status + ", data=" + this.data + ")";
    }

    public /* synthetic */ CustomCallbackResult(CustomCallbackResultStatus customCallbackResultStatus, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(customCallbackResultStatus, (i3 & 2) != 0 ? null : map);
    }
}
