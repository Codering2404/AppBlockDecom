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
import cz.mobilesoft.coreblock.scene.more.academy.AcademyCourseState;
import cz.mobilesoft.coreblock.scene.more.academy.AcademyLessonState;
import cz.mobilesoft.coreblock.storage.room.academy.AcademyLessonWithCourse;
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
public final class AcademyLessonDao_Impl implements AcademyLessonDao {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Companion f125821i = new Companion(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f125822j = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f125823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertAdapter f125824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AcademyLessonState.Converter f125825c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f125826d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f125827f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final EntityUpsertAdapter f125828g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AcademyCourseState.Converter f125829h;

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

    public AcademyLessonDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.f125825c = new AcademyLessonState.Converter();
        this.f125829h = new AcademyCourseState.Converter();
        this.f125823a = __db;
        this.f125824b = new EntityInsertAdapter<AcademyLessonEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.AcademyLessonDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT OR REPLACE INTO `academy_lesson` (`id`,`course_id`,`lesson_order`,`title`,`lead`,`body`,`unlocked_at`,`finished_at`,`lesson_state`) VALUES (?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, AcademyLessonEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.d());
                statement.A(2, entity.b());
                statement.A(3, entity.g());
                statement.p0(4, entity.h());
                statement.p0(5, entity.e());
                statement.p0(6, entity.a());
                statement.A(7, entity.i());
                statement.A(8, entity.c());
                statement.A(9, AcademyLessonDao_Impl.this.f125825c.b(entity.f()));
            }
        };
        this.f125826d = new EntityDeleteOrUpdateAdapter<AcademyLessonEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.AcademyLessonDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "DELETE FROM `academy_lesson` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, AcademyLessonEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.d());
            }
        };
        this.f125827f = new EntityDeleteOrUpdateAdapter<AcademyLessonEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.AcademyLessonDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE OR ABORT `academy_lesson` SET `id` = ?,`course_id` = ?,`lesson_order` = ?,`title` = ?,`lead` = ?,`body` = ?,`unlocked_at` = ?,`finished_at` = ?,`lesson_state` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, AcademyLessonEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.d());
                statement.A(2, entity.b());
                statement.A(3, entity.g());
                statement.p0(4, entity.h());
                statement.p0(5, entity.e());
                statement.p0(6, entity.a());
                statement.A(7, entity.i());
                statement.A(8, entity.c());
                statement.A(9, AcademyLessonDao_Impl.this.f125825c.b(entity.f()));
                statement.A(10, entity.d());
            }
        };
        this.f125828g = new EntityUpsertAdapter(new EntityInsertAdapter<AcademyLessonEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.AcademyLessonDao_Impl.4
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT INTO `academy_lesson` (`id`,`course_id`,`lesson_order`,`title`,`lead`,`body`,`unlocked_at`,`finished_at`,`lesson_state`) VALUES (?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, AcademyLessonEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.d());
                statement.A(2, entity.b());
                statement.A(3, entity.g());
                statement.p0(4, entity.h());
                statement.p0(5, entity.e());
                statement.p0(6, entity.a());
                statement.A(7, entity.i());
                statement.A(8, entity.c());
                statement.A(9, AcademyLessonDao_Impl.this.f125825c.b(entity.f()));
            }
        }, new EntityDeleteOrUpdateAdapter<AcademyLessonEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.AcademyLessonDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE `academy_lesson` SET `id` = ?,`course_id` = ?,`lesson_order` = ?,`title` = ?,`lead` = ?,`body` = ?,`unlocked_at` = ?,`finished_at` = ?,`lesson_state` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, AcademyLessonEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.d());
                statement.A(2, entity.b());
                statement.A(3, entity.g());
                statement.p0(4, entity.h());
                statement.p0(5, entity.e());
                statement.p0(6, entity.a());
                statement.A(7, entity.i());
                statement.A(8, entity.c());
                statement.A(9, AcademyLessonDao_Impl.this.f125825c.b(entity.f()));
                statement.A(10, entity.d());
            }
        });
    }

    private final void T(final SQLiteConnection sQLiteConnection, LongSparseArray longSparseArray) {
        if (longSparseArray.j()) {
            return;
        }
        if (longSparseArray.r() > 999) {
            RelationUtil.b(longSparseArray, false, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.q
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AcademyLessonDao_Impl.U(this.f126291a, sQLiteConnection, (LongSparseArray) obj);
                }
            });
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT `id`,`course_order`,`title`,`lead`,`icon_url`,`course_state` FROM `academy_course` WHERE `id` IN (");
        StringUtil.a(sb, longSparseArray.r());
        sb.append(")");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        SQLiteStatement sQLiteStatementG2 = sQLiteConnection.G2(string);
        int iR = longSparseArray.r();
        int i3 = 1;
        for (int i4 = 0; i4 < iR; i4++) {
            sQLiteStatementG2.A(i3, longSparseArray.k(i4));
            i3++;
        }
        try {
            int iC = SQLiteStatementUtil.c(sQLiteStatementG2, "id");
            if (iC == -1) {
                return;
            }
            while (sQLiteStatementG2.B2()) {
                long j3 = sQLiteStatementG2.getLong(iC);
                if (longSparseArray.e(j3)) {
                    longSparseArray.m(j3, new AcademyCourseEntity(sQLiteStatementG2.getLong(0), (int) sQLiteStatementG2.getLong(1), sQLiteStatementG2.f2(2), sQLiteStatementG2.f2(3), sQLiteStatementG2.f2(4), this.f125829h.a((int) sQLiteStatementG2.getLong(5))));
                }
            }
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(AcademyLessonDao_Impl academyLessonDao_Impl, SQLiteConnection sQLiteConnection, LongSparseArray _tmpMap) {
        Intrinsics.checkNotNullParameter(_tmpMap, "_tmpMap");
        academyLessonDao_Impl.T(sQLiteConnection, _tmpMap);
        return Unit.f139807a;
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
    public static final List Y(String str, AcademyLessonDao_Impl academyLessonDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "course_id");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "lesson_order");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "title");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "lead");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "body");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "unlocked_at");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "finished_at");
            int iD9 = SQLiteStatementUtil.d(sQLiteStatementG2, "lesson_state");
            LongSparseArray longSparseArray = new LongSparseArray(0, 1, null);
            while (sQLiteStatementG2.B2()) {
                longSparseArray.m(sQLiteStatementG2.getLong(iD2), null);
            }
            sQLiteStatementG2.reset();
            academyLessonDao_Impl.T(_connection, longSparseArray);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                int i3 = iD3;
                int i4 = iD4;
                AcademyLessonEntity academyLessonEntity = new AcademyLessonEntity(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.getLong(iD2), (int) sQLiteStatementG2.getLong(iD3), sQLiteStatementG2.f2(iD4), sQLiteStatementG2.f2(iD5), sQLiteStatementG2.f2(iD6), sQLiteStatementG2.getLong(iD7), sQLiteStatementG2.getLong(iD8), academyLessonDao_Impl.f125825c.a((int) sQLiteStatementG2.getLong(iD9)));
                AcademyCourseEntity academyCourseEntity = (AcademyCourseEntity) longSparseArray.g(sQLiteStatementG2.getLong(iD2));
                if (academyCourseEntity == null) {
                    throw new IllegalStateException("Relationship item 'course' was expected to be NON-NULL but is NULL in @Relation involving a parent column named 'course_id' and entityColumn named 'id'.");
                }
                arrayList.add(new AcademyLessonWithCourse(academyLessonEntity, academyCourseEntity));
                iD3 = i3;
                iD4 = i4;
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List Z(String str, Collection collection, AcademyLessonDao_Impl academyLessonDao_Impl, SQLiteConnection _connection) {
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
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "course_id");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "lesson_order");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "title");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "lead");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "body");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "unlocked_at");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "finished_at");
            int iD9 = SQLiteStatementUtil.d(sQLiteStatementG2, "lesson_state");
            LongSparseArray longSparseArray = new LongSparseArray(0, 1, null);
            while (sQLiteStatementG2.B2()) {
                longSparseArray.m(sQLiteStatementG2.getLong(iD2), null);
                iD8 = iD8;
                iD9 = iD9;
            }
            int i4 = iD8;
            int i5 = iD9;
            sQLiteStatementG2.reset();
            academyLessonDao_Impl.T(_connection, longSparseArray);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                int i6 = i4;
                int i7 = i5;
                int i8 = iD;
                AcademyLessonEntity academyLessonEntity = new AcademyLessonEntity(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.getLong(iD2), (int) sQLiteStatementG2.getLong(iD3), sQLiteStatementG2.f2(iD4), sQLiteStatementG2.f2(iD5), sQLiteStatementG2.f2(iD6), sQLiteStatementG2.getLong(iD7), sQLiteStatementG2.getLong(i6), academyLessonDao_Impl.f125825c.a((int) sQLiteStatementG2.getLong(i7)));
                AcademyCourseEntity academyCourseEntity = (AcademyCourseEntity) longSparseArray.g(sQLiteStatementG2.getLong(iD2));
                if (academyCourseEntity == null) {
                    throw new IllegalStateException("Relationship item 'course' was expected to be NON-NULL but is NULL in @Relation involving a parent column named 'course_id' and entityColumn named 'id'.");
                }
                arrayList.add(new AcademyLessonWithCourse(academyLessonEntity, academyCourseEntity));
                iD = i8;
                i4 = i6;
                i5 = i7;
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AcademyLessonWithCourse a0(String str, long j3, AcademyLessonDao_Impl academyLessonDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "course_id");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "lesson_order");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "title");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "lead");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "body");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "unlocked_at");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "finished_at");
            int iD9 = SQLiteStatementUtil.d(sQLiteStatementG2, "lesson_state");
            AcademyLessonWithCourse academyLessonWithCourse = null;
            LongSparseArray longSparseArray = new LongSparseArray(0, 1, null);
            while (sQLiteStatementG2.B2()) {
                longSparseArray.m(sQLiteStatementG2.getLong(iD2), null);
                iD8 = iD8;
                iD9 = iD9;
            }
            int i3 = iD8;
            int i4 = iD9;
            sQLiteStatementG2.reset();
            academyLessonDao_Impl.T(_connection, longSparseArray);
            if (sQLiteStatementG2.B2()) {
                AcademyLessonEntity academyLessonEntity = new AcademyLessonEntity(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.getLong(iD2), (int) sQLiteStatementG2.getLong(iD3), sQLiteStatementG2.f2(iD4), sQLiteStatementG2.f2(iD5), sQLiteStatementG2.f2(iD6), sQLiteStatementG2.getLong(iD7), sQLiteStatementG2.getLong(i3), academyLessonDao_Impl.f125825c.a((int) sQLiteStatementG2.getLong(i4)));
                AcademyCourseEntity academyCourseEntity = (AcademyCourseEntity) longSparseArray.g(sQLiteStatementG2.getLong(iD2));
                if (academyCourseEntity == null) {
                    throw new IllegalStateException("Relationship item 'course' was expected to be NON-NULL but is NULL in @Relation involving a parent column named 'course_id' and entityColumn named 'id'.");
                }
                academyLessonWithCourse = new AcademyLessonWithCourse(academyLessonEntity, academyCourseEntity);
            }
            sQLiteStatementG2.close();
            return academyLessonWithCourse;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AcademyLessonWithCourse b0(String str, long j3, AcademyLessonDao_Impl academyLessonDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "course_id");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "lesson_order");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "title");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "lead");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "body");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "unlocked_at");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "finished_at");
            int iD9 = SQLiteStatementUtil.d(sQLiteStatementG2, "lesson_state");
            AcademyLessonWithCourse academyLessonWithCourse = null;
            LongSparseArray longSparseArray = new LongSparseArray(0, 1, null);
            while (sQLiteStatementG2.B2()) {
                longSparseArray.m(sQLiteStatementG2.getLong(iD2), null);
                iD8 = iD8;
                iD9 = iD9;
            }
            int i3 = iD8;
            int i4 = iD9;
            sQLiteStatementG2.reset();
            academyLessonDao_Impl.T(_connection, longSparseArray);
            if (sQLiteStatementG2.B2()) {
                AcademyLessonEntity academyLessonEntity = new AcademyLessonEntity(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.getLong(iD2), (int) sQLiteStatementG2.getLong(iD3), sQLiteStatementG2.f2(iD4), sQLiteStatementG2.f2(iD5), sQLiteStatementG2.f2(iD6), sQLiteStatementG2.getLong(iD7), sQLiteStatementG2.getLong(i3), academyLessonDao_Impl.f125825c.a((int) sQLiteStatementG2.getLong(i4)));
                AcademyCourseEntity academyCourseEntity = (AcademyCourseEntity) longSparseArray.g(sQLiteStatementG2.getLong(iD2));
                if (academyCourseEntity == null) {
                    throw new IllegalStateException("Relationship item 'course' was expected to be NON-NULL but is NULL in @Relation involving a parent column named 'course_id' and entityColumn named 'id'.");
                }
                academyLessonWithCourse = new AcademyLessonWithCourse(academyLessonEntity, academyCourseEntity);
            }
            sQLiteStatementG2.close();
            return academyLessonWithCourse;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List c0(String str, Collection collection, AcademyLessonDao_Impl academyLessonDao_Impl, int i3, Collection collection2, int i4, Collection collection3, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = collection.iterator();
            int i5 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.A(i5, academyLessonDao_Impl.f125825c.b((AcademyLessonState) it.next()));
                i5++;
            }
            int i6 = i3 + 1;
            Iterator it2 = collection2.iterator();
            int i7 = i6;
            while (it2.hasNext()) {
                sQLiteStatementG2.A(i7, ((Number) it2.next()).longValue());
                i7++;
            }
            int i8 = i6 + i4;
            Iterator it3 = collection3.iterator();
            while (it3.hasNext()) {
                sQLiteStatementG2.A(i8, ((Number) it3.next()).longValue());
                i8++;
            }
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "course_id");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "lesson_order");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "title");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "lead");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "body");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "unlocked_at");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "finished_at");
            int iD9 = SQLiteStatementUtil.d(sQLiteStatementG2, "lesson_state");
            LongSparseArray longSparseArray = new LongSparseArray(0, 1, null);
            while (sQLiteStatementG2.B2()) {
                longSparseArray.m(sQLiteStatementG2.getLong(iD2), null);
                iD8 = iD8;
                iD9 = iD9;
            }
            int i9 = iD8;
            int i10 = iD9;
            sQLiteStatementG2.reset();
            academyLessonDao_Impl.T(_connection, longSparseArray);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                int i11 = i9;
                int i12 = i10;
                int i13 = iD;
                AcademyLessonEntity academyLessonEntity = new AcademyLessonEntity(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.getLong(iD2), (int) sQLiteStatementG2.getLong(iD3), sQLiteStatementG2.f2(iD4), sQLiteStatementG2.f2(iD5), sQLiteStatementG2.f2(iD6), sQLiteStatementG2.getLong(iD7), sQLiteStatementG2.getLong(i11), academyLessonDao_Impl.f125825c.a((int) sQLiteStatementG2.getLong(i12)));
                AcademyCourseEntity academyCourseEntity = (AcademyCourseEntity) longSparseArray.g(sQLiteStatementG2.getLong(iD2));
                if (academyCourseEntity == null) {
                    throw new IllegalStateException("Relationship item 'course' was expected to be NON-NULL but is NULL in @Relation involving a parent column named 'course_id' and entityColumn named 'id'.");
                }
                arrayList.add(new AcademyLessonWithCourse(academyLessonEntity, academyCourseEntity));
                iD = i13;
                i9 = i11;
                i10 = i12;
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AcademyLessonWithCourse d0(String str, long j3, AcademyLessonDao_Impl academyLessonDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "course_id");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "lesson_order");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "title");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "lead");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "body");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "unlocked_at");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "finished_at");
            int iD9 = SQLiteStatementUtil.d(sQLiteStatementG2, "lesson_state");
            AcademyLessonWithCourse academyLessonWithCourse = null;
            LongSparseArray longSparseArray = new LongSparseArray(0, 1, null);
            while (sQLiteStatementG2.B2()) {
                longSparseArray.m(sQLiteStatementG2.getLong(iD2), null);
                iD8 = iD8;
                iD9 = iD9;
            }
            int i3 = iD8;
            int i4 = iD9;
            sQLiteStatementG2.reset();
            academyLessonDao_Impl.T(_connection, longSparseArray);
            if (sQLiteStatementG2.B2()) {
                AcademyLessonEntity academyLessonEntity = new AcademyLessonEntity(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.getLong(iD2), (int) sQLiteStatementG2.getLong(iD3), sQLiteStatementG2.f2(iD4), sQLiteStatementG2.f2(iD5), sQLiteStatementG2.f2(iD6), sQLiteStatementG2.getLong(iD7), sQLiteStatementG2.getLong(i3), academyLessonDao_Impl.f125825c.a((int) sQLiteStatementG2.getLong(i4)));
                AcademyCourseEntity academyCourseEntity = (AcademyCourseEntity) longSparseArray.g(sQLiteStatementG2.getLong(iD2));
                if (academyCourseEntity == null) {
                    throw new IllegalStateException("Relationship item 'course' was expected to be NON-NULL but is NULL in @Relation involving a parent column named 'course_id' and entityColumn named 'id'.");
                }
                academyLessonWithCourse = new AcademyLessonWithCourse(academyLessonEntity, academyCourseEntity);
            }
            sQLiteStatementG2.close();
            return academyLessonWithCourse;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List e0(AcademyLessonDao_Impl academyLessonDao_Impl, Collection collection, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return academyLessonDao_Impl.f125824b.e(_connection, collection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f0(AcademyLessonDao_Impl academyLessonDao_Impl, Collection collection, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        academyLessonDao_Impl.f125827f.d(_connection, collection);
        return Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.AcademyLessonDao
    public Object a(final Collection collection, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ACADEMY_LESSON WHERE ID IN (");
        StringUtil.a(sb, collection.size());
        sb.append(") ORDER BY LESSON_ORDER");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.g(this.f125823a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AcademyLessonDao_Impl.Z(string, collection, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.AcademyLessonDao
    public LiveData c(final long j3) {
        final String str = "SELECT * FROM ACADEMY_LESSON WHERE ID = ?";
        return this.f125823a.getInvalidationTracker().p(new String[]{"academy_course", "ACADEMY_LESSON"}, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.r
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AcademyLessonDao_Impl.d0(str, j3, this, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.AcademyLessonDao
    public Object d(Continuation continuation) {
        Object objF = DBUtil.f(this.f125823a, new AcademyLessonDao_Impl$clearAllUserData$2(this, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.AcademyLessonDao
    public Object deleteAll(Continuation continuation) {
        final String str = "DELETE FROM ACADEMY_LESSON";
        Object objG = DBUtil.g(this.f125823a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AcademyLessonDao_Impl.X(str, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.AcademyLessonDao
    public Object e(final long j3, Continuation continuation) {
        final String str = "SELECT * FROM ACADEMY_LESSON WHERE ID = ?";
        return DBUtil.g(this.f125823a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.o
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AcademyLessonDao_Impl.a0(str, j3, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.AcademyLessonDao
    public Object k(Continuation continuation) {
        final String str = "SELECT * FROM ACADEMY_LESSON";
        return DBUtil.g(this.f125823a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AcademyLessonDao_Impl.Y(str, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.AcademyLessonDao
    public Object l(final Collection collection, final Collection collection2, final Collection collection3, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ACADEMY_LESSON WHERE LESSON_STATE IN (");
        final int size = collection.size();
        StringUtil.a(sb, size);
        sb.append(") AND ID NOT IN (");
        final int size2 = collection2.size();
        StringUtil.a(sb, size2);
        sb.append(") AND COURSE_ID NOT IN (");
        StringUtil.a(sb, collection3.size());
        sb.append(")");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.g(this.f125823a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AcademyLessonDao_Impl.c0(string, collection, this, size, collection2, size2, collection3, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.AcademyLessonDao
    public Flow o(final long j3) {
        final String str = "SELECT * FROM ACADEMY_LESSON WHERE ID = ?";
        return FlowUtil.a(this.f125823a, true, new String[]{"academy_course", "ACADEMY_LESSON"}, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.s
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AcademyLessonDao_Impl.b0(str, j3, this, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object r(final Collection collection, Continuation continuation) {
        Object objG = DBUtil.g(this.f125823a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AcademyLessonDao_Impl.f0(this.f126253a, collection, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object t(final Collection collection, Continuation continuation) {
        return DBUtil.g(this.f125823a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AcademyLessonDao_Impl.e0(this.f126279a, collection, (SQLiteConnection) obj);
            }
        }, continuation);
    }
}
