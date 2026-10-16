package androidx.room;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

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
final /* synthetic */ class RoomDatabaseKt__RoomDatabaseKt {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(androidx.room.RoomDatabase r5, kotlin.jvm.functions.Function2 r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof androidx.room.RoomDatabaseKt__RoomDatabaseKt$useReaderConnection$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.room.RoomDatabaseKt__RoomDatabaseKt$useReaderConnection$1 r0 = (androidx.room.RoomDatabaseKt__RoomDatabaseKt$useReaderConnection$1) r0
            int r1 = r0.f52311d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f52311d = r1
            goto L18
        L13:
            androidx.room.RoomDatabaseKt__RoomDatabaseKt$useReaderConnection$1 r0 = new androidx.room.RoomDatabaseKt__RoomDatabaseKt$useReaderConnection$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f52310c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f52311d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r7)
            return r7
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            java.lang.Object r5 = r0.f52309b
            r6 = r5
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            java.lang.Object r5 = r0.f52308a
            androidx.room.RoomDatabase r5 = (androidx.room.RoomDatabase) r5
            kotlin.ResultKt.b(r7)
            goto L52
        L41:
            kotlin.ResultKt.b(r7)
            r0.f52308a = r5
            r0.f52309b = r6
            r0.f52311d = r4
            r7 = 0
            java.lang.Object r7 = androidx.room.util.DBUtil.d(r5, r7, r0)
            if (r7 != r1) goto L52
            goto L6c
        L52:
            kotlin.coroutines.CoroutineContext r7 = (kotlin.coroutines.CoroutineContext) r7
            androidx.room.RoomExternalOperationElement r2 = androidx.room.RoomExternalOperationElement.f52336a
            kotlin.coroutines.CoroutineContext r7 = r7.plus(r2)
            androidx.room.RoomDatabaseKt__RoomDatabaseKt$useReaderConnection$2 r2 = new androidx.room.RoomDatabaseKt__RoomDatabaseKt$useReaderConnection$2
            r4 = 0
            r2.<init>(r5, r6, r4)
            r0.f52308a = r4
            r0.f52309b = r4
            r0.f52311d = r3
            java.lang.Object r5 = kotlinx.coroutines.BuildersKt.g(r7, r2, r0)
            if (r5 != r1) goto L6d
        L6c:
            return r1
        L6d:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabaseKt__RoomDatabaseKt.a(androidx.room.RoomDatabase, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x006e, code lost:
    
        if (r7 == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object b(androidx.room.RoomDatabase r5, kotlin.jvm.functions.Function2 r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof androidx.room.RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.room.RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$1 r0 = (androidx.room.RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$1) r0
            int r1 = r0.f52318d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f52318d = r1
            goto L18
        L13:
            androidx.room.RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$1 r0 = new androidx.room.RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f52317c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f52318d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L45
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r5 = r0.f52315a
            androidx.room.RoomDatabase r5 = (androidx.room.RoomDatabase) r5
            kotlin.ResultKt.b(r7)
            goto L71
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            java.lang.Object r5 = r0.f52316b
            r6 = r5
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            java.lang.Object r5 = r0.f52315a
            androidx.room.RoomDatabase r5 = (androidx.room.RoomDatabase) r5
            kotlin.ResultKt.b(r7)
            goto L56
        L45:
            kotlin.ResultKt.b(r7)
            r0.f52315a = r5
            r0.f52316b = r6
            r0.f52318d = r4
            r7 = 0
            java.lang.Object r7 = androidx.room.util.DBUtil.d(r5, r7, r0)
            if (r7 != r1) goto L56
            goto L70
        L56:
            kotlin.coroutines.CoroutineContext r7 = (kotlin.coroutines.CoroutineContext) r7
            androidx.room.RoomExternalOperationElement r2 = androidx.room.RoomExternalOperationElement.f52336a
            kotlin.coroutines.CoroutineContext r7 = r7.plus(r2)
            androidx.room.RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$2 r2 = new androidx.room.RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$2
            r4 = 0
            r2.<init>(r5, r6, r4)
            r0.f52315a = r5
            r0.f52316b = r4
            r0.f52318d = r3
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.g(r7, r2, r0)
            if (r7 != r1) goto L71
        L70:
            return r1
        L71:
            androidx.room.InvalidationTracker r5 = r5.getInvalidationTracker()
            r5.B()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabaseKt__RoomDatabaseKt.b(androidx.room.RoomDatabase, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x009e, code lost:
    
        throw new java.lang.IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void c(androidx.room.RoomDatabase r9, androidx.room.DatabaseConfiguration r10) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "configuration"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            java.util.Set r1 = r9.getRequiredAutoMigrationSpecClasses()
            java.util.List r2 = r10.f52145s
            int r2 = r2.size()
            boolean[] r3 = new boolean[r2]
            java.util.Iterator r1 = r1.iterator()
        L1f:
            boolean r4 = r1.hasNext()
            r5 = -1
            if (r4 == 0) goto L7f
            java.lang.Object r4 = r1.next()
            kotlin.reflect.KClass r4 = (kotlin.reflect.KClass) r4
            java.util.List r6 = r10.f52145s
            java.util.Collection r6 = (java.util.Collection) r6
            int r6 = r6.size()
            int r6 = r6 + r5
            if (r6 < 0) goto L4f
        L37:
            int r7 = r6 + (-1)
            java.util.List r8 = r10.f52145s
            java.lang.Object r8 = r8.get(r6)
            boolean r8 = r4.e(r8)
            if (r8 == 0) goto L4a
            r5 = 1
            r3[r6] = r5
            r5 = r6
            goto L4f
        L4a:
            if (r7 >= 0) goto L4d
            goto L4f
        L4d:
            r6 = r7
            goto L37
        L4f:
            if (r5 < 0) goto L5b
            java.util.List r6 = r10.f52145s
            java.lang.Object r5 = r6.get(r5)
            r0.put(r4, r5)
            goto L1f
        L5b:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "A required auto migration spec ("
            r9.append(r10)
            java.lang.String r10 = r4.h()
            r9.append(r10)
            java.lang.String r10 = ") is missing in the database configuration."
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        L7f:
            java.util.List r1 = r10.f52145s
            java.util.Collection r1 = (java.util.Collection) r1
            int r1 = r1.size()
            int r1 = r1 + r5
            if (r1 < 0) goto L9f
        L8a:
            int r4 = r1 + (-1)
            if (r1 >= r2) goto L97
            boolean r1 = r3[r1]
            if (r1 == 0) goto L97
            if (r4 >= 0) goto L95
            goto L9f
        L95:
            r1 = r4
            goto L8a
        L97:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder."
            r9.<init>(r10)
            throw r9
        L9f:
            java.util.List r9 = r9.createAutoMigrations(r0)
            java.util.Iterator r9 = r9.iterator()
        La7:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto Lc5
            java.lang.Object r0 = r9.next()
            androidx.room.migration.Migration r0 = (androidx.room.migration.Migration) r0
            androidx.room.RoomDatabase$MigrationContainer r1 = r10.f52130d
            int r2 = r0.f52660a
            int r3 = r0.f52661b
            boolean r1 = r1.c(r2, r3)
            if (r1 != 0) goto La7
            androidx.room.RoomDatabase$MigrationContainer r1 = r10.f52130d
            r1.a(r0)
            goto La7
        Lc5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabaseKt__RoomDatabaseKt.c(androidx.room.RoomDatabase, androidx.room.DatabaseConfiguration):void");
    }

    public static final void d(Set migrationStartAndEndVersions, Set migrationsNotRequiredFrom) {
        Intrinsics.checkNotNullParameter(migrationStartAndEndVersions, "migrationStartAndEndVersions");
        Intrinsics.checkNotNullParameter(migrationsNotRequiredFrom, "migrationsNotRequiredFrom");
        if (migrationStartAndEndVersions.isEmpty()) {
            return;
        }
        Iterator it = migrationStartAndEndVersions.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            if (migrationsNotRequiredFrom.contains(Integer.valueOf(iIntValue))) {
                throw new IllegalArgumentException(("Inconsistency detected. A Migration was supplied to addMigration() that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(). Start version is: " + iIntValue).toString());
            }
        }
    }

    public static final void e(RoomDatabase roomDatabase, DatabaseConfiguration configuration) {
        Intrinsics.checkNotNullParameter(roomDatabase, "<this>");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Map<KClass<?>, List<KClass<?>>> requiredTypeConverterClassesMap$room_runtime = roomDatabase.getRequiredTypeConverterClassesMap$room_runtime();
        boolean[] zArr = new boolean[configuration.f52144r.size()];
        for (Map.Entry<KClass<?>, List<KClass<?>>> entry : requiredTypeConverterClassesMap$room_runtime.entrySet()) {
            KClass<?> key = entry.getKey();
            for (KClass<?> kClass : entry.getValue()) {
                int size = configuration.f52144r.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i3 = size - 1;
                        if (kClass.e(configuration.f52144r.get(size))) {
                            zArr[size] = true;
                            break;
                        } else if (i3 < 0) {
                            break;
                        } else {
                            size = i3;
                        }
                    }
                    size = -1;
                } else {
                    size = -1;
                }
                if (size < 0) {
                    throw new IllegalArgumentException(("A required type converter (" + kClass.h() + ") for " + key.h() + " is missing in the database configuration.").toString());
                }
                roomDatabase.addTypeConverter$room_runtime(kClass, configuration.f52144r.get(size));
            }
        }
        int size2 = configuration.f52144r.size() - 1;
        if (size2 < 0) {
            return;
        }
        while (true) {
            int i4 = size2 - 1;
            if (!zArr[size2]) {
                throw new IllegalArgumentException("Unexpected type converter " + configuration.f52144r.get(size2) + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
            }
            if (i4 < 0) {
                return;
            } else {
                size2 = i4;
            }
        }
    }
}
