package cz.mobilesoft.coreblock.storage.room.management;

import android.database.Cursor;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareConstants;
import cz.mobilesoft.coreblock.BuildConfig;
import cz.mobilesoft.coreblock.scene.more.academy.AcademyCourseState;
import cz.mobilesoft.coreblock.scene.more.academy.AcademyLessonState;
import cz.mobilesoft.coreblock.storage.room.entity.core.AcademyCourseEntity;
import cz.mobilesoft.coreblock.storage.room.entity.core.AcademyLessonEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.storage.room.management.CoreDatabaseCallback$onCreate$1", f = "CoreDatabaseCallback.kt", l = {28, 66, 127}, m = "invokeSuspend", v = 1)
final class CoreDatabaseCallback$onCreate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f126664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f126665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f126666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f126667d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ CoreDatabaseCallback f126668f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CoreDatabaseCallback$onCreate$1(CoreDatabaseCallback coreDatabaseCallback, Continuation continuation) {
        super(2, continuation);
        this.f126668f = coreDatabaseCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List A(Exception exc) {
        if (!BuildConfig.f95357b.booleanValue()) {
            return null;
        }
        exc.printStackTrace();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List G(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            long j3 = cursor.getLong(cursor.getColumnIndex("_ID"));
            int i3 = cursor.getInt(cursor.getColumnIndex("COURSE_ORDER"));
            String string = cursor.getString(cursor.getColumnIndex(ShareConstants.TITLE));
            String string2 = cursor.getString(cursor.getColumnIndex(ViewHierarchyConstants.LEAD));
            String string3 = cursor.getString(cursor.getColumnIndex("ICON_URL"));
            int i4 = cursor.getInt(cursor.getColumnIndex("COURSE_STATE"));
            Intrinsics.checkNotNull(string);
            Intrinsics.checkNotNull(string2);
            Intrinsics.checkNotNull(string3);
            arrayList.add(new AcademyCourseEntity(j3, i3, string, string2, string3, AcademyCourseState.Companion.a(i4)));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List J(Exception exc) {
        if (!BuildConfig.f95357b.booleanValue()) {
            return null;
        }
        exc.printStackTrace();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List K(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            long j3 = cursor.getLong(cursor.getColumnIndex("_ID"));
            long j4 = cursor.getLong(cursor.getColumnIndex("COURSE_ID"));
            int i3 = cursor.getInt(cursor.getColumnIndex("LESSON_ORDER"));
            String string = cursor.getString(cursor.getColumnIndex(ShareConstants.TITLE));
            String string2 = cursor.getString(cursor.getColumnIndex(ViewHierarchyConstants.LEAD));
            int columnIndex = cursor.getColumnIndex("BODY");
            String string3 = !cursor.isNull(columnIndex) ? cursor.getString(columnIndex) : null;
            int columnIndex2 = cursor.getColumnIndex("UNLOCKED_AT");
            Long lValueOf = !cursor.isNull(columnIndex2) ? Long.valueOf(cursor.getLong(columnIndex2)) : null;
            int columnIndex3 = cursor.getColumnIndex("FINISHED_AT");
            Long lValueOf2 = cursor.isNull(columnIndex3) ? null : Long.valueOf(cursor.getLong(columnIndex3));
            int i4 = cursor.getInt(cursor.getColumnIndex("LESSON_STATE"));
            Long l3 = lValueOf;
            Intrinsics.checkNotNull(string);
            Intrinsics.checkNotNull(string2);
            if (string3 == null) {
                string3 = "";
            }
            long jLongValue = 0;
            long jLongValue2 = l3 != null ? l3.longValue() : 0L;
            if (lValueOf2 != null) {
                jLongValue = lValueOf2.longValue();
            }
            arrayList.add(new AcademyLessonEntity(j3, j4, i3, string, string2, string3, jLongValue2, jLongValue, AcademyLessonState.Companion.a(i4)));
        }
        return arrayList;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new CoreDatabaseCallback$onCreate$1(this.f126668f, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0086, code lost:
    
        if (r8 == r0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00bc, code lost:
    
        if (r4.t(r5, r7) == r0) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009f  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r7.f126667d
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L37
            if (r1 == r5) goto L33
            if (r1 == r4) goto L27
            if (r1 != r3) goto L1f
            java.lang.Object r0 = r7.f126665b
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r0 = r7.f126664a
            android.database.sqlite.SQLiteDatabase r0 = (android.database.sqlite.SQLiteDatabase) r0
            kotlin.ResultKt.b(r8)
            goto Lbf
        L1f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L27:
            java.lang.Object r1 = r7.f126665b
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r1 = r7.f126664a
            android.database.sqlite.SQLiteDatabase r1 = (android.database.sqlite.SQLiteDatabase) r1
            kotlin.ResultKt.b(r8)
            goto L89
        L33:
            kotlin.ResultKt.b(r8)
            goto L46
        L37:
            kotlin.ResultKt.b(r8)
            cz.mobilesoft.coreblock.storage.room.management.CoreDatabaseCallback r8 = r7.f126668f
            r7.f126667d = r5
            java.lang.Object r8 = cz.mobilesoft.coreblock.storage.room.management.CoreDatabaseCallback.g(r8, r7)
            if (r8 != r0) goto L46
            goto Lbe
        L46:
            java.lang.Class<cz.mobilesoft.coreblock.storage.greendao.GreendaoDatabase> r8 = cz.mobilesoft.coreblock.storage.greendao.GreendaoDatabase.class
            r1 = 6
            r5 = 0
            java.lang.Object r8 = org.koin.java.KoinJavaComponent.c(r8, r5, r5, r1, r5)
            cz.mobilesoft.coreblock.storage.greendao.GreendaoDatabase r8 = (cz.mobilesoft.coreblock.storage.greendao.GreendaoDatabase) r8
            android.database.sqlite.SQLiteDatabase r1 = r8.a()
            if (r1 != 0) goto L59
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        L59:
            cz.mobilesoft.coreblock.storage.room.management.w r8 = new cz.mobilesoft.coreblock.storage.room.management.w
            r8.<init>()
            cz.mobilesoft.coreblock.storage.room.management.x r5 = new cz.mobilesoft.coreblock.storage.room.management.x
            r5.<init>()
            java.lang.String r6 = "SELECT * FROM ACADEMY_COURSE"
            java.lang.Object r8 = cz.mobilesoft.coreblock.util.helperextension.DatabaseExtKt.f(r1, r6, r8, r5)
            java.util.List r8 = (java.util.List) r8
            if (r8 == 0) goto L8b
            cz.mobilesoft.coreblock.repository.AcademyRepository r5 = cz.mobilesoft.coreblock.repository.AcademyRepository.f97249a
            cz.mobilesoft.coreblock.storage.room.dao.core.AcademyCourseDao r5 = r5.h()
            r6 = r8
            java.util.Collection r6 = (java.util.Collection) r6
            r7.f126664a = r1
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
            r7.f126665b = r8
            r7.f126666c = r2
            r7.f126667d = r4
            java.lang.Object r8 = r5.t(r6, r7)
            if (r8 != r0) goto L89
            goto Lbe
        L89:
            java.util.List r8 = (java.util.List) r8
        L8b:
            cz.mobilesoft.coreblock.storage.room.management.y r8 = new cz.mobilesoft.coreblock.storage.room.management.y
            r8.<init>()
            cz.mobilesoft.coreblock.storage.room.management.z r4 = new cz.mobilesoft.coreblock.storage.room.management.z
            r4.<init>()
            java.lang.String r5 = "SELECT * FROM ACADEMY_LESSON"
            java.lang.Object r8 = cz.mobilesoft.coreblock.util.helperextension.DatabaseExtKt.f(r1, r5, r8, r4)
            java.util.List r8 = (java.util.List) r8
            if (r8 == 0) goto Lbf
            cz.mobilesoft.coreblock.repository.AcademyRepository r4 = cz.mobilesoft.coreblock.repository.AcademyRepository.f97249a
            cz.mobilesoft.coreblock.storage.room.dao.core.AcademyLessonDao r4 = r4.j()
            r5 = r8
            java.util.Collection r5 = (java.util.Collection) r5
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.a(r1)
            r7.f126664a = r1
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
            r7.f126665b = r8
            r7.f126666c = r2
            r7.f126667d = r3
            java.lang.Object r8 = r4.t(r5, r7)
            if (r8 != r0) goto Lbf
        Lbe:
            return r0
        Lbf:
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.management.CoreDatabaseCallback$onCreate$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((CoreDatabaseCallback$onCreate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
