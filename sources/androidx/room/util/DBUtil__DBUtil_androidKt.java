package androidx.room.util;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.room.TransactionElement;
import androidx.room.coroutines.RunBlockingUninterruptible_androidKt;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.driver.SupportSQLiteConnection;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.io.CloseableKt;
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
final /* synthetic */ class DBUtil__DBUtil_androidKt {
    public static final CancellationSignal a() {
        return new CancellationSignal();
    }

    public static final void b(SupportSQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        DBUtil.b(new SupportSQLiteConnection(db));
    }

    public static final Object c(RoomDatabase roomDatabase, boolean z2, Continuation continuation) {
        TransactionElement transactionElement = (TransactionElement) continuation.getContext().get(TransactionElement.f52383b);
        CoroutineContext coroutineContextD = transactionElement != null ? transactionElement.d() : null;
        if (roomDatabase.inCompatibilityMode()) {
            return coroutineContextD != null ? roomDatabase.getQueryContext().plus(coroutineContextD) : z2 ? roomDatabase.getTransactionContext$room_runtime() : roomDatabase.getQueryContext();
        }
        CoroutineContext queryContext = roomDatabase.getQueryContext();
        if (coroutineContextD == null) {
            coroutineContextD = EmptyCoroutineContext.f139889a;
        }
        return queryContext.plus(coroutineContextD);
    }

    public static final Object d(RoomDatabase db, boolean z2, boolean z3, Function1 block) {
        Intrinsics.checkNotNullParameter(db, "db");
        Intrinsics.checkNotNullParameter(block, "block");
        db.assertNotMainThread();
        db.assertNotSuspendingTransaction();
        CoroutineContext coroutineContext = db.getSuspendingTransactionContext().get();
        if (coroutineContext == null) {
            coroutineContext = EmptyCoroutineContext.f139889a;
        }
        return RunBlockingUninterruptible_androidKt.a(new DBUtil__DBUtil_androidKt$performBlocking$1(coroutineContext, db, z3, z2, block, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object e(androidx.room.RoomDatabase r11, kotlin.jvm.functions.Function1 r12, kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            boolean r1 = r13 instanceof androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$1
            if (r1 == 0) goto L14
            r1 = r13
            androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$1 r1 = (androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$1) r1
            int r2 = r1.f52908d
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r2 & r4
            if (r6 == 0) goto L14
            int r2 = r2 - r4
            r1.f52908d = r2
        L12:
            r6 = r1
            goto L1a
        L14:
            androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$1 r1 = new androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$1
            r1.<init>(r13)
            goto L12
        L1a:
            java.lang.Object r0 = r6.f52907c
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f52908d
            r2 = 4
            r4 = 3
            r8 = 2
            r9 = 1
            r10 = 0
            if (r1 == 0) goto L51
            if (r1 == r9) goto L4d
            if (r1 == r8) goto L49
            if (r1 == r4) goto L3d
            if (r1 != r2) goto L35
            kotlin.ResultKt.b(r0)
            return r0
        L35:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3d:
            java.lang.Object r1 = r6.f52906b
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            java.lang.Object r3 = r6.f52905a
            androidx.room.RoomDatabase r3 = (androidx.room.RoomDatabase) r3
            kotlin.ResultKt.b(r0)
            goto L9f
        L49:
            kotlin.ResultKt.b(r0)
            return r0
        L4d:
            kotlin.ResultKt.b(r0)
            return r0
        L51:
            kotlin.ResultKt.b(r0)
            boolean r0 = r11.inCompatibilityMode()
            if (r0 == 0) goto L69
            androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$2 r0 = new androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$2
            r0.<init>(r11, r12, r10)
            r6.f52908d = r9
            java.lang.Object r0 = androidx.room.RoomDatabaseKt.h(r11, r0, r6)
            if (r0 != r7) goto L68
            goto Lb2
        L68:
            return r0
        L69:
            boolean r0 = r11.inCompatibilityMode()
            if (r0 == 0) goto L90
            boolean r0 = r11.isOpenInternal$room_runtime()
            if (r0 == 0) goto L90
            boolean r0 = r11.inTransaction()
            if (r0 == 0) goto L90
            androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$lambda$3$$inlined$internalPerform$1 r0 = new androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$lambda$3$$inlined$internalPerform$1
            r2 = 0
            r4 = 0
            r1 = 1
            r3 = r11
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5)
            r6.f52908d = r8
            r1 = 0
            java.lang.Object r0 = r11.useConnection(r1, r0, r6)
            if (r0 != r7) goto L8f
            goto Lb2
        L8f:
            return r0
        L90:
            r6.f52905a = r11
            r6.f52906b = r12
            r6.f52908d = r4
            java.lang.Object r0 = androidx.room.util.DBUtil.d(r11, r9, r6)
            if (r0 != r7) goto L9d
            goto Lb2
        L9d:
            r3 = r11
            r1 = r12
        L9f:
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
            androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$$inlined$compatCoroutineExecute$DBUtil__DBUtil_androidKt$1 r4 = new androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$$inlined$compatCoroutineExecute$DBUtil__DBUtil_androidKt$1
            r4.<init>(r10, r3, r1)
            r6.f52905a = r10
            r6.f52906b = r10
            r6.f52908d = r2
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.g(r0, r4, r6)
            if (r0 != r7) goto Lb3
        Lb2:
            return r7
        Lb3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.DBUtil__DBUtil_androidKt.e(androidx.room.RoomDatabase, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object f(androidx.room.RoomDatabase r14, boolean r15, boolean r16, kotlin.jvm.functions.Function1 r17, kotlin.coroutines.Continuation r18) throws java.lang.Throwable {
        /*
            r0 = r18
            boolean r1 = r0 instanceof androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$1
            if (r1 == 0) goto L16
            r1 = r0
            androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$1 r1 = (androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$1) r1
            int r2 = r1.f52942g
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L16
            int r2 = r2 - r3
            r1.f52942g = r2
        L14:
            r6 = r1
            goto L1c
        L16:
            androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$1 r1 = new androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$1
            r1.<init>(r0)
            goto L14
        L1c:
            java.lang.Object r0 = r6.f52941f
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f52942g
            r2 = 3
            r3 = 2
            r8 = 1
            if (r1 == 0) goto L53
            if (r1 == r8) goto L4f
            if (r1 == r3) goto L3b
            if (r1 != r2) goto L33
            kotlin.ResultKt.b(r0)
            return r0
        L33:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L3b:
            boolean r14 = r6.f52940d
            boolean r15 = r6.f52939c
            java.lang.Object r1 = r6.f52938b
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            java.lang.Object r3 = r6.f52937a
            androidx.room.RoomDatabase r3 = (androidx.room.RoomDatabase) r3
            kotlin.ResultKt.b(r0)
            r12 = r14
            r13 = r1
            r10 = r3
        L4d:
            r11 = r15
            goto L99
        L4f:
            kotlin.ResultKt.b(r0)
            return r0
        L53:
            kotlin.ResultKt.b(r0)
            boolean r0 = r14.inCompatibilityMode()
            if (r0 == 0) goto L7f
            boolean r0 = r14.isOpenInternal$room_runtime()
            if (r0 == 0) goto L7f
            boolean r0 = r14.inTransaction()
            if (r0 == 0) goto L7f
            androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1 r0 = new androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1
            r4 = 0
            r3 = r14
            r2 = r15
            r1 = r16
            r5 = r17
            r0.<init>(r1, r2, r3, r4, r5)
            r2 = r0
            r6.f52942g = r8
            java.lang.Object r14 = r14.useConnection(r15, r2, r6)
            if (r14 != r7) goto L7e
            goto Lae
        L7e:
            return r14
        L7f:
            r4 = r16
            r6.f52937a = r14
            r5 = r17
            r6.f52938b = r5
            r6.f52939c = r15
            r6.f52940d = r4
            r6.f52942g = r3
            java.lang.Object r3 = androidx.room.util.DBUtil.d(r14, r4, r6)
            if (r3 != r7) goto L94
            goto Lae
        L94:
            r10 = r14
            r0 = r3
            r12 = r4
            r13 = r5
            goto L4d
        L99:
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
            androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$$inlined$compatCoroutineExecute$DBUtil__DBUtil_androidKt$1 r8 = new androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$$inlined$compatCoroutineExecute$DBUtil__DBUtil_androidKt$1
            r9 = 0
            r8.<init>(r9, r10, r11, r12, r13)
            r14 = 0
            r6.f52937a = r14
            r6.f52938b = r14
            r6.f52942g = r2
            java.lang.Object r14 = kotlinx.coroutines.BuildersKt.g(r0, r8, r6)
            if (r14 != r7) goto Laf
        Lae:
            return r7
        Laf:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.DBUtil__DBUtil_androidKt.f(androidx.room.RoomDatabase, boolean, boolean, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Cursor g(RoomDatabase db, SupportSQLiteQuery sqLiteQuery, boolean z2, CancellationSignal cancellationSignal) {
        Intrinsics.checkNotNullParameter(db, "db");
        Intrinsics.checkNotNullParameter(sqLiteQuery, "sqLiteQuery");
        Cursor cursorQuery = db.query(sqLiteQuery, cancellationSignal);
        if (!z2 || !(cursorQuery instanceof AbstractWindowedCursor)) {
            return cursorQuery;
        }
        AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) cursorQuery;
        int count = abstractWindowedCursor.getCount();
        return (abstractWindowedCursor.hasWindow() ? abstractWindowedCursor.getWindow().getNumRows() : count) < count ? CursorUtil.a(cursorQuery) : cursorQuery;
    }

    public static final int h(File databaseFile) {
        Intrinsics.checkNotNullParameter(databaseFile, "databaseFile");
        FileChannel channel = new FileInputStream(databaseFile).getChannel();
        try {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            channel.tryLock(60L, 4L, true);
            channel.position(60L);
            if (channel.read(byteBufferAllocate) != 4) {
                throw new IOException("Bad database header, unable to read 4 bytes at offset 60");
            }
            byteBufferAllocate.rewind();
            int i3 = byteBufferAllocate.getInt();
            CloseableKt.a(channel, null);
            return i3;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.a(channel, th);
                throw th2;
            }
        }
    }
}
