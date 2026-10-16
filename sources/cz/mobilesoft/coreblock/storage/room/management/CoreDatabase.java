package cz.mobilesoft.coreblock.storage.room.management;

import androidx.room.RoomDatabase;
import cz.mobilesoft.coreblock.storage.room.dao.core.AcademyCourseDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.AcademyLessonDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.AppVersionDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.EmergencyUnblockingDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.LaunchTimeDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.MoodCheckInEntityDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.PricingPhaseDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.ProductDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.PurchasedOfferDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.SubscriptionOptionDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.TokenFCMDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.UsedBackdoorCodeDao;
import kotlin.Metadata;

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
public abstract class CoreDatabase extends RoomDatabase {
    public abstract UsedBackdoorCodeDao A();

    public abstract AcademyCourseDao n();

    public abstract AcademyLessonDao o();

    public abstract AppVersionDao p();

    public abstract CustomBlockingScreenConfigDao q();

    public abstract EmergencyUnblockingDao r();

    public abstract IgnoredStatisticsItemDao s();

    public abstract LaunchTimeDao t();

    public abstract MoodCheckInEntityDao u();

    public abstract PricingPhaseDao v();

    public abstract ProductDao w();

    public abstract PurchasedOfferDao x();

    public abstract SubscriptionOptionDao y();

    public abstract TokenFCMDao z();
}
