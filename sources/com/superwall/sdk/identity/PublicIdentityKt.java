package com.superwall.sdk.identity;

import com.superwall.sdk.Superwall;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public final class PublicIdentityKt {
    public static final Map<String, Object> cleanAttributes(Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : attributes.keySet()) {
            if (!StringsKt.U(str, "$", false, 2, null)) {
                linkedHashMap.put(str, attributes.get(str));
            }
        }
        return MapsKt.toMap(linkedHashMap);
    }

    public static final void identify(Superwall superwall, String userId, IdentityOptions identityOptions) {
        Intrinsics.checkNotNullParameter(superwall, "<this>");
        Intrinsics.checkNotNullParameter(userId, "userId");
        superwall.getDependencyContainer$superwall_release().getIdentityManager().identify(userId, identityOptions);
    }

    public static /* synthetic */ void identify$default(Superwall superwall, String str, IdentityOptions identityOptions, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            identityOptions = null;
        }
        identify(superwall, str, identityOptions);
    }

    public static final void setUserAttributes(Superwall superwall, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(superwall, "<this>");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        IdentityManager.mergeUserAttributes$default(superwall.getDependencyContainer$superwall_release().getIdentityManager(), cleanAttributes(attributes), false, 2, null);
    }
}
