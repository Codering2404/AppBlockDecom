package com.superwall.sdk.identity;

import com.superwall.sdk.storage.AliasId;
import com.superwall.sdk.storage.AppUserId;
import com.superwall.sdk.storage.Seed;
import com.superwall.sdk.storage.Storage;
import com.superwall.sdk.storage.UserAttributes;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
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
public final class IdentityManagerActorKt {
    public static final IdentityState createInitialIdentityState(Storage storage, String appInstalledAtString) {
        String str;
        int iGenerateSeed;
        Map<String, Object> map;
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(appInstalledAtString, "appInstalledAtString");
        AliasId aliasId = AliasId.INSTANCE;
        String str2 = (String) storage.read(aliasId);
        Seed seed = Seed.INSTANCE;
        Integer num = (Integer) storage.read(seed);
        if (str2 == null) {
            String strGenerateAlias = IdentityLogic.INSTANCE.generateAlias();
            storage.write(aliasId, strGenerateAlias);
            str = strGenerateAlias;
        } else {
            str = str2;
        }
        if (num != null) {
            iGenerateSeed = num.intValue();
        } else {
            iGenerateSeed = IdentityLogic.INSTANCE.generateSeed();
            storage.write(seed, Integer.valueOf(iGenerateSeed));
        }
        int i3 = iGenerateSeed;
        String str3 = (String) storage.read(AppUserId.INSTANCE);
        UserAttributes userAttributes = UserAttributes.INSTANCE;
        Map<String, Object> mapEmptyMap = (Map) storage.read(userAttributes);
        if (mapEmptyMap == null) {
            mapEmptyMap = MapsKt.emptyMap();
        }
        if (str2 == null || num == null || mapEmptyMap.isEmpty()) {
            IdentityLogic identityLogic = IdentityLogic.INSTANCE;
            Map mapCreateMapBuilder = MapsKt.createMapBuilder();
            mapCreateMapBuilder.put(Keys.ALIAS_ID, str);
            mapCreateMapBuilder.put(Keys.SEED, Integer.valueOf(i3));
            if (str3 != null) {
                mapCreateMapBuilder.put(Keys.APP_USER_ID, str3);
            }
            Map<String, Object> mapMergeAttributes = identityLogic.mergeAttributes(MapsKt.build(mapCreateMapBuilder), mapEmptyMap, appInstalledAtString);
            if (!Intrinsics.areEqual(mapMergeAttributes, mapEmptyMap)) {
                storage.write(userAttributes, mapMergeAttributes);
            }
            map = mapMergeAttributes;
        } else {
            map = mapEmptyMap;
        }
        return new IdentityState(str3, str, i3, map, null, appInstalledAtString, 16, null);
    }
}
