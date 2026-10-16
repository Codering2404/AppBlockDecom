package cz.mobilesoft.coreblock.scene.statistics.adapter;

import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.statistics.adapter.AppsWebsAdapter$ItemViewHolder$bind$1$3$1$1$1", f = "AppsWebsAdapter.kt", l = {152}, m = "invokeSuspend", v = 1)
final class AppsWebsAdapter$ItemViewHolder$bind$1$3$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f119768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ AppsWebsAdapter f119769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f119770c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppsWebsAdapter$ItemViewHolder$bind$1$3$1$1$1(AppsWebsAdapter appsWebsAdapter, String str, Continuation continuation) {
        super(2, continuation);
        this.f119769b = appsWebsAdapter;
        this.f119770c = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AppsWebsAdapter$ItemViewHolder$bind$1$3$1$1$1(this.f119769b, this.f119770c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f119768a;
        if (i3 == 0) {
            ResultKt.b(obj);
            ApplicationDao applicationDaoM = this.f119769b.m();
            String str = this.f119770c;
            this.f119768a = 1;
            obj = applicationDaoM.P(str, this);
            if (obj == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Boxing.a(!((Boolean) obj).booleanValue());
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AppsWebsAdapter$ItemViewHolder$bind$1$3$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
