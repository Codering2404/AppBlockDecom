package cz.mobilesoft.coreblock.storage.room.dao.blocking;

import cz.mobilesoft.coreblock.storage.room.dao.BaseDao;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WifiNetwork;
import cz.mobilesoft.coreblock.util.helperextension.StringHelper;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public abstract class WifiNetworkDao implements BaseDao<WifiNetwork> {
    public abstract Object J(Collection collection, Continuation continuation);

    public abstract Object K(long j3, Continuation continuation);

    public abstract Object L(Collection collection, Continuation continuation);

    public final Object M(String str, Continuation continuation) {
        return N(str, StringHelper.w(str), continuation);
    }

    public abstract Object N(String str, String str2, Continuation continuation);
}
