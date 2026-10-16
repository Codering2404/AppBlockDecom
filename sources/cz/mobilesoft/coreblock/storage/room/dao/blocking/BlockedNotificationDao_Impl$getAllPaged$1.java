package cz.mobilesoft.coreblock.storage.room.dao.blocking;

import androidx.collection.ArrayMap;
import androidx.room.RoomDatabase;
import androidx.room.RoomRawQuery;
import androidx.room.paging.LimitOffsetPagingSource;
import androidx.room.util.DBUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.BlockedNotificationWithApplication;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Application;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.BlockedNotification;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class BlockedNotificationDao_Impl$getAllPaged$1 extends LimitOffsetPagingSource<BlockedNotificationWithApplication> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ BlockedNotificationDao_Impl f124983e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BlockedNotificationDao_Impl$getAllPaged$1(RoomRawQuery roomRawQuery, BlockedNotificationDao_Impl blockedNotificationDao_Impl, RoomDatabase roomDatabase, String[] strArr) {
        super(roomRawQuery, roomDatabase, strArr);
        this.f124983e = blockedNotificationDao_Impl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List t(RoomRawQuery roomRawQuery, BlockedNotificationDao_Impl blockedNotificationDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(roomRawQuery.f());
        roomRawQuery.e().invoke(sQLiteStatementG2);
        try {
            ArrayMap arrayMap = new ArrayMap();
            while (sQLiteStatementG2.B2()) {
                arrayMap.put(sQLiteStatementG2.f2(1), null);
            }
            sQLiteStatementG2.reset();
            blockedNotificationDao_Impl.W(_connection, arrayMap);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new BlockedNotificationWithApplication(new BlockedNotification(sQLiteStatementG2.getLong(0), sQLiteStatementG2.f2(1), sQLiteStatementG2.getLong(2), sQLiteStatementG2.getLong(3), sQLiteStatementG2.isNull(4) ? null : sQLiteStatementG2.f2(4), sQLiteStatementG2.isNull(5) ? null : sQLiteStatementG2.f2(5)), (Application) arrayMap.get(sQLiteStatementG2.f2(1)), sQLiteStatementG2.isNull(9) ? null : Integer.valueOf((int) sQLiteStatementG2.getLong(9))));
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    @Override // androidx.room.paging.LimitOffsetPagingSource
    protected Object k(final RoomRawQuery roomRawQuery, int i3, Continuation continuation) {
        RoomDatabase roomDatabase = this.f124983e.f124978a;
        final BlockedNotificationDao_Impl blockedNotificationDao_Impl = this.f124983e;
        return DBUtil.g(roomDatabase, true, false, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.g1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BlockedNotificationDao_Impl$getAllPaged$1.t(roomRawQuery, blockedNotificationDao_Impl, (SQLiteConnection) obj);
            }
        }, continuation);
    }
}
