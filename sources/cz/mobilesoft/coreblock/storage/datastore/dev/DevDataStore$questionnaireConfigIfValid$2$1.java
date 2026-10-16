package cz.mobilesoft.coreblock.storage.datastore.dev;

import cz.mobilesoft.coreblock.dto.QuestionnaireConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore$questionnaireConfigIfValid$2$1", f = "DevDataStore.kt", l = {}, m = "invokeSuspend", v = 1)
final class DevDataStore$questionnaireConfigIfValid$2$1 extends SuspendLambda implements Function3<QuestionnaireConfig, DevPrefState, Continuation<? super QuestionnaireConfig>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f124730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f124731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ Object f124732c;

    DevDataStore$questionnaireConfigIfValid$2$1(Continuation continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(QuestionnaireConfig questionnaireConfig, DevPrefState devPrefState, Continuation continuation) {
        DevDataStore$questionnaireConfigIfValid$2$1 devDataStore$questionnaireConfigIfValid$2$1 = new DevDataStore$questionnaireConfigIfValid$2$1(continuation);
        devDataStore$questionnaireConfigIfValid$2$1.f124731b = questionnaireConfig;
        devDataStore$questionnaireConfigIfValid$2$1.f124732c = devPrefState;
        return devDataStore$questionnaireConfigIfValid$2$1.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        QuestionnaireConfig questionnaireConfig = (QuestionnaireConfig) this.f124731b;
        DevPrefState devPrefState = (DevPrefState) this.f124732c;
        IntrinsicsKt.f();
        if (this.f124730a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (Intrinsics.areEqual(devPrefState.isActive(), Boxing.a(true))) {
            return questionnaireConfig;
        }
        return null;
    }
}
