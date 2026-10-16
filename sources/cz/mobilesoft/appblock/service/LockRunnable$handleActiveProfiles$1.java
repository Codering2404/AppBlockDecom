package cz.mobilesoft.appblock.service;

import android.util.Log;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.appblock.service.LockRunnable$handleActiveProfiles$1", f = "LockRunnable.kt", l = {655}, m = "invokeSuspend", v = 1)
final class LockRunnable$handleActiveProfiles$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f94462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ List f94463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ LockRunnable f94464c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockRunnable$handleActiveProfiles$1(List list, LockRunnable lockRunnable, Continuation continuation) {
        super(2, continuation);
        this.f94463b = list;
        this.f94464c = lockRunnable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LockRunnable$handleActiveProfiles$1(this.f94463b, this.f94464c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f94462a;
        if (i3 == 0) {
            ResultKt.b(obj);
            List list = this.f94463b;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Boxing.e(((ProfileWithConfiguration) it.next()).p().r()));
            }
            Log.d("SendContactSupportDetailedRequestUseCase", "sending profiles: " + CollectionsKt.joinToString$default(arrayList, null, null, null, 0, null, null, 63, null));
            EventDataStore eventDataStoreO = this.f94464c.O();
            long jF = TimeHelperExt.f128663a.f();
            List list2 = this.f94463b;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Boxing.e(((ProfileWithConfiguration) it2.next()).p().r()));
            }
            this.f94462a = 1;
            if (eventDataStoreO.N1(jF, arrayList2, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LockRunnable$handleActiveProfiles$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
