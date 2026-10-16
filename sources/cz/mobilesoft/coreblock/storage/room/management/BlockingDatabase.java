package cz.mobilesoft.coreblock.storage.room.management;

import androidx.room.RoomDatabase;
import cz.mobilesoft.coreblock.storage.room.dao.PomodoroSessionDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.AdultContentWebsiteDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.AppWebsiteCategoryDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockSessionDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockedNotificationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.GeoAddressDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakActivitySessionDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakDayDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakPauseRecordDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.SubAppRelationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.WebsiteProfileRelationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.WifiNetworkDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.SchedulePauseHistoryDao;
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
public abstract class BlockingDatabase extends RoomDatabase {
    public abstract SchedulePauseHistoryDao A();

    public abstract StreakActivitySessionDao B();

    public abstract StreakDayDao C();

    public abstract StreakPauseRecordDao D();

    public abstract SubAppRelationDao E();

    public abstract UsageLimitDao F();

    public abstract WebsiteProfileRelationDao G();

    public abstract WifiNetworkDao H();

    public abstract AdultContentWebsiteDao n();

    public abstract AppWebsiteCategoryDao o();

    public abstract ApplicationDao p();

    public abstract ApplicationProfileRelationDao q();

    public abstract BlockSessionDao r();

    public abstract BlockedNotificationDao s();

    public abstract BrowserViewIdDao t();

    public abstract GeoAddressDao u();

    public abstract IntervalDao v();

    public abstract PomodoroHistoryDao w();

    public abstract PomodoroSessionDao x();

    public abstract ProfileDao y();

    public abstract QuickBlockTimerHistoryDao z();
}
