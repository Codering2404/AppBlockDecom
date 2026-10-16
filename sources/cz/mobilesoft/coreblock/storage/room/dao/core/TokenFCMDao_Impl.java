package cz.mobilesoft.coreblock.storage.room.dao.core;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.EntityUpsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.facebook.AccessToken;
import cz.mobilesoft.coreblock.storage.room.entity.core.TokenFCMEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

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
@Metadata
public final class TokenFCMDao_Impl implements TokenFCMDao {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f126133g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f126134h = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f126135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertAdapter f126136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f126137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f126138d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EntityUpsertAdapter f126139f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List a() {
            return CollectionsKt.emptyList();
        }

        private Companion() {
        }
    }

    public TokenFCMDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.f126135a = __db;
        this.f126136b = new EntityInsertAdapter<TokenFCMEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.TokenFCMDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT OR REPLACE INTO `TokenFCMEntity` (`token`,`isSyncedWithServer`) VALUES (?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, TokenFCMEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.a());
                statement.A(2, entity.b() ? 1L : 0L);
            }
        };
        this.f126137c = new EntityDeleteOrUpdateAdapter<TokenFCMEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.TokenFCMDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "DELETE FROM `TokenFCMEntity` WHERE `token` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, TokenFCMEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.a());
            }
        };
        this.f126138d = new EntityDeleteOrUpdateAdapter<TokenFCMEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.TokenFCMDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE OR ABORT `TokenFCMEntity` SET `token` = ?,`isSyncedWithServer` = ? WHERE `token` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, TokenFCMEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.a());
                statement.A(2, entity.b() ? 1L : 0L);
                statement.p0(3, entity.a());
            }
        };
        this.f126139f = new EntityUpsertAdapter(new EntityInsertAdapter<TokenFCMEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.TokenFCMDao_Impl.4
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT INTO `TokenFCMEntity` (`token`,`isSyncedWithServer`) VALUES (?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, TokenFCMEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.a());
                statement.A(2, entity.b() ? 1L : 0L);
            }
        }, new EntityDeleteOrUpdateAdapter<TokenFCMEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.TokenFCMDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE `TokenFCMEntity` SET `token` = ?,`isSyncedWithServer` = ? WHERE `token` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, TokenFCMEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.a());
                statement.A(2, entity.b() ? 1L : 0L);
                statement.p0(3, entity.a());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.B2();
            sQLiteStatementG2.close();
            return Unit.f139807a;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TokenFCMEntity P(String str, SQLiteConnection _connection) {
        TokenFCMEntity tokenFCMEntity;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, AccessToken.TOKEN_KEY);
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "isSyncedWithServer");
            if (sQLiteStatementG2.B2()) {
                tokenFCMEntity = new TokenFCMEntity(sQLiteStatementG2.f2(iD), ((int) sQLiteStatementG2.getLong(iD2)) != 0);
            } else {
                tokenFCMEntity = null;
            }
            return tokenFCMEntity;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TokenFCMEntity Q(String str, SQLiteConnection _connection) {
        TokenFCMEntity tokenFCMEntity;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, AccessToken.TOKEN_KEY);
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "isSyncedWithServer");
            if (sQLiteStatementG2.B2()) {
                tokenFCMEntity = new TokenFCMEntity(sQLiteStatementG2.f2(iD), ((int) sQLiteStatementG2.getLong(iD2)) != 0);
            } else {
                tokenFCMEntity = null;
            }
            return tokenFCMEntity;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long S(TokenFCMDao_Impl tokenFCMDao_Impl, TokenFCMEntity tokenFCMEntity, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return tokenFCMDao_Impl.f126136b.d(_connection, tokenFCMEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(TokenFCMDao_Impl tokenFCMDao_Impl, TokenFCMEntity tokenFCMEntity, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        tokenFCMDao_Impl.f126138d.c(_connection, tokenFCMEntity);
        return Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.TokenFCMDao
    public Flow C() {
        final String str = "SELECT * FROM TokenFCMEntity limit 1";
        return FlowUtil.a(this.f126135a, false, new String[]{"TokenFCMEntity"}, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.r2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TokenFCMDao_Impl.Q(str, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.TokenFCMDao
    public Object G(Continuation continuation) {
        final String str = "SELECT * FROM TokenFCMEntity limit 1";
        return DBUtil.g(this.f126135a, true, false, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.o2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TokenFCMDao_Impl.P(str, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public Object n(final TokenFCMEntity tokenFCMEntity, Continuation continuation) {
        return DBUtil.g(this.f126135a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.p2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(TokenFCMDao_Impl.S(this.f126289a, tokenFCMEntity, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public Object p(final TokenFCMEntity tokenFCMEntity, Continuation continuation) {
        Object objG = DBUtil.g(this.f126135a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.n2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TokenFCMDao_Impl.U(this.f126266a, tokenFCMEntity, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.TokenFCMDao
    public Object i(Continuation continuation) {
        final String str = "DELETE FROM TokenFCMEntity";
        Object objG = DBUtil.g(this.f126135a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.q2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TokenFCMDao_Impl.O(str, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }
}
