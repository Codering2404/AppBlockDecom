package cz.mobilesoft.coreblock.scene.subscriptionob;

import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.subscriptionob.WelcomeScreenKt$ConfettiAnimation$1$1", f = "WelcomeScreen.kt", l = {}, m = "invokeSuspend", v = 1)
final class WelcomeScreenKt$ConfettiAnimation$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f122730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f122731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ SnapshotStateList f122732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ List f122733d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ List f122734f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ float f122735g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ float f122736h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ MutableLongState f122737i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WelcomeScreenKt$ConfettiAnimation$1$1(int i3, SnapshotStateList snapshotStateList, List list, List list2, float f3, float f4, MutableLongState mutableLongState, Continuation continuation) {
        super(2, continuation);
        this.f122731b = i3;
        this.f122732c = snapshotStateList;
        this.f122733d = list;
        this.f122734f = list2;
        this.f122735g = f3;
        this.f122736h = f4;
        this.f122737i = mutableLongState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new WelcomeScreenKt$ConfettiAnimation$1$1(this.f122731b, this.f122732c, this.f122733d, this.f122734f, this.f122735g, this.f122736h, this.f122737i, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f122730a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        int i3 = this.f122731b;
        SnapshotStateList snapshotStateList = this.f122732c;
        List list = this.f122733d;
        List list2 = this.f122734f;
        float f3 = this.f122735g;
        float f4 = this.f122736h;
        for (int i4 = 0; i4 < i3; i4++) {
            snapshotStateList.add(WelcomeScreenKt.z(list, list2, f3, f4));
        }
        WelcomeScreenKt.k(this.f122737i, System.nanoTime());
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((WelcomeScreenKt$ConfettiAnimation$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
