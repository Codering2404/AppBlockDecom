package cz.mobilesoft.coreblock.storage.room.dao.blocking;

import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import cz.mobilesoft.coreblock.storage.room.dao.BaseDao;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.AdultContentWebsite;
import cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
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
public abstract class AdultContentWebsiteDao implements BaseDao<AdultContentWebsite> {
    private final void L(BlockingDatabase blockingDatabase, List list) throws IOException {
        SupportSQLiteStatement supportSQLiteStatementX1 = blockingDatabase.getOpenHelper().getWritableDatabase().x1("INSERT OR REPLACE INTO `AdultContentWebsite` (`url`) VALUES (?)");
        try {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                supportSQLiteStatementX1.s1(1, ((AdultContentWebsite) it.next()).a());
                supportSQLiteStatementX1.k1();
                supportSQLiteStatementX1.x2();
            }
        } finally {
            supportSQLiteStatementX1.close();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0124, code lost:
    
        if (r14 == r1) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object O(cz.mobilesoft.coreblock.storage.room.dao.blocking.AdultContentWebsiteDao r9, cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase r10, java.util.List r11, java.util.List r12, java.util.List r13, kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 300
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.blocking.AdultContentWebsiteDao.O(cz.mobilesoft.coreblock.storage.room.dao.blocking.AdultContentWebsiteDao, cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase, java.util.List, java.util.List, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public abstract Object J(Continuation continuation);

    public abstract Object K(SupportSQLiteQuery supportSQLiteQuery, Continuation continuation);

    public abstract Object M(String str, Continuation continuation);

    public Object N(BlockingDatabase blockingDatabase, List list, List list2, List list3, Continuation continuation) {
        return O(this, blockingDatabase, list, list2, list3, continuation);
    }

    public abstract Object deleteAll(Continuation continuation);
}
