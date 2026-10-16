package cz.mobilesoft.coreblock.storage.room.dao.core;

import androidx.collection.LongSparseArray;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.EntityUpsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.RelationUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.google.android.material.bottomsheet.lKiE.YznnJpHcAmeoW;
import cz.mobilesoft.coreblock.scene.more.academy.AcademyCourseState;
import cz.mobilesoft.coreblock.scene.more.academy.AcademyLessonState;
import cz.mobilesoft.coreblock.storage.room.academy.AcademyCourseWithLessons;
import cz.mobilesoft.coreblock.storage.room.entity.core.AcademyCourseEntity;
import cz.mobilesoft.coreblock.storage.room.entity.core.AcademyLessonEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
public final class AcademyCourseDao_Impl implements AcademyCourseDao {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Companion f125800i = new Companion(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f125801j = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f125802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertAdapter f125803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AcademyCourseState.Converter f125804c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f125805d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f125806f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final EntityUpsertAdapter f125807g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AcademyLessonState.Converter f125808h;

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

    public AcademyCourseDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.f125804c = new AcademyCourseState.Converter();
        this.f125808h = new AcademyLessonState.Converter();
        this.f125802a = __db;
        this.f125803b = new EntityInsertAdapter<AcademyCourseEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.AcademyCourseDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT OR REPLACE INTO `academy_course` (`id`,`course_order`,`title`,`lead`,`icon_url`,`course_state`) VALUES (?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, AcademyCourseEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.c());
                statement.A(2, entity.e());
                statement.p0(3, entity.f());
                statement.p0(4, entity.d());
                statement.p0(5, entity.b());
                statement.A(6, AcademyCourseDao_Impl.this.f125804c.b(entity.a()));
            }
        };
        this.f125805d = new EntityDeleteOrUpdateAdapter<AcademyCourseEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.AcademyCourseDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "DELETE FROM `academy_course` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, AcademyCourseEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.c());
            }
        };
        this.f125806f = new EntityDeleteOrUpdateAdapter<AcademyCourseEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.AcademyCourseDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE OR ABORT `academy_course` SET `id` = ?,`course_order` = ?,`title` = ?,`lead` = ?,`icon_url` = ?,`course_state` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, AcademyCourseEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.c());
                statement.A(2, entity.e());
                statement.p0(3, entity.f());
                statement.p0(4, entity.d());
                statement.p0(5, entity.b());
                statement.A(6, AcademyCourseDao_Impl.this.f125804c.b(entity.a()));
                statement.A(7, entity.c());
            }
        };
        this.f125807g = new EntityUpsertAdapter(new EntityInsertAdapter<AcademyCourseEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.AcademyCourseDao_Impl.4
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT INTO `academy_course` (`id`,`course_order`,`title`,`lead`,`icon_url`,`course_state`) VALUES (?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, AcademyCourseEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.c());
                statement.A(2, entity.e());
                statement.p0(3, entity.f());
                statement.p0(4, entity.d());
                statement.p0(5, entity.b());
                statement.A(6, AcademyCourseDao_Impl.this.f125804c.b(entity.a()));
            }
        }, new EntityDeleteOrUpdateAdapter<AcademyCourseEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.AcademyCourseDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE `academy_course` SET `id` = ?,`course_order` = ?,`title` = ?,`lead` = ?,`icon_url` = ?,`course_state` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, AcademyCourseEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.c());
                statement.A(2, entity.e());
                statement.p0(3, entity.f());
                statement.p0(4, entity.d());
                statement.p0(5, entity.b());
                statement.A(6, AcademyCourseDao_Impl.this.f125804c.b(entity.a()));
                statement.A(7, entity.c());
            }
        });
    }

    private final void S(final SQLiteConnection sQLiteConnection, LongSparseArray longSparseArray) {
        if (longSparseArray.j()) {
            return;
        }
        int i3 = 1;
        if (longSparseArray.r() > 999) {
            RelationUtil.b(longSparseArray, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.h
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AcademyCourseDao_Impl.T(this.f126201a, sQLiteConnection, (LongSparseArray) obj);
                }
            });
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT `id`,`course_id`,`lesson_order`,`title`,`lead`,`body`,`unlocked_at`,`finished_at`,`lesson_state` FROM `academy_lesson` WHERE `course_id` IN (");
        StringUtil.a(sb, longSparseArray.r());
        sb.append(")");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        SQLiteStatement sQLiteStatementG2 = sQLiteConnection.G2(string);
        int iR = longSparseArray.r();
        int i4 = 0;
        int i5 = 1;
        for (int i6 = 0; i6 < iR; i6++) {
            sQLiteStatementG2.A(i5, longSparseArray.k(i6));
            i5++;
        }
        try {
            int iC = SQLiteStatementUtil.c(sQLiteStatementG2, "course_id");
            if (iC == -1) {
                return;
            }
            while (sQLiteStatementG2.B2()) {
                List list = (List) longSparseArray.g(sQLiteStatementG2.getLong(iC));
                if (list != null) {
                    list.add(new AcademyLessonEntity(sQLiteStatementG2.getLong(i4), sQLiteStatementG2.getLong(i3), (int) sQLiteStatementG2.getLong(2), sQLiteStatementG2.f2(3), sQLiteStatementG2.f2(4), sQLiteStatementG2.f2(5), sQLiteStatementG2.getLong(6), sQLiteStatementG2.getLong(7), this.f125808h.a((int) sQLiteStatementG2.getLong(8))));
                    i4 = 0;
                    i3 = 1;
                }
            }
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T(AcademyCourseDao_Impl academyCourseDao_Impl, SQLiteConnection sQLiteConnection, LongSparseArray _tmpMap) {
        Intrinsics.checkNotNullParameter(_tmpMap, "_tmpMap");
        academyCourseDao_Impl.S(sQLiteConnection, _tmpMap);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W(String str, AcademyCourseDao_Impl academyCourseDao_Impl, AcademyCourseState academyCourseState, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, academyCourseDao_Impl.f125804c.b(academyCourseState));
            sQLiteStatementG2.B2();
            sQLiteStatementG2.close();
            return Unit.f139807a;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X(String str, SQLiteConnection _connection) {
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
    public static final List Z(String str, Collection collection, AcademyCourseDao_Impl academyCourseDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = collection.iterator();
            int i3 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.A(i3, ((Number) it.next()).longValue());
                i3++;
            }
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "course_order");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "title");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "lead");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "icon_url");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "course_state");
            LongSparseArray longSparseArray = new LongSparseArray(0, 1, null);
            while (sQLiteStatementG2.B2()) {
                long j3 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray.e(j3)) {
                    longSparseArray.m(j3, new ArrayList());
                }
            }
            sQLiteStatementG2.reset();
            academyCourseDao_Impl.S(_connection, longSparseArray);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                int i4 = iD2;
                AcademyCourseEntity academyCourseEntity = new AcademyCourseEntity(sQLiteStatementG2.getLong(iD), (int) sQLiteStatementG2.getLong(iD2), sQLiteStatementG2.f2(iD3), sQLiteStatementG2.f2(iD4), sQLiteStatementG2.f2(iD5), academyCourseDao_Impl.f125804c.a((int) sQLiteStatementG2.getLong(iD6)));
                Object objG = longSparseArray.g(sQLiteStatementG2.getLong(iD));
                if (objG == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                arrayList.add(new AcademyCourseWithLessons(academyCourseEntity, (List) objG));
                iD2 = i4;
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AcademyCourseWithLessons a0(String str, long j3, AcademyCourseDao_Impl academyCourseDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "course_order");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "title");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "lead");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "icon_url");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "course_state");
            AcademyCourseWithLessons academyCourseWithLessons = null;
            LongSparseArray longSparseArray = new LongSparseArray(0, 1, null);
            while (sQLiteStatementG2.B2()) {
                long j4 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray.e(j4)) {
                    longSparseArray.m(j4, new ArrayList());
                }
            }
            sQLiteStatementG2.reset();
            academyCourseDao_Impl.S(_connection, longSparseArray);
            if (sQLiteStatementG2.B2()) {
                AcademyCourseEntity academyCourseEntity = new AcademyCourseEntity(sQLiteStatementG2.getLong(iD), (int) sQLiteStatementG2.getLong(iD2), sQLiteStatementG2.f2(iD3), sQLiteStatementG2.f2(iD4), sQLiteStatementG2.f2(iD5), academyCourseDao_Impl.f125804c.a((int) sQLiteStatementG2.getLong(iD6)));
                Object objG = longSparseArray.g(sQLiteStatementG2.getLong(iD));
                if (objG == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                academyCourseWithLessons = new AcademyCourseWithLessons(academyCourseEntity, (List) objG);
            }
            sQLiteStatementG2.close();
            return academyCourseWithLessons;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AcademyCourseWithLessons b0(String str, long j3, AcademyCourseDao_Impl academyCourseDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "course_order");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "title");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "lead");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "icon_url");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "course_state");
            AcademyCourseWithLessons academyCourseWithLessons = null;
            LongSparseArray longSparseArray = new LongSparseArray(0, 1, null);
            while (sQLiteStatementG2.B2()) {
                long j4 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray.e(j4)) {
                    longSparseArray.m(j4, new ArrayList());
                }
            }
            sQLiteStatementG2.reset();
            academyCourseDao_Impl.S(_connection, longSparseArray);
            if (sQLiteStatementG2.B2()) {
                AcademyCourseEntity academyCourseEntity = new AcademyCourseEntity(sQLiteStatementG2.getLong(iD), (int) sQLiteStatementG2.getLong(iD2), sQLiteStatementG2.f2(iD3), sQLiteStatementG2.f2(iD4), sQLiteStatementG2.f2(iD5), academyCourseDao_Impl.f125804c.a((int) sQLiteStatementG2.getLong(iD6)));
                Object objG = longSparseArray.g(sQLiteStatementG2.getLong(iD));
                if (objG == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                academyCourseWithLessons = new AcademyCourseWithLessons(academyCourseEntity, (List) objG);
            }
            sQLiteStatementG2.close();
            return academyCourseWithLessons;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List c0(AcademyCourseDao_Impl academyCourseDao_Impl, Collection collection, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return academyCourseDao_Impl.f125803b.e(_connection, collection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d0(AcademyCourseDao_Impl academyCourseDao_Impl, Collection collection, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        academyCourseDao_Impl.f125806f.d(_connection, collection);
        return Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.AcademyCourseDao
    public Object a(final Collection collection, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ACADEMY_COURSE WHERE ID IN (");
        StringUtil.a(sb, collection.size());
        sb.append(") ORDER BY COURSE_ORDER");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.g(this.f125802a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AcademyCourseDao_Impl.Z(string, collection, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.AcademyCourseDao
    public LiveData c(final long j3) {
        final String str = "SELECT * FROM ACADEMY_COURSE WHERE ID = ?";
        return this.f125802a.getInvalidationTracker().p(new String[]{"academy_lesson", "ACADEMY_COURSE"}, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AcademyCourseDao_Impl.b0(str, j3, this, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.AcademyCourseDao
    public /* bridge */ Object d(Continuation continuation) {
        return super.d(continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.AcademyCourseDao
    public Object deleteAll(Continuation continuation) {
        final String str = "DELETE FROM ACADEMY_COURSE";
        Object objG = DBUtil.g(this.f125802a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AcademyCourseDao_Impl.X(str, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.AcademyCourseDao
    public Object e(final long j3, Continuation continuation) {
        final String str = "SELECT * FROM ACADEMY_COURSE WHERE ID = ?";
        return DBUtil.g(this.f125802a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AcademyCourseDao_Impl.a0(str, j3, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.AcademyCourseDao
    public Flow getAll() {
        final String str = "SELECT * FROM ACADEMY_COURSE";
        return FlowUtil.a(this.f125802a, true, new String[]{"academy_lesson", "ACADEMY_COURSE"}, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AcademyCourseDao_Impl.Y(str, this, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.AcademyCourseDao
    public Object m(List list, Continuation continuation) {
        Object objF = DBUtil.f(this.f125802a, new AcademyCourseDao_Impl$updateCourseStates$2(this, list, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object r(final Collection collection, Continuation continuation) {
        Object objG = DBUtil.g(this.f125802a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AcademyCourseDao_Impl.d0(this.f126193a, collection, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object t(final Collection collection, Continuation continuation) {
        return DBUtil.g(this.f125802a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AcademyCourseDao_Impl.c0(this.f126179a, collection, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.AcademyCourseDao
    public Object w(final AcademyCourseState academyCourseState, Continuation continuation) {
        final String str = "UPDATE ACADEMY_COURSE SET COURSE_STATE = ?";
        Object objG = DBUtil.g(this.f125802a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AcademyCourseDao_Impl.W(str, this, academyCourseState, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List Y(String str, AcademyCourseDao_Impl academyCourseDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "course_order");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "title");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "lead");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, YznnJpHcAmeoW.DIkgQrqwckzJUiz);
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "course_state");
            LongSparseArray longSparseArray = new LongSparseArray(0, 1, null);
            while (sQLiteStatementG2.B2()) {
                long j3 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray.e(j3)) {
                    longSparseArray.m(j3, new ArrayList());
                }
            }
            sQLiteStatementG2.reset();
            academyCourseDao_Impl.S(_connection, longSparseArray);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                AcademyCourseEntity academyCourseEntity = new AcademyCourseEntity(sQLiteStatementG2.getLong(iD), (int) sQLiteStatementG2.getLong(iD2), sQLiteStatementG2.f2(iD3), sQLiteStatementG2.f2(iD4), sQLiteStatementG2.f2(iD5), academyCourseDao_Impl.f125804c.a((int) sQLiteStatementG2.getLong(iD6)));
                Object objG = longSparseArray.g(sQLiteStatementG2.getLong(iD));
                if (objG == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                arrayList.add(new AcademyCourseWithLessons(academyCourseEntity, (List) objG));
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }
}
