package cz.mobilesoft.coreblock.util;

import android.content.Context;
import cz.mobilesoft.coreblock.util.runnability.InitHelper;
import cz.mobilesoft.nativecore.NativeLib;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.scope.Scope;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.DeepLinksUtils$preloadSingularKeys$2", f = "DeepLinksUtils.kt", l = {}, m = "invokeSuspend", v = 1)
final class DeepLinksUtils$preloadSingularKeys$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f127825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f127826b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DeepLinksUtils$preloadSingularKeys$2(Context context, Continuation continuation) {
        super(2, continuation);
        this.f127826b = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DeepLinksUtils$preloadSingularKeys$2(this.f127826b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Scope scopeD;
        Class<NativeLib> cls;
        IntrinsicsKt.f();
        if (this.f127825a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (DeepLinksUtils.f127819b != null && DeepLinksUtils.f127820c != null) {
            return Unit.f139807a;
        }
        Object obj2 = DeepLinksUtils.f127821d;
        Context context = this.f127826b;
        synchronized (obj2) {
            if (DeepLinksUtils.f127819b == null || DeepLinksUtils.f127820c == null) {
                try {
                    String[] strArrK = InitHelper.f129486a.k(context);
                    KoinComponent koinComponent = DeepLinksUtils.f127818a;
                    if (koinComponent instanceof KoinScopeComponent) {
                        scopeD = ((KoinScopeComponent) koinComponent).getScope();
                        cls = NativeLib.class;
                    } else {
                        scopeD = koinComponent.r0().j().d();
                        cls = NativeLib.class;
                    }
                    NativeLib nativeLib = (NativeLib) scopeD.e(Reflection.b(cls), null, null);
                    DeepLinksUtils.f127819b = strArrK != null ? nativeLib.getSingularAPIKey(strArrK) : null;
                    DeepLinksUtils.f127820c = strArrK != null ? nativeLib.getSingularSecret(strArrK) : null;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    CrashHelper.j(e3);
                }
            }
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DeepLinksUtils$preloadSingularKeys$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
