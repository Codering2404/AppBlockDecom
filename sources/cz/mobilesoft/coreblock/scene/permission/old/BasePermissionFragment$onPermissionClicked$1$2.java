package cz.mobilesoft.coreblock.scene.permission.old;

import androidx.fragment.app.FragmentActivity;
import cz.mobilesoft.coreblock.util.permissions.PermissionHelper;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.permission.old.BasePermissionFragment$onPermissionClicked$1$2", f = "BasePermissionFragment.kt", l = {142, 144, 148}, m = "invokeSuspend", v = 1)
final class BasePermissionFragment$onPermissionClicked$1$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f111967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f111968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f111969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ BasePermissionFragment f111970d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ FragmentActivity f111971f;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.permission.old.BasePermissionFragment$onPermissionClicked$1$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.permission.old.BasePermissionFragment$onPermissionClicked$1$2$1", f = "BasePermissionFragment.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f111972a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BasePermissionFragment f111973b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f111974c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f111975d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ FragmentActivity f111976f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BasePermissionFragment basePermissionFragment, boolean z2, boolean z3, FragmentActivity fragmentActivity, Continuation continuation) {
            super(2, continuation);
            this.f111973b = basePermissionFragment;
            this.f111974c = z2;
            this.f111975d = z3;
            this.f111976f = fragmentActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f111973b, this.f111974c, this.f111975d, this.f111976f, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f111972a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            FragmentActivity activity = this.f111973b.getActivity();
            if (activity != null) {
                boolean z2 = this.f111974c;
                boolean z3 = this.f111975d;
                BasePermissionFragment basePermissionFragment = this.f111973b;
                FragmentActivity fragmentActivity = this.f111976f;
                if (!z2 || z3) {
                    basePermissionFragment.f111966g.b("android.permission.POST_NOTIFICATIONS");
                } else {
                    Boxing.a(PermissionHelper.q(activity, fragmentActivity.getComponentName()));
                }
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BasePermissionFragment$onPermissionClicked$1$2(BasePermissionFragment basePermissionFragment, FragmentActivity fragmentActivity, Continuation continuation) {
        super(1, continuation);
        this.f111970d = basePermissionFragment;
        this.f111971f = fragmentActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new BasePermissionFragment$onPermissionClicked$1$2(this.f111970d, this.f111971f, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0075, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g(r10, r3, r9) != r0) goto L22;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r9.f111969c
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L28
            if (r1 == r4) goto L24
            if (r1 == r3) goto L1d
            if (r1 != r2) goto L15
            kotlin.ResultKt.b(r10)
            goto L78
        L15:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L1d:
            boolean r1 = r9.f111967a
            kotlin.ResultKt.b(r10)
        L22:
            r5 = r1
            goto L55
        L24:
            kotlin.ResultKt.b(r10)
            goto L3e
        L28:
            kotlin.ResultKt.b(r10)
            cz.mobilesoft.coreblock.scene.permission.old.BasePermissionFragment r10 = r9.f111970d
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r10 = r10.G()
            kotlinx.coroutines.flow.Flow r10 = r10.D3()
            r9.f111969c = r4
            java.lang.Object r10 = kotlinx.coroutines.flow.FlowKt.D(r10, r9)
            if (r10 != r0) goto L3e
            goto L77
        L3e:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r1 = r10.booleanValue()
            cz.mobilesoft.coreblock.scene.permission.old.BasePermissionFragment r10 = r9.f111970d
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r10 = r10.G()
            r9.f111967a = r1
            r9.f111969c = r3
            java.lang.Object r10 = r10.n5(r4, r9)
            if (r10 != r0) goto L22
            goto L77
        L55:
            androidx.fragment.app.FragmentActivity r10 = r9.f111971f
            java.lang.String r1 = "android.permission.POST_NOTIFICATIONS"
            boolean r6 = r10.shouldShowRequestPermissionRationale(r1)
            kotlinx.coroutines.MainCoroutineDispatcher r10 = kotlinx.coroutines.Dispatchers.c()
            cz.mobilesoft.coreblock.scene.permission.old.BasePermissionFragment$onPermissionClicked$1$2$1 r3 = new cz.mobilesoft.coreblock.scene.permission.old.BasePermissionFragment$onPermissionClicked$1$2$1
            cz.mobilesoft.coreblock.scene.permission.old.BasePermissionFragment r4 = r9.f111970d
            androidx.fragment.app.FragmentActivity r7 = r9.f111971f
            r8 = 0
            r3.<init>(r4, r5, r6, r7, r8)
            r9.f111967a = r5
            r9.f111968b = r6
            r9.f111969c = r2
            java.lang.Object r10 = kotlinx.coroutines.BuildersKt.g(r10, r3, r9)
            if (r10 != r0) goto L78
        L77:
            return r0
        L78:
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.permission.old.BasePermissionFragment$onPermissionClicked$1$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((BasePermissionFragment$onPermissionClicked$1$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
