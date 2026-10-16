package cz.mobilesoft.coreblock.util.helperextension;

import android.database.sqlite.SQLiteDatabase;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

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
public final class DatabaseExtKt {
    public static final Object a(int i3, long j3, Function1 function1, Continuation continuation) {
        return FlowKt.D(e(FlowKt.I(new DatabaseExtKt$retryInFlow$2(function1, null)), i3, j3, null, 4, null), continuation);
    }

    public static /* synthetic */ Object b(int i3, long j3, Function1 function1, Continuation continuation, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = 5;
        }
        if ((i4 & 2) != 0) {
            j3 = 200;
        }
        return a(i3, j3, function1, continuation);
    }

    public static final Object c(int i3, long j3, Function1 function1, Function1 function12, Continuation continuation) {
        return FlowKt.F(d(FlowKt.I(new DatabaseExtKt$retryInFlowOrNull$2(function12, null)), i3, j3, function1), continuation);
    }

    public static final Flow d(Flow flow, int i3, long j3, Function1 function1) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        return FlowKt.h(FlowKt.a0(flow, new DatabaseExtKt$retryWhenLocked$1(i3, j3, null)), new DatabaseExtKt$retryWhenLocked$2(function1, null));
    }

    public static /* synthetic */ Flow e(Flow flow, int i3, long j3, Function1 function1, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = 5;
        }
        if ((i4 & 2) != 0) {
            j3 = 200;
        }
        if ((i4 & 4) != 0) {
            function1 = null;
        }
        return d(flow, i3, j3, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0042  */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.jvm.functions.Function1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object f(android.database.sqlite.SQLiteDatabase r1, java.lang.String r2, kotlin.jvm.functions.Function1 r3, kotlin.jvm.functions.Function1 r4) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "query"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "block"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = 0
            android.database.Cursor r1 = r1.rawQuery(r2, r0)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L25
            java.lang.Object r2 = r4.invoke(r1)     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L21
            if (r1 == 0) goto L1d
            r1.close()
        L1d:
            return r2
        L1e:
            r2 = move-exception
            r0 = r1
            goto L40
        L21:
            r2 = move-exception
            goto L27
        L23:
            r2 = move-exception
            goto L40
        L25:
            r2 = move-exception
            r1 = r0
        L27:
            if (r3 == 0) goto L32
            java.lang.Object r3 = r3.invoke(r2)     // Catch: java.lang.Throwable -> L1e
            if (r3 != 0) goto L30
            goto L32
        L30:
            r0 = r3
            goto L3a
        L32:
            cz.mobilesoft.coreblock.util.helperextension.GreendaoQueryException r3 = new cz.mobilesoft.coreblock.util.helperextension.GreendaoQueryException     // Catch: java.lang.Throwable -> L1e
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L1e
            cz.mobilesoft.coreblock.util.CrashHelper.j(r3)     // Catch: java.lang.Throwable -> L1e
        L3a:
            if (r1 == 0) goto L3f
            r1.close()
        L3f:
            return r0
        L40:
            if (r0 == 0) goto L45
            r0.close()
        L45:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.helperextension.DatabaseExtKt.f(android.database.sqlite.SQLiteDatabase, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    public static /* synthetic */ Object g(SQLiteDatabase sQLiteDatabase, String str, Function1 function1, Function1 function12, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function1 = null;
        }
        return f(sQLiteDatabase, str, function1, function12);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object h(androidx.room.RoomDatabase r4, kotlin.jvm.functions.Function1 r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof cz.mobilesoft.coreblock.util.helperextension.DatabaseExtKt$tryTransaction$1
            if (r0 == 0) goto L13
            r0 = r6
            cz.mobilesoft.coreblock.util.helperextension.DatabaseExtKt$tryTransaction$1 r0 = (cz.mobilesoft.coreblock.util.helperextension.DatabaseExtKt$tryTransaction$1) r0
            int r1 = r0.f128517d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f128517d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.util.helperextension.DatabaseExtKt$tryTransaction$1 r0 = new cz.mobilesoft.coreblock.util.helperextension.DatabaseExtKt$tryTransaction$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f128516c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f128517d
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r4 = r0.f128515b
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            java.lang.Object r4 = r0.f128514a
            androidx.room.RoomDatabase r4 = (androidx.room.RoomDatabase) r4
            kotlin.ResultKt.b(r6)     // Catch: java.lang.Exception -> L52
            return r6
        L31:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L39:
            kotlin.ResultKt.b(r6)
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r4)     // Catch: java.lang.Exception -> L52
            r0.f128514a = r6     // Catch: java.lang.Exception -> L52
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r5)     // Catch: java.lang.Exception -> L52
            r0.f128515b = r6     // Catch: java.lang.Exception -> L52
            r0.f128517d = r3     // Catch: java.lang.Exception -> L52
            java.lang.Object r4 = androidx.room.RoomDatabaseKt.g(r4, r5, r0)     // Catch: java.lang.Exception -> L52
            if (r4 != r1) goto L51
            return r1
        L51:
            return r4
        L52:
            r4 = move-exception
            cz.mobilesoft.coreblock.util.helperextension.RoomTransactionException r5 = new cz.mobilesoft.coreblock.util.helperextension.RoomTransactionException
            r5.<init>(r4)
            cz.mobilesoft.coreblock.util.CrashHelper.j(r5)
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.helperextension.DatabaseExtKt.h(androidx.room.RoomDatabase, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
