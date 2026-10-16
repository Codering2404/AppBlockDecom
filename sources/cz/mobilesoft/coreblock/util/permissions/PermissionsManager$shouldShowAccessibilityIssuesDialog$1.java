package cz.mobilesoft.coreblock.util.permissions;

import android.content.Context;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.permissions.PermissionsManager$shouldShowAccessibilityIssuesDialog$1", f = "PermissionsManager.kt", l = {641, 643}, m = "invokeSuspend", v = 1)
final class PermissionsManager$shouldShowAccessibilityIssuesDialog$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f129183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f129184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f129185c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function1 f129186d;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.permissions.PermissionsManager$shouldShowAccessibilityIssuesDialog$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.util.permissions.PermissionsManager$shouldShowAccessibilityIssuesDialog$1$1", f = "PermissionsManager.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f129187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1 f129188b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f129189c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Function1 function1, boolean z2, Continuation continuation) {
            super(2, continuation);
            this.f129188b = function1;
            this.f129189c = z2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f129188b, this.f129189c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f129187a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.f129188b.invoke(Boxing.a(this.f129189c));
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PermissionsManager$shouldShowAccessibilityIssuesDialog$1(Context context, Function1 function1, Continuation continuation) {
        super(1, continuation);
        this.f129185c = context;
        this.f129186d = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new PermissionsManager$shouldShowAccessibilityIssuesDialog$1(this.f129185c, this.f129186d, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003f, code lost:
    
        if (r7 == r0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0060, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g(r7, r1, r6) != r0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0062, code lost:
    
        return r0;
     */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f129184b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r7)
            goto L63
        L12:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1a:
            kotlin.ResultKt.b(r7)
            goto L42
        L1e:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager r7 = cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager.f126839a
            boolean r7 = r7.b1()
            if (r7 == 0) goto L4b
            android.content.Context r7 = r6.f129185c
            boolean r7 = cz.mobilesoft.coreblock.util.permissions.PermissionHelper.l(r7)
            if (r7 == 0) goto L4b
            cz.mobilesoft.coreblock.util.runnability.ServiceHelper r7 = cz.mobilesoft.coreblock.util.runnability.ServiceHelper.f129652a
            android.content.Context r1 = r6.f129185c
            kotlinx.coroutines.CoroutineScope r4 = cz.mobilesoft.coreblock.util.permissions.PermissionsManager.c()
            r6.f129184b = r3
            java.lang.Object r7 = r7.f(r1, r4, r6)
            if (r7 != r0) goto L42
            goto L62
        L42:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L4b
            goto L4c
        L4b:
            r3 = 0
        L4c:
            kotlinx.coroutines.MainCoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.c()
            cz.mobilesoft.coreblock.util.permissions.PermissionsManager$shouldShowAccessibilityIssuesDialog$1$1 r1 = new cz.mobilesoft.coreblock.util.permissions.PermissionsManager$shouldShowAccessibilityIssuesDialog$1$1
            kotlin.jvm.functions.Function1 r4 = r6.f129186d
            r5 = 0
            r1.<init>(r4, r3, r5)
            r6.f129183a = r3
            r6.f129184b = r2
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.g(r7, r1, r6)
            if (r7 != r0) goto L63
        L62:
            return r0
        L63:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.permissions.PermissionsManager$shouldShowAccessibilityIssuesDialog$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((PermissionsManager$shouldShowAccessibilityIssuesDialog$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
