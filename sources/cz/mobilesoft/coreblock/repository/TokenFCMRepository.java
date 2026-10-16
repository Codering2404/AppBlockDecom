package cz.mobilesoft.coreblock.repository;

import cz.mobilesoft.coreblock.storage.room.dao.core.TokenFCMDao;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class TokenFCMRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TokenFCMDao f98388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f98389b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class UserNotSignedInException extends Exception {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserNotSignedInException(String message) {
            super(message);
            Intrinsics.checkNotNullParameter(message, "message");
        }
    }

    public TokenFCMRepository(TokenFCMDao tokenFCMDao) {
        Intrinsics.checkNotNullParameter(tokenFCMDao, "tokenFCMDao");
        this.f98388a = tokenFCMDao;
        this.f98389b = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.repository.y
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TokenFCMRepository.h(this.f98441a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0116, code lost:
    
        if (r2.p(r11, r0) == r1) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object g(cz.mobilesoft.coreblock.storage.room.entity.core.TokenFCMEntity r11, java.lang.String r12, kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.TokenFCMRepository.g(cz.mobilesoft.coreblock.storage.room.entity.core.TokenFCMEntity, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flow h(TokenFCMRepository tokenFCMRepository) {
        return tokenFCMRepository.f98388a.C();
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x008b, code lost:
    
        if (r7 != r1) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.repository.TokenFCMRepository$forceSync$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.repository.TokenFCMRepository$forceSync$1 r0 = (cz.mobilesoft.coreblock.repository.TokenFCMRepository$forceSync$1) r0
            int r1 = r0.f98394f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f98394f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.repository.TokenFCMRepository$forceSync$1 r0 = new cz.mobilesoft.coreblock.repository.TokenFCMRepository$forceSync$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f98392c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f98394f
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L49
            if (r2 == r5) goto L45
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r0 = r0.f98390a
            cz.mobilesoft.coreblock.storage.room.entity.core.TokenFCMEntity r0 = (cz.mobilesoft.coreblock.storage.room.entity.core.TokenFCMEntity) r0
            kotlin.ResultKt.b(r7)
            goto L8e
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L3b:
            int r2 = r0.f98391b
            java.lang.Object r4 = r0.f98390a
            cz.mobilesoft.coreblock.storage.room.entity.core.TokenFCMEntity r4 = (cz.mobilesoft.coreblock.storage.room.entity.core.TokenFCMEntity) r4
            kotlin.ResultKt.b(r7)
            goto L7b
        L45:
            kotlin.ResultKt.b(r7)
            goto L57
        L49:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.storage.room.dao.core.TokenFCMDao r7 = r6.f98388a
            r0.f98394f = r5
            java.lang.Object r7 = r7.G(r0)
            if (r7 != r1) goto L57
            goto L8d
        L57:
            cz.mobilesoft.coreblock.storage.room.entity.core.TokenFCMEntity r7 = (cz.mobilesoft.coreblock.storage.room.entity.core.TokenFCMEntity) r7
            if (r7 == 0) goto L90
            cz.mobilesoft.coreblock.util.SessionManager r2 = cz.mobilesoft.coreblock.util.SessionManager.f127910a
            boolean r2 = r2.r()
            if (r2 == 0) goto L64
            goto L65
        L64:
            r7 = 0
        L65:
            if (r7 == 0) goto L90
            r2 = 0
            r7.c(r2)
            cz.mobilesoft.coreblock.storage.room.dao.core.TokenFCMDao r5 = r6.f98388a
            r0.f98390a = r7
            r0.f98391b = r2
            r0.f98394f = r4
            java.lang.Object r4 = r5.p(r7, r0)
            if (r4 != r1) goto L7a
            goto L8d
        L7a:
            r4 = r7
        L7b:
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r4)
            r0.f98390a = r7
            r0.f98391b = r2
            r0.f98394f = r3
            java.lang.String r7 = "forceSync()"
            java.lang.Object r7 = r6.g(r4, r7, r0)
            if (r7 != r1) goto L8e
        L8d:
            return r1
        L8e:
            cz.mobilesoft.coreblock.util.DataState r7 = (cz.mobilesoft.coreblock.util.DataState) r7
        L90:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.TokenFCMRepository.c(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Flow d() {
        return (Flow) this.f98389b.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(kotlin.coroutines.Continuation r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof cz.mobilesoft.coreblock.repository.TokenFCMRepository$sync$1
            if (r0 == 0) goto L13
            r0 = r6
            cz.mobilesoft.coreblock.repository.TokenFCMRepository$sync$1 r0 = (cz.mobilesoft.coreblock.repository.TokenFCMRepository$sync$1) r0
            int r1 = r0.f98399f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f98399f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.repository.TokenFCMRepository$sync$1 r0 = new cz.mobilesoft.coreblock.repository.TokenFCMRepository$sync$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f98397c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f98399f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r0 = r0.f98395a
            cz.mobilesoft.coreblock.storage.room.entity.core.TokenFCMEntity r0 = (cz.mobilesoft.coreblock.storage.room.entity.core.TokenFCMEntity) r0
            kotlin.ResultKt.b(r6)
            return r6
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L38:
            kotlin.ResultKt.b(r6)
            goto L4a
        L3c:
            kotlin.ResultKt.b(r6)
            cz.mobilesoft.coreblock.storage.room.dao.core.TokenFCMDao r6 = r5.f98388a
            r0.f98399f = r4
            java.lang.Object r6 = r6.G(r0)
            if (r6 != r1) goto L4a
            goto L69
        L4a:
            cz.mobilesoft.coreblock.storage.room.entity.core.TokenFCMEntity r6 = (cz.mobilesoft.coreblock.storage.room.entity.core.TokenFCMEntity) r6
            if (r6 == 0) goto L6b
            cz.mobilesoft.coreblock.util.SessionManager r2 = cz.mobilesoft.coreblock.util.SessionManager.f127910a
            boolean r2 = r2.r()
            if (r2 == 0) goto L6b
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r0.f98395a = r2
            r2 = 0
            r0.f98396b = r2
            r0.f98399f = r3
            java.lang.String r2 = "sync()"
            java.lang.Object r6 = r5.g(r6, r2, r0)
            if (r6 != r1) goto L6a
        L69:
            return r1
        L6a:
            return r6
        L6b:
            cz.mobilesoft.coreblock.util.DataState$Success r6 = new cz.mobilesoft.coreblock.util.DataState$Success
            kotlin.Unit r0 = kotlin.Unit.f139807a
            r6.<init>(r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.TokenFCMRepository.e(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object f(kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof cz.mobilesoft.coreblock.repository.TokenFCMRepository$syncIfPending$1
            if (r0 == 0) goto L13
            r0 = r6
            cz.mobilesoft.coreblock.repository.TokenFCMRepository$syncIfPending$1 r0 = (cz.mobilesoft.coreblock.repository.TokenFCMRepository$syncIfPending$1) r0
            int r1 = r0.f98404f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f98404f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.repository.TokenFCMRepository$syncIfPending$1 r0 = new cz.mobilesoft.coreblock.repository.TokenFCMRepository$syncIfPending$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f98402c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f98404f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r0 = r0.f98400a
            cz.mobilesoft.coreblock.storage.room.entity.core.TokenFCMEntity r0 = (cz.mobilesoft.coreblock.storage.room.entity.core.TokenFCMEntity) r0
            kotlin.ResultKt.b(r6)
            return r6
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L38:
            kotlin.ResultKt.b(r6)
            goto L4a
        L3c:
            kotlin.ResultKt.b(r6)
            cz.mobilesoft.coreblock.storage.room.dao.core.TokenFCMDao r6 = r5.f98388a
            r0.f98404f = r4
            java.lang.Object r6 = r6.G(r0)
            if (r6 != r1) goto L4a
            goto L6f
        L4a:
            cz.mobilesoft.coreblock.storage.room.entity.core.TokenFCMEntity r6 = (cz.mobilesoft.coreblock.storage.room.entity.core.TokenFCMEntity) r6
            if (r6 == 0) goto L71
            boolean r2 = r6.b()
            if (r2 != 0) goto L71
            cz.mobilesoft.coreblock.util.SessionManager r2 = cz.mobilesoft.coreblock.util.SessionManager.f127910a
            boolean r2 = r2.r()
            if (r2 == 0) goto L71
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r0.f98400a = r2
            r2 = 0
            r0.f98401b = r2
            r0.f98404f = r3
            java.lang.String r2 = "syncIfPending()"
            java.lang.Object r6 = r5.g(r6, r2, r0)
            if (r6 != r1) goto L70
        L6f:
            return r1
        L70:
            return r6
        L71:
            cz.mobilesoft.coreblock.util.DataState$Success r6 = new cz.mobilesoft.coreblock.util.DataState$Success
            kotlin.Unit r0 = kotlin.Unit.f139807a
            r6.<init>(r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.TokenFCMRepository.f(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00eb, code lost:
    
        if (g(r8, "updateToken()", r0) == r1) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00cf A[PHI: r2 r8
      0x00cf: PHI (r2v4 java.lang.String) = (r2v3 java.lang.String), (r2v6 java.lang.String) binds: [B:36:0x00cc, B:17:0x0043] A[DONT_GENERATE, DONT_INLINE]
      0x00cf: PHI (r8v6 cz.mobilesoft.coreblock.storage.room.entity.core.TokenFCMEntity) = 
      (r8v5 cz.mobilesoft.coreblock.storage.room.entity.core.TokenFCMEntity)
      (r8v15 cz.mobilesoft.coreblock.storage.room.entity.core.TokenFCMEntity)
     binds: [B:36:0x00cc, B:17:0x0043] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object i(java.lang.String r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.TokenFCMRepository.i(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
