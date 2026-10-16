package cz.mobilesoft.coreblock.scene.streaks;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.streaks.StreakAvailability$isEnabled$1", f = "StreakAvailability.kt", l = {}, m = "invokeSuspend", v = 1)
final class StreakAvailability$isEnabled$1 extends SuspendLambda implements Function3<Boolean, Boolean, Continuation<? super Boolean>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f120227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ boolean f120228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ boolean f120229c;

    StreakAvailability$isEnabled$1(Continuation continuation) {
        super(3, continuation);
    }

    public final Object h(boolean z2, boolean z3, Continuation continuation) {
        StreakAvailability$isEnabled$1 streakAvailability$isEnabled$1 = new StreakAvailability$isEnabled$1(continuation);
        streakAvailability$isEnabled$1.f120228b = z2;
        streakAvailability$isEnabled$1.f120229c = z3;
        return streakAvailability$isEnabled$1.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return h(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Continuation) obj3);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        boolean z2 = this.f120228b;
        boolean z3 = this.f120229c;
        IntrinsicsKt.f();
        if (this.f120227a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        return Boxing.a(z2 && z3);
    }
}
