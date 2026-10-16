package cz.mobilesoft.appblock.view;

import android.view.View;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;
import cz.mobilesoft.appblock.databinding.FragmentLockBinding;
import cz.mobilesoft.appblock.view.LockScreenProvider$initViews$8;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
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
@DebugMetadata(c = "cz.mobilesoft.appblock.view.LockScreenProvider$initViews$8", f = "LockScreenProvider.kt", l = {680, 683}, m = "invokeSuspend", v = 1)
final class LockScreenProvider$initViews$8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f95271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f95272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f95273c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ LockScreenProvider f95274d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ FragmentLockBinding f95275f;

    /* JADX INFO: renamed from: cz.mobilesoft.appblock.view.LockScreenProvider$initViews$8$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.appblock.view.LockScreenProvider$initViews$8$1", f = "LockScreenProvider.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f95276a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ FragmentLockBinding f95277b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f95278c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Integer f95279d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ LockScreenProvider f95280f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(FragmentLockBinding fragmentLockBinding, boolean z2, Integer num, LockScreenProvider lockScreenProvider, Continuation continuation) {
            super(2, continuation);
            this.f95277b = fragmentLockBinding;
            this.f95278c = z2;
            this.f95279d = num;
            this.f95280f = lockScreenProvider;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void q(LockScreenProvider lockScreenProvider, View view) {
            lockScreenProvider.P();
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f95277b, this.f95278c, this.f95279d, this.f95280f, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f95276a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            MaterialCardView inAppUpdateCardView = this.f95277b.f94011p;
            Intrinsics.checkNotNullExpressionValue(inAppUpdateCardView, "inAppUpdateCardView");
            inAppUpdateCardView.setVisibility(this.f95278c ? 0 : 8);
            if (this.f95278c) {
                Integer num = this.f95279d;
                if (num != null) {
                    AnswersHelper.f128199a.Y1(num.intValue());
                }
                MaterialTextView materialTextView = this.f95277b.f94012q;
                final LockScreenProvider lockScreenProvider = this.f95280f;
                materialTextView.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.appblock.view.x
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        LockScreenProvider$initViews$8.AnonymousClass1.q(lockScreenProvider, view);
                    }
                });
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockScreenProvider$initViews$8(LockScreenProvider lockScreenProvider, FragmentLockBinding fragmentLockBinding, Continuation continuation) {
        super(2, continuation);
        this.f95274d = lockScreenProvider;
        this.f95275f = fragmentLockBinding;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LockScreenProvider$initViews$8(this.f95274d, this.f95275f, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x005d, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g(r11, r4, r10) == r0) goto L21;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r10.f95273c
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            java.lang.Object r0 = r10.f95271a
            java.lang.Integer r0 = (java.lang.Integer) r0
            kotlin.ResultKt.b(r11)
            goto L60
        L16:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L1e:
            kotlin.ResultKt.b(r11)
            goto L30
        L22:
            kotlin.ResultKt.b(r11)
            cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository r11 = cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository.f129855a
            r10.f95273c = r3
            java.lang.Object r11 = r11.w(r10)
            if (r11 != r0) goto L30
            goto L5f
        L30:
            r7 = r11
            java.lang.Integer r7 = (java.lang.Integer) r7
            if (r7 == 0) goto L43
            cz.mobilesoft.appblock.view.LockScreenProvider r11 = r10.f95274d
            long r4 = cz.mobilesoft.appblock.view.LockScreenProvider.x(r11)
            r8 = -1
            int r11 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r11 != 0) goto L43
        L41:
            r6 = r3
            goto L45
        L43:
            r3 = 0
            goto L41
        L45:
            kotlinx.coroutines.MainCoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.c()
            cz.mobilesoft.appblock.view.LockScreenProvider$initViews$8$1 r4 = new cz.mobilesoft.appblock.view.LockScreenProvider$initViews$8$1
            cz.mobilesoft.appblock.databinding.FragmentLockBinding r5 = r10.f95275f
            cz.mobilesoft.appblock.view.LockScreenProvider r8 = r10.f95274d
            r9 = 0
            r4.<init>(r5, r6, r7, r8, r9)
            r10.f95271a = r7
            r10.f95272b = r6
            r10.f95273c = r2
            java.lang.Object r11 = kotlinx.coroutines.BuildersKt.g(r11, r4, r10)
            if (r11 != r0) goto L60
        L5f:
            return r0
        L60:
            kotlin.Unit r11 = kotlin.Unit.f139807a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.view.LockScreenProvider$initViews$8.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LockScreenProvider$initViews$8) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
