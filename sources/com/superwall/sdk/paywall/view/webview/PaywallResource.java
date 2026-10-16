package com.superwall.sdk.paywall.view.webview;

import android.net.Uri;
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
public abstract class PaywallResource {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class FromResources extends PaywallResource {
        private final int resId;

        public FromResources(int i3) {
            super(null);
            this.resId = i3;
        }

        public static /* synthetic */ FromResources copy$default(FromResources fromResources, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i3 = fromResources.resId;
            }
            return fromResources.copy(i3);
        }

        public final int component1() {
            return this.resId;
        }

        public final FromResources copy(int i3) {
            return new FromResources(i3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof FromResources) && this.resId == ((FromResources) obj).resId;
        }

        public final int getResId() {
            return this.resId;
        }

        public int hashCode() {
            return Integer.hashCode(this.resId);
        }

        public String toString() {
            return "FromResources(resId=" + this.resId + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class FromUri extends PaywallResource {
        private final Uri uri;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FromUri(Uri uri) {
            super(null);
            Intrinsics.checkNotNullParameter(uri, "uri");
            this.uri = uri;
        }

        public static /* synthetic */ FromUri copy$default(FromUri fromUri, Uri uri, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                uri = fromUri.uri;
            }
            return fromUri.copy(uri);
        }

        public final Uri component1() {
            return this.uri;
        }

        public final FromUri copy(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            return new FromUri(uri);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof FromUri) && Intrinsics.areEqual(this.uri, ((FromUri) obj).uri);
        }

        public final Uri getUri() {
            return this.uri;
        }

        public int hashCode() {
            return this.uri.hashCode();
        }

        public String toString() {
            return "FromUri(uri=" + this.uri + ")";
        }
    }

    public /* synthetic */ PaywallResource(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PaywallResource() {
    }
}
