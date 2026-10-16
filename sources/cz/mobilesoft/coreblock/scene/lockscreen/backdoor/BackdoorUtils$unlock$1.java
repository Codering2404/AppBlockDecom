package cz.mobilesoft.coreblock.scene.lockscreen.backdoor;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorUtils$unlock$1", f = "BackdoorUtils.kt", l = {48, 49, 50, 55}, m = "invokeSuspend", v = 1)
final class BackdoorUtils$unlock$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f105651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f105652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f105653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f105654d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f105655f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ List f105656g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BackdoorUtils$unlock$1(List list, Continuation continuation) {
        super(1, continuation);
        this.f105656g = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new BackdoorUtils$unlock$1(this.f105656g, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0137, code lost:
    
        if (r8.H("", r11) == r0) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0117  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorUtils$unlock$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((BackdoorUtils$unlock$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
