package cz.mobilesoft.coreblock;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.MainActivity$handleDeeplink$1", f = "MainActivity.kt", l = {280, 280, 282}, m = "invokeSuspend", v = 1)
final class MainActivity$handleDeeplink$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f95376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f95377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f95378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f95379d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f95380f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f95381g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ MainActivity f95382h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$handleDeeplink$1(MainActivity mainActivity, Continuation continuation) {
        super(1, continuation);
        this.f95382h = mainActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new MainActivity$handleDeeplink$1(this.f95382h, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c4, code lost:
    
        if (r7.L5(r4, r10) != r0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00df, code lost:
    
        if (r11.l5(r8, r10) == r0) goto L35;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.MainActivity$handleDeeplink$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((MainActivity$handleDeeplink$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
