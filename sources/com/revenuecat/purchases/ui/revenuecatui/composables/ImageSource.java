package com.revenuecat.purchases.ui.revenuecatui.composables;

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
abstract class ImageSource {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Local extends ImageSource {
        public static final int $stable = 0;
        private final Object data;
        private final int resource;

        public Local(int i3) {
            super(null);
            this.resource = i3;
            this.data = Integer.valueOf(i3);
        }

        public static /* synthetic */ Local copy$default(Local local, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i3 = local.resource;
            }
            return local.copy(i3);
        }

        public final int component1() {
            return this.resource;
        }

        public final Local copy(int i3) {
            return new Local(i3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Local) && this.resource == ((Local) obj).resource;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.composables.ImageSource
        public Object getData() {
            return this.data;
        }

        public final int getResource() {
            return this.resource;
        }

        public int hashCode() {
            return Integer.hashCode(this.resource);
        }

        public String toString() {
            return "Local(resource=" + this.resource + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Remote extends ImageSource {
        public static final int $stable = 0;
        private final Object data;
        private final String urlString;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Remote(String urlString) {
            super(null);
            Intrinsics.checkNotNullParameter(urlString, "urlString");
            this.urlString = urlString;
            this.data = urlString;
        }

        public static /* synthetic */ Remote copy$default(Remote remote, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = remote.urlString;
            }
            return remote.copy(str);
        }

        public final String component1() {
            return this.urlString;
        }

        public final Remote copy(String urlString) {
            Intrinsics.checkNotNullParameter(urlString, "urlString");
            return new Remote(urlString);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Remote) && Intrinsics.areEqual(this.urlString, ((Remote) obj).urlString);
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.composables.ImageSource
        public Object getData() {
            return this.data;
        }

        public final String getUrlString() {
            return this.urlString;
        }

        public int hashCode() {
            return this.urlString.hashCode();
        }

        public String toString() {
            return "Remote(urlString=" + this.urlString + ')';
        }
    }

    public /* synthetic */ ImageSource(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract Object getData();

    private ImageSource() {
    }
}
