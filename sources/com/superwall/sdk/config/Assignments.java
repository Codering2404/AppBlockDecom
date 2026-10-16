package com.superwall.sdk.config;

import com.superwall.sdk.Superwall;
import com.superwall.sdk.config.Assignments;
import com.superwall.sdk.config.ConfigLogic;
import com.superwall.sdk.misc.Either;
import com.superwall.sdk.models.assignment.Assignment;
import com.superwall.sdk.models.assignment.AssignmentPostback;
import com.superwall.sdk.models.assignment.ConfirmableAssignment;
import com.superwall.sdk.models.triggers.Experiment;
import com.superwall.sdk.models.triggers.Trigger;
import com.superwall.sdk.network.SuperwallAPI;
import com.superwall.sdk.storage.LocalStorage;
import com.superwall.sdk.utilities.ErrorTrackingKt;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
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
public final class Assignments {
    private Map<String, Experiment.Variant> _unconfirmedAssignments;
    private final CoroutineScope ioScope;
    private final SuperwallAPI network;
    private final LocalStorage storage;

    /* JADX INFO: renamed from: com.superwall.sdk.config.Assignments$getAssignments$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.config.Assignments", f = "Assignments.kt", l = {40, 41}, m = "getAssignments")
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Assignments.this.getAssignments(null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.config.Assignments$getAssignments$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.config.Assignments$getAssignments$2", f = "Assignments.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<List<? extends Assignment>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Set<Trigger> $triggers;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Set<Trigger> set, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$triggers = set;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ConfigLogic.AssignmentOutcome invokeSuspend$lambda$0(List list, Set set, Assignments assignments, Map map) {
            return ConfigLogic.INSTANCE.transferAssignmentsFromServerToDisk(list, set, map, assignments.getUnconfirmedAssignments());
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = Assignments.this.new AnonymousClass2(this.$triggers, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            final List list = (List) this.L$0;
            final Assignments assignments = Assignments.this;
            final Set<Trigger> set = this.$triggers;
            assignments.updateAssignments(new Function1() { // from class: com.superwall.sdk.config.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return Assignments.AnonymousClass2.invokeSuspend$lambda$0(list, set, assignments, (Map) obj2);
                }
            });
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(List<Assignment> list, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(list, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    public Assignments(LocalStorage storage, SuperwallAPI network, CoroutineScope ioScope, Map<String, Experiment.Variant> unconfirmedAssignments) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(network, "network");
        Intrinsics.checkNotNullParameter(ioScope, "ioScope");
        Intrinsics.checkNotNullParameter(unconfirmedAssignments, "unconfirmedAssignments");
        this.storage = storage;
        this.network = network;
        this.ioScope = ioScope;
        this._unconfirmedAssignments = MapsKt.toMutableMap(unconfirmedAssignments);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConfigLogic.AssignmentOutcome choosePaywallVariants$lambda$0(Set set, Map confirmedAssignments) {
        Intrinsics.checkNotNullParameter(confirmedAssignments, "confirmedAssignments");
        return ConfigLogic.INSTANCE.chooseAssignments(set, confirmedAssignments);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConfigLogic.AssignmentOutcome confirmAssignment$lambda$2$lambda$1(ConfirmableAssignment confirmableAssignment, Assignments assignments, Map confirmedAssignments) {
        Intrinsics.checkNotNullParameter(confirmedAssignments, "confirmedAssignments");
        return ConfigLogic.INSTANCE.move(confirmableAssignment, assignments.getUnconfirmedAssignments(), confirmedAssignments);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateAssignments(Function1<? super Map<String, Experiment.Variant>, ConfigLogic.AssignmentOutcome> function1) {
        try {
            ConfigLogic.AssignmentOutcome assignmentOutcome = (ConfigLogic.AssignmentOutcome) function1.invoke(this.storage.getConfirmedAssignments());
            this._unconfirmedAssignments = MapsKt.toMutableMap(assignmentOutcome.getUnconfirmed());
            this.storage.saveConfirmedAssignments(MapsKt.toMutableMap(assignmentOutcome.getConfirmed()));
            new Either.Success(Unit.f139807a);
        } catch (Throwable th) {
            if (ErrorTrackingKt.shouldLog(th)) {
                Superwall.Companion companion = Superwall.Companion;
                if (companion.getInitialized()) {
                    ErrorTrackingKt.trackError(companion.getInstance(), th);
                }
            }
            new Either.Failure(th);
        }
    }

    public final void choosePaywallVariants(final Set<Trigger> triggers) {
        Intrinsics.checkNotNullParameter(triggers, "triggers");
        updateAssignments(new Function1() { // from class: com.superwall.sdk.config.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Assignments.choosePaywallVariants$lambda$0(triggers, (Map) obj);
            }
        });
    }

    public final void confirmAssignment(final ConfirmableAssignment assignment) {
        Intrinsics.checkNotNullParameter(assignment, "assignment");
        try {
            BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new Assignments$confirmAssignment$1$1(this, AssignmentPostback.Companion.create(assignment), null), 3, null);
            updateAssignments(new Function1() { // from class: com.superwall.sdk.config.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Assignments.confirmAssignment$lambda$2$lambda$1(assignment, this, (Map) obj);
                }
            });
            new Either.Success(Unit.f139807a);
        } catch (Throwable th) {
            if (ErrorTrackingKt.shouldLog(th)) {
                Superwall.Companion companion = Superwall.Companion;
                if (companion.getInitialized()) {
                    ErrorTrackingKt.trackError(companion.getInstance(), th);
                }
            }
            new Either.Failure(th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getAssignments(java.util.Set<com.superwall.sdk.models.triggers.Trigger> r7, kotlin.coroutines.Continuation<? super com.superwall.sdk.misc.Either<? extends java.util.List<com.superwall.sdk.models.assignment.Assignment>, com.superwall.sdk.network.NetworkError>> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.superwall.sdk.config.Assignments.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            com.superwall.sdk.config.Assignments$getAssignments$1 r0 = (com.superwall.sdk.config.Assignments.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.config.Assignments$getAssignments$1 r0 = new com.superwall.sdk.config.Assignments$getAssignments$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r8)
            return r8
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            java.lang.Object r7 = r0.L$1
            java.util.Set r7 = (java.util.Set) r7
            java.lang.Object r2 = r0.L$0
            com.superwall.sdk.config.Assignments r2 = (com.superwall.sdk.config.Assignments) r2
            kotlin.ResultKt.b(r8)
            goto L53
        L40:
            kotlin.ResultKt.b(r8)
            com.superwall.sdk.network.SuperwallAPI r8 = r6.network
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r8 = r8.getAssignments(r0)
            if (r8 != r1) goto L52
            goto L67
        L52:
            r2 = r6
        L53:
            com.superwall.sdk.misc.Either r8 = (com.superwall.sdk.misc.Either) r8
            com.superwall.sdk.config.Assignments$getAssignments$2 r4 = new com.superwall.sdk.config.Assignments$getAssignments$2
            r5 = 0
            r4.<init>(r7, r5)
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r7 = com.superwall.sdk.misc.EitherKt.then(r8, r4, r0)
            if (r7 != r1) goto L68
        L67:
            return r1
        L68:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.config.Assignments.getAssignments(java.util.Set, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Map<String, Experiment.Variant> getUnconfirmedAssignments() {
        return this._unconfirmedAssignments;
    }

    public final void reset() {
        this._unconfirmedAssignments.clear();
    }

    public /* synthetic */ Assignments(LocalStorage localStorage, SuperwallAPI superwallAPI, CoroutineScope coroutineScope, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(localStorage, superwallAPI, coroutineScope, (i3 & 8) != 0 ? MapsKt.emptyMap() : map);
    }
}
