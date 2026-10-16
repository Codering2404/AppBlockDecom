package com.facebook.internal;

import android.net.Uri;
import android.os.Bundle;
import androidx.glance.color.Tq.KqqtdetwHMIO;
import com.facebook.FacebookSdk;
import com.facebook.login.CustomTabLoginMethodHandler;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class InstagramCustomTab extends CustomTab {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Uri getURIForAction(String action, Bundle bundle) {
            Intrinsics.checkNotNullParameter(action, "action");
            if (Intrinsics.areEqual(action, CustomTabLoginMethodHandler.OAUTH_DIALOG)) {
                return Utility.buildUri(ServerProtocol.getInstagramDialogAuthority(), KqqtdetwHMIO.IcrU, bundle);
            }
            return Utility.buildUri(ServerProtocol.getInstagramDialogAuthority(), FacebookSdk.getGraphApiVersion() + "/dialog/" + action, bundle);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InstagramCustomTab(String action, Bundle bundle) {
        super(action, bundle);
        Intrinsics.checkNotNullParameter(action, "action");
        setUri(Companion.getURIForAction(action, bundle == null ? new Bundle() : bundle));
    }
}
