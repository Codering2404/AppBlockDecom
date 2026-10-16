package androidx.room.paging;

import android.database.Cursor;
import androidx.paging.PagingSource;
import androidx.paging.PagingState;
import androidx.room.RoomDatabase;
import androidx.room.RoomRawQuery;
import androidx.room.paging.util.RoomPagingUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.coroutines.Continuation;
import kotlin.jdk7.AutoCloseableKt;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public abstract class LimitOffsetPagingSource<Value> extends PagingSource<Integer, Value> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RoomRawQuery f52708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RoomDatabase f52709c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CommonLimitOffsetImpl f52710d;

    public LimitOffsetPagingSource(RoomRawQuery sourceQuery, RoomDatabase db, String... tables) {
        Intrinsics.checkNotNullParameter(sourceQuery, "sourceQuery");
        Intrinsics.checkNotNullParameter(db, "db");
        Intrinsics.checkNotNullParameter(tables, "tables");
        this.f52708b = sourceQuery;
        this.f52709c = db;
        this.f52710d = new CommonLimitOffsetImpl(tables, this, new LimitOffsetPagingSource$implementation$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List m(RoomRawQuery roomRawQuery, LimitOffsetPagingSource limitOffsetPagingSource, int i3, SQLiteConnection connection) throws Exception {
        Intrinsics.checkNotNullParameter(connection, "connection");
        SQLiteStatement sQLiteStatementG2 = connection.G2(roomRawQuery.f());
        try {
            roomRawQuery.e().invoke(sQLiteStatementG2);
            List listL = limitOffsetPagingSource.l(new SQLiteStatementCursor(sQLiteStatementG2, i3));
            AutoCloseableKt.a(sQLiteStatementG2, null);
            return listL;
        } finally {
        }
    }

    static /* synthetic */ Object n(final LimitOffsetPagingSource limitOffsetPagingSource, final RoomRawQuery roomRawQuery, final int i3, Continuation continuation) {
        return DBUtil.g(limitOffsetPagingSource.f52709c, true, false, new Function1() { // from class: androidx.room.paging.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LimitOffsetPagingSource.m(roomRawQuery, limitOffsetPagingSource, i3, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    static /* synthetic */ Object r(LimitOffsetPagingSource limitOffsetPagingSource, PagingSource.LoadParams loadParams, Continuation continuation) {
        return limitOffsetPagingSource.f52710d.l(loadParams, continuation);
    }

    @Override // androidx.paging.PagingSource
    public boolean c() {
        return true;
    }

    @Override // androidx.paging.PagingSource
    public Object g(PagingSource.LoadParams loadParams, Continuation continuation) {
        return r(this, loadParams, continuation);
    }

    protected Object k(RoomRawQuery roomRawQuery, int i3, Continuation continuation) {
        return n(this, roomRawQuery, i3, continuation);
    }

    protected List l(Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        throw new NotImplementedError("Unexpected call to a function with no implementation that Room is suppose to generate. Please file a bug at: https://issuetracker.google.com/issues/new?component=413107&template=1096568.");
    }

    public final RoomDatabase o() {
        return this.f52709c;
    }

    @Override // androidx.paging.PagingSource
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public Integer e(PagingState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return RoomPagingUtil.a(state);
    }

    public final RoomRawQuery q() {
        return this.f52708b;
    }
}
