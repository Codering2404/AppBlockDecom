package cz.mobilesoft.coreblock.service.receiver;

import android.service.quicksettings.Tile;
import cz.mobilesoft.coreblock.repository.QuickBlockRepository;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.service.receiver.QuickBlockTileService$startBlocking$1", f = "QuickBlockTileService.kt", l = {193}, m = "invokeSuspend", v = 1)
final class QuickBlockTileService$startBlocking$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f123766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f123767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f123768c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ QuickBlockTileService f123769d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    QuickBlockTileService$startBlocking$1(QuickBlockTileService quickBlockTileService, Continuation continuation) {
        super(2, continuation);
        this.f123769d = quickBlockTileService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new QuickBlockTileService$startBlocking$1(this.f123769d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f123768c;
        if (i3 == 0) {
            ResultKt.b(obj);
            QuickBlockRepository.O(this.f123769d.s(), null, 1, null);
            AnswersHelper.f128199a.v4(true);
            Tile qsTile = this.f123769d.getQsTile();
            if (qsTile != null) {
                MainCoroutineDispatcher mainCoroutineDispatcherC = Dispatchers.c();
                QuickBlockTileService$startBlocking$1$1$1 quickBlockTileService$startBlocking$1$1$1 = new QuickBlockTileService$startBlocking$1$1$1(qsTile, null);
                this.f123766a = SpillingKt.a(qsTile);
                this.f123767b = 0;
                this.f123768c = 1;
                if (BuildersKt.g(mainCoroutineDispatcherC, quickBlockTileService$startBlocking$1$1$1, this) == objF) {
                    return objF;
                }
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
        return ((QuickBlockTileService$startBlocking$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
