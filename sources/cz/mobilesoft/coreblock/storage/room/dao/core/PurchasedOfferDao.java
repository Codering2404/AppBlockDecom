package cz.mobilesoft.coreblock.storage.room.dao.core;

import cz.mobilesoft.coreblock.storage.room.dao.BaseDao;
import cz.mobilesoft.coreblock.storage.room.entity.core.PurchasedOfferEntity;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

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
/* JADX INFO: loaded from: classes8.dex */
@Deprecated
@Metadata
public interface PurchasedOfferDao extends BaseDao<PurchasedOfferEntity> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object E(PurchasedOfferDao purchasedOfferDao, List list, Continuation continuation) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((PurchasedOfferEntity) it.next()).f(true);
        }
        Object objR = purchasedOfferDao.r(list, continuation);
        return objR == IntrinsicsKt.f() ? objR : Unit.f139807a;
    }

    default Object H(List list, Continuation continuation) {
        return E(this, list, continuation);
    }
}
