package cz.mobilesoft.coreblock.storage.room.dao.core;

import com.facebook.appevents.AppEventsConstants;
import cz.mobilesoft.coreblock.storage.room.dao.BaseDao;
import cz.mobilesoft.coreblock.storage.room.entity.core.ConfigType;
import cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;

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
public abstract class CustomBlockingScreenConfigDao implements BaseDao<CustomBlockingScreenConfigEntity> {
    static /* synthetic */ Object N(CustomBlockingScreenConfigDao customBlockingScreenConfigDao, List list, Continuation continuation) {
        ArrayList arrayList = new ArrayList();
        List list2 = list;
        boolean z2 = list2 instanceof Collection;
        if (z2 && list2.isEmpty()) {
            arrayList.add(new CustomBlockingScreenConfigEntity(AppEventsConstants.EVENT_PARAM_VALUE_YES, ConfigType.DEFAULT, null, false, 0, false, 0, null, null, null, null, 2044, null));
        } else {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                if (((CustomBlockingScreenConfigEntity) it.next()).m() == ConfigType.DEFAULT) {
                    break;
                }
            }
            arrayList.add(new CustomBlockingScreenConfigEntity(AppEventsConstants.EVENT_PARAM_VALUE_YES, ConfigType.DEFAULT, null, false, 0, false, 0, null, null, null, null, 2044, null));
        }
        if (z2 && list2.isEmpty()) {
            arrayList.add(new CustomBlockingScreenConfigEntity("2", ConfigType.ROTATING, null, false, 0, false, 0, null, null, null, null, 2044, null));
        } else {
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                if (((CustomBlockingScreenConfigEntity) it2.next()).m() == ConfigType.ROTATING) {
                    break;
                }
            }
            arrayList.add(new CustomBlockingScreenConfigEntity("2", ConfigType.ROTATING, null, false, 0, false, 0, null, null, null, null, 2044, null));
        }
        Object objJ = customBlockingScreenConfigDao.j(CollectionsKt.plus((Collection) arrayList, (Iterable) list2), continuation);
        return objJ == IntrinsicsKt.f() ? objJ : Unit.f139807a;
    }

    public abstract Flow J();

    public abstract Flow K(String str);

    public abstract Object L(ConfigType configType, Continuation continuation);

    public Object M(List list, Continuation continuation) {
        return N(this, list, continuation);
    }

    public abstract void b();
}
