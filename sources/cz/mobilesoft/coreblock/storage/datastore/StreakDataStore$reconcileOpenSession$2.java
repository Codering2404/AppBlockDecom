package cz.mobilesoft.coreblock.storage.datastore;

import androidx.datastore.preferences.core.MutablePreferences;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$reconcileOpenSession$2", f = "StreakDataStore.kt", l = {}, m = "invokeSuspend", v = 1)
final class StreakDataStore$reconcileOpenSession$2 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f124621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f124622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Ref.ObjectRef f124623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ StreakDataStore f124624d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ long f124625f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreakDataStore$reconcileOpenSession$2(Ref.ObjectRef objectRef, StreakDataStore streakDataStore, long j3, Continuation continuation) {
        super(2, continuation);
        this.f124623c = objectRef;
        this.f124624d = streakDataStore;
        this.f124625f = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        StreakDataStore$reconcileOpenSession$2 streakDataStore$reconcileOpenSession$2 = new StreakDataStore$reconcileOpenSession$2(this.f124623c, this.f124624d, this.f124625f, continuation);
        streakDataStore$reconcileOpenSession$2.f124622b = obj;
        return streakDataStore$reconcileOpenSession$2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(MutablePreferences mutablePreferences, Continuation continuation) {
        return ((StreakDataStore$reconcileOpenSession$2) create(mutablePreferences, continuation)).invokeSuspend(Unit.f139807a);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.Object r0 = r9.f124622b
            r2 = r0
            androidx.datastore.preferences.core.MutablePreferences r2 = (androidx.datastore.preferences.core.MutablePreferences) r2
            kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r0 = r9.f124621a
            if (r0 != 0) goto L67
            kotlin.ResultKt.b(r10)
            androidx.datastore.preferences.core.Preferences$Key r10 = cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt.h4()
            java.lang.Object r10 = r2.c(r10)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            r0 = 0
            if (r10 == 0) goto L21
            boolean r10 = r10.booleanValue()
            goto L22
        L21:
            r10 = r0
        L22:
            r1 = 1
            if (r10 != 0) goto L3c
            androidx.datastore.preferences.core.Preferences$Key r10 = cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt.e4()
            java.lang.Object r10 = r2.c(r10)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            if (r10 == 0) goto L36
            boolean r10 = r10.booleanValue()
            goto L37
        L36:
            r10 = r0
        L37:
            if (r10 == 0) goto L3a
            goto L3c
        L3a:
            r4 = r0
            goto L3d
        L3c:
            r4 = r1
        L3d:
            androidx.datastore.preferences.core.Preferences$Key r10 = cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt.Z3()
            java.lang.Object r10 = r2.c(r10)
            java.lang.Long r10 = (java.lang.Long) r10
            r5 = 0
            if (r10 == 0) goto L50
            long r7 = r10.longValue()
            goto L51
        L50:
            r7 = r5
        L51:
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 <= 0) goto L57
            r3 = r1
            goto L58
        L57:
            r3 = r0
        L58:
            kotlin.jvm.internal.Ref$ObjectRef r10 = r9.f124623c
            cz.mobilesoft.coreblock.storage.datastore.StreakDataStore r1 = r9.f124624d
            long r5 = r9.f124625f
            cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$ActivityTransition r0 = cz.mobilesoft.coreblock.storage.datastore.StreakDataStore.D(r1, r2, r3, r4, r5)
            r10.f140144a = r0
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        L67:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$reconcileOpenSession$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
