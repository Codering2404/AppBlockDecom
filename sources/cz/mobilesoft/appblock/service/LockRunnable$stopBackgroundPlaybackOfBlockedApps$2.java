package cz.mobilesoft.appblock.service;

import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

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
@DebugMetadata(c = "cz.mobilesoft.appblock.service.LockRunnable$stopBackgroundPlaybackOfBlockedApps$2", f = "LockRunnable.kt", l = {}, m = "invokeSuspend", v = 1)
final class LockRunnable$stopBackgroundPlaybackOfBlockedApps$2 extends SuspendLambda implements Function3<Set<? extends String>, Unit, Continuation<? super Set<? extends String>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f94512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f94513b;

    LockRunnable$stopBackgroundPlaybackOfBlockedApps$2(Continuation continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(Set set, Unit unit, Continuation continuation) {
        LockRunnable$stopBackgroundPlaybackOfBlockedApps$2 lockRunnable$stopBackgroundPlaybackOfBlockedApps$2 = new LockRunnable$stopBackgroundPlaybackOfBlockedApps$2(continuation);
        lockRunnable$stopBackgroundPlaybackOfBlockedApps$2.f94513b = set;
        return lockRunnable$stopBackgroundPlaybackOfBlockedApps$2.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Set set = (Set) this.f94513b;
        IntrinsicsKt.f();
        if (this.f94512a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        return set;
    }
}
