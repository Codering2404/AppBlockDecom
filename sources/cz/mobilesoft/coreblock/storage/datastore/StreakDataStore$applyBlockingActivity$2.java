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
@DebugMetadata(c = "cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$applyBlockingActivity$2", f = "StreakDataStore.kt", l = {}, m = "invokeSuspend", v = 1)
final class StreakDataStore$applyBlockingActivity$2 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f124599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f124600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Boolean f124601c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Boolean f124602d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Ref.ObjectRef f124603f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ StreakDataStore f124604g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ long f124605h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreakDataStore$applyBlockingActivity$2(Boolean bool, Boolean bool2, Ref.ObjectRef objectRef, StreakDataStore streakDataStore, long j3, Continuation continuation) {
        super(2, continuation);
        this.f124601c = bool;
        this.f124602d = bool2;
        this.f124603f = objectRef;
        this.f124604g = streakDataStore;
        this.f124605h = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        StreakDataStore$applyBlockingActivity$2 streakDataStore$applyBlockingActivity$2 = new StreakDataStore$applyBlockingActivity$2(this.f124601c, this.f124602d, this.f124603f, this.f124604g, this.f124605h, continuation);
        streakDataStore$applyBlockingActivity$2.f124600b = obj;
        return streakDataStore$applyBlockingActivity$2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(MutablePreferences mutablePreferences, Continuation continuation) {
        return ((StreakDataStore$applyBlockingActivity$2) create(mutablePreferences, continuation)).invokeSuspend(Unit.f139807a);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008e  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = r7.f124600b
            r2 = r0
            androidx.datastore.preferences.core.MutablePreferences r2 = (androidx.datastore.preferences.core.MutablePreferences) r2
            kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r0 = r7.f124599a
            if (r0 != 0) goto L9e
            kotlin.ResultKt.b(r8)
            androidx.datastore.preferences.core.Preferences$Key r8 = cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt.h4()
            java.lang.Object r8 = r2.c(r8)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            r0 = 0
            if (r8 == 0) goto L21
            boolean r8 = r8.booleanValue()
            goto L22
        L21:
            r8 = r0
        L22:
            r1 = 1
            if (r8 != 0) goto L3c
            androidx.datastore.preferences.core.Preferences$Key r8 = cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt.e4()
            java.lang.Object r8 = r2.c(r8)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            if (r8 == 0) goto L36
            boolean r8 = r8.booleanValue()
            goto L37
        L36:
            r8 = r0
        L37:
            if (r8 == 0) goto L3a
            goto L3c
        L3a:
            r3 = r0
            goto L3d
        L3c:
            r3 = r1
        L3d:
            java.lang.Boolean r8 = r7.f124601c
            if (r8 == 0) goto L50
            boolean r8 = r8.booleanValue()
            androidx.datastore.preferences.core.Preferences$Key r4 = cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt.h4()
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.a(r8)
            r2.k(r4, r8)
        L50:
            java.lang.Boolean r8 = r7.f124602d
            if (r8 == 0) goto L63
            boolean r8 = r8.booleanValue()
            androidx.datastore.preferences.core.Preferences$Key r4 = cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt.e4()
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.a(r8)
            r2.k(r4, r8)
        L63:
            androidx.datastore.preferences.core.Preferences$Key r8 = cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt.h4()
            java.lang.Object r8 = r2.c(r8)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            if (r8 == 0) goto L74
            boolean r8 = r8.booleanValue()
            goto L75
        L74:
            r8 = r0
        L75:
            if (r8 != 0) goto L8e
            androidx.datastore.preferences.core.Preferences$Key r8 = cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt.e4()
            java.lang.Object r8 = r2.c(r8)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            if (r8 == 0) goto L88
            boolean r8 = r8.booleanValue()
            goto L89
        L88:
            r8 = r0
        L89:
            if (r8 == 0) goto L8c
            goto L8e
        L8c:
            r4 = r0
            goto L8f
        L8e:
            r4 = r1
        L8f:
            kotlin.jvm.internal.Ref$ObjectRef r8 = r7.f124603f
            cz.mobilesoft.coreblock.storage.datastore.StreakDataStore r1 = r7.f124604g
            long r5 = r7.f124605h
            cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$ActivityTransition r0 = cz.mobilesoft.coreblock.storage.datastore.StreakDataStore.D(r1, r2, r3, r4, r5)
            r8.f140144a = r0
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        L9e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$applyBlockingActivity$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
