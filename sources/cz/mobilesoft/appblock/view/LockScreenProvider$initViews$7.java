package cz.mobilesoft.appblock.view;

import com.google.android.material.button.MaterialButton;
import cz.mobilesoft.appblock.R;
import cz.mobilesoft.appblock.databinding.FragmentLockBinding;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.appblock.view.LockScreenProvider$initViews$7", f = "LockScreenProvider.kt", l = {665, 666}, m = "invokeSuspend", v = 1)
final class LockScreenProvider$initViews$7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f95264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f95265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ LockScreenProvider f95266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ FragmentLockBinding f95267d;

    /* JADX INFO: renamed from: cz.mobilesoft.appblock.view.LockScreenProvider$initViews$7$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.appblock.view.LockScreenProvider$initViews$7$1", f = "LockScreenProvider.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f95268a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ LockScreenProvider f95269b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ FragmentLockBinding f95270c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LockScreenProvider lockScreenProvider, FragmentLockBinding fragmentLockBinding, Continuation continuation) {
            super(2, continuation);
            this.f95269b = lockScreenProvider;
            this.f95270c = fragmentLockBinding;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f95269b, this.f95270c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f95268a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            if (this.f95269b.f95166x) {
                this.f95270c.f94005j.setVisibility(4);
                this.f95270c.f93999d.setText(this.f95269b.f95160r.getString(R.string.back_to_title, this.f95269b.f95160r.getString(R.string.app_name)));
            } else {
                MaterialButton closeButton = this.f95270c.f94005j;
                Intrinsics.checkNotNullExpressionValue(closeButton, "closeButton");
                closeButton.setVisibility(0);
            }
            MaterialButton backToAppButton = this.f95270c.f93999d;
            Intrinsics.checkNotNullExpressionValue(backToAppButton, "backToAppButton");
            backToAppButton.setVisibility(this.f95269b.f95166x ? 0 : 8);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockScreenProvider$initViews$7(LockScreenProvider lockScreenProvider, FragmentLockBinding fragmentLockBinding, Continuation continuation) {
        super(2, continuation);
        this.f95266c = lockScreenProvider;
        this.f95267d = fragmentLockBinding;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LockScreenProvider$initViews$7(this.f95266c, this.f95267d, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g(r9, r1, r8) == r0) goto L19;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r8.f95265b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r9)
            goto L64
        L12:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1a:
            java.lang.Object r1 = r8.f95264a
            cz.mobilesoft.appblock.view.LockScreenProvider r1 = (cz.mobilesoft.appblock.view.LockScreenProvider) r1
            kotlin.ResultKt.b(r9)
            goto L3a
        L22:
            kotlin.ResultKt.b(r9)
            cz.mobilesoft.appblock.view.LockScreenProvider r1 = r8.f95266c
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r9 = cz.mobilesoft.appblock.view.LockScreenProvider.A(r1)
            kotlinx.coroutines.flow.Flow r9 = r9.k2()
            r8.f95264a = r1
            r8.f95265b = r3
            java.lang.Object r9 = kotlinx.coroutines.flow.FlowKt.D(r9, r8)
            if (r9 != r0) goto L3a
            goto L63
        L3a:
            java.lang.Number r9 = (java.lang.Number) r9
            long r4 = r9.longValue()
            r6 = 0
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 <= 0) goto L47
            goto L48
        L47:
            r3 = 0
        L48:
            cz.mobilesoft.appblock.view.LockScreenProvider.L(r1, r3)
            kotlinx.coroutines.MainCoroutineDispatcher r9 = kotlinx.coroutines.Dispatchers.c()
            cz.mobilesoft.appblock.view.LockScreenProvider$initViews$7$1 r1 = new cz.mobilesoft.appblock.view.LockScreenProvider$initViews$7$1
            cz.mobilesoft.appblock.view.LockScreenProvider r3 = r8.f95266c
            cz.mobilesoft.appblock.databinding.FragmentLockBinding r4 = r8.f95267d
            r5 = 0
            r1.<init>(r3, r4, r5)
            r8.f95264a = r5
            r8.f95265b = r2
            java.lang.Object r9 = kotlinx.coroutines.BuildersKt.g(r9, r1, r8)
            if (r9 != r0) goto L64
        L63:
            return r0
        L64:
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.view.LockScreenProvider$initViews$7.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LockScreenProvider$initViews$7) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
