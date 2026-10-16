package cz.mobilesoft.coreblock.storage.room.dao.core;

import android.content.Intent;
import android.content.pm.PackageManager;
import com.facebook.internal.NativeProtocol;
import cz.mobilesoft.coreblock.dto.UsageAccess;
import cz.mobilesoft.coreblock.storage.room.dao.BaseDao;
import cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;

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
public abstract class IgnoredStatisticsItemDao implements BaseDao<IgnoredStatisticsItem> {
    static /* synthetic */ Object L(IgnoredStatisticsItemDao ignoredStatisticsItemDao, PackageManager packageManager, Continuation continuation) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        Object objL0 = ignoredStatisticsItemDao.l0(packageManager.queryIntentActivities(intent, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST), continuation);
        return objL0 == IntrinsicsKt.f() ? objL0 : Unit.f139807a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a6, code lost:
    
        if (r10.r(r12, r6) == r0) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object N(cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao r10, java.util.Collection r11, kotlin.coroutines.Continuation r12) throws java.lang.Throwable {
        /*
            boolean r0 = r12 instanceof cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao$checkAndUpdateCustomAsDefault$1
            if (r0 == 0) goto L14
            r0 = r12
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao$checkAndUpdateCustomAsDefault$1 r0 = (cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao$checkAndUpdateCustomAsDefault$1) r0
            int r1 = r0.f125878g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f125878g = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao$checkAndUpdateCustomAsDefault$1 r0 = new cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao$checkAndUpdateCustomAsDefault$1
            r0.<init>(r10, r12)
            goto L12
        L1a:
            java.lang.Object r12 = r6.f125876d
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f125878g
            r9 = 2
            r2 = 1
            if (r1 == 0) goto L50
            if (r1 == r2) goto L43
            if (r1 != r9) goto L3b
            java.lang.Object r10 = r6.f125875c
            java.util.List r10 = (java.util.List) r10
            java.lang.Object r10 = r6.f125874b
            java.util.Collection r10 = (java.util.Collection) r10
            java.lang.Object r10 = r6.f125873a
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao r10 = (cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao) r10
            kotlin.ResultKt.b(r12)
            goto La9
        L3b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L43:
            java.lang.Object r10 = r6.f125874b
            r11 = r10
            java.util.Collection r11 = (java.util.Collection) r11
            java.lang.Object r10 = r6.f125873a
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao r10 = (cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao) r10
            kotlin.ResultKt.b(r12)
            goto L70
        L50:
            kotlin.ResultKt.b(r12)
            cz.mobilesoft.coreblock.dto.UsageAccess$Type r3 = cz.mobilesoft.coreblock.dto.UsageAccess.Type.APPLICATION
            cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem$ItemSourceType r4 = cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem.ItemSourceType.CUSTOM
            r6.f125873a = r10
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.a(r11)
            r6.f125874b = r12
            r6.f125878g = r2
            r5 = 0
            r7 = 8
            r8 = 0
            r1 = r10
            r2 = r11
            java.lang.Object r12 = Z(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r12 != r0) goto L6e
            goto La8
        L6e:
            r10 = r1
            r11 = r2
        L70:
            java.util.List r12 = (java.util.List) r12
            r1 = r12
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L79:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L8b
            java.lang.Object r2 = r1.next()
            cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem r2 = (cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem) r2
            cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem$ItemSourceType r3 = cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem.ItemSourceType.DEFAULT
            r2.i(r3)
            goto L79
        L8b:
            r1 = r12
            java.util.Collection r1 = (java.util.Collection) r1
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r10)
            r6.f125873a = r2
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.a(r11)
            r6.f125874b = r11
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.a(r12)
            r6.f125875c = r11
            r6.f125878g = r9
            java.lang.Object r10 = r10.r(r1, r6)
            if (r10 != r0) goto La9
        La8:
            return r0
        La9:
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao.N(cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao, java.util.Collection, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object Q(cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao r4, kotlin.coroutines.Continuation r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao$getActiveNames$1
            if (r0 == 0) goto L13
            r0 = r5
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao$getActiveNames$1 r0 = (cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao$getActiveNames$1) r0
            int r1 = r0.f125882d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f125882d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao$getActiveNames$1 r0 = new cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao$getActiveNames$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f125880b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f125882d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.f125879a
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao r4 = (cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao) r4
            kotlin.ResultKt.b(r5)
            goto L47
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.ResultKt.b(r5)
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.a(r4)
            r0.f125879a = r5
            r0.f125882d = r3
            java.lang.Object r5 = r4.R(r3, r0)
            if (r5 != r1) goto L47
            return r1
        L47:
            java.util.List r5 = (java.util.List) r5
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r4 = new java.util.ArrayList
            r0 = 10
            int r0 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r5, r0)
            r4.<init>(r0)
            java.util.Iterator r5 = r5.iterator()
        L5a:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L6e
            java.lang.Object r0 = r5.next()
            cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem r0 = (cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem) r0
            java.lang.String r0 = r0.c()
            r4.add(r0)
            goto L5a
        L6e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao.Q(cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object W(IgnoredStatisticsItemDao ignoredStatisticsItemDao, String str, UsageAccess.Type type, boolean z2, Continuation continuation, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getByNameAndType");
        }
        if ((i3 & 4) != 0) {
            z2 = true;
        }
        return ignoredStatisticsItemDao.U(str, type, z2, continuation);
    }

    public static /* synthetic */ Object X(IgnoredStatisticsItemDao ignoredStatisticsItemDao, Collection collection, UsageAccess.Type type, boolean z2, Continuation continuation, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getByNameAndType");
        }
        if ((i3 & 4) != 0) {
            z2 = true;
        }
        return ignoredStatisticsItemDao.V(collection, type, z2, continuation);
    }

    public static /* synthetic */ Object Z(IgnoredStatisticsItemDao ignoredStatisticsItemDao, Collection collection, UsageAccess.Type type, IgnoredStatisticsItem.ItemSourceType itemSourceType, boolean z2, Continuation continuation, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getByNameTypeAndSourceType");
        }
        if ((i3 & 8) != 0) {
            z2 = true;
        }
        return ignoredStatisticsItemDao.Y(collection, type, itemSourceType, z2, continuation);
    }

    public static /* synthetic */ Object e0(IgnoredStatisticsItemDao ignoredStatisticsItemDao, IgnoredStatisticsItem.ItemSourceType itemSourceType, boolean z2, Continuation continuation, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getNamesBySourceType");
        }
        if ((i3 & 2) != 0) {
            z2 = true;
        }
        return ignoredStatisticsItemDao.d0(itemSourceType, z2, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object f0(cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao r4, cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem.ItemSourceType r5, boolean r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao$getNamesBySourceType$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao$getNamesBySourceType$1 r0 = (cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao$getNamesBySourceType$1) r0
            int r1 = r0.f125888g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f125888g = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao$getNamesBySourceType$1 r0 = new cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao$getNamesBySourceType$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.f125886d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f125888g
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r4 = r0.f125884b
            cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem$ItemSourceType r4 = (cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem.ItemSourceType) r4
            java.lang.Object r4 = r0.f125883a
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao r4 = (cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao) r4
            kotlin.ResultKt.b(r7)
            goto L53
        L31:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L39:
            kotlin.ResultKt.b(r7)
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r4)
            r0.f125883a = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r5)
            r0.f125884b = r7
            r0.f125885c = r6
            r0.f125888g = r3
            java.lang.Object r7 = r4.b0(r5, r6, r0)
            if (r7 != r1) goto L53
            return r1
        L53:
            java.util.List r7 = (java.util.List) r7
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 10
            int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r7, r5)
            r4.<init>(r5)
            java.util.Iterator r5 = r7.iterator()
        L66:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L7a
            java.lang.Object r6 = r5.next()
            cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem r6 = (cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem) r6
            java.lang.String r6 = r6.c()
            r4.add(r6)
            goto L66
        L7a:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao.f0(cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao, cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem$ItemSourceType, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0096, code lost:
    
        if (r7.t(r6, r0) != r1) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object i0(cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao r6, java.util.Collection r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao$insertFromBackup$1
            if (r0 == 0) goto L13
            r0 = r8
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao$insertFromBackup$1 r0 = (cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao$insertFromBackup$1) r0
            int r1 = r0.f125903g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f125903g = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao$insertFromBackup$1 r0 = new cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao$insertFromBackup$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f125901d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f125903g
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L5b
            if (r2 == r5) goto L4b
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r6 = r0.f125899b
            java.util.Collection r6 = (java.util.Collection) r6
            java.lang.Object r6 = r0.f125898a
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao r6 = (cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao) r6
            kotlin.ResultKt.b(r8)
            goto L99
        L37:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3f:
            java.lang.Object r6 = r0.f125899b
            java.util.Collection r6 = (java.util.Collection) r6
            java.lang.Object r7 = r0.f125898a
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao r7 = (cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao) r7
            kotlin.ResultKt.b(r8)
            goto L84
        L4b:
            java.lang.Object r6 = r0.f125900c
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao r6 = (cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao) r6
            java.lang.Object r7 = r0.f125899b
            java.util.Collection r7 = (java.util.Collection) r7
            java.lang.Object r2 = r0.f125898a
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao r2 = (cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao) r2
            kotlin.ResultKt.b(r8)
            goto L70
        L5b:
            kotlin.ResultKt.b(r8)
            cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem$ItemSourceType r8 = cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem.ItemSourceType.CUSTOM
            r0.f125898a = r6
            r0.f125899b = r7
            r0.f125900c = r6
            r0.f125903g = r5
            java.lang.Object r8 = r6.a0(r8, r0)
            if (r8 != r1) goto L6f
            goto L98
        L6f:
            r2 = r6
        L70:
            java.util.List r8 = (java.util.List) r8
            r0.f125898a = r2
            r0.f125899b = r7
            r5 = 0
            r0.f125900c = r5
            r0.f125903g = r4
            java.lang.Object r6 = r6.h(r8, r0)
            if (r6 != r1) goto L82
            goto L98
        L82:
            r6 = r7
            r7 = r2
        L84:
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r0.f125898a = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r0.f125899b = r8
            r0.f125903g = r3
            java.lang.Object r6 = r7.t(r6, r0)
            if (r6 != r1) goto L99
        L98:
            return r1
        L99:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao.i0(cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao, java.util.Collection, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x0206, code lost:
    
        if (r9.t(r6, r13) == r3) goto L63;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x0193 -> B:26:0x00e3). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object k0(cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao r16, java.util.Collection r17, kotlin.coroutines.Continuation r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 524
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao.k0(cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao, java.util.Collection, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x010f, code lost:
    
        if (r0.j0(r1, r2) != r3) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object m0(cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao r20, java.util.Collection r21, kotlin.coroutines.Continuation r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao.m0(cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao, java.util.Collection, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object r0(IgnoredStatisticsItemDao ignoredStatisticsItemDao, IgnoredStatisticsItem ignoredStatisticsItem, boolean z2, Continuation continuation) {
        ignoredStatisticsItem.g(z2);
        Object objP = ignoredStatisticsItemDao.p(ignoredStatisticsItem, continuation);
        return objP == IntrinsicsKt.f() ? objP : Unit.f139807a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a7, code lost:
    
        if (r9.n0(r13, r12, r5) == r0) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object s0(cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao r9, java.lang.String r10, cz.mobilesoft.coreblock.dto.UsageAccess.Type r11, boolean r12, kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            boolean r0 = r13 instanceof cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao$setActive$4
            if (r0 == 0) goto L14
            r0 = r13
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao$setActive$4 r0 = (cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao$setActive$4) r0
            int r1 = r0.f125931j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f125931j = r1
        L12:
            r5 = r0
            goto L1a
        L14:
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao$setActive$4 r0 = new cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao$setActive$4
            r0.<init>(r9, r13)
            goto L12
        L1a:
            java.lang.Object r13 = r5.f125929h
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r5.f125931j
            r8 = 2
            r2 = 1
            if (r1 == 0) goto L5b
            if (r1 == r2) goto L47
            if (r1 != r8) goto L3f
            java.lang.Object r9 = r5.f125926d
            cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem r9 = (cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem) r9
            java.lang.Object r9 = r5.f125925c
            cz.mobilesoft.coreblock.dto.UsageAccess$Type r9 = (cz.mobilesoft.coreblock.dto.UsageAccess.Type) r9
            java.lang.Object r9 = r5.f125924b
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r9 = r5.f125923a
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao r9 = (cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao) r9
            kotlin.ResultKt.b(r13)
            goto Laa
        L3f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L47:
            boolean r12 = r5.f125927f
            java.lang.Object r9 = r5.f125925c
            r11 = r9
            cz.mobilesoft.coreblock.dto.UsageAccess$Type r11 = (cz.mobilesoft.coreblock.dto.UsageAccess.Type) r11
            java.lang.Object r9 = r5.f125924b
            r10 = r9
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r9 = r5.f125923a
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao r9 = (cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao) r9
            kotlin.ResultKt.b(r13)
            goto L80
        L5b:
            kotlin.ResultKt.b(r13)
            r5.f125923a = r9
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.a(r10)
            r5.f125924b = r13
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.a(r11)
            r5.f125925c = r13
            r5.f125927f = r12
            r5.f125931j = r2
            r4 = 0
            r6 = 4
            r7 = 0
            r1 = r9
            r2 = r10
            r3 = r11
            java.lang.Object r13 = W(r1, r2, r3, r4, r5, r6, r7)
            if (r13 != r0) goto L7d
            goto La9
        L7d:
            r9 = r1
            r10 = r2
            r11 = r3
        L80:
            cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem r13 = (cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem) r13
            if (r13 == 0) goto Laa
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.a(r9)
            r5.f125923a = r1
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.a(r10)
            r5.f125924b = r10
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.a(r11)
            r5.f125925c = r10
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.a(r13)
            r5.f125926d = r10
            r5.f125927f = r12
            r10 = 0
            r5.f125928g = r10
            r5.f125931j = r8
            java.lang.Object r9 = r9.n0(r13, r12, r5)
            if (r9 != r0) goto Laa
        La9:
            return r0
        Laa:
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao.s0(cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao, java.lang.String, cz.mobilesoft.coreblock.dto.UsageAccess$Type, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a4, code lost:
    
        if (r9.q0(r13, r12, r5) == r0) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object t0(cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao r9, java.util.Collection r10, cz.mobilesoft.coreblock.dto.UsageAccess.Type r11, boolean r12, kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            boolean r0 = r13 instanceof cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao$setActive$6
            if (r0 == 0) goto L14
            r0 = r13
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao$setActive$6 r0 = (cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao$setActive$6) r0
            int r1 = r0.f125939i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f125939i = r1
        L12:
            r5 = r0
            goto L1a
        L14:
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao$setActive$6 r0 = new cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao$setActive$6
            r0.<init>(r9, r13)
            goto L12
        L1a:
            java.lang.Object r13 = r5.f125937g
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r5.f125939i
            r8 = 2
            r2 = 1
            if (r1 == 0) goto L5a
            if (r1 == r2) goto L46
            if (r1 != r8) goto L3e
            java.lang.Object r9 = r5.f125935d
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r9 = r5.f125934c
            cz.mobilesoft.coreblock.dto.UsageAccess$Type r9 = (cz.mobilesoft.coreblock.dto.UsageAccess.Type) r9
            java.lang.Object r9 = r5.f125933b
            java.util.Collection r9 = (java.util.Collection) r9
            java.lang.Object r9 = r5.f125932a
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao r9 = (cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao) r9
            kotlin.ResultKt.b(r13)
            goto La7
        L3e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L46:
            boolean r12 = r5.f125936f
            java.lang.Object r9 = r5.f125934c
            r11 = r9
            cz.mobilesoft.coreblock.dto.UsageAccess$Type r11 = (cz.mobilesoft.coreblock.dto.UsageAccess.Type) r11
            java.lang.Object r9 = r5.f125933b
            r10 = r9
            java.util.Collection r10 = (java.util.Collection) r10
            java.lang.Object r9 = r5.f125932a
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao r9 = (cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao) r9
            kotlin.ResultKt.b(r13)
            goto L7f
        L5a:
            kotlin.ResultKt.b(r13)
            r5.f125932a = r9
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.a(r10)
            r5.f125933b = r13
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.a(r11)
            r5.f125934c = r13
            r5.f125936f = r12
            r5.f125939i = r2
            r4 = 0
            r6 = 4
            r7 = 0
            r1 = r9
            r2 = r10
            r3 = r11
            java.lang.Object r13 = X(r1, r2, r3, r4, r5, r6, r7)
            if (r13 != r0) goto L7c
            goto La6
        L7c:
            r9 = r1
            r10 = r2
            r11 = r3
        L7f:
            java.util.List r13 = (java.util.List) r13
            r1 = r13
            java.util.Collection r1 = (java.util.Collection) r1
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r9)
            r5.f125932a = r2
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.a(r10)
            r5.f125933b = r10
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.a(r11)
            r5.f125934c = r10
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.a(r13)
            r5.f125935d = r10
            r5.f125936f = r12
            r5.f125939i = r8
            java.lang.Object r9 = r9.q0(r1, r12, r5)
            if (r9 != r0) goto La7
        La6:
            return r0
        La7:
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao.t0(cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao, java.util.Collection, cz.mobilesoft.coreblock.dto.UsageAccess$Type, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object u0(IgnoredStatisticsItemDao ignoredStatisticsItemDao, Collection collection, boolean z2, Continuation continuation) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            ((IgnoredStatisticsItem) it.next()).g(z2);
        }
        Object objR = ignoredStatisticsItemDao.r(collection, continuation);
        return objR == IntrinsicsKt.f() ? objR : Unit.f139807a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0072, code lost:
    
        if (r5.q0(r2, r6, r0) == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object w0(cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao r5, boolean r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao$setAllDefaultActive$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao$setAllDefaultActive$1 r0 = (cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao$setAllDefaultActive$1) r0
            int r1 = r0.f125945g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f125945g = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao$setAllDefaultActive$1 r0 = new cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao$setAllDefaultActive$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f125943d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f125945g
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L46
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r5 = r0.f125941b
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r5 = r0.f125940a
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao r5 = (cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao) r5
            kotlin.ResultKt.b(r7)
            goto L75
        L34:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3c:
            boolean r6 = r0.f125942c
            java.lang.Object r5 = r0.f125940a
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao r5 = (cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao) r5
            kotlin.ResultKt.b(r7)
            goto L59
        L46:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem$ItemSourceType r7 = cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem.ItemSourceType.DEFAULT
            r0.f125940a = r5
            r0.f125942c = r6
            r0.f125945g = r4
            r2 = 0
            java.lang.Object r7 = r5.c0(r7, r2, r0)
            if (r7 != r1) goto L59
            goto L74
        L59:
            java.util.List r7 = (java.util.List) r7
            r2 = r7
            java.util.Collection r2 = (java.util.Collection) r2
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r5)
            r0.f125940a = r4
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r0.f125941b = r7
            r0.f125942c = r6
            r0.f125945g = r3
            java.lang.Object r5 = r5.q0(r2, r6, r0)
            if (r5 != r1) goto L75
        L74:
            return r1
        L75:
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao.w0(cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object J(kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao$areAllDefaultActive$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao$areAllDefaultActive$1 r0 = (cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao$areAllDefaultActive$1) r0
            int r1 = r0.f125872c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f125872c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao$areAllDefaultActive$1 r0 = new cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao$areAllDefaultActive$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f125870a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f125872c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r7)
            goto L3f
        L29:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L31:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem$ItemSourceType r7 = cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem.ItemSourceType.DEFAULT
            r0.f125872c = r3
            java.lang.Object r7 = r6.O(r7, r3, r3, r0)
            if (r7 != r1) goto L3f
            return r1
        L3f:
            java.lang.Number r7 = (java.lang.Number) r7
            long r0 = r7.longValue()
            r4 = 0
            int r7 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r7 != 0) goto L4c
            goto L4d
        L4c:
            r3 = 0
        L4d:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao.J(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object K(PackageManager packageManager, Continuation continuation) {
        return L(this, packageManager, continuation);
    }

    public Object M(Collection collection, Continuation continuation) {
        return N(this, collection, continuation);
    }

    public abstract Object O(IgnoredStatisticsItem.ItemSourceType itemSourceType, boolean z2, boolean z3, Continuation continuation);

    public Object P(Continuation continuation) {
        return Q(this, continuation);
    }

    public abstract Object R(boolean z2, Continuation continuation);

    public abstract Flow S(boolean z2);

    public abstract Object T(String str, Continuation continuation);

    public abstract Object U(String str, UsageAccess.Type type, boolean z2, Continuation continuation);

    public abstract Object V(Collection collection, UsageAccess.Type type, boolean z2, Continuation continuation);

    public abstract Object Y(Collection collection, UsageAccess.Type type, IgnoredStatisticsItem.ItemSourceType itemSourceType, boolean z2, Continuation continuation);

    public abstract Object a0(IgnoredStatisticsItem.ItemSourceType itemSourceType, Continuation continuation);

    public abstract Object b0(IgnoredStatisticsItem.ItemSourceType itemSourceType, boolean z2, Continuation continuation);

    public abstract Object c0(IgnoredStatisticsItem.ItemSourceType itemSourceType, boolean z2, Continuation continuation);

    public Object d0(IgnoredStatisticsItem.ItemSourceType itemSourceType, boolean z2, Continuation continuation) {
        return f0(this, itemSourceType, z2, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x01f3, code lost:
    
        if (j0(r10, r2) != r3) goto L64;
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object g0(java.lang.String r24, kotlin.coroutines.Continuation r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 508
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao.g0(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object h0(Collection collection, Continuation continuation) {
        return i0(this, collection, continuation);
    }

    public Object j0(Collection collection, Continuation continuation) {
        return k0(this, collection, continuation);
    }

    public Object l0(Collection collection, Continuation continuation) {
        return m0(this, collection, continuation);
    }

    public Object n0(IgnoredStatisticsItem ignoredStatisticsItem, boolean z2, Continuation continuation) {
        return r0(this, ignoredStatisticsItem, z2, continuation);
    }

    public Object o0(String str, UsageAccess.Type type, boolean z2, Continuation continuation) {
        return s0(this, str, type, z2, continuation);
    }

    public Object p0(Collection collection, UsageAccess.Type type, boolean z2, Continuation continuation) {
        return t0(this, collection, type, z2, continuation);
    }

    public Object q0(Collection collection, boolean z2, Continuation continuation) {
        return u0(this, collection, z2, continuation);
    }

    public Object v0(boolean z2, Continuation continuation) {
        return w0(this, z2, continuation);
    }
}
